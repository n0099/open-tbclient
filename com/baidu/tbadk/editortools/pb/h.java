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
import com.baidu.tbadk.core.data.by;
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
    private by alu;
    private TbPageContext<?> eNx;
    private c fwB;
    private b fwC;
    private NewWriteModel.d fwI;
    private NewWriteModel fwu;
    private String fwy;
    private j fxe;
    private String fxf;
    private DataModel<?> fxg;
    private boolean fxh;
    private NewWriteModel.d fxi;
    private f fxj;
    private y.a fxk;
    private View.OnClickListener fxl;
    public boolean isBJH;
    public int mFrom;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private SpanGroupManager mSpanGroupManager;
    private VoiceData.VoiceModel mVoiceModel;

    public h(EditorTools editorTools) {
        super(editorTools);
        this.fxf = "";
        this.fxh = false;
        this.fwy = null;
        this.mFrom = 0;
        this.fwI = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.h.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                if (h.this.fxi != null) {
                    h.this.fxi.callback(z, postWriteCallBackData, ahVar, writeData, antiData);
                }
                if (z) {
                    h.this.fxe = null;
                    h.this.fxf = null;
                    h.this.kE(true);
                    h.this.bDt();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z && h.this.alu != null) {
                    ar arVar = new ar("c13563");
                    arVar.dY("tid", h.this.alu.getId());
                    arVar.w("fid", h.this.alu.getFid());
                    arVar.w("uid", TbadkApplication.getCurrentAccountId());
                    arVar.al("obj_type", 2);
                    com.baidu.tbadk.pageExtra.c eX = com.baidu.tbadk.pageExtra.d.eX(h.this.eNx.getPageActivity());
                    if (eX != null) {
                        arVar.dY("obj_cur_page", eX.getCurrentPageKey());
                    }
                    if (com.baidu.tbadk.pageExtra.d.bET() != null) {
                        arVar.dY("obj_pre_page", com.baidu.tbadk.pageExtra.d.bET());
                    }
                    TiebaStatic.log(arVar);
                }
                if (z) {
                    WriteData dcE = h.this.fwu.dcE();
                    h.this.fwu.e((WriteData) null);
                    h.this.fwu.yk(false);
                    h.this.mVoiceModel = null;
                    if (dcE != null && dcE != null && dcE.getType() == 2) {
                        h.this.fxg.bCO();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.bP(i, str)) {
                    h.this.aG(i, str);
                } else if (ahVar != null && writeData != null && !StringUtils.isNull(ahVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(ahVar.getVcode_md5());
                    writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                    writeData.setVcodeExtra(ahVar.bxM());
                    if (h.this.alu != null) {
                        writeData.setBaijiahaoData(h.this.alu.getBaijiahaoData());
                    }
                    if (com.baidu.tbadk.t.a.ES(ahVar.bxL())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(h.this.bxs().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bxL())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(h.this.bxs().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(h.this.eNx.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    h.this.bxs().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.h.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).al("obj_locate", ay.a.LOCATE_REPLY_SUB_PB));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).al("obj_locate", ay.a.LOCATE_REPLY_SUB_PB));
            }
        };
        this.fxl = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(h.this.fwy)) {
                    l.showToast(h.this.bxs().getPageActivity(), h.this.fwy);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            if (this.fxe == null) {
                this.fxe = new j();
            }
            this.fxe.mContent = writeData.getContent();
            this.fxe.fxq = writeData.getSubPbReplyPrefix();
            c(this.fxe);
        }
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.eNx = tbPageContext;
    }

    public TbPageContext<?> bxs() {
        return this.eNx;
    }

    public void setThreadData(by byVar) {
        this.alu = byVar;
    }

    public void DW(String str) {
        if (this.fxe == null) {
            this.fxe = new j();
        }
        this.fxe.mContent = str;
    }

    public void a(j jVar) {
        this.fxe = jVar;
    }

    public void reset() {
        this.fwu.e((WriteData) null);
        this.fwu.yk(false);
        this.mVoiceModel = null;
    }

    public void a(y.a aVar) {
        this.fxk = aVar;
    }

    public void setReplyId(String str) {
        this.fxf = str;
    }

    public void b(DataModel<?> dataModel) {
        this.fxg = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.bCP();
        }
    }

    public void j(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.fwu = new NewWriteModel(tbPageContext);
            this.fwu.b(this.fwI);
            y.b(this.fxg.bCP(), new y.a() { // from class: com.baidu.tbadk.editortools.pb.h.3
                @Override // com.baidu.tieba.tbadkCore.y.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        if (h.this.fxe == null) {
                            h.this.fxe = new j();
                        }
                        h.this.fxe.mContent = writeData.getContent();
                        h.this.fxe.fxq = writeData.getSubPbReplyPrefix();
                        h.this.c(h.this.fxe);
                    }
                    if (h.this.fxk != null) {
                        h.this.fxk.a(writeData);
                    }
                }
            });
        }
    }

    public boolean bDj() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_SUB_PB_AT_SELECT /* 12005 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        N(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (bCn() != null) {
                        bCn().hide();
                    }
                    bDt();
                    kE(true);
                    WriteData dcE = this.fwu.dcE();
                    this.fwu.e((WriteData) null);
                    this.fwu.yk(false);
                    if (dcE != null && dcE != null && dcE.getType() == 2) {
                        this.fxg.bCO();
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
                    if (this.fxi != null) {
                        this.fxi.callback(false, postWriteCallBackData, null, this.fwu.dcE(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void bDr() {
        if (this.fwu.dcE() == null) {
            WriteData DR = this.fxg.DR(this.fxg.bCP());
            if (DR != null && this.alu != null) {
                DR.setBaijiahaoData(this.alu.getBaijiahaoData());
            }
            this.fwu.e(DR);
        }
        if (this.fwu.dcE() != null) {
            this.fwu.setSpanGroupManager(this.mSpanGroupManager);
            if (this.fxe != null) {
                this.fwu.dcE().setContent(this.fxe.mContent);
                this.fwu.dcE().setSubPbReplyPrefix(this.fxe.fxq);
                if (this.alu != null) {
                    this.fwu.dcE().setBaijiahaoData(this.alu.getBaijiahaoData());
                }
            }
            this.fwu.dcE().setReplyId(this.fxf);
            if (this.mPostId != null) {
                this.fwu.dcE().setRepostId(this.fxg.bCP());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.fwu.dcE().setVoice(this.mVoiceModel.getId());
                    this.fwu.dcE().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.fwu.dcE().setVoice(null);
                    this.fwu.dcE().setVoiceDuringTime(-1);
                }
            } else {
                this.fwu.dcE().setVoice(null);
                this.fwu.dcE().setVoiceDuringTime(-1);
            }
            if (!this.fwu.dQH()) {
                bxs().showToast(R.string.write_img_limit);
            } else if (this.fwC == null || !this.fwC.bCR()) {
                if (this.fwB != null) {
                    this.fwB.bCS();
                }
                c(this.fwu.dcE());
                if (!this.fwu.dQE()) {
                }
            }
        }
    }

    public void onDestory() {
        bDs();
        this.fwu.cancelLoadData();
    }

    public void onStop() {
    }

    public void bDs() {
        WriteData writeData = new WriteData(2);
        if (this.fxe != null) {
            writeData.setContent(this.fxe.mContent);
            writeData.setSubPbReplyPrefix(this.fxe.fxq);
        }
        writeData.setReplyId(this.fxf);
        writeData.setThreadId(this.mPostId);
        y.g(this.mPostId, writeData);
    }

    public void bDt() {
        y.g(this.mPostId, null);
    }

    public void aG(int i, String str) {
        if (AntiHelper.bP(i, str)) {
            if (AntiHelper.a(this.eNx.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).al("obj_locate", ay.a.LOCATE_REPLY_SUB_PB));
            }
        } else if (i == 230277 || i == 230278) {
            Ea(str);
        } else {
            bxs().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        if (this.fxe != null) {
            pbEditorData.setContent(this.fxe.mContent);
            pbEditorData.setSubPbReplyPrefix(this.fxe.fxq);
        }
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.fwy);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.eNx.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.h sg;
        if (antiData != null) {
            this.fwy = antiData.getVoice_message();
            if (!StringUtils.isNull(this.fwy) && bCn() != null && (sg = bCn().sg(6)) != null && !TextUtils.isEmpty(this.fwy)) {
                ((View) sg).setOnClickListener(this.fxl);
            }
        }
    }

    private void Ea(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(bxs().getPageActivity());
        aVar.Bq(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.h.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(bxs()).brv();
    }

    private void N(ArrayList<String> arrayList) {
        if (bCn() != null) {
            bCn().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean bDu() {
        return this.fxh;
    }

    public void kG(boolean z) {
        this.fxh = z;
    }

    public void Eb(String str) {
        kG(true);
        bCn().su();
        if (str != null && str.length() != 0) {
            String replace = bxs().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            j jVar = new j();
            jVar.fxq = replace;
            c(jVar);
        } else {
            j jVar2 = new j();
            jVar2.mContent = "";
            c(jVar2);
        }
        TiebaStatic.eventStat(bxs().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void b(j jVar) {
        kG(true);
        bCn().su();
        c(jVar);
        TiebaStatic.eventStat(bxs().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void bDv() {
        kG(false);
        bCn().hide();
    }

    public void bDw() {
        kG(true);
        bCn().su();
        bCn().bG((View) bCn().sg(5));
    }

    public void bDx() {
        kG(true);
        bCn().su();
        bCn().bG((View) bCn().sg(2));
    }

    public void bDy() {
        kG(true);
        bCn().su();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(j jVar) {
        if (bCn() != null) {
            bCn().b(new com.baidu.tbadk.editortools.a(6, 27, jVar));
        }
    }

    public void Ec(String str) {
        if (str != null) {
            String replace = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            if (this.fxe != null) {
                if (TextUtils.isEmpty(this.fxe.fxq) && TextUtils.isEmpty(this.fxe.mContent)) {
                    Eb(str);
                    return;
                } else if (!TextUtils.isEmpty(this.fxe.fxq) && this.fxe.fxq.equals(replace)) {
                    b(this.fxe);
                    return;
                } else {
                    Eb(str);
                    return;
                }
            }
            Eb(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kE(boolean z) {
        if (bCn() != null) {
            bCn().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.fxi = dVar;
    }

    public void a(c cVar) {
        this.fwB = cVar;
    }

    public void a(b bVar) {
        this.fwC = bVar;
    }

    public f bDz() {
        if (this.fxj == null && bCn() != null) {
            this.fxj = (f) bCn().sj(27);
        }
        return this.fxj;
    }

    public boolean bDA() {
        return (this.fxe == null || au.isEmpty(this.fxe.mContent)) ? false : true;
    }

    public void setSpanGroupManager(SpanGroupManager spanGroupManager) {
        this.mSpanGroupManager = spanGroupManager;
    }

    public void Ed(String str) {
        if (!StringUtils.isNull(str) && bCn() != null) {
            bCn().b(new com.baidu.tbadk.editortools.a(45, 27, str));
        }
    }

    public void c(WriteData writeData) {
        int i = 0;
        if (writeData != null) {
            if (!TextUtils.isEmpty(writeData.getContent())) {
                int i2 = 0;
                while (ax.eUm.matcher(writeData.getContent()).find()) {
                    i2++;
                }
                if (i2 > 0 && this.mFrom > 0) {
                    ar arVar = new ar("c13990");
                    arVar.al("obj_type", i2);
                    arVar.al("obj_source", this.mFrom);
                    arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
                    arVar.dY("tid", writeData.getThreadId());
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
                    arVar2.al("obj_type", i);
                    arVar2.al("obj_source", this.mFrom);
                    arVar2.dY("uid", TbadkCoreApplication.getCurrentAccount());
                    arVar2.dY("tid", writeData.getThreadId());
                    TiebaStatic.log(arVar2);
                }
            }
        }
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }
}
