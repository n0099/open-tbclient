package com.baidu.tbadk.editortools.c;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
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
public class d extends com.baidu.tbadk.editortools.f implements ad.a {
    private a<?> atA;
    private AntiData atB;
    private ForumData atC;
    private BaseActivity<?> atD;
    private String atE;
    private boolean atF;
    private int atG;
    private VideoInfo atH;
    private a.d atI;
    private b atJ;
    private d.a atK;
    private d.b atL;
    private final a.d atM;
    private final com.baidu.adp.base.g atN;
    private String att;
    private VoiceData.VoiceModel atu;
    private WriteData atv;
    private String atw;
    private com.baidu.tieba.tbadkCore.location.d atx;
    private com.baidu.tieba.tbadkCore.writeModel.a aty;
    private c atz;
    private WriteImagesInfo baobaoImagesInfo;
    private String mThreadId;
    private UserData mUserData;
    private WriteImagesInfo writeImagesInfo;

    public d(com.baidu.tbadk.editortools.j jVar) {
        super(jVar);
        this.writeImagesInfo = new WriteImagesInfo();
        this.baobaoImagesInfo = new WriteImagesInfo();
        this.att = "";
        this.atv = new WriteData();
        this.aty = null;
        this.atz = null;
        this.mThreadId = null;
        this.atE = null;
        this.atF = true;
        this.atG = 0;
        this.atK = new e(this);
        this.atL = new f(this);
        this.atM = new g(this);
        this.atN = new h(this);
    }

    public void a(a<?> aVar) {
        this.atA = aVar;
    }

