package com.baidu.tbadk.editortools.pb;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.EditText;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.x;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.editortools.f implements x.a {
    private LocationModel aAA;
    private NewWriteModel aAB;
    private ImageModel aAC;
    private DataModel<?> aAD;
    private AntiData aAE;
    private ForumData aAF;
    private String aAG;
    private boolean aAH;
    private int aAI;
    private NewWriteModel.d aAJ;
    private b aAK;
    private com.baidu.tbadk.editortools.imagetool.b aAL;
    private com.baidu.tbadk.editortools.inputtool.a aAM;
    private com.baidu.tbadk.editortools.sendtool.a aAN;
    private boolean aAO;
    private LocationModel.a aAP;
    private LocationModel.b aAQ;
    private final NewWriteModel.d aAR;
    private final com.baidu.adp.base.f aAS;
    private String aAx;
    private VoiceData.VoiceModel aAy;
    private String aAz;
    private long authorId;
    private String authorName;
    private BaseActivity<?> mContext;
    private String mGraffitiFileName;
    private String mThreadId;
    private UserData mUserData;
    private VideoInfo mVideoInfo;
    private String postId;
    private WriteImagesInfo writeImagesInfo;

    public c(com.baidu.tbadk.editortools.j jVar) {
        super(jVar);
        this.writeImagesInfo = new WriteImagesInfo();
        this.aAx = "";
        this.aAB = null;
        this.aAC = null;
        this.mThreadId = null;
        this.aAG = null;
        this.aAH = true;
        this.aAI = 0;
        this.aAO = false;
        this.aAP = new d(this);
        this.aAQ = new e(this);
        this.aAR = new f(this);
        this.aAS = new g(this);
    }

    private com.baidu.tbadk.editortools.sendtool.a CK() {
        if (this.aAN == null && Cm() != null) {
            this.aAN = (com.baidu.tbadk.editortools.sendtool.a) Cm().ey(4);
        }
        return this.aAN;
    }

    public void eF(int i) {
        if (this.aAN == null && Cm() != null) {
            this.aAN = (com.baidu.tbadk.editortools.sendtool.a) Cm().ey(4);
        }
        if (this.aAN != null) {
            this.aAN.setType(i);
        }
    }

    public void eG(int i) {
        if (this.aAN == null && Cm() != null) {
            this.aAN = (com.baidu.tbadk.editortools.sendtool.a) Cm().ey(4);
        }
        if (this.aAN != null) {
            this.aAN.eJ(i);
        }
    }

    private com.baidu.tbadk.editortools.imagetool.b CL() {
        if (this.aAL == null && Cm() != null) {
            this.aAL = (com.baidu.tbadk.editortools.imagetool.b) Cm().ey(11);
        }
        return this.aAL;
    }

    public void eH(int i) {
        if (this.aAL == null && Cm() != null) {
            this.aAL = (com.baidu.tbadk.editortools.imagetool.b) Cm().ey(11);
        }
        if (this.aAL != null) {
            this.aAL.eE(i);
        }
    }

    public com.baidu.tbadk.editortools.inputtool.a CM() {
        if (this.aAM == null && Cm() != null) {
            this.aAM = (com.baidu.tbadk.editortools.inputtool.a) Cm().ey(3);
        }
        return this.aAM;
    }

    public void fq(String str) {
        if (this.aAM == null && Cm() != null) {
            this.aAM = (com.baidu.tbadk.editortools.inputtool.a) Cm().ey(3);
        }
        if (this.aAM != null) {
            this.aAM.setHint(str);
        }
    }

    public void bD(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (Cm() != null && (cVar = (com.baidu.tbadk.editortools.c) Cm().ew(5)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bE(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (Cm() != null && (cVar = (com.baidu.tbadk.editortools.c) Cm().ew(23)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bF(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (Cm() != null && (cVar = (com.baidu.tbadk.editortools.c) Cm().ew(2)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.aAD = dataModel;
    }

    public void d(BaseActivity<?> baseActivity) {
        this.mContext = baseActivity;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.aAH = antiData.isIfvoice();
            this.aAG = antiData.getVoice_message();
        }
        this.aAE = antiData;
    }

    public void a(ForumData forumData, UserData userData) {
        this.aAF = forumData;
        this.mUserData = userData;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (Cm() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void bG(boolean z) {
        this.aAO = z;
    }

    public void CN() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            String valueOf = String.valueOf(this.authorId);
            if (valueOf == null || valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                com.baidu.adp.lib.util.k.showToast(this.mContext.getActivity(), w.l.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.mContext.getActivity(), this.authorId, this.authorName, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.g.b.c(this.mThreadId, 0L), com.baidu.adp.lib.g.b.c(this.postId, 0L))));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        com.baidu.tbadk.editortools.p pVar;
        com.baidu.tbadk.editortools.p pVar2;
        com.baidu.tbadk.editortools.p pVar3 = null;
        if (i2 == -1) {
            switch (i) {
                case 11001:
                    a((String) null, (WriteData) null);
                    return;
                case 11025:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.mContext.getActivity(), 12004, true)));
                    return;
                case 11026:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.mContext.getActivity(), 12005, true)));
                    return;
                case 12002:
                    if (intent != null) {
                        boolean booleanExtra = intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false);
                        if (a.CI().getStatus() == 1) {
                            if (CL() != null) {
                                CL().eE(1);
                            }
                            if (getWriteImagesInfo() != null) {
                                getWriteImagesInfo().setMaxImagesAllowed(1);
                            }
                        } else {
                            if (CL() != null) {
                                CL().eE(10);
                            }
                            if (getWriteImagesInfo() != null) {
                                getWriteImagesInfo().setMaxImagesAllowed(10);
                            }
                        }
                        if (booleanExtra) {
                            D(intent);
                        } else {
                            C(intent);
                        }
                        if (Cm() != null) {
                            pVar2 = Cm().ew(2);
                            pVar = Cm().ew(5);
                            pVar3 = Cm().ew(23);
                        } else {
                            pVar = null;
                            pVar2 = null;
                        }
                        if (a.CI().getStatus() == 1) {
                            Da();
                            if (Cm() != null) {
                                Cm().Cu();
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL));
                            }
                            if (pVar2 != null) {
                                pVar2.hide();
                            }
                            if (pVar != null) {
                                pVar.hide();
                            }
                            if (pVar3 != null) {
                                pVar3.lO();
                            }
                            if (CM() != null) {
                                CM().setHint(this.mContext.getPageContext().getString(w.l.add_picture_description));
                            }
                            if (CL() != null) {
                                CL().fj(this.mContext.getPageContext().getString(w.l.show_pic_tip));
                                CL().fk(this.mContext.getPageContext().getString(w.l.show_pic_add_tip));
                            }
                            if (CK() != null) {
                                CK().setType(SendView.aBl);
                                CK().eJ(SendView.aBl);
                            }
                        } else {
                            if (pVar2 != null) {
                                pVar2.lO();
                            }
                            if (pVar != null) {
                                pVar.lO();
                            }
                            if (pVar3 != null) {
                                pVar3.hide();
                            }
                            if (CM() != null) {
                                CM().setHint(this.mContext.getPageContext().getString(w.l.pb_reply_hint));
                            }
                            if (CK() != null) {
                                CK().setType(SendView.ALL);
                                CK().eJ(SendView.ALL);
                            }
                        }
                        Cm().invalidate();
                        return;
                    }
                    return;
                case 12003:
                    if (intent != null) {
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            CX();
                            this.aAB.lx(false);
                            return;
                        }
                        this.aAC.fp(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case 12004:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra(IntentConfig.NAME_SHOW)) != null) {
                        q(stringArrayListExtra);
                        return;
                    }
                    return;
                case 12006:
                    WriteData writeData = this.aAB.getWriteData();
                    if (writeData != null) {
                        writeData.deleteUploadedTempImages();
                    }
                    this.aAB.setWriteData(null);
                    this.aAB.lx(false);
                    this.aAy = null;
                    this.mVideoInfo = null;
                    this.mGraffitiFileName = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        x.c(this.mThreadId, (WriteData) null);
                    }
                    bI(true);
                    if (this.aAJ != null) {
                        this.aAJ.callback(true, null, null, writeData, null);
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    if (i == 12010) {
                        A(intent);
                        return;
                    }
                    return;
                case 12012:
                    B(intent);
                    if (a.CI().getStatus() == 1 && CL() != null) {
                        CL().fj(this.mContext.getPageContext().getString(w.l.show_pic_tip));
                        return;
                    }
                    return;
                case 13010:
                    if (Cm() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            as asVar = new as("c10068");
                            asVar.r("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(asVar);
                            CY();
                            Cm().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            Cm().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
                            return;
                        }
                        return;
                    }
                    return;
                case 23004:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                    return;
                case 25004:
                    if (intent != null) {
                        fu(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 12001:
                CU();
                return;
            case 12002:
                if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                    this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    return;
                }
                return;
            case 12003:
            default:
                return;
        }
    }

    public void CO() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.mContext.getActivity())));
    }

    public void CP() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.mContext.getActivity())) {
            this.mContext.showToast(w.l.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.m9getInst().getLocationShared()) {
            CQ();
        } else if (this.aAA.biQ()) {
            CO();
        } else {
            this.aAA.lv(false);
            b(1, true, null);
            this.aAA.biO();
        }
    }

    private void CQ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getActivity());
        aVar.bY(w.l.location_app_permission_prompt).a(w.l.isopen, new h(this)).b(w.l.cancel, new i(this)).b(this.mContext.getPageContext());
        aVar.tc();
    }

    public void CR() {
        if (this.aAA.QG()) {
            if (this.aAA.biQ()) {
                this.aAP.a(com.baidu.tieba.tbadkCore.location.d.biM().getLocationData());
                return;
            }
            if (com.baidu.adp.lib.util.k.hB()) {
                this.aAA.biO();
            }
            b(0, true, null);
            return;
        }
        b(0, false, null);
    }

    public boolean CS() {
        if (StringUtils.isNull(this.aAx)) {
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() <= 0) {
                if (this.aAy == null || StringUtils.isNull(this.aAy.getId())) {
                    return (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) || this.mGraffitiFileName != null;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    public void resetData() {
        this.aAB.setWriteData(null);
        this.aAB.lx(false);
        this.aAy = null;
        this.mVideoInfo = null;
        this.mGraffitiFileName = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void CT() {
        this.mVideoInfo = null;
    }

    private void A(Intent intent) {
        this.aAz = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aAz;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.k.dip2px(this.mContext.getActivity(), com.baidu.adp.lib.util.k.af(this.mContext.getActivity())), com.baidu.adp.lib.util.k.dip2px(this.mContext.getActivity(), com.baidu.adp.lib.util.k.ag(this.mContext.getActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.l.a(TbConfig.LOCAL_CAMERA_DIR, this.aAz, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            CZ();
        }
    }

    private void B(Intent intent) {
        b(intent, false);
    }

    private void b(Intent intent, boolean z) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                CZ();
            }
        }
    }

    private void CU() {
        new j(this).execute(new Void[0]);
    }

    private void C(Intent intent) {
        b(intent, true);
    }

    private void D(Intent intent) {
        int size;
        int size2;
        A(intent);
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() - 1 > -1 && this.writeImagesInfo.getChosedFiles() != null && (size2 = this.writeImagesInfo.getChosedFiles().size()) >= 1 && size >= 0 && size < size2) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.mContext.getActivity(), 12012, this.writeImagesInfo, size)));
        }
    }

    public void fr(String str) {
        WriteData writeData = this.aAB.getWriteData();
        if (writeData == null) {
            writeData = new WriteData(1);
            writeData.setThreadId(str);
            writeData.setWriteImagesInfo(this.writeImagesInfo);
        }
        writeData.setContent(this.aAx);
        writeData.setVideoInfo(this.mVideoInfo);
        writeData.setGraffitiFileName(this.mGraffitiFileName);
        x.c(str, writeData);
    }

    public void fs(String str) {
        x.a(str, this);
    }

    @Override // com.baidu.tieba.tbadkCore.x.a
    public void a(WriteData writeData) {
        if (writeData != null) {
            if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                if (this.mVideoInfo == null) {
                    this.mVideoInfo = new VideoInfo();
                }
                this.mVideoInfo.copy(writeData.getVideoInfo());
                CY();
                Cm().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                bH(false);
            }
            this.mGraffitiFileName = writeData.getGraffitiFileName();
            if (Cm() != null && !au.isEmpty(this.mGraffitiFileName)) {
                Cm().b(new com.baidu.tbadk.editortools.a(42, 24, this.mGraffitiFileName));
            }
            if (!au.isEmpty(writeData.getContent()) && au.isEmpty(this.aAx)) {
                this.aAx = writeData.getContent();
                fv(this.aAx);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.aAB.cancelLoadData();
        this.aAC.cancelLoadData();
        this.aAA.cancelLoadData();
    }

    public void CV() {
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        this.aAB = new NewWriteModel(baseActivity);
        this.aAB.b(this.aAR);
        this.aAC = new ImageModel(baseActivity);
        this.aAC.setLoadDataCallBack(this.aAS);
        this.aAA = new LocationModel(baseActivity);
        this.aAA.a(this.aAP);
        this.aAA.a(this.aAQ);
        if (bundle != null) {
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.aAz = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(10);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.m9getInst().getDefaultBubble()) && Cm() != null) {
            Cm().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.aAA.QG() && Cm() != null) {
            Cm().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aAz);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.aAB.getWriteData() == null) {
            this.aAB.setWriteData(this.aAD.fo(str));
        }
        if (this.aAB.getWriteData() != null) {
            if (this.aAO) {
                this.aAB.getWriteData().setCanNoForum(true);
                if (this.aAF != null) {
                    this.aAB.getWriteData().setVForumId(this.aAF.getId());
                    this.aAB.getWriteData().setVForumName(this.aAF.getName());
                }
            } else {
                this.aAB.getWriteData().setCanNoForum(false);
                this.aAB.getWriteData().setVForumId("");
                this.aAB.getWriteData().setVForumName("");
            }
            this.aAB.getWriteData().setWriteImagesInfo(this.writeImagesInfo);
            this.aAB.getWriteData().setVideoInfo(this.mVideoInfo);
            this.aAB.getWriteData().setGraffitiFileName(this.mGraffitiFileName);
            this.aAB.lx(this.writeImagesInfo.size() > 0);
            WriteData writeData2 = this.aAB.getWriteData();
            if (this.aAA == null || !this.aAA.QG()) {
                z = false;
            }
            writeData2.setHasLocationData(z);
            if (str == null) {
                this.aAB.getWriteData().setContent(this.aAx);
            }
            if (this.aAy != null) {
                if (this.aAy.getId() != null) {
                    this.aAB.getWriteData().setVoice(this.aAy.getId());
                    this.aAB.getWriteData().setVoiceDuringTime(this.aAy.duration);
                } else {
                    this.aAB.getWriteData().setVoice(null);
                    this.aAB.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.aAB.getWriteData().setVoice(null);
                this.aAB.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.aAB.bjm()) {
                this.mContext.showToast(w.l.write_img_limit);
                return;
            }
            if (this.aAK != null) {
                this.aAK.CJ();
            }
            if (!this.aAB.startPostWrite()) {
            }
        }
    }

    public BaseActivity<?> getContext() {
        return this.mContext;
    }

    public void ft(String str) {
        this.aAx = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.aAy = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int CW() {
        return this.aAI;
    }

    private void CX() {
        if (Cm() != null) {
            Cm().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void q(ArrayList<String> arrayList) {
        if (Cm() != null) {
            Cm().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    public void fu(String str) {
        if (Cm() != null) {
            Cm().b(new com.baidu.tbadk.editortools.a(44, 3, str));
        }
    }

    private void CY() {
        if (Cm() != null) {
            Cm().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    protected void bH(boolean z) {
        if (Cm() != null) {
            if (z) {
                Cm().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            Cm().b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                Cm().b(new com.baidu.tbadk.editortools.a(2, 10, new StringBuilder(String.valueOf(this.writeImagesInfo.getChosedFiles().size())).toString()));
            } else {
                Cm().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
        }
    }

    protected void CZ() {
        bH(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Da() {
        if (Cm() != null) {
            Cm().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.aAI = i;
        if (Cm() != null) {
            Cm().b(new com.baidu.tbadk.editortools.a(19, 8, new com.baidu.tbadk.editortools.d.a(i, z, str)));
            if (i == 2) {
                Cm().b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            } else {
                Cm().b(new com.baidu.tbadk.editortools.a(2, 7, null));
            }
        }
    }

    private void fv(String str) {
        if (Cm() != null) {
            Cm().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bI(boolean z) {
        if (Cm() != null) {
            Cm().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.aAJ = dVar;
    }

    public void a(b bVar) {
        this.aAK = bVar;
    }

    public void Db() {
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            this.writeImagesInfo.clear();
        }
        CZ();
        if (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) {
            this.mVideoInfo = null;
        }
        Cm().b(new com.baidu.tbadk.editortools.a(2, 19, null));
        setVoiceModel(null);
        Cm().b(new com.baidu.tbadk.editortools.a(2, 6, null));
        Cm().b(new com.baidu.tbadk.editortools.a(33, 6, null));
        if (!StringUtils.isNull(this.aAx)) {
            this.aAx = "";
        }
        fv("");
        this.mGraffitiFileName = null;
        Cm().b(new com.baidu.tbadk.editortools.a(42, 24, null));
        this.aAB.setWriteData(null);
        this.aAB.lx(false);
    }

    public void eI(int i) {
        if (this.aAM == null && Cm() != null) {
            this.aAM = (com.baidu.tbadk.editortools.inputtool.a) Cm().ey(3);
        }
        if (this.aAM != null && (this.aAM.ayJ instanceof EditText)) {
            this.aAM.b(new k(this, i, (EditText) this.aAM.ayJ));
        }
    }

    public void Dc() {
        if (this.aAM != null) {
            this.aAM.b(null);
        }
    }

    public void setGraffitiFileName(String str) {
        this.mGraffitiFileName = str;
    }
}
