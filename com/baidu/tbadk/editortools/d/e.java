package com.baidu.tbadk.editortools.d;

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
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.ad;
import com.baidu.tieba.tbadkCore.location.d;
import com.baidu.tieba.tbadkCore.writeModel.a;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.editortools.f implements ad.a {
    private long authorId;
    private String authorName;
    private BaseActivity<?> avA;
    private String avB;
    private boolean avC;
    private int avD;
    private a.d avE;
    private c avF;
    private com.baidu.tbadk.editortools.imagetool.b avG;
    private com.baidu.tbadk.editortools.inputtool.a avH;
    private com.baidu.tbadk.editortools.sendtool.a avI;
    private d.a avJ;
    private d.b avK;
    private final a.d avL;
    private final com.baidu.adp.base.g avM;
    private String avq;
    private VoiceData.VoiceModel avr;
    private WriteData avs;
    private String avt;
    private com.baidu.tieba.tbadkCore.location.d avu;
    private com.baidu.tieba.tbadkCore.writeModel.a avv;
    private d avw;
    private a<?> avx;
    private AntiData avy;
    private ForumData avz;
    private WriteImagesInfo baobaoImagesInfo;
    private String mGraffitiFileName;
    private String mThreadId;
    private UserData mUserData;
    private VideoInfo mVideoInfo;
    private String postId;
    private WriteImagesInfo writeImagesInfo;

    public e(com.baidu.tbadk.editortools.l lVar) {
        super(lVar);
        this.writeImagesInfo = new WriteImagesInfo();
        this.baobaoImagesInfo = new WriteImagesInfo();
        this.avq = "";
        this.avs = new WriteData();
        this.avv = null;
        this.avw = null;
        this.mThreadId = null;
        this.avB = null;
        this.avC = true;
        this.avD = 0;
        this.avJ = new f(this);
        this.avK = new g(this);
        this.avL = new h(this);
        this.avM = new i(this);
    }

    private com.baidu.tbadk.editortools.sendtool.a DK() {
        if (this.avI == null && Dh() != null) {
            this.avI = (com.baidu.tbadk.editortools.sendtool.a) Dh().eC(4);
        }
        return this.avI;
    }

    public void eI(int i) {
        if (this.avI == null && Dh() != null) {
            this.avI = (com.baidu.tbadk.editortools.sendtool.a) Dh().eC(4);
        }
        if (this.avI != null) {
            this.avI.setType(i);
        }
    }

    public void eJ(int i) {
        if (this.avI == null && Dh() != null) {
            this.avI = (com.baidu.tbadk.editortools.sendtool.a) Dh().eC(4);
        }
        if (this.avI != null) {
            this.avI.eM(i);
        }
    }

    private com.baidu.tbadk.editortools.imagetool.b DL() {
        if (this.avG == null && Dh() != null) {
            this.avG = (com.baidu.tbadk.editortools.imagetool.b) Dh().eC(11);
        }
        return this.avG;
    }

    public void eK(int i) {
        if (this.avG == null && Dh() != null) {
            this.avG = (com.baidu.tbadk.editortools.imagetool.b) Dh().eC(11);
        }
        if (this.avG != null) {
            this.avG.eH(i);
        }
    }

    private com.baidu.tbadk.editortools.inputtool.a DM() {
        if (this.avH == null && Dh() != null) {
            this.avH = (com.baidu.tbadk.editortools.inputtool.a) Dh().eC(3);
        }
        return this.avH;
    }

    public void fx(String str) {
        if (this.avH == null && Dh() != null) {
            this.avH = (com.baidu.tbadk.editortools.inputtool.a) Dh().eC(3);
        }
        if (this.avH != null) {
            this.avH.setHint(str);
        }
    }

    public void bs(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (Dh() != null && (cVar = (com.baidu.tbadk.editortools.c) Dh().eA(5)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bt(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (Dh() != null && (cVar = (com.baidu.tbadk.editortools.c) Dh().eA(23)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bu(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (Dh() != null && (cVar = (com.baidu.tbadk.editortools.c) Dh().eA(2)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void a(a<?> aVar) {
        this.avx = aVar;
    }

    public void d(BaseActivity<?> baseActivity) {
        this.avA = baseActivity;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.avC = antiData.isIfvoice();
            this.avB = antiData.getVoice_message();
        }
        this.avy = antiData;
    }

    public void a(ForumData forumData, UserData userData) {
        this.avz = forumData;
        this.mUserData = userData;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (Dh() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void DN() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            String valueOf = String.valueOf(this.authorId);
            if (valueOf == null || valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                com.baidu.adp.lib.util.k.showToast(this.avA.getActivity(), t.j.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.avA.getActivity(), this.authorId, this.authorName, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.h.b.c(this.mThreadId, 0L), com.baidu.adp.lib.h.b.c(this.postId, 0L))));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.tbadk.editortools.s sVar;
        com.baidu.tbadk.editortools.s sVar2;
        com.baidu.tbadk.editortools.s sVar3 = null;
        if (i2 == -1) {
            switch (i) {
                case 11001:
                    a((String) null, (WriteData) null);
                    return;
                case 11025:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.avA.getActivity(), 12004, true)));
                    return;
                case 11026:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.avA.getActivity(), 12005, true)));
                    return;
                case 12002:
                    if (intent != null) {
                        boolean booleanExtra = intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false);
                        if (b.DI().getStatus() == 1) {
                            if (DL() != null) {
                                DL().eH(1);
                            }
                            if (getWriteImagesInfo() != null) {
                                getWriteImagesInfo().setMaxImagesAllowed(1);
                            }
                        } else {
                            if (DL() != null) {
                                DL().eH(10);
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
                        if (Dh() != null) {
                            sVar2 = Dh().eA(2);
                            sVar = Dh().eA(5);
                            sVar3 = Dh().eA(23);
                        } else {
                            sVar = null;
                            sVar2 = null;
                        }
                        if (b.DI().getStatus() == 1) {
                            Ee();
                            if (Dh() != null) {
                                Dh().Ds();
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL));
                            }
                            if (sVar2 != null) {
                                sVar2.hide();
                            }
                            if (sVar != null) {
                                sVar.hide();
                            }
                            if (sVar3 != null) {
                                sVar3.op();
                            }
                            if (DM() != null) {
                                DM().setHint(this.avA.getPageContext().getString(t.j.add_picture_description));
                            }
                            if (DL() != null) {
                                DL().fr(this.avA.getPageContext().getString(t.j.show_pic_tip));
                                DL().fs(this.avA.getPageContext().getString(t.j.show_pic_add_tip));
                            }
                            if (DK() != null) {
                                DK().setType(SendView.awf);
                                DK().eM(SendView.awf);
                            }
                        } else {
                            if (sVar2 != null) {
                                sVar2.op();
                            }
                            if (sVar != null) {
                                sVar.op();
                            }
                            if (sVar3 != null) {
                                sVar3.hide();
                            }
                            if (DM() != null) {
                                DM().setHint(this.avA.getPageContext().getString(t.j.pb_reply_hint));
                            }
                            if (DK() != null) {
                                DK().setType(SendView.ALL);
                                DK().eM(SendView.ALL);
                            }
                        }
                        Dh().invalidate();
                        return;
                    }
                    return;
                case 12003:
                    if (intent != null) {
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            Eb();
                            this.avv.iN(false);
                            return;
                        }
                        this.avw.fw(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case 12004:
                    ArrayList<String> t = com.baidu.tieba.tbadkCore.util.l.t(intent);
                    if (t != null) {
                        p(t);
                        return;
                    }
                    return;
                case 12006:
                    WriteData aUF = this.avv.aUF();
                    if (aUF != null) {
                        aUF.deleteUploadedTempImages();
                    }
                    this.avs.setIsBaobao(false);
                    this.avs.setBaobaoContent(null);
                    this.baobaoImagesInfo.clear();
                    this.avv.d((WriteData) null);
                    this.avv.iN(false);
                    this.avr = null;
                    this.mVideoInfo = null;
                    this.mGraffitiFileName = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        ad.c(this.mThreadId, (WriteData) null);
                    }
                    bw(true);
                    if (this.avE != null) {
                        this.avE.callback(true, null, null, aUF, null);
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    if (i == 12010) {
                        b(intent);
                        return;
                    }
                    return;
                case 12012:
                    c(intent);
                    if (b.DI().getStatus() == 1 && DL() != null) {
                        DL().fr(this.avA.getPageContext().getString(t.j.show_pic_tip));
                        return;
                    }
                    return;
                case 12013:
                    d(intent);
                    return;
                case 13010:
                    if (Dh() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            aw awVar = new aw("c10068");
                            awVar.r("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(awVar);
                            Ec();
                            Dh().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            Dh().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
                            return;
                        }
                        return;
                    }
                    return;
                case 23004:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 12001:
                DV();
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

    public void DO() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.avA.getActivity())));
    }

    public void DQ() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.avA.getActivity())) {
            this.avA.showToast(t.j.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.m411getInst().getLocationShared()) {
            DR();
        } else if (this.avu.aUi()) {
            DO();
        } else {
            this.avu.iL(false);
            a(1, true, (String) null);
            this.avu.aUg();
        }
    }

    private void DR() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.avA.getActivity());
        aVar.ca(t.j.location_app_permission_prompt).a(t.j.isopen, new j(this)).b(t.j.cancel, new k(this)).b(this.avA.getPageContext());
        aVar.up();
    }

    public void DS() {
        if (this.avu.aUk()) {
            if (this.avu.aUi()) {
                this.avJ.a(com.baidu.tieba.tbadkCore.location.c.aUd().getLocationData());
                return;
            }
            if (com.baidu.adp.lib.util.k.jw()) {
                this.avu.aUg();
            }
            a(0, true, (String) null);
            return;
        }
        a(0, false, (String) null);
    }

    public boolean DT() {
        if (StringUtils.isNull(this.avq)) {
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() <= 0) {
                if (this.baobaoImagesInfo == null || this.baobaoImagesInfo.size() <= 0) {
                    if (this.avr == null || StringUtils.isNull(this.avr.getId())) {
                        return (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) || this.mGraffitiFileName != null;
                    }
                    return true;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    public void resetData() {
        this.avv.d((WriteData) null);
        this.avv.iN(false);
        this.avr = null;
        this.mVideoInfo = null;
        this.mGraffitiFileName = null;
        this.baobaoImagesInfo.clear();
        this.writeImagesInfo.clear();
        this.avs.setIsBaobao(false);
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void DU() {
        this.mVideoInfo = null;
    }

    private void b(Intent intent) {
        this.avt = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.avt;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.k.dip2px(this.avA.getActivity(), com.baidu.adp.lib.util.k.B(this.avA.getActivity())), com.baidu.adp.lib.util.k.dip2px(this.avA.getActivity(), com.baidu.adp.lib.util.k.C(this.avA.getActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.m.b(TbConfig.LOCAL_CAMERA_DIR, this.avt, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            Ed();
        }
    }

    private void c(Intent intent) {
        a(intent, false);
    }

    private void a(Intent intent, boolean z) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                Ed();
            }
        }
    }

    private void d(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("key_bitmap_path");
            String stringExtra2 = intent.getStringExtra("key_content");
            if (stringExtra != null && stringExtra2 != null) {
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(stringExtra);
                this.baobaoImagesInfo.clear();
                this.baobaoImagesInfo.addChooseFile(imageFileInfo);
                Ef();
                if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
                    this.avs.setIsBaobao(true);
                    this.avs.setBaobaoContent(stringExtra2);
                    this.avs.setBaobaoImagesInfo(this.baobaoImagesInfo);
                    return;
                }
                this.avs.setIsBaobao(false);
                this.avs.setBaobaoContent("");
                this.avs.setBaobaoImagesInfo(this.baobaoImagesInfo);
            }
        }
    }

    private void DV() {
        new l(this).execute(new Void[0]);
    }

    private void e(Intent intent) {
        a(intent, true);
    }

    private void f(Intent intent) {
        int size;
        int size2;
        b(intent);
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() - 1 > -1 && this.writeImagesInfo.getChosedFiles() != null && (size2 = this.writeImagesInfo.getChosedFiles().size()) >= 1 && size >= 0 && size < size2) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.avA.getActivity(), 12012, this.writeImagesInfo, size)));
        }
    }

    public void fy(String str) {
        WriteData aUF = this.avv.aUF();
        if (aUF == null) {
            aUF = new WriteData(1);
            aUF.setThreadId(str);
            aUF.setWriteImagesInfo(this.writeImagesInfo);
        }
        aUF.setContent(this.avq);
        if (this.avs != null && this.avs.getIsBaobao()) {
            aUF.setBaobaoContent(this.avs.getBaobaoContent());
            aUF.setBaobaoImagesInfo(this.baobaoImagesInfo);
            aUF.setIsBaobao(true);
        }
        aUF.setVideoInfo(this.mVideoInfo);
        aUF.setGraffitiFileName(this.mGraffitiFileName);
        ad.c(str, aUF);
    }

    public void fz(String str) {
        ad.a(str, this);
    }

    @Override // com.baidu.tieba.tbadkCore.ad.a
    public void a(WriteData writeData) {
        if (writeData != null) {
            if (!ay.isEmpty(writeData.getContent()) && ay.isEmpty(this.avq)) {
                this.avq = writeData.getContent();
                fB(this.avq);
            }
            if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                if (this.mVideoInfo == null) {
                    this.mVideoInfo = new VideoInfo();
                }
                this.mVideoInfo.copy(writeData.getVideoInfo());
                Ec();
                Dh().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                bv(false);
            }
            if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen() && writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                this.avs.setIsBaobao(writeData.getIsBaobao());
                this.avs.setBaobaoContent(writeData.getBaobaoContent());
                this.avs.setBaobaoImagesInfo(this.baobaoImagesInfo);
                Ef();
            }
            this.mGraffitiFileName = writeData.getGraffitiFileName();
            if (Dh() != null) {
                Dh().b(new com.baidu.tbadk.editortools.a(42, 24, this.mGraffitiFileName));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.avv.cancelLoadData();
        this.avw.cancelLoadData();
        this.avu.cancelLoadData();
    }

    public void DW() {
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        this.avv = new com.baidu.tieba.tbadkCore.writeModel.a(baseActivity);
        this.avv.b(this.avL);
        this.avw = new d(baseActivity);
        this.avw.setLoadDataCallBack(this.avM);
        this.avu = new com.baidu.tieba.tbadkCore.location.d(baseActivity);
        this.avu.a(this.avJ);
        this.avu.a(this.avK);
        if (bundle != null) {
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.avt = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        this.writeImagesInfo.setMaxImagesAllowed(10);
        if (!StringUtils.isNull(TbadkCoreApplication.m411getInst().getDefaultBubble()) && Dh() != null) {
            Dh().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.avu.aUk() && Dh() != null) {
            Dh().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
        DX();
    }

    private void DX() {
        boolean z;
        try {
            z = com.baidu.tbadk.core.sharedPref.b.vk().getBoolean("graffiti_reply_notice_show", true);
        } catch (ClassCastException e) {
            com.baidu.tbadk.core.sharedPref.b.vk().remove("graffiti_reply_notice_show");
            z = false;
        }
        if (Dh() != null) {
            Dh().b(new com.baidu.tbadk.editortools.a(2, 24, z ? " " : null));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.avt);
    }

    public void a(String str, WriteData writeData) {
        if (this.avv.aUF() == null) {
            this.avv.d(this.avx.fv(str));
        }
        if (this.avv.aUF() != null) {
            this.avv.aUF().setWriteImagesInfo(this.writeImagesInfo);
            this.avv.aUF().setVideoInfo(this.mVideoInfo);
            this.avv.aUF().setGraffitiFileName(this.mGraffitiFileName);
            this.avv.iN(this.writeImagesInfo.size() > 0);
            if (this.avs.getIsBaobao()) {
                this.avv.aUF().setIsBaobao(true);
                this.avv.aUF().setBaobaoContent(this.avs.getBaobaoContent());
                this.avv.aUF().setBaobaoImagesInfo(this.baobaoImagesInfo);
            } else {
                this.avv.aUF().setIsBaobao(false);
            }
            this.avv.aUF().setHasLocationData(this.avu != null ? this.avu.aUk() : false);
            if (str == null) {
                this.avv.aUF().setContent(this.avq);
            }
            if (this.avr != null) {
                if (this.avr.getId() != null) {
                    this.avv.aUF().setVoice(this.avr.getId());
                    this.avv.aUF().setVoiceDuringTime(this.avr.duration);
                } else {
                    this.avv.aUF().setVoice(null);
                    this.avv.aUF().setVoiceDuringTime(-1);
                }
            } else {
                this.avv.aUF().setVoice(null);
                this.avv.aUF().setVoiceDuringTime(-1);
            }
            if (!this.avv.aUJ()) {
                this.avA.showToast(t.j.write_img_limit);
                return;
            }
            if (this.avF != null) {
                this.avF.DJ();
            }
            if (!this.avv.aUG()) {
            }
        }
    }

    public BaseActivity<?> DY() {
        return this.avA;
    }

    public WriteImagesInfo getBaobaoImagesInfo() {
        return this.baobaoImagesInfo;
    }

    public void fA(String str) {
        this.avq = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.avr = voiceModel;
    }

    public WriteData DZ() {
        return this.avs;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int Ea() {
        return this.avD;
    }

    private void Eb() {
        if (Dh() != null) {
            Dh().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void p(ArrayList<String> arrayList) {
        if (Dh() != null) {
            Dh().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    private void Ec() {
        if (Dh() != null) {
            Dh().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    protected void bv(boolean z) {
        if (Dh() != null) {
            if (z) {
                Dh().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            Dh().b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                Dh().b(new com.baidu.tbadk.editortools.a(2, 10, new StringBuilder(String.valueOf(this.writeImagesInfo.getChosedFiles().size())).toString()));
            } else {
                Dh().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
        }
    }

    protected void Ed() {
        bv(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ee() {
        if (Dh() != null) {
            Dh().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    protected void Ef() {
        if (Dh() != null) {
            Dh().b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            Dh().b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
                Dh().b(new com.baidu.tbadk.editortools.a(2, 13, " "));
            } else {
                Dh().b(new com.baidu.tbadk.editortools.a(2, 13, null));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Eg() {
        if (Dh() != null) {
            Dh().b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.avD = i;
        if (Dh() != null) {
            Dh().b(new com.baidu.tbadk.editortools.a(19, 8, new com.baidu.tbadk.editortools.c.a(i, z, str)));
            if (i == 2) {
                Dh().b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            } else {
                Dh().b(new com.baidu.tbadk.editortools.a(2, 7, null));
            }
        }
    }

    private void fB(String str) {
        if (Dh() != null) {
            Dh().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bw(boolean z) {
        if (Dh() != null) {
            Dh().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void Eh() {
        bw(true);
    }

    public void a(a.d dVar) {
        this.avE = dVar;
    }

    public void a(c cVar) {
        this.avF = cVar;
    }

    public void Ei() {
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            this.writeImagesInfo.clear();
        }
        Ed();
        if (this.baobaoImagesInfo != null && this.baobaoImagesInfo.size() > 0) {
            this.baobaoImagesInfo.clear();
        }
        Ef();
        if (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) {
            this.mVideoInfo = null;
        }
        Dh().b(new com.baidu.tbadk.editortools.a(2, 19, null));
        setVoiceModel(null);
        Dh().b(new com.baidu.tbadk.editortools.a(2, 6, null));
        Dh().b(new com.baidu.tbadk.editortools.a(33, 6, null));
        if (!StringUtils.isNull(this.avq)) {
            this.avq = "";
        }
        fB("");
        this.mGraffitiFileName = null;
        Dh().b(new com.baidu.tbadk.editortools.a(42, 24, null));
        this.avv.d((WriteData) null);
        this.avv.iN(false);
    }

    public void eL(int i) {
        if (this.avH == null && Dh() != null) {
            this.avH = (com.baidu.tbadk.editortools.inputtool.a) Dh().eC(3);
        }
        if (this.avH != null && (this.avH.toolView instanceof EditText)) {
            this.avH.b(new m(this, i, (EditText) this.avH.toolView));
        }
    }

    public void Ej() {
        if (this.avH != null) {
            this.avH.b(null);
        }
    }

    public void setGraffitiFileName(String str) {
        this.mGraffitiFileName = str;
    }
}
