package com.baidu.tbadk.editortools.d;

import android.content.Intent;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.af;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class p extends com.baidu.tbadk.editortools.f {
    private TbPageContext<?> DQ;
    private String asU;
    private VoiceData.VoiceModel asV;
    private com.baidu.tieba.tbadkCore.writeModel.a asZ;
    private String atA;
    private a<?> atB;
    private boolean atC;
    private a.d atD;
    private AntiData atc;
    private c atj;
    private a.d atp;
    private String atz;
    private String mPostId;

    public p(com.baidu.tbadk.editortools.l lVar) {
        super(lVar);
        this.asU = "";
        this.atz = "";
        this.atA = null;
        this.atC = false;
        this.atp = new q(this);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.DQ = tbPageContext;
    }

    public TbPageContext<?> Cn() {
        return this.DQ;
    }

    public String Co() {
        return this.asU;
    }

    public void fB(String str) {
        this.asU = str;
    }

    public void setReplyId(String str) {
        this.atz = str;
    }

    public void b(a<?> aVar) {
        this.atB = aVar;
        if (aVar != null) {
            this.mPostId = aVar.BL();
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.asZ = new com.baidu.tieba.tbadkCore.writeModel.a(tbPageContext);
            this.asZ.b(this.atp);
            af.b(this.atB.BL(), new r(this));
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
                    if (Bl() != null) {
                        Bl().hide();
                    }
                    Cr();
                    bE(true);
                    WriteData bbo = this.asZ.bbo();
                    this.asZ.d((WriteData) null);
                    this.asZ.kB(false);
                    if (bbo != null && bbo != null && bbo.getType() == 2) {
                        this.atB.BK();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void Cp() {
        if (this.asZ.bbo() == null) {
            this.asZ.d(this.atB.fw(this.atB.BL()));
        }
        if (this.asZ.bbo() != null) {
            if (this.atj != null) {
                this.atj.BN();
            }
            if (this.atj != null) {
                this.atj.BN();
            }
            if (this.atj != null) {
                this.atj.BN();
            }
            this.asZ.bbo().setContent(this.asU);
            this.asZ.bbo().setReplyId(this.atz);
            if (this.mPostId != null) {
                this.asZ.bbo().setRepostId(this.atB.BL());
            }
            if (this.asV != null) {
                if (this.asV.getId() != null) {
                    this.asZ.bbo().setVoice(this.asV.getId());
                    this.asZ.bbo().setVoiceDuringTime(this.asV.duration);
                } else {
                    this.asZ.bbo().setVoice(null);
                    this.asZ.bbo().setVoiceDuringTime(-1);
                }
            } else {
                this.asZ.bbo().setVoice(null);
                this.asZ.bbo().setVoiceDuringTime(-1);
            }
            if (!this.asZ.bgP()) {
                Cn().showToast(u.j.write_img_limit);
                return;
            }
            if (this.atj != null) {
                this.atj.BN();
            }
            if (!this.asZ.bgM()) {
            }
        }
    }

    public void onDestory() {
        Cq();
        this.asZ.cancelLoadData();
    }

    public void onStop() {
    }

    public void Cq() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.asU);
        writeData.setReplyId(this.atz);
        writeData.setThreadId(this.mPostId);
        af.d(this.mPostId, writeData);
    }

    public void Cr() {
        af.c(this.mPostId, (WriteData) null);
    }

    public void l(int i, String str) {
        if (AntiHelper.rg(i)) {
            AntiHelper.O(Cn().getPageActivity(), str);
        } else if (i == 230277 || i == 230278) {
            fF(str);
        } else {
            Cn().showToast(str);
        }
    }

    public void a(AntiData antiData) {
        this.atc = antiData;
    }

    private void fF(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(Cn().getPageActivity());
        aVar.cz(str);
        aVar.b(u.j.know, new s(this));
        aVar.b(Cn()).rS();
    }

    private void q(ArrayList<String> arrayList) {
        if (Bl() != null) {
            Bl().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.asV = voiceModel;
    }

    public boolean Cs() {
        return this.atC;
    }

    public void bF(boolean z) {
        this.atC = z;
    }

    public void fG(String str) {
        bF(true);
        Bl().kB();
        if (str != null && str.length() != 0) {
            fI(Cn().getResources().getString(u.j.reply_sub_floor).replace("%s", str));
        } else {
            fI("");
        }
        TiebaStatic.eventStat(Cn().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void fH(String str) {
        bF(true);
        fI(str);
        TiebaStatic.eventStat(Cn().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void Ct() {
        bF(false);
        Bl().hide();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fI(String str) {
        if (Bl() != null) {
            Bl().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    public void fJ(String str) {
        String string = TbadkCoreApplication.m10getInst().getResources().getString(u.j.reply_sub_floor);
        String str2 = "^" + string.replace("%s", ".+") + "$";
        if (ba.isEmpty(this.asU) || this.asU.matches(str2)) {
            if (this.atA != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.atA).lookingAt()) {
                    fH(this.atA);
                    return;
                } else {
                    fG(str);
                    return;
                }
            }
            fG(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.asU);
        this.atA = this.asU;
        if (matcher.lookingAt()) {
            fH(this.asU);
        } else {
            fG(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bE(boolean z) {
        if (Bl() != null) {
            Bl().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(a.d dVar) {
        this.atD = dVar;
    }

    public void a(c cVar) {
        this.atj = cVar;
    }
}
