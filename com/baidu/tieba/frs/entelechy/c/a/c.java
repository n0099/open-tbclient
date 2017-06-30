package com.baidu.tieba.frs.entelechy.c.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.frs.bq;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.frs.smartsort.e;
import com.baidu.tieba.tbadkCore.util.s;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements c.b {
    final /* synthetic */ a chv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.chv = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        com.baidu.tieba.frs.entelechy.c.a.a.a aVar;
        int i2;
        TextView textView;
        int i3;
        r rVar;
        r rVar2;
        int i4;
        int i5;
        r rVar3;
        r rVar4;
        r rVar5;
        r rVar6;
        r rVar7;
        r rVar8;
        String str;
        r rVar9;
        if (!i.gX()) {
            rVar9 = this.chv.cdv;
            rVar9.showToast(w.l.neterror);
            cVar.dismiss();
            return;
        }
        aVar = this.chv.chq;
        bq bqVar = (bq) z.c(aVar.afT(), i);
        if (bqVar != null) {
            i2 = this.chv.chr;
            if (i2 != bqVar.ceQ) {
                this.chv.chs = true;
                textView = this.chv.cho;
                textView.setText(bqVar.name);
                i3 = this.chv.chr;
                if (i3 == 7) {
                    au auVar = new au("c11437");
                    auVar.r("obj_locate", bqVar.ceQ);
                    str = this.chv.bxM;
                    auVar.Z("fid", str);
                    TiebaStatic.log(auVar);
                }
                rVar = this.chv.cdv;
                if (rVar.adP() != null) {
                    rVar2 = this.chv.cdv;
                    FrsModelController adP = rVar2.adP();
                    i4 = this.chv.chr;
                    adP.iX(i4);
                    this.chv.chr = bqVar.ceQ;
                    cVar.dismiss();
                    i5 = this.chv.chr;
                    if (i5 != 7) {
                        v.GV();
                        s.bnr();
                    } else {
                        s.bnq();
                    }
                    rVar3 = this.chv.cdv;
                    if (rVar3.adP() != null) {
                        rVar4 = this.chv.cdv;
                        if (rVar4.adU() != null) {
                            rVar5 = this.chv.cdv;
                            rVar5.adP().iW(bqVar.ceQ);
                            rVar6 = this.chv.cdv;
                            rVar6.adU().startPullRefresh();
                            rVar7 = this.chv.cdv;
                            rVar7.adP().eM(true);
                            rVar8 = this.chv.cdv;
                            e.ahk().f(rVar8.adP().getForumName(), bqVar.ceQ, bqVar.name);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            cVar.dismiss();
            return;
        }
        cVar.dismiss();
    }
}
