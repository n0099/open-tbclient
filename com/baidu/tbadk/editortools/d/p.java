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
import com.baidu.tieba.tbadkCore.ae;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.a;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class p extends com.baidu.tbadk.editortools.f {
    private TbPageContext<?> Do;
    private c arE;
    private a.d arK;
    private String arU;
    private String arV;
    private a<?> arW;
    private boolean arX;
    private a.d arY;
    private String arp;
    private VoiceData.VoiceModel arq;
    private com.baidu.tieba.tbadkCore.writeModel.a aru;
    private AntiData arx;
    private String mPostId;

    public p(com.baidu.tbadk.editortools.l lVar) {
        super(lVar);
        this.arp = "";
        this.arU = "";
        this.arV = null;
        this.arX = false;
        this.arK = new q(this);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.Do = tbPageContext;
    }

    public TbPageContext<?> Cg() {
        return this.Do;
    }

    public String Ch() {
        return this.arp;
    }

    public void fx(String str) {
        this.arp = str;
    }

    public void setReplyId(String str) {
        this.arU = str;
    }

    public void b(a<?> aVar) {
        this.arW = aVar;
        if (aVar != null) {
            this.mPostId = aVar.BC();
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.aru = new com.baidu.tieba.tbadkCore.writeModel.a(tbPageContext);
            this.aru.b(this.arK);
            ae.b(this.arW.BC(), new r(this));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 12005:
                    ArrayList<String> v = com.baidu.tieba.tbadkCore.util.l.v(intent);
                    if (v != null) {
                        p(v);
                        return;
                    }
                    return;
                case 12006:
                    if (Bc() != null) {
                        Bc().hide();
                    }
                    Ck();
                    bC(true);
                    WriteData aVg = this.aru.aVg();
                    this.aru.d((WriteData) null);
                    this.aru.jC(false);
                    if (aVg != null && aVg != null && aVg.getType() == 2) {
                        this.arW.BB();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void Ci() {
        if (this.aru.aVg() == null) {
            this.aru.d(this.arW.fs(this.arW.BC()));
        }
        if (this.aru.aVg() != null) {
            if (this.arE != null) {
                this.arE.BE();
            }
            if (this.arE != null) {
                this.arE.BE();
            }
            if (this.arE != null) {
                this.arE.BE();
            }
            this.aru.aVg().setContent(this.arp);
            this.aru.aVg().setReplyId(this.arU);
            if (this.mPostId != null) {
                this.aru.aVg().setRepostId(this.arW.BC());
            }
            if (this.arq != null) {
                if (this.arq.getId() != null) {
                    this.aru.aVg().setVoice(this.arq.getId());
                    this.aru.aVg().setVoiceDuringTime(this.arq.duration);
                } else {
                    this.aru.aVg().setVoice(null);
                    this.aru.aVg().setVoiceDuringTime(-1);
                }
            } else {
                this.aru.aVg().setVoice(null);
                this.aru.aVg().setVoiceDuringTime(-1);
            }
            if (!this.aru.aVk()) {
                Cg().showToast(t.j.write_img_limit);
                return;
            }
            if (this.arE != null) {
                this.arE.BE();
            }
            if (!this.aru.aVh()) {
            }
        }
    }

    public void onDestory() {
        Cj();
        this.aru.cancelLoadData();
    }

    public void onStop() {
    }

    public void Cj() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.arp);
        writeData.setReplyId(this.arU);
        writeData.setThreadId(this.mPostId);
        ae.d(this.mPostId, writeData);
    }

    public void Ck() {
        ae.c(this.mPostId, (WriteData) null);
    }

    public void l(int i, String str) {
        if (AntiHelper.pv(i)) {
            AntiHelper.O(Cg().getPageActivity(), str);
        } else if (i == 230277 || i == 230278) {
            fB(str);
        } else {
            Cg().showToast(str);
        }
    }

    public void a(AntiData antiData) {
        this.arx = antiData;
    }

    private void fB(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(Cg().getPageActivity());
        aVar.cA(str);
        aVar.b(t.j.know, new s(this));
        aVar.b(Cg()).rV();
    }

    private void p(ArrayList<String> arrayList) {
        if (Bc() != null) {
            Bc().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.arq = voiceModel;
    }

    public boolean Cl() {
        return this.arX;
    }

    public void bD(boolean z) {
        this.arX = z;
    }

    public void fC(String str) {
        bD(true);
        Bc().kC();
        if (str != null && str.length() != 0) {
            fE(Cg().getResources().getString(t.j.reply_sub_floor).replace("%s", str));
        } else {
            fE("");
        }
        TiebaStatic.eventStat(Cg().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void fD(String str) {
        bD(true);
        fE(str);
        TiebaStatic.eventStat(Cg().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void Cm() {
        bD(false);
        Bc().hide();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fE(String str) {
        if (Bc() != null) {
            Bc().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    public void fF(String str) {
        String string = TbadkCoreApplication.m11getInst().getResources().getString(t.j.reply_sub_floor);
        String str2 = "^" + string.replace("%s", ".+") + "$";
        if (ay.isEmpty(this.arp) || this.arp.matches(str2)) {
            if (this.arV != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.arV).lookingAt()) {
                    fD(this.arV);
                    return;
                } else {
                    fC(str);
                    return;
                }
            }
            fC(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.arp);
        this.arV = this.arp;
        if (matcher.lookingAt()) {
            fD(this.arp);
        } else {
            fC(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bC(boolean z) {
        if (Bc() != null) {
            Bc().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(a.d dVar) {
        this.arY = dVar;
    }

    public void a(c cVar) {
        this.arE = cVar;
    }
}
