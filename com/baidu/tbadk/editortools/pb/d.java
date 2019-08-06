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
import com.baidu.sapi2.utils.SapiGIDEvent;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
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
import com.baidu.tbadk.coreExtra.data.x;
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
import com.baidu.ubc.UBC;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class d extends com.baidu.tbadk.editortools.d implements v.a {
    private long authorId;
    private String authorName;
    private String authorNameShow;
    private EditorTools crN;
    private String ctH;
    private String ctI;
    private LocationModel ctJ;
    private NewWriteModel ctK;
    private ImageModel ctL;
    private DataModel<?> ctM;
    private ForumData ctN;
    private String ctO;
    private int ctP;
    private NewWriteModel.d ctQ;
    private c ctR;
    private b ctS;
    private boolean ctT;
    private TextWatcher ctU;
    private e ctV;
    private LocationModel.a ctW;
    private LocationModel.b ctX;
    private final NewWriteModel.d ctY;
    private final com.baidu.adp.base.d ctZ;
    private BaseActivity<?> mContext;
    private String mThreadId;
    private VideoInfo mVideoInfo;
    private VoiceData.VoiceModel mVoiceModel;
    private String postId;
    private WriteImagesInfo writeImagesInfo;

    public d(EditorTools editorTools) {
        super(editorTools);
        this.writeImagesInfo = new WriteImagesInfo();
        this.ctH = "";
        this.ctK = null;
        this.ctL = null;
        this.mThreadId = null;
        this.ctO = null;
        this.ctP = 0;
        this.ctT = false;
        this.ctW = new LocationModel.a() { // from class: com.baidu.tbadk.editortools.pb.d.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void asR() {
                d.this.mContext.showToast(R.string.no_network_guide);
                d.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                BaseActivity baseActivity = d.this.mContext;
                if (StringUtils.isNull(str)) {
                    str = d.this.asa().getContext().getString(R.string.location_fail);
                }
                baseActivity.showToast(str);
                d.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.cqp())) {
                    d.this.b(2, true, aVar.cqp());
                } else {
                    onFail(null);
                }
            }
        };
        this.ctX = new LocationModel.b() { // from class: com.baidu.tbadk.editortools.pb.d.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void asS() {
                d.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void qu(String str) {
                d.this.b(2, true, str);
            }
        };
        this.ctY = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.d.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
                WriteData writeData2 = writeData == null ? d.this.ctK.getWriteData() : writeData;
                if (z) {
                    d.this.fp(true);
                    WriteData writeData3 = d.this.ctK.getWriteData();
                    d.this.resetData();
                    v.d(d.this.mThreadId, (WriteData) null);
                    if (writeData3 != null) {
                        if (writeData3 != null && writeData3.getType() == 2) {
                            v.a(writeData3.getThreadId(), d.this);
                        }
                    } else {
                        return;
                    }
                } else if (writeData2 != null && xVar != null && !TextUtils.isEmpty(xVar.amG())) {
                    writeData2.setVcodeMD5(xVar.getVcode_md5());
                    writeData2.setVcodeUrl(xVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(xVar.amH());
                    if (com.baidu.tbadk.v.a.ru(xVar.amG())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(d.this.mContext.getActivity(), 12006, writeData2, false, xVar.amG())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(d.this.mContext.getActivity(), writeData2, 12006)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(d.this.mContext.getActivity(), 12006, writeData2, postWriteCallBackData.getAccessState())));
                }
                d.this.b(d.this.ctK.getWriteData());
                if (d.this.ctQ != null) {
                    d.this.ctQ.callback(z, postWriteCallBackData, xVar, writeData2, antiData);
                }
            }
        };
        this.ctZ = new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.editortools.pb.d.7
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (obj instanceof Bitmap) {
                    d.this.ctK.rj(true);
                }
            }
        };
        this.crN = editorTools;
    }

    public void kw(int i) {
        if (this.ctV == null && asa() != null) {
            this.ctV = (e) asa().kq(27);
        }
        if (this.ctV != null) {
            this.ctV.setType(i);
        }
    }

    public void kx(int i) {
        if (this.ctV == null && asa() != null) {
            this.ctV = (e) asa().kq(27);
        }
        if (this.ctV != null) {
            this.ctV.ky(i);
        }
    }

    public e asA() {
        if (this.ctV == null && asa() != null) {
            this.ctV = (e) asa().kq(27);
        }
        return this.ctV;
    }

    public void qo(String str) {
        if (this.ctV == null && asa() != null) {
            this.ctV = (e) asa().kq(27);
        }
        if (this.ctV != null) {
            this.ctV.setHint(str);
        }
    }

    public void fl(boolean z) {
        BLauncher bLauncher;
        if (asa() != null && (bLauncher = (BLauncher) asa().kn(5)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void fm(boolean z) {
        BLauncher bLauncher;
        if (asa() != null && (bLauncher = (BLauncher) asa().kn(23)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void fn(boolean z) {
        BLauncher bLauncher;
        if (asa() != null && (bLauncher = (BLauncher) asa().kn(2)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.ctM = dataModel;
    }

    public void b(BaseActivity<?> baseActivity) {
        this.mContext = baseActivity;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.ctO = antiData.getVoice_message();
        }
    }

    public void a(ForumData forumData, UserData userData) {
        this.ctN = forumData;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (asa() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.authorNameShow = metaData.getName_show();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void fo(boolean z) {
        this.ctT = z;
    }

    public void asB() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            String valueOf = String.valueOf(this.authorId);
            if (valueOf == null || valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                l.showToast(this.mContext.getActivity(), (int) R.string.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(this.mContext.getActivity(), this.authorId, this.authorName, this.authorNameShow, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.g.b.c(this.mThreadId, 0L), com.baidu.adp.lib.g.b.c(this.postId, 0L))));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        if (i2 == -1) {
            switch (i) {
                case SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE /* 11001 */:
                    a((String) null, (WriteData) null);
                    return;
                case 11025:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.mContext.getActivity(), 12004, true)));
                    return;
                case 11026:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.mContext.getActivity(), 12005, true)));
                    return;
                case 12002:
                    if (intent != null) {
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            Q(intent);
                        } else {
                            S(intent);
                        }
                        asa().invalidate();
                        return;
                    }
                    return;
                case 12003:
                    if (intent != null) {
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            asL();
                            this.ctK.rj(false);
                            return;
                        }
                        this.ctL.qn(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case 12004:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        z(stringArrayListExtra);
                        return;
                    }
                    return;
                case 12006:
                    WriteData writeData = this.ctK.getWriteData();
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (writeData != null) {
                        writeData.deleteUploadedTempImages();
                    }
                    this.ctK.setWriteData(null);
                    this.ctK.rj(false);
                    this.mVoiceModel = null;
                    this.mVideoInfo = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        v.d(this.mThreadId, (WriteData) null);
                    }
                    fp(true);
                    if (this.ctQ != null) {
                        this.ctQ.callback(true, postWriteCallBackData, null, writeData, null);
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    if (i == 12010) {
                        Q(intent);
                        return;
                    }
                    return;
                case 12012:
                    R(intent);
                    return;
                case 13010:
                    if (asa() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            an anVar = new an("c10068");
                            anVar.P(UBC.CONTENT_KEY_DURATION, this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(anVar);
                            asM();
                            asa().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            asa().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
                            return;
                        }
                        return;
                    }
                    return;
                case 23004:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
                    return;
                case 25004:
                    if (intent != null) {
                        qs(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case SapiGIDEvent.TIME_FREQ /* 12001 */:
                asJ();
                return;
            case 12002:
                if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                    this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    return;
                }
                return;
            case 12003:
            case 12004:
            case 12005:
            case 12007:
            case 12008:
            case 12009:
            case 12010:
            default:
                return;
            case 12006:
                PostWriteCallBackData postWriteCallBackData2 = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                if (this.ctQ != null) {
                    this.ctQ.callback(false, postWriteCallBackData2, null, this.ctK.getWriteData(), null);
                    return;
                }
                return;
        }
    }

    public void asC() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(this.mContext.getActivity())));
    }

    public void asD() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.mContext.getActivity())) {
            this.mContext.showToast((int) R.string.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            asF();
        } else if (this.ctJ.cqv()) {
            asC();
        } else {
            this.ctJ.rh(false);
            b(1, true, null);
            this.ctJ.cqt();
        }
    }

    public void asE() {
        if (this.ctJ != null && !com.baidu.tieba.tbadkCore.location.c.cqr().cqs() && UtilHelper.isSystemLocationProviderEnabled(this.mContext.getActivity()) && TbadkCoreApplication.getInst().getLocationShared()) {
            this.ctJ.cqt();
        }
    }

    private void asF() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getActivity());
        aVar.hu(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tbadk.editortools.pb.d.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.kc()) {
                    d.this.b(1, true, null);
                    d.this.ctJ.aVG();
                } else {
                    d.this.ctW.asR();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.editortools.pb.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                d.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(this.mContext.getPageContext());
        aVar.agK();
    }

    public void asG() {
        if (this.ctJ.aVC()) {
            if (this.ctJ.cqv()) {
                this.ctW.a(com.baidu.tieba.tbadkCore.location.c.cqr().getLocationData());
                return;
            }
            if (l.kt()) {
                this.ctJ.cqt();
            }
            b(0, true, null);
            return;
        }
        b(0, false, null);
    }

    public boolean asH() {
        if (StringUtils.isNull(this.ctH)) {
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
        this.ctK.setWriteData(null);
        this.ctK.rj(false);
        this.mVoiceModel = null;
        this.mVideoInfo = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void asI() {
        this.mVideoInfo = null;
    }

    private void Q(Intent intent) {
        this.ctI = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.ctI;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.mContext.getActivity(), l.af(this.mContext.getActivity())), l.dip2px(this.mContext.getActivity(), l.ah(this.mContext.getActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    m.a(TbConfig.LOCAL_CAMERA_DIR, this.ctI, rotateBitmapBydegree, 100);
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

    private void R(Intent intent) {
        b(intent, false);
    }

    private void b(Intent intent, boolean z) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
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
        pbEditorData.setContent(this.ctH);
        pbEditorData.setWriteImagesInfo(this.writeImagesInfo);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        PbEditorData.ThreadData threadData = new PbEditorData.ThreadData();
        if (this.ctN != null) {
            threadData.setForumId(this.ctN.getId());
            threadData.setForumName(this.ctN.getName());
            threadData.setFirstDir(this.ctN.getFirst_class());
            threadData.setSecondDir(this.ctN.getSecond_class());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.ctO);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.mContext.getActivity(), 25035, pbEditorData, postWriteCallBackData)));
    }

    public void c(p pVar) {
        if (pVar != null) {
            if (pVar.amw() == EmotionGroupType.BIG_EMOTION || pVar.amw() == EmotionGroupType.USER_COLLECT) {
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

    private void asJ() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tbadk.editortools.pb.d.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                m.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + d.this.ctI));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void S(Intent intent) {
        b(intent, true);
    }

    public void qp(String str) {
        WriteData writeData = this.ctK.getWriteData();
        if (writeData == null) {
            writeData = new WriteData(1);
            writeData.setThreadId(str);
            writeData.setWriteImagesInfo(this.writeImagesInfo);
        }
        writeData.setContent(this.ctH);
        writeData.setVideoInfo(this.mVideoInfo);
        v.d(str, writeData);
    }

    public void qq(String str) {
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
                asM();
                asa().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                    asa().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                asa().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            if (!aq.isEmpty(writeData.getContent()) && aq.isEmpty(this.ctH)) {
                this.ctH = writeData.getContent();
                qt(this.ctH);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004008));
        }
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            this.writeImagesInfo = new WriteImagesInfo();
            if (writeData.getWriteImagesInfo() != null) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                    asa().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                asa().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.ctH = writeData.getContent();
            qt(this.ctH);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004008));
        }
    }

    public void onDestroy() {
        this.ctK.cancelLoadData();
        this.ctL.cancelLoadData();
        this.ctJ.cancelLoadData();
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        this.ctK = new NewWriteModel(baseActivity);
        this.ctK.b(this.ctY);
        this.ctL = new ImageModel(baseActivity);
        this.ctL.setLoadDataCallBack(this.ctZ);
        this.ctJ = new LocationModel(baseActivity);
        this.ctJ.a(this.ctW);
        this.ctJ.a(this.ctX);
        if (bundle != null) {
            this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
            this.ctI = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(9);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && asa() != null) {
            asa().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.ctJ.aVC() && asa() != null) {
            asa().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            asa().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.writeImagesInfo != null) {
            bundle.putString(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.ctI);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.ctK.getWriteData() == null) {
            this.ctK.setWriteData(this.ctM.qm(str));
        }
        if (this.ctK.getWriteData() != null) {
            if (this.ctT) {
                this.ctK.getWriteData().setCanNoForum(true);
                if (this.ctN != null) {
                    this.ctK.getWriteData().setVForumId(this.ctN.getId());
                    this.ctK.getWriteData().setVForumName(this.ctN.getName());
                }
            } else {
                this.ctK.getWriteData().setCanNoForum(false);
                this.ctK.getWriteData().setVForumId("");
                this.ctK.getWriteData().setVForumName("");
            }
            this.ctK.getWriteData().setWriteImagesInfo(this.writeImagesInfo);
            this.ctK.getWriteData().setVideoInfo(this.mVideoInfo);
            this.ctK.rj(this.writeImagesInfo.size() > 0);
            WriteData writeData2 = this.ctK.getWriteData();
            if (this.ctJ == null || !this.ctJ.aVC()) {
                z = false;
            }
            writeData2.setHasLocationData(z);
            if (str == null) {
                this.ctK.getWriteData().setContent(this.ctH);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.ctK.getWriteData().setVoice(this.mVoiceModel.getId());
                    this.ctK.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.ctK.getWriteData().setVoice(null);
                    this.ctK.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.ctK.getWriteData().setVoice(null);
                this.ctK.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.ctK.cqX()) {
                this.mContext.showToast((int) R.string.write_img_limit);
            } else if (this.ctS == null || !this.ctS.asy()) {
                if (this.ctR != null) {
                    this.ctR.asz();
                }
                if (!this.ctK.startPostWrite()) {
                }
            }
        }
    }

    public BaseActivity<?> getContext() {
        return this.mContext;
    }

    public void qr(String str) {
        this.ctH = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int asK() {
        return this.ctP;
    }

    private void asL() {
        if (asa() != null) {
            asa().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void z(ArrayList<String> arrayList) {
        if (asa() != null) {
            asa().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void qs(String str) {
        if (asa() != null) {
            asa().b(new com.baidu.tbadk.editortools.a(44, 27, str));
        }
    }

    private void asM() {
        if (asa() != null) {
            asa().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.ctP = i;
        if (asa() != null) {
            asa().b(new com.baidu.tbadk.editortools.a(19, 27, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void qt(String str) {
        if (asa() != null) {
            asa().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fp(boolean z) {
        if (asa() != null) {
            if (z) {
                asa().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                asa().b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
            asa().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.ctQ = dVar;
    }

    public void a(c cVar) {
        this.ctR = cVar;
    }

    public void a(b bVar) {
        this.ctS = bVar;
    }

    public boolean asN() {
        LinkedList<ImageFileInfo> chosedFiles;
        return (this.writeImagesInfo == null || (chosedFiles = this.writeImagesInfo.getChosedFiles()) == null || chosedFiles.isEmpty()) ? false : true;
    }

    public boolean asO() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    private void asP() {
        if (this.ctV == null && asa() != null) {
            this.ctV = (e) asa().kq(27);
        }
    }

    public void asQ() {
        if (this.ctV != null && this.ctU != null) {
            this.ctV.d(this.ctU);
        }
    }

    public void b(TextWatcher textWatcher) {
        asP();
        if (this.ctV != null && textWatcher != null) {
            this.ctV.c(textWatcher);
        }
    }

    public void asl() {
        if (this.crN != null) {
            this.crN.asl();
        }
    }
}
