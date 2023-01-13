package com.baidu.tieba;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.fluency.tracer.FpsTracer;
import com.baidu.tbadk.performanceLog.PerformanceLoggerHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class dg5 extends kg5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public dg5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.kg5
    public void b(gg5 gg5Var) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, gg5Var) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        gh a = ig5.a();
        a.b("action", "time_t");
        f(a, gg5Var);
        String str2 = "1";
        if (gg5Var.s) {
            str = "1";
        } else {
            str = "0";
        }
        a.b("ishttp", str);
        if (!gg5Var.b) {
            str2 = "0";
        }
        a.b("issuccess", str2);
        a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
        a.b(Config.EXCEPTION_CRASH_TYPE, String.valueOf(gg5Var.e));
        a.b("wt", String.valueOf(gg5Var.p));
        a.b("qt", String.valueOf(gg5Var.f));
        a.b("connt", String.valueOf(gg5Var.g));
        a.b("rwt", String.valueOf(gg5Var.h));
        a.b("dect", String.valueOf(gg5Var.k));
        a.b("parset", String.valueOf(gg5Var.l));
        a.b("rendert", String.valueOf(gg5Var.o));
        a.b("ss", String.valueOf(gg5Var.q));
        a.b("hs", String.valueOf(gg5Var.r));
        if (gg5Var.s && (i = gg5Var.t) != 0) {
            a.b("salno", String.valueOf(i));
            long j = gg5Var.u;
            if (j != 0) {
                a.b("scosttime", String.valueOf(j));
            }
        }
        int i2 = gg5Var.v;
        if (i2 != 0) {
            a.c("errcode", Integer.valueOf(i2));
        }
        if (gg5Var.s) {
            a.b("c_logid", String.valueOf(gg5Var.A));
        } else {
            a.b("seq_id", String.valueOf(gg5Var.z & 4294967295L));
        }
        BdStatisticsManager.getInstance().performance(this.a, a);
    }

    @Override // com.baidu.tieba.kg5
    public void c(gg5 gg5Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gg5Var, i) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow() || gg5Var.D <= 0) {
            return;
        }
        gh a = ig5.a();
        a.b("action", "time_t");
        f(a, gg5Var);
        a.b("pct", String.valueOf(gg5Var.D));
        if (i != 0) {
            if (i != 40) {
                return;
            }
            a.b("pct_type", String.valueOf(101));
        } else {
            a.b("pct_type", String.valueOf(100));
        }
        BdStatisticsManager.getInstance().performance(this.a, a);
    }

    @Override // com.baidu.tieba.kg5
    public void d(gg5 gg5Var, boolean z) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, gg5Var, z) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        if (!z || gg5Var.B > 0) {
            if (!z && gg5Var.C <= 0) {
                return;
            }
            gh a = ig5.a();
            a.b("action", "time_t");
            f(a, gg5Var);
            if (z) {
                a.b("put", String.valueOf(gg5Var.B));
            } else {
                a.b("pdt", String.valueOf(gg5Var.C));
            }
            String str2 = "1";
            if (gg5Var.s) {
                str = "1";
            } else {
                str = "0";
            }
            a.b("ishttp", str);
            if (!gg5Var.b) {
                str2 = "0";
            }
            a.b("issuccess", str2);
            a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
            a.b("qt", String.valueOf(gg5Var.f));
            a.b("connt", String.valueOf(gg5Var.g));
            a.b("rwt", String.valueOf(gg5Var.h));
            a.b("dect", String.valueOf(gg5Var.k));
            a.b("parset", String.valueOf(gg5Var.l));
            a.b("rendert", String.valueOf(gg5Var.o));
            a.b("ss", String.valueOf(gg5Var.q));
            a.b("hs", String.valueOf(gg5Var.r));
            if (gg5Var.s && (i = gg5Var.t) != 0) {
                a.b("salno", String.valueOf(i));
                long j = gg5Var.u;
                if (j != 0) {
                    a.b("scosttime", String.valueOf(j));
                }
            }
            int i2 = gg5Var.v;
            if (i2 != 0) {
                a.c("errcode", Integer.valueOf(i2));
            }
            BdStatisticsManager.getInstance().performance(this.a, a);
        }
    }

    public final void f(gh ghVar, gg5 gg5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, ghVar, gg5Var) == null) && (gg5Var instanceof cg5)) {
            ghVar.c("ptype", Integer.valueOf(((cg5) gg5Var).F));
        }
    }
}
