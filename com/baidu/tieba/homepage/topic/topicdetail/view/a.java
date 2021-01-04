package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.ImageModel;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.y;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a extends com.baidu.tbadk.editortools.e {
    private TbPageContext<?> eXu;
    private String fFY;
    private boolean fGN;
    private NewWriteModel.d fGO;
    private View.OnClickListener fGR;
    private NewWriteModel fGa;
    private ImageModel fGb;
    private String fGe;
    private com.baidu.tbadk.editortools.pb.c fGh;
    private com.baidu.tbadk.editortools.pb.b fGi;
    private NewWriteModel.d fGo;
    private final com.baidu.adp.base.e fGp;
    private String klq;
    private c klr;
    private AntiHelper.a mInjectListener;
    private String mPostContent;
    private long mTopicId;
    private WriteImagesInfo writeImagesInfo;

    /* JADX INFO: Access modifiers changed from: private */
    public void la(boolean z) {
        if (bEI() != null) {
            bEI().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void DX(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(bzM().getPageActivity());
        aVar.Bp(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(bzM()).btX();
    }

    public void aI(int i, String str) {
        if (AntiHelper.bP(i, str)) {
            if (AntiHelper.a(this.eXu.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).an("obj_locate", ax.a.LOCATE_REPLY_SUB_PB));
            }
        } else if (i == 230277 || i == 230278) {
            DX(str);
        } else {
            bzM().showToast(str);
        }
    }

    public TbPageContext<?> bzM() {
        return this.eXu;
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.mPostContent = "";
        this.klq = null;
        this.fGN = false;
        this.fGe = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.fGb = null;
        this.fGo = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                if (a.this.fGO != null) {
                    a.this.fGO.callback(z, postWriteCallBackData, ahVar, writeData, antiData);
                }
                if (z) {
                    a.this.mPostContent = null;
                    a.this.la(true);
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    a.this.fGa.f((WriteData) null);
                    a.this.fGa.yp(false);
                    a.this.writeImagesInfo.clear();
                    a.this.bFO();
                    a.this.bEI().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.bP(i, str)) {
                    a.this.aI(i, str);
                } else if (ahVar != null && writeData != null && !StringUtils.isNull(ahVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(ahVar.getVcode_md5());
                    writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                    writeData.setVcodeExtra(ahVar.bAg());
                    if (com.baidu.tbadk.t.a.EQ(ahVar.bAf())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.bzM().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bAf())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.bzM().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.eXu.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    a.this.bzM().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).an("obj_locate", ax.a.LOCATE_REPLY_SUB_PB));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).an("obj_locate", ax.a.LOCATE_REPLY_SUB_PB));
            }
        };
        this.fGp = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.4
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                if (obj instanceof Bitmap) {
                    a.this.fGa.yp(true);
                }
            }
        };
        this.fGR = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(a.this.fGe)) {
                    l.showToast(a.this.bzM().getPageActivity(), a.this.fGe);
                }
            }
        };
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.eXu = tbPageContext;
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        if (baseActivity != null) {
            this.fGa = new NewWriteModel(baseActivity);
            this.fGa.b(this.fGo);
            this.fGb = new ImageModel(baseActivity.getPageContext());
            this.fGb.setLoadDataCallBack(this.fGp);
            if (bundle != null) {
                this.writeImagesInfo.parseJson(bundle.getString("write_images"));
                this.fFY = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            }
            if (this.writeImagesInfo != null) {
                this.writeImagesInfo.setMaxImagesAllowed(9);
            }
            if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                bEI().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        ArrayList<String> stringArrayListExtra;
        if (i2 == -1) {
            switch (i) {
                case 12002:
                    if (intent != null) {
                        if (intent.getBooleanExtra("camera_result", false)) {
                            F(intent);
                        } else {
                            H(intent);
                        }
                        bEI().invalidate();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_IMAGE_VIEW /* 12003 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("delete", false)) {
                            bFA();
                            this.fGa.yp(false);
                            return;
                        }
                        this.fGb.DP(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        N(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    PostWriteCallBackData postWriteCallBackData2 = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (this.fGO != null) {
                        this.mPostContent = null;
                        la(true);
                        this.fGa.f((WriteData) null);
                        this.fGa.yp(false);
                        this.writeImagesInfo.clear();
                        bFO();
                        bEI().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                        this.fGO.callback(true, postWriteCallBackData2, null, this.fGa.dco(), null);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    if (i == 12010) {
                        F(intent);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    G(intent);
                    return;
                case RequestResponseCode.REQUEST_WRITE_NEW /* 13003 */:
                    if (intent != null) {
                        try {
                            postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                        } catch (Exception e) {
                            BdLog.e(e);
                            postWriteCallBackData = null;
                        }
                        this.fGo.callback(true, postWriteCallBackData, null, null, null);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
                        aqVar.an("obj_locate", 6);
                        if (shareItem != null) {
                            aqVar.dX("tid", shareItem.tid);
                        }
                        aqVar.dX("pid", intent.getStringExtra("pid"));
                        TiebaStatic.log(aqVar);
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    PostWriteCallBackData postWriteCallBackData3 = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (this.fGO != null) {
                        this.fGO.callback(false, postWriteCallBackData3, null, this.fGa.dco(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void F(Intent intent) {
        this.fFY = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.fFY;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.eXu.getPageActivity(), l.getEquipmentWidth(this.eXu.getPageActivity())), l.dip2px(this.eXu.getPageActivity(), l.getEquipmentHeight(this.eXu.getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    n.a("cameras", this.fFY, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                cUb();
            }
        }
    }

    private void G(Intent intent) {
        b(intent, false);
    }

    private void b(Intent intent, boolean z) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                cUb();
            }
        }
    }

    private void cUb() {
        if (!WriteActivityConfig.isAsyncWriting() || this.mTopicId <= 0) {
            WriteActivityConfig.newInstance(this.eXu.getPageActivity()).setType(9).setForumId("0").setTopicId(String.valueOf(this.mTopicId)).setFrom("topic_detail").setCallFrom("1").setContent(this.mPostContent).setWriteImagesInfo(this.writeImagesInfo).send();
        }
    }

    public void bFM() {
        if (this.fGa.dco() == null) {
            this.fGa.f(new WriteData());
        }
        if (this.fGa.dco() != null) {
            this.fGa.dco().setForumId("0");
            this.fGa.dco().setType(9);
            this.fGa.dco().setEntranceType(1);
            this.fGa.dco().setCanNoForum(true);
            this.fGa.dco().setTransmitForumData("[]");
            this.fGa.dco().setCallFrom("1");
            this.fGa.dco().setTopicId(String.valueOf(this.mTopicId));
            this.fGa.dco().setContent(this.mPostContent);
            this.fGa.dco().setIsNoTitle(true);
            this.fGa.dco().setTitle("");
            this.fGa.dco().setVoice(null);
            this.fGa.dco().setVoiceDuringTime(-1);
            if (!this.fGa.dQD()) {
                bzM().showToast(R.string.write_img_limit);
            } else if (this.fGi == null || !this.fGi.bFm()) {
                if (this.fGh != null) {
                    this.fGh.bFn();
                }
                if (!this.fGa.dQB()) {
                }
            }
        }
    }

    private void H(Intent intent) {
        b(intent, true);
    }

    public long cUc() {
        return this.mTopicId;
    }

    private void bFA() {
        if (bEI() != null) {
            bEI().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    public void onDestory() {
        this.fGa.cancelLoadData();
    }

    public void bFN() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.mPostContent);
        writeData.setTopicId(String.valueOf(this.mTopicId));
        writeData.setWriteImagesInfo(this.writeImagesInfo);
        y.e(String.valueOf(this.mTopicId), writeData);
    }

    public void cJr() {
        y.d(String.valueOf(this.mTopicId), new y.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.5
            @Override // com.baidu.tieba.tbadkCore.y.a
            public void b(WriteData writeData) {
                if (writeData != null) {
                    if (writeData.getWriteImagesInfo() != null && a.this.writeImagesInfo.size() == 0) {
                        a.this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                        if (a.this.writeImagesInfo != null && a.this.writeImagesInfo.getChosedFiles() != null && a.this.writeImagesInfo.getChosedFiles().size() > 0) {
                            a.this.bEI().b(new com.baidu.tbadk.editortools.a(2, 10, a.this.writeImagesInfo.getChosedFiles().size() + ""));
                        }
                    }
                    if (a.this.writeImagesInfo == null || a.this.writeImagesInfo.size() == 0) {
                        a.this.bEI().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                    }
                    if (!at.isEmpty(writeData.getContent()) && at.isEmpty(a.this.mPostContent)) {
                        a.this.mPostContent = writeData.getContent();
                        a.this.DV(a.this.mPostContent);
                    }
                }
            }
        });
    }

    public void bFO() {
        y.e(String.valueOf(this.mTopicId), (WriteData) null);
    }

    private void N(ArrayList<String> arrayList) {
        if (bEI() != null) {
            bEI().b(new com.baidu.tbadk.editortools.a(17, 29, arrayList));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DV(String str) {
        if (bEI() != null) {
            bEI().b(new com.baidu.tbadk.editortools.a(6, 29, str));
        }
    }

    public void DT(String str) {
        this.mPostContent = str;
    }

    public void lc(boolean z) {
        this.fGN = z;
    }

    public void bFQ() {
        lc(false);
        bEI().hide();
    }

    public void bFT() {
        lc(true);
        bEI().rV();
    }

    public void b(NewWriteModel.d dVar) {
        this.fGO = dVar;
    }

    public void a(com.baidu.tbadk.editortools.pb.b bVar) {
        this.fGi = bVar;
    }

    public c cUd() {
        if (this.klr == null && bEI() != null) {
            this.klr = (c) bEI().sv(29);
        }
        return this.klr;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public void setTopicId(long j) {
        this.mTopicId = j;
    }
}
