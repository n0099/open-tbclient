package com.baidu.tbadk.editortools.pb;

import android.content.Intent;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.x;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class n extends com.baidu.tbadk.editortools.f {
    private NewWriteModel aAB;
    private AntiData aAE;
    private b aAK;
    private NewWriteModel.d aAR;
    private String aAx;
    private VoiceData.VoiceModel aAy;
    private String aBb;
    private String aBc;
    private DataModel<?> aBd;
    private boolean aBe;
    private NewWriteModel.d aBf;
    private TbPageContext<?> aas;
    private String mPostId;

    public n(com.baidu.tbadk.editortools.j jVar) {
        super(jVar);
        this.aAx = "";
        this.aBb = "";
        this.aBc = null;
        this.aBe = false;
        this.aAR = new o(this);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.aas = tbPageContext;
    }

    public TbPageContext<?> xw() {
        return this.aas;
    }

    public String Df() {
        return this.aAx;
    }

    public void ft(String str) {
        this.aAx = str;
    }

    public void setReplyId(String str) {
        this.aBb = str;
    }

    public void b(DataModel<?> dataModel) {
        this.aBd = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.CH();
        }
    }

    public void f(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.aAB = new NewWriteModel(tbPageContext);
            this.aAB.b(this.aAR);
            x.b(this.aBd.CH(), new p(this));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        if (i2 == -1) {
            switch (i) {
                case 12005:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra(IntentConfig.NAME_SHOW)) != null) {
                        q(stringArrayListExtra);
                        return;
                    }
                    return;
                case 12006:
                    if (Cm() != null) {
                        Cm().hide();
                    }
                    Di();
                    bI(true);
                    WriteData writeData = this.aAB.getWriteData();
                    this.aAB.setWriteData(null);
                    this.aAB.lx(false);
                    if (writeData != null && writeData != null && writeData.getType() == 2) {
                        this.aBd.CG();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void Dg() {
        if (this.aAB.getWriteData() == null) {
            this.aAB.setWriteData(this.aBd.fo(this.aBd.CH()));
        }
        if (this.aAB.getWriteData() != null) {
            if (this.aAK != null) {
                this.aAK.CJ();
            }
            if (this.aAK != null) {
                this.aAK.CJ();
            }
            if (this.aAK != null) {
                this.aAK.CJ();
            }
            this.aAB.getWriteData().setContent(this.aAx);
            this.aAB.getWriteData().setReplyId(this.aBb);
            if (this.mPostId != null) {
                this.aAB.getWriteData().setRepostId(this.aBd.CH());
            }
            if (this.aAy != null) {
                if (this.aAy.getId() != null) {
                    this.aAB.getWriteData().setVoice(this.aAy.getId());
                    this.aAB.getWriteData().setVoiceDuringTime(this.aAy.duration);
                } else {
                    this.aAB.getWriteData().setVoice(null);
                    this.aAB.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.aAB.getWriteData().setVoice(null);
                this.aAB.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.aAB.bjm()) {
                xw().showToast(w.l.write_img_limit);
                return;
            }
            if (this.aAK != null) {
                this.aAK.CJ();
            }
            if (!this.aAB.startPostWrite()) {
            }
        }
    }

    public void onDestory() {
        Dh();
        this.aAB.cancelLoadData();
    }

    public void onStop() {
    }

    public void Dh() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.aAx);
        writeData.setReplyId(this.aBb);
        writeData.setThreadId(this.mPostId);
        x.d(this.mPostId, writeData);
    }

    public void Di() {
        x.c(this.mPostId, (WriteData) null);
    }

    public void m(int i, String str) {
        if (AntiHelper.sr(i)) {
            AntiHelper.ap(xw().getPageActivity(), str);
        } else if (i == 230277 || i == 230278) {
            fy(str);
        } else {
            xw().showToast(str);
        }
    }

    public void a(AntiData antiData) {
        this.aAE = antiData;
    }

    private void fy(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(xw().getPageActivity());
        aVar.cB(str);
        aVar.b(w.l.know, new q(this));
        aVar.b(xw()).tc();
    }

    private void q(ArrayList<String> arrayList) {
        if (Cm() != null) {
            Cm().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.aAy = voiceModel;
    }

    public boolean Dj() {
        return this.aBe;
    }

    public void bJ(boolean z) {
        this.aBe = z;
    }

    public void fz(String str) {
        bJ(true);
        Cm().lO();
        if (str != null && str.length() != 0) {
            fB(xw().getResources().getString(w.l.reply_sub_floor).replace("%s", str));
        } else {
            fB("");
        }
        TiebaStatic.eventStat(xw().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void fA(String str) {
        bJ(true);
        Cm().lO();
        fB(str);
        TiebaStatic.eventStat(xw().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void Dk() {
        bJ(false);
        Cm().hide();
    }

    public void Dl() {
        bJ(true);
        Cm().lO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fB(String str) {
        if (Cm() != null) {
            Cm().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    public void fC(String str) {
        String string = TbadkCoreApplication.m9getInst().getResources().getString(w.l.reply_sub_floor);
        String str2 = "^" + string.replace("%s", ".+") + "$";
        if (au.isEmpty(this.aAx) || this.aAx.matches(str2)) {
            if (this.aBc != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.aBc).lookingAt()) {
                    fA(this.aBc);
                    return;
                } else {
                    fz(str);
                    return;
                }
            }
            fz(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.aAx);
        this.aBc = this.aAx;
        if (matcher.lookingAt()) {
            fA(this.aAx);
        } else {
            fz(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bI(boolean z) {
        if (Cm() != null) {
            Cm().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.aBf = dVar;
    }

    public void a(b bVar) {
        this.aAK = bVar;
    }
}
