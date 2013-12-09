package com.baidu.tieba.home;

import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tieba.model.w {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EnterForumActivity f1491a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(EnterForumActivity enterForumActivity) {
        this.f1491a = enterForumActivity;
    }

    @Override // com.baidu.tieba.model.w
    public void a(com.baidu.tieba.model.u uVar) {
        BaseFragmentActivity baseFragmentActivity;
        k kVar;
        k kVar2;
        BaseFragmentActivity baseFragmentActivity2;
        com.baidu.tieba.model.t tVar;
        k kVar3;
        BaseFragmentActivity baseFragmentActivity3;
        k kVar4;
        com.baidu.tieba.model.t tVar2;
        k kVar5;
        k kVar6;
        k kVar7;
        boolean z = false;
        boolean z2 = true;
        baseFragmentActivity = this.f1491a.g;
        UtilHelper.NetworkStateInfo g = UtilHelper.g(baseFragmentActivity);
        if (g == UtilHelper.NetworkStateInfo.UNAVAIL) {
            kVar7 = this.f1491a.f1433a;
            kVar7.m();
        }
        kVar = this.f1491a.f1433a;
        kVar.a(true, "");
        if (uVar.b) {
            tVar2 = this.f1491a.c;
            com.baidu.tieba.data.r a2 = tVar2.a();
            kVar5 = this.f1491a.f1433a;
            kVar5.a(a2);
            kVar6 = this.f1491a.f1433a;
            kVar6.i();
        } else {
            kVar2 = this.f1491a.f1433a;
            kVar2.f();
            if (uVar.f2047a != null && uVar.f2047a.equals("")) {
                baseFragmentActivity2 = this.f1491a.g;
                baseFragmentActivity2.b(uVar.f2047a);
            }
        }
        if (uVar.c == 0 && g != UtilHelper.NetworkStateInfo.UNAVAIL) {
            kVar4 = this.f1491a.f1433a;
            kVar4.e();
        }
        tVar = this.f1491a.c;
        com.baidu.tieba.data.r a3 = tVar.a();
        String str = null;
        if (a3.a() == 1) {
            if (a3.g()) {
                z = true;
            } else {
                baseFragmentActivity3 = this.f1491a.g;
                str = String.format(baseFragmentActivity3.getString(R.string.signallforum_warning), Integer.valueOf(a3.b()));
            }
        } else {
            str = a3.c();
            z2 = false;
        }
        kVar3 = this.f1491a.f1433a;
        kVar3.a(z2, z, str);
    }
}
