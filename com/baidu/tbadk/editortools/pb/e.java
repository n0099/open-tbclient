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
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ag;
import com.baidu.tbadk.coreExtra.data.t;
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
/* loaded from: classes15.dex */
public class e extends com.baidu.tbadk.editortools.e implements x.a {
    private bw ajx;
    protected long authorId;
    protected String authorName;
    protected String authorNameShow;
    private EditorTools eKm;
    private f eMA;
    private LocationModel.a eMB;
    private LocationModel.b eMC;
    private final NewWriteModel.d eMD;
    private final com.baidu.adp.base.d eME;
    private String eMn;
    protected LocationModel eMo;
    protected NewWriteModel eMp;
    protected ImageModel eMq;
    private DataModel<?> eMr;
    protected ForumData eMs;
    protected String eMt;
    private int eMu;
    protected NewWriteModel.d eMv;
    private c eMw;
    protected b eMx;
    protected boolean eMy;
    private TextWatcher eMz;
    protected TbPageContext efn;
    public boolean isBJH;
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
        this.eMp = null;
        this.eMq = null;
        this.mThreadId = null;
        this.eMt = null;
        this.eMu = 0;
        this.eMy = false;
        this.eMB = new LocationModel.a() { // from class: com.baidu.tbadk.editortools.pb.e.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void bsp() {
                e.this.efn.showToast(R.string.no_network_guide);
                e.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                TbPageContext tbPageContext = e.this.efn;
                if (StringUtils.isNull(str)) {
                    str = e.this.brv().getContext().getString(R.string.location_fail);
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
        this.eMC = new LocationModel.b() { // from class: com.baidu.tbadk.editortools.pb.e.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void bsq() {
                e.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void Cc(String str) {
                e.this.a(2, true, str);
            }
        };
        this.eMD = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.e.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ag agVar, WriteData writeData, AntiData antiData) {
                WriteData cKZ = writeData == null ? e.this.eMp.cKZ() : writeData;
                if (z) {
                    e.this.jp(true);
                    WriteData cKZ2 = e.this.eMp.cKZ();
                    e.this.resetData();
                    x.f(e.this.mThreadId, (WriteData) null);
                    if (cKZ2 != null) {
                        if (cKZ2.getType() == 2) {
                            x.a(cKZ2.getThreadId(), e.this);
                        }
                    } else {
                        return;
                    }
                } else if (cKZ != null && agVar != null && !TextUtils.isEmpty(agVar.bmY())) {
                    cKZ.setVcodeMD5(agVar.getVcode_md5());
                    cKZ.setVcodeUrl(agVar.getVcode_pic_url());
                    cKZ.setVcodeExtra(agVar.bmZ());
                    if (e.this.ajx != null) {
                        cKZ.setBaijiahaoData(e.this.ajx.getBaijiahaoData());
                    }
                    if (com.baidu.tbadk.t.a.CO(agVar.bmY())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(e.this.efn.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cKZ, false, agVar.bmY())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(e.this.efn.getPageActivity(), cKZ, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(e.this.efn.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cKZ, postWriteCallBackData.getAccessState())));
                }
                e.this.b(e.this.eMp.cKZ());
                if (e.this.eMv != null) {
                    e.this.eMv.callback(z, postWriteCallBackData, agVar, cKZ, antiData);
                }
            }
        };
        this.eME = new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.editortools.pb.e.7
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Bitmap) {
                    e.this.eMp.wg(true);
                }
            }
        };
        this.eKm = editorTools;
    }

    public void qk(int i) {
        if (this.eMA == null && brv() != null) {
            this.eMA = (f) brv().qe(27);
        }
        if (this.eMA != null) {
            this.eMA.setType(i);
        }
    }

    public void ql(int i) {
        if (this.eMA == null && brv() != null) {
            this.eMA = (f) brv().qe(27);
        }
        if (this.eMA != null) {
            this.eMA.qm(i);
        }
    }

    public f brW() {
        if (this.eMA == null && brv() != null) {
            this.eMA = (f) brv().qe(27);
        }
        return this.eMA;
    }

    public void BW(String str) {
        if (this.eMA == null && brv() != null) {
            this.eMA = (f) brv().qe(27);
        }
        if (this.eMA != null) {
            this.eMA.setHint(str);
        }
    }

    public void jl(boolean z) {
        BLauncher bLauncher;
        if (brv() != null && (bLauncher = (BLauncher) brv().qb(5)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void jm(boolean z) {
        BLauncher bLauncher;
        if (brv() != null && (bLauncher = (BLauncher) brv().qb(23)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void jn(boolean z) {
        BLauncher bLauncher;
        if (brv() != null && (bLauncher = (BLauncher) brv().qb(2)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.eMr = dataModel;
    }

    public void setThreadId(String str) {
        this.mThreadId = str;
    }

    public void a(TbPageContext tbPageContext) {
        this.efn = tbPageContext;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.eMt = antiData.getVoice_message();
        }
    }

    public void a(ForumData forumData, UserData userData) {
        this.eMs = forumData;
    }

    public void setThreadData(bw bwVar) {
        this.ajx = bwVar;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (brv() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.authorNameShow = metaData.getName_show();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void jo(boolean z) {
        this.eMy = z;
    }

    public void brX() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            if (String.valueOf(this.authorId).equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                l.showToast(this.efn.getPageActivity(), R.string.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.efn.getPageActivity(), this.authorId, this.authorName, this.authorNameShow, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.f.b.toLong(this.mThreadId, 0L), com.baidu.adp.lib.f.b.toLong(this.postId, 0L))));
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.efn.getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_LOGIN_SUB_PB_AT /* 11026 */:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.efn.getPageActivity(), RequestResponseCode.REQUEST_SUB_PB_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("camera_result", false)) {
                            E(intent);
                        } else {
                            G(intent);
                        }
                        brv().invalidate();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_IMAGE_VIEW /* 12003 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("delete", false)) {
                            bsi();
                            this.eMp.wg(false);
                            return;
                        }
                        this.eMq.BV(intent.getStringExtra("file_name"));
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
                    WriteData cKZ = this.eMp.cKZ();
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (cKZ != null) {
                        cKZ.deleteUploadedTempImages();
                    }
                    this.eMp.d((WriteData) null);
                    this.eMp.wg(false);
                    this.mVoiceModel = null;
                    this.mVideoInfo = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        x.f(this.mThreadId, (WriteData) null);
                    }
                    jp(true);
                    if (this.eMv != null) {
                        this.eMv.callback(true, postWriteCallBackData, null, cKZ, null);
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
                    if (brv() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            aq aqVar = new aq(TbadkCoreStatisticKey.XIAOYING_DURATION);
                            aqVar.ai("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(aqVar);
                            bsj();
                            brv().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            brv().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                        Ca(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case RequestResponseCode.REQUEST_CAMERA /* 12001 */:
                bsg();
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
                if (this.eMv != null) {
                    this.eMv.callback(false, postWriteCallBackData2, null, this.eMp.cKZ(), null);
                    return;
                }
                return;
        }
    }

    public void brY() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.efn.getPageActivity())));
    }

    public void brZ() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.efn.getPageActivity())) {
            this.efn.showToast(R.string.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bsc();
        } else if (this.eMo.dxn()) {
            brY();
        } else {
            this.eMo.we(false);
            a(1, true, (String) null);
            this.eMo.dxl();
        }
    }

    public void bsa() {
        if (!ae.checkLocationForGoogle(this.efn.getPageActivity())) {
            ae.d(this.efn.getPageActivity(), 0);
        } else {
            brZ();
        }
    }

    public void bsb() {
        if (!this.isBJH && this.eMo != null && !com.baidu.tieba.tbadkCore.location.b.dxi().dxj() && UtilHelper.isSystemLocationProviderEnabled(this.efn.getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared()) {
            this.eMo.dxl();
        }
    }

    private void bsc() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.efn.getPageActivity());
        aVar.nt(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    e.this.a(1, true, (String) null);
                    e.this.eMo.dxp();
                } else {
                    e.this.eMB.bsp();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                e.this.a(0, true, (String) null);
                aVar2.dismiss();
            }
        }).b(this.efn);
        aVar.bhg();
    }

    public void bsd() {
        if (this.eMo.bXz()) {
            if (this.eMo.dxn()) {
                this.eMB.a(com.baidu.tieba.tbadkCore.location.b.dxi().getLocationData());
                return;
            }
            if (l.isNetOk()) {
                this.eMo.dxl();
            }
            a(0, true, (String) null);
            return;
        }
        a(0, false, (String) null);
    }

    public boolean bse() {
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
        this.eMp.d((WriteData) null);
        this.eMp.wg(false);
        this.mVoiceModel = null;
        this.mVideoInfo = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void bsf() {
        this.mVideoInfo = null;
    }

    private void E(Intent intent) {
        this.eMn = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.eMn;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.efn.getPageActivity(), l.getEquipmentWidth(this.efn.getPageActivity())), l.dip2px(this.efn.getPageActivity(), l.getEquipmentHeight(this.efn.getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    n.a("cameras", this.eMn, rotateBitmapBydegree, 100);
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
        if (this.eMs != null) {
            threadData.setForumId(this.eMs.getId());
            threadData.setForumName(this.eMs.getName());
            threadData.setFirstDir(this.eMs.getFirst_class());
            threadData.setSecondDir(this.eMs.getSecond_class());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        threadData.isBJH = this.isBJH;
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.eMt);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.efn.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void c(t tVar) {
        if (tVar != null) {
            if (tVar.bmP() == EmotionGroupType.BIG_EMOTION || tVar.bmP() == EmotionGroupType.USER_COLLECT) {
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setImageType(1);
                imageFileInfo.setFilePath(tVar.getName());
                imageFileInfo.width = tVar.getWidth();
                imageFileInfo.height = tVar.getHeight();
                this.writeImagesInfo.addChooseFile(imageFileInfo);
                this.writeImagesInfo.updateQuality();
            }
        }
    }

    private void bsg() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tbadk.editortools.pb.e.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                n.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + e.this.eMn));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void G(Intent intent) {
        a(intent, true);
    }

    public void BX(String str) {
        WriteData cKZ = this.eMp.cKZ();
        if (cKZ == null) {
            cKZ = new WriteData(1);
            cKZ.setThreadId(str);
            cKZ.setWriteImagesInfo(this.writeImagesInfo);
        }
        cKZ.setContent(this.mPostContent);
        cKZ.setVideoInfo(this.mVideoInfo);
        cKZ.setVoiceModel(this.mVoiceModel);
        x.f(str, cKZ);
    }

    public void BY(String str) {
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
                bsj();
                brv().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                    brv().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                brv().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            if (writeData.getVoiceModel() != null && writeData.getVoiceModel().voiceId != null && writeData.getVoiceModel().duration != -1) {
                if (this.mVoiceModel == null) {
                    this.mVoiceModel = new VoiceData.VoiceModel();
                }
                this.mVoiceModel.copy(writeData.getVoiceModel());
            }
            if (!at.isEmpty(writeData.getContent()) && at.isEmpty(this.mPostContent)) {
                this.mPostContent = writeData.getContent();
                Cb(this.mPostContent);
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
                    brv().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                brv().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.mPostContent = writeData.getContent();
            Cb(this.mPostContent);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.eMp.cancelLoadData();
        this.eMq.cancelLoadData();
        this.eMo.cancelLoadData();
    }

    public void a(TbPageContext tbPageContext, Bundle bundle) {
        this.eMp = new NewWriteModel(tbPageContext);
        this.eMp.b(this.eMD);
        this.eMq = new ImageModel(tbPageContext);
        this.eMq.setLoadDataCallBack(this.eME);
        this.eMo = new LocationModel(tbPageContext);
        this.eMo.a(this.eMB);
        this.eMo.a(this.eMC);
        if (bundle != null) {
            this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
            this.eMn = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(this.isBJH ? 1 : 9);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && brv() != null) {
            brv().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.eMo.bXz() && brv() != null) {
            brv().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            brv().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.writeImagesInfo != null) {
            bundle.putString(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.eMn);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.eMp.cKZ() == null) {
            WriteData BU = this.eMr.BU(str);
            if (BU != null && this.ajx != null) {
                BU.setBaijiahaoData(this.ajx.getBaijiahaoData());
            }
            this.eMp.d(BU);
        }
        if (this.eMp.cKZ() != null) {
            this.eMp.setSpanGroupManager(this.mSpanGroupManager);
            if (this.eMy) {
                this.eMp.cKZ().setCanNoForum(true);
                if (this.eMs != null) {
                    this.eMp.cKZ().setVForumId(this.eMs.getId());
                    this.eMp.cKZ().setVForumName(this.eMs.getName());
                }
            } else {
                this.eMp.cKZ().setCanNoForum(false);
                this.eMp.cKZ().setVForumId("");
                this.eMp.cKZ().setVForumName("");
            }
            this.eMp.cKZ().setIsBJHPost(this.isBJH);
            this.eMp.cKZ().setWriteImagesInfo(this.writeImagesInfo);
            this.eMp.cKZ().setVideoInfo(this.mVideoInfo);
            this.eMp.wg(this.writeImagesInfo.size() > 0);
            WriteData cKZ = this.eMp.cKZ();
            if (this.eMo == null || !this.eMo.bXz()) {
                z = false;
            }
            cKZ.setHasLocationData(z);
            if (str == null) {
                this.eMp.cKZ().setContent(this.mPostContent);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.eMp.cKZ().setVoice(this.mVoiceModel.getId());
                    this.eMp.cKZ().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.eMp.cKZ().setVoice(null);
                    this.eMp.cKZ().setVoiceDuringTime(-1);
                }
            } else {
                this.eMp.cKZ().setVoice(null);
                this.eMp.cKZ().setVoiceDuringTime(-1);
            }
            if (!this.eMp.dxV()) {
                this.efn.showToast(R.string.write_img_limit);
            } else if (this.eMx == null || !this.eMx.brU()) {
                if (this.eMw != null) {
                    this.eMw.brV();
                }
                if (!this.eMp.dxS()) {
                }
            }
        }
    }

    public TbPageContext bmF() {
        return this.efn;
    }

    public void BZ(String str) {
        this.mPostContent = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int bsh() {
        return this.eMu;
    }

    private void bsi() {
        if (brv() != null) {
            brv().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void N(ArrayList<String> arrayList) {
        if (brv() != null) {
            brv().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void Ca(String str) {
        if (brv() != null) {
            brv().b(new com.baidu.tbadk.editortools.a(44, 27, str));
        }
    }

    private void bsj() {
        if (brv() != null) {
            brv().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.eMu = i;
        if (brv() != null) {
            brv().b(new com.baidu.tbadk.editortools.a(19, 27, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void Cb(String str) {
        if (brv() != null) {
            brv().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jp(boolean z) {
        if (brv() != null) {
            if (z) {
                brv().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                brv().b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
            brv().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.eMv = dVar;
    }

    public void a(c cVar) {
        this.eMw = cVar;
    }

    public void a(b bVar) {
        this.eMx = bVar;
    }

    public void bsk() {
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            this.writeImagesInfo.clear();
        }
        if (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) {
            this.mVideoInfo = null;
        }
        brv().b(new com.baidu.tbadk.editortools.a(2, 19, null));
        setVoiceModel(null);
        brv().b(new com.baidu.tbadk.editortools.a(2, 6, null));
        brv().b(new com.baidu.tbadk.editortools.a(33, 6, null));
        if (!StringUtils.isNull(this.mPostContent)) {
            this.mPostContent = "";
        }
        Cb("");
        this.eMp.d((WriteData) null);
        this.eMp.wg(false);
    }

    public boolean bsl() {
        LinkedList<ImageFileInfo> chosedFiles;
        return (this.writeImagesInfo == null || (chosedFiles = this.writeImagesInfo.getChosedFiles()) == null || chosedFiles.isEmpty()) ? false : true;
    }

    public boolean bsm() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    private void bsn() {
        if (this.eMA == null && brv() != null) {
            this.eMA = (f) brv().qe(27);
        }
    }

    public void bso() {
        if (this.eMA != null && this.eMz != null) {
            this.eMA.c(this.eMz);
        }
    }

    public void a(TextWatcher textWatcher) {
        bsn();
        if (this.eMA != null && textWatcher != null) {
            this.eMA.b(textWatcher);
        }
    }

    public void brG() {
        if (this.eKm != null) {
            this.eKm.brG();
        }
    }

    public void setSpanGroupManager(SpanGroupManager spanGroupManager) {
        this.mSpanGroupManager = spanGroupManager;
    }
}
