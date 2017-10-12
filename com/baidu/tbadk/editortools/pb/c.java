package com.baidu.tbadk.editortools.pb;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.util.u;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.editortools.f implements r.a {
    private LocationModel aCA;
    private NewWriteModel aCB;
    private ImageModel aCC;
    private DataModel<?> aCD;
    private ForumData aCE;
    private String aCF;
    private String aCG;
    private int aCH;
    private NewWriteModel.d aCI;
    private b aCJ;
    private com.baidu.tbadk.editortools.imagetool.b aCK;
    private com.baidu.tbadk.editortools.inputtool.a aCL;
    private com.baidu.tbadk.editortools.sendtool.a aCM;
    private boolean aCN;
    private TextWatcher aCO;
    private LocationModel.a aCP;
    private LocationModel.b aCQ;
    private final NewWriteModel.d aCR;
    private final com.baidu.adp.base.d aCS;
    private String aCx;
    private VoiceData.VoiceModel aCy;
    private String aCz;
    private long authorId;
    private String authorName;
    private BaseActivity<?> mContext;
    private String mThreadId;
    private VideoInfo mVideoInfo;
    private String postId;
    private WriteImagesInfo writeImagesInfo;

    public c(i iVar) {
        super(iVar);
        this.writeImagesInfo = new WriteImagesInfo();
        this.aCx = "";
        this.aCB = null;
        this.aCC = null;
        this.mThreadId = null;
        this.aCF = null;
        this.aCH = 0;
        this.aCN = false;
        this.aCP = new LocationModel.a() { // from class: com.baidu.tbadk.editortools.pb.c.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void Dq() {
                c.this.mContext.showToast(d.l.no_network_guide);
                c.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void fR(String str) {
                BaseActivity baseActivity = c.this.mContext;
                if (StringUtils.isNull(str)) {
                    str = c.this.Cz().getContext().getString(d.l.location_fail);
                }
                baseActivity.showToast(str);
                c.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.brZ())) {
                    c.this.a(2, true, aVar.brZ());
                } else {
                    fR(null);
                }
            }
        };
        this.aCQ = new LocationModel.b() { // from class: com.baidu.tbadk.editortools.pb.c.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void Dr() {
                c.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void fS(String str) {
                c.this.a(2, true, str);
            }
        };
        this.aCR = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.c.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
                WriteData writeData2 = writeData == null ? c.this.aCB.getWriteData() : writeData;
                if (z) {
                    c.this.bL(true);
                    WriteData writeData3 = c.this.aCB.getWriteData();
                    c.this.resetData();
                    r.d(c.this.mThreadId, (WriteData) null);
                    if (writeData3 != null) {
                        if (writeData3 != null && writeData3.getType() == 2) {
                            r.a(writeData3.getThreadId(), c.this);
                        }
                    } else {
                        return;
                    }
                } else if (writeData2 != null && qVar != null && !TextUtils.isEmpty(qVar.xZ())) {
                    writeData2.setVcodeMD5(qVar.getVcode_md5());
                    writeData2.setVcodeUrl(qVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(qVar.ya());
                    if (com.baidu.tbadk.p.a.gT(qVar.xZ())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(c.this.mContext.getActivity(), 12006, writeData2, false, qVar.xZ())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(c.this.mContext.getActivity(), writeData2, 12006)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(c.this.mContext.getActivity(), 12006, writeData2, postWriteCallBackData.getAccessState())));
                }
                if (c.this.aCI != null) {
                    c.this.aCI.callback(z, postWriteCallBackData, qVar, writeData2, antiData);
                }
            }
        };
        this.aCS = new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.editortools.pb.c.7
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                if (obj instanceof Bitmap) {
                    c.this.aCB.mG(true);
                }
            }
        };
    }

    private com.baidu.tbadk.editortools.sendtool.a CX() {
        if (this.aCM == null && Cz() != null) {
            this.aCM = (com.baidu.tbadk.editortools.sendtool.a) Cz().eP(4);
        }
        return this.aCM;
    }

    public void eW(int i) {
        if (this.aCM == null && Cz() != null) {
            this.aCM = (com.baidu.tbadk.editortools.sendtool.a) Cz().eP(4);
        }
        if (this.aCM != null) {
            this.aCM.setType(i);
        }
    }

    public void eX(int i) {
        if (this.aCM == null && Cz() != null) {
            this.aCM = (com.baidu.tbadk.editortools.sendtool.a) Cz().eP(4);
        }
        if (this.aCM != null) {
            this.aCM.fa(i);
        }
    }

    private com.baidu.tbadk.editortools.imagetool.b CY() {
        if (this.aCK == null && Cz() != null) {
            this.aCK = (com.baidu.tbadk.editortools.imagetool.b) Cz().eP(11);
        }
        return this.aCK;
    }

    public void eY(int i) {
        if (this.aCK == null && Cz() != null) {
            this.aCK = (com.baidu.tbadk.editortools.imagetool.b) Cz().eP(11);
        }
        if (this.aCK != null) {
            this.aCK.eV(i);
        }
    }

    public com.baidu.tbadk.editortools.inputtool.a CZ() {
        if (this.aCL == null && Cz() != null) {
            this.aCL = (com.baidu.tbadk.editortools.inputtool.a) Cz().eP(3);
        }
        return this.aCL;
    }

    public void fL(String str) {
        if (this.aCL == null && Cz() != null) {
            this.aCL = (com.baidu.tbadk.editortools.inputtool.a) Cz().eP(3);
        }
        if (this.aCL != null) {
            this.aCL.setHint(str);
        }
    }

    public void bG(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (Cz() != null && (cVar = (com.baidu.tbadk.editortools.c) Cz().eN(5)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bH(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (Cz() != null && (cVar = (com.baidu.tbadk.editortools.c) Cz().eN(23)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bI(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (Cz() != null && (cVar = (com.baidu.tbadk.editortools.c) Cz().eN(2)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.aCD = dataModel;
    }

    public void d(BaseActivity<?> baseActivity) {
        this.mContext = baseActivity;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.aCF = antiData.getVoice_message();
        }
    }

    public void a(ForumData forumData, UserData userData) {
        this.aCE = forumData;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (Cz() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.aCG = metaData.getName_show();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void bJ(boolean z) {
        this.aCN = z;
    }

    public void Da() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            String valueOf = String.valueOf(this.authorId);
            if (valueOf == null || valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                l.showToast(this.mContext.getActivity(), d.l.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.mContext.getActivity(), this.authorId, this.authorName, this.aCG, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.g.b.c(this.mThreadId, 0L), com.baidu.adp.lib.g.b.c(this.postId, 0L))));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        com.baidu.tbadk.editortools.l lVar;
        com.baidu.tbadk.editortools.l lVar2;
        com.baidu.tbadk.editortools.l lVar3 = null;
        if (i2 == -1) {
            switch (i) {
                case 11001:
                    a((String) null, (WriteData) null);
                    return;
                case 11025:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.mContext.getActivity(), 12004, true)));
                    return;
                case 11026:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.mContext.getActivity(), 12005, true)));
                    return;
                case 12002:
                    if (intent != null) {
                        boolean booleanExtra = intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false);
                        if (a.CV().getStatus() == 1) {
                            if (CY() != null) {
                                CY().eV(1);
                            }
                            if (getWriteImagesInfo() != null) {
                                getWriteImagesInfo().setMaxImagesAllowed(1);
                            }
                        } else {
                            if (CY() != null) {
                                CY().eV(10);
                            }
                            if (getWriteImagesInfo() != null) {
                                getWriteImagesInfo().setMaxImagesAllowed(10);
                            }
                        }
                        if (booleanExtra) {
                            C(intent);
                        } else {
                            B(intent);
                        }
                        if (Cz() != null) {
                            lVar2 = Cz().eN(2);
                            lVar = Cz().eN(5);
                            lVar3 = Cz().eN(23);
                        } else {
                            lVar = null;
                            lVar2 = null;
                        }
                        if (a.CV().getStatus() == 1) {
                            Dm();
                            if (Cz() != null) {
                                Cz().CI();
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL));
                            }
                            if (lVar2 != null) {
                                lVar2.hide();
                            }
                            if (lVar != null) {
                                lVar.hide();
                            }
                            if (lVar3 != null) {
                                lVar3.lM();
                            }
                            if (CZ() != null) {
                                CZ().setHint(this.mContext.getPageContext().getString(d.l.add_picture_description));
                            }
                            if (CY() != null) {
                                CY().fF(this.mContext.getPageContext().getString(d.l.show_pic_tip));
                                CY().fG(this.mContext.getPageContext().getString(d.l.show_pic_add_tip));
                            }
                            if (CX() != null) {
                                CX().setType(SendView.aDm);
                                CX().fa(SendView.aDm);
                            }
                        } else {
                            if (lVar2 != null) {
                                lVar2.lM();
                            }
                            if (lVar != null) {
                                lVar.lM();
                            }
                            if (lVar3 != null) {
                                lVar3.hide();
                            }
                            if (CZ() != null) {
                                CZ().setHint(this.mContext.getPageContext().getString(d.l.pb_reply_hint));
                            }
                            if (CX() != null) {
                                CX().setType(SendView.ALL);
                                CX().fa(SendView.ALL);
                            }
                        }
                        Cz().invalidate();
                        return;
                    }
                    return;
                case 12003:
                    if (intent != null) {
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            Dj();
                            this.aCB.mG(false);
                            return;
                        }
                        this.aCC.fK(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case 12004:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        p(stringArrayListExtra);
                        return;
                    }
                    return;
                case 12006:
                    WriteData writeData = this.aCB.getWriteData();
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra(WriteActivityConfig.POST_WRITE_CALLBACK_DATA) instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra(WriteActivityConfig.POST_WRITE_CALLBACK_DATA);
                    if (writeData != null) {
                        writeData.deleteUploadedTempImages();
                    }
                    this.aCB.setWriteData(null);
                    this.aCB.mG(false);
                    this.aCy = null;
                    this.mVideoInfo = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        r.d(this.mThreadId, (WriteData) null);
                    }
                    bL(true);
                    if (this.aCI != null) {
                        this.aCI.callback(true, postWriteCallBackData, null, writeData, null);
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    if (i == 12010) {
                        z(intent);
                        return;
                    }
                    return;
                case 12012:
                    A(intent);
                    if (a.CV().getStatus() == 1 && CY() != null) {
                        CY().fF(this.mContext.getPageContext().getString(d.l.show_pic_tip));
                        return;
                    }
                    return;
                case 13010:
                    if (Cz() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            ak akVar = new ak("c10068");
                            akVar.r("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(akVar);
                            Dk();
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
                case 25004:
                    if (intent != null) {
                        fP(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 12001:
                Dh();
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

    public void Db() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.mContext.getActivity())));
    }

    public void Dc() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.mContext.getActivity())) {
            this.mContext.showToast(d.l.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            Dd();
        } else if (this.aCA.bsh()) {
            Db();
        } else {
            this.aCA.mE(false);
            a(1, true, (String) null);
            this.aCA.bsf();
        }
    }

    private void Dd() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getActivity());
        aVar.cd(d.l.location_app_permission_prompt).a(d.l.isopen, new a.b() { // from class: com.baidu.tbadk.editortools.pb.c.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.hh()) {
                    c.this.a(1, true, (String) null);
                    c.this.aCA.Va();
                } else {
                    c.this.aCP.Dq();
                }
                aVar2.dismiss();
            }
        }).b(d.l.cancel, new a.b() { // from class: com.baidu.tbadk.editortools.pb.c.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                c.this.a(0, true, (String) null);
                aVar2.dismiss();
            }
        }).b(this.mContext.getPageContext());
        aVar.ti();
    }

    public void De() {
        if (this.aCA.UW()) {
            if (this.aCA.bsh()) {
                this.aCP.a(com.baidu.tieba.tbadkCore.location.c.bsd().getLocationData());
                return;
            }
            if (l.hy()) {
                this.aCA.bsf();
            }
            a(0, true, (String) null);
            return;
        }
        a(0, false, (String) null);
    }

    public boolean Df() {
        if (StringUtils.isNull(this.aCx)) {
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() <= 0) {
                if (this.aCy == null || StringUtils.isNull(this.aCy.getId())) {
                    return this.mVideoInfo != null && this.mVideoInfo.isAvaliable();
                }
                return true;
            }
            return true;
        }
        return true;
    }

    public void resetData() {
        this.aCB.setWriteData(null);
        this.aCB.mG(false);
        this.aCy = null;
        this.mVideoInfo = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void Dg() {
        this.mVideoInfo = null;
    }

    private void z(Intent intent) {
        this.aCz = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aCz;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.mContext.getActivity(), l.ad(this.mContext.getActivity())), l.dip2px(this.mContext.getActivity(), l.af(this.mContext.getActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    k.a(TbConfig.LOCAL_CAMERA_DIR, this.aCz, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            Dl();
        }
    }

    private void A(Intent intent) {
        b(intent, false);
    }

    private void b(Intent intent, boolean z) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                Dl();
            }
        }
    }

    private void Dh() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tbadk.editortools.pb.c.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                k.t(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + c.this.aCz));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void B(Intent intent) {
        b(intent, true);
    }

    private void C(Intent intent) {
        int size;
        int size2;
        z(intent);
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() - 1 > -1 && this.writeImagesInfo.getChosedFiles() != null && (size2 = this.writeImagesInfo.getChosedFiles().size()) >= 1 && size >= 0 && size < size2) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.mContext.getActivity(), 12012, this.writeImagesInfo, size)));
        }
    }

    public void fM(String str) {
        WriteData writeData = this.aCB.getWriteData();
        if (writeData == null) {
            writeData = new WriteData(1);
            writeData.setThreadId(str);
            writeData.setWriteImagesInfo(this.writeImagesInfo);
        }
        writeData.setContent(this.aCx);
        writeData.setVideoInfo(this.mVideoInfo);
        r.d(str, writeData);
    }

    public void fN(String str) {
        r.a(str, this);
    }

    @Override // com.baidu.tieba.tbadkCore.r.a
    public void a(WriteData writeData) {
        if (writeData != null) {
            if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                if (this.mVideoInfo == null) {
                    this.mVideoInfo = new VideoInfo();
                }
                this.mVideoInfo.copy(writeData.getVideoInfo());
                Dk();
                Cz().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                bK(false);
            }
            if (!am.isEmpty(writeData.getContent()) && am.isEmpty(this.aCx)) {
                this.aCx = writeData.getContent();
                fQ(this.aCx);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.aCB.cancelLoadData();
        this.aCC.cancelLoadData();
        this.aCA.cancelLoadData();
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        this.aCB = new NewWriteModel(baseActivity);
        this.aCB.b(this.aCR);
        this.aCC = new ImageModel(baseActivity);
        this.aCC.setLoadDataCallBack(this.aCS);
        this.aCA = new LocationModel(baseActivity);
        this.aCA.a(this.aCP);
        this.aCA.a(this.aCQ);
        if (bundle != null) {
            this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
            this.aCz = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(10);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && Cz() != null) {
            Cz().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.aCA.UW() && Cz() != null) {
            Cz().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.writeImagesInfo != null) {
            bundle.putString(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aCz);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.aCB.getWriteData() == null) {
            this.aCB.setWriteData(this.aCD.fJ(str));
        }
        if (this.aCB.getWriteData() != null) {
            if (this.aCN) {
                this.aCB.getWriteData().setCanNoForum(true);
                if (this.aCE != null) {
                    this.aCB.getWriteData().setVForumId(this.aCE.getId());
                    this.aCB.getWriteData().setVForumName(this.aCE.getName());
                }
            } else {
                this.aCB.getWriteData().setCanNoForum(false);
                this.aCB.getWriteData().setVForumId("");
                this.aCB.getWriteData().setVForumName("");
            }
            this.aCB.getWriteData().setWriteImagesInfo(this.writeImagesInfo);
            this.aCB.getWriteData().setVideoInfo(this.mVideoInfo);
            this.aCB.mG(this.writeImagesInfo.size() > 0);
            WriteData writeData2 = this.aCB.getWriteData();
            if (this.aCA == null || !this.aCA.UW()) {
                z = false;
            }
            writeData2.setHasLocationData(z);
            if (str == null) {
                this.aCB.getWriteData().setContent(this.aCx);
            }
            if (this.aCy != null) {
                if (this.aCy.getId() != null) {
                    this.aCB.getWriteData().setVoice(this.aCy.getId());
                    this.aCB.getWriteData().setVoiceDuringTime(this.aCy.duration);
                } else {
                    this.aCB.getWriteData().setVoice(null);
                    this.aCB.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.aCB.getWriteData().setVoice(null);
                this.aCB.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.aCB.bsD()) {
                this.mContext.showToast(d.l.write_img_limit);
                return;
            }
            if (this.aCJ != null) {
                this.aCJ.CW();
            }
            if (!this.aCB.startPostWrite()) {
            }
        }
    }

    public BaseActivity<?> getContext() {
        return this.mContext;
    }

    public void fO(String str) {
        this.aCx = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.aCy = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int Di() {
        return this.aCH;
    }

    private void Dj() {
        if (Cz() != null) {
            Cz().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void p(ArrayList<String> arrayList) {
        if (Cz() != null) {
            Cz().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    public void fP(String str) {
        if (Cz() != null) {
            Cz().b(new com.baidu.tbadk.editortools.a(44, 3, str));
        }
    }

    private void Dk() {
        if (Cz() != null) {
            Cz().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    protected void bK(boolean z) {
        if (Cz() != null) {
            if (z) {
                Cz().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            Cz().b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                Cz().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
            } else {
                Cz().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
        }
    }

    protected void Dl() {
        bK(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Dm() {
        if (Cz() != null) {
            Cz().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.aCH = i;
        if (Cz() != null) {
            Cz().b(new com.baidu.tbadk.editortools.a(19, 8, new com.baidu.tbadk.editortools.d.a(i, z, str)));
            if (i == 2) {
                Cz().b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            } else {
                Cz().b(new com.baidu.tbadk.editortools.a(2, 7, null));
            }
        }
    }

    private void fQ(String str) {
        if (Cz() != null) {
            Cz().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bL(boolean z) {
        if (Cz() != null) {
            Cz().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.aCI = dVar;
    }

    public void a(b bVar) {
        this.aCJ = bVar;
    }

    public void Dn() {
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            this.writeImagesInfo.clear();
        }
        Dl();
        if (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) {
            this.mVideoInfo = null;
        }
        Cz().b(new com.baidu.tbadk.editortools.a(2, 19, null));
        setVoiceModel(null);
        Cz().b(new com.baidu.tbadk.editortools.a(2, 6, null));
        Cz().b(new com.baidu.tbadk.editortools.a(33, 6, null));
        if (!StringUtils.isNull(this.aCx)) {
            this.aCx = "";
        }
        fQ("");
        this.aCB.setWriteData(null);
        this.aCB.mG(false);
    }

    public void eZ(final int i) {
        Do();
        if (this.aCL != null && (this.aCL.aAH instanceof EditText)) {
            final EditText editText = (EditText) this.aCL.aAH;
            if (this.aCO == null) {
                this.aCO = new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.c.8
                    @Override // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    }

                    @Override // android.text.TextWatcher
                    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    }

                    @Override // android.text.TextWatcher
                    public void afterTextChanged(Editable editable) {
                        if (editable != null) {
                            String obj = editable.toString();
                            if (!StringUtils.isNull(obj) && u.gP(obj) > i) {
                                String e = u.e(obj, 0, i - 1);
                                editText.setText(e);
                                editText.setSelection(editText.getText().length());
                                UtilHelper.showToast(c.this.getContext().getApplication(), c.this.getContext().getResources().getString(d.l.edit_text_over_limit_tip, Integer.valueOf(e.length())));
                            }
                        }
                    }
                };
            }
            this.aCL.a(this.aCO);
        }
    }

    private void Do() {
        if (this.aCL == null && Cz() != null) {
            this.aCL = (com.baidu.tbadk.editortools.inputtool.a) Cz().eP(3);
        }
    }

    public void Dp() {
        if (this.aCL != null && this.aCO != null) {
            this.aCL.b(this.aCO);
        }
    }

    public void c(TextWatcher textWatcher) {
        Do();
        if (this.aCL != null && textWatcher != null) {
            this.aCL.a(textWatcher);
        }
    }
}
