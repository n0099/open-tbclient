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
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.coreExtra.data.y;
import com.baidu.tbadk.editortools.BLauncher;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.v;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class e extends com.baidu.tbadk.editortools.d implements v.a {
    private bj Nl;
    private long authorId;
    private String authorName;
    private String authorNameShow;
    private TbPageContext cQU;
    private EditorTools drW;
    private String dtS;
    private LocationModel dtT;
    private NewWriteModel dtU;
    private ImageModel dtV;
    private DataModel<?> dtW;
    private ForumData dtX;
    private String dtY;
    private int dtZ;
    private NewWriteModel.d dua;
    private c dub;
    private b duc;
    private boolean dud;
    private TextWatcher due;
    private f duf;
    private LocationModel.a dug;
    private LocationModel.b duh;
    private final NewWriteModel.d dui;
    private final com.baidu.adp.base.d duj;
    public boolean isBJH;
    private String mPostContent;
    private String mThreadId;
    private VideoInfo mVideoInfo;
    private VoiceData.VoiceModel mVoiceModel;
    private String postId;
    private WriteImagesInfo writeImagesInfo;

    public e(EditorTools editorTools) {
        super(editorTools);
        this.writeImagesInfo = new WriteImagesInfo();
        this.mPostContent = "";
        this.dtU = null;
        this.dtV = null;
        this.mThreadId = null;
        this.dtY = null;
        this.dtZ = 0;
        this.dud = false;
        this.dug = new LocationModel.a() { // from class: com.baidu.tbadk.editortools.pb.e.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void aMt() {
                e.this.cQU.showToast(R.string.no_network_guide);
                e.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                TbPageContext tbPageContext = e.this.cQU;
                if (StringUtils.isNull(str)) {
                    str = e.this.aLC().getContext().getString(R.string.location_fail);
                }
                tbPageContext.showToast(str);
                e.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.cIY())) {
                    e.this.b(2, true, aVar.cIY());
                } else {
                    onFail(null);
                }
            }
        };
        this.duh = new LocationModel.b() { // from class: com.baidu.tbadk.editortools.pb.e.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void aMu() {
                e.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void uT(String str) {
                e.this.b(2, true, str);
            }
        };
        this.dui = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.e.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
                WriteData cFi = writeData == null ? e.this.dtU.cFi() : writeData;
                if (z) {
                    e.this.gx(true);
                    WriteData cFi2 = e.this.dtU.cFi();
                    e.this.resetData();
                    v.d(e.this.mThreadId, (WriteData) null);
                    if (cFi2 != null) {
                        if (cFi2.getType() == 2) {
                            v.a(cFi2.getThreadId(), e.this);
                        }
                    } else {
                        return;
                    }
                } else if (cFi != null && yVar != null && !TextUtils.isEmpty(yVar.aGQ())) {
                    cFi.setVcodeMD5(yVar.getVcode_md5());
                    cFi.setVcodeUrl(yVar.getVcode_pic_url());
                    cFi.setVcodeExtra(yVar.aGR());
                    if (e.this.Nl != null) {
                        cFi.setBaijiahaoData(e.this.Nl.getBaijiahaoData());
                    }
                    if (com.baidu.tbadk.s.a.vB(yVar.aGQ())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(e.this.cQU.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cFi, false, yVar.aGQ())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(e.this.cQU.getPageActivity(), cFi, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(e.this.cQU.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cFi, postWriteCallBackData.getAccessState())));
                }
                e.this.b(e.this.dtU.cFi());
                if (e.this.dua != null) {
                    e.this.dua.callback(z, postWriteCallBackData, yVar, cFi, antiData);
                }
            }
        };
        this.duj = new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.editortools.pb.e.7
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Bitmap) {
                    e.this.dtU.sC(true);
                }
            }
        };
        this.drW = editorTools;
    }

    public void md(int i) {
        if (this.duf == null && aLC() != null) {
            this.duf = (f) aLC().lX(27);
        }
        if (this.duf != null) {
            this.duf.setType(i);
        }
    }

    public void me(int i) {
        if (this.duf == null && aLC() != null) {
            this.duf = (f) aLC().lX(27);
        }
        if (this.duf != null) {
            this.duf.mf(i);
        }
    }

    public f aMb() {
        if (this.duf == null && aLC() != null) {
            this.duf = (f) aLC().lX(27);
        }
        return this.duf;
    }

    public void uO(String str) {
        if (this.duf == null && aLC() != null) {
            this.duf = (f) aLC().lX(27);
        }
        if (this.duf != null) {
            this.duf.setHint(str);
        }
    }

    public void gt(boolean z) {
        BLauncher bLauncher;
        if (aLC() != null && (bLauncher = (BLauncher) aLC().lU(5)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void gu(boolean z) {
        BLauncher bLauncher;
        if (aLC() != null && (bLauncher = (BLauncher) aLC().lU(23)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void gv(boolean z) {
        BLauncher bLauncher;
        if (aLC() != null && (bLauncher = (BLauncher) aLC().lU(2)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.dtW = dataModel;
    }

    public void a(TbPageContext tbPageContext) {
        this.cQU = tbPageContext;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.dtY = antiData.getVoice_message();
        }
    }

    public void a(ForumData forumData, UserData userData) {
        this.dtX = forumData;
    }

    public void setThreadData(bj bjVar) {
        this.Nl = bjVar;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (aLC() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.authorNameShow = metaData.getName_show();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void gw(boolean z) {
        this.dud = z;
    }

    public void aMc() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            if (String.valueOf(this.authorId).equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                l.showToast(this.cQU.getPageActivity(), (int) R.string.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.cQU.getPageActivity(), this.authorId, this.authorName, this.authorNameShow, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.f.b.toLong(this.mThreadId, 0L), com.baidu.adp.lib.f.b.toLong(this.postId, 0L))));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        if (i2 == -1) {
            switch (i) {
                case 11001:
                    a((String) null, (WriteData) null);
                    return;
                case RequestResponseCode.REQUEST_LOGIN_PB_AT /* 11025 */:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.cQU.getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_LOGIN_SUB_PB_AT /* 11026 */:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.cQU.getPageActivity(), RequestResponseCode.REQUEST_SUB_PB_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("camera_result", false)) {
                            T(intent);
                        } else {
                            V(intent);
                        }
                        aLC().invalidate();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_IMAGE_VIEW /* 12003 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("delete", false)) {
                            aMn();
                            this.dtU.sC(false);
                            return;
                        }
                        this.dtV.uN(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        E(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    WriteData cFi = this.dtU.cFi();
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (cFi != null) {
                        cFi.deleteUploadedTempImages();
                    }
                    this.dtU.d((WriteData) null);
                    this.dtU.sC(false);
                    this.mVoiceModel = null;
                    this.mVideoInfo = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        v.d(this.mThreadId, (WriteData) null);
                    }
                    gx(true);
                    if (this.dua != null) {
                        this.dua.callback(true, postWriteCallBackData, null, cFi, null);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    if (i == 12010) {
                        T(intent);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    U(intent);
                    return;
                case RequestResponseCode.REQUEST_RECORDER_VIDEO /* 13010 */:
                    if (aLC() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            an anVar = new an(TbadkCoreStatisticKey.XIAOYING_DURATION);
                            anVar.Z("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(anVar);
                            aMo();
                            aLC().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            aLC().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                        uR(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 12001:
                aMk();
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
                if (this.dua != null) {
                    this.dua.callback(false, postWriteCallBackData2, null, this.dtU.cFi(), null);
                    return;
                }
                return;
        }
    }

    public void aMd() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.cQU.getPageActivity())));
    }

    public void aMe() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.cQU.getPageActivity())) {
            this.cQU.showToast(R.string.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            aMg();
        } else if (this.dtT.cJf()) {
            aMd();
        } else {
            this.dtT.sA(false);
            b(1, true, null);
            this.dtT.cJd();
        }
    }

    public void aMf() {
        if (!this.isBJH && this.dtT != null && !com.baidu.tieba.tbadkCore.location.c.cJa().cJb() && UtilHelper.isSystemLocationProviderEnabled(this.cQU.getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared()) {
            this.dtT.cJd();
        }
    }

    private void aMg() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cQU.getPageActivity());
        aVar.jF(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    e.this.b(1, true, null);
                    e.this.dtT.cJh();
                } else {
                    e.this.dug.aMt();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                e.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(this.cQU);
        aVar.aBW();
    }

    public void aMh() {
        if (this.dtT.boD()) {
            if (this.dtT.cJf()) {
                this.dug.a(com.baidu.tieba.tbadkCore.location.c.cJa().getLocationData());
                return;
            }
            if (l.isNetOk()) {
                this.dtT.cJd();
            }
            b(0, true, null);
            return;
        }
        b(0, false, null);
    }

    public boolean aMi() {
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
        this.dtU.d((WriteData) null);
        this.dtU.sC(false);
        this.mVoiceModel = null;
        this.mVideoInfo = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void aMj() {
        this.mVideoInfo = null;
    }

    private void T(Intent intent) {
        this.dtS = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.dtS;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.cQU.getPageActivity(), l.getEquipmentWidth(this.cQU.getPageActivity())), l.dip2px(this.cQU.getPageActivity(), l.getEquipmentHeight(this.cQU.getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    m.a("cameras", this.dtS, rotateBitmapBydegree, 100);
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

    private void U(Intent intent) {
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
        if (this.dtX != null) {
            threadData.setForumId(this.dtX.getId());
            threadData.setForumName(this.dtX.getName());
            threadData.setFirstDir(this.dtX.getFirst_class());
            threadData.setSecondDir(this.dtX.getSecond_class());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        threadData.isBJH = this.isBJH;
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.dtY);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.cQU.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void c(p pVar) {
        if (pVar != null) {
            if (pVar.aGJ() == EmotionGroupType.BIG_EMOTION || pVar.aGJ() == EmotionGroupType.USER_COLLECT) {
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setImageType(1);
                imageFileInfo.setFilePath(pVar.getName());
                imageFileInfo.width = pVar.getWidth();
                imageFileInfo.height = pVar.getHeight();
                this.writeImagesInfo.addChooseFile(imageFileInfo);
                this.writeImagesInfo.updateQuality();
            }
        }
    }

    private void aMk() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tbadk.editortools.pb.e.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                m.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + e.this.dtS));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void V(Intent intent) {
        b(intent, true);
    }

    public void saveDraft(String str) {
        WriteData cFi = this.dtU.cFi();
        if (cFi == null) {
            cFi = new WriteData(1);
            cFi.setThreadId(str);
            cFi.setWriteImagesInfo(this.writeImagesInfo);
        }
        cFi.setContent(this.mPostContent);
        cFi.setVideoInfo(this.mVideoInfo);
        cFi.setVoiceModel(this.mVoiceModel);
        v.d(str, cFi);
    }

    public void uP(String str) {
        v.a(str, this);
    }

    @Override // com.baidu.tieba.tbadkCore.v.a
    public void a(WriteData writeData) {
        if (writeData != null) {
            if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                if (this.mVideoInfo == null) {
                    this.mVideoInfo = new VideoInfo();
                }
                this.mVideoInfo.copy(writeData.getVideoInfo());
                aMo();
                aLC().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                    aLC().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                aLC().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            if (writeData.getVoiceModel() != null && writeData.getVoiceModel().voiceId != null && writeData.getVoiceModel().duration != -1) {
                if (this.mVoiceModel == null) {
                    this.mVoiceModel = new VoiceData.VoiceModel();
                }
                this.mVoiceModel.copy(writeData.getVoiceModel());
            }
            if (!aq.isEmpty(writeData.getContent()) && aq.isEmpty(this.mPostContent)) {
                this.mPostContent = writeData.getContent();
                uS(this.mPostContent);
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
                    aLC().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                aLC().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.mPostContent = writeData.getContent();
            uS(this.mPostContent);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.dtU.cancelLoadData();
        this.dtV.cancelLoadData();
        this.dtT.cancelLoadData();
    }

    public void a(TbPageContext tbPageContext, Bundle bundle) {
        this.dtU = new NewWriteModel(tbPageContext);
        this.dtU.b(this.dui);
        this.dtV = new ImageModel(tbPageContext);
        this.dtV.setLoadDataCallBack(this.duj);
        this.dtT = new LocationModel(tbPageContext);
        this.dtT.a(this.dug);
        this.dtT.a(this.duh);
        if (bundle != null) {
            this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
            this.dtS = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(this.isBJH ? 1 : 9);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && aLC() != null) {
            aLC().b(new com.baidu.tbadk.editortools.a(2, 12, HanziToPinyin.Token.SEPARATOR));
        }
        if (!this.dtT.boD() && aLC() != null) {
            aLC().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            aLC().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.writeImagesInfo != null) {
            bundle.putString(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.dtS);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.dtU.cFi() == null) {
            WriteData uM = this.dtW.uM(str);
            if (uM != null && this.Nl != null) {
                uM.setBaijiahaoData(this.Nl.getBaijiahaoData());
            }
            this.dtU.d(uM);
        }
        if (this.dtU.cFi() != null) {
            if (this.dud) {
                this.dtU.cFi().setCanNoForum(true);
                if (this.dtX != null) {
                    this.dtU.cFi().setVForumId(this.dtX.getId());
                    this.dtU.cFi().setVForumName(this.dtX.getName());
                }
            } else {
                this.dtU.cFi().setCanNoForum(false);
                this.dtU.cFi().setVForumId("");
                this.dtU.cFi().setVForumName("");
            }
            this.dtU.cFi().setIsBJHPost(this.isBJH);
            this.dtU.cFi().setWriteImagesInfo(this.writeImagesInfo);
            this.dtU.cFi().setVideoInfo(this.mVideoInfo);
            this.dtU.sC(this.writeImagesInfo.size() > 0);
            WriteData cFi = this.dtU.cFi();
            if (this.dtT == null || !this.dtT.boD()) {
                z = false;
            }
            cFi.setHasLocationData(z);
            if (str == null) {
                this.dtU.cFi().setContent(this.mPostContent);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.dtU.cFi().setVoice(this.mVoiceModel.getId());
                    this.dtU.cFi().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.dtU.cFi().setVoice(null);
                    this.dtU.cFi().setVoiceDuringTime(-1);
                }
            } else {
                this.dtU.cFi().setVoice(null);
                this.dtU.cFi().setVoiceDuringTime(-1);
            }
            if (!this.dtU.cJJ()) {
                this.cQU.showToast(R.string.write_img_limit);
            } else if (this.duc == null || !this.duc.aLZ()) {
                if (this.dub != null) {
                    this.dub.aMa();
                }
                if (!this.dtU.cJG()) {
                }
            }
        }
    }

    public BaseFragmentActivity aMl() {
        return (BaseFragmentActivity) this.cQU.getPageActivity();
    }

    public void uQ(String str) {
        this.mPostContent = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int aMm() {
        return this.dtZ;
    }

    private void aMn() {
        if (aLC() != null) {
            aLC().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void E(ArrayList<String> arrayList) {
        if (aLC() != null) {
            aLC().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void uR(String str) {
        if (aLC() != null) {
            aLC().b(new com.baidu.tbadk.editortools.a(44, 27, str));
        }
    }

    private void aMo() {
        if (aLC() != null) {
            aLC().b(new com.baidu.tbadk.editortools.a(2, 19, HanziToPinyin.Token.SEPARATOR));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.dtZ = i;
        if (aLC() != null) {
            aLC().b(new com.baidu.tbadk.editortools.a(19, 27, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void uS(String str) {
        if (aLC() != null) {
            aLC().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gx(boolean z) {
        if (aLC() != null) {
            if (z) {
                aLC().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                aLC().b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
            aLC().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.dua = dVar;
    }

    public void a(c cVar) {
        this.dub = cVar;
    }

    public void a(b bVar) {
        this.duc = bVar;
    }

    public boolean aMp() {
        LinkedList<ImageFileInfo> chosedFiles;
        return (this.writeImagesInfo == null || (chosedFiles = this.writeImagesInfo.getChosedFiles()) == null || chosedFiles.isEmpty()) ? false : true;
    }

    public boolean aMq() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    private void aMr() {
        if (this.duf == null && aLC() != null) {
            this.duf = (f) aLC().lX(27);
        }
    }

    public void aMs() {
        if (this.duf != null && this.due != null) {
            this.duf.d(this.due);
        }
    }

    public void b(TextWatcher textWatcher) {
        aMr();
        if (this.duf != null && textWatcher != null) {
            this.duf.c(textWatcher);
        }
    }

    public void aLM() {
        if (this.drW != null) {
            this.drW.aLM();
        }
    }
}
