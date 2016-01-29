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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.aw;
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
    private String auQ;
    private VoiceData.VoiceModel auR;
    private WriteData auS;
    private String auT;
    private com.baidu.tieba.tbadkCore.location.d auU;
    private com.baidu.tieba.tbadkCore.writeModel.a auV;
    private d auW;
    private a<?> auX;
    private AntiData auY;
    private ForumData auZ;
    private long authorId;
    private String authorName;
    private BaseActivity<?> ava;
    private String avb;
    private boolean avc;
    private int avd;
    private a.d ave;
    private c avf;
    private com.baidu.tbadk.editortools.imagetool.b avg;
    private com.baidu.tbadk.editortools.inputtool.a avh;
    private com.baidu.tbadk.editortools.sendtool.a avi;
    private d.a avj;
    private d.b avk;
    private final a.d avl;
    private final com.baidu.adp.base.g avm;
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
        this.auQ = "";
        this.auS = new WriteData();
        this.auV = null;
        this.auW = null;
        this.mThreadId = null;
        this.avb = null;
        this.avc = true;
        this.avd = 0;
        this.avj = new f(this);
        this.avk = new g(this);
        this.avl = new h(this);
        this.avm = new i(this);
    }

    private com.baidu.tbadk.editortools.sendtool.a Dc() {
        if (this.avi == null && Cz() != null) {
            this.avi = (com.baidu.tbadk.editortools.sendtool.a) Cz().ex(4);
        }
        return this.avi;
    }

    public void eD(int i) {
        if (this.avi == null && Cz() != null) {
            this.avi = (com.baidu.tbadk.editortools.sendtool.a) Cz().ex(4);
        }
        if (this.avi != null) {
            this.avi.setType(i);
        }
    }

    public void eE(int i) {
        if (this.avi == null && Cz() != null) {
            this.avi = (com.baidu.tbadk.editortools.sendtool.a) Cz().ex(4);
        }
        if (this.avi != null) {
            this.avi.eH(i);
        }
    }

    private com.baidu.tbadk.editortools.imagetool.b Dd() {
        if (this.avg == null && Cz() != null) {
            this.avg = (com.baidu.tbadk.editortools.imagetool.b) Cz().ex(11);
        }
        return this.avg;
    }

    public void eF(int i) {
        if (this.avg == null && Cz() != null) {
            this.avg = (com.baidu.tbadk.editortools.imagetool.b) Cz().ex(11);
        }
        if (this.avg != null) {
            this.avg.eC(i);
        }
    }

    private com.baidu.tbadk.editortools.inputtool.a De() {
        if (this.avh == null && Cz() != null) {
            this.avh = (com.baidu.tbadk.editortools.inputtool.a) Cz().ex(3);
        }
        return this.avh;
    }

    public void fp(String str) {
        if (this.avh == null && Cz() != null) {
            this.avh = (com.baidu.tbadk.editortools.inputtool.a) Cz().ex(3);
        }
        if (this.avh != null) {
            this.avh.setHint(str);
        }
    }

    public void bn(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (Cz() != null && (cVar = (com.baidu.tbadk.editortools.c) Cz().ev(5)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bo(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (Cz() != null && (cVar = (com.baidu.tbadk.editortools.c) Cz().ev(23)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bp(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (Cz() != null && (cVar = (com.baidu.tbadk.editortools.c) Cz().ev(2)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void a(a<?> aVar) {
        this.auX = aVar;
    }

    public void d(BaseActivity<?> baseActivity) {
        this.ava = baseActivity;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.avc = antiData.isIfvoice();
            this.avb = antiData.getVoice_message();
        }
        this.auY = antiData;
    }

    public void a(ForumData forumData, UserData userData) {
        this.auZ = forumData;
        this.mUserData = userData;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (Cz() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void Df() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            String valueOf = String.valueOf(this.authorId);
            if (valueOf == null || valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                com.baidu.adp.lib.util.k.showToast(this.ava.getActivity(), t.j.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.ava.getActivity(), this.authorId, this.authorName, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.h.b.c(this.mThreadId, 0L), com.baidu.adp.lib.h.b.c(this.postId, 0L))));
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.ava.getActivity(), 12004, true)));
                    return;
                case 11026:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.ava.getActivity(), 12005, true)));
                    return;
                case 12002:
                    if (intent != null) {
                        boolean booleanExtra = intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false);
                        if (b.Da().getStatus() == 1) {
                            if (Dd() != null) {
                                Dd().eC(1);
                            }
                            if (getWriteImagesInfo() != null) {
                                getWriteImagesInfo().setMaxImagesAllowed(1);
                            }
                        } else {
                            if (Dd() != null) {
                                Dd().eC(10);
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
                        if (Cz() != null) {
                            rVar2 = Cz().ev(2);
                            rVar = Cz().ev(5);
                            rVar3 = Cz().ev(23);
                        } else {
                            rVar = null;
                            rVar2 = null;
                        }
                        if (b.Da().getStatus() == 1) {
                            Du();
                            if (Cz() != null) {
                                Cz().CK();
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL));
                            }
                            if (rVar2 != null) {
                                rVar2.hide();
                            }
                            if (rVar != null) {
                                rVar.hide();
                            }
                            if (rVar3 != null) {
                                rVar3.ow();
                            }
                            if (De() != null) {
                                De().setHint(this.ava.getPageContext().getString(t.j.add_picture_description));
                            }
                            if (Dd() != null) {
                                Dd().fj(this.ava.getPageContext().getString(t.j.show_pic_tip));
                                Dd().fk(this.ava.getPageContext().getString(t.j.show_pic_add_tip));
                            }
                            if (Dc() != null) {
                                Dc().setType(SendView.avE);
                                Dc().eH(SendView.avE);
                            }
                        } else {
                            if (rVar2 != null) {
                                rVar2.ow();
                            }
                            if (rVar != null) {
                                rVar.ow();
                            }
                            if (rVar3 != null) {
                                rVar3.hide();
                            }
                            if (De() != null) {
                                De().setHint(this.ava.getPageContext().getString(t.j.pb_reply_hint));
                            }
                            if (Dc() != null) {
                                Dc().setType(SendView.ALL);
                                Dc().eH(SendView.ALL);
                            }
                        }
                        Cz().invalidate();
                        return;
                    }
                    return;
                case 12003:
                    if (intent != null) {
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            Dr();
                            this.auV.hX(false);
                            return;
                        }
                        this.auW.fo(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case 12004:
                    ArrayList<String> V = com.baidu.tieba.tbadkCore.util.l.V(intent);
                    if (V != null) {
                        s(V);
                        return;
                    }
                    return;
                case 12006:
                    WriteData aND = this.auV.aND();
                    if (aND != null) {
                        aND.deleteUploadedTempImages();
                    }
                    this.auS.setIsBaobao(false);
                    this.auS.setBaobaoContent(null);
                    this.baobaoImagesInfo.clear();
                    this.auV.c((WriteData) null);
                    this.auV.hX(false);
                    this.auR = null;
                    this.mVideoInfo = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        ad.c(this.mThreadId, (WriteData) null);
                    }
                    br(true);
                    if (this.ave != null) {
                        this.ave.a(true, null, null, aND, null);
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
                    if (b.Da().getStatus() == 1 && Dd() != null) {
                        Dd().fj(this.ava.getPageContext().getString(t.j.show_pic_tip));
                        return;
                    }
                    return;
                case 12013:
                    H(intent);
                    return;
                case 13010:
                    if (Cz() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            au auVar = new au("c10068");
                            auVar.r("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(auVar);
                            Ds();
                            Cz().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            Cz().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                Dm();
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

    public void Dg() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.ava.getActivity())));
    }

    public void Dh() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.ava.getActivity())) {
            this.ava.showToast(t.j.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.m411getInst().getLocationShared()) {
            Di();
        } else if (this.auU.aNg()) {
            Dg();
        } else {
            this.auU.hW(false);
            a(1, true, (String) null);
            this.auU.aNe();
        }
    }

    private void Di() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ava.getActivity());
        aVar.bY(t.j.location_app_permission_prompt).a(t.j.isopen, new j(this)).b(t.j.cancel, new k(this)).b(this.ava.getPageContext());
        aVar.uj();
    }

    public void Dj() {
        if (this.auU.aNi()) {
            if (this.auU.aNg()) {
                this.avj.a(com.baidu.tieba.tbadkCore.location.c.aNb().getLocationData());
                return;
            }
            if (com.baidu.adp.lib.util.k.jq()) {
                this.auU.aNe();
            }
            a(0, true, (String) null);
            return;
        }
        a(0, false, (String) null);
    }

    public boolean Dk() {
        if (StringUtils.isNull(this.auQ)) {
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() <= 0) {
                if (this.baobaoImagesInfo == null || this.baobaoImagesInfo.size() <= 0) {
                    if (this.auR == null || StringUtils.isNull(this.auR.getId())) {
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
        this.auV.c((WriteData) null);
        this.auV.hX(false);
        this.auR = null;
        this.mVideoInfo = null;
        this.baobaoImagesInfo.clear();
        this.writeImagesInfo.clear();
        this.auS.setIsBaobao(false);
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void Dl() {
        this.mVideoInfo = null;
    }

    private void F(Intent intent) {
        this.auT = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.auT;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.k.dip2px(this.ava.getActivity(), com.baidu.adp.lib.util.k.K(this.ava.getActivity())), com.baidu.adp.lib.util.k.dip2px(this.ava.getActivity(), com.baidu.adp.lib.util.k.L(this.ava.getActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.m.b(TbConfig.LOCAL_CAMERA_DIR, this.auT, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            Dt();
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
                Dt();
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
                Dv();
                if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
                    this.auS.setIsBaobao(true);
                    this.auS.setBaobaoContent(stringExtra2);
                    this.auS.setBaobaoImagesInfo(this.baobaoImagesInfo);
                    return;
                }
                this.auS.setIsBaobao(false);
                this.auS.setBaobaoContent("");
                this.auS.setBaobaoImagesInfo(this.baobaoImagesInfo);
            }
        }
    }

    private void Dm() {
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
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.ava.getActivity(), 12012, this.writeImagesInfo, size)));
        }
    }

    public void fq(String str) {
        WriteData aND = this.auV.aND();
        if (aND == null) {
            aND = new WriteData(1);
            aND.setThreadId(str);
            aND.setWriteImagesInfo(this.writeImagesInfo);
        }
        aND.setContent(this.auQ);
        if (this.auS != null && this.auS.getIsBaobao()) {
            aND.setBaobaoContent(this.auS.getBaobaoContent());
            aND.setBaobaoImagesInfo(this.baobaoImagesInfo);
            aND.setIsBaobao(true);
        }
        aND.setVideoInfo(this.mVideoInfo);
        ad.c(str, aND);
    }

    public void fr(String str) {
        ad.a(str, this);
    }

    @Override // com.baidu.tieba.tbadkCore.ad.a
    public void a(WriteData writeData) {
        if (writeData != null) {
            if (!aw.isEmpty(writeData.getContent()) && aw.isEmpty(this.auQ)) {
                this.auQ = writeData.getContent();
                ft(this.auQ);
            }
            if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                if (this.mVideoInfo == null) {
                    this.mVideoInfo = new VideoInfo();
                }
                this.mVideoInfo.copy(writeData.getVideoInfo());
                Ds();
                Cz().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                bq(false);
            }
            if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen() && writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                this.auS.setIsBaobao(writeData.getIsBaobao());
                this.auS.setBaobaoContent(writeData.getBaobaoContent());
                this.auS.setBaobaoImagesInfo(this.baobaoImagesInfo);
                Dv();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.auV.cancelLoadData();
        this.auW.cancelLoadData();
        this.auU.cancelLoadData();
    }

    public void Dn() {
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        this.auV = new com.baidu.tieba.tbadkCore.writeModel.a(baseActivity);
        this.auV.b(this.avl);
        this.auW = new d(baseActivity);
        this.auW.setLoadDataCallBack(this.avm);
        this.auU = new com.baidu.tieba.tbadkCore.location.d(baseActivity);
        this.auU.a(this.avj);
        this.auU.a(this.avk);
        if (bundle != null) {
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.auT = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        this.writeImagesInfo.setMaxImagesAllowed(10);
        if (!StringUtils.isNull(TbadkCoreApplication.m411getInst().getDefaultBubble()) && Cz() != null) {
            Cz().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.auU.aNi() && Cz() != null) {
            Cz().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.auT);
    }

    public void a(String str, WriteData writeData) {
        if (this.auV.aND() == null) {
            this.auV.c(this.auX.fn(str));
        }
        if (this.auV.aND() != null) {
            this.auV.aND().setWriteImagesInfo(this.writeImagesInfo);
            this.auV.aND().setVideoInfo(this.mVideoInfo);
            this.auV.hX(this.writeImagesInfo.size() > 0);
            if (this.auS.getIsBaobao()) {
                this.auV.aND().setIsBaobao(true);
                this.auV.aND().setBaobaoContent(this.auS.getBaobaoContent());
                this.auV.aND().setBaobaoImagesInfo(this.baobaoImagesInfo);
            } else {
                this.auV.aND().setIsBaobao(false);
            }
            this.auV.aND().setHasLocationData(this.auU != null ? this.auU.aNi() : false);
            if (str == null) {
                this.auV.aND().setContent(this.auQ);
            }
            if (this.auR != null) {
                if (this.auR.getId() != null) {
                    this.auV.aND().setVoice(this.auR.getId());
                    this.auV.aND().setVoiceDuringTime(this.auR.duration);
                } else {
                    this.auV.aND().setVoice(null);
                    this.auV.aND().setVoiceDuringTime(-1);
                }
            } else {
                this.auV.aND().setVoice(null);
                this.auV.aND().setVoiceDuringTime(-1);
            }
            if (!this.auV.aNH()) {
                this.ava.showToast(t.j.write_img_limit);
                return;
            }
            if (this.avf != null) {
                this.avf.Db();
            }
            if (!this.auV.aNE()) {
            }
        }
    }

    public BaseActivity<?> Do() {
        return this.ava;
    }

    public WriteImagesInfo getBaobaoImagesInfo() {
        return this.baobaoImagesInfo;
    }

    public void fs(String str) {
        this.auQ = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.auR = voiceModel;
    }

    public WriteData Dp() {
        return this.auS;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int Dq() {
        return this.avd;
    }

    private void Dr() {
        if (Cz() != null) {
            Cz().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void s(ArrayList<String> arrayList) {
        if (Cz() != null) {
            Cz().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    private void Ds() {
        if (Cz() != null) {
            Cz().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    protected void bq(boolean z) {
        if (Cz() != null) {
            if (z) {
                Cz().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            Cz().b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                Cz().b(new com.baidu.tbadk.editortools.a(2, 10, new StringBuilder(String.valueOf(this.writeImagesInfo.getChosedFiles().size())).toString()));
            } else {
                Cz().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
        }
    }

    protected void Dt() {
        bq(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Du() {
        if (Cz() != null) {
            Cz().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    protected void Dv() {
        if (Cz() != null) {
            Cz().b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            Cz().b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
                Cz().b(new com.baidu.tbadk.editortools.a(2, 13, " "));
            } else {
                Cz().b(new com.baidu.tbadk.editortools.a(2, 13, null));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Dw() {
        if (Cz() != null) {
            Cz().b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.avd = i;
        if (Cz() != null) {
            Cz().b(new com.baidu.tbadk.editortools.a(19, 8, new com.baidu.tbadk.editortools.c.a(i, z, str)));
            if (i == 2) {
                Cz().b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            } else {
                Cz().b(new com.baidu.tbadk.editortools.a(2, 7, null));
            }
        }
    }

    private void ft(String str) {
        if (Cz() != null) {
            Cz().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void br(boolean z) {
        if (Cz() != null) {
            Cz().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void Dx() {
        br(true);
    }

    public void a(a.d dVar) {
        this.ave = dVar;
    }

    public void a(c cVar) {
        this.avf = cVar;
    }

    public void Dy() {
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            this.writeImagesInfo.clear();
        }
        Dt();
        if (this.baobaoImagesInfo != null && this.baobaoImagesInfo.size() > 0) {
            this.baobaoImagesInfo.clear();
        }
        Dv();
        if (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) {
            this.mVideoInfo = null;
        }
        Cz().b(new com.baidu.tbadk.editortools.a(2, 19, null));
        setVoiceModel(null);
        Cz().b(new com.baidu.tbadk.editortools.a(2, 6, null));
        Cz().b(new com.baidu.tbadk.editortools.a(33, 6, null));
        if (!StringUtils.isNull(this.auQ)) {
            this.auQ = "";
        }
        ft("");
        this.auV.c((WriteData) null);
        this.auV.hX(false);
    }

    public void eG(int i) {
        if (this.avh == null && Cz() != null) {
            this.avh = (com.baidu.tbadk.editortools.inputtool.a) Cz().ex(3);
        }
        if (this.avh != null && (this.avh.toolView instanceof EditText)) {
            this.avh.b(new m(this, i, (EditText) this.avh.toolView));
        }
    }

    public void Dz() {
        if (this.avh != null) {
            this.avh.b(null);
        }
    }
}
