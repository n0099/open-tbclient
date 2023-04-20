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
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* loaded from: classes4.dex */
public class gm5 extends nm5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public gm5() {
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

    @Override // com.baidu.tieba.nm5
    public void b(jm5 jm5Var) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, jm5Var) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        og a = lm5.a();
        a.b("action", "time_t");
        f(a, jm5Var);
        String str2 = "1";
        if (jm5Var.s) {
            str = "1";
        } else {
            str = "0";
        }
        a.b("ishttp", str);
        if (!jm5Var.b) {
            str2 = "0";
        }
        a.b("issuccess", str2);
        a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
        a.b(Config.EXCEPTION_CRASH_TYPE, String.valueOf(jm5Var.e));
        a.b("wt", String.valueOf(jm5Var.p));
        a.b("qt", String.valueOf(jm5Var.f));
        a.b("connt", String.valueOf(jm5Var.g));
        a.b("rwt", String.valueOf(jm5Var.h));
        a.b("dect", String.valueOf(jm5Var.k));
        a.b("parset", String.valueOf(jm5Var.l));
        a.b("rendert", String.valueOf(jm5Var.o));
        a.b("ss", String.valueOf(jm5Var.q));
        a.b("hs", String.valueOf(jm5Var.r));
        if (jm5Var.s && (i = jm5Var.t) != 0) {
            a.b("salno", String.valueOf(i));
            long j = jm5Var.u;
            if (j != 0) {
                a.b("scosttime", String.valueOf(j));
            }
        }
        int i2 = jm5Var.v;
        if (i2 != 0) {
            a.c("errcode", Integer.valueOf(i2));
        }
        if (jm5Var.s) {
            a.b("c_logid", String.valueOf(jm5Var.A));
        } else {
            a.b(PushConstants.SEQ_ID, String.valueOf(jm5Var.z & 4294967295L));
        }
        BdStatisticsManager.getInstance().performance(this.a, a);
    }

    @Override // com.baidu.tieba.nm5
    public void c(jm5 jm5Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jm5Var, i) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow() || jm5Var.D <= 0) {
            return;
        }
        og a = lm5.a();
        a.b("action", "time_t");
        f(a, jm5Var);
        a.b("pct", String.valueOf(jm5Var.D));
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

    @Override // com.baidu.tieba.nm5
    public void d(jm5 jm5Var, boolean z) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, jm5Var, z) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        if (!z || jm5Var.B > 0) {
            if (!z && jm5Var.C <= 0) {
                return;
            }
            og a = lm5.a();
            a.b("action", "time_t");
            f(a, jm5Var);
            if (z) {
                a.b("put", String.valueOf(jm5Var.B));
            } else {
                a.b("pdt", String.valueOf(jm5Var.C));
            }
            String str2 = "1";
            if (jm5Var.s) {
                str = "1";
            } else {
                str = "0";
            }
            a.b("ishttp", str);
            if (!jm5Var.b) {
                str2 = "0";
            }
            a.b("issuccess", str2);
            a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
            a.b("qt", String.valueOf(jm5Var.f));
            a.b("connt", String.valueOf(jm5Var.g));
            a.b("rwt", String.valueOf(jm5Var.h));
            a.b("dect", String.valueOf(jm5Var.k));
            a.b("parset", String.valueOf(jm5Var.l));
            a.b("rendert", String.valueOf(jm5Var.o));
            a.b("ss", String.valueOf(jm5Var.q));
            a.b("hs", String.valueOf(jm5Var.r));
            if (jm5Var.s && (i = jm5Var.t) != 0) {
                a.b("salno", String.valueOf(i));
                long j = jm5Var.u;
                if (j != 0) {
                    a.b("scosttime", String.valueOf(j));
                }
            }
            int i2 = jm5Var.v;
            if (i2 != 0) {
                a.c("errcode", Integer.valueOf(i2));
            }
            BdStatisticsManager.getInstance().performance(this.a, a);
        }
    }

    public final void f(og ogVar, jm5 jm5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, ogVar, jm5Var) == null) && (jm5Var instanceof fm5)) {
            ogVar.c("ptype", Integer.valueOf(((fm5) jm5Var).F));
        }
    }
}
