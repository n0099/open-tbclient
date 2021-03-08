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
    private TbPageContext<?> eWx;
    private boolean fFS;
    private NewWriteModel.d fFT;
    private View.OnClickListener fFW;
    private String fFe;
    private NewWriteModel fFg;
    private ImageModel fFh;
    private String fFk;
    private com.baidu.tbadk.editortools.pb.c fFn;
    private com.baidu.tbadk.editortools.pb.b fFo;
    private NewWriteModel.d fFv;
    private final com.baidu.adp.base.e fFw;
    private String kri;
    private c krj;
    private AntiHelper.a mInjectListener;
    private String mPostContent;
    private long mTopicId;
    private WriteImagesInfo writeImagesInfo;

    /* JADX INFO: Access modifiers changed from: private */
    public void kZ(boolean z) {
        if (bBk() != null) {
            bBk().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void Dh(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(bwp().getPageActivity());
        aVar.AB(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(bwp()).bqz();
    }

    public void aN(int i, String str) {
        if (AntiHelper.bX(i, str)) {
            if (AntiHelper.a(this.eWx.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).aq("obj_locate", ay.a.LOCATE_REPLY_SUB_PB));
            }
        } else if (i == 230277 || i == 230278) {
            Dh(str);
        } else {
            bwp().showToast(str);
        }
    }

    public TbPageContext<?> bwp() {
        return this.eWx;
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.mPostContent = "";
        this.kri = null;
        this.fFS = false;
        this.fFk = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.fFh = null;
        this.fFv = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                if (a.this.fFT != null) {
                    a.this.fFT.callback(z, postWriteCallBackData, ahVar, writeData, antiData);
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
                    a.this.fFg.f((WriteData) null);
                    a.this.fFg.yD(false);
                    a.this.writeImagesInfo.clear();
                    a.this.bCr();
                    a.this.bBk().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.bX(i, str)) {
                    a.this.aN(i, str);
                } else if (ahVar != null && writeData != null && !StringUtils.isNull(ahVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(ahVar.getVcode_md5());
                    writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                    writeData.setVcodeExtra(ahVar.bwI());
                    if (com.baidu.tbadk.t.a.Ef(ahVar.bwH())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.bwp().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bwH())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.bwp().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.eWx.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    a.this.bwp().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).aq("obj_locate", ay.a.LOCATE_REPLY_SUB_PB));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).aq("obj_locate", ay.a.LOCATE_REPLY_SUB_PB));
            }
        };
        this.fFw = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.4
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                if (obj instanceof Bitmap) {
                    a.this.fFg.yD(true);
                }
            }
        };
        this.fFW = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(a.this.fFk)) {
                    l.showToast(a.this.bwp().getPageActivity(), a.this.fFk);
                }
            }
        };
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.eWx = tbPageContext;
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        if (baseActivity != null) {
            this.fFg = new NewWriteModel(baseActivity);
            this.fFg.b(this.fFv);
            this.fFh = new ImageModel(baseActivity.getPageContext());
            this.fFh.setLoadDataCallBack(this.fFw);
            if (bundle != null) {
                this.writeImagesInfo.parseJson(bundle.getString("write_images"));
                this.fFe = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            }
            if (this.writeImagesInfo != null) {
                this.writeImagesInfo.setMaxImagesAllowed(9);
            }
            if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                bBk().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
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
                        bBk().invalidate();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_IMAGE_VIEW /* 12003 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("delete", false)) {
                            bCc();
                            this.fFg.yD(false);
                            return;
                        }
                        this.fFh.CZ(intent.getStringExtra("file_name"));
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
                    if (this.fFT != null) {
                        this.mPostContent = null;
                        kZ(true);
                        this.fFg.f((WriteData) null);
                        this.fFg.yD(false);
                        this.writeImagesInfo.clear();
                        bCr();
                        bBk().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                        this.fFT.callback(true, postWriteCallBackData2, null, this.fFg.daL(), null);
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
                        this.fFv.callback(true, postWriteCallBackData, null, null, null);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        ar arVar = new ar(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
                        arVar.aq("obj_locate", 6);
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
                    if (this.fFT != null) {
                        this.fFT.callback(false, postWriteCallBackData3, null, this.fFg.daL(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void F(Intent intent) {
        this.fFe = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.fFe;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.eWx.getPageActivity(), l.getEquipmentWidth(this.eWx.getPageActivity())), l.dip2px(this.eWx.getPageActivity(), l.getEquipmentHeight(this.eWx.getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    o.a("cameras", this.fFe, rotateBitmapBydegree, 100);
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
                cSx();
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
                cSx();
            }
        }
    }

    private void cSx() {
        if (!WriteActivityConfig.isAsyncWriting() || this.mTopicId <= 0) {
            WriteActivityConfig.newInstance(this.eWx.getPageActivity()).setType(9).setForumId("0").setTopicId(String.valueOf(this.mTopicId)).setFrom("topic_detail").setCallFrom("1").setContent(this.mPostContent).setWriteImagesInfo(this.writeImagesInfo).send();
        }
    }

    public void bCp() {
        if (this.fFg.daL() == null) {
            this.fFg.f(new WriteData());
        }
        if (this.fFg.daL() != null) {
            this.fFg.daL().setForumId("0");
            this.fFg.daL().setType(9);
            this.fFg.daL().setEntranceType(1);
            this.fFg.daL().setCanNoForum(true);
            this.fFg.daL().setTransmitForumData("[]");
            this.fFg.daL().setCallFrom("1");
            this.fFg.daL().setTopicId(String.valueOf(this.mTopicId));
            this.fFg.daL().setContent(this.mPostContent);
            this.fFg.daL().setIsNoTitle(true);
            this.fFg.daL().setTitle("");
            this.fFg.daL().setVoice(null);
            this.fFg.daL().setVoiceDuringTime(-1);
            if (!this.fFg.dPo()) {
                bwp().showToast(R.string.write_img_limit);
            } else if (this.fFo == null || !this.fFo.bBO()) {
                if (this.fFn != null) {
                    this.fFn.bBP();
                }
                if (!this.fFg.dPm()) {
                }
            }
        }
    }

    private void H(Intent intent) {
        b(intent, true);
    }

    public long cSy() {
        return this.mTopicId;
    }

    private void bCc() {
        if (bBk() != null) {
            bBk().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    public void onDestory() {
        this.fFg.cancelLoadData();
    }

    public void bCq() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.mPostContent);
        writeData.setTopicId(String.valueOf(this.mTopicId));
        writeData.setWriteImagesInfo(this.writeImagesInfo);
        y.e(String.valueOf(this.mTopicId), writeData);
    }

    public void cHa() {
        y.d(String.valueOf(this.mTopicId), new y.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.5
            @Override // com.baidu.tieba.tbadkCore.y.a
            public void b(WriteData writeData) {
                if (writeData != null) {
                    if (writeData.getWriteImagesInfo() != null && a.this.writeImagesInfo.size() == 0) {
                        a.this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                        if (a.this.writeImagesInfo != null && a.this.writeImagesInfo.getChosedFiles() != null && a.this.writeImagesInfo.getChosedFiles().size() > 0) {
                            a.this.bBk().b(new com.baidu.tbadk.editortools.a(2, 10, a.this.writeImagesInfo.getChosedFiles().size() + ""));
                        }
                    }
                    if (a.this.writeImagesInfo == null || a.this.writeImagesInfo.size() == 0) {
                        a.this.bBk().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                    }
                    if (!au.isEmpty(writeData.getContent()) && au.isEmpty(a.this.mPostContent)) {
                        a.this.mPostContent = writeData.getContent();
                        a.this.Df(a.this.mPostContent);
                    }
                }
            }
        });
    }

    public void bCr() {
        y.e(String.valueOf(this.mTopicId), (WriteData) null);
    }

    private void I(ArrayList<String> arrayList) {
        if (bBk() != null) {
            bBk().b(new com.baidu.tbadk.editortools.a(17, 29, arrayList));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Df(String str) {
        if (bBk() != null) {
            bBk().b(new com.baidu.tbadk.editortools.a(6, 29, str));
        }
    }

    public void Dd(String str) {
        this.mPostContent = str;
    }

    public void lb(boolean z) {
        this.fFS = z;
    }

    public void bCt() {
        lb(false);
        bBk().hide();
    }

    public void bCw() {
        lb(true);
        bBk().display();
    }

    public void b(NewWriteModel.d dVar) {
        this.fFT = dVar;
    }

    public void a(com.baidu.tbadk.editortools.pb.b bVar) {
        this.fFo = bVar;
    }

    public c cSz() {
        if (this.krj == null && bBk() != null) {
            this.krj = (c) bBk().qV(29);
        }
        return this.krj;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public void setTopicId(long j) {
        this.mTopicId = j;
    }
}
