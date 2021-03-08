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
    private cb amn;
    protected long authorId;
    protected String authorName;
    protected String authorNameShow;
    protected TbPageContext eWx;
    private EditorTools fCC;
    private String fFe;
    protected LocationModel fFf;
    protected NewWriteModel fFg;
    protected ImageModel fFh;
    private DataModel<?> fFi;
    protected ForumData fFj;
    protected String fFk;
    private int fFl;
    protected NewWriteModel.d fFm;
    private c fFn;
    protected b fFo;
    protected boolean fFp;
    private TextWatcher fFq;
    private f fFr;
    private boolean fFs;
    private LocationModel.a fFt;
    private LocationModel.b fFu;
    private final NewWriteModel.d fFv;
    private final com.baidu.adp.base.e fFw;
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
        this.fFg = null;
        this.fFh = null;
        this.mThreadId = null;
        this.fFk = null;
        this.fFl = 0;
        this.fFp = false;
        this.mFrom = 0;
        this.fFs = true;
        this.fFt = new LocationModel.a() { // from class: com.baidu.tbadk.editortools.pb.e.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void bCk() {
                e.this.eWx.showToast(R.string.no_network_guide);
                e.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                if (e.this.fFs) {
                    TbPageContext tbPageContext = e.this.eWx;
                    if (StringUtils.isNull(str)) {
                        str = e.this.bBk().getContext().getString(R.string.location_fail);
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
        this.fFu = new LocationModel.b() { // from class: com.baidu.tbadk.editortools.pb.e.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void bCl() {
                e.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void Dg(String str) {
                e.this.b(2, true, str);
            }
        };
        this.fFv = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.e.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                WriteData daL = writeData == null ? e.this.fFg.daL() : writeData;
                if (z) {
                    e.this.kZ(true);
                    WriteData daL2 = e.this.fFg.daL();
                    e.this.resetData();
                    y.b(e.this.mThreadId, (WriteData) null);
                    if (daL2 != null) {
                        if (daL2.getType() == 2) {
                            y.a(daL2.getThreadId(), e.this);
                        }
                    } else {
                        return;
                    }
                } else if (daL != null && ahVar != null && !TextUtils.isEmpty(ahVar.bwH())) {
                    daL.setVcodeMD5(ahVar.getVcode_md5());
                    daL.setVcodeUrl(ahVar.getVcode_pic_url());
                    daL.setVcodeExtra(ahVar.bwI());
                    if (e.this.amn != null) {
                        daL.setBaijiahaoData(e.this.amn.getBaijiahaoData());
                    }
                    if (com.baidu.tbadk.t.a.Ef(ahVar.bwH())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(e.this.eWx.getPageActivity(), RequestResponseCode.REQUEST_VCODE, daL, false, ahVar.bwH())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(e.this.eWx.getPageActivity(), daL, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(e.this.eWx.getPageActivity(), RequestResponseCode.REQUEST_VCODE, daL, postWriteCallBackData.getAccessState())));
                }
                e.this.c(e.this.fFg.daL());
                if (e.this.fFm != null) {
                    e.this.fFm.callback(z, postWriteCallBackData, ahVar, daL, antiData);
                }
            }
        };
        this.fFw = new com.baidu.adp.base.e() { // from class: com.baidu.tbadk.editortools.pb.e.7
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                if (obj instanceof Bitmap) {
                    e.this.fFg.yD(true);
                }
            }
        };
        this.fCC = editorTools;
    }

    public void rf(int i) {
        if (this.fFr == null && bBk() != null) {
            this.fFr = (f) bBk().qV(27);
        }
        if (this.fFr != null) {
            this.fFr.setType(i);
        }
    }

    public void rg(int i) {
        if (this.fFr == null && bBk() != null) {
            this.fFr = (f) bBk().qV(27);
        }
        if (this.fFr != null) {
            this.fFr.rh(i);
        }
    }

    public f bBQ() {
        if (this.fFr == null && bBk() != null) {
            this.fFr = (f) bBk().qV(27);
        }
        return this.fFr;
    }

    public void Da(String str) {
        if (this.fFr == null && bBk() != null) {
            this.fFr = (f) bBk().qV(27);
        }
        if (this.fFr != null) {
            this.fFr.setHint(str);
        }
    }

    public void kV(boolean z) {
        BLauncher bLauncher;
        if (bBk() != null && (bLauncher = (BLauncher) bBk().qS(5)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void kW(boolean z) {
        BLauncher bLauncher;
        if (bBk() != null && (bLauncher = (BLauncher) bBk().qS(23)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void kX(boolean z) {
        BLauncher bLauncher;
        if (bBk() != null && (bLauncher = (BLauncher) bBk().qS(2)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.fFi = dataModel;
    }

    public void setThreadId(String str) {
        this.mThreadId = str;
    }

    public void a(TbPageContext tbPageContext) {
        this.eWx = tbPageContext;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.fFk = antiData.getVoice_message();
        }
    }

    public void a(ForumData forumData, UserData userData) {
        this.fFj = forumData;
    }

    public void setThreadData(cb cbVar) {
        this.amn = cbVar;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (bBk() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.authorNameShow = metaData.getName_show();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void kY(boolean z) {
        this.fFp = z;
    }

    public void bBR() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            if (String.valueOf(this.authorId).equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                l.showToast(this.eWx.getPageActivity(), R.string.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.eWx.getPageActivity(), this.authorId, this.authorName, this.authorNameShow, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.f.b.toLong(this.mThreadId, 0L), com.baidu.adp.lib.f.b.toLong(this.postId, 0L))));
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.eWx.getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_LOGIN_SUB_PB_AT /* 11026 */:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.eWx.getPageActivity(), RequestResponseCode.REQUEST_SUB_PB_AT_SELECT, true)));
                    return;
                case 12002:
                    if (intent != null) {
                        if (intent.getBooleanExtra("camera_result", false)) {
                            F(intent);
                        } else {
                            H(intent);
                        }
                        bBk().invalidate();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_IMAGE_VIEW /* 12003 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("delete", false)) {
                            bCc();
                            this.fFg.yD(false);
                            return;
                        }
                        this.fFh.CZ(intent.getStringExtra("file_name"));
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
                    WriteData daL = this.fFg.daL();
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (daL != null) {
                        daL.deleteUploadedTempImages();
                    }
                    this.fFg.f((WriteData) null);
                    this.fFg.yD(false);
                    this.mVoiceModel = null;
                    this.mVideoInfo = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        y.b(this.mThreadId, (WriteData) null);
                    }
                    kZ(true);
                    if (this.fFm != null) {
                        this.fFm.callback(true, postWriteCallBackData, null, daL, null);
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
                    if (bBk() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            ar arVar = new ar(TbadkCoreStatisticKey.XIAOYING_DURATION);
                            arVar.aq("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(arVar);
                            bCd();
                            bBk().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            bBk().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                        De(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 12001:
                bCa();
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
                if (this.fFm != null) {
                    this.fFm.callback(false, postWriteCallBackData2, null, this.fFg.daL(), null);
                    return;
                }
                return;
        }
    }

    public void bBS() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.eWx.getPageActivity())));
    }

    public void bBT() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.eWx.getPageActivity())) {
            this.eWx.showToast(R.string.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bBW();
        } else if (this.fFf.dOG()) {
            bBS();
        } else {
            this.fFf.yB(false);
            b(1, true, null);
            this.fFf.dOE();
        }
    }

    public void bBU() {
        if (!ae.checkLocationForGoogle(this.eWx.getPageActivity())) {
            ae.c(this.eWx.getPageActivity(), 0);
        } else {
            bBT();
        }
    }

    public void bBV() {
        if (!this.isBJH && this.fFf != null && !com.baidu.tieba.tbadkCore.location.b.dOB().dOC() && UtilHelper.isSystemLocationProviderEnabled(this.eWx.getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared()) {
            this.fFf.dOE();
        }
    }

    private void bBW() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eWx.getPageActivity());
        aVar.ny(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    e.this.b(1, true, null);
                    e.this.fFf.dOI();
                } else {
                    e.this.fFt.bCk();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                e.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(this.eWx);
        aVar.bqz();
    }

    public void bBX() {
        if (this.fFf.clN()) {
            if (this.fFf.dOG()) {
                this.fFt.a(com.baidu.tieba.tbadkCore.location.b.dOB().getLocationData());
                return;
            }
            if (l.isNetOk()) {
                this.fFf.dOE();
            }
            b(0, true, null);
            return;
        }
        b(0, false, null);
    }

    public boolean bBY() {
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
        this.fFg.f((WriteData) null);
        this.fFg.yD(false);
        this.mVoiceModel = null;
        this.mVideoInfo = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void bBZ() {
        this.mVideoInfo = null;
    }

    private void F(Intent intent) {
        this.fFe = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.fFe;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.eWx.getPageActivity(), l.getEquipmentWidth(this.eWx.getPageActivity())), l.dip2px(this.eWx.getPageActivity(), l.getEquipmentHeight(this.eWx.getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    o.a("cameras", this.fFe, rotateBitmapBydegree, 100);
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
        if (this.fFj != null) {
            threadData.setForumId(this.fFj.getId());
            threadData.setForumName(this.fFj.getName());
            threadData.setFirstDir(this.fFj.getFirst_class());
            threadData.setSecondDir(this.fFj.getSecond_class());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        threadData.isBJH = this.isBJH;
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.fFk);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.eWx.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void c(u uVar) {
        if (uVar != null) {
            if (uVar.bwy() == EmotionGroupType.BIG_EMOTION || uVar.bwy() == EmotionGroupType.USER_COLLECT) {
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

    private void bCa() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tbadk.editortools.pb.e.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                o.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + e.this.fFe));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void H(Intent intent) {
        b(intent, true);
    }

    public void Db(String str) {
        WriteData daL = this.fFg.daL();
        if (daL == null) {
            daL = new WriteData(1);
            daL.setThreadId(str);
            daL.setWriteImagesInfo(this.writeImagesInfo);
        }
        daL.setContent(this.mPostContent);
        daL.setVideoInfo(this.mVideoInfo);
        daL.setVoiceModel(this.mVoiceModel);
        y.b(str, daL);
    }

    public void Dc(String str) {
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
                bCd();
                bBk().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                    bBk().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                bBk().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            if (writeData.getVoiceModel() != null && writeData.getVoiceModel().voiceId != null && writeData.getVoiceModel().duration != -1) {
                if (this.mVoiceModel == null) {
                    this.mVoiceModel = new VoiceData.VoiceModel();
                }
                this.mVoiceModel.copy(writeData.getVoiceModel());
            }
            if (!au.isEmpty(writeData.getContent()) && au.isEmpty(this.mPostContent)) {
                this.mPostContent = writeData.getContent();
                Df(this.mPostContent);
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
                    bBk().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                bBk().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.mPostContent = writeData.getContent();
            Df(this.mPostContent);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.fFg.cancelLoadData();
        this.fFh.cancelLoadData();
        this.fFf.cancelLoadData();
    }

    public void a(TbPageContext tbPageContext, Bundle bundle) {
        this.fFg = new NewWriteModel(tbPageContext);
        this.fFg.b(this.fFv);
        this.fFh = new ImageModel(tbPageContext);
        this.fFh.setLoadDataCallBack(this.fFw);
        this.fFf = new LocationModel(tbPageContext);
        this.fFf.a(this.fFt);
        this.fFf.a(this.fFu);
        if (bundle != null) {
            this.writeImagesInfo.parseJson(bundle.getString("write_images"));
            this.fFe = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(this.isBJH ? 1 : 9);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && bBk() != null) {
            bBk().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.fFf.clN() && bBk() != null) {
            bBk().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            bBk().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.writeImagesInfo != null) {
            bundle.putString("write_images", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.fFe);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.fFg.daL() == null) {
            WriteData CY = this.fFi.CY(str);
            if (CY != null && this.amn != null) {
                CY.setBaijiahaoData(this.amn.getBaijiahaoData());
            }
            this.fFg.f(CY);
        }
        if (this.fFg.daL() != null) {
            this.fFg.setSpanGroupManager(this.mSpanGroupManager);
            if (this.fFp) {
                this.fFg.daL().setCanNoForum(true);
                if (this.fFj != null) {
                    this.fFg.daL().setVForumId(this.fFj.getId());
                    this.fFg.daL().setVForumName(this.fFj.getName());
                }
            } else {
                this.fFg.daL().setCanNoForum(false);
                this.fFg.daL().setVForumId("");
                this.fFg.daL().setVForumName("");
            }
            this.fFg.daL().setIsBJHPost(this.isBJH);
            this.fFg.daL().setWriteImagesInfo(this.writeImagesInfo);
            this.fFg.daL().setVideoInfo(this.mVideoInfo);
            this.fFg.yD(this.writeImagesInfo.size() > 0);
            WriteData daL = this.fFg.daL();
            if (this.fFf == null || !this.fFf.clN()) {
                z = false;
            }
            daL.setHasLocationData(z);
            if (str == null) {
                this.fFg.daL().setContent(this.mPostContent);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.fFg.daL().setVoice(this.mVoiceModel.getId());
                    this.fFg.daL().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.fFg.daL().setVoice(null);
                    this.fFg.daL().setVoiceDuringTime(-1);
                }
            } else {
                this.fFg.daL().setVoice(null);
                this.fFg.daL().setVoiceDuringTime(-1);
            }
            if (!this.fFg.dPo()) {
                this.eWx.showToast(R.string.write_img_limit);
            } else if (this.fFo == null || !this.fFo.bBO()) {
                if (this.fFn != null) {
                    this.fFn.bBP();
                }
                d(this.fFg.daL());
                if (!this.fFg.dPm()) {
                }
            }
        }
    }

    public TbPageContext bwp() {
        return this.eWx;
    }

    public void Dd(String str) {
        this.mPostContent = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int bCb() {
        return this.fFl;
    }

    private void bCc() {
        if (bBk() != null) {
            bBk().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void I(ArrayList<String> arrayList) {
        if (bBk() != null) {
            bBk().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void De(String str) {
        if (bBk() != null) {
            bBk().b(new com.baidu.tbadk.editortools.a(44, 27, str));
        }
    }

    private void bCd() {
        if (bBk() != null) {
            bBk().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.fFl = i;
        if (bBk() != null) {
            bBk().b(new com.baidu.tbadk.editortools.a(19, 27, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void Df(String str) {
        if (bBk() != null) {
            bBk().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kZ(boolean z) {
        if (bBk() != null) {
            if (z) {
                bBk().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                bBk().b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
            bBk().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.fFm = dVar;
    }

    public void a(c cVar) {
        this.fFn = cVar;
    }

    public void a(b bVar) {
        this.fFo = bVar;
    }

    public void bCe() {
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            this.writeImagesInfo.clear();
        }
        if (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) {
            this.mVideoInfo = null;
        }
        bBk().b(new com.baidu.tbadk.editortools.a(2, 19, null));
        setVoiceModel(null);
        bBk().b(new com.baidu.tbadk.editortools.a(2, 6, null));
        bBk().b(new com.baidu.tbadk.editortools.a(33, 6, null));
        if (!StringUtils.isNull(this.mPostContent)) {
            this.mPostContent = "";
        }
        Df("");
        this.fFg.f((WriteData) null);
        this.fFg.yD(false);
    }

    public boolean bCf() {
        LinkedList<ImageFileInfo> chosedFiles;
        return (this.writeImagesInfo == null || (chosedFiles = this.writeImagesInfo.getChosedFiles()) == null || chosedFiles.isEmpty()) ? false : true;
    }

    public boolean bCg() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    private void bCh() {
        if (this.fFr == null && bBk() != null) {
            this.fFr = (f) bBk().qV(27);
        }
    }

    public void bCi() {
        if (this.fFr != null && this.fFq != null) {
            this.fFr.c(this.fFq);
        }
    }

    public void a(TextWatcher textWatcher) {
        bCh();
        if (this.fFr != null && textWatcher != null) {
            this.fFr.b(textWatcher);
        }
    }

    public void bBx() {
        if (this.fCC != null) {
            this.fCC.bBx();
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
                while (ax.fcP.matcher(writeData.getContent()).find()) {
                    i2++;
                }
                if (i2 > 0 && this.mFrom > 0) {
                    ar arVar = new ar("c13990");
                    arVar.aq("obj_type", i2);
                    arVar.aq("obj_source", this.mFrom);
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
                    arVar2.aq("obj_type", i);
                    arVar2.aq("obj_source", this.mFrom);
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

    public void bCj() {
        this.fFs = false;
    }
}