    public void b(BaseActivity<?> baseActivity) {
        this.atD = baseActivity;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.atF = antiData.isIfvoice();
            this.atE = antiData.getVoice_message();
        }
        this.atB = antiData;
    }

    public void a(ForumData forumData, UserData userData) {
        this.atC = forumData;
        this.mUserData = userData;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 11001:
                    a((String) null, (WriteData) null);
                    return;
                case 11025:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.atD.getActivity(), 12004, true)));
                    return;
                case 11026:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.atD.getActivity(), 12005, true)));
                    return;
                case 12002:
                    if (intent != null) {
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            L(intent);
                            return;
                        } else {
                            K(intent);
                            return;
                        }
                    }
                    return;
                case 12003:
                    if (intent != null) {
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            BL();
                            this.aty.gm(false);
                            return;
                        }
                        this.atz.eR(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case 12004:
                    ArrayList<String> U = com.baidu.tieba.tbadkCore.util.j.U(intent);
                    if (U != null) {
                        q(U);
                        return;
                    }
                    return;
                case 12006:
                    WriteData avr = this.aty.avr();
                    if (avr != null) {
                        avr.deleteUploadedTempImages();
                    }
                    this.atv.setIsBaobao(false);
                    this.atv.setBaobaoContent(null);
                    this.baobaoImagesInfo.clear();
                    this.aty.c((WriteData) null);
                    this.aty.gm(false);
                    this.atu = null;
                    this.atH = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        ad.c(this.mThreadId, (WriteData) null);
                    }
                    bi(true);
                    if (this.atI != null) {
                        this.atI.a(true, null, null, avr, null);
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    if (i == 12010) {
                        H(intent);
                        return;
                    }
                    return;
                case 12012:
                    I(intent);
                    return;
                case 12013:
                    J(intent);
                    return;
                case 13010:
                    if (AL() != null) {
                        if (this.atH == null) {
                            this.atH = new VideoInfo();
                        }
                        this.atH.parseIntent(intent);
                        ao aoVar = new ao("c10068");
                        aoVar.r("duration", this.atH.getDuration());
                        TiebaStatic.log(aoVar);
                        BM();
                        AL().b(new com.baidu.tbadk.editortools.a(28, 20, this.atH));
                        AL().b(new com.baidu.tbadk.editortools.a(28, -1, this.atH));
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
                BG();
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

    public void BA() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.atD.getActivity())));
    }

    public void BB() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.atD.getActivity())) {
            this.atD.showToast(i.h.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.m411getInst().getLocationShared()) {
            BC();
        } else if (this.atx.auV()) {
            BA();
        } else {
            this.atx.gl(false);
            a(1, true, null);
            this.atx.auT();
        }
    }

    private void BC() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.atD.getActivity());
        aVar.bF(i.h.location_app_permission_prompt).a(i.h.isopen, new i(this)).b(i.h.cancel, new j(this)).b(this.atD.getPageContext());
        aVar.sU();
    }

    public void BD() {
        if (this.atx.auX()) {
            if (this.atx.auV()) {
                this.atK.a(com.baidu.tieba.tbadkCore.location.c.auQ().getLocationData());
                return;
            }
            if (com.baidu.adp.lib.util.k.jc()) {
                this.atx.auT();
            }
            a(0, true, null);
            return;
        }
        a(0, false, null);
    }

    public boolean BE() {
        if (StringUtils.isNull(this.att)) {
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() <= 0) {
                if (this.baobaoImagesInfo == null || this.baobaoImagesInfo.size() <= 0) {
                    if (this.atu == null || StringUtils.isNull(this.atu.getId())) {
                        return this.atH != null && this.atH.isAvaliable();
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
        this.aty.c((WriteData) null);
        this.aty.gm(false);
        this.atu = null;
        this.atH = null;
        this.baobaoImagesInfo.clear();
        this.atv.setIsBaobao(false);
    }

    public VideoInfo getVideoInfo() {
        return this.atH;
    }

    public void BF() {
        this.atH = null;
    }

    private void H(Intent intent) {
        this.atw = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.atw;
        if (!TextUtils.isEmpty(str)) {
            try {
                int cB = com.baidu.tbadk.core.util.c.cB(str);
                if (cB != 0) {
                    Bitmap b = com.baidu.tbadk.core.util.c.b(str, com.baidu.adp.lib.util.k.dip2px(this.atD.getActivity(), com.baidu.adp.lib.util.k.K(this.atD.getActivity())), com.baidu.adp.lib.util.k.dip2px(this.atD.getActivity(), com.baidu.adp.lib.util.k.L(this.atD.getActivity())));
                    Bitmap i = com.baidu.tbadk.core.util.c.i(b, cB);
                    if (b != i) {
                        b.recycle();
                    }
                    com.baidu.tbadk.core.util.n.a(TbConfig.LOCAL_CAMERA_DIR, this.atw, i, 100);
                    i.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            BN();
        }
    }

    private void I(Intent intent) {
        a(intent, false);
    }

    private void a(Intent intent, boolean z) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                BN();
            }
        }
    }

    private void J(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("key_bitmap_path");
            String stringExtra2 = intent.getStringExtra("key_content");
            if (stringExtra != null && stringExtra2 != null) {
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(stringExtra);
                this.baobaoImagesInfo.clear();
                this.baobaoImagesInfo.addChooseFile(imageFileInfo);
                BP();
                if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
                    this.atv.setIsBaobao(true);
                    this.atv.setBaobaoContent(stringExtra2);
                    this.atv.setBaobaoImagesInfo(this.baobaoImagesInfo);
                    return;
                }
                this.atv.setIsBaobao(false);
                this.atv.setBaobaoContent("");
                this.atv.setBaobaoImagesInfo(this.baobaoImagesInfo);
            }
        }
    }

    private void BG() {
        new k(this).execute(new Void[0]);
    }

    private void K(Intent intent) {
        a(intent, true);
    }

    private void L(Intent intent) {
        int size;
        int size2;
        H(intent);
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() - 1 > -1 && this.writeImagesInfo.getChosedFiles() != null && (size2 = this.writeImagesInfo.getChosedFiles().size()) >= 1 && size >= 0 && size < size2) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.atD.getActivity(), 12012, this.writeImagesInfo, size)));
        }
    }

    public void eS(String str) {
        WriteData avr = this.aty.avr();
        if (avr == null) {
            avr = new WriteData(1);
            avr.setThreadId(str);
            avr.setWriteImagesInfo(this.writeImagesInfo);
        }
        avr.setContent(this.att);
        if (this.atv != null && this.atv.getIsBaobao()) {
            avr.setBaobaoContent(this.atv.getBaobaoContent());
            avr.setBaobaoImagesInfo(this.baobaoImagesInfo);
            avr.setIsBaobao(true);
        }
        avr.setVideoInfo(this.atH);
        ad.c(str, avr);
    }

    public void eT(String str) {
        ad.a(str, this);
    }

    @Override // com.baidu.tieba.tbadkCore.ad.a
    public void a(WriteData writeData) {
        if (writeData != null) {
            if (!aq.isEmpty(writeData.getContent()) && aq.isEmpty(this.att)) {
                this.att = writeData.getContent();
                eV(this.att);
            }
            if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                if (this.atH == null) {
                    this.atH = new VideoInfo();
                }
                this.atH.copy(writeData.getVideoInfo());
                BM();
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                BN();
            }
            if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen() && writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                this.atv.setIsBaobao(writeData.getIsBaobao());
                this.atv.setBaobaoContent(writeData.getBaobaoContent());
                this.atv.setBaobaoImagesInfo(this.baobaoImagesInfo);
                BP();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.aty.cancelLoadData();
        this.atz.cancelLoadData();
        this.atx.cancelLoadData();
    }

    public void BH() {
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        this.aty = new com.baidu.tieba.tbadkCore.writeModel.a(baseActivity);
        this.aty.b(this.atM);
        this.atz = new c(baseActivity);
        this.atz.setLoadDataCallBack(this.atN);
        this.atx = new com.baidu.tieba.tbadkCore.location.d(baseActivity);
        this.atx.a(this.atK);
        this.atx.a(this.atL);
        if (bundle != null) {
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.atw = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        this.writeImagesInfo.setMaxImagesAllowed(10);
        if (!StringUtils.isNull(TbadkCoreApplication.m411getInst().getDefaultBubble()) && AL() != null) {
            AL().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.atx.auX() && AL() != null) {
            AL().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.atw);
    }

    public void a(String str, WriteData writeData) {
        if (this.aty.avr() == null) {
            this.aty.c(this.atA.eQ(str));
        }
        if (this.aty.avr() != null) {
            if (this.atB != null) {
                if ((AntiHelper.d(this.atB) || AntiHelper.e(this.atB) || AntiHelper.f(this.atB)) && this.atC != null && this.mUserData != null) {
                    this.atB.setBlock_forum_name(this.atC.getName());
                    this.atB.setBlock_forum_id(this.atC.getId());
                    this.atB.setUser_name(this.mUserData.getUserName());
                    this.atB.setUser_id(this.mUserData.getUserId());
                    if (AntiHelper.a(this.atD.getPageContext().getPageActivity(), this.atB, AntiHelper.OperationType.CREATE_THREAD, PageType.PB)) {
                        return;
                    }
                }
                if (this.atB != null && this.atB.getIfpost() == 0 && !TextUtils.isEmpty(this.atB.getForbid_info())) {
                    com.baidu.adp.lib.util.k.showToast(this.atD.getPageContext().getPageActivity(), this.atB.getForbid_info());
                    return;
                }
            }
            this.aty.avr().setWriteImagesInfo(this.writeImagesInfo);
            this.aty.avr().setVideoInfo(this.atH);
            this.aty.gm(this.writeImagesInfo.size() > 0);
            if (this.atv.getIsBaobao()) {
                this.aty.avr().setIsBaobao(true);
                this.aty.avr().setBaobaoContent(this.atv.getBaobaoContent());
                this.aty.avr().setBaobaoImagesInfo(this.baobaoImagesInfo);
            } else {
                this.aty.avr().setIsBaobao(false);
            }
            this.aty.avr().setHasLocationData(this.atx != null ? this.atx.auX() : false);
            if (str == null) {
                this.aty.avr().setContent(this.att);
            }
            if (this.atu != null) {
                if (this.atu.getId() != null) {
                    this.aty.avr().setVoice(this.atu.getId());
                    this.aty.avr().setVoiceDuringTime(this.atu.duration);
                } else {
                    this.aty.avr().setVoice(null);
                    this.aty.avr().setVoiceDuringTime(-1);
                }
            } else {
                this.aty.avr().setVoice(null);
                this.aty.avr().setVoiceDuringTime(-1);
            }
            if (!this.aty.avu()) {
                this.atD.showToast(i.h.write_img_limit);
                return;
            }
            if (this.atJ != null) {
                this.atJ.Bz();
            }
            if (!this.aty.avs()) {
            }
        }
    }

    public BaseActivity<?> BI() {
        return this.atD;
    }

    public WriteImagesInfo getBaobaoImagesInfo() {
        return this.baobaoImagesInfo;
    }

    public void eU(String str) {
        this.att = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.atu = voiceModel;
    }

    public WriteData BJ() {
        return this.atv;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int BK() {
        return this.atG;
    }

    private void BL() {
        if (AL() != null) {
            AL().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void q(ArrayList<String> arrayList) {
        if (AL() != null) {
            AL().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    private void BM() {
        if (AL() != null) {
            AL().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    protected void BN() {
        if (AL() != null) {
            AL().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            AL().b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                AL().b(new com.baidu.tbadk.editortools.a(2, 10, new StringBuilder(String.valueOf(this.writeImagesInfo.getChosedFiles().size())).toString()));
            } else {
                AL().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void BO() {
        if (AL() != null) {
            AL().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    protected void BP() {
        if (AL() != null) {
            AL().b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            AL().b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
                AL().b(new com.baidu.tbadk.editortools.a(2, 13, " "));
            } else {
                AL().b(new com.baidu.tbadk.editortools.a(2, 13, null));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void BQ() {
        if (AL() != null) {
            AL().b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.atG = i;
        if (AL() != null) {
            AL().b(new com.baidu.tbadk.editortools.a(19, 8, new com.baidu.tbadk.editortools.locationtool.a(i, z, str)));
            if (i == 2) {
                AL().b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            } else {
                AL().b(new com.baidu.tbadk.editortools.a(2, 7, null));
            }
        }
    }

    private void eV(String str) {
        if (AL() != null) {
            AL().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bi(boolean z) {
        if (AL() != null) {
            AL().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void BR() {
        bi(true);
    }

    public void a(a.d dVar) {
        this.atI = dVar;
    }

    public void a(b bVar) {
        this.atJ = bVar;
    }
}
