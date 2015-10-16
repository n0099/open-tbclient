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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
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
    private String arR;
    private VoiceData.VoiceModel arS;
    private WriteData arT;
    private String arU;
    private com.baidu.tieba.tbadkCore.location.d arV;
    private com.baidu.tieba.tbadkCore.writeModel.a arW;
    private c arX;
    private a<?> arY;
    private AntiData arZ;
    private ForumData asa;
    private BaseActivity<?> asb;
    private String asc;
    private boolean asd;
    private int ase;
    private VideoInfo asf;
    private a.d asg;
    private b ash;
    private d.a asi;
    private d.b asj;
    private final a.d ask;
    private final com.baidu.adp.base.g asl;
    private WriteImagesInfo baobaoImagesInfo;
    private String mThreadId;
    private UserData mUserData;
    private WriteImagesInfo writeImagesInfo;

    public d(com.baidu.tbadk.editortools.j jVar) {
        super(jVar);
        this.writeImagesInfo = new WriteImagesInfo();
        this.baobaoImagesInfo = new WriteImagesInfo();
        this.arR = "";
        this.arT = new WriteData();
        this.arW = null;
        this.arX = null;
        this.mThreadId = null;
        this.asc = null;
        this.asd = true;
        this.ase = 0;
        this.asi = new e(this);
        this.asj = new f(this);
        this.ask = new g(this);
        this.asl = new h(this);
    }

    public void a(a<?> aVar) {
        this.arY = aVar;
    }

    public void b(BaseActivity<?> baseActivity) {
        this.asb = baseActivity;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.asd = antiData.isIfvoice();
            this.asc = antiData.getVoice_message();
        }
        this.arZ = antiData;
    }

    public void a(ForumData forumData, UserData userData) {
        this.asa = forumData;
        this.mUserData = userData;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 11001:
                    a((String) null, (WriteData) null);
                    return;
                case 11025:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.asb.getActivity(), 12004, true)));
                    return;
                case 11026:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.asb.getActivity(), 12005, true)));
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
                            this.arW.gw(false);
                            return;
                        }
                        this.arX.eW(intent.getStringExtra("file_name"));
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
                    WriteData axO = this.arW.axO();
                    if (axO != null) {
                        axO.deleteUploadedTempImages();
                    }
                    this.arT.setIsBaobao(false);
                    this.arT.setBaobaoContent(null);
                    this.baobaoImagesInfo.clear();
                    this.arW.c((WriteData) null);
                    this.arW.gw(false);
                    this.arS = null;
                    this.asf = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        ad.c(this.mThreadId, (WriteData) null);
                    }
                    bg(true);
                    if (this.asg != null) {
                        this.asg.a(true, null, null, axO, null);
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
                        if (this.asf == null) {
                            this.asf = new VideoInfo();
                        }
                        this.asf.parseIntent(intent);
                        aq aqVar = new aq("c10068");
                        aqVar.r("duration", this.asf.getDuration());
                        TiebaStatic.log(aqVar);
                        Bz();
                        Ax().b(new com.baidu.tbadk.editortools.a(28, 20, this.asf));
                        Ax().b(new com.baidu.tbadk.editortools.a(28, -1, this.asf));
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
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.asb.getActivity())));
    }

    public void Bo() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.asb.getActivity())) {
            this.asb.showToast(i.h.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.m411getInst().getLocationShared()) {
            Bp();
        } else if (this.arV.axr()) {
            Bn();
        } else {
            this.arV.gv(false);
            a(1, true, null);
            this.arV.axp();
        }
    }

    private void Bp() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.asb.getActivity());
        aVar.bF(i.h.location_app_permission_prompt).a(i.h.isopen, new i(this)).b(i.h.cancel, new j(this)).b(this.asb.getPageContext());
        aVar.sR();
    }

    public void Bq() {
        if (this.arV.axt()) {
            if (this.arV.axr()) {
                this.asi.a(com.baidu.tieba.tbadkCore.location.c.axm().getLocationData());
                return;
            }
            if (com.baidu.adp.lib.util.k.jd()) {
                this.arV.axp();
            }
            a(0, true, null);
            return;
        }
        a(0, false, null);
    }

    public boolean Br() {
        if (StringUtils.isNull(this.arR)) {
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() <= 0) {
                if (this.baobaoImagesInfo == null || this.baobaoImagesInfo.size() <= 0) {
                    if (this.arS == null || StringUtils.isNull(this.arS.getId())) {
                        return this.asf != null && this.asf.isAvaliable();
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
        this.arW.c((WriteData) null);
        this.arW.gw(false);
        this.arS = null;
        this.asf = null;
        this.baobaoImagesInfo.clear();
        this.writeImagesInfo.clear();
        this.arT.setIsBaobao(false);
    }

    public VideoInfo getVideoInfo() {
        return this.asf;
    }

    public void Bs() {
        this.asf = null;
    }

    private void G(Intent intent) {
        this.arU = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.arU;
        if (!TextUtils.isEmpty(str)) {
            try {
                int cC = com.baidu.tbadk.core.util.c.cC(str);
                if (cC != 0) {
                    Bitmap b = com.baidu.tbadk.core.util.c.b(str, com.baidu.adp.lib.util.k.dip2px(this.asb.getActivity(), com.baidu.adp.lib.util.k.K(this.asb.getActivity())), com.baidu.adp.lib.util.k.dip2px(this.asb.getActivity(), com.baidu.adp.lib.util.k.L(this.asb.getActivity())));
                    Bitmap i = com.baidu.tbadk.core.util.c.i(b, cC);
                    if (b != i) {
                        b.recycle();
                    }
                    com.baidu.tbadk.core.util.n.a(TbConfig.LOCAL_CAMERA_DIR, this.arU, i, 100);
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
                    this.arT.setIsBaobao(true);
                    this.arT.setBaobaoContent(stringExtra2);
                    this.arT.setBaobaoImagesInfo(this.baobaoImagesInfo);
                    return;
                }
                this.arT.setIsBaobao(false);
                this.arT.setBaobaoContent("");
                this.arT.setBaobaoImagesInfo(this.baobaoImagesInfo);
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
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.asb.getActivity(), 12012, this.writeImagesInfo, size)));
        }
    }

    public void eX(String str) {
        WriteData axO = this.arW.axO();
        if (axO == null) {
            axO = new WriteData(1);
            axO.setThreadId(str);
            axO.setWriteImagesInfo(this.writeImagesInfo);
        }
        axO.setContent(this.arR);
        if (this.arT != null && this.arT.getIsBaobao()) {
            axO.setBaobaoContent(this.arT.getBaobaoContent());
            axO.setBaobaoImagesInfo(this.baobaoImagesInfo);
            axO.setIsBaobao(true);
        }
        axO.setVideoInfo(this.asf);
        ad.c(str, axO);
    }

    public void eY(String str) {
        ad.a(str, this);
    }

    @Override // com.baidu.tieba.tbadkCore.ad.a
    public void a(WriteData writeData) {
        if (writeData != null) {
            if (!as.isEmpty(writeData.getContent()) && as.isEmpty(this.arR)) {
                this.arR = writeData.getContent();
                fa(this.arR);
            }
            if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                if (this.asf == null) {
                    this.asf = new VideoInfo();
                }
                this.asf.copy(writeData.getVideoInfo());
                Bz();
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                BA();
            }
            if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen() && writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                this.arT.setIsBaobao(writeData.getIsBaobao());
                this.arT.setBaobaoContent(writeData.getBaobaoContent());
                this.arT.setBaobaoImagesInfo(this.baobaoImagesInfo);
                BC();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.arW.cancelLoadData();
        this.arX.cancelLoadData();
        this.arV.cancelLoadData();
    }

    public void Bu() {
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        this.arW = new com.baidu.tieba.tbadkCore.writeModel.a(baseActivity);
        this.arW.b(this.ask);
        this.arX = new c(baseActivity);
        this.arX.setLoadDataCallBack(this.asl);
        this.arV = new com.baidu.tieba.tbadkCore.location.d(baseActivity);
        this.arV.a(this.asi);
        this.arV.a(this.asj);
        if (bundle != null) {
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.arU = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        this.writeImagesInfo.setMaxImagesAllowed(10);
        if (!StringUtils.isNull(TbadkCoreApplication.m411getInst().getDefaultBubble()) && Ax() != null) {
            Ax().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.arV.axt() && Ax() != null) {
            Ax().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.arU);
    }

    public void a(String str, WriteData writeData) {
        if (this.arW.axO() == null) {
            this.arW.c(this.arY.eV(str));
        }
        if (this.arW.axO() != null) {
            if (this.arZ != null) {
                if ((AntiHelper.e(this.arZ) || AntiHelper.f(this.arZ) || AntiHelper.g(this.arZ)) && this.asa != null && this.mUserData != null) {
                    this.arZ.setBlock_forum_name(this.asa.getName());
                    this.arZ.setBlock_forum_id(this.asa.getId());
                    this.arZ.setUser_name(this.mUserData.getUserName());
                    this.arZ.setUser_id(this.mUserData.getUserId());
                    if (AntiHelper.a(this.asb.getPageContext().getPageActivity(), this.arZ, AntiHelper.OperationType.CREATE_THREAD, PageType.PB)) {
                        return;
                    }
                }
                if (this.arZ != null && this.arZ.getIfpost() == 0 && !TextUtils.isEmpty(this.arZ.getForbid_info())) {
                    com.baidu.adp.lib.util.k.showToast(this.asb.getPageContext().getPageActivity(), this.arZ.getForbid_info());
                    return;
                }
            }
            this.arW.axO().setWriteImagesInfo(this.writeImagesInfo);
            this.arW.axO().setVideoInfo(this.asf);
            this.arW.gw(this.writeImagesInfo.size() > 0);
            if (this.arT.getIsBaobao()) {
                this.arW.axO().setIsBaobao(true);
                this.arW.axO().setBaobaoContent(this.arT.getBaobaoContent());
                this.arW.axO().setBaobaoImagesInfo(this.baobaoImagesInfo);
            } else {
                this.arW.axO().setIsBaobao(false);
            }
            this.arW.axO().setHasLocationData(this.arV != null ? this.arV.axt() : false);
            if (str == null) {
                this.arW.axO().setContent(this.arR);
            }
            if (this.arS != null) {
                if (this.arS.getId() != null) {
                    this.arW.axO().setVoice(this.arS.getId());
                    this.arW.axO().setVoiceDuringTime(this.arS.duration);
                } else {
                    this.arW.axO().setVoice(null);
                    this.arW.axO().setVoiceDuringTime(-1);
                }
            } else {
                this.arW.axO().setVoice(null);
                this.arW.axO().setVoiceDuringTime(-1);
            }
            if (!this.arW.axS()) {
                this.asb.showToast(i.h.write_img_limit);
                return;
            }
            if (this.ash != null) {
                this.ash.Bm();
            }
            if (!this.arW.axP()) {
            }
        }
    }

    public BaseActivity<?> Bv() {
        return this.asb;
    }

    public WriteImagesInfo getBaobaoImagesInfo() {
        return this.baobaoImagesInfo;
    }

    public void eZ(String str) {
        this.arR = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.arS = voiceModel;
    }

    public WriteData Bw() {
        return this.arT;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int Bx() {
        return this.ase;
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
        this.ase = i;
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
        this.asg = dVar;
    }

    public void a(b bVar) {
        this.ash = bVar;
    }
}
