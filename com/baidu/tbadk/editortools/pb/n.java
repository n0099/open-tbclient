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
import com.baidu.tieba.tbadkCore.z;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class n extends com.baidu.tbadk.editortools.f {
    private String aAN;
    private VoiceData.VoiceModel aAO;
    private NewWriteModel aAR;
    private AntiData aAU;
    private b aBa;
    private NewWriteModel.d aBg;
    private String aBq;
    private String aBr;
    private DataModel<?> aBs;
    private boolean aBt;
    private NewWriteModel.d aBu;
    private TbPageContext<?> aaY;
    private String mPostId;

    public n(com.baidu.tbadk.editortools.j jVar) {
        super(jVar);
        this.aAN = "";
        this.aBq = "";
        this.aBr = null;
        this.aBt = false;
        this.aBg = new o(this);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.aaY = tbPageContext;
    }

    public TbPageContext<?> yp() {
        return this.aaY;
    }

    public String Eh() {
        return this.aAN;
    }

    public void fy(String str) {
        this.aAN = str;
    }

    public void setReplyId(String str) {
        this.aBq = str;
    }

    public void b(DataModel<?> dataModel) {
        this.aBs = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.DJ();
        }
    }

    public void f(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.aAR = new NewWriteModel(tbPageContext);
            this.aAR.b(this.aBg);
            z.b(this.aBs.DJ(), new p(this));
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
                    if (Dn() != null) {
                        Dn().hide();
                    }
                    Ek();
                    bK(true);
                    WriteData writeData = this.aAR.getWriteData();
                    this.aAR.setWriteData(null);
                    this.aAR.ly(false);
                    if (writeData != null && writeData != null && writeData.getType() == 2) {
                        this.aBs.DI();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void Ei() {
        if (this.aAR.getWriteData() == null) {
            this.aAR.setWriteData(this.aBs.ft(this.aBs.DJ()));
        }
        if (this.aAR.getWriteData() != null) {
            if (this.aBa != null) {
                this.aBa.DL();
            }
            if (this.aBa != null) {
                this.aBa.DL();
            }
            if (this.aBa != null) {
                this.aBa.DL();
            }
            this.aAR.getWriteData().setContent(this.aAN);
            this.aAR.getWriteData().setReplyId(this.aBq);
            if (this.mPostId != null) {
                this.aAR.getWriteData().setRepostId(this.aBs.DJ());
            }
            if (this.aAO != null) {
                if (this.aAO.getId() != null) {
                    this.aAR.getWriteData().setVoice(this.aAO.getId());
                    this.aAR.getWriteData().setVoiceDuringTime(this.aAO.duration);
                } else {
                    this.aAR.getWriteData().setVoice(null);
                    this.aAR.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.aAR.getWriteData().setVoice(null);
                this.aAR.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.aAR.bkv()) {
                yp().showToast(w.l.write_img_limit);
                return;
            }
            if (this.aBa != null) {
                this.aBa.DL();
            }
            if (!this.aAR.startPostWrite()) {
            }
        }
    }

    public void onDestory() {
        Ej();
        this.aAR.cancelLoadData();
    }

    public void onStop() {
    }

    public void Ej() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.aAN);
        writeData.setReplyId(this.aBq);
        writeData.setThreadId(this.mPostId);
        z.d(this.mPostId, writeData);
    }

    public void Ek() {
        z.c(this.mPostId, (WriteData) null);
    }

    public void l(int i, String str) {
        if (AntiHelper.sd(i)) {
            AntiHelper.aq(yp().getPageActivity(), str);
        } else if (i == 230277 || i == 230278) {
            fD(str);
        } else {
            yp().showToast(str);
        }
    }

    public void a(AntiData antiData) {
        this.aAU = antiData;
    }

    private void fD(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(yp().getPageActivity());
        aVar.cE(str);
        aVar.b(w.l.know, new q(this));
        aVar.b(yp()).tQ();
    }

    private void q(ArrayList<String> arrayList) {
        if (Dn() != null) {
            Dn().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.aAO = voiceModel;
    }

    public boolean El() {
        return this.aBt;
    }

    public void bL(boolean z) {
        this.aBt = z;
    }

    public void fE(String str) {
        bL(true);
        Dn().mp();
        if (str != null && str.length() != 0) {
            fG(yp().getResources().getString(w.l.reply_sub_floor).replace("%s", str));
        } else {
            fG("");
        }
        TiebaStatic.eventStat(yp().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void fF(String str) {
        bL(true);
        Dn().mp();
        fG(str);
        TiebaStatic.eventStat(yp().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void Em() {
        bL(false);
        Dn().hide();
    }

    public void En() {
        bL(true);
        Dn().mp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fG(String str) {
        if (Dn() != null) {
            Dn().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    public void fH(String str) {
        String string = TbadkCoreApplication.m9getInst().getResources().getString(w.l.reply_sub_floor);
        String str2 = "^" + string.replace("%s", ".+") + "$";
        if (au.isEmpty(this.aAN) || this.aAN.matches(str2)) {
            if (this.aBr != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.aBr).lookingAt()) {
                    fF(this.aBr);
                    return;
                } else {
                    fE(str);
                    return;
                }
            }
            fE(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.aAN);
        this.aBr = this.aAN;
        if (matcher.lookingAt()) {
            fF(this.aAN);
        } else {
            fE(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bK(boolean z) {
        if (Dn() != null) {
            Dn().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.aBu = dVar;
    }

    public void a(b bVar) {
        this.aBa = bVar;
    }
}
