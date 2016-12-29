package com.baidu.tbadk.editortools.e;

import android.content.Intent;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.ac;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.b;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class p extends com.baidu.tbadk.editortools.f {
    private TbPageContext<?> Gf;
    private String avV;
    private VoiceData.VoiceModel avW;
    private com.baidu.tieba.tbadkCore.writeModel.b avZ;
    private String awA;
    private a<?> awB;
    private boolean awC;
    private b.d awD;
    private AntiData awc;
    private c awj;
    private b.d awp;
    private String awz;
    private String mPostId;

    public p(com.baidu.tbadk.editortools.j jVar) {
        super(jVar);
        this.avV = "";
        this.awz = "";
        this.awA = null;
        this.awC = false;
        this.awp = new q(this);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.Gf = tbPageContext;
    }

    public TbPageContext<?> xz() {
        return this.Gf;
    }

    public String Dv() {
        return this.avV;
    }

    public void fG(String str) {
        this.avV = str;
    }

    public void setReplyId(String str) {
        this.awz = str;
    }

    public void b(a<?> aVar) {
        this.awB = aVar;
        if (aVar != null) {
            this.mPostId = aVar.CX();
        }
    }

    public void f(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.avZ = new com.baidu.tieba.tbadkCore.writeModel.b(tbPageContext);
            this.avZ.b(this.awp);
            ac.b(this.awB.CX(), new r(this));
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
                    if (CB() != null) {
                        CB().hide();
                    }
                    Dy();
                    bJ(true);
                    WriteData bbN = this.avZ.bbN();
                    this.avZ.d((WriteData) null);
                    this.avZ.la(false);
                    if (bbN != null && bbN != null && bbN.getType() == 2) {
                        this.awB.CW();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void Dw() {
        if (this.avZ.bbN() == null) {
            this.avZ.d(this.awB.fB(this.awB.CX()));
        }
        if (this.avZ.bbN() != null) {
            if (this.awj != null) {
                this.awj.CZ();
            }
            if (this.awj != null) {
                this.awj.CZ();
            }
            if (this.awj != null) {
                this.awj.CZ();
            }
            this.avZ.bbN().setContent(this.avV);
            this.avZ.bbN().setReplyId(this.awz);
            if (this.mPostId != null) {
                this.avZ.bbN().setRepostId(this.awB.CX());
            }
            if (this.avW != null) {
                if (this.avW.getId() != null) {
                    this.avZ.bbN().setVoice(this.avW.getId());
                    this.avZ.bbN().setVoiceDuringTime(this.avW.duration);
                } else {
                    this.avZ.bbN().setVoice(null);
                    this.avZ.bbN().setVoiceDuringTime(-1);
                }
            } else {
                this.avZ.bbN().setVoice(null);
                this.avZ.bbN().setVoiceDuringTime(-1);
            }
            if (!this.avZ.bhl()) {
                xz().showToast(r.j.write_img_limit);
                return;
            }
            if (this.awj != null) {
                this.awj.CZ();
            }
            if (!this.avZ.bhi()) {
            }
        }
    }

    public void onDestory() {
        Dx();
        this.avZ.cancelLoadData();
    }

    public void onStop() {
    }

    public void Dx() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.avV);
        writeData.setReplyId(this.awz);
        writeData.setThreadId(this.mPostId);
        ac.d(this.mPostId, writeData);
    }

    public void Dy() {
        ac.c(this.mPostId, (WriteData) null);
    }

    public void k(int i, String str) {
        if (AntiHelper.rp(i)) {
            AntiHelper.S(xz().getPageActivity(), str);
        } else if (i == 230277 || i == 230278) {
            fL(str);
        } else {
            xz().showToast(str);
        }
    }

    public void a(AntiData antiData) {
        this.awc = antiData;
    }

    private void fL(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(xz().getPageActivity());
        aVar.cG(str);
        aVar.b(r.j.know, new s(this));
        aVar.b(xz()).tb();
    }

    private void r(ArrayList<String> arrayList) {
        if (CB() != null) {
            CB().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.avW = voiceModel;
    }

    public boolean Dz() {
        return this.awC;
    }

    public void bK(boolean z) {
        this.awC = z;
    }

    public void fM(String str) {
        bK(true);
        CB().lz();
        if (str != null && str.length() != 0) {
            fO(xz().getResources().getString(r.j.reply_sub_floor).replace("%s", str));
        } else {
            fO("");
        }
        TiebaStatic.eventStat(xz().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void fN(String str) {
        bK(true);
        CB().lz();
        fO(str);
        TiebaStatic.eventStat(xz().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void DA() {
        bK(false);
        CB().hide();
    }

    public void DB() {
        bK(true);
        CB().lz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fO(String str) {
        if (CB() != null) {
            CB().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    public void fP(String str) {
        String string = TbadkCoreApplication.m9getInst().getResources().getString(r.j.reply_sub_floor);
        String str2 = "^" + string.replace("%s", ".+") + "$";
        if (av.isEmpty(this.avV) || this.avV.matches(str2)) {
            if (this.awA != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.awA).lookingAt()) {
                    fN(this.awA);
                    return;
                } else {
                    fM(str);
                    return;
                }
            }
            fM(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.avV);
        this.awA = this.avV;
        if (matcher.lookingAt()) {
            fN(this.avV);
        } else {
            fM(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJ(boolean z) {
        if (CB() != null) {
            CB().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(b.d dVar) {
        this.awD = dVar;
    }

    public void a(c cVar) {
        this.awj = cVar;
    }
}
