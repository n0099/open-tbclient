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
/* loaded from: classes21.dex */
public class a extends com.baidu.tbadk.editortools.e {
    private boolean ePW;
    private NewWriteModel.d ePX;
    private String ePi;
    private NewWriteModel ePk;
    private ImageModel ePl;
    private String ePo;
    private com.baidu.tbadk.editortools.pb.c ePr;
    private com.baidu.tbadk.editortools.pb.b ePs;
    private NewWriteModel.d ePy;
    private final com.baidu.adp.base.d ePz;
    private View.OnClickListener eQa;
    private TbPageContext<?> ehG;
    private String jcr;
    private c jcs;
    private AntiHelper.a mInjectListener;
    private String mPostContent;
    private long mTopicId;
    private WriteImagesInfo writeImagesInfo;

    /* JADX INFO: Access modifiers changed from: private */
    public void js(boolean z) {
        if (bsv() != null) {
            bsv().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void CA(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(bnz().getPageActivity());
        aVar.zV(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(bnz()).bia();
    }

    public void ar(int i, String str) {
        if (AntiHelper.bC(i, str)) {
            if (AntiHelper.a(this.ehG.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ai("obj_locate", ax.a.LOCATE_REPLY_SUB_PB));
            }
        } else if (i == 230277 || i == 230278) {
            CA(str);
        } else {
            bnz().showToast(str);
        }
    }

    public TbPageContext<?> bnz() {
        return this.ehG;
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.mPostContent = "";
        this.jcr = null;
        this.ePW = false;
        this.ePo = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.ePl = null;
        this.ePy = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                if (a.this.ePX != null) {
                    a.this.ePX.callback(z, postWriteCallBackData, ahVar, writeData, antiData);
                }
                if (z) {
                    a.this.mPostContent = null;
                    a.this.js(true);
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    a.this.ePk.e((WriteData) null);
                    a.this.ePk.wr(false);
                    a.this.writeImagesInfo.clear();
                    a.this.btB();
                    a.this.bsv().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.bC(i, str)) {
                    a.this.ar(i, str);
                } else if (ahVar != null && writeData != null && !StringUtils.isNull(ahVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(ahVar.getVcode_md5());
                    writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                    writeData.setVcodeExtra(ahVar.bnT());
                    if (com.baidu.tbadk.t.a.Dl(ahVar.bnS())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.bnz().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bnS())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.bnz().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.ehG.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    a.this.bnz().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ai("obj_locate", ax.a.LOCATE_REPLY_SUB_PB));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ai("obj_locate", ax.a.LOCATE_REPLY_SUB_PB));
            }
        };
        this.ePz = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.4
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Bitmap) {
                    a.this.ePk.wr(true);
                }
            }
        };
        this.eQa = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(a.this.ePo)) {
                    l.showToast(a.this.bnz().getPageActivity(), a.this.ePo);
                }
            }
        };
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.ehG = tbPageContext;
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        if (baseActivity != null) {
            this.ePk = new NewWriteModel(baseActivity);
            this.ePk.b(this.ePy);
            this.ePl = new ImageModel(baseActivity.getPageContext());
            this.ePl.setLoadDataCallBack(this.ePz);
            if (bundle != null) {
                this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
                this.ePi = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            }
            if (this.writeImagesInfo != null) {
                this.writeImagesInfo.setMaxImagesAllowed(9);
            }
            if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                bsv().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
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
                        bsv().invalidate();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_IMAGE_VIEW /* 12003 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("delete", false)) {
                            btn();
                            this.ePk.wr(false);
                            return;
                        }
                        this.ePl.Cs(intent.getStringExtra("file_name"));
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
                    if (this.ePX != null) {
                        this.mPostContent = null;
                        js(true);
                        this.ePk.e((WriteData) null);
                        this.ePk.wr(false);
                        this.writeImagesInfo.clear();
                        btB();
                        bsv().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                        this.ePX.callback(true, postWriteCallBackData2, null, this.ePk.cOG(), null);
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
                        this.ePy.callback(true, postWriteCallBackData, null, null, null);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
                        aqVar.ai("obj_locate", 6);
                        if (shareItem != null) {
                            aqVar.dF("tid", shareItem.tid);
                        }
                        aqVar.dF("pid", intent.getStringExtra("pid"));
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
                    if (this.ePX != null) {
                        this.ePX.callback(false, postWriteCallBackData3, null, this.ePk.cOG(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void E(Intent intent) {
        this.ePi = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.ePi;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.ehG.getPageActivity(), l.getEquipmentWidth(this.ehG.getPageActivity())), l.dip2px(this.ehG.getPageActivity(), l.getEquipmentHeight(this.ehG.getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    n.a("cameras", this.ePi, rotateBitmapBydegree, 100);
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
                cCI();
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
                cCI();
            }
        }
    }

    private void cCI() {
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.ehG.getPageActivity(), 9, "0", null, null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0);
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

    public void btz() {
        if (this.ePk.cOG() == null) {
            this.ePk.e(new WriteData());
        }
        if (this.ePk.cOG() != null) {
            this.ePk.cOG().setForumId("0");
            this.ePk.cOG().setType(9);
            this.ePk.cOG().setEntranceType(1);
            this.ePk.cOG().setCanNoForum(true);
            this.ePk.cOG().setTransmitForumData("[]");
            this.ePk.cOG().setCallFrom("1");
            this.ePk.cOG().setTopicId(String.valueOf(this.mTopicId));
            this.ePk.cOG().setContent(this.mPostContent);
            this.ePk.cOG().setIsNoTitle(true);
            this.ePk.cOG().setTitle("");
            this.ePk.cOG().setVoice(null);
            this.ePk.cOG().setVoiceDuringTime(-1);
            if (!this.ePk.dBT()) {
                bnz().showToast(R.string.write_img_limit);
            } else if (this.ePs == null || !this.ePs.bsZ()) {
                if (this.ePr != null) {
                    this.ePr.bta();
                }
                if (!this.ePk.dBQ()) {
                }
            }
        }
    }

    private void G(Intent intent) {
        a(intent, true);
    }

    public long cCJ() {
        return this.mTopicId;
    }

    private void btn() {
        if (bsv() != null) {
            bsv().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    public void onDestory() {
        this.ePk.cancelLoadData();
    }

    public void btA() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.mPostContent);
        writeData.setTopicId(String.valueOf(this.mTopicId));
        writeData.setWriteImagesInfo(this.writeImagesInfo);
        x.b(String.valueOf(this.mTopicId), writeData);
    }

    public void ctp() {
        x.e(String.valueOf(this.mTopicId), new x.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.5
            @Override // com.baidu.tieba.tbadkCore.x.a
            public void a(WriteData writeData) {
                if (writeData != null) {
                    if (writeData.getWriteImagesInfo() != null && a.this.writeImagesInfo.size() == 0) {
                        a.this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                        if (a.this.writeImagesInfo != null && a.this.writeImagesInfo.getChosedFiles() != null && a.this.writeImagesInfo.getChosedFiles().size() > 0) {
                            a.this.bsv().b(new com.baidu.tbadk.editortools.a(2, 10, a.this.writeImagesInfo.getChosedFiles().size() + ""));
                        }
                    }
                    if (a.this.writeImagesInfo == null || a.this.writeImagesInfo.size() == 0) {
                        a.this.bsv().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                    }
                    if (!at.isEmpty(writeData.getContent()) && at.isEmpty(a.this.mPostContent)) {
                        a.this.mPostContent = writeData.getContent();
                        a.this.Cy(a.this.mPostContent);
                    }
                }
            }
        });
    }

    public void btB() {
        x.b(String.valueOf(this.mTopicId), (WriteData) null);
    }

    private void N(ArrayList<String> arrayList) {
        if (bsv() != null) {
            bsv().b(new com.baidu.tbadk.editortools.a(17, 29, arrayList));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cy(String str) {
        if (bsv() != null) {
            bsv().b(new com.baidu.tbadk.editortools.a(6, 29, str));
        }
    }

    public void Cw(String str) {
        this.mPostContent = str;
    }

    public void ju(boolean z) {
        this.ePW = z;
    }

    public void btD() {
        ju(false);
        bsv().hide();
    }

    public void btG() {
        ju(true);
        bsv().display();
    }

    public void b(NewWriteModel.d dVar) {
        this.ePX = dVar;
    }

    public void a(com.baidu.tbadk.editortools.pb.b bVar) {
        this.ePs = bVar;
    }

    public c cCK() {
        if (this.jcs == null && bsv() != null) {
            this.jcs = (c) bsv().qr(29);
        }
        return this.jcs;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public void setTopicId(long j) {
        this.mTopicId = j;
    }
}
