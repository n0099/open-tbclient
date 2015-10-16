package com.baidu.tbadk.editortools.c;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
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
    private String arR;
    private VoiceData.VoiceModel arS;
    private com.baidu.tieba.tbadkCore.writeModel.a arW;
    private AntiData arZ;
    private BaseActivity<?> asb;
    private b ash;
    private a.d ask;
    private String ass;
    private a<?> ast;
    private boolean asu;
    private a.d asv;
    private String mPostId;

    public n(com.baidu.tbadk.editortools.j jVar) {
        super(jVar);
        this.arR = "";
        this.ass = null;
        this.asu = false;
        this.ask = new o(this);
    }

    public void b(BaseActivity<?> baseActivity) {
        this.asb = baseActivity;
    }

    public BaseActivity<?> Bv() {
        return this.asb;
    }

    public String BH() {
        return this.arR;
    }

    public void eZ(String str) {
        this.arR = str;
    }

    public void b(a<?> aVar) {
        this.ast = aVar;
        if (aVar != null) {
            this.mPostId = aVar.Bl();
        }
    }

    public void c(BaseActivity<?> baseActivity) {
        this.arW = new com.baidu.tieba.tbadkCore.writeModel.a(baseActivity);
        this.arW.b(this.ask);
        ad.b(this.ast.Bl(), new p(this));
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
                    WriteData axO = this.arW.axO();
                    this.arW.c((WriteData) null);
                    this.arW.gw(false);
                    if (axO != null && axO != null && axO.getType() == 2) {
                        this.ast.Bk();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void BI() {
        if (this.arW.axO() == null) {
            this.arW.c(this.ast.eV(this.ast.Bl()));
        }
        if (this.arW.axO() != null) {
            if (this.ash != null) {
                this.ash.Bm();
            }
            if (this.ash != null) {
                this.ash.Bm();
            }
            if (this.arZ != null) {
                if ((!AntiHelper.e(this.arZ) && !AntiHelper.f(this.arZ) && !AntiHelper.g(this.arZ)) || !AntiHelper.a(Bv().getActivity(), this.arZ, AntiHelper.OperationType.REPLY, PageType.FLOOR_IN_FLOOR)) {
                    if (this.arZ != null && this.arZ.getIfpost() == 0 && !TextUtils.isEmpty(this.arZ.getForbid_info())) {
                        com.baidu.adp.lib.util.k.showToast(this.asb.getPageContext().getPageActivity(), this.arZ.getForbid_info());
                        return;
                    }
                } else {
                    return;
                }
            }
            if (this.ash != null) {
                this.ash.Bm();
            }
            this.arW.axO().setContent(this.arR);
            if (this.mPostId != null) {
                this.arW.axO().setRepostId(this.ast.Bl());
            }
            if (this.arS != null) {
                if (this.arS.getId() != null) {
                    this.arW.axO().setVoice(this.arS.getId());
                    this.arW.axO().setVoiceDuringTime(this.arS.duration);
                } else {
                    this.arW.axO().setVoice(null);
                    this.arW.axO().setVoiceDuringTime(-1);
                }
            } else {
                this.arW.axO().setVoice(null);
                this.arW.axO().setVoiceDuringTime(-1);
            }
            if (!this.arW.axS()) {
                Bv().showToast(i.h.write_img_limit);
                return;
            }
            if (this.ash != null) {
                this.ash.Bm();
            }
            if (!this.arW.axP()) {
            }
        }
    }

    public void onDestory() {
        BJ();
        this.arW.cancelLoadData();
    }

    public void onStop() {
    }

    public void BJ() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.arR);
        writeData.setThreadId(this.mPostId);
        ad.d(this.mPostId, writeData);
    }

    public void BK() {
        ad.c(this.mPostId, (WriteData) null);
    }

    public void t(int i, String str) {
        if (AntiHelper.lc(i)) {
            AntiHelper.P(Bv().getActivity(), str);
        } else if (i == 230277 || i == 230278) {
            fd(str);
        } else {
            Bv().showToast(str);
        }
    }

    public void a(AntiData antiData) {
        this.arZ = antiData;
    }

    private void fd(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(Bv().getActivity());
        aVar.cu(str);
        aVar.b(i.h.know, new q(this));
        aVar.b(Bv().getPageContext()).sR();
    }

    private void q(ArrayList<String> arrayList) {
        if (Ax() != null) {
            Ax().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.arS = voiceModel;
    }

    public boolean BL() {
        return this.asu;
    }

    public void bh(boolean z) {
        this.asu = z;
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
        if (as.isEmpty(this.arR) || this.arR.matches(str2)) {
            if (this.ass != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.ass).lookingAt()) {
                    ff(this.ass);
                    return;
                } else {
                    fe(str);
                    return;
                }
            }
            fe(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.arR);
        this.ass = this.arR;
        if (matcher.lookingAt()) {
            ff(this.arR);
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
        this.asv = dVar;
    }

    public void a(b bVar) {
        this.ash = bVar;
    }
}
