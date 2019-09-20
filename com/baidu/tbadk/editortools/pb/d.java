package com.baidu.tbadk.editortools.pb;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.sapi2.utils.SapiGIDEvent;
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
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.coreExtra.data.y;
import com.baidu.tbadk.editortools.BLauncher;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.v;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class d extends com.baidu.tbadk.editortools.d implements v.a {
    private long authorId;
    private String authorName;
    private String authorNameShow;
    private EditorTools csI;
    private String cuE;
    private String cuF;
    private LocationModel cuG;
    private NewWriteModel cuH;
    private ImageModel cuI;
    private DataModel<?> cuJ;
    private ForumData cuK;
    private String cuL;
    private int cuM;
    private NewWriteModel.d cuN;
    private c cuO;
    private b cuP;
    private boolean cuQ;
    private TextWatcher cuR;
    private e cuS;
    private LocationModel.a cuT;
    private LocationModel.b cuU;
    private final NewWriteModel.d cuV;
    private final com.baidu.adp.base.d cuW;
    private BaseActivity<?> mContext;
    private String mThreadId;
    private VideoInfo mVideoInfo;
    private VoiceData.VoiceModel mVoiceModel;
    private String postId;
    private WriteImagesInfo writeImagesInfo;

    public d(EditorTools editorTools) {
        super(editorTools);
        this.writeImagesInfo = new WriteImagesInfo();
        this.cuE = "";
        this.cuH = null;
        this.cuI = null;
        this.mThreadId = null;
        this.cuL = null;
        this.cuM = 0;
        this.cuQ = false;
        this.cuT = new LocationModel.a() { // from class: com.baidu.tbadk.editortools.pb.d.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void atd() {
                d.this.mContext.showToast(R.string.no_network_guide);
                d.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                BaseActivity baseActivity = d.this.mContext;
                if (StringUtils.isNull(str)) {
                    str = d.this.asm().getContext().getString(R.string.location_fail);
                }
                baseActivity.showToast(str);
                d.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.crd())) {
                    d.this.b(2, true, aVar.crd());
                } else {
                    onFail(null);
                }
            }
        };
        this.cuU = new LocationModel.b() { // from class: com.baidu.tbadk.editortools.pb.d.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void ate() {
                d.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void qF(String str) {
                d.this.b(2, true, str);
            }
        };
        this.cuV = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.d.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
                WriteData writeData2 = writeData == null ? d.this.cuH.getWriteData() : writeData;
                if (z) {
                    d.this.fs(true);
                    WriteData writeData3 = d.this.cuH.getWriteData();
                    d.this.resetData();
                    v.d(d.this.mThreadId, (WriteData) null);
                    if (writeData3 != null) {
                        if (writeData3 != null && writeData3.getType() == 2) {
                            v.a(writeData3.getThreadId(), d.this);
                        }
                    } else {
                        return;
                    }
                } else if (writeData2 != null && yVar != null && !TextUtils.isEmpty(yVar.amS())) {
                    writeData2.setVcodeMD5(yVar.getVcode_md5());
                    writeData2.setVcodeUrl(yVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(yVar.amT());
                    if (com.baidu.tbadk.v.a.rF(yVar.amS())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(d.this.mContext.getActivity(), 12006, writeData2, false, yVar.amS())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(d.this.mContext.getActivity(), writeData2, 12006)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(d.this.mContext.getActivity(), 12006, writeData2, postWriteCallBackData.getAccessState())));
                }
                d.this.b(d.this.cuH.getWriteData());
                if (d.this.cuN != null) {
                    d.this.cuN.callback(z, postWriteCallBackData, yVar, writeData2, antiData);
                }
            }
        };
        this.cuW = new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.editortools.pb.d.7
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (obj instanceof Bitmap) {
                    d.this.cuH.rm(true);
                }
            }
        };
        this.csI = editorTools;
    }

    public void kz(int i) {
        if (this.cuS == null && asm() != null) {
            this.cuS = (e) asm().kt(27);
        }
        if (this.cuS != null) {
            this.cuS.setType(i);
        }
    }

    public void kA(int i) {
        if (this.cuS == null && asm() != null) {
            this.cuS = (e) asm().kt(27);
        }
        if (this.cuS != null) {
            this.cuS.kB(i);
        }
    }

    public e asM() {
        if (this.cuS == null && asm() != null) {
            this.cuS = (e) asm().kt(27);
        }
        return this.cuS;
    }

    public void qz(String str) {
        if (this.cuS == null && asm() != null) {
            this.cuS = (e) asm().kt(27);
        }
        if (this.cuS != null) {
            this.cuS.setHint(str);
        }
    }

    public void fo(boolean z) {
        BLauncher bLauncher;
        if (asm() != null && (bLauncher = (BLauncher) asm().kq(5)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void fp(boolean z) {
        BLauncher bLauncher;
        if (asm() != null && (bLauncher = (BLauncher) asm().kq(23)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void fq(boolean z) {
        BLauncher bLauncher;
        if (asm() != null && (bLauncher = (BLauncher) asm().kq(2)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.cuJ = dataModel;
    }

    public void b(BaseActivity<?> baseActivity) {
        this.mContext = baseActivity;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.cuL = antiData.getVoice_message();
        }
    }

    public void a(ForumData forumData, UserData userData) {
        this.cuK = forumData;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (asm() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.authorNameShow = metaData.getName_show();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void fr(boolean z) {
        this.cuQ = z;
    }

    public void asN() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            String valueOf = String.valueOf(this.authorId);
            if (valueOf == null || valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                l.showToast(this.mContext.getActivity(), (int) R.string.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(this.mContext.getActivity(), this.authorId, this.authorName, this.authorNameShow, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.g.b.e(this.mThreadId, 0L), com.baidu.adp.lib.g.b.e(this.postId, 0L))));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        if (i2 == -1) {
            switch (i) {
                case SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE /* 11001 */:
                    a((String) null, (WriteData) null);
                    return;
                case 11025:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.mContext.getActivity(), 12004, true)));
                    return;
                case 11026:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.mContext.getActivity(), 12005, true)));
                    return;
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
                    WriteData writeData = this.cuH.getWriteData();
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (writeData != null) {
                        writeData.deleteUploadedTempImages();
                    }
                    this.cuH.setWriteData(null);
                    this.cuH.rm(false);
                    this.mVoiceModel = null;
                    this.mVideoInfo = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        v.d(this.mThreadId, (WriteData) null);
                    }
                    fs(true);
                    if (this.cuN != null) {
                        this.cuN.callback(true, postWriteCallBackData, null, writeData, null);
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
                case 13010:
                    if (asm() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            an anVar = new an("c10068");
                            anVar.P("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(anVar);
                            asY();
                            asm().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            asm().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
                            return;
                        }
                        return;
                    }
                    return;
                case 23004:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
                    return;
                case 25004:
                    if (intent != null) {
                        qD(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case SapiGIDEvent.TIME_FREQ /* 12001 */:
                asV();
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
                if (this.cuN != null) {
                    this.cuN.callback(false, postWriteCallBackData2, null, this.cuH.getWriteData(), null);
                    return;
                }
                return;
        }
    }

    public void asO() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(this.mContext.getActivity())));
    }

    public void asP() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.mContext.getActivity())) {
            this.mContext.showToast((int) R.string.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            asR();
        } else if (this.cuG.crj()) {
            asO();
        } else {
            this.cuG.rk(false);
            b(1, true, null);
            this.cuG.crh();
        }
    }

    public void asQ() {
        if (this.cuG != null && !com.baidu.tieba.tbadkCore.location.c.crf().crg() && UtilHelper.isSystemLocationProviderEnabled(this.mContext.getActivity()) && TbadkCoreApplication.getInst().getLocationShared()) {
            this.cuG.crh();
        }
    }

    private void asR() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getActivity());
        aVar.hv(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tbadk.editortools.pb.d.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.kc()) {
                    d.this.b(1, true, null);
                    d.this.cuG.aWk();
                } else {
                    d.this.cuT.atd();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.editortools.pb.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                d.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(this.mContext.getPageContext());
        aVar.agO();
    }

    public void asS() {
        if (this.cuG.aWg()) {
            if (this.cuG.crj()) {
                this.cuT.a(com.baidu.tieba.tbadkCore.location.c.crf().getLocationData());
                return;
            }
            if (l.kt()) {
                this.cuG.crh();
            }
            b(0, true, null);
            return;
        }
        b(0, false, null);
    }

    public boolean asT() {
        if (StringUtils.isNull(this.cuE)) {
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
        this.cuH.setWriteData(null);
        this.cuH.rm(false);
        this.mVoiceModel = null;
        this.mVideoInfo = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void asU() {
        this.mVideoInfo = null;
    }

    private void Q(Intent intent) {
        this.cuF = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.cuF;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.mContext.getActivity(), l.af(this.mContext.getActivity())), l.dip2px(this.mContext.getActivity(), l.ah(this.mContext.getActivity())));
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
            a(false, (PostWriteCallBackData) null);
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
                a(false, (PostWriteCallBackData) null);
            }
        }
    }

    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(0);
        pbEditorData.setContent(this.cuE);
        pbEditorData.setWriteImagesInfo(this.writeImagesInfo);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        PbEditorData.ThreadData threadData = new PbEditorData.ThreadData();
        if (this.cuK != null) {
            threadData.setForumId(this.cuK.getId());
            threadData.setForumName(this.cuK.getName());
            threadData.setFirstDir(this.cuK.getFirst_class());
            threadData.setSecondDir(this.cuK.getSecond_class());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.cuL);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.mContext.getActivity(), 25035, pbEditorData, postWriteCallBackData)));
    }

    public void c(p pVar) {
        if (pVar != null) {
            if (pVar.amI() == EmotionGroupType.BIG_EMOTION || pVar.amI() == EmotionGroupType.USER_COLLECT) {
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setImageType(1);
                imageFileInfo.setFilePath(pVar.getName());
                imageFileInfo.width = pVar.getWidth();
                imageFileInfo.height = pVar.getHeight();
                this.writeImagesInfo.addChooseFile(imageFileInfo);
                this.writeImagesInfo.updateQuality();
            }
        }
    }

    private void asV() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tbadk.editortools.pb.d.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                m.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + d.this.cuF));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void S(Intent intent) {
        b(intent, true);
    }

    public void qA(String str) {
        WriteData writeData = this.cuH.getWriteData();
        if (writeData == null) {
            writeData = new WriteData(1);
            writeData.setThreadId(str);
            writeData.setWriteImagesInfo(this.writeImagesInfo);
        }
        writeData.setContent(this.cuE);
        writeData.setVideoInfo(this.mVideoInfo);
        v.d(str, writeData);
    }

    public void qB(String str) {
        v.a(str, this);
    }

    @Override // com.baidu.tieba.tbadkCore.v.a
    public void a(WriteData writeData) {
        if (writeData != null) {
            if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                if (this.mVideoInfo == null) {
                    this.mVideoInfo = new VideoInfo();
                }
                this.mVideoInfo.copy(writeData.getVideoInfo());
                asY();
                asm().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                    asm().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                asm().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            if (!aq.isEmpty(writeData.getContent()) && aq.isEmpty(this.cuE)) {
                this.cuE = writeData.getContent();
                qE(this.cuE);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004008));
        }
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            this.writeImagesInfo = new WriteImagesInfo();
            if (writeData.getWriteImagesInfo() != null) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                    asm().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                asm().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.cuE = writeData.getContent();
            qE(this.cuE);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004008));
        }
    }

    public void onDestroy() {
        this.cuH.cancelLoadData();
        this.cuI.cancelLoadData();
        this.cuG.cancelLoadData();
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        this.cuH = new NewWriteModel(baseActivity);
        this.cuH.b(this.cuV);
        this.cuI = new ImageModel(baseActivity);
        this.cuI.setLoadDataCallBack(this.cuW);
        this.cuG = new LocationModel(baseActivity);
        this.cuG.a(this.cuT);
        this.cuG.a(this.cuU);
        if (bundle != null) {
            this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
            this.cuF = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(9);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && asm() != null) {
            asm().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.cuG.aWg() && asm() != null) {
            asm().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            asm().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.writeImagesInfo != null) {
            bundle.putString(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.cuF);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.cuH.getWriteData() == null) {
            this.cuH.setWriteData(this.cuJ.qx(str));
        }
        if (this.cuH.getWriteData() != null) {
            if (this.cuQ) {
                this.cuH.getWriteData().setCanNoForum(true);
                if (this.cuK != null) {
                    this.cuH.getWriteData().setVForumId(this.cuK.getId());
                    this.cuH.getWriteData().setVForumName(this.cuK.getName());
                }
            } else {
                this.cuH.getWriteData().setCanNoForum(false);
                this.cuH.getWriteData().setVForumId("");
                this.cuH.getWriteData().setVForumName("");
            }
            this.cuH.getWriteData().setWriteImagesInfo(this.writeImagesInfo);
            this.cuH.getWriteData().setVideoInfo(this.mVideoInfo);
            this.cuH.rm(this.writeImagesInfo.size() > 0);
            WriteData writeData2 = this.cuH.getWriteData();
            if (this.cuG == null || !this.cuG.aWg()) {
                z = false;
            }
            writeData2.setHasLocationData(z);
            if (str == null) {
                this.cuH.getWriteData().setContent(this.cuE);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.cuH.getWriteData().setVoice(this.mVoiceModel.getId());
                    this.cuH.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.cuH.getWriteData().setVoice(null);
                    this.cuH.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.cuH.getWriteData().setVoice(null);
                this.cuH.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.cuH.crL()) {
                this.mContext.showToast((int) R.string.write_img_limit);
            } else if (this.cuP == null || !this.cuP.asK()) {
                if (this.cuO != null) {
                    this.cuO.asL();
                }
                if (!this.cuH.startPostWrite()) {
                }
            }
        }
    }

    public BaseActivity<?> getContext() {
        return this.mContext;
    }

    public void qC(String str) {
        this.cuE = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int asW() {
        return this.cuM;
    }

    private void asX() {
        if (asm() != null) {
            asm().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void z(ArrayList<String> arrayList) {
        if (asm() != null) {
            asm().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void qD(String str) {
        if (asm() != null) {
            asm().b(new com.baidu.tbadk.editortools.a(44, 27, str));
        }
    }

    private void asY() {
        if (asm() != null) {
            asm().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.cuM = i;
        if (asm() != null) {
            asm().b(new com.baidu.tbadk.editortools.a(19, 27, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void qE(String str) {
        if (asm() != null) {
            asm().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fs(boolean z) {
        if (asm() != null) {
            if (z) {
                asm().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                asm().b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
            asm().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.cuN = dVar;
    }

    public void a(c cVar) {
        this.cuO = cVar;
    }

    public void a(b bVar) {
        this.cuP = bVar;
    }

    public boolean asZ() {
        LinkedList<ImageFileInfo> chosedFiles;
        return (this.writeImagesInfo == null || (chosedFiles = this.writeImagesInfo.getChosedFiles()) == null || chosedFiles.isEmpty()) ? false : true;
    }

    public boolean ata() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    private void atb() {
        if (this.cuS == null && asm() != null) {
            this.cuS = (e) asm().kt(27);
        }
    }

    public void atc() {
        if (this.cuS != null && this.cuR != null) {
            this.cuS.d(this.cuR);
        }
    }

    public void b(TextWatcher textWatcher) {
        atb();
        if (this.cuS != null && textWatcher != null) {
            this.cuS.c(textWatcher);
        }
    }

    public void asx() {
        if (this.csI != null) {
            this.csI.asx();
        }
    }
}
