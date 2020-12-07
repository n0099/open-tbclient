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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.n;
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
/* loaded from: classes21.dex */
public class e extends com.baidu.tbadk.editortools.e implements y.a {
    private by alu;
    protected long authorId;
    protected String authorName;
    protected String authorNameShow;
    protected TbPageContext eNx;
    private EditorTools ftQ;
    protected NewWriteModel.d fwA;
    private c fwB;
    protected b fwC;
    protected boolean fwD;
    private TextWatcher fwE;
    private f fwF;
    private LocationModel.a fwG;
    private LocationModel.b fwH;
    private final NewWriteModel.d fwI;
    private final com.baidu.adp.base.d fwJ;
    private String fws;
    protected LocationModel fwt;
    protected NewWriteModel fwu;
    protected ImageModel fwv;
    private DataModel<?> fww;
    protected ForumData fwx;
    protected String fwy;
    private int fwz;
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
        this.fwu = null;
        this.fwv = null;
        this.mThreadId = null;
        this.fwy = null;
        this.fwz = 0;
        this.fwD = false;
        this.mFrom = 0;
        this.fwG = new LocationModel.a() { // from class: com.baidu.tbadk.editortools.pb.e.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void bDm() {
                e.this.eNx.showToast(R.string.no_network_guide);
                e.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                TbPageContext tbPageContext = e.this.eNx;
                if (StringUtils.isNull(str)) {
                    str = e.this.bCn().getContext().getString(R.string.location_fail);
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
        this.fwH = new LocationModel.b() { // from class: com.baidu.tbadk.editortools.pb.e.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void bDn() {
                e.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void DZ(String str) {
                e.this.a(2, true, str);
            }
        };
        this.fwI = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.e.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                WriteData dcD = writeData == null ? e.this.fwu.dcD() : writeData;
                if (z) {
                    e.this.kE(true);
                    WriteData dcD2 = e.this.fwu.dcD();
                    e.this.resetData();
                    y.f(e.this.mThreadId, (WriteData) null);
                    if (dcD2 != null) {
                        if (dcD2.getType() == 2) {
                            y.a(dcD2.getThreadId(), e.this);
                        }
                    } else {
                        return;
                    }
                } else if (dcD != null && ahVar != null && !TextUtils.isEmpty(ahVar.bxL())) {
                    dcD.setVcodeMD5(ahVar.getVcode_md5());
                    dcD.setVcodeUrl(ahVar.getVcode_pic_url());
                    dcD.setVcodeExtra(ahVar.bxM());
                    if (e.this.alu != null) {
                        dcD.setBaijiahaoData(e.this.alu.getBaijiahaoData());
                    }
                    if (com.baidu.tbadk.t.a.ES(ahVar.bxL())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(e.this.eNx.getPageActivity(), RequestResponseCode.REQUEST_VCODE, dcD, false, ahVar.bxL())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(e.this.eNx.getPageActivity(), dcD, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(e.this.eNx.getPageActivity(), RequestResponseCode.REQUEST_VCODE, dcD, postWriteCallBackData.getAccessState())));
                }
                e.this.b(e.this.fwu.dcD());
                if (e.this.fwA != null) {
                    e.this.fwA.callback(z, postWriteCallBackData, ahVar, dcD, antiData);
                }
            }
        };
        this.fwJ = new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.editortools.pb.e.7
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Bitmap) {
                    e.this.fwu.yk(true);
                }
            }
        };
        this.ftQ = editorTools;
    }

    public void st(int i) {
        if (this.fwF == null && bCn() != null) {
            this.fwF = (f) bCn().sj(27);
        }
        if (this.fwF != null) {
            this.fwF.setType(i);
        }
    }

    public void su(int i) {
        if (this.fwF == null && bCn() != null) {
            this.fwF = (f) bCn().sj(27);
        }
        if (this.fwF != null) {
            this.fwF.sv(i);
        }
    }

    public f bCT() {
        if (this.fwF == null && bCn() != null) {
            this.fwF = (f) bCn().sj(27);
        }
        return this.fwF;
    }

    public void DT(String str) {
        if (this.fwF == null && bCn() != null) {
            this.fwF = (f) bCn().sj(27);
        }
        if (this.fwF != null) {
            this.fwF.setHint(str);
        }
    }

    public void kA(boolean z) {
        BLauncher bLauncher;
        if (bCn() != null && (bLauncher = (BLauncher) bCn().sg(5)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void kB(boolean z) {
        BLauncher bLauncher;
        if (bCn() != null && (bLauncher = (BLauncher) bCn().sg(23)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void kC(boolean z) {
        BLauncher bLauncher;
        if (bCn() != null && (bLauncher = (BLauncher) bCn().sg(2)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.fww = dataModel;
    }

    public void setThreadId(String str) {
        this.mThreadId = str;
    }

    public void a(TbPageContext tbPageContext) {
        this.eNx = tbPageContext;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.fwy = antiData.getVoice_message();
        }
    }

    public void a(ForumData forumData, UserData userData) {
        this.fwx = forumData;
    }

    public void setThreadData(by byVar) {
        this.alu = byVar;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (bCn() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.authorNameShow = metaData.getName_show();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void kD(boolean z) {
        this.fwD = z;
    }

    public void bCU() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            if (String.valueOf(this.authorId).equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                l.showToast(this.eNx.getPageActivity(), R.string.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.eNx.getPageActivity(), this.authorId, this.authorName, this.authorNameShow, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.f.b.toLong(this.mThreadId, 0L), com.baidu.adp.lib.f.b.toLong(this.postId, 0L))));
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.eNx.getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_LOGIN_SUB_PB_AT /* 11026 */:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.eNx.getPageActivity(), RequestResponseCode.REQUEST_SUB_PB_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("camera_result", false)) {
                            E(intent);
                        } else {
                            G(intent);
                        }
                        bCn().invalidate();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_IMAGE_VIEW /* 12003 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("delete", false)) {
                            bDf();
                            this.fwu.yk(false);
                            return;
                        }
                        this.fwv.DS(intent.getStringExtra("file_name"));
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
                    WriteData dcD = this.fwu.dcD();
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (dcD != null) {
                        dcD.deleteUploadedTempImages();
                    }
                    this.fwu.e((WriteData) null);
                    this.fwu.yk(false);
                    this.mVoiceModel = null;
                    this.mVideoInfo = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        y.f(this.mThreadId, (WriteData) null);
                    }
                    kE(true);
                    if (this.fwA != null) {
                        this.fwA.callback(true, postWriteCallBackData, null, dcD, null);
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
                    if (bCn() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            ar arVar = new ar(TbadkCoreStatisticKey.XIAOYING_DURATION);
                            arVar.al("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(arVar);
                            bDg();
                            bCn().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            bCn().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                        DX(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case RequestResponseCode.REQUEST_CAMERA /* 12001 */:
                bDd();
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
                if (this.fwA != null) {
                    this.fwA.callback(false, postWriteCallBackData2, null, this.fwu.dcD(), null);
                    return;
                }
                return;
        }
    }

    public void bCV() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.eNx.getPageActivity())));
    }

    public void bCW() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.eNx.getPageActivity())) {
            this.eNx.showToast(R.string.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bCZ();
        } else if (this.fwt.dPY()) {
            bCV();
        } else {
            this.fwt.yi(false);
            a(1, true, (String) null);
            this.fwt.dPW();
        }
    }

    public void bCX() {
        if (!ae.checkLocationForGoogle(this.eNx.getPageActivity())) {
            ae.c(this.eNx.getPageActivity(), 0);
        } else {
            bCW();
        }
    }

    public void bCY() {
        if (!this.isBJH && this.fwt != null && !com.baidu.tieba.tbadkCore.location.b.dPT().dPU() && UtilHelper.isSystemLocationProviderEnabled(this.eNx.getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared()) {
            this.fwt.dPW();
        }
    }

    private void bCZ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eNx.getPageActivity());
        aVar.oQ(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    e.this.a(1, true, (String) null);
                    e.this.fwt.dQa();
                } else {
                    e.this.fwG.bDm();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                e.this.a(0, true, (String) null);
                aVar2.dismiss();
            }
        }).b(this.eNx);
        aVar.brv();
    }

    public void bDa() {
        if (this.fwt.clB()) {
            if (this.fwt.dPY()) {
                this.fwG.a(com.baidu.tieba.tbadkCore.location.b.dPT().getLocationData());
                return;
            }
            if (l.isNetOk()) {
                this.fwt.dPW();
            }
            a(0, true, (String) null);
            return;
        }
        a(0, false, (String) null);
    }

    public boolean bDb() {
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
        this.fwu.e((WriteData) null);
        this.fwu.yk(false);
        this.mVoiceModel = null;
        this.mVideoInfo = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void bDc() {
        this.mVideoInfo = null;
    }

    private void E(Intent intent) {
        this.fws = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.fws;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.eNx.getPageActivity(), l.getEquipmentWidth(this.eNx.getPageActivity())), l.dip2px(this.eNx.getPageActivity(), l.getEquipmentHeight(this.eNx.getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    n.a("cameras", this.fws, rotateBitmapBydegree, 100);
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
        if (this.fwx != null) {
            threadData.setForumId(this.fwx.getId());
            threadData.setForumName(this.fwx.getName());
            threadData.setFirstDir(this.fwx.getFirst_class());
            threadData.setSecondDir(this.fwx.getSecond_class());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        threadData.isBJH = this.isBJH;
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.fwy);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.eNx.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void c(u uVar) {
        if (uVar != null) {
            if (uVar.bxC() == EmotionGroupType.BIG_EMOTION || uVar.bxC() == EmotionGroupType.USER_COLLECT) {
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

    private void bDd() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tbadk.editortools.pb.e.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                n.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + e.this.fws));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void G(Intent intent) {
        a(intent, true);
    }

    public void DU(String str) {
        WriteData dcD = this.fwu.dcD();
        if (dcD == null) {
            dcD = new WriteData(1);
            dcD.setThreadId(str);
            dcD.setWriteImagesInfo(this.writeImagesInfo);
        }
        dcD.setContent(this.mPostContent);
        dcD.setVideoInfo(this.mVideoInfo);
        dcD.setVoiceModel(this.mVoiceModel);
        y.f(str, dcD);
    }

    public void DV(String str) {
        y.a(str, this);
    }

    @Override // com.baidu.tieba.tbadkCore.y.a
    public void a(WriteData writeData) {
        if (writeData != null) {
            if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                if (this.mVideoInfo == null) {
                    this.mVideoInfo = new VideoInfo();
                }
                this.mVideoInfo.copy(writeData.getVideoInfo());
                bDg();
                bCn().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                    bCn().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                bCn().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            if (writeData.getVoiceModel() != null && writeData.getVoiceModel().voiceId != null && writeData.getVoiceModel().duration != -1) {
                if (this.mVoiceModel == null) {
                    this.mVoiceModel = new VoiceData.VoiceModel();
                }
                this.mVoiceModel.copy(writeData.getVoiceModel());
            }
            if (!au.isEmpty(writeData.getContent()) && au.isEmpty(this.mPostContent)) {
                this.mPostContent = writeData.getContent();
                DY(this.mPostContent);
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
                    bCn().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                bCn().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.mPostContent = writeData.getContent();
            DY(this.mPostContent);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.fwu.cancelLoadData();
        this.fwv.cancelLoadData();
        this.fwt.cancelLoadData();
    }

    public void a(TbPageContext tbPageContext, Bundle bundle) {
        this.fwu = new NewWriteModel(tbPageContext);
        this.fwu.b(this.fwI);
        this.fwv = new ImageModel(tbPageContext);
        this.fwv.setLoadDataCallBack(this.fwJ);
        this.fwt = new LocationModel(tbPageContext);
        this.fwt.a(this.fwG);
        this.fwt.a(this.fwH);
        if (bundle != null) {
            this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
            this.fws = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(this.isBJH ? 1 : 9);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && bCn() != null) {
            bCn().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.fwt.clB() && bCn() != null) {
            bCn().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            bCn().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.writeImagesInfo != null) {
            bundle.putString(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.fws);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.fwu.dcD() == null) {
            WriteData DR = this.fww.DR(str);
            if (DR != null && this.alu != null) {
                DR.setBaijiahaoData(this.alu.getBaijiahaoData());
            }
            this.fwu.e(DR);
        }
        if (this.fwu.dcD() != null) {
            this.fwu.setSpanGroupManager(this.mSpanGroupManager);
            if (this.fwD) {
                this.fwu.dcD().setCanNoForum(true);
                if (this.fwx != null) {
                    this.fwu.dcD().setVForumId(this.fwx.getId());
                    this.fwu.dcD().setVForumName(this.fwx.getName());
                }
            } else {
                this.fwu.dcD().setCanNoForum(false);
                this.fwu.dcD().setVForumId("");
                this.fwu.dcD().setVForumName("");
            }
            this.fwu.dcD().setIsBJHPost(this.isBJH);
            this.fwu.dcD().setWriteImagesInfo(this.writeImagesInfo);
            this.fwu.dcD().setVideoInfo(this.mVideoInfo);
            this.fwu.yk(this.writeImagesInfo.size() > 0);
            WriteData dcD = this.fwu.dcD();
            if (this.fwt == null || !this.fwt.clB()) {
                z = false;
            }
            dcD.setHasLocationData(z);
            if (str == null) {
                this.fwu.dcD().setContent(this.mPostContent);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.fwu.dcD().setVoice(this.mVoiceModel.getId());
                    this.fwu.dcD().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.fwu.dcD().setVoice(null);
                    this.fwu.dcD().setVoiceDuringTime(-1);
                }
            } else {
                this.fwu.dcD().setVoice(null);
                this.fwu.dcD().setVoiceDuringTime(-1);
            }
            if (!this.fwu.dQG()) {
                this.eNx.showToast(R.string.write_img_limit);
            } else if (this.fwC == null || !this.fwC.bCR()) {
                if (this.fwB != null) {
                    this.fwB.bCS();
                }
                c(this.fwu.dcD());
                if (!this.fwu.dQD()) {
                }
            }
        }
    }

    public TbPageContext bxs() {
        return this.eNx;
    }

    public void DW(String str) {
        this.mPostContent = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int bDe() {
        return this.fwz;
    }

    private void bDf() {
        if (bCn() != null) {
            bCn().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void N(ArrayList<String> arrayList) {
        if (bCn() != null) {
            bCn().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void DX(String str) {
        if (bCn() != null) {
            bCn().b(new com.baidu.tbadk.editortools.a(44, 27, str));
        }
    }

    private void bDg() {
        if (bCn() != null) {
            bCn().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.fwz = i;
        if (bCn() != null) {
            bCn().b(new com.baidu.tbadk.editortools.a(19, 27, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void DY(String str) {
        if (bCn() != null) {
            bCn().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kE(boolean z) {
        if (bCn() != null) {
            if (z) {
                bCn().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                bCn().b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
            bCn().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.fwA = dVar;
    }

    public void a(c cVar) {
        this.fwB = cVar;
    }

    public void a(b bVar) {
        this.fwC = bVar;
    }

    public void bDh() {
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            this.writeImagesInfo.clear();
        }
        if (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) {
            this.mVideoInfo = null;
        }
        bCn().b(new com.baidu.tbadk.editortools.a(2, 19, null));
        setVoiceModel(null);
        bCn().b(new com.baidu.tbadk.editortools.a(2, 6, null));
        bCn().b(new com.baidu.tbadk.editortools.a(33, 6, null));
        if (!StringUtils.isNull(this.mPostContent)) {
            this.mPostContent = "";
        }
        DY("");
        this.fwu.e((WriteData) null);
        this.fwu.yk(false);
    }

    public boolean bDi() {
        LinkedList<ImageFileInfo> chosedFiles;
        return (this.writeImagesInfo == null || (chosedFiles = this.writeImagesInfo.getChosedFiles()) == null || chosedFiles.isEmpty()) ? false : true;
    }

    public boolean bDj() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    private void bDk() {
        if (this.fwF == null && bCn() != null) {
            this.fwF = (f) bCn().sj(27);
        }
    }

    public void bDl() {
        if (this.fwF != null && this.fwE != null) {
            this.fwF.c(this.fwE);
        }
    }

    public void a(TextWatcher textWatcher) {
        bDk();
        if (this.fwF != null && textWatcher != null) {
            this.fwF.b(textWatcher);
        }
    }

    public void bCA() {
        if (this.ftQ != null) {
            this.ftQ.bCA();
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
                while (ax.eUm.matcher(writeData.getContent()).find()) {
                    i2++;
                }
                if (i2 > 0 && this.mFrom > 0) {
                    ar arVar = new ar("c13990");
                    arVar.al("obj_type", i2);
                    arVar.al("obj_source", this.mFrom);
                    arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
                    arVar.dY("tid", writeData.getThreadId());
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
                    arVar2.al("obj_type", i);
                    arVar2.al("obj_source", this.mFrom);
                    arVar2.dY("uid", TbadkCoreApplication.getCurrentAccount());
                    arVar2.dY("tid", writeData.getThreadId());
                    TiebaStatic.log(arVar2);
                }
            }
        }
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }
}
