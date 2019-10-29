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
    private String cGN;
    private String cGO;
    private NewWriteModel cGQ;
    private ImageModel cGR;
    private String cGV;
    private com.baidu.tbadk.editortools.pb.c cGY;
    private com.baidu.tbadk.editortools.pb.b cGZ;
    private boolean cHF;
    private NewWriteModel.d cHG;
    private View.OnClickListener cHJ;
    private NewWriteModel.d cHf;
    private final com.baidu.adp.base.d cHg;
    private TbPageContext<?> cfl;
    private String goh;
    private long goi;
    private c goj;
    private AntiHelper.a mInjectListener;
    private WriteImagesInfo writeImagesInfo;

    /* JADX INFO: Access modifiers changed from: private */
    public void fm(boolean z) {
        if (atZ() != null) {
            atZ().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void pP(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(apd().getPageActivity());
        aVar.nn(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(apd()).akO();
    }

    public void I(int i, String str) {
        if (AntiHelper.aH(i, str)) {
            if (AntiHelper.a(this.cfl.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).O("obj_locate", at.a.LOCATE_REPLY_SUB_PB));
            }
        } else if (i == 230277 || i == 230278) {
            pP(str);
        } else {
            apd().showToast(str);
        }
    }

    public TbPageContext<?> apd() {
        return this.cfl;
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.cGN = "";
        this.goh = null;
        this.cHF = false;
        this.cGV = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.cGR = null;
        this.cHf = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
                if (a.this.cHG != null) {
                    a.this.cHG.callback(z, postWriteCallBackData, yVar, writeData, antiData);
                }
                if (z) {
                    a.this.cGN = null;
                    a.this.fm(true);
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    a.this.cGQ.d((WriteData) null);
                    a.this.cGQ.qV(false);
                    a.this.writeImagesInfo.clear();
                    a.this.auT();
                    a.this.atZ().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.aH(i, str)) {
                    a.this.I(i, str);
                } else if (yVar != null && writeData != null && !StringUtils.isNull(yVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(yVar.getVcode_md5());
                    writeData.setVcodeUrl(yVar.getVcode_pic_url());
                    writeData.setVcodeExtra(yVar.apu());
                    if (com.baidu.tbadk.v.a.qv(yVar.apt())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.apd().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, yVar.apt())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.apd().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.cfl.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    a.this.apd().showToast(str);
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
        this.cHg = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.4
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Bitmap) {
                    a.this.cGQ.qV(true);
                }
            }
        };
        this.cHJ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(a.this.cGV)) {
                    l.showToast(a.this.apd().getPageActivity(), a.this.cGV);
                }
            }
        };
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.cfl = tbPageContext;
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        if (baseActivity != null) {
            this.cGQ = new NewWriteModel(baseActivity);
            this.cGQ.b(this.cHf);
            this.cGR = new ImageModel(baseActivity);
            this.cGR.setLoadDataCallBack(this.cHg);
            if (bundle != null) {
                this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
                this.cGO = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            }
            if (this.writeImagesInfo != null) {
                this.writeImagesInfo.setMaxImagesAllowed(9);
            }
            if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                atZ().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
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
                        atZ().invalidate();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_IMAGE_VIEW /* 12003 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("delete", false)) {
                            auJ();
                            this.cGQ.qV(false);
                            return;
                        }
                        this.cGR.pH(intent.getStringExtra("file_name"));
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
                    if (this.cHG != null) {
                        this.cGN = null;
                        fm(true);
                        this.cGQ.d((WriteData) null);
                        this.cGQ.qV(false);
                        this.writeImagesInfo.clear();
                        auT();
                        atZ().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                        this.cHG.callback(true, postWriteCallBackData2, null, this.cGQ.clc(), null);
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
                        this.cHf.callback(true, postWriteCallBackData, null, null, null);
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
                    if (this.cHG != null) {
                        this.cHG.callback(false, postWriteCallBackData3, null, this.cGQ.clc(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void W(Intent intent) {
        this.cGO = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.cGO;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.cfl.getPageActivity(), l.getEquipmentWidth(this.cfl.getPageActivity())), l.dip2px(this.cfl.getPageActivity(), l.getEquipmentHeight(this.cfl.getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    m.a("cameras", this.cGO, rotateBitmapBydegree, 100);
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
                bvv();
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
                bvv();
            }
        }
    }

    private void bvv() {
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.cfl.getPageActivity(), 9, "0", null, null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0);
        writeActivityConfig.setTopicId(String.valueOf(this.goi));
        writeActivityConfig.getIntent().putExtra("from", "topic_detail");
        writeActivityConfig.setCallFrom("1");
        if (!StringUtils.isNull(this.cGN)) {
            writeActivityConfig.setContent(this.cGN);
        }
        writeActivityConfig.setForumLevel(-1);
        writeActivityConfig.setForumAvatar(null);
        writeActivityConfig.setPrivateThread(0);
        writeActivityConfig.setForumDir("", "");
        writeActivityConfig.setWriteImagesInfo(this.writeImagesInfo);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
    }

    public void auR() {
        if (this.cGQ.clc() == null) {
            this.cGQ.d(new WriteData());
        }
        if (this.cGQ.clc() != null) {
            this.cGQ.clc().setForumId("0");
            this.cGQ.clc().setType(9);
            this.cGQ.clc().setEntranceType(1);
            this.cGQ.clc().setCanNoForum(true);
            this.cGQ.clc().setTransmitForumData("[]");
            this.cGQ.clc().setCallFrom("1");
            this.cGQ.clc().setTopicId(String.valueOf(this.goi));
            this.cGQ.clc().setContent(this.cGN);
            this.cGQ.clc().setIsNoTitle(true);
            this.cGQ.clc().setTitle("");
            this.cGQ.clc().setVoice(null);
            this.cGQ.clc().setVoiceDuringTime(-1);
            if (!this.cGQ.cpH()) {
                apd().showToast((int) R.string.write_img_limit);
            } else if (this.cGZ == null || !this.cGZ.auw()) {
                if (this.cGY != null) {
                    this.cGY.aux();
                }
                if (!this.cGQ.cpE()) {
                }
            }
        }
    }

    private void Y(Intent intent) {
        b(intent, true);
    }

    public long bvw() {
        return this.goi;
    }

    private void auJ() {
        if (atZ() != null) {
            atZ().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    public void onDestory() {
        this.cGQ.cancelLoadData();
    }

    public void auS() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.cGN);
        writeData.setTopicId(String.valueOf(this.goi));
        writeData.setWriteImagesInfo(this.writeImagesInfo);
        v.b(String.valueOf(this.goi), writeData);
    }

    public void bvx() {
        v.d(String.valueOf(this.goi), new v.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.5
            @Override // com.baidu.tieba.tbadkCore.v.a
            public void a(WriteData writeData) {
                if (writeData != null) {
                    if (writeData.getWriteImagesInfo() != null && a.this.writeImagesInfo.size() == 0) {
                        a.this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                        if (a.this.writeImagesInfo != null && a.this.writeImagesInfo.getChosedFiles() != null && a.this.writeImagesInfo.getChosedFiles().size() > 0) {
                            a.this.atZ().b(new com.baidu.tbadk.editortools.a(2, 10, a.this.writeImagesInfo.getChosedFiles().size() + ""));
                        }
                    }
                    if (a.this.writeImagesInfo == null || a.this.writeImagesInfo.size() == 0) {
                        a.this.atZ().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                    }
                    if (!aq.isEmpty(writeData.getContent()) && aq.isEmpty(a.this.cGN)) {
                        a.this.cGN = writeData.getContent();
                        a.this.pN(a.this.cGN);
                    }
                }
            }
        });
    }

    public void auT() {
        v.b(String.valueOf(this.goi), (WriteData) null);
    }

    private void B(ArrayList<String> arrayList) {
        if (atZ() != null) {
            atZ().b(new com.baidu.tbadk.editortools.a(17, 29, arrayList));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pN(String str) {
        if (atZ() != null) {
            atZ().b(new com.baidu.tbadk.editortools.a(6, 29, str));
        }
    }

    public void pL(String str) {
        this.cGN = str;
    }

    public void fn(boolean z) {
        this.cHF = z;
    }

    public void auV() {
        fn(false);
        atZ().hide();
    }

    public void auY() {
        fn(true);
        atZ().le();
    }

    public void b(NewWriteModel.d dVar) {
        this.cHG = dVar;
    }

    public void a(com.baidu.tbadk.editortools.pb.b bVar) {
        this.cGZ = bVar;
    }

    public c bvy() {
        if (this.goj == null && atZ() != null) {
            this.goj = (c) atZ().jL(29);
        }
        return this.goj;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public void setTopicId(long j) {
        this.goi = j;
    }
}
