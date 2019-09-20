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
    private String cuE;
    private String cuF;
    private NewWriteModel cuH;
    private ImageModel cuI;
    private String cuL;
    private com.baidu.tbadk.editortools.pb.c cuO;
    private com.baidu.tbadk.editortools.pb.b cuP;
    private NewWriteModel.d cuV;
    private final com.baidu.adp.base.d cuW;
    private boolean cvv;
    private NewWriteModel.d cvw;
    private View.OnClickListener cvz;
    private String goI;
    private long goJ;
    private c goK;
    private TbPageContext<?> mContext;
    private AntiHelper.a mInjectListener;
    private WriteImagesInfo writeImagesInfo;

    /* JADX INFO: Access modifiers changed from: private */
    public void fs(boolean z) {
        if (asm() != null) {
            asm().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void qG(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(amy().getPageActivity());
        aVar.mQ(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(amy()).agO();
    }

    public void F(int i, String str) {
        if (AntiHelper.aG(i, str)) {
            if (AntiHelper.a(this.mContext.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new an("c12534").P("obj_locate", at.a.bUM));
            }
        } else if (i == 230277 || i == 230278) {
            qG(str);
        } else {
            amy().showToast(str);
        }
    }

    public TbPageContext<?> amy() {
        return this.mContext;
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.cuE = "";
        this.goI = null;
        this.cvv = false;
        this.cuL = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.cuI = null;
        this.cuV = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
                if (a.this.cvw != null) {
                    a.this.cvw.callback(z, postWriteCallBackData, yVar, writeData, antiData);
                }
                if (z) {
                    a.this.cuE = null;
                    a.this.fs(true);
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    a.this.cuH.setWriteData(null);
                    a.this.cuH.rm(false);
                    a.this.writeImagesInfo.clear();
                    a.this.ath();
                    a.this.asm().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.aG(i, str)) {
                    a.this.F(i, str);
                } else if (yVar != null && writeData != null && !StringUtils.isNull(yVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(yVar.getVcode_md5());
                    writeData.setVcodeUrl(yVar.getVcode_pic_url());
                    writeData.setVcodeExtra(yVar.amT());
                    if (com.baidu.tbadk.v.a.rF(yVar.amS())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.amy().getPageActivity(), 12006, writeData, false, yVar.amS())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.amy().getPageActivity(), writeData, 12006)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.mContext.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    a.this.amy().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an("c12536").P("obj_locate", at.a.bUM));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an("c12535").P("obj_locate", at.a.bUM));
            }
        };
        this.cuW = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.4
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (obj instanceof Bitmap) {
                    a.this.cuH.rm(true);
                }
            }
        };
        this.cvz = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(a.this.cuL)) {
                    l.showToast(a.this.amy().getPageActivity(), a.this.cuL);
                }
            }
        };
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        if (baseActivity != null) {
            this.cuH = new NewWriteModel(baseActivity);
            this.cuH.b(this.cuV);
            this.cuI = new ImageModel(baseActivity);
            this.cuI.setLoadDataCallBack(this.cuW);
            if (bundle != null) {
                this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
                this.cuF = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            }
            if (this.writeImagesInfo != null) {
                this.writeImagesInfo.setMaxImagesAllowed(9);
            }
            if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                asm().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
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
                        asm().invalidate();
                        return;
                    }
                    return;
                case 12003:
                    if (intent != null) {
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            asX();
                            this.cuH.rm(false);
                            return;
                        }
                        this.cuI.qy(intent.getStringExtra("file_name"));
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
                    if (this.cvw != null) {
                        this.cuE = null;
                        fs(true);
                        this.cuH.setWriteData(null);
                        this.cuH.rm(false);
                        this.writeImagesInfo.clear();
                        ath();
                        asm().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                        this.cvw.callback(true, postWriteCallBackData2, null, this.cuH.getWriteData(), null);
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
                        this.cuV.callback(true, postWriteCallBackData, null, null, null);
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
                    if (this.cvw != null) {
                        this.cvw.callback(false, postWriteCallBackData3, null, this.cuH.getWriteData(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void Q(Intent intent) {
        this.cuF = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.cuF;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.mContext.getPageActivity(), l.af(this.mContext.getPageActivity())), l.dip2px(this.mContext.getPageActivity(), l.ah(this.mContext.getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    m.a(TbConfig.LOCAL_CAMERA_DIR, this.cuF, rotateBitmapBydegree, 100);
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
                byr();
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
                byr();
            }
        }
    }

    private void byr() {
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mContext.getPageActivity(), 9, "0", null, null, null, 0, null, 13003, false, false, null, false, false, null, null, null, 0);
        writeActivityConfig.setTopicId(String.valueOf(this.goJ));
        writeActivityConfig.getIntent().putExtra("from", "topic_detail");
        writeActivityConfig.setCallFrom("1");
        if (!StringUtils.isNull(this.cuE)) {
            writeActivityConfig.setContent(this.cuE);
        }
        writeActivityConfig.setForumLevel(-1);
        writeActivityConfig.setForumAvatar(null);
        writeActivityConfig.setPrivateThread(0);
        writeActivityConfig.setForumDir("", "");
        writeActivityConfig.setWriteImagesInfo(this.writeImagesInfo);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
    }

    public void atf() {
        if (this.cuH.getWriteData() == null) {
            this.cuH.setWriteData(new WriteData());
        }
        if (this.cuH.getWriteData() != null) {
            this.cuH.getWriteData().setForumId("0");
            this.cuH.getWriteData().setType(9);
            this.cuH.getWriteData().setEntranceType(1);
            this.cuH.getWriteData().setCanNoForum(true);
            this.cuH.getWriteData().setTransmitForumData("[]");
            this.cuH.getWriteData().setCallFrom("1");
            this.cuH.getWriteData().setTopicId(String.valueOf(this.goJ));
            this.cuH.getWriteData().setContent(this.cuE);
            this.cuH.getWriteData().setIsNoTitle(true);
            this.cuH.getWriteData().setTitle("");
            this.cuH.getWriteData().setVoice(null);
            this.cuH.getWriteData().setVoiceDuringTime(-1);
            if (!this.cuH.crL()) {
                amy().showToast((int) R.string.write_img_limit);
            } else if (this.cuP == null || !this.cuP.asK()) {
                if (this.cuO != null) {
                    this.cuO.asL();
                }
                if (!this.cuH.startPostWrite()) {
                }
            }
        }
    }

    private void S(Intent intent) {
        b(intent, true);
    }

    public long bys() {
        return this.goJ;
    }

    private void asX() {
        if (asm() != null) {
            asm().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    public void onDestory() {
        this.cuH.cancelLoadData();
    }

    public void atg() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.cuE);
        writeData.setTopicId(String.valueOf(this.goJ));
        writeData.setWriteImagesInfo(this.writeImagesInfo);
        v.b(String.valueOf(this.goJ), writeData);
    }

    public void byt() {
        v.d(String.valueOf(this.goJ), new v.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.5
            @Override // com.baidu.tieba.tbadkCore.v.a
            public void a(WriteData writeData) {
                if (writeData != null) {
                    if (writeData.getWriteImagesInfo() != null && a.this.writeImagesInfo.size() == 0) {
                        a.this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                        if (a.this.writeImagesInfo != null && a.this.writeImagesInfo.getChosedFiles() != null && a.this.writeImagesInfo.getChosedFiles().size() > 0) {
                            a.this.asm().b(new com.baidu.tbadk.editortools.a(2, 10, a.this.writeImagesInfo.getChosedFiles().size() + ""));
                        }
                    }
                    if (a.this.writeImagesInfo == null || a.this.writeImagesInfo.size() == 0) {
                        a.this.asm().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                    }
                    if (!aq.isEmpty(writeData.getContent()) && aq.isEmpty(a.this.cuE)) {
                        a.this.cuE = writeData.getContent();
                        a.this.qE(a.this.cuE);
                    }
                }
            }
        });
    }

    public void ath() {
        v.b(String.valueOf(this.goJ), (WriteData) null);
    }

    private void z(ArrayList<String> arrayList) {
        if (asm() != null) {
            asm().b(new com.baidu.tbadk.editortools.a(17, 29, arrayList));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qE(String str) {
        if (asm() != null) {
            asm().b(new com.baidu.tbadk.editortools.a(6, 29, str));
        }
    }

    public void qC(String str) {
        this.cuE = str;
    }

    public void ft(boolean z) {
        this.cvv = z;
    }

    public void atj() {
        ft(false);
        asm().hide();
    }

    public void atm() {
        ft(true);
        asm().ql();
    }

    public void b(NewWriteModel.d dVar) {
        this.cvw = dVar;
    }

    public void a(com.baidu.tbadk.editortools.pb.b bVar) {
        this.cuP = bVar;
    }

    public c byu() {
        if (this.goK == null && asm() != null) {
            this.goK = (c) asm().kt(29);
        }
        return this.goK;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public void setTopicId(long j) {
        this.goJ = j;
    }
}
