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
import com.baidu.tbadk.core.util.ap;
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
    private EditorTools aLT;
    private String aNM;
    private String aNN;
    private LocationModel aNO;
    private NewWriteModel aNP;
    private ImageModel aNQ;
    private DataModel<?> aNR;
    private ForumData aNS;
    private String aNT;
    private int aNU;
    private NewWriteModel.d aNV;
    private c aNW;
    private b aNX;
    private boolean aNY;
    private TextWatcher aNZ;
    private e aOa;
    private LocationModel.a aOb;
    private LocationModel.b aOc;
    private final NewWriteModel.d aOd;
    private final com.baidu.adp.base.d aOe;
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
        this.aNM = "";
        this.aNP = null;
        this.aNQ = null;
        this.mThreadId = null;
        this.aNT = null;
        this.aNU = 0;
        this.aNY = false;
        this.aOb = new LocationModel.a() { // from class: com.baidu.tbadk.editortools.pb.d.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void Io() {
                d.this.mContext.showToast(d.k.no_network_guide);
                d.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void gT(String str) {
                BaseActivity baseActivity = d.this.mContext;
                if (StringUtils.isNull(str)) {
                    str = d.this.Hy().getContext().getString(d.k.location_fail);
                }
                baseActivity.showToast(str);
                d.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.byg())) {
                    d.this.b(2, true, aVar.byg());
                } else {
                    gT(null);
                }
            }
        };
        this.aOc = new LocationModel.b() { // from class: com.baidu.tbadk.editortools.pb.d.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void Ip() {
                d.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void gU(String str) {
                d.this.b(2, true, str);
            }
        };
        this.aOd = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.d.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.t tVar, WriteData writeData, AntiData antiData) {
                WriteData writeData2 = writeData == null ? d.this.aNP.getWriteData() : writeData;
                if (z) {
                    d.this.bM(true);
                    WriteData writeData3 = d.this.aNP.getWriteData();
                    d.this.resetData();
                    t.c(d.this.mThreadId, (WriteData) null);
                    if (writeData3 != null) {
                        if (writeData3 != null && writeData3.getType() == 2) {
                            t.a(writeData3.getThreadId(), d.this);
                        }
                    } else {
                        return;
                    }
                } else if (writeData2 != null && tVar != null && !TextUtils.isEmpty(tVar.CB())) {
                    writeData2.setVcodeMD5(tVar.getVcode_md5());
                    writeData2.setVcodeUrl(tVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(tVar.CC());
                    if (com.baidu.tbadk.p.a.hQ(tVar.CB())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(d.this.mContext.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, false, tVar.CB())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(d.this.mContext.getActivity(), writeData2, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(d.this.mContext.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, postWriteCallBackData.getAccessState())));
                }
                if (d.this.aNV != null) {
                    d.this.aNV.callback(z, postWriteCallBackData, tVar, writeData2, antiData);
                }
            }
        };
        this.aOe = new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.editortools.pb.d.7
            @Override // com.baidu.adp.base.d
            public void i(Object obj) {
                if (obj instanceof Bitmap) {
                    d.this.aNP.mN(true);
                }
            }
        };
        this.aLT = editorTools;
    }

    public void eT(int i) {
        if (this.aOa == null && Hy() != null) {
            this.aOa = (e) Hy().eN(27);
        }
        if (this.aOa != null) {
            this.aOa.setType(i);
        }
    }

    public void eU(int i) {
        if (this.aOa == null && Hy() != null) {
            this.aOa = (e) Hy().eN(27);
        }
        if (this.aOa != null) {
            this.aOa.eV(i);
        }
    }

    public e HX() {
        if (this.aOa == null && Hy() != null) {
            this.aOa = (e) Hy().eN(27);
        }
        return this.aOa;
    }

    public void gN(String str) {
        if (this.aOa == null && Hy() != null) {
            this.aOa = (e) Hy().eN(27);
        }
        if (this.aOa != null) {
            this.aOa.setHint(str);
        }
    }

    public void bI(boolean z) {
        BLauncher bLauncher;
        if (Hy() != null && (bLauncher = (BLauncher) Hy().eK(5)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void bJ(boolean z) {
        BLauncher bLauncher;
        if (Hy() != null && (bLauncher = (BLauncher) Hy().eK(23)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void bK(boolean z) {
        BLauncher bLauncher;
        if (Hy() != null && (bLauncher = (BLauncher) Hy().eK(2)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.aNR = dataModel;
    }

    public void b(BaseActivity<?> baseActivity) {
        this.mContext = baseActivity;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.aNT = antiData.getVoice_message();
        }
    }

    public void a(ForumData forumData, UserData userData) {
        this.aNS = forumData;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (Hy() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.authorNameShow = metaData.getName_show();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void bL(boolean z) {
        this.aNY = z;
    }

    public void HY() {
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
                case SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE /* 11001 */:
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
                        Hy().invalidate();
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_DEL /* 12003 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            Ii();
                            this.aNP.mN(false);
                            return;
                        }
                        this.aNQ.gM(intent.getStringExtra("file_name"));
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
                    WriteData writeData = this.aNP.getWriteData();
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (writeData != null) {
                        writeData.deleteUploadedTempImages();
                    }
                    this.aNP.setWriteData(null);
                    this.aNP.mN(false);
                    this.mVoiceModel = null;
                    this.mVideoInfo = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        t.c(this.mThreadId, (WriteData) null);
                    }
                    bM(true);
                    if (this.aNV != null) {
                        this.aNV.callback(true, postWriteCallBackData, null, writeData, null);
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
                    if (Hy() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            an anVar = new an("c10068");
                            anVar.r("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(anVar);
                            Ij();
                            Hy().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            Hy().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                        gR(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 12001:
                Ig();
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
                if (this.aNV != null) {
                    this.aNV.callback(false, postWriteCallBackData2, null, this.aNP.getWriteData(), null);
                    return;
                }
                return;
        }
    }

    public void HZ() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(this.mContext.getActivity())));
    }

    public void Ia() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.mContext.getActivity())) {
            this.mContext.showToast(d.k.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            Ic();
        } else if (this.aNO.byo()) {
            HZ();
        } else {
            this.aNO.mL(false);
            b(1, true, null);
            this.aNO.bym();
        }
    }

    public void Ib() {
        if (this.aNO != null && !com.baidu.tieba.tbadkCore.location.c.byk().byl() && UtilHelper.isSystemLocationProviderEnabled(this.mContext.getActivity()) && TbadkCoreApplication.getInst().getLocationShared()) {
            this.aNO.bym();
        }
    }

    private void Ic() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getActivity());
        aVar.cd(d.k.location_app_permission_prompt).a(d.k.isopen, new a.b() { // from class: com.baidu.tbadk.editortools.pb.d.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.jD()) {
                    d.this.b(1, true, null);
                    d.this.aNO.afA();
                } else {
                    d.this.aOb.Io();
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
        aVar.xn();
    }

    public void Id() {
        if (this.aNO.afw()) {
            if (this.aNO.byo()) {
                this.aOb.a(com.baidu.tieba.tbadkCore.location.c.byk().getLocationData());
                return;
            }
            if (l.jU()) {
                this.aNO.bym();
            }
            b(0, true, null);
            return;
        }
        b(0, false, null);
    }

    public boolean Ie() {
        if (StringUtils.isNull(this.aNM)) {
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
        this.aNP.setWriteData(null);
        this.aNP.mN(false);
        this.mVoiceModel = null;
        this.mVideoInfo = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void If() {
        this.mVideoInfo = null;
    }

    private void z(Intent intent) {
        this.aNN = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aNN;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.mContext.getActivity(), l.ah(this.mContext.getActivity())), l.dip2px(this.mContext.getActivity(), l.aj(this.mContext.getActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.l.a(TbConfig.LOCAL_CAMERA_DIR, this.aNN, rotateBitmapBydegree, 100);
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
        pbEditorData.setContent(this.aNM);
        pbEditorData.setWriteImagesInfo(this.writeImagesInfo);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        PbEditorData.ThreadData threadData = new PbEditorData.ThreadData();
        if (this.aNS != null) {
            threadData.setForumId(this.aNS.getId());
            threadData.setForumName(this.aNS.getName());
            threadData.setFirstDir(this.aNS.getFirst_class());
            threadData.setSecondDir(this.aNS.getSecond_class());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.aNT);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.mContext.getActivity(), 25035, pbEditorData, postWriteCallBackData)));
    }

    private void Ig() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tbadk.editortools.pb.d.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tbadk.core.util.l.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + d.this.aNN));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void B(Intent intent) {
        b(intent, true);
    }

    public void gO(String str) {
        WriteData writeData = this.aNP.getWriteData();
        if (writeData == null) {
            writeData = new WriteData(1);
            writeData.setThreadId(str);
            writeData.setWriteImagesInfo(this.writeImagesInfo);
        }
        writeData.setContent(this.aNM);
        writeData.setVideoInfo(this.mVideoInfo);
        t.c(str, writeData);
    }

    public void gP(String str) {
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
                Ij();
                Hy().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                    Hy().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                Hy().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            if (!ap.isEmpty(writeData.getContent()) && ap.isEmpty(this.aNM)) {
                this.aNM = writeData.getContent();
                gS(this.aNM);
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
                    Hy().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                Hy().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.aNM = writeData.getContent();
            gS(this.aNM);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004008));
        }
    }

    public void onDestroy() {
        this.aNP.cancelLoadData();
        this.aNQ.cancelLoadData();
        this.aNO.cancelLoadData();
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        this.aNP = new NewWriteModel(baseActivity);
        this.aNP.b(this.aOd);
        this.aNQ = new ImageModel(baseActivity);
        this.aNQ.setLoadDataCallBack(this.aOe);
        this.aNO = new LocationModel(baseActivity);
        this.aNO.a(this.aOb);
        this.aNO.a(this.aOc);
        if (bundle != null) {
            this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
            this.aNN = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(10);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && Hy() != null) {
            Hy().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.aNO.afw() && Hy() != null) {
            Hy().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            Hy().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.writeImagesInfo != null) {
            bundle.putString(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aNN);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.aNP.getWriteData() == null) {
            this.aNP.setWriteData(this.aNR.gL(str));
        }
        if (this.aNP.getWriteData() != null) {
            if (this.aNY) {
                this.aNP.getWriteData().setCanNoForum(true);
                if (this.aNS != null) {
                    this.aNP.getWriteData().setVForumId(this.aNS.getId());
                    this.aNP.getWriteData().setVForumName(this.aNS.getName());
                }
            } else {
                this.aNP.getWriteData().setCanNoForum(false);
                this.aNP.getWriteData().setVForumId("");
                this.aNP.getWriteData().setVForumName("");
            }
            this.aNP.getWriteData().setWriteImagesInfo(this.writeImagesInfo);
            this.aNP.getWriteData().setVideoInfo(this.mVideoInfo);
            this.aNP.mN(this.writeImagesInfo.size() > 0);
            WriteData writeData2 = this.aNP.getWriteData();
            if (this.aNO == null || !this.aNO.afw()) {
                z = false;
            }
            writeData2.setHasLocationData(z);
            if (str == null) {
                this.aNP.getWriteData().setContent(this.aNM);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.aNP.getWriteData().setVoice(this.mVoiceModel.getId());
                    this.aNP.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.aNP.getWriteData().setVoice(null);
                    this.aNP.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.aNP.getWriteData().setVoice(null);
                this.aNP.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.aNP.byO()) {
                this.mContext.showToast(d.k.write_img_limit);
            } else if (this.aNX == null || !this.aNX.HV()) {
                if (this.aNW != null) {
                    this.aNW.HW();
                }
                if (!this.aNP.startPostWrite()) {
                }
            }
        }
    }

    public BaseActivity<?> getContext() {
        return this.mContext;
    }

    public void gQ(String str) {
        this.aNM = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int Ih() {
        return this.aNU;
    }

    private void Ii() {
        if (Hy() != null) {
            Hy().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void u(ArrayList<String> arrayList) {
        if (Hy() != null) {
            Hy().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void gR(String str) {
        if (Hy() != null) {
            Hy().b(new com.baidu.tbadk.editortools.a(44, 27, str));
        }
    }

    private void Ij() {
        if (Hy() != null) {
            Hy().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.aNU = i;
        if (Hy() != null) {
            Hy().b(new com.baidu.tbadk.editortools.a(19, 27, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void gS(String str) {
        if (Hy() != null) {
            Hy().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bM(boolean z) {
        if (Hy() != null) {
            if (z) {
                Hy().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                Hy().b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
            Hy().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.aNV = dVar;
    }

    public void a(c cVar) {
        this.aNW = cVar;
    }

    public void a(b bVar) {
        this.aNX = bVar;
    }

    public boolean Ik() {
        LinkedList<ImageFileInfo> chosedFiles;
        return (this.writeImagesInfo == null || (chosedFiles = this.writeImagesInfo.getChosedFiles()) == null || chosedFiles.isEmpty()) ? false : true;
    }

    public boolean Il() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    private void Im() {
        if (this.aOa == null && Hy() != null) {
            this.aOa = (e) Hy().eN(27);
        }
    }

    public void In() {
        if (this.aOa != null && this.aNZ != null) {
            this.aOa.c(this.aNZ);
        }
    }

    public void a(TextWatcher textWatcher) {
        Im();
        if (this.aOa != null && textWatcher != null) {
            this.aOa.b(textWatcher);
        }
    }

    public void HI() {
        if (this.aLT != null) {
            this.aLT.HI();
        }
    }
}
