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
    private String aDS;
    private VoiceData.VoiceModel aDT;
    private String aDU;
    private LocationModel aDV;
    private NewWriteModel aDW;
    private ImageModel aDX;
    private DataModel<?> aDY;
    private AntiData aDZ;
    private ForumData aEa;
    private String aEb;
    private boolean aEc;
    private String aEd;
    private int aEe;
    private NewWriteModel.d aEf;
    private b aEg;
    private com.baidu.tbadk.editortools.imagetool.b aEh;
    private com.baidu.tbadk.editortools.inputtool.a aEi;
    private com.baidu.tbadk.editortools.sendtool.a aEj;
    private boolean aEk;
    private LocationModel.a aEl;
    private LocationModel.b aEm;
    private final NewWriteModel.d aEn;
    private final com.baidu.adp.base.d aEo;
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
        this.aDS = "";
        this.aDW = null;
        this.aDX = null;
        this.mThreadId = null;
        this.aEb = null;
        this.aEc = true;
        this.aEe = 0;
        this.aEk = false;
        this.aEl = new LocationModel.a() { // from class: com.baidu.tbadk.editortools.pb.c.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void DR() {
                c.this.mContext.showToast(d.l.no_network_guide);
                c.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void ge(String str) {
                BaseActivity baseActivity = c.this.mContext;
                if (StringUtils.isNull(str)) {
                    str = c.this.Da().getContext().getString(d.l.location_fail);
                }
                baseActivity.showToast(str);
                c.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.btB())) {
                    c.this.b(2, true, aVar.btB());
                } else {
                    ge(null);
                }
            }
        };
        this.aEm = new LocationModel.b() { // from class: com.baidu.tbadk.editortools.pb.c.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void DS() {
                c.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void gf(String str) {
                c.this.b(2, true, str);
            }
        };
        this.aEn = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.c.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
                WriteData writeData2 = writeData == null ? c.this.aDW.getWriteData() : writeData;
                if (z) {
                    c.this.bN(true);
                    WriteData writeData3 = c.this.aDW.getWriteData();
                    c.this.resetData();
                    r.d(c.this.mThreadId, (WriteData) null);
                    if (writeData3 != null) {
                        if (writeData3 != null && writeData3.getType() == 2) {
                            r.a(writeData3.getThreadId(), c.this);
                        }
                    } else {
                        return;
                    }
                } else if (writeData2 != null && qVar != null && !TextUtils.isEmpty(qVar.yx())) {
                    writeData2.setVcodeMD5(qVar.getVcode_md5());
                    writeData2.setVcodeUrl(qVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(qVar.yy());
                    if (com.baidu.tbadk.q.a.hb(qVar.yx())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(c.this.mContext.getActivity(), 12006, writeData2, false, qVar.yx())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(c.this.mContext.getActivity(), writeData2, 12006)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(c.this.mContext.getActivity(), 12006, writeData2, postWriteCallBackData.getAccessState())));
                }
                if (c.this.aEf != null) {
                    c.this.aEf.callback(z, postWriteCallBackData, qVar, writeData2, antiData);
                }
            }
        };
        this.aEo = new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.editortools.pb.c.7
            @Override // com.baidu.adp.base.d
            public void g(Object obj) {
                if (obj instanceof Bitmap) {
                    Bitmap bitmap = (Bitmap) obj;
                    if (obj != null) {
                        c.this.aDW.mF(true);
                    }
                }
            }
        };
    }

    private com.baidu.tbadk.editortools.sendtool.a Dy() {
        if (this.aEj == null && Da() != null) {
            this.aEj = (com.baidu.tbadk.editortools.sendtool.a) Da().eE(4);
        }
        return this.aEj;
    }

    public void eL(int i) {
        if (this.aEj == null && Da() != null) {
            this.aEj = (com.baidu.tbadk.editortools.sendtool.a) Da().eE(4);
        }
        if (this.aEj != null) {
            this.aEj.setType(i);
        }
    }

    public void eM(int i) {
        if (this.aEj == null && Da() != null) {
            this.aEj = (com.baidu.tbadk.editortools.sendtool.a) Da().eE(4);
        }
        if (this.aEj != null) {
            this.aEj.eP(i);
        }
    }

    private com.baidu.tbadk.editortools.imagetool.b Dz() {
        if (this.aEh == null && Da() != null) {
            this.aEh = (com.baidu.tbadk.editortools.imagetool.b) Da().eE(11);
        }
        return this.aEh;
    }

    public void eN(int i) {
        if (this.aEh == null && Da() != null) {
            this.aEh = (com.baidu.tbadk.editortools.imagetool.b) Da().eE(11);
        }
        if (this.aEh != null) {
            this.aEh.eK(i);
        }
    }

    public com.baidu.tbadk.editortools.inputtool.a DA() {
        if (this.aEi == null && Da() != null) {
            this.aEi = (com.baidu.tbadk.editortools.inputtool.a) Da().eE(3);
        }
        return this.aEi;
    }

    public void fY(String str) {
        if (this.aEi == null && Da() != null) {
            this.aEi = (com.baidu.tbadk.editortools.inputtool.a) Da().eE(3);
        }
        if (this.aEi != null) {
            this.aEi.setHint(str);
        }
    }

    public void bI(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (Da() != null && (cVar = (com.baidu.tbadk.editortools.c) Da().eC(5)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bJ(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (Da() != null && (cVar = (com.baidu.tbadk.editortools.c) Da().eC(23)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bK(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (Da() != null && (cVar = (com.baidu.tbadk.editortools.c) Da().eC(2)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.aDY = dataModel;
    }

    public void d(BaseActivity<?> baseActivity) {
        this.mContext = baseActivity;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.aEc = antiData.isIfvoice();
            this.aEb = antiData.getVoice_message();
        }
        this.aDZ = antiData;
    }

    public void a(ForumData forumData, UserData userData) {
        this.aEa = forumData;
        this.mUserData = userData;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (Da() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.aEd = metaData.getName_show();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void bL(boolean z) {
        this.aEk = z;
    }

    public void DB() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            String valueOf = String.valueOf(this.authorId);
            if (valueOf == null || valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                k.showToast(this.mContext.getActivity(), d.l.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.mContext.getActivity(), this.authorId, this.authorName, this.aEd, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.g.b.d(this.mThreadId, 0L), com.baidu.adp.lib.g.b.d(this.postId, 0L))));
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
                        if (a.Dw().getStatus() == 1) {
                            if (Dz() != null) {
                                Dz().eK(1);
                            }
                            if (getWriteImagesInfo() != null) {
                                getWriteImagesInfo().setMaxImagesAllowed(1);
                            }
                        } else {
                            if (Dz() != null) {
                                Dz().eK(10);
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
                        if (Da() != null) {
                            lVar2 = Da().eC(2);
                            lVar = Da().eC(5);
                            lVar3 = Da().eC(23);
                        } else {
                            lVar = null;
                            lVar2 = null;
                        }
                        if (a.Dw().getStatus() == 1) {
                            DO();
                            if (Da() != null) {
                                Da().Dj();
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL));
                            }
                            if (lVar2 != null) {
                                lVar2.hide();
                            }
                            if (lVar != null) {
                                lVar.hide();
                            }
                            if (lVar3 != null) {
                                lVar3.lS();
                            }
                            if (DA() != null) {
                                DA().setHint(this.mContext.getPageContext().getString(d.l.add_picture_description));
                            }
                            if (Dz() != null) {
                                Dz().fR(this.mContext.getPageContext().getString(d.l.show_pic_tip));
                                Dz().fS(this.mContext.getPageContext().getString(d.l.show_pic_add_tip));
                            }
                            if (Dy() != null) {
                                Dy().setType(SendView.aEH);
                                Dy().eP(SendView.aEH);
                            }
                        } else {
                            if (lVar2 != null) {
                                lVar2.lS();
                            }
                            if (lVar != null) {
                                lVar.lS();
                            }
                            if (lVar3 != null) {
                                lVar3.hide();
                            }
                            if (DA() != null) {
                                DA().setHint(this.mContext.getPageContext().getString(d.l.pb_reply_hint));
                            }
                            if (Dy() != null) {
                                Dy().setType(SendView.ALL);
                                Dy().eP(SendView.ALL);
                            }
                        }
                        Da().invalidate();
                        return;
                    }
                    return;
                case 12003:
                    if (intent != null) {
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            DL();
                            this.aDW.mF(false);
                            return;
                        }
                        this.aDX.fX(intent.getStringExtra("file_name"));
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
                    WriteData writeData = this.aDW.getWriteData();
                    if (writeData != null) {
                        writeData.deleteUploadedTempImages();
                    }
                    this.aDW.setWriteData(null);
                    this.aDW.mF(false);
                    this.aDT = null;
                    this.mVideoInfo = null;
                    this.mGraffitiFileName = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        r.d(this.mThreadId, (WriteData) null);
                    }
                    bN(true);
                    if (this.aEf != null) {
                        this.aEf.callback(true, null, null, writeData, null);
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
                    if (a.Dw().getStatus() == 1 && Dz() != null) {
                        Dz().fR(this.mContext.getPageContext().getString(d.l.show_pic_tip));
                        return;
                    }
                    return;
                case 13010:
                    if (Da() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            aj ajVar = new aj("c10068");
                            ajVar.r("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(ajVar);
                            DM();
                            Da().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            Da().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                        gc(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 12001:
                DI();
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

    public void DC() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.mContext.getActivity())));
    }

    public void DD() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.mContext.getActivity())) {
            this.mContext.showToast(d.l.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            DE();
        } else if (this.aDV.btJ()) {
            DC();
        } else {
            this.aDV.mD(false);
            b(1, true, null);
            this.aDV.btH();
        }
    }

    private void DE() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getActivity());
        aVar.cc(d.l.location_app_permission_prompt).a(d.l.isopen, new a.b() { // from class: com.baidu.tbadk.editortools.pb.c.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.i.hr()) {
                    c.this.b(1, true, null);
                    c.this.aDV.TK();
                } else {
                    c.this.aEl.DR();
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
        aVar.ts();
    }

    public void DF() {
        if (this.aDV.TG()) {
            if (this.aDV.btJ()) {
                this.aEl.a(com.baidu.tieba.tbadkCore.location.c.btF().getLocationData());
                return;
            }
            if (k.hI()) {
                this.aDV.btH();
            }
            b(0, true, null);
            return;
        }
        b(0, false, null);
    }

    public boolean DG() {
        if (StringUtils.isNull(this.aDS)) {
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() <= 0) {
                if (this.aDT == null || StringUtils.isNull(this.aDT.getId())) {
                    return (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) || this.mGraffitiFileName != null;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    public void resetData() {
        this.aDW.setWriteData(null);
        this.aDW.mF(false);
        this.aDT = null;
        this.mVideoInfo = null;
        this.mGraffitiFileName = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void DH() {
        this.mVideoInfo = null;
    }

    private void A(Intent intent) {
        this.aDU = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aDU;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, k.dip2px(this.mContext.getActivity(), k.ag(this.mContext.getActivity())), k.dip2px(this.mContext.getActivity(), k.ah(this.mContext.getActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.k.a(TbConfig.LOCAL_CAMERA_DIR, this.aDU, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            DN();
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
                DN();
            }
        }
    }

    private void DI() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tbadk.editortools.pb.c.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tbadk.core.util.k.s(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + c.this.aDU));
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

    public void fZ(String str) {
        WriteData writeData = this.aDW.getWriteData();
        if (writeData == null) {
            writeData = new WriteData(1);
            writeData.setThreadId(str);
            writeData.setWriteImagesInfo(this.writeImagesInfo);
        }
        writeData.setContent(this.aDS);
        writeData.setVideoInfo(this.mVideoInfo);
        writeData.setGraffitiFileName(this.mGraffitiFileName);
        r.d(str, writeData);
    }

    public void ga(String str) {
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
                DM();
                Da().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                bM(false);
            }
            this.mGraffitiFileName = writeData.getGraffitiFileName();
            if (Da() != null && !al.isEmpty(this.mGraffitiFileName)) {
                Da().b(new com.baidu.tbadk.editortools.a(42, 24, this.mGraffitiFileName));
            }
            if (!al.isEmpty(writeData.getContent()) && al.isEmpty(this.aDS)) {
                this.aDS = writeData.getContent();
                gd(this.aDS);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.aDW.cancelLoadData();
        this.aDX.cancelLoadData();
        this.aDV.cancelLoadData();
    }

    public void DJ() {
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        this.aDW = new NewWriteModel(baseActivity);
        this.aDW.b(this.aEn);
        this.aDX = new ImageModel(baseActivity);
        this.aDX.setLoadDataCallBack(this.aEo);
        this.aDV = new LocationModel(baseActivity);
        this.aDV.a(this.aEl);
        this.aDV.a(this.aEm);
        if (bundle != null) {
            this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
            this.aDU = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(10);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && Da() != null) {
            Da().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.aDV.TG() && Da() != null) {
            Da().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.writeImagesInfo != null) {
            bundle.putString(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aDU);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.aDW.getWriteData() == null) {
            this.aDW.setWriteData(this.aDY.fW(str));
        }
        if (this.aDW.getWriteData() != null) {
            if (this.aEk) {
                this.aDW.getWriteData().setCanNoForum(true);
                if (this.aEa != null) {
                    this.aDW.getWriteData().setVForumId(this.aEa.getId());
                    this.aDW.getWriteData().setVForumName(this.aEa.getName());
                }
            } else {
                this.aDW.getWriteData().setCanNoForum(false);
                this.aDW.getWriteData().setVForumId("");
                this.aDW.getWriteData().setVForumName("");
            }
            this.aDW.getWriteData().setWriteImagesInfo(this.writeImagesInfo);
            this.aDW.getWriteData().setVideoInfo(this.mVideoInfo);
            this.aDW.getWriteData().setGraffitiFileName(this.mGraffitiFileName);
            this.aDW.mF(this.writeImagesInfo.size() > 0);
            WriteData writeData2 = this.aDW.getWriteData();
            if (this.aDV == null || !this.aDV.TG()) {
                z = false;
            }
            writeData2.setHasLocationData(z);
            if (str == null) {
                this.aDW.getWriteData().setContent(this.aDS);
            }
            if (this.aDT != null) {
                if (this.aDT.getId() != null) {
                    this.aDW.getWriteData().setVoice(this.aDT.getId());
                    this.aDW.getWriteData().setVoiceDuringTime(this.aDT.duration);
                } else {
                    this.aDW.getWriteData().setVoice(null);
                    this.aDW.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.aDW.getWriteData().setVoice(null);
                this.aDW.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.aDW.buf()) {
                this.mContext.showToast(d.l.write_img_limit);
                return;
            }
            if (this.aEg != null) {
                this.aEg.Dx();
            }
            if (!this.aDW.startPostWrite()) {
            }
        }
    }

    public BaseActivity<?> getContext() {
        return this.mContext;
    }

    public void gb(String str) {
        this.aDS = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.aDT = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int DK() {
        return this.aEe;
    }

    private void DL() {
        if (Da() != null) {
            Da().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void q(ArrayList<String> arrayList) {
        if (Da() != null) {
            Da().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    public void gc(String str) {
        if (Da() != null) {
            Da().b(new com.baidu.tbadk.editortools.a(44, 3, str));
        }
    }

    private void DM() {
        if (Da() != null) {
            Da().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    protected void bM(boolean z) {
        if (Da() != null) {
            if (z) {
                Da().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            Da().b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                Da().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
            } else {
                Da().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
        }
    }

    protected void DN() {
        bM(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void DO() {
        if (Da() != null) {
            Da().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.aEe = i;
        if (Da() != null) {
            Da().b(new com.baidu.tbadk.editortools.a(19, 8, new com.baidu.tbadk.editortools.d.a(i, z, str)));
            if (i == 2) {
                Da().b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            } else {
                Da().b(new com.baidu.tbadk.editortools.a(2, 7, null));
            }
        }
    }

    private void gd(String str) {
        if (Da() != null) {
            Da().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bN(boolean z) {
        if (Da() != null) {
            Da().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.aEf = dVar;
    }

    public void a(b bVar) {
        this.aEg = bVar;
    }

    public void DP() {
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            this.writeImagesInfo.clear();
        }
        DN();
        if (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) {
            this.mVideoInfo = null;
        }
        Da().b(new com.baidu.tbadk.editortools.a(2, 19, null));
        setVoiceModel(null);
        Da().b(new com.baidu.tbadk.editortools.a(2, 6, null));
        Da().b(new com.baidu.tbadk.editortools.a(33, 6, null));
        if (!StringUtils.isNull(this.aDS)) {
            this.aDS = "";
        }
        gd("");
        this.mGraffitiFileName = null;
        Da().b(new com.baidu.tbadk.editortools.a(42, 24, null));
        this.aDW.setWriteData(null);
        this.aDW.mF(false);
    }

    public void eO(final int i) {
        if (this.aEi == null && Da() != null) {
            this.aEi = (com.baidu.tbadk.editortools.inputtool.a) Da().eE(3);
        }
        if (this.aEi != null && (this.aEi.aCe instanceof EditText)) {
            final EditText editText = (EditText) this.aEi.aCe;
            this.aEi.a(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.c.8
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
                        if (!StringUtils.isNull(obj) && v.gW(obj) > i) {
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

    public void DQ() {
        if (this.aEi != null) {
            this.aEi.a(null);
        }
    }

    public void setGraffitiFileName(String str) {
        this.mGraffitiFileName = str;
    }
}
