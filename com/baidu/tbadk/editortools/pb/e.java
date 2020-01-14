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
import com.baidu.tbadk.coreExtra.data.z;
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
/* loaded from: classes6.dex */
public class e extends com.baidu.tbadk.editortools.d implements v.a {
    private bj Np;
    private long authorId;
    private String authorName;
    private String authorNameShow;
    private TbPageContext cRe;
    private EditorTools dsh;
    private String dud;
    private LocationModel due;
    private NewWriteModel duf;
    private ImageModel dug;
    private DataModel<?> duh;
    private ForumData dui;
    private String duj;
    private int duk;
    private NewWriteModel.d dul;
    private c dum;
    private b dun;
    private boolean duo;
    private TextWatcher dup;
    private f duq;
    private LocationModel.a dur;
    private LocationModel.b dus;
    private final NewWriteModel.d dut;
    private final com.baidu.adp.base.d duu;
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
        this.duf = null;
        this.dug = null;
        this.mThreadId = null;
        this.duj = null;
        this.duk = 0;
        this.duo = false;
        this.dur = new LocationModel.a() { // from class: com.baidu.tbadk.editortools.pb.e.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void aMM() {
                e.this.cRe.showToast(R.string.no_network_guide);
                e.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                TbPageContext tbPageContext = e.this.cRe;
                if (StringUtils.isNull(str)) {
                    str = e.this.aLV().getContext().getString(R.string.location_fail);
                }
                tbPageContext.showToast(str);
                e.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.cKe())) {
                    e.this.a(2, true, aVar.cKe());
                } else {
                    onFail(null);
                }
            }
        };
        this.dus = new LocationModel.b() { // from class: com.baidu.tbadk.editortools.pb.e.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void aMN() {
                e.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void uY(String str) {
                e.this.a(2, true, str);
            }
        };
        this.dut = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.e.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, z zVar, WriteData writeData, AntiData antiData) {
                WriteData cGo = writeData == null ? e.this.duf.cGo() : writeData;
                if (z) {
                    e.this.gC(true);
                    WriteData cGo2 = e.this.duf.cGo();
                    e.this.resetData();
                    v.d(e.this.mThreadId, (WriteData) null);
                    if (cGo2 != null) {
                        if (cGo2.getType() == 2) {
                            v.a(cGo2.getThreadId(), e.this);
                        }
                    } else {
                        return;
                    }
                } else if (cGo != null && zVar != null && !TextUtils.isEmpty(zVar.aHk())) {
                    cGo.setVcodeMD5(zVar.getVcode_md5());
                    cGo.setVcodeUrl(zVar.getVcode_pic_url());
                    cGo.setVcodeExtra(zVar.aHl());
                    if (e.this.Np != null) {
                        cGo.setBaijiahaoData(e.this.Np.getBaijiahaoData());
                    }
                    if (com.baidu.tbadk.s.a.vG(zVar.aHk())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(e.this.cRe.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cGo, false, zVar.aHk())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(e.this.cRe.getPageActivity(), cGo, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(e.this.cRe.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cGo, postWriteCallBackData.getAccessState())));
                }
                e.this.b(e.this.duf.cGo());
                if (e.this.dul != null) {
                    e.this.dul.callback(z, postWriteCallBackData, zVar, cGo, antiData);
                }
            }
        };
        this.duu = new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.editortools.pb.e.7
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Bitmap) {
                    e.this.duf.sO(true);
                }
            }
        };
        this.dsh = editorTools;
    }

    public void md(int i) {
        if (this.duq == null && aLV() != null) {
            this.duq = (f) aLV().lX(27);
        }
        if (this.duq != null) {
            this.duq.setType(i);
        }
    }

    public void me(int i) {
        if (this.duq == null && aLV() != null) {
            this.duq = (f) aLV().lX(27);
        }
        if (this.duq != null) {
            this.duq.mf(i);
        }
    }

    public f aMu() {
        if (this.duq == null && aLV() != null) {
            this.duq = (f) aLV().lX(27);
        }
        return this.duq;
    }

    public void uT(String str) {
        if (this.duq == null && aLV() != null) {
            this.duq = (f) aLV().lX(27);
        }
        if (this.duq != null) {
            this.duq.setHint(str);
        }
    }

    public void gy(boolean z) {
        BLauncher bLauncher;
        if (aLV() != null && (bLauncher = (BLauncher) aLV().lU(5)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void gz(boolean z) {
        BLauncher bLauncher;
        if (aLV() != null && (bLauncher = (BLauncher) aLV().lU(23)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void gA(boolean z) {
        BLauncher bLauncher;
        if (aLV() != null && (bLauncher = (BLauncher) aLV().lU(2)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.duh = dataModel;
    }

    public void a(TbPageContext tbPageContext) {
        this.cRe = tbPageContext;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.duj = antiData.getVoice_message();
        }
    }

    public void a(ForumData forumData, UserData userData) {
        this.dui = forumData;
    }

    public void setThreadData(bj bjVar) {
        this.Np = bjVar;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (aLV() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.authorNameShow = metaData.getName_show();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void gB(boolean z) {
        this.duo = z;
    }

    public void aMv() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            if (String.valueOf(this.authorId).equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                l.showToast(this.cRe.getPageActivity(), (int) R.string.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.cRe.getPageActivity(), this.authorId, this.authorName, this.authorNameShow, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.f.b.toLong(this.mThreadId, 0L), com.baidu.adp.lib.f.b.toLong(this.postId, 0L))));
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.cRe.getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_LOGIN_SUB_PB_AT /* 11026 */:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.cRe.getPageActivity(), RequestResponseCode.REQUEST_SUB_PB_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("camera_result", false)) {
                            T(intent);
                        } else {
                            V(intent);
                        }
                        aLV().invalidate();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_IMAGE_VIEW /* 12003 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("delete", false)) {
                            aMG();
                            this.duf.sO(false);
                            return;
                        }
                        this.dug.uS(intent.getStringExtra("file_name"));
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
                    WriteData cGo = this.duf.cGo();
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (cGo != null) {
                        cGo.deleteUploadedTempImages();
                    }
                    this.duf.d((WriteData) null);
                    this.duf.sO(false);
                    this.mVoiceModel = null;
                    this.mVideoInfo = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        v.d(this.mThreadId, (WriteData) null);
                    }
                    gC(true);
                    if (this.dul != null) {
                        this.dul.callback(true, postWriteCallBackData, null, cGo, null);
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
                    if (aLV() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            an anVar = new an(TbadkCoreStatisticKey.XIAOYING_DURATION);
                            anVar.Z("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(anVar);
                            aMH();
                            aLV().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            aLV().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                        uW(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 12001:
                aMD();
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
                if (this.dul != null) {
                    this.dul.callback(false, postWriteCallBackData2, null, this.duf.cGo(), null);
                    return;
                }
                return;
        }
    }

    public void aMw() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.cRe.getPageActivity())));
    }

    public void aMx() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.cRe.getPageActivity())) {
            this.cRe.showToast(R.string.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            aMz();
        } else if (this.due.cKl()) {
            aMw();
        } else {
            this.due.sM(false);
            a(1, true, (String) null);
            this.due.cKj();
        }
    }

    public void aMy() {
        if (!this.isBJH && this.due != null && !com.baidu.tieba.tbadkCore.location.c.cKg().cKh() && UtilHelper.isSystemLocationProviderEnabled(this.cRe.getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared()) {
            this.due.cKj();
        }
    }

    private void aMz() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cRe.getPageActivity());
        aVar.jF(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    e.this.a(1, true, (String) null);
                    e.this.due.cKn();
                } else {
                    e.this.dur.aMM();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                e.this.a(0, true, (String) null);
                aVar2.dismiss();
            }
        }).b(this.cRe);
        aVar.aCp();
    }

    public void aMA() {
        if (this.due.bpD()) {
            if (this.due.cKl()) {
                this.dur.a(com.baidu.tieba.tbadkCore.location.c.cKg().getLocationData());
                return;
            }
            if (l.isNetOk()) {
                this.due.cKj();
            }
            a(0, true, (String) null);
            return;
        }
        a(0, false, (String) null);
    }

    public boolean aMB() {
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
        this.duf.d((WriteData) null);
        this.duf.sO(false);
        this.mVoiceModel = null;
        this.mVideoInfo = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void aMC() {
        this.mVideoInfo = null;
    }

    private void T(Intent intent) {
        this.dud = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.dud;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.cRe.getPageActivity(), l.getEquipmentWidth(this.cRe.getPageActivity())), l.dip2px(this.cRe.getPageActivity(), l.getEquipmentHeight(this.cRe.getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    m.a("cameras", this.dud, rotateBitmapBydegree, 100);
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
        if (this.dui != null) {
            threadData.setForumId(this.dui.getId());
            threadData.setForumName(this.dui.getName());
            threadData.setFirstDir(this.dui.getFirst_class());
            threadData.setSecondDir(this.dui.getSecond_class());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        threadData.isBJH = this.isBJH;
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.duj);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.cRe.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void c(p pVar) {
        if (pVar != null) {
            if (pVar.aHc() == EmotionGroupType.BIG_EMOTION || pVar.aHc() == EmotionGroupType.USER_COLLECT) {
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

    private void aMD() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tbadk.editortools.pb.e.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                m.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + e.this.dud));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void V(Intent intent) {
        b(intent, true);
    }

    public void saveDraft(String str) {
        WriteData cGo = this.duf.cGo();
        if (cGo == null) {
            cGo = new WriteData(1);
            cGo.setThreadId(str);
            cGo.setWriteImagesInfo(this.writeImagesInfo);
        }
        cGo.setContent(this.mPostContent);
        cGo.setVideoInfo(this.mVideoInfo);
        cGo.setVoiceModel(this.mVoiceModel);
        v.d(str, cGo);
    }

    public void uU(String str) {
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
                aMH();
                aLV().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                    aLV().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                aLV().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            if (writeData.getVoiceModel() != null && writeData.getVoiceModel().voiceId != null && writeData.getVoiceModel().duration != -1) {
                if (this.mVoiceModel == null) {
                    this.mVoiceModel = new VoiceData.VoiceModel();
                }
                this.mVoiceModel.copy(writeData.getVoiceModel());
            }
            if (!aq.isEmpty(writeData.getContent()) && aq.isEmpty(this.mPostContent)) {
                this.mPostContent = writeData.getContent();
                uX(this.mPostContent);
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
                    aLV().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                aLV().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.mPostContent = writeData.getContent();
            uX(this.mPostContent);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.duf.cancelLoadData();
        this.dug.cancelLoadData();
        this.due.cancelLoadData();
    }

    public void a(TbPageContext tbPageContext, Bundle bundle) {
        this.duf = new NewWriteModel(tbPageContext);
        this.duf.b(this.dut);
        this.dug = new ImageModel(tbPageContext);
        this.dug.setLoadDataCallBack(this.duu);
        this.due = new LocationModel(tbPageContext);
        this.due.a(this.dur);
        this.due.a(this.dus);
        if (bundle != null) {
            this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
            this.dud = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(this.isBJH ? 1 : 9);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && aLV() != null) {
            aLV().b(new com.baidu.tbadk.editortools.a(2, 12, HanziToPinyin.Token.SEPARATOR));
        }
        if (!this.due.bpD() && aLV() != null) {
            aLV().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            aLV().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.writeImagesInfo != null) {
            bundle.putString(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.dud);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.duf.cGo() == null) {
            WriteData uR = this.duh.uR(str);
            if (uR != null && this.Np != null) {
                uR.setBaijiahaoData(this.Np.getBaijiahaoData());
            }
            this.duf.d(uR);
        }
        if (this.duf.cGo() != null) {
            if (this.duo) {
                this.duf.cGo().setCanNoForum(true);
                if (this.dui != null) {
                    this.duf.cGo().setVForumId(this.dui.getId());
                    this.duf.cGo().setVForumName(this.dui.getName());
                }
            } else {
                this.duf.cGo().setCanNoForum(false);
                this.duf.cGo().setVForumId("");
                this.duf.cGo().setVForumName("");
            }
            this.duf.cGo().setIsBJHPost(this.isBJH);
            this.duf.cGo().setWriteImagesInfo(this.writeImagesInfo);
            this.duf.cGo().setVideoInfo(this.mVideoInfo);
            this.duf.sO(this.writeImagesInfo.size() > 0);
            WriteData cGo = this.duf.cGo();
            if (this.due == null || !this.due.bpD()) {
                z = false;
            }
            cGo.setHasLocationData(z);
            if (str == null) {
                this.duf.cGo().setContent(this.mPostContent);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.duf.cGo().setVoice(this.mVoiceModel.getId());
                    this.duf.cGo().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.duf.cGo().setVoice(null);
                    this.duf.cGo().setVoiceDuringTime(-1);
                }
            } else {
                this.duf.cGo().setVoice(null);
                this.duf.cGo().setVoiceDuringTime(-1);
            }
            if (!this.duf.cKP()) {
                this.cRe.showToast(R.string.write_img_limit);
            } else if (this.dun == null || !this.dun.aMs()) {
                if (this.dum != null) {
                    this.dum.aMt();
                }
                if (!this.duf.cKM()) {
                }
            }
        }
    }

    public BaseFragmentActivity aME() {
        return (BaseFragmentActivity) this.cRe.getPageActivity();
    }

    public void uV(String str) {
        this.mPostContent = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int aMF() {
        return this.duk;
    }

    private void aMG() {
        if (aLV() != null) {
            aLV().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void E(ArrayList<String> arrayList) {
        if (aLV() != null) {
            aLV().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void uW(String str) {
        if (aLV() != null) {
            aLV().b(new com.baidu.tbadk.editortools.a(44, 27, str));
        }
    }

    private void aMH() {
        if (aLV() != null) {
            aLV().b(new com.baidu.tbadk.editortools.a(2, 19, HanziToPinyin.Token.SEPARATOR));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.duk = i;
        if (aLV() != null) {
            aLV().b(new com.baidu.tbadk.editortools.a(19, 27, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void uX(String str) {
        if (aLV() != null) {
            aLV().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gC(boolean z) {
        if (aLV() != null) {
            if (z) {
                aLV().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                aLV().b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
            aLV().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.dul = dVar;
    }

    public void a(c cVar) {
        this.dum = cVar;
    }

    public void a(b bVar) {
        this.dun = bVar;
    }

    public boolean aMI() {
        LinkedList<ImageFileInfo> chosedFiles;
        return (this.writeImagesInfo == null || (chosedFiles = this.writeImagesInfo.getChosedFiles()) == null || chosedFiles.isEmpty()) ? false : true;
    }

    public boolean aMJ() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    private void aMK() {
        if (this.duq == null && aLV() != null) {
            this.duq = (f) aLV().lX(27);
        }
    }

    public void aML() {
        if (this.duq != null && this.dup != null) {
            this.duq.d(this.dup);
        }
    }

    public void b(TextWatcher textWatcher) {
        aMK();
        if (this.duq != null && textWatcher != null) {
            this.duq.c(textWatcher);
        }
    }

    public void aMf() {
        if (this.dsh != null) {
            this.dsh.aMf();
        }
    }
}
