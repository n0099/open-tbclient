package com.baidu.tbadk.editortools.e;

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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.ad;
import com.baidu.tieba.tbadkCore.location.d;
import com.baidu.tieba.tbadkCore.writeModel.b;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.editortools.f implements ad.a {
    private long authorId;
    private String authorName;
    private String awA;
    private com.baidu.tieba.tbadkCore.location.d awB;
    private com.baidu.tieba.tbadkCore.writeModel.b awC;
    private d awD;
    private a<?> awE;
    private AntiData awF;
    private ForumData awG;
    private BaseActivity<?> awH;
    private String awI;
    private boolean awJ;
    private int awK;
    private b.d awL;
    private c awM;
    private com.baidu.tbadk.editortools.imagetool.b awN;
    private com.baidu.tbadk.editortools.inputtool.a awO;
    private com.baidu.tbadk.editortools.sendtool.a awP;
    private d.a awQ;
    private d.b awR;
    private final b.d awS;
    private final com.baidu.adp.base.g awT;
    private String awy;
    private VoiceData.VoiceModel awz;
    private String mGraffitiFileName;
    private String mThreadId;
    private UserData mUserData;
    private VideoInfo mVideoInfo;
    private String postId;
    private WriteImagesInfo writeImagesInfo;

    public e(com.baidu.tbadk.editortools.l lVar) {
        super(lVar);
        this.writeImagesInfo = new WriteImagesInfo();
        this.awy = "";
        this.awC = null;
        this.awD = null;
        this.mThreadId = null;
        this.awI = null;
        this.awJ = true;
        this.awK = 0;
        this.awQ = new f(this);
        this.awR = new g(this);
        this.awS = new h(this);
        this.awT = new i(this);
    }

    private com.baidu.tbadk.editortools.sendtool.a Dr() {
        if (this.awP == null && CO() != null) {
            this.awP = (com.baidu.tbadk.editortools.sendtool.a) CO().eB(4);
        }
        return this.awP;
    }

    public void eI(int i) {
        if (this.awP == null && CO() != null) {
            this.awP = (com.baidu.tbadk.editortools.sendtool.a) CO().eB(4);
        }
        if (this.awP != null) {
            this.awP.setType(i);
        }
    }

    public void eJ(int i) {
        if (this.awP == null && CO() != null) {
            this.awP = (com.baidu.tbadk.editortools.sendtool.a) CO().eB(4);
        }
        if (this.awP != null) {
            this.awP.eM(i);
        }
    }

    private com.baidu.tbadk.editortools.imagetool.b Ds() {
        if (this.awN == null && CO() != null) {
            this.awN = (com.baidu.tbadk.editortools.imagetool.b) CO().eB(11);
        }
        return this.awN;
    }

    public void eK(int i) {
        if (this.awN == null && CO() != null) {
            this.awN = (com.baidu.tbadk.editortools.imagetool.b) CO().eB(11);
        }
        if (this.awN != null) {
            this.awN.eH(i);
        }
    }

    public com.baidu.tbadk.editortools.inputtool.a Dt() {
        if (this.awO == null && CO() != null) {
            this.awO = (com.baidu.tbadk.editortools.inputtool.a) CO().eB(3);
        }
        return this.awO;
    }

    public void fH(String str) {
        if (this.awO == null && CO() != null) {
            this.awO = (com.baidu.tbadk.editortools.inputtool.a) CO().eB(3);
        }
        if (this.awO != null) {
            this.awO.setHint(str);
        }
    }

    public void bF(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (CO() != null && (cVar = (com.baidu.tbadk.editortools.c) CO().ez(5)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bG(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (CO() != null && (cVar = (com.baidu.tbadk.editortools.c) CO().ez(23)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bH(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (CO() != null && (cVar = (com.baidu.tbadk.editortools.c) CO().ez(2)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void a(a<?> aVar) {
        this.awE = aVar;
    }

    public void d(BaseActivity<?> baseActivity) {
        this.awH = baseActivity;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.awJ = antiData.isIfvoice();
            this.awI = antiData.getVoice_message();
        }
        this.awF = antiData;
    }

    public void a(ForumData forumData, UserData userData) {
        this.awG = forumData;
        this.mUserData = userData;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (CO() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void Du() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            String valueOf = String.valueOf(this.authorId);
            if (valueOf == null || valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                com.baidu.adp.lib.util.k.showToast(this.awH.getActivity(), r.j.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.awH.getActivity(), this.authorId, this.authorName, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.h.b.c(this.mThreadId, 0L), com.baidu.adp.lib.h.b.c(this.postId, 0L))));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        com.baidu.tbadk.editortools.s sVar;
        com.baidu.tbadk.editortools.s sVar2;
        com.baidu.tbadk.editortools.s sVar3 = null;
        if (i2 == -1) {
            switch (i) {
                case 11001:
                    a((String) null, (WriteData) null);
                    return;
                case 11025:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.awH.getActivity(), 12004, true)));
                    return;
                case 11026:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.awH.getActivity(), 12005, true)));
                    return;
                case 12002:
                    if (intent != null) {
                        boolean booleanExtra = intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false);
                        if (b.Dp().getStatus() == 1) {
                            if (Ds() != null) {
                                Ds().eH(1);
                            }
                            if (getWriteImagesInfo() != null) {
                                getWriteImagesInfo().setMaxImagesAllowed(1);
                            }
                        } else {
                            if (Ds() != null) {
                                Ds().eH(10);
                            }
                            if (getWriteImagesInfo() != null) {
                                getWriteImagesInfo().setMaxImagesAllowed(10);
                            }
                        }
                        if (booleanExtra) {
                            f(intent);
                        } else {
                            e(intent);
                        }
                        if (CO() != null) {
                            sVar2 = CO().ez(2);
                            sVar = CO().ez(5);
                            sVar3 = CO().ez(23);
                        } else {
                            sVar = null;
                            sVar2 = null;
                        }
                        if (b.Dp().getStatus() == 1) {
                            DI();
                            if (CO() != null) {
                                CO().CZ();
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL));
                            }
                            if (sVar2 != null) {
                                sVar2.hide();
                            }
                            if (sVar != null) {
                                sVar.hide();
                            }
                            if (sVar3 != null) {
                                sVar3.lz();
                            }
                            if (Dt() != null) {
                                Dt().setHint(this.awH.getPageContext().getString(r.j.add_picture_description));
                            }
                            if (Ds() != null) {
                                Ds().fA(this.awH.getPageContext().getString(r.j.show_pic_tip));
                                Ds().fB(this.awH.getPageContext().getString(r.j.show_pic_add_tip));
                            }
                            if (Dr() != null) {
                                Dr().setType(SendView.axm);
                                Dr().eM(SendView.axm);
                            }
                        } else {
                            if (sVar2 != null) {
                                sVar2.lz();
                            }
                            if (sVar != null) {
                                sVar.lz();
                            }
                            if (sVar3 != null) {
                                sVar3.hide();
                            }
                            if (Dt() != null) {
                                Dt().setHint(this.awH.getPageContext().getString(r.j.pb_reply_hint));
                            }
                            if (Dr() != null) {
                                Dr().setType(SendView.ALL);
                                Dr().eM(SendView.ALL);
                            }
                        }
                        CO().invalidate();
                        return;
                    }
                    return;
                case 12003:
                    if (intent != null) {
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            DF();
                            this.awC.lp(false);
                            return;
                        }
                        this.awD.fG(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case 12004:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra(IntentConfig.NAME_SHOW)) != null) {
                        r(stringArrayListExtra);
                        return;
                    }
                    return;
                case 12006:
                    WriteData bia = this.awC.bia();
                    if (bia != null) {
                        bia.deleteUploadedTempImages();
                    }
                    this.awC.d((WriteData) null);
                    this.awC.lp(false);
                    this.awz = null;
                    this.mVideoInfo = null;
                    this.mGraffitiFileName = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        ad.c(this.mThreadId, (WriteData) null);
                    }
                    bJ(true);
                    if (this.awL != null) {
                        this.awL.callback(true, null, null, bia, null);
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    if (i == 12010) {
                        c(intent);
                        return;
                    }
                    return;
                case 12012:
                    d(intent);
                    if (b.Dp().getStatus() == 1 && Ds() != null) {
                        Ds().fA(this.awH.getPageContext().getString(r.j.show_pic_tip));
                        return;
                    }
                    return;
                case 13010:
                    if (CO() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            av avVar = new av("c10068");
                            avVar.s("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(avVar);
                            DG();
                            CO().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            CO().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                        fL(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 12001:
                DB();
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

    public void Dv() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.awH.getActivity())));
    }

    public void Dw() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.awH.getActivity())) {
            this.awH.showToast(r.j.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.m9getInst().getLocationShared()) {
            Dx();
        } else if (this.awB.bmP()) {
            Dv();
        } else {
            this.awB.ln(false);
            b(1, true, null);
            this.awB.bmN();
        }
    }

    private void Dx() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.awH.getActivity());
        aVar.ca(r.j.location_app_permission_prompt).a(r.j.isopen, new j(this)).b(r.j.cancel, new k(this)).b(this.awH.getPageContext());
        aVar.tq();
    }

    public void Dy() {
        if (this.awB.bmR()) {
            if (this.awB.bmP()) {
                this.awQ.a(com.baidu.tieba.tbadkCore.location.c.bmL().getLocationData());
                return;
            }
            if (com.baidu.adp.lib.util.k.gD()) {
                this.awB.bmN();
            }
            b(0, true, null);
            return;
        }
        b(0, false, null);
    }

    public boolean Dz() {
        if (StringUtils.isNull(this.awy)) {
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() <= 0) {
                if (this.awz == null || StringUtils.isNull(this.awz.getId())) {
                    return (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) || this.mGraffitiFileName != null;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    public void resetData() {
        this.awC.d((WriteData) null);
        this.awC.lp(false);
        this.awz = null;
        this.mVideoInfo = null;
        this.mGraffitiFileName = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void DA() {
        this.mVideoInfo = null;
    }

    private void c(Intent intent) {
        this.awA = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.awA;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.k.dip2px(this.awH.getActivity(), com.baidu.adp.lib.util.k.K(this.awH.getActivity())), com.baidu.adp.lib.util.k.dip2px(this.awH.getActivity(), com.baidu.adp.lib.util.k.L(this.awH.getActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.m.a(TbConfig.LOCAL_CAMERA_DIR, this.awA, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            DH();
        }
    }

    private void d(Intent intent) {
        b(intent, false);
    }

    private void b(Intent intent, boolean z) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                DH();
            }
        }
    }

    private void DB() {
        new l(this).execute(new Void[0]);
    }

    private void e(Intent intent) {
        b(intent, true);
    }

    private void f(Intent intent) {
        int size;
        int size2;
        c(intent);
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() - 1 > -1 && this.writeImagesInfo.getChosedFiles() != null && (size2 = this.writeImagesInfo.getChosedFiles().size()) >= 1 && size >= 0 && size < size2) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.awH.getActivity(), 12012, this.writeImagesInfo, size)));
        }
    }

    public void fI(String str) {
        WriteData bia = this.awC.bia();
        if (bia == null) {
            bia = new WriteData(1);
            bia.setThreadId(str);
            bia.setWriteImagesInfo(this.writeImagesInfo);
        }
        bia.setContent(this.awy);
        bia.setVideoInfo(this.mVideoInfo);
        bia.setGraffitiFileName(this.mGraffitiFileName);
        ad.c(str, bia);
    }

    public void fJ(String str) {
        ad.a(str, this);
    }

    @Override // com.baidu.tieba.tbadkCore.ad.a
    public void a(WriteData writeData) {
        if (writeData != null) {
            if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                if (this.mVideoInfo == null) {
                    this.mVideoInfo = new VideoInfo();
                }
                this.mVideoInfo.copy(writeData.getVideoInfo());
                DG();
                CO().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                bI(false);
            }
            this.mGraffitiFileName = writeData.getGraffitiFileName();
            if (CO() != null && !ax.isEmpty(this.mGraffitiFileName)) {
                CO().b(new com.baidu.tbadk.editortools.a(42, 24, this.mGraffitiFileName));
            }
            if (!ax.isEmpty(writeData.getContent()) && ax.isEmpty(this.awy)) {
                this.awy = writeData.getContent();
                fM(this.awy);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.awC.cancelLoadData();
        this.awD.cancelLoadData();
        this.awB.cancelLoadData();
    }

    public void DC() {
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        this.awC = new com.baidu.tieba.tbadkCore.writeModel.b(baseActivity);
        this.awC.b(this.awS);
        this.awD = new d(baseActivity);
        this.awD.setLoadDataCallBack(this.awT);
        this.awB = new com.baidu.tieba.tbadkCore.location.d(baseActivity);
        this.awB.a(this.awQ);
        this.awB.a(this.awR);
        if (bundle != null) {
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable("write_images");
            this.awA = bundle.getString("photo_name");
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(10);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.m9getInst().getDefaultBubble()) && CO() != null) {
            CO().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.awB.bmR() && CO() != null) {
            CO().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
        DD();
    }

    private void DD() {
        boolean z;
        try {
            z = com.baidu.tbadk.core.sharedPref.b.um().getBoolean("graffiti_reply_notice_show", true);
        } catch (ClassCastException e) {
            com.baidu.tbadk.core.sharedPref.b.um().remove("graffiti_reply_notice_show");
            z = false;
        }
        if (CO() != null) {
            CO().b(new com.baidu.tbadk.editortools.a(2, 24, z ? " " : null));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("write_images", this.writeImagesInfo);
        bundle.putString("photo_name", this.awA);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.awC.bia() == null) {
            this.awC.d(this.awE.fF(str));
        }
        if (this.awC.bia() != null) {
            this.awC.bia().setWriteImagesInfo(this.writeImagesInfo);
            this.awC.bia().setVideoInfo(this.mVideoInfo);
            this.awC.bia().setGraffitiFileName(this.mGraffitiFileName);
            this.awC.lp(this.writeImagesInfo.size() > 0);
            WriteData bia = this.awC.bia();
            if (this.awB == null || !this.awB.bmR()) {
                z = false;
            }
            bia.setHasLocationData(z);
            if (str == null) {
                this.awC.bia().setContent(this.awy);
            }
            if (this.awz != null) {
                if (this.awz.getId() != null) {
                    this.awC.bia().setVoice(this.awz.getId());
                    this.awC.bia().setVoiceDuringTime(this.awz.duration);
                } else {
                    this.awC.bia().setVoice(null);
                    this.awC.bia().setVoiceDuringTime(-1);
                }
            } else {
                this.awC.bia().setVoice(null);
                this.awC.bia().setVoiceDuringTime(-1);
            }
            if (!this.awC.bnr()) {
                this.awH.showToast(r.j.write_img_limit);
                return;
            }
            if (this.awM != null) {
                this.awM.Dq();
            }
            if (!this.awC.bno()) {
            }
        }
    }

    public BaseActivity<?> getContext() {
        return this.awH;
    }

    public void fK(String str) {
        this.awy = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.awz = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int DE() {
        return this.awK;
    }

    private void DF() {
        if (CO() != null) {
            CO().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void r(ArrayList<String> arrayList) {
        if (CO() != null) {
            CO().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    public void fL(String str) {
        if (CO() != null) {
            CO().b(new com.baidu.tbadk.editortools.a(44, 3, str));
        }
    }

    private void DG() {
        if (CO() != null) {
            CO().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    protected void bI(boolean z) {
        if (CO() != null) {
            if (z) {
                CO().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            CO().b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                CO().b(new com.baidu.tbadk.editortools.a(2, 10, new StringBuilder(String.valueOf(this.writeImagesInfo.getChosedFiles().size())).toString()));
            } else {
                CO().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
        }
    }

    protected void DH() {
        bI(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void DI() {
        if (CO() != null) {
            CO().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.awK = i;
        if (CO() != null) {
            CO().b(new com.baidu.tbadk.editortools.a(19, 8, new com.baidu.tbadk.editortools.d.a(i, z, str)));
            if (i == 2) {
                CO().b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            } else {
                CO().b(new com.baidu.tbadk.editortools.a(2, 7, null));
            }
        }
    }

    private void fM(String str) {
        if (CO() != null) {
            CO().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJ(boolean z) {
        if (CO() != null) {
            CO().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(b.d dVar) {
        this.awL = dVar;
    }

    public void a(c cVar) {
        this.awM = cVar;
    }

    public void DJ() {
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            this.writeImagesInfo.clear();
        }
        DH();
        if (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) {
            this.mVideoInfo = null;
        }
        CO().b(new com.baidu.tbadk.editortools.a(2, 19, null));
        setVoiceModel(null);
        CO().b(new com.baidu.tbadk.editortools.a(2, 6, null));
        CO().b(new com.baidu.tbadk.editortools.a(33, 6, null));
        if (!StringUtils.isNull(this.awy)) {
            this.awy = "";
        }
        fM("");
        this.mGraffitiFileName = null;
        CO().b(new com.baidu.tbadk.editortools.a(42, 24, null));
        this.awC.d((WriteData) null);
        this.awC.lp(false);
    }

    public void eL(int i) {
        if (this.awO == null && CO() != null) {
            this.awO = (com.baidu.tbadk.editortools.inputtool.a) CO().eB(3);
        }
        if (this.awO != null && (this.awO.auC instanceof EditText)) {
            this.awO.b(new m(this, i, (EditText) this.awO.auC));
        }
    }

    public void DK() {
        if (this.awO != null) {
            this.awO.b(null);
        }
    }

    public void setGraffitiFileName(String str) {
        this.mGraffitiFileName = str;
    }
}
