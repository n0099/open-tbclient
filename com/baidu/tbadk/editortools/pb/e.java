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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.o;
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
    private cb akU;
    protected long authorId;
    protected String authorName;
    protected String authorNameShow;
    protected TbPageContext eUY;
    private EditorTools fBd;
    private String fDF;
    protected LocationModel fDG;
    protected NewWriteModel fDH;
    protected ImageModel fDI;
    private DataModel<?> fDJ;
    protected ForumData fDK;
    protected String fDL;
    private int fDM;
    protected NewWriteModel.d fDN;
    private c fDO;
    protected b fDP;
    protected boolean fDQ;
    private TextWatcher fDR;
    private f fDS;
    private boolean fDT;
    private LocationModel.a fDU;
    private LocationModel.b fDV;
    private final NewWriteModel.d fDW;
    private final com.baidu.adp.base.e fDX;
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
        this.fDH = null;
        this.fDI = null;
        this.mThreadId = null;
        this.fDL = null;
        this.fDM = 0;
        this.fDQ = false;
        this.mFrom = 0;
        this.fDT = true;
        this.fDU = new LocationModel.a() { // from class: com.baidu.tbadk.editortools.pb.e.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void bCh() {
                e.this.eUY.showToast(R.string.no_network_guide);
                e.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                if (e.this.fDT) {
                    TbPageContext tbPageContext = e.this.eUY;
                    if (StringUtils.isNull(str)) {
                        str = e.this.bBh().getContext().getString(R.string.location_fail);
                    }
                    tbPageContext.showToast(str);
                }
                e.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(LocationData locationData) {
                if (locationData != null && !StringUtils.isNull(locationData.getFormatted_address())) {
                    e.this.b(2, true, locationData.getFormatted_address());
                } else {
                    onFail(null);
                }
            }
        };
        this.fDV = new LocationModel.b() { // from class: com.baidu.tbadk.editortools.pb.e.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void bCi() {
                e.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void CZ(String str) {
                e.this.b(2, true, str);
            }
        };
        this.fDW = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.e.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                WriteData daC = writeData == null ? e.this.fDH.daC() : writeData;
                if (z) {
                    e.this.kZ(true);
                    WriteData daC2 = e.this.fDH.daC();
                    e.this.resetData();
                    y.b(e.this.mThreadId, (WriteData) null);
                    if (daC2 != null) {
                        if (daC2.getType() == 2) {
                            y.a(daC2.getThreadId(), e.this);
                        }
                    } else {
                        return;
                    }
                } else if (daC != null && ahVar != null && !TextUtils.isEmpty(ahVar.bwE())) {
                    daC.setVcodeMD5(ahVar.getVcode_md5());
                    daC.setVcodeUrl(ahVar.getVcode_pic_url());
                    daC.setVcodeExtra(ahVar.bwF());
                    if (e.this.akU != null) {
                        daC.setBaijiahaoData(e.this.akU.getBaijiahaoData());
                    }
                    if (com.baidu.tbadk.t.a.DY(ahVar.bwE())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(e.this.eUY.getPageActivity(), RequestResponseCode.REQUEST_VCODE, daC, false, ahVar.bwE())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(e.this.eUY.getPageActivity(), daC, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(e.this.eUY.getPageActivity(), RequestResponseCode.REQUEST_VCODE, daC, postWriteCallBackData.getAccessState())));
                }
                e.this.c(e.this.fDH.daC());
                if (e.this.fDN != null) {
                    e.this.fDN.callback(z, postWriteCallBackData, ahVar, daC, antiData);
                }
            }
        };
        this.fDX = new com.baidu.adp.base.e() { // from class: com.baidu.tbadk.editortools.pb.e.7
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                if (obj instanceof Bitmap) {
                    e.this.fDH.yE(true);
                }
            }
        };
        this.fBd = editorTools;
    }

    public void re(int i) {
        if (this.fDS == null && bBh() != null) {
            this.fDS = (f) bBh().qU(27);
        }
        if (this.fDS != null) {
            this.fDS.setType(i);
        }
    }

    public void rf(int i) {
        if (this.fDS == null && bBh() != null) {
            this.fDS = (f) bBh().qU(27);
        }
        if (this.fDS != null) {
            this.fDS.rg(i);
        }
    }

    public f bBN() {
        if (this.fDS == null && bBh() != null) {
            this.fDS = (f) bBh().qU(27);
        }
        return this.fDS;
    }

    public void CT(String str) {
        if (this.fDS == null && bBh() != null) {
            this.fDS = (f) bBh().qU(27);
        }
        if (this.fDS != null) {
            this.fDS.setHint(str);
        }
    }

    public void kV(boolean z) {
        BLauncher bLauncher;
        if (bBh() != null && (bLauncher = (BLauncher) bBh().qR(5)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void kW(boolean z) {
        BLauncher bLauncher;
        if (bBh() != null && (bLauncher = (BLauncher) bBh().qR(23)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void kX(boolean z) {
        BLauncher bLauncher;
        if (bBh() != null && (bLauncher = (BLauncher) bBh().qR(2)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.fDJ = dataModel;
    }

    public void setThreadId(String str) {
        this.mThreadId = str;
    }

    public void a(TbPageContext tbPageContext) {
        this.eUY = tbPageContext;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.fDL = antiData.getVoice_message();
        }
    }

    public void a(ForumData forumData, UserData userData) {
        this.fDK = forumData;
    }

    public void setThreadData(cb cbVar) {
        this.akU = cbVar;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (bBh() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.authorNameShow = metaData.getName_show();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void kY(boolean z) {
        this.fDQ = z;
    }

    public void bBO() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            if (String.valueOf(this.authorId).equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                l.showToast(this.eUY.getPageActivity(), R.string.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.eUY.getPageActivity(), this.authorId, this.authorName, this.authorNameShow, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.f.b.toLong(this.mThreadId, 0L), com.baidu.adp.lib.f.b.toLong(this.postId, 0L))));
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.eUY.getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_LOGIN_SUB_PB_AT /* 11026 */:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.eUY.getPageActivity(), RequestResponseCode.REQUEST_SUB_PB_AT_SELECT, true)));
                    return;
                case 12002:
                    if (intent != null) {
                        if (intent.getBooleanExtra("camera_result", false)) {
                            F(intent);
                        } else {
                            H(intent);
                        }
                        bBh().invalidate();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_IMAGE_VIEW /* 12003 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("delete", false)) {
                            bBZ();
                            this.fDH.yE(false);
                            return;
                        }
                        this.fDI.CS(intent.getStringExtra("file_name"));
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
                    WriteData daC = this.fDH.daC();
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (daC != null) {
                        daC.deleteUploadedTempImages();
                    }
                    this.fDH.f((WriteData) null);
                    this.fDH.yE(false);
                    this.mVoiceModel = null;
                    this.mVideoInfo = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        y.b(this.mThreadId, (WriteData) null);
                    }
                    kZ(true);
                    if (this.fDN != null) {
                        this.fDN.callback(true, postWriteCallBackData, null, daC, null);
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
                    if (bBh() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            ar arVar = new ar(TbadkCoreStatisticKey.XIAOYING_DURATION);
                            arVar.ap("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(arVar);
                            bCa();
                            bBh().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            bBh().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                        CX(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 12001:
                bBX();
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
                if (this.fDN != null) {
                    this.fDN.callback(false, postWriteCallBackData2, null, this.fDH.daC(), null);
                    return;
                }
                return;
        }
    }

    public void bBP() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.eUY.getPageActivity())));
    }

    public void bBQ() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.eUY.getPageActivity())) {
            this.eUY.showToast(R.string.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bBT();
        } else if (this.fDG.dOx()) {
            bBP();
        } else {
            this.fDG.yC(false);
            b(1, true, null);
            this.fDG.dOv();
        }
    }

    public void bBR() {
        if (!ae.checkLocationForGoogle(this.eUY.getPageActivity())) {
            ae.c(this.eUY.getPageActivity(), 0);
        } else {
            bBQ();
        }
    }

    public void bBS() {
        if (!this.isBJH && this.fDG != null && !com.baidu.tieba.tbadkCore.location.b.dOs().dOt() && UtilHelper.isSystemLocationProviderEnabled(this.eUY.getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared()) {
            this.fDG.dOv();
        }
    }

    private void bBT() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eUY.getPageActivity());
        aVar.nx(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    e.this.b(1, true, null);
                    e.this.fDG.dOz();
                } else {
                    e.this.fDU.bCh();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                e.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(this.eUY);
        aVar.bqx();
    }

    public void bBU() {
        if (this.fDG.clH()) {
            if (this.fDG.dOx()) {
                this.fDU.a(com.baidu.tieba.tbadkCore.location.b.dOs().getLocationData());
                return;
            }
            if (l.isNetOk()) {
                this.fDG.dOv();
            }
            b(0, true, null);
            return;
        }
        b(0, false, null);
    }

    public boolean bBV() {
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
        this.fDH.f((WriteData) null);
        this.fDH.yE(false);
        this.mVoiceModel = null;
        this.mVideoInfo = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void bBW() {
        this.mVideoInfo = null;
    }

    private void F(Intent intent) {
        this.fDF = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.fDF;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.eUY.getPageActivity(), l.getEquipmentWidth(this.eUY.getPageActivity())), l.dip2px(this.eUY.getPageActivity(), l.getEquipmentHeight(this.eUY.getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    o.a("cameras", this.fDF, rotateBitmapBydegree, 100);
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
        if (this.fDK != null) {
            threadData.setForumId(this.fDK.getId());
            threadData.setForumName(this.fDK.getName());
            threadData.setFirstDir(this.fDK.getFirst_class());
            threadData.setSecondDir(this.fDK.getSecond_class());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        threadData.isBJH = this.isBJH;
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.fDL);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.eUY.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void c(u uVar) {
        if (uVar != null) {
            if (uVar.bwv() == EmotionGroupType.BIG_EMOTION || uVar.bwv() == EmotionGroupType.USER_COLLECT) {
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

    private void bBX() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tbadk.editortools.pb.e.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                o.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + e.this.fDF));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void H(Intent intent) {
        b(intent, true);
    }

    public void CU(String str) {
        WriteData daC = this.fDH.daC();
        if (daC == null) {
            daC = new WriteData(1);
            daC.setThreadId(str);
            daC.setWriteImagesInfo(this.writeImagesInfo);
        }
        daC.setContent(this.mPostContent);
        daC.setVideoInfo(this.mVideoInfo);
        daC.setVoiceModel(this.mVoiceModel);
        y.b(str, daC);
    }

    public void CV(String str) {
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
                bCa();
                bBh().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                    bBh().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                bBh().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            if (writeData.getVoiceModel() != null && writeData.getVoiceModel().voiceId != null && writeData.getVoiceModel().duration != -1) {
                if (this.mVoiceModel == null) {
                    this.mVoiceModel = new VoiceData.VoiceModel();
                }
                this.mVoiceModel.copy(writeData.getVoiceModel());
            }
            if (!au.isEmpty(writeData.getContent()) && au.isEmpty(this.mPostContent)) {
                this.mPostContent = writeData.getContent();
                CY(this.mPostContent);
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
                    bBh().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                bBh().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.mPostContent = writeData.getContent();
            CY(this.mPostContent);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.fDH.cancelLoadData();
        this.fDI.cancelLoadData();
        this.fDG.cancelLoadData();
    }

    public void a(TbPageContext tbPageContext, Bundle bundle) {
        this.fDH = new NewWriteModel(tbPageContext);
        this.fDH.b(this.fDW);
        this.fDI = new ImageModel(tbPageContext);
        this.fDI.setLoadDataCallBack(this.fDX);
        this.fDG = new LocationModel(tbPageContext);
        this.fDG.a(this.fDU);
        this.fDG.a(this.fDV);
        if (bundle != null) {
            this.writeImagesInfo.parseJson(bundle.getString("write_images"));
            this.fDF = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(this.isBJH ? 1 : 9);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && bBh() != null) {
            bBh().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.fDG.clH() && bBh() != null) {
            bBh().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            bBh().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.writeImagesInfo != null) {
            bundle.putString("write_images", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.fDF);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.fDH.daC() == null) {
            WriteData CR = this.fDJ.CR(str);
            if (CR != null && this.akU != null) {
                CR.setBaijiahaoData(this.akU.getBaijiahaoData());
            }
            this.fDH.f(CR);
        }
        if (this.fDH.daC() != null) {
            this.fDH.setSpanGroupManager(this.mSpanGroupManager);
            if (this.fDQ) {
                this.fDH.daC().setCanNoForum(true);
                if (this.fDK != null) {
                    this.fDH.daC().setVForumId(this.fDK.getId());
                    this.fDH.daC().setVForumName(this.fDK.getName());
                }
            } else {
                this.fDH.daC().setCanNoForum(false);
                this.fDH.daC().setVForumId("");
                this.fDH.daC().setVForumName("");
            }
            this.fDH.daC().setIsBJHPost(this.isBJH);
            this.fDH.daC().setWriteImagesInfo(this.writeImagesInfo);
            this.fDH.daC().setVideoInfo(this.mVideoInfo);
            this.fDH.yE(this.writeImagesInfo.size() > 0);
            WriteData daC = this.fDH.daC();
            if (this.fDG == null || !this.fDG.clH()) {
                z = false;
            }
            daC.setHasLocationData(z);
            if (str == null) {
                this.fDH.daC().setContent(this.mPostContent);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.fDH.daC().setVoice(this.mVoiceModel.getId());
                    this.fDH.daC().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.fDH.daC().setVoice(null);
                    this.fDH.daC().setVoiceDuringTime(-1);
                }
            } else {
                this.fDH.daC().setVoice(null);
                this.fDH.daC().setVoiceDuringTime(-1);
            }
            if (!this.fDH.dPf()) {
                this.eUY.showToast(R.string.write_img_limit);
            } else if (this.fDP == null || !this.fDP.bBL()) {
                if (this.fDO != null) {
                    this.fDO.bBM();
                }
                d(this.fDH.daC());
                if (!this.fDH.dPd()) {
                }
            }
        }
    }

    public TbPageContext bwm() {
        return this.eUY;
    }

    public void CW(String str) {
        this.mPostContent = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int bBY() {
        return this.fDM;
    }

    private void bBZ() {
        if (bBh() != null) {
            bBh().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void I(ArrayList<String> arrayList) {
        if (bBh() != null) {
            bBh().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void CX(String str) {
        if (bBh() != null) {
            bBh().b(new com.baidu.tbadk.editortools.a(44, 27, str));
        }
    }

    private void bCa() {
        if (bBh() != null) {
            bBh().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.fDM = i;
        if (bBh() != null) {
            bBh().b(new com.baidu.tbadk.editortools.a(19, 27, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void CY(String str) {
        if (bBh() != null) {
            bBh().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kZ(boolean z) {
        if (bBh() != null) {
            if (z) {
                bBh().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                bBh().b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
            bBh().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.fDN = dVar;
    }

    public void a(c cVar) {
        this.fDO = cVar;
    }

    public void a(b bVar) {
        this.fDP = bVar;
    }

    public void bCb() {
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            this.writeImagesInfo.clear();
        }
        if (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) {
            this.mVideoInfo = null;
        }
        bBh().b(new com.baidu.tbadk.editortools.a(2, 19, null));
        setVoiceModel(null);
        bBh().b(new com.baidu.tbadk.editortools.a(2, 6, null));
        bBh().b(new com.baidu.tbadk.editortools.a(33, 6, null));
        if (!StringUtils.isNull(this.mPostContent)) {
            this.mPostContent = "";
        }
        CY("");
        this.fDH.f((WriteData) null);
        this.fDH.yE(false);
    }

    public boolean bCc() {
        LinkedList<ImageFileInfo> chosedFiles;
        return (this.writeImagesInfo == null || (chosedFiles = this.writeImagesInfo.getChosedFiles()) == null || chosedFiles.isEmpty()) ? false : true;
    }

    public boolean bCd() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    private void bCe() {
        if (this.fDS == null && bBh() != null) {
            this.fDS = (f) bBh().qU(27);
        }
    }

    public void bCf() {
        if (this.fDS != null && this.fDR != null) {
            this.fDS.c(this.fDR);
        }
    }

    public void a(TextWatcher textWatcher) {
        bCe();
        if (this.fDS != null && textWatcher != null) {
            this.fDS.b(textWatcher);
        }
    }

    public void bBu() {
        if (this.fBd != null) {
            this.fBd.bBu();
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
                while (ax.fbp.matcher(writeData.getContent()).find()) {
                    i2++;
                }
                if (i2 > 0 && this.mFrom > 0) {
                    ar arVar = new ar("c13990");
                    arVar.ap("obj_type", i2);
                    arVar.ap("obj_source", this.mFrom);
                    arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    arVar.dR("tid", writeData.getThreadId());
                    TiebaStatic.log(arVar);
                }
            }
            if (writeData.getWriteImagesInfo() != null && !com.baidu.tbadk.core.util.y.isEmpty(writeData.getWriteImagesInfo().getChosedFiles())) {
                for (ImageFileInfo imageFileInfo : writeData.getWriteImagesInfo().getChosedFiles()) {
                    if (imageFileInfo.getImageType() == 1) {
                        i++;
                    }
                }
                if (i > 0 && this.mFrom > 0) {
                    ar arVar2 = new ar("c13991");
                    arVar2.ap("obj_type", i);
                    arVar2.ap("obj_source", this.mFrom);
                    arVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    arVar2.dR("tid", writeData.getThreadId());
                    TiebaStatic.log(arVar2);
                }
            }
        }
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void bCg() {
        this.fDT = false;
    }
}
