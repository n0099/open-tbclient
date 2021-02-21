package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.ImageModel;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.y;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a extends com.baidu.tbadk.editortools.e {
    private TbPageContext<?> eUY;
    private String fDF;
    private NewWriteModel fDH;
    private ImageModel fDI;
    private String fDL;
    private com.baidu.tbadk.editortools.pb.c fDO;
    private com.baidu.tbadk.editortools.pb.b fDP;
    private NewWriteModel.d fDW;
    private final com.baidu.adp.base.e fDX;
    private boolean fEt;
    private NewWriteModel.d fEu;
    private View.OnClickListener fEx;
    private String kpg;
    private c kph;
    private AntiHelper.a mInjectListener;
    private String mPostContent;
    private long mTopicId;
    private WriteImagesInfo writeImagesInfo;

    /* JADX INFO: Access modifiers changed from: private */
    public void kZ(boolean z) {
        if (bBh() != null) {
            bBh().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void Da(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(bwm().getPageActivity());
        aVar.Au(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(bwm()).bqx();
    }

    public void aN(int i, String str) {
        if (AntiHelper.bX(i, str)) {
            if (AntiHelper.a(this.eUY.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ap("obj_locate", ay.a.LOCATE_REPLY_SUB_PB));
            }
        } else if (i == 230277 || i == 230278) {
            Da(str);
        } else {
            bwm().showToast(str);
        }
    }

    public TbPageContext<?> bwm() {
        return this.eUY;
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.mPostContent = "";
        this.kpg = null;
        this.fEt = false;
        this.fDL = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.fDI = null;
        this.fDW = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                if (a.this.fEu != null) {
                    a.this.fEu.callback(z, postWriteCallBackData, ahVar, writeData, antiData);
                }
                if (z) {
                    a.this.mPostContent = null;
                    a.this.kZ(true);
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    a.this.fDH.f((WriteData) null);
                    a.this.fDH.yE(false);
                    a.this.writeImagesInfo.clear();
                    a.this.bCo();
                    a.this.bBh().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.bX(i, str)) {
                    a.this.aN(i, str);
                } else if (ahVar != null && writeData != null && !StringUtils.isNull(ahVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(ahVar.getVcode_md5());
                    writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                    writeData.setVcodeExtra(ahVar.bwF());
                    if (com.baidu.tbadk.t.a.DY(ahVar.bwE())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.bwm().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bwE())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.bwm().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.eUY.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    a.this.bwm().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ap("obj_locate", ay.a.LOCATE_REPLY_SUB_PB));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ap("obj_locate", ay.a.LOCATE_REPLY_SUB_PB));
            }
        };
        this.fDX = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.4
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                if (obj instanceof Bitmap) {
                    a.this.fDH.yE(true);
                }
            }
        };
        this.fEx = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(a.this.fDL)) {
                    l.showToast(a.this.bwm().getPageActivity(), a.this.fDL);
                }
            }
        };
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.eUY = tbPageContext;
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        if (baseActivity != null) {
            this.fDH = new NewWriteModel(baseActivity);
            this.fDH.b(this.fDW);
            this.fDI = new ImageModel(baseActivity.getPageContext());
            this.fDI.setLoadDataCallBack(this.fDX);
            if (bundle != null) {
                this.writeImagesInfo.parseJson(bundle.getString("write_images"));
                this.fDF = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            }
            if (this.writeImagesInfo != null) {
                this.writeImagesInfo.setMaxImagesAllowed(9);
            }
            if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                bBh().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        ArrayList<String> stringArrayListExtra;
        if (i2 == -1) {
            switch (i) {
                case 12002:
                    if (intent != null) {
                        if (intent.getBooleanExtra("camera_result", false)) {
                            F(intent);
                        } else {
                            H(intent);
                        }
                        bBh().invalidate();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_IMAGE_VIEW /* 12003 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("delete", false)) {
                            bBZ();
                            this.fDH.yE(false);
                            return;
                        }
                        this.fDI.CS(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        I(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    PostWriteCallBackData postWriteCallBackData2 = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (this.fEu != null) {
                        this.mPostContent = null;
                        kZ(true);
                        this.fDH.f((WriteData) null);
                        this.fDH.yE(false);
                        this.writeImagesInfo.clear();
                        bCo();
                        bBh().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                        this.fEu.callback(true, postWriteCallBackData2, null, this.fDH.daC(), null);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    if (i == 12010) {
                        F(intent);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    G(intent);
                    return;
                case RequestResponseCode.REQUEST_WRITE_NEW /* 13003 */:
                    if (intent != null) {
                        try {
                            postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                        } catch (Exception e) {
                            BdLog.e(e);
                            postWriteCallBackData = null;
                        }
                        this.fDW.callback(true, postWriteCallBackData, null, null, null);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        ar arVar = new ar(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
                        arVar.ap("obj_locate", 6);
                        if (shareItem != null) {
                            arVar.dR("tid", shareItem.tid);
                        }
                        arVar.dR("pid", intent.getStringExtra("pid"));
                        TiebaStatic.log(arVar);
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    PostWriteCallBackData postWriteCallBackData3 = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (this.fEu != null) {
                        this.fEu.callback(false, postWriteCallBackData3, null, this.fDH.daC(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void F(Intent intent) {
        this.fDF = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.fDF;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.eUY.getPageActivity(), l.getEquipmentWidth(this.eUY.getPageActivity())), l.dip2px(this.eUY.getPageActivity(), l.getEquipmentHeight(this.eUY.getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    o.a("cameras", this.fDF, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                cSq();
            }
        }
    }

    private void G(Intent intent) {
        b(intent, false);
    }

    private void b(Intent intent, boolean z) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                cSq();
            }
        }
    }

    private void cSq() {
        if (!WriteActivityConfig.isAsyncWriting() || this.mTopicId <= 0) {
            WriteActivityConfig.newInstance(this.eUY.getPageActivity()).setType(9).setForumId("0").setTopicId(String.valueOf(this.mTopicId)).setFrom("topic_detail").setCallFrom("1").setContent(this.mPostContent).setWriteImagesInfo(this.writeImagesInfo).send();
        }
    }

    public void bCm() {
        if (this.fDH.daC() == null) {
            this.fDH.f(new WriteData());
        }
        if (this.fDH.daC() != null) {
            this.fDH.daC().setForumId("0");
            this.fDH.daC().setType(9);
            this.fDH.daC().setEntranceType(1);
            this.fDH.daC().setCanNoForum(true);
            this.fDH.daC().setTransmitForumData("[]");
            this.fDH.daC().setCallFrom("1");
            this.fDH.daC().setTopicId(String.valueOf(this.mTopicId));
            this.fDH.daC().setContent(this.mPostContent);
            this.fDH.daC().setIsNoTitle(true);
            this.fDH.daC().setTitle("");
            this.fDH.daC().setVoice(null);
            this.fDH.daC().setVoiceDuringTime(-1);
            if (!this.fDH.dPf()) {
                bwm().showToast(R.string.write_img_limit);
            } else if (this.fDP == null || !this.fDP.bBL()) {
                if (this.fDO != null) {
                    this.fDO.bBM();
                }
                if (!this.fDH.dPd()) {
                }
            }
        }
    }

    private void H(Intent intent) {
        b(intent, true);
    }

    public long cSr() {
        return this.mTopicId;
    }

    private void bBZ() {
        if (bBh() != null) {
            bBh().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    public void onDestory() {
        this.fDH.cancelLoadData();
    }

    public void bCn() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.mPostContent);
        writeData.setTopicId(String.valueOf(this.mTopicId));
        writeData.setWriteImagesInfo(this.writeImagesInfo);
        y.e(String.valueOf(this.mTopicId), writeData);
    }

    public void cGU() {
        y.d(String.valueOf(this.mTopicId), new y.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.5
            @Override // com.baidu.tieba.tbadkCore.y.a
            public void b(WriteData writeData) {
                if (writeData != null) {
                    if (writeData.getWriteImagesInfo() != null && a.this.writeImagesInfo.size() == 0) {
                        a.this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                        if (a.this.writeImagesInfo != null && a.this.writeImagesInfo.getChosedFiles() != null && a.this.writeImagesInfo.getChosedFiles().size() > 0) {
                            a.this.bBh().b(new com.baidu.tbadk.editortools.a(2, 10, a.this.writeImagesInfo.getChosedFiles().size() + ""));
                        }
                    }
                    if (a.this.writeImagesInfo == null || a.this.writeImagesInfo.size() == 0) {
                        a.this.bBh().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                    }
                    if (!au.isEmpty(writeData.getContent()) && au.isEmpty(a.this.mPostContent)) {
                        a.this.mPostContent = writeData.getContent();
                        a.this.CY(a.this.mPostContent);
                    }
                }
            }
        });
    }

    public void bCo() {
        y.e(String.valueOf(this.mTopicId), (WriteData) null);
    }

    private void I(ArrayList<String> arrayList) {
        if (bBh() != null) {
            bBh().b(new com.baidu.tbadk.editortools.a(17, 29, arrayList));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CY(String str) {
        if (bBh() != null) {
            bBh().b(new com.baidu.tbadk.editortools.a(6, 29, str));
        }
    }

    public void CW(String str) {
        this.mPostContent = str;
    }

    public void lb(boolean z) {
        this.fEt = z;
    }

    public void bCq() {
        lb(false);
        bBh().hide();
    }

    public void bCt() {
        lb(true);
        bBh().display();
    }

    public void b(NewWriteModel.d dVar) {
        this.fEu = dVar;
    }

    public void a(com.baidu.tbadk.editortools.pb.b bVar) {
        this.fDP = bVar;
    }

    public c cSs() {
        if (this.kph == null && bBh() != null) {
            this.kph = (c) bBh().qU(29);
        }
        return this.kph;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public void setTopicId(long j) {
        this.mTopicId = j;
    }
}
