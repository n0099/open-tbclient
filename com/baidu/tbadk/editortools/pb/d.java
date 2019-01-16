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
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.x;
import com.baidu.tbadk.editortools.BLauncher;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class d extends com.baidu.tbadk.editortools.d implements t.a {
    private EditorTools aYJ;
    private long authorId;
    private String authorName;
    private String authorNameShow;
    private String baC;
    private String baD;
    private LocationModel baE;
    private NewWriteModel baF;
    private ImageModel baG;
    private DataModel<?> baH;
    private ForumData baI;
    private String baJ;
    private int baK;
    private NewWriteModel.d baL;
    private c baM;
    private b baN;
    private boolean baO;
    private TextWatcher baP;
    private e baQ;
    private LocationModel.a baR;
    private LocationModel.b baS;
    private final NewWriteModel.d baT;
    private final com.baidu.adp.base.d baU;
    private BaseActivity<?> mContext;
    private String mThreadId;
    private VideoInfo mVideoInfo;
    private VoiceData.VoiceModel mVoiceModel;
    private String postId;
    private WriteImagesInfo writeImagesInfo;

    public d(EditorTools editorTools) {
        super(editorTools);
        this.writeImagesInfo = new WriteImagesInfo();
        this.baC = "";
        this.baF = null;
        this.baG = null;
        this.mThreadId = null;
        this.baJ = null;
        this.baK = 0;
        this.baO = false;
        this.baR = new LocationModel.a() { // from class: com.baidu.tbadk.editortools.pb.d.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void Nf() {
                d.this.mContext.showToast(e.j.no_network_guide);
                d.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void dk(String str) {
                BaseActivity baseActivity = d.this.mContext;
                if (StringUtils.isNull(str)) {
                    str = d.this.Mp().getContext().getString(e.j.location_fail);
                }
                baseActivity.showToast(str);
                d.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.bFu())) {
                    d.this.b(2, true, aVar.bFu());
                } else {
                    dk(null);
                }
            }
        };
        this.baS = new LocationModel.b() { // from class: com.baidu.tbadk.editortools.pb.d.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void Ng() {
                d.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void ii(String str) {
                d.this.b(2, true, str);
            }
        };
        this.baT = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.d.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
                WriteData writeData2 = writeData == null ? d.this.baF.getWriteData() : writeData;
                if (z) {
                    d.this.cB(true);
                    WriteData writeData3 = d.this.baF.getWriteData();
                    d.this.resetData();
                    t.c(d.this.mThreadId, (WriteData) null);
                    if (writeData3 != null) {
                        if (writeData3 != null && writeData3.getType() == 2) {
                            t.a(writeData3.getThreadId(), d.this);
                        }
                    } else {
                        return;
                    }
                } else if (writeData2 != null && xVar != null && !TextUtils.isEmpty(xVar.Hk())) {
                    writeData2.setVcodeMD5(xVar.getVcode_md5());
                    writeData2.setVcodeUrl(xVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(xVar.Hl());
                    if (com.baidu.tbadk.r.a.jj(xVar.Hk())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(d.this.mContext.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, false, xVar.Hk())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(d.this.mContext.getActivity(), writeData2, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(d.this.mContext.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, postWriteCallBackData.getAccessState())));
                }
                d.this.b(d.this.baF.getWriteData());
                if (d.this.baL != null) {
                    d.this.baL.callback(z, postWriteCallBackData, xVar, writeData2, antiData);
                }
            }
        };
        this.baU = new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.editortools.pb.d.7
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (obj instanceof Bitmap) {
                    d.this.baF.nD(true);
                }
            }
        };
        this.aYJ = editorTools;
    }

    public void fR(int i) {
        if (this.baQ == null && Mp() != null) {
            this.baQ = (e) Mp().fL(27);
        }
        if (this.baQ != null) {
            this.baQ.setType(i);
        }
    }

    public void fS(int i) {
        if (this.baQ == null && Mp() != null) {
            this.baQ = (e) Mp().fL(27);
        }
        if (this.baQ != null) {
            this.baQ.fT(i);
        }
    }

    public e MO() {
        if (this.baQ == null && Mp() != null) {
            this.baQ = (e) Mp().fL(27);
        }
        return this.baQ;
    }

    public void ib(String str) {
        if (this.baQ == null && Mp() != null) {
            this.baQ = (e) Mp().fL(27);
        }
        if (this.baQ != null) {
            this.baQ.setHint(str);
        }
    }

    public void cx(boolean z) {
        BLauncher bLauncher;
        if (Mp() != null && (bLauncher = (BLauncher) Mp().fI(5)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void cy(boolean z) {
        BLauncher bLauncher;
        if (Mp() != null && (bLauncher = (BLauncher) Mp().fI(23)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void cz(boolean z) {
        BLauncher bLauncher;
        if (Mp() != null && (bLauncher = (BLauncher) Mp().fI(2)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.baH = dataModel;
    }

    public void b(BaseActivity<?> baseActivity) {
        this.mContext = baseActivity;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.baJ = antiData.getVoice_message();
        }
    }

    public void a(ForumData forumData, UserData userData) {
        this.baI = forumData;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (Mp() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.authorNameShow = metaData.getName_show();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void cA(boolean z) {
        this.baO = z;
    }

    public void MP() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            String valueOf = String.valueOf(this.authorId);
            if (valueOf == null || valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                l.showToast(this.mContext.getActivity(), e.j.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(this.mContext.getActivity(), this.authorId, this.authorName, this.authorNameShow, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.g.b.d(this.mThreadId, 0L), com.baidu.adp.lib.g.b.d(this.postId, 0L))));
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
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.mContext.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                    return;
                case 11026:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.mContext.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_MODIFY, true)));
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            A(intent);
                        } else {
                            C(intent);
                        }
                        Mp().invalidate();
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_DEL /* 12003 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            MZ();
                            this.baF.nD(false);
                            return;
                        }
                        this.baG.ia(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        u(stringArrayListExtra);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    WriteData writeData = this.baF.getWriteData();
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (writeData != null) {
                        writeData.deleteUploadedTempImages();
                    }
                    this.baF.setWriteData(null);
                    this.baF.nD(false);
                    this.mVoiceModel = null;
                    this.mVideoInfo = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        t.c(this.mThreadId, (WriteData) null);
                    }
                    cB(true);
                    if (this.baL != null) {
                        this.baL.callback(true, postWriteCallBackData, null, writeData, null);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD /* 12009 */:
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    if (i == 12010) {
                        A(intent);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    B(intent);
                    return;
                case 13010:
                    if (Mp() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            am amVar = new am("c10068");
                            amVar.y("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(amVar);
                            Na();
                            Mp().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            Mp().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                        ig(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 12001:
                MX();
                return;
            case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                    this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    return;
                }
                return;
            case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_DEL /* 12003 */:
            case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
            case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_MODIFY /* 12005 */:
            case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FILL_USENAME /* 12007 */:
            case IEventCenterService.EventId.EventMode.SAPIACCOUNT_CAPTCHA /* 12008 */:
            case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD /* 12009 */:
            case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
            default:
                return;
            case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                PostWriteCallBackData postWriteCallBackData2 = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                if (this.baL != null) {
                    this.baL.callback(false, postWriteCallBackData2, null, this.baF.getWriteData(), null);
                    return;
                }
                return;
        }
    }

    public void MQ() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(this.mContext.getActivity())));
    }

    public void MR() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.mContext.getActivity())) {
            this.mContext.showToast(e.j.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            MT();
        } else if (this.baE.bFB()) {
            MQ();
        } else {
            this.baE.nB(false);
            b(1, true, null);
            this.baE.bFz();
        }
    }

    public void MS() {
        if (this.baE != null && !com.baidu.tieba.tbadkCore.location.c.bFx().bFy() && UtilHelper.isSystemLocationProviderEnabled(this.mContext.getActivity()) && TbadkCoreApplication.getInst().getLocationShared()) {
            this.baE.bFz();
        }
    }

    private void MT() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getActivity());
        aVar.db(e.j.location_app_permission_prompt).a(e.j.isopen, new a.b() { // from class: com.baidu.tbadk.editortools.pb.d.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.kV()) {
                    d.this.b(1, true, null);
                    d.this.baE.amP();
                } else {
                    d.this.baR.Nf();
                }
                aVar2.dismiss();
            }
        }).b(e.j.cancel, new a.b() { // from class: com.baidu.tbadk.editortools.pb.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                d.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(this.mContext.getPageContext());
        aVar.BS();
    }

    public void MU() {
        if (this.baE.amL()) {
            if (this.baE.bFB()) {
                this.baR.a(com.baidu.tieba.tbadkCore.location.c.bFx().getLocationData());
                return;
            }
            if (l.ll()) {
                this.baE.bFz();
            }
            b(0, true, null);
            return;
        }
        b(0, false, null);
    }

    public boolean MV() {
        if (StringUtils.isNull(this.baC)) {
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
        this.baF.setWriteData(null);
        this.baF.nD(false);
        this.mVoiceModel = null;
        this.mVideoInfo = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void MW() {
        this.mVideoInfo = null;
    }

    private void A(Intent intent) {
        this.baD = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.baD;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.mContext.getActivity(), l.aO(this.mContext.getActivity())), l.dip2px(this.mContext.getActivity(), l.aQ(this.mContext.getActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.l.a(TbConfig.LOCAL_CAMERA_DIR, this.baD, rotateBitmapBydegree, 100);
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

    private void B(Intent intent) {
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
        pbEditorData.setContent(this.baC);
        pbEditorData.setWriteImagesInfo(this.writeImagesInfo);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        PbEditorData.ThreadData threadData = new PbEditorData.ThreadData();
        if (this.baI != null) {
            threadData.setForumId(this.baI.getId());
            threadData.setForumName(this.baI.getName());
            threadData.setFirstDir(this.baI.getFirst_class());
            threadData.setSecondDir(this.baI.getSecond_class());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.baJ);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.mContext.getActivity(), 25035, pbEditorData, postWriteCallBackData)));
    }

    private void MX() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tbadk.editortools.pb.d.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tbadk.core.util.l.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + d.this.baD));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void C(Intent intent) {
        b(intent, true);
    }

    public void ic(String str) {
        WriteData writeData = this.baF.getWriteData();
        if (writeData == null) {
            writeData = new WriteData(1);
            writeData.setThreadId(str);
            writeData.setWriteImagesInfo(this.writeImagesInfo);
        }
        writeData.setContent(this.baC);
        writeData.setVideoInfo(this.mVideoInfo);
        t.c(str, writeData);
    }

    public void ie(String str) {
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
                Na();
                Mp().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                    Mp().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                Mp().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            if (!ao.isEmpty(writeData.getContent()) && ao.isEmpty(this.baC)) {
                this.baC = writeData.getContent();
                ih(this.baC);
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
                    Mp().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                Mp().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.baC = writeData.getContent();
            ih(this.baC);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004008));
        }
    }

    public void onDestroy() {
        this.baF.cancelLoadData();
        this.baG.cancelLoadData();
        this.baE.cancelLoadData();
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        this.baF = new NewWriteModel(baseActivity);
        this.baF.b(this.baT);
        this.baG = new ImageModel(baseActivity);
        this.baG.setLoadDataCallBack(this.baU);
        this.baE = new LocationModel(baseActivity);
        this.baE.a(this.baR);
        this.baE.a(this.baS);
        if (bundle != null) {
            this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
            this.baD = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(10);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && Mp() != null) {
            Mp().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.baE.amL() && Mp() != null) {
            Mp().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            Mp().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.writeImagesInfo != null) {
            bundle.putString(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.baD);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.baF.getWriteData() == null) {
            this.baF.setWriteData(this.baH.hZ(str));
        }
        if (this.baF.getWriteData() != null) {
            if (this.baO) {
                this.baF.getWriteData().setCanNoForum(true);
                if (this.baI != null) {
                    this.baF.getWriteData().setVForumId(this.baI.getId());
                    this.baF.getWriteData().setVForumName(this.baI.getName());
                }
            } else {
                this.baF.getWriteData().setCanNoForum(false);
                this.baF.getWriteData().setVForumId("");
                this.baF.getWriteData().setVForumName("");
            }
            this.baF.getWriteData().setWriteImagesInfo(this.writeImagesInfo);
            this.baF.getWriteData().setVideoInfo(this.mVideoInfo);
            this.baF.nD(this.writeImagesInfo.size() > 0);
            WriteData writeData2 = this.baF.getWriteData();
            if (this.baE == null || !this.baE.amL()) {
                z = false;
            }
            writeData2.setHasLocationData(z);
            if (str == null) {
                this.baF.getWriteData().setContent(this.baC);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.baF.getWriteData().setVoice(this.mVoiceModel.getId());
                    this.baF.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.baF.getWriteData().setVoice(null);
                    this.baF.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.baF.getWriteData().setVoice(null);
                this.baF.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.baF.bGe()) {
                this.mContext.showToast(e.j.write_img_limit);
            } else if (this.baN == null || !this.baN.MM()) {
                if (this.baM != null) {
                    this.baM.MN();
                }
                if (!this.baF.startPostWrite()) {
                }
            }
        }
    }

    public BaseActivity<?> getContext() {
        return this.mContext;
    }

    /* renamed from: if  reason: not valid java name */
    public void m17if(String str) {
        this.baC = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int MY() {
        return this.baK;
    }

    private void MZ() {
        if (Mp() != null) {
            Mp().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void u(ArrayList<String> arrayList) {
        if (Mp() != null) {
            Mp().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void ig(String str) {
        if (Mp() != null) {
            Mp().b(new com.baidu.tbadk.editortools.a(44, 27, str));
        }
    }

    private void Na() {
        if (Mp() != null) {
            Mp().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.baK = i;
        if (Mp() != null) {
            Mp().b(new com.baidu.tbadk.editortools.a(19, 27, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void ih(String str) {
        if (Mp() != null) {
            Mp().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cB(boolean z) {
        if (Mp() != null) {
            if (z) {
                Mp().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                Mp().b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
            Mp().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.baL = dVar;
    }

    public void a(c cVar) {
        this.baM = cVar;
    }

    public void a(b bVar) {
        this.baN = bVar;
    }

    public boolean Nb() {
        LinkedList<ImageFileInfo> chosedFiles;
        return (this.writeImagesInfo == null || (chosedFiles = this.writeImagesInfo.getChosedFiles()) == null || chosedFiles.isEmpty()) ? false : true;
    }

    public boolean Nc() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    private void Nd() {
        if (this.baQ == null && Mp() != null) {
            this.baQ = (e) Mp().fL(27);
        }
    }

    public void Ne() {
        if (this.baQ != null && this.baP != null) {
            this.baQ.c(this.baP);
        }
    }

    public void a(TextWatcher textWatcher) {
        Nd();
        if (this.baQ != null && textWatcher != null) {
            this.baQ.b(textWatcher);
        }
    }

    public void Mz() {
        if (this.aYJ != null) {
            this.aYJ.Mz();
        }
    }
}
