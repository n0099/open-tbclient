package com.baidu.tieba;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.fluency.tracer.FpsTracer;
import com.baidu.searchbox.fluency.utils.FpsConstants;
import com.baidu.tbadk.performanceLog.PerformanceLoggerHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class gd5 extends ed5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public gd5() {
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

    public void b(cd5 cd5Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, cd5Var) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            lh a = ed5.a();
            a.b("action", "time");
            a.b("ishttp", cd5Var.s ? "1" : "0");
            a.b("issuccess", cd5Var.b ? "1" : "0");
            a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
            a.b("wt", String.valueOf(cd5Var.p));
            a.b("qt", String.valueOf(cd5Var.f));
            a.b("connt", String.valueOf(cd5Var.g));
            a.b("rwt", String.valueOf(cd5Var.h));
            a.b("fbt", String.valueOf(cd5Var.i));
            a.b("abt", String.valueOf(cd5Var.j));
            a.b("dect", String.valueOf(cd5Var.k));
            a.b("parset", String.valueOf(cd5Var.l));
            a.b("tqt", String.valueOf(cd5Var.n));
            a.b("rendert", String.valueOf(cd5Var.o));
            a.b("ss", String.valueOf(cd5Var.q));
            a.b("hs", String.valueOf(cd5Var.r));
            if (cd5Var.s && (i = cd5Var.t) != 0) {
                a.b("salno", String.valueOf(i));
                long j = cd5Var.u;
                if (j != 0) {
                    a.b("scosttime", String.valueOf(j));
                }
            }
            if (cd5Var.s) {
                a.b("hrtn", String.valueOf(cd5Var.w));
                a.b("hrtt", String.valueOf(cd5Var.x));
            }
            int i2 = cd5Var.v;
            if (i2 != 0) {
                a.c("errcode", Integer.valueOf(i2));
            }
            if (cd5Var.y) {
                a.b(Config.PLATFORM_TYPE, "1");
            } else {
                a.b("sysct", String.valueOf(cd5Var.c));
                a.b(Config.EXCEPTION_CRASH_TYPE, String.valueOf(cd5Var.e));
                a.b(WebvttCueParser.ENTITY_LESS_THAN, String.valueOf(cd5Var.d));
                a.b("df", String.valueOf(cd5Var.m));
            }
            if (cd5Var.s) {
                a.b("c_logid", String.valueOf(cd5Var.A));
                long j2 = cd5Var.z;
                if (j2 != 0) {
                    a.b("seq_id", String.valueOf(j2 & 4294967295L));
                }
            } else {
                a.b("seq_id", String.valueOf(cd5Var.z & 4294967295L));
            }
            HashMap<String, String> hashMap = cd5Var.E;
            if (hashMap != null && !hashMap.isEmpty()) {
                for (Map.Entry<String, String> entry : cd5Var.E.entrySet()) {
                    a.b(entry.getKey(), entry.getValue());
                }
            }
            BdStatisticsManager.getInstance().performance(this.a, a);
        }
    }

    public void c(cd5 cd5Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cd5Var, i) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow() && cd5Var.D > 0) {
            lh a = ed5.a();
            a.b("action", "time");
            a.b("pct", String.valueOf(cd5Var.D));
            if (i == 0) {
                a.b("pct_type", String.valueOf(100));
            } else if (i != 40) {
                return;
            } else {
                a.b("pct_type", String.valueOf(101));
            }
            BdStatisticsManager.getInstance().performance(this.a, a);
        }
    }

    public void d(cd5 cd5Var, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, cd5Var, z) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            if (!z || cd5Var.B > 0) {
                if (z || cd5Var.C > 0) {
                    lh a = ed5.a();
                    a.b("action", "time");
                    if (z) {
                        a.b("put", String.valueOf(cd5Var.B));
                    } else {
                        a.b("pdt", String.valueOf(cd5Var.C));
                    }
                    a.b("ishttp", cd5Var.s ? "1" : "0");
                    a.b("issuccess", cd5Var.b ? "1" : "0");
                    a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
                    a.b("qt", String.valueOf(cd5Var.f));
                    a.b("connt", String.valueOf(cd5Var.g));
                    a.b("rwt", String.valueOf(cd5Var.h));
                    a.b("dect", String.valueOf(cd5Var.k));
                    a.b("parset", String.valueOf(cd5Var.l));
                    a.b("rendert", String.valueOf(cd5Var.o));
                    a.b("ss", String.valueOf(cd5Var.q));
                    a.b("hs", String.valueOf(cd5Var.r));
                    if (cd5Var.s && (i = cd5Var.t) != 0) {
                        a.b("salno", String.valueOf(i));
                        long j = cd5Var.u;
                        if (j != 0) {
                            a.b("scosttime", String.valueOf(j));
                        }
                    }
                    int i2 = cd5Var.v;
                    if (i2 != 0) {
                        a.c("errcode", Integer.valueOf(i2));
                    }
                    BdStatisticsManager.getInstance().performance(this.a, a);
                }
            }
        }
    }

    public void e(wc5 wc5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, wc5Var) == null) && wc5Var != null && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            lh a = ed5.a();
            a.b("action", FpsTracer.UBC_KEY_FLUENCY);
            a.b(FpsConstants.REPORT_FPS, String.valueOf(wc5Var.b()));
            BdStatisticsManager.getInstance().performance(this.a, a);
            lh a2 = ed5.a();
            a2.b("action", "mem");
            a2.b("memp", String.valueOf(PerformanceLoggerHelper.getInstance().getCurrentUsedMemory()));
            BdStatisticsManager.getInstance().performance(this.a, a2);
        }
    }
}
