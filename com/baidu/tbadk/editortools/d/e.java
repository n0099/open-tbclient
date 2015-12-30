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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.ae;
import com.baidu.tieba.tbadkCore.location.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.a;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.editortools.f implements ae.a {
    private String atY;
    private VoiceData.VoiceModel atZ;
    private WriteData aua;
    private String aub;
    private com.baidu.tieba.tbadkCore.location.d auc;
    private com.baidu.tieba.tbadkCore.writeModel.a aud;
    private d aue;
    private a<?> auf;
    private AntiData aug;
    private ForumData auh;
    private BaseActivity<?> aui;
    private String auj;
    private boolean auk;
    private int aul;
    private a.d aum;
    private c aun;
    private com.baidu.tbadk.editortools.imagetool.b auo;
    private com.baidu.tbadk.editortools.inputtool.a aup;
    private com.baidu.tbadk.editortools.sendtool.a auq;
    private d.a aur;
    private d.b aus;
    private final a.d aut;
    private long authorId;
    private String authorName;
    private final com.baidu.adp.base.g auu;
    private WriteImagesInfo baobaoImagesInfo;
    private String mThreadId;
    private UserData mUserData;
    private VideoInfo mVideoInfo;
    private String postId;
    private WriteImagesInfo writeImagesInfo;

    public e(com.baidu.tbadk.editortools.k kVar) {
        super(kVar);
        this.writeImagesInfo = new WriteImagesInfo();
        this.baobaoImagesInfo = new WriteImagesInfo();
        this.atY = "";
        this.aua = new WriteData();
        this.aud = null;
        this.aue = null;
        this.mThreadId = null;
        this.auj = null;
        this.auk = true;
        this.aul = 0;
        this.aur = new f(this);
        this.aus = new g(this);
        this.aut = new h(this);
        this.auu = new i(this);
    }

    private com.baidu.tbadk.editortools.sendtool.a BM() {
        if (this.auq == null && Bj() != null) {
            this.auq = (com.baidu.tbadk.editortools.sendtool.a) Bj().ec(4);
        }
        return this.auq;
    }

    public void ej(int i) {
        if (this.auq == null && Bj() != null) {
            this.auq = (com.baidu.tbadk.editortools.sendtool.a) Bj().ec(4);
        }
        if (this.auq != null) {
            this.auq.setType(i);
        }
    }

    public void ek(int i) {
        if (this.auq == null && Bj() != null) {
            this.auq = (com.baidu.tbadk.editortools.sendtool.a) Bj().ec(4);
        }
        if (this.auq != null) {
            this.auq.en(i);
        }
    }

    private com.baidu.tbadk.editortools.imagetool.b BN() {
        if (this.auo == null && Bj() != null) {
            this.auo = (com.baidu.tbadk.editortools.imagetool.b) Bj().ec(11);
        }
        return this.auo;
    }

    public void el(int i) {
        if (this.auo == null && Bj() != null) {
            this.auo = (com.baidu.tbadk.editortools.imagetool.b) Bj().ec(11);
        }
        if (this.auo != null) {
            this.auo.ei(i);
        }
    }

    private com.baidu.tbadk.editortools.inputtool.a BO() {
        if (this.aup == null && Bj() != null) {
            this.aup = (com.baidu.tbadk.editortools.inputtool.a) Bj().ec(3);
        }
        return this.aup;
    }

    public void fr(String str) {
        if (this.aup == null && Bj() != null) {
            this.aup = (com.baidu.tbadk.editortools.inputtool.a) Bj().ec(3);
        }
        if (this.aup != null) {
            this.aup.fm(str);
        }
    }

    public void bl(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (Bj() != null && (cVar = (com.baidu.tbadk.editortools.c) Bj().ea(5)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bm(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (Bj() != null && (cVar = (com.baidu.tbadk.editortools.c) Bj().ea(23)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bn(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (Bj() != null && (cVar = (com.baidu.tbadk.editortools.c) Bj().ea(2)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void a(a<?> aVar) {
        this.auf = aVar;
    }

    public void d(BaseActivity<?> baseActivity) {
        this.aui = baseActivity;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.auk = antiData.isIfvoice();
            this.auj = antiData.getVoice_message();
        }
        this.aug = antiData;
    }

    public void a(ForumData forumData, UserData userData) {
        this.auh = forumData;
        this.mUserData = userData;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (Bj() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void BP() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            String valueOf = String.valueOf(this.authorId);
            if (valueOf == null || valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                com.baidu.adp.lib.util.k.showToast(this.aui.getActivity(), n.j.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.aui.getActivity(), this.authorId, this.authorName, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.h.b.c(this.mThreadId, 0L), com.baidu.adp.lib.h.b.c(this.postId, 0L))));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.tbadk.editortools.r rVar;
        com.baidu.tbadk.editortools.r rVar2;
        com.baidu.tbadk.editortools.r rVar3 = null;
        if (i2 == -1) {
            switch (i) {
                case 11001:
                    a((String) null, (WriteData) null);
                    return;
                case 11025:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.aui.getActivity(), 12004, true)));
                    return;
                case 11026:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.aui.getActivity(), 12005, true)));
                    return;
                case 12002:
                    if (intent != null) {
                        boolean booleanExtra = intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false);
                        if (b.BK().getStatus() == 1) {
                            if (BN() != null) {
                                BN().ei(1);
                            }
                            if (getWriteImagesInfo() != null) {
                                getWriteImagesInfo().setMaxImagesAllowed(1);
                            }
                        } else {
                            if (BN() != null) {
                                BN().ei(10);
                            }
                            if (getWriteImagesInfo() != null) {
                                getWriteImagesInfo().setMaxImagesAllowed(10);
                            }
                        }
                        if (booleanExtra) {
                            J(intent);
                        } else {
                            I(intent);
                        }
                        if (Bj() != null) {
                            rVar2 = Bj().ea(2);
                            rVar = Bj().ea(5);
                            rVar3 = Bj().ea(23);
                        } else {
                            rVar = null;
                            rVar2 = null;
                        }
                        if (b.BK().getStatus() == 1) {
                            Ce();
                            if (Bj() != null) {
                                Bj().Bu();
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL));
                            }
                            if (rVar2 != null) {
                                rVar2.hide();
                            }
                            if (rVar != null) {
                                rVar.hide();
                            }
                            if (rVar3 != null) {
                                rVar3.ob();
                            }
                            if (BO() != null) {
                                BO().fm(this.aui.getPageContext().getString(n.j.add_picture_description));
                            }
                            if (BN() != null) {
                                BN().fk(this.aui.getPageContext().getString(n.j.show_pic_tip));
                                BN().fl(this.aui.getPageContext().getString(n.j.show_pic_add_tip));
                            }
                            if (BM() != null) {
                                BM().setType(SendView.auM);
                                BM().en(SendView.auM);
                            }
                        } else {
                            if (rVar2 != null) {
                                rVar2.ob();
                            }
                            if (rVar != null) {
                                rVar.ob();
                            }
                            if (rVar3 != null) {
                                rVar3.hide();
                            }
                            if (BO() != null) {
                                BO().fm(this.aui.getPageContext().getString(n.j.pb_reply_hint));
                            }
                            if (BM() != null) {
                                BM().setType(SendView.ALL);
                                BM().en(SendView.ALL);
                            }
                        }
                        Bj().invalidate();
                        return;
                    }
                    return;
                case 12003:
                    if (intent != null) {
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            Cb();
                            this.aud.hw(false);
                            return;
                        }
                        this.aue.fq(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case 12004:
                    ArrayList<String> S = com.baidu.tieba.tbadkCore.util.l.S(intent);
                    if (S != null) {
                        r(S);
                        return;
                    }
                    return;
                case 12006:
                    WriteData aGz = this.aud.aGz();
                    if (aGz != null) {
                        aGz.deleteUploadedTempImages();
                    }
                    this.aua.setIsBaobao(false);
                    this.aua.setBaobaoContent(null);
                    this.baobaoImagesInfo.clear();
                    this.aud.c((WriteData) null);
                    this.aud.hw(false);
                    this.atZ = null;
                    this.mVideoInfo = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        ae.c(this.mThreadId, (WriteData) null);
                    }
                    bp(true);
                    if (this.aum != null) {
                        this.aum.a(true, null, null, aGz, null);
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    if (i == 12010) {
                        F(intent);
                        return;
                    }
                    return;
                case 12012:
                    G(intent);
                    if (b.BK().getStatus() == 1 && BN() != null) {
                        BN().fk(this.aui.getPageContext().getString(n.j.show_pic_tip));
                        return;
                    }
                    return;
                case 12013:
                    H(intent);
                    return;
                case 13010:
                    if (Bj() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            av avVar = new av("c10068");
                            avVar.r("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(avVar);
                            Cc();
                            Bj().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            Bj().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                BW();
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

    public void BQ() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.aui.getActivity())));
    }

    public void BR() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.aui.getActivity())) {
            this.aui.showToast(n.j.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.m411getInst().getLocationShared()) {
            BS();
        } else if (this.auc.aGb()) {
            BQ();
        } else {
            this.auc.hv(false);
            a(1, true, (String) null);
            this.auc.aFZ();
        }
    }

    private void BS() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aui.getActivity());
        aVar.bG(n.j.location_app_permission_prompt).a(n.j.isopen, new j(this)).b(n.j.cancel, new k(this)).b(this.aui.getPageContext());
        aVar.tf();
    }

    public void BT() {
        if (this.auc.aGd()) {
            if (this.auc.aGb()) {
                this.aur.a(com.baidu.tieba.tbadkCore.location.c.aFW().getLocationData());
                return;
            }
            if (com.baidu.adp.lib.util.k.jh()) {
                this.auc.aFZ();
            }
            a(0, true, (String) null);
            return;
        }
        a(0, false, (String) null);
    }

    public boolean BU() {
        if (StringUtils.isNull(this.atY)) {
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() <= 0) {
                if (this.baobaoImagesInfo == null || this.baobaoImagesInfo.size() <= 0) {
                    if (this.atZ == null || StringUtils.isNull(this.atZ.getId())) {
                        return this.mVideoInfo != null && this.mVideoInfo.isAvaliable();
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
        this.aud.c((WriteData) null);
        this.aud.hw(false);
        this.atZ = null;
        this.mVideoInfo = null;
        this.baobaoImagesInfo.clear();
        this.writeImagesInfo.clear();
        this.aua.setIsBaobao(false);
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void BV() {
        this.mVideoInfo = null;
    }

    private void F(Intent intent) {
        this.aub = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aub;
        if (!TextUtils.isEmpty(str)) {
            try {
                int cN = com.baidu.tbadk.core.util.c.cN(str);
                if (cN != 0) {
                    Bitmap b = com.baidu.tbadk.core.util.c.b(str, com.baidu.adp.lib.util.k.dip2px(this.aui.getActivity(), com.baidu.adp.lib.util.k.K(this.aui.getActivity())), com.baidu.adp.lib.util.k.dip2px(this.aui.getActivity(), com.baidu.adp.lib.util.k.L(this.aui.getActivity())));
                    Bitmap i = com.baidu.tbadk.core.util.c.i(b, cN);
                    if (b != i) {
                        b.recycle();
                    }
                    com.baidu.tbadk.core.util.n.a(TbConfig.LOCAL_CAMERA_DIR, this.aub, i, 100);
                    i.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            Cd();
        }
    }

    private void G(Intent intent) {
        a(intent, false);
    }

    private void a(Intent intent, boolean z) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                Cd();
            }
        }
    }

    private void H(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("key_bitmap_path");
            String stringExtra2 = intent.getStringExtra("key_content");
            if (stringExtra != null && stringExtra2 != null) {
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(stringExtra);
                this.baobaoImagesInfo.clear();
                this.baobaoImagesInfo.addChooseFile(imageFileInfo);
                Cf();
                if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
                    this.aua.setIsBaobao(true);
                    this.aua.setBaobaoContent(stringExtra2);
                    this.aua.setBaobaoImagesInfo(this.baobaoImagesInfo);
                    return;
                }
                this.aua.setIsBaobao(false);
                this.aua.setBaobaoContent("");
                this.aua.setBaobaoImagesInfo(this.baobaoImagesInfo);
            }
        }
    }

    private void BW() {
        new l(this).execute(new Void[0]);
    }

    private void I(Intent intent) {
        a(intent, true);
    }

    private void J(Intent intent) {
        int size;
        int size2;
        F(intent);
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() - 1 > -1 && this.writeImagesInfo.getChosedFiles() != null && (size2 = this.writeImagesInfo.getChosedFiles().size()) >= 1 && size >= 0 && size < size2) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.aui.getActivity(), 12012, this.writeImagesInfo, size)));
        }
    }

    public void fs(String str) {
        WriteData aGz = this.aud.aGz();
        if (aGz == null) {
            aGz = new WriteData(1);
            aGz.setThreadId(str);
            aGz.setWriteImagesInfo(this.writeImagesInfo);
        }
        aGz.setContent(this.atY);
        if (this.aua != null && this.aua.getIsBaobao()) {
            aGz.setBaobaoContent(this.aua.getBaobaoContent());
            aGz.setBaobaoImagesInfo(this.baobaoImagesInfo);
            aGz.setIsBaobao(true);
        }
        aGz.setVideoInfo(this.mVideoInfo);
        ae.c(str, aGz);
    }

    public void ft(String str) {
        ae.a(str, this);
    }

    @Override // com.baidu.tieba.tbadkCore.ae.a
    public void a(WriteData writeData) {
        if (writeData != null) {
            if (!ax.isEmpty(writeData.getContent()) && ax.isEmpty(this.atY)) {
                this.atY = writeData.getContent();
                fv(this.atY);
            }
            if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                if (this.mVideoInfo == null) {
                    this.mVideoInfo = new VideoInfo();
                }
                this.mVideoInfo.copy(writeData.getVideoInfo());
                Cc();
                Bj().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                bo(false);
            }
            if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen() && writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                this.aua.setIsBaobao(writeData.getIsBaobao());
                this.aua.setBaobaoContent(writeData.getBaobaoContent());
                this.aua.setBaobaoImagesInfo(this.baobaoImagesInfo);
                Cf();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.aud.cancelLoadData();
        this.aue.cancelLoadData();
        this.auc.cancelLoadData();
    }

    public void BX() {
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        this.aud = new com.baidu.tieba.tbadkCore.writeModel.a(baseActivity);
        this.aud.b(this.aut);
        this.aue = new d(baseActivity);
        this.aue.setLoadDataCallBack(this.auu);
        this.auc = new com.baidu.tieba.tbadkCore.location.d(baseActivity);
        this.auc.a(this.aur);
        this.auc.a(this.aus);
        if (bundle != null) {
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.aub = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        this.writeImagesInfo.setMaxImagesAllowed(10);
        if (!StringUtils.isNull(TbadkCoreApplication.m411getInst().getDefaultBubble()) && Bj() != null) {
            Bj().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.auc.aGd() && Bj() != null) {
            Bj().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aub);
    }

    public void a(String str, WriteData writeData) {
        if (this.aud.aGz() == null) {
            this.aud.c(this.auf.fp(str));
        }
        if (this.aud.aGz() != null) {
            if (this.aug != null) {
                if ((AntiHelper.d(this.aug) || AntiHelper.e(this.aug) || AntiHelper.f(this.aug)) && this.auh != null && this.mUserData != null) {
                    this.aug.setBlock_forum_name(this.auh.getName());
                    this.aug.setBlock_forum_id(this.auh.getId());
                    this.aug.setUser_name(this.mUserData.getUserName());
                    this.aug.setUser_id(this.mUserData.getUserId());
                    if (AntiHelper.a(this.aui.getPageContext().getPageActivity(), this.aug, AntiHelper.OperationType.CREATE_THREAD, PageType.PB)) {
                        return;
                    }
                }
                if (this.aug != null && this.aug.getIfpost() == 0 && !TextUtils.isEmpty(this.aug.getForbid_info())) {
                    com.baidu.adp.lib.util.k.showToast(this.aui.getPageContext().getPageActivity(), this.aug.getForbid_info());
                    return;
                }
            }
            this.aud.aGz().setWriteImagesInfo(this.writeImagesInfo);
            this.aud.aGz().setVideoInfo(this.mVideoInfo);
            this.aud.hw(this.writeImagesInfo.size() > 0);
            if (this.aua.getIsBaobao()) {
                this.aud.aGz().setIsBaobao(true);
                this.aud.aGz().setBaobaoContent(this.aua.getBaobaoContent());
                this.aud.aGz().setBaobaoImagesInfo(this.baobaoImagesInfo);
            } else {
                this.aud.aGz().setIsBaobao(false);
            }
            this.aud.aGz().setHasLocationData(this.auc != null ? this.auc.aGd() : false);
            if (str == null) {
                this.aud.aGz().setContent(this.atY);
            }
            if (this.atZ != null) {
                if (this.atZ.getId() != null) {
                    this.aud.aGz().setVoice(this.atZ.getId());
                    this.aud.aGz().setVoiceDuringTime(this.atZ.duration);
                } else {
                    this.aud.aGz().setVoice(null);
                    this.aud.aGz().setVoiceDuringTime(-1);
                }
            } else {
                this.aud.aGz().setVoice(null);
                this.aud.aGz().setVoiceDuringTime(-1);
            }
            if (!this.aud.aGD()) {
                this.aui.showToast(n.j.write_img_limit);
                return;
            }
            if (this.aun != null) {
                this.aun.BL();
            }
            if (!this.aud.aGA()) {
            }
        }
    }

    public BaseActivity<?> BY() {
        return this.aui;
    }

    public WriteImagesInfo getBaobaoImagesInfo() {
        return this.baobaoImagesInfo;
    }

    public void fu(String str) {
        this.atY = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.atZ = voiceModel;
    }

    public WriteData BZ() {
        return this.aua;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int Ca() {
        return this.aul;
    }

    private void Cb() {
        if (Bj() != null) {
            Bj().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void r(ArrayList<String> arrayList) {
        if (Bj() != null) {
            Bj().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    private void Cc() {
        if (Bj() != null) {
            Bj().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    protected void bo(boolean z) {
        if (Bj() != null) {
            if (z) {
                Bj().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            Bj().b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                Bj().b(new com.baidu.tbadk.editortools.a(2, 10, new StringBuilder(String.valueOf(this.writeImagesInfo.getChosedFiles().size())).toString()));
            } else {
                Bj().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
        }
    }

    protected void Cd() {
        bo(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ce() {
        if (Bj() != null) {
            Bj().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    protected void Cf() {
        if (Bj() != null) {
            Bj().b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            Bj().b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
                Bj().b(new com.baidu.tbadk.editortools.a(2, 13, " "));
            } else {
                Bj().b(new com.baidu.tbadk.editortools.a(2, 13, null));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Cg() {
        if (Bj() != null) {
            Bj().b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.aul = i;
        if (Bj() != null) {
            Bj().b(new com.baidu.tbadk.editortools.a(19, 8, new com.baidu.tbadk.editortools.c.a(i, z, str)));
            if (i == 2) {
                Bj().b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            } else {
                Bj().b(new com.baidu.tbadk.editortools.a(2, 7, null));
            }
        }
    }

    private void fv(String str) {
        if (Bj() != null) {
            Bj().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bp(boolean z) {
        if (Bj() != null) {
            Bj().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void Ch() {
        bp(true);
    }

    public void a(a.d dVar) {
        this.aum = dVar;
    }

    public void a(c cVar) {
        this.aun = cVar;
    }

    public void Ci() {
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            this.writeImagesInfo.clear();
        }
        Cd();
        if (this.baobaoImagesInfo != null && this.baobaoImagesInfo.size() > 0) {
            this.baobaoImagesInfo.clear();
        }
        Cf();
        if (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) {
            this.mVideoInfo = null;
        }
        Bj().b(new com.baidu.tbadk.editortools.a(2, 19, null));
        setVoiceModel(null);
        Bj().b(new com.baidu.tbadk.editortools.a(2, 6, null));
        Bj().b(new com.baidu.tbadk.editortools.a(33, 6, null));
        if (!StringUtils.isNull(this.atY)) {
            this.atY = "";
        }
        fv("");
        this.aud.c((WriteData) null);
        this.aud.hw(false);
    }

    public void em(int i) {
        if (this.aup == null && Bj() != null) {
            this.aup = (com.baidu.tbadk.editortools.inputtool.a) Bj().ec(3);
        }
        if (this.aup != null && (this.aup.toolView instanceof EditText)) {
            this.aup.b(new m(this, i, (EditText) this.aup.toolView));
        }
    }

    public void Cj() {
        if (this.aup != null) {
            this.aup.b(null);
        }
    }
}
