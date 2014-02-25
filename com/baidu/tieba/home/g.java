package com.baidu.tieba.home;

import android.os.Handler;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.tieba.model.n {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.a = fVar;
    }

    @Override // com.baidu.tieba.model.n
    public void a(com.baidu.tieba.model.l lVar) {
        com.baidu.tieba.k kVar;
        n nVar;
        n nVar2;
        com.baidu.tieba.k kVar2;
        com.baidu.tieba.model.k kVar3;
        n nVar3;
        com.baidu.tieba.k kVar4;
        boolean z;
        boolean b;
        n nVar4;
        com.baidu.tieba.model.k kVar5;
        n nVar5;
        n nVar6;
        n nVar7;
        boolean z2 = false;
        boolean z3 = true;
        kVar = this.a.h;
        UtilHelper.NetworkStateInfo h = UtilHelper.h(kVar);
        if (h == UtilHelper.NetworkStateInfo.UNAVAIL) {
            nVar7 = this.a.b;
            nVar7.o();
        }
        nVar = this.a.b;
        nVar.a(true, "");
        if (!lVar.b) {
            nVar2 = this.a.b;
            nVar2.f();
            if (lVar.a != null && lVar.a.equals("")) {
                kVar2 = this.a.h;
                kVar2.a(lVar.a);
            }
        } else {
            kVar5 = this.a.d;
            com.baidu.tieba.data.s a = kVar5.a();
            nVar5 = this.a.b;
            nVar5.a(a);
            nVar6 = this.a.b;
            nVar6.k();
        }
        if (lVar.c == 0 && h != UtilHelper.NetworkStateInfo.UNAVAIL) {
            new Handler().postDelayed(new h(this), 600L);
        }
        if (lVar.c == 1) {
            z = this.a.i;
            if (z) {
                b = this.a.b();
                if (b) {
                    nVar4 = this.a.b;
                    nVar4.i();
                    this.a.i = false;
                }
            }
        }
        kVar3 = this.a.d;
        com.baidu.tieba.data.s a2 = kVar3.a();
        String str = null;
        if (a2.b() == 1) {
            if (a2.h()) {
                z2 = true;
            } else {
                kVar4 = this.a.h;
                str = String.format(kVar4.getString(R.string.signallforum_warning), Integer.valueOf(a2.c()));
            }
        } else {
            str = a2.d();
            z3 = false;
        }
        nVar3 = this.a.b;
        nVar3.a(z3, z2, str);
    }
}
