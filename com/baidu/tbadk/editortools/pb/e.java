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
    private TbPageContext cVg;
    private EditorTools dwo;
    private final com.baidu.adp.base.d dyA;
    private String dyj;
    private LocationModel dyk;
    private NewWriteModel dyl;
    private ImageModel dym;
    private DataModel<?> dyn;
    private ForumData dyo;
    private String dyp;
    private int dyq;
    private NewWriteModel.d dyr;
    private c dys;
    private b dyt;
    private boolean dyu;
    private TextWatcher dyv;
    private f dyw;
    private LocationModel.a dyx;
    private LocationModel.b dyy;
    private final NewWriteModel.d dyz;
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
        this.dyl = null;
        this.dym = null;
        this.mThreadId = null;
        this.dyp = null;
        this.dyq = 0;
        this.dyu = false;
        this.dyx = new LocationModel.a() { // from class: com.baidu.tbadk.editortools.pb.e.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void aPi() {
                e.this.cVg.showToast(R.string.no_network_guide);
                e.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                TbPageContext tbPageContext = e.this.cVg;
                if (StringUtils.isNull(str)) {
                    str = e.this.aOr().getContext().getString(R.string.location_fail);
                }
                tbPageContext.showToast(str);
                e.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.cLC())) {
                    e.this.a(2, true, aVar.cLC());
                } else {
                    onFail(null);
                }
            }
        };
        this.dyy = new LocationModel.b() { // from class: com.baidu.tbadk.editortools.pb.e.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void aPj() {
                e.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void vp(String str) {
                e.this.a(2, true, str);
            }
        };
        this.dyz = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.e.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
                WriteData cHS = writeData == null ? e.this.dyl.cHS() : writeData;
                if (z) {
                    e.this.gJ(true);
                    WriteData cHS2 = e.this.dyl.cHS();
                    e.this.resetData();
                    v.d(e.this.mThreadId, (WriteData) null);
                    if (cHS2 != null) {
                        if (cHS2.getType() == 2) {
                            v.a(cHS2.getThreadId(), e.this);
                        }
                    } else {
                        return;
                    }
                } else if (cHS != null && aaVar != null && !TextUtils.isEmpty(aaVar.aJD())) {
                    cHS.setVcodeMD5(aaVar.getVcode_md5());
                    cHS.setVcodeUrl(aaVar.getVcode_pic_url());
                    cHS.setVcodeExtra(aaVar.aJE());
                    if (e.this.NQ != null) {
                        cHS.setBaijiahaoData(e.this.NQ.getBaijiahaoData());
                    }
                    if (com.baidu.tbadk.s.a.wa(aaVar.aJD())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(e.this.cVg.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cHS, false, aaVar.aJD())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(e.this.cVg.getPageActivity(), cHS, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(e.this.cVg.getPageActivity(), RequestResponseCode.REQUEST_VCODE, cHS, postWriteCallBackData.getAccessState())));
                }
                e.this.b(e.this.dyl.cHS());
                if (e.this.dyr != null) {
                    e.this.dyr.callback(z, postWriteCallBackData, aaVar, cHS, antiData);
                }
            }
        };
        this.dyA = new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.editortools.pb.e.7
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Bitmap) {
                    e.this.dyl.sS(true);
                }
            }
        };
        this.dwo = editorTools;
    }

    public void mv(int i) {
        if (this.dyw == null && aOr() != null) {
            this.dyw = (f) aOr().mp(27);
        }
        if (this.dyw != null) {
            this.dyw.setType(i);
        }
    }

    public void mw(int i) {
        if (this.dyw == null && aOr() != null) {
            this.dyw = (f) aOr().mp(27);
        }
        if (this.dyw != null) {
            this.dyw.mx(i);
        }
    }

    public f aOQ() {
        if (this.dyw == null && aOr() != null) {
            this.dyw = (f) aOr().mp(27);
        }
        return this.dyw;
    }

    public void vk(String str) {
        if (this.dyw == null && aOr() != null) {
            this.dyw = (f) aOr().mp(27);
        }
        if (this.dyw != null) {
            this.dyw.setHint(str);
        }
    }

    public void gF(boolean z) {
        BLauncher bLauncher;
        if (aOr() != null && (bLauncher = (BLauncher) aOr().mm(5)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void gG(boolean z) {
        BLauncher bLauncher;
        if (aOr() != null && (bLauncher = (BLauncher) aOr().mm(23)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void gH(boolean z) {
        BLauncher bLauncher;
        if (aOr() != null && (bLauncher = (BLauncher) aOr().mm(2)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.dyn = dataModel;
    }

    public void a(TbPageContext tbPageContext) {
        this.cVg = tbPageContext;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.dyp = antiData.getVoice_message();
        }
    }

    public void a(ForumData forumData, UserData userData) {
        this.dyo = forumData;
    }

    public void setThreadData(bj bjVar) {
        this.NQ = bjVar;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (aOr() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.authorNameShow = metaData.getName_show();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void gI(boolean z) {
        this.dyu = z;
    }

    public void aOR() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            if (String.valueOf(this.authorId).equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                l.showToast(this.cVg.getPageActivity(), (int) R.string.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.cVg.getPageActivity(), this.authorId, this.authorName, this.authorNameShow, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.f.b.toLong(this.mThreadId, 0L), com.baidu.adp.lib.f.b.toLong(this.postId, 0L))));
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.cVg.getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_LOGIN_SUB_PB_AT /* 11026 */:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.cVg.getPageActivity(), RequestResponseCode.REQUEST_SUB_PB_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("camera_result", false)) {
                            T(intent);
                        } else {
                            V(intent);
                        }
                        aOr().invalidate();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_IMAGE_VIEW /* 12003 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("delete", false)) {
                            aPc();
                            this.dyl.sS(false);
                            return;
                        }
                        this.dym.vj(intent.getStringExtra("file_name"));
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
                    WriteData cHS = this.dyl.cHS();
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (cHS != null) {
                        cHS.deleteUploadedTempImages();
                    }
                    this.dyl.d((WriteData) null);
                    this.dyl.sS(false);
                    this.mVoiceModel = null;
                    this.mVideoInfo = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        v.d(this.mThreadId, (WriteData) null);
                    }
                    gJ(true);
                    if (this.dyr != null) {
                        this.dyr.callback(true, postWriteCallBackData, null, cHS, null);
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
                    if (aOr() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            an anVar = new an(TbadkCoreStatisticKey.XIAOYING_DURATION);
                            anVar.X("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(anVar);
                            aPd();
                            aOr().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            aOr().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                aOZ();
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
                if (this.dyr != null) {
                    this.dyr.callback(false, postWriteCallBackData2, null, this.dyl.cHS(), null);
                    return;
                }
                return;
        }
    }

    public void aOS() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.cVg.getPageActivity())));
    }

    public void aOT() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.cVg.getPageActivity())) {
            this.cVg.showToast(R.string.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            aOV();
        } else if (this.dyk.cLJ()) {
            aOS();
        } else {
            this.dyk.sQ(false);
            a(1, true, (String) null);
            this.dyk.cLH();
        }
    }

    public void aOU() {
        if (!this.isBJH && this.dyk != null && !com.baidu.tieba.tbadkCore.location.c.cLE().cLF() && UtilHelper.isSystemLocationProviderEnabled(this.cVg.getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared()) {
            this.dyk.cLH();
        }
    }

    private void aOV() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVg.getPageActivity());
        aVar.jW(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    e.this.a(1, true, (String) null);
                    e.this.dyk.cLL();
                } else {
                    e.this.dyx.aPi();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                e.this.a(0, true, (String) null);
                aVar2.dismiss();
            }
        }).b(this.cVg);
        aVar.aEA();
    }

    public void aOW() {
        if (this.dyk.brj()) {
            if (this.dyk.cLJ()) {
                this.dyx.a(com.baidu.tieba.tbadkCore.location.c.cLE().getLocationData());
                return;
            }
            if (l.isNetOk()) {
                this.dyk.cLH();
            }
            a(0, true, (String) null);
            return;
        }
        a(0, false, (String) null);
    }

    public boolean aOX() {
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
        this.dyl.d((WriteData) null);
        this.dyl.sS(false);
        this.mVoiceModel = null;
        this.mVideoInfo = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void aOY() {
        this.mVideoInfo = null;
    }

    private void T(Intent intent) {
        this.dyj = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.dyj;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.cVg.getPageActivity(), l.getEquipmentWidth(this.cVg.getPageActivity())), l.dip2px(this.cVg.getPageActivity(), l.getEquipmentHeight(this.cVg.getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    m.a("cameras", this.dyj, rotateBitmapBydegree, 100);
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
        if (this.dyo != null) {
            threadData.setForumId(this.dyo.getId());
            threadData.setForumName(this.dyo.getName());
            threadData.setFirstDir(this.dyo.getFirst_class());
            threadData.setSecondDir(this.dyo.getSecond_class());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        threadData.isBJH = this.isBJH;
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.dyp);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.cVg.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void c(q qVar) {
        if (qVar != null) {
            if (qVar.aJu() == EmotionGroupType.BIG_EMOTION || qVar.aJu() == EmotionGroupType.USER_COLLECT) {
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

    private void aOZ() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tbadk.editortools.pb.e.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                m.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + e.this.dyj));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void V(Intent intent) {
        b(intent, true);
    }

    public void saveDraft(String str) {
        WriteData cHS = this.dyl.cHS();
        if (cHS == null) {
            cHS = new WriteData(1);
            cHS.setThreadId(str);
            cHS.setWriteImagesInfo(this.writeImagesInfo);
        }
        cHS.setContent(this.mPostContent);
        cHS.setVideoInfo(this.mVideoInfo);
        cHS.setVoiceModel(this.mVoiceModel);
        v.d(str, cHS);
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
                aPd();
                aOr().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                    aOr().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                aOr().b(new com.baidu.tbadk.editortools.a(2, 10, null));
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
                    aOr().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                aOr().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.mPostContent = writeData.getContent();
            vo(this.mPostContent);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.dyl.cancelLoadData();
        this.dym.cancelLoadData();
        this.dyk.cancelLoadData();
    }

    public void a(TbPageContext tbPageContext, Bundle bundle) {
        this.dyl = new NewWriteModel(tbPageContext);
        this.dyl.b(this.dyz);
        this.dym = new ImageModel(tbPageContext);
        this.dym.setLoadDataCallBack(this.dyA);
        this.dyk = new LocationModel(tbPageContext);
        this.dyk.a(this.dyx);
        this.dyk.a(this.dyy);
        if (bundle != null) {
            this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
            this.dyj = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(this.isBJH ? 1 : 9);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && aOr() != null) {
            aOr().b(new com.baidu.tbadk.editortools.a(2, 12, HanziToPinyin.Token.SEPARATOR));
        }
        if (!this.dyk.brj() && aOr() != null) {
            aOr().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            aOr().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.writeImagesInfo != null) {
            bundle.putString(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.dyj);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.dyl.cHS() == null) {
            WriteData vi = this.dyn.vi(str);
            if (vi != null && this.NQ != null) {
                vi.setBaijiahaoData(this.NQ.getBaijiahaoData());
            }
            this.dyl.d(vi);
        }
        if (this.dyl.cHS() != null) {
            if (this.dyu) {
                this.dyl.cHS().setCanNoForum(true);
                if (this.dyo != null) {
                    this.dyl.cHS().setVForumId(this.dyo.getId());
                    this.dyl.cHS().setVForumName(this.dyo.getName());
                }
            } else {
                this.dyl.cHS().setCanNoForum(false);
                this.dyl.cHS().setVForumId("");
                this.dyl.cHS().setVForumName("");
            }
            this.dyl.cHS().setIsBJHPost(this.isBJH);
            this.dyl.cHS().setWriteImagesInfo(this.writeImagesInfo);
            this.dyl.cHS().setVideoInfo(this.mVideoInfo);
            this.dyl.sS(this.writeImagesInfo.size() > 0);
            WriteData cHS = this.dyl.cHS();
            if (this.dyk == null || !this.dyk.brj()) {
                z = false;
            }
            cHS.setHasLocationData(z);
            if (str == null) {
                this.dyl.cHS().setContent(this.mPostContent);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.dyl.cHS().setVoice(this.mVoiceModel.getId());
                    this.dyl.cHS().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.dyl.cHS().setVoice(null);
                    this.dyl.cHS().setVoiceDuringTime(-1);
                }
            } else {
                this.dyl.cHS().setVoice(null);
                this.dyl.cHS().setVoiceDuringTime(-1);
            }
            if (!this.dyl.cMk()) {
                this.cVg.showToast(R.string.write_img_limit);
            } else if (this.dyt == null || !this.dyt.aOO()) {
                if (this.dys != null) {
                    this.dys.aOP();
                }
                if (!this.dyl.cMh()) {
                }
            }
        }
    }

    public BaseFragmentActivity aPa() {
        return (BaseFragmentActivity) this.cVg.getPageActivity();
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

    public int aPb() {
        return this.dyq;
    }

    private void aPc() {
        if (aOr() != null) {
            aOr().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void G(ArrayList<String> arrayList) {
        if (aOr() != null) {
            aOr().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void vn(String str) {
        if (aOr() != null) {
            aOr().b(new com.baidu.tbadk.editortools.a(44, 27, str));
        }
    }

    private void aPd() {
        if (aOr() != null) {
            aOr().b(new com.baidu.tbadk.editortools.a(2, 19, HanziToPinyin.Token.SEPARATOR));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.dyq = i;
        if (aOr() != null) {
            aOr().b(new com.baidu.tbadk.editortools.a(19, 27, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void vo(String str) {
        if (aOr() != null) {
            aOr().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gJ(boolean z) {
        if (aOr() != null) {
            if (z) {
                aOr().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                aOr().b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
            aOr().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.dyr = dVar;
    }

    public void a(c cVar) {
        this.dys = cVar;
    }

    public void a(b bVar) {
        this.dyt = bVar;
    }

    public boolean aPe() {
        LinkedList<ImageFileInfo> chosedFiles;
        return (this.writeImagesInfo == null || (chosedFiles = this.writeImagesInfo.getChosedFiles()) == null || chosedFiles.isEmpty()) ? false : true;
    }

    public boolean aPf() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    private void aPg() {
        if (this.dyw == null && aOr() != null) {
            this.dyw = (f) aOr().mp(27);
        }
    }

    public void aPh() {
        if (this.dyw != null && this.dyv != null) {
            this.dyw.d(this.dyv);
        }
    }

    public void b(TextWatcher textWatcher) {
        aPg();
        if (this.dyw != null && textWatcher != null) {
            this.dyw.c(textWatcher);
        }
    }

    public void aOB() {
        if (this.dwo != null) {
            this.dwo.aOB();
        }
    }
}
