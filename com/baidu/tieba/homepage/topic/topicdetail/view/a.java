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
import com.baidu.tbadk.coreExtra.data.ag;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.ImageModel;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.x;
import java.util.ArrayList;
/* loaded from: classes16.dex */
public class a extends com.baidu.tbadk.editortools.e {
    private NewWriteModel.d eMD;
    private final com.baidu.adp.base.d eME;
    private String eMn;
    private NewWriteModel eMp;
    private ImageModel eMq;
    private String eMt;
    private com.baidu.tbadk.editortools.pb.c eMw;
    private com.baidu.tbadk.editortools.pb.b eMx;
    private boolean eNb;
    private NewWriteModel.d eNc;
    private View.OnClickListener eNf;
    private TbPageContext<?> efn;
    private String iTF;
    private c iTG;
    private AntiHelper.a mInjectListener;
    private String mPostContent;
    private long mTopicId;
    private WriteImagesInfo writeImagesInfo;

    /* JADX INFO: Access modifiers changed from: private */
    public void jp(boolean z) {
        if (brv() != null) {
            brv().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void Cd(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(bmF().getPageActivity());
        aVar.zz(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(bmF()).bhg();
    }

    public void aq(int i, String str) {
        if (AntiHelper.bz(i, str)) {
            if (AntiHelper.a(this.efn.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ai("obj_locate", ax.a.LOCATE_REPLY_SUB_PB));
            }
        } else if (i == 230277 || i == 230278) {
            Cd(str);
        } else {
            bmF().showToast(str);
        }
    }

    public TbPageContext<?> bmF() {
        return this.efn;
    }

    public a(EditorTools editorTools) {
        super(editorTools);
        this.mPostContent = "";
        this.iTF = null;
        this.eNb = false;
        this.eMt = null;
        this.writeImagesInfo = new WriteImagesInfo();
        this.eMq = null;
        this.eMD = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ag agVar, WriteData writeData, AntiData antiData) {
                if (a.this.eNc != null) {
                    a.this.eNc.callback(z, postWriteCallBackData, agVar, writeData, antiData);
                }
                if (z) {
                    a.this.mPostContent = null;
                    a.this.jp(true);
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    a.this.eMp.d((WriteData) null);
                    a.this.eMp.wg(false);
                    a.this.writeImagesInfo.clear();
                    a.this.bsw();
                    a.this.brv().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.bz(i, str)) {
                    a.this.aq(i, str);
                } else if (agVar != null && writeData != null && !StringUtils.isNull(agVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(agVar.getVcode_md5());
                    writeData.setVcodeUrl(agVar.getVcode_pic_url());
                    writeData.setVcodeExtra(agVar.bmZ());
                    if (com.baidu.tbadk.t.a.CO(agVar.bmY())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.bmF().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, agVar.bmY())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.bmF().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.efn.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    a.this.bmF().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ai("obj_locate", ax.a.LOCATE_REPLY_SUB_PB));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ai("obj_locate", ax.a.LOCATE_REPLY_SUB_PB));
            }
        };
        this.eME = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.4
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Bitmap) {
                    a.this.eMp.wg(true);
                }
            }
        };
        this.eNf = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(a.this.eMt)) {
                    l.showToast(a.this.bmF().getPageActivity(), a.this.eMt);
                }
            }
        };
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.efn = tbPageContext;
    }

    public void a(BaseActivity baseActivity, Bundle bundle) {
        if (baseActivity != null) {
            this.eMp = new NewWriteModel(baseActivity);
            this.eMp.b(this.eMD);
            this.eMq = new ImageModel(baseActivity.getPageContext());
            this.eMq.setLoadDataCallBack(this.eME);
            if (bundle != null) {
                this.writeImagesInfo.parseJson(bundle.getString(WriteActivityConfig.WRITE_IMAGES));
                this.eMn = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            }
            if (this.writeImagesInfo != null) {
                this.writeImagesInfo.setMaxImagesAllowed(9);
            }
            if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                brv().b(new com.baidu.tbadk.editortools.a(2, 10, this.writeImagesInfo.getChosedFiles().size() + ""));
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        ArrayList<String> stringArrayListExtra;
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("camera_result", false)) {
                            E(intent);
                        } else {
                            G(intent);
                        }
                        brv().invalidate();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_IMAGE_VIEW /* 12003 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("delete", false)) {
                            bsi();
                            this.eMp.wg(false);
                            return;
                        }
                        this.eMq.BV(intent.getStringExtra("file_name"));
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
                    if (this.eNc != null) {
                        this.mPostContent = null;
                        jp(true);
                        this.eMp.d((WriteData) null);
                        this.eMp.wg(false);
                        this.writeImagesInfo.clear();
                        bsw();
                        brv().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                        this.eNc.callback(true, postWriteCallBackData2, null, this.eMp.cKZ(), null);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    if (i == 12010) {
                        E(intent);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    F(intent);
                    return;
                case RequestResponseCode.REQUEST_WRITE_NEW /* 13003 */:
                    if (intent != null) {
                        try {
                            postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                        } catch (Exception e) {
                            BdLog.e(e);
                            postWriteCallBackData = null;
                        }
                        this.eMD.callback(true, postWriteCallBackData, null, null, null);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
                        aqVar.ai("obj_locate", 6);
                        if (shareItem != null) {
                            aqVar.dD("tid", shareItem.tid);
                        }
                        aqVar.dD("pid", intent.getStringExtra("pid"));
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
                    if (this.eNc != null) {
                        this.eNc.callback(false, postWriteCallBackData3, null, this.eMp.cKZ(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void E(Intent intent) {
        this.eMn = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.eMn;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(this.efn.getPageActivity(), l.getEquipmentWidth(this.efn.getPageActivity())), l.dip2px(this.efn.getPageActivity(), l.getEquipmentHeight(this.efn.getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    n.a("cameras", this.eMn, rotateBitmapBydegree, 100);
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
                cza();
            }
        }
    }

    private void F(Intent intent) {
        a(intent, false);
    }

    private void a(Intent intent, boolean z) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                cza();
            }
        }
    }

    private void cza() {
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.efn.getPageActivity(), 9, "0", null, null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0);
        writeActivityConfig.setTopicId(String.valueOf(this.mTopicId));
        writeActivityConfig.getIntent().putExtra("from", "topic_detail");
        writeActivityConfig.setCallFrom("1");
        if (!StringUtils.isNull(this.mPostContent)) {
            writeActivityConfig.setContent(this.mPostContent);
        }
        writeActivityConfig.setForumLevel(-1);
        writeActivityConfig.setForumAvatar(null);
        writeActivityConfig.setPrivateThread(0);
        writeActivityConfig.setForumDir("", "");
        writeActivityConfig.setWriteImagesInfo(this.writeImagesInfo);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
    }

    public void bsu() {
        if (this.eMp.cKZ() == null) {
            this.eMp.d(new WriteData());
        }
        if (this.eMp.cKZ() != null) {
            this.eMp.cKZ().setForumId("0");
            this.eMp.cKZ().setType(9);
            this.eMp.cKZ().setEntranceType(1);
            this.eMp.cKZ().setCanNoForum(true);
            this.eMp.cKZ().setTransmitForumData("[]");
            this.eMp.cKZ().setCallFrom("1");
            this.eMp.cKZ().setTopicId(String.valueOf(this.mTopicId));
            this.eMp.cKZ().setContent(this.mPostContent);
            this.eMp.cKZ().setIsNoTitle(true);
            this.eMp.cKZ().setTitle("");
            this.eMp.cKZ().setVoice(null);
            this.eMp.cKZ().setVoiceDuringTime(-1);
            if (!this.eMp.dxV()) {
                bmF().showToast(R.string.write_img_limit);
            } else if (this.eMx == null || !this.eMx.brU()) {
                if (this.eMw != null) {
                    this.eMw.brV();
                }
                if (!this.eMp.dxS()) {
                }
            }
        }
    }

    private void G(Intent intent) {
        a(intent, true);
    }

    public long czb() {
        return this.mTopicId;
    }

    private void bsi() {
        if (brv() != null) {
            brv().b(new com.baidu.tbadk.editortools.a(13, -1, null));
        }
    }

    public void onDestory() {
        this.eMp.cancelLoadData();
    }

    public void bsv() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.mPostContent);
        writeData.setTopicId(String.valueOf(this.mTopicId));
        writeData.setWriteImagesInfo(this.writeImagesInfo);
        x.b(String.valueOf(this.mTopicId), writeData);
    }

    public void cqb() {
        x.e(String.valueOf(this.mTopicId), new x.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.a.5
            @Override // com.baidu.tieba.tbadkCore.x.a
            public void a(WriteData writeData) {
                if (writeData != null) {
                    if (writeData.getWriteImagesInfo() != null && a.this.writeImagesInfo.size() == 0) {
                        a.this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                        if (a.this.writeImagesInfo != null && a.this.writeImagesInfo.getChosedFiles() != null && a.this.writeImagesInfo.getChosedFiles().size() > 0) {
                            a.this.brv().b(new com.baidu.tbadk.editortools.a(2, 10, a.this.writeImagesInfo.getChosedFiles().size() + ""));
                        }
                    }
                    if (a.this.writeImagesInfo == null || a.this.writeImagesInfo.size() == 0) {
                        a.this.brv().b(new com.baidu.tbadk.editortools.a(2, 10, null));
                    }
                    if (!at.isEmpty(writeData.getContent()) && at.isEmpty(a.this.mPostContent)) {
                        a.this.mPostContent = writeData.getContent();
                        a.this.Cb(a.this.mPostContent);
                    }
                }
            }
        });
    }

    public void bsw() {
        x.b(String.valueOf(this.mTopicId), (WriteData) null);
    }

    private void N(ArrayList<String> arrayList) {
        if (brv() != null) {
            brv().b(new com.baidu.tbadk.editortools.a(17, 29, arrayList));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cb(String str) {
        if (brv() != null) {
            brv().b(new com.baidu.tbadk.editortools.a(6, 29, str));
        }
    }

    public void BZ(String str) {
        this.mPostContent = str;
    }

    public void jr(boolean z) {
        this.eNb = z;
    }

    public void bsy() {
        jr(false);
        brv().hide();
    }

    public void bsB() {
        jr(true);
        brv().display();
    }

    public void b(NewWriteModel.d dVar) {
        this.eNc = dVar;
    }

    public void a(com.baidu.tbadk.editortools.pb.b bVar) {
        this.eMx = bVar;
    }

    public c czc() {
        if (this.iTG == null && brv() != null) {
            this.iTG = (c) brv().qe(29);
        }
        return this.iTG;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public void setTopicId(long j) {
        this.mTopicId = j;
    }
}
