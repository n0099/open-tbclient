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
    private d asA;
    private a<?> asB;
    private AntiData asC;
    private ForumData asD;
    private BaseActivity<?> asE;
    private String asF;
    private boolean asG;
    private int asH;
    private a.d asI;
    private c asJ;
    private com.baidu.tbadk.editortools.imagetool.b asK;
    private com.baidu.tbadk.editortools.inputtool.a asL;
    private com.baidu.tbadk.editortools.sendtool.a asM;
    private d.a asN;
    private d.b asO;
    private final a.d asP;
    private final com.baidu.adp.base.g asQ;
    private String asu;
    private VoiceData.VoiceModel asv;
    private WriteData asw;
    private String asx;
    private com.baidu.tieba.tbadkCore.location.d asy;
    private com.baidu.tieba.tbadkCore.writeModel.a asz;
    private long authorId;
    private String authorName;
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
        this.asu = "";
        this.asw = new WriteData();
        this.asz = null;
        this.asA = null;
        this.mThreadId = null;
        this.asF = null;
        this.asG = true;
        this.asH = 0;
        this.asN = new f(this);
        this.asO = new g(this);
        this.asP = new h(this);
        this.asQ = new i(this);
    }

    private com.baidu.tbadk.editortools.sendtool.a BX() {
        if (this.asM == null && Bu() != null) {
            this.asM = (com.baidu.tbadk.editortools.sendtool.a) Bu().ei(4);
        }
        return this.asM;
    }

    public void ep(int i) {
        if (this.asM == null && Bu() != null) {
            this.asM = (com.baidu.tbadk.editortools.sendtool.a) Bu().ei(4);
        }
        if (this.asM != null) {
            this.asM.setType(i);
        }
    }

    public void eq(int i) {
        if (this.asM == null && Bu() != null) {
            this.asM = (com.baidu.tbadk.editortools.sendtool.a) Bu().ei(4);
        }
        if (this.asM != null) {
            this.asM.et(i);
        }
    }

    private com.baidu.tbadk.editortools.imagetool.b BY() {
        if (this.asK == null && Bu() != null) {
            this.asK = (com.baidu.tbadk.editortools.imagetool.b) Bu().ei(11);
        }
        return this.asK;
    }

    public void er(int i) {
        if (this.asK == null && Bu() != null) {
            this.asK = (com.baidu.tbadk.editortools.imagetool.b) Bu().ei(11);
        }
        if (this.asK != null) {
            this.asK.eo(i);
        }
    }

    private com.baidu.tbadk.editortools.inputtool.a BZ() {
        if (this.asL == null && Bu() != null) {
            this.asL = (com.baidu.tbadk.editortools.inputtool.a) Bu().ei(3);
        }
        return this.asL;
    }

    public void fn(String str) {
        if (this.asL == null && Bu() != null) {
            this.asL = (com.baidu.tbadk.editortools.inputtool.a) Bu().ei(3);
        }
        if (this.asL != null) {
            this.asL.fi(str);
        }
    }

    public void bl(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (Bu() != null && (cVar = (com.baidu.tbadk.editortools.c) Bu().eg(5)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bm(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (Bu() != null && (cVar = (com.baidu.tbadk.editortools.c) Bu().eg(23)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bn(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (Bu() != null && (cVar = (com.baidu.tbadk.editortools.c) Bu().eg(2)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void a(a<?> aVar) {
        this.asB = aVar;
    }

    public void b(BaseActivity<?> baseActivity) {
        this.asE = baseActivity;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.asG = antiData.isIfvoice();
            this.asF = antiData.getVoice_message();
        }
        this.asC = antiData;
    }

    public void a(ForumData forumData, UserData userData) {
        this.asD = forumData;
        this.mUserData = userData;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (Bu() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void Ca() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            String valueOf = String.valueOf(this.authorId);
            if (valueOf == null || valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                com.baidu.adp.lib.util.k.showToast(this.asE.getActivity(), n.i.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.asE.getActivity(), this.authorId, this.authorName, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.h.b.c(this.mThreadId, 0L), com.baidu.adp.lib.h.b.c(this.postId, 0L))));
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.asE.getActivity(), 12004, true)));
                    return;
                case 11026:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.asE.getActivity(), 12005, true)));
                    return;
                case 12002:
                    if (intent != null) {
                        boolean booleanExtra = intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false);
                        if (b.BV().getStatus() == 1) {
                            if (BY() != null) {
                                BY().eo(1);
                            }
                            if (getWriteImagesInfo() != null) {
                                getWriteImagesInfo().setMaxImagesAllowed(1);
                            }
                        } else {
                            if (BY() != null) {
                                BY().eo(10);
                            }
                            if (getWriteImagesInfo() != null) {
                                getWriteImagesInfo().setMaxImagesAllowed(10);
                            }
                        }
                        if (booleanExtra) {
                            K(intent);
                        } else {
                            J(intent);
                        }
                        if (Bu() != null) {
                            rVar2 = Bu().eg(2);
                            rVar = Bu().eg(5);
                            rVar3 = Bu().eg(23);
                        } else {
                            rVar = null;
                            rVar2 = null;
                        }
                        if (b.BV().getStatus() == 1) {
                            Cp();
                            if (Bu() != null) {
                                Bu().BF();
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL));
                            }
                            if (rVar2 != null) {
                                rVar2.hide();
                            }
                            if (rVar != null) {
                                rVar.hide();
                            }
                            if (rVar3 != null) {
                                rVar3.oD();
                            }
                            if (BZ() != null) {
                                BZ().fi(this.asE.getPageContext().getString(n.i.add_picture_description));
                            }
                            if (BY() != null) {
                                BY().fg(this.asE.getPageContext().getString(n.i.show_pic_tip));
                                BY().fh(this.asE.getPageContext().getString(n.i.show_pic_add_tip));
                            }
                            if (BX() != null) {
                                BX().setType(SendView.ati);
                                BX().et(SendView.ati);
                            }
                        } else {
                            if (rVar2 != null) {
                                rVar2.oD();
                            }
                            if (rVar != null) {
                                rVar.oD();
                            }
                            if (rVar3 != null) {
                                rVar3.hide();
                            }
                            if (BZ() != null) {
                                BZ().fi(this.asE.getPageContext().getString(n.i.pb_reply_hint));
                            }
                            if (BX() != null) {
                                BX().setType(SendView.ALL);
                                BX().et(SendView.ALL);
                            }
                        }
                        Bu().invalidate();
                        return;
                    }
                    return;
                case 12003:
                    if (intent != null) {
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            Cm();
                            this.asz.hn(false);
                            return;
                        }
                        this.asA.fm(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case 12004:
                    ArrayList<String> T = com.baidu.tieba.tbadkCore.util.l.T(intent);
                    if (T != null) {
                        r(T);
                        return;
                    }
                    return;
                case 12006:
                    WriteData aEl = this.asz.aEl();
                    if (aEl != null) {
                        aEl.deleteUploadedTempImages();
                    }
                    this.asw.setIsBaobao(false);
                    this.asw.setBaobaoContent(null);
                    this.baobaoImagesInfo.clear();
                    this.asz.c((WriteData) null);
                    this.asz.hn(false);
                    this.asv = null;
                    this.mVideoInfo = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        ae.c(this.mThreadId, (WriteData) null);
                    }
                    bp(true);
                    if (this.asI != null) {
                        this.asI.a(true, null, null, aEl, null);
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    if (i == 12010) {
                        G(intent);
                        return;
                    }
                    return;
                case 12012:
                    H(intent);
                    if (b.BV().getStatus() == 1 && BY() != null) {
                        BY().fg(this.asE.getPageContext().getString(n.i.show_pic_tip));
                        return;
                    }
                    return;
                case 12013:
                    I(intent);
                    return;
                case 13010:
                    if (Bu() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            av avVar = new av("c10068");
                            avVar.r("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(avVar);
                            Cn();
                            Bu().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            Bu().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                Ch();
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

    public void Cb() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.asE.getActivity())));
    }

    public void Cc() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.asE.getActivity())) {
            this.asE.showToast(n.i.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.m411getInst().getLocationShared()) {
            Cd();
        } else if (this.asy.aDO()) {
            Cb();
        } else {
            this.asy.hm(false);
            a(1, true, (String) null);
            this.asy.aDM();
        }
    }

    private void Cd() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.asE.getActivity());
        aVar.bN(n.i.location_app_permission_prompt).a(n.i.isopen, new j(this)).b(n.i.cancel, new k(this)).b(this.asE.getPageContext());
        aVar.tv();
    }

    public void Ce() {
        if (this.asy.aDQ()) {
            if (this.asy.aDO()) {
                this.asN.a(com.baidu.tieba.tbadkCore.location.c.aDJ().getLocationData());
                return;
            }
            if (com.baidu.adp.lib.util.k.jg()) {
                this.asy.aDM();
            }
            a(0, true, (String) null);
            return;
        }
        a(0, false, (String) null);
    }

    public boolean Cf() {
        if (StringUtils.isNull(this.asu)) {
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() <= 0) {
                if (this.baobaoImagesInfo == null || this.baobaoImagesInfo.size() <= 0) {
                    if (this.asv == null || StringUtils.isNull(this.asv.getId())) {
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
        this.asz.c((WriteData) null);
        this.asz.hn(false);
        this.asv = null;
        this.mVideoInfo = null;
        this.baobaoImagesInfo.clear();
        this.writeImagesInfo.clear();
        this.asw.setIsBaobao(false);
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void Cg() {
        this.mVideoInfo = null;
    }

    private void G(Intent intent) {
        this.asx = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.asx;
        if (!TextUtils.isEmpty(str)) {
            try {
                int cK = com.baidu.tbadk.core.util.c.cK(str);
                if (cK != 0) {
                    Bitmap b = com.baidu.tbadk.core.util.c.b(str, com.baidu.adp.lib.util.k.dip2px(this.asE.getActivity(), com.baidu.adp.lib.util.k.K(this.asE.getActivity())), com.baidu.adp.lib.util.k.dip2px(this.asE.getActivity(), com.baidu.adp.lib.util.k.L(this.asE.getActivity())));
                    Bitmap i = com.baidu.tbadk.core.util.c.i(b, cK);
                    if (b != i) {
                        b.recycle();
                    }
                    com.baidu.tbadk.core.util.n.a(TbConfig.LOCAL_CAMERA_DIR, this.asx, i, 100);
                    i.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            Co();
        }
    }

    private void H(Intent intent) {
        a(intent, false);
    }

    private void a(Intent intent, boolean z) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                Co();
            }
        }
    }

    private void I(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("key_bitmap_path");
            String stringExtra2 = intent.getStringExtra("key_content");
            if (stringExtra != null && stringExtra2 != null) {
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(stringExtra);
                this.baobaoImagesInfo.clear();
                this.baobaoImagesInfo.addChooseFile(imageFileInfo);
                Cq();
                if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
                    this.asw.setIsBaobao(true);
                    this.asw.setBaobaoContent(stringExtra2);
                    this.asw.setBaobaoImagesInfo(this.baobaoImagesInfo);
                    return;
                }
                this.asw.setIsBaobao(false);
                this.asw.setBaobaoContent("");
                this.asw.setBaobaoImagesInfo(this.baobaoImagesInfo);
            }
        }
    }

    private void Ch() {
        new l(this).execute(new Void[0]);
    }

    private void J(Intent intent) {
        a(intent, true);
    }

    private void K(Intent intent) {
        int size;
        int size2;
        G(intent);
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() - 1 > -1 && this.writeImagesInfo.getChosedFiles() != null && (size2 = this.writeImagesInfo.getChosedFiles().size()) >= 1 && size >= 0 && size < size2) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.asE.getActivity(), 12012, this.writeImagesInfo, size)));
        }
    }

    public void fo(String str) {
        WriteData aEl = this.asz.aEl();
        if (aEl == null) {
            aEl = new WriteData(1);
            aEl.setThreadId(str);
            aEl.setWriteImagesInfo(this.writeImagesInfo);
        }
        aEl.setContent(this.asu);
        if (this.asw != null && this.asw.getIsBaobao()) {
            aEl.setBaobaoContent(this.asw.getBaobaoContent());
            aEl.setBaobaoImagesInfo(this.baobaoImagesInfo);
            aEl.setIsBaobao(true);
        }
        aEl.setVideoInfo(this.mVideoInfo);
        ae.c(str, aEl);
    }

    public void fp(String str) {
        ae.a(str, this);
    }

    @Override // com.baidu.tieba.tbadkCore.ae.a
    public void a(WriteData writeData) {
        if (writeData != null) {
            if (!ax.isEmpty(writeData.getContent()) && ax.isEmpty(this.asu)) {
                this.asu = writeData.getContent();
                fr(this.asu);
            }
            if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                if (this.mVideoInfo == null) {
                    this.mVideoInfo = new VideoInfo();
                }
                this.mVideoInfo.copy(writeData.getVideoInfo());
                Cn();
                Bu().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                bo(false);
            }
            if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen() && writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                this.asw.setIsBaobao(writeData.getIsBaobao());
                this.asw.setBaobaoContent(writeData.getBaobaoContent());
                this.asw.setBaobaoImagesInfo(this.baobaoImagesInfo);
                Cq();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.asz.cancelLoadData();
        this.asA.cancelLoadData();
        this.asy.cancelLoadData();
    }

    public void Ci() {
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        this.asz = new com.baidu.tieba.tbadkCore.writeModel.a(baseActivity);
        this.asz.b(this.asP);
        this.asA = new d(baseActivity);
        this.asA.setLoadDataCallBack(this.asQ);
        this.asy = new com.baidu.tieba.tbadkCore.location.d(baseActivity);
        this.asy.a(this.asN);
        this.asy.a(this.asO);
        if (bundle != null) {
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.asx = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        this.writeImagesInfo.setMaxImagesAllowed(10);
        if (!StringUtils.isNull(TbadkCoreApplication.m411getInst().getDefaultBubble()) && Bu() != null) {
            Bu().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.asy.aDQ() && Bu() != null) {
            Bu().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.asx);
    }

    public void a(String str, WriteData writeData) {
        if (this.asz.aEl() == null) {
            this.asz.c(this.asB.fl(str));
        }
        if (this.asz.aEl() != null) {
            if (this.asC != null) {
                if ((AntiHelper.d(this.asC) || AntiHelper.e(this.asC) || AntiHelper.f(this.asC)) && this.asD != null && this.mUserData != null) {
                    this.asC.setBlock_forum_name(this.asD.getName());
                    this.asC.setBlock_forum_id(this.asD.getId());
                    this.asC.setUser_name(this.mUserData.getUserName());
                    this.asC.setUser_id(this.mUserData.getUserId());
                    if (AntiHelper.a(this.asE.getPageContext().getPageActivity(), this.asC, AntiHelper.OperationType.CREATE_THREAD, PageType.PB)) {
                        return;
                    }
                }
                if (this.asC != null && this.asC.getIfpost() == 0 && !TextUtils.isEmpty(this.asC.getForbid_info())) {
                    com.baidu.adp.lib.util.k.showToast(this.asE.getPageContext().getPageActivity(), this.asC.getForbid_info());
                    return;
                }
            }
            this.asz.aEl().setWriteImagesInfo(this.writeImagesInfo);
            this.asz.aEl().setVideoInfo(this.mVideoInfo);
            this.asz.hn(this.writeImagesInfo.size() > 0);
            if (this.asw.getIsBaobao()) {
                this.asz.aEl().setIsBaobao(true);
                this.asz.aEl().setBaobaoContent(this.asw.getBaobaoContent());
                this.asz.aEl().setBaobaoImagesInfo(this.baobaoImagesInfo);
            } else {
                this.asz.aEl().setIsBaobao(false);
            }
            this.asz.aEl().setHasLocationData(this.asy != null ? this.asy.aDQ() : false);
            if (str == null) {
                this.asz.aEl().setContent(this.asu);
            }
            if (this.asv != null) {
                if (this.asv.getId() != null) {
                    this.asz.aEl().setVoice(this.asv.getId());
                    this.asz.aEl().setVoiceDuringTime(this.asv.duration);
                } else {
                    this.asz.aEl().setVoice(null);
                    this.asz.aEl().setVoiceDuringTime(-1);
                }
            } else {
                this.asz.aEl().setVoice(null);
                this.asz.aEl().setVoiceDuringTime(-1);
            }
            if (!this.asz.aEp()) {
                this.asE.showToast(n.i.write_img_limit);
                return;
            }
            if (this.asJ != null) {
                this.asJ.BW();
            }
            if (!this.asz.aEm()) {
            }
        }
    }

    public BaseActivity<?> Cj() {
        return this.asE;
    }

    public WriteImagesInfo getBaobaoImagesInfo() {
        return this.baobaoImagesInfo;
    }

    public void fq(String str) {
        this.asu = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.asv = voiceModel;
    }

    public WriteData Ck() {
        return this.asw;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int Cl() {
        return this.asH;
    }

    private void Cm() {
        if (Bu() != null) {
            Bu().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void r(ArrayList<String> arrayList) {
        if (Bu() != null) {
            Bu().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    private void Cn() {
        if (Bu() != null) {
            Bu().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    protected void bo(boolean z) {
        if (Bu() != null) {
            if (z) {
                Bu().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            Bu().b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                Bu().b(new com.baidu.tbadk.editortools.a(2, 10, new StringBuilder(String.valueOf(this.writeImagesInfo.getChosedFiles().size())).toString()));
            } else {
                Bu().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
        }
    }

    protected void Co() {
        bo(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Cp() {
        if (Bu() != null) {
            Bu().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    protected void Cq() {
        if (Bu() != null) {
            Bu().b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            Bu().b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
                Bu().b(new com.baidu.tbadk.editortools.a(2, 13, " "));
            } else {
                Bu().b(new com.baidu.tbadk.editortools.a(2, 13, null));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Cr() {
        if (Bu() != null) {
            Bu().b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.asH = i;
        if (Bu() != null) {
            Bu().b(new com.baidu.tbadk.editortools.a(19, 8, new com.baidu.tbadk.editortools.c.a(i, z, str)));
            if (i == 2) {
                Bu().b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            } else {
                Bu().b(new com.baidu.tbadk.editortools.a(2, 7, null));
            }
        }
    }

    private void fr(String str) {
        if (Bu() != null) {
            Bu().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bp(boolean z) {
        if (Bu() != null) {
            Bu().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void Cs() {
        bp(true);
    }

    public void a(a.d dVar) {
        this.asI = dVar;
    }

    public void a(c cVar) {
        this.asJ = cVar;
    }

    public void Ct() {
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            this.writeImagesInfo.clear();
        }
        Co();
        if (this.baobaoImagesInfo != null && this.baobaoImagesInfo.size() > 0) {
            this.baobaoImagesInfo.clear();
        }
        Cq();
        if (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) {
            this.mVideoInfo = null;
        }
        Bu().b(new com.baidu.tbadk.editortools.a(2, 19, null));
        setVoiceModel(null);
        Bu().b(new com.baidu.tbadk.editortools.a(2, 6, null));
        Bu().b(new com.baidu.tbadk.editortools.a(33, 6, null));
        if (!StringUtils.isNull(this.asu)) {
            this.asu = "";
        }
        fr("");
        this.asz.c((WriteData) null);
        this.asz.hn(false);
    }

    public void es(int i) {
        if (this.asL == null && Bu() != null) {
            this.asL = (com.baidu.tbadk.editortools.inputtool.a) Bu().ei(3);
        }
        if (this.asL != null && (this.asL.toolView instanceof EditText)) {
            this.asL.b(new m(this, i, (EditText) this.asL.toolView));
        }
    }

    public void Cu() {
        if (this.asL != null) {
            this.asL.b(null);
        }
    }
}
