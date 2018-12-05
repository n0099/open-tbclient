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
import com.baidu.tbadk.coreExtra.data.w;
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
    private EditorTools aXW;
    private String aZO;
    private String aZP;
    private LocationModel aZQ;
    private NewWriteModel aZR;
    private ImageModel aZS;
    private DataModel<?> aZT;
    private ForumData aZU;
    private String aZV;
    private int aZW;
    private NewWriteModel.d aZX;
    private c aZY;
    private b aZZ;
    private long authorId;
    private String authorName;
    private String authorNameShow;
    private boolean baa;
    private TextWatcher bab;
    private e bac;
    private LocationModel.a bad;
    private LocationModel.b bae;
    private final NewWriteModel.d baf;
    private final com.baidu.adp.base.d bag;
    private BaseActivity<?> mContext;
    private String mThreadId;
    private VideoInfo mVideoInfo;
    private VoiceData.VoiceModel mVoiceModel;
    private String postId;
    private WriteImagesInfo writeImagesInfo;

    public d(EditorTools editorTools) {
        super(editorTools);
        this.writeImagesInfo = new WriteImagesInfo();
        this.aZO = "";
        this.aZR = null;
        this.aZS = null;
        this.mThreadId = null;
        this.aZV = null;
        this.aZW = 0;
        this.baa = false;
        this.bad = new LocationModel.a() { // from class: com.baidu.tbadk.editortools.pb.d.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void MN() {
                d.this.mContext.showToast(e.j.no_network_guide);
                d.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void dj(String str) {
                BaseActivity baseActivity = d.this.mContext;
                if (StringUtils.isNull(str)) {
                    str = d.this.LX().getContext().getString(e.j.location_fail);
                }
                baseActivity.showToast(str);
                d.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.bDU())) {
                    d.this.b(2, true, aVar.bDU());
                } else {
                    dj(null);
                }
            }
        };
        this.bae = new LocationModel.b() { // from class: com.baidu.tbadk.editortools.pb.d.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void MO() {
                d.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void hS(String str) {
                d.this.b(2, true, str);
            }
        };
        this.baf = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.d.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, w wVar, WriteData writeData, AntiData antiData) {
                WriteData writeData2 = writeData == null ? d.this.aZR.getWriteData() : writeData;
                if (z) {
                    d.this.cy(true);
                    WriteData writeData3 = d.this.aZR.getWriteData();
                    d.this.resetData();
                    t.c(d.this.mThreadId, (WriteData) null);
                    if (writeData3 != null) {
                        if (writeData3 != null && writeData3.getType() == 2) {
                            t.a(writeData3.getThreadId(), d.this);
                        }
                    } else {
                        return;
                    }
                } else if (writeData2 != null && wVar != null && !TextUtils.isEmpty(wVar.GV())) {
                    writeData2.setVcodeMD5(wVar.getVcode_md5());
                    writeData2.setVcodeUrl(wVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(wVar.GW());
                    if (com.baidu.tbadk.r.a.iS(wVar.GV())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(d.this.mContext.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, false, wVar.GV())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(d.this.mContext.getActivity(), writeData2, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(d.this.mContext.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, postWriteCallBackData.getAccessState())));
                }
                d.this.b(d.this.aZR.getWriteData());
                if (d.this.aZX != null) {
                    d.this.aZX.callback(z, postWriteCallBackData, wVar, writeData2, antiData);
                }
            }
        };
        this.bag = new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.editortools.pb.d.7
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (obj instanceof Bitmap) {
                    d.this.aZR.nz(true);
                }
            }
        };
        this.aXW = editorTools;
    }

    public void fQ(int i) {
        if (this.bac == null && LX() != null) {
            this.bac = (e) LX().fK(27);
        }
        if (this.bac != null) {
            this.bac.setType(i);
        }
    }

    public void fR(int i) {
        if (this.bac == null && LX() != null) {
            this.bac = (e) LX().fK(27);
        }
        if (this.bac != null) {
            this.bac.fS(i);
        }
    }

    public e Mw() {
        if (this.bac == null && LX() != null) {
            this.bac = (e) LX().fK(27);
        }
        return this.bac;
    }

    public void hM(String str) {
        if (this.bac == null && LX() != null) {
            this.bac = (e) LX().fK(27);
        }
        if (this.bac != null) {
            this.bac.setHint(str);
        }
    }

    public void cu(boolean z) {
        BLauncher bLauncher;
        if (LX() != null && (bLauncher = (BLauncher) LX().fH(5)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void cv(boolean z) {
        BLauncher bLauncher;
        if (LX() != null && (bLauncher = (BLauncher) LX().fH(23)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void cw(boolean z) {
        BLauncher bLauncher;
        if (LX() != null && (bLauncher = (BLauncher) LX().fH(2)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.aZT = dataModel;
    }

    public void b(BaseActivity<?> baseActivity) {
        this.mContext = baseActivity;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.aZV = antiData.getVoice_message();
        }
    }

    public void a(ForumData forumData, UserData userData) {
        this.aZU = forumData;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (LX() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.authorNameShow = metaData.getName_show();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void cx(boolean z) {
        this.baa = z;
    }

    public void Mx() {
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
                        LX().invalidate();
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_DEL /* 12003 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            MH();
                            this.aZR.nz(false);
                            return;
                        }
                        this.aZS.hL(intent.getStringExtra("file_name"));
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
                    WriteData writeData = this.aZR.getWriteData();
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (writeData != null) {
                        writeData.deleteUploadedTempImages();
                    }
                    this.aZR.setWriteData(null);
                    this.aZR.nz(false);
                    this.mVoiceModel = null;
                    this.mVideoInfo = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        t.c(this.mThreadId, (WriteData) null);
                    }
                    cy(true);
                    if (this.aZX != null) {
                        this.aZX.callback(true, postWriteCallBackData, null, writeData, null);
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
                    if (LX() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            am amVar = new am("c10068");
                            amVar.x("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(amVar);
                            MI();
                            LX().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            LX().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                        hQ(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 12001:
                MF();
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
                if (this.aZX != null) {
                    this.aZX.callback(false, postWriteCallBackData2, null, this.aZR.getWriteData(), null);
                    return;
                }
                return;
        }
    }

    public void My() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(this.mContext.getActivity())));
    }

    public void Mz() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.mContext.getActivity())) {
            this.mContext.showToast(e.j.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            MB();
        } else if (this.aZQ.bEb()) {
            My();
        } else {
            this.aZQ.nx(false);
            b(1, true, null);
            this.aZQ.bDZ();
        }
    }

    public void MA() {
        if (this.aZQ != null && !com.baidu.tieba.tbadkCore.location.c.bDX().bDY() && UtilHelper.isSystemLocationProviderEnabled(this.mContext.getActivity()) && TbadkCoreApplication.getInst().getLocationShared()) {
            this.aZQ.bDZ();
        }
    }

    private void MB() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getActivity());
        aVar.db(e.j.location_app_permission_prompt).a(e.j.isopen, new a.b() { // from class: com.baidu.tbadk.editortools.pb.d.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.kV()) {
                    d.this.b(1, true, null);
                    d.this.aZQ.alQ();
                } else {
                    d.this.bad.MN();
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
        aVar.BF();
    }

    public void MC() {
        if (this.aZQ.alM()) {
            if (this.aZQ.bEb()) {
                this.bad.a(com.baidu.tieba.tbadkCore.location.c.bDX().getLocationData());
                return;
            }
            if (l.ll()) {
                this.aZQ.bDZ();
            }
            b(0, true, null);
            return;
        }
        b(0, false, null);
    }

    public boolean MD() {
        if (StringUtils.isNull(this.aZO)) {
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
        this.aZR.setWriteData(null);
        this.aZR.nz(false);
        this.mVoiceModel = null;
        this.mVideoInfo = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void ME() {
        this.mVideoInfo = null;
    }

    private void A(Intent intent) {
        this.aZP = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aZP;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.mContext.getActivity(), l.aO(this.mContext.getActivity())), l.dip2px(this.mContext.getActivity(), l.aQ(this.mContext.getActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.l.a(TbConfig.LOCAL_CAMERA_DIR, this.aZP, rotateBitmapBydegree, 100);
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
        pbEditorData.setContent(this.aZO);
        pbEditorData.setWriteImagesInfo(this.writeImagesInfo);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        PbEditorData.ThreadData threadData = new PbEditorData.ThreadData();
        if (this.aZU != null) {
            threadData.setForumId(this.aZU.getId());
            threadData.setForumName(this.aZU.getName());
            threadData.setFirstDir(this.aZU.getFirst_class());
            threadData.setSecondDir(this.aZU.getSecond_class());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.aZV);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.mContext.getActivity(), 25035, pbEditorData, postWriteCallBackData)));
    }

    private void MF() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tbadk.editortools.pb.d.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tbadk.core.util.l.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + d.this.aZP));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void C(Intent intent) {
        b(intent, true);
    }

    public void hN(String str) {
        WriteData writeData = this.aZR.getWriteData();
        if (writeData == null) {
            writeData = new WriteData(1);
            writeData.setThreadId(str);
            writeData.setWriteImagesInfo(this.writeImagesInfo);
        }
        writeData.setContent(this.aZO);
        writeData.setVideoInfo(this.mVideoInfo);
        t.c(str, writeData);
    }

    public void hO(String str) {
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
                MI();
                LX().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                    LX().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                LX().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            if (!ao.isEmpty(writeData.getContent()) && ao.isEmpty(this.aZO)) {
                this.aZO = writeData.getContent();
                hR(this.aZO);
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
                    LX().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                LX().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.aZO = writeData.getContent();
            hR(this.aZO);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004008));
        }
    }

    public void onDestroy() {
        this.aZR.cancelLoadData();
        this.aZS.cancelLoadData();
        this.aZQ.cancelLoadData();
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        this.aZR = new NewWriteModel(baseActivity);
        this.aZR.b(this.baf);
        this.aZS = new ImageModel(baseActivity);
        this.aZS.setLoadDataCallBack(this.bag);
        this.aZQ = new LocationModel(baseActivity);
        this.aZQ.a(this.bad);
        this.aZQ.a(this.bae);
        if (bundle != null) {
            this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
            this.aZP = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(10);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && LX() != null) {
            LX().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.aZQ.alM() && LX() != null) {
            LX().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            LX().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.writeImagesInfo != null) {
            bundle.putString(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aZP);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.aZR.getWriteData() == null) {
            this.aZR.setWriteData(this.aZT.hK(str));
        }
        if (this.aZR.getWriteData() != null) {
            if (this.baa) {
                this.aZR.getWriteData().setCanNoForum(true);
                if (this.aZU != null) {
                    this.aZR.getWriteData().setVForumId(this.aZU.getId());
                    this.aZR.getWriteData().setVForumName(this.aZU.getName());
                }
            } else {
                this.aZR.getWriteData().setCanNoForum(false);
                this.aZR.getWriteData().setVForumId("");
                this.aZR.getWriteData().setVForumName("");
            }
            this.aZR.getWriteData().setWriteImagesInfo(this.writeImagesInfo);
            this.aZR.getWriteData().setVideoInfo(this.mVideoInfo);
            this.aZR.nz(this.writeImagesInfo.size() > 0);
            WriteData writeData2 = this.aZR.getWriteData();
            if (this.aZQ == null || !this.aZQ.alM()) {
                z = false;
            }
            writeData2.setHasLocationData(z);
            if (str == null) {
                this.aZR.getWriteData().setContent(this.aZO);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.aZR.getWriteData().setVoice(this.mVoiceModel.getId());
                    this.aZR.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.aZR.getWriteData().setVoice(null);
                    this.aZR.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.aZR.getWriteData().setVoice(null);
                this.aZR.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.aZR.bEE()) {
                this.mContext.showToast(e.j.write_img_limit);
            } else if (this.aZZ == null || !this.aZZ.Mu()) {
                if (this.aZY != null) {
                    this.aZY.Mv();
                }
                if (!this.aZR.startPostWrite()) {
                }
            }
        }
    }

    public BaseActivity<?> getContext() {
        return this.mContext;
    }

    public void hP(String str) {
        this.aZO = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int MG() {
        return this.aZW;
    }

    private void MH() {
        if (LX() != null) {
            LX().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void u(ArrayList<String> arrayList) {
        if (LX() != null) {
            LX().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void hQ(String str) {
        if (LX() != null) {
            LX().b(new com.baidu.tbadk.editortools.a(44, 27, str));
        }
    }

    private void MI() {
        if (LX() != null) {
            LX().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.aZW = i;
        if (LX() != null) {
            LX().b(new com.baidu.tbadk.editortools.a(19, 27, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void hR(String str) {
        if (LX() != null) {
            LX().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cy(boolean z) {
        if (LX() != null) {
            if (z) {
                LX().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                LX().b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
            LX().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.aZX = dVar;
    }

    public void a(c cVar) {
        this.aZY = cVar;
    }

    public void a(b bVar) {
        this.aZZ = bVar;
    }

    public boolean MJ() {
        LinkedList<ImageFileInfo> chosedFiles;
        return (this.writeImagesInfo == null || (chosedFiles = this.writeImagesInfo.getChosedFiles()) == null || chosedFiles.isEmpty()) ? false : true;
    }

    public boolean MK() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    private void ML() {
        if (this.bac == null && LX() != null) {
            this.bac = (e) LX().fK(27);
        }
    }

    public void MM() {
        if (this.bac != null && this.bab != null) {
            this.bac.c(this.bab);
        }
    }

    public void a(TextWatcher textWatcher) {
        ML();
        if (this.bac != null && textWatcher != null) {
            this.bac.b(textWatcher);
        }
    }

    public void Mh() {
        if (this.aXW != null) {
            this.aXW.Mh();
        }
    }
}
