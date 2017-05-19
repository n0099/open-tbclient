package com.baidu.tieba.frs.entelechy.c.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.util.u;
import com.baidu.tieba.frs.bo;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.frs.smartsort.e;
import com.baidu.tieba.tbadkCore.util.s;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements c.b {
    final /* synthetic */ a bTu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bTu = aVar;
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
        if (!i.gY()) {
            rVar9 = this.bTu.bPw;
            rVar9.showToast(w.l.neterror);
            cVar.dismiss();
            return;
        }
        aVar = this.bTu.bTp;
        bo boVar = (bo) x.c(aVar.aaX(), i);
        if (boVar != null) {
            i2 = this.bTu.bTq;
            if (i2 != boVar.bQR) {
                this.bTu.bTr = true;
                textView = this.bTu.bTn;
                textView.setText(boVar.name);
                i3 = this.bTu.bTq;
                if (i3 == 7) {
                    as asVar = new as("c11437");
                    asVar.s("obj_locate", boVar.bQR);
                    str = this.bTu.btj;
                    asVar.aa("fid", str);
                    TiebaStatic.log(asVar);
                }
                rVar = this.bTu.bPw;
                if (rVar.YU() != null) {
                    rVar2 = this.bTu.bPw;
                    FrsModelController YU = rVar2.YU();
                    i4 = this.bTu.bTq;
                    YU.in(i4);
                    this.bTu.bTq = boVar.bQR;
                    cVar.dismiss();
                    i5 = this.bTu.bTq;
                    if (i5 != 7) {
                        u.GE();
                        s.bhJ();
                    } else {
                        s.bhI();
                    }
                    rVar3 = this.bTu.bPw;
                    if (rVar3.YU() != null) {
                        rVar4 = this.bTu.bPw;
                        if (rVar4.YZ() != null) {
                            rVar5 = this.bTu.bPw;
                            rVar5.YU().im(boVar.bQR);
                            rVar6 = this.bTu.bPw;
                            rVar6.YZ().startPullRefresh();
                            rVar7 = this.bTu.bPw;
                            rVar7.YU().ee(true);
                            rVar8 = this.bTu.bPw;
                            e.aco().f(rVar8.YU().getForumName(), boVar.bQR, boVar.name);
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
