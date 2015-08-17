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
import com.baidu.tieba.tbadkCore.ac;
import com.baidu.tieba.tbadkCore.location.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.a;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d extends com.baidu.tbadk.editortools.f implements ac.a {
    private String arJ;
    private VoiceData.VoiceModel arK;
    private WriteData arL;
    private String arM;
    private com.baidu.tieba.tbadkCore.location.d arN;
    private com.baidu.tieba.tbadkCore.writeModel.a arO;
    private c arP;
    private a<?> arQ;
    private AntiData arR;
    private ForumData arS;
    private BaseActivity<?> arT;
    private String arU;
    private boolean arV;
    private int arW;
    private VideoInfo arX;
    private a.d arY;
    private b arZ;
    private d.a asa;
    private d.b asb;
    private final a.d asc;
    private final com.baidu.adp.base.g asd;
    private WriteImagesInfo baobaoImagesInfo;
    private String mThreadId;
    private UserData mUserData;
    private WriteImagesInfo writeImagesInfo;

    public d(com.baidu.tbadk.editortools.j jVar) {
        super(jVar);
        this.writeImagesInfo = new WriteImagesInfo();
        this.baobaoImagesInfo = new WriteImagesInfo();
        this.arJ = "";
        this.arL = new WriteData();
        this.arO = null;
        this.arP = null;
        this.mThreadId = null;
        this.arU = null;
        this.arV = true;
        this.arW = 0;
        this.asa = new e(this);
        this.asb = new f(this);
        this.asc = new g(this);
        this.asd = new h(this);
    }

    public void a(a<?> aVar) {
        this.arQ = aVar;
    }

    public void b(BaseActivity<?> baseActivity) {
        this.arT = baseActivity;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.arV = antiData.isIfvoice();
            this.arU = antiData.getVoice_message();
        }
        this.arR = antiData;
    }

    public void a(ForumData forumData, UserData userData) {
        this.arS = forumData;
        this.mUserData = userData;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 11001:
                    a((String) null, (WriteData) null);
                    return;
                case 11025:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.arT.getActivity(), 12004, true)));
                    return;
                case 11026:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.arT.getActivity(), 12005, true)));
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
                            By();
                            this.arO.fB(false);
                            return;
                        }
                        this.arP.eJ(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case 12004:
                    ArrayList<String> R = com.baidu.tieba.tbadkCore.util.j.R(intent);
                    if (R != null) {
                        r(R);
                        return;
                    }
                    return;
                case 12006:
                    WriteData ard = this.arO.ard();
                    if (ard != null) {
                        ard.deleteUploadedTempImages();
                    }
                    this.arL.setIsBaobao(false);
                    this.arL.setBaobaoContent(null);
                    this.baobaoImagesInfo.clear();
                    this.arO.c((WriteData) null);
                    this.arO.fB(false);
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        ac.c(this.mThreadId, (WriteData) null);
                    }
                    bb(true);
                    if (this.arY != null) {
                        this.arY.a(true, null, null, ard, null);
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
                    if (Ay() != null) {
                        if (this.arX == null) {
                            this.arX = new VideoInfo();
                        }
                        this.arX.parseIntent(intent);
                        ao aoVar = new ao("c10068");
                        aoVar.r("duration", this.arX.getDuration());
                        TiebaStatic.log(aoVar);
                        Bz();
                        Ay().b(new com.baidu.tbadk.editortools.a(28, 20, this.arX));
                        Ay().b(new com.baidu.tbadk.editortools.a(28, -1, this.arX));
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
                Bt();
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

    public void Bn() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.arT.getActivity())));
    }

    public void Bo() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.arT.getActivity())) {
            this.arT.showToast(i.C0057i.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.m411getInst().getLocationShared()) {
            Bp();
        } else if (this.arN.aqH()) {
            Bn();
        } else {
            this.arN.fA(false);
            a(1, true, null);
            this.arN.aqF();
        }
    }

    private void Bp() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.arT.getActivity());
        aVar.bC(i.C0057i.location_app_permission_prompt).a(i.C0057i.isopen, new i(this)).b(i.C0057i.cancel, new j(this)).b(this.arT.getPageContext());
        aVar.sP();
    }

    public void Bq() {
        if (this.arN.aqJ()) {
            if (this.arN.aqH()) {
                this.asa.a(com.baidu.tieba.tbadkCore.location.c.aqC().getLocationData());
                return;
            }
            if (com.baidu.adp.lib.util.k.jf()) {
                this.arN.aqF();
            }
            a(0, true, null);
            return;
        }
        a(0, false, null);
    }

    public boolean Br() {
        if (StringUtils.isNull(this.arJ)) {
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() <= 0) {
                if (this.baobaoImagesInfo == null || this.baobaoImagesInfo.size() <= 0) {
                    return (this.arK == null || StringUtils.isNull(this.arK.getId())) ? false : true;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    public VideoInfo getVideoInfo() {
        return this.arX;
    }

    public void Bs() {
        this.arX = null;
    }

    private void H(Intent intent) {
        this.arM = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.arM;
        if (!TextUtils.isEmpty(str)) {
            try {
                int cv = com.baidu.tbadk.core.util.c.cv(str);
                if (cv != 0) {
                    Bitmap b = com.baidu.tbadk.core.util.c.b(str, com.baidu.adp.lib.util.k.dip2px(this.arT.getActivity(), com.baidu.adp.lib.util.k.K(this.arT.getActivity())), com.baidu.adp.lib.util.k.dip2px(this.arT.getActivity(), com.baidu.adp.lib.util.k.L(this.arT.getActivity())));
                    Bitmap i = com.baidu.tbadk.core.util.c.i(b, cv);
                    if (b != i) {
                        b.recycle();
                    }
                    com.baidu.tbadk.core.util.n.a(TbConfig.LOCAL_CAMERA_DIR, this.arM, i, 100);
                    i.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            BA();
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
                BA();
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
                BC();
                if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
                    this.arL.setIsBaobao(true);
                    this.arL.setBaobaoContent(stringExtra2);
                    this.arL.setBaobaoImagesInfo(this.baobaoImagesInfo);
                    return;
                }
                this.arL.setIsBaobao(false);
                this.arL.setBaobaoContent("");
                this.arL.setBaobaoImagesInfo(this.baobaoImagesInfo);
            }
        }
    }

    private void Bt() {
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
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.arT.getActivity(), 12012, this.writeImagesInfo, size)));
        }
    }

    public void eK(String str) {
        WriteData ard = this.arO.ard();
        if (ard == null) {
            ard = new WriteData(1);
            ard.setThreadId(str);
            ard.setWriteImagesInfo(this.writeImagesInfo);
        }
        ard.setContent(this.arJ);
        if (this.arL != null && this.arL.getIsBaobao()) {
            ard.setBaobaoContent(this.arL.getBaobaoContent());
            ard.setBaobaoImagesInfo(this.baobaoImagesInfo);
            ard.setIsBaobao(true);
        }
        ard.setVideoInfo(this.arX);
        ac.c(str, ard);
    }

    public void eL(String str) {
        ac.a(str, this);
    }

    @Override // com.baidu.tieba.tbadkCore.ac.a
    public void a(WriteData writeData) {
        if (writeData != null) {
            if (!aq.isEmpty(writeData.getContent()) && aq.isEmpty(this.arJ)) {
                this.arJ = writeData.getContent();
                eN(this.arJ);
            }
            if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                if (this.arX == null) {
                    this.arX = new VideoInfo();
                }
                this.arX.copy(writeData.getVideoInfo());
                Bz();
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                BA();
            }
            if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen() && writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                this.arL.setIsBaobao(writeData.getIsBaobao());
                this.arL.setBaobaoContent(writeData.getBaobaoContent());
                this.arL.setBaobaoImagesInfo(this.baobaoImagesInfo);
                BC();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.arO.cancelLoadData();
        this.arP.cancelLoadData();
        this.arN.cancelLoadData();
    }

    public void Bu() {
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        this.arO = new com.baidu.tieba.tbadkCore.writeModel.a(baseActivity);
        this.arO.b(this.asc);
        this.arP = new c(baseActivity);
        this.arP.setLoadDataCallBack(this.asd);
        this.arN = new com.baidu.tieba.tbadkCore.location.d(baseActivity);
        this.arN.a(this.asa);
        this.arN.a(this.asb);
        if (bundle != null) {
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.arM = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        this.writeImagesInfo.setMaxImagesAllowed(10);
        if (!StringUtils.isNull(TbadkCoreApplication.m411getInst().getDefaultBubble()) && Ay() != null) {
            Ay().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.arN.aqJ() && Ay() != null) {
            Ay().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.arM);
    }

    public void a(String str, WriteData writeData) {
        if (this.arO.ard() == null) {
            this.arO.c(this.arQ.eI(str));
        }
        if (this.arO.ard() != null) {
            if (this.arR != null) {
                if ((AntiHelper.d(this.arR) || AntiHelper.e(this.arR) || AntiHelper.f(this.arR)) && this.arS != null && this.mUserData != null) {
                    this.arR.setBlock_forum_name(this.arS.getName());
                    this.arR.setBlock_forum_id(this.arS.getId());
                    this.arR.setUser_name(this.mUserData.getUserName());
                    this.arR.setUser_id(this.mUserData.getUserId());
                    if (AntiHelper.a(this.arT.getPageContext().getPageActivity(), this.arR, AntiHelper.OperationType.CREATE_THREAD, PageType.PB)) {
                        return;
                    }
                }
                if (this.arR != null && this.arR.getIfpost() == 0 && !TextUtils.isEmpty(this.arR.getForbid_info())) {
                    com.baidu.adp.lib.util.k.showToast(this.arT.getPageContext().getPageActivity(), this.arR.getForbid_info());
                    return;
                }
            }
            this.arO.ard().setWriteImagesInfo(this.writeImagesInfo);
            this.arO.ard().setVideoInfo(this.arX);
            this.arO.fB(this.writeImagesInfo.size() > 0);
            if (this.arL.getIsBaobao()) {
                this.arO.ard().setIsBaobao(true);
                this.arO.ard().setBaobaoContent(this.arL.getBaobaoContent());
                this.arO.ard().setBaobaoImagesInfo(this.baobaoImagesInfo);
            } else {
                this.arO.ard().setIsBaobao(false);
            }
            this.arO.ard().setHasLocationData(this.arN != null ? this.arN.aqJ() : false);
            if (str == null) {
                this.arO.ard().setContent(this.arJ);
            }
            if (this.arK != null) {
                if (this.arK.getId() != null) {
                    this.arO.ard().setVoice(this.arK.getId());
                    this.arO.ard().setVoiceDuringTime(this.arK.duration);
                } else {
                    this.arO.ard().setVoice(null);
                    this.arO.ard().setVoiceDuringTime(-1);
                }
            } else {
                this.arO.ard().setVoice(null);
                this.arO.ard().setVoiceDuringTime(-1);
            }
            if (!this.arO.arg()) {
                this.arT.showToast(i.C0057i.write_img_limit);
                return;
            }
            if (this.arZ != null) {
                this.arZ.Bm();
            }
            if (!this.arO.are()) {
            }
        }
    }

    public BaseActivity<?> Bv() {
        return this.arT;
    }

    public WriteImagesInfo getBaobaoImagesInfo() {
        return this.baobaoImagesInfo;
    }

    public void eM(String str) {
        this.arJ = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.arK = voiceModel;
    }

    public WriteData Bw() {
        return this.arL;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int Bx() {
        return this.arW;
    }

    private void By() {
        if (Ay() != null) {
            Ay().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void r(ArrayList<String> arrayList) {
        if (Ay() != null) {
            Ay().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    private void Bz() {
        if (Ay() != null) {
            Ay().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    protected void BA() {
        if (Ay() != null) {
            Ay().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            Ay().b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                Ay().b(new com.baidu.tbadk.editortools.a(2, 10, new StringBuilder(String.valueOf(this.writeImagesInfo.getChosedFiles().size())).toString()));
            } else {
                Ay().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void BB() {
        if (Ay() != null) {
            Ay().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    protected void BC() {
        if (Ay() != null) {
            Ay().b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            Ay().b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
                Ay().b(new com.baidu.tbadk.editortools.a(2, 13, " "));
            } else {
                Ay().b(new com.baidu.tbadk.editortools.a(2, 13, null));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void BD() {
        if (Ay() != null) {
            Ay().b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.arW = i;
        if (Ay() != null) {
            Ay().b(new com.baidu.tbadk.editortools.a(19, 8, new com.baidu.tbadk.editortools.locationtool.a(i, z, str)));
            if (i == 2) {
                Ay().b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            } else {
                Ay().b(new com.baidu.tbadk.editortools.a(2, 7, null));
            }
        }
    }

    private void eN(String str) {
        if (Ay() != null) {
            Ay().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb(boolean z) {
        if (Ay() != null) {
            Ay().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void BE() {
        bb(true);
    }

    public void a(a.d dVar) {
        this.arY = dVar;
    }

    public void a(b bVar) {
        this.arZ = bVar;
    }
}
