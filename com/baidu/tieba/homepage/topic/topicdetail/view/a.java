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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.aa;
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
/* loaded from: classes9.dex */
public class a extends com.baidu.tbadk.editortools.d {
    private TbPageContext<?> cVv;
    private String dyK;
    private NewWriteModel dyM;
    private ImageModel dyN;
    private String dyQ;
    private com.baidu.tbadk.editortools.pb.c dyT;
    private com.baidu.tbadk.editortools.pb.b dyU;
    private View.OnClickListener dzB;
    private NewWriteModel.d dza;
    private final com.baidu.adp.base.d dzb;
    private boolean dzx;
    private NewWriteModel.d dzy;
    private String hik;
    private c hil;
    private AntiHelper.a mInjectListener;
    private String mPostContent;
    private long mTopicId;
    private WriteImagesInfo writeImagesInfo;

    /* JADX INFO: Access modifiers changed from: private */
    public void gK(boolean z) {
        if (aOy() != null) {
            aOy().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void vr(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(aJv().getPageActivity());
        aVar.sS(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(aJv()).aEG();
    }

    public void T(int i, String str) {
        if (AntiHelper.bb(i, str)) {
            if (AntiHelper.a(this.cVv.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).X("obj_locate", at.a.LOCATE_REPLY_SUB_PB));
            }
        } else if (i == 230277 || i == 230278) {
            vr(str);
        } else {
            aJv().showToast(str);
        }
    }

    public TbPageContext<?> aJv() {
        return this.cVv;
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.mPostContent = "";
        this.hik = null;
        this.dzx = false;
        this.dyQ = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.dyN = null;
        this.dza = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
                if (a.this.dzy != null) {
                    a.this.dzy.callback(z, postWriteCallBackData, aaVar, writeData, antiData);
                }
                if (z) {
                    a.this.mPostContent = null;
                    a.this.gK(true);
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    a.this.dyM.d((WriteData) null);
                    a.this.dyM.sY(false);
                    a.this.writeImagesInfo.clear();
                    a.this.aPv();
                    a.this.aOy().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.bb(i, str)) {
                    a.this.T(i, str);
                } else if (aaVar != null && writeData != null && !StringUtils.isNull(aaVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(aaVar.getVcode_md5());
                    writeData.setVcodeUrl(aaVar.getVcode_pic_url());
                    writeData.setVcodeExtra(aaVar.aJL());
                    if (com.baidu.tbadk.s.a.wc(aaVar.aJK())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.aJv().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, aaVar.aJK())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.aJv().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.cVv.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    a.this.aJv().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).X("obj_locate", at.a.LOCATE_REPLY_SUB_PB));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).X("obj_locate", at.a.LOCATE_REPLY_SUB_PB));
            }
        };
        this.dzb = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.4
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Bitmap) {
                    a.this.dyM.sY(true);
                }
            }
        };
        this.dzB = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(a.this.dyQ)) {
                    l.showToast(a.this.aJv().getPageActivity(), a.this.dyQ);
                }
            }
        };
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.cVv = tbPageContext;
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        if (baseActivity != null) {
            this.dyM = new NewWriteModel(baseActivity);
            this.dyM.b(this.dza);
            this.dyN = new ImageModel(baseActivity.getPageContext());
            this.dyN.setLoadDataCallBack(this.dzb);
            if (bundle != null) {
                this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
                this.dyK = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            }
            if (this.writeImagesInfo != null) {
                this.writeImagesInfo.setMaxImagesAllowed(9);
            }
            if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                aOy().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
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
                            T(intent);
                        } else {
                            V(intent);
                        }
                        aOy().invalidate();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_IMAGE_VIEW /* 12003 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("delete", false)) {
                            aPj();
                            this.dyM.sY(false);
                            return;
                        }
                        this.dyN.vk(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        G(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    PostWriteCallBackData postWriteCallBackData2 = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (this.dzy != null) {
                        this.mPostContent = null;
                        gK(true);
                        this.dyM.d((WriteData) null);
                        this.dyM.sY(false);
                        this.writeImagesInfo.clear();
                        aPv();
                        aOy().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                        this.dzy.callback(true, postWriteCallBackData2, null, this.dyM.cIp(), null);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    if (i == 12010) {
                        T(intent);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    U(intent);
                    return;
                case RequestResponseCode.REQUEST_WRITE_NEW /* 13003 */:
                    if (intent != null) {
                        try {
                            postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                        } catch (Exception e) {
                            BdLog.e(e);
                            postWriteCallBackData = null;
                        }
                        this.dza.callback(true, postWriteCallBackData, null, null, null);
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
                    if (this.dzy != null) {
                        this.dzy.callback(false, postWriteCallBackData3, null, this.dyM.cIp(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void T(Intent intent) {
        this.dyK = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.dyK;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.cVv.getPageActivity(), l.getEquipmentWidth(this.cVv.getPageActivity())), l.dip2px(this.cVv.getPageActivity(), l.getEquipmentHeight(this.cVv.getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    m.a("cameras", this.dyK, rotateBitmapBydegree, 100);
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
                bPM();
            }
        }
    }

    private void U(Intent intent) {
        b(intent, false);
    }

    private void b(Intent intent, boolean z) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                bPM();
            }
        }
    }

    private void bPM() {
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.cVv.getPageActivity(), 9, "0", null, null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0);
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

    public void aPt() {
        if (this.dyM.cIp() == null) {
            this.dyM.d(new WriteData());
        }
        if (this.dyM.cIp() != null) {
            this.dyM.cIp().setForumId("0");
            this.dyM.cIp().setType(9);
            this.dyM.cIp().setEntranceType(1);
            this.dyM.cIp().setCanNoForum(true);
            this.dyM.cIp().setTransmitForumData("[]");
            this.dyM.cIp().setCallFrom("1");
            this.dyM.cIp().setTopicId(String.valueOf(this.mTopicId));
            this.dyM.cIp().setContent(this.mPostContent);
            this.dyM.cIp().setIsNoTitle(true);
            this.dyM.cIp().setTitle("");
            this.dyM.cIp().setVoice(null);
            this.dyM.cIp().setVoiceDuringTime(-1);
            if (!this.dyM.cMH()) {
                aJv().showToast((int) R.string.write_img_limit);
            } else if (this.dyU == null || !this.dyU.aOV()) {
                if (this.dyT != null) {
                    this.dyT.aOW();
                }
                if (!this.dyM.cME()) {
                }
            }
        }
    }

    private void V(Intent intent) {
        b(intent, true);
    }

    public long bPN() {
        return this.mTopicId;
    }

    private void aPj() {
        if (aOy() != null) {
            aOy().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    public void onDestory() {
        this.dyM.cancelLoadData();
    }

    public void aPu() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.mPostContent);
        writeData.setTopicId(String.valueOf(this.mTopicId));
        writeData.setWriteImagesInfo(this.writeImagesInfo);
        w.b(String.valueOf(this.mTopicId), writeData);
    }

    public void bPO() {
        w.d(String.valueOf(this.mTopicId), new w.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.5
            @Override // com.baidu.tieba.tbadkCore.w.a
            public void a(WriteData writeData) {
                if (writeData != null) {
                    if (writeData.getWriteImagesInfo() != null && a.this.writeImagesInfo.size() == 0) {
                        a.this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                        if (a.this.writeImagesInfo != null && a.this.writeImagesInfo.getChosedFiles() != null && a.this.writeImagesInfo.getChosedFiles().size() > 0) {
                            a.this.aOy().b(new com.baidu.tbadk.editortools.a(2, 10, a.this.writeImagesInfo.getChosedFiles().size() + ""));
                        }
                    }
                    if (a.this.writeImagesInfo == null || a.this.writeImagesInfo.size() == 0) {
                        a.this.aOy().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                    }
                    if (!aq.isEmpty(writeData.getContent()) && aq.isEmpty(a.this.mPostContent)) {
                        a.this.mPostContent = writeData.getContent();
                        a.this.vp(a.this.mPostContent);
                    }
                }
            }
        });
    }

    public void aPv() {
        w.b(String.valueOf(this.mTopicId), (WriteData) null);
    }

    private void G(ArrayList<String> arrayList) {
        if (aOy() != null) {
            aOy().b(new com.baidu.tbadk.editortools.a(17, 29, arrayList));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vp(String str) {
        if (aOy() != null) {
            aOy().b(new com.baidu.tbadk.editortools.a(6, 29, str));
        }
    }

    public void vn(String str) {
        this.mPostContent = str;
    }

    public void gL(boolean z) {
        this.dzx = z;
    }

    public void aPx() {
        gL(false);
        aOy().hide();
    }

    public void aPA() {
        gL(true);
        aOy().display();
    }

    public void b(NewWriteModel.d dVar) {
        this.dzy = dVar;
    }

    public void a(com.baidu.tbadk.editortools.pb.b bVar) {
        this.dyU = bVar;
    }

    public c bPP() {
        if (this.hil == null && aOy() != null) {
            this.hil = (c) aOy().mr(29);
        }
        return this.hil;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public void setTopicId(long j) {
        this.mTopicId = j;
    }
}
