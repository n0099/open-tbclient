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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
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
    private String arQ;
    private VoiceData.VoiceModel arR;
    private WriteData arS;
    private String arT;
    private com.baidu.tieba.tbadkCore.location.d arU;
    private com.baidu.tieba.tbadkCore.writeModel.a arV;
    private c arW;
    private a<?> arX;
    private AntiData arY;
    private ForumData arZ;
    private BaseActivity<?> asa;
    private String asb;
    private boolean asc;
    private int asd;
    private VideoInfo ase;
    private a.d asf;
    private b asg;
    private d.a ash;
    private d.b asi;
    private final a.d asj;
    private final com.baidu.adp.base.g ask;
    private WriteImagesInfo baobaoImagesInfo;
    private String mThreadId;
    private UserData mUserData;
    private WriteImagesInfo writeImagesInfo;

    public d(com.baidu.tbadk.editortools.j jVar) {
        super(jVar);
        this.writeImagesInfo = new WriteImagesInfo();
        this.baobaoImagesInfo = new WriteImagesInfo();
        this.arQ = "";
        this.arS = new WriteData();
        this.arV = null;
        this.arW = null;
        this.mThreadId = null;
        this.asb = null;
        this.asc = true;
        this.asd = 0;
        this.ash = new e(this);
        this.asi = new f(this);
        this.asj = new g(this);
        this.ask = new h(this);
    }

    public void a(a<?> aVar) {
        this.arX = aVar;
    }

    public void b(BaseActivity<?> baseActivity) {
        this.asa = baseActivity;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.asc = antiData.isIfvoice();
            this.asb = antiData.getVoice_message();
        }
        this.arY = antiData;
    }

    public void a(ForumData forumData, UserData userData) {
        this.arZ = forumData;
        this.mUserData = userData;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 11001:
                    a((String) null, (WriteData) null);
                    return;
                case 11025:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.asa.getActivity(), 12004, true)));
                    return;
                case 11026:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.asa.getActivity(), 12005, true)));
                    return;
                case 12002:
                    if (intent != null) {
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            K(intent);
                            return;
                        } else {
                            J(intent);
                            return;
                        }
                    }
                    return;
                case 12003:
                    if (intent != null) {
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            By();
                            this.arV.gw(false);
                            return;
                        }
                        this.arW.eW(intent.getStringExtra("file_name"));
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
                    WriteData axE = this.arV.axE();
                    if (axE != null) {
                        axE.deleteUploadedTempImages();
                    }
                    this.arS.setIsBaobao(false);
                    this.arS.setBaobaoContent(null);
                    this.baobaoImagesInfo.clear();
                    this.arV.c((WriteData) null);
                    this.arV.gw(false);
                    this.arR = null;
                    this.ase = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        ad.c(this.mThreadId, (WriteData) null);
                    }
                    bg(true);
                    if (this.asf != null) {
                        this.asf.a(true, null, null, axE, null);
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
                    return;
                case 12013:
                    I(intent);
                    return;
                case 13010:
                    if (Ax() != null) {
                        if (this.ase == null) {
                            this.ase = new VideoInfo();
                        }
                        this.ase.parseIntent(intent);
                        ap apVar = new ap("c10068");
                        apVar.r("duration", this.ase.getDuration());
                        TiebaStatic.log(apVar);
                        Bz();
                        Ax().b(new com.baidu.tbadk.editortools.a(28, 20, this.ase));
                        Ax().b(new com.baidu.tbadk.editortools.a(28, -1, this.ase));
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
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.asa.getActivity())));
    }

    public void Bo() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.asa.getActivity())) {
            this.asa.showToast(i.h.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.m411getInst().getLocationShared()) {
            Bp();
        } else if (this.arU.axh()) {
            Bn();
        } else {
            this.arU.gv(false);
            a(1, true, null);
            this.arU.axf();
        }
    }

    private void Bp() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.asa.getActivity());
        aVar.bF(i.h.location_app_permission_prompt).a(i.h.isopen, new i(this)).b(i.h.cancel, new j(this)).b(this.asa.getPageContext());
        aVar.sR();
    }

    public void Bq() {
        if (this.arU.axj()) {
            if (this.arU.axh()) {
                this.ash.a(com.baidu.tieba.tbadkCore.location.c.axc().getLocationData());
                return;
            }
            if (com.baidu.adp.lib.util.k.jd()) {
                this.arU.axf();
            }
            a(0, true, null);
            return;
        }
        a(0, false, null);
    }

    public boolean Br() {
        if (StringUtils.isNull(this.arQ)) {
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() <= 0) {
                if (this.baobaoImagesInfo == null || this.baobaoImagesInfo.size() <= 0) {
                    if (this.arR == null || StringUtils.isNull(this.arR.getId())) {
                        return this.ase != null && this.ase.isAvaliable();
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
        this.arV.c((WriteData) null);
        this.arV.gw(false);
        this.arR = null;
        this.ase = null;
        this.baobaoImagesInfo.clear();
        this.writeImagesInfo.clear();
        this.arS.setIsBaobao(false);
    }

    public VideoInfo getVideoInfo() {
        return this.ase;
    }

    public void Bs() {
        this.ase = null;
    }

    private void G(Intent intent) {
        this.arT = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.arT;
        if (!TextUtils.isEmpty(str)) {
            try {
                int cB = com.baidu.tbadk.core.util.c.cB(str);
                if (cB != 0) {
                    Bitmap b = com.baidu.tbadk.core.util.c.b(str, com.baidu.adp.lib.util.k.dip2px(this.asa.getActivity(), com.baidu.adp.lib.util.k.K(this.asa.getActivity())), com.baidu.adp.lib.util.k.dip2px(this.asa.getActivity(), com.baidu.adp.lib.util.k.L(this.asa.getActivity())));
                    Bitmap i = com.baidu.tbadk.core.util.c.i(b, cB);
                    if (b != i) {
                        b.recycle();
                    }
                    com.baidu.tbadk.core.util.n.a(TbConfig.LOCAL_CAMERA_DIR, this.arT, i, 100);
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

    private void H(Intent intent) {
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

    private void I(Intent intent) {
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
                    this.arS.setIsBaobao(true);
                    this.arS.setBaobaoContent(stringExtra2);
                    this.arS.setBaobaoImagesInfo(this.baobaoImagesInfo);
                    return;
                }
                this.arS.setIsBaobao(false);
                this.arS.setBaobaoContent("");
                this.arS.setBaobaoImagesInfo(this.baobaoImagesInfo);
            }
        }
    }

    private void Bt() {
        new k(this).execute(new Void[0]);
    }

    private void J(Intent intent) {
        a(intent, true);
    }

    private void K(Intent intent) {
        int size;
        int size2;
        G(intent);
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() - 1 > -1 && this.writeImagesInfo.getChosedFiles() != null && (size2 = this.writeImagesInfo.getChosedFiles().size()) >= 1 && size >= 0 && size < size2) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.asa.getActivity(), 12012, this.writeImagesInfo, size)));
        }
    }

    public void eX(String str) {
        WriteData axE = this.arV.axE();
        if (axE == null) {
            axE = new WriteData(1);
            axE.setThreadId(str);
            axE.setWriteImagesInfo(this.writeImagesInfo);
        }
        axE.setContent(this.arQ);
        if (this.arS != null && this.arS.getIsBaobao()) {
            axE.setBaobaoContent(this.arS.getBaobaoContent());
            axE.setBaobaoImagesInfo(this.baobaoImagesInfo);
            axE.setIsBaobao(true);
        }
        axE.setVideoInfo(this.ase);
        ad.c(str, axE);
    }

    public void eY(String str) {
        ad.a(str, this);
    }

    @Override // com.baidu.tieba.tbadkCore.ad.a
    public void a(WriteData writeData) {
        if (writeData != null) {
            if (!ar.isEmpty(writeData.getContent()) && ar.isEmpty(this.arQ)) {
                this.arQ = writeData.getContent();
                fa(this.arQ);
            }
            if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                if (this.ase == null) {
                    this.ase = new VideoInfo();
                }
                this.ase.copy(writeData.getVideoInfo());
                Bz();
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                BA();
            }
            if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen() && writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                this.arS.setIsBaobao(writeData.getIsBaobao());
                this.arS.setBaobaoContent(writeData.getBaobaoContent());
                this.arS.setBaobaoImagesInfo(this.baobaoImagesInfo);
                BC();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.arV.cancelLoadData();
        this.arW.cancelLoadData();
        this.arU.cancelLoadData();
    }

    public void Bu() {
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        this.arV = new com.baidu.tieba.tbadkCore.writeModel.a(baseActivity);
        this.arV.b(this.asj);
        this.arW = new c(baseActivity);
        this.arW.setLoadDataCallBack(this.ask);
        this.arU = new com.baidu.tieba.tbadkCore.location.d(baseActivity);
        this.arU.a(this.ash);
        this.arU.a(this.asi);
        if (bundle != null) {
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.arT = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        this.writeImagesInfo.setMaxImagesAllowed(10);
        if (!StringUtils.isNull(TbadkCoreApplication.m411getInst().getDefaultBubble()) && Ax() != null) {
            Ax().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.arU.axj() && Ax() != null) {
            Ax().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.arT);
    }

    public void a(String str, WriteData writeData) {
        if (this.arV.axE() == null) {
            this.arV.c(this.arX.eV(str));
        }
        if (this.arV.axE() != null) {
            if (this.arY != null) {
                if ((AntiHelper.e(this.arY) || AntiHelper.f(this.arY) || AntiHelper.g(this.arY)) && this.arZ != null && this.mUserData != null) {
                    this.arY.setBlock_forum_name(this.arZ.getName());
                    this.arY.setBlock_forum_id(this.arZ.getId());
                    this.arY.setUser_name(this.mUserData.getUserName());
                    this.arY.setUser_id(this.mUserData.getUserId());
                    if (AntiHelper.a(this.asa.getPageContext().getPageActivity(), this.arY, AntiHelper.OperationType.CREATE_THREAD, PageType.PB)) {
                        return;
                    }
                }
                if (this.arY != null && this.arY.getIfpost() == 0 && !TextUtils.isEmpty(this.arY.getForbid_info())) {
                    com.baidu.adp.lib.util.k.showToast(this.asa.getPageContext().getPageActivity(), this.arY.getForbid_info());
                    return;
                }
            }
            this.arV.axE().setWriteImagesInfo(this.writeImagesInfo);
            this.arV.axE().setVideoInfo(this.ase);
            this.arV.gw(this.writeImagesInfo.size() > 0);
            if (this.arS.getIsBaobao()) {
                this.arV.axE().setIsBaobao(true);
                this.arV.axE().setBaobaoContent(this.arS.getBaobaoContent());
                this.arV.axE().setBaobaoImagesInfo(this.baobaoImagesInfo);
            } else {
                this.arV.axE().setIsBaobao(false);
            }
            this.arV.axE().setHasLocationData(this.arU != null ? this.arU.axj() : false);
            if (str == null) {
                this.arV.axE().setContent(this.arQ);
            }
            if (this.arR != null) {
                if (this.arR.getId() != null) {
                    this.arV.axE().setVoice(this.arR.getId());
                    this.arV.axE().setVoiceDuringTime(this.arR.duration);
                } else {
                    this.arV.axE().setVoice(null);
                    this.arV.axE().setVoiceDuringTime(-1);
                }
            } else {
                this.arV.axE().setVoice(null);
                this.arV.axE().setVoiceDuringTime(-1);
            }
            if (!this.arV.axI()) {
                this.asa.showToast(i.h.write_img_limit);
                return;
            }
            if (this.asg != null) {
                this.asg.Bm();
            }
            if (!this.arV.axF()) {
            }
        }
    }

    public BaseActivity<?> Bv() {
        return this.asa;
    }

    public WriteImagesInfo getBaobaoImagesInfo() {
        return this.baobaoImagesInfo;
    }

    public void eZ(String str) {
        this.arQ = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.arR = voiceModel;
    }

    public WriteData Bw() {
        return this.arS;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int Bx() {
        return this.asd;
    }

    private void By() {
        if (Ax() != null) {
            Ax().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void q(ArrayList<String> arrayList) {
        if (Ax() != null) {
            Ax().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    private void Bz() {
        if (Ax() != null) {
            Ax().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    protected void BA() {
        if (Ax() != null) {
            Ax().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            Ax().b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                Ax().b(new com.baidu.tbadk.editortools.a(2, 10, new StringBuilder(String.valueOf(this.writeImagesInfo.getChosedFiles().size())).toString()));
            } else {
                Ax().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void BB() {
        if (Ax() != null) {
            Ax().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    protected void BC() {
        if (Ax() != null) {
            Ax().b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            Ax().b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
            if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
                Ax().b(new com.baidu.tbadk.editortools.a(2, 13, " "));
            } else {
                Ax().b(new com.baidu.tbadk.editortools.a(2, 13, null));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void BD() {
        if (Ax() != null) {
            Ax().b(new com.baidu.tbadk.editortools.a(12, 14, new com.baidu.tbadk.editortools.imagetool.a(this.baobaoImagesInfo, false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.asd = i;
        if (Ax() != null) {
            Ax().b(new com.baidu.tbadk.editortools.a(19, 8, new com.baidu.tbadk.editortools.locationtool.a(i, z, str)));
            if (i == 2) {
                Ax().b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            } else {
                Ax().b(new com.baidu.tbadk.editortools.a(2, 7, null));
            }
        }
    }

    private void fa(String str) {
        if (Ax() != null) {
            Ax().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bg(boolean z) {
        if (Ax() != null) {
            Ax().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void BE() {
        bg(true);
    }

    public void a(a.d dVar) {
        this.asf = dVar;
    }

    public void a(b bVar) {
        this.asg = bVar;
    }
}
