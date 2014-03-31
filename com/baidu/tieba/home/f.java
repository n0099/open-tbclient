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
        n nVar;
        n nVar2;
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
        boolean isShow;
        n nVar3;
        com.baidu.tieba.model.o oVar6;
        n nVar4;
        n nVar5;
        n nVar6;
        eVar = this.a.g;
        UtilHelper.NetworkStateInfo d = UtilHelper.d(eVar);
        if (d == UtilHelper.NetworkStateInfo.UNAVAIL) {
            nVar6 = this.a.a;
            nVar6.i();
        }
        nVar = this.a.a;
        nVar.a(true, "");
        if (!pVar.b) {
            nVar2 = this.a.a;
            nVar2.d();
            if (pVar.a != null && pVar.a.equals("")) {
                eVar2 = this.a.g;
                eVar2.a(pVar.a);
            }
        } else {
            oVar6 = this.a.c;
            com.baidu.tieba.data.n e = oVar6.e();
            nVar4 = this.a.a;
            nVar4.a(e);
            nVar5 = this.a.a;
            nVar5.f();
        }
        if (pVar.c == 0 && d != UtilHelper.NetworkStateInfo.UNAVAIL) {
            new Handler().postDelayed(new g(this), 600L);
        }
        if (pVar.c == 1 && com.baidu.tieba.r.c().b()) {
            isShow = this.a.isShow();
            if (isShow) {
                nVar3 = this.a.a;
                nVar3.e();
                com.baidu.tieba.r.c().a(false);
            }
        }
        if (pVar.c == 1) {
            j = this.a.h;
            if (j > -1) {
                long currentTimeMillis = System.currentTimeMillis();
                j2 = this.a.h;
                oVar2 = this.a.c;
                long d2 = oVar2.d();
                j3 = this.a.h;
                long j4 = d2 - j3;
                oVar3 = this.a.c;
                long b = oVar3.b();
                oVar4 = this.a.c;
                long c = oVar4.c();
                oVar5 = this.a.c;
                TiebaStatic.a("op_forum_enter", currentTimeMillis - j2, j4, b, c, currentTimeMillis - oVar5.a());
                this.a.h = -1L;
            }
        }
        oVar = this.a.c;
        com.baidu.tieba.data.n e2 = oVar.e();
        if (e2.b() == 1) {
            if (!e2.i()) {
                eVar3 = this.a.g;
                String.format(eVar3.getString(com.baidu.tieba.a.k.signallforum_warning), Integer.valueOf(e2.c()));
                return;
            }
            return;
        }
        e2.d();
    }
}
