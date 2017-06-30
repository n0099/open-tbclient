package com.baidu.tbadk.editortools.pb;

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
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
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
import com.baidu.tbadk.core.frameworkData.IntentConfig;
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
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.x;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.editortools.f implements x.a {
    private String aBA;
    private VoiceData.VoiceModel aBB;
    private String aBC;
    private LocationModel aBD;
    private NewWriteModel aBE;
    private ImageModel aBF;
    private DataModel<?> aBG;
    private AntiData aBH;
    private ForumData aBI;
    private String aBJ;
    private boolean aBK;
    private int aBL;
    private NewWriteModel.d aBM;
    private b aBN;
    private com.baidu.tbadk.editortools.imagetool.b aBO;
    private com.baidu.tbadk.editortools.inputtool.a aBP;
    private com.baidu.tbadk.editortools.sendtool.a aBQ;
    private boolean aBR;
    private LocationModel.a aBS;
    private LocationModel.b aBT;
    private final NewWriteModel.d aBU;
    private final com.baidu.adp.base.f aBV;
    private long authorId;
    private String authorName;
    private BaseActivity<?> mContext;
    private String mGraffitiFileName;
    private String mThreadId;
    private UserData mUserData;
    private VideoInfo mVideoInfo;
    private String postId;
    private WriteImagesInfo writeImagesInfo;

    public c(com.baidu.tbadk.editortools.j jVar) {
        super(jVar);
        this.writeImagesInfo = new WriteImagesInfo();
        this.aBA = "";
        this.aBE = null;
        this.aBF = null;
        this.mThreadId = null;
        this.aBJ = null;
        this.aBK = true;
        this.aBL = 0;
        this.aBR = false;
        this.aBS = new d(this);
        this.aBT = new e(this);
        this.aBU = new f(this);
        this.aBV = new g(this);
    }

    private com.baidu.tbadk.editortools.sendtool.a De() {
        if (this.aBQ == null && CG() != null) {
            this.aBQ = (com.baidu.tbadk.editortools.sendtool.a) CG().eA(4);
        }
        return this.aBQ;
    }

    public void eH(int i) {
        if (this.aBQ == null && CG() != null) {
            this.aBQ = (com.baidu.tbadk.editortools.sendtool.a) CG().eA(4);
        }
        if (this.aBQ != null) {
            this.aBQ.setType(i);
        }
    }

    public void eI(int i) {
        if (this.aBQ == null && CG() != null) {
            this.aBQ = (com.baidu.tbadk.editortools.sendtool.a) CG().eA(4);
        }
        if (this.aBQ != null) {
            this.aBQ.eL(i);
        }
    }

    private com.baidu.tbadk.editortools.imagetool.b Df() {
        if (this.aBO == null && CG() != null) {
            this.aBO = (com.baidu.tbadk.editortools.imagetool.b) CG().eA(11);
        }
        return this.aBO;
    }

    public void eJ(int i) {
        if (this.aBO == null && CG() != null) {
            this.aBO = (com.baidu.tbadk.editortools.imagetool.b) CG().eA(11);
        }
        if (this.aBO != null) {
            this.aBO.eG(i);
        }
    }

    public com.baidu.tbadk.editortools.inputtool.a Dg() {
        if (this.aBP == null && CG() != null) {
            this.aBP = (com.baidu.tbadk.editortools.inputtool.a) CG().eA(3);
        }
        return this.aBP;
    }

    public void fK(String str) {
        if (this.aBP == null && CG() != null) {
            this.aBP = (com.baidu.tbadk.editortools.inputtool.a) CG().eA(3);
        }
        if (this.aBP != null) {
            this.aBP.setHint(str);
        }
    }

    public void bF(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (CG() != null && (cVar = (com.baidu.tbadk.editortools.c) CG().ey(5)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bG(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (CG() != null && (cVar = (com.baidu.tbadk.editortools.c) CG().ey(23)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bH(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (CG() != null && (cVar = (com.baidu.tbadk.editortools.c) CG().ey(2)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.aBG = dataModel;
    }

    public void d(BaseActivity<?> baseActivity) {
        this.mContext = baseActivity;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.aBK = antiData.isIfvoice();
            this.aBJ = antiData.getVoice_message();
        }
        this.aBH = antiData;
    }

    public void a(ForumData forumData, UserData userData) {
        this.aBI = forumData;
        this.mUserData = userData;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (CG() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void bI(boolean z) {
        this.aBR = z;
    }

    public void Dh() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            String valueOf = String.valueOf(this.authorId);
            if (valueOf == null || valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                com.baidu.adp.lib.util.k.showToast(this.mContext.getActivity(), w.l.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.mContext.getActivity(), this.authorId, this.authorName, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.g.b.c(this.mThreadId, 0L), com.baidu.adp.lib.g.b.c(this.postId, 0L))));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        com.baidu.tbadk.editortools.p pVar;
        com.baidu.tbadk.editortools.p pVar2;
        com.baidu.tbadk.editortools.p pVar3 = null;
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
                        if (a.Dc().getStatus() == 1) {
                            if (Df() != null) {
                                Df().eG(1);
                            }
                            if (getWriteImagesInfo() != null) {
                                getWriteImagesInfo().setMaxImagesAllowed(1);
                            }
                        } else {
                            if (Df() != null) {
                                Df().eG(10);
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
                        if (CG() != null) {
                            pVar2 = CG().ey(2);
                            pVar = CG().ey(5);
                            pVar3 = CG().ey(23);
                        } else {
                            pVar = null;
                            pVar2 = null;
                        }
                        if (a.Dc().getStatus() == 1) {
                            Du();
                            if (CG() != null) {
                                CG().CP();
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL));
                            }
                            if (pVar2 != null) {
                                pVar2.hide();
                            }
                            if (pVar != null) {
                                pVar.hide();
                            }
                            if (pVar3 != null) {
                                pVar3.lM();
                            }
                            if (Dg() != null) {
                                Dg().setHint(this.mContext.getPageContext().getString(w.l.add_picture_description));
                            }
                            if (Df() != null) {
                                Df().fD(this.mContext.getPageContext().getString(w.l.show_pic_tip));
                                Df().fE(this.mContext.getPageContext().getString(w.l.show_pic_add_tip));
                            }
                            if (De() != null) {
                                De().setType(SendView.aCo);
                                De().eL(SendView.aCo);
                            }
                        } else {
                            if (pVar2 != null) {
                                pVar2.lM();
                            }
                            if (pVar != null) {
                                pVar.lM();
                            }
                            if (pVar3 != null) {
                                pVar3.hide();
                            }
                            if (Dg() != null) {
                                Dg().setHint(this.mContext.getPageContext().getString(w.l.pb_reply_hint));
                            }
                            if (De() != null) {
                                De().setType(SendView.ALL);
                                De().eL(SendView.ALL);
                            }
                        }
                        CG().invalidate();
                        return;
                    }
                    return;
                case 12003:
                    if (intent != null) {
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            Dr();
                            this.aBE.lW(false);
                            return;
                        }
                        this.aBF.fJ(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case 12004:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra(IntentConfig.NAME_SHOW)) != null) {
                        q(stringArrayListExtra);
                        return;
                    }
                    return;
                case 12006:
                    WriteData writeData = this.aBE.getWriteData();
                    if (writeData != null) {
                        writeData.deleteUploadedTempImages();
                    }
                    this.aBE.setWriteData(null);
                    this.aBE.lW(false);
                    this.aBB = null;
                    this.mVideoInfo = null;
                    this.mGraffitiFileName = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        x.c(this.mThreadId, (WriteData) null);
                    }
                    bK(true);
                    if (this.aBM != null) {
                        this.aBM.callback(true, null, null, writeData, null);
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
                    if (a.Dc().getStatus() == 1 && Df() != null) {
                        Df().fD(this.mContext.getPageContext().getString(w.l.show_pic_tip));
                        return;
                    }
                    return;
                case 13010:
                    if (CG() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            au auVar = new au("c10068");
                            auVar.r("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(auVar);
                            Ds();
                            CG().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            CG().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                        fO(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 12001:
                Do();
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

    public void Di() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.mContext.getActivity())));
    }

    public void Dj() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.mContext.getActivity())) {
            this.mContext.showToast(w.l.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.m9getInst().getLocationShared()) {
            Dk();
        } else if (this.aBD.bne()) {
            Di();
        } else {
            this.aBD.lU(false);
            b(1, true, null);
            this.aBD.bnc();
        }
    }

    private void Dk() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getActivity());
        aVar.bY(w.l.location_app_permission_prompt).a(w.l.isopen, new h(this)).b(w.l.cancel, new i(this)).b(this.mContext.getPageContext());
        aVar.ta();
    }

    public void Dl() {
        if (this.aBD.Sy()) {
            if (this.aBD.bne()) {
                this.aBS.a(com.baidu.tieba.tbadkCore.location.d.bna().getLocationData());
                return;
            }
            if (com.baidu.adp.lib.util.k.hA()) {
                this.aBD.bnc();
            }
            b(0, true, null);
            return;
        }
        b(0, false, null);
    }

    public boolean Dm() {
        if (StringUtils.isNull(this.aBA)) {
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() <= 0) {
                if (this.aBB == null || StringUtils.isNull(this.aBB.getId())) {
                    return (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) || this.mGraffitiFileName != null;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    public void resetData() {
        this.aBE.setWriteData(null);
        this.aBE.lW(false);
        this.aBB = null;
        this.mVideoInfo = null;
        this.mGraffitiFileName = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void Dn() {
        this.mVideoInfo = null;
    }

    private void A(Intent intent) {
        this.aBC = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aBC;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.k.dip2px(this.mContext.getActivity(), com.baidu.adp.lib.util.k.af(this.mContext.getActivity())), com.baidu.adp.lib.util.k.dip2px(this.mContext.getActivity(), com.baidu.adp.lib.util.k.ag(this.mContext.getActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.n.a(TbConfig.LOCAL_CAMERA_DIR, this.aBC, rotateBitmapBydegree, 100);
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

    private void B(Intent intent) {
        b(intent, false);
    }

    private void b(Intent intent, boolean z) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                Dt();
            }
        }
    }

    private void Do() {
        new j(this).execute(new Void[0]);
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

    public void fL(String str) {
        WriteData writeData = this.aBE.getWriteData();
        if (writeData == null) {
            writeData = new WriteData(1);
            writeData.setThreadId(str);
            writeData.setWriteImagesInfo(this.writeImagesInfo);
        }
        writeData.setContent(this.aBA);
        writeData.setVideoInfo(this.mVideoInfo);
        writeData.setGraffitiFileName(this.mGraffitiFileName);
        x.c(str, writeData);
    }

    public void fM(String str) {
        x.a(str, this);
    }

    @Override // com.baidu.tieba.tbadkCore.x.a
    public void a(WriteData writeData) {
        if (writeData != null) {
            if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                if (this.mVideoInfo == null) {
                    this.mVideoInfo = new VideoInfo();
                }
                this.mVideoInfo.copy(writeData.getVideoInfo());
                Ds();
                CG().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                bJ(false);
            }
            this.mGraffitiFileName = writeData.getGraffitiFileName();
            if (CG() != null && !aw.isEmpty(this.mGraffitiFileName)) {
                CG().b(new com.baidu.tbadk.editortools.a(42, 24, this.mGraffitiFileName));
            }
            if (!aw.isEmpty(writeData.getContent()) && aw.isEmpty(this.aBA)) {
                this.aBA = writeData.getContent();
                fP(this.aBA);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.aBE.cancelLoadData();
        this.aBF.cancelLoadData();
        this.aBD.cancelLoadData();
    }

    public void Dp() {
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        this.aBE = new NewWriteModel(baseActivity);
        this.aBE.b(this.aBU);
        this.aBF = new ImageModel(baseActivity);
        this.aBF.setLoadDataCallBack(this.aBV);
        this.aBD = new LocationModel(baseActivity);
        this.aBD.a(this.aBS);
        this.aBD.a(this.aBT);
        if (bundle != null) {
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.aBC = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(10);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.m9getInst().getDefaultBubble()) && CG() != null) {
            CG().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.aBD.Sy() && CG() != null) {
            CG().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aBC);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.aBE.getWriteData() == null) {
            this.aBE.setWriteData(this.aBG.fI(str));
        }
        if (this.aBE.getWriteData() != null) {
            if (this.aBR) {
                this.aBE.getWriteData().setCanNoForum(true);
                if (this.aBI != null) {
                    this.aBE.getWriteData().setVForumId(this.aBI.getId());
                    this.aBE.getWriteData().setVForumName(this.aBI.getName());
                }
            } else {
                this.aBE.getWriteData().setCanNoForum(false);
                this.aBE.getWriteData().setVForumId("");
                this.aBE.getWriteData().setVForumName("");
            }
            this.aBE.getWriteData().setWriteImagesInfo(this.writeImagesInfo);
            this.aBE.getWriteData().setVideoInfo(this.mVideoInfo);
            this.aBE.getWriteData().setGraffitiFileName(this.mGraffitiFileName);
            this.aBE.lW(this.writeImagesInfo.size() > 0);
            WriteData writeData2 = this.aBE.getWriteData();
            if (this.aBD == null || !this.aBD.Sy()) {
                z = false;
            }
            writeData2.setHasLocationData(z);
            if (str == null) {
                this.aBE.getWriteData().setContent(this.aBA);
            }
            if (this.aBB != null) {
                if (this.aBB.getId() != null) {
                    this.aBE.getWriteData().setVoice(this.aBB.getId());
                    this.aBE.getWriteData().setVoiceDuringTime(this.aBB.duration);
                } else {
                    this.aBE.getWriteData().setVoice(null);
                    this.aBE.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.aBE.getWriteData().setVoice(null);
                this.aBE.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.aBE.bnA()) {
                this.mContext.showToast(w.l.write_img_limit);
                return;
            }
            if (this.aBN != null) {
                this.aBN.Dd();
            }
            if (!this.aBE.startPostWrite()) {
            }
        }
    }

    public BaseActivity<?> getContext() {
        return this.mContext;
    }

    public void fN(String str) {
        this.aBA = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.aBB = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int Dq() {
        return this.aBL;
    }

    private void Dr() {
        if (CG() != null) {
            CG().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void q(ArrayList<String> arrayList) {
        if (CG() != null) {
            CG().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    public void fO(String str) {
        if (CG() != null) {
            CG().b(new com.baidu.tbadk.editortools.a(44, 3, str));
        }
    }

    private void Ds() {
        if (CG() != null) {
            CG().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    protected void bJ(boolean z) {
        if (CG() != null) {
            if (z) {
                CG().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            CG().b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                CG().b(new com.baidu.tbadk.editortools.a(2, 10, new StringBuilder(String.valueOf(this.writeImagesInfo.getChosedFiles().size())).toString()));
            } else {
                CG().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
        }
    }

    protected void Dt() {
        bJ(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Du() {
        if (CG() != null) {
            CG().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.aBL = i;
        if (CG() != null) {
            CG().b(new com.baidu.tbadk.editortools.a(19, 8, new com.baidu.tbadk.editortools.d.a(i, z, str)));
            if (i == 2) {
                CG().b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            } else {
                CG().b(new com.baidu.tbadk.editortools.a(2, 7, null));
            }
        }
    }

    private void fP(String str) {
        if (CG() != null) {
            CG().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bK(boolean z) {
        if (CG() != null) {
            CG().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.aBM = dVar;
    }

    public void a(b bVar) {
        this.aBN = bVar;
    }

    public void Dv() {
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            this.writeImagesInfo.clear();
        }
        Dt();
        if (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) {
            this.mVideoInfo = null;
        }
        CG().b(new com.baidu.tbadk.editortools.a(2, 19, null));
        setVoiceModel(null);
        CG().b(new com.baidu.tbadk.editortools.a(2, 6, null));
        CG().b(new com.baidu.tbadk.editortools.a(33, 6, null));
        if (!StringUtils.isNull(this.aBA)) {
            this.aBA = "";
        }
        fP("");
        this.mGraffitiFileName = null;
        CG().b(new com.baidu.tbadk.editortools.a(42, 24, null));
        this.aBE.setWriteData(null);
        this.aBE.lW(false);
    }

    public void eK(int i) {
        if (this.aBP == null && CG() != null) {
            this.aBP = (com.baidu.tbadk.editortools.inputtool.a) CG().eA(3);
        }
        if (this.aBP != null && (this.aBP.azL instanceof EditText)) {
            this.aBP.b(new k(this, i, (EditText) this.aBP.azL));
        }
    }

    public void Dw() {
        if (this.aBP != null) {
            this.aBP.b(null);
        }
    }

    public void setGraffitiFileName(String str) {
        this.mGraffitiFileName = str;
    }
}
