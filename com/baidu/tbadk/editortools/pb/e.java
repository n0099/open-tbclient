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
    private bw ajz;
    protected long authorId;
    protected String authorName;
    protected String authorNameShow;
    private EditorTools eKq;
    private c eMA;
    protected b eMB;
    protected boolean eMC;
    private TextWatcher eMD;
    private f eME;
    private LocationModel.a eMF;
    private LocationModel.b eMG;
    private final NewWriteModel.d eMH;
    private final com.baidu.adp.base.d eMI;
    private String eMr;
    protected LocationModel eMs;
    protected NewWriteModel eMt;
    protected ImageModel eMu;
    private DataModel<?> eMv;
    protected ForumData eMw;
    protected String eMx;
    private int eMy;
    protected NewWriteModel.d eMz;
    protected TbPageContext efr;
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
        this.eMt = null;
        this.eMu = null;
        this.mThreadId = null;
        this.eMx = null;
        this.eMy = 0;
        this.eMC = false;
        this.eMF = new LocationModel.a() { // from class: com.baidu.tbadk.editortools.pb.e.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void bsq() {
                e.this.efr.showToast(R.string.no_network_guide);
                e.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                TbPageContext tbPageContext = e.this.efr;
                if (StringUtils.isNull(str)) {
                    str = e.this.brw().getContext().getString(R.string.location_fail);
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
        this.eMG = new LocationModel.b() { // from class: com.baidu.tbadk.editortools.pb.e.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void bsr() {
                e.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void Cd(String str) {
                e.this.a(2, true, str);
            }
        };
        this.eMH = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.e.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ag agVar, WriteData writeData, AntiData antiData) {
                WriteData cLa = writeData == null ? e.this.eMt.cLa() : writeData;
                if (z) {
                    e.this.jr(true);
                    WriteData cLa2 = e.this.eMt.cLa();
                    e.this.resetData();
                    x.f(e.this.mThreadId, (WriteData) null);
                    if (cLa2 != null) {
                        if (cLa2.getType() == 2) {
                            x.a(cLa2.getThreadId(), e.this);
                        }
                    } else {
                        return;
                    }
                } else if (cLa != null && agVar != null && !TextUtils.isEmpty(agVar.bmY())) {
                    cLa.setVcodeMD5(agVar.getVcode_md5());
                    cLa.setVcodeUrl(agVar.getVcode_pic_url());
                    cLa.setVcodeExtra(agVar.bmZ());
                    if (e.this.ajz != null) {
                        cLa.setBaijiahaoData(e.this.ajz.getBaijiahaoData());
                    }
                    if (com.baidu.tbadk.t.a.CP(agVar.bmY())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(e.this.efr.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cLa, false, agVar.bmY())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(e.this.efr.getPageActivity(), cLa, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(e.this.efr.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cLa, postWriteCallBackData.getAccessState())));
                }
                e.this.b(e.this.eMt.cLa());
                if (e.this.eMz != null) {
                    e.this.eMz.callback(z, postWriteCallBackData, agVar, cLa, antiData);
                }
            }
        };
        this.eMI = new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.editortools.pb.e.7
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Bitmap) {
                    e.this.eMt.wi(true);
                }
            }
        };
        this.eKq = editorTools;
    }

    public void qk(int i) {
        if (this.eME == null && brw() != null) {
            this.eME = (f) brw().qe(27);
        }
        if (this.eME != null) {
            this.eME.setType(i);
        }
    }

    public void ql(int i) {
        if (this.eME == null && brw() != null) {
            this.eME = (f) brw().qe(27);
        }
        if (this.eME != null) {
            this.eME.qm(i);
        }
    }

    public f brX() {
        if (this.eME == null && brw() != null) {
            this.eME = (f) brw().qe(27);
        }
        return this.eME;
    }

    public void BX(String str) {
        if (this.eME == null && brw() != null) {
            this.eME = (f) brw().qe(27);
        }
        if (this.eME != null) {
            this.eME.setHint(str);
        }
    }

    public void jn(boolean z) {
        BLauncher bLauncher;
        if (brw() != null && (bLauncher = (BLauncher) brw().qb(5)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void jo(boolean z) {
        BLauncher bLauncher;
        if (brw() != null && (bLauncher = (BLauncher) brw().qb(23)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void jp(boolean z) {
        BLauncher bLauncher;
        if (brw() != null && (bLauncher = (BLauncher) brw().qb(2)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.eMv = dataModel;
    }

    public void setThreadId(String str) {
        this.mThreadId = str;
    }

    public void a(TbPageContext tbPageContext) {
        this.efr = tbPageContext;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.eMx = antiData.getVoice_message();
        }
    }

    public void a(ForumData forumData, UserData userData) {
        this.eMw = forumData;
    }

    public void setThreadData(bw bwVar) {
        this.ajz = bwVar;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (brw() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.authorNameShow = metaData.getName_show();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void jq(boolean z) {
        this.eMC = z;
    }

    public void brY() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            if (String.valueOf(this.authorId).equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                l.showToast(this.efr.getPageActivity(), R.string.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.efr.getPageActivity(), this.authorId, this.authorName, this.authorNameShow, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.f.b.toLong(this.mThreadId, 0L), com.baidu.adp.lib.f.b.toLong(this.postId, 0L))));
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.efr.getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_LOGIN_SUB_PB_AT /* 11026 */:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.efr.getPageActivity(), RequestResponseCode.REQUEST_SUB_PB_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("camera_result", false)) {
                            E(intent);
                        } else {
                            G(intent);
                        }
                        brw().invalidate();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_IMAGE_VIEW /* 12003 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("delete", false)) {
                            bsj();
                            this.eMt.wi(false);
                            return;
                        }
                        this.eMu.BW(intent.getStringExtra("file_name"));
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
                    WriteData cLa = this.eMt.cLa();
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (cLa != null) {
                        cLa.deleteUploadedTempImages();
                    }
                    this.eMt.d((WriteData) null);
                    this.eMt.wi(false);
                    this.mVoiceModel = null;
                    this.mVideoInfo = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        x.f(this.mThreadId, (WriteData) null);
                    }
                    jr(true);
                    if (this.eMz != null) {
                        this.eMz.callback(true, postWriteCallBackData, null, cLa, null);
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
                    if (brw() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            aq aqVar = new aq(TbadkCoreStatisticKey.XIAOYING_DURATION);
                            aqVar.ai("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(aqVar);
                            bsk();
                            brw().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            brw().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                        Cb(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case RequestResponseCode.REQUEST_CAMERA /* 12001 */:
                bsh();
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
                if (this.eMz != null) {
                    this.eMz.callback(false, postWriteCallBackData2, null, this.eMt.cLa(), null);
                    return;
                }
                return;
        }
    }

    public void brZ() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.efr.getPageActivity())));
    }

    public void bsa() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.efr.getPageActivity())) {
            this.efr.showToast(R.string.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bsd();
        } else if (this.eMs.dxs()) {
            brZ();
        } else {
            this.eMs.wg(false);
            a(1, true, (String) null);
            this.eMs.dxq();
        }
    }

    public void bsb() {
        if (!ae.checkLocationForGoogle(this.efr.getPageActivity())) {
            ae.d(this.efr.getPageActivity(), 0);
        } else {
            bsa();
        }
    }

    public void bsc() {
        if (!this.isBJH && this.eMs != null && !com.baidu.tieba.tbadkCore.location.b.dxn().dxo() && UtilHelper.isSystemLocationProviderEnabled(this.efr.getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared()) {
            this.eMs.dxq();
        }
    }

    private void bsd() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.efr.getPageActivity());
        aVar.nt(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    e.this.a(1, true, (String) null);
                    e.this.eMs.dxu();
                } else {
                    e.this.eMF.bsq();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                e.this.a(0, true, (String) null);
                aVar2.dismiss();
            }
        }).b(this.efr);
        aVar.bhg();
    }

    public void bse() {
        if (this.eMs.bXA()) {
            if (this.eMs.dxs()) {
                this.eMF.a(com.baidu.tieba.tbadkCore.location.b.dxn().getLocationData());
                return;
            }
            if (l.isNetOk()) {
                this.eMs.dxq();
            }
            a(0, true, (String) null);
            return;
        }
        a(0, false, (String) null);
    }

    public boolean bsf() {
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
        this.eMt.d((WriteData) null);
        this.eMt.wi(false);
        this.mVoiceModel = null;
        this.mVideoInfo = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void bsg() {
        this.mVideoInfo = null;
    }

    private void E(Intent intent) {
        this.eMr = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.eMr;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.efr.getPageActivity(), l.getEquipmentWidth(this.efr.getPageActivity())), l.dip2px(this.efr.getPageActivity(), l.getEquipmentHeight(this.efr.getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    n.a("cameras", this.eMr, rotateBitmapBydegree, 100);
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
        if (this.eMw != null) {
            threadData.setForumId(this.eMw.getId());
            threadData.setForumName(this.eMw.getName());
            threadData.setFirstDir(this.eMw.getFirst_class());
            threadData.setSecondDir(this.eMw.getSecond_class());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        threadData.isBJH = this.isBJH;
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.eMx);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.efr.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
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

    private void bsh() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tbadk.editortools.pb.e.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                n.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + e.this.eMr));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void G(Intent intent) {
        a(intent, true);
    }

    public void BY(String str) {
        WriteData cLa = this.eMt.cLa();
        if (cLa == null) {
            cLa = new WriteData(1);
            cLa.setThreadId(str);
            cLa.setWriteImagesInfo(this.writeImagesInfo);
        }
        cLa.setContent(this.mPostContent);
        cLa.setVideoInfo(this.mVideoInfo);
        cLa.setVoiceModel(this.mVoiceModel);
        x.f(str, cLa);
    }

    public void BZ(String str) {
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
                bsk();
                brw().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                    brw().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                brw().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            if (writeData.getVoiceModel() != null && writeData.getVoiceModel().voiceId != null && writeData.getVoiceModel().duration != -1) {
                if (this.mVoiceModel == null) {
                    this.mVoiceModel = new VoiceData.VoiceModel();
                }
                this.mVoiceModel.copy(writeData.getVoiceModel());
            }
            if (!at.isEmpty(writeData.getContent()) && at.isEmpty(this.mPostContent)) {
                this.mPostContent = writeData.getContent();
                Cc(this.mPostContent);
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
                    brw().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                brw().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.mPostContent = writeData.getContent();
            Cc(this.mPostContent);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.eMt.cancelLoadData();
        this.eMu.cancelLoadData();
        this.eMs.cancelLoadData();
    }

    public void a(TbPageContext tbPageContext, Bundle bundle) {
        this.eMt = new NewWriteModel(tbPageContext);
        this.eMt.b(this.eMH);
        this.eMu = new ImageModel(tbPageContext);
        this.eMu.setLoadDataCallBack(this.eMI);
        this.eMs = new LocationModel(tbPageContext);
        this.eMs.a(this.eMF);
        this.eMs.a(this.eMG);
        if (bundle != null) {
            this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
            this.eMr = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(this.isBJH ? 1 : 9);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && brw() != null) {
            brw().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.eMs.bXA() && brw() != null) {
            brw().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            brw().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.writeImagesInfo != null) {
            bundle.putString(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.eMr);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.eMt.cLa() == null) {
            WriteData BV = this.eMv.BV(str);
            if (BV != null && this.ajz != null) {
                BV.setBaijiahaoData(this.ajz.getBaijiahaoData());
            }
            this.eMt.d(BV);
        }
        if (this.eMt.cLa() != null) {
            this.eMt.setSpanGroupManager(this.mSpanGroupManager);
            if (this.eMC) {
                this.eMt.cLa().setCanNoForum(true);
                if (this.eMw != null) {
                    this.eMt.cLa().setVForumId(this.eMw.getId());
                    this.eMt.cLa().setVForumName(this.eMw.getName());
                }
            } else {
                this.eMt.cLa().setCanNoForum(false);
                this.eMt.cLa().setVForumId("");
                this.eMt.cLa().setVForumName("");
            }
            this.eMt.cLa().setIsBJHPost(this.isBJH);
            this.eMt.cLa().setWriteImagesInfo(this.writeImagesInfo);
            this.eMt.cLa().setVideoInfo(this.mVideoInfo);
            this.eMt.wi(this.writeImagesInfo.size() > 0);
            WriteData cLa = this.eMt.cLa();
            if (this.eMs == null || !this.eMs.bXA()) {
                z = false;
            }
            cLa.setHasLocationData(z);
            if (str == null) {
                this.eMt.cLa().setContent(this.mPostContent);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.eMt.cLa().setVoice(this.mVoiceModel.getId());
                    this.eMt.cLa().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.eMt.cLa().setVoice(null);
                    this.eMt.cLa().setVoiceDuringTime(-1);
                }
            } else {
                this.eMt.cLa().setVoice(null);
                this.eMt.cLa().setVoiceDuringTime(-1);
            }
            if (!this.eMt.dya()) {
                this.efr.showToast(R.string.write_img_limit);
            } else if (this.eMB == null || !this.eMB.brV()) {
                if (this.eMA != null) {
                    this.eMA.brW();
                }
                if (!this.eMt.dxX()) {
                }
            }
        }
    }

    public TbPageContext bmF() {
        return this.efr;
    }

    public void Ca(String str) {
        this.mPostContent = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int bsi() {
        return this.eMy;
    }

    private void bsj() {
        if (brw() != null) {
            brw().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void N(ArrayList<String> arrayList) {
        if (brw() != null) {
            brw().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void Cb(String str) {
        if (brw() != null) {
            brw().b(new com.baidu.tbadk.editortools.a(44, 27, str));
        }
    }

    private void bsk() {
        if (brw() != null) {
            brw().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.eMy = i;
        if (brw() != null) {
            brw().b(new com.baidu.tbadk.editortools.a(19, 27, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void Cc(String str) {
        if (brw() != null) {
            brw().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jr(boolean z) {
        if (brw() != null) {
            if (z) {
                brw().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                brw().b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
            brw().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.eMz = dVar;
    }

    public void a(c cVar) {
        this.eMA = cVar;
    }

    public void a(b bVar) {
        this.eMB = bVar;
    }

    public void bsl() {
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            this.writeImagesInfo.clear();
        }
        if (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) {
            this.mVideoInfo = null;
        }
        brw().b(new com.baidu.tbadk.editortools.a(2, 19, null));
        setVoiceModel(null);
        brw().b(new com.baidu.tbadk.editortools.a(2, 6, null));
        brw().b(new com.baidu.tbadk.editortools.a(33, 6, null));
        if (!StringUtils.isNull(this.mPostContent)) {
            this.mPostContent = "";
        }
        Cc("");
        this.eMt.d((WriteData) null);
        this.eMt.wi(false);
    }

    public boolean bsm() {
        LinkedList<ImageFileInfo> chosedFiles;
        return (this.writeImagesInfo == null || (chosedFiles = this.writeImagesInfo.getChosedFiles()) == null || chosedFiles.isEmpty()) ? false : true;
    }

    public boolean bsn() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    private void bso() {
        if (this.eME == null && brw() != null) {
            this.eME = (f) brw().qe(27);
        }
    }

    public void bsp() {
        if (this.eME != null && this.eMD != null) {
            this.eME.c(this.eMD);
        }
    }

    public void a(TextWatcher textWatcher) {
        bso();
        if (this.eME != null && textWatcher != null) {
            this.eME.b(textWatcher);
        }
    }

    public void brH() {
        if (this.eKq != null) {
            this.eKq.brH();
        }
    }

    public void setSpanGroupManager(SpanGroupManager spanGroupManager) {
        this.mSpanGroupManager = spanGroupManager;
    }
}
