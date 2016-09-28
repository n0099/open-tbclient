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
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.ae;
import com.baidu.tieba.tbadkCore.location.d;
import com.baidu.tieba.tbadkCore.writeModel.b;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.editortools.f implements ae.a {
    private long authorId;
    private String authorName;
    private String avE;
    private VoiceData.VoiceModel avF;
    private WriteData avG;
    private String avH;
    private com.baidu.tieba.tbadkCore.location.d avI;
    private com.baidu.tieba.tbadkCore.writeModel.b avJ;
    private d avK;
    private a<?> avL;
    private AntiData avM;
    private ForumData avN;
    private BaseActivity<?> avO;
    private String avP;
    private boolean avQ;
    private int avR;
    private b.d avS;
    private c avT;
    private com.baidu.tbadk.editortools.imagetool.b avU;
    private com.baidu.tbadk.editortools.inputtool.a avV;
    private com.baidu.tbadk.editortools.sendtool.a avW;
    private d.a avX;
    private d.b avY;
    private final b.d avZ;
    private final com.baidu.adp.base.g awa;
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
        this.avE = "";
        this.avG = new WriteData();
        this.avJ = null;
        this.avK = null;
        this.mThreadId = null;
        this.avP = null;
        this.avQ = true;
        this.avR = 0;
        this.avX = new f(this);
        this.avY = new g(this);
        this.avZ = new h(this);
        this.awa = new i(this);
    }

    private com.baidu.tbadk.editortools.sendtool.a Dj() {
        if (this.avW == null && CG() != null) {
            this.avW = (com.baidu.tbadk.editortools.sendtool.a) CG().ey(4);
        }
        return this.avW;
    }

    public void eF(int i) {
        if (this.avW == null && CG() != null) {
            this.avW = (com.baidu.tbadk.editortools.sendtool.a) CG().ey(4);
        }
        if (this.avW != null) {
            this.avW.setType(i);
        }
    }

    public void eG(int i) {
        if (this.avW == null && CG() != null) {
            this.avW = (com.baidu.tbadk.editortools.sendtool.a) CG().ey(4);
        }
        if (this.avW != null) {
            this.avW.eJ(i);
        }
    }

    private com.baidu.tbadk.editortools.imagetool.b Dk() {
        if (this.avU == null && CG() != null) {
            this.avU = (com.baidu.tbadk.editortools.imagetool.b) CG().ey(11);
        }
        return this.avU;
    }

    public void eH(int i) {
        if (this.avU == null && CG() != null) {
            this.avU = (com.baidu.tbadk.editortools.imagetool.b) CG().ey(11);
        }
        if (this.avU != null) {
            this.avU.eE(i);
        }
    }

    public com.baidu.tbadk.editortools.inputtool.a Dl() {
        if (this.avV == null && CG() != null) {
            this.avV = (com.baidu.tbadk.editortools.inputtool.a) CG().ey(3);
        }
        return this.avV;
    }

    public void fE(String str) {
        if (this.avV == null && CG() != null) {
            this.avV = (com.baidu.tbadk.editortools.inputtool.a) CG().ey(3);
        }
        if (this.avV != null) {
            this.avV.setHint(str);
        }
    }

    public void bB(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (CG() != null && (cVar = (com.baidu.tbadk.editortools.c) CG().ew(5)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bC(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (CG() != null && (cVar = (com.baidu.tbadk.editortools.c) CG().ew(23)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bD(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (CG() != null && (cVar = (com.baidu.tbadk.editortools.c) CG().ew(2)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void a(a<?> aVar) {
        this.avL = aVar;
    }

    public void d(BaseActivity<?> baseActivity) {
        this.avO = baseActivity;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.avQ = antiData.isIfvoice();
            this.avP = antiData.getVoice_message();
        }
        this.avM = antiData;
    }

    public void a(ForumData forumData, UserData userData) {
        this.avN = forumData;
        this.mUserData = userData;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (CG() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void Dm() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            String valueOf = String.valueOf(this.authorId);
            if (valueOf == null || valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                com.baidu.adp.lib.util.k.showToast(this.avO.getActivity(), r.j.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.avO.getActivity(), this.authorId, this.authorName, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.h.b.c(this.mThreadId, 0L), com.baidu.adp.lib.h.b.c(this.postId, 0L))));
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.avO.getActivity(), 12004, true)));
                    return;
                case 11026:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.avO.getActivity(), 12005, true)));
                    return;
                case 12002:
                    if (intent != null) {
                        boolean booleanExtra = intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false);
                        if (b.Dh().getStatus() == 1) {
                            if (Dk() != null) {
                                Dk().eE(1);
                            }
                            if (getWriteImagesInfo() != null) {
                                getWriteImagesInfo().setMaxImagesAllowed(1);
                            }
                        } else {
                            if (Dk() != null) {
                                Dk().eE(10);
                            }
                            if (getWriteImagesInfo() != null) {
                                getWriteImagesInfo().setMaxImagesAllowed(10);
                            }
                        }
                        if (booleanExtra) {
                            g(intent);
                        } else {
                            f(intent);
                        }
                        if (CG() != null) {
                            sVar2 = CG().ew(2);
                            sVar = CG().ew(5);
                            sVar3 = CG().ew(23);
                        } else {
                            sVar = null;
                            sVar2 = null;
                        }
                        if (b.Dh().getStatus() == 1) {
                            DB();
                            if (CG() != null) {
                                CG().CR();
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL));
                            }
                            if (sVar2 != null) {
                                sVar2.hide();
                            }
                            if (sVar != null) {
                                sVar.hide();
                            }
                            if (sVar3 != null) {
                                sVar3.lw();
                            }
                            if (Dl() != null) {
                                Dl().setHint(this.avO.getPageContext().getString(r.j.add_picture_description));
                            }
                            if (Dk() != null) {
                                Dk().fx(this.avO.getPageContext().getString(r.j.show_pic_tip));
                                Dk().fy(this.avO.getPageContext().getString(r.j.show_pic_add_tip));
                            }
                            if (Dj() != null) {
                                Dj().setType(SendView.awt);
                                Dj().eJ(SendView.awt);
                            }
                        } else {
                            if (sVar2 != null) {
                                sVar2.lw();
                            }
                            if (sVar != null) {
                                sVar.lw();
                            }
                            if (sVar3 != null) {
                                sVar3.hide();
                            }
                            if (Dl() != null) {
                                Dl().setHint(this.avO.getPageContext().getString(r.j.pb_reply_hint));
                            }
                            if (Dj() != null) {
                                Dj().setType(SendView.ALL);
                                Dj().eJ(SendView.ALL);
                            }
                        }
                        CG().invalidate();
                        return;
                    }
                    return;
                case 12003:
                    if (intent != null) {
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            Dy();
                            this.avJ.kQ(false);
                            return;
                        }
                        this.avK.fD(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case 12004:
                    ArrayList<String> y = com.baidu.tieba.tbadkCore.util.l.y(intent);
                    if (y != null) {
                        q(y);
                        return;
                    }
                    return;
                case 12006:
                    WriteData bfE = this.avJ.bfE();
                    if (bfE != null) {
                        bfE.deleteUploadedTempImages();
                    }
                    this.avG.setIsBaobao(false);
                    this.avG.setBaobaoContent(null);
                    this.baobaoImagesInfo.clear();
                    this.avJ.d((WriteData) null);
                    this.avJ.kQ(false);
                    this.avF = null;
                    this.mVideoInfo = null;
                    this.mGraffitiFileName = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        ae.c(this.mThreadId, (WriteData) null);
                    }
                    bF(true);
                    if (this.avS != null) {
                        this.avS.callback(true, null, null, bfE, null);
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
                    if (b.Dh().getStatus() == 1 && Dk() != null) {
                        Dk().fx(this.avO.getPageContext().getString(r.j.show_pic_tip));
                        return;
                    }
                    return;
                case 12013:
                    e(intent);
                    return;
                case 13010:
                    if (CG() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            ax axVar = new ax("c10068");
                            axVar.s("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(axVar);
                            Dz();
                            CG().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            CG().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                        fI(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 12001:
                Dt();
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

    public void Dn() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.avO.getActivity())));
    }

    public void Do() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.avO.getActivity())) {
            this.avO.showToast(r.j.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.m9getInst().getLocationShared()) {
            Dp();
        } else if (this.avI.bkz()) {
            Dn();
        } else {
            this.avI.kO(false);
            b(1, true, null);
            this.avI.bkx();
        }
    }

    private void Dp() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.avO.getActivity());
        aVar.bZ(r.j.location_app_permission_prompt).a(r.j.isopen, new j(this)).b(r.j.cancel, new k(this)).b(this.avO.getPageContext());
        aVar.tm();
    }

    public void Dq() {
        if (this.avI.bkB()) {
            if (this.avI.bkz()) {
                this.avX.a(com.baidu.tieba.tbadkCore.location.c.bkv().getLocationData());
                return;
            }
            if (com.baidu.adp.lib.util.k.gD()) {
                this.avI.bkx();
            }
            b(0, true, null);
            return;
        }
        b(0, false, null);
    }

    public boolean Dr() {
        if (StringUtils.isNull(this.avE)) {
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() <= 0) {
                if (this.baobaoImagesInfo == null || this.baobaoImagesInfo.size() <= 0) {
                    if (this.avF == null || StringUtils.isNull(this.avF.getId())) {
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
        this.avJ.d((WriteData) null);
        this.avJ.kQ(false);
        this.avF = null;
        this.mVideoInfo = null;
        this.mGraffitiFileName = null;
        this.baobaoImagesInfo.clear();
        this.writeImagesInfo.clear();
        this.avG.setIsBaobao(false);
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void Ds() {
        this.mVideoInfo = null;
    }

    private void c(Intent intent) {
        this.avH = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.avH;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.k.dip2px(this.avO.getActivity(), com.baidu.adp.lib.util.k.K(this.avO.getActivity())), com.baidu.adp.lib.util.k.dip2px(this.avO.getActivity(), com.baidu.adp.lib.util.k.L(this.avO.getActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.m.a(TbConfig.LOCAL_CAMERA_DIR, this.avH, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            DA();
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
                DA();
            }
        }
    }

    private void e(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("key_bitmap_path");
            String stringExtra2 = intent.getStringExtra("key_content");
            if (stringExtra != null && stringExtra2 != null) {
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(stringExtra);
                this.baobaoImagesInfo.clear();
                this.baobaoImagesInfo.addChooseFile(imageFileInfo);
                DC();
                if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
                    this.avG.setIsBaobao(true);
                    this.avG.setBaobaoContent(stringExtra2);
                    this.avG.setBaobaoImagesInfo(this.baobaoImagesInfo);
                    return;
                }
                this.avG.setIsBaobao(false);
                this.avG.setBaobaoContent("");
                this.avG.setBaobaoImagesInfo(this.baobaoImagesInfo);
            }
        }
    }

    private void Dt() {
        new l(this).execute(new Void[0]);
    }

    private void f(Intent intent) {
        b(intent, true);
    }

    private void g(Intent intent) {
        int size;
        int size2;
        c(intent);
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() - 1 > -1 && this.writeImagesInfo.getChosedFiles() != null && (size2 = this.writeImagesInfo.getChosedFiles().size()) >= 1 && size >= 0 && size < size2) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.avO.getActivity(), 12012, this.writeImagesInfo, size)));
        }
    }

    public void fF(String str) {
        WriteData bfE = this.avJ.bfE();
        if (bfE == null) {
            bfE = new WriteData(1);
            bfE.setThreadId(str);
            bfE.setWriteImagesInfo(this.writeImagesInfo);
        }
        bfE.setContent(this.avE);
        if (this.avG != null && this.avG.getIsBaobao()) {
            bfE.setBaobaoContent(this.avG.getBaobaoContent());
            bfE.setBaobaoImagesInfo(this.baobaoImagesInfo);
            bfE.setIsBaobao(true);
        }
        bfE.setVideoInfo(this.mVideoInfo);
        bfE.setGraffitiFileName(this.mGraffitiFileName);
        ae.c(str, bfE);
    }

    public void fG(String str) {
        ae.a(str, this);
    }

    @Override // com.baidu.tieba.tbadkCore.ae.a
    public void a(WriteData writeData) {
        if (writeData != null) {
            if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                if (this.mVideoInfo == null) {
                    this.mVideoInfo = new VideoInfo();
                }
                this.mVideoInfo.copy(writeData.getVideoInfo());
                Dz();
                CG().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                bE(false);
            }
            if (TbadkCoreApplication.m9getInst().isBaobaoShouldOpen() && writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                this.avG.setIsBaobao(writeData.getIsBaobao());
                this.avG.setBaobaoContent(writeData.getBaobaoContent());
                this.avG.setBaobaoImagesInfo(this.baobaoImagesInfo);
                DC();
            }
            this.mGraffitiFileName = writeData.getGraffitiFileName();
            if (CG() != null && !az.isEmpty(this.mGraffitiFileName)) {
                CG().b(new com.baidu.tbadk.editortools.a(42, 24, this.mGraffitiFileName));
            }
            if (!az.isEmpty(writeData.getContent()) && az.isEmpty(this.avE)) {
                this.avE = writeData.getContent();
                fJ(this.avE);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.avJ.cancelLoadData();
        this.avK.cancelLoadData();
        this.avI.cancelLoadData();
    }

    public void Du() {
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        this.avJ = new com.baidu.tieba.tbadkCore.writeModel.b(baseActivity);
        this.avJ.b(this.avZ);
        this.avK = new d(baseActivity);
        this.avK.setLoadDataCallBack(this.awa);
        this.avI = new com.baidu.tieba.tbadkCore.location.d(baseActivity);
        this.avI.a(this.avX);
        this.avI.a(this.avY);
        if (bundle != null) {
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable("write_images");
            this.avH = bundle.getString("photo_name");
        }
        this.writeImagesInfo.setMaxImagesAllowed(10);
        if (!StringUtils.isNull(TbadkCoreApplication.m9getInst().getDefaultBubble()) && CG() != null) {
            CG().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.avI.bkB() && CG() != null) {
            CG().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
        Dv();
    }

    private void Dv() {
        boolean z;
        try {
            z = com.baidu.tbadk.core.sharedPref.b.uh().getBoolean("graffiti_reply_notice_show", true);
        } catch (ClassCastException e) {
            com.baidu.tbadk.core.sharedPref.b.uh().remove("graffiti_reply_notice_show");
            z = false;
        }
        if (CG() != null) {
            CG().b(new com.baidu.tbadk.editortools.a(2, 24, z ? " " : null));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("write_images", this.writeImagesInfo);
        bundle.putString("photo_name", this.avH);
    }

    public void a(String str, WriteData writeData) {
        if (this.avJ.bfE() == null) {
            this.avJ.d(this.avL.fC(str));
        }
        if (this.avJ.bfE() != null) {
            this.avJ.bfE().setWriteImagesInfo(this.writeImagesInfo);
            this.avJ.bfE().setVideoInfo(this.mVideoInfo);
            this.avJ.bfE().setGraffitiFileName(this.mGraffitiFileName);
            this.avJ.kQ(this.writeImagesInfo.size() > 0);
            if (this.avG.getIsBaobao()) {
                this.avJ.bfE().setIsBaobao(true);
                this.avJ.bfE().setBaobaoContent(this.avG.getBaobaoContent());
                this.avJ.bfE().setBaobaoImagesInfo(this.baobaoImagesInfo);
            } else {
                this.avJ.bfE().setIsBaobao(false);
            }
            this.avJ.bfE().setHasLocationData(this.avI != null ? this.avI.bkB() : false);
            if (str == null) {
                this.avJ.bfE().setContent(this.avE);
            }
            if (this.avF != null) {
                if (this.avF.getId() != null) {
                    this.avJ.bfE().setVoice(this.avF.getId());
                    this.avJ.bfE().setVoiceDuringTime(this.avF.duration);
                } else {
                    this.avJ.bfE().setVoice(null);
                    this.avJ.bfE().setVoiceDuringTime(-1);
                }
            } else {
                this.avJ.bfE().setVoice(null);
                this.avJ.bfE().setVoiceDuringTime(-1);
            }
            if (!this.avJ.blb()) {
                this.avO.showToast(r.j.write_img_limit);
                return;
            }
            if (this.avT != null) {
                this.avT.Di();
            }
            if (!this.avJ.bkY()) {
            }
        }
    }

    public BaseActivity<?> getContext() {
        return this.avO;
    }

    public WriteImagesInfo getBaobaoImagesInfo() {
        return this.baobaoImagesInfo;
    }

    public void fH(String str) {
        this.avE = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.avF = voiceModel;
    }

    public WriteData Dw() {
        return this.avG;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int Dx() {
        return this.avR;
    }

    private void Dy() {
        if (CG() != null) {
            CG().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void q(ArrayList<String> arrayList) {
        if (CG() != null) {
            CG().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    public void fI(String str) {
        if (CG() != null) {
            CG().b(new com.baidu.tbadk.editortools.a(44, 3, str));
        }
    }

    private void Dz() {
        if (CG() != null) {
            CG().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    protected void bE(boolean z) {
        if (CG() != null) {
            if (z) {
                CG().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            CG().b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                CG().b(new com.baidu.tbadk.editortools.a(2, 10, new StringBuilder(String.valueOf(this.writeImagesInfo.getChosedFiles().size())).toString()));
            } else {
                CG().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
        }
    }

    protected void DA() {
        bE(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void DB() {
        if (CG() != null) {
            CG().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    protected void DC() {
        if (CG() != null) {
            CG().b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            CG().b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
                CG().b(new com.baidu.tbadk.editortools.a(2, 13, " "));
            } else {
                CG().b(new com.baidu.tbadk.editortools.a(2, 13, null));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void DD() {
        if (CG() != null) {
            CG().b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.avR = i;
        if (CG() != null) {
            CG().b(new com.baidu.tbadk.editortools.a(19, 8, new com.baidu.tbadk.editortools.d.a(i, z, str)));
            if (i == 2) {
                CG().b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            } else {
                CG().b(new com.baidu.tbadk.editortools.a(2, 7, null));
            }
        }
    }

    private void fJ(String str) {
        if (CG() != null) {
            CG().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bF(boolean z) {
        if (CG() != null) {
            CG().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(b.d dVar) {
        this.avS = dVar;
    }

    public void a(c cVar) {
        this.avT = cVar;
    }

    public void DE() {
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            this.writeImagesInfo.clear();
        }
        DA();
        if (this.baobaoImagesInfo != null && this.baobaoImagesInfo.size() > 0) {
            this.baobaoImagesInfo.clear();
        }
        DC();
        if (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) {
            this.mVideoInfo = null;
        }
        CG().b(new com.baidu.tbadk.editortools.a(2, 19, null));
        setVoiceModel(null);
        CG().b(new com.baidu.tbadk.editortools.a(2, 6, null));
        CG().b(new com.baidu.tbadk.editortools.a(33, 6, null));
        if (!StringUtils.isNull(this.avE)) {
            this.avE = "";
        }
        fJ("");
        this.mGraffitiFileName = null;
        CG().b(new com.baidu.tbadk.editortools.a(42, 24, null));
        this.avJ.d((WriteData) null);
        this.avJ.kQ(false);
    }

    public void eI(int i) {
        if (this.avV == null && CG() != null) {
            this.avV = (com.baidu.tbadk.editortools.inputtool.a) CG().ey(3);
        }
        if (this.avV != null && (this.avV.atI instanceof EditText)) {
            this.avV.b(new m(this, i, (EditText) this.avV.atI));
        }
    }

    public void DF() {
        if (this.avV != null) {
            this.avV.b(null);
        }
    }

    public void setGraffitiFileName(String str) {
        this.mGraffitiFileName = str;
    }
}
