package com.baidu.tieba.flutter.plugin.performanceMonitor;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import c.a.d.f.n.a;
import c.a.p.e.a;
import c.a.q0.r0.j;
import c.a.r0.z0.a.h.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.statistics.k;
import com.baidu.searchbox.fluency.tracer.FpsTracer;
import com.baidu.searchbox.fluency.utils.FpsConstants;
import com.baidu.searchbox.perfframe.ioc.Constant;
import com.baidu.tbadk.performanceLog.PerformanceLoggerHelper;
import com.baidu.tieba.flutter.base.util.OpenFlutter;
import com.baidu.tieba.flutter.plugin.performanceMonitor.PerformanceMonitorAuto;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.util.UriUtil;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class PerformanceMonitorPlugin implements FlutterPlugin, PerformanceMonitorAuto.HostPerformanceMonitor {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, String> flutterEngineStartInfo;
    public transient /* synthetic */ FieldHolder $fh;
    public final CustomMessageListener mFlutterEngineInitListener;

    /* loaded from: classes5.dex */
    public class PerfCPULogAsync extends BdAsyncTask<String, Integer, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final a mItem;
        public final String mPage;
        public final /* synthetic */ PerformanceMonitorPlugin this$0;

        public PerfCPULogAsync(PerformanceMonitorPlugin performanceMonitorPlugin, String str, a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {performanceMonitorPlugin, str, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = performanceMonitorPlugin;
            this.mPage = str;
            this.mItem = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bool) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                this.mItem.b("memp", String.valueOf(PerformanceLoggerHelper.getInstance().getCurrentUsedMemory()));
                this.mItem.b("cpu", PerformanceLoggerHelper.getInstance().getCpuUsageStatisticString());
                BdStatisticsManager.getInstance().performance(this.mPage, this.mItem);
                return Boolean.TRUE;
            }
            return (Boolean) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1065146764, "Lcom/baidu/tieba/flutter/plugin/performanceMonitor/PerformanceMonitorPlugin;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1065146764, "Lcom/baidu/tieba/flutter/plugin/performanceMonitor/PerformanceMonitorPlugin;");
                return;
            }
        }
        flutterEngineStartInfo = new HashMap<>();
    }

    public PerformanceMonitorPlugin() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mFlutterEngineInitListener = new CustomMessageListener(this, 2921451) { // from class: com.baidu.tieba.flutter.plugin.performanceMonitor.PerformanceMonitorPlugin.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PerformanceMonitorPlugin this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof HashMap)) {
                    PerformanceMonitorPlugin.flutterEngineStartInfo.clear();
                    PerformanceMonitorPlugin.flutterEngineStartInfo.putAll((HashMap) customResponsedMessage.getData());
                }
            }
        };
        c.a.p.e.a.b().c(new a.InterfaceC0224a(this) { // from class: com.baidu.tieba.flutter.plugin.performanceMonitor.PerformanceMonitorPlugin.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PerformanceMonitorPlugin this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // c.a.p.e.a.InterfaceC0224a
            public void report(String str, HashMap<String, Object> hashMap) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, str, hashMap) == null) {
                    if ("uploadFpsData".equals(str)) {
                        this.this$0.uploadFpsData(hashMap);
                    } else if ("uploadOpenPageData".equals(str)) {
                        this.this$0.uploadOpenPageData(hashMap);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 9)
    public void uploadFpsData(HashMap<String, Object> hashMap) {
        HashMap hashMap2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, this, hashMap) == null) || !PerformanceLoggerHelper.getInstance().isSmallFlow() || hashMap == null || (hashMap2 = (HashMap) hashMap.get(Constant.KEY_BUSINESS)) == null) {
            return;
        }
        Long l = (Long) hashMap.get("time");
        String str = (String) hashMap2.get("flutterpage");
        if (str == null || str.isEmpty()) {
            return;
        }
        HashMap hashMap3 = (HashMap) hashMap2.get("flutter_fps");
        double doubleValue = Double.valueOf((String) hashMap3.get("catonrate")).doubleValue();
        double doubleValue2 = Double.valueOf((String) hashMap3.get("deviation")).doubleValue();
        List list = (List) hashMap3.get("fpslist");
        int size = list.size();
        double d2 = 0.0d;
        double d3 = 0.0d;
        double d4 = 0.0d;
        int i2 = 0;
        while (true) {
            double d5 = doubleValue2;
            if (i2 < size) {
                List list2 = list;
                Map map = (Map) list.get(i2);
                d2 += Double.valueOf((String) map.get(FpsConstants.REPORT_FPS)).doubleValue();
                d3 += Double.valueOf((String) map.get("cpu")).doubleValue();
                d4 += Double.valueOf((String) map.get("gpu")).doubleValue();
                i2++;
                doubleValue2 = d5;
                list = list2;
            } else {
                double d6 = size;
                c.a.d.f.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("pfmonitor");
                statsItem.c("time", l);
                statsItem.c(FpsConstants.REPORT_FPS, Double.valueOf(d2 / d6));
                statsItem.c("cpu", Double.valueOf(d3 / d6));
                statsItem.c("gpu", Double.valueOf(d4 / d6));
                statsItem.c("catonrate", Double.valueOf(doubleValue));
                statsItem.c("deviation", Double.valueOf(d5));
                statsItem.b("action", "fps_perf");
                BdStatisticsManager.getInstance().performance(str, statsItem);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 9)
    public void uploadOpenPageData(HashMap<String, Object> hashMap) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, this, hashMap) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            HashMap<String, Integer> baseSwitchs = SwitchManager.getInstance().getBaseSwitchs();
            if (((baseSwitchs == null || !baseSwitchs.containsKey("flutter_open_disable")) ? 0 : baseSwitchs.get("flutter_open_disable").intValue()) >= 1 || hashMap == null || hashMap == null || hashMap.get("viewCreateTime") == null || ((Double) hashMap.get("viewCreateTime")).doubleValue() <= 0.0d || (str = (String) hashMap.get("pageName")) == null || str.isEmpty()) {
                return;
            }
            if (OpenFlutter.ACTIVITY_SIGN_TOGETHER.equals(str)) {
                str = "sign_all_flt";
            } else if (OpenFlutter.FRAGMENT_MYTAB.equals(str)) {
                str = "user_center_flt";
            }
            c.a.d.f.n.a a = j.a();
            a.b("action", "time");
            a.c("ishttp", hashMap.get("isHttp"));
            a.b("issuccess", hashMap.get("errCode") == BasicPushStatus.SUCCESS_CODE ? "1" : "0");
            a.b("nettype", PerformanceLoggerHelper.getInstance().getNetType());
            if (hashMap.containsKey("whiteTime") && (hashMap.get("whiteTime") instanceof Double)) {
                a.c("wt", Double.valueOf(((Double) hashMap.get("whiteTime")).doubleValue() * 1000.0d));
            }
            a.c("qt", hashMap.get("queneTime"));
            a.c("connt", hashMap.get("netConTime"));
            a.c("rwt", hashMap.get("netRWTime"));
            a.c("fbt", hashMap.get("firstByteTime"));
            a.c("abt", hashMap.get("allDataReadTime"));
            a.c("dect", hashMap.get("dataDeCompressTime"));
            a.c("tqt", hashMap.get("taskWaitTime"));
            if (hashMap.containsKey("dataParseTime") && (hashMap.get("dataParseTime") instanceof Double)) {
                a.c("parset", Double.valueOf(((Double) hashMap.get("dataParseTime")).doubleValue() * 1000.0d));
            }
            if (hashMap.containsKey("drawTime") && (hashMap.get("drawTime") instanceof Double)) {
                a.c("rendert", Double.valueOf(((Double) hashMap.get("drawTime")).doubleValue() * 1000.0d));
            }
            if (hashMap.get("isHttp") == "1") {
                a.c("hrtn", hashMap.get("httpRetryNum"));
                a.c("hrtt", hashMap.get("httpRetryCostTime"));
            }
            if (hashMap.get("errCode") != "0") {
                a.c("errcode", hashMap.get("errCode"));
            }
            if (hashMap.containsKey("viewCreateTime") && (hashMap.get("viewCreateTime") instanceof Double)) {
                a.c("ct", Double.valueOf(((Double) hashMap.get("viewCreateTime")).doubleValue() * 1000.0d));
            }
            if (hashMap.containsKey("channelTransTime") && (hashMap.get("channelTransTime") instanceof Double)) {
                a.c("transt", Double.valueOf(((Double) hashMap.get("channelTransTime")).doubleValue() * 1000.0d));
            }
            if (hashMap.containsKey("dartItemParseTime") && (hashMap.get("dartItemParseTime") instanceof Double)) {
                a.c("dpt", Double.valueOf(((Double) hashMap.get("dartItemParseTime")).doubleValue() * 1000.0d));
            }
            if (hashMap.containsKey("reqWaitTime") && (hashMap.get("reqWaitTime") instanceof Double)) {
                a.c("rqwt", Double.valueOf(((Double) hashMap.get("reqWaitTime")).doubleValue() * 1000.0d));
            }
            if (hashMap.containsKey("renderTime") && (hashMap.get("renderTime") instanceof Double)) {
                a.c("rdt", Double.valueOf(((Double) hashMap.get("renderTime")).doubleValue() * 1000.0d));
            }
            a.c("hs", hashMap.get("httpSize"));
            if (hashMap.containsKey("navigationCostTime")) {
                a.c("navigationCostTime", hashMap.get("navigationCostTime"));
            }
            if (hashMap.containsKey("netRequestCostTime")) {
                a.c("netRequestCostTime", hashMap.get("netRequestCostTime"));
            }
            if (hashMap.containsKey("pageRenderCostTime")) {
                a.c("pageRenderCostTime", hashMap.get("pageRenderCostTime"));
            }
            if (hashMap.containsKey("openPageTotalCostTime")) {
                a.c("openPageTotalCostTime", hashMap.get("openPageTotalCostTime"));
            }
            BdStatisticsManager.getInstance().performance(str, a);
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, flutterPluginBinding) == null) {
            e.e(flutterPluginBinding.getBinaryMessenger(), this);
            MessageManager.getInstance().registerListener(this.mFlutterEngineInitListener);
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, flutterPluginBinding) == null) {
            MessageManager.getInstance().unRegisterListener(this.mFlutterEngineInitListener);
            e.e(flutterPluginBinding.getBinaryMessenger(), null);
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.performanceMonitor.PerformanceMonitorAuto.HostPerformanceMonitor
    public void reportEnginePerformance(PerformanceMonitorAuto.MapParam mapParam) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mapParam) == null) || mapParam.getParams() == null) {
            return;
        }
        HashMap params = mapParam.getParams();
        c.a.d.f.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("pfmonitor");
        statsItem.b("action", "engine_perf");
        HashMap<String, String> hashMap = flutterEngineStartInfo;
        if (hashMap != null && !hashMap.isEmpty()) {
            for (Map.Entry<String, String> entry : flutterEngineStartInfo.entrySet()) {
                statsItem.b(entry.getKey(), entry.getValue());
            }
        }
        if (params != null && !params.isEmpty()) {
            for (Map.Entry entry2 : params.entrySet()) {
                statsItem.c(entry2.getKey(), entry2.getValue());
            }
        }
        BdStatisticsManager.getInstance().performance("engine", statsItem);
    }

    @Override // com.baidu.tieba.flutter.plugin.performanceMonitor.PerformanceMonitorAuto.HostPerformanceMonitor
    public void reportFPSPerformance(PerformanceMonitorAuto.FpsParam fpsParam) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fpsParam) == null) {
            String page = fpsParam.getPage();
            double doubleValue = fpsParam.getFps().doubleValue();
            c.a.d.f.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("pfmonitor");
            statsItem.b("action", FpsTracer.UBC_KEY_FLUENCY);
            statsItem.b("page", page);
            statsItem.c(FpsConstants.REPORT_FPS, Double.valueOf(doubleValue));
            statsItem.c("flutter", 1);
            HashMap fatal = fpsParam.getFatal();
            if (fatal != null) {
                if (fatal.containsKey("blocks") && (fatal.get("blocks") instanceof String)) {
                    statsItem.c("fatal_blocks", fatal.get("blocks"));
                }
                if (fatal.containsKey("vast") && (fatal.get("vast") instanceof Boolean)) {
                    statsItem.c("fatal_vast", fatal.get("vast"));
                }
            }
            HashMap cont = fpsParam.getCont();
            if (cont != null) {
                if (cont.containsKey("blocks") && (cont.get("blocks") instanceof String)) {
                    statsItem.c("cont_blocks", cont.get("blocks"));
                }
                if (cont.containsKey("vast") && (cont.get("vast") instanceof Boolean)) {
                    statsItem.c("cont_vast", cont.get("vast"));
                }
            }
            PerfCPULogAsync perfCPULogAsync = new PerfCPULogAsync(this, page, statsItem);
            perfCPULogAsync.setSelfExecute(true);
            perfCPULogAsync.execute(new String[0]);
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.performanceMonitor.PerformanceMonitorAuto.HostPerformanceMonitor
    public void reportImageLoadPerformance(PerformanceMonitorAuto.MapParam mapParam) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, mapParam) == null) || mapParam.getParams() == null) {
            return;
        }
        HashMap params = mapParam.getParams();
        c.a.d.f.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("pfmonitor");
        statsItem.b("action", "image_perf");
        statsItem.c(UriUtil.LOCAL_RESOURCE_SCHEME, params.get("isBundleFile"));
        statsItem.c("try", params.get("tryTimes"));
        statsItem.c("ct", params.get("contentType"));
        statsItem.c("dc", params.get("dartCodecCost"));
        statsItem.c(k.f32451h, params.get("loadingCost"));
        statsItem.c("trans", params.get("channelTransTime"));
        statsItem.c("cc", params.get("codecCost"));
        statsItem.c("tc", params.get("totalCost"));
        statsItem.c("ds", params.get("imageDataSize"));
        statsItem.c("nt", params.get("netType"));
        BdStatisticsManager.getInstance().performance("flt", statsItem);
    }

    @Override // com.baidu.tieba.flutter.plugin.performanceMonitor.PerformanceMonitorAuto.HostPerformanceMonitor
    public void reportPageLoadPerformance(PerformanceMonitorAuto.MapParam mapParam) {
        HashMap params;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, mapParam) == null) || !PerformanceLoggerHelper.getInstance().isSmallFlow() || mapParam.getParams() == null || (params = mapParam.getParams()) == null || params.get("viewCreateTime") == null || ((Double) params.get("viewCreateTime")).doubleValue() <= 0.0d) {
            return;
        }
        String str = (String) params.get("pageName");
        if (OpenFlutter.ACTIVITY_SIGN_TOGETHER.equals(str)) {
            str = "sign_all_flt";
        } else if (OpenFlutter.FRAGMENT_MYTAB.equals(str)) {
            str = "user_center_flt";
        }
        c.a.d.f.n.a a = j.a();
        a.b("action", "time");
        a.c("ishttp", params.get("isHttp"));
        a.b("issuccess", params.get("errCode") == BasicPushStatus.SUCCESS_CODE ? "1" : "0");
        a.b("nettype", PerformanceLoggerHelper.getInstance().getNetType());
        if (params.containsKey("whiteTime") && (params.get("whiteTime") instanceof Double)) {
            a.c("wt", Double.valueOf(((Double) params.get("whiteTime")).doubleValue() * 1000.0d));
        }
        a.c("qt", params.get("queneTime"));
        a.c("connt", params.get("netConTime"));
        a.c("rwt", params.get("netRWTime"));
        a.c("fbt", params.get("firstByteTime"));
        a.c("abt", params.get("allDataReadTime"));
        a.c("dect", params.get("dataDeCompressTime"));
        a.c("tqt", params.get("taskWaitTime"));
        if (params.containsKey("dataParseTime") && (params.get("dataParseTime") instanceof Double)) {
            a.c("parset", Double.valueOf(((Double) params.get("dataParseTime")).doubleValue() * 1000.0d));
        }
        if (params.containsKey("drawTime") && (params.get("drawTime") instanceof Double)) {
            a.c("rendert", Double.valueOf(((Double) params.get("drawTime")).doubleValue() * 1000.0d));
        }
        if (params.get("isHttp") == "1") {
            a.c("hrtn", params.get("httpRetryNum"));
            a.c("hrtt", params.get("httpRetryCostTime"));
        }
        if (params.get("errCode") != "0") {
            a.c("errcode", params.get("errCode"));
        }
        if (params.containsKey("viewCreateTime") && (params.get("viewCreateTime") instanceof Double)) {
            a.c("ct", Double.valueOf(((Double) params.get("viewCreateTime")).doubleValue() * 1000.0d));
        }
        if (params.containsKey("channelTransTime") && (params.get("channelTransTime") instanceof Double)) {
            a.c("transt", Double.valueOf(((Double) params.get("channelTransTime")).doubleValue() * 1000.0d));
        }
        if (params.containsKey("dartItemParseTime") && (params.get("dartItemParseTime") instanceof Double)) {
            a.c("dpt", Double.valueOf(((Double) params.get("dartItemParseTime")).doubleValue() * 1000.0d));
        }
        if (params.containsKey("reqWaitTime") && (params.get("reqWaitTime") instanceof Double)) {
            a.c("rqwt", Double.valueOf(((Double) params.get("reqWaitTime")).doubleValue() * 1000.0d));
        }
        if (params.containsKey("renderTime") && (params.get("renderTime") instanceof Double)) {
            a.c("rdt", Double.valueOf(((Double) params.get("renderTime")).doubleValue() * 1000.0d));
        }
        a.c("hs", params.get("httpSize"));
        BdStatisticsManager.getInstance().performance(str, a);
    }
}
