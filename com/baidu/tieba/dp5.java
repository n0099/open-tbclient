package com.baidu.tieba;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.BdStatsItem;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.searchbox.fluency.tracer.FpsTracer;
import com.baidu.tbadk.performanceLog.PerformanceLogger;
import com.baidu.tbadk.performanceLog.PerformanceLoggerHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* loaded from: classes5.dex */
public class dp5 extends jp5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public dp5() {
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

    @Override // com.baidu.tieba.jp5
    public void a(gp5 gp5Var) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, gp5Var) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        BdStatsItem logItem = PerformanceLogger.getLogItem();
        logItem.append("action", "time_t");
        e(logItem, gp5Var);
        String str2 = "1";
        if (gp5Var.s) {
            str = "1";
        } else {
            str = "0";
        }
        logItem.append("ishttp", str);
        if (!gp5Var.b) {
            str2 = "0";
        }
        logItem.append("issuccess", str2);
        logItem.append(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
        logItem.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(gp5Var.e));
        logItem.append("wt", String.valueOf(gp5Var.p));
        logItem.append("qt", String.valueOf(gp5Var.f));
        logItem.append("connt", String.valueOf(gp5Var.g));
        logItem.append("rwt", String.valueOf(gp5Var.h));
        logItem.append("dect", String.valueOf(gp5Var.k));
        logItem.append("parset", String.valueOf(gp5Var.l));
        logItem.append("rendert", String.valueOf(gp5Var.o));
        logItem.append("ss", String.valueOf(gp5Var.q));
        logItem.append("hs", String.valueOf(gp5Var.r));
        if (gp5Var.s && (i = gp5Var.t) != 0) {
            logItem.append("salno", String.valueOf(i));
            long j = gp5Var.u;
            if (j != 0) {
                logItem.append("scosttime", String.valueOf(j));
            }
        }
        int i2 = gp5Var.v;
        if (i2 != 0) {
            logItem.append(DownloadConstants.DOWNLOAD_FEEDBACK_EXTRA_KEY_ERR_CODE, Integer.valueOf(i2));
        }
        if (gp5Var.s) {
            logItem.append("c_logid", String.valueOf(gp5Var.A));
        } else {
            logItem.append(PushConstants.SEQ_ID, String.valueOf(gp5Var.z & 4294967295L));
        }
        BdStatisticsManager.getInstance().performance(this.subType, logItem);
    }

    @Override // com.baidu.tieba.jp5
    public void b(gp5 gp5Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gp5Var, i) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow() || gp5Var.D <= 0) {
            return;
        }
        BdStatsItem logItem = PerformanceLogger.getLogItem();
        logItem.append("action", "time_t");
        e(logItem, gp5Var);
        logItem.append("pct", String.valueOf(gp5Var.D));
        if (i != 0) {
            if (i != 40) {
                return;
            }
            logItem.append("pct_type", String.valueOf(101));
        } else {
            logItem.append("pct_type", String.valueOf(100));
        }
        BdStatisticsManager.getInstance().performance(this.subType, logItem);
    }

    @Override // com.baidu.tieba.jp5
    public void c(gp5 gp5Var, boolean z) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, gp5Var, z) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        if (!z || gp5Var.B > 0) {
            if (!z && gp5Var.C <= 0) {
                return;
            }
            BdStatsItem logItem = PerformanceLogger.getLogItem();
            logItem.append("action", "time_t");
            e(logItem, gp5Var);
            if (z) {
                logItem.append("put", String.valueOf(gp5Var.B));
            } else {
                logItem.append("pdt", String.valueOf(gp5Var.C));
            }
            String str2 = "1";
            if (gp5Var.s) {
                str = "1";
            } else {
                str = "0";
            }
            logItem.append("ishttp", str);
            if (!gp5Var.b) {
                str2 = "0";
            }
            logItem.append("issuccess", str2);
            logItem.append(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
            logItem.append("qt", String.valueOf(gp5Var.f));
            logItem.append("connt", String.valueOf(gp5Var.g));
            logItem.append("rwt", String.valueOf(gp5Var.h));
            logItem.append("dect", String.valueOf(gp5Var.k));
            logItem.append("parset", String.valueOf(gp5Var.l));
            logItem.append("rendert", String.valueOf(gp5Var.o));
            logItem.append("ss", String.valueOf(gp5Var.q));
            logItem.append("hs", String.valueOf(gp5Var.r));
            if (gp5Var.s && (i = gp5Var.t) != 0) {
                logItem.append("salno", String.valueOf(i));
                long j = gp5Var.u;
                if (j != 0) {
                    logItem.append("scosttime", String.valueOf(j));
                }
            }
            int i2 = gp5Var.v;
            if (i2 != 0) {
                logItem.append(DownloadConstants.DOWNLOAD_FEEDBACK_EXTRA_KEY_ERR_CODE, Integer.valueOf(i2));
            }
            BdStatisticsManager.getInstance().performance(this.subType, logItem);
        }
    }

    public final void e(BdStatsItem bdStatsItem, gp5 gp5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, bdStatsItem, gp5Var) == null) && (gp5Var instanceof cp5)) {
            bdStatsItem.append("ptype", Integer.valueOf(((cp5) gp5Var).F));
        }
    }
}
