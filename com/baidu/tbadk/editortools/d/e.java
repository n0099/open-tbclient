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
import com.baidu.tieba.tbadkCore.ae;
import com.baidu.tieba.tbadkCore.location.d;
import com.baidu.tieba.tbadkCore.writeModel.a;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.editortools.f implements ae.a {
    private String arA;
    private boolean arB;
    private int arC;
    private a.d arD;
    private c arE;
    private com.baidu.tbadk.editortools.imagetool.b arF;
    private com.baidu.tbadk.editortools.inputtool.a arG;
    private com.baidu.tbadk.editortools.sendtool.a arH;
    private d.a arI;
    private d.b arJ;
    private final a.d arK;
    private final com.baidu.adp.base.g arL;
    private String arp;
    private VoiceData.VoiceModel arq;
    private WriteData arr;
    private String ars;
    private com.baidu.tieba.tbadkCore.location.d art;
    private com.baidu.tieba.tbadkCore.writeModel.a aru;
    private d arv;
    private a<?> arw;
    private AntiData arx;
    private ForumData ary;
    private BaseActivity<?> arz;
    private long authorId;
    private String authorName;
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
        this.arp = "";
        this.arr = new WriteData();
        this.aru = null;
        this.arv = null;
        this.mThreadId = null;
        this.arA = null;
        this.arB = true;
        this.arC = 0;
        this.arI = new f(this);
        this.arJ = new g(this);
        this.arK = new h(this);
        this.arL = new i(this);
    }

    private com.baidu.tbadk.editortools.sendtool.a BF() {
        if (this.arH == null && Bc() != null) {
            this.arH = (com.baidu.tbadk.editortools.sendtool.a) Bc().eh(4);
        }
        return this.arH;
    }

    public void en(int i) {
        if (this.arH == null && Bc() != null) {
            this.arH = (com.baidu.tbadk.editortools.sendtool.a) Bc().eh(4);
        }
        if (this.arH != null) {
            this.arH.setType(i);
        }
    }

    public void eo(int i) {
        if (this.arH == null && Bc() != null) {
            this.arH = (com.baidu.tbadk.editortools.sendtool.a) Bc().eh(4);
        }
        if (this.arH != null) {
            this.arH.er(i);
        }
    }

    private com.baidu.tbadk.editortools.imagetool.b BG() {
        if (this.arF == null && Bc() != null) {
            this.arF = (com.baidu.tbadk.editortools.imagetool.b) Bc().eh(11);
        }
        return this.arF;
    }

    public void ep(int i) {
        if (this.arF == null && Bc() != null) {
            this.arF = (com.baidu.tbadk.editortools.imagetool.b) Bc().eh(11);
        }
        if (this.arF != null) {
            this.arF.em(i);
        }
    }

    private com.baidu.tbadk.editortools.inputtool.a BH() {
        if (this.arG == null && Bc() != null) {
            this.arG = (com.baidu.tbadk.editortools.inputtool.a) Bc().eh(3);
        }
        return this.arG;
    }

    public void fu(String str) {
        if (this.arG == null && Bc() != null) {
            this.arG = (com.baidu.tbadk.editortools.inputtool.a) Bc().eh(3);
        }
        if (this.arG != null) {
            this.arG.setHint(str);
        }
    }

    public void by(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (Bc() != null && (cVar = (com.baidu.tbadk.editortools.c) Bc().ef(5)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bz(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (Bc() != null && (cVar = (com.baidu.tbadk.editortools.c) Bc().ef(23)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bA(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (Bc() != null && (cVar = (com.baidu.tbadk.editortools.c) Bc().ef(2)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void a(a<?> aVar) {
        this.arw = aVar;
    }

    public void d(BaseActivity<?> baseActivity) {
        this.arz = baseActivity;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.arB = antiData.isIfvoice();
            this.arA = antiData.getVoice_message();
        }
        this.arx = antiData;
    }

    public void a(ForumData forumData, UserData userData) {
        this.ary = forumData;
        this.mUserData = userData;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (Bc() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void BI() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            String valueOf = String.valueOf(this.authorId);
            if (valueOf == null || valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                com.baidu.adp.lib.util.k.showToast(this.arz.getActivity(), t.j.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.arz.getActivity(), this.authorId, this.authorName, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.h.b.c(this.mThreadId, 0L), com.baidu.adp.lib.h.b.c(this.postId, 0L))));
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.arz.getActivity(), 12004, true)));
                    return;
                case 11026:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.arz.getActivity(), 12005, true)));
                    return;
                case 12002:
                    if (intent != null) {
                        boolean booleanExtra = intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false);
                        if (b.BD().getStatus() == 1) {
                            if (BG() != null) {
                                BG().em(1);
                            }
                            if (getWriteImagesInfo() != null) {
                                getWriteImagesInfo().setMaxImagesAllowed(1);
                            }
                        } else {
                            if (BG() != null) {
                                BG().em(10);
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
                        if (Bc() != null) {
                            sVar2 = Bc().ef(2);
                            sVar = Bc().ef(5);
                            sVar3 = Bc().ef(23);
                        } else {
                            sVar = null;
                            sVar2 = null;
                        }
                        if (b.BD().getStatus() == 1) {
                            BY();
                            if (Bc() != null) {
                                Bc().Bn();
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL));
                            }
                            if (sVar2 != null) {
                                sVar2.hide();
                            }
                            if (sVar != null) {
                                sVar.hide();
                            }
                            if (sVar3 != null) {
                                sVar3.kC();
                            }
                            if (BH() != null) {
                                BH().setHint(this.arz.getPageContext().getString(t.j.add_picture_description));
                            }
                            if (BG() != null) {
                                BG().fo(this.arz.getPageContext().getString(t.j.show_pic_tip));
                                BG().fp(this.arz.getPageContext().getString(t.j.show_pic_add_tip));
                            }
                            if (BF() != null) {
                                BF().setType(SendView.ase);
                                BF().er(SendView.ase);
                            }
                        } else {
                            if (sVar2 != null) {
                                sVar2.kC();
                            }
                            if (sVar != null) {
                                sVar.kC();
                            }
                            if (sVar3 != null) {
                                sVar3.hide();
                            }
                            if (BH() != null) {
                                BH().setHint(this.arz.getPageContext().getString(t.j.pb_reply_hint));
                            }
                            if (BF() != null) {
                                BF().setType(SendView.ALL);
                                BF().er(SendView.ALL);
                            }
                        }
                        Bc().invalidate();
                        return;
                    }
                    return;
                case 12003:
                    if (intent != null) {
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            BV();
                            this.aru.jC(false);
                            return;
                        }
                        this.arv.ft(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case 12004:
                    ArrayList<String> v = com.baidu.tieba.tbadkCore.util.l.v(intent);
                    if (v != null) {
                        p(v);
                        return;
                    }
                    return;
                case 12006:
                    WriteData aVg = this.aru.aVg();
                    if (aVg != null) {
                        aVg.deleteUploadedTempImages();
                    }
                    this.arr.setIsBaobao(false);
                    this.arr.setBaobaoContent(null);
                    this.baobaoImagesInfo.clear();
                    this.aru.d((WriteData) null);
                    this.aru.jC(false);
                    this.arq = null;
                    this.mVideoInfo = null;
                    this.mGraffitiFileName = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        ae.c(this.mThreadId, (WriteData) null);
                    }
                    bC(true);
                    if (this.arD != null) {
                        this.arD.callback(true, null, null, aVg, null);
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
                    if (b.BD().getStatus() == 1 && BG() != null) {
                        BG().fo(this.arz.getPageContext().getString(t.j.show_pic_tip));
                        return;
                    }
                    return;
                case 12013:
                    d(intent);
                    return;
                case 13010:
                    if (Bc() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            aw awVar = new aw("c10068");
                            awVar.s("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(awVar);
                            BW();
                            Bc().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            Bc().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                BP();
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

    public void BJ() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.arz.getActivity())));
    }

    public void BK() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.arz.getActivity())) {
            this.arz.showToast(t.j.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.m11getInst().getLocationShared()) {
            BL();
        } else if (this.art.aUJ()) {
            BJ();
        } else {
            this.art.jA(false);
            a(1, true, (String) null);
            this.art.aUH();
        }
    }

    private void BL() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.arz.getActivity());
        aVar.bL(t.j.location_app_permission_prompt).a(t.j.isopen, new j(this)).b(t.j.cancel, new k(this)).b(this.arz.getPageContext());
        aVar.rV();
    }

    public void BM() {
        if (this.art.aUL()) {
            if (this.art.aUJ()) {
                this.arI.a(com.baidu.tieba.tbadkCore.location.c.aUF().getLocationData());
                return;
            }
            if (com.baidu.adp.lib.util.k.fH()) {
                this.art.aUH();
            }
            a(0, true, (String) null);
            return;
        }
        a(0, false, (String) null);
    }

    public boolean BN() {
        if (StringUtils.isNull(this.arp)) {
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() <= 0) {
                if (this.baobaoImagesInfo == null || this.baobaoImagesInfo.size() <= 0) {
                    if (this.arq == null || StringUtils.isNull(this.arq.getId())) {
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
        this.aru.d((WriteData) null);
        this.aru.jC(false);
        this.arq = null;
        this.mVideoInfo = null;
        this.mGraffitiFileName = null;
        this.baobaoImagesInfo.clear();
        this.writeImagesInfo.clear();
        this.arr.setIsBaobao(false);
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void BO() {
        this.mVideoInfo = null;
    }

    private void b(Intent intent) {
        this.ars = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.ars;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.k.dip2px(this.arz.getActivity(), com.baidu.adp.lib.util.k.B(this.arz.getActivity())), com.baidu.adp.lib.util.k.dip2px(this.arz.getActivity(), com.baidu.adp.lib.util.k.C(this.arz.getActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.m.a(TbConfig.LOCAL_CAMERA_DIR, this.ars, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            BX();
        }
    }

    private void c(Intent intent) {
        b(intent, false);
    }

    private void b(Intent intent, boolean z) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                BX();
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
                BZ();
                if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
                    this.arr.setIsBaobao(true);
                    this.arr.setBaobaoContent(stringExtra2);
                    this.arr.setBaobaoImagesInfo(this.baobaoImagesInfo);
                    return;
                }
                this.arr.setIsBaobao(false);
                this.arr.setBaobaoContent("");
                this.arr.setBaobaoImagesInfo(this.baobaoImagesInfo);
            }
        }
    }

    private void BP() {
        new l(this).execute(new Void[0]);
    }

    private void e(Intent intent) {
        b(intent, true);
    }

    private void f(Intent intent) {
        int size;
        int size2;
        b(intent);
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() - 1 > -1 && this.writeImagesInfo.getChosedFiles() != null && (size2 = this.writeImagesInfo.getChosedFiles().size()) >= 1 && size >= 0 && size < size2) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.arz.getActivity(), 12012, this.writeImagesInfo, size)));
        }
    }

    public void fv(String str) {
        WriteData aVg = this.aru.aVg();
        if (aVg == null) {
            aVg = new WriteData(1);
            aVg.setThreadId(str);
            aVg.setWriteImagesInfo(this.writeImagesInfo);
        }
        aVg.setContent(this.arp);
        if (this.arr != null && this.arr.getIsBaobao()) {
            aVg.setBaobaoContent(this.arr.getBaobaoContent());
            aVg.setBaobaoImagesInfo(this.baobaoImagesInfo);
            aVg.setIsBaobao(true);
        }
        aVg.setVideoInfo(this.mVideoInfo);
        aVg.setGraffitiFileName(this.mGraffitiFileName);
        ae.c(str, aVg);
    }

    public void fw(String str) {
        ae.a(str, this);
    }

    @Override // com.baidu.tieba.tbadkCore.ae.a
    public void a(WriteData writeData) {
        if (writeData != null) {
            if (!ay.isEmpty(writeData.getContent()) && ay.isEmpty(this.arp)) {
                this.arp = writeData.getContent();
                fy(this.arp);
            }
            if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                if (this.mVideoInfo == null) {
                    this.mVideoInfo = new VideoInfo();
                }
                this.mVideoInfo.copy(writeData.getVideoInfo());
                BW();
                Bc().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                bB(false);
            }
            if (TbadkCoreApplication.m11getInst().isBaobaoShouldOpen() && writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                this.arr.setIsBaobao(writeData.getIsBaobao());
                this.arr.setBaobaoContent(writeData.getBaobaoContent());
                this.arr.setBaobaoImagesInfo(this.baobaoImagesInfo);
                BZ();
            }
            this.mGraffitiFileName = writeData.getGraffitiFileName();
            if (Bc() != null) {
                Bc().b(new com.baidu.tbadk.editortools.a(42, 24, this.mGraffitiFileName));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.aru.cancelLoadData();
        this.arv.cancelLoadData();
        this.art.cancelLoadData();
    }

    public void BQ() {
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        this.aru = new com.baidu.tieba.tbadkCore.writeModel.a(baseActivity);
        this.aru.b(this.arK);
        this.arv = new d(baseActivity);
        this.arv.setLoadDataCallBack(this.arL);
        this.art = new com.baidu.tieba.tbadkCore.location.d(baseActivity);
        this.art.a(this.arI);
        this.art.a(this.arJ);
        if (bundle != null) {
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.ars = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        this.writeImagesInfo.setMaxImagesAllowed(10);
        if (!StringUtils.isNull(TbadkCoreApplication.m11getInst().getDefaultBubble()) && Bc() != null) {
            Bc().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.art.aUL() && Bc() != null) {
            Bc().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
        BR();
    }

    private void BR() {
        boolean z;
        try {
            z = com.baidu.tbadk.core.sharedPref.b.sR().getBoolean("graffiti_reply_notice_show", true);
        } catch (ClassCastException e) {
            com.baidu.tbadk.core.sharedPref.b.sR().remove("graffiti_reply_notice_show");
            z = false;
        }
        if (Bc() != null) {
            Bc().b(new com.baidu.tbadk.editortools.a(2, 24, z ? " " : null));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.ars);
    }

    public void a(String str, WriteData writeData) {
        if (this.aru.aVg() == null) {
            this.aru.d(this.arw.fs(str));
        }
        if (this.aru.aVg() != null) {
            this.aru.aVg().setWriteImagesInfo(this.writeImagesInfo);
            this.aru.aVg().setVideoInfo(this.mVideoInfo);
            this.aru.aVg().setGraffitiFileName(this.mGraffitiFileName);
            this.aru.jC(this.writeImagesInfo.size() > 0);
            if (this.arr.getIsBaobao()) {
                this.aru.aVg().setIsBaobao(true);
                this.aru.aVg().setBaobaoContent(this.arr.getBaobaoContent());
                this.aru.aVg().setBaobaoImagesInfo(this.baobaoImagesInfo);
            } else {
                this.aru.aVg().setIsBaobao(false);
            }
            this.aru.aVg().setHasLocationData(this.art != null ? this.art.aUL() : false);
            if (str == null) {
                this.aru.aVg().setContent(this.arp);
            }
            if (this.arq != null) {
                if (this.arq.getId() != null) {
                    this.aru.aVg().setVoice(this.arq.getId());
                    this.aru.aVg().setVoiceDuringTime(this.arq.duration);
                } else {
                    this.aru.aVg().setVoice(null);
                    this.aru.aVg().setVoiceDuringTime(-1);
                }
            } else {
                this.aru.aVg().setVoice(null);
                this.aru.aVg().setVoiceDuringTime(-1);
            }
            if (!this.aru.aVk()) {
                this.arz.showToast(t.j.write_img_limit);
                return;
            }
            if (this.arE != null) {
                this.arE.BE();
            }
            if (!this.aru.aVh()) {
            }
        }
    }

    public BaseActivity<?> BS() {
        return this.arz;
    }

    public WriteImagesInfo getBaobaoImagesInfo() {
        return this.baobaoImagesInfo;
    }

    public void fx(String str) {
        this.arp = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.arq = voiceModel;
    }

    public WriteData BT() {
        return this.arr;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int BU() {
        return this.arC;
    }

    private void BV() {
        if (Bc() != null) {
            Bc().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void p(ArrayList<String> arrayList) {
        if (Bc() != null) {
            Bc().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    private void BW() {
        if (Bc() != null) {
            Bc().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    protected void bB(boolean z) {
        if (Bc() != null) {
            if (z) {
                Bc().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            Bc().b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                Bc().b(new com.baidu.tbadk.editortools.a(2, 10, new StringBuilder(String.valueOf(this.writeImagesInfo.getChosedFiles().size())).toString()));
            } else {
                Bc().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
        }
    }

    protected void BX() {
        bB(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void BY() {
        if (Bc() != null) {
            Bc().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    protected void BZ() {
        if (Bc() != null) {
            Bc().b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            Bc().b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
                Bc().b(new com.baidu.tbadk.editortools.a(2, 13, " "));
            } else {
                Bc().b(new com.baidu.tbadk.editortools.a(2, 13, null));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ca() {
        if (Bc() != null) {
            Bc().b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.arC = i;
        if (Bc() != null) {
            Bc().b(new com.baidu.tbadk.editortools.a(19, 8, new com.baidu.tbadk.editortools.c.a(i, z, str)));
            if (i == 2) {
                Bc().b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            } else {
                Bc().b(new com.baidu.tbadk.editortools.a(2, 7, null));
            }
        }
    }

    private void fy(String str) {
        if (Bc() != null) {
            Bc().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bC(boolean z) {
        if (Bc() != null) {
            Bc().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void Cb() {
        bC(true);
    }

    public void a(a.d dVar) {
        this.arD = dVar;
    }

    public void a(c cVar) {
        this.arE = cVar;
    }

    public void Cc() {
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            this.writeImagesInfo.clear();
        }
        BX();
        if (this.baobaoImagesInfo != null && this.baobaoImagesInfo.size() > 0) {
            this.baobaoImagesInfo.clear();
        }
        BZ();
        if (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) {
            this.mVideoInfo = null;
        }
        Bc().b(new com.baidu.tbadk.editortools.a(2, 19, null));
        setVoiceModel(null);
        Bc().b(new com.baidu.tbadk.editortools.a(2, 6, null));
        Bc().b(new com.baidu.tbadk.editortools.a(33, 6, null));
        if (!StringUtils.isNull(this.arp)) {
            this.arp = "";
        }
        fy("");
        this.mGraffitiFileName = null;
        Bc().b(new com.baidu.tbadk.editortools.a(42, 24, null));
        this.aru.d((WriteData) null);
        this.aru.jC(false);
    }

    public void eq(int i) {
        if (this.arG == null && Bc() != null) {
            this.arG = (com.baidu.tbadk.editortools.inputtool.a) Bc().eh(3);
        }
        if (this.arG != null && (this.arG.aps instanceof EditText)) {
            this.arG.b(new m(this, i, (EditText) this.arG.aps));
        }
    }

    public void Cd() {
        if (this.arG != null) {
            this.arG.b(null);
        }
    }

    public void setGraffitiFileName(String str) {
        this.mGraffitiFileName = str;
    }
}
