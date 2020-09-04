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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ag;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.x;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends com.baidu.tbadk.editortools.e {
    private bw ajz;
    private c eMA;
    private b eMB;
    private NewWriteModel.d eMH;
    private NewWriteModel eMt;
    private String eMx;
    private j eNc;
    private String eNd;
    private DataModel<?> eNe;
    private boolean eNf;
    private NewWriteModel.d eNg;
    private f eNh;
    private x.a eNi;
    private View.OnClickListener eNj;
    private TbPageContext<?> efr;
    public boolean isBJH;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private SpanGroupManager mSpanGroupManager;
    private VoiceData.VoiceModel mVoiceModel;

    public h(EditorTools editorTools) {
        super(editorTools);
        this.eNd = "";
        this.eNf = false;
        this.eMx = null;
        this.eMH = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.h.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ag agVar, WriteData writeData, AntiData antiData) {
                if (h.this.eNg != null) {
                    h.this.eNg.callback(z, postWriteCallBackData, agVar, writeData, antiData);
                }
                if (z) {
                    h.this.eNc = null;
                    h.this.eNd = null;
                    h.this.jr(true);
                    h.this.bsx();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData cLa = h.this.eMt.cLa();
                    h.this.eMt.d((WriteData) null);
                    h.this.eMt.wi(false);
                    h.this.mVoiceModel = null;
                    if (cLa != null && cLa != null && cLa.getType() == 2) {
                        h.this.eNe.brS();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.by(i, str)) {
                    h.this.aq(i, str);
                } else if (agVar != null && writeData != null && !StringUtils.isNull(agVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(agVar.getVcode_md5());
                    writeData.setVcodeUrl(agVar.getVcode_pic_url());
                    writeData.setVcodeExtra(agVar.bmZ());
                    if (h.this.ajz != null) {
                        writeData.setBaijiahaoData(h.this.ajz.getBaijiahaoData());
                    }
                    if (com.baidu.tbadk.t.a.CP(agVar.bmY())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(h.this.bmF().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, agVar.bmY())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(h.this.bmF().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(h.this.efr.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    h.this.bmF().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.h.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ai("obj_locate", ax.a.LOCATE_REPLY_SUB_PB));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ai("obj_locate", ax.a.LOCATE_REPLY_SUB_PB));
            }
        };
        this.eNj = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(h.this.eMx)) {
                    l.showToast(h.this.bmF().getPageActivity(), h.this.eMx);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            if (this.eNc == null) {
                this.eNc = new j();
            }
            this.eNc.mContent = writeData.getContent();
            this.eNc.eNo = writeData.getSubPbReplyPrefix();
            c(this.eNc);
        }
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.efr = tbPageContext;
    }

    public TbPageContext<?> bmF() {
        return this.efr;
    }

    public void setThreadData(bw bwVar) {
        this.ajz = bwVar;
    }

    public void Ca(String str) {
        if (this.eNc == null) {
            this.eNc = new j();
        }
        this.eNc.mContent = str;
    }

    public void a(j jVar) {
        this.eNc = jVar;
    }

    public void reset() {
        this.eMt.d((WriteData) null);
        this.eMt.wi(false);
        this.mVoiceModel = null;
    }

    public void a(x.a aVar) {
        this.eNi = aVar;
    }

    public void setReplyId(String str) {
        this.eNd = str;
    }

    public void b(DataModel<?> dataModel) {
        this.eNe = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.brT();
        }
    }

    public void j(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.eMt = new NewWriteModel(tbPageContext);
            this.eMt.b(this.eMH);
            x.b(this.eNe.brT(), new x.a() { // from class: com.baidu.tbadk.editortools.pb.h.3
                @Override // com.baidu.tieba.tbadkCore.x.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        if (h.this.eNc == null) {
                            h.this.eNc = new j();
                        }
                        h.this.eNc.mContent = writeData.getContent();
                        h.this.eNc.eNo = writeData.getSubPbReplyPrefix();
                        h.this.c(h.this.eNc);
                    }
                    if (h.this.eNi != null) {
                        h.this.eNi.a(writeData);
                    }
                }
            });
        }
    }

    public boolean bsn() {
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
                    if (brw() != null) {
                        brw().hide();
                    }
                    bsx();
                    jr(true);
                    WriteData cLa = this.eMt.cLa();
                    this.eMt.d((WriteData) null);
                    this.eMt.wi(false);
                    if (cLa != null && cLa != null && cLa.getType() == 2) {
                        this.eNe.brS();
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
                    if (this.eNg != null) {
                        this.eNg.callback(false, postWriteCallBackData, null, this.eMt.cLa(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void bsv() {
        if (this.eMt.cLa() == null) {
            WriteData BV = this.eNe.BV(this.eNe.brT());
            if (BV != null && this.ajz != null) {
                BV.setBaijiahaoData(this.ajz.getBaijiahaoData());
            }
            this.eMt.d(BV);
        }
        if (this.eMt.cLa() != null) {
            this.eMt.setSpanGroupManager(this.mSpanGroupManager);
            if (this.eNc != null) {
                this.eMt.cLa().setContent(this.eNc.mContent);
                this.eMt.cLa().setSubPbReplyPrefix(this.eNc.eNo);
                if (this.ajz != null) {
                    this.eMt.cLa().setBaijiahaoData(this.ajz.getBaijiahaoData());
                }
            }
            this.eMt.cLa().setReplyId(this.eNd);
            if (this.mPostId != null) {
                this.eMt.cLa().setRepostId(this.eNe.brT());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.eMt.cLa().setVoice(this.mVoiceModel.getId());
                    this.eMt.cLa().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.eMt.cLa().setVoice(null);
                    this.eMt.cLa().setVoiceDuringTime(-1);
                }
            } else {
                this.eMt.cLa().setVoice(null);
                this.eMt.cLa().setVoiceDuringTime(-1);
            }
            if (!this.eMt.dya()) {
                bmF().showToast(R.string.write_img_limit);
            } else if (this.eMB == null || !this.eMB.brV()) {
                if (this.eMA != null) {
                    this.eMA.brW();
                }
                if (!this.eMt.dxX()) {
                }
            }
        }
    }

    public void onDestory() {
        bsw();
        this.eMt.cancelLoadData();
    }

    public void onStop() {
    }

    public void bsw() {
        WriteData writeData = new WriteData(2);
        if (this.eNc != null) {
            writeData.setContent(this.eNc.mContent);
            writeData.setSubPbReplyPrefix(this.eNc.eNo);
        }
        writeData.setReplyId(this.eNd);
        writeData.setThreadId(this.mPostId);
        x.g(this.mPostId, writeData);
    }

    public void bsx() {
        x.f(this.mPostId, (WriteData) null);
    }

    public void aq(int i, String str) {
        if (AntiHelper.by(i, str)) {
            if (AntiHelper.a(this.efr.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ai("obj_locate", ax.a.LOCATE_REPLY_SUB_PB));
            }
        } else if (i == 230277 || i == 230278) {
            Ce(str);
        } else {
            bmF().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        if (this.eNc != null) {
            pbEditorData.setContent(this.eNc.mContent);
            pbEditorData.setSubPbReplyPrefix(this.eNc.eNo);
        }
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.eMx);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.efr.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.h qb;
        if (antiData != null) {
            this.eMx = antiData.getVoice_message();
            if (!StringUtils.isNull(this.eMx) && brw() != null && (qb = brw().qb(6)) != null && !TextUtils.isEmpty(this.eMx)) {
                ((View) qb).setOnClickListener(this.eNj);
            }
        }
    }

    private void Ce(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(bmF().getPageActivity());
        aVar.zA(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.h.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(bmF()).bhg();
    }

    private void N(ArrayList<String> arrayList) {
        if (brw() != null) {
            brw().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean bsy() {
        return this.eNf;
    }

    public void jt(boolean z) {
        this.eNf = z;
    }

    public void Cf(String str) {
        jt(true);
        brw().display();
        if (str != null && str.length() != 0) {
            String replace = bmF().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            j jVar = new j();
            jVar.eNo = replace;
            c(jVar);
        } else {
            j jVar2 = new j();
            jVar2.mContent = "";
            c(jVar2);
        }
        TiebaStatic.eventStat(bmF().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void b(j jVar) {
        jt(true);
        brw().display();
        c(jVar);
        TiebaStatic.eventStat(bmF().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void bsz() {
        jt(false);
        brw().hide();
    }

    public void bsA() {
        jt(true);
        brw().display();
        brw().bp((View) brw().qb(5));
    }

    public void bsB() {
        jt(true);
        brw().display();
        brw().bp((View) brw().qb(2));
    }

    public void bsC() {
        jt(true);
        brw().display();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(j jVar) {
        if (brw() != null) {
            brw().b(new com.baidu.tbadk.editortools.a(6, 27, jVar));
        }
    }

    public void Cg(String str) {
        if (str != null) {
            String replace = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            if (this.eNc != null) {
                if (TextUtils.isEmpty(this.eNc.eNo) && TextUtils.isEmpty(this.eNc.mContent)) {
                    Cf(str);
                    return;
                } else if (!TextUtils.isEmpty(this.eNc.eNo) && this.eNc.eNo.equals(replace)) {
                    b(this.eNc);
                    return;
                } else {
                    Cf(str);
                    return;
                }
            }
            Cf(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jr(boolean z) {
        if (brw() != null) {
            brw().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.eNg = dVar;
    }

    public void a(c cVar) {
        this.eMA = cVar;
    }

    public void a(b bVar) {
        this.eMB = bVar;
    }

    public f bsD() {
        if (this.eNh == null && brw() != null) {
            this.eNh = (f) brw().qe(27);
        }
        return this.eNh;
    }

    public boolean bsE() {
        return (this.eNc == null || at.isEmpty(this.eNc.mContent)) ? false : true;
    }

    public void setSpanGroupManager(SpanGroupManager spanGroupManager) {
        this.mSpanGroupManager = spanGroupManager;
    }

    public void Ch(String str) {
        if (!StringUtils.isNull(str) && brw() != null) {
            brw().b(new com.baidu.tbadk.editortools.a(45, 27, str));
        }
    }
}
