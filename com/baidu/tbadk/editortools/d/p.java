package com.baidu.tbadk.editortools.d;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.ae;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.a;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class p extends com.baidu.tbadk.editortools.f {
    private String atY;
    private VoiceData.VoiceModel atZ;
    private String auD;
    private a<?> auE;
    private boolean auF;
    private a.d auG;
    private com.baidu.tieba.tbadkCore.writeModel.a aud;
    private AntiData aug;
    private c aun;
    private a.d aut;
    private TbPageContext<?> mContext;
    private String mPostId;

    public p(com.baidu.tbadk.editortools.k kVar) {
        super(kVar);
        this.atY = "";
        this.auD = null;
        this.auF = false;
        this.aut = new q(this);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public TbPageContext<?> Cm() {
        return this.mContext;
    }

    public String Cn() {
        return this.atY;
    }

    public void fu(String str) {
        this.atY = str;
    }

    public void b(a<?> aVar) {
        this.auE = aVar;
        if (aVar != null) {
            this.mPostId = aVar.BJ();
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.aud = new com.baidu.tieba.tbadkCore.writeModel.a(tbPageContext);
            this.aud.b(this.aut);
            ae.b(this.auE.BJ(), new r(this));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 12005:
                    ArrayList<String> S = com.baidu.tieba.tbadkCore.util.l.S(intent);
                    if (S != null) {
                        r(S);
                        return;
                    }
                    return;
                case 12006:
                    if (Bj() != null) {
                        Bj().hide();
                    }
                    Cq();
                    bp(true);
                    WriteData aGz = this.aud.aGz();
                    this.aud.c((WriteData) null);
                    this.aud.hw(false);
                    if (aGz != null && aGz != null && aGz.getType() == 2) {
                        this.auE.BI();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void Co() {
        if (this.aud.aGz() == null) {
            this.aud.c(this.auE.fp(this.auE.BJ()));
        }
        if (this.aud.aGz() != null) {
            if (this.aun != null) {
                this.aun.BL();
            }
            if (this.aun != null) {
                this.aun.BL();
            }
            if (this.aug != null) {
                if ((!AntiHelper.d(this.aug) && !AntiHelper.e(this.aug) && !AntiHelper.f(this.aug)) || !AntiHelper.a(Cm().getPageActivity(), this.aug, AntiHelper.OperationType.REPLY, PageType.FLOOR_IN_FLOOR)) {
                    if (this.aug != null && this.aug.getIfpost() == 0 && !TextUtils.isEmpty(this.aug.getForbid_info())) {
                        com.baidu.adp.lib.util.k.showToast(this.mContext.getPageActivity(), this.aug.getForbid_info());
                        return;
                    }
                } else {
                    return;
                }
            }
            if (this.aun != null) {
                this.aun.BL();
            }
            this.aud.aGz().setContent(this.atY);
            if (this.mPostId != null) {
                this.aud.aGz().setRepostId(this.auE.BJ());
            }
            if (this.atZ != null) {
                if (this.atZ.getId() != null) {
                    this.aud.aGz().setVoice(this.atZ.getId());
                    this.aud.aGz().setVoiceDuringTime(this.atZ.duration);
                } else {
                    this.aud.aGz().setVoice(null);
                    this.aud.aGz().setVoiceDuringTime(-1);
                }
            } else {
                this.aud.aGz().setVoice(null);
                this.aud.aGz().setVoiceDuringTime(-1);
            }
            if (!this.aud.aGD()) {
                Cm().showToast(n.j.write_img_limit);
                return;
            }
            if (this.aun != null) {
                this.aun.BL();
            }
            if (!this.aud.aGA()) {
            }
        }
    }

    public void onDestory() {
        Cp();
        this.aud.cancelLoadData();
    }

    public void onStop() {
    }

    public void Cp() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.atY);
        writeData.setThreadId(this.mPostId);
        ae.d(this.mPostId, writeData);
    }

    public void Cq() {
        ae.c(this.mPostId, (WriteData) null);
    }

    public void t(int i, String str) {
        if (AntiHelper.ne(i)) {
            AntiHelper.Q(Cm().getPageActivity(), str);
        } else if (i == 230277 || i == 230278) {
            fy(str);
        } else {
            Cm().showToast(str);
        }
    }

    public void a(AntiData antiData) {
        this.aug = antiData;
    }

    private void fy(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(Cm().getPageActivity());
        aVar.cF(str);
        aVar.b(n.j.know, new s(this));
        aVar.b(Cm()).tf();
    }

    private void r(ArrayList<String> arrayList) {
        if (Bj() != null) {
            Bj().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.atZ = voiceModel;
    }

    public boolean Cr() {
        return this.auF;
    }

    public void bq(boolean z) {
        this.auF = z;
    }

    public void fz(String str) {
        bq(true);
        Bj().ob();
        if (str != null && str.length() != 0) {
            fB(Cm().getResources().getString(n.j.reply_sub_floor).replace("%s", str));
        } else {
            fB("");
        }
        TiebaStatic.eventStat(Cm().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void fA(String str) {
        bq(true);
        fB(str);
        TiebaStatic.eventStat(Cm().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void Cs() {
        bq(false);
        Bj().hide();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fB(String str) {
        if (Bj() != null) {
            Bj().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    public void fC(String str) {
        String string = TbadkCoreApplication.m411getInst().getResources().getString(n.j.reply_sub_floor);
        String str2 = "^" + string.replace("%s", ".+") + "$";
        if (ax.isEmpty(this.atY) || this.atY.matches(str2)) {
            if (this.auD != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.auD).lookingAt()) {
                    fA(this.auD);
                    return;
                } else {
                    fz(str);
                    return;
                }
            }
            fz(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.atY);
        this.auD = this.atY;
        if (matcher.lookingAt()) {
            fA(this.atY);
        } else {
            fz(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bp(boolean z) {
        if (Bj() != null) {
            Bj().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(a.d dVar) {
        this.auG = dVar;
    }

    public void a(c cVar) {
        this.aun = cVar;
    }
}
