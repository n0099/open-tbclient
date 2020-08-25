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
/* loaded from: classes2.dex */
public class h extends com.baidu.tbadk.editortools.e {
    private bw ajx;
    private NewWriteModel.d eMD;
    private j eMY;
    private String eMZ;
    private NewWriteModel eMp;
    private String eMt;
    private c eMw;
    private b eMx;
    private DataModel<?> eNa;
    private boolean eNb;
    private NewWriteModel.d eNc;
    private f eNd;
    private x.a eNe;
    private View.OnClickListener eNf;
    private TbPageContext<?> efn;
    public boolean isBJH;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private SpanGroupManager mSpanGroupManager;
    private VoiceData.VoiceModel mVoiceModel;

    public h(EditorTools editorTools) {
        super(editorTools);
        this.eMZ = "";
        this.eNb = false;
        this.eMt = null;
        this.eMD = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.h.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ag agVar, WriteData writeData, AntiData antiData) {
                if (h.this.eNc != null) {
                    h.this.eNc.callback(z, postWriteCallBackData, agVar, writeData, antiData);
                }
                if (z) {
                    h.this.eMY = null;
                    h.this.eMZ = null;
                    h.this.jp(true);
                    h.this.bsw();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData cKZ = h.this.eMp.cKZ();
                    h.this.eMp.d((WriteData) null);
                    h.this.eMp.wg(false);
                    h.this.mVoiceModel = null;
                    if (cKZ != null && cKZ != null && cKZ.getType() == 2) {
                        h.this.eNa.brR();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.bz(i, str)) {
                    h.this.aq(i, str);
                } else if (agVar != null && writeData != null && !StringUtils.isNull(agVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(agVar.getVcode_md5());
                    writeData.setVcodeUrl(agVar.getVcode_pic_url());
                    writeData.setVcodeExtra(agVar.bmZ());
                    if (h.this.ajx != null) {
                        writeData.setBaijiahaoData(h.this.ajx.getBaijiahaoData());
                    }
                    if (com.baidu.tbadk.t.a.CO(agVar.bmY())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(h.this.bmF().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, agVar.bmY())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(h.this.bmF().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(h.this.efn.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
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
        this.eNf = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(h.this.eMt)) {
                    l.showToast(h.this.bmF().getPageActivity(), h.this.eMt);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            if (this.eMY == null) {
                this.eMY = new j();
            }
            this.eMY.mContent = writeData.getContent();
            this.eMY.eNk = writeData.getSubPbReplyPrefix();
            c(this.eMY);
        }
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.efn = tbPageContext;
    }

    public TbPageContext<?> bmF() {
        return this.efn;
    }

    public void setThreadData(bw bwVar) {
        this.ajx = bwVar;
    }

    public void BZ(String str) {
        if (this.eMY == null) {
            this.eMY = new j();
        }
        this.eMY.mContent = str;
    }

    public void a(j jVar) {
        this.eMY = jVar;
    }

    public void reset() {
        this.eMp.d((WriteData) null);
        this.eMp.wg(false);
        this.mVoiceModel = null;
    }

    public void a(x.a aVar) {
        this.eNe = aVar;
    }

    public void setReplyId(String str) {
        this.eMZ = str;
    }

    public void b(DataModel<?> dataModel) {
        this.eNa = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.brS();
        }
    }

    public void j(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.eMp = new NewWriteModel(tbPageContext);
            this.eMp.b(this.eMD);
            x.b(this.eNa.brS(), new x.a() { // from class: com.baidu.tbadk.editortools.pb.h.3
                @Override // com.baidu.tieba.tbadkCore.x.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        if (h.this.eMY == null) {
                            h.this.eMY = new j();
                        }
                        h.this.eMY.mContent = writeData.getContent();
                        h.this.eMY.eNk = writeData.getSubPbReplyPrefix();
                        h.this.c(h.this.eMY);
                    }
                    if (h.this.eNe != null) {
                        h.this.eNe.a(writeData);
                    }
                }
            });
        }
    }

