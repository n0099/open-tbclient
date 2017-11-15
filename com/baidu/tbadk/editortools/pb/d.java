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
import com.baidu.tbadk.coreExtra.data.r;
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
    private String aDb;
    private VoiceData.VoiceModel aDc;
    private String aDd;
    private LocationModel aDe;
    private NewWriteModel aDf;
    private ImageModel aDg;
    private DataModel<?> aDh;
    private ForumData aDi;
    private String aDj;
    private String aDk;
    private int aDl;
    private NewWriteModel.d aDm;
    private c aDn;
    private b aDo;
    private com.baidu.tbadk.editortools.imagetool.b aDp;
    private com.baidu.tbadk.editortools.inputtool.a aDq;
    private com.baidu.tbadk.editortools.sendtool.a aDr;
    private boolean aDs;
    private TextWatcher aDt;
    private LocationModel.a aDu;
    private LocationModel.b aDv;
    private final NewWriteModel.d aDw;
    private final com.baidu.adp.base.d aDx;
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
        this.aDb = "";
        this.aDf = null;
        this.aDg = null;
        this.mThreadId = null;
        this.aDj = null;
        this.aDl = 0;
        this.aDs = false;
        this.aDu = new LocationModel.a() { // from class: com.baidu.tbadk.editortools.pb.d.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void DL() {
                d.this.mContext.showToast(d.j.no_network_guide);
                d.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void fY(String str) {
                BaseActivity baseActivity = d.this.mContext;
                if (StringUtils.isNull(str)) {
                    str = d.this.CU().getContext().getString(d.j.location_fail);
                }
                baseActivity.showToast(str);
                d.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.bvi())) {
                    d.this.a(2, true, aVar.bvi());
                } else {
                    fY(null);
                }
            }
        };
        this.aDv = new LocationModel.b() { // from class: com.baidu.tbadk.editortools.pb.d.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void DM() {
                d.this.a(0, false, (String) null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void fZ(String str) {
                d.this.a(2, true, str);
            }
        };
        this.aDw = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.d.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, r rVar, WriteData writeData, AntiData antiData) {
                WriteData writeData2 = writeData == null ? d.this.aDf.getWriteData() : writeData;
                if (z) {
                    d.this.bG(true);
                    WriteData writeData3 = d.this.aDf.getWriteData();
                    d.this.resetData();
                    s.d(d.this.mThreadId, (WriteData) null);
                    if (writeData3 != null) {
                        if (writeData3 != null && writeData3.getType() == 2) {
                            s.a(writeData3.getThreadId(), d.this);
                        }
                    } else {
                        return;
                    }
                } else if (writeData2 != null && rVar != null && !TextUtils.isEmpty(rVar.yh())) {
                    writeData2.setVcodeMD5(rVar.getVcode_md5());
                    writeData2.setVcodeUrl(rVar.getVcode_pic_url());
                    writeData2.setVcodeExtra(rVar.yi());
                    if (com.baidu.tbadk.q.a.hb(rVar.yh())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(d.this.mContext.getActivity(), 12006, writeData2, false, rVar.yh())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(d.this.mContext.getActivity(), writeData2, 12006)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(d.this.mContext.getActivity(), 12006, writeData2, postWriteCallBackData.getAccessState())));
                }
                if (d.this.aDm != null) {
                    d.this.aDm.callback(z, postWriteCallBackData, rVar, writeData2, antiData);
                }
            }
        };
        this.aDx = new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.editortools.pb.d.7
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                if (obj instanceof Bitmap) {
                    d.this.aDf.mJ(true);
                }
            }
        };
    }

    private com.baidu.tbadk.editortools.sendtool.a Ds() {
        if (this.aDr == null && CU() != null) {
            this.aDr = (com.baidu.tbadk.editortools.sendtool.a) CU().eO(4);
        }
        return this.aDr;
    }

    public void eV(int i) {
        if (this.aDr == null && CU() != null) {
            this.aDr = (com.baidu.tbadk.editortools.sendtool.a) CU().eO(4);
        }
        if (this.aDr != null) {
            this.aDr.setType(i);
        }
    }

    public void eW(int i) {
        if (this.aDr == null && CU() != null) {
            this.aDr = (com.baidu.tbadk.editortools.sendtool.a) CU().eO(4);
        }
        if (this.aDr != null) {
            this.aDr.eZ(i);
        }
    }

    private com.baidu.tbadk.editortools.imagetool.b Dt() {
        if (this.aDp == null && CU() != null) {
            this.aDp = (com.baidu.tbadk.editortools.imagetool.b) CU().eO(11);
        }
        return this.aDp;
    }

    public void eX(int i) {
        if (this.aDp == null && CU() != null) {
            this.aDp = (com.baidu.tbadk.editortools.imagetool.b) CU().eO(11);
        }
        if (this.aDp != null) {
            this.aDp.eU(i);
        }
    }

    public com.baidu.tbadk.editortools.inputtool.a Du() {
        if (this.aDq == null && CU() != null) {
            this.aDq = (com.baidu.tbadk.editortools.inputtool.a) CU().eO(3);
        }
        return this.aDq;
    }

    public void fS(String str) {
        if (this.aDq == null && CU() != null) {
            this.aDq = (com.baidu.tbadk.editortools.inputtool.a) CU().eO(3);
        }
        if (this.aDq != null) {
            this.aDq.setHint(str);
        }
    }

    public void bB(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (CU() != null && (cVar = (com.baidu.tbadk.editortools.c) CU().eM(5)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bC(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (CU() != null && (cVar = (com.baidu.tbadk.editortools.c) CU().eM(23)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void bD(boolean z) {
        com.baidu.tbadk.editortools.c cVar;
        if (CU() != null && (cVar = (com.baidu.tbadk.editortools.c) CU().eM(2)) != null) {
            cVar.setOutSetVisibilty(z);
        }
    }

    public void a(DataModel<?> dataModel) {
        this.aDh = dataModel;
    }

    public void d(BaseActivity<?> baseActivity) {
        this.mContext = baseActivity;
    }

    public void a(AntiData antiData) {
        if (antiData != null) {
            this.aDj = antiData.getVoice_message();
        }
    }

    public void a(ForumData forumData, UserData userData) {
        this.aDi = forumData;
    }

    public void a(MetaData metaData, String str, String str2) {
        if (CU() != null && metaData != null) {
            this.authorId = metaData.getUserIdLong();
            this.authorName = metaData.getUserName();
            this.aDk = metaData.getName_show();
            this.mThreadId = str;
            this.postId = str2;
        }
    }

    public void bE(boolean z) {
        this.aDs = z;
    }

    public void Dv() {
        if (!StringUtils.isNull(this.authorName) && this.authorId > 0) {
            String valueOf = String.valueOf(this.authorId);
            if (valueOf == null || valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                l.showToast(this.mContext.getActivity(), d.j.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.mContext.getActivity(), this.authorId, this.authorName, this.aDk, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.g.b.c(this.mThreadId, 0L), com.baidu.adp.lib.g.b.c(this.postId, 0L))));
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
                        if (a.Dp().getStatus() == 1) {
                            if (Dt() != null) {
                                Dt().eU(1);
                            }
                            if (getWriteImagesInfo() != null) {
                                getWriteImagesInfo().setMaxImagesAllowed(1);
                            }
                        } else {
                            if (Dt() != null) {
                                Dt().eU(10);
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
                        if (CU() != null) {
                            lVar2 = CU().eM(2);
                            lVar = CU().eM(5);
                            lVar3 = CU().eM(23);
                        } else {
                            lVar = null;
                            lVar2 = null;
                        }
                        if (a.Dp().getStatus() == 1) {
                            DH();
                            if (CU() != null) {
                                CU().Dd();
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
                            if (Du() != null) {
                                Du().setHint(this.mContext.getPageContext().getString(d.j.add_picture_description));
                            }
                            if (Dt() != null) {
                                Dt().fM(this.mContext.getPageContext().getString(d.j.show_pic_tip));
                                Dt().fN(this.mContext.getPageContext().getString(d.j.show_pic_add_tip));
                            }
                            if (Ds() != null) {
                                Ds().setType(SendView.aDR);
                                Ds().eZ(SendView.aDR);
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
                            if (Du() != null) {
                                Du().setHint(this.mContext.getPageContext().getString(d.j.pb_reply_hint));
                            }
                            if (Ds() != null) {
                                Ds().setType(SendView.ALL);
                                Ds().eZ(SendView.ALL);
                            }
                        }
                        CU().invalidate();
                        return;
                    }
                    return;
                case 12003:
                    if (intent != null) {
                        if (intent.getBooleanExtra(WriteImageActivityConfig.DELET_FLAG, false)) {
                            DE();
                            this.aDf.mJ(false);
                            return;
                        }
                        this.aDg.fR(intent.getStringExtra("file_name"));
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
                    WriteData writeData = this.aDf.getWriteData();
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra(WriteActivityConfig.POST_WRITE_CALLBACK_DATA) instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra(WriteActivityConfig.POST_WRITE_CALLBACK_DATA);
                    if (writeData != null) {
                        writeData.deleteUploadedTempImages();
                    }
                    this.aDf.setWriteData(null);
                    this.aDf.mJ(false);
                    this.aDc = null;
                    this.mVideoInfo = null;
                    if (!TextUtils.isEmpty(this.mThreadId)) {
                        s.d(this.mThreadId, (WriteData) null);
                    }
                    bG(true);
                    if (this.aDm != null) {
                        this.aDm.callback(true, postWriteCallBackData, null, writeData, null);
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
                    if (a.Dp().getStatus() == 1 && Dt() != null) {
                        Dt().fM(this.mContext.getPageContext().getString(d.j.show_pic_tip));
                        return;
                    }
                    return;
                case 13010:
                    if (CU() != null) {
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.parseFromIntent(intent);
                        if (videoInfo.isAvaliable()) {
                            this.mVideoInfo = videoInfo;
                            ak akVar = new ak("c10068");
                            akVar.r("duration", this.mVideoInfo.getVideoDuration());
                            TiebaStatic.log(akVar);
                            DF();
                            CU().b(new com.baidu.tbadk.editortools.a(28, 20, this.mVideoInfo));
                            CU().b(new com.baidu.tbadk.editortools.a(28, -1, this.mVideoInfo));
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
                DC();
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
                if (this.aDm != null) {
                    this.aDm.callback(false, postWriteCallBackData2, null, this.aDf.getWriteData(), null);
                    return;
                }
                return;
        }
    }

    public void Dw() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.mContext.getActivity())));
    }

    public void Dx() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.mContext.getActivity())) {
            this.mContext.showToast(d.j.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            Dy();
        } else if (this.aDe.bvq()) {
            Dw();
        } else {
            this.aDe.mH(false);
            a(1, true, (String) null);
            this.aDe.bvo();
        }
    }

    private void Dy() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getActivity());
        aVar.cc(d.j.location_app_permission_prompt).a(d.j.isopen, new a.b() { // from class: com.baidu.tbadk.editortools.pb.d.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.hh()) {
                    d.this.a(1, true, (String) null);
                    d.this.aDe.WZ();
                } else {
                    d.this.aDu.DL();
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

    public void Dz() {
        if (this.aDe.WV()) {
            if (this.aDe.bvq()) {
                this.aDu.a(com.baidu.tieba.tbadkCore.location.c.bvm().getLocationData());
                return;
            }
            if (l.hy()) {
                this.aDe.bvo();
            }
            a(0, true, (String) null);
            return;
        }
        a(0, false, (String) null);
    }

    public boolean DA() {
        if (StringUtils.isNull(this.aDb)) {
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() <= 0) {
                if (this.aDc == null || StringUtils.isNull(this.aDc.getId())) {
                    return this.mVideoInfo != null && this.mVideoInfo.isAvaliable();
                }
                return true;
            }
            return true;
        }
        return true;
    }

    public void resetData() {
        this.aDf.setWriteData(null);
        this.aDf.mJ(false);
        this.aDc = null;
        this.mVideoInfo = null;
        this.writeImagesInfo.clear();
    }

    public VideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public void DB() {
        this.mVideoInfo = null;
    }

    private void z(Intent intent) {
        this.aDd = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aDd;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.mContext.getActivity(), l.ac(this.mContext.getActivity())), l.dip2px(this.mContext.getActivity(), l.ae(this.mContext.getActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    k.a(TbConfig.LOCAL_CAMERA_DIR, this.aDd, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            DG();
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
                DG();
            }
        }
    }

    private void DC() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tbadk.editortools.pb.d.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                k.s(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + d.this.aDd));
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
        WriteData writeData = this.aDf.getWriteData();
        if (writeData == null) {
            writeData = new WriteData(1);
            writeData.setThreadId(str);
            writeData.setWriteImagesInfo(this.writeImagesInfo);
        }
        writeData.setContent(this.aDb);
        writeData.setVideoInfo(this.mVideoInfo);
        s.d(str, writeData);
    }

    public void fU(String str) {
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
                DF();
                CU().b(new com.baidu.tbadk.editortools.a(39, -1, this.mVideoInfo));
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                bF(false);
            }
            if (!am.isEmpty(writeData.getContent()) && am.isEmpty(this.aDb)) {
                this.aDb = writeData.getContent();
                fX(this.aDb);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_LOAD_DRAFT));
        }
    }

    public void onDestroy() {
        this.aDf.cancelLoadData();
        this.aDg.cancelLoadData();
        this.aDe.cancelLoadData();
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        this.aDf = new NewWriteModel(baseActivity);
        this.aDf.b(this.aDw);
        this.aDg = new ImageModel(baseActivity);
        this.aDg.setLoadDataCallBack(this.aDx);
        this.aDe = new LocationModel(baseActivity);
        this.aDe.a(this.aDu);
        this.aDe.a(this.aDv);
        if (bundle != null) {
            this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
            this.aDd = bundle.getString(WriteActivityConfig.PHOTO_NAME);
        }
        if (this.writeImagesInfo != null) {
            this.writeImagesInfo.setMaxImagesAllowed(10);
        }
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && CU() != null) {
            CU().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.aDe.WV() && CU() != null) {
            CU().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.writeImagesInfo != null) {
            bundle.putString(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aDd);
    }

    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.aDf.getWriteData() == null) {
            this.aDf.setWriteData(this.aDh.fQ(str));
        }
        if (this.aDf.getWriteData() != null) {
            if (this.aDs) {
                this.aDf.getWriteData().setCanNoForum(true);
                if (this.aDi != null) {
                    this.aDf.getWriteData().setVForumId(this.aDi.getId());
                    this.aDf.getWriteData().setVForumName(this.aDi.getName());
                }
            } else {
                this.aDf.getWriteData().setCanNoForum(false);
                this.aDf.getWriteData().setVForumId("");
                this.aDf.getWriteData().setVForumName("");
            }
            this.aDf.getWriteData().setWriteImagesInfo(this.writeImagesInfo);
            this.aDf.getWriteData().setVideoInfo(this.mVideoInfo);
            this.aDf.mJ(this.writeImagesInfo.size() > 0);
            WriteData writeData2 = this.aDf.getWriteData();
            if (this.aDe == null || !this.aDe.WV()) {
                z = false;
            }
            writeData2.setHasLocationData(z);
            if (str == null) {
                this.aDf.getWriteData().setContent(this.aDb);
            }
            if (this.aDc != null) {
                if (this.aDc.getId() != null) {
                    this.aDf.getWriteData().setVoice(this.aDc.getId());
                    this.aDf.getWriteData().setVoiceDuringTime(this.aDc.duration);
                } else {
                    this.aDf.getWriteData().setVoice(null);
                    this.aDf.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.aDf.getWriteData().setVoice(null);
                this.aDf.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.aDf.bvL()) {
                this.mContext.showToast(d.j.write_img_limit);
            } else if (this.aDo == null || !this.aDo.Dq()) {
                if (this.aDn != null) {
                    this.aDn.Dr();
                }
                if (!this.aDf.startPostWrite()) {
                }
            }
        }
    }

    public BaseActivity<?> getContext() {
        return this.mContext;
    }

    public void fV(String str) {
        this.aDb = str;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.aDc = voiceModel;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public int DD() {
        return this.aDl;
    }

    private void DE() {
        if (CU() != null) {
            CU().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    private void q(ArrayList<String> arrayList) {
        if (CU() != null) {
            CU().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    public void fW(String str) {
        if (CU() != null) {
            CU().b(new com.baidu.tbadk.editortools.a(44, 3, str));
        }
    }

    private void DF() {
        if (CU() != null) {
            CU().b(new com.baidu.tbadk.editortools.a(2, 19, " "));
        }
    }

    protected void bF(boolean z) {
        if (CU() != null) {
            if (z) {
                CU().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            CU().b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                CU().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
            } else {
                CU().b(new com.baidu.tbadk.editortools.a(2, 10, null));
            }
        }
    }

    protected void DG() {
        bF(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void DH() {
        if (CU() != null) {
            CU().b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.aDl = i;
        if (CU() != null) {
            CU().b(new com.baidu.tbadk.editortools.a(19, 8, new com.baidu.tbadk.editortools.d.a(i, z, str)));
            if (i == 2) {
                CU().b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            } else {
                CU().b(new com.baidu.tbadk.editortools.a(2, 7, null));
            }
        }
    }

    private void fX(String str) {
        if (CU() != null) {
            CU().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bG(boolean z) {
        if (CU() != null) {
            CU().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void a(NewWriteModel.d dVar) {
        this.aDm = dVar;
    }

    public void a(c cVar) {
        this.aDn = cVar;
    }

    public void a(b bVar) {
        this.aDo = bVar;
    }

    public void DI() {
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            this.writeImagesInfo.clear();
        }
        DG();
        if (this.mVideoInfo != null && this.mVideoInfo.isAvaliable()) {
            this.mVideoInfo = null;
        }
        CU().b(new com.baidu.tbadk.editortools.a(2, 19, null));
        setVoiceModel(null);
        CU().b(new com.baidu.tbadk.editortools.a(2, 6, null));
        CU().b(new com.baidu.tbadk.editortools.a(33, 6, null));
        if (!StringUtils.isNull(this.aDb)) {
            this.aDb = "";
        }
        fX("");
        this.aDf.setWriteData(null);
        this.aDf.mJ(false);
    }

    public void eY(final int i) {
        DJ();
        if (this.aDq != null && (this.aDq.aBn instanceof EditText)) {
            final EditText editText = (EditText) this.aDq.aBn;
            if (this.aDt == null) {
                this.aDt = new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.d.8
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
                            if (!StringUtils.isNull(obj) && w.gW(obj) > i) {
                                String e = w.e(obj, 0, i - 1);
                                editText.setText(e);
                                editText.setSelection(editText.getText().length());
                                UtilHelper.showToast(d.this.getContext().getApplication(), d.this.getContext().getResources().getString(d.j.edit_text_over_limit_tip, Integer.valueOf(e.length())));
                            }
                        }
                    }
                };
            }
            this.aDq.a(this.aDt);
        }
    }

    private void DJ() {
        if (this.aDq == null && CU() != null) {
            this.aDq = (com.baidu.tbadk.editortools.inputtool.a) CU().eO(3);
        }
    }

    public void DK() {
        if (this.aDq != null && this.aDt != null) {
            this.aDq.b(this.aDt);
        }
    }

    public void c(TextWatcher textWatcher) {
        DJ();
        if (this.aDq != null && textWatcher != null) {
            this.aDq.a(textWatcher);
        }
    }
}
