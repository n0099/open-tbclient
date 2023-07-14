package com.baidu.tieba;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.searchbox.fluency.tracer.FpsTracer;
import com.baidu.tbadk.performanceLog.PerformanceLoggerHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* loaded from: classes5.dex */
public class au5 extends hu5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public au5() {
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

    @Override // com.baidu.tieba.hu5
    public void b(du5 du5Var) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, du5Var) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        eh a = fu5.a();
        a.b("action", "time_t");
        f(a, du5Var);
        String str2 = "1";
        if (du5Var.s) {
            str = "1";
        } else {
            str = "0";
        }
        a.b("ishttp", str);
        if (!du5Var.b) {
            str2 = "0";
        }
        a.b("issuccess", str2);
        a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
        a.b(Config.EXCEPTION_CRASH_TYPE, String.valueOf(du5Var.e));
        a.b("wt", String.valueOf(du5Var.p));
        a.b("qt", String.valueOf(du5Var.f));
        a.b("connt", String.valueOf(du5Var.g));
        a.b("rwt", String.valueOf(du5Var.h));
        a.b("dect", String.valueOf(du5Var.k));
        a.b("parset", String.valueOf(du5Var.l));
        a.b("rendert", String.valueOf(du5Var.o));
        a.b("ss", String.valueOf(du5Var.q));
        a.b("hs", String.valueOf(du5Var.r));
        if (du5Var.s && (i = du5Var.t) != 0) {
            a.b("salno", String.valueOf(i));
            long j = du5Var.u;
            if (j != 0) {
                a.b("scosttime", String.valueOf(j));
            }
        }
        int i2 = du5Var.v;
        if (i2 != 0) {
            a.c(DownloadConstants.DOWNLOAD_FEEDBACK_EXTRA_KEY_ERR_CODE, Integer.valueOf(i2));
        }
        if (du5Var.s) {
            a.b("c_logid", String.valueOf(du5Var.A));
        } else {
            a.b(PushConstants.SEQ_ID, String.valueOf(du5Var.z & 4294967295L));
        }
        BdStatisticsManager.getInstance().performance(this.a, a);
    }

    @Override // com.baidu.tieba.hu5
    public void c(du5 du5Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, du5Var, i) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow() || du5Var.D <= 0) {
            return;
        }
        eh a = fu5.a();
        a.b("action", "time_t");
        f(a, du5Var);
        a.b("pct", String.valueOf(du5Var.D));
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

    @Override // com.baidu.tieba.hu5
    public void d(du5 du5Var, boolean z) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, du5Var, z) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        if (!z || du5Var.B > 0) {
            if (!z && du5Var.C <= 0) {
                return;
            }
            eh a = fu5.a();
            a.b("action", "time_t");
            f(a, du5Var);
            if (z) {
                a.b("put", String.valueOf(du5Var.B));
            } else {
                a.b("pdt", String.valueOf(du5Var.C));
            }
            String str2 = "1";
            if (du5Var.s) {
                str = "1";
            } else {
                str = "0";
            }
            a.b("ishttp", str);
            if (!du5Var.b) {
                str2 = "0";
            }
            a.b("issuccess", str2);
            a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
            a.b("qt", String.valueOf(du5Var.f));
            a.b("connt", String.valueOf(du5Var.g));
            a.b("rwt", String.valueOf(du5Var.h));
            a.b("dect", String.valueOf(du5Var.k));
            a.b("parset", String.valueOf(du5Var.l));
            a.b("rendert", String.valueOf(du5Var.o));
            a.b("ss", String.valueOf(du5Var.q));
            a.b("hs", String.valueOf(du5Var.r));
            if (du5Var.s && (i = du5Var.t) != 0) {
                a.b("salno", String.valueOf(i));
                long j = du5Var.u;
                if (j != 0) {
                    a.b("scosttime", String.valueOf(j));
                }
            }
            int i2 = du5Var.v;
            if (i2 != 0) {
                a.c(DownloadConstants.DOWNLOAD_FEEDBACK_EXTRA_KEY_ERR_CODE, Integer.valueOf(i2));
            }
            BdStatisticsManager.getInstance().performance(this.a, a);
        }
    }

    public final void f(eh ehVar, du5 du5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, ehVar, du5Var) == null) && (du5Var instanceof zt5)) {
            ehVar.c("ptype", Integer.valueOf(((zt5) du5Var).F));
        }
    }
}
