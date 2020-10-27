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
    protected TbPageContext eCn;
    private EditorTools fhk;
    private String fjO;
    protected LocationModel fjP;
    protected NewWriteModel fjQ;
    protected ImageModel fjR;
    private DataModel<?> fjS;
    protected ForumData fjT;
    protected String fjU;
    private int fjV;
    protected NewWriteModel.d fjW;
    private c fjX;
    protected b fjY;
    protected boolean fjZ;
    private TextWatcher fka;
    private f fkb;
    private LocationModel.a fkc;
    private LocationModel.b fkd;
    private final NewWriteModel.d fke;
    private final com.baidu.adp.base.d fkf;
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
        this.fjQ = null;
        this.fjR = null;
        this.mThreadId = null;
        this.fjU = null;
        this.fjV = 0;
        this.fjZ = false;
        this.mFrom = 0;
        this.fkc = new LocationModel.a() { // from class: com.baidu.tbadk.editortools.pb.e.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void bxX() {
                e.this.eCn.showToast(R.string.no_network_guide);
                e.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                TbPageContext tbPageContext = e.this.eCn;
                if (StringUtils.isNull(str)) {
                    str = e.this.bwY().getContext().getString(R.string.location_fail);
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
        this.fkd = new LocationModel.b() { // from class: com.baidu.tbadk.editortools.pb.e.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void bxY() {
                e.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void DE(String str) {
                e.this.a(2, true, str);
            }
        };
        this.fke = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.e.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                WriteData cVv = writeData == null ? e.this.fjQ.cVv() : writeData;
                if (z) {
                    e.this.kd(true);
                    WriteData cVv2 = e.this.fjQ.cVv();
                    e.this.resetData();
                    x.f(e.this.mThreadId, (WriteData) null);
                    if (cVv2 != null) {
                        if (cVv2.getType() == 2) {
                            x.a(cVv2.getThreadId(), e.this);
                        }
                    } else {
                        return;
                    }
                } else if (cVv != null && ahVar != null && !TextUtils.isEmpty(ahVar.bsv())) {
                    cVv.setVcodeMD5(ahVar.getVcode_md5());
                    cVv.setVcodeUrl(ahVar.getVcode_pic_url());
                    cVv.setVcodeExtra(ahVar.bsw());
                    if (e.this.akq != null) {
                        cVv.setBaijiahaoData(e.this.akq.getBaijiahaoData());
                    }
                    if (com.baidu.tbadk.t.a.Eq(ahVar.bsv())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(e.this.eCn.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cVv, false, ahVar.bsv())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(e.this.eCn.getPageActivity(), cVv, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(e.this.eCn.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cVv, postWriteCallBackData.getAccessState())));
                }
                e.this.b(e.this.fjQ.cVv());
                if (e.this.fjW != null) {
                    e.this.fjW.callback(z, postWriteCallBackData, ahVar, cVv, antiData);
                }
            }
        };
        this.fkf = new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.editortools.pb.e.7
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Bitmap) {
                    e.this.fjQ.xp(true);
                }
            }
        };
        this.fhk = editorTools;
    }

    public void rk(int i) {
        if (this.fkb == null && bwY() != null) {
            this.fkb = (f) bwY().ra(27);
        }
        if (this.fkb != null) {
            this.fkb.setType(i);
        }
    }

    public void rl(int i) {
        if (this.fkb == null && bwY() != null) {
            this.fkb = (f) bwY().ra(27);
        }
        if (this.fkb != null) {
            this.fkb.rm(i);
        }
    }

    public f bxE() {
        if (this.fkb == null && bwY() != null) {
            this.fkb = (f) bwY().ra(27);
        }
        return this.fkb;
    }

    public void Dy(String str) {
        if (this.fkb == null && bwY() != null) {
            this.fkb = (f) bwY().ra(27);
        }
        if (this.fkb != null) {
            this.fkb.setHint(str);
        }
    }

    public void jZ(boolean z) {
        BLauncher bLauncher;
        if (bwY() != null && (bLauncher = (BLauncher) bwY().qX(5)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void ka(boolean z) {
        BLauncher bLauncher;
        if (bwY() != null && (bLauncher = (BLauncher) bwY().qX(23)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void kb(boolean z) {
        BLauncher bLauncher;
        if (bwY() != null && (bLauncher = (BLauncher) bwY().qX(2)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.fjS = dataModel;
    }

    public void setThreadId(String str) {
        this.mThreadId = str;
    }

    public void a(TbPageContext tbPageContext) {
        this.eCn = tbPageContext;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.fjU = antiData.getVoice_message();
        }
    }

    public void a(ForumData forumData, UserData userData) {
        this.fjT = forumData;
    }

    public void setThreadData(bw bwVar) {
        this.akq = bwVar;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (bwY() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.authorNameShow = metaData.getName_show();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void kc(boolean z) {
        this.fjZ = z;
    }

    public void bxF() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            if (String.valueOf(this.authorId).equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                l.showToast(this.eCn.getPageActivity(), R.string.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.eCn.getPageActivity(), this.authorId, this.authorName, this.authorNameShow, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.f.b.toLong(this.mThreadId, 0L), com.baidu.adp.lib.f.b.toLong(this.postId, 0L))));
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.eCn.getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_LOGIN_SUB_PB_AT /* 11026 */:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.eCn.getPageActivity(), RequestResponseCode.REQUEST_SUB_PB_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("camera_result", false)) {
                            E(intent);
                        } else {
                            G(intent);
                        }
                        bwY().invalidate();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_IMAGE_VIEW /* 12003 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("delete", false)) {
                            bxQ();
                            this.fjQ.xp(false);
                            return;
                        }
                        this.fjR.Dx(intent.getStringExtra("file_name"));
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
                    WriteData cVv = this.fjQ.cVv();
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (cVv != null) {
                        cVv.deleteUploadedTempImages();
                    }
                    this.fjQ.e((WriteData) null);
                    this.fjQ.xp(false);
                    this.mVoiceModel = null;
                    this.mVideoInfo = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        x.f(this.mThreadId, (WriteData) null);
                    }
                    kd(true);
                    if (this.fjW != null) {
                        this.fjW.callback(true, postWriteCallBackData, null, cVv, null);
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
                    if (bwY() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            aq aqVar = new aq(TbadkCoreStatisticKey.XIAOYING_DURATION);
                            aqVar.aj("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(aqVar);
                            bxR();
                            bwY().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            bwY().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                        DC(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case RequestResponseCode.REQUEST_CAMERA /* 12001 */:
                bxO();
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
                if (this.fjW != null) {
                    this.fjW.callback(false, postWriteCallBackData2, null, this.fjQ.cVv(), null);
                    return;
                }
                return;
        }
    }

    public void bxG() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.eCn.getPageActivity())));
    }

    public void bxH() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.eCn.getPageActivity())) {
            this.eCn.showToast(R.string.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bxK();
        } else if (this.fjP.dIf()) {
            bxG();
        } else {
            this.fjP.xn(false);
            a(1, true, (String) null);
            this.fjP.dId();
        }
    }

    public void bxI() {
        if (!ae.checkLocationForGoogle(this.eCn.getPageActivity())) {
            ae.c(this.eCn.getPageActivity(), 0);
        } else {
            bxH();
        }
    }

    public void bxJ() {
        if (!this.isBJH && this.fjP != null && !com.baidu.tieba.tbadkCore.location.b.dIa().dIb() && UtilHelper.isSystemLocationProviderEnabled(this.eCn.getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared()) {
            this.fjP.dId();
        }
    }

    private void bxK() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eCn.getPageActivity());
        aVar.om(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    e.this.a(1, true, (String) null);
                    e.this.fjP.dIh();
                } else {
                    e.this.fkc.bxX();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                e.this.a(0, true, (String) null);
                aVar2.dismiss();
            }
        }).b(this.eCn);
        aVar.bmC();
    }

    public void bxL() {
        if (this.fjP.cfL()) {
            if (this.fjP.dIf()) {
                this.fkc.a(com.baidu.tieba.tbadkCore.location.b.dIa().getLocationData());
                return;
            }
            if (l.isNetOk()) {
                this.fjP.dId();
            }
            a(0, true, (String) null);
            return;
        }
        a(0, false, (String) null);
    }

    public boolean bxM() {
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
        this.fjQ.e((WriteData) null);
        this.fjQ.xp(false);
        this.mVoiceModel = null;
        this.mVideoInfo = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void bxN() {
        this.mVideoInfo = null;
    }

    private void E(Intent intent) {
        this.fjO = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.fjO;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.eCn.getPageActivity(), l.getEquipmentWidth(this.eCn.getPageActivity())), l.dip2px(this.eCn.getPageActivity(), l.getEquipmentHeight(this.eCn.getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    n.a("cameras", this.fjO, rotateBitmapBydegree, 100);
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
        if (this.fjT != null) {
            threadData.setForumId(this.fjT.getId());
            threadData.setForumName(this.fjT.getName());
            threadData.setFirstDir(this.fjT.getFirst_class());
            threadData.setSecondDir(this.fjT.getSecond_class());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        threadData.isBJH = this.isBJH;
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.fjU);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.eCn.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void c(u uVar) {
        if (uVar != null) {
            if (uVar.bsm() == EmotionGroupType.BIG_EMOTION || uVar.bsm() == EmotionGroupType.USER_COLLECT) {
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

    private void bxO() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tbadk.editortools.pb.e.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                n.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + e.this.fjO));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void G(Intent intent) {
        a(intent, true);
    }

    public void Dz(String str) {
        WriteData cVv = this.fjQ.cVv();
        if (cVv == null) {
            cVv = new WriteData(1);
            cVv.setThreadId(str);
            cVv.setWriteImagesInfo(this.writeImagesInfo);
        }
        cVv.setContent(this.mPostContent);
        cVv.setVideoInfo(this.mVideoInfo);
        cVv.setVoiceModel(this.mVoiceModel);
        x.f(str, cVv);
    }

    public void DA(String str) {
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
                bxR();
                bwY().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                    bwY().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                bwY().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            if (writeData.getVoiceModel() != null && writeData.getVoiceModel().voiceId != null && writeData.getVoiceModel().duration != -1) {
                if (this.mVoiceModel == null) {
                    this.mVoiceModel = new VoiceData.VoiceModel();
                }
                this.mVoiceModel.copy(writeData.getVoiceModel());
            }
            if (!at.isEmpty(writeData.getContent()) && at.isEmpty(this.mPostContent)) {
                this.mPostContent = writeData.getContent();
                DD(this.mPostContent);
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
                    bwY().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                bwY().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.mPostContent = writeData.getContent();
            DD(this.mPostContent);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.fjQ.cancelLoadData();
        this.fjR.cancelLoadData();
        this.fjP.cancelLoadData();
    }

    public void a(TbPageContext tbPageContext, Bundle bundle) {
        this.fjQ = new NewWriteModel(tbPageContext);
        this.fjQ.b(this.fke);
        this.fjR = new ImageModel(tbPageContext);
        this.fjR.setLoadDataCallBack(this.fkf);
        this.fjP = new LocationModel(tbPageContext);
        this.fjP.a(this.fkc);
        this.fjP.a(this.fkd);
        if (bundle != null) {
            this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
            this.fjO = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(this.isBJH ? 1 : 9);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && bwY() != null) {
            bwY().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.fjP.cfL() && bwY() != null) {
            bwY().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            bwY().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.writeImagesInfo != null) {
            bundle.putString(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.fjO);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.fjQ.cVv() == null) {
            WriteData Dw = this.fjS.Dw(str);
            if (Dw != null && this.akq != null) {
                Dw.setBaijiahaoData(this.akq.getBaijiahaoData());
            }
            this.fjQ.e(Dw);
        }
        if (this.fjQ.cVv() != null) {
            this.fjQ.setSpanGroupManager(this.mSpanGroupManager);
            if (this.fjZ) {
                this.fjQ.cVv().setCanNoForum(true);
                if (this.fjT != null) {
                    this.fjQ.cVv().setVForumId(this.fjT.getId());
                    this.fjQ.cVv().setVForumName(this.fjT.getName());
                }
            } else {
                this.fjQ.cVv().setCanNoForum(false);
                this.fjQ.cVv().setVForumId("");
                this.fjQ.cVv().setVForumName("");
            }
            this.fjQ.cVv().setIsBJHPost(this.isBJH);
            this.fjQ.cVv().setWriteImagesInfo(this.writeImagesInfo);
            this.fjQ.cVv().setVideoInfo(this.mVideoInfo);
            this.fjQ.xp(this.writeImagesInfo.size() > 0);
            WriteData cVv = this.fjQ.cVv();
            if (this.fjP == null || !this.fjP.cfL()) {
                z = false;
            }
            cVv.setHasLocationData(z);
            if (str == null) {
                this.fjQ.cVv().setContent(this.mPostContent);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.fjQ.cVv().setVoice(this.mVoiceModel.getId());
                    this.fjQ.cVv().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.fjQ.cVv().setVoice(null);
                    this.fjQ.cVv().setVoiceDuringTime(-1);
                }
            } else {
                this.fjQ.cVv().setVoice(null);
                this.fjQ.cVv().setVoiceDuringTime(-1);
            }
            if (!this.fjQ.dIN()) {
                this.eCn.showToast(R.string.write_img_limit);
            } else if (this.fjY == null || !this.fjY.bxC()) {
                if (this.fjX != null) {
                    this.fjX.bxD();
                }
                c(this.fjQ.cVv());
                if (!this.fjQ.dIK()) {
                }
            }
        }
    }

    public TbPageContext bsc() {
        return this.eCn;
    }

    public void DB(String str) {
        this.mPostContent = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int bxP() {
        return this.fjV;
    }

    private void bxQ() {
        if (bwY() != null) {
            bwY().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void N(ArrayList<String> arrayList) {
        if (bwY() != null) {
            bwY().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void DC(String str) {
        if (bwY() != null) {
            bwY().b(new com.baidu.tbadk.editortools.a(44, 27, str));
        }
    }

    private void bxR() {
        if (bwY() != null) {
            bwY().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.fjV = i;
        if (bwY() != null) {
            bwY().b(new com.baidu.tbadk.editortools.a(19, 27, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void DD(String str) {
        if (bwY() != null) {
            bwY().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kd(boolean z) {
        if (bwY() != null) {
            if (z) {
                bwY().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                bwY().b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
            bwY().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.fjW = dVar;
    }

    public void a(c cVar) {
        this.fjX = cVar;
    }

    public void a(b bVar) {
        this.fjY = bVar;
    }

    public void bxS() {
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            this.writeImagesInfo.clear();
        }
        if (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) {
            this.mVideoInfo = null;
        }
        bwY().b(new com.baidu.tbadk.editortools.a(2, 19, null));
        setVoiceModel(null);
        bwY().b(new com.baidu.tbadk.editortools.a(2, 6, null));
        bwY().b(new com.baidu.tbadk.editortools.a(33, 6, null));
        if (!StringUtils.isNull(this.mPostContent)) {
            this.mPostContent = "";
        }
        DD("");
        this.fjQ.e((WriteData) null);
        this.fjQ.xp(false);
    }

    public boolean bxT() {
        LinkedList<ImageFileInfo> chosedFiles;
        return (this.writeImagesInfo == null || (chosedFiles = this.writeImagesInfo.getChosedFiles()) == null || chosedFiles.isEmpty()) ? false : true;
    }

    public boolean bxU() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    private void bxV() {
        if (this.fkb == null && bwY() != null) {
            this.fkb = (f) bwY().ra(27);
        }
    }

    public void bxW() {
        if (this.fkb != null && this.fka != null) {
            this.fkb.c(this.fka);
        }
    }

    public void a(TextWatcher textWatcher) {
        bxV();
        if (this.fkb != null && textWatcher != null) {
            this.fkb.b(textWatcher);
        }
    }

    public void bxl() {
        if (this.fhk != null) {
            this.fhk.bxl();
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
                while (aw.eIh.matcher(writeData.getContent()).find()) {
                    i2++;
                }
                if (i2 > 0 && this.mFrom > 0) {
                    aq aqVar = new aq("c13990");
                    aqVar.aj("obj_type", i2);
                    aqVar.aj("obj_source", this.mFrom);
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
                    aqVar2.aj("obj_type", i);
                    aqVar2.aj("obj_source", this.mFrom);
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
