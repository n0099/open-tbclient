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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.u;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class d extends com.baidu.tbadk.editortools.f implements u.a {
    private long authorId;
    private String authorName;
    private String authorNameShow;
    private com.baidu.tbadk.editortools.i brZ;
    private String btU;
    private String btV;
    private LocationModel btW;
    private NewWriteModel btX;
    private ImageModel btY;
    private DataModel<?> btZ;
    private ForumData bua;
    private String bub;
    private int buc;
    private NewWriteModel.d bud;
    private c bue;
    private b bug;
    private boolean buh;
    private TextWatcher bui;
    private e buj;
    private LocationModel.a buk;
    private LocationModel.b bul;
    private final NewWriteModel.d bum;
    private final com.baidu.adp.base.d bun;
    private BaseActivity<?> mContext;
    private String mThreadId;
    private VideoInfo mVideoInfo;
    private VoiceData.VoiceModel mVoiceModel;
    private String postId;
    private WriteImagesInfo writeImagesInfo;

    public d(com.baidu.tbadk.editortools.i iVar) {
        super(iVar);
        this.writeImagesInfo = new WriteImagesInfo();
        this.btU = "";
        this.btX = null;
        this.btY = null;
        this.mThreadId = null;
        this.bub = null;
        this.buc = 0;
        this.buh = false;
        this.buk = new LocationModel.a() { // from class: com.baidu.tbadk.editortools.pb.d.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void LR() {
                d.this.mContext.showToast(d.j.no_network_guide);
                d.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void gA(String str) {
                BaseActivity baseActivity = d.this.mContext;
                if (StringUtils.isNull(str)) {
                    str = d.this.Lc().getContext().getString(d.j.location_fail);
                }
                baseActivity.showToast(str);
                d.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.bxA())) {
                    d.this.b(2, true, aVar.bxA());
                } else {
                    gA(null);
                }
            }
        };
        this.bul = new LocationModel.b() { // from class: com.baidu.tbadk.editortools.pb.d.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void LS() {
                d.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void gB(String str) {
                d.this.b(2, true, str);
            }
        };
        this.bum = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.d.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
                WriteData writeData2 = writeData == null ? d.this.btX.getWriteData() : writeData;
                if (z) {
                    d.this.cn(true);
                    WriteData writeData3 = d.this.btX.getWriteData();
                    d.this.resetData();
                    u.c(d.this.mThreadId, (WriteData) null);
                    if (writeData3 != null) {
                        if (writeData3 != null && writeData3.getType() == 2) {
                            u.a(writeData3.getThreadId(), d.this);
                        }
                    } else {
                        return;
                    }
                } else if (writeData2 != null && tVar != null && !TextUtils.isEmpty(tVar.FX())) {
                    writeData2.setVcodeMD5(tVar.getVcode_md5());
                    writeData2.setVcodeUrl(tVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(tVar.FY());
                    if (com.baidu.tbadk.p.a.hx(tVar.FX())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(d.this.mContext.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, false, tVar.FX())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(d.this.mContext.getActivity(), writeData2, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(d.this.mContext.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, postWriteCallBackData.getAccessState())));
                }
                if (d.this.bud != null) {
                    d.this.bud.callback(z, postWriteCallBackData, tVar, writeData2, antiData);
                }
            }
        };
        this.bun = new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.editortools.pb.d.7
            @Override // com.baidu.adp.base.d
            public void ak(Object obj) {
                if (obj instanceof Bitmap) {
                    d.this.btX.mT(true);
                }
            }
        };
        this.brZ = iVar;
    }

    public void hO(int i) {
        if (this.buj == null && Lc() != null) {
            this.buj = (e) Lc().hI(27);
        }
        if (this.buj != null) {
            this.buj.setType(i);
        }
    }

    public void hP(int i) {
        if (this.buj == null && Lc() != null) {
            this.buj = (e) Lc().hI(27);
        }
        if (this.buj != null) {
            this.buj.hQ(i);
        }
    }

    public e LB() {
        if (this.buj == null && Lc() != null) {
            this.buj = (e) Lc().hI(27);
        }
        return this.buj;
    }

    public void gu(String str) {
        if (this.buj == null && Lc() != null) {
            this.buj = (e) Lc().hI(27);
        }
        if (this.buj != null) {
            this.buj.setHint(str);
        }
    }

    public void cj(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (Lc() != null && (cVar = (com.baidu.tbadk.editortools.c) Lc().hG(5)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void ck(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (Lc() != null && (cVar = (com.baidu.tbadk.editortools.c) Lc().hG(23)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void cl(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (Lc() != null && (cVar = (com.baidu.tbadk.editortools.c) Lc().hG(2)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.btZ = dataModel;
    }

    public void b(BaseActivity<?> baseActivity) {
        this.mContext = baseActivity;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.bub = antiData.getVoice_message();
        }
    }

    public void a(ForumData forumData, UserData userData) {
        this.bua = forumData;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (Lc() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.authorNameShow = metaData.getName_show();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void cm(boolean z) {
        this.buh = z;
    }

    public void LC() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            String valueOf = String.valueOf(this.authorId);
            if (valueOf == null || valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                l.showToast(this.mContext.getActivity(), d.j.can_not_send_gift_to_yourself);
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
                            B(intent);
                        } else {
                            D(intent);
                        }
                        Lc().invalidate();
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_DEL /* 12003 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            LL();
                            this.btX.mT(false);
                            return;
                        }
                        this.btY.gt(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        r(stringArrayListExtra);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    WriteData writeData = this.btX.getWriteData();
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (writeData != null) {
                        writeData.deleteUploadedTempImages();
                    }
                    this.btX.setWriteData(null);
                    this.btX.mT(false);
                    this.mVoiceModel = null;
                    this.mVideoInfo = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        u.c(this.mThreadId, (WriteData) null);
                    }
                    cn(true);
                    if (this.bud != null) {
                        this.bud.callback(true, postWriteCallBackData, null, writeData, null);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD /* 12009 */:
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    if (i == 12010) {
                        B(intent);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    C(intent);
                    return;
                case 13010:
                    if (Lc() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            ak akVar = new ak("c10068");
                            akVar.s("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(akVar);
                            LM();
                            Lc().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            Lc().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                        gy(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case IEventCenterService.EventId.EventMode.SAPIACCOUNT_DYNAMICPWD_LOGIN /* 12001 */:
                LJ();
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
                if (this.bud != null) {
                    this.bud.callback(false, postWriteCallBackData2, null, this.btX.getWriteData(), null);
                    return;
                }
                return;
        }
    }

    public void LD() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(this.mContext.getActivity())));
    }

    public void LE() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.mContext.getActivity())) {
            this.mContext.showToast(d.j.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            LF();
        } else if (this.btW.bxI()) {
            LD();
        } else {
            this.btW.mR(false);
            b(1, true, null);
            this.btW.bxG();
        }
    }

    private void LF() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getActivity());
        aVar.fb(d.j.location_app_permission_prompt).a(d.j.isopen, new a.b() { // from class: com.baidu.tbadk.editortools.pb.d.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.oJ()) {
                    d.this.b(1, true, null);
                    d.this.btW.ahm();
                } else {
                    d.this.buk.LR();
                }
                aVar2.dismiss();
            }
        }).b(d.j.cancel, new a.b() { // from class: com.baidu.tbadk.editortools.pb.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                d.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(this.mContext.getPageContext());
        aVar.AV();
    }

    public void LG() {
        if (this.btW.ahi()) {
            if (this.btW.bxI()) {
                this.buk.a(com.baidu.tieba.tbadkCore.location.c.bxE().getLocationData());
                return;
            }
            if (l.pa()) {
                this.btW.bxG();
            }
            b(0, true, null);
            return;
        }
        b(0, false, null);
    }

    public boolean LH() {
        if (StringUtils.isNull(this.btU)) {
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
        this.btX.setWriteData(null);
        this.btX.mT(false);
        this.mVoiceModel = null;
        this.mVideoInfo = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void LI() {
        this.mVideoInfo = null;
    }

    private void B(Intent intent) {
        this.btV = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.btV;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.mContext.getActivity(), l.ao(this.mContext.getActivity())), l.dip2px(this.mContext.getActivity(), l.aq(this.mContext.getActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    k.a(TbConfig.LOCAL_CAMERA_DIR, this.btV, rotateBitmapBydegree, 100);
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

    private void C(Intent intent) {
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
        pbEditorData.setContent(this.btU);
        pbEditorData.setWriteImagesInfo(this.writeImagesInfo);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        PbEditorData.ThreadData threadData = new PbEditorData.ThreadData();
        if (this.bua != null) {
            threadData.setForumId(this.bua.getId());
            threadData.setForumName(this.bua.getName());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.bub);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.mContext.getActivity(), 25035, pbEditorData, postWriteCallBackData)));
    }

    private void LJ() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tbadk.editortools.pb.d.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                k.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + d.this.btV));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void D(Intent intent) {
        b(intent, true);
    }

    public void gv(String str) {
        WriteData writeData = this.btX.getWriteData();
        if (writeData == null) {
            writeData = new WriteData(1);
            writeData.setThreadId(str);
            writeData.setWriteImagesInfo(this.writeImagesInfo);
        }
        writeData.setContent(this.btU);
        writeData.setVideoInfo(this.mVideoInfo);
        u.c(str, writeData);
    }

    public void gw(String str) {
        u.a(str, this);
    }

    @Override // com.baidu.tieba.tbadkCore.u.a
    public void a(WriteData writeData) {
        if (writeData != null) {
            if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                if (this.mVideoInfo == null) {
                    this.mVideoInfo = new VideoInfo();
                }
                this.mVideoInfo.copy(writeData.getVideoInfo());
                LM();
                Lc().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                    Lc().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                Lc().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            if (!am.isEmpty(writeData.getContent()) && am.isEmpty(this.btU)) {
                this.btU = writeData.getContent();
                gz(this.btU);
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
                    Lc().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                Lc().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.btU = writeData.getContent();
            gz(this.btU);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004008));
        }
    }

    public void onDestroy() {
        this.btX.cancelLoadData();
        this.btY.cancelLoadData();
        this.btW.cancelLoadData();
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        this.btX = new NewWriteModel(baseActivity);
        this.btX.b(this.bum);
        this.btY = new ImageModel(baseActivity);
        this.btY.setLoadDataCallBack(this.bun);
        this.btW = new LocationModel(baseActivity);
        this.btW.a(this.buk);
        this.btW.a(this.bul);
        if (bundle != null) {
            this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
            this.btV = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(10);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && Lc() != null) {
            Lc().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.btW.ahi() && Lc() != null) {
            Lc().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            Lc().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.writeImagesInfo != null) {
            bundle.putString(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.btV);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.btX.getWriteData() == null) {
            this.btX.setWriteData(this.btZ.gr(str));
        }
        if (this.btX.getWriteData() != null) {
            if (this.buh) {
                this.btX.getWriteData().setCanNoForum(true);
                if (this.bua != null) {
                    this.btX.getWriteData().setVForumId(this.bua.getId());
                    this.btX.getWriteData().setVForumName(this.bua.getName());
                }
            } else {
                this.btX.getWriteData().setCanNoForum(false);
                this.btX.getWriteData().setVForumId("");
                this.btX.getWriteData().setVForumName("");
            }
            this.btX.getWriteData().setWriteImagesInfo(this.writeImagesInfo);
            this.btX.getWriteData().setVideoInfo(this.mVideoInfo);
            this.btX.mT(this.writeImagesInfo.size() > 0);
            WriteData writeData2 = this.btX.getWriteData();
            if (this.btW == null || !this.btW.ahi()) {
                z = false;
            }
            writeData2.setHasLocationData(z);
            if (str == null) {
                this.btX.getWriteData().setContent(this.btU);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.btX.getWriteData().setVoice(this.mVoiceModel.getId());
                    this.btX.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.btX.getWriteData().setVoice(null);
                    this.btX.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.btX.getWriteData().setVoice(null);
                this.btX.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.btX.byh()) {
                this.mContext.showToast(d.j.write_img_limit);
            } else if (this.bug == null || !this.bug.Lz()) {
                if (this.bue != null) {
                    this.bue.LA();
                }
                if (!this.btX.startPostWrite()) {
                }
            }
        }
    }

    public BaseActivity<?> getContext() {
        return this.mContext;
    }

    public void gx(String str) {
        this.btU = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int LK() {
        return this.buc;
    }

    private void LL() {
        if (Lc() != null) {
            Lc().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void r(ArrayList<String> arrayList) {
        if (Lc() != null) {
            Lc().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void gy(String str) {
        if (Lc() != null) {
            Lc().b(new com.baidu.tbadk.editortools.a(44, 27, str));
        }
    }

    private void LM() {
        if (Lc() != null) {
            Lc().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.buc = i;
        if (Lc() != null) {
            Lc().b(new com.baidu.tbadk.editortools.a(19, 27, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void gz(String str) {
        if (Lc() != null) {
            Lc().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cn(boolean z) {
        if (Lc() != null) {
            if (z) {
                Lc().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                Lc().b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
            Lc().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.bud = dVar;
    }

    public void a(c cVar) {
        this.bue = cVar;
    }

    public void a(b bVar) {
        this.bug = bVar;
    }

    public boolean LN() {
        LinkedList<ImageFileInfo> chosedFiles;
        return (this.writeImagesInfo == null || (chosedFiles = this.writeImagesInfo.getChosedFiles()) == null || chosedFiles.isEmpty()) ? false : true;
    }

    public boolean LO() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    private void LP() {
        if (this.buj == null && Lc() != null) {
            this.buj = (e) Lc().hI(27);
        }
    }

    public void LQ() {
        if (this.buj != null && this.bui != null) {
            this.buj.c(this.bui);
        }
    }

    public void a(TextWatcher textWatcher) {
        LP();
        if (this.buj != null && textWatcher != null) {
            this.buj.b(textWatcher);
        }
    }

    public void Lm() {
        if (this.brZ != null) {
            this.brZ.Lm();
        }
    }
}
