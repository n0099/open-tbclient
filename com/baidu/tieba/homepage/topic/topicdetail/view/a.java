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
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a extends com.baidu.tbadk.editortools.d {
    private NewWriteModel.d csE;
    private final com.baidu.adp.base.d csF;
    private String csn;
    private String cso;
    private NewWriteModel csq;
    private ImageModel csr;
    private String csu;
    private com.baidu.tbadk.editortools.pb.c csx;
    private com.baidu.tbadk.editortools.pb.b csy;
    private boolean cte;
    private NewWriteModel.d ctf;
    private View.OnClickListener cti;
    private String gfL;
    private long gfM;
    private c gfN;
    private TbPageContext<?> mContext;
    private AntiHelper.a mInjectListener;
    private WriteImagesInfo writeImagesInfo;

    /* JADX INFO: Access modifiers changed from: private */
    public void fl(boolean z) {
        if (aqS() != null) {
            aqS().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void qe(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(alf().getPageActivity());
        aVar.mD(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(alf()).afG();
    }

    public void F(int i, String str) {
        if (AntiHelper.aG(i, str)) {
            if (AntiHelper.a(this.mContext.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new am("c12534").P("obj_locate", at.a.bTc));
            }
        } else if (i == 230277 || i == 230278) {
            qe(str);
        } else {
            alf().showToast(str);
        }
    }

    public TbPageContext<?> alf() {
        return this.mContext;
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.csn = "";
        this.gfL = null;
        this.cte = false;
        this.csu = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.csr = null;
        this.csE = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
                if (a.this.ctf != null) {
                    a.this.ctf.callback(z, postWriteCallBackData, xVar, writeData, antiData);
                }
                if (z) {
                    a.this.csn = null;
                    a.this.fl(true);
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    a.this.csq.setWriteData(null);
                    a.this.csq.qT(false);
                    a.this.writeImagesInfo.clear();
                    a.this.arN();
                    a.this.aqS().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.aG(i, str)) {
                    a.this.F(i, str);
                } else if (xVar != null && writeData != null && !StringUtils.isNull(xVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(xVar.getVcode_md5());
                    writeData.setVcodeUrl(xVar.getVcode_pic_url());
                    writeData.setVcodeExtra(xVar.alA());
                    if (com.baidu.tbadk.v.a.rc(xVar.alz())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.alf().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, xVar.alz())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.alf().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    a.this.alf().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12536").P("obj_locate", at.a.bTc));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12535").P("obj_locate", at.a.bTc));
            }
        };
        this.csF = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.4
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (obj instanceof Bitmap) {
                    a.this.csq.qT(true);
                }
            }
        };
        this.cti = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(a.this.csu)) {
                    l.showToast(a.this.alf().getPageActivity(), a.this.csu);
                }
            }
        };
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        if (baseActivity != null) {
            this.csq = new NewWriteModel(baseActivity);
            this.csq.b(this.csE);
            this.csr = new ImageModel(baseActivity);
            this.csr.setLoadDataCallBack(this.csF);
            if (bundle != null) {
                this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
                this.cso = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            }
            if (this.writeImagesInfo != null) {
                this.writeImagesInfo.setMaxImagesAllowed(9);
            }
            if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                aqS().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
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
                        aqS().invalidate();
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_DEL /* 12003 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            arD();
                            this.csq.qT(false);
                            return;
                        }
                        this.csr.pW(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        z(stringArrayListExtra);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    PostWriteCallBackData postWriteCallBackData2 = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (this.ctf != null) {
                        this.csn = null;
                        fl(true);
                        this.csq.setWriteData(null);
                        this.csq.qT(false);
                        this.writeImagesInfo.clear();
                        arN();
                        aqS().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                        this.ctf.callback(true, postWriteCallBackData2, null, this.csq.getWriteData(), null);
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
                        this.csE.callback(true, postWriteCallBackData, null, null, null);
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
                    if (this.ctf != null) {
                        this.ctf.callback(false, postWriteCallBackData3, null, this.csq.getWriteData(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void O(Intent intent) {
        this.cso = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.cso;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.mContext.getPageActivity(), l.af(this.mContext.getPageActivity())), l.dip2px(this.mContext.getPageActivity(), l.ah(this.mContext.getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    m.a(TbConfig.LOCAL_CAMERA_DIR, this.cso, rotateBitmapBydegree, 100);
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
                buL();
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
                buL();
            }
        }
    }

    private void buL() {
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mContext.getPageActivity(), 9, "0", null, null, null, 0, null, 13003, false, false, null, false, false, null, null, null, 0);
        writeActivityConfig.setTopicId(String.valueOf(this.gfM));
        writeActivityConfig.getIntent().putExtra("from", "topic_detail");
        writeActivityConfig.setCallFrom("1");
        if (!StringUtils.isNull(this.csn)) {
            writeActivityConfig.setContent(this.csn);
        }
        writeActivityConfig.setForumLevel(-1);
        writeActivityConfig.setForumAvatar(null);
        writeActivityConfig.setPrivateThread(0);
        writeActivityConfig.setForumDir("", "");
        writeActivityConfig.setWriteImagesInfo(this.writeImagesInfo);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
    }

    public void arL() {
        if (this.csq.getWriteData() == null) {
            this.csq.setWriteData(new WriteData());
        }
        if (this.csq.getWriteData() != null) {
            this.csq.getWriteData().setForumId("0");
            this.csq.getWriteData().setType(9);
            this.csq.getWriteData().setEntranceType(1);
            this.csq.getWriteData().setCanNoForum(true);
            this.csq.getWriteData().setTransmitForumData("[]");
            this.csq.getWriteData().setCallFrom("1");
            this.csq.getWriteData().setTopicId(String.valueOf(this.gfM));
            this.csq.getWriteData().setContent(this.csn);
            this.csq.getWriteData().setIsNoTitle(true);
            this.csq.getWriteData().setTitle("");
            this.csq.getWriteData().setVoice(null);
            this.csq.getWriteData().setVoiceDuringTime(-1);
            if (!this.csq.cnI()) {
                alf().showToast((int) R.string.write_img_limit);
            } else if (this.csy == null || !this.csy.arq()) {
                if (this.csx != null) {
                    this.csx.arr();
                }
                if (!this.csq.startPostWrite()) {
                }
            }
        }
    }

    private void Q(Intent intent) {
        b(intent, true);
    }

    public long buM() {
        return this.gfM;
    }

    private void arD() {
        if (aqS() != null) {
            aqS().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    public void onDestory() {
        this.csq.cancelLoadData();
    }

    public void arM() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.csn);
        writeData.setTopicId(String.valueOf(this.gfM));
        writeData.setWriteImagesInfo(this.writeImagesInfo);
        t.b(String.valueOf(this.gfM), writeData);
    }

    public void buN() {
        t.d(String.valueOf(this.gfM), new t.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.5
            @Override // com.baidu.tieba.tbadkCore.t.a
            public void a(WriteData writeData) {
                if (writeData != null) {
                    if (writeData.getWriteImagesInfo() != null && a.this.writeImagesInfo.size() == 0) {
                        a.this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                        if (a.this.writeImagesInfo != null && a.this.writeImagesInfo.getChosedFiles() != null && a.this.writeImagesInfo.getChosedFiles().size() > 0) {
                            a.this.aqS().b(new com.baidu.tbadk.editortools.a(2, 10, a.this.writeImagesInfo.getChosedFiles().size() + ""));
                        }
                    }
                    if (a.this.writeImagesInfo == null || a.this.writeImagesInfo.size() == 0) {
                        a.this.aqS().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                    }
                    if (!ap.isEmpty(writeData.getContent()) && ap.isEmpty(a.this.csn)) {
                        a.this.csn = writeData.getContent();
                        a.this.qc(a.this.csn);
                    }
                }
            }
        });
    }

    public void arN() {
        t.b(String.valueOf(this.gfM), (WriteData) null);
    }

    private void z(ArrayList<String> arrayList) {
        if (aqS() != null) {
            aqS().b(new com.baidu.tbadk.editortools.a(17, 29, arrayList));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qc(String str) {
        if (aqS() != null) {
            aqS().b(new com.baidu.tbadk.editortools.a(6, 29, str));
        }
    }

    public void qa(String str) {
        this.csn = str;
    }

    public void fm(boolean z) {
        this.cte = z;
    }

    public void arP() {
        fm(false);
        aqS().hide();
    }

    public void arS() {
        fm(true);
        aqS().pO();
    }

    public void b(NewWriteModel.d dVar) {
        this.ctf = dVar;
    }

    public void a(com.baidu.tbadk.editortools.pb.b bVar) {
        this.csy = bVar;
    }

    public c buO() {
        if (this.gfN == null && aqS() != null) {
            this.gfN = (c) aqS().kj(29);
        }
        return this.gfN;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public void setTopicId(long j) {
        this.gfM = j;
    }
}
