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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.ay;
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
    private cb amn;
    private TbPageContext<?> eWx;
    private j fFP;
    private String fFQ;
    private DataModel<?> fFR;
    private boolean fFS;
    private NewWriteModel.d fFT;
    private f fFU;
    private y.a fFV;
    private View.OnClickListener fFW;
    private NewWriteModel fFg;
    private String fFk;
    private c fFn;
    private b fFo;
    private NewWriteModel.d fFv;
    public boolean isBJH;
    public int mFrom;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private SpanGroupManager mSpanGroupManager;
    private VoiceData.VoiceModel mVoiceModel;

    public h(EditorTools editorTools) {
        super(editorTools);
        this.fFQ = "";
        this.fFS = false;
        this.fFk = null;
        this.mFrom = 0;
        this.fFv = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.h.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                if (h.this.fFT != null) {
                    h.this.fFT.callback(z, postWriteCallBackData, ahVar, writeData, antiData);
                }
                if (z) {
                    h.this.fFP = null;
                    h.this.fFQ = null;
                    h.this.kZ(true);
                    h.this.bCr();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z && h.this.amn != null) {
                    ar arVar = new ar("c13563");
                    arVar.dR("tid", h.this.amn.getId());
                    arVar.v("fid", h.this.amn.getFid());
                    arVar.v("uid", TbadkApplication.getCurrentAccountId());
                    arVar.aq("obj_type", 2);
                    com.baidu.tbadk.pageExtra.c fp = com.baidu.tbadk.pageExtra.d.fp(h.this.eWx.getPageActivity());
                    if (fp != null) {
                        arVar.dR("obj_cur_page", fp.getCurrentPageKey());
                    }
                    if (com.baidu.tbadk.pageExtra.d.bDP() != null) {
                        arVar.dR("obj_pre_page", com.baidu.tbadk.pageExtra.d.bDP());
                    }
                    TiebaStatic.log(arVar);
                }
                if (z) {
                    WriteData daL = h.this.fFg.daL();
                    h.this.fFg.f((WriteData) null);
                    h.this.fFg.yD(false);
                    h.this.mVoiceModel = null;
                    if (daL != null && daL != null && daL.getType() == 2) {
                        h.this.fFR.bBL();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.bX(i, str)) {
                    h.this.aN(i, str);
                } else if (ahVar != null && writeData != null && !StringUtils.isNull(ahVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(ahVar.getVcode_md5());
                    writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                    writeData.setVcodeExtra(ahVar.bwI());
                    if (h.this.amn != null) {
                        writeData.setBaijiahaoData(h.this.amn.getBaijiahaoData());
                    }
                    if (com.baidu.tbadk.t.a.Ef(ahVar.bwH())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(h.this.bwp().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bwH())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(h.this.bwp().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(h.this.eWx.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    h.this.bwp().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.h.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).aq("obj_locate", ay.a.LOCATE_REPLY_SUB_PB));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).aq("obj_locate", ay.a.LOCATE_REPLY_SUB_PB));
            }
        };
        this.fFW = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(h.this.fFk)) {
                    l.showToast(h.this.bwp().getPageActivity(), h.this.fFk);
                }
            }
        };
    }

    public void c(WriteData writeData) {
        if (writeData != null) {
            if (this.fFP == null) {
                this.fFP = new j();
            }
            this.fFP.mContent = writeData.getContent();
            this.fFP.fGb = writeData.getSubPbReplyPrefix();
            c(this.fFP);
        }
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.eWx = tbPageContext;
    }

    public TbPageContext<?> bwp() {
        return this.eWx;
    }

    public void setThreadData(cb cbVar) {
        this.amn = cbVar;
    }

    public void Dd(String str) {
        if (this.fFP == null) {
            this.fFP = new j();
        }
        this.fFP.mContent = str;
    }

    public void a(j jVar) {
        this.fFP = jVar;
    }

    public void reset() {
        this.fFg.f((WriteData) null);
        this.fFg.yD(false);
        this.mVoiceModel = null;
    }

    public void a(y.a aVar) {
        this.fFV = aVar;
    }

    public void setReplyId(String str) {
        this.fFQ = str;
    }

    public void b(DataModel<?> dataModel) {
        this.fFR = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.bBM();
        }
    }

    public void j(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.fFg = new NewWriteModel(tbPageContext);
            this.fFg.b(this.fFv);
            y.e(this.fFR.bBM(), new y.a() { // from class: com.baidu.tbadk.editortools.pb.h.3
                @Override // com.baidu.tieba.tbadkCore.y.a
                public void b(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        if (h.this.fFP == null) {
                            h.this.fFP = new j();
                        }
                        h.this.fFP.mContent = writeData.getContent();
                        h.this.fFP.fGb = writeData.getSubPbReplyPrefix();
                        h.this.c(h.this.fFP);
                    }
                    if (h.this.fFV != null) {
                        h.this.fFV.b(writeData);
                    }
                }
            });
        }
    }

    public boolean bCg() {
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
                    if (bBk() != null) {
                        bBk().hide();
                    }
                    bCr();
                    kZ(true);
                    WriteData daL = this.fFg.daL();
                    this.fFg.f((WriteData) null);
                    this.fFg.yD(false);
                    if (daL != null && daL != null && daL.getType() == 2) {
                        this.fFR.bBL();
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
                    if (this.fFT != null) {
                        this.fFT.callback(false, postWriteCallBackData, null, this.fFg.daL(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void bCp() {
        if (this.fFg.daL() == null) {
            WriteData CY = this.fFR.CY(this.fFR.bBM());
            if (CY != null && this.amn != null) {
                CY.setBaijiahaoData(this.amn.getBaijiahaoData());
            }
            this.fFg.f(CY);
        }
        if (this.fFg.daL() != null) {
            this.fFg.setSpanGroupManager(this.mSpanGroupManager);
            if (this.fFP != null) {
                this.fFg.daL().setContent(this.fFP.mContent);
                this.fFg.daL().setSubPbReplyPrefix(this.fFP.fGb);
                if (this.amn != null) {
                    this.fFg.daL().setBaijiahaoData(this.amn.getBaijiahaoData());
                }
            }
            this.fFg.daL().setReplyId(this.fFQ);
            if (this.mPostId != null) {
                this.fFg.daL().setRepostId(this.fFR.bBM());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.fFg.daL().setVoice(this.mVoiceModel.getId());
                    this.fFg.daL().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.fFg.daL().setVoice(null);
                    this.fFg.daL().setVoiceDuringTime(-1);
                }
            } else {
                this.fFg.daL().setVoice(null);
                this.fFg.daL().setVoiceDuringTime(-1);
            }
            if (!this.fFg.dPo()) {
                bwp().showToast(R.string.write_img_limit);
            } else if (this.fFo == null || !this.fFo.bBO()) {
                if (this.fFn != null) {
                    this.fFn.bBP();
                }
                d(this.fFg.daL());
                if (!this.fFg.dPm()) {
                }
            }
        }
    }

    public void onDestory() {
        bCq();
        this.fFg.cancelLoadData();
    }

    public void onStop() {
    }

    public void bCq() {
        WriteData writeData = new WriteData(2);
        if (this.fFP != null) {
            writeData.setContent(this.fFP.mContent);
            writeData.setSubPbReplyPrefix(this.fFP.fGb);
        }
        writeData.setReplyId(this.fFQ);
        writeData.setThreadId(this.mPostId);
        y.f(this.mPostId, writeData);
    }

    public void bCr() {
        y.f(this.mPostId, (WriteData) null);
    }

    public void aN(int i, String str) {
        if (AntiHelper.bX(i, str)) {
            if (AntiHelper.a(this.eWx.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).aq("obj_locate", ay.a.LOCATE_REPLY_SUB_PB));
            }
        } else if (i == 230277 || i == 230278) {
            Dh(str);
        } else {
            bwp().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        if (this.fFP != null) {
            pbEditorData.setContent(this.fFP.mContent);
            pbEditorData.setSubPbReplyPrefix(this.fFP.fGb);
        }
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.fFk);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.eWx.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.h qS;
        if (antiData != null) {
            this.fFk = antiData.getVoice_message();
            if (!StringUtils.isNull(this.fFk) && bBk() != null && (qS = bBk().qS(6)) != null && !TextUtils.isEmpty(this.fFk)) {
                ((View) qS).setOnClickListener(this.fFW);
            }
        }
    }

    private void Dh(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(bwp().getPageActivity());
        aVar.AB(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.h.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(bwp()).bqz();
    }

    private void I(ArrayList<String> arrayList) {
        if (bBk() != null) {
            bBk().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean bCs() {
        return this.fFS;
    }

    public void lb(boolean z) {
        this.fFS = z;
    }

    public void Di(String str) {
        lb(true);
        bBk().display();
        if (str != null && str.length() != 0) {
            String replace = bwp().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            j jVar = new j();
            jVar.fGb = replace;
            c(jVar);
        } else {
            j jVar2 = new j();
            jVar2.mContent = "";
            c(jVar2);
        }
        TiebaStatic.eventStat(bwp().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void b(j jVar) {
        lb(true);
        bBk().display();
        c(jVar);
        TiebaStatic.eventStat(bwp().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void bCt() {
        lb(false);
        bBk().hide();
    }

    public void bCu() {
        lb(true);
        bBk().display();
        bBk().bL((View) bBk().qS(5));
    }

    public void bCv() {
        lb(true);
        bBk().display();
        bBk().bL((View) bBk().qS(2));
    }

    public void bCw() {
        lb(true);
        bBk().display();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(j jVar) {
        if (bBk() != null) {
            bBk().b(new com.baidu.tbadk.editortools.a(6, 27, jVar));
        }
    }

    public void Dj(String str) {
        if (str != null) {
            String replace = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            if (this.fFP != null) {
                if (TextUtils.isEmpty(this.fFP.fGb) && TextUtils.isEmpty(this.fFP.mContent)) {
                    Di(str);
                    return;
                } else if (!TextUtils.isEmpty(this.fFP.fGb) && this.fFP.fGb.equals(replace)) {
                    b(this.fFP);
                    return;
                } else {
                    Di(str);
                    return;
                }
            }
            Di(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kZ(boolean z) {
        if (bBk() != null) {
            bBk().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.fFT = dVar;
    }

    public void a(c cVar) {
        this.fFn = cVar;
    }

    public void a(b bVar) {
        this.fFo = bVar;
    }

    public f bCx() {
        if (this.fFU == null && bBk() != null) {
            this.fFU = (f) bBk().qV(27);
        }
        return this.fFU;
    }

    public boolean bCy() {
        return (this.fFP == null || au.isEmpty(this.fFP.mContent)) ? false : true;
    }

    public void setSpanGroupManager(SpanGroupManager spanGroupManager) {
        this.mSpanGroupManager = spanGroupManager;
    }

    public void Dk(String str) {
        if (!StringUtils.isNull(str) && bBk() != null) {
            bBk().b(new com.baidu.tbadk.editortools.a(45, 27, str));
        }
    }

    public void d(WriteData writeData) {
        int i = 0;
        if (writeData != null) {
            if (!TextUtils.isEmpty(writeData.getContent())) {
                int i2 = 0;
                while (ax.fcP.matcher(writeData.getContent()).find()) {
                    i2++;
                }
                if (i2 > 0 && this.mFrom > 0) {
                    ar arVar = new ar("c13990");
                    arVar.aq("obj_type", i2);
                    arVar.aq("obj_source", this.mFrom);
                    arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    arVar.dR("tid", writeData.getThreadId());
                    TiebaStatic.log(arVar);
                }
            }
            if (writeData.getWriteImagesInfo() != null && !com.baidu.tbadk.core.util.y.isEmpty(writeData.getWriteImagesInfo().getChosedFiles())) {
                for (ImageFileInfo imageFileInfo : writeData.getWriteImagesInfo().getChosedFiles()) {
                    if (imageFileInfo.getImageType() == 1) {
                        i++;
                    }
                }
                if (i > 0 && this.mFrom > 0) {
                    ar arVar2 = new ar("c13991");
                    arVar2.aq("obj_type", i);
                    arVar2.aq("obj_source", this.mFrom);
                    arVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    arVar2.dR("tid", writeData.getThreadId());
                    TiebaStatic.log(arVar2);
                }
            }
        }
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }
}
