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
public class dt5 extends jt5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public dt5() {
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

    @Override // com.baidu.tieba.jt5
    public void a(gt5 gt5Var) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, gt5Var) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        BdStatsItem logItem = PerformanceLogger.getLogItem();
        logItem.append("action", "time_t");
        e(logItem, gt5Var);
        String str2 = "1";
        if (gt5Var.s) {
            str = "1";
        } else {
            str = "0";
        }
        logItem.append("ishttp", str);
        if (!gt5Var.b) {
            str2 = "0";
        }
        logItem.append("issuccess", str2);
        logItem.append(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
        logItem.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(gt5Var.e));
        logItem.append("wt", String.valueOf(gt5Var.p));
        logItem.append("qt", String.valueOf(gt5Var.f));
        logItem.append("connt", String.valueOf(gt5Var.g));
        logItem.append("rwt", String.valueOf(gt5Var.h));
        logItem.append("dect", String.valueOf(gt5Var.k));
        logItem.append("parset", String.valueOf(gt5Var.l));
        logItem.append("rendert", String.valueOf(gt5Var.o));
        logItem.append("ss", String.valueOf(gt5Var.q));
        logItem.append("hs", String.valueOf(gt5Var.r));
        if (gt5Var.s && (i = gt5Var.t) != 0) {
            logItem.append("salno", String.valueOf(i));
            long j = gt5Var.u;
            if (j != 0) {
                logItem.append("scosttime", String.valueOf(j));
            }
        }
        int i2 = gt5Var.v;
        if (i2 != 0) {
            logItem.append(DownloadConstants.DOWNLOAD_FEEDBACK_EXTRA_KEY_ERR_CODE, Integer.valueOf(i2));
        }
        if (gt5Var.s) {
            logItem.append("c_logid", String.valueOf(gt5Var.A));
        } else {
            logItem.append(PushConstants.SEQ_ID, String.valueOf(gt5Var.z & 4294967295L));
        }
        BdStatisticsManager.getInstance().performance(this.subType, logItem);
    }

    @Override // com.baidu.tieba.jt5
    public void b(gt5 gt5Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gt5Var, i) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow() || gt5Var.D <= 0) {
            return;
        }
        BdStatsItem logItem = PerformanceLogger.getLogItem();
        logItem.append("action", "time_t");
        e(logItem, gt5Var);
        logItem.append("pct", String.valueOf(gt5Var.D));
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

    @Override // com.baidu.tieba.jt5
    public void c(gt5 gt5Var, boolean z) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, gt5Var, z) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        if (!z || gt5Var.B > 0) {
            if (!z && gt5Var.C <= 0) {
                return;
            }
            BdStatsItem logItem = PerformanceLogger.getLogItem();
            logItem.append("action", "time_t");
            e(logItem, gt5Var);
            if (z) {
                logItem.append("put", String.valueOf(gt5Var.B));
            } else {
                logItem.append("pdt", String.valueOf(gt5Var.C));
            }
            String str2 = "1";
            if (gt5Var.s) {
                str = "1";
            } else {
                str = "0";
            }
            logItem.append("ishttp", str);
            if (!gt5Var.b) {
                str2 = "0";
            }
            logItem.append("issuccess", str2);
            logItem.append(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
            logItem.append("qt", String.valueOf(gt5Var.f));
            logItem.append("connt", String.valueOf(gt5Var.g));
            logItem.append("rwt", String.valueOf(gt5Var.h));
            logItem.append("dect", String.valueOf(gt5Var.k));
            logItem.append("parset", String.valueOf(gt5Var.l));
            logItem.append("rendert", String.valueOf(gt5Var.o));
            logItem.append("ss", String.valueOf(gt5Var.q));
            logItem.append("hs", String.valueOf(gt5Var.r));
            if (gt5Var.s && (i = gt5Var.t) != 0) {
                logItem.append("salno", String.valueOf(i));
                long j = gt5Var.u;
                if (j != 0) {
                    logItem.append("scosttime", String.valueOf(j));
                }
            }
            int i2 = gt5Var.v;
            if (i2 != 0) {
                logItem.append(DownloadConstants.DOWNLOAD_FEEDBACK_EXTRA_KEY_ERR_CODE, Integer.valueOf(i2));
            }
            BdStatisticsManager.getInstance().performance(this.subType, logItem);
        }
    }

    public final void e(BdStatsItem bdStatsItem, gt5 gt5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, bdStatsItem, gt5Var) == null) && (gt5Var instanceof ct5)) {
            bdStatsItem.append("ptype", Integer.valueOf(((ct5) gt5Var).F));
        }
    }
}
