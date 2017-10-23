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
    private boolean aCA;
    private TextWatcher aCB;
    private LocationModel.a aCC;
    private LocationModel.b aCD;
    private final NewWriteModel.d aCE;
    private final com.baidu.adp.base.d aCF;
    private String aCk;
    private VoiceData.VoiceModel aCl;
    private String aCm;
    private LocationModel aCn;
    private NewWriteModel aCo;
    private ImageModel aCp;
    private DataModel<?> aCq;
    private ForumData aCr;
    private String aCs;
    private String aCt;
    private int aCu;
    private NewWriteModel.d aCv;
    private b aCw;
    private com.baidu.tbadk.editortools.imagetool.b aCx;
    private com.baidu.tbadk.editortools.inputtool.a aCy;
    private com.baidu.tbadk.editortools.sendtool.a aCz;
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
        this.aCk = "";
        this.aCo = null;
        this.aCp = null;
        this.mThreadId = null;
        this.aCs = null;
        this.aCu = 0;
        this.aCA = false;
        this.aCC = new LocationModel.a() { // from class: com.baidu.tbadk.editortools.pb.c.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void Dk() {
                c.this.mContext.showToast(d.l.no_network_guide);
                c.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void fQ(String str) {
                BaseActivity baseActivity = c.this.mContext;
                if (StringUtils.isNull(str)) {
                    str = c.this.Ct().getContext().getString(d.l.location_fail);
                }
                baseActivity.showToast(str);
                c.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.brS())) {
                    c.this.a(2, true, aVar.brS());
                } else {
                    fQ(null);
                }
            }
        };
        this.aCD = new LocationModel.b() { // from class: com.baidu.tbadk.editortools.pb.c.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void Dl() {
                c.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void fR(String str) {
                c.this.a(2, true, str);
            }
        };
        this.aCE = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.c.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
                WriteData writeData2 = writeData == null ? c.this.aCo.getWriteData() : writeData;
                if (z) {
                    c.this.bK(true);
                    WriteData writeData3 = c.this.aCo.getWriteData();
                    c.this.resetData();
                    r.d(c.this.mThreadId, (WriteData) null);
                    if (writeData3 != null) {
                        if (writeData3 != null && writeData3.getType() == 2) {
                            r.a(writeData3.getThreadId(), c.this);
                        }
                    } else {
                        return;
                    }
                } else if (writeData2 != null && qVar != null && !TextUtils.isEmpty(qVar.xS())) {
                    writeData2.setVcodeMD5(qVar.getVcode_md5());
                    writeData2.setVcodeUrl(qVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(qVar.xT());
                    if (com.baidu.tbadk.p.a.gS(qVar.xS())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(c.this.mContext.getActivity(), 12006, writeData2, false, qVar.xS())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(c.this.mContext.getActivity(), writeData2, 12006)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(c.this.mContext.getActivity(), 12006, writeData2, postWriteCallBackData.getAccessState())));
                }
                if (c.this.aCv != null) {
                    c.this.aCv.callback(z, postWriteCallBackData, qVar, writeData2, antiData);
                }
            }
        };
        this.aCF = new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.editortools.pb.c.7
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                if (obj instanceof Bitmap) {
                    c.this.aCo.mF(true);
                }
            }
        };
    }

    private com.baidu.tbadk.editortools.sendtool.a CR() {
        if (this.aCz == null && Ct() != null) {
            this.aCz = (com.baidu.tbadk.editortools.sendtool.a) Ct().eO(4);
        }
        return this.aCz;
    }

    public void eV(int i) {
        if (this.aCz == null && Ct() != null) {
            this.aCz = (com.baidu.tbadk.editortools.sendtool.a) Ct().eO(4);
        }
        if (this.aCz != null) {
            this.aCz.setType(i);
        }
    }

    public void eW(int i) {
        if (this.aCz == null && Ct() != null) {
            this.aCz = (com.baidu.tbadk.editortools.sendtool.a) Ct().eO(4);
        }
        if (this.aCz != null) {
            this.aCz.eZ(i);
        }
    }

    private com.baidu.tbadk.editortools.imagetool.b CS() {
        if (this.aCx == null && Ct() != null) {
            this.aCx = (com.baidu.tbadk.editortools.imagetool.b) Ct().eO(11);
        }
        return this.aCx;
    }

    public void eX(int i) {
        if (this.aCx == null && Ct() != null) {
            this.aCx = (com.baidu.tbadk.editortools.imagetool.b) Ct().eO(11);
        }
        if (this.aCx != null) {
            this.aCx.eU(i);
        }
    }

    public com.baidu.tbadk.editortools.inputtool.a CT() {
        if (this.aCy == null && Ct() != null) {
            this.aCy = (com.baidu.tbadk.editortools.inputtool.a) Ct().eO(3);
        }
        return this.aCy;
    }

    public void fK(String str) {
        if (this.aCy == null && Ct() != null) {
            this.aCy = (com.baidu.tbadk.editortools.inputtool.a) Ct().eO(3);
        }
        if (this.aCy != null) {
            this.aCy.setHint(str);
        }
    }

    public void bF(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (Ct() != null && (cVar = (com.baidu.tbadk.editortools.c) Ct().eM(5)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bG(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (Ct() != null && (cVar = (com.baidu.tbadk.editortools.c) Ct().eM(23)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bH(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (Ct() != null && (cVar = (com.baidu.tbadk.editortools.c) Ct().eM(2)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.aCq = dataModel;
    }

    public void d(BaseActivity<?> baseActivity) {
        this.mContext = baseActivity;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.aCs = antiData.getVoice_message();
        }
    }

    public void a(ForumData forumData, UserData userData) {
        this.aCr = forumData;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (Ct() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.aCt = metaData.getName_show();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void bI(boolean z) {
        this.aCA = z;
    }

    public void CU() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            String valueOf = String.valueOf(this.authorId);
            if (valueOf == null || valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                l.showToast(this.mContext.getActivity(), d.l.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.mContext.getActivity(), this.authorId, this.authorName, this.aCt, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.g.b.c(this.mThreadId, 0L), com.baidu.adp.lib.g.b.c(this.postId, 0L))));
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
                        if (a.CP().getStatus() == 1) {
                            if (CS() != null) {
                                CS().eU(1);
                            }
                            if (getWriteImagesInfo() != null) {
                                getWriteImagesInfo().setMaxImagesAllowed(1);
                            }
                        } else {
                            if (CS() != null) {
                                CS().eU(10);
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
                        if (Ct() != null) {
                            lVar2 = Ct().eM(2);
                            lVar = Ct().eM(5);
                            lVar3 = Ct().eM(23);
                        } else {
                            lVar = null;
                            lVar2 = null;
                        }
                        if (a.CP().getStatus() == 1) {
                            Dg();
                            if (Ct() != null) {
                                Ct().CC();
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
                            if (CT() != null) {
                                CT().setHint(this.mContext.getPageContext().getString(d.l.add_picture_description));
                            }
                            if (CS() != null) {
                                CS().fE(this.mContext.getPageContext().getString(d.l.show_pic_tip));
                                CS().fF(this.mContext.getPageContext().getString(d.l.show_pic_add_tip));
                            }
                            if (CR() != null) {
                                CR().setType(SendView.aCZ);
                                CR().eZ(SendView.aCZ);
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
                            if (CT() != null) {
                                CT().setHint(this.mContext.getPageContext().getString(d.l.pb_reply_hint));
                            }
                            if (CR() != null) {
                                CR().setType(SendView.ALL);
                                CR().eZ(SendView.ALL);
                            }
                        }
                        Ct().invalidate();
                        return;
                    }
                    return;
                case 12003:
                    if (intent != null) {
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            Dd();
                            this.aCo.mF(false);
                            return;
                        }
                        this.aCp.fJ(intent.getStringExtra("file_name"));
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
                    WriteData writeData = this.aCo.getWriteData();
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra(WriteActivityConfig.POST_WRITE_CALLBACK_DATA) instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra(WriteActivityConfig.POST_WRITE_CALLBACK_DATA);
                    if (writeData != null) {
                        writeData.deleteUploadedTempImages();
                    }
                    this.aCo.setWriteData(null);
                    this.aCo.mF(false);
                    this.aCl = null;
                    this.mVideoInfo = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        r.d(this.mThreadId, (WriteData) null);
                    }
                    bK(true);
                    if (this.aCv != null) {
                        this.aCv.callback(true, postWriteCallBackData, null, writeData, null);
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
                    if (a.CP().getStatus() == 1 && CS() != null) {
                        CS().fE(this.mContext.getPageContext().getString(d.l.show_pic_tip));
                        return;
                    }
                    return;
                case 13010:
                    if (Ct() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            ak akVar = new ak("c10068");
                            akVar.r("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(akVar);
                            De();
                            Ct().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            Ct().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                Db();
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

    public void CV() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.mContext.getActivity())));
    }

    public void CW() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.mContext.getActivity())) {
            this.mContext.showToast(d.l.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            CX();
        } else if (this.aCn.bsa()) {
            CV();
        } else {
            this.aCn.mD(false);
            a(1, true, (String) null);
            this.aCn.brY();
        }
    }

    private void CX() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getActivity());
        aVar.cc(d.l.location_app_permission_prompt).a(d.l.isopen, new a.b() { // from class: com.baidu.tbadk.editortools.pb.c.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.hh()) {
                    c.this.a(1, true, (String) null);
                    c.this.aCn.UW();
                } else {
                    c.this.aCC.Dk();
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
        aVar.tb();
    }

    public void CY() {
        if (this.aCn.US()) {
            if (this.aCn.bsa()) {
                this.aCC.a(com.baidu.tieba.tbadkCore.location.c.brW().getLocationData());
                return;
            }
            if (l.hy()) {
                this.aCn.brY();
            }
            a(0, true, (String) null);
            return;
        }
        a(0, false, (String) null);
    }

    public boolean CZ() {
        if (StringUtils.isNull(this.aCk)) {
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() <= 0) {
                if (this.aCl == null || StringUtils.isNull(this.aCl.getId())) {
                    return this.mVideoInfo != null && this.mVideoInfo.isAvaliable();
                }
                return true;
            }
            return true;
        }
        return true;
    }

    public void resetData() {
        this.aCo.setWriteData(null);
        this.aCo.mF(false);
        this.aCl = null;
        this.mVideoInfo = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void Da() {
        this.mVideoInfo = null;
    }

    private void z(Intent intent) {
        this.aCm = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aCm;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.mContext.getActivity(), l.ad(this.mContext.getActivity())), l.dip2px(this.mContext.getActivity(), l.af(this.mContext.getActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    k.a(TbConfig.LOCAL_CAMERA_DIR, this.aCm, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            Df();
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
                Df();
            }
        }
    }

    private void Db() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tbadk.editortools.pb.c.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                k.t(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + c.this.aCm));
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

    public void fL(String str) {
        WriteData writeData = this.aCo.getWriteData();
        if (writeData == null) {
            writeData = new WriteData(1);
            writeData.setThreadId(str);
            writeData.setWriteImagesInfo(this.writeImagesInfo);
        }
        writeData.setContent(this.aCk);
        writeData.setVideoInfo(this.mVideoInfo);
        r.d(str, writeData);
    }

    public void fM(String str) {
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
                De();
                Ct().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                bJ(false);
            }
            if (!am.isEmpty(writeData.getContent()) && am.isEmpty(this.aCk)) {
                this.aCk = writeData.getContent();
                fP(this.aCk);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.aCo.cancelLoadData();
        this.aCp.cancelLoadData();
        this.aCn.cancelLoadData();
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        this.aCo = new NewWriteModel(baseActivity);
        this.aCo.b(this.aCE);
        this.aCp = new ImageModel(baseActivity);
        this.aCp.setLoadDataCallBack(this.aCF);
        this.aCn = new LocationModel(baseActivity);
        this.aCn.a(this.aCC);
        this.aCn.a(this.aCD);
        if (bundle != null) {
            this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
            this.aCm = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(10);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && Ct() != null) {
            Ct().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.aCn.US() && Ct() != null) {
            Ct().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.writeImagesInfo != null) {
            bundle.putString(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aCm);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.aCo.getWriteData() == null) {
            this.aCo.setWriteData(this.aCq.fI(str));
        }
        if (this.aCo.getWriteData() != null) {
            if (this.aCA) {
                this.aCo.getWriteData().setCanNoForum(true);
                if (this.aCr != null) {
                    this.aCo.getWriteData().setVForumId(this.aCr.getId());
                    this.aCo.getWriteData().setVForumName(this.aCr.getName());
                }
            } else {
                this.aCo.getWriteData().setCanNoForum(false);
                this.aCo.getWriteData().setVForumId("");
                this.aCo.getWriteData().setVForumName("");
            }
            this.aCo.getWriteData().setWriteImagesInfo(this.writeImagesInfo);
            this.aCo.getWriteData().setVideoInfo(this.mVideoInfo);
            this.aCo.mF(this.writeImagesInfo.size() > 0);
            WriteData writeData2 = this.aCo.getWriteData();
            if (this.aCn == null || !this.aCn.US()) {
                z = false;
            }
            writeData2.setHasLocationData(z);
            if (str == null) {
                this.aCo.getWriteData().setContent(this.aCk);
            }
            if (this.aCl != null) {
                if (this.aCl.getId() != null) {
                    this.aCo.getWriteData().setVoice(this.aCl.getId());
                    this.aCo.getWriteData().setVoiceDuringTime(this.aCl.duration);
                } else {
                    this.aCo.getWriteData().setVoice(null);
                    this.aCo.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.aCo.getWriteData().setVoice(null);
                this.aCo.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.aCo.bsv()) {
                this.mContext.showToast(d.l.write_img_limit);
                return;
            }
            if (this.aCw != null) {
                this.aCw.CQ();
            }
            if (!this.aCo.startPostWrite()) {
            }
        }
    }

    public BaseActivity<?> getContext() {
        return this.mContext;
    }

    public void fN(String str) {
        this.aCk = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.aCl = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int Dc() {
        return this.aCu;
    }

    private void Dd() {
        if (Ct() != null) {
            Ct().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void p(ArrayList<String> arrayList) {
        if (Ct() != null) {
            Ct().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    public void fO(String str) {
        if (Ct() != null) {
            Ct().b(new com.baidu.tbadk.editortools.a(44, 3, str));
        }
    }

    private void De() {
        if (Ct() != null) {
            Ct().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    protected void bJ(boolean z) {
        if (Ct() != null) {
            if (z) {
                Ct().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            Ct().b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                Ct().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
            } else {
                Ct().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
        }
    }

    protected void Df() {
        bJ(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Dg() {
        if (Ct() != null) {
            Ct().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.aCu = i;
        if (Ct() != null) {
            Ct().b(new com.baidu.tbadk.editortools.a(19, 8, new com.baidu.tbadk.editortools.d.a(i, z, str)));
            if (i == 2) {
                Ct().b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            } else {
                Ct().b(new com.baidu.tbadk.editortools.a(2, 7, null));
            }
        }
    }

    private void fP(String str) {
        if (Ct() != null) {
            Ct().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bK(boolean z) {
        if (Ct() != null) {
            Ct().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.aCv = dVar;
    }

    public void a(b bVar) {
        this.aCw = bVar;
    }

    public void Dh() {
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            this.writeImagesInfo.clear();
        }
        Df();
        if (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) {
            this.mVideoInfo = null;
        }
        Ct().b(new com.baidu.tbadk.editortools.a(2, 19, null));
        setVoiceModel(null);
        Ct().b(new com.baidu.tbadk.editortools.a(2, 6, null));
        Ct().b(new com.baidu.tbadk.editortools.a(33, 6, null));
        if (!StringUtils.isNull(this.aCk)) {
            this.aCk = "";
        }
        fP("");
        this.aCo.setWriteData(null);
        this.aCo.mF(false);
    }

    public void eY(final int i) {
        Di();
        if (this.aCy != null && (this.aCy.aAv instanceof EditText)) {
            final EditText editText = (EditText) this.aCy.aAv;
            if (this.aCB == null) {
                this.aCB = new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.c.8
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
                            if (!StringUtils.isNull(obj) && u.gO(obj) > i) {
                                String e = u.e(obj, 0, i - 1);
                                editText.setText(e);
                                editText.setSelection(editText.getText().length());
                                UtilHelper.showToast(c.this.getContext().getApplication(), c.this.getContext().getResources().getString(d.l.edit_text_over_limit_tip, Integer.valueOf(e.length())));
                            }
                        }
                    }
                };
            }
            this.aCy.a(this.aCB);
        }
    }

    private void Di() {
        if (this.aCy == null && Ct() != null) {
            this.aCy = (com.baidu.tbadk.editortools.inputtool.a) Ct().eO(3);
        }
    }

    public void Dj() {
        if (this.aCy != null && this.aCB != null) {
            this.aCy.b(this.aCB);
        }
    }

    public void c(TextWatcher textWatcher) {
        Di();
        if (this.aCy != null && textWatcher != null) {
            this.aCy.a(textWatcher);
        }
    }
}
