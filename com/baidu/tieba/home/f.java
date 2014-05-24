package com.baidu.tieba.home;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.ai;
import com.baidu.tieba.y;
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
        BaseFragmentActivity baseFragmentActivity;
        q qVar;
        q qVar2;
        BaseFragmentActivity baseFragmentActivity2;
        com.baidu.tieba.model.o oVar;
        BaseFragmentActivity baseFragmentActivity3;
        q qVar3;
        BaseFragmentActivity baseFragmentActivity4;
        long j;
        long j2;
        com.baidu.tieba.model.o oVar2;
        long j3;
        com.baidu.tieba.model.o oVar3;
        com.baidu.tieba.model.o oVar4;
        com.baidu.tieba.model.o oVar5;
        boolean d_;
        q qVar4;
        com.baidu.tieba.model.o oVar6;
        q qVar5;
        q qVar6;
        q qVar7;
        baseFragmentActivity = this.a.h;
        UtilHelper.NetworkStateInfo netStatusInfo = UtilHelper.getNetStatusInfo(baseFragmentActivity);
        if (netStatusInfo == UtilHelper.NetworkStateInfo.UNAVAIL) {
            qVar7 = this.a.b;
            qVar7.m();
        }
        qVar = this.a.b;
        qVar.a(true, "");
        if (!pVar.b) {
            qVar2 = this.a.b;
            qVar2.e();
            if (pVar.a != null && pVar.a.equals("")) {
                baseFragmentActivity2 = this.a.h;
                baseFragmentActivity2.a(pVar.a);
            }
        } else {
            oVar6 = this.a.d;
            com.baidu.tieba.data.n e = oVar6.e();
            qVar5 = this.a.b;
            qVar5.a(e);
            qVar6 = this.a.b;
            qVar6.j();
        }
        if (pVar.c == 0 && netStatusInfo != UtilHelper.NetworkStateInfo.UNAVAIL) {
            new Handler().postDelayed(new g(this), 600L);
        }
        if (pVar.c == 1 && ai.c().b()) {
            d_ = this.a.d_();
            if (d_) {
                qVar4 = this.a.b;
                qVar4.i();
                ai.c().a(false);
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
                baseFragmentActivity4 = this.a.h;
                String.format(baseFragmentActivity4.getString(y.signallforum_warning), Integer.valueOf(e2.d()));
            }
        } else {
            e2.e();
        }
        if (pVar.c == 1) {
            String b2 = com.baidu.tbadk.f.a().b("hao123_guide_show", "");
            baseFragmentActivity3 = this.a.h;
            String currentVerson = UtilHelper.getCurrentVerson(baseFragmentActivity3);
            if (!TextUtils.isEmpty(currentVerson) && !currentVerson.equals(b2) && TbadkApplication.m252getInst().isHao123HelperShouldOpen() && !TbadkApplication.m252getInst().isTiebaHelperOpen()) {
                qVar3 = this.a.b;
                qVar3.w();
                com.baidu.tbadk.f.a().a("hao123_guide_show", currentVerson);
            }
        }
    }
}
