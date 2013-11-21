package com.baidu.tieba.home;

import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tieba.model.w {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EnterForumActivity f1445a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(EnterForumActivity enterForumActivity) {
        this.f1445a = enterForumActivity;
    }

    @Override // com.baidu.tieba.model.w
    public void a(com.baidu.tieba.model.u uVar) {
        BaseFragmentActivity baseFragmentActivity;
        o oVar;
        o oVar2;
        BaseFragmentActivity baseFragmentActivity2;
        com.baidu.tieba.model.t tVar;
        o oVar3;
        BaseFragmentActivity baseFragmentActivity3;
        o oVar4;
        com.baidu.tieba.model.t tVar2;
        o oVar5;
        Boolean bool;
        o oVar6;
        o oVar7;
        boolean z = false;
        boolean z2 = true;
        baseFragmentActivity = this.f1445a.i;
        UtilHelper.NetworkStateInfo i = UtilHelper.i(baseFragmentActivity);
        if (i == UtilHelper.NetworkStateInfo.UNAVAIL) {
            oVar7 = this.f1445a.c;
            oVar7.o();
        }
        oVar = this.f1445a.c;
        oVar.a(true, "");
        if (uVar.b) {
            tVar2 = this.f1445a.e;
            com.baidu.tieba.data.r a2 = tVar2.a();
            oVar5 = this.f1445a.c;
            bool = this.f1445a.h;
            oVar5.a(a2, bool.booleanValue());
            oVar6 = this.f1445a.c;
            oVar6.i();
        } else {
            oVar2 = this.f1445a.c;
            oVar2.f();
            if (uVar.f1934a != null && uVar.f1934a.equals("")) {
                baseFragmentActivity2 = this.f1445a.i;
                baseFragmentActivity2.a(uVar.f1934a);
            }
        }
        if (uVar.c == 0 && i != UtilHelper.NetworkStateInfo.UNAVAIL) {
            oVar4 = this.f1445a.c;
            oVar4.e();
        }
        tVar = this.f1445a.e;
        com.baidu.tieba.data.r a3 = tVar.a();
        String str = null;
        if (a3.a() == 1) {
            if (a3.g()) {
                z = true;
            } else {
                baseFragmentActivity3 = this.f1445a.i;
                str = String.format(baseFragmentActivity3.getString(R.string.signallforum_warning), Integer.valueOf(a3.b()));
            }
        } else {
            str = a3.c();
            z2 = false;
        }
        oVar3 = this.f1445a.c;
        oVar3.a(z2, z, str);
    }
}
