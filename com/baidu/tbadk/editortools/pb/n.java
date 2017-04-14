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
    private String aAL;
    private VoiceData.VoiceModel aAM;
    private NewWriteModel aAP;
    private AntiData aAS;
    private b aAY;
    private NewWriteModel.d aBe;
    private String aBo;
    private String aBp;
    private DataModel<?> aBq;
    private boolean aBr;
    private NewWriteModel.d aBs;
    private TbPageContext<?> aaX;
    private String mPostId;

    public n(com.baidu.tbadk.editortools.j jVar) {
        super(jVar);
        this.aAL = "";
        this.aBo = "";
        this.aBp = null;
        this.aBr = false;
        this.aBe = new o(this);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.aaX = tbPageContext;
    }

    public TbPageContext<?> yp() {
        return this.aaX;
    }

    public String Eh() {
        return this.aAL;
    }

    public void fy(String str) {
        this.aAL = str;
    }

    public void setReplyId(String str) {
        this.aBo = str;
    }

    public void b(DataModel<?> dataModel) {
        this.aBq = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.DJ();
        }
    }

    public void f(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.aAP = new NewWriteModel(tbPageContext);
            this.aAP.b(this.aBe);
            z.b(this.aBq.DJ(), new p(this));
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
                    WriteData writeData = this.aAP.getWriteData();
                    this.aAP.setWriteData(null);
                    this.aAP.lo(false);
                    if (writeData != null && writeData != null && writeData.getType() == 2) {
                        this.aBq.DI();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void Ei() {
        if (this.aAP.getWriteData() == null) {
            this.aAP.setWriteData(this.aBq.ft(this.aBq.DJ()));
        }
        if (this.aAP.getWriteData() != null) {
            if (this.aAY != null) {
                this.aAY.DL();
            }
            if (this.aAY != null) {
                this.aAY.DL();
            }
            if (this.aAY != null) {
                this.aAY.DL();
            }
            this.aAP.getWriteData().setContent(this.aAL);
            this.aAP.getWriteData().setReplyId(this.aBo);
            if (this.mPostId != null) {
                this.aAP.getWriteData().setRepostId(this.aBq.DJ());
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
            if (!this.aAP.bju()) {
                yp().showToast(w.l.write_img_limit);
                return;
            }
            if (this.aAY != null) {
                this.aAY.DL();
            }
            if (!this.aAP.startPostWrite()) {
            }
        }
    }

    public void onDestory() {
        Ej();
        this.aAP.cancelLoadData();
    }

    public void onStop() {
    }

    public void Ej() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.aAL);
        writeData.setReplyId(this.aBo);
        writeData.setThreadId(this.mPostId);
        z.d(this.mPostId, writeData);
    }

    public void Ek() {
        z.c(this.mPostId, (WriteData) null);
    }

    public void l(int i, String str) {
        if (AntiHelper.rX(i)) {
            AntiHelper.aq(yp().getPageActivity(), str);
        } else if (i == 230277 || i == 230278) {
            fD(str);
        } else {
            yp().showToast(str);
        }
    }

    public void a(AntiData antiData) {
        this.aAS = antiData;
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
        this.aAM = voiceModel;
    }

    public boolean El() {
        return this.aBr;
    }

    public void bL(boolean z) {
        this.aBr = z;
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
        if (au.isEmpty(this.aAL) || this.aAL.matches(str2)) {
            if (this.aBp != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.aBp).lookingAt()) {
                    fF(this.aBp);
                    return;
                } else {
                    fE(str);
                    return;
                }
            }
            fE(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.aAL);
        this.aBp = this.aAL;
        if (matcher.lookingAt()) {
            fF(this.aAL);
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
        this.aBs = dVar;
    }

    public void a(b bVar) {
        this.aAY = bVar;
    }
}
