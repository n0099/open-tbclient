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
    private String aAL;
    private VoiceData.VoiceModel aAM;
    private NewWriteModel aAP;
    private AntiData aAS;
    private b aAY;
    private NewWriteModel.d aBf;
    private String aBp;
    private String aBq;
    private DataModel<?> aBr;
    private boolean aBs;
    private NewWriteModel.d aBt;
    private TbPageContext<?> aat;
    private String mPostId;

    public n(com.baidu.tbadk.editortools.j jVar) {
        super(jVar);
        this.aAL = "";
        this.aBp = "";
        this.aBq = null;
        this.aBs = false;
        this.aBf = new o(this);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.aat = tbPageContext;
    }

    public TbPageContext<?> xD() {
        return this.aat;
    }

    public String Dl() {
        return this.aAL;
    }

    public void fv(String str) {
        this.aAL = str;
    }

    public void setReplyId(String str) {
        this.aBp = str;
    }

    public void b(DataModel<?> dataModel) {
        this.aBr = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.CN();
        }
    }

    public void f(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.aAP = new NewWriteModel(tbPageContext);
            this.aAP.b(this.aBf);
            x.b(this.aBr.CN(), new p(this));
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
                    if (Cs() != null) {
                        Cs().hide();
                    }
                    Do();
                    bL(true);
                    WriteData writeData = this.aAP.getWriteData();
                    this.aAP.setWriteData(null);
                    this.aAP.lc(false);
                    if (writeData != null && writeData != null && writeData.getType() == 2) {
                        this.aBr.CM();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void Dm() {
        if (this.aAP.getWriteData() == null) {
            this.aAP.setWriteData(this.aBr.fq(this.aBr.CN()));
        }
        if (this.aAP.getWriteData() != null) {
            if (this.aAY != null) {
                this.aAY.CP();
            }
            if (this.aAY != null) {
                this.aAY.CP();
            }
            if (this.aAY != null) {
                this.aAY.CP();
            }
            this.aAP.getWriteData().setContent(this.aAL);
            this.aAP.getWriteData().setReplyId(this.aBp);
            if (this.mPostId != null) {
                this.aAP.getWriteData().setRepostId(this.aBr.CN());
            }
            if (this.aAM != null) {
                if (this.aAM.getId() != null) {
                    this.aAP.getWriteData().setVoice(this.aAM.getId());
                    this.aAP.getWriteData().setVoiceDuringTime(this.aAM.duration);
                } else {
                    this.aAP.getWriteData().setVoice(null);
                    this.aAP.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.aAP.getWriteData().setVoice(null);
                this.aAP.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.aAP.bhS()) {
                xD().showToast(w.l.write_img_limit);
                return;
            }
            if (this.aAY != null) {
                this.aAY.CP();
            }
            if (!this.aAP.startPostWrite()) {
            }
        }
    }

    public void onDestory() {
        Dn();
        this.aAP.cancelLoadData();
    }

    public void onStop() {
    }

    public void Dn() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.aAL);
        writeData.setReplyId(this.aBp);
        writeData.setThreadId(this.mPostId);
        x.d(this.mPostId, writeData);
    }

    public void Do() {
        x.c(this.mPostId, (WriteData) null);
    }

    public void m(int i, String str) {
        if (AntiHelper.rV(i)) {
            AntiHelper.aq(xD().getPageActivity(), str);
        } else if (i == 230277 || i == 230278) {
            fA(str);
        } else {
            xD().showToast(str);
        }
    }

    public void a(AntiData antiData) {
        this.aAS = antiData;
    }

    private void fA(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(xD().getPageActivity());
        aVar.cC(str);
        aVar.b(w.l.know, new q(this));
        aVar.b(xD()).td();
    }

    private void q(ArrayList<String> arrayList) {
        if (Cs() != null) {
            Cs().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.aAM = voiceModel;
    }

    public boolean Dp() {
        return this.aBs;
    }

    public void bM(boolean z) {
        this.aBs = z;
    }

    public void fB(String str) {
        bM(true);
        Cs().lW();
        if (str != null && str.length() != 0) {
            fD(xD().getResources().getString(w.l.reply_sub_floor).replace("%s", str));
        } else {
            fD("");
        }
        TiebaStatic.eventStat(xD().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void fC(String str) {
        bM(true);
        Cs().lW();
        fD(str);
        TiebaStatic.eventStat(xD().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void Dq() {
        bM(false);
        Cs().hide();
    }

    public void Dr() {
        bM(true);
        Cs().lW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fD(String str) {
        if (Cs() != null) {
            Cs().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    public void fE(String str) {
        String string = TbadkCoreApplication.m9getInst().getResources().getString(w.l.reply_sub_floor);
        String str2 = "^" + string.replace("%s", ".+") + "$";
        if (au.isEmpty(this.aAL) || this.aAL.matches(str2)) {
            if (this.aBq != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.aBq).lookingAt()) {
                    fC(this.aBq);
                    return;
                } else {
                    fB(str);
                    return;
                }
            }
            fB(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.aAL);
        this.aBq = this.aAL;
        if (matcher.lookingAt()) {
            fC(this.aAL);
        } else {
            fB(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bL(boolean z) {
        if (Cs() != null) {
            Cs().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.aBt = dVar;
    }

    public void a(b bVar) {
        this.aAY = bVar;
    }
}
