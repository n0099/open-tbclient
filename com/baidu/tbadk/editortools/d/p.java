package com.baidu.tbadk.editortools.d;

import android.content.Intent;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.ad;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.a;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class p extends com.baidu.tbadk.editortools.f {
    private TbPageContext<?> MR;
    private String auQ;
    private VoiceData.VoiceModel auR;
    private com.baidu.tieba.tbadkCore.writeModel.a auV;
    private AntiData auY;
    private c avf;
    private a.d avl;
    private String avv;
    private a<?> avw;
    private boolean avx;
    private a.d avy;
    private String mPostId;

    public p(com.baidu.tbadk.editortools.k kVar) {
        super(kVar);
        this.auQ = "";
        this.avv = null;
        this.avx = false;
        this.avl = new q(this);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.MR = tbPageContext;
    }

    public TbPageContext<?> DC() {
        return this.MR;
    }

    public String DD() {
        return this.auQ;
    }

    public void fs(String str) {
        this.auQ = str;
    }

    public void b(a<?> aVar) {
        this.avw = aVar;
        if (aVar != null) {
            this.mPostId = aVar.CZ();
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.auV = new com.baidu.tieba.tbadkCore.writeModel.a(tbPageContext);
            this.auV.b(this.avl);
            ad.b(this.avw.CZ(), new r(this));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 12005:
                    ArrayList<String> V = com.baidu.tieba.tbadkCore.util.l.V(intent);
                    if (V != null) {
                        s(V);
                        return;
                    }
                    return;
                case 12006:
                    if (Cz() != null) {
                        Cz().hide();
                    }
                    DG();
                    br(true);
                    WriteData aND = this.auV.aND();
                    this.auV.c((WriteData) null);
                    this.auV.hX(false);
                    if (aND != null && aND != null && aND.getType() == 2) {
                        this.avw.CY();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void DE() {
        if (this.auV.aND() == null) {
            this.auV.c(this.avw.fn(this.avw.CZ()));
        }
        if (this.auV.aND() != null) {
            if (this.avf != null) {
                this.avf.Db();
            }
            if (this.avf != null) {
                this.avf.Db();
            }
            if (this.avf != null) {
                this.avf.Db();
            }
            this.auV.aND().setContent(this.auQ);
            if (this.mPostId != null) {
                this.auV.aND().setRepostId(this.avw.CZ());
            }
            if (this.auR != null) {
                if (this.auR.getId() != null) {
                    this.auV.aND().setVoice(this.auR.getId());
                    this.auV.aND().setVoiceDuringTime(this.auR.duration);
                } else {
                    this.auV.aND().setVoice(null);
                    this.auV.aND().setVoiceDuringTime(-1);
                }
            } else {
                this.auV.aND().setVoice(null);
                this.auV.aND().setVoiceDuringTime(-1);
            }
            if (!this.auV.aNH()) {
                DC().showToast(t.j.write_img_limit);
                return;
            }
            if (this.avf != null) {
                this.avf.Db();
            }
            if (!this.auV.aNE()) {
            }
        }
    }

    public void onDestory() {
        DF();
        this.auV.cancelLoadData();
    }

    public void onStop() {
    }

    public void DF() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.auQ);
        writeData.setThreadId(this.mPostId);
        ad.d(this.mPostId, writeData);
    }

    public void DG() {
        ad.c(this.mPostId, (WriteData) null);
    }

    public void t(int i, String str) {
        if (AntiHelper.or(i)) {
            AntiHelper.X(DC().getPageActivity(), str);
        } else if (i == 230277 || i == 230278) {
            fw(str);
        } else {
            DC().showToast(str);
        }
    }

    public void a(AntiData antiData) {
        this.auY = antiData;
    }

    private void fw(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(DC().getPageActivity());
        aVar.cE(str);
        aVar.b(t.j.know, new s(this));
        aVar.b(DC()).uj();
    }

    private void s(ArrayList<String> arrayList) {
        if (Cz() != null) {
            Cz().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.auR = voiceModel;
    }

    public boolean DH() {
        return this.avx;
    }

    public void bs(boolean z) {
        this.avx = z;
    }

    public void fx(String str) {
        bs(true);
        Cz().ow();
        if (str != null && str.length() != 0) {
            fz(DC().getResources().getString(t.j.reply_sub_floor).replace("%s", str));
        } else {
            fz("");
        }
        TiebaStatic.eventStat(DC().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void fy(String str) {
        bs(true);
        fz(str);
        TiebaStatic.eventStat(DC().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void DI() {
        bs(false);
        Cz().hide();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fz(String str) {
        if (Cz() != null) {
            Cz().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    public void fA(String str) {
        String string = TbadkCoreApplication.m411getInst().getResources().getString(t.j.reply_sub_floor);
        String str2 = "^" + string.replace("%s", ".+") + "$";
        if (aw.isEmpty(this.auQ) || this.auQ.matches(str2)) {
            if (this.avv != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.avv).lookingAt()) {
                    fy(this.avv);
                    return;
                } else {
                    fx(str);
                    return;
                }
            }
            fx(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.auQ);
        this.avv = this.auQ;
        if (matcher.lookingAt()) {
            fy(this.auQ);
        } else {
            fx(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void br(boolean z) {
        if (Cz() != null) {
            Cz().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(a.d dVar) {
        this.avy = dVar;
    }

    public void a(c cVar) {
        this.avf = cVar;
    }
}
