package com.baidu.tbadk.editortools.c;

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
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.ad;
import com.baidu.tieba.tbadkCore.location.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.a;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.editortools.f implements ad.a {
    private BaseActivity<?> aqA;
    private String aqB;
    private boolean aqC;
    private int aqD;
    private VideoInfo aqE;
    private a.d aqF;
    private c aqG;
    private com.baidu.tbadk.editortools.imagetool.b aqH;
    private com.baidu.tbadk.editortools.inputtool.a aqI;
    private com.baidu.tbadk.editortools.sendtool.a aqJ;
    private d.a aqK;
    private d.b aqL;
    private final a.d aqM;
    private final com.baidu.adp.base.g aqN;
    private String aqq;
    private VoiceData.VoiceModel aqr;
    private WriteData aqs;
    private String aqt;
    private com.baidu.tieba.tbadkCore.location.d aqu;
    private com.baidu.tieba.tbadkCore.writeModel.a aqv;
    private d aqw;
    private a<?> aqx;
    private AntiData aqy;
    private ForumData aqz;
    private WriteImagesInfo baobaoImagesInfo;
    private String mThreadId;
    private UserData mUserData;
    private WriteImagesInfo writeImagesInfo;

    public e(com.baidu.tbadk.editortools.j jVar) {
        super(jVar);
        this.writeImagesInfo = new WriteImagesInfo();
        this.baobaoImagesInfo = new WriteImagesInfo();
        this.aqq = "";
        this.aqs = new WriteData();
        this.aqv = null;
        this.aqw = null;
        this.mThreadId = null;
        this.aqB = null;
        this.aqC = true;
        this.aqD = 0;
        this.aqK = new f(this);
        this.aqL = new g(this);
        this.aqM = new h(this);
        this.aqN = new i(this);
    }

    private com.baidu.tbadk.editortools.sendtool.a AY() {
        if (this.aqJ == null && Az() != null) {
            this.aqJ = (com.baidu.tbadk.editortools.sendtool.a) Az().dU(4);
        }
        return this.aqJ;
    }

    public void eb(int i) {
        if (this.aqJ == null && Az() != null) {
            this.aqJ = (com.baidu.tbadk.editortools.sendtool.a) Az().dU(4);
        }
        if (this.aqJ != null) {
            this.aqJ.setType(i);
        }
    }

    public void ec(int i) {
        if (this.aqJ == null && Az() != null) {
            this.aqJ = (com.baidu.tbadk.editortools.sendtool.a) Az().dU(4);
        }
        if (this.aqJ != null) {
            this.aqJ.ef(i);
        }
    }

    private com.baidu.tbadk.editortools.imagetool.b AZ() {
        if (this.aqH == null && Az() != null) {
            this.aqH = (com.baidu.tbadk.editortools.imagetool.b) Az().dU(11);
        }
        return this.aqH;
    }

    public void ed(int i) {
        if (this.aqH == null && Az() != null) {
            this.aqH = (com.baidu.tbadk.editortools.imagetool.b) Az().dU(11);
        }
        if (this.aqH != null) {
            this.aqH.ea(i);
        }
    }

    private com.baidu.tbadk.editortools.inputtool.a Ba() {
        if (this.aqI == null && Az() != null) {
            this.aqI = (com.baidu.tbadk.editortools.inputtool.a) Az().dU(3);
        }
        return this.aqI;
    }

    public void eY(String str) {
        if (this.aqI == null && Az() != null) {
            this.aqI = (com.baidu.tbadk.editortools.inputtool.a) Az().dU(3);
        }
        if (this.aqI != null) {
            this.aqI.eU(str);
        }
    }

    public void bg(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (Az() != null && (cVar = (com.baidu.tbadk.editortools.c) Az().dS(5)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bh(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (Az() != null && (cVar = (com.baidu.tbadk.editortools.c) Az().dS(22)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bi(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (Az() != null && (cVar = (com.baidu.tbadk.editortools.c) Az().dS(2)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void a(a<?> aVar) {
        this.aqx = aVar;
    }

    public void b(BaseActivity<?> baseActivity) {
        this.aqA = baseActivity;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.aqC = antiData.isIfvoice();
            this.aqB = antiData.getVoice_message();
        }
        this.aqy = antiData;
    }

    public void a(ForumData forumData, UserData userData) {
        this.aqz = forumData;
        this.mUserData = userData;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.tbadk.editortools.p pVar;
        com.baidu.tbadk.editortools.p pVar2;
        com.baidu.tbadk.editortools.p pVar3 = null;
        if (i2 == -1) {
            switch (i) {
                case 11001:
                    a((String) null, (WriteData) null);
                    return;
                case 11025:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.aqA.getActivity(), 12004, true)));
                    return;
                case 11026:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.aqA.getActivity(), 12005, true)));
                    return;
                case 12002:
                    if (intent != null) {
                        boolean booleanExtra = intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false);
                        if (b.AW().getStatus() == 1) {
                            if (AZ() != null) {
                                AZ().ea(1);
                            }
                            if (getWriteImagesInfo() != null) {
                                getWriteImagesInfo().setMaxImagesAllowed(1);
                            }
                        } else {
                            if (AZ() != null) {
                                AZ().ea(10);
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
                        if (Az() != null) {
                            pVar2 = Az().dS(2);
                            pVar = Az().dS(5);
                            pVar3 = Az().dS(22);
                        } else {
                            pVar = null;
                            pVar2 = null;
                        }
                        if (b.AW().getStatus() == 1) {
                            Bp();
                            if (Az() != null) {
                                Az().AH();
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL));
                            }
                            if (pVar2 != null) {
                                pVar2.hide();
                            }
                            if (pVar != null) {
                                pVar.hide();
                            }
                            if (pVar3 != null) {
                                pVar3.ox();
                            }
                            if (Ba() != null) {
                                Ba().eU(this.aqA.getPageContext().getString(i.h.add_picture_description));
                            }
                            if (AZ() != null) {
                                AZ().eS(this.aqA.getPageContext().getString(i.h.show_pic_tip));
                                AZ().eT(this.aqA.getPageContext().getString(i.h.show_pic_add_tip));
                            }
                            if (AY() != null) {
                                AY().setType(SendView.arg);
                                AY().ef(SendView.arg);
                            }
                        } else {
                            if (pVar2 != null) {
                                pVar2.ox();
                            }
                            if (pVar != null) {
                                pVar.ox();
                            }
                            if (pVar3 != null) {
                                pVar3.hide();
                            }
                            if (Ba() != null) {
                                Ba().eU(this.aqA.getPageContext().getString(i.h.pb_reply_hint));
                            }
                            if (AY() != null) {
                                AY().setType(SendView.ALL);
                                AY().ef(SendView.ALL);
                            }
                        }
                        Az().invalidate();
                        return;
                    }
                    return;
                case 12003:
                    if (intent != null) {
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            Bm();
                            this.aqv.gC(false);
                            return;
                        }
                        this.aqw.eX(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case 12004:
                    ArrayList<String> T = com.baidu.tieba.tbadkCore.util.l.T(intent);
                    if (T != null) {
                        q(T);
                        return;
                    }
                    return;
                case 12006:
                    WriteData ayT = this.aqv.ayT();
                    if (ayT != null) {
                        ayT.deleteUploadedTempImages();
                    }
                    this.aqs.setIsBaobao(false);
                    this.aqs.setBaobaoContent(null);
                    this.baobaoImagesInfo.clear();
                    this.aqv.c((WriteData) null);
                    this.aqv.gC(false);
                    this.aqr = null;
                    this.aqE = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        ad.c(this.mThreadId, (WriteData) null);
                    }
                    bj(true);
                    if (this.aqF != null) {
                        this.aqF.a(true, null, null, ayT, null);
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
                    if (b.AW().getStatus() == 1 && AZ() != null) {
                        AZ().eS(this.aqA.getPageContext().getString(i.h.show_pic_tip));
                        return;
                    }
                    return;
                case 12013:
                    I(intent);
                    return;
                case 13010:
                    if (Az() != null) {
                        if (this.aqE == null) {
                            this.aqE = new VideoInfo();
                        }
                        this.aqE.parseIntent(intent);
                        aq aqVar = new aq("c10068");
                        aqVar.r("duration", this.aqE.getDuration());
                        TiebaStatic.log(aqVar);
                        Bn();
                        Az().b(new com.baidu.tbadk.editortools.a(28, 20, this.aqE));
                        Az().b(new com.baidu.tbadk.editortools.a(28, -1, this.aqE));
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
                Bh();
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

    public void Bb() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.aqA.getActivity())));
    }

    public void Bc() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.aqA.getActivity())) {
            this.aqA.showToast(i.h.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.m411getInst().getLocationShared()) {
            Bd();
        } else if (this.aqu.ayw()) {
            Bb();
        } else {
            this.aqu.gB(false);
            a(1, true, null);
            this.aqu.ayu();
        }
    }

    private void Bd() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aqA.getActivity());
        aVar.bF(i.h.location_app_permission_prompt).a(i.h.isopen, new j(this)).b(i.h.cancel, new k(this)).b(this.aqA.getPageContext());
        aVar.sR();
    }

    public void Be() {
        if (this.aqu.ayy()) {
            if (this.aqu.ayw()) {
                this.aqK.a(com.baidu.tieba.tbadkCore.location.c.ayr().getLocationData());
                return;
            }
            if (com.baidu.adp.lib.util.k.je()) {
                this.aqu.ayu();
            }
            a(0, true, null);
            return;
        }
        a(0, false, null);
    }

    public boolean Bf() {
        if (StringUtils.isNull(this.aqq)) {
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() <= 0) {
                if (this.baobaoImagesInfo == null || this.baobaoImagesInfo.size() <= 0) {
                    if (this.aqr == null || StringUtils.isNull(this.aqr.getId())) {
                        return this.aqE != null && this.aqE.isAvaliable();
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
        this.aqv.c((WriteData) null);
        this.aqv.gC(false);
        this.aqr = null;
        this.aqE = null;
        this.baobaoImagesInfo.clear();
        this.writeImagesInfo.clear();
        this.aqs.setIsBaobao(false);
    }

    public VideoInfo getVideoInfo() {
        return this.aqE;
    }

    public void Bg() {
        this.aqE = null;
    }

    private void G(Intent intent) {
        this.aqt = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aqt;
        if (!TextUtils.isEmpty(str)) {
            try {
                int cC = com.baidu.tbadk.core.util.c.cC(str);
                if (cC != 0) {
                    Bitmap b = com.baidu.tbadk.core.util.c.b(str, com.baidu.adp.lib.util.k.dip2px(this.aqA.getActivity(), com.baidu.adp.lib.util.k.K(this.aqA.getActivity())), com.baidu.adp.lib.util.k.dip2px(this.aqA.getActivity(), com.baidu.adp.lib.util.k.L(this.aqA.getActivity())));
                    Bitmap i = com.baidu.tbadk.core.util.c.i(b, cC);
                    if (b != i) {
                        b.recycle();
                    }
                    com.baidu.tbadk.core.util.n.a(TbConfig.LOCAL_CAMERA_DIR, this.aqt, i, 100);
                    i.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            Bo();
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
                Bo();
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
                Bq();
                if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
                    this.aqs.setIsBaobao(true);
                    this.aqs.setBaobaoContent(stringExtra2);
                    this.aqs.setBaobaoImagesInfo(this.baobaoImagesInfo);
                    return;
                }
                this.aqs.setIsBaobao(false);
                this.aqs.setBaobaoContent("");
                this.aqs.setBaobaoImagesInfo(this.baobaoImagesInfo);
            }
        }
    }

    private void Bh() {
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
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.aqA.getActivity(), 12012, this.writeImagesInfo, size)));
        }
    }

    public void eZ(String str) {
        WriteData ayT = this.aqv.ayT();
        if (ayT == null) {
            ayT = new WriteData(1);
            ayT.setThreadId(str);
            ayT.setWriteImagesInfo(this.writeImagesInfo);
        }
        ayT.setContent(this.aqq);
        if (this.aqs != null && this.aqs.getIsBaobao()) {
            ayT.setBaobaoContent(this.aqs.getBaobaoContent());
            ayT.setBaobaoImagesInfo(this.baobaoImagesInfo);
            ayT.setIsBaobao(true);
        }
        ayT.setVideoInfo(this.aqE);
        ad.c(str, ayT);
    }

    public void fa(String str) {
        ad.a(str, this);
    }

    @Override // com.baidu.tieba.tbadkCore.ad.a
    public void a(WriteData writeData) {
        if (writeData != null) {
            if (!as.isEmpty(writeData.getContent()) && as.isEmpty(this.aqq)) {
                this.aqq = writeData.getContent();
                fc(this.aqq);
            }
            if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                if (this.aqE == null) {
                    this.aqE = new VideoInfo();
                }
                this.aqE.copy(writeData.getVideoInfo());
                Bn();
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                Bo();
            }
            if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen() && writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                this.aqs.setIsBaobao(writeData.getIsBaobao());
                this.aqs.setBaobaoContent(writeData.getBaobaoContent());
                this.aqs.setBaobaoImagesInfo(this.baobaoImagesInfo);
                Bq();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.aqv.cancelLoadData();
        this.aqw.cancelLoadData();
        this.aqu.cancelLoadData();
    }

    public void Bi() {
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        this.aqv = new com.baidu.tieba.tbadkCore.writeModel.a(baseActivity);
        this.aqv.b(this.aqM);
        this.aqw = new d(baseActivity);
        this.aqw.setLoadDataCallBack(this.aqN);
        this.aqu = new com.baidu.tieba.tbadkCore.location.d(baseActivity);
        this.aqu.a(this.aqK);
        this.aqu.a(this.aqL);
        if (bundle != null) {
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.aqt = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        this.writeImagesInfo.setMaxImagesAllowed(10);
        if (!StringUtils.isNull(TbadkCoreApplication.m411getInst().getDefaultBubble()) && Az() != null) {
            Az().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.aqu.ayy() && Az() != null) {
            Az().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aqt);
    }

    public void a(String str, WriteData writeData) {
        if (this.aqv.ayT() == null) {
            this.aqv.c(this.aqx.eW(str));
        }
        if (this.aqv.ayT() != null) {
            if (this.aqy != null) {
                if ((AntiHelper.e(this.aqy) || AntiHelper.f(this.aqy) || AntiHelper.g(this.aqy)) && this.aqz != null && this.mUserData != null) {
                    this.aqy.setBlock_forum_name(this.aqz.getName());
                    this.aqy.setBlock_forum_id(this.aqz.getId());
                    this.aqy.setUser_name(this.mUserData.getUserName());
                    this.aqy.setUser_id(this.mUserData.getUserId());
                    if (AntiHelper.a(this.aqA.getPageContext().getPageActivity(), this.aqy, AntiHelper.OperationType.CREATE_THREAD, PageType.PB)) {
                        return;
                    }
                }
                if (this.aqy != null && this.aqy.getIfpost() == 0 && !TextUtils.isEmpty(this.aqy.getForbid_info())) {
                    com.baidu.adp.lib.util.k.showToast(this.aqA.getPageContext().getPageActivity(), this.aqy.getForbid_info());
                    return;
                }
            }
            this.aqv.ayT().setWriteImagesInfo(this.writeImagesInfo);
            this.aqv.ayT().setVideoInfo(this.aqE);
            this.aqv.gC(this.writeImagesInfo.size() > 0);
            if (this.aqs.getIsBaobao()) {
                this.aqv.ayT().setIsBaobao(true);
                this.aqv.ayT().setBaobaoContent(this.aqs.getBaobaoContent());
                this.aqv.ayT().setBaobaoImagesInfo(this.baobaoImagesInfo);
            } else {
                this.aqv.ayT().setIsBaobao(false);
            }
            this.aqv.ayT().setHasLocationData(this.aqu != null ? this.aqu.ayy() : false);
            if (str == null) {
                this.aqv.ayT().setContent(this.aqq);
            }
            if (this.aqr != null) {
                if (this.aqr.getId() != null) {
                    this.aqv.ayT().setVoice(this.aqr.getId());
                    this.aqv.ayT().setVoiceDuringTime(this.aqr.duration);
                } else {
                    this.aqv.ayT().setVoice(null);
                    this.aqv.ayT().setVoiceDuringTime(-1);
                }
            } else {
                this.aqv.ayT().setVoice(null);
                this.aqv.ayT().setVoiceDuringTime(-1);
            }
            if (!this.aqv.ayX()) {
                this.aqA.showToast(i.h.write_img_limit);
                return;
            }
            if (this.aqG != null) {
                this.aqG.AX();
            }
            if (!this.aqv.ayU()) {
            }
        }
    }

    public BaseActivity<?> Bj() {
        return this.aqA;
    }

    public WriteImagesInfo getBaobaoImagesInfo() {
        return this.baobaoImagesInfo;
    }

    public void fb(String str) {
        this.aqq = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.aqr = voiceModel;
    }

    public WriteData Bk() {
        return this.aqs;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int Bl() {
        return this.aqD;
    }

    private void Bm() {
        if (Az() != null) {
            Az().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void q(ArrayList<String> arrayList) {
        if (Az() != null) {
            Az().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    private void Bn() {
        if (Az() != null) {
            Az().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    protected void Bo() {
        if (Az() != null) {
            Az().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            Az().b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                Az().b(new com.baidu.tbadk.editortools.a(2, 10, new StringBuilder(String.valueOf(this.writeImagesInfo.getChosedFiles().size())).toString()));
            } else {
                Az().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Bp() {
        if (Az() != null) {
            Az().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    protected void Bq() {
        if (Az() != null) {
            Az().b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            Az().b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
                Az().b(new com.baidu.tbadk.editortools.a(2, 13, " "));
            } else {
                Az().b(new com.baidu.tbadk.editortools.a(2, 13, null));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Br() {
        if (Az() != null) {
            Az().b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.aqD = i;
        if (Az() != null) {
            Az().b(new com.baidu.tbadk.editortools.a(19, 8, new com.baidu.tbadk.editortools.b.a(i, z, str)));
            if (i == 2) {
                Az().b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            } else {
                Az().b(new com.baidu.tbadk.editortools.a(2, 7, null));
            }
        }
    }

    private void fc(String str) {
        if (Az() != null) {
            Az().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bj(boolean z) {
        if (Az() != null) {
            Az().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void Bs() {
        bj(true);
    }

    public void a(a.d dVar) {
        this.aqF = dVar;
    }

    public void a(c cVar) {
        this.aqG = cVar;
    }

    public void Bt() {
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            this.writeImagesInfo.clear();
        }
        Bo();
        if (this.baobaoImagesInfo != null && this.baobaoImagesInfo.size() > 0) {
            this.baobaoImagesInfo.clear();
        }
        Bq();
        if (this.aqE != null && this.aqE.isAvaliable()) {
            this.aqE = null;
        }
        Az().b(new com.baidu.tbadk.editortools.a(2, 19, null));
        setVoiceModel(null);
        Az().b(new com.baidu.tbadk.editortools.a(2, 6, null));
        Az().b(new com.baidu.tbadk.editortools.a(33, 6, null));
        if (!StringUtils.isNull(this.aqq)) {
            this.aqq = "";
        }
        fc("");
        this.aqv.c((WriteData) null);
        this.aqv.gC(false);
    }

    public void ee(int i) {
        if (this.aqI == null && Az() != null) {
            this.aqI = (com.baidu.tbadk.editortools.inputtool.a) Az().dU(3);
        }
        if (this.aqI != null && (this.aqI.toolView instanceof EditText)) {
            this.aqI.b(new m(this, i, (EditText) this.aqI.toolView));
        }
    }

    public void Bu() {
        if (this.aqI != null) {
            this.aqI.b(null);
        }
    }
}
