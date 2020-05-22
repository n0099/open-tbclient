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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.aa;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends com.baidu.tbadk.editortools.d {
    private bk ahg;
    private TbPageContext<?> dIF;
    private NewWriteModel emH;
    private String emL;
    private c emO;
    private b emP;
    private NewWriteModel.d emV;
    private j enq;
    private String enr;
    private DataModel<?> ens;
    private boolean ent;
    private NewWriteModel.d enu;
    private f enw;
    private w.a enx;
    private View.OnClickListener eny;
    public boolean isBJH;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private VoiceData.VoiceModel mVoiceModel;

    public h(EditorTools editorTools) {
        super(editorTools);
        this.enr = "";
        this.ent = false;
        this.emL = null;
        this.emV = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.h.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
                if (h.this.enu != null) {
                    h.this.enu.callback(z, postWriteCallBackData, aaVar, writeData, antiData);
                }
                if (z) {
                    h.this.enq = null;
                    h.this.enr = null;
                    h.this.ie(true);
                    h.this.bdT();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData cZP = h.this.emH.cZP();
                    h.this.emH.d((WriteData) null);
                    h.this.emH.uy(false);
                    h.this.mVoiceModel = null;
                    if (cZP != null && cZP != null && cZP.getType() == 2) {
                        h.this.ens.bdq();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.bv(i, str)) {
                    h.this.ap(i, str);
                } else if (aaVar != null && writeData != null && !StringUtils.isNull(aaVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(aaVar.getVcode_md5());
                    writeData.setVcodeUrl(aaVar.getVcode_pic_url());
                    writeData.setVcodeExtra(aaVar.aYm());
                    if (h.this.ahg != null) {
                        writeData.setBaijiahaoData(h.this.ahg.getBaijiahaoData());
                    }
                    if (com.baidu.tbadk.s.a.yX(aaVar.aYl())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(h.this.aXW().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, aaVar.aYl())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(h.this.aXW().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(h.this.dIF.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    h.this.aXW().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.h.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ag("obj_locate", at.a.LOCATE_REPLY_SUB_PB));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ag("obj_locate", at.a.LOCATE_REPLY_SUB_PB));
            }
        };
        this.eny = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(h.this.emL)) {
                    l.showToast(h.this.aXW().getPageActivity(), h.this.emL);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            if (this.enq == null) {
                this.enq = new j();
            }
            this.enq.mContent = writeData.getContent();
            this.enq.enD = writeData.getSubPbReplyPrefix();
            c(this.enq);
        }
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.dIF = tbPageContext;
    }

    public TbPageContext<?> aXW() {
        return this.dIF;
    }

    public void setThreadData(bk bkVar) {
        this.ahg = bkVar;
    }

    public void yk(String str) {
        if (this.enq == null) {
            this.enq = new j();
        }
        this.enq.mContent = str;
    }

    public void a(j jVar) {
        this.enq = jVar;
    }

    public void a(w.a aVar) {
        this.enx = aVar;
    }

    public void setReplyId(String str) {
        this.enr = str;
    }

    public void b(DataModel<?> dataModel) {
        this.ens = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.bdr();
        }
    }

    public void h(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.emH = new NewWriteModel(tbPageContext);
            this.emH.b(this.emV);
            w.b(this.ens.bdr(), new w.a() { // from class: com.baidu.tbadk.editortools.pb.h.3
                @Override // com.baidu.tieba.tbadkCore.w.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        if (h.this.enq == null) {
                            h.this.enq = new j();
                        }
                        h.this.enq.mContent = writeData.getContent();
                        h.this.enq.enD = writeData.getSubPbReplyPrefix();
                        h.this.c(h.this.enq);
                    }
                    if (h.this.enx != null) {
                        h.this.enx.a(writeData);
                    }
                }
            });
        }
    }

    public boolean bdK() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_SUB_PB_AT_SELECT /* 12005 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        G(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (bcW() != null) {
                        bcW().hide();
                    }
                    bdT();
                    ie(true);
                    WriteData cZP = this.emH.cZP();
                    this.emH.d((WriteData) null);
                    this.emH.uy(false);
                    if (cZP != null && cZP != null && cZP.getType() == 2) {
                        this.ens.bdq();
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
                    if (this.enu != null) {
                        this.enu.callback(false, postWriteCallBackData, null, this.emH.cZP(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void bdR() {
        if (this.emH.cZP() == null) {
            WriteData yf = this.ens.yf(this.ens.bdr());
            if (yf != null && this.ahg != null) {
                yf.setBaijiahaoData(this.ahg.getBaijiahaoData());
            }
            this.emH.d(yf);
        }
        if (this.emH.cZP() != null) {
            if (this.enq != null) {
                this.emH.cZP().setContent(this.enq.mContent);
                this.emH.cZP().setSubPbReplyPrefix(this.enq.enD);
                if (this.ahg != null) {
                    this.emH.cZP().setBaijiahaoData(this.ahg.getBaijiahaoData());
                }
            }
            this.emH.cZP().setReplyId(this.enr);
            if (this.mPostId != null) {
                this.emH.cZP().setRepostId(this.ens.bdr());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.emH.cZP().setVoice(this.mVoiceModel.getId());
                    this.emH.cZP().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.emH.cZP().setVoice(null);
                    this.emH.cZP().setVoiceDuringTime(-1);
                }
            } else {
                this.emH.cZP().setVoice(null);
                this.emH.cZP().setVoiceDuringTime(-1);
            }
            if (!this.emH.deQ()) {
                aXW().showToast((int) R.string.write_img_limit);
            } else if (this.emP == null || !this.emP.bdt()) {
                if (this.emO != null) {
                    this.emO.bdu();
                }
                if (!this.emH.deN()) {
                }
            }
        }
    }

    public void onDestory() {
        bdS();
        this.emH.cancelLoadData();
    }

    public void onStop() {
    }

    public void bdS() {
        WriteData writeData = new WriteData(2);
        if (this.enq != null) {
            writeData.setContent(this.enq.mContent);
            writeData.setSubPbReplyPrefix(this.enq.enD);
        }
        writeData.setReplyId(this.enr);
        writeData.setThreadId(this.mPostId);
        w.f(this.mPostId, writeData);
    }

    public void bdT() {
        w.e(this.mPostId, (WriteData) null);
    }

    public void ap(int i, String str) {
        if (AntiHelper.bv(i, str)) {
            if (AntiHelper.a(this.dIF.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ag("obj_locate", at.a.LOCATE_REPLY_SUB_PB));
            }
        } else if (i == 230277 || i == 230278) {
            yo(str);
        } else {
            aXW().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        if (this.enq != null) {
            pbEditorData.setContent(this.enq.mContent);
            pbEditorData.setSubPbReplyPrefix(this.enq.enD);
        }
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.emL);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.dIF.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.g nc;
        if (antiData != null) {
            this.emL = antiData.getVoice_message();
            if (!StringUtils.isNull(this.emL) && bcW() != null && (nc = bcW().nc(6)) != null && !TextUtils.isEmpty(this.emL)) {
                ((View) nc).setOnClickListener(this.eny);
            }
        }
    }

    private void yo(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(aXW().getPageActivity());
        aVar.vO(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.h.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(aXW()).aST();
    }

    private void G(ArrayList<String> arrayList) {
        if (bcW() != null) {
            bcW().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean bdU() {
        return this.ent;
    }

    /* renamed from: if  reason: not valid java name */
    public void m31if(boolean z) {
        this.ent = z;
    }

    public void yp(String str) {
        m31if(true);
        bcW().display();
        if (str != null && str.length() != 0) {
            String replace = aXW().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            j jVar = new j();
            jVar.enD = replace;
            c(jVar);
        } else {
            j jVar2 = new j();
            jVar2.mContent = "";
            c(jVar2);
        }
        TiebaStatic.eventStat(aXW().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void b(j jVar) {
        m31if(true);
        bcW().display();
        c(jVar);
        TiebaStatic.eventStat(aXW().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void bdV() {
        m31if(false);
        bcW().hide();
    }

    public void bdW() {
        m31if(true);
        bcW().display();
        bcW().bg((View) bcW().nc(5));
    }

    public void bdX() {
        m31if(true);
        bcW().display();
        bcW().bg((View) bcW().nc(2));
    }

    public void bdY() {
        m31if(true);
        bcW().display();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(j jVar) {
        if (bcW() != null) {
            bcW().b(new com.baidu.tbadk.editortools.a(6, 27, jVar));
        }
    }

    public void yq(String str) {
        if (str != null) {
            String replace = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            if (this.enq != null) {
                if (TextUtils.isEmpty(this.enq.enD) && TextUtils.isEmpty(this.enq.mContent)) {
                    yp(str);
                    return;
                } else if (!TextUtils.isEmpty(this.enq.enD) && this.enq.enD.equals(replace)) {
                    b(this.enq);
                    return;
                } else {
                    yp(str);
                    return;
                }
            }
            yp(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ie(boolean z) {
        if (bcW() != null) {
            bcW().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.enu = dVar;
    }

    public void a(c cVar) {
        this.emO = cVar;
    }

    public void a(b bVar) {
        this.emP = bVar;
    }

    public f bdZ() {
        if (this.enw == null && bcW() != null) {
            this.enw = (f) bcW().nf(27);
        }
        return this.enw;
    }

    public boolean bea() {
        return (this.enq == null || aq.isEmpty(this.enq.mContent)) ? false : true;
    }
}
