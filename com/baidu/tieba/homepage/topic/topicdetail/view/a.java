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
import com.baidu.tbadk.coreExtra.data.y;
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
/* loaded from: classes4.dex */
public class a extends com.baidu.tbadk.editortools.d {
    private String cFW;
    private String cFX;
    private NewWriteModel cFZ;
    private boolean cGO;
    private NewWriteModel.d cGP;
    private View.OnClickListener cGS;
    private ImageModel cGa;
    private String cGe;
    private com.baidu.tbadk.editortools.pb.c cGh;
    private com.baidu.tbadk.editortools.pb.b cGi;
    private NewWriteModel.d cGo;
    private final com.baidu.adp.base.d cGp;
    private TbPageContext<?> ceu;
    private String gnq;
    private long gnr;
    private c gns;
    private AntiHelper.a mInjectListener;
    private WriteImagesInfo writeImagesInfo;

    /* JADX INFO: Access modifiers changed from: private */
    public void fm(boolean z) {
        if (atX() != null) {
            atX().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void pP(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(apb().getPageActivity());
        aVar.nn(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(apb()).akM();
    }

    public void H(int i, String str) {
        if (AntiHelper.aG(i, str)) {
            if (AntiHelper.a(this.ceu.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).O("obj_locate", at.a.LOCATE_REPLY_SUB_PB));
            }
        } else if (i == 230277 || i == 230278) {
            pP(str);
        } else {
            apb().showToast(str);
        }
    }

    public TbPageContext<?> apb() {
        return this.ceu;
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.cFW = "";
        this.gnq = null;
        this.cGO = false;
        this.cGe = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.cGa = null;
        this.cGo = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
                if (a.this.cGP != null) {
                    a.this.cGP.callback(z, postWriteCallBackData, yVar, writeData, antiData);
                }
                if (z) {
                    a.this.cFW = null;
                    a.this.fm(true);
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    a.this.cFZ.d((WriteData) null);
                    a.this.cFZ.qV(false);
                    a.this.writeImagesInfo.clear();
                    a.this.auR();
                    a.this.atX().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.aG(i, str)) {
                    a.this.H(i, str);
                } else if (yVar != null && writeData != null && !StringUtils.isNull(yVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(yVar.getVcode_md5());
                    writeData.setVcodeUrl(yVar.getVcode_pic_url());
                    writeData.setVcodeExtra(yVar.aps());
                    if (com.baidu.tbadk.v.a.qv(yVar.apr())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.apb().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, yVar.apr())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.apb().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.ceu.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    a.this.apb().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).O("obj_locate", at.a.LOCATE_REPLY_SUB_PB));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).O("obj_locate", at.a.LOCATE_REPLY_SUB_PB));
            }
        };
        this.cGp = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.4
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Bitmap) {
                    a.this.cFZ.qV(true);
                }
            }
        };
        this.cGS = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(a.this.cGe)) {
                    l.showToast(a.this.apb().getPageActivity(), a.this.cGe);
                }
            }
        };
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.ceu = tbPageContext;
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        if (baseActivity != null) {
            this.cFZ = new NewWriteModel(baseActivity);
            this.cFZ.b(this.cGo);
            this.cGa = new ImageModel(baseActivity);
            this.cGa.setLoadDataCallBack(this.cGp);
            if (bundle != null) {
                this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
                this.cFX = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            }
            if (this.writeImagesInfo != null) {
                this.writeImagesInfo.setMaxImagesAllowed(9);
            }
            if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                atX().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
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
                            W(intent);
                        } else {
                            Y(intent);
                        }
                        atX().invalidate();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_IMAGE_VIEW /* 12003 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("delete", false)) {
                            auH();
                            this.cFZ.qV(false);
                            return;
                        }
                        this.cGa.pH(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        B(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    PostWriteCallBackData postWriteCallBackData2 = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (this.cGP != null) {
                        this.cFW = null;
                        fm(true);
                        this.cFZ.d((WriteData) null);
                        this.cFZ.qV(false);
                        this.writeImagesInfo.clear();
                        auR();
                        atX().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                        this.cGP.callback(true, postWriteCallBackData2, null, this.cFZ.cla(), null);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    if (i == 12010) {
                        W(intent);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    X(intent);
                    return;
                case RequestResponseCode.REQUEST_WRITE_NEW /* 13003 */:
                    if (intent != null) {
                        try {
                            postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                        } catch (Exception e) {
                            BdLog.e(e);
                            postWriteCallBackData = null;
                        }
                        this.cGo.callback(true, postWriteCallBackData, null, null, null);
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
                    if (this.cGP != null) {
                        this.cGP.callback(false, postWriteCallBackData3, null, this.cFZ.cla(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void W(Intent intent) {
        this.cFX = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.cFX;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.ceu.getPageActivity(), l.getEquipmentWidth(this.ceu.getPageActivity())), l.dip2px(this.ceu.getPageActivity(), l.getEquipmentHeight(this.ceu.getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    m.a("cameras", this.cFX, rotateBitmapBydegree, 100);
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
                bvt();
            }
        }
    }

    private void X(Intent intent) {
        b(intent, false);
    }

    private void b(Intent intent, boolean z) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                bvt();
            }
        }
    }

    private void bvt() {
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.ceu.getPageActivity(), 9, "0", null, null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0);
        writeActivityConfig.setTopicId(String.valueOf(this.gnr));
        writeActivityConfig.getIntent().putExtra("from", "topic_detail");
        writeActivityConfig.setCallFrom("1");
        if (!StringUtils.isNull(this.cFW)) {
            writeActivityConfig.setContent(this.cFW);
        }
        writeActivityConfig.setForumLevel(-1);
        writeActivityConfig.setForumAvatar(null);
        writeActivityConfig.setPrivateThread(0);
        writeActivityConfig.setForumDir("", "");
        writeActivityConfig.setWriteImagesInfo(this.writeImagesInfo);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
    }

    public void auP() {
        if (this.cFZ.cla() == null) {
            this.cFZ.d(new WriteData());
        }
        if (this.cFZ.cla() != null) {
            this.cFZ.cla().setForumId("0");
            this.cFZ.cla().setType(9);
            this.cFZ.cla().setEntranceType(1);
            this.cFZ.cla().setCanNoForum(true);
            this.cFZ.cla().setTransmitForumData("[]");
            this.cFZ.cla().setCallFrom("1");
            this.cFZ.cla().setTopicId(String.valueOf(this.gnr));
            this.cFZ.cla().setContent(this.cFW);
            this.cFZ.cla().setIsNoTitle(true);
            this.cFZ.cla().setTitle("");
            this.cFZ.cla().setVoice(null);
            this.cFZ.cla().setVoiceDuringTime(-1);
            if (!this.cFZ.cpF()) {
                apb().showToast((int) R.string.write_img_limit);
            } else if (this.cGi == null || !this.cGi.auu()) {
                if (this.cGh != null) {
                    this.cGh.auv();
                }
                if (!this.cFZ.cpC()) {
                }
            }
        }
    }

    private void Y(Intent intent) {
        b(intent, true);
    }

    public long bvu() {
        return this.gnr;
    }

    private void auH() {
        if (atX() != null) {
            atX().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    public void onDestory() {
        this.cFZ.cancelLoadData();
    }

    public void auQ() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.cFW);
        writeData.setTopicId(String.valueOf(this.gnr));
        writeData.setWriteImagesInfo(this.writeImagesInfo);
        v.b(String.valueOf(this.gnr), writeData);
    }

    public void bvv() {
        v.d(String.valueOf(this.gnr), new v.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.5
            @Override // com.baidu.tieba.tbadkCore.v.a
            public void a(WriteData writeData) {
                if (writeData != null) {
                    if (writeData.getWriteImagesInfo() != null && a.this.writeImagesInfo.size() == 0) {
                        a.this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                        if (a.this.writeImagesInfo != null && a.this.writeImagesInfo.getChosedFiles() != null && a.this.writeImagesInfo.getChosedFiles().size() > 0) {
                            a.this.atX().b(new com.baidu.tbadk.editortools.a(2, 10, a.this.writeImagesInfo.getChosedFiles().size() + ""));
                        }
                    }
                    if (a.this.writeImagesInfo == null || a.this.writeImagesInfo.size() == 0) {
                        a.this.atX().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                    }
                    if (!aq.isEmpty(writeData.getContent()) && aq.isEmpty(a.this.cFW)) {
                        a.this.cFW = writeData.getContent();
                        a.this.pN(a.this.cFW);
                    }
                }
            }
        });
    }

    public void auR() {
        v.b(String.valueOf(this.gnr), (WriteData) null);
    }

    private void B(ArrayList<String> arrayList) {
        if (atX() != null) {
            atX().b(new com.baidu.tbadk.editortools.a(17, 29, arrayList));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pN(String str) {
        if (atX() != null) {
            atX().b(new com.baidu.tbadk.editortools.a(6, 29, str));
        }
    }

    public void pL(String str) {
        this.cFW = str;
    }

    public void fn(boolean z) {
        this.cGO = z;
    }

    public void auT() {
        fn(false);
        atX().hide();
    }

    public void auW() {
        fn(true);
        atX().le();
    }

    public void b(NewWriteModel.d dVar) {
        this.cGP = dVar;
    }

    public void a(com.baidu.tbadk.editortools.pb.b bVar) {
        this.cGi = bVar;
    }

    public c bvw() {
        if (this.gns == null && atX() != null) {
            this.gns = (c) atX().jK(29);
        }
        return this.gns;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public void setTopicId(long j) {
        this.gnr = j;
    }
}
