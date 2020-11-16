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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.ax;
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
/* loaded from: classes20.dex */
public class e extends com.baidu.tbadk.editortools.e implements x.a {
    private bx akt;
    protected long authorId;
    protected String authorName;
    protected String authorNameShow;
    protected TbPageContext eGu;
    private EditorTools fml;
    private String foN;
    protected LocationModel foO;
    protected NewWriteModel foP;
    protected ImageModel foQ;
    private DataModel<?> foR;
    protected ForumData foS;
    protected String foT;
    private int foU;
    protected NewWriteModel.d foV;
    private c foW;
    protected b foX;
    protected boolean foY;
    private TextWatcher foZ;
    private f fpa;
    private LocationModel.a fpb;
    private LocationModel.b fpc;
    private final NewWriteModel.d fpd;
    private final com.baidu.adp.base.d fpe;
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
        this.foP = null;
        this.foQ = null;
        this.mThreadId = null;
        this.foT = null;
        this.foU = 0;
        this.foY = false;
        this.mFrom = 0;
        this.fpb = new LocationModel.a() { // from class: com.baidu.tbadk.editortools.pb.e.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void bzM() {
                e.this.eGu.showToast(R.string.no_network_guide);
                e.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                TbPageContext tbPageContext = e.this.eGu;
                if (StringUtils.isNull(str)) {
                    str = e.this.byN().getContext().getString(R.string.location_fail);
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
        this.fpc = new LocationModel.b() { // from class: com.baidu.tbadk.editortools.pb.e.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void bzN() {
                e.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void Dr(String str) {
                e.this.a(2, true, str);
            }
        };
        this.fpd = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.e.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                WriteData cXs = writeData == null ? e.this.foP.cXs() : writeData;
                if (z) {
                    e.this.kn(true);
                    WriteData cXs2 = e.this.foP.cXs();
                    e.this.resetData();
                    x.f(e.this.mThreadId, (WriteData) null);
                    if (cXs2 != null) {
                        if (cXs2.getType() == 2) {
                            x.a(cXs2.getThreadId(), e.this);
                        }
                    } else {
                        return;
                    }
                } else if (cXs != null && ahVar != null && !TextUtils.isEmpty(ahVar.bul())) {
                    cXs.setVcodeMD5(ahVar.getVcode_md5());
                    cXs.setVcodeUrl(ahVar.getVcode_pic_url());
                    cXs.setVcodeExtra(ahVar.bum());
                    if (e.this.akt != null) {
                        cXs.setBaijiahaoData(e.this.akt.getBaijiahaoData());
                    }
                    if (com.baidu.tbadk.t.a.Ef(ahVar.bul())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(e.this.eGu.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cXs, false, ahVar.bul())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(e.this.eGu.getPageActivity(), cXs, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(e.this.eGu.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cXs, postWriteCallBackData.getAccessState())));
                }
                e.this.b(e.this.foP.cXs());
                if (e.this.foV != null) {
                    e.this.foV.callback(z, postWriteCallBackData, ahVar, cXs, antiData);
                }
            }
        };
        this.fpe = new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.editortools.pb.e.7
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Bitmap) {
                    e.this.foP.xF(true);
                }
            }
        };
        this.fml = editorTools;
    }

    public void rS(int i) {
        if (this.fpa == null && byN() != null) {
            this.fpa = (f) byN().rI(27);
        }
        if (this.fpa != null) {
            this.fpa.setType(i);
        }
    }

    public void rT(int i) {
        if (this.fpa == null && byN() != null) {
            this.fpa = (f) byN().rI(27);
        }
        if (this.fpa != null) {
            this.fpa.rU(i);
        }
    }

    public f bzt() {
        if (this.fpa == null && byN() != null) {
            this.fpa = (f) byN().rI(27);
        }
        return this.fpa;
    }

    public void Dl(String str) {
        if (this.fpa == null && byN() != null) {
            this.fpa = (f) byN().rI(27);
        }
        if (this.fpa != null) {
            this.fpa.setHint(str);
        }
    }

    public void kj(boolean z) {
        BLauncher bLauncher;
        if (byN() != null && (bLauncher = (BLauncher) byN().rF(5)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void kk(boolean z) {
        BLauncher bLauncher;
        if (byN() != null && (bLauncher = (BLauncher) byN().rF(23)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void kl(boolean z) {
        BLauncher bLauncher;
        if (byN() != null && (bLauncher = (BLauncher) byN().rF(2)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.foR = dataModel;
    }

    public void setThreadId(String str) {
        this.mThreadId = str;
    }

    public void a(TbPageContext tbPageContext) {
        this.eGu = tbPageContext;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.foT = antiData.getVoice_message();
        }
    }

    public void a(ForumData forumData, UserData userData) {
        this.foS = forumData;
    }

    public void setThreadData(bx bxVar) {
        this.akt = bxVar;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (byN() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.authorNameShow = metaData.getName_show();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void km(boolean z) {
        this.foY = z;
    }

    public void bzu() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            if (String.valueOf(this.authorId).equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                l.showToast(this.eGu.getPageActivity(), R.string.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.eGu.getPageActivity(), this.authorId, this.authorName, this.authorNameShow, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.f.b.toLong(this.mThreadId, 0L), com.baidu.adp.lib.f.b.toLong(this.postId, 0L))));
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.eGu.getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_LOGIN_SUB_PB_AT /* 11026 */:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.eGu.getPageActivity(), RequestResponseCode.REQUEST_SUB_PB_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("camera_result", false)) {
                            E(intent);
                        } else {
                            G(intent);
                        }
                        byN().invalidate();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_IMAGE_VIEW /* 12003 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("delete", false)) {
                            bzF();
                            this.foP.xF(false);
                            return;
                        }
                        this.foQ.Dk(intent.getStringExtra("file_name"));
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
                    WriteData cXs = this.foP.cXs();
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (cXs != null) {
                        cXs.deleteUploadedTempImages();
                    }
                    this.foP.e((WriteData) null);
                    this.foP.xF(false);
                    this.mVoiceModel = null;
                    this.mVideoInfo = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        x.f(this.mThreadId, (WriteData) null);
                    }
                    kn(true);
                    if (this.foV != null) {
                        this.foV.callback(true, postWriteCallBackData, null, cXs, null);
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
                    if (byN() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            ar arVar = new ar(TbadkCoreStatisticKey.XIAOYING_DURATION);
                            arVar.ak("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(arVar);
                            bzG();
                            byN().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            byN().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                        Dp(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case RequestResponseCode.REQUEST_CAMERA /* 12001 */:
                bzD();
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
                if (this.foV != null) {
                    this.foV.callback(false, postWriteCallBackData2, null, this.foP.cXs(), null);
                    return;
                }
                return;
        }
    }

    public void bzv() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.eGu.getPageActivity())));
    }

    public void bzw() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.eGu.getPageActivity())) {
            this.eGu.showToast(R.string.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bzz();
        } else if (this.foO.dKG()) {
            bzv();
        } else {
            this.foO.xD(false);
            a(1, true, (String) null);
            this.foO.dKE();
        }
    }

    public void bzx() {
        if (!ae.checkLocationForGoogle(this.eGu.getPageActivity())) {
            ae.c(this.eGu.getPageActivity(), 0);
        } else {
            bzw();
        }
    }

    public void bzy() {
        if (!this.isBJH && this.foO != null && !com.baidu.tieba.tbadkCore.location.b.dKB().dKC() && UtilHelper.isSystemLocationProviderEnabled(this.eGu.getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared()) {
            this.foO.dKE();
        }
    }

    private void bzz() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eGu.getPageActivity());
        aVar.os(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    e.this.a(1, true, (String) null);
                    e.this.foO.dKI();
                } else {
                    e.this.fpb.bzM();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                e.this.a(0, true, (String) null);
                aVar2.dismiss();
            }
        }).b(this.eGu);
        aVar.bog();
    }

    public void bzA() {
        if (this.foO.chG()) {
            if (this.foO.dKG()) {
                this.fpb.a(com.baidu.tieba.tbadkCore.location.b.dKB().getLocationData());
                return;
            }
            if (l.isNetOk()) {
                this.foO.dKE();
            }
            a(0, true, (String) null);
            return;
        }
        a(0, false, (String) null);
    }

    public boolean bzB() {
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
        this.foP.e((WriteData) null);
        this.foP.xF(false);
        this.mVoiceModel = null;
        this.mVideoInfo = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void bzC() {
        this.mVideoInfo = null;
    }

    private void E(Intent intent) {
        this.foN = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.foN;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.eGu.getPageActivity(), l.getEquipmentWidth(this.eGu.getPageActivity())), l.dip2px(this.eGu.getPageActivity(), l.getEquipmentHeight(this.eGu.getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    n.a("cameras", this.foN, rotateBitmapBydegree, 100);
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
        if (this.foS != null) {
            threadData.setForumId(this.foS.getId());
            threadData.setForumName(this.foS.getName());
            threadData.setFirstDir(this.foS.getFirst_class());
            threadData.setSecondDir(this.foS.getSecond_class());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        threadData.isBJH = this.isBJH;
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.foT);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.eGu.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void c(u uVar) {
        if (uVar != null) {
            if (uVar.buc() == EmotionGroupType.BIG_EMOTION || uVar.buc() == EmotionGroupType.USER_COLLECT) {
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

    private void bzD() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tbadk.editortools.pb.e.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                n.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + e.this.foN));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void G(Intent intent) {
        a(intent, true);
    }

    public void Dm(String str) {
        WriteData cXs = this.foP.cXs();
        if (cXs == null) {
            cXs = new WriteData(1);
            cXs.setThreadId(str);
            cXs.setWriteImagesInfo(this.writeImagesInfo);
        }
        cXs.setContent(this.mPostContent);
        cXs.setVideoInfo(this.mVideoInfo);
        cXs.setVoiceModel(this.mVoiceModel);
        x.f(str, cXs);
    }

    public void Dn(String str) {
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
                bzG();
                byN().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                    byN().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                byN().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            if (writeData.getVoiceModel() != null && writeData.getVoiceModel().voiceId != null && writeData.getVoiceModel().duration != -1) {
                if (this.mVoiceModel == null) {
                    this.mVoiceModel = new VoiceData.VoiceModel();
                }
                this.mVoiceModel.copy(writeData.getVoiceModel());
            }
            if (!au.isEmpty(writeData.getContent()) && au.isEmpty(this.mPostContent)) {
                this.mPostContent = writeData.getContent();
                Dq(this.mPostContent);
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
                    byN().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                byN().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.mPostContent = writeData.getContent();
            Dq(this.mPostContent);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.foP.cancelLoadData();
        this.foQ.cancelLoadData();
        this.foO.cancelLoadData();
    }

    public void a(TbPageContext tbPageContext, Bundle bundle) {
        this.foP = new NewWriteModel(tbPageContext);
        this.foP.b(this.fpd);
        this.foQ = new ImageModel(tbPageContext);
        this.foQ.setLoadDataCallBack(this.fpe);
        this.foO = new LocationModel(tbPageContext);
        this.foO.a(this.fpb);
        this.foO.a(this.fpc);
        if (bundle != null) {
            this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
            this.foN = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(this.isBJH ? 1 : 9);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && byN() != null) {
            byN().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.foO.chG() && byN() != null) {
            byN().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            byN().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.writeImagesInfo != null) {
            bundle.putString(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.foN);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.foP.cXs() == null) {
            WriteData Dj = this.foR.Dj(str);
            if (Dj != null && this.akt != null) {
                Dj.setBaijiahaoData(this.akt.getBaijiahaoData());
            }
            this.foP.e(Dj);
        }
        if (this.foP.cXs() != null) {
            this.foP.setSpanGroupManager(this.mSpanGroupManager);
            if (this.foY) {
                this.foP.cXs().setCanNoForum(true);
                if (this.foS != null) {
                    this.foP.cXs().setVForumId(this.foS.getId());
                    this.foP.cXs().setVForumName(this.foS.getName());
                }
            } else {
                this.foP.cXs().setCanNoForum(false);
                this.foP.cXs().setVForumId("");
                this.foP.cXs().setVForumName("");
            }
            this.foP.cXs().setIsBJHPost(this.isBJH);
            this.foP.cXs().setWriteImagesInfo(this.writeImagesInfo);
            this.foP.cXs().setVideoInfo(this.mVideoInfo);
            this.foP.xF(this.writeImagesInfo.size() > 0);
            WriteData cXs = this.foP.cXs();
            if (this.foO == null || !this.foO.chG()) {
                z = false;
            }
            cXs.setHasLocationData(z);
            if (str == null) {
                this.foP.cXs().setContent(this.mPostContent);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.foP.cXs().setVoice(this.mVoiceModel.getId());
                    this.foP.cXs().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.foP.cXs().setVoice(null);
                    this.foP.cXs().setVoiceDuringTime(-1);
                }
            } else {
                this.foP.cXs().setVoice(null);
                this.foP.cXs().setVoiceDuringTime(-1);
            }
            if (!this.foP.dLo()) {
                this.eGu.showToast(R.string.write_img_limit);
            } else if (this.foX == null || !this.foX.bzr()) {
                if (this.foW != null) {
                    this.foW.bzs();
                }
                c(this.foP.cXs());
                if (!this.foP.dLl()) {
                }
            }
        }
    }

    public TbPageContext btS() {
        return this.eGu;
    }

    public void Do(String str) {
        this.mPostContent = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int bzE() {
        return this.foU;
    }

    private void bzF() {
        if (byN() != null) {
            byN().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void N(ArrayList<String> arrayList) {
        if (byN() != null) {
            byN().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void Dp(String str) {
        if (byN() != null) {
            byN().b(new com.baidu.tbadk.editortools.a(44, 27, str));
        }
    }

    private void bzG() {
        if (byN() != null) {
            byN().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.foU = i;
        if (byN() != null) {
            byN().b(new com.baidu.tbadk.editortools.a(19, 27, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void Dq(String str) {
        if (byN() != null) {
            byN().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kn(boolean z) {
        if (byN() != null) {
            if (z) {
                byN().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                byN().b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
            byN().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.foV = dVar;
    }

    public void a(c cVar) {
        this.foW = cVar;
    }

    public void a(b bVar) {
        this.foX = bVar;
    }

    public void bzH() {
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            this.writeImagesInfo.clear();
        }
        if (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) {
            this.mVideoInfo = null;
        }
        byN().b(new com.baidu.tbadk.editortools.a(2, 19, null));
        setVoiceModel(null);
        byN().b(new com.baidu.tbadk.editortools.a(2, 6, null));
        byN().b(new com.baidu.tbadk.editortools.a(33, 6, null));
        if (!StringUtils.isNull(this.mPostContent)) {
            this.mPostContent = "";
        }
        Dq("");
        this.foP.e((WriteData) null);
        this.foP.xF(false);
    }

    public boolean bzI() {
        LinkedList<ImageFileInfo> chosedFiles;
        return (this.writeImagesInfo == null || (chosedFiles = this.writeImagesInfo.getChosedFiles()) == null || chosedFiles.isEmpty()) ? false : true;
    }

    public boolean bzJ() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    private void bzK() {
        if (this.fpa == null && byN() != null) {
            this.fpa = (f) byN().rI(27);
        }
    }

    public void bzL() {
        if (this.fpa != null && this.foZ != null) {
            this.fpa.c(this.foZ);
        }
    }

    public void a(TextWatcher textWatcher) {
        bzK();
        if (this.fpa != null && textWatcher != null) {
            this.fpa.b(textWatcher);
        }
    }

    public void bza() {
        if (this.fml != null) {
            this.fml.bza();
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
                while (ax.eNa.matcher(writeData.getContent()).find()) {
                    i2++;
                }
                if (i2 > 0 && this.mFrom > 0) {
                    ar arVar = new ar("c13990");
                    arVar.ak("obj_type", i2);
                    arVar.ak("obj_source", this.mFrom);
                    arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    arVar.dR("tid", writeData.getThreadId());
                    TiebaStatic.log(arVar);
                }
            }
            if (writeData.getWriteImagesInfo() != null && !y.isEmpty(writeData.getWriteImagesInfo().getChosedFiles())) {
                for (ImageFileInfo imageFileInfo : writeData.getWriteImagesInfo().getChosedFiles()) {
                    if (imageFileInfo.getImageType() == 1) {
                        i++;
                    }
                }
                if (i > 0 && this.mFrom > 0) {
                    ar arVar2 = new ar("c13991");
                    arVar2.ak("obj_type", i);
                    arVar2.ak("obj_source", this.mFrom);
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
}
