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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.n;
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
import com.baidu.tieba.tbadkCore.x;
import java.util.ArrayList;
/* loaded from: classes22.dex */
public class a extends com.baidu.tbadk.editortools.e {
    private TbPageContext<?> eIc;
    private String fpG;
    private NewWriteModel fpI;
    private ImageModel fpJ;
    private String fpM;
    private com.baidu.tbadk.editortools.pb.c fpP;
    private com.baidu.tbadk.editortools.pb.b fpQ;
    private NewWriteModel.d fpW;
    private final com.baidu.adp.base.d fpX;
    private boolean fqu;
    private NewWriteModel.d fqv;
    private View.OnClickListener fqy;
    private String jJO;
    private c jJP;
    private AntiHelper.a mInjectListener;
    private String mPostContent;
    private long mTopicId;
    private WriteImagesInfo writeImagesInfo;

    /* JADX INFO: Access modifiers changed from: private */
    public void km(boolean z) {
        if (bzx() != null) {
            bzx().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void DT(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(buC().getPageActivity());
        aVar.Bo(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(buC()).bpc();
    }

    public void aI(int i, String str) {
        if (AntiHelper.bR(i, str)) {
            if (AntiHelper.a(this.eIc.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).al("obj_locate", ax.a.LOCATE_REPLY_SUB_PB));
            }
        } else if (i == 230277 || i == 230278) {
            DT(str);
        } else {
            buC().showToast(str);
        }
    }

    public TbPageContext<?> buC() {
        return this.eIc;
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.mPostContent = "";
        this.jJO = null;
        this.fqu = false;
        this.fpM = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.fpJ = null;
        this.fpW = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                if (a.this.fqv != null) {
                    a.this.fqv.callback(z, postWriteCallBackData, ahVar, writeData, antiData);
                }
                if (z) {
                    a.this.mPostContent = null;
                    a.this.km(true);
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    a.this.fpI.e((WriteData) null);
                    a.this.fpI.xy(false);
                    a.this.writeImagesInfo.clear();
                    a.this.bAD();
                    a.this.bzx().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.bR(i, str)) {
                    a.this.aI(i, str);
                } else if (ahVar != null && writeData != null && !StringUtils.isNull(ahVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(ahVar.getVcode_md5());
                    writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                    writeData.setVcodeExtra(ahVar.buW());
                    if (com.baidu.tbadk.t.a.EE(ahVar.buV())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.buC().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.buV())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.buC().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.eIc.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    a.this.buC().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).al("obj_locate", ax.a.LOCATE_REPLY_SUB_PB));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).al("obj_locate", ax.a.LOCATE_REPLY_SUB_PB));
            }
        };
        this.fpX = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.4
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Bitmap) {
                    a.this.fpI.xy(true);
                }
            }
        };
        this.fqy = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(a.this.fpM)) {
                    l.showToast(a.this.buC().getPageActivity(), a.this.fpM);
                }
            }
        };
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.eIc = tbPageContext;
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        if (baseActivity != null) {
            this.fpI = new NewWriteModel(baseActivity);
            this.fpI.b(this.fpW);
            this.fpJ = new ImageModel(baseActivity.getPageContext());
            this.fpJ.setLoadDataCallBack(this.fpX);
            if (bundle != null) {
                this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
                this.fpG = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            }
            if (this.writeImagesInfo != null) {
                this.writeImagesInfo.setMaxImagesAllowed(9);
            }
            if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                bzx().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        ArrayList<String> stringArrayListExtra;
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("camera_result", false)) {
                            E(intent);
                        } else {
                            G(intent);
                        }
                        bzx().invalidate();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_IMAGE_VIEW /* 12003 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("delete", false)) {
                            bAp();
                            this.fpI.xy(false);
                            return;
                        }
                        this.fpJ.DL(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        N(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    PostWriteCallBackData postWriteCallBackData2 = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (this.fqv != null) {
                        this.mPostContent = null;
                        km(true);
                        this.fpI.e((WriteData) null);
                        this.fpI.xy(false);
                        this.writeImagesInfo.clear();
                        bAD();
                        bzx().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                        this.fqv.callback(true, postWriteCallBackData2, null, this.fpI.cXW(), null);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    if (i == 12010) {
                        E(intent);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    F(intent);
                    return;
                case RequestResponseCode.REQUEST_WRITE_NEW /* 13003 */:
                    if (intent != null) {
                        try {
                            postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                        } catch (Exception e) {
                            BdLog.e(e);
                            postWriteCallBackData = null;
                        }
                        this.fpW.callback(true, postWriteCallBackData, null, null, null);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
                        aqVar.al("obj_locate", 6);
                        if (shareItem != null) {
                            aqVar.dR("tid", shareItem.tid);
                        }
                        aqVar.dR("pid", intent.getStringExtra("pid"));
                        TiebaStatic.log(aqVar);
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
                    if (this.fqv != null) {
                        this.fqv.callback(false, postWriteCallBackData3, null, this.fpI.cXW(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void E(Intent intent) {
        this.fpG = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.fpG;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.eIc.getPageActivity(), l.getEquipmentWidth(this.eIc.getPageActivity())), l.dip2px(this.eIc.getPageActivity(), l.getEquipmentHeight(this.eIc.getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    n.a("cameras", this.fpG, rotateBitmapBydegree, 100);
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
                cLZ();
            }
        }
    }

    private void F(Intent intent) {
        a(intent, false);
    }

    private void a(Intent intent, boolean z) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                cLZ();
            }
        }
    }

    private void cLZ() {
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.eIc.getPageActivity(), 9, "0", null, null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0);
        writeActivityConfig.setTopicId(String.valueOf(this.mTopicId));
        writeActivityConfig.getIntent().putExtra("from", "topic_detail");
        writeActivityConfig.setCallFrom("1");
        if (!StringUtils.isNull(this.mPostContent)) {
            writeActivityConfig.setContent(this.mPostContent);
        }
        writeActivityConfig.setForumLevel(-1);
        writeActivityConfig.setForumAvatar(null);
        writeActivityConfig.setPrivateThread(0);
        writeActivityConfig.setForumDir("", "");
        writeActivityConfig.setWriteImagesInfo(this.writeImagesInfo);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
    }

    public void bAB() {
        if (this.fpI.cXW() == null) {
            this.fpI.e(new WriteData());
        }
        if (this.fpI.cXW() != null) {
            this.fpI.cXW().setForumId("0");
            this.fpI.cXW().setType(9);
            this.fpI.cXW().setEntranceType(1);
            this.fpI.cXW().setCanNoForum(true);
            this.fpI.cXW().setTransmitForumData("[]");
            this.fpI.cXW().setCallFrom("1");
            this.fpI.cXW().setTopicId(String.valueOf(this.mTopicId));
            this.fpI.cXW().setContent(this.mPostContent);
            this.fpI.cXW().setIsNoTitle(true);
            this.fpI.cXW().setTitle("");
            this.fpI.cXW().setVoice(null);
            this.fpI.cXW().setVoiceDuringTime(-1);
            if (!this.fpI.dLp()) {
                buC().showToast(R.string.write_img_limit);
            } else if (this.fpQ == null || !this.fpQ.bAb()) {
                if (this.fpP != null) {
                    this.fpP.bAc();
                }
                if (!this.fpI.dLm()) {
                }
            }
        }
    }

    private void G(Intent intent) {
        a(intent, true);
    }

    public long cMa() {
        return this.mTopicId;
    }

    private void bAp() {
        if (bzx() != null) {
            bzx().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    public void onDestory() {
        this.fpI.cancelLoadData();
    }

    public void bAC() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.mPostContent);
        writeData.setTopicId(String.valueOf(this.mTopicId));
        writeData.setWriteImagesInfo(this.writeImagesInfo);
        x.b(String.valueOf(this.mTopicId), writeData);
    }

    public void cCu() {
        x.e(String.valueOf(this.mTopicId), new x.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.5
            @Override // com.baidu.tieba.tbadkCore.x.a
            public void a(WriteData writeData) {
                if (writeData != null) {
                    if (writeData.getWriteImagesInfo() != null && a.this.writeImagesInfo.size() == 0) {
                        a.this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                        if (a.this.writeImagesInfo != null && a.this.writeImagesInfo.getChosedFiles() != null && a.this.writeImagesInfo.getChosedFiles().size() > 0) {
                            a.this.bzx().b(new com.baidu.tbadk.editortools.a(2, 10, a.this.writeImagesInfo.getChosedFiles().size() + ""));
                        }
                    }
                    if (a.this.writeImagesInfo == null || a.this.writeImagesInfo.size() == 0) {
                        a.this.bzx().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                    }
                    if (!at.isEmpty(writeData.getContent()) && at.isEmpty(a.this.mPostContent)) {
                        a.this.mPostContent = writeData.getContent();
                        a.this.DR(a.this.mPostContent);
                    }
                }
            }
        });
    }

    public void bAD() {
        x.b(String.valueOf(this.mTopicId), (WriteData) null);
    }

    private void N(ArrayList<String> arrayList) {
        if (bzx() != null) {
            bzx().b(new com.baidu.tbadk.editortools.a(17, 29, arrayList));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DR(String str) {
        if (bzx() != null) {
            bzx().b(new com.baidu.tbadk.editortools.a(6, 29, str));
        }
    }

    public void DP(String str) {
        this.mPostContent = str;
    }

    public void ko(boolean z) {
        this.fqu = z;
    }

    public void bAF() {
        ko(false);
        bzx().hide();
    }

    public void bAI() {
        ko(true);
        bzx().display();
    }

    public void b(NewWriteModel.d dVar) {
        this.fqv = dVar;
    }

    public void a(com.baidu.tbadk.editortools.pb.b bVar) {
        this.fpQ = bVar;
    }

    public c cMb() {
        if (this.jJP == null && bzx() != null) {
            this.jJP = (c) bzx().rk(29);
        }
        return this.jJP;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public void setTopicId(long j) {
        this.mTopicId = j;
    }
}
