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
    private final a.d asA;
    private final com.baidu.adp.base.g asB;
    private String asf;
    private VoiceData.VoiceModel asg;
    private WriteData ash;
    private String asi;
    private com.baidu.tieba.tbadkCore.location.d asj;
    private com.baidu.tieba.tbadkCore.writeModel.a ask;
    private d asl;
    private a<?> asm;
    private AntiData asn;
    private ForumData aso;
    private BaseActivity<?> asp;
    private String asq;
    private boolean asr;
    private int ass;
    private a.d ast;
    private c asu;
    private com.baidu.tbadk.editortools.imagetool.b asv;
    private com.baidu.tbadk.editortools.inputtool.a asw;
    private com.baidu.tbadk.editortools.sendtool.a asx;
    private d.a asy;
    private d.b asz;
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
        this.asf = "";
        this.ash = new WriteData();
        this.ask = null;
        this.asl = null;
        this.mThreadId = null;
        this.asq = null;
        this.asr = true;
        this.ass = 0;
        this.asy = new f(this);
        this.asz = new g(this);
        this.asA = new h(this);
        this.asB = new i(this);
    }

    private com.baidu.tbadk.editortools.sendtool.a BO() {
        if (this.asx == null && Bl() != null) {
            this.asx = (com.baidu.tbadk.editortools.sendtool.a) Bl().el(4);
        }
        return this.asx;
    }

    public void es(int i) {
        if (this.asx == null && Bl() != null) {
            this.asx = (com.baidu.tbadk.editortools.sendtool.a) Bl().el(4);
        }
        if (this.asx != null) {
            this.asx.setType(i);
        }
    }

    public void et(int i) {
        if (this.asx == null && Bl() != null) {
            this.asx = (com.baidu.tbadk.editortools.sendtool.a) Bl().el(4);
        }
        if (this.asx != null) {
            this.asx.ew(i);
        }
    }

    private com.baidu.tbadk.editortools.imagetool.b BP() {
        if (this.asv == null && Bl() != null) {
            this.asv = (com.baidu.tbadk.editortools.imagetool.b) Bl().el(11);
        }
        return this.asv;
    }

    public void eu(int i) {
        if (this.asv == null && Bl() != null) {
            this.asv = (com.baidu.tbadk.editortools.imagetool.b) Bl().el(11);
        }
        if (this.asv != null) {
            this.asv.er(i);
        }
    }

    private com.baidu.tbadk.editortools.inputtool.a BQ() {
        if (this.asw == null && Bl() != null) {
            this.asw = (com.baidu.tbadk.editortools.inputtool.a) Bl().el(3);
        }
        return this.asw;
    }

    public void fA(String str) {
        if (this.asw == null && Bl() != null) {
            this.asw = (com.baidu.tbadk.editortools.inputtool.a) Bl().el(3);
        }
        if (this.asw != null) {
            this.asw.setHint(str);
        }
    }

    public void bx(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (Bl() != null && (cVar = (com.baidu.tbadk.editortools.c) Bl().ej(5)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void by(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (Bl() != null && (cVar = (com.baidu.tbadk.editortools.c) Bl().ej(23)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bz(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (Bl() != null && (cVar = (com.baidu.tbadk.editortools.c) Bl().ej(2)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void a(a<?> aVar) {
        this.asm = aVar;
    }

    public void setThreadId(String str) {
        this.mThreadId = str;
    }

    public void d(BaseActivity<?> baseActivity) {
        this.asp = baseActivity;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.asr = antiData.isIfvoice();
            this.asq = antiData.getVoice_message();
        }
        this.asn = antiData;
    }

    public void a(ForumData forumData, UserData userData) {
        this.aso = forumData;
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
                com.baidu.adp.lib.util.k.showToast(this.asp.getActivity(), u.j.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.asp.getActivity(), this.authorId, this.authorName, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.h.b.c(this.mThreadId, 0L), com.baidu.adp.lib.h.b.c(this.postId, 0L))));
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.asp.getActivity(), 12004, true)));
                    return;
                case 11026:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.asp.getActivity(), 12005, true)));
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
                            f(intent);
                        } else {
                            e(intent);
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
                                sVar3.kF();
                            }
                            if (BQ() != null) {
                                BQ().setHint(this.asp.getPageContext().getString(u.j.add_picture_description));
                            }
                            if (BP() != null) {
                                BP().fu(this.asp.getPageContext().getString(u.j.show_pic_tip));
                                BP().fv(this.asp.getPageContext().getString(u.j.show_pic_add_tip));
                            }
                            if (BO() != null) {
                                BO().setType(SendView.asU);
                                BO().ew(SendView.asU);
                            }
                        } else {
                            if (sVar2 != null) {
                                sVar2.kF();
                            }
                            if (sVar != null) {
                                sVar.kF();
                            }
                            if (sVar3 != null) {
                                sVar3.hide();
                            }
                            if (BQ() != null) {
                                BQ().setHint(this.asp.getPageContext().getString(u.j.pb_reply_hint));
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
                            this.ask.kn(false);
                            return;
                        }
                        this.asl.fz(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case 12004:
                    ArrayList<String> y = com.baidu.tieba.tbadkCore.util.l.y(intent);
                    if (y != null) {
                        p(y);
                        return;
                    }
                    return;
                case 12006:
                    WriteData bdu = this.ask.bdu();
                    if (bdu != null) {
                        bdu.deleteUploadedTempImages();
                    }
                    this.ash.setIsBaobao(false);
                    this.ash.setBaobaoContent(null);
                    this.baobaoImagesInfo.clear();
                    this.ask.d((WriteData) null);
                    this.ask.kn(false);
                    this.asg = null;
                    this.mVideoInfo = null;
                    this.mGraffitiFileName = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        af.c(this.mThreadId, (WriteData) null);
                    }
                    bB(true);
                    if (this.ast != null) {
                        this.ast.callback(true, null, null, bdu, null);
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
                    if (b.BM().getStatus() == 1 && BP() != null) {
                        BP().fu(this.asp.getPageContext().getString(u.j.show_pic_tip));
                        return;
                    }
                    return;
                case 12013:
                    d(intent);
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
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.asp.getActivity())));
    }

    public void BT() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.asp.getActivity())) {
            this.asp.showToast(u.j.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.m9getInst().getLocationShared()) {
            BU();
        } else if (this.asj.bcX()) {
            BS();
        } else {
            this.asj.kl(false);
            a(1, true, (String) null);
            this.asj.bcV();
        }
    }

    private void BU() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.asp.getActivity());
        aVar.bM(u.j.location_app_permission_prompt).a(u.j.isopen, new j(this)).b(u.j.cancel, new k(this)).b(this.asp.getPageContext());
        aVar.rT();
    }

    public void BV() {
        if (this.asj.bcZ()) {
            if (this.asj.bcX()) {
                this.asy.a(com.baidu.tieba.tbadkCore.location.c.bcT().getLocationData());
                return;
            }
            if (com.baidu.adp.lib.util.k.fI()) {
                this.asj.bcV();
            }
            a(0, true, (String) null);
            return;
        }
        a(0, false, (String) null);
    }

    public boolean BW() {
        if (StringUtils.isNull(this.asf)) {
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() <= 0) {
                if (this.baobaoImagesInfo == null || this.baobaoImagesInfo.size() <= 0) {
                    if (this.asg == null || StringUtils.isNull(this.asg.getId())) {
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
        this.ask.d((WriteData) null);
        this.ask.kn(false);
        this.asg = null;
        this.mVideoInfo = null;
        this.mGraffitiFileName = null;
        this.baobaoImagesInfo.clear();
        this.writeImagesInfo.clear();
        this.ash.setIsBaobao(false);
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void BX() {
        this.mVideoInfo = null;
    }

    private void b(Intent intent) {
        this.asi = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.asi;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.k.dip2px(this.asp.getActivity(), com.baidu.adp.lib.util.k.A(this.asp.getActivity())), com.baidu.adp.lib.util.k.dip2px(this.asp.getActivity(), com.baidu.adp.lib.util.k.B(this.asp.getActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.m.a(TbConfig.LOCAL_CAMERA_DIR, this.asi, rotateBitmapBydegree, 100);
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

    private void c(Intent intent) {
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

    private void d(Intent intent) {
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
                    this.ash.setIsBaobao(true);
                    this.ash.setBaobaoContent(stringExtra2);
                    this.ash.setBaobaoImagesInfo(this.baobaoImagesInfo);
                    return;
                }
                this.ash.setIsBaobao(false);
                this.ash.setBaobaoContent("");
                this.ash.setBaobaoImagesInfo(this.baobaoImagesInfo);
            }
        }
    }

    private void BY() {
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
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.asp.getActivity(), 12012, this.writeImagesInfo, size)));
        }
    }

    public void fB(String str) {
        WriteData bdu = this.ask.bdu();
        if (bdu == null) {
            bdu = new WriteData(1);
            bdu.setThreadId(str);
            bdu.setWriteImagesInfo(this.writeImagesInfo);
        }
        bdu.setContent(this.asf);
        if (this.ash != null && this.ash.getIsBaobao()) {
            bdu.setBaobaoContent(this.ash.getBaobaoContent());
            bdu.setBaobaoImagesInfo(this.baobaoImagesInfo);
            bdu.setIsBaobao(true);
        }
        bdu.setVideoInfo(this.mVideoInfo);
        bdu.setGraffitiFileName(this.mGraffitiFileName);
        af.c(str, bdu);
    }

    public void fC(String str) {
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
                bA(false);
            }
            if (TbadkCoreApplication.m9getInst().isBaobaoShouldOpen() && writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                this.ash.setIsBaobao(writeData.getIsBaobao());
                this.ash.setBaobaoContent(writeData.getBaobaoContent());
                this.ash.setBaobaoImagesInfo(this.baobaoImagesInfo);
                Ch();
            }
            this.mGraffitiFileName = writeData.getGraffitiFileName();
            if (Bl() != null && !ba.isEmpty(this.mGraffitiFileName)) {
                Bl().b(new com.baidu.tbadk.editortools.a(42, 24, this.mGraffitiFileName));
            }
            if (!ba.isEmpty(writeData.getContent()) && ba.isEmpty(this.asf)) {
                this.asf = writeData.getContent();
                fE(this.asf);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.ask.cancelLoadData();
        this.asl.cancelLoadData();
        this.asj.cancelLoadData();
    }

    public void BZ() {
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        this.ask = new com.baidu.tieba.tbadkCore.writeModel.a(baseActivity);
        this.ask.b(this.asA);
        this.asl = new d(baseActivity);
        this.asl.setLoadDataCallBack(this.asB);
        this.asj = new com.baidu.tieba.tbadkCore.location.d(baseActivity);
        this.asj.a(this.asy);
        this.asj.a(this.asz);
        if (bundle != null) {
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable("write_images");
            this.asi = bundle.getString("photo_name");
        }
        this.writeImagesInfo.setMaxImagesAllowed(10);
        if (!StringUtils.isNull(TbadkCoreApplication.m9getInst().getDefaultBubble()) && Bl() != null) {
            Bl().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.asj.bcZ() && Bl() != null) {
            Bl().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
        Ca();
    }

    private void Ca() {
        boolean z;
        try {
            z = com.baidu.tbadk.core.sharedPref.b.sO().getBoolean("graffiti_reply_notice_show", true);
        } catch (ClassCastException e) {
            com.baidu.tbadk.core.sharedPref.b.sO().remove("graffiti_reply_notice_show");
            z = false;
        }
        if (Bl() != null) {
            Bl().b(new com.baidu.tbadk.editortools.a(2, 24, z ? " " : null));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("write_images", this.writeImagesInfo);
        bundle.putString("photo_name", this.asi);
    }

    public void a(String str, WriteData writeData) {
        if (this.ask.bdu() == null) {
            this.ask.d(this.asm.fy(str));
        }
        if (this.ask.bdu() != null) {
            this.ask.bdu().setWriteImagesInfo(this.writeImagesInfo);
            this.ask.bdu().setVideoInfo(this.mVideoInfo);
            this.ask.bdu().setGraffitiFileName(this.mGraffitiFileName);
            this.ask.kn(this.writeImagesInfo.size() > 0);
            if (this.ash.getIsBaobao()) {
                this.ask.bdu().setIsBaobao(true);
                this.ask.bdu().setBaobaoContent(this.ash.getBaobaoContent());
                this.ask.bdu().setBaobaoImagesInfo(this.baobaoImagesInfo);
            } else {
                this.ask.bdu().setIsBaobao(false);
            }
            this.ask.bdu().setHasLocationData(this.asj != null ? this.asj.bcZ() : false);
            if (str == null) {
                this.ask.bdu().setContent(this.asf);
            }
            if (this.asg != null) {
                if (this.asg.getId() != null) {
                    this.ask.bdu().setVoice(this.asg.getId());
                    this.ask.bdu().setVoiceDuringTime(this.asg.duration);
                } else {
                    this.ask.bdu().setVoice(null);
                    this.ask.bdu().setVoiceDuringTime(-1);
                }
            } else {
                this.ask.bdu().setVoice(null);
                this.ask.bdu().setVoiceDuringTime(-1);
            }
            if (!this.ask.bdy()) {
                this.asp.showToast(u.j.write_img_limit);
                return;
            }
            if (this.asu != null) {
                this.asu.BN();
            }
            if (!this.ask.bdv()) {
            }
        }
    }

    public BaseActivity<?> getContext() {
        return this.asp;
    }

    public WriteImagesInfo getBaobaoImagesInfo() {
        return this.baobaoImagesInfo;
    }

    public void fD(String str) {
        this.asf = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.asg = voiceModel;
    }

    public WriteData Cb() {
        return this.ash;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int Cc() {
        return this.ass;
    }

    private void Cd() {
        if (Bl() != null) {
            Bl().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void p(ArrayList<String> arrayList) {
        if (Bl() != null) {
            Bl().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    private void Ce() {
        if (Bl() != null) {
            Bl().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    protected void bA(boolean z) {
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
        bA(true);
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
    public void a(int i, boolean z, String str) {
        this.ass = i;
        if (Bl() != null) {
            Bl().b(new com.baidu.tbadk.editortools.a(19, 8, new com.baidu.tbadk.editortools.c.a(i, z, str)));
            if (i == 2) {
                Bl().b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            } else {
                Bl().b(new com.baidu.tbadk.editortools.a(2, 7, null));
            }
        }
    }

    private void fE(String str) {
        if (Bl() != null) {
            Bl().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bB(boolean z) {
        if (Bl() != null) {
            Bl().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void Cj() {
        bB(true);
    }

    public void a(a.d dVar) {
        this.ast = dVar;
    }

    public void a(c cVar) {
        this.asu = cVar;
    }

    public void Ck() {
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
        if (!StringUtils.isNull(this.asf)) {
            this.asf = "";
        }
        fE("");
        this.mGraffitiFileName = null;
        Bl().b(new com.baidu.tbadk.editortools.a(42, 24, null));
        this.ask.d((WriteData) null);
        this.ask.kn(false);
    }

    public void ev(int i) {
        if (this.asw == null && Bl() != null) {
            this.asw = (com.baidu.tbadk.editortools.inputtool.a) Bl().el(3);
        }
        if (this.asw != null && (this.asw.aqi instanceof EditText)) {
            this.asw.b(new m(this, i, (EditText) this.asw.aqi));
        }
    }

    public void Cl() {
        if (this.asw != null) {
            this.asw.b(null);
        }
    }

    public void setGraffitiFileName(String str) {
        this.mGraffitiFileName = str;
    }
}
