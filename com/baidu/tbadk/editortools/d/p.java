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
    private TbPageContext<?> Dp;
    private a.d asA;
    private String asK;
    private String asL;
    private a<?> asM;
    private boolean asN;
    private a.d asO;
    private String asf;
    private VoiceData.VoiceModel asg;
    private com.baidu.tieba.tbadkCore.writeModel.a ask;
    private AntiData asn;
    private c asu;
    private String mPostId;

    public p(com.baidu.tbadk.editortools.l lVar) {
        super(lVar);
        this.asf = "";
        this.asK = "";
        this.asL = null;
        this.asN = false;
        this.asA = new q(this);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.Dp = tbPageContext;
    }

    public TbPageContext<?> Co() {
        return this.Dp;
    }

    public String Cp() {
        return this.asf;
    }

    public void fD(String str) {
        this.asf = str;
    }

    public void setReplyId(String str) {
        this.asK = str;
    }

    public void b(a<?> aVar) {
        this.asM = aVar;
        if (aVar != null) {
            this.mPostId = aVar.BL();
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.ask = new com.baidu.tieba.tbadkCore.writeModel.a(tbPageContext);
            this.ask.b(this.asA);
            af.b(this.asM.BL(), new r(this));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 12005:
                    ArrayList<String> y = com.baidu.tieba.tbadkCore.util.l.y(intent);
                    if (y != null) {
                        p(y);
                        return;
                    }
                    return;
                case 12006:
                    if (Bl() != null) {
                        Bl().hide();
                    }
                    Cs();
                    bB(true);
                    WriteData bdu = this.ask.bdu();
                    this.ask.d((WriteData) null);
                    this.ask.kn(false);
                    if (bdu != null && bdu != null && bdu.getType() == 2) {
                        this.asM.BK();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void Cq() {
        if (this.ask.bdu() == null) {
            this.ask.d(this.asM.fy(this.asM.BL()));
        }
        if (this.ask.bdu() != null) {
            if (this.asu != null) {
                this.asu.BN();
            }
            if (this.asu != null) {
                this.asu.BN();
            }
            if (this.asu != null) {
                this.asu.BN();
            }
            this.ask.bdu().setContent(this.asf);
            this.ask.bdu().setReplyId(this.asK);
            if (this.mPostId != null) {
                this.ask.bdu().setRepostId(this.asM.BL());
            }
            if (this.asg != null) {
                if (this.asg.getId() != null) {
                    this.ask.bdu().setVoice(this.asg.getId());
                    this.ask.bdu().setVoiceDuringTime(this.asg.duration);
                } else {
                    this.ask.bdu().setVoice(null);
                    this.ask.bdu().setVoiceDuringTime(-1);
                }
            } else {
                this.ask.bdu().setVoice(null);
                this.ask.bdu().setVoiceDuringTime(-1);
            }
            if (!this.ask.bdy()) {
                Co().showToast(u.j.write_img_limit);
                return;
            }
            if (this.asu != null) {
                this.asu.BN();
            }
            if (!this.ask.bdv()) {
            }
        }
    }

    public void onDestory() {
        Cr();
        this.ask.cancelLoadData();
    }

    public void onStop() {
    }

    public void Cr() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.asf);
        writeData.setReplyId(this.asK);
        writeData.setThreadId(this.mPostId);
        af.d(this.mPostId, writeData);
    }

    public void Cs() {
        af.c(this.mPostId, (WriteData) null);
    }

    public void l(int i, String str) {
        if (AntiHelper.qL(i)) {
            AntiHelper.O(Co().getPageActivity(), str);
        } else if (i == 230277 || i == 230278) {
            fH(str);
        } else {
            Co().showToast(str);
        }
    }

    public void a(AntiData antiData) {
        this.asn = antiData;
    }

    private void fH(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(Co().getPageActivity());
        aVar.cz(str);
        aVar.b(u.j.know, new s(this));
        aVar.b(Co()).rT();
    }

    private void p(ArrayList<String> arrayList) {
        if (Bl() != null) {
            Bl().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.asg = voiceModel;
    }

    public boolean Ct() {
        return this.asN;
    }

    public void bC(boolean z) {
        this.asN = z;
    }

    public void fI(String str) {
        bC(true);
        Bl().kF();
        if (str != null && str.length() != 0) {
            fK(Co().getResources().getString(u.j.reply_sub_floor).replace("%s", str));
        } else {
            fK("");
        }
        TiebaStatic.eventStat(Co().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void fJ(String str) {
        bC(true);
        fK(str);
        TiebaStatic.eventStat(Co().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void Cu() {
        bC(false);
        Bl().hide();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fK(String str) {
        if (Bl() != null) {
            Bl().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    public void fL(String str) {
        String string = TbadkCoreApplication.m9getInst().getResources().getString(u.j.reply_sub_floor);
        String str2 = "^" + string.replace("%s", ".+") + "$";
        if (ba.isEmpty(this.asf) || this.asf.matches(str2)) {
            if (this.asL != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.asL).lookingAt()) {
                    fJ(this.asL);
                    return;
                } else {
                    fI(str);
                    return;
                }
            }
            fI(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.asf);
        this.asL = this.asf;
        if (matcher.lookingAt()) {
            fJ(this.asf);
        } else {
            fI(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bB(boolean z) {
        if (Bl() != null) {
            Bl().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(a.d dVar) {
        this.asO = dVar;
    }

    public void a(c cVar) {
        this.asu = cVar;
    }
}
