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
import com.baidu.tieba.tbadkCore.ad;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.a;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class n extends com.baidu.tbadk.editortools.f {
    private AntiData atB;
    private BaseActivity<?> atD;
    private b atJ;
    private a.d atM;
    private String atU;
    private a<?> atV;
    private boolean atW;
    private a.d atX;
    private String att;
    private VoiceData.VoiceModel atu;
    private com.baidu.tieba.tbadkCore.writeModel.a aty;
    private String mPostId;

    public n(com.baidu.tbadk.editortools.j jVar) {
        super(jVar);
        this.att = "";
        this.atU = null;
        this.atW = false;
        this.atM = new o(this);
    }

    public void b(BaseActivity<?> baseActivity) {
        this.atD = baseActivity;
    }

    public BaseActivity<?> BI() {
        return this.atD;
    }

    public String BU() {
        return this.att;
    }

    public void eU(String str) {
        this.att = str;
    }

    public void b(a<?> aVar) {
        this.atV = aVar;
        if (aVar != null) {
            this.mPostId = aVar.By();
        }
    }

    public void c(BaseActivity<?> baseActivity) {
        this.aty = new com.baidu.tieba.tbadkCore.writeModel.a(baseActivity);
        this.aty.b(this.atM);
        ad.b(this.atV.By(), new p(this));
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 12005:
                    ArrayList<String> U = com.baidu.tieba.tbadkCore.util.j.U(intent);
                    if (U != null) {
                        q(U);
                        return;
                    }
                    return;
                case 12006:
                    if (AL() != null) {
                        AL().hide();
                    }
                    BX();
                    bi(true);
                    WriteData avr = this.aty.avr();
                    this.aty.c((WriteData) null);
                    this.aty.gm(false);
                    if (avr != null && avr != null && avr.getType() == 2) {
                        this.atV.Bx();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void BV() {
        if (this.aty.avr() == null) {
            this.aty.c(this.atV.eQ(this.atV.By()));
        }
        if (this.aty.avr() != null) {
            if (this.atJ != null) {
                this.atJ.Bz();
            }
            if (this.atB != null) {
                if ((!AntiHelper.d(this.atB) && !AntiHelper.e(this.atB) && !AntiHelper.f(this.atB)) || !AntiHelper.a(BI().getActivity(), this.atB, AntiHelper.OperationType.REPLY, PageType.FLOOR_IN_FLOOR)) {
                    if (this.atB != null && this.atB.getIfpost() == 0 && !TextUtils.isEmpty(this.atB.getForbid_info())) {
                        com.baidu.adp.lib.util.k.showToast(this.atD.getPageContext().getPageActivity(), this.atB.getForbid_info());
                        return;
                    }
                } else {
                    return;
                }
            }
            if (this.atJ != null) {
                this.atJ.Bz();
            }
            this.aty.avr().setContent(this.att);
            if (this.mPostId != null) {
                this.aty.avr().setRepostId(this.atV.By());
            }
            if (this.atu != null) {
                if (this.atu.getId() != null) {
                    this.aty.avr().setVoice(this.atu.getId());
                    this.aty.avr().setVoiceDuringTime(this.atu.duration);
                } else {
                    this.aty.avr().setVoice(null);
                    this.aty.avr().setVoiceDuringTime(-1);
                }
            } else {
                this.aty.avr().setVoice(null);
                this.aty.avr().setVoiceDuringTime(-1);
            }
            if (!this.aty.avu()) {
                BI().showToast(i.h.write_img_limit);
                return;
            }
            if (this.atJ != null) {
                this.atJ.Bz();
            }
            if (!this.aty.avs()) {
            }
        }
    }

    public void onDestory() {
        BW();
        this.aty.cancelLoadData();
    }

    public void onStop() {
    }

    public void BW() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.att);
        writeData.setThreadId(this.mPostId);
        ad.d(this.mPostId, writeData);
    }

    public void BX() {
        ad.c(this.mPostId, (WriteData) null);
    }

    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData) || AntiHelper.g(antiData)) {
            AntiHelper.a(BI().getActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.FLOOR_IN_FLOOR);
        } else if (i == 230277) {
            eY(str);
        } else {
            BI().showToast(str);
        }
    }

    public void a(AntiData antiData) {
        this.atB = antiData;
    }

    private void eY(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(BI().getActivity());
        aVar.ct(str);
        aVar.b(i.h.know, new q(this));
        aVar.b(BI().getPageContext()).sU();
    }

    private void q(ArrayList<String> arrayList) {
        if (AL() != null) {
            AL().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.atu = voiceModel;
    }

    public boolean BY() {
        return this.atW;
    }

    public void bj(boolean z) {
        this.atW = z;
    }

    public void eZ(String str) {
        bj(true);
        AL().ov();
        if (str != null && str.length() != 0) {
            fb(BI().getResources().getString(i.h.reply_sub_floor).replace("%s", str));
        } else {
            fb("");
        }
        TiebaStatic.eventStat(BI().getActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void fa(String str) {
        bj(true);
        fb(str);
        TiebaStatic.eventStat(BI().getActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void BZ() {
        bj(false);
        AL().hide();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fb(String str) {
        if (AL() != null) {
            AL().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    public void fc(String str) {
        String string = TbadkCoreApplication.m411getInst().getResources().getString(i.h.reply_sub_floor);
        String str2 = "^" + string.replace("%s", ".+") + "$";
        if (aq.isEmpty(this.att) || this.att.matches(str2)) {
            if (this.atU != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.atU).lookingAt()) {
                    fa(this.atU);
                    return;
                } else {
                    eZ(str);
                    return;
                }
            }
            eZ(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.att);
        this.atU = this.att;
        if (matcher.lookingAt()) {
            fa(this.att);
        } else {
            eZ(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bi(boolean z) {
        if (AL() != null) {
            AL().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(a.d dVar) {
        this.atX = dVar;
    }

    public void a(b bVar) {
        this.atJ = bVar;
    }
}
