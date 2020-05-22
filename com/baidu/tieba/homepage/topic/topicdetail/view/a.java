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
    private TbPageContext<?> dIF;
    private String emF;
    private NewWriteModel emH;
    private ImageModel emI;
    private String emL;
    private com.baidu.tbadk.editortools.pb.c emO;
    private com.baidu.tbadk.editortools.pb.b emP;
    private NewWriteModel.d emV;
    private final com.baidu.adp.base.d emW;
    private boolean ent;
    private NewWriteModel.d enu;
    private View.OnClickListener eny;
    private String igJ;
    private c igK;
    private AntiHelper.a mInjectListener;
    private String mPostContent;
    private long mTopicId;
    private WriteImagesInfo writeImagesInfo;

    /* JADX INFO: Access modifiers changed from: private */
    public void ie(boolean z) {
        if (bcW() != null) {
            bcW().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void yo(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(aXW().getPageActivity());
        aVar.vO(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(aXW()).aST();
    }

    public void ap(int i, String str) {
        if (AntiHelper.bv(i, str)) {
            if (AntiHelper.a(this.dIF.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ag("obj_locate", at.a.LOCATE_REPLY_SUB_PB));
            }
        } else if (i == 230277 || i == 230278) {
            yo(str);
        } else {
            aXW().showToast(str);
        }
    }

    public TbPageContext<?> aXW() {
        return this.dIF;
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.mPostContent = "";
        this.igJ = null;
        this.ent = false;
        this.emL = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.emI = null;
        this.emV = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
                if (a.this.enu != null) {
                    a.this.enu.callback(z, postWriteCallBackData, aaVar, writeData, antiData);
                }
                if (z) {
                    a.this.mPostContent = null;
                    a.this.ie(true);
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    a.this.emH.d((WriteData) null);
                    a.this.emH.uy(false);
                    a.this.writeImagesInfo.clear();
                    a.this.bdT();
                    a.this.bcW().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.bv(i, str)) {
                    a.this.ap(i, str);
                } else if (aaVar != null && writeData != null && !StringUtils.isNull(aaVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(aaVar.getVcode_md5());
                    writeData.setVcodeUrl(aaVar.getVcode_pic_url());
                    writeData.setVcodeExtra(aaVar.aYm());
                    if (com.baidu.tbadk.s.a.yX(aaVar.aYl())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.aXW().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, aaVar.aYl())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.aXW().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.dIF.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    a.this.aXW().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ag("obj_locate", at.a.LOCATE_REPLY_SUB_PB));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ag("obj_locate", at.a.LOCATE_REPLY_SUB_PB));
            }
        };
        this.emW = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.4
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Bitmap) {
                    a.this.emH.uy(true);
                }
            }
        };
        this.eny = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(a.this.emL)) {
                    l.showToast(a.this.aXW().getPageActivity(), a.this.emL);
                }
            }
        };
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.dIF = tbPageContext;
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        if (baseActivity != null) {
            this.emH = new NewWriteModel(baseActivity);
            this.emH.b(this.emV);
            this.emI = new ImageModel(baseActivity.getPageContext());
            this.emI.setLoadDataCallBack(this.emW);
            if (bundle != null) {
                this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
                this.emF = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            }
            if (this.writeImagesInfo != null) {
                this.writeImagesInfo.setMaxImagesAllowed(9);
            }
            if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                bcW().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
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
                        bcW().invalidate();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_IMAGE_VIEW /* 12003 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("delete", false)) {
                            bdH();
                            this.emH.uy(false);
                            return;
                        }
                        this.emI.yg(intent.getStringExtra("file_name"));
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
                    if (this.enu != null) {
                        this.mPostContent = null;
                        ie(true);
                        this.emH.d((WriteData) null);
                        this.emH.uy(false);
                        this.writeImagesInfo.clear();
                        bdT();
                        bcW().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                        this.enu.callback(true, postWriteCallBackData2, null, this.emH.cZP(), null);
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
                        this.emV.callback(true, postWriteCallBackData, null, null, null);
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
                    if (this.enu != null) {
                        this.enu.callback(false, postWriteCallBackData3, null, this.emH.cZP(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void C(Intent intent) {
        this.emF = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.emF;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.dIF.getPageActivity(), l.getEquipmentWidth(this.dIF.getPageActivity())), l.dip2px(this.dIF.getPageActivity(), l.getEquipmentHeight(this.dIF.getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    m.a("cameras", this.emF, rotateBitmapBydegree, 100);
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
                cgK();
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
                cgK();
            }
        }
    }

    private void cgK() {
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.dIF.getPageActivity(), 9, "0", null, null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0);
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

    public void bdR() {
        if (this.emH.cZP() == null) {
            this.emH.d(new WriteData());
        }
        if (this.emH.cZP() != null) {
            this.emH.cZP().setForumId("0");
            this.emH.cZP().setType(9);
            this.emH.cZP().setEntranceType(1);
            this.emH.cZP().setCanNoForum(true);
            this.emH.cZP().setTransmitForumData("[]");
            this.emH.cZP().setCallFrom("1");
            this.emH.cZP().setTopicId(String.valueOf(this.mTopicId));
            this.emH.cZP().setContent(this.mPostContent);
            this.emH.cZP().setIsNoTitle(true);
            this.emH.cZP().setTitle("");
            this.emH.cZP().setVoice(null);
            this.emH.cZP().setVoiceDuringTime(-1);
            if (!this.emH.deQ()) {
                aXW().showToast((int) R.string.write_img_limit);
            } else if (this.emP == null || !this.emP.bdt()) {
                if (this.emO != null) {
                    this.emO.bdu();
                }
                if (!this.emH.deN()) {
                }
            }
        }
    }

    private void E(Intent intent) {
        b(intent, true);
    }

    public long cgL() {
        return this.mTopicId;
    }

    private void bdH() {
        if (bcW() != null) {
            bcW().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    public void onDestory() {
        this.emH.cancelLoadData();
    }

    public void bdS() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.mPostContent);
        writeData.setTopicId(String.valueOf(this.mTopicId));
        writeData.setWriteImagesInfo(this.writeImagesInfo);
        w.b(String.valueOf(this.mTopicId), writeData);
    }

    public void cgM() {
        w.e(String.valueOf(this.mTopicId), new w.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.5
            @Override // com.baidu.tieba.tbadkCore.w.a
            public void a(WriteData writeData) {
                if (writeData != null) {
                    if (writeData.getWriteImagesInfo() != null && a.this.writeImagesInfo.size() == 0) {
                        a.this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                        if (a.this.writeImagesInfo != null && a.this.writeImagesInfo.getChosedFiles() != null && a.this.writeImagesInfo.getChosedFiles().size() > 0) {
                            a.this.bcW().b(new com.baidu.tbadk.editortools.a(2, 10, a.this.writeImagesInfo.getChosedFiles().size() + ""));
                        }
                    }
                    if (a.this.writeImagesInfo == null || a.this.writeImagesInfo.size() == 0) {
                        a.this.bcW().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                    }
                    if (!aq.isEmpty(writeData.getContent()) && aq.isEmpty(a.this.mPostContent)) {
                        a.this.mPostContent = writeData.getContent();
                        a.this.ym(a.this.mPostContent);
                    }
                }
            }
        });
    }

    public void bdT() {
        w.b(String.valueOf(this.mTopicId), (WriteData) null);
    }

    private void G(ArrayList<String> arrayList) {
        if (bcW() != null) {
            bcW().b(new com.baidu.tbadk.editortools.a(17, 29, arrayList));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ym(String str) {
        if (bcW() != null) {
            bcW().b(new com.baidu.tbadk.editortools.a(6, 29, str));
        }
    }

    public void yk(String str) {
        this.mPostContent = str;
    }

    /* renamed from: if  reason: not valid java name */
    public void m33if(boolean z) {
        this.ent = z;
    }

    public void bdV() {
        m33if(false);
        bcW().hide();
    }

    public void bdY() {
        m33if(true);
        bcW().display();
    }

    public void b(NewWriteModel.d dVar) {
        this.enu = dVar;
    }

    public void a(com.baidu.tbadk.editortools.pb.b bVar) {
        this.emP = bVar;
    }

    public c cgN() {
        if (this.igK == null && bcW() != null) {
            this.igK = (c) bcW().nf(29);
        }
        return this.igK;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public void setTopicId(long j) {
        this.mTopicId = j;
    }
}
