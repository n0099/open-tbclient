package com.baidu.tbadk.editortools.e;

import android.content.Intent;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.ae;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.b;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class p extends com.baidu.tbadk.editortools.f {
    private TbPageContext<?> Gd;
    private String avE;
    private VoiceData.VoiceModel avF;
    private com.baidu.tieba.tbadkCore.writeModel.b avJ;
    private AntiData avM;
    private c avT;
    private b.d avZ;
    private String awj;
    private String awk;
    private a<?> awl;
    private boolean awm;
    private b.d awn;
    private String mPostId;

    public p(com.baidu.tbadk.editortools.l lVar) {
        super(lVar);
        this.avE = "";
        this.awj = "";
        this.awk = null;
        this.awm = false;
        this.avZ = new q(this);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.Gd = tbPageContext;
    }

    public TbPageContext<?> DI() {
        return this.Gd;
    }

    public String DJ() {
        return this.avE;
    }

    public void fH(String str) {
        this.avE = str;
    }

    public void setReplyId(String str) {
        this.awj = str;
    }

    public void b(a<?> aVar) {
        this.awl = aVar;
        if (aVar != null) {
            this.mPostId = aVar.Dg();
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.avJ = new com.baidu.tieba.tbadkCore.writeModel.b(tbPageContext);
            this.avJ.b(this.avZ);
            ae.b(this.awl.Dg(), new r(this));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 12005:
                    ArrayList<String> y = com.baidu.tieba.tbadkCore.util.l.y(intent);
                    if (y != null) {
                        q(y);
                        return;
                    }
                    return;
                case 12006:
                    if (CG() != null) {
                        CG().hide();
                    }
                    DM();
                    bF(true);
                    WriteData bfE = this.avJ.bfE();
                    this.avJ.d((WriteData) null);
                    this.avJ.kQ(false);
                    if (bfE != null && bfE != null && bfE.getType() == 2) {
                        this.awl.Df();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void DK() {
        if (this.avJ.bfE() == null) {
            this.avJ.d(this.awl.fC(this.awl.Dg()));
        }
        if (this.avJ.bfE() != null) {
            if (this.avT != null) {
                this.avT.Di();
            }
            if (this.avT != null) {
                this.avT.Di();
            }
            if (this.avT != null) {
                this.avT.Di();
            }
            this.avJ.bfE().setContent(this.avE);
            this.avJ.bfE().setReplyId(this.awj);
            if (this.mPostId != null) {
                this.avJ.bfE().setRepostId(this.awl.Dg());
            }
            if (this.avF != null) {
                if (this.avF.getId() != null) {
                    this.avJ.bfE().setVoice(this.avF.getId());
                    this.avJ.bfE().setVoiceDuringTime(this.avF.duration);
                } else {
                    this.avJ.bfE().setVoice(null);
                    this.avJ.bfE().setVoiceDuringTime(-1);
                }
            } else {
                this.avJ.bfE().setVoice(null);
                this.avJ.bfE().setVoiceDuringTime(-1);
            }
            if (!this.avJ.blb()) {
                DI().showToast(r.j.write_img_limit);
                return;
            }
            if (this.avT != null) {
                this.avT.Di();
            }
            if (!this.avJ.bkY()) {
            }
        }
    }

    public void onDestory() {
        DL();
        this.avJ.cancelLoadData();
    }

    public void onStop() {
    }

    public void DL() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.avE);
        writeData.setReplyId(this.awj);
        writeData.setThreadId(this.mPostId);
        ae.d(this.mPostId, writeData);
    }

    public void DM() {
        ae.c(this.mPostId, (WriteData) null);
    }

    public void l(int i, String str) {
        if (AntiHelper.rU(i)) {
            AntiHelper.R(DI().getPageActivity(), str);
        } else if (i == 230277 || i == 230278) {
            fM(str);
        } else {
            DI().showToast(str);
        }
    }

    public void a(AntiData antiData) {
        this.avM = antiData;
    }

    private void fM(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(DI().getPageActivity());
        aVar.cD(str);
        aVar.b(r.j.know, new s(this));
        aVar.b(DI()).tm();
    }

    private void q(ArrayList<String> arrayList) {
        if (CG() != null) {
            CG().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.avF = voiceModel;
    }

    public boolean DN() {
        return this.awm;
    }

    public void bG(boolean z) {
        this.awm = z;
    }

    public void fN(String str) {
        bG(true);
        CG().lw();
        if (str != null && str.length() != 0) {
            fP(DI().getResources().getString(r.j.reply_sub_floor).replace("%s", str));
        } else {
            fP("");
        }
        TiebaStatic.eventStat(DI().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void fO(String str) {
        bG(true);
        fP(str);
        TiebaStatic.eventStat(DI().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void DO() {
        bG(false);
        CG().hide();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fP(String str) {
        if (CG() != null) {
            CG().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    public void fQ(String str) {
        String string = TbadkCoreApplication.m9getInst().getResources().getString(r.j.reply_sub_floor);
        String str2 = "^" + string.replace("%s", ".+") + "$";
        if (az.isEmpty(this.avE) || this.avE.matches(str2)) {
            if (this.awk != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.awk).lookingAt()) {
                    fO(this.awk);
                    return;
                } else {
                    fN(str);
                    return;
                }
            }
            fN(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.avE);
        this.awk = this.avE;
        if (matcher.lookingAt()) {
            fO(this.avE);
        } else {
            fN(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bF(boolean z) {
        if (CG() != null) {
            CG().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(b.d dVar) {
        this.awn = dVar;
    }

    public void a(c cVar) {
        this.avT = cVar;
    }
}
