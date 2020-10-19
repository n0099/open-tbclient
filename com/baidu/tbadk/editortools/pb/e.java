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
    private bw akp;
    protected long authorId;
    protected String authorName;
    protected String authorNameShow;
    private EditorTools eYO;
    protected TbPageContext etO;
    protected boolean fbA;
    private TextWatcher fbB;
    private f fbC;
    private LocationModel.a fbD;
    private LocationModel.b fbE;
    private final NewWriteModel.d fbF;
    private final com.baidu.adp.base.d fbG;
    private String fbp;
    protected LocationModel fbq;
    protected NewWriteModel fbr;
    protected ImageModel fbs;
    private DataModel<?> fbt;
    protected ForumData fbu;
    protected String fbv;
    private int fbw;
    protected NewWriteModel.d fbx;
    private c fby;
    protected b fbz;
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
        this.fbr = null;
        this.fbs = null;
        this.mThreadId = null;
        this.fbv = null;
        this.fbw = 0;
        this.fbA = false;
        this.mFrom = 0;
        this.fbD = new LocationModel.a() { // from class: com.baidu.tbadk.editortools.pb.e.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void bwe() {
                e.this.etO.showToast(R.string.no_network_guide);
                e.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                TbPageContext tbPageContext = e.this.etO;
                if (StringUtils.isNull(str)) {
                    str = e.this.bvf().getContext().getString(R.string.location_fail);
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
        this.fbE = new LocationModel.b() { // from class: com.baidu.tbadk.editortools.pb.e.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void bwf() {
                e.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void Dl(String str) {
                e.this.a(2, true, str);
            }
        };
        this.fbF = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.e.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                WriteData cSo = writeData == null ? e.this.fbr.cSo() : writeData;
                if (z) {
                    e.this.jQ(true);
                    WriteData cSo2 = e.this.fbr.cSo();
                    e.this.resetData();
                    x.f(e.this.mThreadId, (WriteData) null);
                    if (cSo2 != null) {
                        if (cSo2.getType() == 2) {
                            x.a(cSo2.getThreadId(), e.this);
                        }
                    } else {
                        return;
                    }
                } else if (cSo != null && ahVar != null && !TextUtils.isEmpty(ahVar.bqC())) {
                    cSo.setVcodeMD5(ahVar.getVcode_md5());
                    cSo.setVcodeUrl(ahVar.getVcode_pic_url());
                    cSo.setVcodeExtra(ahVar.bqD());
                    if (e.this.akp != null) {
                        cSo.setBaijiahaoData(e.this.akp.getBaijiahaoData());
                    }
                    if (com.baidu.tbadk.t.a.DX(ahVar.bqC())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(e.this.etO.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cSo, false, ahVar.bqC())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(e.this.etO.getPageActivity(), cSo, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(e.this.etO.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cSo, postWriteCallBackData.getAccessState())));
                }
                e.this.b(e.this.fbr.cSo());
                if (e.this.fbx != null) {
                    e.this.fbx.callback(z, postWriteCallBackData, ahVar, cSo, antiData);
                }
            }
        };
        this.fbG = new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.editortools.pb.e.7
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Bitmap) {
                    e.this.fbr.wY(true);
                }
            }
        };
        this.eYO = editorTools;
    }

    public void qZ(int i) {
        if (this.fbC == null && bvf() != null) {
            this.fbC = (f) bvf().qP(27);
        }
        if (this.fbC != null) {
            this.fbC.setType(i);
        }
    }

    public void ra(int i) {
        if (this.fbC == null && bvf() != null) {
            this.fbC = (f) bvf().qP(27);
        }
        if (this.fbC != null) {
            this.fbC.rb(i);
        }
    }

    public f bvL() {
        if (this.fbC == null && bvf() != null) {
            this.fbC = (f) bvf().qP(27);
        }
        return this.fbC;
    }

    public void Df(String str) {
        if (this.fbC == null && bvf() != null) {
            this.fbC = (f) bvf().qP(27);
        }
        if (this.fbC != null) {
            this.fbC.setHint(str);
        }
    }

    public void jM(boolean z) {
        BLauncher bLauncher;
        if (bvf() != null && (bLauncher = (BLauncher) bvf().qM(5)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void jN(boolean z) {
        BLauncher bLauncher;
        if (bvf() != null && (bLauncher = (BLauncher) bvf().qM(23)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void jO(boolean z) {
        BLauncher bLauncher;
        if (bvf() != null && (bLauncher = (BLauncher) bvf().qM(2)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.fbt = dataModel;
    }

    public void setThreadId(String str) {
        this.mThreadId = str;
    }

    public void a(TbPageContext tbPageContext) {
        this.etO = tbPageContext;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.fbv = antiData.getVoice_message();
        }
    }

    public void a(ForumData forumData, UserData userData) {
        this.fbu = forumData;
    }

    public void setThreadData(bw bwVar) {
        this.akp = bwVar;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (bvf() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.authorNameShow = metaData.getName_show();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void jP(boolean z) {
        this.fbA = z;
    }

    public void bvM() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            if (String.valueOf(this.authorId).equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                l.showToast(this.etO.getPageActivity(), R.string.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.etO.getPageActivity(), this.authorId, this.authorName, this.authorNameShow, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.f.b.toLong(this.mThreadId, 0L), com.baidu.adp.lib.f.b.toLong(this.postId, 0L))));
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.etO.getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_LOGIN_SUB_PB_AT /* 11026 */:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.etO.getPageActivity(), RequestResponseCode.REQUEST_SUB_PB_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("camera_result", false)) {
                            E(intent);
                        } else {
                            G(intent);
                        }
                        bvf().invalidate();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_IMAGE_VIEW /* 12003 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("delete", false)) {
                            bvX();
                            this.fbr.wY(false);
                            return;
                        }
                        this.fbs.De(intent.getStringExtra("file_name"));
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
                    WriteData cSo = this.fbr.cSo();
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (cSo != null) {
                        cSo.deleteUploadedTempImages();
                    }
                    this.fbr.e((WriteData) null);
                    this.fbr.wY(false);
                    this.mVoiceModel = null;
                    this.mVideoInfo = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        x.f(this.mThreadId, (WriteData) null);
                    }
                    jQ(true);
                    if (this.fbx != null) {
                        this.fbx.callback(true, postWriteCallBackData, null, cSo, null);
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
                    if (bvf() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            aq aqVar = new aq(TbadkCoreStatisticKey.XIAOYING_DURATION);
                            aqVar.aj("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(aqVar);
                            bvY();
                            bvf().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            bvf().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                        Dj(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case RequestResponseCode.REQUEST_CAMERA /* 12001 */:
                bvV();
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
                if (this.fbx != null) {
                    this.fbx.callback(false, postWriteCallBackData2, null, this.fbr.cSo(), null);
                    return;
                }
                return;
        }
    }

    public void bvN() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.etO.getPageActivity())));
    }

    public void bvO() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.etO.getPageActivity())) {
            this.etO.showToast(R.string.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bvR();
        } else if (this.fbq.dEX()) {
            bvN();
        } else {
            this.fbq.wW(false);
            a(1, true, (String) null);
            this.fbq.dEV();
        }
    }

    public void bvP() {
        if (!ae.checkLocationForGoogle(this.etO.getPageActivity())) {
            ae.c(this.etO.getPageActivity(), 0);
        } else {
            bvO();
        }
    }

    public void bvQ() {
        if (!this.isBJH && this.fbq != null && !com.baidu.tieba.tbadkCore.location.b.dES().dET() && UtilHelper.isSystemLocationProviderEnabled(this.etO.getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared()) {
            this.fbq.dEV();
        }
    }

    private void bvR() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.etO.getPageActivity());
        aVar.ob(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    e.this.a(1, true, (String) null);
                    e.this.fbq.dEZ();
                } else {
                    e.this.fbD.bwe();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                e.this.a(0, true, (String) null);
                aVar2.dismiss();
            }
        }).b(this.etO);
        aVar.bkJ();
    }

    public void bvS() {
        if (this.fbq.ccF()) {
            if (this.fbq.dEX()) {
                this.fbD.a(com.baidu.tieba.tbadkCore.location.b.dES().getLocationData());
                return;
            }
            if (l.isNetOk()) {
                this.fbq.dEV();
            }
            a(0, true, (String) null);
            return;
        }
        a(0, false, (String) null);
    }

    public boolean bvT() {
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
        this.fbr.e((WriteData) null);
        this.fbr.wY(false);
        this.mVoiceModel = null;
        this.mVideoInfo = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void bvU() {
        this.mVideoInfo = null;
    }

    private void E(Intent intent) {
        this.fbp = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.fbp;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.etO.getPageActivity(), l.getEquipmentWidth(this.etO.getPageActivity())), l.dip2px(this.etO.getPageActivity(), l.getEquipmentHeight(this.etO.getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    n.a("cameras", this.fbp, rotateBitmapBydegree, 100);
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
        if (this.fbu != null) {
            threadData.setForumId(this.fbu.getId());
            threadData.setForumName(this.fbu.getName());
            threadData.setFirstDir(this.fbu.getFirst_class());
            threadData.setSecondDir(this.fbu.getSecond_class());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        threadData.isBJH = this.isBJH;
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.fbv);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.etO.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void c(u uVar) {
        if (uVar != null) {
            if (uVar.bqt() == EmotionGroupType.BIG_EMOTION || uVar.bqt() == EmotionGroupType.USER_COLLECT) {
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

    private void bvV() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tbadk.editortools.pb.e.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                n.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + e.this.fbp));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void G(Intent intent) {
        a(intent, true);
    }

    public void Dg(String str) {
        WriteData cSo = this.fbr.cSo();
        if (cSo == null) {
            cSo = new WriteData(1);
            cSo.setThreadId(str);
            cSo.setWriteImagesInfo(this.writeImagesInfo);
        }
        cSo.setContent(this.mPostContent);
        cSo.setVideoInfo(this.mVideoInfo);
        cSo.setVoiceModel(this.mVoiceModel);
        x.f(str, cSo);
    }

    public void Dh(String str) {
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
                bvY();
                bvf().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                    bvf().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                bvf().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            if (writeData.getVoiceModel() != null && writeData.getVoiceModel().voiceId != null && writeData.getVoiceModel().duration != -1) {
                if (this.mVoiceModel == null) {
                    this.mVoiceModel = new VoiceData.VoiceModel();
                }
                this.mVoiceModel.copy(writeData.getVoiceModel());
            }
            if (!at.isEmpty(writeData.getContent()) && at.isEmpty(this.mPostContent)) {
                this.mPostContent = writeData.getContent();
                Dk(this.mPostContent);
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
                    bvf().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                bvf().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.mPostContent = writeData.getContent();
            Dk(this.mPostContent);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.fbr.cancelLoadData();
        this.fbs.cancelLoadData();
        this.fbq.cancelLoadData();
    }

    public void a(TbPageContext tbPageContext, Bundle bundle) {
        this.fbr = new NewWriteModel(tbPageContext);
        this.fbr.b(this.fbF);
        this.fbs = new ImageModel(tbPageContext);
        this.fbs.setLoadDataCallBack(this.fbG);
        this.fbq = new LocationModel(tbPageContext);
        this.fbq.a(this.fbD);
        this.fbq.a(this.fbE);
        if (bundle != null) {
            this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
            this.fbp = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(this.isBJH ? 1 : 9);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && bvf() != null) {
            bvf().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.fbq.ccF() && bvf() != null) {
            bvf().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            bvf().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.writeImagesInfo != null) {
            bundle.putString(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.fbp);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.fbr.cSo() == null) {
            WriteData Dd = this.fbt.Dd(str);
            if (Dd != null && this.akp != null) {
                Dd.setBaijiahaoData(this.akp.getBaijiahaoData());
            }
            this.fbr.e(Dd);
        }
        if (this.fbr.cSo() != null) {
            this.fbr.setSpanGroupManager(this.mSpanGroupManager);
            if (this.fbA) {
                this.fbr.cSo().setCanNoForum(true);
                if (this.fbu != null) {
                    this.fbr.cSo().setVForumId(this.fbu.getId());
                    this.fbr.cSo().setVForumName(this.fbu.getName());
                }
            } else {
                this.fbr.cSo().setCanNoForum(false);
                this.fbr.cSo().setVForumId("");
                this.fbr.cSo().setVForumName("");
            }
            this.fbr.cSo().setIsBJHPost(this.isBJH);
            this.fbr.cSo().setWriteImagesInfo(this.writeImagesInfo);
            this.fbr.cSo().setVideoInfo(this.mVideoInfo);
            this.fbr.wY(this.writeImagesInfo.size() > 0);
            WriteData cSo = this.fbr.cSo();
            if (this.fbq == null || !this.fbq.ccF()) {
                z = false;
            }
            cSo.setHasLocationData(z);
            if (str == null) {
                this.fbr.cSo().setContent(this.mPostContent);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.fbr.cSo().setVoice(this.mVoiceModel.getId());
                    this.fbr.cSo().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.fbr.cSo().setVoice(null);
                    this.fbr.cSo().setVoiceDuringTime(-1);
                }
            } else {
                this.fbr.cSo().setVoice(null);
                this.fbr.cSo().setVoiceDuringTime(-1);
            }
            if (!this.fbr.dFF()) {
                this.etO.showToast(R.string.write_img_limit);
            } else if (this.fbz == null || !this.fbz.bvJ()) {
                if (this.fby != null) {
                    this.fby.bvK();
                }
                c(this.fbr.cSo());
                if (!this.fbr.dFC()) {
                }
            }
        }
    }

    public TbPageContext bqj() {
        return this.etO;
    }

    public void Di(String str) {
        this.mPostContent = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int bvW() {
        return this.fbw;
    }

    private void bvX() {
        if (bvf() != null) {
            bvf().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void N(ArrayList<String> arrayList) {
        if (bvf() != null) {
            bvf().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void Dj(String str) {
        if (bvf() != null) {
            bvf().b(new com.baidu.tbadk.editortools.a(44, 27, str));
        }
    }

    private void bvY() {
        if (bvf() != null) {
            bvf().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.fbw = i;
        if (bvf() != null) {
            bvf().b(new com.baidu.tbadk.editortools.a(19, 27, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void Dk(String str) {
        if (bvf() != null) {
            bvf().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jQ(boolean z) {
        if (bvf() != null) {
            if (z) {
                bvf().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                bvf().b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
            bvf().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.fbx = dVar;
    }

    public void a(c cVar) {
        this.fby = cVar;
    }

    public void a(b bVar) {
        this.fbz = bVar;
    }

    public void bvZ() {
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            this.writeImagesInfo.clear();
        }
        if (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) {
            this.mVideoInfo = null;
        }
        bvf().b(new com.baidu.tbadk.editortools.a(2, 19, null));
        setVoiceModel(null);
        bvf().b(new com.baidu.tbadk.editortools.a(2, 6, null));
        bvf().b(new com.baidu.tbadk.editortools.a(33, 6, null));
        if (!StringUtils.isNull(this.mPostContent)) {
            this.mPostContent = "";
        }
        Dk("");
        this.fbr.e((WriteData) null);
        this.fbr.wY(false);
    }

    public boolean bwa() {
        LinkedList<ImageFileInfo> chosedFiles;
        return (this.writeImagesInfo == null || (chosedFiles = this.writeImagesInfo.getChosedFiles()) == null || chosedFiles.isEmpty()) ? false : true;
    }

    public boolean bwb() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    private void bwc() {
        if (this.fbC == null && bvf() != null) {
            this.fbC = (f) bvf().qP(27);
        }
    }

    public void bwd() {
        if (this.fbC != null && this.fbB != null) {
            this.fbC.c(this.fbB);
        }
    }

    public void a(TextWatcher textWatcher) {
        bwc();
        if (this.fbC != null && textWatcher != null) {
            this.fbC.b(textWatcher);
        }
    }

    public void bvs() {
        if (this.eYO != null) {
            this.eYO.bvs();
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
                while (aw.ezL.matcher(writeData.getContent()).find()) {
                    i2++;
                }
                if (i2 > 0 && this.mFrom > 0) {
                    aq aqVar = new aq("c13990");
                    aqVar.aj("obj_type", i2);
                    aqVar.aj("obj_source", this.mFrom);
                    aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar.dK("tid", writeData.getThreadId());
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
                    aqVar2.dK("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar2.dK("tid", writeData.getThreadId());
                    TiebaStatic.log(aqVar2);
                }
            }
        }
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }
}
