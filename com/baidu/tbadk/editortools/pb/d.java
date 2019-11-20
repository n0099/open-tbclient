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
    private EditorTools cEb;
    private String cFW;
    private String cFX;
    private LocationModel cFY;
    private NewWriteModel cFZ;
    private ImageModel cGa;
    private DataModel<?> cGb;
    private ForumData cGc;
    private BaseActivity<?> cGd;
    private String cGe;
    private int cGf;
    private NewWriteModel.d cGg;
    private c cGh;
    private b cGi;
    private boolean cGj;
    private TextWatcher cGk;
    private e cGl;
    private LocationModel.a cGm;
    private LocationModel.b cGn;
    private final NewWriteModel.d cGo;
    private final com.baidu.adp.base.d cGp;
    private String mThreadId;
    private VideoInfo mVideoInfo;
    private VoiceData.VoiceModel mVoiceModel;
    private String postId;
    private WriteImagesInfo writeImagesInfo;

    public d(EditorTools editorTools) {
        super(editorTools);
        this.writeImagesInfo = new WriteImagesInfo();
        this.cFW = "";
        this.cFZ = null;
        this.cGa = null;
        this.mThreadId = null;
        this.cGe = null;
        this.cGf = 0;
        this.cGj = false;
        this.cGm = new LocationModel.a() { // from class: com.baidu.tbadk.editortools.pb.d.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void auN() {
                d.this.cGd.showToast(R.string.no_network_guide);
                d.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                BaseActivity baseActivity = d.this.cGd;
                if (StringUtils.isNull(str)) {
                    str = d.this.atX().getContext().getString(R.string.location_fail);
                }
                baseActivity.showToast(str);
                d.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.coS())) {
                    d.this.b(2, true, aVar.coS());
                } else {
                    onFail(null);
                }
            }
        };
        this.cGn = new LocationModel.b() { // from class: com.baidu.tbadk.editortools.pb.d.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void auO() {
                d.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void pO(String str) {
                d.this.b(2, true, str);
            }
        };
        this.cGo = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.d.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
                WriteData cla = writeData == null ? d.this.cFZ.cla() : writeData;
                if (z) {
                    d.this.fm(true);
                    WriteData cla2 = d.this.cFZ.cla();
                    d.this.resetData();
                    v.d(d.this.mThreadId, (WriteData) null);
                    if (cla2 != null) {
                        if (cla2 != null && cla2.getType() == 2) {
                            v.a(cla2.getThreadId(), d.this);
                        }
                    } else {
                        return;
                    }
                } else if (cla != null && yVar != null && !TextUtils.isEmpty(yVar.apr())) {
                    cla.setVcodeMD5(yVar.getVcode_md5());
                    cla.setVcodeUrl(yVar.getVcode_pic_url());
                    cla.setVcodeExtra(yVar.aps());
                    if (com.baidu.tbadk.v.a.qv(yVar.apr())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(d.this.cGd.getActivity(), RequestResponseCode.REQUEST_VCODE, cla, false, yVar.apr())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(d.this.cGd.getActivity(), cla, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(d.this.cGd.getActivity(), RequestResponseCode.REQUEST_VCODE, cla, postWriteCallBackData.getAccessState())));
                }
                d.this.b(d.this.cFZ.cla());
                if (d.this.cGg != null) {
                    d.this.cGg.callback(z, postWriteCallBackData, yVar, cla, antiData);
                }
            }
        };
        this.cGp = new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.editortools.pb.d.7
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Bitmap) {
                    d.this.cFZ.qV(true);
                }
            }
        };
        this.cEb = editorTools;
    }

    public void jQ(int i) {
        if (this.cGl == null && atX() != null) {
            this.cGl = (e) atX().jK(27);
        }
        if (this.cGl != null) {
            this.cGl.setType(i);
        }
    }

    public void jR(int i) {
        if (this.cGl == null && atX() != null) {
            this.cGl = (e) atX().jK(27);
        }
        if (this.cGl != null) {
            this.cGl.jS(i);
        }
    }

    public e auw() {
        if (this.cGl == null && atX() != null) {
            this.cGl = (e) atX().jK(27);
        }
        return this.cGl;
    }

    public void pI(String str) {
        if (this.cGl == null && atX() != null) {
            this.cGl = (e) atX().jK(27);
        }
        if (this.cGl != null) {
            this.cGl.setHint(str);
        }
    }

    public void fi(boolean z) {
        BLauncher bLauncher;
        if (atX() != null && (bLauncher = (BLauncher) atX().jH(5)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void fj(boolean z) {
        BLauncher bLauncher;
        if (atX() != null && (bLauncher = (BLauncher) atX().jH(23)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void fk(boolean z) {
        BLauncher bLauncher;
        if (atX() != null && (bLauncher = (BLauncher) atX().jH(2)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.cGb = dataModel;
    }

    public void b(BaseActivity<?> baseActivity) {
        this.cGd = baseActivity;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.cGe = antiData.getVoice_message();
        }
    }

    public void a(ForumData forumData, UserData userData) {
        this.cGc = forumData;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (atX() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.authorNameShow = metaData.getName_show();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void fl(boolean z) {
        this.cGj = z;
    }

    public void aux() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            String valueOf = String.valueOf(this.authorId);
            if (valueOf == null || valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                l.showToast(this.cGd.getActivity(), (int) R.string.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.cGd.getActivity(), this.authorId, this.authorName, this.authorNameShow, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.g.b.toLong(this.mThreadId, 0L), com.baidu.adp.lib.g.b.toLong(this.postId, 0L))));
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.cGd.getActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_LOGIN_SUB_PB_AT /* 11026 */:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.cGd.getActivity(), RequestResponseCode.REQUEST_SUB_PB_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("camera_result", false)) {
                            W(intent);
                        } else {
                            Y(intent);
                        }
                        atX().invalidate();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_IMAGE_VIEW /* 12003 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("delete", false)) {
                            auH();
                            this.cFZ.qV(false);
                            return;
                        }
                        this.cGa.pH(intent.getStringExtra("file_name"));
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
                    WriteData cla = this.cFZ.cla();
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (cla != null) {
                        cla.deleteUploadedTempImages();
                    }
                    this.cFZ.d((WriteData) null);
                    this.cFZ.qV(false);
                    this.mVoiceModel = null;
                    this.mVideoInfo = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        v.d(this.mThreadId, (WriteData) null);
                    }
                    fm(true);
                    if (this.cGg != null) {
                        this.cGg.callback(true, postWriteCallBackData, null, cla, null);
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
                    if (atX() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            an anVar = new an(TbadkCoreStatisticKey.XIAOYING_DURATION);
                            anVar.O("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(anVar);
                            auI();
                            atX().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            atX().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                auF();
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
                if (this.cGg != null) {
                    this.cGg.callback(false, postWriteCallBackData2, null, this.cFZ.cla(), null);
                    return;
                }
                return;
        }
    }

    public void auy() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.cGd.getActivity())));
    }

    public void auz() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.cGd.getActivity())) {
            this.cGd.showToast((int) R.string.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            auB();
        } else if (this.cFY.coZ()) {
            auy();
        } else {
            this.cFY.qT(false);
            b(1, true, null);
            this.cFY.coX();
        }
    }

    public void auA() {
        if (this.cFY != null && !com.baidu.tieba.tbadkCore.location.c.coU().coV() && UtilHelper.isSystemLocationProviderEnabled(this.cGd.getActivity()) && TbadkCoreApplication.getInst().getLocationShared()) {
            this.cFY.coX();
        }
    }

    private void auB() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cGd.getActivity());
        aVar.hT(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tbadk.editortools.pb.d.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.isNetWorkAvailable()) {
                    d.this.b(1, true, null);
                    d.this.cFY.cpb();
                } else {
                    d.this.cGm.auN();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.editortools.pb.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                d.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(this.cGd.getPageContext());
        aVar.akM();
    }

    public void auC() {
        if (this.cFY.aWP()) {
            if (this.cFY.coZ()) {
                this.cGm.a(com.baidu.tieba.tbadkCore.location.c.coU().getLocationData());
                return;
            }
            if (l.isNetOk()) {
                this.cFY.coX();
            }
            b(0, true, null);
            return;
        }
        b(0, false, null);
    }

    public boolean auD() {
        if (StringUtils.isNull(this.cFW)) {
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
        this.cFZ.d((WriteData) null);
        this.cFZ.qV(false);
        this.mVoiceModel = null;
        this.mVideoInfo = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void auE() {
        this.mVideoInfo = null;
    }

    private void W(Intent intent) {
        this.cFX = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.cFX;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.cGd.getActivity(), l.getEquipmentWidth(this.cGd.getActivity())), l.dip2px(this.cGd.getActivity(), l.getEquipmentHeight(this.cGd.getActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    m.a("cameras", this.cFX, rotateBitmapBydegree, 100);
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
        pbEditorData.setContent(this.cFW);
        pbEditorData.setWriteImagesInfo(this.writeImagesInfo);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        PbEditorData.ThreadData threadData = new PbEditorData.ThreadData();
        if (this.cGc != null) {
            threadData.setForumId(this.cGc.getId());
            threadData.setForumName(this.cGc.getName());
            threadData.setFirstDir(this.cGc.getFirst_class());
            threadData.setSecondDir(this.cGc.getSecond_class());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.cGe);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.cGd.getActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void c(p pVar) {
        if (pVar != null) {
            if (pVar.apk() == EmotionGroupType.BIG_EMOTION || pVar.apk() == EmotionGroupType.USER_COLLECT) {
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

    private void auF() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tbadk.editortools.pb.d.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                m.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + d.this.cFX));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void Y(Intent intent) {
        b(intent, true);
    }

    public void pJ(String str) {
        WriteData cla = this.cFZ.cla();
        if (cla == null) {
            cla = new WriteData(1);
            cla.setThreadId(str);
            cla.setWriteImagesInfo(this.writeImagesInfo);
        }
        cla.setContent(this.cFW);
        cla.setVideoInfo(this.mVideoInfo);
        v.d(str, cla);
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
                auI();
                atX().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                    atX().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                atX().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            if (!aq.isEmpty(writeData.getContent()) && aq.isEmpty(this.cFW)) {
                this.cFW = writeData.getContent();
                pN(this.cFW);
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
                    atX().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                atX().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.cFW = writeData.getContent();
            pN(this.cFW);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.cFZ.cancelLoadData();
        this.cGa.cancelLoadData();
        this.cFY.cancelLoadData();
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        this.cFZ = new NewWriteModel(baseActivity);
        this.cFZ.b(this.cGo);
        this.cGa = new ImageModel(baseActivity);
        this.cGa.setLoadDataCallBack(this.cGp);
        this.cFY = new LocationModel(baseActivity);
        this.cFY.a(this.cGm);
        this.cFY.a(this.cGn);
        if (bundle != null) {
            this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
            this.cFX = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(9);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && atX() != null) {
            atX().b(new com.baidu.tbadk.editortools.a(2, 12, HanziToPinyin.Token.SEPARATOR));
        }
        if (!this.cFY.aWP() && atX() != null) {
            atX().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            atX().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.writeImagesInfo != null) {
            bundle.putString(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.cFX);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.cFZ.cla() == null) {
            this.cFZ.d(this.cGb.pG(str));
        }
        if (this.cFZ.cla() != null) {
            if (this.cGj) {
                this.cFZ.cla().setCanNoForum(true);
                if (this.cGc != null) {
                    this.cFZ.cla().setVForumId(this.cGc.getId());
                    this.cFZ.cla().setVForumName(this.cGc.getName());
                }
            } else {
                this.cFZ.cla().setCanNoForum(false);
                this.cFZ.cla().setVForumId("");
                this.cFZ.cla().setVForumName("");
            }
            this.cFZ.cla().setWriteImagesInfo(this.writeImagesInfo);
            this.cFZ.cla().setVideoInfo(this.mVideoInfo);
            this.cFZ.qV(this.writeImagesInfo.size() > 0);
            WriteData cla = this.cFZ.cla();
            if (this.cFY == null || !this.cFY.aWP()) {
                z = false;
            }
            cla.setHasLocationData(z);
            if (str == null) {
                this.cFZ.cla().setContent(this.cFW);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.cFZ.cla().setVoice(this.mVoiceModel.getId());
                    this.cFZ.cla().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.cFZ.cla().setVoice(null);
                    this.cFZ.cla().setVoiceDuringTime(-1);
                }
            } else {
                this.cFZ.cla().setVoice(null);
                this.cFZ.cla().setVoiceDuringTime(-1);
            }
            if (!this.cFZ.cpF()) {
                this.cGd.showToast((int) R.string.write_img_limit);
            } else if (this.cGi == null || !this.cGi.auu()) {
                if (this.cGh != null) {
                    this.cGh.auv();
                }
                if (!this.cFZ.cpC()) {
                }
            }
        }
    }

    public BaseActivity<?> getContext() {
        return this.cGd;
    }

    public void pL(String str) {
        this.cFW = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int auG() {
        return this.cGf;
    }

    private void auH() {
        if (atX() != null) {
            atX().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void B(ArrayList<String> arrayList) {
        if (atX() != null) {
            atX().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void pM(String str) {
        if (atX() != null) {
            atX().b(new com.baidu.tbadk.editortools.a(44, 27, str));
        }
    }

    private void auI() {
        if (atX() != null) {
            atX().b(new com.baidu.tbadk.editortools.a(2, 19, HanziToPinyin.Token.SEPARATOR));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.cGf = i;
        if (atX() != null) {
            atX().b(new com.baidu.tbadk.editortools.a(19, 27, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void pN(String str) {
        if (atX() != null) {
            atX().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fm(boolean z) {
        if (atX() != null) {
            if (z) {
                atX().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                atX().b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
            atX().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.cGg = dVar;
    }

    public void a(c cVar) {
        this.cGh = cVar;
    }

    public void a(b bVar) {
        this.cGi = bVar;
    }

    public boolean auJ() {
        LinkedList<ImageFileInfo> chosedFiles;
        return (this.writeImagesInfo == null || (chosedFiles = this.writeImagesInfo.getChosedFiles()) == null || chosedFiles.isEmpty()) ? false : true;
    }

    public boolean auK() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    private void auL() {
        if (this.cGl == null && atX() != null) {
            this.cGl = (e) atX().jK(27);
        }
    }

    public void auM() {
        if (this.cGl != null && this.cGk != null) {
            this.cGl.d(this.cGk);
        }
    }

    public void b(TextWatcher textWatcher) {
        auL();
        if (this.cGl != null && textWatcher != null) {
            this.cGl.c(textWatcher);
        }
    }

    public void auh() {
        if (this.cEb != null) {
            this.cEb.auh();
        }
    }
}
