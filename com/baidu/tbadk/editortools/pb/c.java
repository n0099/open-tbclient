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
import com.baidu.adp.lib.util.k;
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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.l;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.editortools.f implements r.a {
    private String aCA;
    private VoiceData.VoiceModel aCB;
    private String aCC;
    private LocationModel aCD;
    private NewWriteModel aCE;
    private ImageModel aCF;
    private DataModel<?> aCG;
    private AntiData aCH;
    private ForumData aCI;
    private String aCJ;
    private boolean aCK;
    private String aCL;
    private int aCM;
    private NewWriteModel.d aCN;
    private b aCO;
    private com.baidu.tbadk.editortools.imagetool.b aCP;
    private com.baidu.tbadk.editortools.inputtool.a aCQ;
    private com.baidu.tbadk.editortools.sendtool.a aCR;
    private boolean aCS;
    private LocationModel.a aCT;
    private LocationModel.b aCU;
    private final NewWriteModel.d aCV;
    private final com.baidu.adp.base.d aCW;
    private long authorId;
    private String authorName;
    private BaseActivity<?> mContext;
    private String mGraffitiFileName;
    private String mThreadId;
    private UserData mUserData;
    private VideoInfo mVideoInfo;
    private String postId;
    private WriteImagesInfo writeImagesInfo;

    public c(i iVar) {
        super(iVar);
        this.writeImagesInfo = new WriteImagesInfo();
        this.aCA = "";
        this.aCE = null;
        this.aCF = null;
        this.mThreadId = null;
        this.aCJ = null;
        this.aCK = true;
        this.aCM = 0;
        this.aCS = false;
        this.aCT = new LocationModel.a() { // from class: com.baidu.tbadk.editortools.pb.c.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void DJ() {
                c.this.mContext.showToast(d.l.no_network_guide);
                c.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void fU(String str) {
                BaseActivity baseActivity = c.this.mContext;
                if (StringUtils.isNull(str)) {
                    str = c.this.CS().getContext().getString(d.l.location_fail);
                }
                baseActivity.showToast(str);
                c.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.bsT())) {
                    c.this.b(2, true, aVar.bsT());
                } else {
                    fU(null);
                }
            }
        };
        this.aCU = new LocationModel.b() { // from class: com.baidu.tbadk.editortools.pb.c.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void DK() {
                c.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void fV(String str) {
                c.this.b(2, true, str);
            }
        };
        this.aCV = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.c.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
                WriteData writeData2 = writeData == null ? c.this.aCE.getWriteData() : writeData;
                if (z) {
                    c.this.bN(true);
                    WriteData writeData3 = c.this.aCE.getWriteData();
                    c.this.resetData();
                    r.d(c.this.mThreadId, (WriteData) null);
                    if (writeData3 != null) {
                        if (writeData3 != null && writeData3.getType() == 2) {
                            r.a(writeData3.getThreadId(), c.this);
                        }
                    } else {
                        return;
                    }
                } else if (writeData2 != null && qVar != null && !TextUtils.isEmpty(qVar.yp())) {
                    writeData2.setVcodeMD5(qVar.getVcode_md5());
                    writeData2.setVcodeUrl(qVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(qVar.yq());
                    if (com.baidu.tbadk.q.a.gT(qVar.yp())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(c.this.mContext.getActivity(), 12006, writeData2, false, qVar.yp())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(c.this.mContext.getActivity(), writeData2, 12006)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(c.this.mContext.getActivity(), 12006, writeData2, postWriteCallBackData.getAccessState())));
                }
                if (c.this.aCN != null) {
                    c.this.aCN.callback(z, postWriteCallBackData, qVar, writeData2, antiData);
                }
            }
        };
        this.aCW = new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.editortools.pb.c.7
            @Override // com.baidu.adp.base.d
            public void g(Object obj) {
                if (obj instanceof Bitmap) {
                    Bitmap bitmap = (Bitmap) obj;
                    if (obj != null) {
                        c.this.aCE.mC(true);
                    }
                }
            }
        };
    }

    private com.baidu.tbadk.editortools.sendtool.a Dq() {
        if (this.aCR == null && CS() != null) {
            this.aCR = (com.baidu.tbadk.editortools.sendtool.a) CS().eC(4);
        }
        return this.aCR;
    }

    public void eJ(int i) {
        if (this.aCR == null && CS() != null) {
            this.aCR = (com.baidu.tbadk.editortools.sendtool.a) CS().eC(4);
        }
        if (this.aCR != null) {
            this.aCR.setType(i);
        }
    }

    public void eK(int i) {
        if (this.aCR == null && CS() != null) {
            this.aCR = (com.baidu.tbadk.editortools.sendtool.a) CS().eC(4);
        }
        if (this.aCR != null) {
            this.aCR.eN(i);
        }
    }

    private com.baidu.tbadk.editortools.imagetool.b Dr() {
        if (this.aCP == null && CS() != null) {
            this.aCP = (com.baidu.tbadk.editortools.imagetool.b) CS().eC(11);
        }
        return this.aCP;
    }

    public void eL(int i) {
        if (this.aCP == null && CS() != null) {
            this.aCP = (com.baidu.tbadk.editortools.imagetool.b) CS().eC(11);
        }
        if (this.aCP != null) {
            this.aCP.eI(i);
        }
    }

    public com.baidu.tbadk.editortools.inputtool.a Ds() {
        if (this.aCQ == null && CS() != null) {
            this.aCQ = (com.baidu.tbadk.editortools.inputtool.a) CS().eC(3);
        }
        return this.aCQ;
    }

    public void fO(String str) {
        if (this.aCQ == null && CS() != null) {
            this.aCQ = (com.baidu.tbadk.editortools.inputtool.a) CS().eC(3);
        }
        if (this.aCQ != null) {
            this.aCQ.setHint(str);
        }
    }

    public void bI(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (CS() != null && (cVar = (com.baidu.tbadk.editortools.c) CS().eA(5)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bJ(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (CS() != null && (cVar = (com.baidu.tbadk.editortools.c) CS().eA(23)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bK(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (CS() != null && (cVar = (com.baidu.tbadk.editortools.c) CS().eA(2)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.aCG = dataModel;
    }

    public void d(BaseActivity<?> baseActivity) {
        this.mContext = baseActivity;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.aCK = antiData.isIfvoice();
            this.aCJ = antiData.getVoice_message();
        }
        this.aCH = antiData;
    }

    public void a(ForumData forumData, UserData userData) {
        this.aCI = forumData;
        this.mUserData = userData;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (CS() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.aCL = metaData.getName_show();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void bL(boolean z) {
        this.aCS = z;
    }

    public void Dt() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            String valueOf = String.valueOf(this.authorId);
            if (valueOf == null || valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                k.showToast(this.mContext.getActivity(), d.l.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.mContext.getActivity(), this.authorId, this.authorName, this.aCL, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.g.b.c(this.mThreadId, 0L), com.baidu.adp.lib.g.b.c(this.postId, 0L))));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        l lVar;
        l lVar2;
        l lVar3 = null;
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
                        if (a.Do().getStatus() == 1) {
                            if (Dr() != null) {
                                Dr().eI(1);
                            }
                            if (getWriteImagesInfo() != null) {
                                getWriteImagesInfo().setMaxImagesAllowed(1);
                            }
                        } else {
                            if (Dr() != null) {
                                Dr().eI(10);
                            }
                            if (getWriteImagesInfo() != null) {
                                getWriteImagesInfo().setMaxImagesAllowed(10);
                            }
                        }
                        if (booleanExtra) {
                            D(intent);
                        } else {
                            C(intent);
                        }
                        if (CS() != null) {
                            lVar2 = CS().eA(2);
                            lVar = CS().eA(5);
                            lVar3 = CS().eA(23);
                        } else {
                            lVar = null;
                            lVar2 = null;
                        }
                        if (a.Do().getStatus() == 1) {
                            DG();
                            if (CS() != null) {
                                CS().Db();
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL));
                            }
                            if (lVar2 != null) {
                                lVar2.hide();
                            }
                            if (lVar != null) {
                                lVar.hide();
                            }
                            if (lVar3 != null) {
                                lVar3.lJ();
                            }
                            if (Ds() != null) {
                                Ds().setHint(this.mContext.getPageContext().getString(d.l.add_picture_description));
                            }
                            if (Dr() != null) {
                                Dr().fH(this.mContext.getPageContext().getString(d.l.show_pic_tip));
                                Dr().fI(this.mContext.getPageContext().getString(d.l.show_pic_add_tip));
                            }
                            if (Dq() != null) {
                                Dq().setType(SendView.aDp);
                                Dq().eN(SendView.aDp);
                            }
                        } else {
                            if (lVar2 != null) {
                                lVar2.lJ();
                            }
                            if (lVar != null) {
                                lVar.lJ();
                            }
                            if (lVar3 != null) {
                                lVar3.hide();
                            }
                            if (Ds() != null) {
                                Ds().setHint(this.mContext.getPageContext().getString(d.l.pb_reply_hint));
                            }
                            if (Dq() != null) {
                                Dq().setType(SendView.ALL);
                                Dq().eN(SendView.ALL);
                            }
                        }
                        CS().invalidate();
                        return;
                    }
                    return;
                case 12003:
                    if (intent != null) {
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            DD();
                            this.aCE.mC(false);
                            return;
                        }
                        this.aCF.fN(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case 12004:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        q(stringArrayListExtra);
                        return;
                    }
                    return;
                case 12006:
                    WriteData writeData = this.aCE.getWriteData();
                    if (writeData != null) {
                        writeData.deleteUploadedTempImages();
                    }
                    this.aCE.setWriteData(null);
                    this.aCE.mC(false);
                    this.aCB = null;
                    this.mVideoInfo = null;
                    this.mGraffitiFileName = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        r.d(this.mThreadId, (WriteData) null);
                    }
                    bN(true);
                    if (this.aCN != null) {
                        this.aCN.callback(true, null, null, writeData, null);
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    if (i == 12010) {
                        A(intent);
                        return;
                    }
                    return;
                case 12012:
                    B(intent);
                    if (a.Do().getStatus() == 1 && Dr() != null) {
                        Dr().fH(this.mContext.getPageContext().getString(d.l.show_pic_tip));
                        return;
                    }
                    return;
                case 13010:
                    if (CS() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            aj ajVar = new aj("c10068");
                            ajVar.r("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(ajVar);
                            DE();
                            CS().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            CS().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                        fS(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 12001:
                DA();
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

    public void Du() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.mContext.getActivity())));
    }

    public void Dv() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.mContext.getActivity())) {
            this.mContext.showToast(d.l.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            Dw();
        } else if (this.aCD.btb()) {
            Du();
        } else {
            this.aCD.mA(false);
            b(1, true, null);
            this.aCD.bsZ();
        }
    }

    private void Dw() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getActivity());
        aVar.ca(d.l.location_app_permission_prompt).a(d.l.isopen, new a.b() { // from class: com.baidu.tbadk.editortools.pb.c.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.i.hh()) {
                    c.this.b(1, true, null);
                    c.this.aCD.Tl();
                } else {
                    c.this.aCT.DJ();
                }
                aVar2.dismiss();
            }
        }).b(d.l.cancel, new a.b() { // from class: com.baidu.tbadk.editortools.pb.c.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                c.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(this.mContext.getPageContext());
        aVar.th();
    }

    public void Dx() {
        if (this.aCD.Th()) {
            if (this.aCD.btb()) {
                this.aCT.a(com.baidu.tieba.tbadkCore.location.c.bsX().getLocationData());
                return;
            }
            if (k.hy()) {
                this.aCD.bsZ();
            }
            b(0, true, null);
            return;
        }
        b(0, false, null);
    }

    public boolean Dy() {
        if (StringUtils.isNull(this.aCA)) {
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() <= 0) {
                if (this.aCB == null || StringUtils.isNull(this.aCB.getId())) {
                    return (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) || this.mGraffitiFileName != null;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    public void resetData() {
        this.aCE.setWriteData(null);
        this.aCE.mC(false);
        this.aCB = null;
        this.mVideoInfo = null;
        this.mGraffitiFileName = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void Dz() {
        this.mVideoInfo = null;
    }

    private void A(Intent intent) {
        this.aCC = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aCC;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, k.dip2px(this.mContext.getActivity(), k.af(this.mContext.getActivity())), k.dip2px(this.mContext.getActivity(), k.ag(this.mContext.getActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.k.a(TbConfig.LOCAL_CAMERA_DIR, this.aCC, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            DF();
        }
    }

    private void B(Intent intent) {
        b(intent, false);
    }

    private void b(Intent intent, boolean z) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                DF();
            }
        }
    }

    private void DA() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tbadk.editortools.pb.c.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tbadk.core.util.k.s(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + c.this.aCC));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void C(Intent intent) {
        b(intent, true);
    }

    private void D(Intent intent) {
        int size;
        int size2;
        A(intent);
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() - 1 > -1 && this.writeImagesInfo.getChosedFiles() != null && (size2 = this.writeImagesInfo.getChosedFiles().size()) >= 1 && size >= 0 && size < size2) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.mContext.getActivity(), 12012, this.writeImagesInfo, size)));
        }
    }

    public void fP(String str) {
        WriteData writeData = this.aCE.getWriteData();
        if (writeData == null) {
            writeData = new WriteData(1);
            writeData.setThreadId(str);
            writeData.setWriteImagesInfo(this.writeImagesInfo);
        }
        writeData.setContent(this.aCA);
        writeData.setVideoInfo(this.mVideoInfo);
        writeData.setGraffitiFileName(this.mGraffitiFileName);
        r.d(str, writeData);
    }

    public void fQ(String str) {
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
                DE();
                CS().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                bM(false);
            }
            this.mGraffitiFileName = writeData.getGraffitiFileName();
            if (CS() != null && !al.isEmpty(this.mGraffitiFileName)) {
                CS().b(new com.baidu.tbadk.editortools.a(42, 24, this.mGraffitiFileName));
            }
            if (!al.isEmpty(writeData.getContent()) && al.isEmpty(this.aCA)) {
                this.aCA = writeData.getContent();
                fT(this.aCA);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.aCE.cancelLoadData();
        this.aCF.cancelLoadData();
        this.aCD.cancelLoadData();
    }

    public void DB() {
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        this.aCE = new NewWriteModel(baseActivity);
        this.aCE.b(this.aCV);
        this.aCF = new ImageModel(baseActivity);
        this.aCF.setLoadDataCallBack(this.aCW);
        this.aCD = new LocationModel(baseActivity);
        this.aCD.a(this.aCT);
        this.aCD.a(this.aCU);
        if (bundle != null) {
            this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
            this.aCC = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(10);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && CS() != null) {
            CS().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.aCD.Th() && CS() != null) {
            CS().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.writeImagesInfo != null) {
            bundle.putString(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aCC);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.aCE.getWriteData() == null) {
            this.aCE.setWriteData(this.aCG.fM(str));
        }
        if (this.aCE.getWriteData() != null) {
            if (this.aCS) {
                this.aCE.getWriteData().setCanNoForum(true);
                if (this.aCI != null) {
                    this.aCE.getWriteData().setVForumId(this.aCI.getId());
                    this.aCE.getWriteData().setVForumName(this.aCI.getName());
                }
            } else {
                this.aCE.getWriteData().setCanNoForum(false);
                this.aCE.getWriteData().setVForumId("");
                this.aCE.getWriteData().setVForumName("");
            }
            this.aCE.getWriteData().setWriteImagesInfo(this.writeImagesInfo);
            this.aCE.getWriteData().setVideoInfo(this.mVideoInfo);
            this.aCE.getWriteData().setGraffitiFileName(this.mGraffitiFileName);
            this.aCE.mC(this.writeImagesInfo.size() > 0);
            WriteData writeData2 = this.aCE.getWriteData();
            if (this.aCD == null || !this.aCD.Th()) {
                z = false;
            }
            writeData2.setHasLocationData(z);
            if (str == null) {
                this.aCE.getWriteData().setContent(this.aCA);
            }
            if (this.aCB != null) {
                if (this.aCB.getId() != null) {
                    this.aCE.getWriteData().setVoice(this.aCB.getId());
                    this.aCE.getWriteData().setVoiceDuringTime(this.aCB.duration);
                } else {
                    this.aCE.getWriteData().setVoice(null);
                    this.aCE.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.aCE.getWriteData().setVoice(null);
                this.aCE.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.aCE.btx()) {
                this.mContext.showToast(d.l.write_img_limit);
                return;
            }
            if (this.aCO != null) {
                this.aCO.Dp();
            }
            if (!this.aCE.startPostWrite()) {
            }
        }
    }

    public BaseActivity<?> getContext() {
        return this.mContext;
    }

    public void fR(String str) {
        this.aCA = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.aCB = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int DC() {
        return this.aCM;
    }

    private void DD() {
        if (CS() != null) {
            CS().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void q(ArrayList<String> arrayList) {
        if (CS() != null) {
            CS().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    public void fS(String str) {
        if (CS() != null) {
            CS().b(new com.baidu.tbadk.editortools.a(44, 3, str));
        }
    }

    private void DE() {
        if (CS() != null) {
            CS().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    protected void bM(boolean z) {
        if (CS() != null) {
            if (z) {
                CS().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            CS().b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                CS().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
            } else {
                CS().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
        }
    }

    protected void DF() {
        bM(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void DG() {
        if (CS() != null) {
            CS().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.aCM = i;
        if (CS() != null) {
            CS().b(new com.baidu.tbadk.editortools.a(19, 8, new com.baidu.tbadk.editortools.d.a(i, z, str)));
            if (i == 2) {
                CS().b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            } else {
                CS().b(new com.baidu.tbadk.editortools.a(2, 7, null));
            }
        }
    }

    private void fT(String str) {
        if (CS() != null) {
            CS().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bN(boolean z) {
        if (CS() != null) {
            CS().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.aCN = dVar;
    }

    public void a(b bVar) {
        this.aCO = bVar;
    }

    public void DH() {
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            this.writeImagesInfo.clear();
        }
        DF();
        if (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) {
            this.mVideoInfo = null;
        }
        CS().b(new com.baidu.tbadk.editortools.a(2, 19, null));
        setVoiceModel(null);
        CS().b(new com.baidu.tbadk.editortools.a(2, 6, null));
        CS().b(new com.baidu.tbadk.editortools.a(33, 6, null));
        if (!StringUtils.isNull(this.aCA)) {
            this.aCA = "";
        }
        fT("");
        this.mGraffitiFileName = null;
        CS().b(new com.baidu.tbadk.editortools.a(42, 24, null));
        this.aCE.setWriteData(null);
        this.aCE.mC(false);
    }

    public void eM(final int i) {
        if (this.aCQ == null && CS() != null) {
            this.aCQ = (com.baidu.tbadk.editortools.inputtool.a) CS().eC(3);
        }
        if (this.aCQ != null && (this.aCQ.aAL instanceof EditText)) {
            final EditText editText = (EditText) this.aCQ.aAL;
            this.aCQ.b(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.c.8
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
                        if (!StringUtils.isNull(obj) && v.gO(obj) > i) {
                            String d = v.d(obj, 0, i - 1);
                            editText.setText(d);
                            editText.setSelection(editText.getText().length());
                            UtilHelper.showToast(c.this.getContext().getApplication(), c.this.getContext().getResources().getString(d.l.edit_text_over_limit_tip, Integer.valueOf(d.length())));
                        }
                    }
                }
            });
        }
    }

    public void DI() {
        if (this.aCQ != null) {
            this.aCQ.b(null);
        }
    }

    public void setGraffitiFileName(String str) {
        this.mGraffitiFileName = str;
    }
}
