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
    private bz alW;
    protected long authorId;
    protected String authorName;
    protected String authorNameShow;
    protected TbPageContext eXu;
    private EditorTools fDw;
    private String fFY;
    protected LocationModel fFZ;
    protected NewWriteModel fGa;
    protected ImageModel fGb;
    private DataModel<?> fGc;
    protected ForumData fGd;
    protected String fGe;
    private int fGf;
    protected NewWriteModel.d fGg;
    private c fGh;
    protected b fGi;
    protected boolean fGj;
    private TextWatcher fGk;
    private f fGl;
    private LocationModel.a fGm;
    private LocationModel.b fGn;
    private final NewWriteModel.d fGo;
    private final com.baidu.adp.base.e fGp;
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
        this.fGa = null;
        this.fGb = null;
        this.mThreadId = null;
        this.fGe = null;
        this.fGf = 0;
        this.fGj = false;
        this.mFrom = 0;
        this.fGm = new LocationModel.a() { // from class: com.baidu.tbadk.editortools.pb.e.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void bFH() {
                e.this.eXu.showToast(R.string.no_network_guide);
                e.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                TbPageContext tbPageContext = e.this.eXu;
                if (StringUtils.isNull(str)) {
                    str = e.this.bEI().getContext().getString(R.string.location_fail);
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
        this.fGn = new LocationModel.b() { // from class: com.baidu.tbadk.editortools.pb.e.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void bFI() {
                e.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void DW(String str) {
                e.this.a(2, true, str);
            }
        };
        this.fGo = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.e.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                WriteData dco = writeData == null ? e.this.fGa.dco() : writeData;
                if (z) {
                    e.this.la(true);
                    WriteData dco2 = e.this.fGa.dco();
                    e.this.resetData();
                    y.b(e.this.mThreadId, (WriteData) null);
                    if (dco2 != null) {
                        if (dco2.getType() == 2) {
                            y.a(dco2.getThreadId(), e.this);
                        }
                    } else {
                        return;
                    }
                } else if (dco != null && ahVar != null && !TextUtils.isEmpty(ahVar.bAf())) {
                    dco.setVcodeMD5(ahVar.getVcode_md5());
                    dco.setVcodeUrl(ahVar.getVcode_pic_url());
                    dco.setVcodeExtra(ahVar.bAg());
                    if (e.this.alW != null) {
                        dco.setBaijiahaoData(e.this.alW.getBaijiahaoData());
                    }
                    if (com.baidu.tbadk.t.a.EQ(ahVar.bAf())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(e.this.eXu.getPageActivity(), RequestResponseCode.REQUEST_VCODE, dco, false, ahVar.bAf())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(e.this.eXu.getPageActivity(), dco, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(e.this.eXu.getPageActivity(), RequestResponseCode.REQUEST_VCODE, dco, postWriteCallBackData.getAccessState())));
                }
                e.this.c(e.this.fGa.dco());
                if (e.this.fGg != null) {
                    e.this.fGg.callback(z, postWriteCallBackData, ahVar, dco, antiData);
                }
            }
        };
        this.fGp = new com.baidu.adp.base.e() { // from class: com.baidu.tbadk.editortools.pb.e.7
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                if (obj instanceof Bitmap) {
                    e.this.fGa.yp(true);
                }
            }
        };
        this.fDw = editorTools;
    }

    public void sF(int i) {
        if (this.fGl == null && bEI() != null) {
            this.fGl = (f) bEI().sv(27);
        }
        if (this.fGl != null) {
            this.fGl.setType(i);
        }
    }

    public void sG(int i) {
        if (this.fGl == null && bEI() != null) {
            this.fGl = (f) bEI().sv(27);
        }
        if (this.fGl != null) {
            this.fGl.sH(i);
        }
    }

    public f bFo() {
        if (this.fGl == null && bEI() != null) {
            this.fGl = (f) bEI().sv(27);
        }
        return this.fGl;
    }

    public void DQ(String str) {
        if (this.fGl == null && bEI() != null) {
            this.fGl = (f) bEI().sv(27);
        }
        if (this.fGl != null) {
            this.fGl.setHint(str);
        }
    }

    public void kW(boolean z) {
        BLauncher bLauncher;
        if (bEI() != null && (bLauncher = (BLauncher) bEI().ss(5)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void kX(boolean z) {
        BLauncher bLauncher;
        if (bEI() != null && (bLauncher = (BLauncher) bEI().ss(23)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void kY(boolean z) {
        BLauncher bLauncher;
        if (bEI() != null && (bLauncher = (BLauncher) bEI().ss(2)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.fGc = dataModel;
    }

    public void setThreadId(String str) {
        this.mThreadId = str;
    }

    public void a(TbPageContext tbPageContext) {
        this.eXu = tbPageContext;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.fGe = antiData.getVoice_message();
        }
    }

    public void a(ForumData forumData, UserData userData) {
        this.fGd = forumData;
    }

    public void setThreadData(bz bzVar) {
        this.alW = bzVar;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (bEI() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.authorNameShow = metaData.getName_show();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void kZ(boolean z) {
        this.fGj = z;
    }

    public void bFp() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            if (String.valueOf(this.authorId).equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                l.showToast(this.eXu.getPageActivity(), R.string.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.eXu.getPageActivity(), this.authorId, this.authorName, this.authorNameShow, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.f.b.toLong(this.mThreadId, 0L), com.baidu.adp.lib.f.b.toLong(this.postId, 0L))));
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.eXu.getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_LOGIN_SUB_PB_AT /* 11026 */:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.eXu.getPageActivity(), RequestResponseCode.REQUEST_SUB_PB_AT_SELECT, true)));
                    return;
                case 12002:
                    if (intent != null) {
                        if (intent.getBooleanExtra("camera_result", false)) {
                            F(intent);
                        } else {
                            H(intent);
                        }
                        bEI().invalidate();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_IMAGE_VIEW /* 12003 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("delete", false)) {
                            bFA();
                            this.fGa.yp(false);
                            return;
                        }
                        this.fGb.DP(intent.getStringExtra("file_name"));
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
                    WriteData dco = this.fGa.dco();
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (dco != null) {
                        dco.deleteUploadedTempImages();
                    }
                    this.fGa.f((WriteData) null);
                    this.fGa.yp(false);
                    this.mVoiceModel = null;
                    this.mVideoInfo = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        y.b(this.mThreadId, (WriteData) null);
                    }
                    la(true);
                    if (this.fGg != null) {
                        this.fGg.callback(true, postWriteCallBackData, null, dco, null);
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
                    if (bEI() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            aq aqVar = new aq(TbadkCoreStatisticKey.XIAOYING_DURATION);
                            aqVar.an("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(aqVar);
                            bFB();
                            bEI().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            bEI().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                        DU(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 12001:
                bFy();
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
                if (this.fGg != null) {
                    this.fGg.callback(false, postWriteCallBackData2, null, this.fGa.dco(), null);
                    return;
                }
                return;
        }
    }

    public void bFq() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.eXu.getPageActivity())));
    }

    public void bFr() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.eXu.getPageActivity())) {
            this.eXu.showToast(R.string.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bFu();
        } else if (this.fFZ.dPV()) {
            bFq();
        } else {
            this.fFZ.yn(false);
            a(1, true, (String) null);
            this.fFZ.dPT();
        }
    }

    public void bFs() {
        if (!ad.checkLocationForGoogle(this.eXu.getPageActivity())) {
            ad.c(this.eXu.getPageActivity(), 0);
        } else {
            bFr();
        }
    }

    public void bFt() {
        if (!this.isBJH && this.fFZ != null && !com.baidu.tieba.tbadkCore.location.b.dPQ().dPR() && UtilHelper.isSystemLocationProviderEnabled(this.eXu.getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared()) {
            this.fFZ.dPT();
        }
    }

    private void bFu() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eXu.getPageActivity());
        aVar.pa(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    e.this.a(1, true, (String) null);
                    e.this.fFZ.dPX();
                } else {
                    e.this.fGm.bFH();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                e.this.a(0, true, (String) null);
                aVar2.dismiss();
            }
        }).b(this.eXu);
        aVar.btX();
    }

    public void bFv() {
        if (this.fFZ.cot()) {
            if (this.fFZ.dPV()) {
                this.fGm.a(com.baidu.tieba.tbadkCore.location.b.dPQ().getLocationData());
                return;
            }
            if (l.isNetOk()) {
                this.fFZ.dPT();
            }
            a(0, true, (String) null);
            return;
        }
        a(0, false, (String) null);
    }

    public boolean bFw() {
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
        this.fGa.f((WriteData) null);
        this.fGa.yp(false);
        this.mVoiceModel = null;
        this.mVideoInfo = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void bFx() {
        this.mVideoInfo = null;
    }

    private void F(Intent intent) {
        this.fFY = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.fFY;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.eXu.getPageActivity(), l.getEquipmentWidth(this.eXu.getPageActivity())), l.dip2px(this.eXu.getPageActivity(), l.getEquipmentHeight(this.eXu.getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    n.a("cameras", this.fFY, rotateBitmapBydegree, 100);
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
        if (this.fGd != null) {
            threadData.setForumId(this.fGd.getId());
            threadData.setForumName(this.fGd.getName());
            threadData.setFirstDir(this.fGd.getFirst_class());
            threadData.setSecondDir(this.fGd.getSecond_class());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        threadData.isBJH = this.isBJH;
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.fGe);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.eXu.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void c(u uVar) {
        if (uVar != null) {
            if (uVar.bzW() == EmotionGroupType.BIG_EMOTION || uVar.bzW() == EmotionGroupType.USER_COLLECT) {
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

    private void bFy() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tbadk.editortools.pb.e.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                n.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + e.this.fFY));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void H(Intent intent) {
        b(intent, true);
    }

    public void DR(String str) {
        WriteData dco = this.fGa.dco();
        if (dco == null) {
            dco = new WriteData(1);
            dco.setThreadId(str);
            dco.setWriteImagesInfo(this.writeImagesInfo);
        }
        dco.setContent(this.mPostContent);
        dco.setVideoInfo(this.mVideoInfo);
        dco.setVoiceModel(this.mVoiceModel);
        y.b(str, dco);
    }

    public void DS(String str) {
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
                bFB();
                bEI().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                    bEI().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                bEI().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            if (writeData.getVoiceModel() != null && writeData.getVoiceModel().voiceId != null && writeData.getVoiceModel().duration != -1) {
                if (this.mVoiceModel == null) {
                    this.mVoiceModel = new VoiceData.VoiceModel();
                }
                this.mVoiceModel.copy(writeData.getVoiceModel());
            }
            if (!at.isEmpty(writeData.getContent()) && at.isEmpty(this.mPostContent)) {
                this.mPostContent = writeData.getContent();
                DV(this.mPostContent);
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
                    bEI().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                bEI().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.mPostContent = writeData.getContent();
            DV(this.mPostContent);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.fGa.cancelLoadData();
        this.fGb.cancelLoadData();
        this.fFZ.cancelLoadData();
    }

    public void a(TbPageContext tbPageContext, Bundle bundle) {
        this.fGa = new NewWriteModel(tbPageContext);
        this.fGa.b(this.fGo);
        this.fGb = new ImageModel(tbPageContext);
        this.fGb.setLoadDataCallBack(this.fGp);
        this.fFZ = new LocationModel(tbPageContext);
        this.fFZ.a(this.fGm);
        this.fFZ.a(this.fGn);
        if (bundle != null) {
            this.writeImagesInfo.parseJson(bundle.getString("write_images"));
            this.fFY = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(this.isBJH ? 1 : 9);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && bEI() != null) {
            bEI().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.fFZ.cot() && bEI() != null) {
            bEI().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            bEI().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.writeImagesInfo != null) {
            bundle.putString("write_images", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.fFY);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.fGa.dco() == null) {
            WriteData DO = this.fGc.DO(str);
            if (DO != null && this.alW != null) {
                DO.setBaijiahaoData(this.alW.getBaijiahaoData());
            }
            this.fGa.f(DO);
        }
        if (this.fGa.dco() != null) {
            this.fGa.setSpanGroupManager(this.mSpanGroupManager);
            if (this.fGj) {
                this.fGa.dco().setCanNoForum(true);
                if (this.fGd != null) {
                    this.fGa.dco().setVForumId(this.fGd.getId());
                    this.fGa.dco().setVForumName(this.fGd.getName());
                }
            } else {
                this.fGa.dco().setCanNoForum(false);
                this.fGa.dco().setVForumId("");
                this.fGa.dco().setVForumName("");
            }
            this.fGa.dco().setIsBJHPost(this.isBJH);
            this.fGa.dco().setWriteImagesInfo(this.writeImagesInfo);
            this.fGa.dco().setVideoInfo(this.mVideoInfo);
            this.fGa.yp(this.writeImagesInfo.size() > 0);
            WriteData dco = this.fGa.dco();
            if (this.fFZ == null || !this.fFZ.cot()) {
                z = false;
            }
            dco.setHasLocationData(z);
            if (str == null) {
                this.fGa.dco().setContent(this.mPostContent);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.fGa.dco().setVoice(this.mVoiceModel.getId());
                    this.fGa.dco().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.fGa.dco().setVoice(null);
                    this.fGa.dco().setVoiceDuringTime(-1);
                }
            } else {
                this.fGa.dco().setVoice(null);
                this.fGa.dco().setVoiceDuringTime(-1);
            }
            if (!this.fGa.dQD()) {
                this.eXu.showToast(R.string.write_img_limit);
            } else if (this.fGi == null || !this.fGi.bFm()) {
                if (this.fGh != null) {
                    this.fGh.bFn();
                }
                d(this.fGa.dco());
                if (!this.fGa.dQB()) {
                }
            }
        }
    }

    public TbPageContext bzM() {
        return this.eXu;
    }

    public void DT(String str) {
        this.mPostContent = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int bFz() {
        return this.fGf;
    }

    private void bFA() {
        if (bEI() != null) {
            bEI().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void N(ArrayList<String> arrayList) {
        if (bEI() != null) {
            bEI().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void DU(String str) {
        if (bEI() != null) {
            bEI().b(new com.baidu.tbadk.editortools.a(44, 27, str));
        }
    }

    private void bFB() {
        if (bEI() != null) {
            bEI().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.fGf = i;
        if (bEI() != null) {
            bEI().b(new com.baidu.tbadk.editortools.a(19, 27, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void DV(String str) {
        if (bEI() != null) {
            bEI().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void la(boolean z) {
        if (bEI() != null) {
            if (z) {
                bEI().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                bEI().b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
            bEI().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.fGg = dVar;
    }

    public void a(c cVar) {
        this.fGh = cVar;
    }

    public void a(b bVar) {
        this.fGi = bVar;
    }

    public void bFC() {
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            this.writeImagesInfo.clear();
        }
        if (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) {
            this.mVideoInfo = null;
        }
        bEI().b(new com.baidu.tbadk.editortools.a(2, 19, null));
        setVoiceModel(null);
        bEI().b(new com.baidu.tbadk.editortools.a(2, 6, null));
        bEI().b(new com.baidu.tbadk.editortools.a(33, 6, null));
        if (!StringUtils.isNull(this.mPostContent)) {
            this.mPostContent = "";
        }
        DV("");
        this.fGa.f((WriteData) null);
        this.fGa.yp(false);
    }

    public boolean bFD() {
        LinkedList<ImageFileInfo> chosedFiles;
        return (this.writeImagesInfo == null || (chosedFiles = this.writeImagesInfo.getChosedFiles()) == null || chosedFiles.isEmpty()) ? false : true;
    }

    public boolean bFE() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    private void bFF() {
        if (this.fGl == null && bEI() != null) {
            this.fGl = (f) bEI().sv(27);
        }
    }

    public void bFG() {
        if (this.fGl != null && this.fGk != null) {
            this.fGl.c(this.fGk);
        }
    }

    public void a(TextWatcher textWatcher) {
        bFF();
        if (this.fGl != null && textWatcher != null) {
            this.fGl.b(textWatcher);
        }
    }

    public void bEV() {
        if (this.fDw != null) {
            this.fDw.bEV();
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
                while (aw.fdJ.matcher(writeData.getContent()).find()) {
                    i2++;
                }
                if (i2 > 0 && this.mFrom > 0) {
                    aq aqVar = new aq("c13990");
                    aqVar.an("obj_type", i2);
                    aqVar.an("obj_source", this.mFrom);
                    aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar.dX("tid", writeData.getThreadId());
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
                    aqVar2.dX("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar2.dX("tid", writeData.getThreadId());
                    TiebaStatic.log(aqVar2);
                }
            }
        }
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }
}
