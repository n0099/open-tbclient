package com.baidu.tbadk.editortools.d;

import android.content.Intent;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.ae;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.b;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class p extends com.baidu.tbadk.editortools.f {
    private TbPageContext<?> Gd;
    private String awG;
    private String awH;
    private a<?> awI;
    private boolean awJ;
    private b.d awK;
    private String awb;
    private VoiceData.VoiceModel awc;
    private com.baidu.tieba.tbadkCore.writeModel.b awg;
    private AntiData awj;
    private c awq;
    private b.d aww;
    private String mPostId;

    public p(com.baidu.tbadk.editortools.l lVar) {
        super(lVar);
        this.awb = "";
        this.awG = "";
        this.awH = null;
        this.awJ = false;
        this.aww = new q(this);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.Gd = tbPageContext;
    }

    public TbPageContext<?> DI() {
        return this.Gd;
    }

    public String DJ() {
        return this.awb;
    }

    public void fE(String str) {
        this.awb = str;
    }

    public void setReplyId(String str) {
        this.awG = str;
    }

    public void b(a<?> aVar) {
        this.awI = aVar;
        if (aVar != null) {
            this.mPostId = aVar.Dg();
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.awg = new com.baidu.tieba.tbadkCore.writeModel.b(tbPageContext);
            this.awg.b(this.aww);
            ae.b(this.awI.Dg(), new r(this));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 12005:
                    ArrayList<String> z = com.baidu.tieba.tbadkCore.util.l.z(intent);
                    if (z != null) {
                        q(z);
                        return;
                    }
                    return;
                case 12006:
                    if (CG() != null) {
                        CG().hide();
                    }
                    DM();
                    bG(true);
                    WriteData beT = this.awg.beT();
                    this.awg.d((WriteData) null);
                    this.awg.kN(false);
                    if (beT != null && beT != null && beT.getType() == 2) {
                        this.awI.Df();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void DK() {
        if (this.awg.beT() == null) {
            this.awg.d(this.awI.fz(this.awI.Dg()));
        }
        if (this.awg.beT() != null) {
            if (this.awq != null) {
                this.awq.Di();
            }
            if (this.awq != null) {
                this.awq.Di();
            }
            if (this.awq != null) {
                this.awq.Di();
            }
            this.awg.beT().setContent(this.awb);
            this.awg.beT().setReplyId(this.awG);
            if (this.mPostId != null) {
                this.awg.beT().setRepostId(this.awI.Dg());
            }
            if (this.awc != null) {
                if (this.awc.getId() != null) {
                    this.awg.beT().setVoice(this.awc.getId());
                    this.awg.beT().setVoiceDuringTime(this.awc.duration);
                } else {
                    this.awg.beT().setVoice(null);
                    this.awg.beT().setVoiceDuringTime(-1);
                }
            } else {
                this.awg.beT().setVoice(null);
                this.awg.beT().setVoiceDuringTime(-1);
            }
            if (!this.awg.bkq()) {
                DI().showToast(t.j.write_img_limit);
                return;
            }
            if (this.awq != null) {
                this.awq.Di();
            }
            if (!this.awg.bkn()) {
            }
        }
    }

    public void onDestory() {
        DL();
        this.awg.cancelLoadData();
    }

    public void onStop() {
    }

    public void DL() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.awb);
        writeData.setReplyId(this.awG);
        writeData.setThreadId(this.mPostId);
        ae.d(this.mPostId, writeData);
    }

    public void DM() {
        ae.c(this.mPostId, (WriteData) null);
    }

    public void l(int i, String str) {
        if (AntiHelper.rG(i)) {
            AntiHelper.R(DI().getPageActivity(), str);
        } else if (i == 230277 || i == 230278) {
            fI(str);
        } else {
            DI().showToast(str);
        }
    }

    public void a(AntiData antiData) {
        this.awj = antiData;
    }

    private void fI(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(DI().getPageActivity());
        aVar.cB(str);
        aVar.b(t.j.know, new s(this));
        aVar.b(DI()).sX();
    }

    private void q(ArrayList<String> arrayList) {
        if (CG() != null) {
            CG().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.awc = voiceModel;
    }

    public boolean DN() {
        return this.awJ;
    }

    public void bH(boolean z) {
        this.awJ = z;
    }

    public void fJ(String str) {
        bH(true);
        CG().lw();
        if (str != null && str.length() != 0) {
            fL(DI().getResources().getString(t.j.reply_sub_floor).replace("%s", str));
        } else {
            fL("");
        }
        TiebaStatic.eventStat(DI().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void fK(String str) {
        bH(true);
        fL(str);
        TiebaStatic.eventStat(DI().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void DO() {
        bH(false);
        CG().hide();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fL(String str) {
        if (CG() != null) {
            CG().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    public void fM(String str) {
        String string = TbadkCoreApplication.m9getInst().getResources().getString(t.j.reply_sub_floor);
        String str2 = "^" + string.replace("%s", ".+") + "$";
        if (ba.isEmpty(this.awb) || this.awb.matches(str2)) {
            if (this.awH != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.awH).lookingAt()) {
                    fK(this.awH);
                    return;
                } else {
                    fJ(str);
                    return;
                }
            }
            fJ(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.awb);
        this.awH = this.awb;
        if (matcher.lookingAt()) {
            fK(this.awb);
        } else {
            fJ(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bG(boolean z) {
        if (CG() != null) {
            CG().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(b.d dVar) {
        this.awK = dVar;
    }

    public void a(c cVar) {
        this.awq = cVar;
    }
}
