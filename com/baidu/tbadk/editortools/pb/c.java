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
    private String aAN;
    private VoiceData.VoiceModel aAO;
    private String aAP;
    private LocationModel aAQ;
    private NewWriteModel aAR;
    private ImageModel aAS;
    private DataModel<?> aAT;
    private AntiData aAU;
    private ForumData aAV;
    private String aAW;
    private boolean aAX;
    private int aAY;
    private NewWriteModel.d aAZ;
    private b aBa;
    private com.baidu.tbadk.editortools.imagetool.b aBb;
    private com.baidu.tbadk.editortools.inputtool.a aBc;
    private com.baidu.tbadk.editortools.sendtool.a aBd;
    private LocationModel.a aBe;
    private LocationModel.b aBf;
    private final NewWriteModel.d aBg;
    private final com.baidu.adp.base.f aBh;
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
        this.aAN = "";
        this.aAR = null;
        this.aAS = null;
        this.mThreadId = null;
        this.aAW = null;
        this.aAX = true;
        this.aAY = 0;
        this.aBe = new d(this);
        this.aBf = new e(this);
        this.aBg = new f(this);
        this.aBh = new g(this);
    }

    private com.baidu.tbadk.editortools.sendtool.a DM() {
        if (this.aBd == null && Dn() != null) {
            this.aBd = (com.baidu.tbadk.editortools.sendtool.a) Dn().eB(4);
        }
        return this.aBd;
    }

    public void eI(int i) {
        if (this.aBd == null && Dn() != null) {
            this.aBd = (com.baidu.tbadk.editortools.sendtool.a) Dn().eB(4);
        }
        if (this.aBd != null) {
            this.aBd.setType(i);
        }
    }

    public void eJ(int i) {
        if (this.aBd == null && Dn() != null) {
            this.aBd = (com.baidu.tbadk.editortools.sendtool.a) Dn().eB(4);
        }
        if (this.aBd != null) {
            this.aBd.eM(i);
        }
    }

    private com.baidu.tbadk.editortools.imagetool.b DN() {
        if (this.aBb == null && Dn() != null) {
            this.aBb = (com.baidu.tbadk.editortools.imagetool.b) Dn().eB(11);
        }
        return this.aBb;
    }

    public void eK(int i) {
        if (this.aBb == null && Dn() != null) {
            this.aBb = (com.baidu.tbadk.editortools.imagetool.b) Dn().eB(11);
        }
        if (this.aBb != null) {
            this.aBb.eH(i);
        }
    }

    public com.baidu.tbadk.editortools.inputtool.a DO() {
        if (this.aBc == null && Dn() != null) {
            this.aBc = (com.baidu.tbadk.editortools.inputtool.a) Dn().eB(3);
        }
        return this.aBc;
    }

    public void fv(String str) {
        if (this.aBc == null && Dn() != null) {
            this.aBc = (com.baidu.tbadk.editortools.inputtool.a) Dn().eB(3);
        }
        if (this.aBc != null) {
            this.aBc.setHint(str);
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
        this.aAT = dataModel;
    }

    public void d(BaseActivity<?> baseActivity) {
        this.mContext = baseActivity;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.aAX = antiData.isIfvoice();
            this.aAW = antiData.getVoice_message();
        }
        this.aAU = antiData;
    }

    public void a(ForumData forumData, UserData userData) {
        this.aAV = forumData;
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
                                DM().setType(SendView.aBA);
                                DM().eM(SendView.aBA);
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
                            this.aAR.ly(false);
                            return;
                        }
                        this.aAS.fu(intent.getStringExtra("file_name"));
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
                    WriteData writeData = this.aAR.getWriteData();
                    if (writeData != null) {
                        writeData.deleteUploadedTempImages();
                    }
                    this.aAR.setWriteData(null);
                    this.aAR.ly(false);
                    this.aAO = null;
                    this.mVideoInfo = null;
                    this.mGraffitiFileName = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        z.c(this.mThreadId, (WriteData) null);
                    }
                    bK(true);
                    if (this.aAZ != null) {
                        this.aAZ.callback(true, null, null, writeData, null);
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
        } else if (this.aAQ.bjZ()) {
            DQ();
        } else {
            this.aAQ.lw(false);
            b(1, true, null);
            this.aAQ.bjX();
        }
    }

    private void DS() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getActivity());
        aVar.bZ(w.l.location_app_permission_prompt).a(w.l.isopen, new h(this)).b(w.l.cancel, new i(this)).b(this.mContext.getPageContext());
        aVar.tQ();
    }

    public void DT() {
        if (this.aAQ.QZ()) {
            if (this.aAQ.bjZ()) {
                this.aBe.a(com.baidu.tieba.tbadkCore.location.d.bjV().getLocationData());
                return;
            }
            if (com.baidu.adp.lib.util.k.hB()) {
                this.aAQ.bjX();
            }
            b(0, true, null);
            return;
        }
        b(0, false, null);
    }

    public boolean DU() {
        if (StringUtils.isNull(this.aAN)) {
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() <= 0) {
                if (this.aAO == null || StringUtils.isNull(this.aAO.getId())) {
                    return (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) || this.mGraffitiFileName != null;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    public void resetData() {
        this.aAR.setWriteData(null);
        this.aAR.ly(false);
        this.aAO = null;
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
        this.aAP = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aAP;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.k.dip2px(this.mContext.getActivity(), com.baidu.adp.lib.util.k.af(this.mContext.getActivity())), com.baidu.adp.lib.util.k.dip2px(this.mContext.getActivity(), com.baidu.adp.lib.util.k.ag(this.mContext.getActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.l.a(TbConfig.LOCAL_CAMERA_DIR, this.aAP, rotateBitmapBydegree, 100);
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
        WriteData writeData = this.aAR.getWriteData();
        if (writeData == null) {
            writeData = new WriteData(1);
            writeData.setThreadId(str);
            writeData.setWriteImagesInfo(this.writeImagesInfo);
        }
        writeData.setContent(this.aAN);
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
            if (!au.isEmpty(writeData.getContent()) && au.isEmpty(this.aAN)) {
                this.aAN = writeData.getContent();
                fA(this.aAN);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.aAR.cancelLoadData();
        this.aAS.cancelLoadData();
        this.aAQ.cancelLoadData();
    }

    public void DX() {
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        this.aAR = new NewWriteModel(baseActivity);
        this.aAR.b(this.aBg);
        this.aAS = new ImageModel(baseActivity);
        this.aAS.setLoadDataCallBack(this.aBh);
        this.aAQ = new LocationModel(baseActivity);
        this.aAQ.a(this.aBe);
        this.aAQ.a(this.aBf);
        if (bundle != null) {
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.aAP = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(10);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.m9getInst().getDefaultBubble()) && Dn() != null) {
            Dn().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.aAQ.QZ() && Dn() != null) {
            Dn().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aAP);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.aAR.getWriteData() == null) {
            this.aAR.setWriteData(this.aAT.ft(str));
        }
        if (this.aAR.getWriteData() != null) {
            this.aAR.getWriteData().setWriteImagesInfo(this.writeImagesInfo);
            this.aAR.getWriteData().setVideoInfo(this.mVideoInfo);
            this.aAR.getWriteData().setGraffitiFileName(this.mGraffitiFileName);
            this.aAR.ly(this.writeImagesInfo.size() > 0);
            WriteData writeData2 = this.aAR.getWriteData();
            if (this.aAQ == null || !this.aAQ.QZ()) {
                z = false;
            }
            writeData2.setHasLocationData(z);
            if (str == null) {
                this.aAR.getWriteData().setContent(this.aAN);
            }
            if (this.aAO != null) {
                if (this.aAO.getId() != null) {
                    this.aAR.getWriteData().setVoice(this.aAO.getId());
                    this.aAR.getWriteData().setVoiceDuringTime(this.aAO.duration);
                } else {
                    this.aAR.getWriteData().setVoice(null);
                    this.aAR.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.aAR.getWriteData().setVoice(null);
                this.aAR.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.aAR.bkv()) {
                this.mContext.showToast(w.l.write_img_limit);
                return;
            }
            if (this.aBa != null) {
                this.aBa.DL();
            }
            if (!this.aAR.startPostWrite()) {
            }
        }
    }

    public BaseActivity<?> getContext() {
        return this.mContext;
    }

    public void fy(String str) {
        this.aAN = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.aAO = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int DY() {
        return this.aAY;
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
        this.aAY = i;
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
        this.aAZ = dVar;
    }

    public void a(b bVar) {
        this.aBa = bVar;
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
        if (!StringUtils.isNull(this.aAN)) {
            this.aAN = "";
        }
        fA("");
        this.mGraffitiFileName = null;
        Dn().b(new com.baidu.tbadk.editortools.a(42, 24, null));
        this.aAR.setWriteData(null);
        this.aAR.ly(false);
    }

    public void eL(int i) {
        if (this.aBc == null && Dn() != null) {
            this.aBc = (com.baidu.tbadk.editortools.inputtool.a) Dn().eB(3);
        }
        if (this.aBc != null && (this.aBc.ayZ instanceof EditText)) {
            this.aBc.b(new k(this, i, (EditText) this.aBc.ayZ));
        }
    }

    public void Ee() {
        if (this.aBc != null) {
            this.aBc.b(null);
        }
    }

    public void setGraffitiFileName(String str) {
        this.mGraffitiFileName = str;
    }
}
