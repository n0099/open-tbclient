package com.baidu.tieba.feed.log;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.sapi2.utils.enums.ShareDirectionType;
import com.baidu.searchbox.download.util.LocalFilesFilterKt;
import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.bb7;
import com.baidu.tieba.cb7;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0002\b\tB\u001b\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/baidu/tieba/feed/log/FeedStat;", "", "logInfo", "", "", "(Ljava/util/Map;)V", "getLogInfo", "()Ljava/util/Map;", "Companion", "FeedStatCallback", "lib-templates_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedStat {
    public static /* synthetic */ Interceptable $ic;
    public static final Companion a;
    public static boolean b;
    public static final Map<String, Set<String>> c;
    public static final Map<String, Function0<String>> d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public interface a {
        void a(String str, Map<String, String> map, Map<String, String> map2, Map<String, String> map3);
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\fH\u0002J0\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0016H\u0002J,\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u00162\u0006\u0010\u001b\u001a\u00020\u0018H\u0002J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000bH\u0002J$\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00182\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0016H\u0002J\u0006\u0010\u001f\u001a\u00020\u0012J\u000e\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"J\u0016\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$J\"\u0010%\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0016J$\u0010&\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0016H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u000e0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006'"}, d2 = {"Lcom/baidu/tieba/feed/log/FeedStat$Companion;", "", "()V", "inited", "", "getInited", "()Z", "setInited", "(Z)V", "localInfoFunctionMap", "", "", "Lkotlin/Function0;", "shownMap", "", "getShownMap", "()Ljava/util/Map;", "addLocalInfoFunction", "", "key", WebChromeClient.KEY_FUNCTION_NAME, "createRunAndLocalInfoForNewLog", "", "jsonObject", "Lorg/json/JSONObject;", "runInfo", "createRunAndLocalInfoForUbc", "baseInfo", "filterKey", "importCommonInfo", "logInfo", "init", LocalFilesFilterKt.FILTER_NAME_LOG, "item", "Lcom/baidu/tieba/feed/log/FeedStatItem;", WebChromeClient.KEY_ARG_CALLBACK, "Lcom/baidu/tieba/feed/log/FeedStat$FeedStatCallback;", "statForNewLog", "statForUbc", "lib-templates_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* loaded from: classes5.dex */
        public static final class a implements a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.feed.log.FeedStat.a
            public void a(String id, Map<String, String> businessInfo, Map<String, String> logInfo, Map<String, String> runInfo) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLLL(1048576, this, id, businessInfo, logInfo, runInfo) == null) {
                    Intrinsics.checkNotNullParameter(id, "id");
                    Intrinsics.checkNotNullParameter(businessInfo, "businessInfo");
                    Intrinsics.checkNotNullParameter(logInfo, "logInfo");
                    Intrinsics.checkNotNullParameter(runInfo, "runInfo");
                }
            }

            public a() {
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
        }

        public Companion() {
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

        public final boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048580, this)) != null) {
                return invokeV.booleanValue;
            }
            return FeedStat.b;
        }

        public final Map<String, Set<String>> f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048581, this)) != null) {
                return (Map) invokeV.objValue;
            }
            return FeedStat.c;
        }

        public final void h() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && !e()) {
                a("get_uid", FeedStat$Companion$init$1.INSTANCE);
                a("get_hdid", FeedStat$Companion$init$2.INSTANCE);
                k(true);
            }
        }

        public final void a(String str, Function0<String> function0) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, function0) == null) {
                FeedStat.d.put(str, function0);
            }
        }

        public final Map<String, String> b(JSONObject jSONObject, Map<String, String> map) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, map)) == null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                JSONObject optJSONObject = jSONObject.optJSONObject("run_info");
                if (optJSONObject != null) {
                    Iterator<String> keys = optJSONObject.keys();
                    Intrinsics.checkNotNullExpressionValue(keys, "it.keys()");
                    while (keys.hasNext()) {
                        String key = keys.next();
                        String optString = optJSONObject.optString(key);
                        if (map.containsKey(optString)) {
                            Intrinsics.checkNotNullExpressionValue(key, "key");
                            String str = map.get(optString);
                            if (str == null) {
                                str = "";
                            }
                            linkedHashMap.put(key, str);
                        }
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("local_info");
                if (optJSONObject2 != null) {
                    Iterator<String> keys2 = optJSONObject2.keys();
                    Intrinsics.checkNotNullExpressionValue(keys2, "it.keys()");
                    while (keys2.hasNext()) {
                        String key2 = keys2.next();
                        String optString2 = optJSONObject2.optString(key2);
                        if (FeedStat.d.containsKey(optString2)) {
                            Intrinsics.checkNotNullExpressionValue(key2, "key");
                            Function0 function0 = (Function0) FeedStat.d.get(optString2);
                            linkedHashMap.put(key2, (function0 == null || (r4 = (String) function0.invoke()) == null) ? "" : "");
                        }
                    }
                }
                return linkedHashMap;
            }
            return (Map) invokeLL.objValue;
        }

        public final void c(JSONObject jSONObject, Map<String, String> map, JSONObject jSONObject2) {
            JSONObject jSONObject3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, map, jSONObject2) == null) {
                JSONObject optJSONObject = jSONObject2.optJSONObject("ext");
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("param");
                if (optJSONObject2 == null) {
                    optJSONObject2 = new JSONObject();
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("run_info");
                if (optJSONObject3 != null) {
                    Iterator<String> keys = optJSONObject3.keys();
                    Intrinsics.checkNotNullExpressionValue(keys, "it.keys()");
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (Intrinsics.areEqual(next, "source")) {
                            jSONObject3 = jSONObject2;
                        } else if (Intrinsics.areEqual(next, "pos")) {
                            jSONObject3 = optJSONObject;
                        } else {
                            jSONObject3 = optJSONObject2;
                        }
                        String optString = optJSONObject3.optString(next);
                        if (map.containsKey(optString)) {
                            String str = map.get(optString);
                            if (str == null) {
                                str = "";
                            }
                            jSONObject3.put(next, str);
                        } else {
                            jSONObject3.put(next, "");
                        }
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("local_info");
                if (optJSONObject4 != null) {
                    Iterator<String> keys2 = optJSONObject4.keys();
                    Intrinsics.checkNotNullExpressionValue(keys2, "it.keys()");
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        String optString2 = optJSONObject4.optString(next2);
                        if (FeedStat.d.containsKey(optString2)) {
                            Function0 function0 = (Function0) FeedStat.d.get(optString2);
                            optJSONObject2.put(next2, (function0 == null || (r5 = (String) function0.invoke()) == null) ? "" : "");
                        } else {
                            optJSONObject2.put(next2, "");
                        }
                    }
                }
                optJSONObject.put("param", optJSONObject2);
                jSONObject2.put("ext", optJSONObject);
            }
        }

        public final boolean d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                return !Intrinsics.areEqual(str, "stat_key");
            }
            return invokeL.booleanValue;
        }

        public final void i(bb7 item) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, item) == null) {
                Intrinsics.checkNotNullParameter(item, "item");
                j(item, new a());
            }
        }

        public final void k(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
                FeedStat.b = z;
            }
        }

        public final JSONObject g(JSONObject jSONObject, Map<String, String> map) {
            InterceptResult invokeLL;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, jSONObject, map)) == null) {
                String importKey = jSONObject.optString(ShareDirectionType.IMPORT);
                Intrinsics.checkNotNullExpressionValue(importKey, "importKey");
                if (importKey.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z && map.containsKey(importKey)) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2 = new JSONObject(map.get(importKey));
                    } catch (Exception e) {
                        if (!GlobalBuildConfig.isDebug()) {
                            e.printStackTrace();
                        } else {
                            throw new IllegalStateException("import info error");
                        }
                    }
                    Iterator<String> keys = jSONObject.keys();
                    Intrinsics.checkNotNullExpressionValue(keys, "jsonObject.keys()");
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (next != null) {
                            switch (next.hashCode()) {
                                case -1816743588:
                                    if (!next.equals("base_info")) {
                                        break;
                                    } else {
                                        JSONObject optJSONObject = jSONObject2.optJSONObject("base_info");
                                        if (optJSONObject == null) {
                                            optJSONObject = new JSONObject();
                                        }
                                        JSONObject optJSONObject2 = jSONObject.optJSONObject("base_info");
                                        if (optJSONObject2 == null) {
                                            optJSONObject2 = new JSONObject();
                                        }
                                        cb7.a(optJSONObject, optJSONObject2);
                                        jSONObject2.put("base_info", optJSONObject);
                                        continue;
                                    }
                                case -1184795739:
                                    if (!next.equals(ShareDirectionType.IMPORT)) {
                                        break;
                                    } else {
                                        continue;
                                    }
                                case 815808994:
                                    if (!next.equals("run_info")) {
                                        break;
                                    } else {
                                        JSONObject optJSONObject3 = jSONObject2.optJSONObject("run_info");
                                        if (optJSONObject3 == null) {
                                            optJSONObject3 = new JSONObject();
                                        }
                                        JSONObject optJSONObject4 = jSONObject.optJSONObject("run_info");
                                        if (optJSONObject4 == null) {
                                            optJSONObject4 = new JSONObject();
                                        }
                                        cb7.a(optJSONObject3, optJSONObject4);
                                        jSONObject2.put("run_info", optJSONObject3);
                                        continue;
                                    }
                                case 1303390466:
                                    if (!next.equals("local_info")) {
                                        break;
                                    } else {
                                        JSONObject optJSONObject5 = jSONObject2.optJSONObject("local_info");
                                        if (optJSONObject5 == null) {
                                            optJSONObject5 = new JSONObject();
                                        }
                                        JSONObject optJSONObject6 = jSONObject.optJSONObject("local_info");
                                        if (optJSONObject6 == null) {
                                            optJSONObject6 = new JSONObject();
                                        }
                                        cb7.a(optJSONObject5, optJSONObject6);
                                        jSONObject2.put("local_info", optJSONObject5);
                                        continue;
                                    }
                            }
                        }
                        jSONObject2.put(next, jSONObject.opt(next));
                    }
                    return jSONObject2;
                }
                return jSONObject;
            }
            return (JSONObject) invokeLL.objValue;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0093  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0094 A[Catch: Exception -> 0x00ed, TryCatch #0 {Exception -> 0x00ed, blocks: (B:10:0x0041, B:12:0x005c, B:14:0x0079, B:16:0x0087, B:23:0x0094, B:25:0x00a0, B:29:0x00b8, B:26:0x00ad, B:30:0x00c4, B:32:0x00cc, B:33:0x00d7, B:35:0x00df), top: B:47:0x0041 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void j(bb7 item, a callback) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, item, callback) == null) {
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(callback, "callback");
                callback.a(item.b(), item.a(), item.c(), item.d());
                if (item.c().isEmpty() || !item.c().keySet().contains(item.b())) {
                    return;
                }
                try {
                    JSONArray jSONArray = new JSONArray(item.c().get(item.b()));
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jsonObject = jSONArray.optJSONObject(i);
                        Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                        JSONObject jsonObject2 = g(jsonObject, item.c());
                        String optString = jsonObject2.optString("stat_type");
                        if (jsonObject2.optBoolean("exclude_repeat")) {
                            String str = item.d().get(LegoListActivityConfig.PAGE_ID);
                            if (str != null && str.length() != 0) {
                                z = false;
                                if (!z) {
                                    Set<String> set = f().get(str);
                                    if (set == null) {
                                        set = new LinkedHashSet<>();
                                        f().put(str, set);
                                    } else if (set.contains(jsonObject2.toString())) {
                                    }
                                    String jSONObject = jsonObject2.toString();
                                    Intrinsics.checkNotNullExpressionValue(jSONObject, "jsonObject.toString()");
                                    set.add(jSONObject);
                                }
                            }
                            z = true;
                            if (!z) {
                            }
                        }
                        if (Intrinsics.areEqual(optString, "1")) {
                            Intrinsics.checkNotNullExpressionValue(jsonObject2, "jsonObject");
                            l(jsonObject2, item.d());
                        } else if (Intrinsics.areEqual(optString, "2")) {
                            Intrinsics.checkNotNullExpressionValue(jsonObject2, "jsonObject");
                            m(jsonObject2, item.d());
                        }
                    }
                } catch (Exception e) {
                    if (!GlobalBuildConfig.isDebug()) {
                        e.printStackTrace();
                        return;
                    }
                    throw new IllegalStateException("log_info error");
                }
            }
        }

        public final void l(JSONObject jsonObject, Map<String, String> runInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, jsonObject, runInfo) == null) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                Intrinsics.checkNotNullParameter(runInfo, "runInfo");
                JSONObject optJSONObject = jsonObject.optJSONObject("base_info");
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                StatisticItem statisticItem = new StatisticItem(optJSONObject.optString("stat_key"));
                Iterator<String> keys = optJSONObject.keys();
                Intrinsics.checkNotNullExpressionValue(keys, "baseInfo.keys()");
                while (keys.hasNext()) {
                    String key = keys.next();
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    if (d(key)) {
                        statisticItem.param(key, optJSONObject.optString(key));
                    }
                }
                Map<String, String> b = b(jsonObject, runInfo);
                for (String str : b.keySet()) {
                    statisticItem.param(str, b.get(str));
                }
                TiebaStatic.log(statisticItem);
            }
        }

        public final void m(JSONObject jSONObject, Map<String, String> map) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048588, this, jSONObject, map) == null) {
                JSONObject optJSONObject = jSONObject.optJSONObject("base_info");
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                String optString = optJSONObject.optString("type");
                if (Intrinsics.areEqual(optString, "expose")) {
                    str = "6707";
                } else if (Intrinsics.areEqual(optString, "click")) {
                    str = "6708";
                } else {
                    str = "";
                }
                c(jSONObject, map, optJSONObject);
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("ext");
                if (optJSONObject2 == null) {
                    optJSONObject2 = new JSONObject();
                }
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("param");
                if (optJSONObject3 == null) {
                    optJSONObject3 = new JSONObject();
                }
                optJSONObject2.put("param", optJSONObject3.toString());
                optJSONObject.put("ext", optJSONObject2);
                ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(str, optJSONObject);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1260215259, "Lcom/baidu/tieba/feed/log/FeedStat;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1260215259, "Lcom/baidu/tieba/feed/log/FeedStat;");
                return;
            }
        }
        a = new Companion(null);
        c = new LinkedHashMap();
        d = new LinkedHashMap();
    }
}
