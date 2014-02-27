package com.baidu.tieba.home;

import android.os.Handler;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.cb;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g implements com.baidu.tieba.model.n {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.a = fVar;
    }

    @Override // com.baidu.tieba.model.n
    public final void a(com.baidu.tieba.model.l lVar) {
        com.baidu.tieba.k kVar;
        n nVar;
        n nVar2;
        com.baidu.tieba.k kVar2;
        com.baidu.tieba.model.k kVar3;
        boolean z;
        n nVar3;
        com.baidu.tieba.k kVar4;
        long j;
        long j2;
        com.baidu.tieba.model.k kVar5;
        long j3;
        com.baidu.tieba.model.k kVar6;
        com.baidu.tieba.model.k kVar7;
        com.baidu.tieba.model.k kVar8;
        boolean z2;
        boolean d;
        n nVar4;
        com.baidu.tieba.model.k kVar9;
        n nVar5;
        n nVar6;
        n nVar7;
        kVar = this.a.h;
        UtilHelper.NetworkStateInfo h = UtilHelper.h(kVar);
        if (h == UtilHelper.NetworkStateInfo.UNAVAIL) {
            nVar7 = this.a.b;
            nVar7.k();
        }
        nVar = this.a.b;
        nVar.a(true, "");
        if (!lVar.b) {
            nVar2 = this.a.b;
            nVar2.d();
            if (lVar.a != null && lVar.a.equals("")) {
                kVar2 = this.a.h;
                kVar2.a(lVar.a);
            }
        } else {
            kVar9 = this.a.d;
            com.baidu.tieba.data.s e = kVar9.e();
            nVar5 = this.a.b;
            nVar5.a(e);
            nVar6 = this.a.b;
            nVar6.g();
        }
        if (lVar.c == 0 && h != UtilHelper.NetworkStateInfo.UNAVAIL) {
            new Handler().postDelayed(new h(this), 600L);
        }
        if (lVar.c == 1) {
            z2 = this.a.i;
            if (z2) {
                d = this.a.d();
                if (d) {
                    nVar4 = this.a.b;
                    nVar4.e();
                    this.a.i = false;
                }
            }
        }
        if (lVar.c == 1) {
            j = this.a.j;
            if (j > -1) {
                long currentTimeMillis = System.currentTimeMillis();
                j2 = this.a.j;
                kVar5 = this.a.d;
                long d2 = kVar5.d();
                j3 = this.a.j;
                long j4 = d2 - j3;
                kVar6 = this.a.d;
                long b = kVar6.b();
                kVar7 = this.a.d;
                long c = kVar7.c();
                kVar8 = this.a.d;
                cb.a("op_forum_enter", currentTimeMillis - j2, j4, b, c, currentTimeMillis - kVar8.a());
                this.a.j = -1L;
            }
        }
        kVar3 = this.a.d;
        com.baidu.tieba.data.s e2 = kVar3.e();
        boolean z3 = false;
        String str = null;
        if (e2.b() == 1) {
            z = true;
            if (!e2.h()) {
                kVar4 = this.a.h;
                str = String.format(kVar4.getString(R.string.signallforum_warning), Integer.valueOf(e2.c()));
            } else {
                z3 = true;
            }
        } else {
            z = false;
            str = e2.d();
        }
        nVar3 = this.a.b;
        nVar3.a(z, z3, str);
    }
}
