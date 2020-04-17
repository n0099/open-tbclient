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
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bj;
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
import com.baidu.tbadk.coreExtra.data.aa;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tbadk.editortools.BLauncher;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.w;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes8.dex */
public class e extends com.baidu.tbadk.editortools.d implements w.a {
    private bj agz;
    private long authorId;
    private String authorName;
    private String authorNameShow;
    private EditorTools dWw;
    private c dYA;
    private b dYB;
    private boolean dYC;
    private TextWatcher dYD;
    private f dYE;
    private LocationModel.a dYF;
    private LocationModel.b dYG;
    private final NewWriteModel.d dYH;
    private final com.baidu.adp.base.d dYI;
    private String dYr;
    private LocationModel dYs;
    private NewWriteModel dYt;
    private ImageModel dYu;
    private DataModel<?> dYv;
    private ForumData dYw;
    private String dYx;
    private int dYy;
    private NewWriteModel.d dYz;
    private TbPageContext duG;
    public boolean isBJH;
    private String mPostContent;
    private String mThreadId;
    private VideoInfo mVideoInfo;
    private VoiceData.VoiceModel mVoiceModel;
    private String postId;
    private WriteImagesInfo writeImagesInfo;

    public e(EditorTools editorTools) {
        super(editorTools);
        this.writeImagesInfo = new WriteImagesInfo();
        this.mPostContent = "";
        this.dYt = null;
        this.dYu = null;
        this.mThreadId = null;
        this.dYx = null;
        this.dYy = 0;
        this.dYC = false;
        this.dYF = new LocationModel.a() { // from class: com.baidu.tbadk.editortools.pb.e.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void aXG() {
                e.this.duG.showToast(R.string.no_network_guide);
                e.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                TbPageContext tbPageContext = e.this.duG;
                if (StringUtils.isNull(str)) {
                    str = e.this.aWP().getContext().getString(R.string.location_fail);
                }
                tbPageContext.showToast(str);
                e.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.cWV())) {
                    e.this.a(2, true, aVar.cWV());
                } else {
                    onFail(null);
                }
            }
        };
        this.dYG = new LocationModel.b() { // from class: com.baidu.tbadk.editortools.pb.e.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void aXH() {
                e.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void wE(String str) {
                e.this.a(2, true, str);
            }
        };
        this.dYH = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.e.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
                WriteData cSN = writeData == null ? e.this.dYt.cSN() : writeData;
                if (z) {
                    e.this.hI(true);
                    WriteData cSN2 = e.this.dYt.cSN();
                    e.this.resetData();
                    w.d(e.this.mThreadId, (WriteData) null);
                    if (cSN2 != null) {
                        if (cSN2.getType() == 2) {
                            w.a(cSN2.getThreadId(), e.this);
                        }
                    } else {
                        return;
                    }
                } else if (cSN != null && aaVar != null && !TextUtils.isEmpty(aaVar.aSh())) {
                    cSN.setVcodeMD5(aaVar.getVcode_md5());
                    cSN.setVcodeUrl(aaVar.getVcode_pic_url());
                    cSN.setVcodeExtra(aaVar.aSi());
                    if (e.this.agz != null) {
                        cSN.setBaijiahaoData(e.this.agz.getBaijiahaoData());
                    }
                    if (com.baidu.tbadk.s.a.xo(aaVar.aSh())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(e.this.duG.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cSN, false, aaVar.aSh())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(e.this.duG.getPageActivity(), cSN, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(e.this.duG.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cSN, postWriteCallBackData.getAccessState())));
                }
                e.this.b(e.this.dYt.cSN());
                if (e.this.dYz != null) {
                    e.this.dYz.callback(z, postWriteCallBackData, aaVar, cSN, antiData);
                }
            }
        };
        this.dYI = new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.editortools.pb.e.7
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Bitmap) {
                    e.this.dYt.ua(true);
                }
            }
        };
        this.dWw = editorTools;
    }

    public void mJ(int i) {
        if (this.dYE == null && aWP() != null) {
            this.dYE = (f) aWP().mD(27);
        }
        if (this.dYE != null) {
            this.dYE.setType(i);
        }
    }

    public void mK(int i) {
        if (this.dYE == null && aWP() != null) {
            this.dYE = (f) aWP().mD(27);
        }
        if (this.dYE != null) {
            this.dYE.mL(i);
        }
    }

    public f aXo() {
        if (this.dYE == null && aWP() != null) {
            this.dYE = (f) aWP().mD(27);
        }
        return this.dYE;
    }

    public void wy(String str) {
        if (this.dYE == null && aWP() != null) {
            this.dYE = (f) aWP().mD(27);
        }
        if (this.dYE != null) {
            this.dYE.setHint(str);
        }
    }

    public void hE(boolean z) {
        BLauncher bLauncher;
        if (aWP() != null && (bLauncher = (BLauncher) aWP().mA(5)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void hF(boolean z) {
        BLauncher bLauncher;
        if (aWP() != null && (bLauncher = (BLauncher) aWP().mA(23)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void hG(boolean z) {
        BLauncher bLauncher;
        if (aWP() != null && (bLauncher = (BLauncher) aWP().mA(2)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.dYv = dataModel;
    }

    public void a(TbPageContext tbPageContext) {
        this.duG = tbPageContext;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.dYx = antiData.getVoice_message();
        }
    }

    public void a(ForumData forumData, UserData userData) {
        this.dYw = forumData;
    }

    public void setThreadData(bj bjVar) {
        this.agz = bjVar;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (aWP() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.authorNameShow = metaData.getName_show();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void hH(boolean z) {
        this.dYC = z;
    }

    public void aXp() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            if (String.valueOf(this.authorId).equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                l.showToast(this.duG.getPageActivity(), (int) R.string.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.duG.getPageActivity(), this.authorId, this.authorName, this.authorNameShow, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.f.b.toLong(this.mThreadId, 0L), com.baidu.adp.lib.f.b.toLong(this.postId, 0L))));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        if (i2 == -1) {
            switch (i) {
                case 11001:
                    a((String) null, (WriteData) null);
                    return;
                case RequestResponseCode.REQUEST_LOGIN_PB_AT /* 11025 */:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.duG.getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_LOGIN_SUB_PB_AT /* 11026 */:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.duG.getPageActivity(), RequestResponseCode.REQUEST_SUB_PB_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("camera_result", false)) {
                            S(intent);
                        } else {
                            U(intent);
                        }
                        aWP().invalidate();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_IMAGE_VIEW /* 12003 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("delete", false)) {
                            aXA();
                            this.dYt.ua(false);
                            return;
                        }
                        this.dYu.wx(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        G(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    WriteData cSN = this.dYt.cSN();
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (cSN != null) {
                        cSN.deleteUploadedTempImages();
                    }
                    this.dYt.d((WriteData) null);
                    this.dYt.ua(false);
                    this.mVoiceModel = null;
                    this.mVideoInfo = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        w.d(this.mThreadId, (WriteData) null);
                    }
                    hI(true);
                    if (this.dYz != null) {
                        this.dYz.callback(true, postWriteCallBackData, null, cSN, null);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    if (i == 12010) {
                        S(intent);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    T(intent);
                    return;
                case RequestResponseCode.REQUEST_RECORDER_VIDEO /* 13010 */:
                    if (aWP() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            an anVar = new an(TbadkCoreStatisticKey.XIAOYING_DURATION);
                            anVar.af("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(anVar);
                            aXB();
                            aWP().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            aWP().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_PAY_BUBBLE_CODE /* 23004 */:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if (intent != null) {
                        wC(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 12001:
                aXx();
                return;
            case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                if (intent != null && intent.hasExtra("last_album_id")) {
                    this.writeImagesInfo.setLastAlbumId(intent.getStringExtra("last_album_id"));
                    return;
                }
                return;
            case RequestResponseCode.REQUEST_IMAGE_VIEW /* 12003 */:
            case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
            case RequestResponseCode.REQUEST_SUB_PB_AT_SELECT /* 12005 */:
            case RequestResponseCode.REQUEST_REGIST /* 12007 */:
            case RequestResponseCode.REQUEST_FEEDBACK /* 12008 */:
            case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
            case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
            default:
                return;
            case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                PostWriteCallBackData postWriteCallBackData2 = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                if (this.dYz != null) {
                    this.dYz.callback(false, postWriteCallBackData2, null, this.dYt.cSN(), null);
                    return;
                }
                return;
        }
    }

    public void aXq() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.duG.getPageActivity())));
    }

    public void aXr() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.duG.getPageActivity())) {
            this.duG.showToast(R.string.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            aXt();
        } else if (this.dYs.cXc()) {
            aXq();
        } else {
            this.dYs.tY(false);
            a(1, true, (String) null);
            this.dYs.cXa();
        }
    }

    public void aXs() {
        if (!this.isBJH && this.dYs != null && !com.baidu.tieba.tbadkCore.location.c.cWX().cWY() && UtilHelper.isSystemLocationProviderEnabled(this.duG.getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared()) {
            this.dYs.cXa();
        }
    }

    private void aXt() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.duG.getPageActivity());
        aVar.kd(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    e.this.a(1, true, (String) null);
                    e.this.dYs.cXe();
                } else {
                    e.this.dYF.aXG();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                e.this.a(0, true, (String) null);
                aVar2.dismiss();
            }
        }).b(this.duG);
        aVar.aMU();
    }

    public void aXu() {
        if (this.dYs.bAU()) {
            if (this.dYs.cXc()) {
                this.dYF.a(com.baidu.tieba.tbadkCore.location.c.cWX().getLocationData());
                return;
            }
            if (l.isNetOk()) {
                this.dYs.cXa();
            }
            a(0, true, (String) null);
            return;
        }
        a(0, false, (String) null);
    }

    public boolean aXv() {
        if (StringUtils.isNull(this.mPostContent)) {
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
        this.dYt.d((WriteData) null);
        this.dYt.ua(false);
        this.mVoiceModel = null;
        this.mVideoInfo = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void aXw() {
        this.mVideoInfo = null;
    }

    private void S(Intent intent) {
        this.dYr = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.dYr;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.duG.getPageActivity(), l.getEquipmentWidth(this.duG.getPageActivity())), l.dip2px(this.duG.getPageActivity(), l.getEquipmentHeight(this.duG.getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    m.a("cameras", this.dYr, rotateBitmapBydegree, 100);
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

    private void T(Intent intent) {
        b(intent, false);
    }

    private void b(Intent intent, boolean z) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
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
        pbEditorData.setContent(this.mPostContent);
        pbEditorData.setWriteImagesInfo(this.writeImagesInfo);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        PbEditorData.ThreadData threadData = new PbEditorData.ThreadData();
        if (this.dYw != null) {
            threadData.setForumId(this.dYw.getId());
            threadData.setForumName(this.dYw.getName());
            threadData.setFirstDir(this.dYw.getFirst_class());
            threadData.setSecondDir(this.dYw.getSecond_class());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        threadData.isBJH = this.isBJH;
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.dYx);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.duG.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void c(q qVar) {
        if (qVar != null) {
            if (qVar.aRY() == EmotionGroupType.BIG_EMOTION || qVar.aRY() == EmotionGroupType.USER_COLLECT) {
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setImageType(1);
                imageFileInfo.setFilePath(qVar.getName());
                imageFileInfo.width = qVar.getWidth();
                imageFileInfo.height = qVar.getHeight();
                this.writeImagesInfo.addChooseFile(imageFileInfo);
                this.writeImagesInfo.updateQuality();
            }
        }
    }

    private void aXx() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tbadk.editortools.pb.e.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                m.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + e.this.dYr));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void U(Intent intent) {
        b(intent, true);
    }

    public void wz(String str) {
        WriteData cSN = this.dYt.cSN();
        if (cSN == null) {
            cSN = new WriteData(1);
            cSN.setThreadId(str);
            cSN.setWriteImagesInfo(this.writeImagesInfo);
        }
        cSN.setContent(this.mPostContent);
        cSN.setVideoInfo(this.mVideoInfo);
        cSN.setVoiceModel(this.mVoiceModel);
        w.d(str, cSN);
    }

    public void wA(String str) {
        w.a(str, this);
    }

    @Override // com.baidu.tieba.tbadkCore.w.a
    public void a(WriteData writeData) {
        if (writeData != null) {
            if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                if (this.mVideoInfo == null) {
                    this.mVideoInfo = new VideoInfo();
                }
                this.mVideoInfo.copy(writeData.getVideoInfo());
                aXB();
                aWP().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                    aWP().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                aWP().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            if (writeData.getVoiceModel() != null && writeData.getVoiceModel().voiceId != null && writeData.getVoiceModel().duration != -1) {
                if (this.mVoiceModel == null) {
                    this.mVoiceModel = new VoiceData.VoiceModel();
                }
                this.mVoiceModel.copy(writeData.getVoiceModel());
            }
            if (!aq.isEmpty(writeData.getContent()) && aq.isEmpty(this.mPostContent)) {
                this.mPostContent = writeData.getContent();
                wD(this.mPostContent);
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
                    aWP().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                aWP().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.mPostContent = writeData.getContent();
            wD(this.mPostContent);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.dYt.cancelLoadData();
        this.dYu.cancelLoadData();
        this.dYs.cancelLoadData();
    }

    public void a(TbPageContext tbPageContext, Bundle bundle) {
        this.dYt = new NewWriteModel(tbPageContext);
        this.dYt.b(this.dYH);
        this.dYu = new ImageModel(tbPageContext);
        this.dYu.setLoadDataCallBack(this.dYI);
        this.dYs = new LocationModel(tbPageContext);
        this.dYs.a(this.dYF);
        this.dYs.a(this.dYG);
        if (bundle != null) {
            this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
            this.dYr = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(this.isBJH ? 1 : 9);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && aWP() != null) {
            aWP().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.dYs.bAU() && aWP() != null) {
            aWP().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            aWP().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.writeImagesInfo != null) {
            bundle.putString(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.dYr);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.dYt.cSN() == null) {
            WriteData ww = this.dYv.ww(str);
            if (ww != null && this.agz != null) {
                ww.setBaijiahaoData(this.agz.getBaijiahaoData());
            }
            this.dYt.d(ww);
        }
        if (this.dYt.cSN() != null) {
            if (this.dYC) {
                this.dYt.cSN().setCanNoForum(true);
                if (this.dYw != null) {
                    this.dYt.cSN().setVForumId(this.dYw.getId());
                    this.dYt.cSN().setVForumName(this.dYw.getName());
                }
            } else {
                this.dYt.cSN().setCanNoForum(false);
                this.dYt.cSN().setVForumId("");
                this.dYt.cSN().setVForumName("");
            }
            this.dYt.cSN().setIsBJHPost(this.isBJH);
            this.dYt.cSN().setWriteImagesInfo(this.writeImagesInfo);
            this.dYt.cSN().setVideoInfo(this.mVideoInfo);
            this.dYt.ua(this.writeImagesInfo.size() > 0);
            WriteData cSN = this.dYt.cSN();
            if (this.dYs == null || !this.dYs.bAU()) {
                z = false;
            }
            cSN.setHasLocationData(z);
            if (str == null) {
                this.dYt.cSN().setContent(this.mPostContent);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.dYt.cSN().setVoice(this.mVoiceModel.getId());
                    this.dYt.cSN().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.dYt.cSN().setVoice(null);
                    this.dYt.cSN().setVoiceDuringTime(-1);
                }
            } else {
                this.dYt.cSN().setVoice(null);
                this.dYt.cSN().setVoiceDuringTime(-1);
            }
            if (!this.dYt.cXE()) {
                this.duG.showToast(R.string.write_img_limit);
            } else if (this.dYB == null || !this.dYB.aXm()) {
                if (this.dYA != null) {
                    this.dYA.aXn();
                }
                if (!this.dYt.cXB()) {
                }
            }
        }
    }

    public BaseFragmentActivity aXy() {
        return (BaseFragmentActivity) this.duG.getPageActivity();
    }

    public void wB(String str) {
        this.mPostContent = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int aXz() {
        return this.dYy;
    }

    private void aXA() {
        if (aWP() != null) {
            aWP().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void G(ArrayList<String> arrayList) {
        if (aWP() != null) {
            aWP().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void wC(String str) {
        if (aWP() != null) {
            aWP().b(new com.baidu.tbadk.editortools.a(44, 27, str));
        }
    }

    private void aXB() {
        if (aWP() != null) {
            aWP().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.dYy = i;
        if (aWP() != null) {
            aWP().b(new com.baidu.tbadk.editortools.a(19, 27, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void wD(String str) {
        if (aWP() != null) {
            aWP().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hI(boolean z) {
        if (aWP() != null) {
            if (z) {
                aWP().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                aWP().b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
            aWP().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.dYz = dVar;
    }

    public void a(c cVar) {
        this.dYA = cVar;
    }

    public void a(b bVar) {
        this.dYB = bVar;
    }

    public boolean aXC() {
        LinkedList<ImageFileInfo> chosedFiles;
        return (this.writeImagesInfo == null || (chosedFiles = this.writeImagesInfo.getChosedFiles()) == null || chosedFiles.isEmpty()) ? false : true;
    }

    public boolean aXD() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    private void aXE() {
        if (this.dYE == null && aWP() != null) {
            this.dYE = (f) aWP().mD(27);
        }
    }

    public void aXF() {
        if (this.dYE != null && this.dYD != null) {
            this.dYE.d(this.dYD);
        }
    }

    public void b(TextWatcher textWatcher) {
        aXE();
        if (this.dYE != null && textWatcher != null) {
            this.dYE.c(textWatcher);
        }
    }

    public void aWZ() {
        if (this.dWw != null) {
            this.dWw.aWZ();
        }
    }
}
