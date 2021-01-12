package com.baidu.tbadk.editortools.pb;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.y;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends com.baidu.tbadk.editortools.e {
    private bz ale;
    private TbPageContext<?> eSJ;
    private b fBA;
    private NewWriteModel.d fBH;
    private NewWriteModel fBs;
    private String fBw;
    private c fBz;
    private j fCd;
    private String fCe;
    private DataModel<?> fCf;
    private boolean fCg;
    private NewWriteModel.d fCh;
    private f fCi;
    private y.a fCj;
    private View.OnClickListener fCk;
    public boolean isBJH;
    public int mFrom;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private SpanGroupManager mSpanGroupManager;
    private VoiceData.VoiceModel mVoiceModel;

    public h(EditorTools editorTools) {
        super(editorTools);
        this.fCe = "";
        this.fCg = false;
        this.fBw = null;
        this.mFrom = 0;
        this.fBH = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.h.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                if (h.this.fCh != null) {
                    h.this.fCh.callback(z, postWriteCallBackData, ahVar, writeData, antiData);
                }
                if (z) {
                    h.this.fCd = null;
                    h.this.fCe = null;
                    h.this.kW(true);
                    h.this.bBW();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z && h.this.ale != null) {
                    aq aqVar = new aq("c13563");
                    aqVar.dW("tid", h.this.ale.getId());
                    aqVar.w("fid", h.this.ale.getFid());
                    aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                    aqVar.an("obj_type", 2);
                    com.baidu.tbadk.pageExtra.c fr = com.baidu.tbadk.pageExtra.d.fr(h.this.eSJ.getPageActivity());
                    if (fr != null) {
                        aqVar.dW("obj_cur_page", fr.getCurrentPageKey());
                    }
                    if (com.baidu.tbadk.pageExtra.d.bDu() != null) {
                        aqVar.dW("obj_pre_page", com.baidu.tbadk.pageExtra.d.bDu());
                    }
                    TiebaStatic.log(aqVar);
                }
                if (z) {
                    WriteData cYx = h.this.fBs.cYx();
                    h.this.fBs.f((WriteData) null);
                    h.this.fBs.yl(false);
                    h.this.mVoiceModel = null;
                    if (cYx != null && cYx != null && cYx.getType() == 2) {
                        h.this.fCf.bBq();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.bQ(i, str)) {
                    h.this.aJ(i, str);
                } else if (ahVar != null && writeData != null && !StringUtils.isNull(ahVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(ahVar.getVcode_md5());
                    writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                    writeData.setVcodeExtra(ahVar.bwn());
                    if (h.this.ale != null) {
                        writeData.setBaijiahaoData(h.this.ale.getBaijiahaoData());
                    }
                    if (com.baidu.tbadk.t.a.DE(ahVar.bwm())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(h.this.bvT().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bwm())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(h.this.bvT().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(h.this.eSJ.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    h.this.bvT().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.h.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).an("obj_locate", ax.a.LOCATE_REPLY_SUB_PB));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).an("obj_locate", ax.a.LOCATE_REPLY_SUB_PB));
            }
        };
        this.fCk = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(h.this.fBw)) {
                    l.showToast(h.this.bvT().getPageActivity(), h.this.fBw);
                }
            }
        };
    }

    public void c(WriteData writeData) {
        if (writeData != null) {
            if (this.fCd == null) {
                this.fCd = new j();
            }
            this.fCd.mContent = writeData.getContent();
            this.fCd.fCp = writeData.getSubPbReplyPrefix();
            c(this.fCd);
        }
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.eSJ = tbPageContext;
    }

    public TbPageContext<?> bvT() {
        return this.eSJ;
    }

    public void setThreadData(bz bzVar) {
        this.ale = bzVar;
    }

    public void CH(String str) {
        if (this.fCd == null) {
            this.fCd = new j();
        }
        this.fCd.mContent = str;
    }

    public void a(j jVar) {
        this.fCd = jVar;
    }

    public void reset() {
        this.fBs.f((WriteData) null);
        this.fBs.yl(false);
        this.mVoiceModel = null;
    }

    public void a(y.a aVar) {
        this.fCj = aVar;
    }

    public void setReplyId(String str) {
        this.fCe = str;
    }

    public void b(DataModel<?> dataModel) {
        this.fCf = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.bBr();
        }
    }

    public void j(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.fBs = new NewWriteModel(tbPageContext);
            this.fBs.b(this.fBH);
            y.e(this.fCf.bBr(), new y.a() { // from class: com.baidu.tbadk.editortools.pb.h.3
                @Override // com.baidu.tieba.tbadkCore.y.a
                public void b(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        if (h.this.fCd == null) {
                            h.this.fCd = new j();
                        }
                        h.this.fCd.mContent = writeData.getContent();
                        h.this.fCd.fCp = writeData.getSubPbReplyPrefix();
                        h.this.c(h.this.fCd);
                    }
                    if (h.this.fCj != null) {
                        h.this.fCj.b(writeData);
                    }
                }
            });
        }
    }

    public boolean bBL() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_SUB_PB_AT_SELECT /* 12005 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        I(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (bAP() != null) {
                        bAP().hide();
                    }
                    bBW();
                    kW(true);
                    WriteData cYx = this.fBs.cYx();
                    this.fBs.f((WriteData) null);
                    this.fBs.yl(false);
                    if (cYx != null && cYx != null && cYx.getType() == 2) {
                        this.fCf.bBq();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (this.fCh != null) {
                        this.fCh.callback(false, postWriteCallBackData, null, this.fBs.cYx(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void bBU() {
        if (this.fBs.cYx() == null) {
            WriteData CC = this.fCf.CC(this.fCf.bBr());
            if (CC != null && this.ale != null) {
                CC.setBaijiahaoData(this.ale.getBaijiahaoData());
            }
            this.fBs.f(CC);
        }
        if (this.fBs.cYx() != null) {
            this.fBs.setSpanGroupManager(this.mSpanGroupManager);
            if (this.fCd != null) {
                this.fBs.cYx().setContent(this.fCd.mContent);
                this.fBs.cYx().setSubPbReplyPrefix(this.fCd.fCp);
                if (this.ale != null) {
                    this.fBs.cYx().setBaijiahaoData(this.ale.getBaijiahaoData());
                }
            }
            this.fBs.cYx().setReplyId(this.fCe);
            if (this.mPostId != null) {
                this.fBs.cYx().setRepostId(this.fCf.bBr());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.fBs.cYx().setVoice(this.mVoiceModel.getId());
                    this.fBs.cYx().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.fBs.cYx().setVoice(null);
                    this.fBs.cYx().setVoiceDuringTime(-1);
                }
            } else {
                this.fBs.cYx().setVoice(null);
                this.fBs.cYx().setVoiceDuringTime(-1);
            }
            if (!this.fBs.dMM()) {
                bvT().showToast(R.string.write_img_limit);
            } else if (this.fBA == null || !this.fBA.bBt()) {
                if (this.fBz != null) {
                    this.fBz.bBu();
                }
                d(this.fBs.cYx());
                if (!this.fBs.dMK()) {
                }
            }
        }
    }

    public void onDestory() {
        bBV();
        this.fBs.cancelLoadData();
    }

    public void onStop() {
    }

    public void bBV() {
        WriteData writeData = new WriteData(2);
        if (this.fCd != null) {
            writeData.setContent(this.fCd.mContent);
            writeData.setSubPbReplyPrefix(this.fCd.fCp);
        }
        writeData.setReplyId(this.fCe);
        writeData.setThreadId(this.mPostId);
        y.f(this.mPostId, writeData);
    }

    public void bBW() {
        y.f(this.mPostId, (WriteData) null);
    }

    public void aJ(int i, String str) {
        if (AntiHelper.bQ(i, str)) {
            if (AntiHelper.a(this.eSJ.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).an("obj_locate", ax.a.LOCATE_REPLY_SUB_PB));
            }
        } else if (i == 230277 || i == 230278) {
            CL(str);
        } else {
            bvT().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        if (this.fCd != null) {
            pbEditorData.setContent(this.fCd.mContent);
            pbEditorData.setSubPbReplyPrefix(this.fCd.fCp);
        }
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.fBw);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.eSJ.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.h qM;
        if (antiData != null) {
            this.fBw = antiData.getVoice_message();
            if (!StringUtils.isNull(this.fBw) && bAP() != null && (qM = bAP().qM(6)) != null && !TextUtils.isEmpty(this.fBw)) {
                ((View) qM).setOnClickListener(this.fCk);
            }
        }
    }

    private void CL(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(bvT().getPageActivity());
        aVar.Ad(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.h.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(bvT()).bqe();
    }

    private void I(ArrayList<String> arrayList) {
        if (bAP() != null) {
            bAP().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean bBX() {
        return this.fCg;
    }

    public void kY(boolean z) {
        this.fCg = z;
    }

    public void CM(String str) {
        kY(true);
        bAP().rV();
        if (str != null && str.length() != 0) {
            String replace = bvT().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            j jVar = new j();
            jVar.fCp = replace;
            c(jVar);
        } else {
            j jVar2 = new j();
            jVar2.mContent = "";
            c(jVar2);
        }
        TiebaStatic.eventStat(bvT().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void b(j jVar) {
        kY(true);
        bAP().rV();
        c(jVar);
        TiebaStatic.eventStat(bvT().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void bBY() {
        kY(false);
        bAP().hide();
    }

    public void bBZ() {
        kY(true);
        bAP().rV();
        bAP().bP((View) bAP().qM(5));
    }

    public void bCa() {
        kY(true);
        bAP().rV();
        bAP().bP((View) bAP().qM(2));
    }

    public void bCb() {
        kY(true);
        bAP().rV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(j jVar) {
        if (bAP() != null) {
            bAP().b(new com.baidu.tbadk.editortools.a(6, 27, jVar));
        }
    }

    public void CN(String str) {
        if (str != null) {
            String replace = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            if (this.fCd != null) {
                if (TextUtils.isEmpty(this.fCd.fCp) && TextUtils.isEmpty(this.fCd.mContent)) {
                    CM(str);
                    return;
                } else if (!TextUtils.isEmpty(this.fCd.fCp) && this.fCd.fCp.equals(replace)) {
                    b(this.fCd);
                    return;
                } else {
                    CM(str);
                    return;
                }
            }
            CM(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kW(boolean z) {
        if (bAP() != null) {
            bAP().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.fCh = dVar;
    }

    public void a(c cVar) {
        this.fBz = cVar;
    }

    public void a(b bVar) {
        this.fBA = bVar;
    }

    public f bCc() {
        if (this.fCi == null && bAP() != null) {
            this.fCi = (f) bAP().qP(27);
        }
        return this.fCi;
    }

    public boolean bCd() {
        return (this.fCd == null || at.isEmpty(this.fCd.mContent)) ? false : true;
    }

    public void setSpanGroupManager(SpanGroupManager spanGroupManager) {
        this.mSpanGroupManager = spanGroupManager;
    }

    public void CO(String str) {
        if (!StringUtils.isNull(str) && bAP() != null) {
            bAP().b(new com.baidu.tbadk.editortools.a(45, 27, str));
        }
    }

    public void d(WriteData writeData) {
        int i = 0;
        if (writeData != null) {
            if (!TextUtils.isEmpty(writeData.getContent())) {
                int i2 = 0;
                while (aw.eZa.matcher(writeData.getContent()).find()) {
                    i2++;
                }
                if (i2 > 0 && this.mFrom > 0) {
                    aq aqVar = new aq("c13990");
                    aqVar.an("obj_type", i2);
                    aqVar.an("obj_source", this.mFrom);
                    aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar.dW("tid", writeData.getThreadId());
                    TiebaStatic.log(aqVar);
                }
            }
            if (writeData.getWriteImagesInfo() != null && !x.isEmpty(writeData.getWriteImagesInfo().getChosedFiles())) {
                for (ImageFileInfo imageFileInfo : writeData.getWriteImagesInfo().getChosedFiles()) {
                    if (imageFileInfo.getImageType() == 1) {
                        i++;
                    }
                }
                if (i > 0 && this.mFrom > 0) {
                    aq aqVar2 = new aq("c13991");
                    aqVar2.an("obj_type", i);
                    aqVar2.an("obj_source", this.mFrom);
                    aqVar2.dW("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar2.dW("tid", writeData.getThreadId());
                    TiebaStatic.log(aqVar2);
                }
            }
        }
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }
}
