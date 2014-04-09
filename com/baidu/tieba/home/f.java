package com.baidu.tieba.home;

import android.os.Handler;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f implements com.baidu.tieba.model.r {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.a = eVar;
    }

    @Override // com.baidu.tieba.model.r
    public final void a(com.baidu.tieba.model.p pVar) {
        com.baidu.tbadk.core.e eVar;
        o oVar;
        o oVar2;
        com.baidu.tbadk.core.e eVar2;
        com.baidu.tieba.model.o oVar3;
        com.baidu.tbadk.core.e eVar3;
        long j;
        long j2;
        com.baidu.tieba.model.o oVar4;
        long j3;
        com.baidu.tieba.model.o oVar5;
        com.baidu.tieba.model.o oVar6;
        com.baidu.tieba.model.o oVar7;
        boolean c_;
        o oVar8;
        com.baidu.tieba.model.o oVar9;
        o oVar10;
        o oVar11;
        o oVar12;
        eVar = this.a.h;
        UtilHelper.NetworkStateInfo d = UtilHelper.d(eVar);
        if (d == UtilHelper.NetworkStateInfo.UNAVAIL) {
            oVar12 = this.a.b;
            oVar12.j();
        }
        oVar = this.a.b;
        oVar.a(true, "");
        if (!pVar.b) {
            oVar2 = this.a.b;
            oVar2.d();
            if (pVar.a != null && pVar.a.equals("")) {
                eVar2 = this.a.h;
                eVar2.a(pVar.a);
            }
        } else {
            oVar9 = this.a.d;
            com.baidu.tieba.data.n e = oVar9.e();
            oVar10 = this.a.b;
            oVar10.a(e);
            oVar11 = this.a.b;
            oVar11.g();
        }
        if (pVar.c == 0 && d != UtilHelper.NetworkStateInfo.UNAVAIL) {
            new Handler().postDelayed(new g(this), 600L);
        }
        if (pVar.c == 1 && com.baidu.tieba.p.c().b()) {
            c_ = this.a.c_();
            if (c_) {
                oVar8 = this.a.b;
                oVar8.f();
                com.baidu.tieba.p.c().a(false);
            }
        }
        if (pVar.c == 1) {
            j = this.a.i;
            if (j > -1) {
                long currentTimeMillis = System.currentTimeMillis();
                j2 = this.a.i;
                oVar4 = this.a.d;
                long d2 = oVar4.d();
                j3 = this.a.i;
                long j4 = d2 - j3;
                oVar5 = this.a.d;
                long b = oVar5.b();
                oVar6 = this.a.d;
                long c = oVar6.c();
                oVar7 = this.a.d;
                TiebaStatic.a("op_forum_enter", currentTimeMillis - j2, j4, b, c, currentTimeMillis - oVar7.a());
                this.a.i = -1L;
            }
        }
        oVar3 = this.a.d;
        com.baidu.tieba.data.n e2 = oVar3.e();
        if (e2.b() == 1) {
            if (!e2.i()) {
                eVar3 = this.a.h;
                String.format(eVar3.getString(com.baidu.tieba.a.k.signallforum_warning), Integer.valueOf(e2.c()));
                return;
            }
            return;
        }
        e2.d();
    }
}
