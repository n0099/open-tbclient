package com.baidu.tbadk.editortools.pb;

import android.content.Intent;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
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
    private String aBA;
    private VoiceData.VoiceModel aBB;
    private NewWriteModel aBE;
    private AntiData aBH;
    private b aBN;
    private NewWriteModel.d aBU;
    private String aCe;
    private String aCf;
    private DataModel<?> aCg;
    private boolean aCh;
    private NewWriteModel.d aCi;
    private TbPageContext<?> aat;
    private String mPostId;

    public n(com.baidu.tbadk.editortools.j jVar) {
        super(jVar);
        this.aBA = "";
        this.aCe = "";
        this.aCf = null;
        this.aCh = false;
        this.aBU = new o(this);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.aat = tbPageContext;
    }

    public TbPageContext<?> xN() {
        return this.aat;
    }

    public String Dz() {
        return this.aBA;
    }

    public void fN(String str) {
        this.aBA = str;
    }

    public void setReplyId(String str) {
        this.aCe = str;
    }

    public void b(DataModel<?> dataModel) {
        this.aCg = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.Db();
        }
    }

    public void f(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.aBE = new NewWriteModel(tbPageContext);
            this.aBE.b(this.aBU);
            x.b(this.aCg.Db(), new p(this));
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
                    if (CG() != null) {
                        CG().hide();
                    }
                    DC();
                    bK(true);
                    WriteData writeData = this.aBE.getWriteData();
                    this.aBE.setWriteData(null);
                    this.aBE.lW(false);
                    if (writeData != null && writeData != null && writeData.getType() == 2) {
                        this.aCg.Da();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void DA() {
        if (this.aBE.getWriteData() == null) {
            this.aBE.setWriteData(this.aCg.fI(this.aCg.Db()));
        }
        if (this.aBE.getWriteData() != null) {
            if (this.aBN != null) {
                this.aBN.Dd();
            }
            if (this.aBN != null) {
                this.aBN.Dd();
            }
            if (this.aBN != null) {
                this.aBN.Dd();
            }
            this.aBE.getWriteData().setContent(this.aBA);
            this.aBE.getWriteData().setReplyId(this.aCe);
            if (this.mPostId != null) {
                this.aBE.getWriteData().setRepostId(this.aCg.Db());
            }
            if (this.aBB != null) {
                if (this.aBB.getId() != null) {
                    this.aBE.getWriteData().setVoice(this.aBB.getId());
                    this.aBE.getWriteData().setVoiceDuringTime(this.aBB.duration);
                } else {
                    this.aBE.getWriteData().setVoice(null);
                    this.aBE.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.aBE.getWriteData().setVoice(null);
                this.aBE.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.aBE.bnA()) {
                xN().showToast(w.l.write_img_limit);
                return;
            }
            if (this.aBN != null) {
                this.aBN.Dd();
            }
            if (!this.aBE.startPostWrite()) {
            }
        }
    }

    public void onDestory() {
        DB();
        this.aBE.cancelLoadData();
    }

    public void onStop() {
    }

    public void DB() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.aBA);
        writeData.setReplyId(this.aCe);
        writeData.setThreadId(this.mPostId);
        x.d(this.mPostId, writeData);
    }

    public void DC() {
        x.c(this.mPostId, (WriteData) null);
    }

    public void m(int i, String str) {
        if (AntiHelper.sK(i)) {
            AntiHelper.ar(xN().getPageActivity(), str);
        } else if (i == 230277 || i == 230278) {
            fS(str);
        } else {
            xN().showToast(str);
        }
    }

    public void a(AntiData antiData) {
        this.aBH = antiData;
    }

    private void fS(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(xN().getPageActivity());
        aVar.cI(str);
        aVar.b(w.l.know, new q(this));
        aVar.b(xN()).ta();
    }

    private void q(ArrayList<String> arrayList) {
        if (CG() != null) {
            CG().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.aBB = voiceModel;
    }

    public boolean DD() {
        return this.aCh;
    }

    public void bL(boolean z) {
        this.aCh = z;
    }

    public void fT(String str) {
        bL(true);
        CG().lM();
        if (str != null && str.length() != 0) {
            fV(xN().getResources().getString(w.l.reply_sub_floor).replace("%s", str));
        } else {
            fV("");
        }
        TiebaStatic.eventStat(xN().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void fU(String str) {
        bL(true);
        CG().lM();
        fV(str);
        TiebaStatic.eventStat(xN().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void DE() {
        bL(false);
        CG().hide();
    }

    public void DF() {
        bL(true);
        CG().lM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fV(String str) {
        if (CG() != null) {
            CG().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    public void fW(String str) {
        String string = TbadkCoreApplication.m9getInst().getResources().getString(w.l.reply_sub_floor);
        String str2 = "^" + string.replace("%s", ".+") + "$";
        if (aw.isEmpty(this.aBA) || this.aBA.matches(str2)) {
            if (this.aCf != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.aCf).lookingAt()) {
                    fU(this.aCf);
                    return;
                } else {
                    fT(str);
                    return;
                }
            }
            fT(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.aBA);
        this.aCf = this.aBA;
        if (matcher.lookingAt()) {
            fU(this.aBA);
        } else {
            fT(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bK(boolean z) {
        if (CG() != null) {
            CG().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.aCi = dVar;
    }

    public void a(b bVar) {
        this.aBN = bVar;
    }
}
