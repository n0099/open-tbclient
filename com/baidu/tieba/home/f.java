package com.baidu.tieba.home;

import android.os.Handler;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.ad;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tieba.model.r {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.a = eVar;
    }

    @Override // com.baidu.tieba.model.r
    public void a(com.baidu.tieba.model.p pVar) {
        com.baidu.tbadk.core.e eVar;
        p pVar2;
        p pVar3;
        com.baidu.tbadk.core.e eVar2;
        com.baidu.tieba.model.o oVar;
        com.baidu.tbadk.core.e eVar3;
        long j;
        long j2;
        com.baidu.tieba.model.o oVar2;
        long j3;
        com.baidu.tieba.model.o oVar3;
        com.baidu.tieba.model.o oVar4;
        com.baidu.tieba.model.o oVar5;
        boolean d_;
        p pVar4;
        com.baidu.tieba.model.o oVar6;
        p pVar5;
        p pVar6;
        p pVar7;
        eVar = this.a.h;
        UtilHelper.NetworkStateInfo netStatusInfo = UtilHelper.getNetStatusInfo(eVar);
        if (netStatusInfo == UtilHelper.NetworkStateInfo.UNAVAIL) {
            pVar7 = this.a.b;
            pVar7.k();
        }
        pVar2 = this.a.b;
        pVar2.a(true, "");
        if (!pVar.b) {
            pVar3 = this.a.b;
            pVar3.c();
            if (pVar.a != null && pVar.a.equals("")) {
                eVar2 = this.a.h;
                eVar2.a(pVar.a);
            }
        } else {
            oVar6 = this.a.d;
            com.baidu.tieba.data.n e = oVar6.e();
            pVar5 = this.a.b;
            pVar5.a(e);
            pVar6 = this.a.b;
            pVar6.h();
        }
        if (pVar.c == 0 && netStatusInfo != UtilHelper.NetworkStateInfo.UNAVAIL) {
            new Handler().postDelayed(new g(this), 600L);
        }
        if (pVar.c == 1 && ad.c().b()) {
            d_ = this.a.d_();
            if (d_) {
                pVar4 = this.a.b;
                pVar4.g();
                ad.c().a(false);
            }
        }
        if (pVar.c == 1) {
            j = this.a.i;
            if (j > -1) {
                long currentTimeMillis = System.currentTimeMillis();
                j2 = this.a.i;
                oVar2 = this.a.d;
                long d = oVar2.d();
                j3 = this.a.i;
                long j4 = d - j3;
                oVar3 = this.a.d;
                long b = oVar3.b();
                oVar4 = this.a.d;
                long c = oVar4.c();
                oVar5 = this.a.d;
                TiebaStatic.page("op_forum_enter", currentTimeMillis - j2, j4, b, c, currentTimeMillis - oVar5.a());
                this.a.i = -1L;
            }
        }
        oVar = this.a.d;
        com.baidu.tieba.data.n e2 = oVar.e();
        if (e2.c() == 1) {
            if (!e2.j()) {
                eVar3 = this.a.h;
                String.format(eVar3.getString(com.baidu.tieba.u.signallforum_warning), Integer.valueOf(e2.d()));
                return;
            }
            return;
        }
        e2.e();
    }
}
