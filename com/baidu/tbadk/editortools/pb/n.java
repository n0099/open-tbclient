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
    private AntiData aAC;
    private b aAI;
    private NewWriteModel.d aAO;
    private String aAY;
    private String aAZ;
    private String aAv;
    private VoiceData.VoiceModel aAw;
    private NewWriteModel aAz;
    private DataModel<?> aBa;
    private boolean aBb;
    private NewWriteModel.d aBc;
    private TbPageContext<?> aaI;
    private String mPostId;

    public n(com.baidu.tbadk.editortools.j jVar) {
        super(jVar);
        this.aAv = "";
        this.aAY = "";
        this.aAZ = null;
        this.aBb = false;
        this.aAO = new o(this);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.aaI = tbPageContext;
    }

    public TbPageContext<?> xR() {
        return this.aaI;
    }

    public String DJ() {
        return this.aAv;
    }

    public void fs(String str) {
        this.aAv = str;
    }

    public void setReplyId(String str) {
        this.aAY = str;
    }

    public void b(DataModel<?> dataModel) {
        this.aBa = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.Dl();
        }
    }

    public void f(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.aAz = new NewWriteModel(tbPageContext);
            this.aAz.b(this.aAO);
            z.b(this.aBa.Dl(), new p(this));
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
                    if (CP() != null) {
                        CP().hide();
                    }
                    DM();
                    bI(true);
                    WriteData writeData = this.aAz.getWriteData();
                    this.aAz.setWriteData(null);
                    this.aAz.ll(false);
                    if (writeData != null && writeData != null && writeData.getType() == 2) {
                        this.aBa.Dk();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void DK() {
        if (this.aAz.getWriteData() == null) {
            this.aAz.setWriteData(this.aBa.fn(this.aBa.Dl()));
        }
        if (this.aAz.getWriteData() != null) {
            if (this.aAI != null) {
                this.aAI.Dn();
            }
            if (this.aAI != null) {
                this.aAI.Dn();
            }
            if (this.aAI != null) {
                this.aAI.Dn();
            }
            this.aAz.getWriteData().setContent(this.aAv);
            this.aAz.getWriteData().setReplyId(this.aAY);
            if (this.mPostId != null) {
                this.aAz.getWriteData().setRepostId(this.aBa.Dl());
            }
            if (this.aAw != null) {
                if (this.aAw.getId() != null) {
                    this.aAz.getWriteData().setVoice(this.aAw.getId());
                    this.aAz.getWriteData().setVoiceDuringTime(this.aAw.duration);
                } else {
                    this.aAz.getWriteData().setVoice(null);
                    this.aAz.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.aAz.getWriteData().setVoice(null);
                this.aAz.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.aAz.biJ()) {
                xR().showToast(w.l.write_img_limit);
                return;
            }
            if (this.aAI != null) {
                this.aAI.Dn();
            }
            if (!this.aAz.startPostWrite()) {
            }
        }
    }

    public void onDestory() {
        DL();
        this.aAz.cancelLoadData();
    }

    public void onStop() {
    }

    public void DL() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.aAv);
        writeData.setReplyId(this.aAY);
        writeData.setThreadId(this.mPostId);
        z.d(this.mPostId, writeData);
    }

    public void DM() {
        z.c(this.mPostId, (WriteData) null);
    }

    public void l(int i, String str) {
        if (AntiHelper.rZ(i)) {
            AntiHelper.an(xR().getPageActivity(), str);
        } else if (i == 230277 || i == 230278) {
            fx(str);
        } else {
            xR().showToast(str);
        }
    }

    public void a(AntiData antiData) {
        this.aAC = antiData;
    }

    private void fx(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(xR().getPageActivity());
        aVar.cx(str);
        aVar.b(w.l.know, new q(this));
        aVar.b(xR()).ts();
    }

    private void q(ArrayList<String> arrayList) {
        if (CP() != null) {
            CP().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.aAw = voiceModel;
    }

    public boolean DN() {
        return this.aBb;
    }

    public void bJ(boolean z) {
        this.aBb = z;
    }

    public void fy(String str) {
        bJ(true);
        CP().ml();
        if (str != null && str.length() != 0) {
            fA(xR().getResources().getString(w.l.reply_sub_floor).replace("%s", str));
        } else {
            fA("");
        }
        TiebaStatic.eventStat(xR().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void fz(String str) {
        bJ(true);
        CP().ml();
        fA(str);
        TiebaStatic.eventStat(xR().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void DO() {
        bJ(false);
        CP().hide();
    }

    public void DP() {
        bJ(true);
        CP().ml();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fA(String str) {
        if (CP() != null) {
            CP().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    public void fB(String str) {
        String string = TbadkCoreApplication.m9getInst().getResources().getString(w.l.reply_sub_floor);
        String str2 = "^" + string.replace("%s", ".+") + "$";
        if (au.isEmpty(this.aAv) || this.aAv.matches(str2)) {
            if (this.aAZ != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.aAZ).lookingAt()) {
                    fz(this.aAZ);
                    return;
                } else {
                    fy(str);
                    return;
                }
            }
            fy(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.aAv);
        this.aAZ = this.aAv;
        if (matcher.lookingAt()) {
            fz(this.aAv);
        } else {
            fy(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bI(boolean z) {
        if (CP() != null) {
            CP().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.aBc = dVar;
    }

    public void a(b bVar) {
        this.aAI = bVar;
    }
}
