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
import com.baidu.tbadk.core.data.bk;
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
    private bk ahg;
    private long authorId;
    private String authorName;
    private String authorNameShow;
    private TbPageContext dIF;
    private EditorTools ekK;
    private String emF;
    private LocationModel emG;
    private NewWriteModel emH;
    private ImageModel emI;
    private DataModel<?> emJ;
    private ForumData emK;
    private String emL;
    private int emM;
    private NewWriteModel.d emN;
    private c emO;
    private b emP;
    private boolean emQ;
    private TextWatcher emR;
    private f emS;
    private LocationModel.a emT;
    private LocationModel.b emU;
    private final NewWriteModel.d emV;
    private final com.baidu.adp.base.d emW;
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
        this.emH = null;
        this.emI = null;
        this.mThreadId = null;
        this.emL = null;
        this.emM = 0;
        this.emQ = false;
        this.emT = new LocationModel.a() { // from class: com.baidu.tbadk.editortools.pb.e.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void bdN() {
                e.this.dIF.showToast(R.string.no_network_guide);
                e.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                TbPageContext tbPageContext = e.this.dIF;
                if (StringUtils.isNull(str)) {
                    str = e.this.bcW().getContext().getString(R.string.location_fail);
                }
                tbPageContext.showToast(str);
                e.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.dea())) {
                    e.this.a(2, true, aVar.dea());
                } else {
                    onFail(null);
                }
            }
        };
        this.emU = new LocationModel.b() { // from class: com.baidu.tbadk.editortools.pb.e.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void bdO() {
                e.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void yn(String str) {
                e.this.a(2, true, str);
            }
        };
        this.emV = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.e.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
                WriteData cZP = writeData == null ? e.this.emH.cZP() : writeData;
                if (z) {
                    e.this.ie(true);
                    WriteData cZP2 = e.this.emH.cZP();
                    e.this.resetData();
                    w.e(e.this.mThreadId, (WriteData) null);
                    if (cZP2 != null) {
                        if (cZP2.getType() == 2) {
                            w.a(cZP2.getThreadId(), e.this);
                        }
                    } else {
                        return;
                    }
                } else if (cZP != null && aaVar != null && !TextUtils.isEmpty(aaVar.aYl())) {
                    cZP.setVcodeMD5(aaVar.getVcode_md5());
                    cZP.setVcodeUrl(aaVar.getVcode_pic_url());
                    cZP.setVcodeExtra(aaVar.aYm());
                    if (e.this.ahg != null) {
                        cZP.setBaijiahaoData(e.this.ahg.getBaijiahaoData());
                    }
                    if (com.baidu.tbadk.s.a.yX(aaVar.aYl())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(e.this.dIF.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cZP, false, aaVar.aYl())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(e.this.dIF.getPageActivity(), cZP, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(e.this.dIF.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cZP, postWriteCallBackData.getAccessState())));
                }
                e.this.b(e.this.emH.cZP());
                if (e.this.emN != null) {
                    e.this.emN.callback(z, postWriteCallBackData, aaVar, cZP, antiData);
                }
            }
        };
        this.emW = new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.editortools.pb.e.7
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Bitmap) {
                    e.this.emH.uy(true);
                }
            }
        };
        this.ekK = editorTools;
    }

    public void nl(int i) {
        if (this.emS == null && bcW() != null) {
            this.emS = (f) bcW().nf(27);
        }
        if (this.emS != null) {
            this.emS.setType(i);
        }
    }

    public void nm(int i) {
        if (this.emS == null && bcW() != null) {
            this.emS = (f) bcW().nf(27);
        }
        if (this.emS != null) {
            this.emS.nn(i);
        }
    }

    public f bdv() {
        if (this.emS == null && bcW() != null) {
            this.emS = (f) bcW().nf(27);
        }
        return this.emS;
    }

    public void yh(String str) {
        if (this.emS == null && bcW() != null) {
            this.emS = (f) bcW().nf(27);
        }
        if (this.emS != null) {
            this.emS.setHint(str);
        }
    }

    public void ia(boolean z) {
        BLauncher bLauncher;
        if (bcW() != null && (bLauncher = (BLauncher) bcW().nc(5)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void ib(boolean z) {
        BLauncher bLauncher;
        if (bcW() != null && (bLauncher = (BLauncher) bcW().nc(23)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void ic(boolean z) {
        BLauncher bLauncher;
        if (bcW() != null && (bLauncher = (BLauncher) bcW().nc(2)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.emJ = dataModel;
    }

    public void a(TbPageContext tbPageContext) {
        this.dIF = tbPageContext;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.emL = antiData.getVoice_message();
        }
    }

    public void a(ForumData forumData, UserData userData) {
        this.emK = forumData;
    }

    public void setThreadData(bk bkVar) {
        this.ahg = bkVar;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (bcW() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.authorNameShow = metaData.getName_show();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void id(boolean z) {
        this.emQ = z;
    }

    public void bdw() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            if (String.valueOf(this.authorId).equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                l.showToast(this.dIF.getPageActivity(), (int) R.string.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.dIF.getPageActivity(), this.authorId, this.authorName, this.authorNameShow, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.f.b.toLong(this.mThreadId, 0L), com.baidu.adp.lib.f.b.toLong(this.postId, 0L))));
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.dIF.getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_LOGIN_SUB_PB_AT /* 11026 */:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.dIF.getPageActivity(), RequestResponseCode.REQUEST_SUB_PB_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("camera_result", false)) {
                            C(intent);
                        } else {
                            E(intent);
                        }
                        bcW().invalidate();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_IMAGE_VIEW /* 12003 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("delete", false)) {
                            bdH();
                            this.emH.uy(false);
                            return;
                        }
                        this.emI.yg(intent.getStringExtra("file_name"));
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
                    WriteData cZP = this.emH.cZP();
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (cZP != null) {
                        cZP.deleteUploadedTempImages();
                    }
                    this.emH.d((WriteData) null);
                    this.emH.uy(false);
                    this.mVoiceModel = null;
                    this.mVideoInfo = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        w.e(this.mThreadId, (WriteData) null);
                    }
                    ie(true);
                    if (this.emN != null) {
                        this.emN.callback(true, postWriteCallBackData, null, cZP, null);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    if (i == 12010) {
                        C(intent);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    D(intent);
                    return;
                case RequestResponseCode.REQUEST_RECORDER_VIDEO /* 13010 */:
                    if (bcW() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            an anVar = new an(TbadkCoreStatisticKey.XIAOYING_DURATION);
                            anVar.ag("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(anVar);
                            bdI();
                            bcW().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            bcW().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                        yl(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 12001:
                bdE();
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
                if (this.emN != null) {
                    this.emN.callback(false, postWriteCallBackData2, null, this.emH.cZP(), null);
                    return;
                }
                return;
        }
    }

    public void bdx() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.dIF.getPageActivity())));
    }

    public void bdy() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.dIF.getPageActivity())) {
            this.dIF.showToast(R.string.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bdA();
        } else if (this.emG.deh()) {
            bdx();
        } else {
            this.emG.uw(false);
            a(1, true, (String) null);
            this.emG.def();
        }
    }

    public void bdz() {
        if (!this.isBJH && this.emG != null && !com.baidu.tieba.tbadkCore.location.c.dec().ded() && UtilHelper.isSystemLocationProviderEnabled(this.dIF.getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared()) {
            this.emG.def();
        }
    }

    private void bdA() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dIF.getPageActivity());
        aVar.kD(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    e.this.a(1, true, (String) null);
                    e.this.emG.dej();
                } else {
                    e.this.emT.bdN();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                e.this.a(0, true, (String) null);
                aVar2.dismiss();
            }
        }).b(this.dIF);
        aVar.aST();
    }

    public void bdB() {
        if (this.emG.bHm()) {
            if (this.emG.deh()) {
                this.emT.a(com.baidu.tieba.tbadkCore.location.c.dec().getLocationData());
                return;
            }
            if (l.isNetOk()) {
                this.emG.def();
            }
            a(0, true, (String) null);
            return;
        }
        a(0, false, (String) null);
    }

    public boolean bdC() {
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
        this.emH.d((WriteData) null);
        this.emH.uy(false);
        this.mVoiceModel = null;
        this.mVideoInfo = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void bdD() {
        this.mVideoInfo = null;
    }

    private void C(Intent intent) {
        this.emF = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.emF;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.dIF.getPageActivity(), l.getEquipmentWidth(this.dIF.getPageActivity())), l.dip2px(this.dIF.getPageActivity(), l.getEquipmentHeight(this.dIF.getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    m.a("cameras", this.emF, rotateBitmapBydegree, 100);
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

    private void D(Intent intent) {
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
        if (this.emK != null) {
            threadData.setForumId(this.emK.getId());
            threadData.setForumName(this.emK.getName());
            threadData.setFirstDir(this.emK.getFirst_class());
            threadData.setSecondDir(this.emK.getSecond_class());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        threadData.isBJH = this.isBJH;
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.emL);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.dIF.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void c(q qVar) {
        if (qVar != null) {
            if (qVar.aYc() == EmotionGroupType.BIG_EMOTION || qVar.aYc() == EmotionGroupType.USER_COLLECT) {
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

    private void bdE() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tbadk.editortools.pb.e.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                m.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + e.this.emF));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void E(Intent intent) {
        b(intent, true);
    }

    public void yi(String str) {
        WriteData cZP = this.emH.cZP();
        if (cZP == null) {
            cZP = new WriteData(1);
            cZP.setThreadId(str);
            cZP.setWriteImagesInfo(this.writeImagesInfo);
        }
        cZP.setContent(this.mPostContent);
        cZP.setVideoInfo(this.mVideoInfo);
        cZP.setVoiceModel(this.mVoiceModel);
        w.e(str, cZP);
    }

    public void yj(String str) {
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
                bdI();
                bcW().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                    bcW().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                bcW().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            if (writeData.getVoiceModel() != null && writeData.getVoiceModel().voiceId != null && writeData.getVoiceModel().duration != -1) {
                if (this.mVoiceModel == null) {
                    this.mVoiceModel = new VoiceData.VoiceModel();
                }
                this.mVoiceModel.copy(writeData.getVoiceModel());
            }
            if (!aq.isEmpty(writeData.getContent()) && aq.isEmpty(this.mPostContent)) {
                this.mPostContent = writeData.getContent();
                ym(this.mPostContent);
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
                    bcW().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                bcW().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.mPostContent = writeData.getContent();
            ym(this.mPostContent);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.emH.cancelLoadData();
        this.emI.cancelLoadData();
        this.emG.cancelLoadData();
    }

    public void a(TbPageContext tbPageContext, Bundle bundle) {
        this.emH = new NewWriteModel(tbPageContext);
        this.emH.b(this.emV);
        this.emI = new ImageModel(tbPageContext);
        this.emI.setLoadDataCallBack(this.emW);
        this.emG = new LocationModel(tbPageContext);
        this.emG.a(this.emT);
        this.emG.a(this.emU);
        if (bundle != null) {
            this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
            this.emF = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(this.isBJH ? 1 : 9);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && bcW() != null) {
            bcW().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.emG.bHm() && bcW() != null) {
            bcW().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            bcW().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.writeImagesInfo != null) {
            bundle.putString(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.emF);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.emH.cZP() == null) {
            WriteData yf = this.emJ.yf(str);
            if (yf != null && this.ahg != null) {
                yf.setBaijiahaoData(this.ahg.getBaijiahaoData());
            }
            this.emH.d(yf);
        }
        if (this.emH.cZP() != null) {
            if (this.emQ) {
                this.emH.cZP().setCanNoForum(true);
                if (this.emK != null) {
                    this.emH.cZP().setVForumId(this.emK.getId());
                    this.emH.cZP().setVForumName(this.emK.getName());
                }
            } else {
                this.emH.cZP().setCanNoForum(false);
                this.emH.cZP().setVForumId("");
                this.emH.cZP().setVForumName("");
            }
            this.emH.cZP().setIsBJHPost(this.isBJH);
            this.emH.cZP().setWriteImagesInfo(this.writeImagesInfo);
            this.emH.cZP().setVideoInfo(this.mVideoInfo);
            this.emH.uy(this.writeImagesInfo.size() > 0);
            WriteData cZP = this.emH.cZP();
            if (this.emG == null || !this.emG.bHm()) {
                z = false;
            }
            cZP.setHasLocationData(z);
            if (str == null) {
                this.emH.cZP().setContent(this.mPostContent);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.emH.cZP().setVoice(this.mVoiceModel.getId());
                    this.emH.cZP().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.emH.cZP().setVoice(null);
                    this.emH.cZP().setVoiceDuringTime(-1);
                }
            } else {
                this.emH.cZP().setVoice(null);
                this.emH.cZP().setVoiceDuringTime(-1);
            }
            if (!this.emH.deQ()) {
                this.dIF.showToast(R.string.write_img_limit);
            } else if (this.emP == null || !this.emP.bdt()) {
                if (this.emO != null) {
                    this.emO.bdu();
                }
                if (!this.emH.deN()) {
                }
            }
        }
    }

    public BaseFragmentActivity bdF() {
        return (BaseFragmentActivity) this.dIF.getPageActivity();
    }

    public void yk(String str) {
        this.mPostContent = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int bdG() {
        return this.emM;
    }

    private void bdH() {
        if (bcW() != null) {
            bcW().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void G(ArrayList<String> arrayList) {
        if (bcW() != null) {
            bcW().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void yl(String str) {
        if (bcW() != null) {
            bcW().b(new com.baidu.tbadk.editortools.a(44, 27, str));
        }
    }

    private void bdI() {
        if (bcW() != null) {
            bcW().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.emM = i;
        if (bcW() != null) {
            bcW().b(new com.baidu.tbadk.editortools.a(19, 27, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void ym(String str) {
        if (bcW() != null) {
            bcW().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ie(boolean z) {
        if (bcW() != null) {
            if (z) {
                bcW().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                bcW().b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
            bcW().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.emN = dVar;
    }

    public void a(c cVar) {
        this.emO = cVar;
    }

    public void a(b bVar) {
        this.emP = bVar;
    }

    public boolean bdJ() {
        LinkedList<ImageFileInfo> chosedFiles;
        return (this.writeImagesInfo == null || (chosedFiles = this.writeImagesInfo.getChosedFiles()) == null || chosedFiles.isEmpty()) ? false : true;
    }

    public boolean bdK() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    private void bdL() {
        if (this.emS == null && bcW() != null) {
            this.emS = (f) bcW().nf(27);
        }
    }

    public void bdM() {
        if (this.emS != null && this.emR != null) {
            this.emS.c(this.emR);
        }
    }

    public void a(TextWatcher textWatcher) {
        bdL();
        if (this.emS != null && textWatcher != null) {
            this.emS.b(textWatcher);
        }
    }

    public void bdg() {
        if (this.ekK != null) {
            this.ekK.bdg();
        }
    }
}
