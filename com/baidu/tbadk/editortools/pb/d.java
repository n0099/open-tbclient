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
import com.baidu.tbadk.coreExtra.data.v;
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
    private EditorTools aTJ;
    private String aVB;
    private String aVC;
    private LocationModel aVD;
    private NewWriteModel aVE;
    private ImageModel aVF;
    private DataModel<?> aVG;
    private ForumData aVH;
    private String aVI;
    private int aVJ;
    private NewWriteModel.d aVK;
    private c aVL;
    private b aVM;
    private boolean aVN;
    private TextWatcher aVO;
    private e aVP;
    private LocationModel.a aVQ;
    private LocationModel.b aVR;
    private final NewWriteModel.d aVS;
    private final com.baidu.adp.base.d aVT;
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
        this.aVB = "";
        this.aVE = null;
        this.aVF = null;
        this.mThreadId = null;
        this.aVI = null;
        this.aVJ = 0;
        this.aVN = false;
        this.aVQ = new LocationModel.a() { // from class: com.baidu.tbadk.editortools.pb.d.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void Lx() {
                d.this.mContext.showToast(e.j.no_network_guide);
                d.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void hz(String str) {
                BaseActivity baseActivity = d.this.mContext;
                if (StringUtils.isNull(str)) {
                    str = d.this.KH().getContext().getString(e.j.location_fail);
                }
                baseActivity.showToast(str);
                d.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.bCD())) {
                    d.this.b(2, true, aVar.bCD());
                } else {
                    hz(null);
                }
            }
        };
        this.aVR = new LocationModel.b() { // from class: com.baidu.tbadk.editortools.pb.d.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void Ly() {
                d.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void hA(String str) {
                d.this.b(2, true, str);
            }
        };
        this.aVS = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.d.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, v vVar, WriteData writeData, AntiData antiData) {
                WriteData writeData2 = writeData == null ? d.this.aVE.getWriteData() : writeData;
                if (z) {
                    d.this.cg(true);
                    WriteData writeData3 = d.this.aVE.getWriteData();
                    d.this.resetData();
                    t.c(d.this.mThreadId, (WriteData) null);
                    if (writeData3 != null) {
                        if (writeData3 != null && writeData3.getType() == 2) {
                            t.a(writeData3.getThreadId(), d.this);
                        }
                    } else {
                        return;
                    }
                } else if (writeData2 != null && vVar != null && !TextUtils.isEmpty(vVar.FF())) {
                    writeData2.setVcodeMD5(vVar.getVcode_md5());
                    writeData2.setVcodeUrl(vVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(vVar.FG());
                    if (com.baidu.tbadk.q.a.iy(vVar.FF())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(d.this.mContext.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, false, vVar.FF())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(d.this.mContext.getActivity(), writeData2, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(d.this.mContext.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, postWriteCallBackData.getAccessState())));
                }
                d.this.b(d.this.aVE.getWriteData());
                if (d.this.aVK != null) {
                    d.this.aVK.callback(z, postWriteCallBackData, vVar, writeData2, antiData);
                }
            }
        };
        this.aVT = new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.editortools.pb.d.7
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (obj instanceof Bitmap) {
                    d.this.aVE.nm(true);
                }
            }
        };
        this.aTJ = editorTools;
    }

    public void fo(int i) {
        if (this.aVP == null && KH() != null) {
            this.aVP = (e) KH().fi(27);
        }
        if (this.aVP != null) {
            this.aVP.setType(i);
        }
    }

    public void fp(int i) {
        if (this.aVP == null && KH() != null) {
            this.aVP = (e) KH().fi(27);
        }
        if (this.aVP != null) {
            this.aVP.fq(i);
        }
    }

    public e Lg() {
        if (this.aVP == null && KH() != null) {
            this.aVP = (e) KH().fi(27);
        }
        return this.aVP;
    }

    public void ht(String str) {
        if (this.aVP == null && KH() != null) {
            this.aVP = (e) KH().fi(27);
        }
        if (this.aVP != null) {
            this.aVP.setHint(str);
        }
    }

    public void cc(boolean z) {
        BLauncher bLauncher;
        if (KH() != null && (bLauncher = (BLauncher) KH().ff(5)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void cd(boolean z) {
        BLauncher bLauncher;
        if (KH() != null && (bLauncher = (BLauncher) KH().ff(23)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void ce(boolean z) {
        BLauncher bLauncher;
        if (KH() != null && (bLauncher = (BLauncher) KH().ff(2)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.aVG = dataModel;
    }

    public void b(BaseActivity<?> baseActivity) {
        this.mContext = baseActivity;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.aVI = antiData.getVoice_message();
        }
    }

    public void a(ForumData forumData, UserData userData) {
        this.aVH = forumData;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (KH() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.authorNameShow = metaData.getName_show();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void cf(boolean z) {
        this.aVN = z;
    }

    public void Lh() {
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
                        KH().invalidate();
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_DEL /* 12003 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            Lr();
                            this.aVE.nm(false);
                            return;
                        }
                        this.aVF.hs(intent.getStringExtra("file_name"));
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
                    WriteData writeData = this.aVE.getWriteData();
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (writeData != null) {
                        writeData.deleteUploadedTempImages();
                    }
                    this.aVE.setWriteData(null);
                    this.aVE.nm(false);
                    this.mVoiceModel = null;
                    this.mVideoInfo = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        t.c(this.mThreadId, (WriteData) null);
                    }
                    cg(true);
                    if (this.aVK != null) {
                        this.aVK.callback(true, postWriteCallBackData, null, writeData, null);
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
                    if (KH() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            am amVar = new am("c10068");
                            amVar.x("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(amVar);
                            Ls();
                            KH().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            KH().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                        hx(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 12001:
                Lp();
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
                if (this.aVK != null) {
                    this.aVK.callback(false, postWriteCallBackData2, null, this.aVE.getWriteData(), null);
                    return;
                }
                return;
        }
    }

    public void Li() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(this.mContext.getActivity())));
    }

    public void Lj() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.mContext.getActivity())) {
            this.mContext.showToast(e.j.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            Ll();
        } else if (this.aVD.bCL()) {
            Li();
        } else {
            this.aVD.nk(false);
            b(1, true, null);
            this.aVD.bCJ();
        }
    }

    public void Lk() {
        if (this.aVD != null && !com.baidu.tieba.tbadkCore.location.c.bCH().bCI() && UtilHelper.isSystemLocationProviderEnabled(this.mContext.getActivity()) && TbadkCoreApplication.getInst().getLocationShared()) {
            this.aVD.bCJ();
        }
    }

    private void Ll() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getActivity());
        aVar.cz(e.j.location_app_permission_prompt).a(e.j.isopen, new a.b() { // from class: com.baidu.tbadk.editortools.pb.d.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.kX()) {
                    d.this.b(1, true, null);
                    d.this.aVD.aln();
                } else {
                    d.this.aVQ.Lx();
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
        aVar.Au();
    }

    public void Lm() {
        if (this.aVD.alj()) {
            if (this.aVD.bCL()) {
                this.aVQ.a(com.baidu.tieba.tbadkCore.location.c.bCH().getLocationData());
                return;
            }
            if (l.lo()) {
                this.aVD.bCJ();
            }
            b(0, true, null);
            return;
        }
        b(0, false, null);
    }

    public boolean Ln() {
        if (StringUtils.isNull(this.aVB)) {
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
        this.aVE.setWriteData(null);
        this.aVE.nm(false);
        this.mVoiceModel = null;
        this.mVideoInfo = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void Lo() {
        this.mVideoInfo = null;
    }

    private void A(Intent intent) {
        this.aVC = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aVC;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.mContext.getActivity(), l.aO(this.mContext.getActivity())), l.dip2px(this.mContext.getActivity(), l.aQ(this.mContext.getActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.l.a(TbConfig.LOCAL_CAMERA_DIR, this.aVC, rotateBitmapBydegree, 100);
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
        pbEditorData.setContent(this.aVB);
        pbEditorData.setWriteImagesInfo(this.writeImagesInfo);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        PbEditorData.ThreadData threadData = new PbEditorData.ThreadData();
        if (this.aVH != null) {
            threadData.setForumId(this.aVH.getId());
            threadData.setForumName(this.aVH.getName());
            threadData.setFirstDir(this.aVH.getFirst_class());
            threadData.setSecondDir(this.aVH.getSecond_class());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.aVI);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.mContext.getActivity(), 25035, pbEditorData, postWriteCallBackData)));
    }

    private void Lp() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tbadk.editortools.pb.d.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tbadk.core.util.l.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + d.this.aVC));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void C(Intent intent) {
        b(intent, true);
    }

    public void hu(String str) {
        WriteData writeData = this.aVE.getWriteData();
        if (writeData == null) {
            writeData = new WriteData(1);
            writeData.setThreadId(str);
            writeData.setWriteImagesInfo(this.writeImagesInfo);
        }
        writeData.setContent(this.aVB);
        writeData.setVideoInfo(this.mVideoInfo);
        t.c(str, writeData);
    }

    public void hv(String str) {
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
                Ls();
                KH().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                    KH().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                KH().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            if (!ao.isEmpty(writeData.getContent()) && ao.isEmpty(this.aVB)) {
                this.aVB = writeData.getContent();
                hy(this.aVB);
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
                    KH().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                KH().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.aVB = writeData.getContent();
            hy(this.aVB);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004008));
        }
    }

    public void onDestroy() {
        this.aVE.cancelLoadData();
        this.aVF.cancelLoadData();
        this.aVD.cancelLoadData();
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        this.aVE = new NewWriteModel(baseActivity);
        this.aVE.b(this.aVS);
        this.aVF = new ImageModel(baseActivity);
        this.aVF.setLoadDataCallBack(this.aVT);
        this.aVD = new LocationModel(baseActivity);
        this.aVD.a(this.aVQ);
        this.aVD.a(this.aVR);
        if (bundle != null) {
            this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
            this.aVC = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(10);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && KH() != null) {
            KH().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.aVD.alj() && KH() != null) {
            KH().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            KH().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.writeImagesInfo != null) {
            bundle.putString(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aVC);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.aVE.getWriteData() == null) {
            this.aVE.setWriteData(this.aVG.hr(str));
        }
        if (this.aVE.getWriteData() != null) {
            if (this.aVN) {
                this.aVE.getWriteData().setCanNoForum(true);
                if (this.aVH != null) {
                    this.aVE.getWriteData().setVForumId(this.aVH.getId());
                    this.aVE.getWriteData().setVForumName(this.aVH.getName());
                }
            } else {
                this.aVE.getWriteData().setCanNoForum(false);
                this.aVE.getWriteData().setVForumId("");
                this.aVE.getWriteData().setVForumName("");
            }
            this.aVE.getWriteData().setWriteImagesInfo(this.writeImagesInfo);
            this.aVE.getWriteData().setVideoInfo(this.mVideoInfo);
            this.aVE.nm(this.writeImagesInfo.size() > 0);
            WriteData writeData2 = this.aVE.getWriteData();
            if (this.aVD == null || !this.aVD.alj()) {
                z = false;
            }
            writeData2.setHasLocationData(z);
            if (str == null) {
                this.aVE.getWriteData().setContent(this.aVB);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.aVE.getWriteData().setVoice(this.mVoiceModel.getId());
                    this.aVE.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.aVE.getWriteData().setVoice(null);
                    this.aVE.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.aVE.getWriteData().setVoice(null);
                this.aVE.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.aVE.bDo()) {
                this.mContext.showToast(e.j.write_img_limit);
            } else if (this.aVM == null || !this.aVM.Le()) {
                if (this.aVL != null) {
                    this.aVL.Lf();
                }
                if (!this.aVE.startPostWrite()) {
                }
            }
        }
    }

    public BaseActivity<?> getContext() {
        return this.mContext;
    }

    public void hw(String str) {
        this.aVB = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int Lq() {
        return this.aVJ;
    }

    private void Lr() {
        if (KH() != null) {
            KH().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void u(ArrayList<String> arrayList) {
        if (KH() != null) {
            KH().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void hx(String str) {
        if (KH() != null) {
            KH().b(new com.baidu.tbadk.editortools.a(44, 27, str));
        }
    }

    private void Ls() {
        if (KH() != null) {
            KH().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.aVJ = i;
        if (KH() != null) {
            KH().b(new com.baidu.tbadk.editortools.a(19, 27, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void hy(String str) {
        if (KH() != null) {
            KH().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cg(boolean z) {
        if (KH() != null) {
            if (z) {
                KH().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                KH().b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
            KH().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.aVK = dVar;
    }

    public void a(c cVar) {
        this.aVL = cVar;
    }

    public void a(b bVar) {
        this.aVM = bVar;
    }

    public boolean Lt() {
        LinkedList<ImageFileInfo> chosedFiles;
        return (this.writeImagesInfo == null || (chosedFiles = this.writeImagesInfo.getChosedFiles()) == null || chosedFiles.isEmpty()) ? false : true;
    }

    public boolean Lu() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    private void Lv() {
        if (this.aVP == null && KH() != null) {
            this.aVP = (e) KH().fi(27);
        }
    }

    public void Lw() {
        if (this.aVP != null && this.aVO != null) {
            this.aVP.c(this.aVO);
        }
    }

    public void a(TextWatcher textWatcher) {
        Lv();
        if (this.aVP != null && textWatcher != null) {
            this.aVP.b(textWatcher);
        }
    }

    public void KR() {
        if (this.aTJ != null) {
            this.aTJ.KR();
        }
    }
}
