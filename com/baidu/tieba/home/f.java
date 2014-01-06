package com.baidu.tieba.home;

import android.os.Handler;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tieba.model.w {
    final /* synthetic */ EnterForumActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(EnterForumActivity enterForumActivity) {
        this.a = enterForumActivity;
    }

    @Override // com.baidu.tieba.model.w
    public void a(com.baidu.tieba.model.u uVar) {
        BaseFragmentActivity baseFragmentActivity;
        l lVar;
        l lVar2;
        BaseFragmentActivity baseFragmentActivity2;
        com.baidu.tieba.model.t tVar;
        l lVar3;
        BaseFragmentActivity baseFragmentActivity3;
        com.baidu.tieba.model.t tVar2;
        l lVar4;
        l lVar5;
        l lVar6;
        boolean z = false;
        boolean z2 = true;
        baseFragmentActivity = this.a.g;
        UtilHelper.NetworkStateInfo g = UtilHelper.g(baseFragmentActivity);
        if (g == UtilHelper.NetworkStateInfo.UNAVAIL) {
            lVar6 = this.a.a;
            lVar6.m();
        }
        lVar = this.a.a;
        lVar.a(true, "");
        if (uVar.b) {
            tVar2 = this.a.c;
            com.baidu.tieba.data.r a = tVar2.a();
            lVar4 = this.a.a;
            lVar4.a(a);
            lVar5 = this.a.a;
            lVar5.i();
        } else {
            lVar2 = this.a.a;
            lVar2.f();
            if (uVar.a != null && uVar.a.equals("")) {
                baseFragmentActivity2 = this.a.g;
                baseFragmentActivity2.a(uVar.a);
            }
        }
        if (uVar.c == 0 && g != UtilHelper.NetworkStateInfo.UNAVAIL) {
            new Handler().postDelayed(new g(this), 600L);
        }
        tVar = this.a.c;
        com.baidu.tieba.data.r a2 = tVar.a();
        String str = null;
        if (a2.a() == 1) {
            if (a2.g()) {
                z = true;
            } else {
                baseFragmentActivity3 = this.a.g;
                str = String.format(baseFragmentActivity3.getString(R.string.signallforum_warning), Integer.valueOf(a2.b()));
            }
        } else {
            str = a2.c();
            z2 = false;
        }
        lVar3 = this.a.a;
        lVar3.a(z2, z, str);
    }
}
