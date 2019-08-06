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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.x;
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
    private String ctH;
    private String ctI;
    private NewWriteModel ctK;
    private ImageModel ctL;
    private String ctO;
    private com.baidu.tbadk.editortools.pb.c ctR;
    private com.baidu.tbadk.editortools.pb.b ctS;
    private NewWriteModel.d ctY;
    private final com.baidu.adp.base.d ctZ;
    private NewWriteModel.d cuA;
    private View.OnClickListener cuD;
    private boolean cuz;
    private String gmR;
    private long gmS;
    private c gmT;
    private TbPageContext<?> mContext;
    private AntiHelper.a mInjectListener;
    private WriteImagesInfo writeImagesInfo;

    /* JADX INFO: Access modifiers changed from: private */
    public void fp(boolean z) {
        if (asa() != null) {
            asa().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void qv(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(amm().getPageActivity());
        aVar.mO(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(amm()).agK();
    }

    public void F(int i, String str) {
        if (AntiHelper.aG(i, str)) {
            if (AntiHelper.a(this.mContext.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new an("c12534").P("obj_locate", au.a.bUj));
            }
        } else if (i == 230277 || i == 230278) {
            qv(str);
        } else {
            amm().showToast(str);
        }
    }

    public TbPageContext<?> amm() {
        return this.mContext;
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.ctH = "";
        this.gmR = null;
        this.cuz = false;
        this.ctO = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.ctL = null;
        this.ctY = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
                if (a.this.cuA != null) {
                    a.this.cuA.callback(z, postWriteCallBackData, xVar, writeData, antiData);
                }
                if (z) {
                    a.this.ctH = null;
                    a.this.fp(true);
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    a.this.ctK.setWriteData(null);
                    a.this.ctK.rj(false);
                    a.this.writeImagesInfo.clear();
                    a.this.asV();
                    a.this.asa().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.aG(i, str)) {
                    a.this.F(i, str);
                } else if (xVar != null && writeData != null && !StringUtils.isNull(xVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(xVar.getVcode_md5());
                    writeData.setVcodeUrl(xVar.getVcode_pic_url());
                    writeData.setVcodeExtra(xVar.amH());
                    if (com.baidu.tbadk.v.a.ru(xVar.amG())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.amm().getPageActivity(), 12006, writeData, false, xVar.amG())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.amm().getPageActivity(), writeData, 12006)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.mContext.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    a.this.amm().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an("c12536").P("obj_locate", au.a.bUj));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an("c12535").P("obj_locate", au.a.bUj));
            }
        };
        this.ctZ = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.4
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (obj instanceof Bitmap) {
                    a.this.ctK.rj(true);
                }
            }
        };
        this.cuD = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(a.this.ctO)) {
                    l.showToast(a.this.amm().getPageActivity(), a.this.ctO);
                }
            }
        };
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        if (baseActivity != null) {
            this.ctK = new NewWriteModel(baseActivity);
            this.ctK.b(this.ctY);
            this.ctL = new ImageModel(baseActivity);
            this.ctL.setLoadDataCallBack(this.ctZ);
            if (bundle != null) {
                this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
                this.ctI = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            }
            if (this.writeImagesInfo != null) {
                this.writeImagesInfo.setMaxImagesAllowed(9);
            }
            if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                asa().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        ArrayList<String> stringArrayListExtra;
        if (i2 == -1) {
            switch (i) {
                case 12002:
                    if (intent != null) {
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            Q(intent);
                        } else {
                            S(intent);
                        }
                        asa().invalidate();
                        return;
                    }
                    return;
                case 12003:
                    if (intent != null) {
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            asL();
                            this.ctK.rj(false);
                            return;
                        }
                        this.ctL.qn(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case 12004:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        z(stringArrayListExtra);
                        return;
                    }
                    return;
                case 12006:
                    PostWriteCallBackData postWriteCallBackData2 = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (this.cuA != null) {
                        this.ctH = null;
                        fp(true);
                        this.ctK.setWriteData(null);
                        this.ctK.rj(false);
                        this.writeImagesInfo.clear();
                        asV();
                        asa().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                        this.cuA.callback(true, postWriteCallBackData2, null, this.ctK.getWriteData(), null);
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    if (i == 12010) {
                        Q(intent);
                        return;
                    }
                    return;
                case 12012:
                    R(intent);
                    return;
                case 13003:
                    if (intent != null) {
                        try {
                            postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                        } catch (Exception e) {
                            BdLog.e(e);
                            postWriteCallBackData = null;
                        }
                        this.ctY.callback(true, postWriteCallBackData, null, null, null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12006:
                    PostWriteCallBackData postWriteCallBackData3 = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (this.cuA != null) {
                        this.cuA.callback(false, postWriteCallBackData3, null, this.ctK.getWriteData(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void Q(Intent intent) {
        this.ctI = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.ctI;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.mContext.getPageActivity(), l.af(this.mContext.getPageActivity())), l.dip2px(this.mContext.getPageActivity(), l.ah(this.mContext.getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    m.a(TbConfig.LOCAL_CAMERA_DIR, this.ctI, rotateBitmapBydegree, 100);
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
                bxD();
            }
        }
    }

    private void R(Intent intent) {
        b(intent, false);
    }

    private void b(Intent intent, boolean z) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                bxD();
            }
        }
    }

    private void bxD() {
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mContext.getPageActivity(), 9, "0", null, null, null, 0, null, 13003, false, false, null, false, false, null, null, null, 0);
        writeActivityConfig.setTopicId(String.valueOf(this.gmS));
        writeActivityConfig.getIntent().putExtra("from", "topic_detail");
        writeActivityConfig.setCallFrom("1");
        if (!StringUtils.isNull(this.ctH)) {
            writeActivityConfig.setContent(this.ctH);
        }
        writeActivityConfig.setForumLevel(-1);
        writeActivityConfig.setForumAvatar(null);
        writeActivityConfig.setPrivateThread(0);
        writeActivityConfig.setForumDir("", "");
        writeActivityConfig.setWriteImagesInfo(this.writeImagesInfo);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
    }

    public void asT() {
        if (this.ctK.getWriteData() == null) {
            this.ctK.setWriteData(new WriteData());
        }
        if (this.ctK.getWriteData() != null) {
            this.ctK.getWriteData().setForumId("0");
            this.ctK.getWriteData().setType(9);
            this.ctK.getWriteData().setEntranceType(1);
            this.ctK.getWriteData().setCanNoForum(true);
            this.ctK.getWriteData().setTransmitForumData("[]");
            this.ctK.getWriteData().setCallFrom("1");
            this.ctK.getWriteData().setTopicId(String.valueOf(this.gmS));
            this.ctK.getWriteData().setContent(this.ctH);
            this.ctK.getWriteData().setIsNoTitle(true);
            this.ctK.getWriteData().setTitle("");
            this.ctK.getWriteData().setVoice(null);
            this.ctK.getWriteData().setVoiceDuringTime(-1);
            if (!this.ctK.cqX()) {
                amm().showToast((int) R.string.write_img_limit);
            } else if (this.ctS == null || !this.ctS.asy()) {
                if (this.ctR != null) {
                    this.ctR.asz();
                }
                if (!this.ctK.startPostWrite()) {
                }
            }
        }
    }

    private void S(Intent intent) {
        b(intent, true);
    }

    public long bxE() {
        return this.gmS;
    }

    private void asL() {
        if (asa() != null) {
            asa().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    public void onDestory() {
        this.ctK.cancelLoadData();
    }

    public void asU() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.ctH);
        writeData.setTopicId(String.valueOf(this.gmS));
        writeData.setWriteImagesInfo(this.writeImagesInfo);
        v.b(String.valueOf(this.gmS), writeData);
    }

    public void bxF() {
        v.d(String.valueOf(this.gmS), new v.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.5
            @Override // com.baidu.tieba.tbadkCore.v.a
            public void a(WriteData writeData) {
                if (writeData != null) {
                    if (writeData.getWriteImagesInfo() != null && a.this.writeImagesInfo.size() == 0) {
                        a.this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                        if (a.this.writeImagesInfo != null && a.this.writeImagesInfo.getChosedFiles() != null && a.this.writeImagesInfo.getChosedFiles().size() > 0) {
                            a.this.asa().b(new com.baidu.tbadk.editortools.a(2, 10, a.this.writeImagesInfo.getChosedFiles().size() + ""));
                        }
                    }
                    if (a.this.writeImagesInfo == null || a.this.writeImagesInfo.size() == 0) {
                        a.this.asa().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                    }
                    if (!aq.isEmpty(writeData.getContent()) && aq.isEmpty(a.this.ctH)) {
                        a.this.ctH = writeData.getContent();
                        a.this.qt(a.this.ctH);
                    }
                }
            }
        });
    }

    public void asV() {
        v.b(String.valueOf(this.gmS), (WriteData) null);
    }

    private void z(ArrayList<String> arrayList) {
        if (asa() != null) {
            asa().b(new com.baidu.tbadk.editortools.a(17, 29, arrayList));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qt(String str) {
        if (asa() != null) {
            asa().b(new com.baidu.tbadk.editortools.a(6, 29, str));
        }
    }

    public void qr(String str) {
        this.ctH = str;
    }

    public void fq(boolean z) {
        this.cuz = z;
    }

    public void asX() {
        fq(false);
        asa().hide();
    }

    public void ata() {
        fq(true);
        asa().qk();
    }

    public void b(NewWriteModel.d dVar) {
        this.cuA = dVar;
    }

    public void a(com.baidu.tbadk.editortools.pb.b bVar) {
        this.ctS = bVar;
    }

    public c bxG() {
        if (this.gmT == null && asa() != null) {
            this.gmT = (c) asa().kq(29);
        }
        return this.gmT;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public void setTopicId(long j) {
        this.gmS = j;
    }
}
