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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.aa;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.editortools.f implements aa.a {
    private long authorId;
    private String authorName;
    private String ava;
    private VoiceData.VoiceModel avb;
    private String avc;
    private LocationModel avd;
    private NewWriteModel ave;
    private ImageModel avf;
    private DataModel<?> avg;
    private AntiData avh;
    private ForumData avi;
    private String avj;
    private boolean avk;
    private int avl;
    private NewWriteModel.d avm;
    private b avn;
    private com.baidu.tbadk.editortools.imagetool.b avo;
    private com.baidu.tbadk.editortools.inputtool.a avp;
    private com.baidu.tbadk.editortools.sendtool.a avq;
    private LocationModel.a avr;
    private LocationModel.b avs;
    private final NewWriteModel.d avt;
    private final com.baidu.adp.base.f avu;
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
        this.ava = "";
        this.ave = null;
        this.avf = null;
        this.mThreadId = null;
        this.avj = null;
        this.avk = true;
        this.avl = 0;
        this.avr = new d(this);
        this.avs = new e(this);
        this.avt = new f(this);
        this.avu = new g(this);
    }

    private com.baidu.tbadk.editortools.sendtool.a CV() {
        if (this.avq == null && Cw() != null) {
            this.avq = (com.baidu.tbadk.editortools.sendtool.a) Cw().eD(4);
        }
        return this.avq;
    }

    public void eK(int i) {
        if (this.avq == null && Cw() != null) {
            this.avq = (com.baidu.tbadk.editortools.sendtool.a) Cw().eD(4);
        }
        if (this.avq != null) {
            this.avq.setType(i);
        }
    }

    public void eL(int i) {
        if (this.avq == null && Cw() != null) {
            this.avq = (com.baidu.tbadk.editortools.sendtool.a) Cw().eD(4);
        }
        if (this.avq != null) {
            this.avq.eO(i);
        }
    }

    private com.baidu.tbadk.editortools.imagetool.b CW() {
        if (this.avo == null && Cw() != null) {
            this.avo = (com.baidu.tbadk.editortools.imagetool.b) Cw().eD(11);
        }
        return this.avo;
    }

    public void eM(int i) {
        if (this.avo == null && Cw() != null) {
            this.avo = (com.baidu.tbadk.editortools.imagetool.b) Cw().eD(11);
        }
        if (this.avo != null) {
            this.avo.eJ(i);
        }
    }

    public com.baidu.tbadk.editortools.inputtool.a CX() {
        if (this.avp == null && Cw() != null) {
            this.avp = (com.baidu.tbadk.editortools.inputtool.a) Cw().eD(3);
        }
        return this.avp;
    }

    public void fA(String str) {
        if (this.avp == null && Cw() != null) {
            this.avp = (com.baidu.tbadk.editortools.inputtool.a) Cw().eD(3);
        }
        if (this.avp != null) {
            this.avp.setHint(str);
        }
    }

    public void bF(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (Cw() != null && (cVar = (com.baidu.tbadk.editortools.c) Cw().eB(5)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bG(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (Cw() != null && (cVar = (com.baidu.tbadk.editortools.c) Cw().eB(23)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bH(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (Cw() != null && (cVar = (com.baidu.tbadk.editortools.c) Cw().eB(2)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.avg = dataModel;
    }

    public void d(BaseActivity<?> baseActivity) {
        this.mContext = baseActivity;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.avk = antiData.isIfvoice();
            this.avj = antiData.getVoice_message();
        }
        this.avh = antiData;
    }

    public void a(ForumData forumData, UserData userData) {
        this.avi = forumData;
        this.mUserData = userData;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (Cw() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void CY() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            String valueOf = String.valueOf(this.authorId);
            if (valueOf == null || valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                com.baidu.adp.lib.util.k.showToast(this.mContext.getActivity(), r.l.can_not_send_gift_to_yourself);
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
                        if (a.CT().getStatus() == 1) {
                            if (CW() != null) {
                                CW().eJ(1);
                            }
                            if (getWriteImagesInfo() != null) {
                                getWriteImagesInfo().setMaxImagesAllowed(1);
                            }
                        } else {
                            if (CW() != null) {
                                CW().eJ(10);
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
                        if (Cw() != null) {
                            pVar2 = Cw().eB(2);
                            pVar = Cw().eB(5);
                            pVar3 = Cw().eB(23);
                        } else {
                            pVar = null;
                            pVar2 = null;
                        }
                        if (a.CT().getStatus() == 1) {
                            Dl();
                            if (Cw() != null) {
                                Cw().CE();
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL));
                            }
                            if (pVar2 != null) {
                                pVar2.hide();
                            }
                            if (pVar != null) {
                                pVar.hide();
                            }
                            if (pVar3 != null) {
                                pVar3.lr();
                            }
                            if (CX() != null) {
                                CX().setHint(this.mContext.getPageContext().getString(r.l.add_picture_description));
                            }
                            if (CW() != null) {
                                CW().ft(this.mContext.getPageContext().getString(r.l.show_pic_tip));
                                CW().fu(this.mContext.getPageContext().getString(r.l.show_pic_add_tip));
                            }
                            if (CV() != null) {
                                CV().setType(SendView.avN);
                                CV().eO(SendView.avN);
                            }
                        } else {
                            if (pVar2 != null) {
                                pVar2.lr();
                            }
                            if (pVar != null) {
                                pVar.lr();
                            }
                            if (pVar3 != null) {
                                pVar3.hide();
                            }
                            if (CX() != null) {
                                CX().setHint(this.mContext.getPageContext().getString(r.l.pb_reply_hint));
                            }
                            if (CV() != null) {
                                CV().setType(SendView.ALL);
                                CV().eO(SendView.ALL);
                            }
                        }
                        Cw().invalidate();
                        return;
                    }
                    return;
                case 12003:
                    if (intent != null) {
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            Di();
                            this.ave.lm(false);
                            return;
                        }
                        this.avf.fz(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case 12004:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra(IntentConfig.NAME_SHOW)) != null) {
                        r(stringArrayListExtra);
                        return;
                    }
                    return;
                case 12006:
                    WriteData writeData = this.ave.getWriteData();
                    if (writeData != null) {
                        writeData.deleteUploadedTempImages();
                    }
                    this.ave.setWriteData(null);
                    this.ave.lm(false);
                    this.avb = null;
                    this.mVideoInfo = null;
                    this.mGraffitiFileName = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        aa.c(this.mThreadId, (WriteData) null);
                    }
                    bJ(true);
                    if (this.avm != null) {
                        this.avm.callback(true, null, null, writeData, null);
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    if (i == 12010) {
                        c(intent);
                        return;
                    }
                    return;
                case 12012:
                    d(intent);
                    if (a.CT().getStatus() == 1 && CW() != null) {
                        CW().ft(this.mContext.getPageContext().getString(r.l.show_pic_tip));
                        return;
                    }
                    return;
                case 13010:
                    if (Cw() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            ar arVar = new ar("c10068");
                            arVar.s("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(arVar);
                            Dj();
                            Cw().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            Cw().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                        fE(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 12001:
                Df();
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

    public void CZ() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.mContext.getActivity())));
    }

    public void Da() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.mContext.getActivity())) {
            this.mContext.showToast(r.l.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.m9getInst().getLocationShared()) {
            Db();
        } else if (this.avd.bix()) {
            CZ();
        } else {
            this.avd.lk(false);
            b(1, true, null);
            this.avd.biv();
        }
    }

    private void Db() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getActivity());
        aVar.ca(r.l.location_app_permission_prompt).a(r.l.isopen, new h(this)).b(r.l.cancel, new i(this)).b(this.mContext.getPageContext());
        aVar.sV();
    }

    public void Dc() {
        if (this.avd.OH()) {
            if (this.avd.bix()) {
                this.avr.a(com.baidu.tieba.tbadkCore.location.c.bit().getLocationData());
                return;
            }
            if (com.baidu.adp.lib.util.k.gB()) {
                this.avd.biv();
            }
            b(0, true, null);
            return;
        }
        b(0, false, null);
    }

    public boolean Dd() {
        if (StringUtils.isNull(this.ava)) {
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() <= 0) {
                if (this.avb == null || StringUtils.isNull(this.avb.getId())) {
                    return (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) || this.mGraffitiFileName != null;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    public void resetData() {
        this.ave.setWriteData(null);
        this.ave.lm(false);
        this.avb = null;
        this.mVideoInfo = null;
        this.mGraffitiFileName = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void De() {
        this.mVideoInfo = null;
    }

    private void c(Intent intent) {
        this.avc = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.avc;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.k.dip2px(this.mContext.getActivity(), com.baidu.adp.lib.util.k.I(this.mContext.getActivity())), com.baidu.adp.lib.util.k.dip2px(this.mContext.getActivity(), com.baidu.adp.lib.util.k.J(this.mContext.getActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.l.a(TbConfig.LOCAL_CAMERA_DIR, this.avc, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            Dk();
        }
    }

    private void d(Intent intent) {
        b(intent, false);
    }

    private void b(Intent intent, boolean z) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                Dk();
            }
        }
    }

    private void Df() {
        new j(this).execute(new Void[0]);
    }

    private void e(Intent intent) {
        b(intent, true);
    }

    private void f(Intent intent) {
        int size;
        int size2;
        c(intent);
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() - 1 > -1 && this.writeImagesInfo.getChosedFiles() != null && (size2 = this.writeImagesInfo.getChosedFiles().size()) >= 1 && size >= 0 && size < size2) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.mContext.getActivity(), 12012, this.writeImagesInfo, size)));
        }
    }

    public void fB(String str) {
        WriteData writeData = this.ave.getWriteData();
        if (writeData == null) {
            writeData = new WriteData(1);
            writeData.setThreadId(str);
            writeData.setWriteImagesInfo(this.writeImagesInfo);
        }
        writeData.setContent(this.ava);
        writeData.setVideoInfo(this.mVideoInfo);
        writeData.setGraffitiFileName(this.mGraffitiFileName);
        aa.c(str, writeData);
    }

    public void fC(String str) {
        aa.a(str, this);
    }

    @Override // com.baidu.tieba.tbadkCore.aa.a
    public void a(WriteData writeData) {
        if (writeData != null) {
            if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                if (this.mVideoInfo == null) {
                    this.mVideoInfo = new VideoInfo();
                }
                this.mVideoInfo.copy(writeData.getVideoInfo());
                Dj();
                Cw().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                bI(false);
            }
            this.mGraffitiFileName = writeData.getGraffitiFileName();
            if (Cw() != null && !at.isEmpty(this.mGraffitiFileName)) {
                Cw().b(new com.baidu.tbadk.editortools.a(42, 24, this.mGraffitiFileName));
            }
            if (!at.isEmpty(writeData.getContent()) && at.isEmpty(this.ava)) {
                this.ava = writeData.getContent();
                fF(this.ava);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.ave.cancelLoadData();
        this.avf.cancelLoadData();
        this.avd.cancelLoadData();
    }

    public void Dg() {
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        this.ave = new NewWriteModel(baseActivity);
        this.ave.b(this.avt);
        this.avf = new ImageModel(baseActivity);
        this.avf.setLoadDataCallBack(this.avu);
        this.avd = new LocationModel(baseActivity);
        this.avd.a(this.avr);
        this.avd.a(this.avs);
        if (bundle != null) {
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.avc = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(10);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.m9getInst().getDefaultBubble()) && Cw() != null) {
            Cw().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.avd.OH() && Cw() != null) {
            Cw().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.avc);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.ave.getWriteData() == null) {
            this.ave.setWriteData(this.avg.fy(str));
        }
        if (this.ave.getWriteData() != null) {
            this.ave.getWriteData().setWriteImagesInfo(this.writeImagesInfo);
            this.ave.getWriteData().setVideoInfo(this.mVideoInfo);
            this.ave.getWriteData().setGraffitiFileName(this.mGraffitiFileName);
            this.ave.lm(this.writeImagesInfo.size() > 0);
            WriteData writeData2 = this.ave.getWriteData();
            if (this.avd == null || !this.avd.OH()) {
                z = false;
            }
            writeData2.setHasLocationData(z);
            if (str == null) {
                this.ave.getWriteData().setContent(this.ava);
            }
            if (this.avb != null) {
                if (this.avb.getId() != null) {
                    this.ave.getWriteData().setVoice(this.avb.getId());
                    this.ave.getWriteData().setVoiceDuringTime(this.avb.duration);
                } else {
                    this.ave.getWriteData().setVoice(null);
                    this.ave.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.ave.getWriteData().setVoice(null);
                this.ave.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.ave.biT()) {
                this.mContext.showToast(r.l.write_img_limit);
                return;
            }
            if (this.avn != null) {
                this.avn.CU();
            }
            if (!this.ave.startPostWrite()) {
            }
        }
    }

    public BaseActivity<?> getContext() {
        return this.mContext;
    }

    public void fD(String str) {
        this.ava = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.avb = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int Dh() {
        return this.avl;
    }

    private void Di() {
        if (Cw() != null) {
            Cw().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void r(ArrayList<String> arrayList) {
        if (Cw() != null) {
            Cw().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    public void fE(String str) {
        if (Cw() != null) {
            Cw().b(new com.baidu.tbadk.editortools.a(44, 3, str));
        }
    }

    private void Dj() {
        if (Cw() != null) {
            Cw().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    protected void bI(boolean z) {
        if (Cw() != null) {
            if (z) {
                Cw().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            Cw().b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                Cw().b(new com.baidu.tbadk.editortools.a(2, 10, new StringBuilder(String.valueOf(this.writeImagesInfo.getChosedFiles().size())).toString()));
            } else {
                Cw().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
        }
    }

    protected void Dk() {
        bI(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Dl() {
        if (Cw() != null) {
            Cw().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.avl = i;
        if (Cw() != null) {
            Cw().b(new com.baidu.tbadk.editortools.a(19, 8, new com.baidu.tbadk.editortools.d.a(i, z, str)));
            if (i == 2) {
                Cw().b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            } else {
                Cw().b(new com.baidu.tbadk.editortools.a(2, 7, null));
            }
        }
    }

    private void fF(String str) {
        if (Cw() != null) {
            Cw().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJ(boolean z) {
        if (Cw() != null) {
            Cw().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.avm = dVar;
    }

    public void a(b bVar) {
        this.avn = bVar;
    }

    public void Dm() {
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            this.writeImagesInfo.clear();
        }
        Dk();
        if (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) {
            this.mVideoInfo = null;
        }
        Cw().b(new com.baidu.tbadk.editortools.a(2, 19, null));
        setVoiceModel(null);
        Cw().b(new com.baidu.tbadk.editortools.a(2, 6, null));
        Cw().b(new com.baidu.tbadk.editortools.a(33, 6, null));
        if (!StringUtils.isNull(this.ava)) {
            this.ava = "";
        }
        fF("");
        this.mGraffitiFileName = null;
        Cw().b(new com.baidu.tbadk.editortools.a(42, 24, null));
        this.ave.setWriteData(null);
        this.ave.lm(false);
    }

    public void eN(int i) {
        if (this.avp == null && Cw() != null) {
            this.avp = (com.baidu.tbadk.editortools.inputtool.a) Cw().eD(3);
        }
        if (this.avp != null && (this.avp.atm instanceof EditText)) {
            this.avp.b(new k(this, i, (EditText) this.avp.atm));
        }
    }

    public void Dn() {
        if (this.avp != null) {
            this.avp.b(null);
        }
    }

    public void setGraffitiFileName(String str) {
        this.mGraffitiFileName = str;
    }
}
