package com.baidu.tieba;

import android.text.TextUtils;
import android.webkit.WebView;
import androidx.core.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.WebViewTrackerEnableSwitch;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
import com.facebook.common.util.UriUtil;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class dz4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean a;
    public volatile boolean b;
    public String c;
    public Runnable d;
    public pn6 e;

    public dz4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = WebViewTrackerEnableSwitch.isOn();
        this.b = false;
        this.e = null;
    }

    public void e() {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (runnable = this.d) != null) {
            runnable.run();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.d != null) {
            wl6.a().e(this.d);
            this.d = null;
        }
    }

    public final void a(final String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && !this.b && this.d == null) {
            this.d = new Runnable() { // from class: com.baidu.tieba.az4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        dz4.this.d(str);
                    }
                }
            };
            wl6.a().d(this.d, 10000L);
        }
    }

    public /* synthetic */ void d(String str) {
        g(str, 1);
    }

    public final void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            try {
                if (this.e != null && !tm6.a(this.e.f())) {
                    Map<String, Pair<Long, Long>> g = this.e.g();
                    JSONArray jSONArray = new JSONArray();
                    for (Pair<String, Long> pair : this.e.f()) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("path", pair.first);
                        jSONObject2.put("req", pair.second);
                        Pair<Long, Long> pair2 = g.get(pair.first);
                        if (pair2 != null) {
                            jSONObject2.put(UriUtil.LOCAL_RESOURCE_SCHEME, pair2.first);
                            jSONObject2.put("hit", pair2.second);
                        } else {
                            jSONObject2.put(UriUtil.LOCAL_RESOURCE_SCHEME, -1);
                            jSONObject2.put("hit", -1);
                        }
                        jSONArray.put(jSONObject2);
                    }
                    if (!tm6.c(jSONArray)) {
                        jSONObject.put(PrefetchEvent.MODULE, jSONArray);
                    }
                }
            } catch (JSONException unused) {
            }
        }
    }

    public JSONObject c(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, webView)) == null) {
            if (webView != null) {
                try {
                    if (webView.getParent() instanceof TbWebView) {
                        this.e = ((TbWebView) webView.getParent()).getPerfData();
                    }
                } catch (Exception unused) {
                    return null;
                }
            }
            if (this.e != null && this.a && !this.b && pn6.l(this.e.h())) {
                String h = this.e.h();
                JSONObject jSONObject = new JSONObject();
                String c = this.e.c();
                this.c = c;
                jSONObject.put("logId", c);
                jSONObject.put("url", h);
                if (!TextUtils.isEmpty(this.e.e())) {
                    jSONObject.put("originUrl", this.e.e());
                }
                jSONObject.put("clientType", "Android");
                jSONObject.put("isOfflinePackage", this.e.k());
                jSONObject.put(com.kuaishou.weapon.p0.u.x, this.e.d());
                jSONObject.put("wvst", this.e.j());
                jSONObject.put("wvft", this.e.i());
                jSONObject.put("lst", this.e.b());
                a(jSONObject.toString());
                return jSONObject;
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public synchronized void g(String str, int i) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, str, i) == null) {
            synchronized (this) {
                f();
                if (this.a && !this.b && !TextUtils.isEmpty(str)) {
                    this.b = true;
                    UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
                    if (uBCManager != null) {
                        uBCManager.onEvent("5607", str);
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        jSONObject.optString("logId", this.c);
                        String optString = jSONObject.optString("url", "");
                        String optString2 = jSONObject.optString("originUrl", "");
                        boolean optBoolean = jSONObject.optBoolean("isOfflinePackage", false);
                        long optLong = jSONObject.optLong(com.kuaishou.weapon.p0.u.x, -1L);
                        long optLong2 = jSONObject.optLong("wvst", -1L);
                        long optLong3 = jSONObject.optLong("wvft", -1L);
                        long optLong4 = jSONObject.optLong("lst", -1L);
                        long optLong5 = jSONObject.optLong("navigationStart", -1L);
                        long optLong6 = jSONObject.optLong("fetchStart", -1L);
                        long optLong7 = jSONObject.optLong("domainLookupStart", -1L);
                        long optLong8 = jSONObject.optLong("domainLookupEnd", -1L);
                        long optLong9 = jSONObject.optLong("connectStart", -1L);
                        long optLong10 = jSONObject.optLong("connectEnd", -1L);
                        long optLong11 = jSONObject.optLong("requestStart", -1L);
                        long optLong12 = jSONObject.optLong("responseStart", -1L);
                        long optLong13 = jSONObject.optLong("responseEnd", -1L);
                        long optLong14 = jSONObject.optLong("ds", -1L);
                        long optLong15 = jSONObject.optLong("df", -1L);
                        long optLong16 = jSONObject.optLong("drt", -1L);
                        long optLong17 = jSONObject.optLong("dt", -1L);
                        long optLong18 = jSONObject.optLong("autoFMP", -1L);
                        long optLong19 = jSONObject.optLong("autoFP", -1L);
                        long optLong20 = jSONObject.optLong("autoFCP", -1L);
                        int optInt = jSONObject.optInt("autoWVLCP", -1);
                        int optInt2 = jSONObject.optInt("autoWVFCP", -1);
                        long optLong21 = jSONObject.optLong("fp", -1L);
                        long optLong22 = jSONObject.optLong("fmp", -1L);
                        StringBuilder sb = new StringBuilder();
                        sb.append("是否离线包：");
                        sb.append(optBoolean);
                        sb.append(",总耗时");
                        long j = optLong22 - optLong;
                        sb.append(j);
                        sb.append("-初始化:");
                        sb.append(optLong4 - optLong);
                        sb.append(",加载:");
                        sb.append(optLong14 - optLong4);
                        sb.append(",解析:");
                        sb.append(optLong15 - optLong14);
                        sb.append("，渲染:");
                        sb.append(optLong22 - optLong15);
                        rm6.b("newHybrid", sb.toString());
                        b(jSONObject);
                        StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.WEBVIEW_PERF_DATA_KEY).param("obj_param1", jSONObject.toString()).param(TiebaStatic.Params.OBJ_PARAM2, jSONObject.toString());
                        if (optBoolean) {
                            str2 = "0";
                        } else {
                            str2 = "1";
                        }
                        StatisticItem param2 = param.param("obj_id", str2).param("obj_type", i).param("obj_locate", 1).param("obj_source", 1).param(TiebaStatic.Params.OBJ_PARAM3, j).param(com.kuaishou.weapon.p0.u.x, optLong).param("wvst", optLong2).param("wvft", optLong3).param("lst", optLong4).param("navigationStart", optLong5).param("fetchStart", optLong6).param("domainLookupStart", optLong7).param("domainLookupEnd", optLong8).param("connectStart", optLong9).param("connectEnd", optLong10).param("requestStart", optLong11).param("responseStart", optLong12).param("responseEnd", optLong13).param("ds", optLong14).param("df", optLong15).param("drt", optLong16).param("dt", optLong17).param("autoFMP", optLong18).param("autoFP", optLong19).param("autoFCP", optLong20).param("autoWVLCP", optInt).param("autoWVFCP", optInt2).param("fp", optLong21).param("fmp", optLong22).param("url", optString);
                        if (!TextUtils.isEmpty(optString2)) {
                            param2.param("originUrl", optString2);
                        }
                        TiebaStatic.log(param2);
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }
}
