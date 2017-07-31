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
    private String aDQ;
    private VoiceData.VoiceModel aDR;
    private String aDS;
    private LocationModel aDT;
    private NewWriteModel aDU;
    private ImageModel aDV;
    private DataModel<?> aDW;
    private AntiData aDX;
    private ForumData aDY;
    private String aDZ;
    private boolean aEa;
    private String aEb;
    private int aEc;
    private NewWriteModel.d aEd;
    private b aEe;
    private com.baidu.tbadk.editortools.imagetool.b aEf;
    private com.baidu.tbadk.editortools.inputtool.a aEg;
    private com.baidu.tbadk.editortools.sendtool.a aEh;
    private boolean aEi;
    private LocationModel.a aEj;
    private LocationModel.b aEk;
    private final NewWriteModel.d aEl;
    private final com.baidu.adp.base.d aEm;
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
        this.aDQ = "";
        this.aDU = null;
        this.aDV = null;
        this.mThreadId = null;
        this.aDZ = null;
        this.aEa = true;
        this.aEc = 0;
        this.aEi = false;
        this.aEj = new LocationModel.a() { // from class: com.baidu.tbadk.editortools.pb.c.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void DR() {
                c.this.mContext.showToast(d.l.no_network_guide);
                c.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void ga(String str) {
                BaseActivity baseActivity = c.this.mContext;
                if (StringUtils.isNull(str)) {
                    str = c.this.Da().getContext().getString(d.l.location_fail);
                }
                baseActivity.showToast(str);
                c.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.bta())) {
                    c.this.b(2, true, aVar.bta());
                } else {
                    ga(null);
                }
            }
        };
        this.aEk = new LocationModel.b() { // from class: com.baidu.tbadk.editortools.pb.c.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void DS() {
                c.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void gb(String str) {
                c.this.b(2, true, str);
            }
        };
        this.aEl = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.c.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
                WriteData writeData2 = writeData == null ? c.this.aDU.getWriteData() : writeData;
                if (z) {
                    c.this.bN(true);
                    WriteData writeData3 = c.this.aDU.getWriteData();
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
                    if (com.baidu.tbadk.q.a.gY(qVar.yx())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(c.this.mContext.getActivity(), 12006, writeData2, false, qVar.yx())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(c.this.mContext.getActivity(), writeData2, 12006)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(c.this.mContext.getActivity(), 12006, writeData2, postWriteCallBackData.getAccessState())));
                }
                if (c.this.aEd != null) {
                    c.this.aEd.callback(z, postWriteCallBackData, qVar, writeData2, antiData);
                }
            }
        };
        this.aEm = new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.editortools.pb.c.7
            @Override // com.baidu.adp.base.d
            public void g(Object obj) {
                if (obj instanceof Bitmap) {
                    Bitmap bitmap = (Bitmap) obj;
                    if (obj != null) {
                        c.this.aDU.mC(true);
                    }
                }
            }
        };
    }

    private com.baidu.tbadk.editortools.sendtool.a Dy() {
        if (this.aEh == null && Da() != null) {
            this.aEh = (com.baidu.tbadk.editortools.sendtool.a) Da().eE(4);
        }
        return this.aEh;
    }

    public void eL(int i) {
        if (this.aEh == null && Da() != null) {
            this.aEh = (com.baidu.tbadk.editortools.sendtool.a) Da().eE(4);
        }
        if (this.aEh != null) {
            this.aEh.setType(i);
        }
    }

    public void eM(int i) {
        if (this.aEh == null && Da() != null) {
            this.aEh = (com.baidu.tbadk.editortools.sendtool.a) Da().eE(4);
        }
        if (this.aEh != null) {
            this.aEh.eP(i);
        }
    }

    private com.baidu.tbadk.editortools.imagetool.b Dz() {
        if (this.aEf == null && Da() != null) {
            this.aEf = (com.baidu.tbadk.editortools.imagetool.b) Da().eE(11);
        }
        return this.aEf;
    }

    public void eN(int i) {
        if (this.aEf == null && Da() != null) {
            this.aEf = (com.baidu.tbadk.editortools.imagetool.b) Da().eE(11);
        }
        if (this.aEf != null) {
            this.aEf.eK(i);
        }
    }

    public com.baidu.tbadk.editortools.inputtool.a DA() {
        if (this.aEg == null && Da() != null) {
            this.aEg = (com.baidu.tbadk.editortools.inputtool.a) Da().eE(3);
        }
        return this.aEg;
    }

    public void fU(String str) {
        if (this.aEg == null && Da() != null) {
            this.aEg = (com.baidu.tbadk.editortools.inputtool.a) Da().eE(3);
        }
        if (this.aEg != null) {
            this.aEg.setHint(str);
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
        this.aDW = dataModel;
    }

    public void d(BaseActivity<?> baseActivity) {
        this.mContext = baseActivity;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.aEa = antiData.isIfvoice();
            this.aDZ = antiData.getVoice_message();
        }
        this.aDX = antiData;
    }

    public void a(ForumData forumData, UserData userData) {
        this.aDY = forumData;
        this.mUserData = userData;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (Da() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.aEb = metaData.getName_show();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void bL(boolean z) {
        this.aEi = z;
    }

    public void DB() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            String valueOf = String.valueOf(this.authorId);
            if (valueOf == null || valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                k.showToast(this.mContext.getActivity(), d.l.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.mContext.getActivity(), this.authorId, this.authorName, this.aEb, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.g.b.d(this.mThreadId, 0L), com.baidu.adp.lib.g.b.d(this.postId, 0L))));
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
                                lVar3.lT();
                            }
                            if (DA() != null) {
                                DA().setHint(this.mContext.getPageContext().getString(d.l.add_picture_description));
                            }
                            if (Dz() != null) {
                                Dz().fN(this.mContext.getPageContext().getString(d.l.show_pic_tip));
                                Dz().fO(this.mContext.getPageContext().getString(d.l.show_pic_add_tip));
                            }
                            if (Dy() != null) {
                                Dy().setType(SendView.aEF);
                                Dy().eP(SendView.aEF);
                            }
                        } else {
                            if (lVar2 != null) {
                                lVar2.lT();
                            }
                            if (lVar != null) {
                                lVar.lT();
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
                            this.aDU.mC(false);
                            return;
                        }
                        this.aDV.fT(intent.getStringExtra("file_name"));
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
                    WriteData writeData = this.aDU.getWriteData();
                    if (writeData != null) {
                        writeData.deleteUploadedTempImages();
                    }
                    this.aDU.setWriteData(null);
                    this.aDU.mC(false);
                    this.aDR = null;
                    this.mVideoInfo = null;
                    this.mGraffitiFileName = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        r.d(this.mThreadId, (WriteData) null);
                    }
                    bN(true);
                    if (this.aEd != null) {
                        this.aEd.callback(true, null, null, writeData, null);
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
                        Dz().fN(this.mContext.getPageContext().getString(d.l.show_pic_tip));
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
                        fY(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
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
        } else if (this.aDT.bti()) {
            DC();
        } else {
            this.aDT.mA(false);
            b(1, true, null);
            this.aDT.btg();
        }
    }

    private void DE() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getActivity());
        aVar.cc(d.l.location_app_permission_prompt).a(d.l.isopen, new a.b() { // from class: com.baidu.tbadk.editortools.pb.c.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.i.hr()) {
                    c.this.b(1, true, null);
                    c.this.aDT.Tq();
                } else {
                    c.this.aEj.DR();
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
        aVar.tr();
    }

    public void DF() {
        if (this.aDT.Tm()) {
            if (this.aDT.bti()) {
                this.aEj.a(com.baidu.tieba.tbadkCore.location.c.bte().getLocationData());
                return;
            }
            if (k.hI()) {
                this.aDT.btg();
            }
            b(0, true, null);
            return;
        }
        b(0, false, null);
    }

    public boolean DG() {
        if (StringUtils.isNull(this.aDQ)) {
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() <= 0) {
                if (this.aDR == null || StringUtils.isNull(this.aDR.getId())) {
                    return (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) || this.mGraffitiFileName != null;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    public void resetData() {
        this.aDU.setWriteData(null);
        this.aDU.mC(false);
        this.aDR = null;
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
        this.aDS = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aDS;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, k.dip2px(this.mContext.getActivity(), k.ag(this.mContext.getActivity())), k.dip2px(this.mContext.getActivity(), k.ah(this.mContext.getActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.k.a(TbConfig.LOCAL_CAMERA_DIR, this.aDS, rotateBitmapBydegree, 100);
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
                com.baidu.tbadk.core.util.k.s(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + c.this.aDS));
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

    public void fV(String str) {
        WriteData writeData = this.aDU.getWriteData();
        if (writeData == null) {
            writeData = new WriteData(1);
            writeData.setThreadId(str);
            writeData.setWriteImagesInfo(this.writeImagesInfo);
        }
        writeData.setContent(this.aDQ);
        writeData.setVideoInfo(this.mVideoInfo);
        writeData.setGraffitiFileName(this.mGraffitiFileName);
        r.d(str, writeData);
    }

    public void fW(String str) {
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
            if (!al.isEmpty(writeData.getContent()) && al.isEmpty(this.aDQ)) {
                this.aDQ = writeData.getContent();
                fZ(this.aDQ);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.aDU.cancelLoadData();
        this.aDV.cancelLoadData();
        this.aDT.cancelLoadData();
    }

    public void DJ() {
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        this.aDU = new NewWriteModel(baseActivity);
        this.aDU.b(this.aEl);
        this.aDV = new ImageModel(baseActivity);
        this.aDV.setLoadDataCallBack(this.aEm);
        this.aDT = new LocationModel(baseActivity);
        this.aDT.a(this.aEj);
        this.aDT.a(this.aEk);
        if (bundle != null) {
            this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
            this.aDS = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(10);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && Da() != null) {
            Da().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.aDT.Tm() && Da() != null) {
            Da().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.writeImagesInfo != null) {
            bundle.putString(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aDS);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.aDU.getWriteData() == null) {
            this.aDU.setWriteData(this.aDW.fS(str));
        }
        if (this.aDU.getWriteData() != null) {
            if (this.aEi) {
                this.aDU.getWriteData().setCanNoForum(true);
                if (this.aDY != null) {
                    this.aDU.getWriteData().setVForumId(this.aDY.getId());
                    this.aDU.getWriteData().setVForumName(this.aDY.getName());
                }
            } else {
                this.aDU.getWriteData().setCanNoForum(false);
                this.aDU.getWriteData().setVForumId("");
                this.aDU.getWriteData().setVForumName("");
            }
            this.aDU.getWriteData().setWriteImagesInfo(this.writeImagesInfo);
            this.aDU.getWriteData().setVideoInfo(this.mVideoInfo);
            this.aDU.getWriteData().setGraffitiFileName(this.mGraffitiFileName);
            this.aDU.mC(this.writeImagesInfo.size() > 0);
            WriteData writeData2 = this.aDU.getWriteData();
            if (this.aDT == null || !this.aDT.Tm()) {
                z = false;
            }
            writeData2.setHasLocationData(z);
            if (str == null) {
                this.aDU.getWriteData().setContent(this.aDQ);
            }
            if (this.aDR != null) {
                if (this.aDR.getId() != null) {
                    this.aDU.getWriteData().setVoice(this.aDR.getId());
                    this.aDU.getWriteData().setVoiceDuringTime(this.aDR.duration);
                } else {
                    this.aDU.getWriteData().setVoice(null);
                    this.aDU.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.aDU.getWriteData().setVoice(null);
                this.aDU.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.aDU.btE()) {
                this.mContext.showToast(d.l.write_img_limit);
                return;
            }
            if (this.aEe != null) {
                this.aEe.Dx();
            }
            if (!this.aDU.startPostWrite()) {
            }
        }
    }

    public BaseActivity<?> getContext() {
        return this.mContext;
    }

    public void fX(String str) {
        this.aDQ = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.aDR = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int DK() {
        return this.aEc;
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

    public void fY(String str) {
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
        this.aEc = i;
        if (Da() != null) {
            Da().b(new com.baidu.tbadk.editortools.a(19, 8, new com.baidu.tbadk.editortools.d.a(i, z, str)));
            if (i == 2) {
                Da().b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            } else {
                Da().b(new com.baidu.tbadk.editortools.a(2, 7, null));
            }
        }
    }

    private void fZ(String str) {
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
        this.aEd = dVar;
    }

    public void a(b bVar) {
        this.aEe = bVar;
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
        if (!StringUtils.isNull(this.aDQ)) {
            this.aDQ = "";
        }
        fZ("");
        this.mGraffitiFileName = null;
        Da().b(new com.baidu.tbadk.editortools.a(42, 24, null));
        this.aDU.setWriteData(null);
        this.aDU.mC(false);
    }

    public void eO(final int i) {
        if (this.aEg == null && Da() != null) {
            this.aEg = (com.baidu.tbadk.editortools.inputtool.a) Da().eE(3);
        }
        if (this.aEg != null && (this.aEg.aCc instanceof EditText)) {
            final EditText editText = (EditText) this.aEg.aCc;
            this.aEg.b(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.c.8
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
                        if (!StringUtils.isNull(obj) && v.gT(obj) > i) {
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

    public void DQ() {
        if (this.aEg != null) {
            this.aEg.b(null);
        }
    }

    public void setGraffitiFileName(String str) {
        this.mGraffitiFileName = str;
    }
}
