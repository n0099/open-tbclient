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
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ad;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.ImageModel;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes16.dex */
public class a extends com.baidu.tbadk.editortools.d {
    private TbPageContext<?> dVN;
    private String eBO;
    private NewWriteModel eBQ;
    private ImageModel eBR;
    private String eBU;
    private com.baidu.tbadk.editortools.pb.c eBX;
    private com.baidu.tbadk.editortools.pb.b eBY;
    private boolean eCC;
    private NewWriteModel.d eCD;
    private View.OnClickListener eCG;
    private NewWriteModel.d eCe;
    private final com.baidu.adp.base.d eCf;
    private String iEH;
    private c iEI;
    private AntiHelper.a mInjectListener;
    private String mPostContent;
    private long mTopicId;
    private WriteImagesInfo writeImagesInfo;

    /* JADX INFO: Access modifiers changed from: private */
    public void iR(boolean z) {
        if (biJ() != null) {
            biJ().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void zN(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(bdZ().getPageActivity());
        aVar.xl(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(bdZ()).aYL();
    }

    public void as(int i, String str) {
        if (AntiHelper.bB(i, str)) {
            if (AntiHelper.a(this.dVN.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ah("obj_locate", aw.a.LOCATE_REPLY_SUB_PB));
            }
        } else if (i == 230277 || i == 230278) {
            zN(str);
        } else {
            bdZ().showToast(str);
        }
    }

    public TbPageContext<?> bdZ() {
        return this.dVN;
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.mPostContent = "";
        this.iEH = null;
        this.eCC = false;
        this.eBU = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.eBR = null;
        this.eCe = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ad adVar, WriteData writeData, AntiData antiData) {
                if (a.this.eCD != null) {
                    a.this.eCD.callback(z, postWriteCallBackData, adVar, writeData, antiData);
                }
                if (z) {
                    a.this.mPostContent = null;
                    a.this.iR(true);
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    a.this.eBQ.d((WriteData) null);
                    a.this.eBQ.vr(false);
                    a.this.writeImagesInfo.clear();
                    a.this.bjK();
                    a.this.biJ().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.bB(i, str)) {
                    a.this.as(i, str);
                } else if (adVar != null && writeData != null && !StringUtils.isNull(adVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(adVar.getVcode_md5());
                    writeData.setVcodeUrl(adVar.getVcode_pic_url());
                    writeData.setVcodeExtra(adVar.bep());
                    if (com.baidu.tbadk.t.a.Ay(adVar.beo())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.bdZ().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, adVar.beo())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.bdZ().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.dVN.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    a.this.bdZ().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ah("obj_locate", aw.a.LOCATE_REPLY_SUB_PB));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ah("obj_locate", aw.a.LOCATE_REPLY_SUB_PB));
            }
        };
        this.eCf = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.4
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Bitmap) {
                    a.this.eBQ.vr(true);
                }
            }
        };
        this.eCG = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(a.this.eBU)) {
                    l.showToast(a.this.bdZ().getPageActivity(), a.this.eBU);
                }
            }
        };
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.dVN = tbPageContext;
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        if (baseActivity != null) {
            this.eBQ = new NewWriteModel(baseActivity);
            this.eBQ.b(this.eCe);
            this.eBR = new ImageModel(baseActivity.getPageContext());
            this.eBR.setLoadDataCallBack(this.eCf);
            if (bundle != null) {
                this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
                this.eBO = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            }
            if (this.writeImagesInfo != null) {
                this.writeImagesInfo.setMaxImagesAllowed(9);
            }
            if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                biJ().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
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
                            C(intent);
                        } else {
                            E(intent);
                        }
                        biJ().invalidate();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_IMAGE_VIEW /* 12003 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("delete", false)) {
                            bjx();
                            this.eBQ.vr(false);
                            return;
                        }
                        this.eBR.zF(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        H(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    PostWriteCallBackData postWriteCallBackData2 = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (this.eCD != null) {
                        this.mPostContent = null;
                        iR(true);
                        this.eBQ.d((WriteData) null);
                        this.eBQ.vr(false);
                        this.writeImagesInfo.clear();
                        bjK();
                        biJ().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                        this.eCD.callback(true, postWriteCallBackData2, null, this.eBQ.dhF(), null);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    if (i == 12010) {
                        C(intent);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    D(intent);
                    return;
                case RequestResponseCode.REQUEST_WRITE_NEW /* 13003 */:
                    if (intent != null) {
                        try {
                            postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                        } catch (Exception e) {
                            BdLog.e(e);
                            postWriteCallBackData = null;
                        }
                        this.eCe.callback(true, postWriteCallBackData, null, null, null);
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
                    if (this.eCD != null) {
                        this.eCD.callback(false, postWriteCallBackData3, null, this.eBQ.dhF(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void C(Intent intent) {
        this.eBO = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.eBO;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.dVN.getPageActivity(), l.getEquipmentWidth(this.dVN.getPageActivity())), l.dip2px(this.dVN.getPageActivity(), l.getEquipmentHeight(this.dVN.getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    n.a("cameras", this.eBO, rotateBitmapBydegree, 100);
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
                coh();
            }
        }
    }

    private void D(Intent intent) {
        b(intent, false);
    }

    private void b(Intent intent, boolean z) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                coh();
            }
        }
    }

    private void coh() {
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.dVN.getPageActivity(), 9, "0", null, null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0);
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

    public void bjI() {
        if (this.eBQ.dhF() == null) {
            this.eBQ.d(new WriteData());
        }
        if (this.eBQ.dhF() != null) {
            this.eBQ.dhF().setForumId("0");
            this.eBQ.dhF().setType(9);
            this.eBQ.dhF().setEntranceType(1);
            this.eBQ.dhF().setCanNoForum(true);
            this.eBQ.dhF().setTransmitForumData("[]");
            this.eBQ.dhF().setCallFrom("1");
            this.eBQ.dhF().setTopicId(String.valueOf(this.mTopicId));
            this.eBQ.dhF().setContent(this.mPostContent);
            this.eBQ.dhF().setIsNoTitle(true);
            this.eBQ.dhF().setTitle("");
            this.eBQ.dhF().setVoice(null);
            this.eBQ.dhF().setVoiceDuringTime(-1);
            if (!this.eBQ.dmA()) {
                bdZ().showToast(R.string.write_img_limit);
            } else if (this.eBY == null || !this.eBY.bji()) {
                if (this.eBX != null) {
                    this.eBX.bjj();
                }
                if (!this.eBQ.dmx()) {
                }
            }
        }
    }

    private void E(Intent intent) {
        b(intent, true);
    }

    public long coi() {
        return this.mTopicId;
    }

    private void bjx() {
        if (biJ() != null) {
            biJ().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    public void onDestory() {
        this.eBQ.cancelLoadData();
    }

    public void bjJ() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.mPostContent);
        writeData.setTopicId(String.valueOf(this.mTopicId));
        writeData.setWriteImagesInfo(this.writeImagesInfo);
        w.b(String.valueOf(this.mTopicId), writeData);
    }

    public void cfw() {
        w.e(String.valueOf(this.mTopicId), new w.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.5
            @Override // com.baidu.tieba.tbadkCore.w.a
            public void a(WriteData writeData) {
                if (writeData != null) {
                    if (writeData.getWriteImagesInfo() != null && a.this.writeImagesInfo.size() == 0) {
                        a.this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                        if (a.this.writeImagesInfo != null && a.this.writeImagesInfo.getChosedFiles() != null && a.this.writeImagesInfo.getChosedFiles().size() > 0) {
                            a.this.biJ().b(new com.baidu.tbadk.editortools.a(2, 10, a.this.writeImagesInfo.getChosedFiles().size() + ""));
                        }
                    }
                    if (a.this.writeImagesInfo == null || a.this.writeImagesInfo.size() == 0) {
                        a.this.biJ().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                    }
                    if (!as.isEmpty(writeData.getContent()) && as.isEmpty(a.this.mPostContent)) {
                        a.this.mPostContent = writeData.getContent();
                        a.this.zL(a.this.mPostContent);
                    }
                }
            }
        });
    }

    public void bjK() {
        w.b(String.valueOf(this.mTopicId), (WriteData) null);
    }

    private void H(ArrayList<String> arrayList) {
        if (biJ() != null) {
            biJ().b(new com.baidu.tbadk.editortools.a(17, 29, arrayList));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zL(String str) {
        if (biJ() != null) {
            biJ().b(new com.baidu.tbadk.editortools.a(6, 29, str));
        }
    }

    public void zJ(String str) {
        this.mPostContent = str;
    }

    public void iT(boolean z) {
        this.eCC = z;
    }

    public void bjM() {
        iT(false);
        biJ().hide();
    }

    public void bjP() {
        iT(true);
        biJ().display();
    }

    public void b(NewWriteModel.d dVar) {
        this.eCD = dVar;
    }

    public void a(com.baidu.tbadk.editortools.pb.b bVar) {
        this.eBY = bVar;
    }

    public c coj() {
        if (this.iEI == null && biJ() != null) {
            this.iEI = (c) biJ().nT(29);
        }
        return this.iEI;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public void setTopicId(long j) {
        this.mTopicId = j;
    }
}
