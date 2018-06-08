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
import com.baidu.tbadk.editortools.BLauncher;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class d extends com.baidu.tbadk.editortools.d implements t.a {
    private EditorTools aKX;
    private String aMQ;
    private String aMR;
    private LocationModel aMS;
    private NewWriteModel aMT;
    private ImageModel aMU;
    private DataModel<?> aMV;
    private ForumData aMW;
    private String aMX;
    private int aMY;
    private NewWriteModel.d aMZ;
    private c aNa;
    private b aNb;
    private boolean aNc;
    private TextWatcher aNd;
    private e aNe;
    private LocationModel.a aNf;
    private LocationModel.b aNg;
    private final NewWriteModel.d aNh;
    private final com.baidu.adp.base.d aNi;
    private long authorId;
    private String authorName;
    private String authorNameShow;
    private BaseActivity<?> mContext;
    private String mThreadId;
    private VideoInfo mVideoInfo;
    private VoiceData.VoiceModel mVoiceModel;
    private String postId;
    private WriteImagesInfo writeImagesInfo;

    public d(EditorTools editorTools) {
        super(editorTools);
        this.writeImagesInfo = new WriteImagesInfo();
        this.aMQ = "";
        this.aMT = null;
        this.aMU = null;
        this.mThreadId = null;
        this.aMX = null;
        this.aMY = 0;
        this.aNc = false;
        this.aNf = new LocationModel.a() { // from class: com.baidu.tbadk.editortools.pb.d.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void HW() {
                d.this.mContext.showToast(d.k.no_network_guide);
                d.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void gP(String str) {
                BaseActivity baseActivity = d.this.mContext;
                if (StringUtils.isNull(str)) {
                    str = d.this.Hg().getContext().getString(d.k.location_fail);
                }
                baseActivity.showToast(str);
                d.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.bxD())) {
                    d.this.b(2, true, aVar.bxD());
                } else {
                    gP(null);
                }
            }
        };
        this.aNg = new LocationModel.b() { // from class: com.baidu.tbadk.editortools.pb.d.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void HX() {
                d.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void gQ(String str) {
                d.this.b(2, true, str);
            }
        };
        this.aNh = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.d.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.t tVar, WriteData writeData, AntiData antiData) {
                WriteData writeData2 = writeData == null ? d.this.aMT.getWriteData() : writeData;
                if (z) {
                    d.this.bJ(true);
                    WriteData writeData3 = d.this.aMT.getWriteData();
                    d.this.resetData();
                    t.c(d.this.mThreadId, (WriteData) null);
                    if (writeData3 != null) {
                        if (writeData3 != null && writeData3.getType() == 2) {
                            t.a(writeData3.getThreadId(), d.this);
                        }
                    } else {
                        return;
                    }
                } else if (writeData2 != null && tVar != null && !TextUtils.isEmpty(tVar.Cj())) {
                    writeData2.setVcodeMD5(tVar.getVcode_md5());
                    writeData2.setVcodeUrl(tVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(tVar.Ck());
                    if (com.baidu.tbadk.p.a.hM(tVar.Cj())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(d.this.mContext.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, false, tVar.Cj())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(d.this.mContext.getActivity(), writeData2, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(d.this.mContext.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, postWriteCallBackData.getAccessState())));
                }
                if (d.this.aMZ != null) {
                    d.this.aMZ.callback(z, postWriteCallBackData, tVar, writeData2, antiData);
                }
            }
        };
        this.aNi = new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.editortools.pb.d.7
            @Override // com.baidu.adp.base.d
            public void i(Object obj) {
                if (obj instanceof Bitmap) {
                    d.this.aMT.mC(true);
                }
            }
        };
        this.aKX = editorTools;
    }

    public void eS(int i) {
        if (this.aNe == null && Hg() != null) {
            this.aNe = (e) Hg().eM(27);
        }
        if (this.aNe != null) {
            this.aNe.setType(i);
        }
    }

    public void eT(int i) {
        if (this.aNe == null && Hg() != null) {
            this.aNe = (e) Hg().eM(27);
        }
        if (this.aNe != null) {
            this.aNe.eU(i);
        }
    }

    public e HF() {
        if (this.aNe == null && Hg() != null) {
            this.aNe = (e) Hg().eM(27);
        }
        return this.aNe;
    }

    public void gJ(String str) {
        if (this.aNe == null && Hg() != null) {
            this.aNe = (e) Hg().eM(27);
        }
        if (this.aNe != null) {
            this.aNe.setHint(str);
        }
    }

    public void bF(boolean z) {
        BLauncher bLauncher;
        if (Hg() != null && (bLauncher = (BLauncher) Hg().eJ(5)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void bG(boolean z) {
        BLauncher bLauncher;
        if (Hg() != null && (bLauncher = (BLauncher) Hg().eJ(23)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void bH(boolean z) {
        BLauncher bLauncher;
        if (Hg() != null && (bLauncher = (BLauncher) Hg().eJ(2)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.aMV = dataModel;
    }

    public void b(BaseActivity<?> baseActivity) {
        this.mContext = baseActivity;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.aMX = antiData.getVoice_message();
        }
    }

    public void a(ForumData forumData, UserData userData) {
        this.aMW = forumData;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (Hg() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.authorNameShow = metaData.getName_show();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void bI(boolean z) {
        this.aNc = z;
    }

    public void HG() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            String valueOf = String.valueOf(this.authorId);
            if (valueOf == null || valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                l.showToast(this.mContext.getActivity(), d.k.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(this.mContext.getActivity(), this.authorId, this.authorName, this.authorNameShow, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.g.b.c(this.mThreadId, 0L), com.baidu.adp.lib.g.b.c(this.postId, 0L))));
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
                            z(intent);
                        } else {
                            B(intent);
                        }
                        Hg().invalidate();
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_DEL /* 12003 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            HQ();
                            this.aMT.mC(false);
                            return;
                        }
                        this.aMU.gI(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        q(stringArrayListExtra);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    WriteData writeData = this.aMT.getWriteData();
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (writeData != null) {
                        writeData.deleteUploadedTempImages();
                    }
                    this.aMT.setWriteData(null);
                    this.aMT.mC(false);
                    this.mVoiceModel = null;
                    this.mVideoInfo = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        t.c(this.mThreadId, (WriteData) null);
                    }
                    bJ(true);
                    if (this.aMZ != null) {
                        this.aMZ.callback(true, postWriteCallBackData, null, writeData, null);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD /* 12009 */:
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    if (i == 12010) {
                        z(intent);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    A(intent);
                    return;
                case 13010:
                    if (Hg() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            am amVar = new am("c10068");
                            amVar.r("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(amVar);
                            HR();
                            Hg().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            Hg().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                        gN(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case IEventCenterService.EventId.EventMode.SAPIACCOUNT_DYNAMICPWD_LOGIN /* 12001 */:
                HO();
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
                if (this.aMZ != null) {
                    this.aMZ.callback(false, postWriteCallBackData2, null, this.aMT.getWriteData(), null);
                    return;
                }
                return;
        }
    }

    public void HH() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(this.mContext.getActivity())));
    }

    public void HI() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.mContext.getActivity())) {
            this.mContext.showToast(d.k.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            HK();
        } else if (this.aMS.bxL()) {
            HH();
        } else {
            this.aMS.mA(false);
            b(1, true, null);
            this.aMS.bxJ();
        }
    }

    public void HJ() {
        if (this.aMS != null && !com.baidu.tieba.tbadkCore.location.c.bxH().bxI() && UtilHelper.isSystemLocationProviderEnabled(this.mContext.getActivity()) && TbadkCoreApplication.getInst().getLocationShared()) {
            this.aMS.bxJ();
        }
    }

    private void HK() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getActivity());
        aVar.cc(d.k.location_app_permission_prompt).a(d.k.isopen, new a.b() { // from class: com.baidu.tbadk.editortools.pb.d.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.jD()) {
                    d.this.b(1, true, null);
                    d.this.aMS.aeS();
                } else {
                    d.this.aNf.HW();
                }
                aVar2.dismiss();
            }
        }).b(d.k.cancel, new a.b() { // from class: com.baidu.tbadk.editortools.pb.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                d.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(this.mContext.getPageContext());
        aVar.xa();
    }

    public void HL() {
        if (this.aMS.aeO()) {
            if (this.aMS.bxL()) {
                this.aNf.a(com.baidu.tieba.tbadkCore.location.c.bxH().getLocationData());
                return;
            }
            if (l.jU()) {
                this.aMS.bxJ();
            }
            b(0, true, null);
            return;
        }
        b(0, false, null);
    }

    public boolean HM() {
        if (StringUtils.isNull(this.aMQ)) {
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
        this.aMT.setWriteData(null);
        this.aMT.mC(false);
        this.mVoiceModel = null;
        this.mVideoInfo = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void HN() {
        this.mVideoInfo = null;
    }

    private void z(Intent intent) {
        this.aMR = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aMR;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.mContext.getActivity(), l.ah(this.mContext.getActivity())), l.dip2px(this.mContext.getActivity(), l.aj(this.mContext.getActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.l.a(TbConfig.LOCAL_CAMERA_DIR, this.aMR, rotateBitmapBydegree, 100);
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
        pbEditorData.setContent(this.aMQ);
        pbEditorData.setWriteImagesInfo(this.writeImagesInfo);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        PbEditorData.ThreadData threadData = new PbEditorData.ThreadData();
        if (this.aMW != null) {
            threadData.setForumId(this.aMW.getId());
            threadData.setForumName(this.aMW.getName());
            threadData.setFirstDir(this.aMW.getFirst_class());
            threadData.setSecondDir(this.aMW.getSecond_class());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.aMX);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.mContext.getActivity(), 25035, pbEditorData, postWriteCallBackData)));
    }

    private void HO() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tbadk.editortools.pb.d.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tbadk.core.util.l.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + d.this.aMR));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void B(Intent intent) {
        b(intent, true);
    }

    public void gK(String str) {
        WriteData writeData = this.aMT.getWriteData();
        if (writeData == null) {
            writeData = new WriteData(1);
            writeData.setThreadId(str);
            writeData.setWriteImagesInfo(this.writeImagesInfo);
        }
        writeData.setContent(this.aMQ);
        writeData.setVideoInfo(this.mVideoInfo);
        t.c(str, writeData);
    }

    public void gL(String str) {
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
                HR();
                Hg().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                    Hg().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                Hg().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            if (!ao.isEmpty(writeData.getContent()) && ao.isEmpty(this.aMQ)) {
                this.aMQ = writeData.getContent();
                gO(this.aMQ);
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
                    Hg().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                Hg().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.aMQ = writeData.getContent();
            gO(this.aMQ);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004008));
        }
    }

    public void onDestroy() {
        this.aMT.cancelLoadData();
        this.aMU.cancelLoadData();
        this.aMS.cancelLoadData();
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        this.aMT = new NewWriteModel(baseActivity);
        this.aMT.b(this.aNh);
        this.aMU = new ImageModel(baseActivity);
        this.aMU.setLoadDataCallBack(this.aNi);
        this.aMS = new LocationModel(baseActivity);
        this.aMS.a(this.aNf);
        this.aMS.a(this.aNg);
        if (bundle != null) {
            this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
            this.aMR = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(10);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && Hg() != null) {
            Hg().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.aMS.aeO() && Hg() != null) {
            Hg().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            Hg().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.writeImagesInfo != null) {
            bundle.putString(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aMR);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.aMT.getWriteData() == null) {
            this.aMT.setWriteData(this.aMV.gH(str));
        }
        if (this.aMT.getWriteData() != null) {
            if (this.aNc) {
                this.aMT.getWriteData().setCanNoForum(true);
                if (this.aMW != null) {
                    this.aMT.getWriteData().setVForumId(this.aMW.getId());
                    this.aMT.getWriteData().setVForumName(this.aMW.getName());
                }
            } else {
                this.aMT.getWriteData().setCanNoForum(false);
                this.aMT.getWriteData().setVForumId("");
                this.aMT.getWriteData().setVForumName("");
            }
            this.aMT.getWriteData().setWriteImagesInfo(this.writeImagesInfo);
            this.aMT.getWriteData().setVideoInfo(this.mVideoInfo);
            this.aMT.mC(this.writeImagesInfo.size() > 0);
            WriteData writeData2 = this.aMT.getWriteData();
            if (this.aMS == null || !this.aMS.aeO()) {
                z = false;
            }
            writeData2.setHasLocationData(z);
            if (str == null) {
                this.aMT.getWriteData().setContent(this.aMQ);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.aMT.getWriteData().setVoice(this.mVoiceModel.getId());
                    this.aMT.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.aMT.getWriteData().setVoice(null);
                    this.aMT.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.aMT.getWriteData().setVoice(null);
                this.aMT.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.aMT.byk()) {
                this.mContext.showToast(d.k.write_img_limit);
            } else if (this.aNb == null || !this.aNb.HD()) {
                if (this.aNa != null) {
                    this.aNa.HE();
                }
                if (!this.aMT.startPostWrite()) {
                }
            }
        }
    }

    public BaseActivity<?> getContext() {
        return this.mContext;
    }

    public void gM(String str) {
        this.aMQ = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int HP() {
        return this.aMY;
    }

    private void HQ() {
        if (Hg() != null) {
            Hg().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void q(ArrayList<String> arrayList) {
        if (Hg() != null) {
            Hg().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void gN(String str) {
        if (Hg() != null) {
            Hg().b(new com.baidu.tbadk.editortools.a(44, 27, str));
        }
    }

    private void HR() {
        if (Hg() != null) {
            Hg().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.aMY = i;
        if (Hg() != null) {
            Hg().b(new com.baidu.tbadk.editortools.a(19, 27, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void gO(String str) {
        if (Hg() != null) {
            Hg().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJ(boolean z) {
        if (Hg() != null) {
            if (z) {
                Hg().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                Hg().b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
            Hg().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.aMZ = dVar;
    }

    public void a(c cVar) {
        this.aNa = cVar;
    }

    public void a(b bVar) {
        this.aNb = bVar;
    }

    public boolean HS() {
        LinkedList<ImageFileInfo> chosedFiles;
        return (this.writeImagesInfo == null || (chosedFiles = this.writeImagesInfo.getChosedFiles()) == null || chosedFiles.isEmpty()) ? false : true;
    }

    public boolean HT() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    private void HU() {
        if (this.aNe == null && Hg() != null) {
            this.aNe = (e) Hg().eM(27);
        }
    }

    public void HV() {
        if (this.aNe != null && this.aNd != null) {
            this.aNe.c(this.aNd);
        }
    }

    public void a(TextWatcher textWatcher) {
        HU();
        if (this.aNe != null && textWatcher != null) {
            this.aNe.b(textWatcher);
        }
    }

    public void Hq() {
        if (this.aKX != null) {
            this.aKX.Hq();
        }
    }
}
