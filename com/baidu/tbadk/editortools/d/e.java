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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.tbadkCore.af;
import com.baidu.tieba.tbadkCore.location.d;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.editortools.f implements af.a {
    private String asU;
    private VoiceData.VoiceModel asV;
    private WriteData asW;
    private String asX;
    private com.baidu.tieba.tbadkCore.location.d asY;
    private com.baidu.tieba.tbadkCore.writeModel.a asZ;
    private d ata;
    private a<?> atb;
    private AntiData atc;
    private ForumData atd;
    private BaseActivity<?> ate;
    private String atf;
    private boolean atg;
    private int ath;
    private a.d ati;
    private c atj;
    private com.baidu.tbadk.editortools.imagetool.b atk;
    private com.baidu.tbadk.editortools.inputtool.a atl;
    private com.baidu.tbadk.editortools.sendtool.a atm;
    private d.a atn;
    private d.b ato;
    private final a.d atp;
    private final com.baidu.adp.base.g atq;
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
        this.asU = "";
        this.asW = new WriteData();
        this.asZ = null;
        this.ata = null;
        this.mThreadId = null;
        this.atf = null;
        this.atg = true;
        this.ath = 0;
        this.atn = new f(this);
        this.ato = new g(this);
        this.atp = new h(this);
        this.atq = new i(this);
    }

    private com.baidu.tbadk.editortools.sendtool.a BO() {
        if (this.atm == null && Bl() != null) {
            this.atm = (com.baidu.tbadk.editortools.sendtool.a) Bl().el(4);
        }
        return this.atm;
    }

    public void es(int i) {
        if (this.atm == null && Bl() != null) {
            this.atm = (com.baidu.tbadk.editortools.sendtool.a) Bl().el(4);
        }
        if (this.atm != null) {
            this.atm.setType(i);
        }
    }

    public void et(int i) {
        if (this.atm == null && Bl() != null) {
            this.atm = (com.baidu.tbadk.editortools.sendtool.a) Bl().el(4);
        }
        if (this.atm != null) {
            this.atm.ew(i);
        }
    }

    private com.baidu.tbadk.editortools.imagetool.b BP() {
        if (this.atk == null && Bl() != null) {
            this.atk = (com.baidu.tbadk.editortools.imagetool.b) Bl().el(11);
        }
        return this.atk;
    }

    public void eu(int i) {
        if (this.atk == null && Bl() != null) {
            this.atk = (com.baidu.tbadk.editortools.imagetool.b) Bl().el(11);
        }
        if (this.atk != null) {
            this.atk.er(i);
        }
    }

    private com.baidu.tbadk.editortools.inputtool.a BQ() {
        if (this.atl == null && Bl() != null) {
            this.atl = (com.baidu.tbadk.editortools.inputtool.a) Bl().el(3);
        }
        return this.atl;
    }

    public void fy(String str) {
        if (this.atl == null && Bl() != null) {
            this.atl = (com.baidu.tbadk.editortools.inputtool.a) Bl().el(3);
        }
        if (this.atl != null) {
            this.atl.setHint(str);
        }
    }

    public void bA(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (Bl() != null && (cVar = (com.baidu.tbadk.editortools.c) Bl().ej(5)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bB(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (Bl() != null && (cVar = (com.baidu.tbadk.editortools.c) Bl().ej(23)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bC(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (Bl() != null && (cVar = (com.baidu.tbadk.editortools.c) Bl().ej(2)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void a(a<?> aVar) {
        this.atb = aVar;
    }

    public void d(BaseActivity<?> baseActivity) {
        this.ate = baseActivity;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.atg = antiData.isIfvoice();
            this.atf = antiData.getVoice_message();
        }
        this.atc = antiData;
    }

    public void a(ForumData forumData, UserData userData) {
        this.atd = forumData;
        this.mUserData = userData;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (Bl() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void BR() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            String valueOf = String.valueOf(this.authorId);
            if (valueOf == null || valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                com.baidu.adp.lib.util.k.showToast(this.ate.getActivity(), u.j.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.ate.getActivity(), this.authorId, this.authorName, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.h.b.c(this.mThreadId, 0L), com.baidu.adp.lib.h.b.c(this.postId, 0L))));
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.ate.getActivity(), 12004, true)));
                    return;
                case 11026:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.ate.getActivity(), 12005, true)));
                    return;
                case 12002:
                    if (intent != null) {
                        boolean booleanExtra = intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false);
                        if (b.BM().getStatus() == 1) {
                            if (BP() != null) {
                                BP().er(1);
                            }
                            if (getWriteImagesInfo() != null) {
                                getWriteImagesInfo().setMaxImagesAllowed(1);
                            }
                        } else {
                            if (BP() != null) {
                                BP().er(10);
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
                        if (Bl() != null) {
                            sVar2 = Bl().ej(2);
                            sVar = Bl().ej(5);
                            sVar3 = Bl().ej(23);
                        } else {
                            sVar = null;
                            sVar2 = null;
                        }
                        if (b.BM().getStatus() == 1) {
                            Cg();
                            if (Bl() != null) {
                                Bl().Bw();
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL));
                            }
                            if (sVar2 != null) {
                                sVar2.hide();
                            }
                            if (sVar != null) {
                                sVar.hide();
                            }
                            if (sVar3 != null) {
                                sVar3.kB();
                            }
                            if (BQ() != null) {
                                BQ().setHint(this.ate.getPageContext().getString(u.j.add_picture_description));
                            }
                            if (BP() != null) {
                                BP().fs(this.ate.getPageContext().getString(u.j.show_pic_tip));
                                BP().ft(this.ate.getPageContext().getString(u.j.show_pic_add_tip));
                            }
                            if (BO() != null) {
                                BO().setType(SendView.atJ);
                                BO().ew(SendView.atJ);
                            }
                        } else {
                            if (sVar2 != null) {
                                sVar2.kB();
                            }
                            if (sVar != null) {
                                sVar.kB();
                            }
                            if (sVar3 != null) {
                                sVar3.hide();
                            }
                            if (BQ() != null) {
                                BQ().setHint(this.ate.getPageContext().getString(u.j.pb_reply_hint));
                            }
                            if (BO() != null) {
                                BO().setType(SendView.ALL);
                                BO().ew(SendView.ALL);
                            }
                        }
                        Bl().invalidate();
                        return;
                    }
                    return;
                case 12003:
                    if (intent != null) {
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            Cd();
                            this.asZ.kB(false);
                            return;
                        }
                        this.ata.fx(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case 12004:
                    ArrayList<String> z = com.baidu.tieba.tbadkCore.util.l.z(intent);
                    if (z != null) {
                        q(z);
                        return;
                    }
                    return;
                case 12006:
                    WriteData bbo = this.asZ.bbo();
                    if (bbo != null) {
                        bbo.deleteUploadedTempImages();
                    }
                    this.asW.setIsBaobao(false);
                    this.asW.setBaobaoContent(null);
                    this.baobaoImagesInfo.clear();
                    this.asZ.d((WriteData) null);
                    this.asZ.kB(false);
                    this.asV = null;
                    this.mVideoInfo = null;
                    this.mGraffitiFileName = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        af.c(this.mThreadId, (WriteData) null);
                    }
                    bE(true);
                    if (this.ati != null) {
                        this.ati.callback(true, null, null, bbo, null);
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
                    if (b.BM().getStatus() == 1 && BP() != null) {
                        BP().fs(this.ate.getPageContext().getString(u.j.show_pic_tip));
                        return;
                    }
                    return;
                case 12013:
                    e(intent);
                    return;
                case 13010:
                    if (Bl() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            ay ayVar = new ay("c10068");
                            ayVar.s("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(ayVar);
                            Ce();
                            Bl().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            Bl().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                BY();
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

    public void BS() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.ate.getActivity())));
    }

    public void BT() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.ate.getActivity())) {
            this.ate.showToast(u.j.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.m10getInst().getLocationShared()) {
            BU();
        } else if (this.asY.bgm()) {
            BS();
        } else {
            this.asY.kz(false);
            b(1, true, null);
            this.asY.bgk();
        }
    }

    private void BU() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ate.getActivity());
        aVar.bM(u.j.location_app_permission_prompt).a(u.j.isopen, new j(this)).b(u.j.cancel, new k(this)).b(this.ate.getPageContext());
        aVar.rS();
    }

    public void BV() {
        if (this.asY.bgo()) {
            if (this.asY.bgm()) {
                this.atn.a(com.baidu.tieba.tbadkCore.location.c.bgi().getLocationData());
                return;
            }
            if (com.baidu.adp.lib.util.k.fH()) {
                this.asY.bgk();
            }
            b(0, true, null);
            return;
        }
        b(0, false, null);
    }

    public boolean BW() {
        if (StringUtils.isNull(this.asU)) {
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() <= 0) {
                if (this.baobaoImagesInfo == null || this.baobaoImagesInfo.size() <= 0) {
                    if (this.asV == null || StringUtils.isNull(this.asV.getId())) {
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
        this.asZ.d((WriteData) null);
        this.asZ.kB(false);
        this.asV = null;
        this.mVideoInfo = null;
        this.mGraffitiFileName = null;
        this.baobaoImagesInfo.clear();
        this.writeImagesInfo.clear();
        this.asW.setIsBaobao(false);
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void BX() {
        this.mVideoInfo = null;
    }

    private void c(Intent intent) {
        this.asX = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.asX;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.k.dip2px(this.ate.getActivity(), com.baidu.adp.lib.util.k.A(this.ate.getActivity())), com.baidu.adp.lib.util.k.dip2px(this.ate.getActivity(), com.baidu.adp.lib.util.k.B(this.ate.getActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.m.a(TbConfig.LOCAL_CAMERA_DIR, this.asX, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            Cf();
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
                Cf();
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
                Ch();
                if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
                    this.asW.setIsBaobao(true);
                    this.asW.setBaobaoContent(stringExtra2);
                    this.asW.setBaobaoImagesInfo(this.baobaoImagesInfo);
                    return;
                }
                this.asW.setIsBaobao(false);
                this.asW.setBaobaoContent("");
                this.asW.setBaobaoImagesInfo(this.baobaoImagesInfo);
            }
        }
    }

    private void BY() {
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
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.ate.getActivity(), 12012, this.writeImagesInfo, size)));
        }
    }

    public void fz(String str) {
        WriteData bbo = this.asZ.bbo();
        if (bbo == null) {
            bbo = new WriteData(1);
            bbo.setThreadId(str);
            bbo.setWriteImagesInfo(this.writeImagesInfo);
        }
        bbo.setContent(this.asU);
        if (this.asW != null && this.asW.getIsBaobao()) {
            bbo.setBaobaoContent(this.asW.getBaobaoContent());
            bbo.setBaobaoImagesInfo(this.baobaoImagesInfo);
            bbo.setIsBaobao(true);
        }
        bbo.setVideoInfo(this.mVideoInfo);
        bbo.setGraffitiFileName(this.mGraffitiFileName);
        af.c(str, bbo);
    }

    public void fA(String str) {
        af.a(str, this);
    }

    @Override // com.baidu.tieba.tbadkCore.af.a
    public void a(WriteData writeData) {
        if (writeData != null) {
            if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                if (this.mVideoInfo == null) {
                    this.mVideoInfo = new VideoInfo();
                }
                this.mVideoInfo.copy(writeData.getVideoInfo());
                Ce();
                Bl().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                bD(false);
            }
            if (TbadkCoreApplication.m10getInst().isBaobaoShouldOpen() && writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                this.asW.setIsBaobao(writeData.getIsBaobao());
                this.asW.setBaobaoContent(writeData.getBaobaoContent());
                this.asW.setBaobaoImagesInfo(this.baobaoImagesInfo);
                Ch();
            }
            this.mGraffitiFileName = writeData.getGraffitiFileName();
            if (Bl() != null && !ba.isEmpty(this.mGraffitiFileName)) {
                Bl().b(new com.baidu.tbadk.editortools.a(42, 24, this.mGraffitiFileName));
            }
            if (!ba.isEmpty(writeData.getContent()) && ba.isEmpty(this.asU)) {
                this.asU = writeData.getContent();
                fC(this.asU);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.asZ.cancelLoadData();
        this.ata.cancelLoadData();
        this.asY.cancelLoadData();
    }

    public void BZ() {
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        this.asZ = new com.baidu.tieba.tbadkCore.writeModel.a(baseActivity);
        this.asZ.b(this.atp);
        this.ata = new d(baseActivity);
        this.ata.setLoadDataCallBack(this.atq);
        this.asY = new com.baidu.tieba.tbadkCore.location.d(baseActivity);
        this.asY.a(this.atn);
        this.asY.a(this.ato);
        if (bundle != null) {
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable("write_images");
            this.asX = bundle.getString("photo_name");
        }
        this.writeImagesInfo.setMaxImagesAllowed(10);
        if (!StringUtils.isNull(TbadkCoreApplication.m10getInst().getDefaultBubble()) && Bl() != null) {
            Bl().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.asY.bgo() && Bl() != null) {
            Bl().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
        Ca();
    }

    private void Ca() {
        boolean z;
        try {
            z = com.baidu.tbadk.core.sharedPref.b.sN().getBoolean("graffiti_reply_notice_show", true);
        } catch (ClassCastException e) {
            com.baidu.tbadk.core.sharedPref.b.sN().remove("graffiti_reply_notice_show");
            z = false;
        }
        if (Bl() != null) {
            Bl().b(new com.baidu.tbadk.editortools.a(2, 24, z ? " " : null));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("write_images", this.writeImagesInfo);
        bundle.putString("photo_name", this.asX);
    }

    public void a(String str, WriteData writeData) {
        if (this.asZ.bbo() == null) {
            this.asZ.d(this.atb.fw(str));
        }
        if (this.asZ.bbo() != null) {
            this.asZ.bbo().setWriteImagesInfo(this.writeImagesInfo);
            this.asZ.bbo().setVideoInfo(this.mVideoInfo);
            this.asZ.bbo().setGraffitiFileName(this.mGraffitiFileName);
            this.asZ.kB(this.writeImagesInfo.size() > 0);
            if (this.asW.getIsBaobao()) {
                this.asZ.bbo().setIsBaobao(true);
                this.asZ.bbo().setBaobaoContent(this.asW.getBaobaoContent());
                this.asZ.bbo().setBaobaoImagesInfo(this.baobaoImagesInfo);
            } else {
                this.asZ.bbo().setIsBaobao(false);
            }
            this.asZ.bbo().setHasLocationData(this.asY != null ? this.asY.bgo() : false);
            if (str == null) {
                this.asZ.bbo().setContent(this.asU);
            }
            if (this.asV != null) {
                if (this.asV.getId() != null) {
                    this.asZ.bbo().setVoice(this.asV.getId());
                    this.asZ.bbo().setVoiceDuringTime(this.asV.duration);
                } else {
                    this.asZ.bbo().setVoice(null);
                    this.asZ.bbo().setVoiceDuringTime(-1);
                }
            } else {
                this.asZ.bbo().setVoice(null);
                this.asZ.bbo().setVoiceDuringTime(-1);
            }
            if (!this.asZ.bgP()) {
                this.ate.showToast(u.j.write_img_limit);
                return;
            }
            if (this.atj != null) {
                this.atj.BN();
            }
            if (!this.asZ.bgM()) {
            }
        }
    }

    public BaseActivity<?> getContext() {
        return this.ate;
    }

    public WriteImagesInfo getBaobaoImagesInfo() {
        return this.baobaoImagesInfo;
    }

    public void fB(String str) {
        this.asU = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.asV = voiceModel;
    }

    public WriteData Cb() {
        return this.asW;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int Cc() {
        return this.ath;
    }

    private void Cd() {
        if (Bl() != null) {
            Bl().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void q(ArrayList<String> arrayList) {
        if (Bl() != null) {
            Bl().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    private void Ce() {
        if (Bl() != null) {
            Bl().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    protected void bD(boolean z) {
        if (Bl() != null) {
            if (z) {
                Bl().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            Bl().b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                Bl().b(new com.baidu.tbadk.editortools.a(2, 10, new StringBuilder(String.valueOf(this.writeImagesInfo.getChosedFiles().size())).toString()));
            } else {
                Bl().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
        }
    }

    protected void Cf() {
        bD(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Cg() {
        if (Bl() != null) {
            Bl().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    protected void Ch() {
        if (Bl() != null) {
            Bl().b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            Bl().b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
                Bl().b(new com.baidu.tbadk.editortools.a(2, 13, " "));
            } else {
                Bl().b(new com.baidu.tbadk.editortools.a(2, 13, null));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ci() {
        if (Bl() != null) {
            Bl().b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.ath = i;
        if (Bl() != null) {
            Bl().b(new com.baidu.tbadk.editortools.a(19, 8, new com.baidu.tbadk.editortools.c.a(i, z, str)));
            if (i == 2) {
                Bl().b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            } else {
                Bl().b(new com.baidu.tbadk.editortools.a(2, 7, null));
            }
        }
    }

    private void fC(String str) {
        if (Bl() != null) {
            Bl().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bE(boolean z) {
        if (Bl() != null) {
            Bl().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(a.d dVar) {
        this.ati = dVar;
    }

    public void a(c cVar) {
        this.atj = cVar;
    }

    public void Cj() {
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            this.writeImagesInfo.clear();
        }
        Cf();
        if (this.baobaoImagesInfo != null && this.baobaoImagesInfo.size() > 0) {
            this.baobaoImagesInfo.clear();
        }
        Ch();
        if (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) {
            this.mVideoInfo = null;
        }
        Bl().b(new com.baidu.tbadk.editortools.a(2, 19, null));
        setVoiceModel(null);
        Bl().b(new com.baidu.tbadk.editortools.a(2, 6, null));
        Bl().b(new com.baidu.tbadk.editortools.a(33, 6, null));
        if (!StringUtils.isNull(this.asU)) {
            this.asU = "";
        }
        fC("");
        this.mGraffitiFileName = null;
        Bl().b(new com.baidu.tbadk.editortools.a(42, 24, null));
        this.asZ.d((WriteData) null);
        this.asZ.kB(false);
    }

    public void ev(int i) {
        if (this.atl == null && Bl() != null) {
            this.atl = (com.baidu.tbadk.editortools.inputtool.a) Bl().el(3);
        }
        if (this.atl != null && (this.atl.aqX instanceof EditText)) {
            this.atl.b(new m(this, i, (EditText) this.atl.aqX));
        }
    }

    public void Ck() {
        if (this.atl != null) {
            this.atl.b(null);
        }
    }

    public void setGraffitiFileName(String str) {
        this.mGraffitiFileName = str;
    }
}
