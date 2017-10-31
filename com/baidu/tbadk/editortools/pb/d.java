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
import com.baidu.tbadk.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.s;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d extends com.baidu.tbadk.editortools.f implements s.a {
    private String aCT;
    private VoiceData.VoiceModel aCU;
    private String aCV;
    private LocationModel aCW;
    private NewWriteModel aCX;
    private ImageModel aCY;
    private DataModel<?> aCZ;
    private ForumData aDa;
    private String aDb;
    private String aDc;
    private int aDd;
    private NewWriteModel.d aDe;
    private c aDf;
    private b aDg;
    private com.baidu.tbadk.editortools.imagetool.b aDh;
    private com.baidu.tbadk.editortools.inputtool.a aDi;
    private com.baidu.tbadk.editortools.sendtool.a aDj;
    private boolean aDk;
    private TextWatcher aDl;
    private LocationModel.a aDm;
    private LocationModel.b aDn;
    private final NewWriteModel.d aDo;
    private final com.baidu.adp.base.d aDp;
    private long authorId;
    private String authorName;
    private BaseActivity<?> mContext;
    private String mThreadId;
    private VideoInfo mVideoInfo;
    private String postId;
    private WriteImagesInfo writeImagesInfo;

    public d(i iVar) {
        super(iVar);
        this.writeImagesInfo = new WriteImagesInfo();
        this.aCT = "";
        this.aCX = null;
        this.aCY = null;
        this.mThreadId = null;
        this.aDb = null;
        this.aDd = 0;
        this.aDk = false;
        this.aDm = new LocationModel.a() { // from class: com.baidu.tbadk.editortools.pb.d.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void Dz() {
                d.this.mContext.showToast(d.j.no_network_guide);
                d.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void fX(String str) {
                BaseActivity baseActivity = d.this.mContext;
                if (StringUtils.isNull(str)) {
                    str = d.this.CI().getContext().getString(d.j.location_fail);
                }
                baseActivity.showToast(str);
                d.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.buW())) {
                    d.this.a(2, true, aVar.buW());
                } else {
                    fX(null);
                }
            }
        };
        this.aDn = new LocationModel.b() { // from class: com.baidu.tbadk.editortools.pb.d.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void DA() {
                d.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void fY(String str) {
                d.this.a(2, true, str);
            }
        };
        this.aDo = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.d.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
                WriteData writeData2 = writeData == null ? d.this.aCX.getWriteData() : writeData;
                if (z) {
                    d.this.bF(true);
                    WriteData writeData3 = d.this.aCX.getWriteData();
                    d.this.resetData();
                    s.d(d.this.mThreadId, (WriteData) null);
                    if (writeData3 != null) {
                        if (writeData3 != null && writeData3.getType() == 2) {
                            s.a(writeData3.getThreadId(), d.this);
                        }
                    } else {
                        return;
                    }
                } else if (writeData2 != null && qVar != null && !TextUtils.isEmpty(qVar.xZ())) {
                    writeData2.setVcodeMD5(qVar.getVcode_md5());
                    writeData2.setVcodeUrl(qVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(qVar.ya());
                    if (com.baidu.tbadk.q.a.ha(qVar.xZ())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(d.this.mContext.getActivity(), 12006, writeData2, false, qVar.xZ())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(d.this.mContext.getActivity(), writeData2, 12006)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(d.this.mContext.getActivity(), 12006, writeData2, postWriteCallBackData.getAccessState())));
                }
                if (d.this.aDe != null) {
                    d.this.aDe.callback(z, postWriteCallBackData, qVar, writeData2, antiData);
                }
            }
        };
        this.aDp = new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.editortools.pb.d.7
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                if (obj instanceof Bitmap) {
                    d.this.aCX.mB(true);
                }
            }
        };
    }

    private com.baidu.tbadk.editortools.sendtool.a Dg() {
        if (this.aDj == null && CI() != null) {
            this.aDj = (com.baidu.tbadk.editortools.sendtool.a) CI().eP(4);
        }
        return this.aDj;
    }

    public void eW(int i) {
        if (this.aDj == null && CI() != null) {
            this.aDj = (com.baidu.tbadk.editortools.sendtool.a) CI().eP(4);
        }
        if (this.aDj != null) {
            this.aDj.setType(i);
        }
    }

    public void eX(int i) {
        if (this.aDj == null && CI() != null) {
            this.aDj = (com.baidu.tbadk.editortools.sendtool.a) CI().eP(4);
        }
        if (this.aDj != null) {
            this.aDj.fa(i);
        }
    }

    private com.baidu.tbadk.editortools.imagetool.b Dh() {
        if (this.aDh == null && CI() != null) {
            this.aDh = (com.baidu.tbadk.editortools.imagetool.b) CI().eP(11);
        }
        return this.aDh;
    }

    public void eY(int i) {
        if (this.aDh == null && CI() != null) {
            this.aDh = (com.baidu.tbadk.editortools.imagetool.b) CI().eP(11);
        }
        if (this.aDh != null) {
            this.aDh.eV(i);
        }
    }

    public com.baidu.tbadk.editortools.inputtool.a Di() {
        if (this.aDi == null && CI() != null) {
            this.aDi = (com.baidu.tbadk.editortools.inputtool.a) CI().eP(3);
        }
        return this.aDi;
    }

    public void fR(String str) {
        if (this.aDi == null && CI() != null) {
            this.aDi = (com.baidu.tbadk.editortools.inputtool.a) CI().eP(3);
        }
        if (this.aDi != null) {
            this.aDi.setHint(str);
        }
    }

    public void bA(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (CI() != null && (cVar = (com.baidu.tbadk.editortools.c) CI().eN(5)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bB(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (CI() != null && (cVar = (com.baidu.tbadk.editortools.c) CI().eN(23)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bC(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (CI() != null && (cVar = (com.baidu.tbadk.editortools.c) CI().eN(2)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.aCZ = dataModel;
    }

    public void d(BaseActivity<?> baseActivity) {
        this.mContext = baseActivity;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.aDb = antiData.getVoice_message();
        }
    }

    public void a(ForumData forumData, UserData userData) {
        this.aDa = forumData;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (CI() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.aDc = metaData.getName_show();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void bD(boolean z) {
        this.aDk = z;
    }

    public void Dj() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            String valueOf = String.valueOf(this.authorId);
            if (valueOf == null || valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                l.showToast(this.mContext.getActivity(), d.j.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.mContext.getActivity(), this.authorId, this.authorName, this.aDc, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.g.b.c(this.mThreadId, 0L), com.baidu.adp.lib.g.b.c(this.postId, 0L))));
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
                        if (a.Dd().getStatus() == 1) {
                            if (Dh() != null) {
                                Dh().eV(1);
                            }
                            if (getWriteImagesInfo() != null) {
                                getWriteImagesInfo().setMaxImagesAllowed(1);
                            }
                        } else {
                            if (Dh() != null) {
                                Dh().eV(10);
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
                        if (CI() != null) {
                            lVar2 = CI().eN(2);
                            lVar = CI().eN(5);
                            lVar3 = CI().eN(23);
                        } else {
                            lVar = null;
                            lVar2 = null;
                        }
                        if (a.Dd().getStatus() == 1) {
                            Dv();
                            if (CI() != null) {
                                CI().CR();
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL));
                            }
                            if (lVar2 != null) {
                                lVar2.hide();
                            }
                            if (lVar != null) {
                                lVar.hide();
                            }
                            if (lVar3 != null) {
                                lVar3.lG();
                            }
                            if (Di() != null) {
                                Di().setHint(this.mContext.getPageContext().getString(d.j.add_picture_description));
                            }
                            if (Dh() != null) {
                                Dh().fL(this.mContext.getPageContext().getString(d.j.show_pic_tip));
                                Dh().fM(this.mContext.getPageContext().getString(d.j.show_pic_add_tip));
                            }
                            if (Dg() != null) {
                                Dg().setType(SendView.aDJ);
                                Dg().fa(SendView.aDJ);
                            }
                        } else {
                            if (lVar2 != null) {
                                lVar2.lG();
                            }
                            if (lVar != null) {
                                lVar.lG();
                            }
                            if (lVar3 != null) {
                                lVar3.hide();
                            }
                            if (Di() != null) {
                                Di().setHint(this.mContext.getPageContext().getString(d.j.pb_reply_hint));
                            }
                            if (Dg() != null) {
                                Dg().setType(SendView.ALL);
                                Dg().fa(SendView.ALL);
                            }
                        }
                        CI().invalidate();
                        return;
                    }
                    return;
                case 12003:
                    if (intent != null) {
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            Ds();
                            this.aCX.mB(false);
                            return;
                        }
                        this.aCY.fQ(intent.getStringExtra("file_name"));
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
                    WriteData writeData = this.aCX.getWriteData();
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra(WriteActivityConfig.POST_WRITE_CALLBACK_DATA) instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra(WriteActivityConfig.POST_WRITE_CALLBACK_DATA);
                    if (writeData != null) {
                        writeData.deleteUploadedTempImages();
                    }
                    this.aCX.setWriteData(null);
                    this.aCX.mB(false);
                    this.aCU = null;
                    this.mVideoInfo = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        s.d(this.mThreadId, (WriteData) null);
                    }
                    bF(true);
                    if (this.aDe != null) {
                        this.aDe.callback(true, postWriteCallBackData, null, writeData, null);
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
                    if (a.Dd().getStatus() == 1 && Dh() != null) {
                        Dh().fL(this.mContext.getPageContext().getString(d.j.show_pic_tip));
                        return;
                    }
                    return;
                case 13010:
                    if (CI() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            ak akVar = new ak("c10068");
                            akVar.r("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(akVar);
                            Dt();
                            CI().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            CI().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                        fV(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 12001:
                Dq();
                return;
            case 12002:
                if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                    this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    return;
                }
                return;
            case 12003:
            case 12004:
            case 12005:
            case 12007:
            case 12008:
            case 12009:
            case 12010:
            default:
                return;
            case 12006:
                PostWriteCallBackData postWriteCallBackData2 = (intent == null || !(intent.getSerializableExtra(WriteActivityConfig.POST_WRITE_CALLBACK_DATA) instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra(WriteActivityConfig.POST_WRITE_CALLBACK_DATA);
                if (this.aDe != null) {
                    this.aDe.callback(false, postWriteCallBackData2, null, this.aCX.getWriteData(), null);
                    return;
                }
                return;
        }
    }

    public void Dk() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.mContext.getActivity())));
    }

    public void Dl() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.mContext.getActivity())) {
            this.mContext.showToast(d.j.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            Dm();
        } else if (this.aCW.bve()) {
            Dk();
        } else {
            this.aCW.mz(false);
            a(1, true, (String) null);
            this.aCW.bvc();
        }
    }

    private void Dm() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getActivity());
        aVar.cc(d.j.location_app_permission_prompt).a(d.j.isopen, new a.b() { // from class: com.baidu.tbadk.editortools.pb.d.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.hh()) {
                    d.this.a(1, true, (String) null);
                    d.this.aCW.WO();
                } else {
                    d.this.aDm.Dz();
                }
                aVar2.dismiss();
            }
        }).b(d.j.cancel, new a.b() { // from class: com.baidu.tbadk.editortools.pb.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                d.this.a(0, true, (String) null);
                aVar2.dismiss();
            }
        }).b(this.mContext.getPageContext());
        aVar.th();
    }

    public void Dn() {
        if (this.aCW.WK()) {
            if (this.aCW.bve()) {
                this.aDm.a(com.baidu.tieba.tbadkCore.location.c.bva().getLocationData());
                return;
            }
            if (l.hy()) {
                this.aCW.bvc();
            }
            a(0, true, (String) null);
            return;
        }
        a(0, false, (String) null);
    }

    public boolean Do() {
        if (StringUtils.isNull(this.aCT)) {
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() <= 0) {
                if (this.aCU == null || StringUtils.isNull(this.aCU.getId())) {
                    return this.mVideoInfo != null && this.mVideoInfo.isAvaliable();
                }
                return true;
            }
            return true;
        }
        return true;
    }

    public void resetData() {
        this.aCX.setWriteData(null);
        this.aCX.mB(false);
        this.aCU = null;
        this.mVideoInfo = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void Dp() {
        this.mVideoInfo = null;
    }

    private void z(Intent intent) {
        this.aCV = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aCV;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.mContext.getActivity(), l.ac(this.mContext.getActivity())), l.dip2px(this.mContext.getActivity(), l.ae(this.mContext.getActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    k.a(TbConfig.LOCAL_CAMERA_DIR, this.aCV, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            Du();
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
                Du();
            }
        }
    }

    private void Dq() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tbadk.editortools.pb.d.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                k.s(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + d.this.aCV));
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

    public void fS(String str) {
        WriteData writeData = this.aCX.getWriteData();
        if (writeData == null) {
            writeData = new WriteData(1);
            writeData.setThreadId(str);
            writeData.setWriteImagesInfo(this.writeImagesInfo);
        }
        writeData.setContent(this.aCT);
        writeData.setVideoInfo(this.mVideoInfo);
        s.d(str, writeData);
    }

    public void fT(String str) {
        s.a(str, this);
    }

    @Override // com.baidu.tieba.tbadkCore.s.a
    public void a(WriteData writeData) {
        if (writeData != null) {
            if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                if (this.mVideoInfo == null) {
                    this.mVideoInfo = new VideoInfo();
                }
                this.mVideoInfo.copy(writeData.getVideoInfo());
                Dt();
                CI().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                bE(false);
            }
            if (!am.isEmpty(writeData.getContent()) && am.isEmpty(this.aCT)) {
                this.aCT = writeData.getContent();
                fW(this.aCT);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.aCX.cancelLoadData();
        this.aCY.cancelLoadData();
        this.aCW.cancelLoadData();
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        this.aCX = new NewWriteModel(baseActivity);
        this.aCX.b(this.aDo);
        this.aCY = new ImageModel(baseActivity);
        this.aCY.setLoadDataCallBack(this.aDp);
        this.aCW = new LocationModel(baseActivity);
        this.aCW.a(this.aDm);
        this.aCW.a(this.aDn);
        if (bundle != null) {
            this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
            this.aCV = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(10);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && CI() != null) {
            CI().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.aCW.WK() && CI() != null) {
            CI().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.writeImagesInfo != null) {
            bundle.putString(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aCV);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.aCX.getWriteData() == null) {
            this.aCX.setWriteData(this.aCZ.fP(str));
        }
        if (this.aCX.getWriteData() != null) {
            if (this.aDk) {
                this.aCX.getWriteData().setCanNoForum(true);
                if (this.aDa != null) {
                    this.aCX.getWriteData().setVForumId(this.aDa.getId());
                    this.aCX.getWriteData().setVForumName(this.aDa.getName());
                }
            } else {
                this.aCX.getWriteData().setCanNoForum(false);
                this.aCX.getWriteData().setVForumId("");
                this.aCX.getWriteData().setVForumName("");
            }
            this.aCX.getWriteData().setWriteImagesInfo(this.writeImagesInfo);
            this.aCX.getWriteData().setVideoInfo(this.mVideoInfo);
            this.aCX.mB(this.writeImagesInfo.size() > 0);
            WriteData writeData2 = this.aCX.getWriteData();
            if (this.aCW == null || !this.aCW.WK()) {
                z = false;
            }
            writeData2.setHasLocationData(z);
            if (str == null) {
                this.aCX.getWriteData().setContent(this.aCT);
            }
            if (this.aCU != null) {
                if (this.aCU.getId() != null) {
                    this.aCX.getWriteData().setVoice(this.aCU.getId());
                    this.aCX.getWriteData().setVoiceDuringTime(this.aCU.duration);
                } else {
                    this.aCX.getWriteData().setVoice(null);
                    this.aCX.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.aCX.getWriteData().setVoice(null);
                this.aCX.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.aCX.bvz()) {
                this.mContext.showToast(d.j.write_img_limit);
            } else if (this.aDg == null || !this.aDg.De()) {
                if (this.aDf != null) {
                    this.aDf.Df();
                }
                if (!this.aCX.startPostWrite()) {
                }
            }
        }
    }

    public BaseActivity<?> getContext() {
        return this.mContext;
    }

    public void fU(String str) {
        this.aCT = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.aCU = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int Dr() {
        return this.aDd;
    }

    private void Ds() {
        if (CI() != null) {
            CI().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void q(ArrayList<String> arrayList) {
        if (CI() != null) {
            CI().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    public void fV(String str) {
        if (CI() != null) {
            CI().b(new com.baidu.tbadk.editortools.a(44, 3, str));
        }
    }

    private void Dt() {
        if (CI() != null) {
            CI().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    protected void bE(boolean z) {
        if (CI() != null) {
            if (z) {
                CI().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            CI().b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                CI().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
            } else {
                CI().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
        }
    }

    protected void Du() {
        bE(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Dv() {
        if (CI() != null) {
            CI().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.aDd = i;
        if (CI() != null) {
            CI().b(new com.baidu.tbadk.editortools.a(19, 8, new com.baidu.tbadk.editortools.d.a(i, z, str)));
            if (i == 2) {
                CI().b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            } else {
                CI().b(new com.baidu.tbadk.editortools.a(2, 7, null));
            }
        }
    }

    private void fW(String str) {
        if (CI() != null) {
            CI().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bF(boolean z) {
        if (CI() != null) {
            CI().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.aDe = dVar;
    }

    public void a(c cVar) {
        this.aDf = cVar;
    }

    public void a(b bVar) {
        this.aDg = bVar;
    }

    public void Dw() {
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            this.writeImagesInfo.clear();
        }
        Du();
        if (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) {
            this.mVideoInfo = null;
        }
        CI().b(new com.baidu.tbadk.editortools.a(2, 19, null));
        setVoiceModel(null);
        CI().b(new com.baidu.tbadk.editortools.a(2, 6, null));
        CI().b(new com.baidu.tbadk.editortools.a(33, 6, null));
        if (!StringUtils.isNull(this.aCT)) {
            this.aCT = "";
        }
        fW("");
        this.aCX.setWriteData(null);
        this.aCX.mB(false);
    }

    public void eZ(final int i) {
        Dx();
        if (this.aDi != null && (this.aDi.aBf instanceof EditText)) {
            final EditText editText = (EditText) this.aDi.aBf;
            if (this.aDl == null) {
                this.aDl = new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.d.8
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
                            if (!StringUtils.isNull(obj) && w.gV(obj) > i) {
                                String e = w.e(obj, 0, i - 1);
                                editText.setText(e);
                                editText.setSelection(editText.getText().length());
                                UtilHelper.showToast(d.this.getContext().getApplication(), d.this.getContext().getResources().getString(d.j.edit_text_over_limit_tip, Integer.valueOf(e.length())));
                            }
                        }
                    }
                };
            }
            this.aDi.a(this.aDl);
        }
    }

    private void Dx() {
        if (this.aDi == null && CI() != null) {
            this.aDi = (com.baidu.tbadk.editortools.inputtool.a) CI().eP(3);
        }
    }

    public void Dy() {
        if (this.aDi != null && this.aDl != null) {
            this.aDi.b(this.aDl);
        }
    }

    public void c(TextWatcher textWatcher) {
        Dx();
        if (this.aDi != null && textWatcher != null) {
            this.aDi.a(textWatcher);
        }
    }
}
