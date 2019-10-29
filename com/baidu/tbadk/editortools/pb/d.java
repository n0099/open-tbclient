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
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
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
/* loaded from: classes3.dex */
public class d extends com.baidu.tbadk.editortools.d implements v.a {
    private long authorId;
    private String authorName;
    private String authorNameShow;
    private EditorTools cES;
    private String cGN;
    private String cGO;
    private LocationModel cGP;
    private NewWriteModel cGQ;
    private ImageModel cGR;
    private DataModel<?> cGS;
    private ForumData cGT;
    private BaseActivity<?> cGU;
    private String cGV;
    private int cGW;
    private NewWriteModel.d cGX;
    private c cGY;
    private b cGZ;
    private boolean cHa;
    private TextWatcher cHb;
    private e cHc;
    private LocationModel.a cHd;
    private LocationModel.b cHe;
    private final NewWriteModel.d cHf;
    private final com.baidu.adp.base.d cHg;
    private String mThreadId;
    private VideoInfo mVideoInfo;
    private VoiceData.VoiceModel mVoiceModel;
    private String postId;
    private WriteImagesInfo writeImagesInfo;

    public d(EditorTools editorTools) {
        super(editorTools);
        this.writeImagesInfo = new WriteImagesInfo();
        this.cGN = "";
        this.cGQ = null;
        this.cGR = null;
        this.mThreadId = null;
        this.cGV = null;
        this.cGW = 0;
        this.cHa = false;
        this.cHd = new LocationModel.a() { // from class: com.baidu.tbadk.editortools.pb.d.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void auP() {
                d.this.cGU.showToast(R.string.no_network_guide);
                d.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                BaseActivity baseActivity = d.this.cGU;
                if (StringUtils.isNull(str)) {
                    str = d.this.atZ().getContext().getString(R.string.location_fail);
                }
                baseActivity.showToast(str);
                d.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.coU())) {
                    d.this.b(2, true, aVar.coU());
                } else {
                    onFail(null);
                }
            }
        };
        this.cHe = new LocationModel.b() { // from class: com.baidu.tbadk.editortools.pb.d.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void auQ() {
                d.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void pO(String str) {
                d.this.b(2, true, str);
            }
        };
        this.cHf = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.d.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
                WriteData clc = writeData == null ? d.this.cGQ.clc() : writeData;
                if (z) {
                    d.this.fm(true);
                    WriteData clc2 = d.this.cGQ.clc();
                    d.this.resetData();
                    v.d(d.this.mThreadId, (WriteData) null);
                    if (clc2 != null) {
                        if (clc2 != null && clc2.getType() == 2) {
                            v.a(clc2.getThreadId(), d.this);
                        }
                    } else {
                        return;
                    }
                } else if (clc != null && yVar != null && !TextUtils.isEmpty(yVar.apt())) {
                    clc.setVcodeMD5(yVar.getVcode_md5());
                    clc.setVcodeUrl(yVar.getVcode_pic_url());
                    clc.setVcodeExtra(yVar.apu());
                    if (com.baidu.tbadk.v.a.qv(yVar.apt())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(d.this.cGU.getActivity(), RequestResponseCode.REQUEST_VCODE, clc, false, yVar.apt())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(d.this.cGU.getActivity(), clc, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(d.this.cGU.getActivity(), RequestResponseCode.REQUEST_VCODE, clc, postWriteCallBackData.getAccessState())));
                }
                d.this.b(d.this.cGQ.clc());
                if (d.this.cGX != null) {
                    d.this.cGX.callback(z, postWriteCallBackData, yVar, clc, antiData);
                }
            }
        };
        this.cHg = new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.editortools.pb.d.7
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Bitmap) {
                    d.this.cGQ.qV(true);
                }
            }
        };
        this.cES = editorTools;
    }

    public void jR(int i) {
        if (this.cHc == null && atZ() != null) {
            this.cHc = (e) atZ().jL(27);
        }
        if (this.cHc != null) {
            this.cHc.setType(i);
        }
    }

    public void jS(int i) {
        if (this.cHc == null && atZ() != null) {
            this.cHc = (e) atZ().jL(27);
        }
        if (this.cHc != null) {
            this.cHc.jT(i);
        }
    }

    public e auy() {
        if (this.cHc == null && atZ() != null) {
            this.cHc = (e) atZ().jL(27);
        }
        return this.cHc;
    }

    public void pI(String str) {
        if (this.cHc == null && atZ() != null) {
            this.cHc = (e) atZ().jL(27);
        }
        if (this.cHc != null) {
            this.cHc.setHint(str);
        }
    }

    public void fi(boolean z) {
        BLauncher bLauncher;
        if (atZ() != null && (bLauncher = (BLauncher) atZ().jI(5)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void fj(boolean z) {
        BLauncher bLauncher;
        if (atZ() != null && (bLauncher = (BLauncher) atZ().jI(23)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void fk(boolean z) {
        BLauncher bLauncher;
        if (atZ() != null && (bLauncher = (BLauncher) atZ().jI(2)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.cGS = dataModel;
    }

    public void b(BaseActivity<?> baseActivity) {
        this.cGU = baseActivity;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.cGV = antiData.getVoice_message();
        }
    }

    public void a(ForumData forumData, UserData userData) {
        this.cGT = forumData;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (atZ() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.authorNameShow = metaData.getName_show();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void fl(boolean z) {
        this.cHa = z;
    }

    public void auz() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            String valueOf = String.valueOf(this.authorId);
            if (valueOf == null || valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                l.showToast(this.cGU.getActivity(), (int) R.string.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.cGU.getActivity(), this.authorId, this.authorName, this.authorNameShow, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.g.b.toLong(this.mThreadId, 0L), com.baidu.adp.lib.g.b.toLong(this.postId, 0L))));
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.cGU.getActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_LOGIN_SUB_PB_AT /* 11026 */:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.cGU.getActivity(), RequestResponseCode.REQUEST_SUB_PB_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("camera_result", false)) {
                            W(intent);
                        } else {
                            Y(intent);
                        }
                        atZ().invalidate();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_IMAGE_VIEW /* 12003 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("delete", false)) {
                            auJ();
                            this.cGQ.qV(false);
                            return;
                        }
                        this.cGR.pH(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        B(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    WriteData clc = this.cGQ.clc();
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (clc != null) {
                        clc.deleteUploadedTempImages();
                    }
                    this.cGQ.d((WriteData) null);
                    this.cGQ.qV(false);
                    this.mVoiceModel = null;
                    this.mVideoInfo = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        v.d(this.mThreadId, (WriteData) null);
                    }
                    fm(true);
                    if (this.cGX != null) {
                        this.cGX.callback(true, postWriteCallBackData, null, clc, null);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    if (i == 12010) {
                        W(intent);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    X(intent);
                    return;
                case RequestResponseCode.REQUEST_RECORDER_VIDEO /* 13010 */:
                    if (atZ() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            an anVar = new an(TbadkCoreStatisticKey.XIAOYING_DURATION);
                            anVar.O("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(anVar);
                            auK();
                            atZ().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            atZ().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                        pM(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 12001:
                auH();
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
                if (this.cGX != null) {
                    this.cGX.callback(false, postWriteCallBackData2, null, this.cGQ.clc(), null);
                    return;
                }
                return;
        }
    }

    public void auA() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.cGU.getActivity())));
    }

    public void auB() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.cGU.getActivity())) {
            this.cGU.showToast((int) R.string.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            auD();
        } else if (this.cGP.cpb()) {
            auA();
        } else {
            this.cGP.qT(false);
            b(1, true, null);
            this.cGP.coZ();
        }
    }

    public void auC() {
        if (this.cGP != null && !com.baidu.tieba.tbadkCore.location.c.coW().coX() && UtilHelper.isSystemLocationProviderEnabled(this.cGU.getActivity()) && TbadkCoreApplication.getInst().getLocationShared()) {
            this.cGP.coZ();
        }
    }

    private void auD() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cGU.getActivity());
        aVar.hU(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tbadk.editortools.pb.d.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.isNetWorkAvailable()) {
                    d.this.b(1, true, null);
                    d.this.cGP.cpd();
                } else {
                    d.this.cHd.auP();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.editortools.pb.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                d.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(this.cGU.getPageContext());
        aVar.akO();
    }

    public void auE() {
        if (this.cGP.aWR()) {
            if (this.cGP.cpb()) {
                this.cHd.a(com.baidu.tieba.tbadkCore.location.c.coW().getLocationData());
                return;
            }
            if (l.isNetOk()) {
                this.cGP.coZ();
            }
            b(0, true, null);
            return;
        }
        b(0, false, null);
    }

    public boolean auF() {
        if (StringUtils.isNull(this.cGN)) {
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
        this.cGQ.d((WriteData) null);
        this.cGQ.qV(false);
        this.mVoiceModel = null;
        this.mVideoInfo = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void auG() {
        this.mVideoInfo = null;
    }

    private void W(Intent intent) {
        this.cGO = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.cGO;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.cGU.getActivity(), l.getEquipmentWidth(this.cGU.getActivity())), l.dip2px(this.cGU.getActivity(), l.getEquipmentHeight(this.cGU.getActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    m.a("cameras", this.cGO, rotateBitmapBydegree, 100);
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

    private void X(Intent intent) {
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
        pbEditorData.setContent(this.cGN);
        pbEditorData.setWriteImagesInfo(this.writeImagesInfo);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        PbEditorData.ThreadData threadData = new PbEditorData.ThreadData();
        if (this.cGT != null) {
            threadData.setForumId(this.cGT.getId());
            threadData.setForumName(this.cGT.getName());
            threadData.setFirstDir(this.cGT.getFirst_class());
            threadData.setSecondDir(this.cGT.getSecond_class());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.cGV);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.cGU.getActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void c(p pVar) {
        if (pVar != null) {
            if (pVar.apm() == EmotionGroupType.BIG_EMOTION || pVar.apm() == EmotionGroupType.USER_COLLECT) {
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

    private void auH() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tbadk.editortools.pb.d.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                m.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + d.this.cGO));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void Y(Intent intent) {
        b(intent, true);
    }

    public void pJ(String str) {
        WriteData clc = this.cGQ.clc();
        if (clc == null) {
            clc = new WriteData(1);
            clc.setThreadId(str);
            clc.setWriteImagesInfo(this.writeImagesInfo);
        }
        clc.setContent(this.cGN);
        clc.setVideoInfo(this.mVideoInfo);
        v.d(str, clc);
    }

    public void pK(String str) {
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
                auK();
                atZ().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                    atZ().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                atZ().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            if (!aq.isEmpty(writeData.getContent()) && aq.isEmpty(this.cGN)) {
                this.cGN = writeData.getContent();
                pN(this.cGN);
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
                    atZ().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                atZ().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.cGN = writeData.getContent();
            pN(this.cGN);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.cGQ.cancelLoadData();
        this.cGR.cancelLoadData();
        this.cGP.cancelLoadData();
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        this.cGQ = new NewWriteModel(baseActivity);
        this.cGQ.b(this.cHf);
        this.cGR = new ImageModel(baseActivity);
        this.cGR.setLoadDataCallBack(this.cHg);
        this.cGP = new LocationModel(baseActivity);
        this.cGP.a(this.cHd);
        this.cGP.a(this.cHe);
        if (bundle != null) {
            this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
            this.cGO = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(9);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && atZ() != null) {
            atZ().b(new com.baidu.tbadk.editortools.a(2, 12, HanziToPinyin.Token.SEPARATOR));
        }
        if (!this.cGP.aWR() && atZ() != null) {
            atZ().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            atZ().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.writeImagesInfo != null) {
            bundle.putString(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.cGO);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.cGQ.clc() == null) {
            this.cGQ.d(this.cGS.pG(str));
        }
        if (this.cGQ.clc() != null) {
            if (this.cHa) {
                this.cGQ.clc().setCanNoForum(true);
                if (this.cGT != null) {
                    this.cGQ.clc().setVForumId(this.cGT.getId());
                    this.cGQ.clc().setVForumName(this.cGT.getName());
                }
            } else {
                this.cGQ.clc().setCanNoForum(false);
                this.cGQ.clc().setVForumId("");
                this.cGQ.clc().setVForumName("");
            }
            this.cGQ.clc().setWriteImagesInfo(this.writeImagesInfo);
            this.cGQ.clc().setVideoInfo(this.mVideoInfo);
            this.cGQ.qV(this.writeImagesInfo.size() > 0);
            WriteData clc = this.cGQ.clc();
            if (this.cGP == null || !this.cGP.aWR()) {
                z = false;
            }
            clc.setHasLocationData(z);
            if (str == null) {
                this.cGQ.clc().setContent(this.cGN);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.cGQ.clc().setVoice(this.mVoiceModel.getId());
                    this.cGQ.clc().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.cGQ.clc().setVoice(null);
                    this.cGQ.clc().setVoiceDuringTime(-1);
                }
            } else {
                this.cGQ.clc().setVoice(null);
                this.cGQ.clc().setVoiceDuringTime(-1);
            }
            if (!this.cGQ.cpH()) {
                this.cGU.showToast((int) R.string.write_img_limit);
            } else if (this.cGZ == null || !this.cGZ.auw()) {
                if (this.cGY != null) {
                    this.cGY.aux();
                }
                if (!this.cGQ.cpE()) {
                }
            }
        }
    }

    public BaseActivity<?> getContext() {
        return this.cGU;
    }

    public void pL(String str) {
        this.cGN = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int auI() {
        return this.cGW;
    }

    private void auJ() {
        if (atZ() != null) {
            atZ().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void B(ArrayList<String> arrayList) {
        if (atZ() != null) {
            atZ().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void pM(String str) {
        if (atZ() != null) {
            atZ().b(new com.baidu.tbadk.editortools.a(44, 27, str));
        }
    }

    private void auK() {
        if (atZ() != null) {
            atZ().b(new com.baidu.tbadk.editortools.a(2, 19, HanziToPinyin.Token.SEPARATOR));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.cGW = i;
        if (atZ() != null) {
            atZ().b(new com.baidu.tbadk.editortools.a(19, 27, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void pN(String str) {
        if (atZ() != null) {
            atZ().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fm(boolean z) {
        if (atZ() != null) {
            if (z) {
                atZ().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                atZ().b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
            atZ().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.cGX = dVar;
    }

    public void a(c cVar) {
        this.cGY = cVar;
    }

    public void a(b bVar) {
        this.cGZ = bVar;
    }

    public boolean auL() {
        LinkedList<ImageFileInfo> chosedFiles;
        return (this.writeImagesInfo == null || (chosedFiles = this.writeImagesInfo.getChosedFiles()) == null || chosedFiles.isEmpty()) ? false : true;
    }

    public boolean auM() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    private void auN() {
        if (this.cHc == null && atZ() != null) {
            this.cHc = (e) atZ().jL(27);
        }
    }

    public void auO() {
        if (this.cHc != null && this.cHb != null) {
            this.cHc.d(this.cHb);
        }
    }

    public void b(TextWatcher textWatcher) {
        auN();
        if (this.cHc != null && textWatcher != null) {
            this.cHc.c(textWatcher);
        }
    }

    public void auj() {
        if (this.cES != null) {
            this.cES.auj();
        }
    }
}
