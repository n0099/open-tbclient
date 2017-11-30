package com.baidu.tbadk.editortools.pb;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.r;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class d extends com.baidu.tbadk.editortools.f implements t.a {
    private com.baidu.tbadk.editortools.i aBB;
    private ImageModel aDA;
    private DataModel<?> aDB;
    private ForumData aDC;
    private String aDD;
    private int aDE;
    private NewWriteModel.d aDF;
    private c aDG;
    private b aDH;
    private boolean aDI;
    private TextWatcher aDJ;
    private e aDK;
    private LocationModel.a aDL;
    private LocationModel.b aDM;
    private final NewWriteModel.d aDN;
    private final com.baidu.adp.base.d aDO;
    private String aDw;
    private String aDx;
    private LocationModel aDy;
    private NewWriteModel aDz;
    private long authorId;
    private String authorName;
    private String authorNameShow;
    private BaseActivity<?> mContext;
    private String mThreadId;
    private VideoInfo mVideoInfo;
    private VoiceData.VoiceModel mVoiceModel;
    private String postId;
    private WriteImagesInfo writeImagesInfo;

    public d(com.baidu.tbadk.editortools.i iVar) {
        super(iVar);
        this.writeImagesInfo = new WriteImagesInfo();
        this.aDw = "";
        this.aDz = null;
        this.aDA = null;
        this.mThreadId = null;
        this.aDD = null;
        this.aDE = 0;
        this.aDI = false;
        this.aDL = new LocationModel.a() { // from class: com.baidu.tbadk.editortools.pb.d.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void DS() {
                d.this.mContext.showToast(d.j.no_network_guide);
                d.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void gb(String str) {
                BaseActivity baseActivity = d.this.mContext;
                if (StringUtils.isNull(str)) {
                    str = d.this.Dd().getContext().getString(d.j.location_fail);
                }
                baseActivity.showToast(str);
                d.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.bwS())) {
                    d.this.a(2, true, aVar.bwS());
                } else {
                    gb(null);
                }
            }
        };
        this.aDM = new LocationModel.b() { // from class: com.baidu.tbadk.editortools.pb.d.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void DT() {
                d.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void gc(String str) {
                d.this.a(2, true, str);
            }
        };
        this.aDN = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.d.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, r rVar, WriteData writeData, AntiData antiData) {
                WriteData writeData2 = writeData == null ? d.this.aDz.getWriteData() : writeData;
                if (z) {
                    d.this.bF(true);
                    WriteData writeData3 = d.this.aDz.getWriteData();
                    d.this.resetData();
                    t.d(d.this.mThreadId, (WriteData) null);
                    if (writeData3 != null) {
                        if (writeData3 != null && writeData3.getType() == 2) {
                            t.a(writeData3.getThreadId(), d.this);
                        }
                    } else {
                        return;
                    }
                } else if (writeData2 != null && rVar != null && !TextUtils.isEmpty(rVar.yi())) {
                    writeData2.setVcodeMD5(rVar.getVcode_md5());
                    writeData2.setVcodeUrl(rVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(rVar.yj());
                    if (com.baidu.tbadk.p.a.he(rVar.yi())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(d.this.mContext.getActivity(), 12006, writeData2, false, rVar.yi())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(d.this.mContext.getActivity(), writeData2, 12006)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(d.this.mContext.getActivity(), 12006, writeData2, postWriteCallBackData.getAccessState())));
                }
                if (d.this.aDF != null) {
                    d.this.aDF.callback(z, postWriteCallBackData, rVar, writeData2, antiData);
                }
            }
        };
        this.aDO = new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.editortools.pb.d.7
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                if (obj instanceof Bitmap) {
                    d.this.aDz.ng(true);
                }
            }
        };
        this.aBB = iVar;
    }

    public void eV(int i) {
        if (this.aDK == null && Dd() != null) {
            this.aDK = (e) Dd().eP(27);
        }
        if (this.aDK != null) {
            this.aDK.setType(i);
        }
    }

    public void eW(int i) {
        if (this.aDK == null && Dd() != null) {
            this.aDK = (e) Dd().eP(27);
        }
        if (this.aDK != null) {
            this.aDK.eY(i);
        }
    }

    public e DB() {
        if (this.aDK == null && Dd() != null) {
            this.aDK = (e) Dd().eP(27);
        }
        return this.aDK;
    }

    public void fV(String str) {
        if (this.aDK == null && Dd() != null) {
            this.aDK = (e) Dd().eP(27);
        }
        if (this.aDK != null) {
            this.aDK.setHint(str);
        }
    }

    public void bB(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (Dd() != null && (cVar = (com.baidu.tbadk.editortools.c) Dd().eN(5)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bC(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (Dd() != null && (cVar = (com.baidu.tbadk.editortools.c) Dd().eN(23)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bD(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (Dd() != null && (cVar = (com.baidu.tbadk.editortools.c) Dd().eN(2)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.aDB = dataModel;
    }

    public void d(BaseActivity<?> baseActivity) {
        this.mContext = baseActivity;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.aDD = antiData.getVoice_message();
        }
    }

    public void a(ForumData forumData, UserData userData) {
        this.aDC = forumData;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (Dd() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.authorNameShow = metaData.getName_show();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void bE(boolean z) {
        this.aDI = z;
    }

    public void DC() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            String valueOf = String.valueOf(this.authorId);
            if (valueOf == null || valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                l.showToast(this.mContext.getActivity(), d.j.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.mContext.getActivity(), this.authorId, this.authorName, this.authorNameShow, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.g.b.c(this.mThreadId, 0L), com.baidu.adp.lib.g.b.c(this.postId, 0L))));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        if (i2 == -1) {
            switch (i) {
                case 11001:
                    a((String) null, (WriteData) null);
                    return;
                case 11025:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.mContext.getActivity(), 12004, true)));
                    return;
                case 11026:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.mContext.getActivity(), 12005, true)));
                    return;
                case 12002:
                    if (intent != null) {
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            z(intent);
                        } else {
                            B(intent);
                        }
                        Dd().invalidate();
                        return;
                    }
                    return;
                case 12003:
                    if (intent != null) {
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            DL();
                            this.aDz.ng(false);
                            return;
                        }
                        this.aDA.fU(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case 12004:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        q(stringArrayListExtra);
                        return;
                    }
                    return;
                case 12006:
                    WriteData writeData = this.aDz.getWriteData();
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (writeData != null) {
                        writeData.deleteUploadedTempImages();
                    }
                    this.aDz.setWriteData(null);
                    this.aDz.ng(false);
                    this.mVoiceModel = null;
                    this.mVideoInfo = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        t.d(this.mThreadId, (WriteData) null);
                    }
                    bF(true);
                    if (this.aDF != null) {
                        this.aDF.callback(true, postWriteCallBackData, null, writeData, null);
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    if (i == 12010) {
                        z(intent);
                        return;
                    }
                    return;
                case 12012:
                    A(intent);
                    return;
                case 13010:
                    if (Dd() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            ak akVar = new ak("c10068");
                            akVar.r("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(akVar);
                            DM();
                            Dd().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            Dd().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
                            return;
                        }
                        return;
                    }
                    return;
                case 23004:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                    return;
                case 25004:
                    if (intent != null) {
                        fZ(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 12001:
                DJ();
                return;
            case 12002:
                if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                    this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    return;
                }
                return;
            case 12003:
            case 12004:
            case 12005:
            case 12007:
            case 12008:
            case 12009:
            case 12010:
            default:
                return;
            case 12006:
                PostWriteCallBackData postWriteCallBackData2 = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                if (this.aDF != null) {
                    this.aDF.callback(false, postWriteCallBackData2, null, this.aDz.getWriteData(), null);
                    return;
                }
                return;
        }
    }

    public void DD() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.mContext.getActivity())));
    }

    public void DE() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.mContext.getActivity())) {
            this.mContext.showToast(d.j.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            DF();
        } else if (this.aDy.bxa()) {
            DD();
        } else {
            this.aDy.ne(false);
            a(1, true, (String) null);
            this.aDy.bwY();
        }
    }

    private void DF() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getActivity());
        aVar.cd(d.j.location_app_permission_prompt).a(d.j.isopen, new a.b() { // from class: com.baidu.tbadk.editortools.pb.d.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.hh()) {
                    d.this.a(1, true, (String) null);
                    d.this.aDy.YM();
                } else {
                    d.this.aDL.DS();
                }
                aVar2.dismiss();
            }
        }).b(d.j.cancel, new a.b() { // from class: com.baidu.tbadk.editortools.pb.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                d.this.a(0, true, (String) null);
                aVar2.dismiss();
            }
        }).b(this.mContext.getPageContext());
        aVar.tk();
    }

    public void DG() {
        if (this.aDy.YI()) {
            if (this.aDy.bxa()) {
                this.aDL.a(com.baidu.tieba.tbadkCore.location.c.bwW().getLocationData());
                return;
            }
            if (l.hy()) {
                this.aDy.bwY();
            }
            a(0, true, (String) null);
            return;
        }
        a(0, false, (String) null);
    }

    public boolean DH() {
        if (StringUtils.isNull(this.aDw)) {
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() <= 0) {
                if (this.mVoiceModel == null || StringUtils.isNull(this.mVoiceModel.getId())) {
                    return this.mVideoInfo != null && this.mVideoInfo.isAvaliable();
                }
                return true;
            }
            return true;
        }
        return true;
    }

    public void resetData() {
        this.aDz.setWriteData(null);
        this.aDz.ng(false);
        this.mVoiceModel = null;
        this.mVideoInfo = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void DI() {
        this.mVideoInfo = null;
    }

    private void z(Intent intent) {
        this.aDx = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aDx;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.mContext.getActivity(), l.ac(this.mContext.getActivity())), l.dip2px(this.mContext.getActivity(), l.ae(this.mContext.getActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    k.a(TbConfig.LOCAL_CAMERA_DIR, this.aDx, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            a(false, (PostWriteCallBackData) null);
        }
    }

    private void A(Intent intent) {
        b(intent, false);
    }

    private void b(Intent intent, boolean z) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                a(false, (PostWriteCallBackData) null);
            }
        }
    }

    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(0);
        pbEditorData.setContent(this.aDw);
        pbEditorData.setWriteImagesInfo(this.writeImagesInfo);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        PbEditorData.ThreadData threadData = new PbEditorData.ThreadData();
        if (this.aDC != null) {
            threadData.setForumId(this.aDC.getId());
            threadData.setForumName(this.aDC.getName());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.aDD);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.mContext.getActivity(), 25035, pbEditorData, postWriteCallBackData)));
    }

    private void DJ() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tbadk.editortools.pb.d.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                k.s(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + d.this.aDx));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void B(Intent intent) {
        b(intent, true);
    }

    public void fW(String str) {
        WriteData writeData = this.aDz.getWriteData();
        if (writeData == null) {
            writeData = new WriteData(1);
            writeData.setThreadId(str);
            writeData.setWriteImagesInfo(this.writeImagesInfo);
        }
        writeData.setContent(this.aDw);
        writeData.setVideoInfo(this.mVideoInfo);
        t.d(str, writeData);
    }

    public void fX(String str) {
        t.a(str, this);
    }

    @Override // com.baidu.tieba.tbadkCore.t.a
    public void a(WriteData writeData) {
        if (writeData != null) {
            if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                if (this.mVideoInfo == null) {
                    this.mVideoInfo = new VideoInfo();
                }
                this.mVideoInfo.copy(writeData.getVideoInfo());
                DM();
                Dd().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                    Dd().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                Dd().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            if (!am.isEmpty(writeData.getContent()) && am.isEmpty(this.aDw)) {
                this.aDw = writeData.getContent();
                ga(this.aDw);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            this.writeImagesInfo = new WriteImagesInfo();
            if (writeData.getWriteImagesInfo() != null) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                    Dd().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                Dd().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.aDw = writeData.getContent();
            ga(this.aDw);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.aDz.cancelLoadData();
        this.aDA.cancelLoadData();
        this.aDy.cancelLoadData();
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        this.aDz = new NewWriteModel(baseActivity);
        this.aDz.b(this.aDN);
        this.aDA = new ImageModel(baseActivity);
        this.aDA.setLoadDataCallBack(this.aDO);
        this.aDy = new LocationModel(baseActivity);
        this.aDy.a(this.aDL);
        this.aDy.a(this.aDM);
        if (bundle != null) {
            this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
            this.aDx = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(10);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && Dd() != null) {
            Dd().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.aDy.YI() && Dd() != null) {
            Dd().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            Dd().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.writeImagesInfo != null) {
            bundle.putString(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aDx);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.aDz.getWriteData() == null) {
            this.aDz.setWriteData(this.aDB.fT(str));
        }
        if (this.aDz.getWriteData() != null) {
            if (this.aDI) {
                this.aDz.getWriteData().setCanNoForum(true);
                if (this.aDC != null) {
                    this.aDz.getWriteData().setVForumId(this.aDC.getId());
                    this.aDz.getWriteData().setVForumName(this.aDC.getName());
                }
            } else {
                this.aDz.getWriteData().setCanNoForum(false);
                this.aDz.getWriteData().setVForumId("");
                this.aDz.getWriteData().setVForumName("");
            }
            this.aDz.getWriteData().setWriteImagesInfo(this.writeImagesInfo);
            this.aDz.getWriteData().setVideoInfo(this.mVideoInfo);
            this.aDz.ng(this.writeImagesInfo.size() > 0);
            WriteData writeData2 = this.aDz.getWriteData();
            if (this.aDy == null || !this.aDy.YI()) {
                z = false;
            }
            writeData2.setHasLocationData(z);
            if (str == null) {
                this.aDz.getWriteData().setContent(this.aDw);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.aDz.getWriteData().setVoice(this.mVoiceModel.getId());
                    this.aDz.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.aDz.getWriteData().setVoice(null);
                    this.aDz.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.aDz.getWriteData().setVoice(null);
                this.aDz.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.aDz.bxw()) {
                this.mContext.showToast(d.j.write_img_limit);
            } else if (this.aDH == null || !this.aDH.Dz()) {
                if (this.aDG != null) {
                    this.aDG.DA();
                }
                if (!this.aDz.startPostWrite()) {
                }
            }
        }
    }

    public BaseActivity<?> getContext() {
        return this.mContext;
    }

    public void fY(String str) {
        this.aDw = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int DK() {
        return this.aDE;
    }

    private void DL() {
        if (Dd() != null) {
            Dd().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void q(ArrayList<String> arrayList) {
        if (Dd() != null) {
            Dd().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void fZ(String str) {
        if (Dd() != null) {
            Dd().b(new com.baidu.tbadk.editortools.a(44, 27, str));
        }
    }

    private void DM() {
        if (Dd() != null) {
            Dd().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.aDE = i;
        if (Dd() != null) {
            Dd().b(new com.baidu.tbadk.editortools.a(19, 27, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void ga(String str) {
        if (Dd() != null) {
            Dd().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bF(boolean z) {
        if (Dd() != null) {
            if (z) {
                Dd().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                Dd().b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
            Dd().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.aDF = dVar;
    }

    public void a(c cVar) {
        this.aDG = cVar;
    }

    public void a(b bVar) {
        this.aDH = bVar;
    }

    public void DN() {
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            this.writeImagesInfo.clear();
        }
        if (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) {
            this.mVideoInfo = null;
        }
        Dd().b(new com.baidu.tbadk.editortools.a(2, 19, null));
        setVoiceModel(null);
        Dd().b(new com.baidu.tbadk.editortools.a(2, 6, null));
        Dd().b(new com.baidu.tbadk.editortools.a(33, 6, null));
        if (!StringUtils.isNull(this.aDw)) {
            this.aDw = "";
        }
        ga("");
        this.aDz.setWriteData(null);
        this.aDz.ng(false);
    }

    public boolean DO() {
        LinkedList<ImageFileInfo> chosedFiles;
        return (this.writeImagesInfo == null || (chosedFiles = this.writeImagesInfo.getChosedFiles()) == null || chosedFiles.isEmpty()) ? false : true;
    }

    public boolean DP() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    public void eX(final int i) {
        DQ();
        if (this.aDK != null && (this.aDK.aBO instanceof LinearLayout)) {
            final EditText inputView = this.aDK.getInputView();
            if (this.aDJ == null) {
                this.aDJ = new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.d.8
                    @Override // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    }

                    @Override // android.text.TextWatcher
                    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    }

                    @Override // android.text.TextWatcher
                    public void afterTextChanged(Editable editable) {
                        if (editable != null) {
                            String obj = editable.toString();
                            if (!StringUtils.isNull(obj) && w.gZ(obj) > i) {
                                String e = w.e(obj, 0, i - 1);
                                inputView.setText(e);
                                inputView.setSelection(inputView.getText().length());
                                UtilHelper.showToast(d.this.getContext().getApplication(), d.this.getContext().getResources().getString(d.j.edit_text_over_limit_tip, Integer.valueOf(e.length())));
                            }
                        }
                    }
                };
            }
            this.aDK.b(this.aDJ);
        }
    }

    private void DQ() {
        if (this.aDK == null && Dd() != null) {
            this.aDK = (e) Dd().eP(27);
        }
    }

    public void DR() {
        if (this.aDK != null && this.aDJ != null) {
            this.aDK.c(this.aDJ);
        }
    }

    public void a(TextWatcher textWatcher) {
        DQ();
        if (this.aDK != null && textWatcher != null) {
            this.aDK.b(textWatcher);
        }
    }

    public void Dn() {
        if (this.aBB != null) {
            this.aBB.Dn();
        }
    }
}
