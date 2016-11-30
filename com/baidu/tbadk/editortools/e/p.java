package com.baidu.tbadk.editortools.e;

import android.content.Intent;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.ad;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.b;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class p extends com.baidu.tbadk.editortools.f {
    private TbPageContext<?> Gf;
    private com.baidu.tieba.tbadkCore.writeModel.b awC;
    private AntiData awF;
    private c awM;
    private b.d awS;
    private String awy;
    private VoiceData.VoiceModel awz;
    private String axc;
    private String axd;
    private a<?> axe;
    private boolean axf;
    private b.d axg;
    private String mPostId;

    public p(com.baidu.tbadk.editortools.l lVar) {
        super(lVar);
        this.awy = "";
        this.axc = "";
        this.axd = null;
        this.axf = false;
        this.awS = new q(this);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.Gf = tbPageContext;
    }

    public TbPageContext<?> xL() {
        return this.Gf;
    }

    public String DN() {
        return this.awy;
    }

    public void fK(String str) {
        this.awy = str;
    }

    public void setReplyId(String str) {
        this.axc = str;
    }

    public void b(a<?> aVar) {
        this.axe = aVar;
        if (aVar != null) {
            this.mPostId = aVar.Do();
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.awC = new com.baidu.tieba.tbadkCore.writeModel.b(tbPageContext);
            this.awC.b(this.awS);
            ad.b(this.axe.Do(), new r(this));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        if (i2 == -1) {
            switch (i) {
                case 12005:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra(IntentConfig.NAME_SHOW)) != null) {
                        r(stringArrayListExtra);
                        return;
                    }
                    return;
                case 12006:
                    if (CO() != null) {
                        CO().hide();
                    }
                    DQ();
                    bJ(true);
                    WriteData bia = this.awC.bia();
                    this.awC.d((WriteData) null);
                    this.awC.lp(false);
                    if (bia != null && bia != null && bia.getType() == 2) {
                        this.axe.Dn();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void DO() {
        if (this.awC.bia() == null) {
            this.awC.d(this.axe.fF(this.axe.Do()));
        }
        if (this.awC.bia() != null) {
            if (this.awM != null) {
                this.awM.Dq();
            }
            if (this.awM != null) {
                this.awM.Dq();
            }
            if (this.awM != null) {
                this.awM.Dq();
            }
            this.awC.bia().setContent(this.awy);
            this.awC.bia().setReplyId(this.axc);
            if (this.mPostId != null) {
                this.awC.bia().setRepostId(this.axe.Do());
            }
            if (this.awz != null) {
                if (this.awz.getId() != null) {
                    this.awC.bia().setVoice(this.awz.getId());
                    this.awC.bia().setVoiceDuringTime(this.awz.duration);
                } else {
                    this.awC.bia().setVoice(null);
                    this.awC.bia().setVoiceDuringTime(-1);
                }
            } else {
                this.awC.bia().setVoice(null);
                this.awC.bia().setVoiceDuringTime(-1);
            }
            if (!this.awC.bnr()) {
                xL().showToast(r.j.write_img_limit);
                return;
            }
            if (this.awM != null) {
                this.awM.Dq();
            }
            if (!this.awC.bno()) {
            }
        }
    }

    public void onDestory() {
        DP();
        this.awC.cancelLoadData();
    }

    public void onStop() {
    }

    public void DP() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.awy);
        writeData.setReplyId(this.axc);
        writeData.setThreadId(this.mPostId);
        ad.d(this.mPostId, writeData);
    }

    public void DQ() {
        ad.c(this.mPostId, (WriteData) null);
    }

    public void k(int i, String str) {
        if (AntiHelper.sm(i)) {
            AntiHelper.S(xL().getPageActivity(), str);
        } else if (i == 230277 || i == 230278) {
            fP(str);
        } else {
            xL().showToast(str);
        }
    }

    public void a(AntiData antiData) {
        this.awF = antiData;
    }

    private void fP(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(xL().getPageActivity());
        aVar.cF(str);
        aVar.b(r.j.know, new s(this));
        aVar.b(xL()).tq();
    }

    private void r(ArrayList<String> arrayList) {
        if (CO() != null) {
            CO().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.awz = voiceModel;
    }

    public boolean DR() {
        return this.axf;
    }

    public void bK(boolean z) {
        this.axf = z;
    }

    public void fQ(String str) {
        bK(true);
        CO().lz();
        if (str != null && str.length() != 0) {
            fS(xL().getResources().getString(r.j.reply_sub_floor).replace("%s", str));
        } else {
            fS("");
        }
        TiebaStatic.eventStat(xL().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void fR(String str) {
        bK(true);
        CO().lz();
        fS(str);
        TiebaStatic.eventStat(xL().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void DS() {
        bK(false);
        CO().hide();
    }

    public void DT() {
        bK(true);
        CO().lz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fS(String str) {
        if (CO() != null) {
            CO().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    public void fT(String str) {
        String string = TbadkCoreApplication.m9getInst().getResources().getString(r.j.reply_sub_floor);
        String str2 = "^" + string.replace("%s", ".+") + "$";
        if (ax.isEmpty(this.awy) || this.awy.matches(str2)) {
            if (this.axd != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.axd).lookingAt()) {
                    fR(this.axd);
                    return;
                } else {
                    fQ(str);
                    return;
                }
            }
            fQ(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.awy);
        this.axd = this.awy;
        if (matcher.lookingAt()) {
            fR(this.awy);
        } else {
            fQ(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJ(boolean z) {
        if (CO() != null) {
            CO().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(b.d dVar) {
        this.axg = dVar;
    }

    public void a(c cVar) {
        this.awM = cVar;
    }
}
