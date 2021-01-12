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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.editortools.BLauncher;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.y;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.editortools.e implements y.a {
    private bz ale;
    protected long authorId;
    protected String authorName;
    protected String authorNameShow;
    protected TbPageContext eSJ;
    protected b fBA;
    protected boolean fBB;
    private TextWatcher fBC;
    private f fBD;
    private boolean fBE;
    private LocationModel.a fBF;
    private LocationModel.b fBG;
    private final NewWriteModel.d fBH;
    private final com.baidu.adp.base.e fBI;
    private String fBq;
    protected LocationModel fBr;
    protected NewWriteModel fBs;
    protected ImageModel fBt;
    private DataModel<?> fBu;
    protected ForumData fBv;
    protected String fBw;
    private int fBx;
    protected NewWriteModel.d fBy;
    private c fBz;
    private EditorTools fyO;
    public boolean isBJH;
    private int mFrom;
    protected String mPostContent;
    protected SpanGroupManager mSpanGroupManager;
    protected String mThreadId;
    private VideoInfo mVideoInfo;
    protected VoiceData.VoiceModel mVoiceModel;
    protected String postId;
    protected WriteImagesInfo writeImagesInfo;

    public e(EditorTools editorTools) {
        super(editorTools);
        this.writeImagesInfo = new WriteImagesInfo();
        this.mPostContent = "";
        this.fBs = null;
        this.fBt = null;
        this.mThreadId = null;
        this.fBw = null;
        this.fBx = 0;
        this.fBB = false;
        this.mFrom = 0;
        this.fBE = true;
        this.fBF = new LocationModel.a() { // from class: com.baidu.tbadk.editortools.pb.e.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void bBP() {
                e.this.eSJ.showToast(R.string.no_network_guide);
                e.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                if (e.this.fBE) {
                    TbPageContext tbPageContext = e.this.eSJ;
                    if (StringUtils.isNull(str)) {
                        str = e.this.bAP().getContext().getString(R.string.location_fail);
                    }
                    tbPageContext.showToast(str);
                }
                e.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(LocationData locationData) {
                if (locationData != null && !StringUtils.isNull(locationData.getFormatted_address())) {
                    e.this.a(2, true, locationData.getFormatted_address());
                } else {
                    onFail(null);
                }
            }
        };
        this.fBG = new LocationModel.b() { // from class: com.baidu.tbadk.editortools.pb.e.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void bBQ() {
                e.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void CK(String str) {
                e.this.a(2, true, str);
            }
        };
        this.fBH = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.e.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                WriteData cYx = writeData == null ? e.this.fBs.cYx() : writeData;
                if (z) {
                    e.this.kW(true);
                    WriteData cYx2 = e.this.fBs.cYx();
                    e.this.resetData();
                    y.b(e.this.mThreadId, (WriteData) null);
                    if (cYx2 != null) {
                        if (cYx2.getType() == 2) {
                            y.a(cYx2.getThreadId(), e.this);
                        }
                    } else {
                        return;
                    }
                } else if (cYx != null && ahVar != null && !TextUtils.isEmpty(ahVar.bwm())) {
                    cYx.setVcodeMD5(ahVar.getVcode_md5());
                    cYx.setVcodeUrl(ahVar.getVcode_pic_url());
                    cYx.setVcodeExtra(ahVar.bwn());
                    if (e.this.ale != null) {
                        cYx.setBaijiahaoData(e.this.ale.getBaijiahaoData());
                    }
                    if (com.baidu.tbadk.t.a.DE(ahVar.bwm())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(e.this.eSJ.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cYx, false, ahVar.bwm())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(e.this.eSJ.getPageActivity(), cYx, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(e.this.eSJ.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cYx, postWriteCallBackData.getAccessState())));
                }
                e.this.c(e.this.fBs.cYx());
                if (e.this.fBy != null) {
                    e.this.fBy.callback(z, postWriteCallBackData, ahVar, cYx, antiData);
                }
            }
        };
        this.fBI = new com.baidu.adp.base.e() { // from class: com.baidu.tbadk.editortools.pb.e.7
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                if (obj instanceof Bitmap) {
                    e.this.fBs.yl(true);
                }
            }
        };
        this.fyO = editorTools;
    }

    public void qZ(int i) {
        if (this.fBD == null && bAP() != null) {
            this.fBD = (f) bAP().qP(27);
        }
        if (this.fBD != null) {
            this.fBD.setType(i);
        }
    }

    public void ra(int i) {
        if (this.fBD == null && bAP() != null) {
            this.fBD = (f) bAP().qP(27);
        }
        if (this.fBD != null) {
            this.fBD.rb(i);
        }
    }

    public f bBv() {
        if (this.fBD == null && bAP() != null) {
            this.fBD = (f) bAP().qP(27);
        }
        return this.fBD;
    }

    public void CE(String str) {
        if (this.fBD == null && bAP() != null) {
            this.fBD = (f) bAP().qP(27);
        }
        if (this.fBD != null) {
            this.fBD.setHint(str);
        }
    }

    public void kS(boolean z) {
        BLauncher bLauncher;
        if (bAP() != null && (bLauncher = (BLauncher) bAP().qM(5)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void kT(boolean z) {
        BLauncher bLauncher;
        if (bAP() != null && (bLauncher = (BLauncher) bAP().qM(23)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void kU(boolean z) {
        BLauncher bLauncher;
        if (bAP() != null && (bLauncher = (BLauncher) bAP().qM(2)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.fBu = dataModel;
    }

    public void setThreadId(String str) {
        this.mThreadId = str;
    }

    public void a(TbPageContext tbPageContext) {
        this.eSJ = tbPageContext;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.fBw = antiData.getVoice_message();
        }
    }

    public void a(ForumData forumData, UserData userData) {
        this.fBv = forumData;
    }

    public void setThreadData(bz bzVar) {
        this.ale = bzVar;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (bAP() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.authorNameShow = metaData.getName_show();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void kV(boolean z) {
        this.fBB = z;
    }

    public void bBw() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            if (String.valueOf(this.authorId).equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                l.showToast(this.eSJ.getPageActivity(), R.string.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.eSJ.getPageActivity(), this.authorId, this.authorName, this.authorNameShow, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.f.b.toLong(this.mThreadId, 0L), com.baidu.adp.lib.f.b.toLong(this.postId, 0L))));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_WRITE /* 11001 */:
                    a((String) null, (WriteData) null);
                    return;
                case RequestResponseCode.REQUEST_LOGIN_PB_AT /* 11025 */:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.eSJ.getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_LOGIN_SUB_PB_AT /* 11026 */:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.eSJ.getPageActivity(), RequestResponseCode.REQUEST_SUB_PB_AT_SELECT, true)));
                    return;
                case 12002:
                    if (intent != null) {
                        if (intent.getBooleanExtra("camera_result", false)) {
                            F(intent);
                        } else {
                            H(intent);
                        }
                        bAP().invalidate();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_IMAGE_VIEW /* 12003 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("delete", false)) {
                            bBH();
                            this.fBs.yl(false);
                            return;
                        }
                        this.fBt.CD(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        I(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    WriteData cYx = this.fBs.cYx();
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (cYx != null) {
                        cYx.deleteUploadedTempImages();
                    }
                    this.fBs.f((WriteData) null);
                    this.fBs.yl(false);
                    this.mVoiceModel = null;
                    this.mVideoInfo = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        y.b(this.mThreadId, (WriteData) null);
                    }
                    kW(true);
                    if (this.fBy != null) {
                        this.fBy.callback(true, postWriteCallBackData, null, cYx, null);
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
                    if (bAP() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            aq aqVar = new aq(TbadkCoreStatisticKey.XIAOYING_DURATION);
                            aqVar.an("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(aqVar);
                            bBI();
                            bAP().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            bAP().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                        CI(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 12001:
                bBF();
                return;
            case 12002:
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
                if (this.fBy != null) {
                    this.fBy.callback(false, postWriteCallBackData2, null, this.fBs.cYx(), null);
                    return;
                }
                return;
        }
    }

    public void bBx() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.eSJ.getPageActivity())));
    }

    public void bBy() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.eSJ.getPageActivity())) {
            this.eSJ.showToast(R.string.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bBB();
        } else if (this.fBr.dMe()) {
            bBx();
        } else {
            this.fBr.yj(false);
            a(1, true, (String) null);
            this.fBr.dMc();
        }
    }

    public void bBz() {
        if (!ad.checkLocationForGoogle(this.eSJ.getPageActivity())) {
            ad.c(this.eSJ.getPageActivity(), 0);
        } else {
            bBy();
        }
    }

    public void bBA() {
        if (!this.isBJH && this.fBr != null && !com.baidu.tieba.tbadkCore.location.b.dLZ().dMa() && UtilHelper.isSystemLocationProviderEnabled(this.eSJ.getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared()) {
            this.fBr.dMc();
        }
    }

    private void bBB() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eSJ.getPageActivity());
        aVar.nu(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    e.this.a(1, true, (String) null);
                    e.this.fBr.dMg();
                } else {
                    e.this.fBF.bBP();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                e.this.a(0, true, (String) null);
                aVar2.dismiss();
            }
        }).b(this.eSJ);
        aVar.bqe();
    }

    public void bBC() {
        if (this.fBr.ckC()) {
            if (this.fBr.dMe()) {
                this.fBF.a(com.baidu.tieba.tbadkCore.location.b.dLZ().getLocationData());
                return;
            }
            if (l.isNetOk()) {
                this.fBr.dMc();
            }
            a(0, true, (String) null);
            return;
        }
        a(0, false, (String) null);
    }

    public boolean bBD() {
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
        this.fBs.f((WriteData) null);
        this.fBs.yl(false);
        this.mVoiceModel = null;
        this.mVideoInfo = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void bBE() {
        this.mVideoInfo = null;
    }

    private void F(Intent intent) {
        this.fBq = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.fBq;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.eSJ.getPageActivity(), l.getEquipmentWidth(this.eSJ.getPageActivity())), l.dip2px(this.eSJ.getPageActivity(), l.getEquipmentHeight(this.eSJ.getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    n.a("cameras", this.fBq, rotateBitmapBydegree, 100);
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
        if (this.fBv != null) {
            threadData.setForumId(this.fBv.getId());
            threadData.setForumName(this.fBv.getName());
            threadData.setFirstDir(this.fBv.getFirst_class());
            threadData.setSecondDir(this.fBv.getSecond_class());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        threadData.isBJH = this.isBJH;
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.fBw);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.eSJ.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void c(u uVar) {
        if (uVar != null) {
            if (uVar.bwd() == EmotionGroupType.BIG_EMOTION || uVar.bwd() == EmotionGroupType.USER_COLLECT) {
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setImageType(1);
                imageFileInfo.setFilePath(uVar.getName());
                imageFileInfo.width = uVar.getWidth();
                imageFileInfo.height = uVar.getHeight();
                this.writeImagesInfo.addChooseFile(imageFileInfo);
                this.writeImagesInfo.updateQuality();
            }
        }
    }

    private void bBF() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tbadk.editortools.pb.e.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                n.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + e.this.fBq));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void H(Intent intent) {
        b(intent, true);
    }

    public void CF(String str) {
        WriteData cYx = this.fBs.cYx();
        if (cYx == null) {
            cYx = new WriteData(1);
            cYx.setThreadId(str);
            cYx.setWriteImagesInfo(this.writeImagesInfo);
        }
        cYx.setContent(this.mPostContent);
        cYx.setVideoInfo(this.mVideoInfo);
        cYx.setVoiceModel(this.mVoiceModel);
        y.b(str, cYx);
    }

    public void CG(String str) {
        y.a(str, this);
    }

    @Override // com.baidu.tieba.tbadkCore.y.a
    public void b(WriteData writeData) {
        if (writeData != null) {
            if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                if (this.mVideoInfo == null) {
                    this.mVideoInfo = new VideoInfo();
                }
                this.mVideoInfo.copy(writeData.getVideoInfo());
                bBI();
                bAP().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                    bAP().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                bAP().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            if (writeData.getVoiceModel() != null && writeData.getVoiceModel().voiceId != null && writeData.getVoiceModel().duration != -1) {
                if (this.mVoiceModel == null) {
                    this.mVoiceModel = new VoiceData.VoiceModel();
                }
                this.mVoiceModel.copy(writeData.getVoiceModel());
            }
            if (!at.isEmpty(writeData.getContent()) && at.isEmpty(this.mPostContent)) {
                this.mPostContent = writeData.getContent();
                CJ(this.mPostContent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void c(WriteData writeData) {
        if (writeData != null) {
            this.writeImagesInfo = new WriteImagesInfo();
            if (writeData.getWriteImagesInfo() != null) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                    bAP().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                bAP().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.mPostContent = writeData.getContent();
            CJ(this.mPostContent);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.fBs.cancelLoadData();
        this.fBt.cancelLoadData();
        this.fBr.cancelLoadData();
    }

    public void a(TbPageContext tbPageContext, Bundle bundle) {
        this.fBs = new NewWriteModel(tbPageContext);
        this.fBs.b(this.fBH);
        this.fBt = new ImageModel(tbPageContext);
        this.fBt.setLoadDataCallBack(this.fBI);
        this.fBr = new LocationModel(tbPageContext);
        this.fBr.a(this.fBF);
        this.fBr.a(this.fBG);
        if (bundle != null) {
            this.writeImagesInfo.parseJson(bundle.getString("write_images"));
            this.fBq = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(this.isBJH ? 1 : 9);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && bAP() != null) {
            bAP().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.fBr.ckC() && bAP() != null) {
            bAP().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            bAP().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.writeImagesInfo != null) {
            bundle.putString("write_images", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.fBq);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.fBs.cYx() == null) {
            WriteData CC = this.fBu.CC(str);
            if (CC != null && this.ale != null) {
                CC.setBaijiahaoData(this.ale.getBaijiahaoData());
            }
            this.fBs.f(CC);
        }
        if (this.fBs.cYx() != null) {
            this.fBs.setSpanGroupManager(this.mSpanGroupManager);
            if (this.fBB) {
                this.fBs.cYx().setCanNoForum(true);
                if (this.fBv != null) {
                    this.fBs.cYx().setVForumId(this.fBv.getId());
                    this.fBs.cYx().setVForumName(this.fBv.getName());
                }
            } else {
                this.fBs.cYx().setCanNoForum(false);
                this.fBs.cYx().setVForumId("");
                this.fBs.cYx().setVForumName("");
            }
            this.fBs.cYx().setIsBJHPost(this.isBJH);
            this.fBs.cYx().setWriteImagesInfo(this.writeImagesInfo);
            this.fBs.cYx().setVideoInfo(this.mVideoInfo);
            this.fBs.yl(this.writeImagesInfo.size() > 0);
            WriteData cYx = this.fBs.cYx();
            if (this.fBr == null || !this.fBr.ckC()) {
                z = false;
            }
            cYx.setHasLocationData(z);
            if (str == null) {
                this.fBs.cYx().setContent(this.mPostContent);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.fBs.cYx().setVoice(this.mVoiceModel.getId());
                    this.fBs.cYx().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.fBs.cYx().setVoice(null);
                    this.fBs.cYx().setVoiceDuringTime(-1);
                }
            } else {
                this.fBs.cYx().setVoice(null);
                this.fBs.cYx().setVoiceDuringTime(-1);
            }
            if (!this.fBs.dMM()) {
                this.eSJ.showToast(R.string.write_img_limit);
            } else if (this.fBA == null || !this.fBA.bBt()) {
                if (this.fBz != null) {
                    this.fBz.bBu();
                }
                d(this.fBs.cYx());
                if (!this.fBs.dMK()) {
                }
            }
        }
    }

    public TbPageContext bvT() {
        return this.eSJ;
    }

    public void CH(String str) {
        this.mPostContent = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int bBG() {
        return this.fBx;
    }

    private void bBH() {
        if (bAP() != null) {
            bAP().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void I(ArrayList<String> arrayList) {
        if (bAP() != null) {
            bAP().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void CI(String str) {
        if (bAP() != null) {
            bAP().b(new com.baidu.tbadk.editortools.a(44, 27, str));
        }
    }

    private void bBI() {
        if (bAP() != null) {
            bAP().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.fBx = i;
        if (bAP() != null) {
            bAP().b(new com.baidu.tbadk.editortools.a(19, 27, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void CJ(String str) {
        if (bAP() != null) {
            bAP().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kW(boolean z) {
        if (bAP() != null) {
            if (z) {
                bAP().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                bAP().b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
            bAP().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.fBy = dVar;
    }

    public void a(c cVar) {
        this.fBz = cVar;
    }

    public void a(b bVar) {
        this.fBA = bVar;
    }

    public void bBJ() {
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            this.writeImagesInfo.clear();
        }
        if (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) {
            this.mVideoInfo = null;
        }
        bAP().b(new com.baidu.tbadk.editortools.a(2, 19, null));
        setVoiceModel(null);
        bAP().b(new com.baidu.tbadk.editortools.a(2, 6, null));
        bAP().b(new com.baidu.tbadk.editortools.a(33, 6, null));
        if (!StringUtils.isNull(this.mPostContent)) {
            this.mPostContent = "";
        }
        CJ("");
        this.fBs.f((WriteData) null);
        this.fBs.yl(false);
    }

    public boolean bBK() {
        LinkedList<ImageFileInfo> chosedFiles;
        return (this.writeImagesInfo == null || (chosedFiles = this.writeImagesInfo.getChosedFiles()) == null || chosedFiles.isEmpty()) ? false : true;
    }

    public boolean bBL() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    private void bBM() {
        if (this.fBD == null && bAP() != null) {
            this.fBD = (f) bAP().qP(27);
        }
    }

    public void bBN() {
        if (this.fBD != null && this.fBC != null) {
            this.fBD.c(this.fBC);
        }
    }

    public void a(TextWatcher textWatcher) {
        bBM();
        if (this.fBD != null && textWatcher != null) {
            this.fBD.b(textWatcher);
        }
    }

    public void bBc() {
        if (this.fyO != null) {
            this.fyO.bBc();
        }
    }

    public void setSpanGroupManager(SpanGroupManager spanGroupManager) {
        this.mSpanGroupManager = spanGroupManager;
    }

    public void d(WriteData writeData) {
        int i = 0;
        if (writeData != null) {
            if (!TextUtils.isEmpty(writeData.getContent())) {
                int i2 = 0;
                while (aw.eZa.matcher(writeData.getContent()).find()) {
                    i2++;
                }
                if (i2 > 0 && this.mFrom > 0) {
                    aq aqVar = new aq("c13990");
                    aqVar.an("obj_type", i2);
                    aqVar.an("obj_source", this.mFrom);
                    aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar.dW("tid", writeData.getThreadId());
                    TiebaStatic.log(aqVar);
                }
            }
            if (writeData.getWriteImagesInfo() != null && !x.isEmpty(writeData.getWriteImagesInfo().getChosedFiles())) {
                for (ImageFileInfo imageFileInfo : writeData.getWriteImagesInfo().getChosedFiles()) {
                    if (imageFileInfo.getImageType() == 1) {
                        i++;
                    }
                }
                if (i > 0 && this.mFrom > 0) {
                    aq aqVar2 = new aq("c13991");
                    aqVar2.an("obj_type", i);
                    aqVar2.an("obj_source", this.mFrom);
                    aqVar2.dW("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar2.dW("tid", writeData.getThreadId());
                    TiebaStatic.log(aqVar2);
                }
            }
        }
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void bBO() {
        this.fBE = false;
    }
}
