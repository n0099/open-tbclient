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
    private String aAL;
    private VoiceData.VoiceModel aAM;
    private String aAN;
    private LocationModel aAO;
    private NewWriteModel aAP;
    private ImageModel aAQ;
    private DataModel<?> aAR;
    private AntiData aAS;
    private ForumData aAT;
    private String aAU;
    private boolean aAV;
    private int aAW;
    private NewWriteModel.d aAX;
    private b aAY;
    private com.baidu.tbadk.editortools.imagetool.b aAZ;
    private com.baidu.tbadk.editortools.inputtool.a aBa;
    private com.baidu.tbadk.editortools.sendtool.a aBb;
    private LocationModel.a aBc;
    private LocationModel.b aBd;
    private final NewWriteModel.d aBe;
    private final com.baidu.adp.base.f aBf;
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
        this.aAL = "";
        this.aAP = null;
        this.aAQ = null;
        this.mThreadId = null;
        this.aAU = null;
        this.aAV = true;
        this.aAW = 0;
        this.aBc = new d(this);
        this.aBd = new e(this);
        this.aBe = new f(this);
        this.aBf = new g(this);
    }

    private com.baidu.tbadk.editortools.sendtool.a DM() {
        if (this.aBb == null && Dn() != null) {
            this.aBb = (com.baidu.tbadk.editortools.sendtool.a) Dn().eB(4);
        }
        return this.aBb;
    }

    public void eI(int i) {
        if (this.aBb == null && Dn() != null) {
            this.aBb = (com.baidu.tbadk.editortools.sendtool.a) Dn().eB(4);
        }
        if (this.aBb != null) {
            this.aBb.setType(i);
        }
    }

    public void eJ(int i) {
        if (this.aBb == null && Dn() != null) {
            this.aBb = (com.baidu.tbadk.editortools.sendtool.a) Dn().eB(4);
        }
        if (this.aBb != null) {
            this.aBb.eM(i);
        }
    }

    private com.baidu.tbadk.editortools.imagetool.b DN() {
        if (this.aAZ == null && Dn() != null) {
            this.aAZ = (com.baidu.tbadk.editortools.imagetool.b) Dn().eB(11);
        }
        return this.aAZ;
    }

    public void eK(int i) {
        if (this.aAZ == null && Dn() != null) {
            this.aAZ = (com.baidu.tbadk.editortools.imagetool.b) Dn().eB(11);
        }
        if (this.aAZ != null) {
            this.aAZ.eH(i);
        }
    }

    public com.baidu.tbadk.editortools.inputtool.a DO() {
        if (this.aBa == null && Dn() != null) {
            this.aBa = (com.baidu.tbadk.editortools.inputtool.a) Dn().eB(3);
        }
        return this.aBa;
    }

    public void fv(String str) {
        if (this.aBa == null && Dn() != null) {
            this.aBa = (com.baidu.tbadk.editortools.inputtool.a) Dn().eB(3);
        }
        if (this.aBa != null) {
            this.aBa.setHint(str);
        }
    }

    public void bG(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (Dn() != null && (cVar = (com.baidu.tbadk.editortools.c) Dn().ez(5)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bH(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (Dn() != null && (cVar = (com.baidu.tbadk.editortools.c) Dn().ez(23)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bI(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (Dn() != null && (cVar = (com.baidu.tbadk.editortools.c) Dn().ez(2)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.aAR = dataModel;
    }

    public void d(BaseActivity<?> baseActivity) {
        this.mContext = baseActivity;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.aAV = antiData.isIfvoice();
            this.aAU = antiData.getVoice_message();
        }
        this.aAS = antiData;
    }

    public void a(ForumData forumData, UserData userData) {
        this.aAT = forumData;
        this.mUserData = userData;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (Dn() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void DP() {
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
                        if (a.DK().getStatus() == 1) {
                            if (DN() != null) {
                                DN().eH(1);
                            }
                            if (getWriteImagesInfo() != null) {
                                getWriteImagesInfo().setMaxImagesAllowed(1);
                            }
                        } else {
                            if (DN() != null) {
                                DN().eH(10);
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
                        if (Dn() != null) {
                            pVar2 = Dn().ez(2);
                            pVar = Dn().ez(5);
                            pVar3 = Dn().ez(23);
                        } else {
                            pVar = null;
                            pVar2 = null;
                        }
                        if (a.DK().getStatus() == 1) {
                            Ec();
                            if (Dn() != null) {
                                Dn().Dv();
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL));
                            }
                            if (pVar2 != null) {
                                pVar2.hide();
                            }
                            if (pVar != null) {
                                pVar.hide();
                            }
                            if (pVar3 != null) {
                                pVar3.mp();
                            }
                            if (DO() != null) {
                                DO().setHint(this.mContext.getPageContext().getString(w.l.add_picture_description));
                            }
                            if (DN() != null) {
                                DN().fo(this.mContext.getPageContext().getString(w.l.show_pic_tip));
                                DN().fp(this.mContext.getPageContext().getString(w.l.show_pic_add_tip));
                            }
                            if (DM() != null) {
                                DM().setType(SendView.aBy);
                                DM().eM(SendView.aBy);
                            }
                        } else {
                            if (pVar2 != null) {
                                pVar2.mp();
                            }
                            if (pVar != null) {
                                pVar.mp();
                            }
                            if (pVar3 != null) {
                                pVar3.hide();
                            }
                            if (DO() != null) {
                                DO().setHint(this.mContext.getPageContext().getString(w.l.pb_reply_hint));
                            }
                            if (DM() != null) {
                                DM().setType(SendView.ALL);
                                DM().eM(SendView.ALL);
                            }
                        }
                        Dn().invalidate();
                        return;
                    }
                    return;
                case 12003:
                    if (intent != null) {
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            DZ();
                            this.aAP.lo(false);
                            return;
                        }
                        this.aAQ.fu(intent.getStringExtra("file_name"));
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
                    WriteData writeData = this.aAP.getWriteData();
                    if (writeData != null) {
                        writeData.deleteUploadedTempImages();
                    }
                    this.aAP.setWriteData(null);
                    this.aAP.lo(false);
                    this.aAM = null;
                    this.mVideoInfo = null;
                    this.mGraffitiFileName = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        z.c(this.mThreadId, (WriteData) null);
                    }
                    bK(true);
                    if (this.aAX != null) {
                        this.aAX.callback(true, null, null, writeData, null);
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
                    if (a.DK().getStatus() == 1 && DN() != null) {
                        DN().fo(this.mContext.getPageContext().getString(w.l.show_pic_tip));
                        return;
                    }
                    return;
                case 13010:
                    if (Dn() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            as asVar = new as("c10068");
                            asVar.s("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(asVar);
                            Ea();
                            Dn().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            Dn().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                        fz(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 12001:
                DW();
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

    public void DQ() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.mContext.getActivity())));
    }

    public void DR() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.mContext.getActivity())) {
            this.mContext.showToast(w.l.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.m9getInst().getLocationShared()) {
            DS();
        } else if (this.aAO.biY()) {
            DQ();
        } else {
            this.aAO.lm(false);
            b(1, true, null);
            this.aAO.biW();
        }
    }

    private void DS() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getActivity());
        aVar.bZ(w.l.location_app_permission_prompt).a(w.l.isopen, new h(this)).b(w.l.cancel, new i(this)).b(this.mContext.getPageContext());
        aVar.tQ();
    }

    public void DT() {
        if (this.aAO.PZ()) {
            if (this.aAO.biY()) {
                this.aBc.a(com.baidu.tieba.tbadkCore.location.d.biU().getLocationData());
                return;
            }
            if (com.baidu.adp.lib.util.k.hA()) {
                this.aAO.biW();
            }
            b(0, true, null);
            return;
        }
        b(0, false, null);
    }

    public boolean DU() {
        if (StringUtils.isNull(this.aAL)) {
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() <= 0) {
                if (this.aAM == null || StringUtils.isNull(this.aAM.getId())) {
                    return (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) || this.mGraffitiFileName != null;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    public void resetData() {
        this.aAP.setWriteData(null);
        this.aAP.lo(false);
        this.aAM = null;
        this.mVideoInfo = null;
        this.mGraffitiFileName = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void DV() {
        this.mVideoInfo = null;
    }

    private void A(Intent intent) {
        this.aAN = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aAN;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.k.dip2px(this.mContext.getActivity(), com.baidu.adp.lib.util.k.af(this.mContext.getActivity())), com.baidu.adp.lib.util.k.dip2px(this.mContext.getActivity(), com.baidu.adp.lib.util.k.ag(this.mContext.getActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.l.a(TbConfig.LOCAL_CAMERA_DIR, this.aAN, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            Eb();
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
                Eb();
            }
        }
    }

    private void DW() {
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

    public void fw(String str) {
        WriteData writeData = this.aAP.getWriteData();
        if (writeData == null) {
            writeData = new WriteData(1);
            writeData.setThreadId(str);
            writeData.setWriteImagesInfo(this.writeImagesInfo);
        }
        writeData.setContent(this.aAL);
        writeData.setVideoInfo(this.mVideoInfo);
        writeData.setGraffitiFileName(this.mGraffitiFileName);
        z.c(str, writeData);
    }

    public void fx(String str) {
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
                Ea();
                Dn().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                bJ(false);
            }
            this.mGraffitiFileName = writeData.getGraffitiFileName();
            if (Dn() != null && !au.isEmpty(this.mGraffitiFileName)) {
                Dn().b(new com.baidu.tbadk.editortools.a(42, 24, this.mGraffitiFileName));
            }
            if (!au.isEmpty(writeData.getContent()) && au.isEmpty(this.aAL)) {
                this.aAL = writeData.getContent();
                fA(this.aAL);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.aAP.cancelLoadData();
        this.aAQ.cancelLoadData();
        this.aAO.cancelLoadData();
    }

    public void DX() {
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        this.aAP = new NewWriteModel(baseActivity);
        this.aAP.b(this.aBe);
        this.aAQ = new ImageModel(baseActivity);
        this.aAQ.setLoadDataCallBack(this.aBf);
        this.aAO = new LocationModel(baseActivity);
        this.aAO.a(this.aBc);
        this.aAO.a(this.aBd);
        if (bundle != null) {
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.aAN = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(10);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.m9getInst().getDefaultBubble()) && Dn() != null) {
            Dn().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.aAO.PZ() && Dn() != null) {
            Dn().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aAN);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.aAP.getWriteData() == null) {
            this.aAP.setWriteData(this.aAR.ft(str));
        }
        if (this.aAP.getWriteData() != null) {
            this.aAP.getWriteData().setWriteImagesInfo(this.writeImagesInfo);
            this.aAP.getWriteData().setVideoInfo(this.mVideoInfo);
            this.aAP.getWriteData().setGraffitiFileName(this.mGraffitiFileName);
            this.aAP.lo(this.writeImagesInfo.size() > 0);
            WriteData writeData2 = this.aAP.getWriteData();
            if (this.aAO == null || !this.aAO.PZ()) {
                z = false;
            }
            writeData2.setHasLocationData(z);
            if (str == null) {
                this.aAP.getWriteData().setContent(this.aAL);
            }
            if (this.aAM != null) {
                if (this.aAM.getId() != null) {
                    this.aAP.getWriteData().setVoice(this.aAM.getId());
                    this.aAP.getWriteData().setVoiceDuringTime(this.aAM.duration);
                } else {
                    this.aAP.getWriteData().setVoice(null);
                    this.aAP.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.aAP.getWriteData().setVoice(null);
                this.aAP.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.aAP.bju()) {
                this.mContext.showToast(w.l.write_img_limit);
                return;
            }
            if (this.aAY != null) {
                this.aAY.DL();
            }
            if (!this.aAP.startPostWrite()) {
            }
        }
    }

    public BaseActivity<?> getContext() {
        return this.mContext;
    }

    public void fy(String str) {
        this.aAL = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.aAM = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int DY() {
        return this.aAW;
    }

    private void DZ() {
        if (Dn() != null) {
            Dn().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void q(ArrayList<String> arrayList) {
        if (Dn() != null) {
            Dn().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    public void fz(String str) {
        if (Dn() != null) {
            Dn().b(new com.baidu.tbadk.editortools.a(44, 3, str));
        }
    }

    private void Ea() {
        if (Dn() != null) {
            Dn().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    protected void bJ(boolean z) {
        if (Dn() != null) {
            if (z) {
                Dn().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            Dn().b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                Dn().b(new com.baidu.tbadk.editortools.a(2, 10, new StringBuilder(String.valueOf(this.writeImagesInfo.getChosedFiles().size())).toString()));
            } else {
                Dn().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
        }
    }

    protected void Eb() {
        bJ(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ec() {
        if (Dn() != null) {
            Dn().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.aAW = i;
        if (Dn() != null) {
            Dn().b(new com.baidu.tbadk.editortools.a(19, 8, new com.baidu.tbadk.editortools.d.a(i, z, str)));
            if (i == 2) {
                Dn().b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            } else {
                Dn().b(new com.baidu.tbadk.editortools.a(2, 7, null));
            }
        }
    }

    private void fA(String str) {
        if (Dn() != null) {
            Dn().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bK(boolean z) {
        if (Dn() != null) {
            Dn().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.aAX = dVar;
    }

    public void a(b bVar) {
        this.aAY = bVar;
    }

    public void Ed() {
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            this.writeImagesInfo.clear();
        }
        Eb();
        if (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) {
            this.mVideoInfo = null;
        }
        Dn().b(new com.baidu.tbadk.editortools.a(2, 19, null));
        setVoiceModel(null);
        Dn().b(new com.baidu.tbadk.editortools.a(2, 6, null));
        Dn().b(new com.baidu.tbadk.editortools.a(33, 6, null));
        if (!StringUtils.isNull(this.aAL)) {
            this.aAL = "";
        }
        fA("");
        this.mGraffitiFileName = null;
        Dn().b(new com.baidu.tbadk.editortools.a(42, 24, null));
        this.aAP.setWriteData(null);
        this.aAP.lo(false);
    }

    public void eL(int i) {
        if (this.aBa == null && Dn() != null) {
            this.aBa = (com.baidu.tbadk.editortools.inputtool.a) Dn().eB(3);
        }
        if (this.aBa != null && (this.aBa.ayX instanceof EditText)) {
            this.aBa.b(new k(this, i, (EditText) this.aBa.ayX));
        }
    }

    public void Ee() {
        if (this.aBa != null) {
            this.aBa.b(null);
        }
    }

    public void setGraffitiFileName(String str) {
        this.mGraffitiFileName = str;
    }
}
