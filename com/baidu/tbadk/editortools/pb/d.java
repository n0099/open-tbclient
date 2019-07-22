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
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.ubc.UBC;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class d extends com.baidu.tbadk.editortools.d implements t.a {
    private long authorId;
    private String authorName;
    private String authorNameShow;
    private EditorTools crG;
    private String ctA;
    private String ctB;
    private LocationModel ctC;
    private NewWriteModel ctD;
    private ImageModel ctE;
    private DataModel<?> ctF;
    private ForumData ctG;
    private String ctH;
    private int ctI;
    private NewWriteModel.d ctJ;
    private c ctK;
    private b ctL;
    private boolean ctM;
    private TextWatcher ctN;
    private e ctO;
    private LocationModel.a ctP;
    private LocationModel.b ctQ;
    private final NewWriteModel.d ctR;
    private final com.baidu.adp.base.d ctS;
    private BaseActivity<?> mContext;
    private String mThreadId;
    private VideoInfo mVideoInfo;
    private VoiceData.VoiceModel mVoiceModel;
    private String postId;
    private WriteImagesInfo writeImagesInfo;

    public d(EditorTools editorTools) {
        super(editorTools);
        this.writeImagesInfo = new WriteImagesInfo();
        this.ctA = "";
        this.ctD = null;
        this.ctE = null;
        this.mThreadId = null;
        this.ctH = null;
        this.ctI = 0;
        this.ctM = false;
        this.ctP = new LocationModel.a() { // from class: com.baidu.tbadk.editortools.pb.d.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void asP() {
                d.this.mContext.showToast(R.string.no_network_guide);
                d.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                BaseActivity baseActivity = d.this.mContext;
                if (StringUtils.isNull(str)) {
                    str = d.this.arY().getContext().getString(R.string.location_fail);
                }
                baseActivity.showToast(str);
                d.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.cpT())) {
                    d.this.b(2, true, aVar.cpT());
                } else {
                    onFail(null);
                }
            }
        };
        this.ctQ = new LocationModel.b() { // from class: com.baidu.tbadk.editortools.pb.d.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void asQ() {
                d.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void qu(String str) {
                d.this.b(2, true, str);
            }
        };
        this.ctR = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.d.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
                WriteData writeData2 = writeData == null ? d.this.ctD.getWriteData() : writeData;
                if (z) {
                    d.this.fp(true);
                    WriteData writeData3 = d.this.ctD.getWriteData();
                    d.this.resetData();
                    t.d(d.this.mThreadId, (WriteData) null);
                    if (writeData3 != null) {
                        if (writeData3 != null && writeData3.getType() == 2) {
                            t.a(writeData3.getThreadId(), d.this);
                        }
                    } else {
                        return;
                    }
                } else if (writeData2 != null && xVar != null && !TextUtils.isEmpty(xVar.amE())) {
                    writeData2.setVcodeMD5(xVar.getVcode_md5());
                    writeData2.setVcodeUrl(xVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(xVar.amF());
                    if (com.baidu.tbadk.v.a.ru(xVar.amE())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(d.this.mContext.getActivity(), 12006, writeData2, false, xVar.amE())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(d.this.mContext.getActivity(), writeData2, 12006)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(d.this.mContext.getActivity(), 12006, writeData2, postWriteCallBackData.getAccessState())));
                }
                d.this.b(d.this.ctD.getWriteData());
                if (d.this.ctJ != null) {
                    d.this.ctJ.callback(z, postWriteCallBackData, xVar, writeData2, antiData);
                }
            }
        };
        this.ctS = new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.editortools.pb.d.7
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (obj instanceof Bitmap) {
                    d.this.ctD.ri(true);
                }
            }
        };
        this.crG = editorTools;
    }

    public void kv(int i) {
        if (this.ctO == null && arY() != null) {
            this.ctO = (e) arY().kp(27);
        }
        if (this.ctO != null) {
            this.ctO.setType(i);
        }
    }

    public void kw(int i) {
        if (this.ctO == null && arY() != null) {
            this.ctO = (e) arY().kp(27);
        }
        if (this.ctO != null) {
            this.ctO.kx(i);
        }
    }

    public e asy() {
        if (this.ctO == null && arY() != null) {
            this.ctO = (e) arY().kp(27);
        }
        return this.ctO;
    }

    public void qo(String str) {
        if (this.ctO == null && arY() != null) {
            this.ctO = (e) arY().kp(27);
        }
        if (this.ctO != null) {
            this.ctO.setHint(str);
        }
    }

    public void fl(boolean z) {
        BLauncher bLauncher;
        if (arY() != null && (bLauncher = (BLauncher) arY().km(5)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void fm(boolean z) {
        BLauncher bLauncher;
        if (arY() != null && (bLauncher = (BLauncher) arY().km(23)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void fn(boolean z) {
        BLauncher bLauncher;
        if (arY() != null && (bLauncher = (BLauncher) arY().km(2)) != null) {
            bLauncher.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.ctF = dataModel;
    }

    public void b(BaseActivity<?> baseActivity) {
        this.mContext = baseActivity;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.ctH = antiData.getVoice_message();
        }
    }

    public void a(ForumData forumData, UserData userData) {
        this.ctG = forumData;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (arY() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.authorNameShow = metaData.getName_show();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void fo(boolean z) {
        this.ctM = z;
    }

    public void asz() {
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
                            O(intent);
                        } else {
                            Q(intent);
                        }
                        arY().invalidate();
                        return;
                    }
                    return;
                case 12003:
                    if (intent != null) {
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            asJ();
                            this.ctD.ri(false);
                            return;
                        }
                        this.ctE.qn(intent.getStringExtra("file_name"));
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
                    WriteData writeData = this.ctD.getWriteData();
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (writeData != null) {
                        writeData.deleteUploadedTempImages();
                    }
                    this.ctD.setWriteData(null);
                    this.ctD.ri(false);
                    this.mVoiceModel = null;
                    this.mVideoInfo = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        t.d(this.mThreadId, (WriteData) null);
                    }
                    fp(true);
                    if (this.ctJ != null) {
                        this.ctJ.callback(true, postWriteCallBackData, null, writeData, null);
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    if (i == 12010) {
                        O(intent);
                        return;
                    }
                    return;
                case 12012:
                    P(intent);
                    return;
                case 13010:
                    if (arY() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            an anVar = new an("c10068");
                            anVar.P(UBC.CONTENT_KEY_DURATION, this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(anVar);
                            asK();
                            arY().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            arY().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                asH();
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
                if (this.ctJ != null) {
                    this.ctJ.callback(false, postWriteCallBackData2, null, this.ctD.getWriteData(), null);
                    return;
                }
                return;
        }
    }

    public void asA() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(this.mContext.getActivity())));
    }

    public void asB() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.mContext.getActivity())) {
            this.mContext.showToast((int) R.string.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            asD();
        } else if (this.ctC.cpZ()) {
            asA();
        } else {
            this.ctC.rg(false);
            b(1, true, null);
            this.ctC.cpX();
        }
    }

    public void asC() {
        if (this.ctC != null && !com.baidu.tieba.tbadkCore.location.c.cpV().cpW() && UtilHelper.isSystemLocationProviderEnabled(this.mContext.getActivity()) && TbadkCoreApplication.getInst().getLocationShared()) {
            this.ctC.cpX();
        }
    }

    private void asD() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getActivity());
        aVar.hu(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tbadk.editortools.pb.d.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.kc()) {
                    d.this.b(1, true, null);
                    d.this.ctC.aVE();
                } else {
                    d.this.ctP.asP();
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
        aVar.agI();
    }

    public void asE() {
        if (this.ctC.aVA()) {
            if (this.ctC.cpZ()) {
                this.ctP.a(com.baidu.tieba.tbadkCore.location.c.cpV().getLocationData());
                return;
            }
            if (l.kt()) {
                this.ctC.cpX();
            }
            b(0, true, null);
            return;
        }
        b(0, false, null);
    }

    public boolean asF() {
        if (StringUtils.isNull(this.ctA)) {
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
        this.ctD.setWriteData(null);
        this.ctD.ri(false);
        this.mVoiceModel = null;
        this.mVideoInfo = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void asG() {
        this.mVideoInfo = null;
    }

    private void O(Intent intent) {
        this.ctB = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.ctB;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.mContext.getActivity(), l.af(this.mContext.getActivity())), l.dip2px(this.mContext.getActivity(), l.ah(this.mContext.getActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    m.a(TbConfig.LOCAL_CAMERA_DIR, this.ctB, rotateBitmapBydegree, 100);
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

    private void P(Intent intent) {
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
        pbEditorData.setContent(this.ctA);
        pbEditorData.setWriteImagesInfo(this.writeImagesInfo);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        PbEditorData.ThreadData threadData = new PbEditorData.ThreadData();
        if (this.ctG != null) {
            threadData.setForumId(this.ctG.getId());
            threadData.setForumName(this.ctG.getName());
            threadData.setFirstDir(this.ctG.getFirst_class());
            threadData.setSecondDir(this.ctG.getSecond_class());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.ctH);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.mContext.getActivity(), 25035, pbEditorData, postWriteCallBackData)));
    }

    public void c(p pVar) {
        if (pVar != null) {
            if (pVar.amu() == EmotionGroupType.BIG_EMOTION || pVar.amu() == EmotionGroupType.USER_COLLECT) {
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

    private void asH() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tbadk.editortools.pb.d.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                m.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + d.this.ctB));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void Q(Intent intent) {
        b(intent, true);
    }

    public void qp(String str) {
        WriteData writeData = this.ctD.getWriteData();
        if (writeData == null) {
            writeData = new WriteData(1);
            writeData.setThreadId(str);
            writeData.setWriteImagesInfo(this.writeImagesInfo);
        }
        writeData.setContent(this.ctA);
        writeData.setVideoInfo(this.mVideoInfo);
        t.d(str, writeData);
    }

    public void qq(String str) {
        t.a(str, this);
    }

    @Override // com.baidu.tieba.tbadkCore.t.a
    public void a(WriteData writeData) {
        if (writeData != null) {
            if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                if (this.mVideoInfo == null) {
                    this.mVideoInfo = new VideoInfo();
                }
                this.mVideoInfo.copy(writeData.getVideoInfo());
                asK();
                arY().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                    arY().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                arY().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            if (!aq.isEmpty(writeData.getContent()) && aq.isEmpty(this.ctA)) {
                this.ctA = writeData.getContent();
                qt(this.ctA);
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
                    arY().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
                }
            }
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() == 0) {
                arY().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
            this.ctA = writeData.getContent();
            qt(this.ctA);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004008));
        }
    }

    public void onDestroy() {
        this.ctD.cancelLoadData();
        this.ctE.cancelLoadData();
        this.ctC.cancelLoadData();
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        this.ctD = new NewWriteModel(baseActivity);
        this.ctD.b(this.ctR);
        this.ctE = new ImageModel(baseActivity);
        this.ctE.setLoadDataCallBack(this.ctS);
        this.ctC = new LocationModel(baseActivity);
        this.ctC.a(this.ctP);
        this.ctC.a(this.ctQ);
        if (bundle != null) {
            this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
            this.ctB = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(9);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && arY() != null) {
            arY().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.ctC.aVA() && arY() != null) {
            arY().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            arY().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.writeImagesInfo != null) {
            bundle.putString(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.ctB);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.ctD.getWriteData() == null) {
            this.ctD.setWriteData(this.ctF.qm(str));
        }
        if (this.ctD.getWriteData() != null) {
            if (this.ctM) {
                this.ctD.getWriteData().setCanNoForum(true);
                if (this.ctG != null) {
                    this.ctD.getWriteData().setVForumId(this.ctG.getId());
                    this.ctD.getWriteData().setVForumName(this.ctG.getName());
                }
            } else {
                this.ctD.getWriteData().setCanNoForum(false);
                this.ctD.getWriteData().setVForumId("");
                this.ctD.getWriteData().setVForumName("");
            }
            this.ctD.getWriteData().setWriteImagesInfo(this.writeImagesInfo);
            this.ctD.getWriteData().setVideoInfo(this.mVideoInfo);
            this.ctD.ri(this.writeImagesInfo.size() > 0);
            WriteData writeData2 = this.ctD.getWriteData();
            if (this.ctC == null || !this.ctC.aVA()) {
                z = false;
            }
            writeData2.setHasLocationData(z);
            if (str == null) {
                this.ctD.getWriteData().setContent(this.ctA);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.ctD.getWriteData().setVoice(this.mVoiceModel.getId());
                    this.ctD.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.ctD.getWriteData().setVoice(null);
                    this.ctD.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.ctD.getWriteData().setVoice(null);
                this.ctD.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.ctD.cqB()) {
                this.mContext.showToast((int) R.string.write_img_limit);
            } else if (this.ctL == null || !this.ctL.asw()) {
                if (this.ctK != null) {
                    this.ctK.asx();
                }
                if (!this.ctD.startPostWrite()) {
                }
            }
        }
    }

    public BaseActivity<?> getContext() {
        return this.mContext;
    }

    public void qr(String str) {
        this.ctA = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int asI() {
        return this.ctI;
    }

    private void asJ() {
        if (arY() != null) {
            arY().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void z(ArrayList<String> arrayList) {
        if (arY() != null) {
            arY().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void qs(String str) {
        if (arY() != null) {
            arY().b(new com.baidu.tbadk.editortools.a(44, 27, str));
        }
    }

    private void asK() {
        if (arY() != null) {
            arY().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.ctI = i;
        if (arY() != null) {
            arY().b(new com.baidu.tbadk.editortools.a(19, 27, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void qt(String str) {
        if (arY() != null) {
            arY().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fp(boolean z) {
        if (arY() != null) {
            if (z) {
                arY().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                arY().b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
            arY().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.ctJ = dVar;
    }

    public void a(c cVar) {
        this.ctK = cVar;
    }

    public void a(b bVar) {
        this.ctL = bVar;
    }

    public boolean asL() {
        LinkedList<ImageFileInfo> chosedFiles;
        return (this.writeImagesInfo == null || (chosedFiles = this.writeImagesInfo.getChosedFiles()) == null || chosedFiles.isEmpty()) ? false : true;
    }

    public boolean asM() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    private void asN() {
        if (this.ctO == null && arY() != null) {
            this.ctO = (e) arY().kp(27);
        }
    }

    public void asO() {
        if (this.ctO != null && this.ctN != null) {
            this.ctO.d(this.ctN);
        }
    }

    public void b(TextWatcher textWatcher) {
        asN();
        if (this.ctO != null && textWatcher != null) {
            this.ctO.c(textWatcher);
        }
    }

    public void asj() {
        if (this.crG != null) {
            this.crG.asj();
        }
    }
}
