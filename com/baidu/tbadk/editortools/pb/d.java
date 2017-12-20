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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.s;
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
    private com.baidu.tbadk.editortools.i aBG;
    private String aDB;
    private String aDC;
    private LocationModel aDD;
    private NewWriteModel aDE;
    private ImageModel aDF;
    private DataModel<?> aDG;
    private ForumData aDH;
    private String aDI;
    private int aDJ;
    private NewWriteModel.d aDK;
    private c aDL;
    private b aDM;
    private boolean aDN;
    private TextWatcher aDO;
    private e aDP;
    private LocationModel.a aDQ;
    private LocationModel.b aDR;
    private final NewWriteModel.d aDS;
    private final com.baidu.adp.base.d aDT;
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
        this.aDB = "";
        this.aDE = null;
        this.aDF = null;
        this.mThreadId = null;
        this.aDI = null;
        this.aDJ = 0;
        this.aDN = false;
        this.aDQ = new LocationModel.a() { // from class: com.baidu.tbadk.editortools.pb.d.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void DT() {
                d.this.mContext.showToast(d.j.no_network_guide);
                d.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void ga(String str) {
                BaseActivity baseActivity = d.this.mContext;
                if (StringUtils.isNull(str)) {
                    str = d.this.De().getContext().getString(d.j.location_fail);
                }
                baseActivity.showToast(str);
                d.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.bxy())) {
                    d.this.a(2, true, aVar.bxy());
                } else {
                    ga(null);
                }
            }
        };
        this.aDR = new LocationModel.b() { // from class: com.baidu.tbadk.editortools.pb.d.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void DU() {
                d.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void gb(String str) {
                d.this.a(2, true, str);
            }
        };
        this.aDS = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.d.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, s sVar, WriteData writeData, AntiData antiData) {
                WriteData writeData2 = writeData == null ? d.this.aDE.getWriteData() : writeData;
                if (z) {
                    d.this.bG(true);
                    WriteData writeData3 = d.this.aDE.getWriteData();
                    d.this.resetData();
                    t.d(d.this.mThreadId, (WriteData) null);
                    if (writeData3 != null) {
                        if (writeData3 != null && writeData3.getType() == 2) {
                            t.a(writeData3.getThreadId(), d.this);
                        }
                    } else {
                        return;
                    }
                } else if (writeData2 != null && sVar != null && !TextUtils.isEmpty(sVar.yj())) {
                    writeData2.setVcodeMD5(sVar.getVcode_md5());
                    writeData2.setVcodeUrl(sVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(sVar.yk());
                    if (com.baidu.tbadk.p.a.hc(sVar.yj())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(d.this.mContext.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, false, sVar.yj())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(d.this.mContext.getActivity(), writeData2, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(d.this.mContext.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, postWriteCallBackData.getAccessState())));
                }
                if (d.this.aDK != null) {
                    d.this.aDK.callback(z, postWriteCallBackData, sVar, writeData2, antiData);
                }
            }
        };
        this.aDT = new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.editortools.pb.d.7
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                if (obj instanceof Bitmap) {
                    d.this.aDE.ni(true);
                }
            }
        };
        this.aBG = iVar;
    }

    public void eV(int i) {
        if (this.aDP == null && De() != null) {
            this.aDP = (e) De().eP(27);
        }
        if (this.aDP != null) {
            this.aDP.setType(i);
        }
    }

    public void eW(int i) {
        if (this.aDP == null && De() != null) {
            this.aDP = (e) De().eP(27);
        }
        if (this.aDP != null) {
            this.aDP.eY(i);
        }
    }

    public e DC() {
        if (this.aDP == null && De() != null) {
            this.aDP = (e) De().eP(27);
        }
        return this.aDP;
    }

    public void fU(String str) {
        if (this.aDP == null && De() != null) {
            this.aDP = (e) De().eP(27);
        }
        if (this.aDP != null) {
            this.aDP.setHint(str);
        }
    }

    public void bC(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (De() != null && (cVar = (com.baidu.tbadk.editortools.c) De().eN(5)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bD(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (De() != null && (cVar = (com.baidu.tbadk.editortools.c) De().eN(23)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bE(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (De() != null && (cVar = (com.baidu.tbadk.editortools.c) De().eN(2)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.aDG = dataModel;
    }

    public void d(BaseActivity<?> baseActivity) {
        this.mContext = baseActivity;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.aDI = antiData.getVoice_message();
        }
    }

    public void a(ForumData forumData, UserData userData) {
        this.aDH = forumData;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (De() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.authorNameShow = metaData.getName_show();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void bF(boolean z) {
        this.aDN = z;
    }

    public void DD() {
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.mContext.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                    return;
                case 11026:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.mContext.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_MODIFY, true)));
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            z(intent);
                        } else {
                            B(intent);
                        }
                        De().invalidate();
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_DEL /* 12003 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            DM();
                            this.aDE.ni(false);
                            return;
                        }
                        this.aDF.fT(intent.getStringExtra("file_name"));
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
                    WriteData writeData = this.aDE.getWriteData();
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (writeData != null) {
                        writeData.deleteUploadedTempImages();
                    }
                    this.aDE.setWriteData(null);
                    this.aDE.ni(false);
                    this.mVoiceModel = null;
                    this.mVideoInfo = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        t.d(this.mThreadId, (WriteData) null);
                    }
                    bG(true);
                    if (this.aDK != null) {
                        this.aDK.callback(true, postWriteCallBackData, null, writeData, null);
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
                    if (De() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            ak akVar = new ak("c10068");
                            akVar.r("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(akVar);
                            DN();
                            De().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            De().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                        fY(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case IEventCenterService.EventId.EventMode.SAPIACCOUNT_DYNAMICPWD_LOGIN /* 12001 */:
                DK();
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
                if (this.aDK != null) {
                    this.aDK.callback(false, postWriteCallBackData2, null, this.aDE.getWriteData(), null);
                    return;
                }
                return;
        }
    }

    public void DE() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.mContext.getActivity())));
    }

    public void DF() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.mContext.getActivity())) {
            this.mContext.showToast(d.j.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            DG();
        } else if (this.aDD.bxG()) {
            DE();
        } else {
            this.aDD.ng(false);
            a(1, true, (String) null);
            this.aDD.bxE();
        }
    }

    private void DG() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getActivity());
        aVar.cd(d.j.location_app_permission_prompt).a(d.j.isopen, new a.b() { // from class: com.baidu.tbadk.editortools.pb.d.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.hh()) {
                    d.this.a(1, true, (String) null);
                    d.this.aDD.YN();
                } else {
                    d.this.aDQ.DT();
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
        aVar.th();
    }

    public void DH() {
        if (this.aDD.YJ()) {
            if (this.aDD.bxG()) {
                this.aDQ.a(com.baidu.tieba.tbadkCore.location.c.bxC().getLocationData());
                return;
            }
            if (l.hy()) {
                this.aDD.bxE();
            }
            a(0, true, (String) null);
            return;
        }
        a(0, false, (String) null);
    }

    public boolean DI() {
        if (StringUtils.isNull(this.aDB)) {
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
        this.aDE.setWriteData(null);
        this.aDE.ni(false);
        this.mVoiceModel = null;
        this.mVideoInfo = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void DJ() {
        this.mVideoInfo = null;
    }

    private void z(Intent intent) {
        this.aDC = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aDC;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.mContext.getActivity(), l.ac(this.mContext.getActivity())), l.dip2px(this.mContext.getActivity(), l.ae(this.mContext.getActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    k.a(TbConfig.LOCAL_CAMERA_DIR, this.aDC, rotateBitmapBydegree, 100);
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
        pbEditorData.setContent(this.aDB);
        pbEditorData.setWriteImagesInfo(this.writeImagesInfo);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        PbEditorData.ThreadData threadData = new PbEditorData.ThreadData();
        if (this.aDH != null) {
            threadData.setForumId(this.aDH.getId());
            threadData.setForumName(this.aDH.getName());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.aDI);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.mContext.getActivity(), 25035, pbEditorData, postWriteCallBackData)));
    }

    private void DK() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tbadk.editortools.pb.d.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                k.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + d.this.aDC));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void B(Intent intent) {
        b(intent, true);
    }

    public void fV(String str) {
        WriteData writeData = this.aDE.getWriteData();
        if (writeData == null) {
            writeData = new WriteData(1);
            writeData.setThreadId(str);
            writeData.setWriteImagesInfo(this.writeImagesInfo);
        }
        writeData.setContent(this.aDB);
        writeData.setVideoInfo(this.mVideoInfo);
        t.d(str, writeData);
    }

    public void fW(String str) {
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
                DN();
                De().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                    De().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                De().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            if (!am.isEmpty(writeData.getContent()) && am.isEmpty(this.aDB)) {
                this.aDB = writeData.getContent();
                fZ(this.aDB);
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
                    De().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                De().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.aDB = writeData.getContent();
            fZ(this.aDB);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.aDE.cancelLoadData();
        this.aDF.cancelLoadData();
        this.aDD.cancelLoadData();
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        this.aDE = new NewWriteModel(baseActivity);
        this.aDE.b(this.aDS);
        this.aDF = new ImageModel(baseActivity);
        this.aDF.setLoadDataCallBack(this.aDT);
        this.aDD = new LocationModel(baseActivity);
        this.aDD.a(this.aDQ);
        this.aDD.a(this.aDR);
        if (bundle != null) {
            this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
            this.aDC = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(10);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && De() != null) {
            De().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.aDD.YJ() && De() != null) {
            De().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            De().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.writeImagesInfo != null) {
            bundle.putString(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aDC);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.aDE.getWriteData() == null) {
            this.aDE.setWriteData(this.aDG.fS(str));
        }
        if (this.aDE.getWriteData() != null) {
            if (this.aDN) {
                this.aDE.getWriteData().setCanNoForum(true);
                if (this.aDH != null) {
                    this.aDE.getWriteData().setVForumId(this.aDH.getId());
                    this.aDE.getWriteData().setVForumName(this.aDH.getName());
                }
            } else {
                this.aDE.getWriteData().setCanNoForum(false);
                this.aDE.getWriteData().setVForumId("");
                this.aDE.getWriteData().setVForumName("");
            }
            this.aDE.getWriteData().setWriteImagesInfo(this.writeImagesInfo);
            this.aDE.getWriteData().setVideoInfo(this.mVideoInfo);
            this.aDE.ni(this.writeImagesInfo.size() > 0);
            WriteData writeData2 = this.aDE.getWriteData();
            if (this.aDD == null || !this.aDD.YJ()) {
                z = false;
            }
            writeData2.setHasLocationData(z);
            if (str == null) {
                this.aDE.getWriteData().setContent(this.aDB);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.aDE.getWriteData().setVoice(this.mVoiceModel.getId());
                    this.aDE.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.aDE.getWriteData().setVoice(null);
                    this.aDE.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.aDE.getWriteData().setVoice(null);
                this.aDE.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.aDE.byc()) {
                this.mContext.showToast(d.j.write_img_limit);
            } else if (this.aDM == null || !this.aDM.DA()) {
                if (this.aDL != null) {
                    this.aDL.DB();
                }
                if (!this.aDE.startPostWrite()) {
                }
            }
        }
    }

    public BaseActivity<?> getContext() {
        return this.mContext;
    }

    public void fX(String str) {
        this.aDB = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int DL() {
        return this.aDJ;
    }

    private void DM() {
        if (De() != null) {
            De().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void q(ArrayList<String> arrayList) {
        if (De() != null) {
            De().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void fY(String str) {
        if (De() != null) {
            De().b(new com.baidu.tbadk.editortools.a(44, 27, str));
        }
    }

    private void DN() {
        if (De() != null) {
            De().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.aDJ = i;
        if (De() != null) {
            De().b(new com.baidu.tbadk.editortools.a(19, 27, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void fZ(String str) {
        if (De() != null) {
            De().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bG(boolean z) {
        if (De() != null) {
            if (z) {
                De().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                De().b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
            De().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.aDK = dVar;
    }

    public void a(c cVar) {
        this.aDL = cVar;
    }

    public void a(b bVar) {
        this.aDM = bVar;
    }

    public void DO() {
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            this.writeImagesInfo.clear();
        }
        if (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) {
            this.mVideoInfo = null;
        }
        De().b(new com.baidu.tbadk.editortools.a(2, 19, null));
        setVoiceModel(null);
        De().b(new com.baidu.tbadk.editortools.a(2, 6, null));
        De().b(new com.baidu.tbadk.editortools.a(33, 6, null));
        if (!StringUtils.isNull(this.aDB)) {
            this.aDB = "";
        }
        fZ("");
        this.aDE.setWriteData(null);
        this.aDE.ni(false);
    }

    public boolean DP() {
        LinkedList<ImageFileInfo> chosedFiles;
        return (this.writeImagesInfo == null || (chosedFiles = this.writeImagesInfo.getChosedFiles()) == null || chosedFiles.isEmpty()) ? false : true;
    }

    public boolean DQ() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    public void eX(final int i) {
        DR();
        if (this.aDP != null && (this.aDP.aBT instanceof LinearLayout)) {
            final EditText inputView = this.aDP.getInputView();
            if (this.aDO == null) {
                this.aDO = new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.d.8
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
                            if (!StringUtils.isNull(obj) && w.gX(obj) > i) {
                                String e = w.e(obj, 0, i - 1);
                                inputView.setText(e);
                                inputView.setSelection(inputView.getText().length());
                                UtilHelper.showToast(d.this.getContext().getApplication(), d.this.getContext().getResources().getString(d.j.edit_text_over_limit_tip, Integer.valueOf(e.length())));
                            }
                        }
                    }
                };
            }
            this.aDP.b(this.aDO);
        }
    }

    private void DR() {
        if (this.aDP == null && De() != null) {
            this.aDP = (e) De().eP(27);
        }
    }

    public void DS() {
        if (this.aDP != null && this.aDO != null) {
            this.aDP.c(this.aDO);
        }
    }

    public void a(TextWatcher textWatcher) {
        DR();
        if (this.aDP != null && textWatcher != null) {
            this.aDP.b(textWatcher);
        }
    }

    public void Do() {
        if (this.aBG != null) {
            this.aBG.Do();
        }
    }
}
