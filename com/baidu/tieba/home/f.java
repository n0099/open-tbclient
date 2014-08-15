package com.baidu.tieba.home;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.ai;
import com.baidu.tieba.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tieba.model.q {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.a = eVar;
    }

    @Override // com.baidu.tieba.model.q
    public void a(com.baidu.tieba.model.o oVar) {
        BaseFragmentActivity baseFragmentActivity;
        p pVar;
        p pVar2;
        BaseFragmentActivity baseFragmentActivity2;
        com.baidu.tieba.model.n nVar;
        BaseFragmentActivity baseFragmentActivity3;
        p pVar3;
        BaseFragmentActivity baseFragmentActivity4;
        long j;
        long j2;
        com.baidu.tieba.model.n nVar2;
        long j3;
        com.baidu.tieba.model.n nVar3;
        com.baidu.tieba.model.n nVar4;
        com.baidu.tieba.model.n nVar5;
        boolean d_;
        p pVar4;
        com.baidu.tieba.model.n nVar6;
        p pVar5;
        p pVar6;
        p pVar7;
        baseFragmentActivity = this.a.h;
        UtilHelper.NetworkStateInfo netStatusInfo = UtilHelper.getNetStatusInfo(baseFragmentActivity);
        if (netStatusInfo == UtilHelper.NetworkStateInfo.UNAVAIL) {
            pVar7 = this.a.b;
            pVar7.l();
        }
        pVar = this.a.b;
        pVar.a(true, "");
        BdLog.d("OnLoadForumDataCallback, eventArgs.isOk=" + oVar.b);
        if (!oVar.b) {
            pVar2 = this.a.b;
            pVar2.d();
            if (oVar.a != null && oVar.a.equals("")) {
                baseFragmentActivity2 = this.a.h;
                baseFragmentActivity2.a(oVar.a);
            }
        } else {
            nVar6 = this.a.d;
            com.baidu.tieba.data.o e = nVar6.e();
            pVar5 = this.a.b;
            pVar5.a(e);
            pVar6 = this.a.b;
            pVar6.i();
        }
        if (oVar.c == 0 && netStatusInfo != UtilHelper.NetworkStateInfo.UNAVAIL) {
            new Handler().postDelayed(new g(this), 600L);
        }
        if (oVar.c == 1 && ai.c().b()) {
            d_ = this.a.d_();
            if (d_) {
                pVar4 = this.a.b;
                pVar4.h();
                ai.c().a(false);
            }
        }
        if (oVar.c == 1) {
            j = this.a.i;
            if (j > -1) {
                long currentTimeMillis = System.currentTimeMillis();
                j2 = this.a.i;
                nVar2 = this.a.d;
                long d = nVar2.d();
                j3 = this.a.i;
                long j4 = d - j3;
                nVar3 = this.a.d;
                long b = nVar3.b();
                nVar4 = this.a.d;
                long c = nVar4.c();
                nVar5 = this.a.d;
                TiebaStatic.page("op_forum_enter", currentTimeMillis - j2, j4, b, c, currentTimeMillis - nVar5.a());
                this.a.i = -1L;
            }
        }
        nVar = this.a.d;
        com.baidu.tieba.data.o e2 = nVar.e();
        if (e2 != null && e2.c() == 1) {
            if (!e2.k()) {
                baseFragmentActivity4 = this.a.h;
                String.format(baseFragmentActivity4.getString(x.signallforum_warning), Integer.valueOf(e2.d()));
            }
        } else if (e2 != null) {
            e2.e();
        }
        if (oVar.c == 1) {
            String b2 = com.baidu.tbadk.h.a().b("hao123_guide_show", "");
            baseFragmentActivity3 = this.a.h;
            String currentVerson = UtilHelper.getCurrentVerson(baseFragmentActivity3);
            if (!TextUtils.isEmpty(currentVerson) && !currentVerson.equals(b2) && TbadkApplication.m252getInst().isHao123HelperShouldOpen() && !TbadkApplication.m252getInst().isTiebaHelperOpen()) {
                pVar3 = this.a.b;
                pVar3.v();
                com.baidu.tbadk.h.a().a("hao123_guide_show", currentVerson);
            }
        }
    }
}
