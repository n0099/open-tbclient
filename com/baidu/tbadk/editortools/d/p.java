package com.baidu.tbadk.editortools.d;

import android.content.Intent;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.ad;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.a;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class p extends com.baidu.tbadk.editortools.f {
    private TbPageContext<?> MX;
    private c avF;
    private a.d avL;
    private String avV;
    private String avW;
    private a<?> avX;
    private boolean avY;
    private a.d avZ;
    private String avq;
    private VoiceData.VoiceModel avr;
    private com.baidu.tieba.tbadkCore.writeModel.a avv;
    private AntiData avy;
    private String mPostId;

    public p(com.baidu.tbadk.editortools.l lVar) {
        super(lVar);
        this.avq = "";
        this.avV = "";
        this.avW = null;
        this.avY = false;
        this.avL = new q(this);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.MX = tbPageContext;
    }

    public TbPageContext<?> Em() {
        return this.MX;
    }

    public String En() {
        return this.avq;
    }

    public void fA(String str) {
        this.avq = str;
    }

    public void setReplyId(String str) {
        this.avV = str;
    }

    public void b(a<?> aVar) {
        this.avX = aVar;
        if (aVar != null) {
            this.mPostId = aVar.DH();
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.avv = new com.baidu.tieba.tbadkCore.writeModel.a(tbPageContext);
            this.avv.b(this.avL);
            ad.b(this.avX.DH(), new r(this));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 12005:
                    ArrayList<String> t = com.baidu.tieba.tbadkCore.util.l.t(intent);
                    if (t != null) {
                        p(t);
                        return;
                    }
                    return;
                case 12006:
                    if (Dh() != null) {
                        Dh().hide();
                    }
                    Eq();
                    bw(true);
                    WriteData aUF = this.avv.aUF();
                    this.avv.d((WriteData) null);
                    this.avv.iN(false);
                    if (aUF != null && aUF != null && aUF.getType() == 2) {
                        this.avX.DG();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void Eo() {
        if (this.avv.aUF() == null) {
            this.avv.d(this.avX.fv(this.avX.DH()));
        }
        if (this.avv.aUF() != null) {
            if (this.avF != null) {
                this.avF.DJ();
            }
            if (this.avF != null) {
                this.avF.DJ();
            }
            if (this.avF != null) {
                this.avF.DJ();
            }
            this.avv.aUF().setContent(this.avq);
            this.avv.aUF().setReplyId(this.avV);
            if (this.mPostId != null) {
                this.avv.aUF().setRepostId(this.avX.DH());
            }
            if (this.avr != null) {
                if (this.avr.getId() != null) {
                    this.avv.aUF().setVoice(this.avr.getId());
                    this.avv.aUF().setVoiceDuringTime(this.avr.duration);
                } else {
                    this.avv.aUF().setVoice(null);
                    this.avv.aUF().setVoiceDuringTime(-1);
                }
            } else {
                this.avv.aUF().setVoice(null);
                this.avv.aUF().setVoiceDuringTime(-1);
            }
            if (!this.avv.aUJ()) {
                Em().showToast(t.j.write_img_limit);
                return;
            }
            if (this.avF != null) {
                this.avF.DJ();
            }
            if (!this.avv.aUG()) {
            }
        }
    }

    public void onDestory() {
        Ep();
        this.avv.cancelLoadData();
    }

    public void onStop() {
    }

    public void Ep() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.avq);
        writeData.setReplyId(this.avV);
        writeData.setThreadId(this.mPostId);
        ad.d(this.mPostId, writeData);
    }

    public void Eq() {
        ad.c(this.mPostId, (WriteData) null);
    }

    public void l(int i, String str) {
        if (AntiHelper.pB(i)) {
            AntiHelper.O(Em().getPageActivity(), str);
        } else if (i == 230277 || i == 230278) {
            fE(str);
        } else {
            Em().showToast(str);
        }
    }

    public void a(AntiData antiData) {
        this.avy = antiData;
    }

    private void fE(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(Em().getPageActivity());
        aVar.cC(str);
        aVar.b(t.j.know, new s(this));
        aVar.b(Em()).up();
    }

    private void p(ArrayList<String> arrayList) {
        if (Dh() != null) {
            Dh().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.avr = voiceModel;
    }

    public boolean Er() {
        return this.avY;
    }

    public void bx(boolean z) {
        this.avY = z;
    }

    public void fF(String str) {
        bx(true);
        Dh().op();
        if (str != null && str.length() != 0) {
            fH(Em().getResources().getString(t.j.reply_sub_floor).replace("%s", str));
        } else {
            fH("");
        }
        TiebaStatic.eventStat(Em().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void fG(String str) {
        bx(true);
        fH(str);
        TiebaStatic.eventStat(Em().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void Es() {
        bx(false);
        Dh().hide();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fH(String str) {
        if (Dh() != null) {
            Dh().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    public void fI(String str) {
        String string = TbadkCoreApplication.m411getInst().getResources().getString(t.j.reply_sub_floor);
        String str2 = "^" + string.replace("%s", ".+") + "$";
        if (ay.isEmpty(this.avq) || this.avq.matches(str2)) {
            if (this.avW != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.avW).lookingAt()) {
                    fG(this.avW);
                    return;
                } else {
                    fF(str);
                    return;
                }
            }
            fF(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.avq);
        this.avW = this.avq;
        if (matcher.lookingAt()) {
            fG(this.avq);
        } else {
            fF(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bw(boolean z) {
        if (Dh() != null) {
            Dh().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(a.d dVar) {
        this.avZ = dVar;
    }

    public void a(c cVar) {
        this.avF = cVar;
    }
}
