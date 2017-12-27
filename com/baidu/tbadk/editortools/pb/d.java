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
    private com.baidu.tbadk.editortools.i bpE;
    private LocationModel brA;
    private NewWriteModel brB;
    private ImageModel brC;
    private DataModel<?> brD;
    private ForumData brE;
    private String brF;
    private int brG;
    private NewWriteModel.d brH;
    private c brI;
    private b brJ;
    private boolean brK;
    private TextWatcher brL;
    private e brM;
    private LocationModel.a brN;
    private LocationModel.b brO;
    private final NewWriteModel.d brP;
    private final com.baidu.adp.base.d brQ;
    private String bry;
    private String brz;
    private BaseActivity<?> mContext;
    private String mThreadId;
    private VideoInfo mVideoInfo;
    private VoiceData.VoiceModel mVoiceModel;
    private String postId;
    private WriteImagesInfo writeImagesInfo;

    public d(com.baidu.tbadk.editortools.i iVar) {
        super(iVar);
        this.writeImagesInfo = new WriteImagesInfo();
        this.bry = "";
        this.brB = null;
        this.brC = null;
        this.mThreadId = null;
        this.brF = null;
        this.brG = 0;
        this.brK = false;
        this.brN = new LocationModel.a() { // from class: com.baidu.tbadk.editortools.pb.d.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void Lu() {
                d.this.mContext.showToast(d.j.no_network_guide);
                d.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void gh(String str) {
                BaseActivity baseActivity = d.this.mContext;
                if (StringUtils.isNull(str)) {
                    str = d.this.KF().getContext().getString(d.j.location_fail);
                }
                baseActivity.showToast(str);
                d.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.bCP())) {
                    d.this.b(2, true, aVar.bCP());
                } else {
                    gh(null);
                }
            }
        };
        this.brO = new LocationModel.b() { // from class: com.baidu.tbadk.editortools.pb.d.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void Lv() {
                d.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void gi(String str) {
                d.this.b(2, true, str);
            }
        };
        this.brP = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.d.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, s sVar, WriteData writeData, AntiData antiData) {
                WriteData writeData2 = writeData == null ? d.this.brB.getWriteData() : writeData;
                if (z) {
                    d.this.ck(true);
                    WriteData writeData3 = d.this.brB.getWriteData();
                    d.this.resetData();
                    u.c(d.this.mThreadId, (WriteData) null);
                    if (writeData3 != null) {
                        if (writeData3 != null && writeData3.getType() == 2) {
                            u.a(writeData3.getThreadId(), d.this);
                        }
                    } else {
                        return;
                    }
                } else if (writeData2 != null && sVar != null && !TextUtils.isEmpty(sVar.FI())) {
                    writeData2.setVcodeMD5(sVar.getVcode_md5());
                    writeData2.setVcodeUrl(sVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(sVar.FJ());
                    if (com.baidu.tbadk.p.a.hf(sVar.FI())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(d.this.mContext.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, false, sVar.FI())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(d.this.mContext.getActivity(), writeData2, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(d.this.mContext.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, postWriteCallBackData.getAccessState())));
                }
                if (d.this.brH != null) {
                    d.this.brH.callback(z, postWriteCallBackData, sVar, writeData2, antiData);
                }
            }
        };
        this.brQ = new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.editortools.pb.d.7
            @Override // com.baidu.adp.base.d
            public void ak(Object obj) {
                if (obj instanceof Bitmap) {
                    d.this.brB.nC(true);
                }
            }
        };
        this.bpE = iVar;
    }

    public void hT(int i) {
        if (this.brM == null && KF() != null) {
            this.brM = (e) KF().hN(27);
        }
        if (this.brM != null) {
            this.brM.setType(i);
        }
    }

    public void hU(int i) {
        if (this.brM == null && KF() != null) {
            this.brM = (e) KF().hN(27);
        }
        if (this.brM != null) {
            this.brM.hW(i);
        }
    }

    public e Ld() {
        if (this.brM == null && KF() != null) {
            this.brM = (e) KF().hN(27);
        }
        return this.brM;
    }

    public void gb(String str) {
        if (this.brM == null && KF() != null) {
            this.brM = (e) KF().hN(27);
        }
        if (this.brM != null) {
            this.brM.setHint(str);
        }
    }

    public void cg(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (KF() != null && (cVar = (com.baidu.tbadk.editortools.c) KF().hL(5)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void ch(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (KF() != null && (cVar = (com.baidu.tbadk.editortools.c) KF().hL(23)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void ci(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (KF() != null && (cVar = (com.baidu.tbadk.editortools.c) KF().hL(2)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.brD = dataModel;
    }

    public void d(BaseActivity<?> baseActivity) {
        this.mContext = baseActivity;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.brF = antiData.getVoice_message();
        }
    }

    public void a(ForumData forumData, UserData userData) {
        this.brE = forumData;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (KF() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.authorNameShow = metaData.getName_show();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void cj(boolean z) {
        this.brK = z;
    }

    public void Le() {
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
                            B(intent);
                        } else {
                            D(intent);
                        }
                        KF().invalidate();
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_DEL /* 12003 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            Ln();
                            this.brB.nC(false);
                            return;
                        }
                        this.brC.ga(intent.getStringExtra("file_name"));
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
                    WriteData writeData = this.brB.getWriteData();
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (writeData != null) {
                        writeData.deleteUploadedTempImages();
                    }
                    this.brB.setWriteData(null);
                    this.brB.nC(false);
                    this.mVoiceModel = null;
                    this.mVideoInfo = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        u.c(this.mThreadId, (WriteData) null);
                    }
                    ck(true);
                    if (this.brH != null) {
                        this.brH.callback(true, postWriteCallBackData, null, writeData, null);
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
                    if (KF() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            ak akVar = new ak("c10068");
                            akVar.s("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(akVar);
                            Lo();
                            KF().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            KF().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                        gf(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case IEventCenterService.EventId.EventMode.SAPIACCOUNT_DYNAMICPWD_LOGIN /* 12001 */:
                Ll();
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
                if (this.brH != null) {
                    this.brH.callback(false, postWriteCallBackData2, null, this.brB.getWriteData(), null);
                    return;
                }
                return;
        }
    }

    public void Lf() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.mContext.getActivity())));
    }

    public void Lg() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.mContext.getActivity())) {
            this.mContext.showToast(d.j.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            Lh();
        } else if (this.brA.bCX()) {
            Lf();
        } else {
            this.brA.nA(false);
            b(1, true, null);
            this.brA.bCV();
        }
    }

    private void Lh() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getActivity());
        aVar.fd(d.j.location_app_permission_prompt).a(d.j.isopen, new a.b() { // from class: com.baidu.tbadk.editortools.pb.d.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.oI()) {
                    d.this.b(1, true, null);
                    d.this.brA.agv();
                } else {
                    d.this.brN.Lu();
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
        aVar.AI();
    }

    public void Li() {
        if (this.brA.agr()) {
            if (this.brA.bCX()) {
                this.brN.a(com.baidu.tieba.tbadkCore.location.c.bCT().getLocationData());
                return;
            }
            if (l.oZ()) {
                this.brA.bCV();
            }
            b(0, true, null);
            return;
        }
        b(0, false, null);
    }

    public boolean Lj() {
        if (StringUtils.isNull(this.bry)) {
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
        this.brB.setWriteData(null);
        this.brB.nC(false);
        this.mVoiceModel = null;
        this.mVideoInfo = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void Lk() {
        this.mVideoInfo = null;
    }

    private void B(Intent intent) {
        this.brz = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.brz;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.mContext.getActivity(), l.ao(this.mContext.getActivity())), l.dip2px(this.mContext.getActivity(), l.aq(this.mContext.getActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    k.a(TbConfig.LOCAL_CAMERA_DIR, this.brz, rotateBitmapBydegree, 100);
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
        pbEditorData.setContent(this.bry);
        pbEditorData.setWriteImagesInfo(this.writeImagesInfo);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        PbEditorData.ThreadData threadData = new PbEditorData.ThreadData();
        if (this.brE != null) {
            threadData.setForumId(this.brE.getId());
            threadData.setForumName(this.brE.getName());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.brF);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.mContext.getActivity(), 25035, pbEditorData, postWriteCallBackData)));
    }

    private void Ll() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tbadk.editortools.pb.d.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                k.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + d.this.brz));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void D(Intent intent) {
        b(intent, true);
    }

    public void gc(String str) {
        WriteData writeData = this.brB.getWriteData();
        if (writeData == null) {
            writeData = new WriteData(1);
            writeData.setThreadId(str);
            writeData.setWriteImagesInfo(this.writeImagesInfo);
        }
        writeData.setContent(this.bry);
        writeData.setVideoInfo(this.mVideoInfo);
        u.c(str, writeData);
    }

    public void gd(String str) {
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
                Lo();
                KF().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                    KF().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                KF().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            if (!am.isEmpty(writeData.getContent()) && am.isEmpty(this.bry)) {
                this.bry = writeData.getContent();
                gg(this.bry);
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
                    KF().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                KF().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.bry = writeData.getContent();
            gg(this.bry);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.brB.cancelLoadData();
        this.brC.cancelLoadData();
        this.brA.cancelLoadData();
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        this.brB = new NewWriteModel(baseActivity);
        this.brB.b(this.brP);
        this.brC = new ImageModel(baseActivity);
        this.brC.setLoadDataCallBack(this.brQ);
        this.brA = new LocationModel(baseActivity);
        this.brA.a(this.brN);
        this.brA.a(this.brO);
        if (bundle != null) {
            this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
            this.brz = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(10);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && KF() != null) {
            KF().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.brA.agr() && KF() != null) {
            KF().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            KF().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.writeImagesInfo != null) {
            bundle.putString(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.brz);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.brB.getWriteData() == null) {
            this.brB.setWriteData(this.brD.fZ(str));
        }
        if (this.brB.getWriteData() != null) {
            if (this.brK) {
                this.brB.getWriteData().setCanNoForum(true);
                if (this.brE != null) {
                    this.brB.getWriteData().setVForumId(this.brE.getId());
                    this.brB.getWriteData().setVForumName(this.brE.getName());
                }
            } else {
                this.brB.getWriteData().setCanNoForum(false);
                this.brB.getWriteData().setVForumId("");
                this.brB.getWriteData().setVForumName("");
            }
            this.brB.getWriteData().setWriteImagesInfo(this.writeImagesInfo);
            this.brB.getWriteData().setVideoInfo(this.mVideoInfo);
            this.brB.nC(this.writeImagesInfo.size() > 0);
            WriteData writeData2 = this.brB.getWriteData();
            if (this.brA == null || !this.brA.agr()) {
                z = false;
            }
            writeData2.setHasLocationData(z);
            if (str == null) {
                this.brB.getWriteData().setContent(this.bry);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.brB.getWriteData().setVoice(this.mVoiceModel.getId());
                    this.brB.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.brB.getWriteData().setVoice(null);
                    this.brB.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.brB.getWriteData().setVoice(null);
                this.brB.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.brB.bDu()) {
                this.mContext.showToast(d.j.write_img_limit);
            } else if (this.brJ == null || !this.brJ.Lb()) {
                if (this.brI != null) {
                    this.brI.Lc();
                }
                if (!this.brB.startPostWrite()) {
                }
            }
        }
    }

    public BaseActivity<?> getContext() {
        return this.mContext;
    }

    public void ge(String str) {
        this.bry = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int Lm() {
        return this.brG;
    }

    private void Ln() {
        if (KF() != null) {
            KF().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void r(ArrayList<String> arrayList) {
        if (KF() != null) {
            KF().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void gf(String str) {
        if (KF() != null) {
            KF().b(new com.baidu.tbadk.editortools.a(44, 27, str));
        }
    }

    private void Lo() {
        if (KF() != null) {
            KF().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.brG = i;
        if (KF() != null) {
            KF().b(new com.baidu.tbadk.editortools.a(19, 27, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void gg(String str) {
        if (KF() != null) {
            KF().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ck(boolean z) {
        if (KF() != null) {
            if (z) {
                KF().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                KF().b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
            KF().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.brH = dVar;
    }

    public void a(c cVar) {
        this.brI = cVar;
    }

    public void a(b bVar) {
        this.brJ = bVar;
    }

    public void Lp() {
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            this.writeImagesInfo.clear();
        }
        if (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) {
            this.mVideoInfo = null;
        }
        KF().b(new com.baidu.tbadk.editortools.a(2, 19, null));
        setVoiceModel(null);
        KF().b(new com.baidu.tbadk.editortools.a(2, 6, null));
        KF().b(new com.baidu.tbadk.editortools.a(33, 6, null));
        if (!StringUtils.isNull(this.bry)) {
            this.bry = "";
        }
        gg("");
        this.brB.setWriteData(null);
        this.brB.nC(false);
    }

    public boolean Lq() {
        LinkedList<ImageFileInfo> chosedFiles;
        return (this.writeImagesInfo == null || (chosedFiles = this.writeImagesInfo.getChosedFiles()) == null || chosedFiles.isEmpty()) ? false : true;
    }

    public boolean Lr() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    public void hV(final int i) {
        Ls();
        if (this.brM != null && (this.brM.bpR instanceof LinearLayout)) {
            final EditText inputView = this.brM.getInputView();
            if (this.brL == null) {
                this.brL = new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.d.8
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
                            if (!StringUtils.isNull(obj) && w.ha(obj) > i) {
                                String j = w.j(obj, 0, i - 1);
                                inputView.setText(j);
                                inputView.setSelection(inputView.getText().length());
                                UtilHelper.showToast(d.this.getContext().getApplication(), d.this.getContext().getResources().getString(d.j.edit_text_over_limit_tip, Integer.valueOf(j.length())));
                            }
                        }
                    }
                };
            }
            this.brM.b(this.brL);
        }
    }

    private void Ls() {
        if (this.brM == null && KF() != null) {
            this.brM = (e) KF().hN(27);
        }
    }

    public void Lt() {
        if (this.brM != null && this.brL != null) {
            this.brM.c(this.brL);
        }
    }

    public void a(TextWatcher textWatcher) {
        Ls();
        if (this.brM != null && textWatcher != null) {
            this.brM.b(textWatcher);
        }
    }

    public void KP() {
        if (this.bpE != null) {
            this.bpE.KP();
        }
    }
}
