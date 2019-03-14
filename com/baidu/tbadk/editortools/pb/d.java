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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.coreExtra.data.x;
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
import com.baidu.ubc.UBC;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class d extends com.baidu.tbadk.editortools.d implements t.a {
    private long authorId;
    private String authorName;
    private String authorNameShow;
    private EditorTools cih;
    private String ckb;
    private String ckc;
    private LocationModel ckd;
    private NewWriteModel cke;
    private ImageModel ckf;
    private DataModel<?> ckg;
    private ForumData ckh;
    private String cki;
    private int ckj;
    private NewWriteModel.d ckk;
    private c ckl;
    private b ckm;
    private boolean ckn;
    private TextWatcher cko;
    private e ckp;
    private LocationModel.a ckq;
    private LocationModel.b ckr;
    private final NewWriteModel.d cks;
    private final com.baidu.adp.base.d ckt;
    private BaseActivity<?> mContext;
    private String mThreadId;
    private VideoInfo mVideoInfo;
    private VoiceData.VoiceModel mVoiceModel;
    private String postId;
    private WriteImagesInfo writeImagesInfo;

    public d(EditorTools editorTools) {
        super(editorTools);
        this.writeImagesInfo = new WriteImagesInfo();
        this.ckb = "";
        this.cke = null;
        this.ckf = null;
        this.mThreadId = null;
        this.cki = null;
        this.ckj = 0;
        this.ckn = false;
        this.ckq = new LocationModel.a() { // from class: com.baidu.tbadk.editortools.pb.d.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void amJ() {
                d.this.mContext.showToast(d.j.no_network_guide);
                d.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                BaseActivity baseActivity = d.this.mContext;
                if (StringUtils.isNull(str)) {
                    str = d.this.alS().getContext().getString(d.j.location_fail);
                }
                baseActivity.showToast(str);
                d.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.ceW())) {
                    d.this.b(2, true, aVar.ceW());
                } else {
                    onFail(null);
                }
            }
        };
        this.ckr = new LocationModel.b() { // from class: com.baidu.tbadk.editortools.pb.d.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void amK() {
                d.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void oV(String str) {
                d.this.b(2, true, str);
            }
        };
        this.cks = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.d.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
                WriteData writeData2 = writeData == null ? d.this.cke.getWriteData() : writeData;
                if (z) {
                    d.this.eP(true);
                    WriteData writeData3 = d.this.cke.getWriteData();
                    d.this.resetData();
                    t.d(d.this.mThreadId, (WriteData) null);
                    if (writeData3 != null) {
                        if (writeData3 != null && writeData3.getType() == 2) {
                            t.a(writeData3.getThreadId(), d.this);
                        }
                    } else {
                        return;
                    }
                } else if (writeData2 != null && xVar != null && !TextUtils.isEmpty(xVar.agD())) {
                    writeData2.setVcodeMD5(xVar.getVcode_md5());
                    writeData2.setVcodeUrl(xVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(xVar.agE());
                    if (com.baidu.tbadk.u.a.pT(xVar.agD())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(d.this.mContext.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, false, xVar.agD())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(d.this.mContext.getActivity(), writeData2, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(d.this.mContext.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData2, postWriteCallBackData.getAccessState())));
                }
                d.this.b(d.this.cke.getWriteData());
                if (d.this.ckk != null) {
                    d.this.ckk.callback(z, postWriteCallBackData, xVar, writeData2, antiData);
                }
            }
        };
        this.ckt = new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.editortools.pb.d.7
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (obj instanceof Bitmap) {
                    d.this.cke.qd(true);
                }
            }
        };
        this.cih = editorTools;
    }

    public void jC(int i) {
        if (this.ckp == null && alS() != null) {
            this.ckp = (e) alS().jw(27);
        }
        if (this.ckp != null) {
            this.ckp.setType(i);
        }
    }

    public void jD(int i) {
        if (this.ckp == null && alS() != null) {
            this.ckp = (e) alS().jw(27);
        }
        if (this.ckp != null) {
            this.ckp.jE(i);
        }
    }

    public e ams() {
        if (this.ckp == null && alS() != null) {
            this.ckp = (e) alS().jw(27);
        }
        return this.ckp;
    }

    public void oP(String str) {
        if (this.ckp == null && alS() != null) {
            this.ckp = (e) alS().jw(27);
        }
        if (this.ckp != null) {
            this.ckp.setHint(str);
        }
    }

    public void eL(boolean z) {
        BLauncher bLauncher;
        if (alS() != null && (bLauncher = (BLauncher) alS().jt(5)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void eM(boolean z) {
        BLauncher bLauncher;
        if (alS() != null && (bLauncher = (BLauncher) alS().jt(23)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void eN(boolean z) {
        BLauncher bLauncher;
        if (alS() != null && (bLauncher = (BLauncher) alS().jt(2)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.ckg = dataModel;
    }

    public void b(BaseActivity<?> baseActivity) {
        this.mContext = baseActivity;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.cki = antiData.getVoice_message();
        }
    }

    public void a(ForumData forumData, UserData userData) {
        this.ckh = forumData;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (alS() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.authorNameShow = metaData.getName_show();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void eO(boolean z) {
        this.ckn = z;
    }

    public void amt() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            String valueOf = String.valueOf(this.authorId);
            if (valueOf == null || valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                l.showToast(this.mContext.getActivity(), d.j.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(this.mContext.getActivity(), this.authorId, this.authorName, this.authorNameShow, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.g.b.d(this.mThreadId, 0L), com.baidu.adp.lib.g.b.d(this.postId, 0L))));
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
                            O(intent);
                        } else {
                            Q(intent);
                        }
                        alS().invalidate();
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_DEL /* 12003 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            amD();
                            this.cke.qd(false);
                            return;
                        }
                        this.ckf.oO(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        w(stringArrayListExtra);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    WriteData writeData = this.cke.getWriteData();
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (writeData != null) {
                        writeData.deleteUploadedTempImages();
                    }
                    this.cke.setWriteData(null);
                    this.cke.qd(false);
                    this.mVoiceModel = null;
                    this.mVideoInfo = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        t.d(this.mThreadId, (WriteData) null);
                    }
                    eP(true);
                    if (this.ckk != null) {
                        this.ckk.callback(true, postWriteCallBackData, null, writeData, null);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD /* 12009 */:
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    if (i == 12010) {
                        O(intent);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    P(intent);
                    return;
                case 13010:
                    if (alS() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            am amVar = new am("c10068");
                            amVar.T(UBC.CONTENT_KEY_DURATION, this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(amVar);
                            amE();
                            alS().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            alS().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                        oT(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 12001:
                amB();
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
                if (this.ckk != null) {
                    this.ckk.callback(false, postWriteCallBackData2, null, this.cke.getWriteData(), null);
                    return;
                }
                return;
        }
    }

    public void amu() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(this.mContext.getActivity())));
    }

    public void amv() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.mContext.getActivity())) {
            this.mContext.showToast(d.j.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            amx();
        } else if (this.ckd.cfd()) {
            amu();
        } else {
            this.ckd.qb(false);
            b(1, true, null);
            this.ckd.cfb();
        }
    }

    public void amw() {
        if (this.ckd != null && !com.baidu.tieba.tbadkCore.location.c.ceZ().cfa() && UtilHelper.isSystemLocationProviderEnabled(this.mContext.getActivity()) && TbadkCoreApplication.getInst().getLocationShared()) {
            this.ckd.cfb();
        }
    }

    private void amx() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getActivity());
        aVar.gD(d.j.location_app_permission_prompt).a(d.j.isopen, new a.b() { // from class: com.baidu.tbadk.editortools.pb.d.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.kY()) {
                    d.this.b(1, true, null);
                    d.this.ckd.aNJ();
                } else {
                    d.this.ckq.amJ();
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
        aVar.aaZ();
    }

    public void amy() {
        if (this.ckd.aNF()) {
            if (this.ckd.cfd()) {
                this.ckq.a(com.baidu.tieba.tbadkCore.location.c.ceZ().getLocationData());
                return;
            }
            if (l.lo()) {
                this.ckd.cfb();
            }
            b(0, true, null);
            return;
        }
        b(0, false, null);
    }

    public boolean amz() {
        if (StringUtils.isNull(this.ckb)) {
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
        this.cke.setWriteData(null);
        this.cke.qd(false);
        this.mVoiceModel = null;
        this.mVideoInfo = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void amA() {
        this.mVideoInfo = null;
    }

    private void O(Intent intent) {
        this.ckc = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.ckc;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.mContext.getActivity(), l.aO(this.mContext.getActivity())), l.dip2px(this.mContext.getActivity(), l.aQ(this.mContext.getActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    m.a(TbConfig.LOCAL_CAMERA_DIR, this.ckc, rotateBitmapBydegree, 100);
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

    private void P(Intent intent) {
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
        pbEditorData.setContent(this.ckb);
        pbEditorData.setWriteImagesInfo(this.writeImagesInfo);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        PbEditorData.ThreadData threadData = new PbEditorData.ThreadData();
        if (this.ckh != null) {
            threadData.setForumId(this.ckh.getId());
            threadData.setForumName(this.ckh.getName());
            threadData.setFirstDir(this.ckh.getFirst_class());
            threadData.setSecondDir(this.ckh.getSecond_class());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.cki);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.mContext.getActivity(), 25035, pbEditorData, postWriteCallBackData)));
    }

    public void c(p pVar) {
        if (pVar != null) {
            if (pVar.agt() == EmotionGroupType.BIG_EMOTION || pVar.agt() == EmotionGroupType.USER_COLLECT) {
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

    private void amB() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tbadk.editortools.pb.d.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                m.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + d.this.ckc));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void Q(Intent intent) {
        b(intent, true);
    }

    public void oQ(String str) {
        WriteData writeData = this.cke.getWriteData();
        if (writeData == null) {
            writeData = new WriteData(1);
            writeData.setThreadId(str);
            writeData.setWriteImagesInfo(this.writeImagesInfo);
        }
        writeData.setContent(this.ckb);
        writeData.setVideoInfo(this.mVideoInfo);
        t.d(str, writeData);
    }

    public void oR(String str) {
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
                amE();
                alS().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                    alS().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                alS().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            if (!ap.isEmpty(writeData.getContent()) && ap.isEmpty(this.ckb)) {
                this.ckb = writeData.getContent();
                oU(this.ckb);
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
                    alS().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                alS().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.ckb = writeData.getContent();
            oU(this.ckb);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004008));
        }
    }

    public void onDestroy() {
        this.cke.cancelLoadData();
        this.ckf.cancelLoadData();
        this.ckd.cancelLoadData();
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        this.cke = new NewWriteModel(baseActivity);
        this.cke.b(this.cks);
        this.ckf = new ImageModel(baseActivity);
        this.ckf.setLoadDataCallBack(this.ckt);
        this.ckd = new LocationModel(baseActivity);
        this.ckd.a(this.ckq);
        this.ckd.a(this.ckr);
        if (bundle != null) {
            this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
            this.ckc = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(9);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && alS() != null) {
            alS().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.ckd.aNF() && alS() != null) {
            alS().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            alS().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.writeImagesInfo != null) {
            bundle.putString(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.ckc);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.cke.getWriteData() == null) {
            this.cke.setWriteData(this.ckg.oN(str));
        }
        if (this.cke.getWriteData() != null) {
            if (this.ckn) {
                this.cke.getWriteData().setCanNoForum(true);
                if (this.ckh != null) {
                    this.cke.getWriteData().setVForumId(this.ckh.getId());
                    this.cke.getWriteData().setVForumName(this.ckh.getName());
                }
            } else {
                this.cke.getWriteData().setCanNoForum(false);
                this.cke.getWriteData().setVForumId("");
                this.cke.getWriteData().setVForumName("");
            }
            this.cke.getWriteData().setWriteImagesInfo(this.writeImagesInfo);
            this.cke.getWriteData().setVideoInfo(this.mVideoInfo);
            this.cke.qd(this.writeImagesInfo.size() > 0);
            WriteData writeData2 = this.cke.getWriteData();
            if (this.ckd == null || !this.ckd.aNF()) {
                z = false;
            }
            writeData2.setHasLocationData(z);
            if (str == null) {
                this.cke.getWriteData().setContent(this.ckb);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.cke.getWriteData().setVoice(this.mVoiceModel.getId());
                    this.cke.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.cke.getWriteData().setVoice(null);
                    this.cke.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.cke.getWriteData().setVoice(null);
                this.cke.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.cke.cfF()) {
                this.mContext.showToast(d.j.write_img_limit);
            } else if (this.ckm == null || !this.ckm.amq()) {
                if (this.ckl != null) {
                    this.ckl.amr();
                }
                if (!this.cke.startPostWrite()) {
                }
            }
        }
    }

    public BaseActivity<?> getContext() {
        return this.mContext;
    }

    public void oS(String str) {
        this.ckb = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int amC() {
        return this.ckj;
    }

    private void amD() {
        if (alS() != null) {
            alS().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void w(ArrayList<String> arrayList) {
        if (alS() != null) {
            alS().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void oT(String str) {
        if (alS() != null) {
            alS().b(new com.baidu.tbadk.editortools.a(44, 27, str));
        }
    }

    private void amE() {
        if (alS() != null) {
            alS().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.ckj = i;
        if (alS() != null) {
            alS().b(new com.baidu.tbadk.editortools.a(19, 27, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void oU(String str) {
        if (alS() != null) {
            alS().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eP(boolean z) {
        if (alS() != null) {
            if (z) {
                alS().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                alS().b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
            alS().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.ckk = dVar;
    }

    public void a(c cVar) {
        this.ckl = cVar;
    }

    public void a(b bVar) {
        this.ckm = bVar;
    }

    public boolean amF() {
        LinkedList<ImageFileInfo> chosedFiles;
        return (this.writeImagesInfo == null || (chosedFiles = this.writeImagesInfo.getChosedFiles()) == null || chosedFiles.isEmpty()) ? false : true;
    }

    public boolean amG() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    private void amH() {
        if (this.ckp == null && alS() != null) {
            this.ckp = (e) alS().jw(27);
        }
    }

    public void amI() {
        if (this.ckp != null && this.cko != null) {
            this.ckp.d(this.cko);
        }
    }

    public void b(TextWatcher textWatcher) {
        amH();
        if (this.ckp != null && textWatcher != null) {
            this.ckp.c(textWatcher);
        }
    }

    public void amd() {
        if (this.cih != null) {
            this.cih.amd();
        }
    }
}
