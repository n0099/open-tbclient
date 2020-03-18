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
import com.baidu.tieba.tbadkCore.w;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes8.dex */
public class e extends com.baidu.tbadk.editortools.d implements w.a {
    private bj NR;
    private long authorId;
    private String authorName;
    private String authorNameShow;
    private TbPageContext cVv;
    private EditorTools dwP;
    private String dyK;
    private LocationModel dyL;
    private NewWriteModel dyM;
    private ImageModel dyN;
    private DataModel<?> dyO;
    private ForumData dyP;
    private String dyQ;
    private int dyR;
    private NewWriteModel.d dyS;
    private c dyT;
    private b dyU;
    private boolean dyV;
    private TextWatcher dyW;
    private f dyX;
    private LocationModel.a dyY;
    private LocationModel.b dyZ;
    private final NewWriteModel.d dza;
    private final com.baidu.adp.base.d dzb;
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
        this.dyM = null;
        this.dyN = null;
        this.mThreadId = null;
        this.dyQ = null;
        this.dyR = 0;
        this.dyV = false;
        this.dyY = new LocationModel.a() { // from class: com.baidu.tbadk.editortools.pb.e.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void aPp() {
                e.this.cVv.showToast(R.string.no_network_guide);
                e.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                TbPageContext tbPageContext = e.this.cVv;
                if (StringUtils.isNull(str)) {
                    str = e.this.aOy().getContext().getString(R.string.location_fail);
                }
                tbPageContext.showToast(str);
                e.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.cLZ())) {
                    e.this.a(2, true, aVar.cLZ());
                } else {
                    onFail(null);
                }
            }
        };
        this.dyZ = new LocationModel.b() { // from class: com.baidu.tbadk.editortools.pb.e.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void aPq() {
                e.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void vp(String str) {
                e.this.a(2, true, str);
            }
        };
        this.dza = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.e.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
                WriteData cIp = writeData == null ? e.this.dyM.cIp() : writeData;
                if (z) {
                    e.this.gK(true);
                    WriteData cIp2 = e.this.dyM.cIp();
                    e.this.resetData();
                    w.d(e.this.mThreadId, (WriteData) null);
                    if (cIp2 != null) {
                        if (cIp2.getType() == 2) {
                            w.a(cIp2.getThreadId(), e.this);
                        }
                    } else {
                        return;
                    }
                } else if (cIp != null && aaVar != null && !TextUtils.isEmpty(aaVar.aJK())) {
                    cIp.setVcodeMD5(aaVar.getVcode_md5());
                    cIp.setVcodeUrl(aaVar.getVcode_pic_url());
                    cIp.setVcodeExtra(aaVar.aJL());
                    if (e.this.NR != null) {
                        cIp.setBaijiahaoData(e.this.NR.getBaijiahaoData());
                    }
                    if (com.baidu.tbadk.s.a.wb(aaVar.aJK())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(e.this.cVv.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cIp, false, aaVar.aJK())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(e.this.cVv.getPageActivity(), cIp, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(e.this.cVv.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cIp, postWriteCallBackData.getAccessState())));
                }
                e.this.b(e.this.dyM.cIp());
                if (e.this.dyS != null) {
                    e.this.dyS.callback(z, postWriteCallBackData, aaVar, cIp, antiData);
                }
            }
        };
        this.dzb = new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.editortools.pb.e.7
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Bitmap) {
                    e.this.dyM.sY(true);
                }
            }
        };
        this.dwP = editorTools;
    }

    public void mx(int i) {
        if (this.dyX == null && aOy() != null) {
            this.dyX = (f) aOy().mr(27);
        }
        if (this.dyX != null) {
            this.dyX.setType(i);
        }
    }

    public void my(int i) {
        if (this.dyX == null && aOy() != null) {
            this.dyX = (f) aOy().mr(27);
        }
        if (this.dyX != null) {
            this.dyX.mz(i);
        }
    }

    public f aOX() {
        if (this.dyX == null && aOy() != null) {
            this.dyX = (f) aOy().mr(27);
        }
        return this.dyX;
    }

    public void vk(String str) {
        if (this.dyX == null && aOy() != null) {
            this.dyX = (f) aOy().mr(27);
        }
        if (this.dyX != null) {
            this.dyX.setHint(str);
        }
    }

    public void gG(boolean z) {
        BLauncher bLauncher;
        if (aOy() != null && (bLauncher = (BLauncher) aOy().mo(5)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void gH(boolean z) {
        BLauncher bLauncher;
        if (aOy() != null && (bLauncher = (BLauncher) aOy().mo(23)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void gI(boolean z) {
        BLauncher bLauncher;
        if (aOy() != null && (bLauncher = (BLauncher) aOy().mo(2)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.dyO = dataModel;
    }

    public void a(TbPageContext tbPageContext) {
        this.cVv = tbPageContext;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.dyQ = antiData.getVoice_message();
        }
    }

    public void a(ForumData forumData, UserData userData) {
        this.dyP = forumData;
    }

    public void setThreadData(bj bjVar) {
        this.NR = bjVar;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (aOy() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.authorNameShow = metaData.getName_show();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void gJ(boolean z) {
        this.dyV = z;
    }

    public void aOY() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            if (String.valueOf(this.authorId).equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                l.showToast(this.cVv.getPageActivity(), (int) R.string.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.cVv.getPageActivity(), this.authorId, this.authorName, this.authorNameShow, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.f.b.toLong(this.mThreadId, 0L), com.baidu.adp.lib.f.b.toLong(this.postId, 0L))));
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.cVv.getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_LOGIN_SUB_PB_AT /* 11026 */:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.cVv.getPageActivity(), RequestResponseCode.REQUEST_SUB_PB_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("camera_result", false)) {
                            T(intent);
                        } else {
                            V(intent);
                        }
                        aOy().invalidate();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_IMAGE_VIEW /* 12003 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("delete", false)) {
                            aPj();
                            this.dyM.sY(false);
                            return;
                        }
                        this.dyN.vj(intent.getStringExtra("file_name"));
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
                    WriteData cIp = this.dyM.cIp();
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (cIp != null) {
                        cIp.deleteUploadedTempImages();
                    }
                    this.dyM.d((WriteData) null);
                    this.dyM.sY(false);
                    this.mVoiceModel = null;
                    this.mVideoInfo = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        w.d(this.mThreadId, (WriteData) null);
                    }
                    gK(true);
                    if (this.dyS != null) {
                        this.dyS.callback(true, postWriteCallBackData, null, cIp, null);
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
                    if (aOy() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            an anVar = new an(TbadkCoreStatisticKey.XIAOYING_DURATION);
                            anVar.X("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(anVar);
                            aPk();
                            aOy().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            aOy().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                        vn(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 12001:
                aPg();
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
                if (this.dyS != null) {
                    this.dyS.callback(false, postWriteCallBackData2, null, this.dyM.cIp(), null);
                    return;
                }
                return;
        }
    }

    public void aOZ() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.cVv.getPageActivity())));
    }

    public void aPa() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.cVv.getPageActivity())) {
            this.cVv.showToast(R.string.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            aPc();
        } else if (this.dyL.cMg()) {
            aOZ();
        } else {
            this.dyL.sW(false);
            a(1, true, (String) null);
            this.dyL.cMe();
        }
    }

    public void aPb() {
        if (!this.isBJH && this.dyL != null && !com.baidu.tieba.tbadkCore.location.c.cMb().cMc() && UtilHelper.isSystemLocationProviderEnabled(this.cVv.getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared()) {
            this.dyL.cMe();
        }
    }

    private void aPc() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVv.getPageActivity());
        aVar.jW(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    e.this.a(1, true, (String) null);
                    e.this.dyL.cMi();
                } else {
                    e.this.dyY.aPp();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                e.this.a(0, true, (String) null);
                aVar2.dismiss();
            }
        }).b(this.cVv);
        aVar.aEG();
    }

    public void aPd() {
        if (this.dyL.brr()) {
            if (this.dyL.cMg()) {
                this.dyY.a(com.baidu.tieba.tbadkCore.location.c.cMb().getLocationData());
                return;
            }
            if (l.isNetOk()) {
                this.dyL.cMe();
            }
            a(0, true, (String) null);
            return;
        }
        a(0, false, (String) null);
    }

    public boolean aPe() {
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
        this.dyM.d((WriteData) null);
        this.dyM.sY(false);
        this.mVoiceModel = null;
        this.mVideoInfo = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void aPf() {
        this.mVideoInfo = null;
    }

    private void T(Intent intent) {
        this.dyK = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.dyK;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.cVv.getPageActivity(), l.getEquipmentWidth(this.cVv.getPageActivity())), l.dip2px(this.cVv.getPageActivity(), l.getEquipmentHeight(this.cVv.getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    m.a("cameras", this.dyK, rotateBitmapBydegree, 100);
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
        if (this.dyP != null) {
            threadData.setForumId(this.dyP.getId());
            threadData.setForumName(this.dyP.getName());
            threadData.setFirstDir(this.dyP.getFirst_class());
            threadData.setSecondDir(this.dyP.getSecond_class());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        threadData.isBJH = this.isBJH;
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.dyQ);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.cVv.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void c(q qVar) {
        if (qVar != null) {
            if (qVar.aJB() == EmotionGroupType.BIG_EMOTION || qVar.aJB() == EmotionGroupType.USER_COLLECT) {
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

    private void aPg() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tbadk.editortools.pb.e.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                m.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + e.this.dyK));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void V(Intent intent) {
        b(intent, true);
    }

    public void saveDraft(String str) {
        WriteData cIp = this.dyM.cIp();
        if (cIp == null) {
            cIp = new WriteData(1);
            cIp.setThreadId(str);
            cIp.setWriteImagesInfo(this.writeImagesInfo);
        }
        cIp.setContent(this.mPostContent);
        cIp.setVideoInfo(this.mVideoInfo);
        cIp.setVoiceModel(this.mVoiceModel);
        w.d(str, cIp);
    }

    public void vl(String str) {
        w.a(str, this);
    }

    @Override // com.baidu.tieba.tbadkCore.w.a
    public void a(WriteData writeData) {
        if (writeData != null) {
            if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                if (this.mVideoInfo == null) {
                    this.mVideoInfo = new VideoInfo();
                }
                this.mVideoInfo.copy(writeData.getVideoInfo());
                aPk();
                aOy().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                    aOy().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                aOy().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            if (writeData.getVoiceModel() != null && writeData.getVoiceModel().voiceId != null && writeData.getVoiceModel().duration != -1) {
                if (this.mVoiceModel == null) {
                    this.mVoiceModel = new VoiceData.VoiceModel();
                }
                this.mVoiceModel.copy(writeData.getVoiceModel());
            }
            if (!aq.isEmpty(writeData.getContent()) && aq.isEmpty(this.mPostContent)) {
                this.mPostContent = writeData.getContent();
                vo(this.mPostContent);
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
                    aOy().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                aOy().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.mPostContent = writeData.getContent();
            vo(this.mPostContent);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.dyM.cancelLoadData();
        this.dyN.cancelLoadData();
        this.dyL.cancelLoadData();
    }

    public void a(TbPageContext tbPageContext, Bundle bundle) {
        this.dyM = new NewWriteModel(tbPageContext);
        this.dyM.b(this.dza);
        this.dyN = new ImageModel(tbPageContext);
        this.dyN.setLoadDataCallBack(this.dzb);
        this.dyL = new LocationModel(tbPageContext);
        this.dyL.a(this.dyY);
        this.dyL.a(this.dyZ);
        if (bundle != null) {
            this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
            this.dyK = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(this.isBJH ? 1 : 9);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && aOy() != null) {
            aOy().b(new com.baidu.tbadk.editortools.a(2, 12, HanziToPinyin.Token.SEPARATOR));
        }
        if (!this.dyL.brr() && aOy() != null) {
            aOy().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            aOy().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.writeImagesInfo != null) {
            bundle.putString(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.dyK);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.dyM.cIp() == null) {
            WriteData vi = this.dyO.vi(str);
            if (vi != null && this.NR != null) {
                vi.setBaijiahaoData(this.NR.getBaijiahaoData());
            }
            this.dyM.d(vi);
        }
        if (this.dyM.cIp() != null) {
            if (this.dyV) {
                this.dyM.cIp().setCanNoForum(true);
                if (this.dyP != null) {
                    this.dyM.cIp().setVForumId(this.dyP.getId());
                    this.dyM.cIp().setVForumName(this.dyP.getName());
                }
            } else {
                this.dyM.cIp().setCanNoForum(false);
                this.dyM.cIp().setVForumId("");
                this.dyM.cIp().setVForumName("");
            }
            this.dyM.cIp().setIsBJHPost(this.isBJH);
            this.dyM.cIp().setWriteImagesInfo(this.writeImagesInfo);
            this.dyM.cIp().setVideoInfo(this.mVideoInfo);
            this.dyM.sY(this.writeImagesInfo.size() > 0);
            WriteData cIp = this.dyM.cIp();
            if (this.dyL == null || !this.dyL.brr()) {
                z = false;
            }
            cIp.setHasLocationData(z);
            if (str == null) {
                this.dyM.cIp().setContent(this.mPostContent);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.dyM.cIp().setVoice(this.mVoiceModel.getId());
                    this.dyM.cIp().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.dyM.cIp().setVoice(null);
                    this.dyM.cIp().setVoiceDuringTime(-1);
                }
            } else {
                this.dyM.cIp().setVoice(null);
                this.dyM.cIp().setVoiceDuringTime(-1);
            }
            if (!this.dyM.cMH()) {
                this.cVv.showToast(R.string.write_img_limit);
            } else if (this.dyU == null || !this.dyU.aOV()) {
                if (this.dyT != null) {
                    this.dyT.aOW();
                }
                if (!this.dyM.cME()) {
                }
            }
        }
    }

    public BaseFragmentActivity aPh() {
        return (BaseFragmentActivity) this.cVv.getPageActivity();
    }

    public void vm(String str) {
        this.mPostContent = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int aPi() {
        return this.dyR;
    }

    private void aPj() {
        if (aOy() != null) {
            aOy().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void G(ArrayList<String> arrayList) {
        if (aOy() != null) {
            aOy().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void vn(String str) {
        if (aOy() != null) {
            aOy().b(new com.baidu.tbadk.editortools.a(44, 27, str));
        }
    }

    private void aPk() {
        if (aOy() != null) {
            aOy().b(new com.baidu.tbadk.editortools.a(2, 19, HanziToPinyin.Token.SEPARATOR));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.dyR = i;
        if (aOy() != null) {
            aOy().b(new com.baidu.tbadk.editortools.a(19, 27, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void vo(String str) {
        if (aOy() != null) {
            aOy().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gK(boolean z) {
        if (aOy() != null) {
            if (z) {
                aOy().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                aOy().b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
            aOy().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.dyS = dVar;
    }

    public void a(c cVar) {
        this.dyT = cVar;
    }

    public void a(b bVar) {
        this.dyU = bVar;
    }

    public boolean aPl() {
        LinkedList<ImageFileInfo> chosedFiles;
        return (this.writeImagesInfo == null || (chosedFiles = this.writeImagesInfo.getChosedFiles()) == null || chosedFiles.isEmpty()) ? false : true;
    }

    public boolean aPm() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    private void aPn() {
        if (this.dyX == null && aOy() != null) {
            this.dyX = (f) aOy().mr(27);
        }
    }

    public void aPo() {
        if (this.dyX != null && this.dyW != null) {
            this.dyX.d(this.dyW);
        }
    }

    public void b(TextWatcher textWatcher) {
        aPn();
        if (this.dyX != null && textWatcher != null) {
            this.dyX.c(textWatcher);
        }
    }

    public void aOI() {
        if (this.dwP != null) {
            this.dwP.aOI();
        }
    }
}
