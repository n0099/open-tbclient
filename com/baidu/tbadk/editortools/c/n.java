package com.baidu.tbadk.editortools.c;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.ad;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.a;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class n extends com.baidu.tbadk.editortools.f {
    private String arQ;
    private VoiceData.VoiceModel arR;
    private com.baidu.tieba.tbadkCore.writeModel.a arV;
    private AntiData arY;
    private BaseActivity<?> asa;
    private b asg;
    private a.d asj;
    private String asr;
    private a<?> ass;
    private boolean ast;
    private a.d asu;
    private String mPostId;

    public n(com.baidu.tbadk.editortools.j jVar) {
        super(jVar);
        this.arQ = "";
        this.asr = null;
        this.ast = false;
        this.asj = new o(this);
    }

    public void b(BaseActivity<?> baseActivity) {
        this.asa = baseActivity;
    }

    public BaseActivity<?> Bv() {
        return this.asa;
    }

    public String BH() {
        return this.arQ;
    }

    public void eZ(String str) {
        this.arQ = str;
    }

    public void b(a<?> aVar) {
        this.ass = aVar;
        if (aVar != null) {
            this.mPostId = aVar.Bl();
        }
    }

    public void c(BaseActivity<?> baseActivity) {
        this.arV = new com.baidu.tieba.tbadkCore.writeModel.a(baseActivity);
        this.arV.b(this.asj);
        ad.b(this.ass.Bl(), new p(this));
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 12005:
                    ArrayList<String> T = com.baidu.tieba.tbadkCore.util.l.T(intent);
                    if (T != null) {
                        q(T);
                        return;
                    }
                    return;
                case 12006:
                    if (Ax() != null) {
                        Ax().hide();
                    }
                    BK();
                    bg(true);
                    WriteData axE = this.arV.axE();
                    this.arV.c((WriteData) null);
                    this.arV.gw(false);
                    if (axE != null && axE != null && axE.getType() == 2) {
                        this.ass.Bk();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void BI() {
        if (this.arV.axE() == null) {
            this.arV.c(this.ass.eV(this.ass.Bl()));
        }
        if (this.arV.axE() != null) {
            if (this.asg != null) {
                this.asg.Bm();
            }
            if (this.asg != null) {
                this.asg.Bm();
            }
            if (this.arY != null) {
                if ((!AntiHelper.e(this.arY) && !AntiHelper.f(this.arY) && !AntiHelper.g(this.arY)) || !AntiHelper.a(Bv().getActivity(), this.arY, AntiHelper.OperationType.REPLY, PageType.FLOOR_IN_FLOOR)) {
                    if (this.arY != null && this.arY.getIfpost() == 0 && !TextUtils.isEmpty(this.arY.getForbid_info())) {
                        com.baidu.adp.lib.util.k.showToast(this.asa.getPageContext().getPageActivity(), this.arY.getForbid_info());
                        return;
                    }
                } else {
                    return;
                }
            }
            if (this.asg != null) {
                this.asg.Bm();
            }
            this.arV.axE().setContent(this.arQ);
            if (this.mPostId != null) {
                this.arV.axE().setRepostId(this.ass.Bl());
            }
            if (this.arR != null) {
                if (this.arR.getId() != null) {
                    this.arV.axE().setVoice(this.arR.getId());
                    this.arV.axE().setVoiceDuringTime(this.arR.duration);
                } else {
                    this.arV.axE().setVoice(null);
                    this.arV.axE().setVoiceDuringTime(-1);
                }
            } else {
                this.arV.axE().setVoice(null);
                this.arV.axE().setVoiceDuringTime(-1);
            }
            if (!this.arV.axI()) {
                Bv().showToast(i.h.write_img_limit);
                return;
            }
            if (this.asg != null) {
                this.asg.Bm();
            }
            if (!this.arV.axF()) {
            }
        }
    }

    public void onDestory() {
        BJ();
        this.arV.cancelLoadData();
    }

    public void onStop() {
    }

    public void BJ() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.arQ);
        writeData.setThreadId(this.mPostId);
        ad.d(this.mPostId, writeData);
    }

    public void BK() {
        ad.c(this.mPostId, (WriteData) null);
    }

    public void t(int i, String str) {
        if (AntiHelper.la(i)) {
            AntiHelper.P(Bv().getActivity(), str);
        } else if (i == 230277 || i == 230278) {
            fd(str);
        } else {
            Bv().showToast(str);
        }
    }

    public void a(AntiData antiData) {
        this.arY = antiData;
    }

    private void fd(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(Bv().getActivity());
        aVar.ct(str);
        aVar.b(i.h.know, new q(this));
        aVar.b(Bv().getPageContext()).sR();
    }

    private void q(ArrayList<String> arrayList) {
        if (Ax() != null) {
            Ax().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.arR = voiceModel;
    }

    public boolean BL() {
        return this.ast;
    }

    public void bh(boolean z) {
        this.ast = z;
    }

    public void fe(String str) {
        bh(true);
        Ax().ow();
        if (str != null && str.length() != 0) {
            fg(Bv().getResources().getString(i.h.reply_sub_floor).replace("%s", str));
        } else {
            fg("");
        }
        TiebaStatic.eventStat(Bv().getActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void ff(String str) {
        bh(true);
        fg(str);
        TiebaStatic.eventStat(Bv().getActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void BM() {
        bh(false);
        Ax().hide();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fg(String str) {
        if (Ax() != null) {
            Ax().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    public void fh(String str) {
        String string = TbadkCoreApplication.m411getInst().getResources().getString(i.h.reply_sub_floor);
        String str2 = "^" + string.replace("%s", ".+") + "$";
        if (ar.isEmpty(this.arQ) || this.arQ.matches(str2)) {
            if (this.asr != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.asr).lookingAt()) {
                    ff(this.asr);
                    return;
                } else {
                    fe(str);
                    return;
                }
            }
            fe(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.arQ);
        this.asr = this.arQ;
        if (matcher.lookingAt()) {
            ff(this.arQ);
        } else {
            fe(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bg(boolean z) {
        if (Ax() != null) {
            Ax().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(a.d dVar) {
        this.asu = dVar;
    }

    public void a(b bVar) {
        this.asg = bVar;
    }
}
