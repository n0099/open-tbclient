package com.baidu.tbadk.editortools.e;

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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.ac;
import com.baidu.tieba.tbadkCore.location.d;
import com.baidu.tieba.tbadkCore.writeModel.b;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.editortools.f implements ac.a {
    private long authorId;
    private String authorName;
    private String avV;
    private VoiceData.VoiceModel avW;
    private String avX;
    private com.baidu.tieba.tbadkCore.location.d avY;
    private com.baidu.tieba.tbadkCore.writeModel.b avZ;
    private d awa;
    private a<?> awb;
    private AntiData awc;
    private ForumData awd;
    private BaseActivity<?> awe;
    private String awf;
    private boolean awg;
    private int awh;
    private b.d awi;
    private c awj;
    private com.baidu.tbadk.editortools.imagetool.b awk;
    private com.baidu.tbadk.editortools.inputtool.a awl;
    private com.baidu.tbadk.editortools.sendtool.a awm;
    private d.a awn;
    private d.b awo;
    private final b.d awp;
    private final com.baidu.adp.base.g awq;
    private String mGraffitiFileName;
    private String mThreadId;
    private UserData mUserData;
    private VideoInfo mVideoInfo;
    private String postId;
    private WriteImagesInfo writeImagesInfo;

    public e(com.baidu.tbadk.editortools.j jVar) {
        super(jVar);
        this.writeImagesInfo = new WriteImagesInfo();
        this.avV = "";
        this.avZ = null;
        this.awa = null;
        this.mThreadId = null;
        this.awf = null;
        this.awg = true;
        this.awh = 0;
        this.awn = new f(this);
        this.awo = new g(this);
        this.awp = new h(this);
        this.awq = new i(this);
    }

    private com.baidu.tbadk.editortools.sendtool.a Da() {
        if (this.awm == null && CB() != null) {
            this.awm = (com.baidu.tbadk.editortools.sendtool.a) CB().eC(4);
        }
        return this.awm;
    }

    public void eJ(int i) {
        if (this.awm == null && CB() != null) {
            this.awm = (com.baidu.tbadk.editortools.sendtool.a) CB().eC(4);
        }
        if (this.awm != null) {
            this.awm.setType(i);
        }
    }

    public void eK(int i) {
        if (this.awm == null && CB() != null) {
            this.awm = (com.baidu.tbadk.editortools.sendtool.a) CB().eC(4);
        }
        if (this.awm != null) {
            this.awm.eN(i);
        }
    }

    private com.baidu.tbadk.editortools.imagetool.b Db() {
        if (this.awk == null && CB() != null) {
            this.awk = (com.baidu.tbadk.editortools.imagetool.b) CB().eC(11);
        }
        return this.awk;
    }

    public void eL(int i) {
        if (this.awk == null && CB() != null) {
            this.awk = (com.baidu.tbadk.editortools.imagetool.b) CB().eC(11);
        }
        if (this.awk != null) {
            this.awk.eI(i);
        }
    }

    public com.baidu.tbadk.editortools.inputtool.a Dc() {
        if (this.awl == null && CB() != null) {
            this.awl = (com.baidu.tbadk.editortools.inputtool.a) CB().eC(3);
        }
        return this.awl;
    }

    public void fD(String str) {
        if (this.awl == null && CB() != null) {
            this.awl = (com.baidu.tbadk.editortools.inputtool.a) CB().eC(3);
        }
        if (this.awl != null) {
            this.awl.setHint(str);
        }
    }

    public void bF(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (CB() != null && (cVar = (com.baidu.tbadk.editortools.c) CB().eA(5)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bG(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (CB() != null && (cVar = (com.baidu.tbadk.editortools.c) CB().eA(23)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bH(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (CB() != null && (cVar = (com.baidu.tbadk.editortools.c) CB().eA(2)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void a(a<?> aVar) {
        this.awb = aVar;
    }

    public void d(BaseActivity<?> baseActivity) {
        this.awe = baseActivity;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.awg = antiData.isIfvoice();
            this.awf = antiData.getVoice_message();
        }
        this.awc = antiData;
    }

    public void a(ForumData forumData, UserData userData) {
        this.awd = forumData;
        this.mUserData = userData;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (CB() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void Dd() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            String valueOf = String.valueOf(this.authorId);
            if (valueOf == null || valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                com.baidu.adp.lib.util.k.showToast(this.awe.getActivity(), r.j.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.awe.getActivity(), this.authorId, this.authorName, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.h.b.c(this.mThreadId, 0L), com.baidu.adp.lib.h.b.c(this.postId, 0L))));
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.awe.getActivity(), 12004, true)));
                    return;
                case 11026:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.awe.getActivity(), 12005, true)));
                    return;
                case 12002:
                    if (intent != null) {
                        boolean booleanExtra = intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false);
                        if (b.CY().getStatus() == 1) {
                            if (Db() != null) {
                                Db().eI(1);
                            }
                            if (getWriteImagesInfo() != null) {
                                getWriteImagesInfo().setMaxImagesAllowed(1);
                            }
                        } else {
                            if (Db() != null) {
                                Db().eI(10);
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
                        if (CB() != null) {
                            pVar2 = CB().eA(2);
                            pVar = CB().eA(5);
                            pVar3 = CB().eA(23);
                        } else {
                            pVar = null;
                            pVar2 = null;
                        }
                        if (b.CY().getStatus() == 1) {
                            Dq();
                            if (CB() != null) {
                                CB().CJ();
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL));
                            }
                            if (pVar2 != null) {
                                pVar2.hide();
                            }
                            if (pVar != null) {
                                pVar.hide();
                            }
                            if (pVar3 != null) {
                                pVar3.lz();
                            }
                            if (Dc() != null) {
                                Dc().setHint(this.awe.getPageContext().getString(r.j.add_picture_description));
                            }
                            if (Db() != null) {
                                Db().fw(this.awe.getPageContext().getString(r.j.show_pic_tip));
                                Db().fx(this.awe.getPageContext().getString(r.j.show_pic_add_tip));
                            }
                            if (Da() != null) {
                                Da().setType(SendView.awJ);
                                Da().eN(SendView.awJ);
                            }
                        } else {
                            if (pVar2 != null) {
                                pVar2.lz();
                            }
                            if (pVar != null) {
                                pVar.lz();
                            }
                            if (pVar3 != null) {
                                pVar3.hide();
                            }
                            if (Dc() != null) {
                                Dc().setHint(this.awe.getPageContext().getString(r.j.pb_reply_hint));
                            }
                            if (Da() != null) {
                                Da().setType(SendView.ALL);
                                Da().eN(SendView.ALL);
                            }
                        }
                        CB().invalidate();
                        return;
                    }
                    return;
                case 12003:
                    if (intent != null) {
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            Dn();
                            this.avZ.la(false);
                            return;
                        }
                        this.awa.fC(intent.getStringExtra("file_name"));
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
                    WriteData bbN = this.avZ.bbN();
                    if (bbN != null) {
                        bbN.deleteUploadedTempImages();
                    }
                    this.avZ.d((WriteData) null);
                    this.avZ.la(false);
                    this.avW = null;
                    this.mVideoInfo = null;
                    this.mGraffitiFileName = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        ac.c(this.mThreadId, (WriteData) null);
                    }
                    bJ(true);
                    if (this.awi != null) {
                        this.awi.callback(true, null, null, bbN, null);
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
                    if (b.CY().getStatus() == 1 && Db() != null) {
                        Db().fw(this.awe.getPageContext().getString(r.j.show_pic_tip));
                        return;
                    }
                    return;
                case 13010:
                    if (CB() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            at atVar = new at("c10068");
                            atVar.s("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(atVar);
                            Do();
                            CB().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            CB().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                        fH(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 12001:
                Dk();
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

    public void De() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.awe.getActivity())));
    }

    public void Df() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.awe.getActivity())) {
            this.awe.showToast(r.j.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.m9getInst().getLocationShared()) {
            Dg();
        } else if (this.avY.bgJ()) {
            De();
        } else {
            this.avY.kY(false);
            b(1, true, null);
            this.avY.bgH();
        }
    }

    private void Dg() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.awe.getActivity());
        aVar.cb(r.j.location_app_permission_prompt).a(r.j.isopen, new j(this)).b(r.j.cancel, new k(this)).b(this.awe.getPageContext());
        aVar.tb();
    }

    public void Dh() {
        if (this.avY.bgL()) {
            if (this.avY.bgJ()) {
                this.awn.a(com.baidu.tieba.tbadkCore.location.c.bgE().getLocationData());
                return;
            }
            if (com.baidu.adp.lib.util.k.gD()) {
                this.avY.bgH();
            }
            b(0, true, null);
            return;
        }
        b(0, false, null);
    }

    public boolean Di() {
        if (StringUtils.isNull(this.avV)) {
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() <= 0) {
                if (this.avW == null || StringUtils.isNull(this.avW.getId())) {
                    return (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) || this.mGraffitiFileName != null;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    public void resetData() {
        this.avZ.d((WriteData) null);
        this.avZ.la(false);
        this.avW = null;
        this.mVideoInfo = null;
        this.mGraffitiFileName = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void Dj() {
        this.mVideoInfo = null;
    }

    private void c(Intent intent) {
        this.avX = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.avX;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.k.dip2px(this.awe.getActivity(), com.baidu.adp.lib.util.k.I(this.awe.getActivity())), com.baidu.adp.lib.util.k.dip2px(this.awe.getActivity(), com.baidu.adp.lib.util.k.J(this.awe.getActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.m.a(TbConfig.LOCAL_CAMERA_DIR, this.avX, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            Dp();
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
                Dp();
            }
        }
    }

    private void Dk() {
        new l(this).execute(new Void[0]);
    }

    private void e(Intent intent) {
        b(intent, true);
    }

    private void f(Intent intent) {
        int size;
        int size2;
        c(intent);
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() - 1 > -1 && this.writeImagesInfo.getChosedFiles() != null && (size2 = this.writeImagesInfo.getChosedFiles().size()) >= 1 && size >= 0 && size < size2) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.awe.getActivity(), 12012, this.writeImagesInfo, size)));
        }
    }

    public void fE(String str) {
        WriteData bbN = this.avZ.bbN();
        if (bbN == null) {
            bbN = new WriteData(1);
            bbN.setThreadId(str);
            bbN.setWriteImagesInfo(this.writeImagesInfo);
        }
        bbN.setContent(this.avV);
        bbN.setVideoInfo(this.mVideoInfo);
        bbN.setGraffitiFileName(this.mGraffitiFileName);
        ac.c(str, bbN);
    }

    public void fF(String str) {
        ac.a(str, this);
    }

    @Override // com.baidu.tieba.tbadkCore.ac.a
    public void a(WriteData writeData) {
        if (writeData != null) {
            if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                if (this.mVideoInfo == null) {
                    this.mVideoInfo = new VideoInfo();
                }
                this.mVideoInfo.copy(writeData.getVideoInfo());
                Do();
                CB().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                bI(false);
            }
            this.mGraffitiFileName = writeData.getGraffitiFileName();
            if (CB() != null && !av.isEmpty(this.mGraffitiFileName)) {
                CB().b(new com.baidu.tbadk.editortools.a(42, 24, this.mGraffitiFileName));
            }
            if (!av.isEmpty(writeData.getContent()) && av.isEmpty(this.avV)) {
                this.avV = writeData.getContent();
                fI(this.avV);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.avZ.cancelLoadData();
        this.awa.cancelLoadData();
        this.avY.cancelLoadData();
    }

    public void Dl() {
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        this.avZ = new com.baidu.tieba.tbadkCore.writeModel.b(baseActivity);
        this.avZ.b(this.awp);
        this.awa = new d(baseActivity);
        this.awa.setLoadDataCallBack(this.awq);
        this.avY = new com.baidu.tieba.tbadkCore.location.d(baseActivity);
        this.avY.a(this.awn);
        this.avY.a(this.awo);
        if (bundle != null) {
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.avX = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(10);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.m9getInst().getDefaultBubble()) && CB() != null) {
            CB().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.avY.bgL() && CB() != null) {
            CB().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.avX);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.avZ.bbN() == null) {
            this.avZ.d(this.awb.fB(str));
        }
        if (this.avZ.bbN() != null) {
            this.avZ.bbN().setWriteImagesInfo(this.writeImagesInfo);
            this.avZ.bbN().setVideoInfo(this.mVideoInfo);
            this.avZ.bbN().setGraffitiFileName(this.mGraffitiFileName);
            this.avZ.la(this.writeImagesInfo.size() > 0);
            WriteData bbN = this.avZ.bbN();
            if (this.avY == null || !this.avY.bgL()) {
                z = false;
            }
            bbN.setHasLocationData(z);
            if (str == null) {
                this.avZ.bbN().setContent(this.avV);
            }
            if (this.avW != null) {
                if (this.avW.getId() != null) {
                    this.avZ.bbN().setVoice(this.avW.getId());
                    this.avZ.bbN().setVoiceDuringTime(this.avW.duration);
                } else {
                    this.avZ.bbN().setVoice(null);
                    this.avZ.bbN().setVoiceDuringTime(-1);
                }
            } else {
                this.avZ.bbN().setVoice(null);
                this.avZ.bbN().setVoiceDuringTime(-1);
            }
            if (!this.avZ.bhl()) {
                this.awe.showToast(r.j.write_img_limit);
                return;
            }
            if (this.awj != null) {
                this.awj.CZ();
            }
            if (!this.avZ.bhi()) {
            }
        }
    }

    public BaseActivity<?> getContext() {
        return this.awe;
    }

    public void fG(String str) {
        this.avV = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.avW = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int Dm() {
        return this.awh;
    }

    private void Dn() {
        if (CB() != null) {
            CB().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void r(ArrayList<String> arrayList) {
        if (CB() != null) {
            CB().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    public void fH(String str) {
        if (CB() != null) {
            CB().b(new com.baidu.tbadk.editortools.a(44, 3, str));
        }
    }

    private void Do() {
        if (CB() != null) {
            CB().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    protected void bI(boolean z) {
        if (CB() != null) {
            if (z) {
                CB().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            CB().b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                CB().b(new com.baidu.tbadk.editortools.a(2, 10, new StringBuilder(String.valueOf(this.writeImagesInfo.getChosedFiles().size())).toString()));
            } else {
                CB().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
        }
    }

    protected void Dp() {
        bI(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Dq() {
        if (CB() != null) {
            CB().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.awh = i;
        if (CB() != null) {
            CB().b(new com.baidu.tbadk.editortools.a(19, 8, new com.baidu.tbadk.editortools.d.a(i, z, str)));
            if (i == 2) {
                CB().b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            } else {
                CB().b(new com.baidu.tbadk.editortools.a(2, 7, null));
            }
        }
    }

    private void fI(String str) {
        if (CB() != null) {
            CB().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJ(boolean z) {
        if (CB() != null) {
            CB().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(b.d dVar) {
        this.awi = dVar;
    }

    public void a(c cVar) {
        this.awj = cVar;
    }

    public void Dr() {
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            this.writeImagesInfo.clear();
        }
        Dp();
        if (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) {
            this.mVideoInfo = null;
        }
        CB().b(new com.baidu.tbadk.editortools.a(2, 19, null));
        setVoiceModel(null);
        CB().b(new com.baidu.tbadk.editortools.a(2, 6, null));
        CB().b(new com.baidu.tbadk.editortools.a(33, 6, null));
        if (!StringUtils.isNull(this.avV)) {
            this.avV = "";
        }
        fI("");
        this.mGraffitiFileName = null;
        CB().b(new com.baidu.tbadk.editortools.a(42, 24, null));
        this.avZ.d((WriteData) null);
        this.avZ.la(false);
    }

    public void eM(int i) {
        if (this.awl == null && CB() != null) {
            this.awl = (com.baidu.tbadk.editortools.inputtool.a) CB().eC(3);
        }
        if (this.awl != null && (this.awl.auh instanceof EditText)) {
            this.awl.b(new m(this, i, (EditText) this.awl.auh));
        }
    }

    public void Ds() {
        if (this.awl != null) {
            this.awl.b(null);
        }
    }

    public void setGraffitiFileName(String str) {
        this.mGraffitiFileName = str;
    }
}
