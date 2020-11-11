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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.y;
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
import com.baidu.tieba.tbadkCore.x;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes21.dex */
public class e extends com.baidu.tbadk.editortools.e implements x.a {
    private bw akq;
    protected long authorId;
    protected String authorName;
    protected String authorNameShow;
    protected TbPageContext eIc;
    private EditorTools fne;
    private String fpG;
    protected LocationModel fpH;
    protected NewWriteModel fpI;
    protected ImageModel fpJ;
    private DataModel<?> fpK;
    protected ForumData fpL;
    protected String fpM;
    private int fpN;
    protected NewWriteModel.d fpO;
    private c fpP;
    protected b fpQ;
    protected boolean fpR;
    private TextWatcher fpS;
    private f fpT;
    private LocationModel.a fpU;
    private LocationModel.b fpV;
    private final NewWriteModel.d fpW;
    private final com.baidu.adp.base.d fpX;
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
        this.fpI = null;
        this.fpJ = null;
        this.mThreadId = null;
        this.fpM = null;
        this.fpN = 0;
        this.fpR = false;
        this.mFrom = 0;
        this.fpU = new LocationModel.a() { // from class: com.baidu.tbadk.editortools.pb.e.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void bAw() {
                e.this.eIc.showToast(R.string.no_network_guide);
                e.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                TbPageContext tbPageContext = e.this.eIc;
                if (StringUtils.isNull(str)) {
                    str = e.this.bzx().getContext().getString(R.string.location_fail);
                }
                tbPageContext.showToast(str);
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
        this.fpV = new LocationModel.b() { // from class: com.baidu.tbadk.editortools.pb.e.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void bAx() {
                e.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void DS(String str) {
                e.this.a(2, true, str);
            }
        };
        this.fpW = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.e.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                WriteData cXW = writeData == null ? e.this.fpI.cXW() : writeData;
                if (z) {
                    e.this.km(true);
                    WriteData cXW2 = e.this.fpI.cXW();
                    e.this.resetData();
                    x.f(e.this.mThreadId, (WriteData) null);
                    if (cXW2 != null) {
                        if (cXW2.getType() == 2) {
                            x.a(cXW2.getThreadId(), e.this);
                        }
                    } else {
                        return;
                    }
                } else if (cXW != null && ahVar != null && !TextUtils.isEmpty(ahVar.buV())) {
                    cXW.setVcodeMD5(ahVar.getVcode_md5());
                    cXW.setVcodeUrl(ahVar.getVcode_pic_url());
                    cXW.setVcodeExtra(ahVar.buW());
                    if (e.this.akq != null) {
                        cXW.setBaijiahaoData(e.this.akq.getBaijiahaoData());
                    }
                    if (com.baidu.tbadk.t.a.EE(ahVar.buV())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(e.this.eIc.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cXW, false, ahVar.buV())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(e.this.eIc.getPageActivity(), cXW, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(e.this.eIc.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cXW, postWriteCallBackData.getAccessState())));
                }
                e.this.b(e.this.fpI.cXW());
                if (e.this.fpO != null) {
                    e.this.fpO.callback(z, postWriteCallBackData, ahVar, cXW, antiData);
                }
            }
        };
        this.fpX = new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.editortools.pb.e.7
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Bitmap) {
                    e.this.fpI.xy(true);
                }
            }
        };
        this.fne = editorTools;
    }

    public void ru(int i) {
        if (this.fpT == null && bzx() != null) {
            this.fpT = (f) bzx().rk(27);
        }
        if (this.fpT != null) {
            this.fpT.setType(i);
        }
    }

    public void rv(int i) {
        if (this.fpT == null && bzx() != null) {
            this.fpT = (f) bzx().rk(27);
        }
        if (this.fpT != null) {
            this.fpT.rw(i);
        }
    }

    public f bAd() {
        if (this.fpT == null && bzx() != null) {
            this.fpT = (f) bzx().rk(27);
        }
        return this.fpT;
    }

    public void DM(String str) {
        if (this.fpT == null && bzx() != null) {
            this.fpT = (f) bzx().rk(27);
        }
        if (this.fpT != null) {
            this.fpT.setHint(str);
        }
    }

    public void ki(boolean z) {
        BLauncher bLauncher;
        if (bzx() != null && (bLauncher = (BLauncher) bzx().rh(5)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void kj(boolean z) {
        BLauncher bLauncher;
        if (bzx() != null && (bLauncher = (BLauncher) bzx().rh(23)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void kk(boolean z) {
        BLauncher bLauncher;
        if (bzx() != null && (bLauncher = (BLauncher) bzx().rh(2)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.fpK = dataModel;
    }

    public void setThreadId(String str) {
        this.mThreadId = str;
    }

    public void a(TbPageContext tbPageContext) {
        this.eIc = tbPageContext;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.fpM = antiData.getVoice_message();
        }
    }

    public void a(ForumData forumData, UserData userData) {
        this.fpL = forumData;
    }

    public void setThreadData(bw bwVar) {
        this.akq = bwVar;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (bzx() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.authorNameShow = metaData.getName_show();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void kl(boolean z) {
        this.fpR = z;
    }

    public void bAe() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            if (String.valueOf(this.authorId).equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                l.showToast(this.eIc.getPageActivity(), R.string.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.eIc.getPageActivity(), this.authorId, this.authorName, this.authorNameShow, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.f.b.toLong(this.mThreadId, 0L), com.baidu.adp.lib.f.b.toLong(this.postId, 0L))));
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.eIc.getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_LOGIN_SUB_PB_AT /* 11026 */:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.eIc.getPageActivity(), RequestResponseCode.REQUEST_SUB_PB_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("camera_result", false)) {
                            E(intent);
                        } else {
                            G(intent);
                        }
                        bzx().invalidate();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_IMAGE_VIEW /* 12003 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("delete", false)) {
                            bAp();
                            this.fpI.xy(false);
                            return;
                        }
                        this.fpJ.DL(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        N(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    WriteData cXW = this.fpI.cXW();
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (cXW != null) {
                        cXW.deleteUploadedTempImages();
                    }
                    this.fpI.e((WriteData) null);
                    this.fpI.xy(false);
                    this.mVoiceModel = null;
                    this.mVideoInfo = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        x.f(this.mThreadId, (WriteData) null);
                    }
                    km(true);
                    if (this.fpO != null) {
                        this.fpO.callback(true, postWriteCallBackData, null, cXW, null);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    if (i == 12010) {
                        E(intent);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    F(intent);
                    return;
                case RequestResponseCode.REQUEST_RECORDER_VIDEO /* 13010 */:
                    if (bzx() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            aq aqVar = new aq(TbadkCoreStatisticKey.XIAOYING_DURATION);
                            aqVar.al("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(aqVar);
                            bAq();
                            bzx().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            bzx().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                        DQ(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case RequestResponseCode.REQUEST_CAMERA /* 12001 */:
                bAn();
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
                if (this.fpO != null) {
                    this.fpO.callback(false, postWriteCallBackData2, null, this.fpI.cXW(), null);
                    return;
                }
                return;
        }
    }

    public void bAf() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.eIc.getPageActivity())));
    }

    public void bAg() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.eIc.getPageActivity())) {
            this.eIc.showToast(R.string.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bAj();
        } else if (this.fpH.dKH()) {
            bAf();
        } else {
            this.fpH.xw(false);
            a(1, true, (String) null);
            this.fpH.dKF();
        }
    }

    public void bAh() {
        if (!ae.checkLocationForGoogle(this.eIc.getPageActivity())) {
            ae.c(this.eIc.getPageActivity(), 0);
        } else {
            bAg();
        }
    }

    public void bAi() {
        if (!this.isBJH && this.fpH != null && !com.baidu.tieba.tbadkCore.location.b.dKC().dKD() && UtilHelper.isSystemLocationProviderEnabled(this.eIc.getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared()) {
            this.fpH.dKF();
        }
    }

    private void bAj() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eIc.getPageActivity());
        aVar.ow(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    e.this.a(1, true, (String) null);
                    e.this.fpH.dKJ();
                } else {
                    e.this.fpU.bAw();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                e.this.a(0, true, (String) null);
                aVar2.dismiss();
            }
        }).b(this.eIc);
        aVar.bpc();
    }

    public void bAk() {
        if (this.fpH.cin()) {
            if (this.fpH.dKH()) {
                this.fpU.a(com.baidu.tieba.tbadkCore.location.b.dKC().getLocationData());
                return;
            }
            if (l.isNetOk()) {
                this.fpH.dKF();
            }
            a(0, true, (String) null);
            return;
        }
        a(0, false, (String) null);
    }

    public boolean bAl() {
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
        this.fpI.e((WriteData) null);
        this.fpI.xy(false);
        this.mVoiceModel = null;
        this.mVideoInfo = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void bAm() {
        this.mVideoInfo = null;
    }

    private void E(Intent intent) {
        this.fpG = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.fpG;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.eIc.getPageActivity(), l.getEquipmentWidth(this.eIc.getPageActivity())), l.dip2px(this.eIc.getPageActivity(), l.getEquipmentHeight(this.eIc.getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    n.a("cameras", this.fpG, rotateBitmapBydegree, 100);
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

    private void F(Intent intent) {
        a(intent, false);
    }

    private void a(Intent intent, boolean z) {
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
        if (this.fpL != null) {
            threadData.setForumId(this.fpL.getId());
            threadData.setForumName(this.fpL.getName());
            threadData.setFirstDir(this.fpL.getFirst_class());
            threadData.setSecondDir(this.fpL.getSecond_class());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        threadData.isBJH = this.isBJH;
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.fpM);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.eIc.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void c(u uVar) {
        if (uVar != null) {
            if (uVar.buM() == EmotionGroupType.BIG_EMOTION || uVar.buM() == EmotionGroupType.USER_COLLECT) {
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

    private void bAn() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tbadk.editortools.pb.e.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                n.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + e.this.fpG));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void G(Intent intent) {
        a(intent, true);
    }

    public void DN(String str) {
        WriteData cXW = this.fpI.cXW();
        if (cXW == null) {
            cXW = new WriteData(1);
            cXW.setThreadId(str);
            cXW.setWriteImagesInfo(this.writeImagesInfo);
        }
        cXW.setContent(this.mPostContent);
        cXW.setVideoInfo(this.mVideoInfo);
        cXW.setVoiceModel(this.mVoiceModel);
        x.f(str, cXW);
    }

    public void DO(String str) {
        x.a(str, this);
    }

    @Override // com.baidu.tieba.tbadkCore.x.a
    public void a(WriteData writeData) {
        if (writeData != null) {
            if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                if (this.mVideoInfo == null) {
                    this.mVideoInfo = new VideoInfo();
                }
                this.mVideoInfo.copy(writeData.getVideoInfo());
                bAq();
                bzx().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                    bzx().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                bzx().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            if (writeData.getVoiceModel() != null && writeData.getVoiceModel().voiceId != null && writeData.getVoiceModel().duration != -1) {
                if (this.mVoiceModel == null) {
                    this.mVoiceModel = new VoiceData.VoiceModel();
                }
                this.mVoiceModel.copy(writeData.getVoiceModel());
            }
            if (!at.isEmpty(writeData.getContent()) && at.isEmpty(this.mPostContent)) {
                this.mPostContent = writeData.getContent();
                DR(this.mPostContent);
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
                    bzx().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                bzx().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.mPostContent = writeData.getContent();
            DR(this.mPostContent);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.fpI.cancelLoadData();
        this.fpJ.cancelLoadData();
        this.fpH.cancelLoadData();
    }

    public void a(TbPageContext tbPageContext, Bundle bundle) {
        this.fpI = new NewWriteModel(tbPageContext);
        this.fpI.b(this.fpW);
        this.fpJ = new ImageModel(tbPageContext);
        this.fpJ.setLoadDataCallBack(this.fpX);
        this.fpH = new LocationModel(tbPageContext);
        this.fpH.a(this.fpU);
        this.fpH.a(this.fpV);
        if (bundle != null) {
            this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
            this.fpG = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(this.isBJH ? 1 : 9);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && bzx() != null) {
            bzx().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.fpH.cin() && bzx() != null) {
            bzx().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            bzx().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.writeImagesInfo != null) {
            bundle.putString(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.fpG);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.fpI.cXW() == null) {
            WriteData DK = this.fpK.DK(str);
            if (DK != null && this.akq != null) {
                DK.setBaijiahaoData(this.akq.getBaijiahaoData());
            }
            this.fpI.e(DK);
        }
        if (this.fpI.cXW() != null) {
            this.fpI.setSpanGroupManager(this.mSpanGroupManager);
            if (this.fpR) {
                this.fpI.cXW().setCanNoForum(true);
                if (this.fpL != null) {
                    this.fpI.cXW().setVForumId(this.fpL.getId());
                    this.fpI.cXW().setVForumName(this.fpL.getName());
                }
            } else {
                this.fpI.cXW().setCanNoForum(false);
                this.fpI.cXW().setVForumId("");
                this.fpI.cXW().setVForumName("");
            }
            this.fpI.cXW().setIsBJHPost(this.isBJH);
            this.fpI.cXW().setWriteImagesInfo(this.writeImagesInfo);
            this.fpI.cXW().setVideoInfo(this.mVideoInfo);
            this.fpI.xy(this.writeImagesInfo.size() > 0);
            WriteData cXW = this.fpI.cXW();
            if (this.fpH == null || !this.fpH.cin()) {
                z = false;
            }
            cXW.setHasLocationData(z);
            if (str == null) {
                this.fpI.cXW().setContent(this.mPostContent);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.fpI.cXW().setVoice(this.mVoiceModel.getId());
                    this.fpI.cXW().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.fpI.cXW().setVoice(null);
                    this.fpI.cXW().setVoiceDuringTime(-1);
                }
            } else {
                this.fpI.cXW().setVoice(null);
                this.fpI.cXW().setVoiceDuringTime(-1);
            }
            if (!this.fpI.dLp()) {
                this.eIc.showToast(R.string.write_img_limit);
            } else if (this.fpQ == null || !this.fpQ.bAb()) {
                if (this.fpP != null) {
                    this.fpP.bAc();
                }
                c(this.fpI.cXW());
                if (!this.fpI.dLm()) {
                }
            }
        }
    }

    public TbPageContext buC() {
        return this.eIc;
    }

    public void DP(String str) {
        this.mPostContent = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int bAo() {
        return this.fpN;
    }

    private void bAp() {
        if (bzx() != null) {
            bzx().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void N(ArrayList<String> arrayList) {
        if (bzx() != null) {
            bzx().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void DQ(String str) {
        if (bzx() != null) {
            bzx().b(new com.baidu.tbadk.editortools.a(44, 27, str));
        }
    }

    private void bAq() {
        if (bzx() != null) {
            bzx().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.fpN = i;
        if (bzx() != null) {
            bzx().b(new com.baidu.tbadk.editortools.a(19, 27, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void DR(String str) {
        if (bzx() != null) {
            bzx().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void km(boolean z) {
        if (bzx() != null) {
            if (z) {
                bzx().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                bzx().b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
            bzx().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.fpO = dVar;
    }

    public void a(c cVar) {
        this.fpP = cVar;
    }

    public void a(b bVar) {
        this.fpQ = bVar;
    }

    public void bAr() {
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            this.writeImagesInfo.clear();
        }
        if (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) {
            this.mVideoInfo = null;
        }
        bzx().b(new com.baidu.tbadk.editortools.a(2, 19, null));
        setVoiceModel(null);
        bzx().b(new com.baidu.tbadk.editortools.a(2, 6, null));
        bzx().b(new com.baidu.tbadk.editortools.a(33, 6, null));
        if (!StringUtils.isNull(this.mPostContent)) {
            this.mPostContent = "";
        }
        DR("");
        this.fpI.e((WriteData) null);
        this.fpI.xy(false);
    }

    public boolean bAs() {
        LinkedList<ImageFileInfo> chosedFiles;
        return (this.writeImagesInfo == null || (chosedFiles = this.writeImagesInfo.getChosedFiles()) == null || chosedFiles.isEmpty()) ? false : true;
    }

    public boolean bAt() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    private void bAu() {
        if (this.fpT == null && bzx() != null) {
            this.fpT = (f) bzx().rk(27);
        }
    }

    public void bAv() {
        if (this.fpT != null && this.fpS != null) {
            this.fpT.c(this.fpS);
        }
    }

    public void a(TextWatcher textWatcher) {
        bAu();
        if (this.fpT != null && textWatcher != null) {
            this.fpT.b(textWatcher);
        }
    }

    public void bzK() {
        if (this.fne != null) {
            this.fne.bzK();
        }
    }

    public void setSpanGroupManager(SpanGroupManager spanGroupManager) {
        this.mSpanGroupManager = spanGroupManager;
    }

    public void c(WriteData writeData) {
        int i = 0;
        if (writeData != null) {
            if (!TextUtils.isEmpty(writeData.getContent())) {
                int i2 = 0;
                while (aw.eNW.matcher(writeData.getContent()).find()) {
                    i2++;
                }
                if (i2 > 0 && this.mFrom > 0) {
                    aq aqVar = new aq("c13990");
                    aqVar.al("obj_type", i2);
                    aqVar.al("obj_source", this.mFrom);
                    aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar.dR("tid", writeData.getThreadId());
                    TiebaStatic.log(aqVar);
                }
            }
            if (writeData.getWriteImagesInfo() != null && !y.isEmpty(writeData.getWriteImagesInfo().getChosedFiles())) {
                for (ImageFileInfo imageFileInfo : writeData.getWriteImagesInfo().getChosedFiles()) {
                    if (imageFileInfo.getImageType() == 1) {
                        i++;
                    }
                }
                if (i > 0 && this.mFrom > 0) {
                    aq aqVar2 = new aq("c13991");
                    aqVar2.al("obj_type", i);
                    aqVar2.al("obj_source", this.mFrom);
                    aqVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar2.dR("tid", writeData.getThreadId());
                    TiebaStatic.log(aqVar2);
                }
            }
        }
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }
}
