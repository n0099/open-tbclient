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
/* loaded from: classes20.dex */
public class e extends com.baidu.tbadk.editortools.e implements x.a {
    private bw ajX;
    protected long authorId;
    protected String authorName;
    protected String authorNameShow;
    private EditorTools eMH;
    private String ePi;
    protected LocationModel ePj;
    protected NewWriteModel ePk;
    protected ImageModel ePl;
    private DataModel<?> ePm;
    protected ForumData ePn;
    protected String ePo;
    private int ePp;
    protected NewWriteModel.d ePq;
    private c ePr;
    protected b ePs;
    protected boolean ePt;
    private TextWatcher ePu;
    private f ePv;
    private LocationModel.a ePw;
    private LocationModel.b ePx;
    private final NewWriteModel.d ePy;
    private final com.baidu.adp.base.d ePz;
    protected TbPageContext ehG;
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
        this.ePk = null;
        this.ePl = null;
        this.mThreadId = null;
        this.ePo = null;
        this.ePp = 0;
        this.ePt = false;
        this.mFrom = 0;
        this.ePw = new LocationModel.a() { // from class: com.baidu.tbadk.editortools.pb.e.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void btu() {
                e.this.ehG.showToast(R.string.no_network_guide);
                e.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                TbPageContext tbPageContext = e.this.ehG;
                if (StringUtils.isNull(str)) {
                    str = e.this.bsv().getContext().getString(R.string.location_fail);
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
        this.ePx = new LocationModel.b() { // from class: com.baidu.tbadk.editortools.pb.e.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void btv() {
                e.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void Cz(String str) {
                e.this.a(2, true, str);
            }
        };
        this.ePy = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.e.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                WriteData cOG = writeData == null ? e.this.ePk.cOG() : writeData;
                if (z) {
                    e.this.js(true);
                    WriteData cOG2 = e.this.ePk.cOG();
                    e.this.resetData();
                    x.f(e.this.mThreadId, (WriteData) null);
                    if (cOG2 != null) {
                        if (cOG2.getType() == 2) {
                            x.a(cOG2.getThreadId(), e.this);
                        }
                    } else {
                        return;
                    }
                } else if (cOG != null && ahVar != null && !TextUtils.isEmpty(ahVar.bnS())) {
                    cOG.setVcodeMD5(ahVar.getVcode_md5());
                    cOG.setVcodeUrl(ahVar.getVcode_pic_url());
                    cOG.setVcodeExtra(ahVar.bnT());
                    if (e.this.ajX != null) {
                        cOG.setBaijiahaoData(e.this.ajX.getBaijiahaoData());
                    }
                    if (com.baidu.tbadk.t.a.Dl(ahVar.bnS())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(e.this.ehG.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cOG, false, ahVar.bnS())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(e.this.ehG.getPageActivity(), cOG, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(e.this.ehG.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cOG, postWriteCallBackData.getAccessState())));
                }
                e.this.b(e.this.ePk.cOG());
                if (e.this.ePq != null) {
                    e.this.ePq.callback(z, postWriteCallBackData, ahVar, cOG, antiData);
                }
            }
        };
        this.ePz = new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.editortools.pb.e.7
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Bitmap) {
                    e.this.ePk.wr(true);
                }
            }
        };
        this.eMH = editorTools;
    }

    public void qB(int i) {
        if (this.ePv == null && bsv() != null) {
            this.ePv = (f) bsv().qr(27);
        }
        if (this.ePv != null) {
            this.ePv.setType(i);
        }
    }

    public void qC(int i) {
        if (this.ePv == null && bsv() != null) {
            this.ePv = (f) bsv().qr(27);
        }
        if (this.ePv != null) {
            this.ePv.qD(i);
        }
    }

    public f btb() {
        if (this.ePv == null && bsv() != null) {
            this.ePv = (f) bsv().qr(27);
        }
        return this.ePv;
    }

    public void Ct(String str) {
        if (this.ePv == null && bsv() != null) {
            this.ePv = (f) bsv().qr(27);
        }
        if (this.ePv != null) {
            this.ePv.setHint(str);
        }
    }

    public void jo(boolean z) {
        BLauncher bLauncher;
        if (bsv() != null && (bLauncher = (BLauncher) bsv().qo(5)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void jp(boolean z) {
        BLauncher bLauncher;
        if (bsv() != null && (bLauncher = (BLauncher) bsv().qo(23)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void jq(boolean z) {
        BLauncher bLauncher;
        if (bsv() != null && (bLauncher = (BLauncher) bsv().qo(2)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.ePm = dataModel;
    }

    public void setThreadId(String str) {
        this.mThreadId = str;
    }

    public void a(TbPageContext tbPageContext) {
        this.ehG = tbPageContext;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.ePo = antiData.getVoice_message();
        }
    }

    public void a(ForumData forumData, UserData userData) {
        this.ePn = forumData;
    }

    public void setThreadData(bw bwVar) {
        this.ajX = bwVar;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (bsv() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.authorNameShow = metaData.getName_show();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void jr(boolean z) {
        this.ePt = z;
    }

    public void btc() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            if (String.valueOf(this.authorId).equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                l.showToast(this.ehG.getPageActivity(), R.string.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.ehG.getPageActivity(), this.authorId, this.authorName, this.authorNameShow, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.f.b.toLong(this.mThreadId, 0L), com.baidu.adp.lib.f.b.toLong(this.postId, 0L))));
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.ehG.getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_LOGIN_SUB_PB_AT /* 11026 */:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.ehG.getPageActivity(), RequestResponseCode.REQUEST_SUB_PB_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("camera_result", false)) {
                            E(intent);
                        } else {
                            G(intent);
                        }
                        bsv().invalidate();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_IMAGE_VIEW /* 12003 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("delete", false)) {
                            btn();
                            this.ePk.wr(false);
                            return;
                        }
                        this.ePl.Cs(intent.getStringExtra("file_name"));
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
                    WriteData cOG = this.ePk.cOG();
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (cOG != null) {
                        cOG.deleteUploadedTempImages();
                    }
                    this.ePk.e((WriteData) null);
                    this.ePk.wr(false);
                    this.mVoiceModel = null;
                    this.mVideoInfo = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        x.f(this.mThreadId, (WriteData) null);
                    }
                    js(true);
                    if (this.ePq != null) {
                        this.ePq.callback(true, postWriteCallBackData, null, cOG, null);
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
                    if (bsv() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            aq aqVar = new aq(TbadkCoreStatisticKey.XIAOYING_DURATION);
                            aqVar.ai("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(aqVar);
                            bto();
                            bsv().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            bsv().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                        Cx(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case RequestResponseCode.REQUEST_CAMERA /* 12001 */:
                btl();
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
                if (this.ePq != null) {
                    this.ePq.callback(false, postWriteCallBackData2, null, this.ePk.cOG(), null);
                    return;
                }
                return;
        }
    }

    public void btd() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.ehG.getPageActivity())));
    }

    public void bte() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.ehG.getPageActivity())) {
            this.ehG.showToast(R.string.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bth();
        } else if (this.ePj.dBl()) {
            btd();
        } else {
            this.ePj.wp(false);
            a(1, true, (String) null);
            this.ePj.dBj();
        }
    }

    public void btf() {
        if (!ae.checkLocationForGoogle(this.ehG.getPageActivity())) {
            ae.c(this.ehG.getPageActivity(), 0);
        } else {
            bte();
        }
    }

    public void btg() {
        if (!this.isBJH && this.ePj != null && !com.baidu.tieba.tbadkCore.location.b.dBg().dBh() && UtilHelper.isSystemLocationProviderEnabled(this.ehG.getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared()) {
            this.ePj.dBj();
        }
    }

    private void bth() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ehG.getPageActivity());
        aVar.nE(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    e.this.a(1, true, (String) null);
                    e.this.ePj.dBn();
                } else {
                    e.this.ePw.btu();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                e.this.a(0, true, (String) null);
                aVar2.dismiss();
            }
        }).b(this.ehG);
        aVar.bia();
    }

    public void bti() {
        if (this.ePj.bZh()) {
            if (this.ePj.dBl()) {
                this.ePw.a(com.baidu.tieba.tbadkCore.location.b.dBg().getLocationData());
                return;
            }
            if (l.isNetOk()) {
                this.ePj.dBj();
            }
            a(0, true, (String) null);
            return;
        }
        a(0, false, (String) null);
    }

    public boolean btj() {
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
        this.ePk.e((WriteData) null);
        this.ePk.wr(false);
        this.mVoiceModel = null;
        this.mVideoInfo = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void btk() {
        this.mVideoInfo = null;
    }

    private void E(Intent intent) {
        this.ePi = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.ePi;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.ehG.getPageActivity(), l.getEquipmentWidth(this.ehG.getPageActivity())), l.dip2px(this.ehG.getPageActivity(), l.getEquipmentHeight(this.ehG.getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    n.a("cameras", this.ePi, rotateBitmapBydegree, 100);
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
        if (this.ePn != null) {
            threadData.setForumId(this.ePn.getId());
            threadData.setForumName(this.ePn.getName());
            threadData.setFirstDir(this.ePn.getFirst_class());
            threadData.setSecondDir(this.ePn.getSecond_class());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        threadData.isBJH = this.isBJH;
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.ePo);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.ehG.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void c(u uVar) {
        if (uVar != null) {
            if (uVar.bnJ() == EmotionGroupType.BIG_EMOTION || uVar.bnJ() == EmotionGroupType.USER_COLLECT) {
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

    private void btl() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tbadk.editortools.pb.e.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                n.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + e.this.ePi));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void G(Intent intent) {
        a(intent, true);
    }

    public void Cu(String str) {
        WriteData cOG = this.ePk.cOG();
        if (cOG == null) {
            cOG = new WriteData(1);
            cOG.setThreadId(str);
            cOG.setWriteImagesInfo(this.writeImagesInfo);
        }
        cOG.setContent(this.mPostContent);
        cOG.setVideoInfo(this.mVideoInfo);
        cOG.setVoiceModel(this.mVoiceModel);
        x.f(str, cOG);
    }

    public void Cv(String str) {
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
                bto();
                bsv().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                    bsv().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                bsv().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            if (writeData.getVoiceModel() != null && writeData.getVoiceModel().voiceId != null && writeData.getVoiceModel().duration != -1) {
                if (this.mVoiceModel == null) {
                    this.mVoiceModel = new VoiceData.VoiceModel();
                }
                this.mVoiceModel.copy(writeData.getVoiceModel());
            }
            if (!at.isEmpty(writeData.getContent()) && at.isEmpty(this.mPostContent)) {
                this.mPostContent = writeData.getContent();
                Cy(this.mPostContent);
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
                    bsv().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                bsv().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.mPostContent = writeData.getContent();
            Cy(this.mPostContent);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.ePk.cancelLoadData();
        this.ePl.cancelLoadData();
        this.ePj.cancelLoadData();
    }

    public void a(TbPageContext tbPageContext, Bundle bundle) {
        this.ePk = new NewWriteModel(tbPageContext);
        this.ePk.b(this.ePy);
        this.ePl = new ImageModel(tbPageContext);
        this.ePl.setLoadDataCallBack(this.ePz);
        this.ePj = new LocationModel(tbPageContext);
        this.ePj.a(this.ePw);
        this.ePj.a(this.ePx);
        if (bundle != null) {
            this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
            this.ePi = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(this.isBJH ? 1 : 9);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && bsv() != null) {
            bsv().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.ePj.bZh() && bsv() != null) {
            bsv().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            bsv().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.writeImagesInfo != null) {
            bundle.putString(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.ePi);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.ePk.cOG() == null) {
            WriteData Cr = this.ePm.Cr(str);
            if (Cr != null && this.ajX != null) {
                Cr.setBaijiahaoData(this.ajX.getBaijiahaoData());
            }
            this.ePk.e(Cr);
        }
        if (this.ePk.cOG() != null) {
            this.ePk.setSpanGroupManager(this.mSpanGroupManager);
            if (this.ePt) {
                this.ePk.cOG().setCanNoForum(true);
                if (this.ePn != null) {
                    this.ePk.cOG().setVForumId(this.ePn.getId());
                    this.ePk.cOG().setVForumName(this.ePn.getName());
                }
            } else {
                this.ePk.cOG().setCanNoForum(false);
                this.ePk.cOG().setVForumId("");
                this.ePk.cOG().setVForumName("");
            }
            this.ePk.cOG().setIsBJHPost(this.isBJH);
            this.ePk.cOG().setWriteImagesInfo(this.writeImagesInfo);
            this.ePk.cOG().setVideoInfo(this.mVideoInfo);
            this.ePk.wr(this.writeImagesInfo.size() > 0);
            WriteData cOG = this.ePk.cOG();
            if (this.ePj == null || !this.ePj.bZh()) {
                z = false;
            }
            cOG.setHasLocationData(z);
            if (str == null) {
                this.ePk.cOG().setContent(this.mPostContent);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.ePk.cOG().setVoice(this.mVoiceModel.getId());
                    this.ePk.cOG().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.ePk.cOG().setVoice(null);
                    this.ePk.cOG().setVoiceDuringTime(-1);
                }
            } else {
                this.ePk.cOG().setVoice(null);
                this.ePk.cOG().setVoiceDuringTime(-1);
            }
            if (!this.ePk.dBT()) {
                this.ehG.showToast(R.string.write_img_limit);
            } else if (this.ePs == null || !this.ePs.bsZ()) {
                if (this.ePr != null) {
                    this.ePr.bta();
                }
                c(this.ePk.cOG());
                if (!this.ePk.dBQ()) {
                }
            }
        }
    }

    public TbPageContext bnz() {
        return this.ehG;
    }

    public void Cw(String str) {
        this.mPostContent = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int btm() {
        return this.ePp;
    }

    private void btn() {
        if (bsv() != null) {
            bsv().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void N(ArrayList<String> arrayList) {
        if (bsv() != null) {
            bsv().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void Cx(String str) {
        if (bsv() != null) {
            bsv().b(new com.baidu.tbadk.editortools.a(44, 27, str));
        }
    }

    private void bto() {
        if (bsv() != null) {
            bsv().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.ePp = i;
        if (bsv() != null) {
            bsv().b(new com.baidu.tbadk.editortools.a(19, 27, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void Cy(String str) {
        if (bsv() != null) {
            bsv().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void js(boolean z) {
        if (bsv() != null) {
            if (z) {
                bsv().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                bsv().b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
            bsv().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.ePq = dVar;
    }

    public void a(c cVar) {
        this.ePr = cVar;
    }

    public void a(b bVar) {
        this.ePs = bVar;
    }

    public void btp() {
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            this.writeImagesInfo.clear();
        }
        if (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) {
            this.mVideoInfo = null;
        }
        bsv().b(new com.baidu.tbadk.editortools.a(2, 19, null));
        setVoiceModel(null);
        bsv().b(new com.baidu.tbadk.editortools.a(2, 6, null));
        bsv().b(new com.baidu.tbadk.editortools.a(33, 6, null));
        if (!StringUtils.isNull(this.mPostContent)) {
            this.mPostContent = "";
        }
        Cy("");
        this.ePk.e((WriteData) null);
        this.ePk.wr(false);
    }

    public boolean btq() {
        LinkedList<ImageFileInfo> chosedFiles;
        return (this.writeImagesInfo == null || (chosedFiles = this.writeImagesInfo.getChosedFiles()) == null || chosedFiles.isEmpty()) ? false : true;
    }

    public boolean btr() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    private void bts() {
        if (this.ePv == null && bsv() != null) {
            this.ePv = (f) bsv().qr(27);
        }
    }

    public void btt() {
        if (this.ePv != null && this.ePu != null) {
            this.ePv.c(this.ePu);
        }
    }

    public void a(TextWatcher textWatcher) {
        bts();
        if (this.ePv != null && textWatcher != null) {
            this.ePv.b(textWatcher);
        }
    }

    public void bsI() {
        if (this.eMH != null) {
            this.eMH.bsI();
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
                while (aw.enD.matcher(writeData.getContent()).find()) {
                    i2++;
                }
                if (i2 > 0 && this.mFrom > 0) {
                    aq aqVar = new aq("c13990");
                    aqVar.ai("obj_type", i2);
                    aqVar.ai("obj_source", this.mFrom);
                    aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar.dF("tid", writeData.getThreadId());
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
                    aqVar2.ai("obj_type", i);
                    aqVar2.ai("obj_source", this.mFrom);
                    aqVar2.dF("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar2.dF("tid", writeData.getThreadId());
                    TiebaStatic.log(aqVar2);
                }
            }
        }
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }
}
