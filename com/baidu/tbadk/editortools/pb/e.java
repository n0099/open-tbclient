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
    private bj agC;
    private long authorId;
    private String authorName;
    private String authorNameShow;
    private EditorTools dWB;
    private DataModel<?> dYA;
    private ForumData dYB;
    private String dYC;
    private int dYD;
    private NewWriteModel.d dYE;
    private c dYF;
    private b dYG;
    private boolean dYH;
    private TextWatcher dYI;
    private f dYJ;
    private LocationModel.a dYK;
    private LocationModel.b dYL;
    private final NewWriteModel.d dYM;
    private final com.baidu.adp.base.d dYN;
    private String dYw;
    private LocationModel dYx;
    private NewWriteModel dYy;
    private ImageModel dYz;
    private TbPageContext duK;
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
        this.dYy = null;
        this.dYz = null;
        this.mThreadId = null;
        this.dYC = null;
        this.dYD = 0;
        this.dYH = false;
        this.dYK = new LocationModel.a() { // from class: com.baidu.tbadk.editortools.pb.e.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void aXE() {
                e.this.duK.showToast(R.string.no_network_guide);
                e.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                TbPageContext tbPageContext = e.this.duK;
                if (StringUtils.isNull(str)) {
                    str = e.this.aWN().getContext().getString(R.string.location_fail);
                }
                tbPageContext.showToast(str);
                e.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.cWT())) {
                    e.this.a(2, true, aVar.cWT());
                } else {
                    onFail(null);
                }
            }
        };
        this.dYL = new LocationModel.b() { // from class: com.baidu.tbadk.editortools.pb.e.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void aXF() {
                e.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void wH(String str) {
                e.this.a(2, true, str);
            }
        };
        this.dYM = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.e.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
                WriteData cSL = writeData == null ? e.this.dYy.cSL() : writeData;
                if (z) {
                    e.this.hI(true);
                    WriteData cSL2 = e.this.dYy.cSL();
                    e.this.resetData();
                    w.d(e.this.mThreadId, (WriteData) null);
                    if (cSL2 != null) {
                        if (cSL2.getType() == 2) {
                            w.a(cSL2.getThreadId(), e.this);
                        }
                    } else {
                        return;
                    }
                } else if (cSL != null && aaVar != null && !TextUtils.isEmpty(aaVar.aSe())) {
                    cSL.setVcodeMD5(aaVar.getVcode_md5());
                    cSL.setVcodeUrl(aaVar.getVcode_pic_url());
                    cSL.setVcodeExtra(aaVar.aSf());
                    if (e.this.agC != null) {
                        cSL.setBaijiahaoData(e.this.agC.getBaijiahaoData());
                    }
                    if (com.baidu.tbadk.s.a.xr(aaVar.aSe())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(e.this.duK.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cSL, false, aaVar.aSe())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(e.this.duK.getPageActivity(), cSL, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(e.this.duK.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cSL, postWriteCallBackData.getAccessState())));
                }
                e.this.b(e.this.dYy.cSL());
                if (e.this.dYE != null) {
                    e.this.dYE.callback(z, postWriteCallBackData, aaVar, cSL, antiData);
                }
            }
        };
        this.dYN = new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.editortools.pb.e.7
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Bitmap) {
                    e.this.dYy.ua(true);
                }
            }
        };
        this.dWB = editorTools;
    }

    public void mJ(int i) {
        if (this.dYJ == null && aWN() != null) {
            this.dYJ = (f) aWN().mD(27);
        }
        if (this.dYJ != null) {
            this.dYJ.setType(i);
        }
    }

    public void mK(int i) {
        if (this.dYJ == null && aWN() != null) {
            this.dYJ = (f) aWN().mD(27);
        }
        if (this.dYJ != null) {
            this.dYJ.mL(i);
        }
    }

    public f aXm() {
        if (this.dYJ == null && aWN() != null) {
            this.dYJ = (f) aWN().mD(27);
        }
        return this.dYJ;
    }

    public void wB(String str) {
        if (this.dYJ == null && aWN() != null) {
            this.dYJ = (f) aWN().mD(27);
        }
        if (this.dYJ != null) {
            this.dYJ.setHint(str);
        }
    }

    public void hE(boolean z) {
        BLauncher bLauncher;
        if (aWN() != null && (bLauncher = (BLauncher) aWN().mA(5)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void hF(boolean z) {
        BLauncher bLauncher;
        if (aWN() != null && (bLauncher = (BLauncher) aWN().mA(23)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void hG(boolean z) {
        BLauncher bLauncher;
        if (aWN() != null && (bLauncher = (BLauncher) aWN().mA(2)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.dYA = dataModel;
    }

    public void a(TbPageContext tbPageContext) {
        this.duK = tbPageContext;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.dYC = antiData.getVoice_message();
        }
    }

    public void a(ForumData forumData, UserData userData) {
        this.dYB = forumData;
    }

    public void setThreadData(bj bjVar) {
        this.agC = bjVar;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (aWN() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.authorNameShow = metaData.getName_show();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void hH(boolean z) {
        this.dYH = z;
    }

    public void aXn() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            if (String.valueOf(this.authorId).equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                l.showToast(this.duK.getPageActivity(), (int) R.string.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.duK.getPageActivity(), this.authorId, this.authorName, this.authorNameShow, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.f.b.toLong(this.mThreadId, 0L), com.baidu.adp.lib.f.b.toLong(this.postId, 0L))));
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.duK.getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_LOGIN_SUB_PB_AT /* 11026 */:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.duK.getPageActivity(), RequestResponseCode.REQUEST_SUB_PB_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("camera_result", false)) {
                            F(intent);
                        } else {
                            H(intent);
                        }
                        aWN().invalidate();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_IMAGE_VIEW /* 12003 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("delete", false)) {
                            aXy();
                            this.dYy.ua(false);
                            return;
                        }
                        this.dYz.wA(intent.getStringExtra("file_name"));
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
                    WriteData cSL = this.dYy.cSL();
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (cSL != null) {
                        cSL.deleteUploadedTempImages();
                    }
                    this.dYy.d((WriteData) null);
                    this.dYy.ua(false);
                    this.mVoiceModel = null;
                    this.mVideoInfo = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        w.d(this.mThreadId, (WriteData) null);
                    }
                    hI(true);
                    if (this.dYE != null) {
                        this.dYE.callback(true, postWriteCallBackData, null, cSL, null);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    if (i == 12010) {
                        F(intent);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    G(intent);
                    return;
                case RequestResponseCode.REQUEST_RECORDER_VIDEO /* 13010 */:
                    if (aWN() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            an anVar = new an(TbadkCoreStatisticKey.XIAOYING_DURATION);
                            anVar.af("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(anVar);
                            aXz();
                            aWN().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            aWN().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                        wF(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 12001:
                aXv();
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
                if (this.dYE != null) {
                    this.dYE.callback(false, postWriteCallBackData2, null, this.dYy.cSL(), null);
                    return;
                }
                return;
        }
    }

    public void aXo() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.duK.getPageActivity())));
    }

    public void aXp() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.duK.getPageActivity())) {
            this.duK.showToast(R.string.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            aXr();
        } else if (this.dYx.cXa()) {
            aXo();
        } else {
            this.dYx.tY(false);
            a(1, true, (String) null);
            this.dYx.cWY();
        }
    }

    public void aXq() {
        if (!this.isBJH && this.dYx != null && !com.baidu.tieba.tbadkCore.location.c.cWV().cWW() && UtilHelper.isSystemLocationProviderEnabled(this.duK.getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared()) {
            this.dYx.cWY();
        }
    }

    private void aXr() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.duK.getPageActivity());
        aVar.kd(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    e.this.a(1, true, (String) null);
                    e.this.dYx.cXc();
                } else {
                    e.this.dYK.aXE();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                e.this.a(0, true, (String) null);
                aVar2.dismiss();
            }
        }).b(this.duK);
        aVar.aMS();
    }

    public void aXs() {
        if (this.dYx.bAS()) {
            if (this.dYx.cXa()) {
                this.dYK.a(com.baidu.tieba.tbadkCore.location.c.cWV().getLocationData());
                return;
            }
            if (l.isNetOk()) {
                this.dYx.cWY();
            }
            a(0, true, (String) null);
            return;
        }
        a(0, false, (String) null);
    }

    public boolean aXt() {
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
        this.dYy.d((WriteData) null);
        this.dYy.ua(false);
        this.mVoiceModel = null;
        this.mVideoInfo = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void aXu() {
        this.mVideoInfo = null;
    }

    private void F(Intent intent) {
        this.dYw = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.dYw;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.duK.getPageActivity(), l.getEquipmentWidth(this.duK.getPageActivity())), l.dip2px(this.duK.getPageActivity(), l.getEquipmentHeight(this.duK.getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    m.a("cameras", this.dYw, rotateBitmapBydegree, 100);
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

    private void G(Intent intent) {
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
        if (this.dYB != null) {
            threadData.setForumId(this.dYB.getId());
            threadData.setForumName(this.dYB.getName());
            threadData.setFirstDir(this.dYB.getFirst_class());
            threadData.setSecondDir(this.dYB.getSecond_class());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        threadData.isBJH = this.isBJH;
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.dYC);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.duK.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void c(q qVar) {
        if (qVar != null) {
            if (qVar.aRV() == EmotionGroupType.BIG_EMOTION || qVar.aRV() == EmotionGroupType.USER_COLLECT) {
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

    private void aXv() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tbadk.editortools.pb.e.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                m.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + e.this.dYw));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void H(Intent intent) {
        b(intent, true);
    }

    public void wC(String str) {
        WriteData cSL = this.dYy.cSL();
        if (cSL == null) {
            cSL = new WriteData(1);
            cSL.setThreadId(str);
            cSL.setWriteImagesInfo(this.writeImagesInfo);
        }
        cSL.setContent(this.mPostContent);
        cSL.setVideoInfo(this.mVideoInfo);
        cSL.setVoiceModel(this.mVoiceModel);
        w.d(str, cSL);
    }

    public void wD(String str) {
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
                aXz();
                aWN().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                    aWN().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                aWN().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            if (writeData.getVoiceModel() != null && writeData.getVoiceModel().voiceId != null && writeData.getVoiceModel().duration != -1) {
                if (this.mVoiceModel == null) {
                    this.mVoiceModel = new VoiceData.VoiceModel();
                }
                this.mVoiceModel.copy(writeData.getVoiceModel());
            }
            if (!aq.isEmpty(writeData.getContent()) && aq.isEmpty(this.mPostContent)) {
                this.mPostContent = writeData.getContent();
                wG(this.mPostContent);
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
                    aWN().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                aWN().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.mPostContent = writeData.getContent();
            wG(this.mPostContent);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.dYy.cancelLoadData();
        this.dYz.cancelLoadData();
        this.dYx.cancelLoadData();
    }

    public void a(TbPageContext tbPageContext, Bundle bundle) {
        this.dYy = new NewWriteModel(tbPageContext);
        this.dYy.b(this.dYM);
        this.dYz = new ImageModel(tbPageContext);
        this.dYz.setLoadDataCallBack(this.dYN);
        this.dYx = new LocationModel(tbPageContext);
        this.dYx.a(this.dYK);
        this.dYx.a(this.dYL);
        if (bundle != null) {
            this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
            this.dYw = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(this.isBJH ? 1 : 9);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && aWN() != null) {
            aWN().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.dYx.bAS() && aWN() != null) {
            aWN().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            aWN().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.writeImagesInfo != null) {
            bundle.putString(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.dYw);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.dYy.cSL() == null) {
            WriteData wz = this.dYA.wz(str);
            if (wz != null && this.agC != null) {
                wz.setBaijiahaoData(this.agC.getBaijiahaoData());
            }
            this.dYy.d(wz);
        }
        if (this.dYy.cSL() != null) {
            if (this.dYH) {
                this.dYy.cSL().setCanNoForum(true);
                if (this.dYB != null) {
                    this.dYy.cSL().setVForumId(this.dYB.getId());
                    this.dYy.cSL().setVForumName(this.dYB.getName());
                }
            } else {
                this.dYy.cSL().setCanNoForum(false);
                this.dYy.cSL().setVForumId("");
                this.dYy.cSL().setVForumName("");
            }
            this.dYy.cSL().setIsBJHPost(this.isBJH);
            this.dYy.cSL().setWriteImagesInfo(this.writeImagesInfo);
            this.dYy.cSL().setVideoInfo(this.mVideoInfo);
            this.dYy.ua(this.writeImagesInfo.size() > 0);
            WriteData cSL = this.dYy.cSL();
            if (this.dYx == null || !this.dYx.bAS()) {
                z = false;
            }
            cSL.setHasLocationData(z);
            if (str == null) {
                this.dYy.cSL().setContent(this.mPostContent);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.dYy.cSL().setVoice(this.mVoiceModel.getId());
                    this.dYy.cSL().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.dYy.cSL().setVoice(null);
                    this.dYy.cSL().setVoiceDuringTime(-1);
                }
            } else {
                this.dYy.cSL().setVoice(null);
                this.dYy.cSL().setVoiceDuringTime(-1);
            }
            if (!this.dYy.cXC()) {
                this.duK.showToast(R.string.write_img_limit);
            } else if (this.dYG == null || !this.dYG.aXk()) {
                if (this.dYF != null) {
                    this.dYF.aXl();
                }
                if (!this.dYy.cXz()) {
                }
            }
        }
    }

    public BaseFragmentActivity aXw() {
        return (BaseFragmentActivity) this.duK.getPageActivity();
    }

    public void wE(String str) {
        this.mPostContent = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int aXx() {
        return this.dYD;
    }

    private void aXy() {
        if (aWN() != null) {
            aWN().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void G(ArrayList<String> arrayList) {
        if (aWN() != null) {
            aWN().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void wF(String str) {
        if (aWN() != null) {
            aWN().b(new com.baidu.tbadk.editortools.a(44, 27, str));
        }
    }

    private void aXz() {
        if (aWN() != null) {
            aWN().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.dYD = i;
        if (aWN() != null) {
            aWN().b(new com.baidu.tbadk.editortools.a(19, 27, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void wG(String str) {
        if (aWN() != null) {
            aWN().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hI(boolean z) {
        if (aWN() != null) {
            if (z) {
                aWN().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                aWN().b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
            aWN().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.dYE = dVar;
    }

    public void a(c cVar) {
        this.dYF = cVar;
    }

    public void a(b bVar) {
        this.dYG = bVar;
    }

    public boolean aXA() {
        LinkedList<ImageFileInfo> chosedFiles;
        return (this.writeImagesInfo == null || (chosedFiles = this.writeImagesInfo.getChosedFiles()) == null || chosedFiles.isEmpty()) ? false : true;
    }

    public boolean aXB() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    private void aXC() {
        if (this.dYJ == null && aWN() != null) {
            this.dYJ = (f) aWN().mD(27);
        }
    }

    public void aXD() {
        if (this.dYJ != null && this.dYI != null) {
            this.dYJ.d(this.dYI);
        }
    }

    public void b(TextWatcher textWatcher) {
        aXC();
        if (this.dYJ != null && textWatcher != null) {
            this.dYJ.c(textWatcher);
        }
    }

    public void aWX() {
        if (this.dWB != null) {
            this.dWB.aWX();
        }
    }
}
