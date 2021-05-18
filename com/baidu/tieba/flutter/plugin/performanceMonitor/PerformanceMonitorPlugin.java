package com.baidu.tieba.flutter.plugin.performanceMonitor;

import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.mobstat.Config;
import com.baidu.tieba.flutter.base.util.OpenFlutter;
import com.baidu.tieba.flutter.plugin.performanceMonitor.PerformanceMonitorAuto;
import com.baidu.wallet.router.RouterCallback;
import com.facebook.common.util.UriUtil;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import d.a.c.e.n.a;
import d.a.j0.m0.j;
import d.a.j0.m0.k;
import d.a.k0.m0.a.g.e;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class PerformanceMonitorPlugin implements FlutterPlugin, PerformanceMonitorAuto.HostPerformanceMonitor {
    public static HashMap<String, String> flutterEngineStartInfo = new HashMap<>();
    public final CustomMessageListener mFlutterEngineInitListener = new CustomMessageListener(2921451) { // from class: com.baidu.tieba.flutter.plugin.performanceMonitor.PerformanceMonitorPlugin.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof HashMap)) {
                return;
            }
            PerformanceMonitorPlugin.flutterEngineStartInfo.clear();
            PerformanceMonitorPlugin.flutterEngineStartInfo.putAll((HashMap) customResponsedMessage.getData());
        }
    };

    /* loaded from: classes4.dex */
    public class PerfCPULogAsync extends BdAsyncTask<String, Integer, Boolean> {
        public final a mItem;
        public final String mPage;

        public PerfCPULogAsync(String str, a aVar) {
            this.mPage = str;
            this.mItem = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            this.mItem.b("memp", String.valueOf(k.d().c()));
            this.mItem.b("cpu", k.d().b());
            BdStatisticsManager.getInstance().performance(this.mPage, this.mItem);
            return Boolean.TRUE;
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        e.e(flutterPluginBinding.getBinaryMessenger(), this);
        MessageManager.getInstance().registerListener(this.mFlutterEngineInitListener);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MessageManager.getInstance().unRegisterListener(this.mFlutterEngineInitListener);
        e.e(flutterPluginBinding.getBinaryMessenger(), null);
    }

    @Override // com.baidu.tieba.flutter.plugin.performanceMonitor.PerformanceMonitorAuto.HostPerformanceMonitor
    public void reportEnginePerformance(PerformanceMonitorAuto.MapParam mapParam) {
        if (mapParam.getParams() == null) {
            return;
        }
        HashMap params = mapParam.getParams();
        a statsItem = BdStatisticsManager.getInstance().getStatsItem("pfmonitor");
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
        String page = fpsParam.getPage();
        double doubleValue = fpsParam.getFps().doubleValue();
        a statsItem = BdStatisticsManager.getInstance().getStatsItem("pfmonitor");
        statsItem.b("action", "fluency");
        statsItem.b("page", page);
        statsItem.c("fps", Double.valueOf(doubleValue));
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
        PerfCPULogAsync perfCPULogAsync = new PerfCPULogAsync(page, statsItem);
        perfCPULogAsync.setSelfExecute(true);
        perfCPULogAsync.execute(new String[0]);
    }

    @Override // com.baidu.tieba.flutter.plugin.performanceMonitor.PerformanceMonitorAuto.HostPerformanceMonitor
    public void reportImageLoadPerformance(PerformanceMonitorAuto.MapParam mapParam) {
        if (mapParam.getParams() == null) {
            return;
        }
        HashMap params = mapParam.getParams();
        a statsItem = BdStatisticsManager.getInstance().getStatsItem("pfmonitor");
        statsItem.b("action", "image_perf");
        statsItem.c(UriUtil.LOCAL_RESOURCE_SCHEME, params.get("isBundleFile"));
        statsItem.c("try", params.get("tryTimes"));
        statsItem.c(Config.EXCEPTION_CRASH_TYPE, params.get("contentType"));
        statsItem.c("dc", params.get("dartCodecCost"));
        statsItem.c("lc", params.get("loadingCost"));
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
        if (!k.d().g() || mapParam.getParams() == null || (params = mapParam.getParams()) == null || params.get("viewCreateTime") == null || ((Double) params.get("viewCreateTime")).doubleValue() <= 0.0d) {
            return;
        }
        String str = (String) params.get("pageName");
        if (OpenFlutter.ACTIVITY_SIGN_TOGETHER.equals(str)) {
            str = "sign_all_flt";
        } else if (OpenFlutter.FRAGMENT_MYTAB.equals(str)) {
            str = "user_center_flt";
        }
        a a2 = j.a();
        a2.b("action", "time");
        a2.c("ishttp", params.get("isHttp"));
        a2.b("issuccess", params.get(RouterCallback.KEY_ERROR_CODE) == BasicPushStatus.SUCCESS_CODE ? "1" : "0");
        a2.b("nettype", k.d().f());
        if (params.containsKey("whiteTime") && (params.get("whiteTime") instanceof Double)) {
            a2.c("wt", Double.valueOf(((Double) params.get("whiteTime")).doubleValue() * 1000.0d));
        }
        a2.c("qt", params.get("queneTime"));
        a2.c("connt", params.get("netConTime"));
        a2.c("rwt", params.get("netRWTime"));
        a2.c("fbt", params.get("firstByteTime"));
        a2.c("abt", params.get("allDataReadTime"));
        a2.c("dect", params.get("dataDeCompressTime"));
        a2.c("tqt", params.get("taskWaitTime"));
        if (params.containsKey("dataParseTime") && (params.get("dataParseTime") instanceof Double)) {
            a2.c("parset", Double.valueOf(((Double) params.get("dataParseTime")).doubleValue() * 1000.0d));
        }
        if (params.containsKey("drawTime") && (params.get("drawTime") instanceof Double)) {
            a2.c("rendert", Double.valueOf(((Double) params.get("drawTime")).doubleValue() * 1000.0d));
        }
        if (params.get("isHttp") == "1") {
            a2.c("hrtn", params.get("httpRetryNum"));
            a2.c("hrtt", params.get("httpRetryCostTime"));
        }
        if (params.get(RouterCallback.KEY_ERROR_CODE) != "0") {
            a2.c("errcode", params.get(RouterCallback.KEY_ERROR_CODE));
        }
        if (params.containsKey("viewCreateTime") && (params.get("viewCreateTime") instanceof Double)) {
            a2.c(Config.EXCEPTION_CRASH_TYPE, Double.valueOf(((Double) params.get("viewCreateTime")).doubleValue() * 1000.0d));
        }
        if (params.containsKey("channelTransTime") && (params.get("channelTransTime") instanceof Double)) {
            a2.c("transt", Double.valueOf(((Double) params.get("channelTransTime")).doubleValue() * 1000.0d));
        }
        if (params.containsKey("dartItemParseTime") && (params.get("dartItemParseTime") instanceof Double)) {
            a2.c("dpt", Double.valueOf(((Double) params.get("dartItemParseTime")).doubleValue() * 1000.0d));
        }
        if (params.containsKey("reqWaitTime") && (params.get("reqWaitTime") instanceof Double)) {
            a2.c("rqwt", Double.valueOf(((Double) params.get("reqWaitTime")).doubleValue() * 1000.0d));
        }
        if (params.containsKey("renderTime") && (params.get("renderTime") instanceof Double)) {
            a2.c("rdt", Double.valueOf(((Double) params.get("renderTime")).doubleValue() * 1000.0d));
        }
        a2.c("hs", params.get("httpSize"));
        BdStatisticsManager.getInstance().performance(str, a2);
    }
}
