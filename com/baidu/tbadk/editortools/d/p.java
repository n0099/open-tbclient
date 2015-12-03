package com.baidu.tbadk.editortools.d;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.ae;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.a;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class p extends com.baidu.tbadk.editortools.f {
    private AntiData asC;
    private c asJ;
    private a.d asP;
    private String asZ;
    private String asu;
    private VoiceData.VoiceModel asv;
    private com.baidu.tieba.tbadkCore.writeModel.a asz;
    private a<?> ata;
    private boolean atb;
    private a.d atc;
    private TbPageContext<?> mContext;
    private String mPostId;

    public p(com.baidu.tbadk.editortools.k kVar) {
        super(kVar);
        this.asu = "";
        this.asZ = null;
        this.atb = false;
        this.asP = new q(this);
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public TbPageContext<?> Cx() {
        return this.mContext;
    }

    public String Cy() {
        return this.asu;
    }

    public void fq(String str) {
        this.asu = str;
    }

    public void b(a<?> aVar) {
        this.ata = aVar;
        if (aVar != null) {
            this.mPostId = aVar.BU();
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.asz = new com.baidu.tieba.tbadkCore.writeModel.a(tbPageContext);
            this.asz.b(this.asP);
            ae.b(this.ata.BU(), new r(this));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 12005:
                    ArrayList<String> T = com.baidu.tieba.tbadkCore.util.l.T(intent);
                    if (T != null) {
                        r(T);
                        return;
                    }
                    return;
                case 12006:
                    if (Bu() != null) {
                        Bu().hide();
                    }
                    CB();
                    bp(true);
                    WriteData aEl = this.asz.aEl();
                    this.asz.c((WriteData) null);
                    this.asz.hn(false);
                    if (aEl != null && aEl != null && aEl.getType() == 2) {
                        this.ata.BT();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void Cz() {
        if (this.asz.aEl() == null) {
            this.asz.c(this.ata.fl(this.ata.BU()));
        }
        if (this.asz.aEl() != null) {
            if (this.asJ != null) {
                this.asJ.BW();
            }
            if (this.asJ != null) {
                this.asJ.BW();
            }
            if (this.asC != null) {
                if ((!AntiHelper.d(this.asC) && !AntiHelper.e(this.asC) && !AntiHelper.f(this.asC)) || !AntiHelper.a(Cx().getPageActivity(), this.asC, AntiHelper.OperationType.REPLY, PageType.FLOOR_IN_FLOOR)) {
                    if (this.asC != null && this.asC.getIfpost() == 0 && !TextUtils.isEmpty(this.asC.getForbid_info())) {
                        com.baidu.adp.lib.util.k.showToast(this.mContext.getPageActivity(), this.asC.getForbid_info());
                        return;
                    }
                } else {
                    return;
                }
            }
            if (this.asJ != null) {
                this.asJ.BW();
            }
            this.asz.aEl().setContent(this.asu);
            if (this.mPostId != null) {
                this.asz.aEl().setRepostId(this.ata.BU());
            }
            if (this.asv != null) {
                if (this.asv.getId() != null) {
                    this.asz.aEl().setVoice(this.asv.getId());
                    this.asz.aEl().setVoiceDuringTime(this.asv.duration);
                } else {
                    this.asz.aEl().setVoice(null);
                    this.asz.aEl().setVoiceDuringTime(-1);
                }
            } else {
                this.asz.aEl().setVoice(null);
                this.asz.aEl().setVoiceDuringTime(-1);
            }
            if (!this.asz.aEp()) {
                Cx().showToast(n.i.write_img_limit);
                return;
            }
            if (this.asJ != null) {
                this.asJ.BW();
            }
            if (!this.asz.aEm()) {
            }
        }
    }

    public void onDestory() {
        CA();
        this.asz.cancelLoadData();
    }

    public void onStop() {
    }

    public void CA() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.asu);
        writeData.setThreadId(this.mPostId);
        ae.d(this.mPostId, writeData);
    }

    public void CB() {
        ae.c(this.mPostId, (WriteData) null);
    }

    public void t(int i, String str) {
        if (AntiHelper.mC(i)) {
            AntiHelper.Q(Cx().getPageActivity(), str);
        } else if (i == 230277 || i == 230278) {
            fu(str);
        } else {
            Cx().showToast(str);
        }
    }

    public void a(AntiData antiData) {
        this.asC = antiData;
    }

    private void fu(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(Cx().getPageActivity());
        aVar.cC(str);
        aVar.b(n.i.know, new s(this));
        aVar.b(Cx()).tv();
    }

    private void r(ArrayList<String> arrayList) {
        if (Bu() != null) {
            Bu().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.asv = voiceModel;
    }

    public boolean CC() {
        return this.atb;
    }

    public void bq(boolean z) {
        this.atb = z;
    }

    public void fv(String str) {
        bq(true);
        Bu().oD();
        if (str != null && str.length() != 0) {
            fx(Cx().getResources().getString(n.i.reply_sub_floor).replace("%s", str));
        } else {
            fx("");
        }
        TiebaStatic.eventStat(Cx().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void fw(String str) {
        bq(true);
        fx(str);
        TiebaStatic.eventStat(Cx().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void CD() {
        bq(false);
        Bu().hide();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fx(String str) {
        if (Bu() != null) {
            Bu().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    public void fy(String str) {
        String string = TbadkCoreApplication.m411getInst().getResources().getString(n.i.reply_sub_floor);
        String str2 = "^" + string.replace("%s", ".+") + "$";
        if (ax.isEmpty(this.asu) || this.asu.matches(str2)) {
            if (this.asZ != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.asZ).lookingAt()) {
                    fw(this.asZ);
                    return;
                } else {
                    fv(str);
                    return;
                }
            }
            fv(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.asu);
        this.asZ = this.asu;
        if (matcher.lookingAt()) {
            fw(this.asu);
        } else {
            fv(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bp(boolean z) {
        if (Bu() != null) {
            Bu().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(a.d dVar) {
        this.atc = dVar;
    }

    public void a(c cVar) {
        this.asJ = cVar;
    }
}
