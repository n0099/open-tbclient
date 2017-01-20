package com.baidu.tbadk.editortools.pb;

import android.content.Intent;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.aa;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class n extends com.baidu.tbadk.editortools.f {
    private TbPageContext<?> Fp;
    private String avD;
    private String avE;
    private DataModel<?> avF;
    private boolean avG;
    private NewWriteModel.d avH;
    private String ava;
    private VoiceData.VoiceModel avb;
    private NewWriteModel ave;
    private AntiData avh;
    private b avn;
    private NewWriteModel.d avt;
    private String mPostId;

    public n(com.baidu.tbadk.editortools.j jVar) {
        super(jVar);
        this.ava = "";
        this.avD = "";
        this.avE = null;
        this.avG = false;
        this.avt = new o(this);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.Fp = tbPageContext;
    }

    public TbPageContext<?> xv() {
        return this.Fp;
    }

    public String Dq() {
        return this.ava;
    }

    public void fD(String str) {
        this.ava = str;
    }

    public void setReplyId(String str) {
        this.avD = str;
    }

    public void b(DataModel<?> dataModel) {
        this.avF = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.CS();
        }
    }

    public void f(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.ave = new NewWriteModel(tbPageContext);
            this.ave.b(this.avt);
            aa.b(this.avF.CS(), new p(this));
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
                    if (Cw() != null) {
                        Cw().hide();
                    }
                    Dt();
                    bJ(true);
                    WriteData writeData = this.ave.getWriteData();
                    this.ave.setWriteData(null);
                    this.ave.lm(false);
                    if (writeData != null && writeData != null && writeData.getType() == 2) {
                        this.avF.CR();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void Dr() {
        if (this.ave.getWriteData() == null) {
            this.ave.setWriteData(this.avF.fy(this.avF.CS()));
        }
        if (this.ave.getWriteData() != null) {
            if (this.avn != null) {
                this.avn.CU();
            }
            if (this.avn != null) {
                this.avn.CU();
            }
            if (this.avn != null) {
                this.avn.CU();
            }
            this.ave.getWriteData().setContent(this.ava);
            this.ave.getWriteData().setReplyId(this.avD);
            if (this.mPostId != null) {
                this.ave.getWriteData().setRepostId(this.avF.CS());
            }
            if (this.avb != null) {
                if (this.avb.getId() != null) {
                    this.ave.getWriteData().setVoice(this.avb.getId());
                    this.ave.getWriteData().setVoiceDuringTime(this.avb.duration);
                } else {
                    this.ave.getWriteData().setVoice(null);
                    this.ave.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.ave.getWriteData().setVoice(null);
                this.ave.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.ave.biT()) {
                xv().showToast(r.l.write_img_limit);
                return;
            }
            if (this.avn != null) {
                this.avn.CU();
            }
            if (!this.ave.startPostWrite()) {
            }
        }
    }

    public void onDestory() {
        Ds();
        this.ave.cancelLoadData();
    }

    public void onStop() {
    }

    public void Ds() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.ava);
        writeData.setReplyId(this.avD);
        writeData.setThreadId(this.mPostId);
        aa.d(this.mPostId, writeData);
    }

    public void Dt() {
        aa.c(this.mPostId, (WriteData) null);
    }

    public void k(int i, String str) {
        if (AntiHelper.sa(i)) {
            AntiHelper.T(xv().getPageActivity(), str);
        } else if (i == 230277 || i == 230278) {
            fI(str);
        } else {
            xv().showToast(str);
        }
    }

    public void a(AntiData antiData) {
        this.avh = antiData;
    }

    private void fI(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(xv().getPageActivity());
        aVar.cE(str);
        aVar.b(r.l.know, new q(this));
        aVar.b(xv()).sV();
    }

    private void r(ArrayList<String> arrayList) {
        if (Cw() != null) {
            Cw().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.avb = voiceModel;
    }

    public boolean Du() {
        return this.avG;
    }

    public void bK(boolean z) {
        this.avG = z;
    }

    public void fJ(String str) {
        bK(true);
        Cw().lr();
        if (str != null && str.length() != 0) {
            fL(xv().getResources().getString(r.l.reply_sub_floor).replace("%s", str));
        } else {
            fL("");
        }
        TiebaStatic.eventStat(xv().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void fK(String str) {
        bK(true);
        Cw().lr();
        fL(str);
        TiebaStatic.eventStat(xv().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void Dv() {
        bK(false);
        Cw().hide();
    }

    public void Dw() {
        bK(true);
        Cw().lr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fL(String str) {
        if (Cw() != null) {
            Cw().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    public void fM(String str) {
        String string = TbadkCoreApplication.m9getInst().getResources().getString(r.l.reply_sub_floor);
        String str2 = "^" + string.replace("%s", ".+") + "$";
        if (at.isEmpty(this.ava) || this.ava.matches(str2)) {
            if (this.avE != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.avE).lookingAt()) {
                    fK(this.avE);
                    return;
                } else {
                    fJ(str);
                    return;
                }
            }
            fJ(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.ava);
        this.avE = this.ava;
        if (matcher.lookingAt()) {
            fK(this.ava);
        } else {
            fJ(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJ(boolean z) {
        if (Cw() != null) {
            Cw().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.avH = dVar;
    }

    public void a(b bVar) {
        this.avn = bVar;
    }
}
