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
import com.baidu.tbadk.coreExtra.data.z;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.ImageModel;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.v;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class a extends com.baidu.tbadk.editortools.d {
    private TbPageContext<?> cRe;
    private boolean duQ;
    private NewWriteModel.d duR;
    private View.OnClickListener duU;
    private String dud;
    private NewWriteModel duf;
    private ImageModel dug;
    private String duj;
    private com.baidu.tbadk.editortools.pb.c dum;
    private com.baidu.tbadk.editortools.pb.b dun;
    private NewWriteModel.d dut;
    private final com.baidu.adp.base.d duu;
    private String heu;
    private long hev;
    private c hew;
    private AntiHelper.a mInjectListener;
    private String mPostContent;
    private WriteImagesInfo writeImagesInfo;

    /* JADX INFO: Access modifiers changed from: private */
    public void gC(boolean z) {
        if (aLV() != null) {
            aLV().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void uZ(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(aGW().getPageActivity());
        aVar.sC(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(aGW()).aCp();
    }

    public void R(int i, String str) {
        if (AntiHelper.bc(i, str)) {
            if (AntiHelper.a(this.cRe.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).Z("obj_locate", at.a.LOCATE_REPLY_SUB_PB));
            }
        } else if (i == 230277 || i == 230278) {
            uZ(str);
        } else {
            aGW().showToast(str);
        }
    }

    public TbPageContext<?> aGW() {
        return this.cRe;
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.mPostContent = "";
        this.heu = null;
        this.duQ = false;
        this.duj = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.dug = null;
        this.dut = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, z zVar, WriteData writeData, AntiData antiData) {
                if (a.this.duR != null) {
                    a.this.duR.callback(z, postWriteCallBackData, zVar, writeData, antiData);
                }
                if (z) {
                    a.this.mPostContent = null;
                    a.this.gC(true);
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    a.this.duf.d((WriteData) null);
                    a.this.duf.sO(false);
                    a.this.writeImagesInfo.clear();
                    a.this.aMS();
                    a.this.aLV().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.bc(i, str)) {
                    a.this.R(i, str);
                } else if (zVar != null && writeData != null && !StringUtils.isNull(zVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(zVar.getVcode_md5());
                    writeData.setVcodeUrl(zVar.getVcode_pic_url());
                    writeData.setVcodeExtra(zVar.aHl());
                    if (com.baidu.tbadk.s.a.vG(zVar.aHk())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.aGW().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, zVar.aHk())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.aGW().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.cRe.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    a.this.aGW().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).Z("obj_locate", at.a.LOCATE_REPLY_SUB_PB));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).Z("obj_locate", at.a.LOCATE_REPLY_SUB_PB));
            }
        };
        this.duu = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.4
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Bitmap) {
                    a.this.duf.sO(true);
                }
            }
        };
        this.duU = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(a.this.duj)) {
                    l.showToast(a.this.aGW().getPageActivity(), a.this.duj);
                }
            }
        };
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.cRe = tbPageContext;
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        if (baseActivity != null) {
            this.duf = new NewWriteModel(baseActivity);
            this.duf.b(this.dut);
            this.dug = new ImageModel(baseActivity.getPageContext());
            this.dug.setLoadDataCallBack(this.duu);
            if (bundle != null) {
                this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
                this.dud = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            }
            if (this.writeImagesInfo != null) {
                this.writeImagesInfo.setMaxImagesAllowed(9);
            }
            if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                aLV().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
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
                        aLV().invalidate();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_IMAGE_VIEW /* 12003 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("delete", false)) {
                            aMG();
                            this.duf.sO(false);
                            return;
                        }
                        this.dug.uS(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        E(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    PostWriteCallBackData postWriteCallBackData2 = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (this.duR != null) {
                        this.mPostContent = null;
                        gC(true);
                        this.duf.d((WriteData) null);
                        this.duf.sO(false);
                        this.writeImagesInfo.clear();
                        aMS();
                        aLV().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                        this.duR.callback(true, postWriteCallBackData2, null, this.duf.cGm(), null);
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
                        this.dut.callback(true, postWriteCallBackData, null, null, null);
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
                    if (this.duR != null) {
                        this.duR.callback(false, postWriteCallBackData3, null, this.duf.cGm(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void T(Intent intent) {
        this.dud = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.dud;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.cRe.getPageActivity(), l.getEquipmentWidth(this.cRe.getPageActivity())), l.dip2px(this.cRe.getPageActivity(), l.getEquipmentHeight(this.cRe.getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    m.a("cameras", this.dud, rotateBitmapBydegree, 100);
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
                bNP();
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
                bNP();
            }
        }
    }

    private void bNP() {
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.cRe.getPageActivity(), 9, "0", null, null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0);
        writeActivityConfig.setTopicId(String.valueOf(this.hev));
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

    public void aMQ() {
        if (this.duf.cGm() == null) {
            this.duf.d(new WriteData());
        }
        if (this.duf.cGm() != null) {
            this.duf.cGm().setForumId("0");
            this.duf.cGm().setType(9);
            this.duf.cGm().setEntranceType(1);
            this.duf.cGm().setCanNoForum(true);
            this.duf.cGm().setTransmitForumData("[]");
            this.duf.cGm().setCallFrom("1");
            this.duf.cGm().setTopicId(String.valueOf(this.hev));
            this.duf.cGm().setContent(this.mPostContent);
            this.duf.cGm().setIsNoTitle(true);
            this.duf.cGm().setTitle("");
            this.duf.cGm().setVoice(null);
            this.duf.cGm().setVoiceDuringTime(-1);
            if (!this.duf.cKN()) {
                aGW().showToast((int) R.string.write_img_limit);
            } else if (this.dun == null || !this.dun.aMs()) {
                if (this.dum != null) {
                    this.dum.aMt();
                }
                if (!this.duf.cKK()) {
                }
            }
        }
    }

    private void V(Intent intent) {
        b(intent, true);
    }

    public long bNQ() {
        return this.hev;
    }

    private void aMG() {
        if (aLV() != null) {
            aLV().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    public void onDestory() {
        this.duf.cancelLoadData();
    }

    public void aMR() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.mPostContent);
        writeData.setTopicId(String.valueOf(this.hev));
        writeData.setWriteImagesInfo(this.writeImagesInfo);
        v.b(String.valueOf(this.hev), writeData);
    }

    public void bNR() {
        v.d(String.valueOf(this.hev), new v.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.5
            @Override // com.baidu.tieba.tbadkCore.v.a
            public void a(WriteData writeData) {
                if (writeData != null) {
                    if (writeData.getWriteImagesInfo() != null && a.this.writeImagesInfo.size() == 0) {
                        a.this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                        if (a.this.writeImagesInfo != null && a.this.writeImagesInfo.getChosedFiles() != null && a.this.writeImagesInfo.getChosedFiles().size() > 0) {
                            a.this.aLV().b(new com.baidu.tbadk.editortools.a(2, 10, a.this.writeImagesInfo.getChosedFiles().size() + ""));
                        }
                    }
                    if (a.this.writeImagesInfo == null || a.this.writeImagesInfo.size() == 0) {
                        a.this.aLV().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                    }
                    if (!aq.isEmpty(writeData.getContent()) && aq.isEmpty(a.this.mPostContent)) {
                        a.this.mPostContent = writeData.getContent();
                        a.this.uX(a.this.mPostContent);
                    }
                }
            }
        });
    }

    public void aMS() {
        v.b(String.valueOf(this.hev), (WriteData) null);
    }

    private void E(ArrayList<String> arrayList) {
        if (aLV() != null) {
            aLV().b(new com.baidu.tbadk.editortools.a(17, 29, arrayList));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uX(String str) {
        if (aLV() != null) {
            aLV().b(new com.baidu.tbadk.editortools.a(6, 29, str));
        }
    }

    public void uV(String str) {
        this.mPostContent = str;
    }

    public void gD(boolean z) {
        this.duQ = z;
    }

    public void aMU() {
        gD(false);
        aLV().hide();
    }

    public void aMX() {
        gD(true);
        aLV().display();
    }

    public void b(NewWriteModel.d dVar) {
        this.duR = dVar;
    }

    public void a(com.baidu.tbadk.editortools.pb.b bVar) {
        this.dun = bVar;
    }

    public c bNS() {
        if (this.hew == null && aLV() != null) {
            this.hew = (c) aLV().lX(29);
        }
        return this.hew;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public void setTopicId(long j) {
        this.hev = j;
    }
}