    public boolean bsm() {
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
                    if (brv() != null) {
                        brv().hide();
                    }
                    bsw();
                    jp(true);
                    WriteData cKZ = this.eMp.cKZ();
                    this.eMp.d((WriteData) null);
                    this.eMp.wg(false);
                    if (cKZ != null && cKZ != null && cKZ.getType() == 2) {
                        this.eNa.brR();
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
                    if (this.eNc != null) {
                        this.eNc.callback(false, postWriteCallBackData, null, this.eMp.cKZ(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void bsu() {
        if (this.eMp.cKZ() == null) {
            WriteData BU = this.eNa.BU(this.eNa.brS());
            if (BU != null && this.ajx != null) {
                BU.setBaijiahaoData(this.ajx.getBaijiahaoData());
            }
            this.eMp.d(BU);
        }
        if (this.eMp.cKZ() != null) {
            this.eMp.setSpanGroupManager(this.mSpanGroupManager);
            if (this.eMY != null) {
                this.eMp.cKZ().setContent(this.eMY.mContent);
                this.eMp.cKZ().setSubPbReplyPrefix(this.eMY.eNk);
                if (this.ajx != null) {
                    this.eMp.cKZ().setBaijiahaoData(this.ajx.getBaijiahaoData());
                }
            }
            this.eMp.cKZ().setReplyId(this.eMZ);
            if (this.mPostId != null) {
                this.eMp.cKZ().setRepostId(this.eNa.brS());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.eMp.cKZ().setVoice(this.mVoiceModel.getId());
                    this.eMp.cKZ().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.eMp.cKZ().setVoice(null);
                    this.eMp.cKZ().setVoiceDuringTime(-1);
                }
            } else {
                this.eMp.cKZ().setVoice(null);
                this.eMp.cKZ().setVoiceDuringTime(-1);
            }
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

    public void onDestory() {
        bsv();
        this.eMp.cancelLoadData();
    }

    public void onStop() {
    }

    public void bsv() {
        WriteData writeData = new WriteData(2);
        if (this.eMY != null) {
            writeData.setContent(this.eMY.mContent);
            writeData.setSubPbReplyPrefix(this.eMY.eNk);
        }
        writeData.setReplyId(this.eMZ);
        writeData.setThreadId(this.mPostId);
        x.g(this.mPostId, writeData);
    }

    public void bsw() {
        x.f(this.mPostId, (WriteData) null);
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

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        if (this.eMY != null) {
            pbEditorData.setContent(this.eMY.mContent);
            pbEditorData.setSubPbReplyPrefix(this.eMY.eNk);
        }
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.eMt);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.efn.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.h qb;
        if (antiData != null) {
            this.eMt = antiData.getVoice_message();
            if (!StringUtils.isNull(this.eMt) && brv() != null && (qb = brv().qb(6)) != null && !TextUtils.isEmpty(this.eMt)) {
                ((View) qb).setOnClickListener(this.eNf);
            }
        }
    }

    private void Cd(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(bmF().getPageActivity());
        aVar.zz(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.h.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(bmF()).bhg();
    }

    private void N(ArrayList<String> arrayList) {
        if (brv() != null) {
            brv().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean bsx() {
        return this.eNb;
    }

    public void jr(boolean z) {
        this.eNb = z;
    }

    public void Ce(String str) {
        jr(true);
        brv().display();
        if (str != null && str.length() != 0) {
            String replace = bmF().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            j jVar = new j();
            jVar.eNk = replace;
            c(jVar);
        } else {
            j jVar2 = new j();
            jVar2.mContent = "";
            c(jVar2);
        }
        TiebaStatic.eventStat(bmF().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void b(j jVar) {
        jr(true);
        brv().display();
        c(jVar);
        TiebaStatic.eventStat(bmF().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void bsy() {
        jr(false);
        brv().hide();
    }

    public void bsz() {
        jr(true);
        brv().display();
        brv().bp((View) brv().qb(5));
    }

    public void bsA() {
        jr(true);
        brv().display();
        brv().bp((View) brv().qb(2));
    }

    public void bsB() {
        jr(true);
        brv().display();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(j jVar) {
        if (brv() != null) {
            brv().b(new com.baidu.tbadk.editortools.a(6, 27, jVar));
        }
    }

    public void Cf(String str) {
        if (str != null) {
            String replace = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            if (this.eMY != null) {
                if (TextUtils.isEmpty(this.eMY.eNk) && TextUtils.isEmpty(this.eMY.mContent)) {
                    Ce(str);
                    return;
                } else if (!TextUtils.isEmpty(this.eMY.eNk) && this.eMY.eNk.equals(replace)) {
                    b(this.eMY);
                    return;
                } else {
                    Ce(str);
                    return;
                }
            }
            Ce(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jp(boolean z) {
        if (brv() != null) {
            brv().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.eNc = dVar;
    }

    public void a(c cVar) {
        this.eMw = cVar;
    }

    public void a(b bVar) {
        this.eMx = bVar;
    }

    public f bsC() {
        if (this.eNd == null && brv() != null) {
            this.eNd = (f) brv().qe(27);
        }
        return this.eNd;
    }

    public boolean bsD() {
        return (this.eMY == null || at.isEmpty(this.eMY.mContent)) ? false : true;
    }

    public void setSpanGroupManager(SpanGroupManager spanGroupManager) {
        this.mSpanGroupManager = spanGroupManager;
    }

    public void Cg(String str) {
        if (!StringUtils.isNull(str) && brv() != null) {
            brv().b(new com.baidu.tbadk.editortools.a(45, 27, str));
        }
    }
}
