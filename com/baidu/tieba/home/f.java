package com.baidu.tieba.home;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.ai;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tieba.model.p {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.a = eVar;
    }

    @Override // com.baidu.tieba.model.p
    public void a(com.baidu.tieba.model.n nVar) {
        BaseFragmentActivity baseFragmentActivity;
        p pVar;
        p pVar2;
        BaseFragmentActivity baseFragmentActivity2;
        com.baidu.tieba.model.m mVar;
        BaseFragmentActivity baseFragmentActivity3;
        p pVar3;
        BaseFragmentActivity baseFragmentActivity4;
        long j;
        long j2;
        com.baidu.tieba.model.m mVar2;
        long j3;
        com.baidu.tieba.model.m mVar3;
        com.baidu.tieba.model.m mVar4;
        com.baidu.tieba.model.m mVar5;
        boolean d_;
        p pVar4;
        com.baidu.tieba.model.m mVar6;
        p pVar5;
        p pVar6;
        p pVar7;
        baseFragmentActivity = this.a.h;
        UtilHelper.NetworkStateInfo netStatusInfo = UtilHelper.getNetStatusInfo(baseFragmentActivity);
        if (netStatusInfo == UtilHelper.NetworkStateInfo.UNAVAIL) {
            pVar7 = this.a.b;
            pVar7.m();
        }
        pVar = this.a.b;
        pVar.a(true, "");
        BdLog.d("OnLoadForumDataCallback, eventArgs.isOk=" + nVar.b);
        if (!nVar.b) {
            pVar2 = this.a.b;
            pVar2.e();
            if (nVar.a != null && nVar.a.equals("")) {
                baseFragmentActivity2 = this.a.h;
                baseFragmentActivity2.a(nVar.a);
            }
        } else {
            mVar6 = this.a.d;
            com.baidu.tieba.data.o e = mVar6.e();
            pVar5 = this.a.b;
            pVar5.a(e);
            pVar6 = this.a.b;
            pVar6.j();
        }
        if (nVar.c == 0 && netStatusInfo != UtilHelper.NetworkStateInfo.UNAVAIL) {
            new Handler().postDelayed(new g(this), 600L);
        }
        if (nVar.c == 1 && ai.c().b()) {
            d_ = this.a.d_();
            if (d_) {
                pVar4 = this.a.b;
                pVar4.i();
                ai.c().a(false);
            }
        }
        if (nVar.c == 1) {
            j = this.a.i;
            if (j > -1) {
                long currentTimeMillis = System.currentTimeMillis();
                j2 = this.a.i;
                mVar2 = this.a.d;
                long d = mVar2.d();
                j3 = this.a.i;
                long j4 = d - j3;
                mVar3 = this.a.d;
                long b = mVar3.b();
                mVar4 = this.a.d;
                long c = mVar4.c();
                mVar5 = this.a.d;
                TiebaStatic.page("op_forum_enter", currentTimeMillis - j2, j4, b, c, currentTimeMillis - mVar5.a());
                this.a.i = -1L;
            }
        }
        mVar = this.a.d;
        com.baidu.tieba.data.o e2 = mVar.e();
        if (e2.c() == 1) {
            if (!e2.k()) {
                baseFragmentActivity4 = this.a.h;
                String.format(baseFragmentActivity4.getString(y.signallforum_warning), Integer.valueOf(e2.d()));
            }
        } else {
            e2.e();
        }
        if (nVar.c == 1) {
            String b2 = com.baidu.tbadk.i.a().b("hao123_guide_show", "");
            baseFragmentActivity3 = this.a.h;
            String currentVerson = UtilHelper.getCurrentVerson(baseFragmentActivity3);
            if (!TextUtils.isEmpty(currentVerson) && !currentVerson.equals(b2) && TbadkApplication.m252getInst().isHao123HelperShouldOpen() && !TbadkApplication.m252getInst().isTiebaHelperOpen()) {
                pVar3 = this.a.b;
                pVar3.w();
                com.baidu.tbadk.i.a().a("hao123_guide_show", currentVerson);
            }
        }
    }
}
