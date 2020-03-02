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
    private TbPageContext cVh;
    private EditorTools dwp;
    private final NewWriteModel.d dyA;
    private final com.baidu.adp.base.d dyB;
    private String dyk;
    private LocationModel dyl;
    private NewWriteModel dym;
    private ImageModel dyn;
    private DataModel<?> dyo;
    private ForumData dyp;
    private String dyq;
    private int dyr;
    private NewWriteModel.d dys;
    private c dyt;
    private b dyu;
    private boolean dyv;
    private TextWatcher dyw;
    private f dyx;
    private LocationModel.a dyy;
    private LocationModel.b dyz;
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
        this.dym = null;
        this.dyn = null;
        this.mThreadId = null;
        this.dyq = null;
        this.dyr = 0;
        this.dyv = false;
        this.dyy = new LocationModel.a() { // from class: com.baidu.tbadk.editortools.pb.e.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void aPk() {
                e.this.cVh.showToast(R.string.no_network_guide);
                e.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                TbPageContext tbPageContext = e.this.cVh;
                if (StringUtils.isNull(str)) {
                    str = e.this.aOt().getContext().getString(R.string.location_fail);
                }
                tbPageContext.showToast(str);
                e.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.cLE())) {
                    e.this.a(2, true, aVar.cLE());
                } else {
                    onFail(null);
                }
            }
        };
        this.dyz = new LocationModel.b() { // from class: com.baidu.tbadk.editortools.pb.e.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void aPl() {
                e.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void vp(String str) {
                e.this.a(2, true, str);
            }
        };
        this.dyA = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.e.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
                WriteData cHU = writeData == null ? e.this.dym.cHU() : writeData;
                if (z) {
                    e.this.gJ(true);
                    WriteData cHU2 = e.this.dym.cHU();
                    e.this.resetData();
                    v.d(e.this.mThreadId, (WriteData) null);
                    if (cHU2 != null) {
                        if (cHU2.getType() == 2) {
                            v.a(cHU2.getThreadId(), e.this);
                        }
                    } else {
                        return;
                    }
                } else if (cHU != null && aaVar != null && !TextUtils.isEmpty(aaVar.aJF())) {
                    cHU.setVcodeMD5(aaVar.getVcode_md5());
                    cHU.setVcodeUrl(aaVar.getVcode_pic_url());
                    cHU.setVcodeExtra(aaVar.aJG());
                    if (e.this.NQ != null) {
                        cHU.setBaijiahaoData(e.this.NQ.getBaijiahaoData());
                    }
                    if (com.baidu.tbadk.s.a.wa(aaVar.aJF())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(e.this.cVh.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cHU, false, aaVar.aJF())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(e.this.cVh.getPageActivity(), cHU, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(e.this.cVh.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cHU, postWriteCallBackData.getAccessState())));
                }
                e.this.b(e.this.dym.cHU());
                if (e.this.dys != null) {
                    e.this.dys.callback(z, postWriteCallBackData, aaVar, cHU, antiData);
                }
            }
        };
        this.dyB = new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.editortools.pb.e.7
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Bitmap) {
                    e.this.dym.sS(true);
                }
            }
        };
        this.dwp = editorTools;
    }

    public void mv(int i) {
        if (this.dyx == null && aOt() != null) {
            this.dyx = (f) aOt().mp(27);
        }
        if (this.dyx != null) {
            this.dyx.setType(i);
        }
    }

    public void mw(int i) {
        if (this.dyx == null && aOt() != null) {
            this.dyx = (f) aOt().mp(27);
        }
        if (this.dyx != null) {
            this.dyx.mx(i);
        }
    }

    public f aOS() {
        if (this.dyx == null && aOt() != null) {
            this.dyx = (f) aOt().mp(27);
        }
        return this.dyx;
    }

    public void vk(String str) {
        if (this.dyx == null && aOt() != null) {
            this.dyx = (f) aOt().mp(27);
        }
        if (this.dyx != null) {
            this.dyx.setHint(str);
        }
    }

    public void gF(boolean z) {
        BLauncher bLauncher;
        if (aOt() != null && (bLauncher = (BLauncher) aOt().mm(5)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void gG(boolean z) {
        BLauncher bLauncher;
        if (aOt() != null && (bLauncher = (BLauncher) aOt().mm(23)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void gH(boolean z) {
        BLauncher bLauncher;
        if (aOt() != null && (bLauncher = (BLauncher) aOt().mm(2)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.dyo = dataModel;
    }

    public void a(TbPageContext tbPageContext) {
        this.cVh = tbPageContext;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.dyq = antiData.getVoice_message();
        }
    }

    public void a(ForumData forumData, UserData userData) {
        this.dyp = forumData;
    }

    public void setThreadData(bj bjVar) {
        this.NQ = bjVar;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (aOt() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.authorNameShow = metaData.getName_show();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void gI(boolean z) {
        this.dyv = z;
    }

    public void aOT() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            if (String.valueOf(this.authorId).equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                l.showToast(this.cVh.getPageActivity(), (int) R.string.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.cVh.getPageActivity(), this.authorId, this.authorName, this.authorNameShow, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.f.b.toLong(this.mThreadId, 0L), com.baidu.adp.lib.f.b.toLong(this.postId, 0L))));
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.cVh.getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_LOGIN_SUB_PB_AT /* 11026 */:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.cVh.getPageActivity(), RequestResponseCode.REQUEST_SUB_PB_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("camera_result", false)) {
                            T(intent);
                        } else {
                            V(intent);
                        }
                        aOt().invalidate();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_IMAGE_VIEW /* 12003 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("delete", false)) {
                            aPe();
                            this.dym.sS(false);
                            return;
                        }
                        this.dyn.vj(intent.getStringExtra("file_name"));
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
                    WriteData cHU = this.dym.cHU();
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (cHU != null) {
                        cHU.deleteUploadedTempImages();
                    }
                    this.dym.d((WriteData) null);
                    this.dym.sS(false);
                    this.mVoiceModel = null;
                    this.mVideoInfo = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        v.d(this.mThreadId, (WriteData) null);
                    }
                    gJ(true);
                    if (this.dys != null) {
                        this.dys.callback(true, postWriteCallBackData, null, cHU, null);
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
                    if (aOt() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            an anVar = new an(TbadkCoreStatisticKey.XIAOYING_DURATION);
                            anVar.X("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(anVar);
                            aPf();
                            aOt().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            aOt().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                aPb();
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
                if (this.dys != null) {
                    this.dys.callback(false, postWriteCallBackData2, null, this.dym.cHU(), null);
                    return;
                }
                return;
        }
    }

    public void aOU() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.cVh.getPageActivity())));
    }

    public void aOV() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.cVh.getPageActivity())) {
            this.cVh.showToast(R.string.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            aOX();
        } else if (this.dyl.cLL()) {
            aOU();
        } else {
            this.dyl.sQ(false);
            a(1, true, (String) null);
            this.dyl.cLJ();
        }
    }

    public void aOW() {
        if (!this.isBJH && this.dyl != null && !com.baidu.tieba.tbadkCore.location.c.cLG().cLH() && UtilHelper.isSystemLocationProviderEnabled(this.cVh.getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared()) {
            this.dyl.cLJ();
        }
    }

    private void aOX() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVh.getPageActivity());
        aVar.jW(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    e.this.a(1, true, (String) null);
                    e.this.dyl.cLN();
                } else {
                    e.this.dyy.aPk();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                e.this.a(0, true, (String) null);
                aVar2.dismiss();
            }
        }).b(this.cVh);
        aVar.aEC();
    }

    public void aOY() {
        if (this.dyl.brl()) {
            if (this.dyl.cLL()) {
                this.dyy.a(com.baidu.tieba.tbadkCore.location.c.cLG().getLocationData());
                return;
            }
            if (l.isNetOk()) {
                this.dyl.cLJ();
            }
            a(0, true, (String) null);
            return;
        }
        a(0, false, (String) null);
    }

    public boolean aOZ() {
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
        this.dym.d((WriteData) null);
        this.dym.sS(false);
        this.mVoiceModel = null;
        this.mVideoInfo = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void aPa() {
        this.mVideoInfo = null;
    }

    private void T(Intent intent) {
        this.dyk = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.dyk;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.cVh.getPageActivity(), l.getEquipmentWidth(this.cVh.getPageActivity())), l.dip2px(this.cVh.getPageActivity(), l.getEquipmentHeight(this.cVh.getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    m.a("cameras", this.dyk, rotateBitmapBydegree, 100);
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
        if (this.dyp != null) {
            threadData.setForumId(this.dyp.getId());
            threadData.setForumName(this.dyp.getName());
            threadData.setFirstDir(this.dyp.getFirst_class());
            threadData.setSecondDir(this.dyp.getSecond_class());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        threadData.isBJH = this.isBJH;
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.dyq);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.cVh.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void c(q qVar) {
        if (qVar != null) {
            if (qVar.aJw() == EmotionGroupType.BIG_EMOTION || qVar.aJw() == EmotionGroupType.USER_COLLECT) {
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

    private void aPb() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tbadk.editortools.pb.e.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                m.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + e.this.dyk));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void V(Intent intent) {
        b(intent, true);
    }

    public void saveDraft(String str) {
        WriteData cHU = this.dym.cHU();
        if (cHU == null) {
            cHU = new WriteData(1);
            cHU.setThreadId(str);
            cHU.setWriteImagesInfo(this.writeImagesInfo);
        }
        cHU.setContent(this.mPostContent);
        cHU.setVideoInfo(this.mVideoInfo);
        cHU.setVoiceModel(this.mVoiceModel);
        v.d(str, cHU);
    }

    public void vl(String str) {
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
                aPf();
                aOt().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                    aOt().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                aOt().b(new com.baidu.tbadk.editortools.a(2, 10, null));
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
                    aOt().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                aOt().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.mPostContent = writeData.getContent();
            vo(this.mPostContent);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.dym.cancelLoadData();
        this.dyn.cancelLoadData();
        this.dyl.cancelLoadData();
    }

    public void a(TbPageContext tbPageContext, Bundle bundle) {
        this.dym = new NewWriteModel(tbPageContext);
        this.dym.b(this.dyA);
        this.dyn = new ImageModel(tbPageContext);
        this.dyn.setLoadDataCallBack(this.dyB);
        this.dyl = new LocationModel(tbPageContext);
        this.dyl.a(this.dyy);
        this.dyl.a(this.dyz);
        if (bundle != null) {
            this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
            this.dyk = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(this.isBJH ? 1 : 9);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && aOt() != null) {
            aOt().b(new com.baidu.tbadk.editortools.a(2, 12, HanziToPinyin.Token.SEPARATOR));
        }
        if (!this.dyl.brl() && aOt() != null) {
            aOt().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            aOt().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.writeImagesInfo != null) {
            bundle.putString(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.dyk);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.dym.cHU() == null) {
            WriteData vi = this.dyo.vi(str);
            if (vi != null && this.NQ != null) {
                vi.setBaijiahaoData(this.NQ.getBaijiahaoData());
            }
            this.dym.d(vi);
        }
        if (this.dym.cHU() != null) {
            if (this.dyv) {
                this.dym.cHU().setCanNoForum(true);
                if (this.dyp != null) {
                    this.dym.cHU().setVForumId(this.dyp.getId());
                    this.dym.cHU().setVForumName(this.dyp.getName());
                }
            } else {
                this.dym.cHU().setCanNoForum(false);
                this.dym.cHU().setVForumId("");
                this.dym.cHU().setVForumName("");
            }
            this.dym.cHU().setIsBJHPost(this.isBJH);
            this.dym.cHU().setWriteImagesInfo(this.writeImagesInfo);
            this.dym.cHU().setVideoInfo(this.mVideoInfo);
            this.dym.sS(this.writeImagesInfo.size() > 0);
            WriteData cHU = this.dym.cHU();
            if (this.dyl == null || !this.dyl.brl()) {
                z = false;
            }
            cHU.setHasLocationData(z);
            if (str == null) {
                this.dym.cHU().setContent(this.mPostContent);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.dym.cHU().setVoice(this.mVoiceModel.getId());
                    this.dym.cHU().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.dym.cHU().setVoice(null);
                    this.dym.cHU().setVoiceDuringTime(-1);
                }
            } else {
                this.dym.cHU().setVoice(null);
                this.dym.cHU().setVoiceDuringTime(-1);
            }
            if (!this.dym.cMm()) {
                this.cVh.showToast(R.string.write_img_limit);
            } else if (this.dyu == null || !this.dyu.aOQ()) {
                if (this.dyt != null) {
                    this.dyt.aOR();
                }
                if (!this.dym.cMj()) {
                }
            }
        }
    }

    public BaseFragmentActivity aPc() {
        return (BaseFragmentActivity) this.cVh.getPageActivity();
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

    public int aPd() {
        return this.dyr;
    }

    private void aPe() {
        if (aOt() != null) {
            aOt().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void G(ArrayList<String> arrayList) {
        if (aOt() != null) {
            aOt().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void vn(String str) {
        if (aOt() != null) {
            aOt().b(new com.baidu.tbadk.editortools.a(44, 27, str));
        }
    }

    private void aPf() {
        if (aOt() != null) {
            aOt().b(new com.baidu.tbadk.editortools.a(2, 19, HanziToPinyin.Token.SEPARATOR));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.dyr = i;
        if (aOt() != null) {
            aOt().b(new com.baidu.tbadk.editortools.a(19, 27, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void vo(String str) {
        if (aOt() != null) {
            aOt().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gJ(boolean z) {
        if (aOt() != null) {
            if (z) {
                aOt().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                aOt().b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
            aOt().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.dys = dVar;
    }

    public void a(c cVar) {
        this.dyt = cVar;
    }

    public void a(b bVar) {
        this.dyu = bVar;
    }

    public boolean aPg() {
        LinkedList<ImageFileInfo> chosedFiles;
        return (this.writeImagesInfo == null || (chosedFiles = this.writeImagesInfo.getChosedFiles()) == null || chosedFiles.isEmpty()) ? false : true;
    }

    public boolean aPh() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    private void aPi() {
        if (this.dyx == null && aOt() != null) {
            this.dyx = (f) aOt().mp(27);
        }
    }

    public void aPj() {
        if (this.dyx != null && this.dyw != null) {
            this.dyx.d(this.dyw);
        }
    }

    public void b(TextWatcher textWatcher) {
        aPi();
        if (this.dyx != null && textWatcher != null) {
            this.dyx.c(textWatcher);
        }
    }

    public void aOD() {
        if (this.dwp != null) {
            this.dwp.aOD();
        }
    }
}
