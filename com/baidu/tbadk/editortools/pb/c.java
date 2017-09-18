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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
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
    private LocationModel.b aDA;
    private final NewWriteModel.d aDB;
    private final com.baidu.adp.base.d aDC;
    private String aDg;
    private VoiceData.VoiceModel aDh;
    private String aDi;
    private LocationModel aDj;
    private NewWriteModel aDk;
    private ImageModel aDl;
    private DataModel<?> aDm;
    private AntiData aDn;
    private ForumData aDo;
    private String aDp;
    private boolean aDq;
    private String aDr;
    private int aDs;
    private NewWriteModel.d aDt;
    private b aDu;
    private com.baidu.tbadk.editortools.imagetool.b aDv;
    private com.baidu.tbadk.editortools.inputtool.a aDw;
    private com.baidu.tbadk.editortools.sendtool.a aDx;
    private boolean aDy;
    private LocationModel.a aDz;
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
        this.aDg = "";
        this.aDk = null;
        this.aDl = null;
        this.mThreadId = null;
        this.aDp = null;
        this.aDq = true;
        this.aDs = 0;
        this.aDy = false;
        this.aDz = new LocationModel.a() { // from class: com.baidu.tbadk.editortools.pb.c.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void DM() {
                c.this.mContext.showToast(d.l.no_network_guide);
                c.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void fY(String str) {
                BaseActivity baseActivity = c.this.mContext;
                if (StringUtils.isNull(str)) {
                    str = c.this.CV().getContext().getString(d.l.location_fail);
                }
                baseActivity.showToast(str);
                c.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.btb())) {
                    c.this.a(2, true, aVar.btb());
                } else {
                    fY(null);
                }
            }
        };
        this.aDA = new LocationModel.b() { // from class: com.baidu.tbadk.editortools.pb.c.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void DN() {
                c.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void fZ(String str) {
                c.this.a(2, true, str);
            }
        };
        this.aDB = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.c.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
                WriteData writeData2 = writeData == null ? c.this.aDk.getWriteData() : writeData;
                if (z) {
                    c.this.bM(true);
                    WriteData writeData3 = c.this.aDk.getWriteData();
                    c.this.resetData();
                    r.d(c.this.mThreadId, (WriteData) null);
                    if (writeData3 != null) {
                        if (writeData3 != null && writeData3.getType() == 2) {
                            r.a(writeData3.getThreadId(), c.this);
                        }
                    } else {
                        return;
                    }
                } else if (writeData2 != null && qVar != null && !TextUtils.isEmpty(qVar.yA())) {
                    writeData2.setVcodeMD5(qVar.getVcode_md5());
                    writeData2.setVcodeUrl(qVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(qVar.yB());
                    if (com.baidu.tbadk.q.a.gX(qVar.yA())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(c.this.mContext.getActivity(), 12006, writeData2, false, qVar.yA())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(c.this.mContext.getActivity(), writeData2, 12006)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(c.this.mContext.getActivity(), 12006, writeData2, postWriteCallBackData.getAccessState())));
                }
                if (c.this.aDt != null) {
                    c.this.aDt.callback(z, postWriteCallBackData, qVar, writeData2, antiData);
                }
            }
        };
        this.aDC = new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.editortools.pb.c.7
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                if (obj instanceof Bitmap) {
                    Bitmap bitmap = (Bitmap) obj;
                    if (obj != null) {
                        c.this.aDk.mM(true);
                    }
                }
            }
        };
    }

    private com.baidu.tbadk.editortools.sendtool.a Dt() {
        if (this.aDx == null && CV() != null) {
            this.aDx = (com.baidu.tbadk.editortools.sendtool.a) CV().eE(4);
        }
        return this.aDx;
    }

    public void eL(int i) {
        if (this.aDx == null && CV() != null) {
            this.aDx = (com.baidu.tbadk.editortools.sendtool.a) CV().eE(4);
        }
        if (this.aDx != null) {
            this.aDx.setType(i);
        }
    }

    public void eM(int i) {
        if (this.aDx == null && CV() != null) {
            this.aDx = (com.baidu.tbadk.editortools.sendtool.a) CV().eE(4);
        }
        if (this.aDx != null) {
            this.aDx.eP(i);
        }
    }

    private com.baidu.tbadk.editortools.imagetool.b Du() {
        if (this.aDv == null && CV() != null) {
            this.aDv = (com.baidu.tbadk.editortools.imagetool.b) CV().eE(11);
        }
        return this.aDv;
    }

    public void eN(int i) {
        if (this.aDv == null && CV() != null) {
            this.aDv = (com.baidu.tbadk.editortools.imagetool.b) CV().eE(11);
        }
        if (this.aDv != null) {
            this.aDv.eK(i);
        }
    }

    public com.baidu.tbadk.editortools.inputtool.a Dv() {
        if (this.aDw == null && CV() != null) {
            this.aDw = (com.baidu.tbadk.editortools.inputtool.a) CV().eE(3);
        }
        return this.aDw;
    }

    public void fS(String str) {
        if (this.aDw == null && CV() != null) {
            this.aDw = (com.baidu.tbadk.editortools.inputtool.a) CV().eE(3);
        }
        if (this.aDw != null) {
            this.aDw.setHint(str);
        }
    }

    public void bH(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (CV() != null && (cVar = (com.baidu.tbadk.editortools.c) CV().eC(5)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bI(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (CV() != null && (cVar = (com.baidu.tbadk.editortools.c) CV().eC(23)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bJ(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (CV() != null && (cVar = (com.baidu.tbadk.editortools.c) CV().eC(2)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.aDm = dataModel;
    }

    public void d(BaseActivity<?> baseActivity) {
        this.mContext = baseActivity;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.aDq = antiData.isIfvoice();
            this.aDp = antiData.getVoice_message();
        }
        this.aDn = antiData;
    }

    public void a(ForumData forumData, UserData userData) {
        this.aDo = forumData;
        this.mUserData = userData;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (CV() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.aDr = metaData.getName_show();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void bK(boolean z) {
        this.aDy = z;
    }

    public void Dw() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            String valueOf = String.valueOf(this.authorId);
            if (valueOf == null || valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                k.showToast(this.mContext.getActivity(), d.l.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.mContext.getActivity(), this.authorId, this.authorName, this.aDr, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.g.b.c(this.mThreadId, 0L), com.baidu.adp.lib.g.b.c(this.postId, 0L))));
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
                        if (a.Dr().getStatus() == 1) {
                            if (Du() != null) {
                                Du().eK(1);
                            }
                            if (getWriteImagesInfo() != null) {
                                getWriteImagesInfo().setMaxImagesAllowed(1);
                            }
                        } else {
                            if (Du() != null) {
                                Du().eK(10);
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
                        if (CV() != null) {
                            lVar2 = CV().eC(2);
                            lVar = CV().eC(5);
                            lVar3 = CV().eC(23);
                        } else {
                            lVar = null;
                            lVar2 = null;
                        }
                        if (a.Dr().getStatus() == 1) {
                            DJ();
                            if (CV() != null) {
                                CV().De();
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL));
                            }
                            if (lVar2 != null) {
                                lVar2.hide();
                            }
                            if (lVar != null) {
                                lVar.hide();
                            }
                            if (lVar3 != null) {
                                lVar3.lK();
                            }
                            if (Dv() != null) {
                                Dv().setHint(this.mContext.getPageContext().getString(d.l.add_picture_description));
                            }
                            if (Du() != null) {
                                Du().fM(this.mContext.getPageContext().getString(d.l.show_pic_tip));
                                Du().fN(this.mContext.getPageContext().getString(d.l.show_pic_add_tip));
                            }
                            if (Dt() != null) {
                                Dt().setType(SendView.aDV);
                                Dt().eP(SendView.aDV);
                            }
                        } else {
                            if (lVar2 != null) {
                                lVar2.lK();
                            }
                            if (lVar != null) {
                                lVar.lK();
                            }
                            if (lVar3 != null) {
                                lVar3.hide();
                            }
                            if (Dv() != null) {
                                Dv().setHint(this.mContext.getPageContext().getString(d.l.pb_reply_hint));
                            }
                            if (Dt() != null) {
                                Dt().setType(SendView.ALL);
                                Dt().eP(SendView.ALL);
                            }
                        }
                        CV().invalidate();
                        return;
                    }
                    return;
                case 12003:
                    if (intent != null) {
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            DG();
                            this.aDk.mM(false);
                            return;
                        }
                        this.aDl.fR(intent.getStringExtra("file_name"));
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
                    WriteData writeData = this.aDk.getWriteData();
                    if (writeData != null) {
                        writeData.deleteUploadedTempImages();
                    }
                    this.aDk.setWriteData(null);
                    this.aDk.mM(false);
                    this.aDh = null;
                    this.mVideoInfo = null;
                    this.mGraffitiFileName = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        r.d(this.mThreadId, (WriteData) null);
                    }
                    bM(true);
                    if (this.aDt != null) {
                        this.aDt.callback(true, null, null, writeData, null);
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
                    if (a.Dr().getStatus() == 1 && Du() != null) {
                        Du().fM(this.mContext.getPageContext().getString(d.l.show_pic_tip));
                        return;
                    }
                    return;
                case 13010:
                    if (CV() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            ak akVar = new ak("c10068");
                            akVar.r("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(akVar);
                            DH();
                            CV().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            CV().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                        fW(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 12001:
                DD();
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

    public void Dx() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.mContext.getActivity())));
    }

    public void Dy() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.mContext.getActivity())) {
            this.mContext.showToast(d.l.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            Dz();
        } else if (this.aDj.btj()) {
            Dx();
        } else {
            this.aDj.mK(false);
            a(1, true, (String) null);
            this.aDj.bth();
        }
    }

    private void Dz() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getActivity());
        aVar.cc(d.l.location_app_permission_prompt).a(d.l.isopen, new a.b() { // from class: com.baidu.tbadk.editortools.pb.c.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.i.hi()) {
                    c.this.a(1, true, (String) null);
                    c.this.aDj.UG();
                } else {
                    c.this.aDz.DM();
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
        aVar.to();
    }

    public void DA() {
        if (this.aDj.UC()) {
            if (this.aDj.btj()) {
                this.aDz.a(com.baidu.tieba.tbadkCore.location.c.btf().getLocationData());
                return;
            }
            if (k.hz()) {
                this.aDj.bth();
            }
            a(0, true, (String) null);
            return;
        }
        a(0, false, (String) null);
    }

    public boolean DB() {
        if (StringUtils.isNull(this.aDg)) {
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() <= 0) {
                if (this.aDh == null || StringUtils.isNull(this.aDh.getId())) {
                    return (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) || this.mGraffitiFileName != null;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    public void resetData() {
        this.aDk.setWriteData(null);
        this.aDk.mM(false);
        this.aDh = null;
        this.mVideoInfo = null;
        this.mGraffitiFileName = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void DC() {
        this.mVideoInfo = null;
    }

    private void z(Intent intent) {
        this.aDi = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aDi;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, k.dip2px(this.mContext.getActivity(), k.ae(this.mContext.getActivity())), k.dip2px(this.mContext.getActivity(), k.af(this.mContext.getActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.k.a(TbConfig.LOCAL_CAMERA_DIR, this.aDi, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            DI();
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
                DI();
            }
        }
    }

    private void DD() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tbadk.editortools.pb.c.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tbadk.core.util.k.u(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + c.this.aDi));
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

    public void fT(String str) {
        WriteData writeData = this.aDk.getWriteData();
        if (writeData == null) {
            writeData = new WriteData(1);
            writeData.setThreadId(str);
            writeData.setWriteImagesInfo(this.writeImagesInfo);
        }
        writeData.setContent(this.aDg);
        writeData.setVideoInfo(this.mVideoInfo);
        writeData.setGraffitiFileName(this.mGraffitiFileName);
        r.d(str, writeData);
    }

    public void fU(String str) {
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
                DH();
                CV().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                bL(false);
            }
            this.mGraffitiFileName = writeData.getGraffitiFileName();
            if (CV() != null && !am.isEmpty(this.mGraffitiFileName)) {
                CV().b(new com.baidu.tbadk.editortools.a(42, 24, this.mGraffitiFileName));
            }
            if (!am.isEmpty(writeData.getContent()) && am.isEmpty(this.aDg)) {
                this.aDg = writeData.getContent();
                fX(this.aDg);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.aDk.cancelLoadData();
        this.aDl.cancelLoadData();
        this.aDj.cancelLoadData();
    }

    public void DE() {
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        this.aDk = new NewWriteModel(baseActivity);
        this.aDk.b(this.aDB);
        this.aDl = new ImageModel(baseActivity);
        this.aDl.setLoadDataCallBack(this.aDC);
        this.aDj = new LocationModel(baseActivity);
        this.aDj.a(this.aDz);
        this.aDj.a(this.aDA);
        if (bundle != null) {
            this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
            this.aDi = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(10);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && CV() != null) {
            CV().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.aDj.UC() && CV() != null) {
            CV().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.writeImagesInfo != null) {
            bundle.putString(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aDi);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.aDk.getWriteData() == null) {
            this.aDk.setWriteData(this.aDm.fQ(str));
        }
        if (this.aDk.getWriteData() != null) {
            if (this.aDy) {
                this.aDk.getWriteData().setCanNoForum(true);
                if (this.aDo != null) {
                    this.aDk.getWriteData().setVForumId(this.aDo.getId());
                    this.aDk.getWriteData().setVForumName(this.aDo.getName());
                }
            } else {
                this.aDk.getWriteData().setCanNoForum(false);
                this.aDk.getWriteData().setVForumId("");
                this.aDk.getWriteData().setVForumName("");
            }
            this.aDk.getWriteData().setWriteImagesInfo(this.writeImagesInfo);
            this.aDk.getWriteData().setVideoInfo(this.mVideoInfo);
            this.aDk.getWriteData().setGraffitiFileName(this.mGraffitiFileName);
            this.aDk.mM(this.writeImagesInfo.size() > 0);
            WriteData writeData2 = this.aDk.getWriteData();
            if (this.aDj == null || !this.aDj.UC()) {
                z = false;
            }
            writeData2.setHasLocationData(z);
            if (str == null) {
                this.aDk.getWriteData().setContent(this.aDg);
            }
            if (this.aDh != null) {
                if (this.aDh.getId() != null) {
                    this.aDk.getWriteData().setVoice(this.aDh.getId());
                    this.aDk.getWriteData().setVoiceDuringTime(this.aDh.duration);
                } else {
                    this.aDk.getWriteData().setVoice(null);
                    this.aDk.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.aDk.getWriteData().setVoice(null);
                this.aDk.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.aDk.btF()) {
                this.mContext.showToast(d.l.write_img_limit);
                return;
            }
            if (this.aDu != null) {
                this.aDu.Ds();
            }
            if (!this.aDk.startPostWrite()) {
            }
        }
    }

    public BaseActivity<?> getContext() {
        return this.mContext;
    }

    public void fV(String str) {
        this.aDg = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.aDh = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int DF() {
        return this.aDs;
    }

    private void DG() {
        if (CV() != null) {
            CV().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void q(ArrayList<String> arrayList) {
        if (CV() != null) {
            CV().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    public void fW(String str) {
        if (CV() != null) {
            CV().b(new com.baidu.tbadk.editortools.a(44, 3, str));
        }
    }

    private void DH() {
        if (CV() != null) {
            CV().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    protected void bL(boolean z) {
        if (CV() != null) {
            if (z) {
                CV().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            CV().b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                CV().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
            } else {
                CV().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
        }
    }

    protected void DI() {
        bL(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void DJ() {
        if (CV() != null) {
            CV().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.aDs = i;
        if (CV() != null) {
            CV().b(new com.baidu.tbadk.editortools.a(19, 8, new com.baidu.tbadk.editortools.d.a(i, z, str)));
            if (i == 2) {
                CV().b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            } else {
                CV().b(new com.baidu.tbadk.editortools.a(2, 7, null));
            }
        }
    }

    private void fX(String str) {
        if (CV() != null) {
            CV().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bM(boolean z) {
        if (CV() != null) {
            CV().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.aDt = dVar;
    }

    public void a(b bVar) {
        this.aDu = bVar;
    }

    public void DK() {
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            this.writeImagesInfo.clear();
        }
        DI();
        if (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) {
            this.mVideoInfo = null;
        }
        CV().b(new com.baidu.tbadk.editortools.a(2, 19, null));
        setVoiceModel(null);
        CV().b(new com.baidu.tbadk.editortools.a(2, 6, null));
        CV().b(new com.baidu.tbadk.editortools.a(33, 6, null));
        if (!StringUtils.isNull(this.aDg)) {
            this.aDg = "";
        }
        fX("");
        this.mGraffitiFileName = null;
        CV().b(new com.baidu.tbadk.editortools.a(42, 24, null));
        this.aDk.setWriteData(null);
        this.aDk.mM(false);
    }

    public void eO(final int i) {
        if (this.aDw == null && CV() != null) {
            this.aDw = (com.baidu.tbadk.editortools.inputtool.a) CV().eE(3);
        }
        if (this.aDw != null && (this.aDw.aBn instanceof EditText)) {
            final EditText editText = (EditText) this.aDw.aBn;
            this.aDw.a(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.c.8
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
                        if (!StringUtils.isNull(obj) && v.gS(obj) > i) {
                            String e = v.e(obj, 0, i - 1);
                            editText.setText(e);
                            editText.setSelection(editText.getText().length());
                            UtilHelper.showToast(c.this.getContext().getApplication(), c.this.getContext().getResources().getString(d.l.edit_text_over_limit_tip, Integer.valueOf(e.length())));
                        }
                    }
                }
            });
        }
    }

    public void DL() {
        if (this.aDw != null) {
            this.aDw.a(null);
        }
    }

    public void setGraffitiFileName(String str) {
        this.mGraffitiFileName = str;
    }
}
