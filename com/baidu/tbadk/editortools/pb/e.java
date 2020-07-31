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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ad;
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
/* loaded from: classes15.dex */
public class e extends com.baidu.tbadk.editortools.d implements w.a {
    private bv aii;
    private long authorId;
    private String authorName;
    private String authorNameShow;
    private TbPageContext dVN;
    private String eBO;
    private LocationModel eBP;
    private NewWriteModel eBQ;
    private ImageModel eBR;
    private DataModel<?> eBS;
    private ForumData eBT;
    private String eBU;
    private int eBV;
    private NewWriteModel.d eBW;
    private c eBX;
    private b eBY;
    private boolean eBZ;
    private TextWatcher eCa;
    private f eCb;
    private LocationModel.a eCc;
    private LocationModel.b eCd;
    private final NewWriteModel.d eCe;
    private final com.baidu.adp.base.d eCf;
    private EditorTools ezO;
    public boolean isBJH;
    private String mPostContent;
    private SpanGroupManager mSpanGroupManager;
    private String mThreadId;
    private VideoInfo mVideoInfo;
    private VoiceData.VoiceModel mVoiceModel;
    private String postId;
    private WriteImagesInfo writeImagesInfo;

    public e(EditorTools editorTools) {
        super(editorTools);
        this.writeImagesInfo = new WriteImagesInfo();
        this.mPostContent = "";
        this.eBQ = null;
        this.eBR = null;
        this.mThreadId = null;
        this.eBU = null;
        this.eBV = 0;
        this.eBZ = false;
        this.eCc = new LocationModel.a() { // from class: com.baidu.tbadk.editortools.pb.e.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void bjD() {
                e.this.dVN.showToast(R.string.no_network_guide);
                e.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                TbPageContext tbPageContext = e.this.dVN;
                if (StringUtils.isNull(str)) {
                    str = e.this.biJ().getContext().getString(R.string.location_fail);
                }
                tbPageContext.showToast(str);
                e.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.dlK())) {
                    e.this.a(2, true, aVar.dlK());
                } else {
                    onFail(null);
                }
            }
        };
        this.eCd = new LocationModel.b() { // from class: com.baidu.tbadk.editortools.pb.e.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void bjE() {
                e.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void zM(String str) {
                e.this.a(2, true, str);
            }
        };
        this.eCe = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.e.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ad adVar, WriteData writeData, AntiData antiData) {
                WriteData dhF = writeData == null ? e.this.eBQ.dhF() : writeData;
                if (z) {
                    e.this.iR(true);
                    WriteData dhF2 = e.this.eBQ.dhF();
                    e.this.resetData();
                    w.f(e.this.mThreadId, (WriteData) null);
                    if (dhF2 != null) {
                        if (dhF2.getType() == 2) {
                            w.a(dhF2.getThreadId(), e.this);
                        }
                    } else {
                        return;
                    }
                } else if (dhF != null && adVar != null && !TextUtils.isEmpty(adVar.beo())) {
                    dhF.setVcodeMD5(adVar.getVcode_md5());
                    dhF.setVcodeUrl(adVar.getVcode_pic_url());
                    dhF.setVcodeExtra(adVar.bep());
                    if (e.this.aii != null) {
                        dhF.setBaijiahaoData(e.this.aii.getBaijiahaoData());
                    }
                    if (com.baidu.tbadk.t.a.Ay(adVar.beo())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(e.this.dVN.getPageActivity(), RequestResponseCode.REQUEST_VCODE, dhF, false, adVar.beo())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(e.this.dVN.getPageActivity(), dhF, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(e.this.dVN.getPageActivity(), RequestResponseCode.REQUEST_VCODE, dhF, postWriteCallBackData.getAccessState())));
                }
                e.this.b(e.this.eBQ.dhF());
                if (e.this.eBW != null) {
                    e.this.eBW.callback(z, postWriteCallBackData, adVar, dhF, antiData);
                }
            }
        };
        this.eCf = new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.editortools.pb.e.7
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Bitmap) {
                    e.this.eBQ.vr(true);
                }
            }
        };
        this.ezO = editorTools;
    }

    public void nZ(int i) {
        if (this.eCb == null && biJ() != null) {
            this.eCb = (f) biJ().nT(27);
        }
        if (this.eCb != null) {
            this.eCb.setType(i);
        }
    }

    public void oa(int i) {
        if (this.eCb == null && biJ() != null) {
            this.eCb = (f) biJ().nT(27);
        }
        if (this.eCb != null) {
            this.eCb.ob(i);
        }
    }

    public f bjk() {
        if (this.eCb == null && biJ() != null) {
            this.eCb = (f) biJ().nT(27);
        }
        return this.eCb;
    }

    public void zG(String str) {
        if (this.eCb == null && biJ() != null) {
            this.eCb = (f) biJ().nT(27);
        }
        if (this.eCb != null) {
            this.eCb.setHint(str);
        }
    }

    public void iN(boolean z) {
        BLauncher bLauncher;
        if (biJ() != null && (bLauncher = (BLauncher) biJ().nQ(5)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void iO(boolean z) {
        BLauncher bLauncher;
        if (biJ() != null && (bLauncher = (BLauncher) biJ().nQ(23)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void iP(boolean z) {
        BLauncher bLauncher;
        if (biJ() != null && (bLauncher = (BLauncher) biJ().nQ(2)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.eBS = dataModel;
    }

    public void a(TbPageContext tbPageContext) {
        this.dVN = tbPageContext;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.eBU = antiData.getVoice_message();
        }
    }

    public void a(ForumData forumData, UserData userData) {
        this.eBT = forumData;
    }

    public void setThreadData(bv bvVar) {
        this.aii = bvVar;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (biJ() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.authorNameShow = metaData.getName_show();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void iQ(boolean z) {
        this.eBZ = z;
    }

    public void bjl() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            if (String.valueOf(this.authorId).equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                l.showToast(this.dVN.getPageActivity(), R.string.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.dVN.getPageActivity(), this.authorId, this.authorName, this.authorNameShow, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.f.b.toLong(this.mThreadId, 0L), com.baidu.adp.lib.f.b.toLong(this.postId, 0L))));
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.dVN.getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_LOGIN_SUB_PB_AT /* 11026 */:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.dVN.getPageActivity(), RequestResponseCode.REQUEST_SUB_PB_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("camera_result", false)) {
                            C(intent);
                        } else {
                            E(intent);
                        }
                        biJ().invalidate();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_IMAGE_VIEW /* 12003 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("delete", false)) {
                            bjx();
                            this.eBQ.vr(false);
                            return;
                        }
                        this.eBR.zF(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        H(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    WriteData dhF = this.eBQ.dhF();
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (dhF != null) {
                        dhF.deleteUploadedTempImages();
                    }
                    this.eBQ.d((WriteData) null);
                    this.eBQ.vr(false);
                    this.mVoiceModel = null;
                    this.mVideoInfo = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        w.f(this.mThreadId, (WriteData) null);
                    }
                    iR(true);
                    if (this.eBW != null) {
                        this.eBW.callback(true, postWriteCallBackData, null, dhF, null);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    if (i == 12010) {
                        C(intent);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    D(intent);
                    return;
                case RequestResponseCode.REQUEST_RECORDER_VIDEO /* 13010 */:
                    if (biJ() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            ap apVar = new ap(TbadkCoreStatisticKey.XIAOYING_DURATION);
                            apVar.ah("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(apVar);
                            bjy();
                            biJ().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            biJ().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                        zK(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 12001:
                bju();
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
                if (this.eBW != null) {
                    this.eBW.callback(false, postWriteCallBackData2, null, this.eBQ.dhF(), null);
                    return;
                }
                return;
        }
    }

    public void bjm() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.dVN.getPageActivity())));
    }

    public void bjn() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.dVN.getPageActivity())) {
            this.dVN.showToast(R.string.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bjq();
        } else if (this.eBP.dlR()) {
            bjm();
        } else {
            this.eBP.vp(false);
            a(1, true, (String) null);
            this.eBP.dlP();
        }
    }

    public void bjo() {
        if (!com.baidu.tbadk.core.util.ad.checkLocationForGoogle(this.dVN.getPageActivity())) {
            com.baidu.tbadk.core.util.ad.d(this.dVN.getPageActivity(), 0);
        } else {
            bjn();
        }
    }

    public void bjp() {
        if (!this.isBJH && this.eBP != null && !com.baidu.tieba.tbadkCore.location.c.dlM().dlN() && UtilHelper.isSystemLocationProviderEnabled(this.dVN.getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared()) {
            this.eBP.dlP();
        }
    }

    private void bjq() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dVN.getPageActivity());
        aVar.ln(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    e.this.a(1, true, (String) null);
                    e.this.eBP.dlT();
                } else {
                    e.this.eCc.bjD();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                e.this.a(0, true, (String) null);
                aVar2.dismiss();
            }
        }).b(this.dVN);
        aVar.aYL();
    }

    public void bjr() {
        if (this.eBP.bNz()) {
            if (this.eBP.dlR()) {
                this.eCc.a(com.baidu.tieba.tbadkCore.location.c.dlM().getLocationData());
                return;
            }
            if (l.isNetOk()) {
                this.eBP.dlP();
            }
            a(0, true, (String) null);
            return;
        }
        a(0, false, (String) null);
    }

    public boolean bjs() {
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
        this.eBQ.d((WriteData) null);
        this.eBQ.vr(false);
        this.mVoiceModel = null;
        this.mVideoInfo = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void bjt() {
        this.mVideoInfo = null;
    }

    private void C(Intent intent) {
        this.eBO = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.eBO;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.dVN.getPageActivity(), l.getEquipmentWidth(this.dVN.getPageActivity())), l.dip2px(this.dVN.getPageActivity(), l.getEquipmentHeight(this.dVN.getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    n.a("cameras", this.eBO, rotateBitmapBydegree, 100);
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

    private void D(Intent intent) {
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
        if (this.eBT != null) {
            threadData.setForumId(this.eBT.getId());
            threadData.setForumName(this.eBT.getName());
            threadData.setFirstDir(this.eBT.getFirst_class());
            threadData.setSecondDir(this.eBT.getSecond_class());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        threadData.isBJH = this.isBJH;
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.eBU);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.dVN.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void c(q qVar) {
        if (qVar != null) {
            if (qVar.bef() == EmotionGroupType.BIG_EMOTION || qVar.bef() == EmotionGroupType.USER_COLLECT) {
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

    private void bju() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tbadk.editortools.pb.e.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                n.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + e.this.eBO));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void E(Intent intent) {
        b(intent, true);
    }

    public void zH(String str) {
        WriteData dhF = this.eBQ.dhF();
        if (dhF == null) {
            dhF = new WriteData(1);
            dhF.setThreadId(str);
            dhF.setWriteImagesInfo(this.writeImagesInfo);
        }
        dhF.setContent(this.mPostContent);
        dhF.setVideoInfo(this.mVideoInfo);
        dhF.setVoiceModel(this.mVoiceModel);
        w.f(str, dhF);
    }

    public void zI(String str) {
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
                bjy();
                biJ().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                    biJ().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                biJ().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            if (writeData.getVoiceModel() != null && writeData.getVoiceModel().voiceId != null && writeData.getVoiceModel().duration != -1) {
                if (this.mVoiceModel == null) {
                    this.mVoiceModel = new VoiceData.VoiceModel();
                }
                this.mVoiceModel.copy(writeData.getVoiceModel());
            }
            if (!as.isEmpty(writeData.getContent()) && as.isEmpty(this.mPostContent)) {
                this.mPostContent = writeData.getContent();
                zL(this.mPostContent);
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
                    biJ().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                biJ().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.mPostContent = writeData.getContent();
            zL(this.mPostContent);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.eBQ.cancelLoadData();
        this.eBR.cancelLoadData();
        this.eBP.cancelLoadData();
    }

    public void a(TbPageContext tbPageContext, Bundle bundle) {
        this.eBQ = new NewWriteModel(tbPageContext);
        this.eBQ.b(this.eCe);
        this.eBR = new ImageModel(tbPageContext);
        this.eBR.setLoadDataCallBack(this.eCf);
        this.eBP = new LocationModel(tbPageContext);
        this.eBP.a(this.eCc);
        this.eBP.a(this.eCd);
        if (bundle != null) {
            this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
            this.eBO = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(this.isBJH ? 1 : 9);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && biJ() != null) {
            biJ().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.eBP.bNz() && biJ() != null) {
            biJ().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            biJ().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.writeImagesInfo != null) {
            bundle.putString(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.eBO);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.eBQ.dhF() == null) {
            WriteData zE = this.eBS.zE(str);
            if (zE != null && this.aii != null) {
                zE.setBaijiahaoData(this.aii.getBaijiahaoData());
            }
            this.eBQ.d(zE);
        }
        if (this.eBQ.dhF() != null) {
            this.eBQ.setSpanGroupManager(this.mSpanGroupManager);
            if (this.eBZ) {
                this.eBQ.dhF().setCanNoForum(true);
                if (this.eBT != null) {
                    this.eBQ.dhF().setVForumId(this.eBT.getId());
                    this.eBQ.dhF().setVForumName(this.eBT.getName());
                }
            } else {
                this.eBQ.dhF().setCanNoForum(false);
                this.eBQ.dhF().setVForumId("");
                this.eBQ.dhF().setVForumName("");
            }
            this.eBQ.dhF().setIsBJHPost(this.isBJH);
            this.eBQ.dhF().setWriteImagesInfo(this.writeImagesInfo);
            this.eBQ.dhF().setVideoInfo(this.mVideoInfo);
            this.eBQ.vr(this.writeImagesInfo.size() > 0);
            WriteData dhF = this.eBQ.dhF();
            if (this.eBP == null || !this.eBP.bNz()) {
                z = false;
            }
            dhF.setHasLocationData(z);
            if (str == null) {
                this.eBQ.dhF().setContent(this.mPostContent);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.eBQ.dhF().setVoice(this.mVoiceModel.getId());
                    this.eBQ.dhF().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.eBQ.dhF().setVoice(null);
                    this.eBQ.dhF().setVoiceDuringTime(-1);
                }
            } else {
                this.eBQ.dhF().setVoice(null);
                this.eBQ.dhF().setVoiceDuringTime(-1);
            }
            if (!this.eBQ.dmz()) {
                this.dVN.showToast(R.string.write_img_limit);
            } else if (this.eBY == null || !this.eBY.bji()) {
                if (this.eBX != null) {
                    this.eBX.bjj();
                }
                if (!this.eBQ.dmw()) {
                }
            }
        }
    }

    public BaseFragmentActivity bjv() {
        return (BaseFragmentActivity) this.dVN.getPageActivity();
    }

    public void zJ(String str) {
        this.mPostContent = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int bjw() {
        return this.eBV;
    }

    private void bjx() {
        if (biJ() != null) {
            biJ().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void H(ArrayList<String> arrayList) {
        if (biJ() != null) {
            biJ().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void zK(String str) {
        if (biJ() != null) {
            biJ().b(new com.baidu.tbadk.editortools.a(44, 27, str));
        }
    }

    private void bjy() {
        if (biJ() != null) {
            biJ().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.eBV = i;
        if (biJ() != null) {
            biJ().b(new com.baidu.tbadk.editortools.a(19, 27, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void zL(String str) {
        if (biJ() != null) {
            biJ().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iR(boolean z) {
        if (biJ() != null) {
            if (z) {
                biJ().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                biJ().b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
            biJ().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.eBW = dVar;
    }

    public void a(c cVar) {
        this.eBX = cVar;
    }

    public void a(b bVar) {
        this.eBY = bVar;
    }

    public boolean bjz() {
        LinkedList<ImageFileInfo> chosedFiles;
        return (this.writeImagesInfo == null || (chosedFiles = this.writeImagesInfo.getChosedFiles()) == null || chosedFiles.isEmpty()) ? false : true;
    }

    public boolean bjA() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    private void bjB() {
        if (this.eCb == null && biJ() != null) {
            this.eCb = (f) biJ().nT(27);
        }
    }

    public void bjC() {
        if (this.eCb != null && this.eCa != null) {
            this.eCb.c(this.eCa);
        }
    }

    public void a(TextWatcher textWatcher) {
        bjB();
        if (this.eCb != null && textWatcher != null) {
            this.eCb.b(textWatcher);
        }
    }

    public void biU() {
        if (this.ezO != null) {
            this.ezO.biU();
        }
    }

    public void setSpanGroupManager(SpanGroupManager spanGroupManager) {
        this.mSpanGroupManager = spanGroupManager;
    }
}
