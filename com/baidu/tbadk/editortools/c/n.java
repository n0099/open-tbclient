package com.baidu.tbadk.editortools.c;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.ac;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.a;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class n extends com.baidu.tbadk.editortools.f {
    private String arJ;
    private VoiceData.VoiceModel arK;
    private com.baidu.tieba.tbadkCore.writeModel.a arO;
    private AntiData arR;
    private BaseActivity<?> arT;
    private b arZ;
    private a.d asc;
    private String ask;
    private a<?> asl;
    private boolean asm;
    private a.d asn;
    private String mPostId;

    public n(com.baidu.tbadk.editortools.j jVar) {
        super(jVar);
        this.arJ = "";
        this.ask = null;
        this.asm = false;
        this.asc = new o(this);
    }

    public void b(BaseActivity<?> baseActivity) {
        this.arT = baseActivity;
    }

    public BaseActivity<?> Bv() {
        return this.arT;
    }

    public void eM(String str) {
        this.arJ = str;
    }

    public void b(a<?> aVar) {
        this.asl = aVar;
        if (aVar != null) {
            this.mPostId = aVar.Bl();
        }
    }

    public void c(BaseActivity<?> baseActivity) {
        this.arO = new com.baidu.tieba.tbadkCore.writeModel.a(baseActivity);
        this.arO.b(this.asc);
        ac.b(this.asl.Bl(), new p(this));
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 12005:
                    ArrayList<String> R = com.baidu.tieba.tbadkCore.util.j.R(intent);
                    if (R != null) {
                        r(R);
                        return;
                    }
                    return;
                case 12006:
                    if (Ay() != null) {
                        Ay().hide();
                    }
                    BJ();
                    bb(true);
                    WriteData ard = this.arO.ard();
                    this.arO.c((WriteData) null);
                    this.arO.fB(false);
                    if (ard != null && ard != null && ard.getType() == 2) {
                        this.asl.Bk();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void BH() {
        if (this.arO.ard() == null) {
            this.arO.c(this.asl.eI(null));
        }
        if (this.arO.ard() != null) {
            if (this.arR != null) {
                if ((!AntiHelper.d(this.arR) && !AntiHelper.e(this.arR) && !AntiHelper.f(this.arR)) || !AntiHelper.a(Bv().getActivity(), this.arR, AntiHelper.OperationType.REPLY, PageType.FLOOR_IN_FLOOR)) {
                    if (this.arR != null && this.arR.getIfpost() == 0 && !TextUtils.isEmpty(this.arR.getForbid_info())) {
                        com.baidu.adp.lib.util.k.showToast(this.arT.getPageContext().getPageActivity(), this.arR.getForbid_info());
                        return;
                    }
                } else {
                    return;
                }
            }
            if (this.arZ != null) {
                this.arZ.Bm();
            }
            this.arO.ard().setContent(this.arJ);
            if (this.mPostId != null) {
                this.arO.ard().setRepostId(this.asl.Bl());
            }
            if (this.arK != null) {
                if (this.arK.getId() != null) {
                    this.arO.ard().setVoice(this.arK.getId());
                    this.arO.ard().setVoiceDuringTime(this.arK.duration);
                } else {
                    this.arO.ard().setVoice(null);
                    this.arO.ard().setVoiceDuringTime(-1);
                }
            } else {
                this.arO.ard().setVoice(null);
                this.arO.ard().setVoiceDuringTime(-1);
            }
            if (!this.arO.arg()) {
                Bv().showToast(i.C0057i.write_img_limit);
                return;
            }
            if (this.arZ != null) {
                this.arZ.Bm();
            }
            if (!this.arO.are()) {
            }
        }
    }

    public void onDestory() {
        BI();
        this.arO.cancelLoadData();
    }

    public void onStop() {
    }

    public void BI() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.arJ);
        writeData.setThreadId(this.mPostId);
        ac.c(this.mPostId, writeData);
    }

    public void BJ() {
        ac.c(this.mPostId, (WriteData) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData) || AntiHelper.g(antiData)) {
            AntiHelper.a(Bv().getActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.FLOOR_IN_FLOOR);
        } else if (i == 230277) {
            eQ(str);
        } else {
            Bv().showToast(str);
        }
    }

    public void a(AntiData antiData) {
        this.arR = antiData;
    }

    private void eQ(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(Bv().getActivity());
        aVar.cn(str);
        aVar.b(i.C0057i.know, new q(this));
        aVar.b(Bv().getPageContext()).sP();
    }

    private void r(ArrayList<String> arrayList) {
        if (Ay() != null) {
            Ay().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.arK = voiceModel;
    }

    public boolean BK() {
        return this.asm;
    }

    public void bc(boolean z) {
        this.asm = z;
    }

    public void eR(String str) {
        bc(true);
        Ay().oy();
        if (str != null) {
            eT(Bv().getResources().getString(i.C0057i.reply_sub_floor).replace("%s", str));
        }
        TiebaStatic.eventStat(Bv().getActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void eS(String str) {
        bc(true);
        eT(str);
        TiebaStatic.eventStat(Bv().getActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void BL() {
        bc(false);
        Ay().hide();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eT(String str) {
        if (Ay() != null) {
            Ay().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    public void eU(String str) {
        String string = TbadkCoreApplication.m411getInst().getResources().getString(i.C0057i.reply_sub_floor);
        String str2 = "^" + string.replace("%s", ".+") + "$";
        if (aq.isEmpty(this.arJ) || this.arJ.matches(str2)) {
            if (this.ask != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.ask).lookingAt()) {
                    eS(this.ask);
                    return;
                } else {
                    eR(str);
                    return;
                }
            }
            eR(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.arJ);
        this.ask = this.arJ;
        if (matcher.lookingAt()) {
            eS(this.arJ);
        } else {
            eR(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb(boolean z) {
        if (Ay() != null) {
            Ay().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(a.d dVar) {
        this.asn = dVar;
    }

    public void a(b bVar) {
        this.arZ = bVar;
    }
}
