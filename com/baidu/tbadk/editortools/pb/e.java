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
import com.baidu.tbadk.coreExtra.data.aa;
import com.baidu.tbadk.coreExtra.data.q;
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
/* loaded from: classes8.dex */
public class e extends com.baidu.tbadk.editortools.d implements v.a {
    private bj NQ;
    private long authorId;
    private String authorName;
    private String authorNameShow;
    private TbPageContext cVi;
    private EditorTools dwC;
    private ImageModel dyA;
    private DataModel<?> dyB;
    private ForumData dyC;
    private String dyD;
    private int dyE;
    private NewWriteModel.d dyF;
    private c dyG;
    private b dyH;
    private boolean dyI;
    private TextWatcher dyJ;
    private f dyK;
    private LocationModel.a dyL;
    private LocationModel.b dyM;
    private final NewWriteModel.d dyN;
    private final com.baidu.adp.base.d dyO;
    private String dyx;
    private LocationModel dyy;
    private NewWriteModel dyz;
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
        this.dyz = null;
        this.dyA = null;
        this.mThreadId = null;
        this.dyD = null;
        this.dyE = 0;
        this.dyI = false;
        this.dyL = new LocationModel.a() { // from class: com.baidu.tbadk.editortools.pb.e.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void aPl() {
                e.this.cVi.showToast(R.string.no_network_guide);
                e.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                TbPageContext tbPageContext = e.this.cVi;
                if (StringUtils.isNull(str)) {
                    str = e.this.aOu().getContext().getString(R.string.location_fail);
                }
                tbPageContext.showToast(str);
                e.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.cLF())) {
                    e.this.a(2, true, aVar.cLF());
                } else {
                    onFail(null);
                }
            }
        };
        this.dyM = new LocationModel.b() { // from class: com.baidu.tbadk.editortools.pb.e.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void aPm() {
                e.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void vq(String str) {
                e.this.a(2, true, str);
            }
        };
        this.dyN = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.e.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
                WriteData cHV = writeData == null ? e.this.dyz.cHV() : writeData;
                if (z) {
                    e.this.gJ(true);
                    WriteData cHV2 = e.this.dyz.cHV();
                    e.this.resetData();
                    v.d(e.this.mThreadId, (WriteData) null);
                    if (cHV2 != null) {
                        if (cHV2.getType() == 2) {
                            v.a(cHV2.getThreadId(), e.this);
                        }
                    } else {
                        return;
                    }
                } else if (cHV != null && aaVar != null && !TextUtils.isEmpty(aaVar.aJG())) {
                    cHV.setVcodeMD5(aaVar.getVcode_md5());
                    cHV.setVcodeUrl(aaVar.getVcode_pic_url());
                    cHV.setVcodeExtra(aaVar.aJH());
                    if (e.this.NQ != null) {
                        cHV.setBaijiahaoData(e.this.NQ.getBaijiahaoData());
                    }
                    if (com.baidu.tbadk.s.a.wb(aaVar.aJG())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(e.this.cVi.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cHV, false, aaVar.aJG())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(e.this.cVi.getPageActivity(), cHV, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(e.this.cVi.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cHV, postWriteCallBackData.getAccessState())));
                }
                e.this.b(e.this.dyz.cHV());
                if (e.this.dyF != null) {
                    e.this.dyF.callback(z, postWriteCallBackData, aaVar, cHV, antiData);
                }
            }
        };
        this.dyO = new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.editortools.pb.e.7
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Bitmap) {
                    e.this.dyz.sS(true);
                }
            }
        };
        this.dwC = editorTools;
    }

    public void mv(int i) {
        if (this.dyK == null && aOu() != null) {
            this.dyK = (f) aOu().mp(27);
        }
        if (this.dyK != null) {
            this.dyK.setType(i);
        }
    }

    public void mw(int i) {
        if (this.dyK == null && aOu() != null) {
            this.dyK = (f) aOu().mp(27);
        }
        if (this.dyK != null) {
            this.dyK.mx(i);
        }
    }

    public f aOT() {
        if (this.dyK == null && aOu() != null) {
            this.dyK = (f) aOu().mp(27);
        }
        return this.dyK;
    }

    public void vl(String str) {
        if (this.dyK == null && aOu() != null) {
            this.dyK = (f) aOu().mp(27);
        }
        if (this.dyK != null) {
            this.dyK.setHint(str);
        }
    }

    public void gF(boolean z) {
        BLauncher bLauncher;
        if (aOu() != null && (bLauncher = (BLauncher) aOu().mm(5)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void gG(boolean z) {
        BLauncher bLauncher;
        if (aOu() != null && (bLauncher = (BLauncher) aOu().mm(23)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void gH(boolean z) {
        BLauncher bLauncher;
        if (aOu() != null && (bLauncher = (BLauncher) aOu().mm(2)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.dyB = dataModel;
    }

    public void a(TbPageContext tbPageContext) {
        this.cVi = tbPageContext;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.dyD = antiData.getVoice_message();
        }
    }

    public void a(ForumData forumData, UserData userData) {
        this.dyC = forumData;
    }

    public void setThreadData(bj bjVar) {
        this.NQ = bjVar;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (aOu() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.authorNameShow = metaData.getName_show();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void gI(boolean z) {
        this.dyI = z;
    }

    public void aOU() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            if (String.valueOf(this.authorId).equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                l.showToast(this.cVi.getPageActivity(), (int) R.string.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.cVi.getPageActivity(), this.authorId, this.authorName, this.authorNameShow, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.f.b.toLong(this.mThreadId, 0L), com.baidu.adp.lib.f.b.toLong(this.postId, 0L))));
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.cVi.getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_LOGIN_SUB_PB_AT /* 11026 */:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.cVi.getPageActivity(), RequestResponseCode.REQUEST_SUB_PB_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("camera_result", false)) {
                            T(intent);
                        } else {
                            V(intent);
                        }
                        aOu().invalidate();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_IMAGE_VIEW /* 12003 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("delete", false)) {
                            aPf();
                            this.dyz.sS(false);
                            return;
                        }
                        this.dyA.vk(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        G(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    WriteData cHV = this.dyz.cHV();
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (cHV != null) {
                        cHV.deleteUploadedTempImages();
                    }
                    this.dyz.d((WriteData) null);
                    this.dyz.sS(false);
                    this.mVoiceModel = null;
                    this.mVideoInfo = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        v.d(this.mThreadId, (WriteData) null);
                    }
                    gJ(true);
                    if (this.dyF != null) {
                        this.dyF.callback(true, postWriteCallBackData, null, cHV, null);
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
                    if (aOu() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            an anVar = new an(TbadkCoreStatisticKey.XIAOYING_DURATION);
                            anVar.X("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(anVar);
                            aPg();
                            aOu().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            aOu().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                        vo(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 12001:
                aPc();
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
                if (this.dyF != null) {
                    this.dyF.callback(false, postWriteCallBackData2, null, this.dyz.cHV(), null);
                    return;
                }
                return;
        }
    }

    public void aOV() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.cVi.getPageActivity())));
    }

    public void aOW() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.cVi.getPageActivity())) {
            this.cVi.showToast(R.string.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            aOY();
        } else if (this.dyy.cLM()) {
            aOV();
        } else {
            this.dyy.sQ(false);
            a(1, true, (String) null);
            this.dyy.cLK();
        }
    }

    public void aOX() {
        if (!this.isBJH && this.dyy != null && !com.baidu.tieba.tbadkCore.location.c.cLH().cLI() && UtilHelper.isSystemLocationProviderEnabled(this.cVi.getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared()) {
            this.dyy.cLK();
        }
    }

    private void aOY() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVi.getPageActivity());
        aVar.jW(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    e.this.a(1, true, (String) null);
                    e.this.dyy.cLO();
                } else {
                    e.this.dyL.aPl();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                e.this.a(0, true, (String) null);
                aVar2.dismiss();
            }
        }).b(this.cVi);
        aVar.aEC();
    }

    public void aOZ() {
        if (this.dyy.brm()) {
            if (this.dyy.cLM()) {
                this.dyL.a(com.baidu.tieba.tbadkCore.location.c.cLH().getLocationData());
                return;
            }
            if (l.isNetOk()) {
                this.dyy.cLK();
            }
            a(0, true, (String) null);
            return;
        }
        a(0, false, (String) null);
    }

    public boolean aPa() {
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
        this.dyz.d((WriteData) null);
        this.dyz.sS(false);
        this.mVoiceModel = null;
        this.mVideoInfo = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void aPb() {
        this.mVideoInfo = null;
    }

    private void T(Intent intent) {
        this.dyx = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.dyx;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.cVi.getPageActivity(), l.getEquipmentWidth(this.cVi.getPageActivity())), l.dip2px(this.cVi.getPageActivity(), l.getEquipmentHeight(this.cVi.getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    m.a("cameras", this.dyx, rotateBitmapBydegree, 100);
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
        if (this.dyC != null) {
            threadData.setForumId(this.dyC.getId());
            threadData.setForumName(this.dyC.getName());
            threadData.setFirstDir(this.dyC.getFirst_class());
            threadData.setSecondDir(this.dyC.getSecond_class());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        threadData.isBJH = this.isBJH;
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.dyD);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.cVi.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void c(q qVar) {
        if (qVar != null) {
            if (qVar.aJx() == EmotionGroupType.BIG_EMOTION || qVar.aJx() == EmotionGroupType.USER_COLLECT) {
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setImageType(1);
                imageFileInfo.setFilePath(qVar.getName());
                imageFileInfo.width = qVar.getWidth();
                imageFileInfo.height = qVar.getHeight();
                this.writeImagesInfo.addChooseFile(imageFileInfo);
                this.writeImagesInfo.updateQuality();
            }
        }
    }

    private void aPc() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tbadk.editortools.pb.e.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                m.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + e.this.dyx));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void V(Intent intent) {
        b(intent, true);
    }

    public void saveDraft(String str) {
        WriteData cHV = this.dyz.cHV();
        if (cHV == null) {
            cHV = new WriteData(1);
            cHV.setThreadId(str);
            cHV.setWriteImagesInfo(this.writeImagesInfo);
        }
        cHV.setContent(this.mPostContent);
        cHV.setVideoInfo(this.mVideoInfo);
        cHV.setVoiceModel(this.mVoiceModel);
        v.d(str, cHV);
    }

    public void vm(String str) {
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
                aPg();
                aOu().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                    aOu().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                aOu().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            if (writeData.getVoiceModel() != null && writeData.getVoiceModel().voiceId != null && writeData.getVoiceModel().duration != -1) {
                if (this.mVoiceModel == null) {
                    this.mVoiceModel = new VoiceData.VoiceModel();
                }
                this.mVoiceModel.copy(writeData.getVoiceModel());
            }
            if (!aq.isEmpty(writeData.getContent()) && aq.isEmpty(this.mPostContent)) {
                this.mPostContent = writeData.getContent();
                vp(this.mPostContent);
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
                    aOu().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                aOu().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.mPostContent = writeData.getContent();
            vp(this.mPostContent);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.dyz.cancelLoadData();
        this.dyA.cancelLoadData();
        this.dyy.cancelLoadData();
    }

    public void a(TbPageContext tbPageContext, Bundle bundle) {
        this.dyz = new NewWriteModel(tbPageContext);
        this.dyz.b(this.dyN);
        this.dyA = new ImageModel(tbPageContext);
        this.dyA.setLoadDataCallBack(this.dyO);
        this.dyy = new LocationModel(tbPageContext);
        this.dyy.a(this.dyL);
        this.dyy.a(this.dyM);
        if (bundle != null) {
            this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
            this.dyx = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(this.isBJH ? 1 : 9);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && aOu() != null) {
            aOu().b(new com.baidu.tbadk.editortools.a(2, 12, HanziToPinyin.Token.SEPARATOR));
        }
        if (!this.dyy.brm() && aOu() != null) {
            aOu().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            aOu().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.writeImagesInfo != null) {
            bundle.putString(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.dyx);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.dyz.cHV() == null) {
            WriteData vj = this.dyB.vj(str);
            if (vj != null && this.NQ != null) {
                vj.setBaijiahaoData(this.NQ.getBaijiahaoData());
            }
            this.dyz.d(vj);
        }
        if (this.dyz.cHV() != null) {
            if (this.dyI) {
                this.dyz.cHV().setCanNoForum(true);
                if (this.dyC != null) {
                    this.dyz.cHV().setVForumId(this.dyC.getId());
                    this.dyz.cHV().setVForumName(this.dyC.getName());
                }
            } else {
                this.dyz.cHV().setCanNoForum(false);
                this.dyz.cHV().setVForumId("");
                this.dyz.cHV().setVForumName("");
            }
            this.dyz.cHV().setIsBJHPost(this.isBJH);
            this.dyz.cHV().setWriteImagesInfo(this.writeImagesInfo);
            this.dyz.cHV().setVideoInfo(this.mVideoInfo);
            this.dyz.sS(this.writeImagesInfo.size() > 0);
            WriteData cHV = this.dyz.cHV();
            if (this.dyy == null || !this.dyy.brm()) {
                z = false;
            }
            cHV.setHasLocationData(z);
            if (str == null) {
                this.dyz.cHV().setContent(this.mPostContent);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.dyz.cHV().setVoice(this.mVoiceModel.getId());
                    this.dyz.cHV().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.dyz.cHV().setVoice(null);
                    this.dyz.cHV().setVoiceDuringTime(-1);
                }
            } else {
                this.dyz.cHV().setVoice(null);
                this.dyz.cHV().setVoiceDuringTime(-1);
            }
            if (!this.dyz.cMn()) {
                this.cVi.showToast(R.string.write_img_limit);
            } else if (this.dyH == null || !this.dyH.aOR()) {
                if (this.dyG != null) {
                    this.dyG.aOS();
                }
                if (!this.dyz.cMk()) {
                }
            }
        }
    }

    public BaseFragmentActivity aPd() {
        return (BaseFragmentActivity) this.cVi.getPageActivity();
    }

    public void vn(String str) {
        this.mPostContent = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int aPe() {
        return this.dyE;
    }

    private void aPf() {
        if (aOu() != null) {
            aOu().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void G(ArrayList<String> arrayList) {
        if (aOu() != null) {
            aOu().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void vo(String str) {
        if (aOu() != null) {
            aOu().b(new com.baidu.tbadk.editortools.a(44, 27, str));
        }
    }

    private void aPg() {
        if (aOu() != null) {
            aOu().b(new com.baidu.tbadk.editortools.a(2, 19, HanziToPinyin.Token.SEPARATOR));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.dyE = i;
        if (aOu() != null) {
            aOu().b(new com.baidu.tbadk.editortools.a(19, 27, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void vp(String str) {
        if (aOu() != null) {
            aOu().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gJ(boolean z) {
        if (aOu() != null) {
            if (z) {
                aOu().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                aOu().b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
            aOu().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.dyF = dVar;
    }

    public void a(c cVar) {
        this.dyG = cVar;
    }

    public void a(b bVar) {
        this.dyH = bVar;
    }

    public boolean aPh() {
        LinkedList<ImageFileInfo> chosedFiles;
        return (this.writeImagesInfo == null || (chosedFiles = this.writeImagesInfo.getChosedFiles()) == null || chosedFiles.isEmpty()) ? false : true;
    }

    public boolean aPi() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    private void aPj() {
        if (this.dyK == null && aOu() != null) {
            this.dyK = (f) aOu().mp(27);
        }
    }

    public void aPk() {
        if (this.dyK != null && this.dyJ != null) {
            this.dyK.d(this.dyJ);
        }
    }

    public void b(TextWatcher textWatcher) {
        aPj();
        if (this.dyK != null && textWatcher != null) {
            this.dyK.c(textWatcher);
        }
    }

    public void aOE() {
        if (this.dwC != null) {
            this.dwC.aOE();
        }
    }
}
