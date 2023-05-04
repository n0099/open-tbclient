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
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class gn5 extends en5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public gn5() {
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

    public void b(cn5 cn5Var) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, cn5Var) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        og a = en5.a();
        a.b("action", "time");
        String str2 = "0";
        if (!cn5Var.s) {
            str = "0";
        } else {
            str = "1";
        }
        a.b("ishttp", str);
        if (cn5Var.b) {
            str2 = "1";
        }
        a.b("issuccess", str2);
        a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
        a.b("wt", String.valueOf(cn5Var.p));
        a.b("qt", String.valueOf(cn5Var.f));
        a.b("connt", String.valueOf(cn5Var.g));
        a.b("rwt", String.valueOf(cn5Var.h));
        a.b("fbt", String.valueOf(cn5Var.i));
        a.b("abt", String.valueOf(cn5Var.j));
        a.b("dect", String.valueOf(cn5Var.k));
        a.b("parset", String.valueOf(cn5Var.l));
        a.b("tqt", String.valueOf(cn5Var.n));
        a.b("rendert", String.valueOf(cn5Var.o));
        a.b("ss", String.valueOf(cn5Var.q));
        a.b("hs", String.valueOf(cn5Var.r));
        if (cn5Var.s && (i = cn5Var.t) != 0) {
            a.b("salno", String.valueOf(i));
            long j = cn5Var.u;
            if (j != 0) {
                a.b("scosttime", String.valueOf(j));
            }
        }
        if (cn5Var.s) {
            a.b("hrtn", String.valueOf(cn5Var.w));
            a.b("hrtt", String.valueOf(cn5Var.x));
        }
        int i2 = cn5Var.v;
        if (i2 != 0) {
            a.c("errcode", Integer.valueOf(i2));
        }
        if (cn5Var.y) {
            a.b("pt", "1");
        } else {
            a.b("sysct", String.valueOf(cn5Var.c));
            a.b(Config.EXCEPTION_CRASH_TYPE, String.valueOf(cn5Var.e));
            a.b(WebvttCueParser.ENTITY_LESS_THAN, String.valueOf(cn5Var.d));
            a.b("df", String.valueOf(cn5Var.m));
        }
        if (cn5Var.s) {
            a.b("c_logid", String.valueOf(cn5Var.A));
            long j2 = cn5Var.z;
            if (j2 != 0) {
                a.b(PushConstants.SEQ_ID, String.valueOf(j2 & 4294967295L));
            }
        } else {
            a.b(PushConstants.SEQ_ID, String.valueOf(cn5Var.z & 4294967295L));
        }
        HashMap<String, String> hashMap = cn5Var.E;
        if (hashMap != null && !hashMap.isEmpty()) {
            for (Map.Entry<String, String> entry : cn5Var.E.entrySet()) {
                a.b(entry.getKey(), entry.getValue());
            }
        }
        BdStatisticsManager.getInstance().performance(this.a, a);
    }

    public void c(cn5 cn5Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cn5Var, i) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow() || cn5Var.D <= 0) {
            return;
        }
        og a = en5.a();
        a.b("action", "time");
        a.b("pct", String.valueOf(cn5Var.D));
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

    public void d(cn5 cn5Var, boolean z) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, cn5Var, z) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        if (!z || cn5Var.B > 0) {
            if (!z && cn5Var.C <= 0) {
                return;
            }
            og a = en5.a();
            a.b("action", "time");
            if (z) {
                a.b("put", String.valueOf(cn5Var.B));
            } else {
                a.b("pdt", String.valueOf(cn5Var.C));
            }
            String str2 = "1";
            if (cn5Var.s) {
                str = "1";
            } else {
                str = "0";
            }
            a.b("ishttp", str);
            if (!cn5Var.b) {
                str2 = "0";
            }
            a.b("issuccess", str2);
            a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
            a.b("qt", String.valueOf(cn5Var.f));
            a.b("connt", String.valueOf(cn5Var.g));
            a.b("rwt", String.valueOf(cn5Var.h));
            a.b("dect", String.valueOf(cn5Var.k));
            a.b("parset", String.valueOf(cn5Var.l));
            a.b("rendert", String.valueOf(cn5Var.o));
            a.b("ss", String.valueOf(cn5Var.q));
            a.b("hs", String.valueOf(cn5Var.r));
            if (cn5Var.s && (i = cn5Var.t) != 0) {
                a.b("salno", String.valueOf(i));
                long j = cn5Var.u;
                if (j != 0) {
                    a.b("scosttime", String.valueOf(j));
                }
            }
            int i2 = cn5Var.v;
            if (i2 != 0) {
                a.c("errcode", Integer.valueOf(i2));
            }
            BdStatisticsManager.getInstance().performance(this.a, a);
        }
    }

    public void e(wm5 wm5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, wm5Var) != null) || wm5Var == null || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        og a = en5.a();
        a.b("action", FpsTracer.UBC_KEY_FLUENCY);
        a.b(FpsConstants.REPORT_FPS, String.valueOf(wm5Var.b()));
        BdStatisticsManager.getInstance().performance(this.a, a);
        og a2 = en5.a();
        a2.b("action", "mem");
        a2.b("memp", String.valueOf(PerformanceLoggerHelper.getInstance().getCurrentUsedMemory()));
        BdStatisticsManager.getInstance().performance(this.a, a2);
    }
}
