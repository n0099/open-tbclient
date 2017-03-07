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
import com.baidu.tieba.tbadkCore.z;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.editortools.f implements z.a {
    private ImageModel aAA;
    private DataModel<?> aAB;
    private AntiData aAC;
    private ForumData aAD;
    private String aAE;
    private boolean aAF;
    private int aAG;
    private NewWriteModel.d aAH;
    private b aAI;
    private com.baidu.tbadk.editortools.imagetool.b aAJ;
    private com.baidu.tbadk.editortools.inputtool.a aAK;
    private com.baidu.tbadk.editortools.sendtool.a aAL;
    private LocationModel.a aAM;
    private LocationModel.b aAN;
    private final NewWriteModel.d aAO;
    private final com.baidu.adp.base.f aAP;
    private String aAv;
    private VoiceData.VoiceModel aAw;
    private String aAx;
    private LocationModel aAy;
    private NewWriteModel aAz;
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
        this.aAv = "";
        this.aAz = null;
        this.aAA = null;
        this.mThreadId = null;
        this.aAE = null;
        this.aAF = true;
        this.aAG = 0;
        this.aAM = new d(this);
        this.aAN = new e(this);
        this.aAO = new f(this);
        this.aAP = new g(this);
    }

    private com.baidu.tbadk.editortools.sendtool.a Do() {
        if (this.aAL == null && CP() != null) {
            this.aAL = (com.baidu.tbadk.editortools.sendtool.a) CP().ey(4);
        }
        return this.aAL;
    }

    public void eF(int i) {
        if (this.aAL == null && CP() != null) {
            this.aAL = (com.baidu.tbadk.editortools.sendtool.a) CP().ey(4);
        }
        if (this.aAL != null) {
            this.aAL.setType(i);
        }
    }

    public void eG(int i) {
        if (this.aAL == null && CP() != null) {
            this.aAL = (com.baidu.tbadk.editortools.sendtool.a) CP().ey(4);
        }
        if (this.aAL != null) {
            this.aAL.eJ(i);
        }
    }

    private com.baidu.tbadk.editortools.imagetool.b Dp() {
        if (this.aAJ == null && CP() != null) {
            this.aAJ = (com.baidu.tbadk.editortools.imagetool.b) CP().ey(11);
        }
        return this.aAJ;
    }

    public void eH(int i) {
        if (this.aAJ == null && CP() != null) {
            this.aAJ = (com.baidu.tbadk.editortools.imagetool.b) CP().ey(11);
        }
        if (this.aAJ != null) {
            this.aAJ.eE(i);
        }
    }

    public com.baidu.tbadk.editortools.inputtool.a Dq() {
        if (this.aAK == null && CP() != null) {
            this.aAK = (com.baidu.tbadk.editortools.inputtool.a) CP().ey(3);
        }
        return this.aAK;
    }

    public void fp(String str) {
        if (this.aAK == null && CP() != null) {
            this.aAK = (com.baidu.tbadk.editortools.inputtool.a) CP().ey(3);
        }
        if (this.aAK != null) {
            this.aAK.setHint(str);
        }
    }

    public void bE(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (CP() != null && (cVar = (com.baidu.tbadk.editortools.c) CP().ew(5)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bF(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (CP() != null && (cVar = (com.baidu.tbadk.editortools.c) CP().ew(23)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bG(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (CP() != null && (cVar = (com.baidu.tbadk.editortools.c) CP().ew(2)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.aAB = dataModel;
    }

    public void d(BaseActivity<?> baseActivity) {
        this.mContext = baseActivity;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.aAF = antiData.isIfvoice();
            this.aAE = antiData.getVoice_message();
        }
        this.aAC = antiData;
    }

    public void a(ForumData forumData, UserData userData) {
        this.aAD = forumData;
        this.mUserData = userData;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (CP() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void Dr() {
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
                        if (a.Dm().getStatus() == 1) {
                            if (Dp() != null) {
                                Dp().eE(1);
                            }
                            if (getWriteImagesInfo() != null) {
                                getWriteImagesInfo().setMaxImagesAllowed(1);
                            }
                        } else {
                            if (Dp() != null) {
                                Dp().eE(10);
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
                        if (CP() != null) {
                            pVar2 = CP().ew(2);
                            pVar = CP().ew(5);
                            pVar3 = CP().ew(23);
                        } else {
                            pVar = null;
                            pVar2 = null;
                        }
                        if (a.Dm().getStatus() == 1) {
                            DE();
                            if (CP() != null) {
                                CP().CX();
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL));
                            }
                            if (pVar2 != null) {
                                pVar2.hide();
                            }
                            if (pVar != null) {
                                pVar.hide();
                            }
                            if (pVar3 != null) {
                                pVar3.ml();
                            }
                            if (Dq() != null) {
                                Dq().setHint(this.mContext.getPageContext().getString(w.l.add_picture_description));
                            }
                            if (Dp() != null) {
                                Dp().fi(this.mContext.getPageContext().getString(w.l.show_pic_tip));
                                Dp().fj(this.mContext.getPageContext().getString(w.l.show_pic_add_tip));
                            }
                            if (Do() != null) {
                                Do().setType(SendView.aBi);
                                Do().eJ(SendView.aBi);
                            }
                        } else {
                            if (pVar2 != null) {
                                pVar2.ml();
                            }
                            if (pVar != null) {
                                pVar.ml();
                            }
                            if (pVar3 != null) {
                                pVar3.hide();
                            }
                            if (Dq() != null) {
                                Dq().setHint(this.mContext.getPageContext().getString(w.l.pb_reply_hint));
                            }
                            if (Do() != null) {
                                Do().setType(SendView.ALL);
                                Do().eJ(SendView.ALL);
                            }
                        }
                        CP().invalidate();
                        return;
                    }
                    return;
                case 12003:
                    if (intent != null) {
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            DB();
                            this.aAz.ll(false);
                            return;
                        }
                        this.aAA.fo(intent.getStringExtra("file_name"));
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
                    WriteData writeData = this.aAz.getWriteData();
                    if (writeData != null) {
                        writeData.deleteUploadedTempImages();
                    }
                    this.aAz.setWriteData(null);
                    this.aAz.ll(false);
                    this.aAw = null;
                    this.mVideoInfo = null;
                    this.mGraffitiFileName = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        z.c(this.mThreadId, (WriteData) null);
                    }
                    bI(true);
                    if (this.aAH != null) {
                        this.aAH.callback(true, null, null, writeData, null);
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
                    if (a.Dm().getStatus() == 1 && Dp() != null) {
                        Dp().fi(this.mContext.getPageContext().getString(w.l.show_pic_tip));
                        return;
                    }
                    return;
                case 13010:
                    if (CP() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            as asVar = new as("c10068");
                            asVar.s("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(asVar);
                            DC();
                            CP().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            CP().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                        ft(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 12001:
                Dy();
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

    public void Ds() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.mContext.getActivity())));
    }

    public void Dt() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.mContext.getActivity())) {
            this.mContext.showToast(w.l.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.m9getInst().getLocationShared()) {
            Du();
        } else if (this.aAy.bin()) {
            Ds();
        } else {
            this.aAy.lj(false);
            b(1, true, null);
            this.aAy.bil();
        }
    }

    private void Du() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getActivity());
        aVar.bW(w.l.location_app_permission_prompt).a(w.l.isopen, new h(this)).b(w.l.cancel, new i(this)).b(this.mContext.getPageContext());
        aVar.ts();
    }

    public void Dv() {
        if (this.aAy.PB()) {
            if (this.aAy.bin()) {
                this.aAM.a(com.baidu.tieba.tbadkCore.location.c.bij().getLocationData());
                return;
            }
            if (com.baidu.adp.lib.util.k.hv()) {
                this.aAy.bil();
            }
            b(0, true, null);
            return;
        }
        b(0, false, null);
    }

    public boolean Dw() {
        if (StringUtils.isNull(this.aAv)) {
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() <= 0) {
                if (this.aAw == null || StringUtils.isNull(this.aAw.getId())) {
                    return (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) || this.mGraffitiFileName != null;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    public void resetData() {
        this.aAz.setWriteData(null);
        this.aAz.ll(false);
        this.aAw = null;
        this.mVideoInfo = null;
        this.mGraffitiFileName = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void Dx() {
        this.mVideoInfo = null;
    }

    private void A(Intent intent) {
        this.aAx = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aAx;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.k.dip2px(this.mContext.getActivity(), com.baidu.adp.lib.util.k.ag(this.mContext.getActivity())), com.baidu.adp.lib.util.k.dip2px(this.mContext.getActivity(), com.baidu.adp.lib.util.k.ah(this.mContext.getActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.l.a(TbConfig.LOCAL_CAMERA_DIR, this.aAx, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            DD();
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
                DD();
            }
        }
    }

    private void Dy() {
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

    public void fq(String str) {
        WriteData writeData = this.aAz.getWriteData();
        if (writeData == null) {
            writeData = new WriteData(1);
            writeData.setThreadId(str);
            writeData.setWriteImagesInfo(this.writeImagesInfo);
        }
        writeData.setContent(this.aAv);
        writeData.setVideoInfo(this.mVideoInfo);
        writeData.setGraffitiFileName(this.mGraffitiFileName);
        z.c(str, writeData);
    }

    public void fr(String str) {
        z.a(str, this);
    }

    @Override // com.baidu.tieba.tbadkCore.z.a
    public void a(WriteData writeData) {
        if (writeData != null) {
            if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                if (this.mVideoInfo == null) {
                    this.mVideoInfo = new VideoInfo();
                }
                this.mVideoInfo.copy(writeData.getVideoInfo());
                DC();
                CP().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                bH(false);
            }
            this.mGraffitiFileName = writeData.getGraffitiFileName();
            if (CP() != null && !au.isEmpty(this.mGraffitiFileName)) {
                CP().b(new com.baidu.tbadk.editortools.a(42, 24, this.mGraffitiFileName));
            }
            if (!au.isEmpty(writeData.getContent()) && au.isEmpty(this.aAv)) {
                this.aAv = writeData.getContent();
                fu(this.aAv);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.aAz.cancelLoadData();
        this.aAA.cancelLoadData();
        this.aAy.cancelLoadData();
    }

    public void Dz() {
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        this.aAz = new NewWriteModel(baseActivity);
        this.aAz.b(this.aAO);
        this.aAA = new ImageModel(baseActivity);
        this.aAA.setLoadDataCallBack(this.aAP);
        this.aAy = new LocationModel(baseActivity);
        this.aAy.a(this.aAM);
        this.aAy.a(this.aAN);
        if (bundle != null) {
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.aAx = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(10);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.m9getInst().getDefaultBubble()) && CP() != null) {
            CP().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.aAy.PB() && CP() != null) {
            CP().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aAx);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.aAz.getWriteData() == null) {
            this.aAz.setWriteData(this.aAB.fn(str));
        }
        if (this.aAz.getWriteData() != null) {
            this.aAz.getWriteData().setWriteImagesInfo(this.writeImagesInfo);
            this.aAz.getWriteData().setVideoInfo(this.mVideoInfo);
            this.aAz.getWriteData().setGraffitiFileName(this.mGraffitiFileName);
            this.aAz.ll(this.writeImagesInfo.size() > 0);
            WriteData writeData2 = this.aAz.getWriteData();
            if (this.aAy == null || !this.aAy.PB()) {
                z = false;
            }
            writeData2.setHasLocationData(z);
            if (str == null) {
                this.aAz.getWriteData().setContent(this.aAv);
            }
            if (this.aAw != null) {
                if (this.aAw.getId() != null) {
                    this.aAz.getWriteData().setVoice(this.aAw.getId());
                    this.aAz.getWriteData().setVoiceDuringTime(this.aAw.duration);
                } else {
                    this.aAz.getWriteData().setVoice(null);
                    this.aAz.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.aAz.getWriteData().setVoice(null);
                this.aAz.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.aAz.biJ()) {
                this.mContext.showToast(w.l.write_img_limit);
                return;
            }
            if (this.aAI != null) {
                this.aAI.Dn();
            }
            if (!this.aAz.startPostWrite()) {
            }
        }
    }

    public BaseActivity<?> getContext() {
        return this.mContext;
    }

    public void fs(String str) {
        this.aAv = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.aAw = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int DA() {
        return this.aAG;
    }

    private void DB() {
        if (CP() != null) {
            CP().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void q(ArrayList<String> arrayList) {
        if (CP() != null) {
            CP().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    public void ft(String str) {
        if (CP() != null) {
            CP().b(new com.baidu.tbadk.editortools.a(44, 3, str));
        }
    }

    private void DC() {
        if (CP() != null) {
            CP().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    protected void bH(boolean z) {
        if (CP() != null) {
            if (z) {
                CP().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            CP().b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                CP().b(new com.baidu.tbadk.editortools.a(2, 10, new StringBuilder(String.valueOf(this.writeImagesInfo.getChosedFiles().size())).toString()));
            } else {
                CP().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
        }
    }

    protected void DD() {
        bH(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void DE() {
        if (CP() != null) {
            CP().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.aAG = i;
        if (CP() != null) {
            CP().b(new com.baidu.tbadk.editortools.a(19, 8, new com.baidu.tbadk.editortools.d.a(i, z, str)));
            if (i == 2) {
                CP().b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            } else {
                CP().b(new com.baidu.tbadk.editortools.a(2, 7, null));
            }
        }
    }

    private void fu(String str) {
        if (CP() != null) {
            CP().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bI(boolean z) {
        if (CP() != null) {
            CP().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.aAH = dVar;
    }

    public void a(b bVar) {
        this.aAI = bVar;
    }

    public void DF() {
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            this.writeImagesInfo.clear();
        }
        DD();
        if (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) {
            this.mVideoInfo = null;
        }
        CP().b(new com.baidu.tbadk.editortools.a(2, 19, null));
        setVoiceModel(null);
        CP().b(new com.baidu.tbadk.editortools.a(2, 6, null));
        CP().b(new com.baidu.tbadk.editortools.a(33, 6, null));
        if (!StringUtils.isNull(this.aAv)) {
            this.aAv = "";
        }
        fu("");
        this.mGraffitiFileName = null;
        CP().b(new com.baidu.tbadk.editortools.a(42, 24, null));
        this.aAz.setWriteData(null);
        this.aAz.ll(false);
    }

    public void eI(int i) {
        if (this.aAK == null && CP() != null) {
            this.aAK = (com.baidu.tbadk.editortools.inputtool.a) CP().ey(3);
        }
        if (this.aAK != null && (this.aAK.ayH instanceof EditText)) {
            this.aAK.b(new k(this, i, (EditText) this.aAK.ayH));
        }
    }

    public void DG() {
        if (this.aAK != null) {
            this.aAK.b(null);
        }
    }

    public void setGraffitiFileName(String str) {
        this.mGraffitiFileName = str;
    }
}
