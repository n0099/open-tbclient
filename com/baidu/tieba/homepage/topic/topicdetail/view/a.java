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
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.x;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.ImageModel;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a extends com.baidu.tbadk.editortools.d {
    private boolean ckV;
    private NewWriteModel.d ckW;
    private View.OnClickListener ckZ;
    private String cke;
    private String ckf;
    private NewWriteModel ckh;
    private ImageModel cki;
    private String ckl;
    private com.baidu.tbadk.editortools.pb.c cko;
    private com.baidu.tbadk.editortools.pb.b ckp;
    private NewWriteModel.d ckv;
    private final com.baidu.adp.base.d ckw;
    private String fOB;
    private long fOC;
    private c fOD;
    private TbPageContext<?> mContext;
    private AntiHelper.a mInjectListener;
    private WriteImagesInfo writeImagesInfo;

    /* JADX INFO: Access modifiers changed from: private */
    public void eP(boolean z) {
        if (alP() != null) {
            alP().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void oX(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(agg().getPageActivity());
        aVar.lz(str);
        aVar.b(d.j.know, new a.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(agg()).aaW();
    }

    public void C(int i, String str) {
        if (AntiHelper.aD(i, str)) {
            if (AntiHelper.a(this.mContext.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new am("c12534").T("obj_locate", at.a.bLp));
            }
        } else if (i == 230277 || i == 230278) {
            oX(str);
        } else {
            agg().showToast(str);
        }
    }

    public TbPageContext<?> agg() {
        return this.mContext;
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.cke = "";
        this.fOB = null;
        this.ckV = false;
        this.ckl = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.cki = null;
        this.ckv = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
                if (a.this.ckW != null) {
                    a.this.ckW.callback(z, postWriteCallBackData, xVar, writeData, antiData);
                }
                if (z) {
                    a.this.cke = null;
                    a.this.eP(true);
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    a.this.ckh.setWriteData(null);
                    a.this.ckh.qd(false);
                    a.this.writeImagesInfo.clear();
                    a.this.amK();
                    a.this.alP().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.aD(i, str)) {
                    a.this.C(i, str);
                } else if (xVar != null && writeData != null && !StringUtils.isNull(xVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(xVar.getVcode_md5());
                    writeData.setVcodeUrl(xVar.getVcode_pic_url());
                    writeData.setVcodeExtra(xVar.agB());
                    if (com.baidu.tbadk.u.a.pU(xVar.agA())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.agg().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, xVar.agA())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.agg().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    a.this.agg().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12536").T("obj_locate", at.a.bLp));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12535").T("obj_locate", at.a.bLp));
            }
        };
        this.ckw = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.4
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (obj instanceof Bitmap) {
                    a.this.ckh.qd(true);
                }
            }
        };
        this.ckZ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(a.this.ckl)) {
                    l.showToast(a.this.agg().getPageActivity(), a.this.ckl);
                }
            }
        };
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        if (baseActivity != null) {
            this.ckh = new NewWriteModel(baseActivity);
            this.ckh.b(this.ckv);
            this.cki = new ImageModel(baseActivity);
            this.cki.setLoadDataCallBack(this.ckw);
            if (bundle != null) {
                this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
                this.ckf = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            }
            if (this.writeImagesInfo != null) {
                this.writeImagesInfo.setMaxImagesAllowed(9);
            }
            if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                alP().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        ArrayList<String> stringArrayListExtra;
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            O(intent);
                        } else {
                            Q(intent);
                        }
                        alP().invalidate();
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_DEL /* 12003 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            amA();
                            this.ckh.qd(false);
                            return;
                        }
                        this.cki.oP(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        w(stringArrayListExtra);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    PostWriteCallBackData postWriteCallBackData2 = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (this.ckW != null) {
                        this.cke = null;
                        eP(true);
                        this.ckh.setWriteData(null);
                        this.ckh.qd(false);
                        this.writeImagesInfo.clear();
                        amK();
                        alP().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                        this.ckW.callback(true, postWriteCallBackData2, null, this.ckh.getWriteData(), null);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD /* 12009 */:
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    if (i == 12010) {
                        O(intent);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    P(intent);
                    return;
                case 13003:
                    if (intent != null) {
                        try {
                            postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                        } catch (Exception e) {
                            BdLog.e(e);
                            postWriteCallBackData = null;
                        }
                        this.ckv.callback(true, postWriteCallBackData, null, null, null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    PostWriteCallBackData postWriteCallBackData3 = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (this.ckW != null) {
                        this.ckW.callback(false, postWriteCallBackData3, null, this.ckh.getWriteData(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void O(Intent intent) {
        this.ckf = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.ckf;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.mContext.getPageActivity(), l.aO(this.mContext.getPageActivity())), l.dip2px(this.mContext.getPageActivity(), l.aQ(this.mContext.getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    m.a(TbConfig.LOCAL_CAMERA_DIR, this.ckf, rotateBitmapBydegree, 100);
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
                bnf();
            }
        }
    }

    private void P(Intent intent) {
        b(intent, false);
    }

    private void b(Intent intent, boolean z) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                bnf();
            }
        }
    }

    private void bnf() {
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mContext.getPageActivity(), 9, "0", null, null, null, 0, null, 13003, false, false, null, false, false, null, null, null, 0);
        writeActivityConfig.setTopicId(String.valueOf(this.fOC));
        writeActivityConfig.getIntent().putExtra("from", "topic_detail");
        writeActivityConfig.setCallFrom("1");
        if (!StringUtils.isNull(this.cke)) {
            writeActivityConfig.setContent(this.cke);
        }
        writeActivityConfig.setForumLevel(-1);
        writeActivityConfig.setForumAvatar(null);
        writeActivityConfig.setPrivateThread(0);
        writeActivityConfig.setForumDir("", "");
        writeActivityConfig.setWriteImagesInfo(this.writeImagesInfo);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
    }

    public void amI() {
        if (this.ckh.getWriteData() == null) {
            this.ckh.setWriteData(new WriteData());
        }
        if (this.ckh.getWriteData() != null) {
            this.ckh.getWriteData().setForumId("0");
            this.ckh.getWriteData().setType(9);
            this.ckh.getWriteData().setEntranceType(1);
            this.ckh.getWriteData().setCanNoForum(true);
            this.ckh.getWriteData().setTransmitForumData("[]");
            this.ckh.getWriteData().setCallFrom("1");
            this.ckh.getWriteData().setTopicId(String.valueOf(this.fOC));
            this.ckh.getWriteData().setContent(this.cke);
            this.ckh.getWriteData().setIsNoTitle(true);
            this.ckh.getWriteData().setTitle("");
            this.ckh.getWriteData().setVoice(null);
            this.ckh.getWriteData().setVoiceDuringTime(-1);
            if (!this.ckh.cfB()) {
                agg().showToast(d.j.write_img_limit);
            } else if (this.ckp == null || !this.ckp.amn()) {
                if (this.cko != null) {
                    this.cko.amo();
                }
                if (!this.ckh.startPostWrite()) {
                }
            }
        }
    }

    private void Q(Intent intent) {
        b(intent, true);
    }

    public long bng() {
        return this.fOC;
    }

    private void amA() {
        if (alP() != null) {
            alP().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    public void onDestory() {
        this.ckh.cancelLoadData();
    }

    public void amJ() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.cke);
        writeData.setTopicId(String.valueOf(this.fOC));
        writeData.setWriteImagesInfo(this.writeImagesInfo);
        t.b(String.valueOf(this.fOC), writeData);
    }

    public void bnh() {
        t.d(String.valueOf(this.fOC), new t.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.5
            @Override // com.baidu.tieba.tbadkCore.t.a
            public void a(WriteData writeData) {
                if (writeData != null) {
                    if (writeData.getWriteImagesInfo() != null && a.this.writeImagesInfo.size() == 0) {
                        a.this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                        if (a.this.writeImagesInfo != null && a.this.writeImagesInfo.getChosedFiles() != null && a.this.writeImagesInfo.getChosedFiles().size() > 0) {
                            a.this.alP().b(new com.baidu.tbadk.editortools.a(2, 10, a.this.writeImagesInfo.getChosedFiles().size() + ""));
                        }
                    }
                    if (a.this.writeImagesInfo == null || a.this.writeImagesInfo.size() == 0) {
                        a.this.alP().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                    }
                    if (!ap.isEmpty(writeData.getContent()) && ap.isEmpty(a.this.cke)) {
                        a.this.cke = writeData.getContent();
                        a.this.oV(a.this.cke);
                    }
                }
            }
        });
    }

    public void amK() {
        t.b(String.valueOf(this.fOC), (WriteData) null);
    }

    private void w(ArrayList<String> arrayList) {
        if (alP() != null) {
            alP().b(new com.baidu.tbadk.editortools.a(17, 29, arrayList));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oV(String str) {
        if (alP() != null) {
            alP().b(new com.baidu.tbadk.editortools.a(6, 29, str));
        }
    }

    public void oT(String str) {
        this.cke = str;
    }

    public void eQ(boolean z) {
        this.ckV = z;
    }

    public void amM() {
        eQ(false);
        alP().hide();
    }

    public void amP() {
        eQ(true);
        alP().qT();
    }

    public void b(NewWriteModel.d dVar) {
        this.ckW = dVar;
    }

    public void a(com.baidu.tbadk.editortools.pb.b bVar) {
        this.ckp = bVar;
    }

    public c bni() {
        if (this.fOD == null && alP() != null) {
            this.fOD = (c) alP().jv(29);
        }
        return this.fOD;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public void setTopicId(long j) {
        this.fOC = j;
    }
}
