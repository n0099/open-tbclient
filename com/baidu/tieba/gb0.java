package com.baidu.tieba;

import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.arch.utils.MiniPluginUtils;
import com.baidu.live.feedpage.interfaces.ILiveFeedPageInvoke;
import com.baidu.live.framework.net.LiveNetwork;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.BundleInfoGroup;
import com.baidu.nps.pm.manager.NPSPackageManager;
import com.baidu.searchbox.live.interfaces.net.LiveNetConstants;
import com.baidu.searchbox.live.model.requester.MixRequesterKt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class gb0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static final class a<T> implements Comparator<Map.Entry<? extends String, ? extends String>> {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-781472873, "Lcom/baidu/tieba/gb0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-781472873, "Lcom/baidu/tieba/gb0$a;");
                    return;
                }
            }
            a = new a();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public final int compare(Map.Entry<String, String> entry, Map.Entry<String, String> entry2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, entry, entry2)) == null) {
                return entry.getKey().compareTo(entry2.getKey());
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public static final class b<T> implements Comparator<Map.Entry<? extends String, ? extends String>> {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-781472842, "Lcom/baidu/tieba/gb0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-781472842, "Lcom/baidu/tieba/gb0$b;");
                    return;
                }
            }
            a = new b();
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public final int compare(Map.Entry<String, String> entry, Map.Entry<String, String> entry2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, entry, entry2)) == null) {
                return entry.getKey().compareTo(entry2.getKey());
            }
            return invokeLL.intValue;
        }
    }

    public static final Map<String, String> a(Map<String, String> map, Map<String, String> map2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65536, null, map, map2, z)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("timestamp", String.valueOf(System.currentTimeMillis()));
            hashMap.put("livefeed_sdk_version", "6.4.5.0");
            hashMap.put(MiniPluginUtils.MIX_PLUGIN_VER_PARAM_KEY, m());
            if (z) {
                hashMap.put("sign", i(map, hashMap, map2));
            } else {
                hashMap.put("sign", j(map, hashMap, map2));
            }
            return hashMap;
        }
        return (Map) invokeLLZ.objValue;
    }

    public static /* synthetic */ Map b(Map map, Map map2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return a(map, map2, z);
    }

    public static final String c(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, map)) == null) {
            String fullUrl = mb0.b(str);
            if (map != null) {
                String a2 = mb0.a(fullUrl, map);
                Intrinsics.checkExpressionValueIsNotNull(a2, "CommonUrlParamUtils.addParam(fullUrl, params)");
                return a2;
            }
            Intrinsics.checkExpressionValueIsNotNull(fullUrl, "fullUrl");
            return fullUrl;
        }
        return (String) invokeLL.objValue;
    }

    public static final StringBuffer d(StringBuffer stringBuffer, ArrayList<Map.Entry<String, String>> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, stringBuffer, arrayList)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                Iterator<Map.Entry<String, String>> it = arrayList.iterator();
                while (it.hasNext()) {
                    Map.Entry<String, String> next = it.next();
                    String key = next.getKey();
                    String value = next.getValue();
                    if (!"sign".equals(key)) {
                        stringBuffer.append(key);
                        stringBuffer.append("=");
                        stringBuffer.append(value);
                        stringBuffer.append("&");
                    }
                }
            }
            return stringBuffer;
        }
        return (StringBuffer) invokeLL.objValue;
    }

    public static final StringBuffer e(StringBuffer stringBuffer, ArrayList<Map.Entry<String, String>> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, stringBuffer, arrayList)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                Iterator<Map.Entry<String, String>> it = arrayList.iterator();
                while (it.hasNext()) {
                    Map.Entry<String, String> next = it.next();
                    String key = next.getKey();
                    String value = next.getValue();
                    if (!"sign".equals(key)) {
                        stringBuffer.append(key);
                        stringBuffer.append("=");
                        stringBuffer.append(value);
                    }
                }
            }
            return stringBuffer;
        }
        return (StringBuffer) invokeLL.objValue;
    }

    public static final <T> void f(String str, Map<String, String> map, fb0<T> fb0Var, int i, int i2, Map<String, String> map2, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{str, map, fb0Var, Integer.valueOf(i), Integer.valueOf(i2), map2, list}) == null) {
            LiveNetwork liveNetwork = new LiveNetwork();
            String c = c(str, map2);
            LiveFeedPageSdk liveFeedPageSdk = LiveFeedPageSdk.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(liveFeedPageSdk, "LiveFeedPageSdk.getInstance()");
            if (liveFeedPageSdk.getInvoker() != null) {
                LiveFeedPageSdk liveFeedPageSdk2 = LiveFeedPageSdk.getInstance();
                Intrinsics.checkExpressionValueIsNotNull(liveFeedPageSdk2, "LiveFeedPageSdk.getInstance()");
                ILiveFeedPageInvoke invoker = liveFeedPageSdk2.getInvoker();
                if (invoker == null) {
                    Intrinsics.throwNpe();
                }
                Intrinsics.checkExpressionValueIsNotNull(invoker, "LiveFeedPageSdk.getInstance().invoker!!");
                String iid = invoker.getIID();
                if (!TextUtils.isEmpty(iid)) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    Intrinsics.checkExpressionValueIsNotNull(iid, "iid");
                    linkedHashMap.put("iid_bak", iid);
                    c = mb0.a(c, linkedHashMap);
                    Intrinsics.checkExpressionValueIsNotNull(c, "CommonUrlParamUtils.addParam(fullUrl, iidParam)");
                }
            }
            Map b2 = b(map, n(c), false, 4, null);
            liveNetwork.f(MapsKt__MapsKt.mapOf(TuplesKt.to(LiveNetConstants.EXTRA_KEY_ENABLE_STAT, Boolean.TRUE), TuplesKt.to(LiveNetConstants.EXTRA_KEY_REQUEST_FROM, Integer.valueOf(i)), TuplesKt.to(LiveNetConstants.EXTRA_KEY_REQUEST_SUB_FROM, Integer.valueOf(i2))));
            liveNetwork.g(c);
            liveNetwork.d(q(MapsKt__MapsKt.plus(new HashMap(b2), map)), fb0Var, list);
        }
    }

    public static /* synthetic */ void g(String str, Map map, fb0 fb0Var, int i, int i2, Map map2, List list, int i3, Object obj) {
        int i4;
        int i5;
        Map map3;
        List list2;
        if ((i3 & 8) != 0) {
            i4 = 0;
        } else {
            i4 = i;
        }
        if ((i3 & 16) != 0) {
            i5 = 0;
        } else {
            i5 = i2;
        }
        if ((i3 & 32) != 0) {
            map3 = null;
        } else {
            map3 = map2;
        }
        if ((i3 & 64) != 0) {
            list2 = null;
        } else {
            list2 = list;
        }
        f(str, map, fb0Var, i4, i5, map3, list2);
    }

    public static final <T> void h(String str, Map<String, String> map, fb0<T> fb0Var, int i, int i2, Map<String, String> map2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, map, fb0Var, Integer.valueOf(i), Integer.valueOf(i2), map2}) == null) {
            LiveNetwork liveNetwork = new LiveNetwork();
            String c = c(str, map2);
            Map<String, String> a2 = a(map, n(c), true);
            liveNetwork.f(MapsKt__MapsKt.mapOf(TuplesKt.to(LiveNetConstants.EXTRA_KEY_ENABLE_STAT, Boolean.TRUE), TuplesKt.to(LiveNetConstants.EXTRA_KEY_REQUEST_FROM, Integer.valueOf(i)), TuplesKt.to(LiveNetConstants.EXTRA_KEY_REQUEST_SUB_FROM, Integer.valueOf(i2))));
            liveNetwork.g(c);
            LiveNetwork.e(liveNetwork, q(MapsKt__MapsKt.plus(new HashMap(a2), map)), fb0Var, null, 4, null);
        }
    }

    public static final String i(Map<String, String> map, Map<String, String> map2, Map<String, String> map3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, map, map2, map3)) == null) {
            ArrayList arrayList = new ArrayList();
            if (map != null) {
                arrayList.addAll(map.entrySet());
            }
            if (map2 != null) {
                arrayList.addAll(map2.entrySet());
            }
            if (map3 != null) {
                arrayList.addAll(map3.entrySet());
            }
            Collections.sort(arrayList, a.a);
            StringBuffer stringBuffer = new StringBuffer(1024);
            e(stringBuffer, arrayList);
            stringBuffer.append("tiebaclient!!!");
            String stringBuffer2 = stringBuffer.toString();
            Intrinsics.checkExpressionValueIsNotNull(stringBuffer2, "md5Source.toString()");
            Charset charset = Charsets.UTF_8;
            if (stringBuffer2 != null) {
                byte[] bytes = stringBuffer2.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                String b2 = pb0.b(bytes, true);
                Intrinsics.checkExpressionValueIsNotNull(b2, "Md5Utils.toMd5(md5Source…ng().toByteArray(), true)");
                return b2;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        return (String) invokeLLL.objValue;
    }

    public static final String j(Map<String, String> map, Map<String, String> map2, Map<String, String> map3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, map, map2, map3)) == null) {
            ArrayList arrayList = new ArrayList();
            if (map != null) {
                arrayList.addAll(map.entrySet());
            }
            if (map2 != null) {
                arrayList.addAll(map2.entrySet());
            }
            if (map3 != null) {
                arrayList.addAll(map3.entrySet());
            }
            Collections.sort(arrayList, b.a);
            StringBuffer stringBuffer = new StringBuffer(1024);
            d(stringBuffer, arrayList);
            stringBuffer.append(MixRequesterKt.SIGN_SUFFIX2);
            String stringBuffer2 = stringBuffer.toString();
            Intrinsics.checkExpressionValueIsNotNull(stringBuffer2, "md5Source.toString()");
            Charset charset = Charsets.UTF_8;
            if (stringBuffer2 != null) {
                byte[] bytes = stringBuffer2.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                String b2 = pb0.b(bytes, true);
                Intrinsics.checkExpressionValueIsNotNull(b2, "Md5Utils.toMd5(md5Source…ng().toByteArray(), true)");
                return b2;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        return (String) invokeLLL.objValue;
    }

    public static final int k(String str) {
        InterceptResult invokeL;
        ib0 ib0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            SparseArray<ib0> l = l(str);
            if (l != null && (ib0Var = l.get(3)) != null) {
                return ib0Var.a();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static final SparseArray<ib0> l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            BundleInfoGroup bundleGroup = NPSPackageManager.getInstance().getBundleGroup(str);
            if (bundleGroup != null) {
                return o(bundleGroup);
            }
            return null;
        }
        return (SparseArray) invokeL.objValue;
    }

    public static final Map<String, String> n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            return mb0.g(mb0.d(str));
        }
        return (Map) invokeL.objValue;
    }

    public static final String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("com.baidu.searchbox.livenps", String.valueOf(k("com.baidu.searchbox.livenps")));
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "json.toString()");
            return jSONObject2;
        }
        return (String) invokeV.objValue;
    }

    public static final SparseArray<ib0> o(BundleInfoGroup bundleInfoGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bundleInfoGroup)) == null) {
            SparseArray<ib0> sparseArray = new SparseArray<>();
            try {
                sparseArray.append(1, p(bundleInfoGroup.getBundleByType(1)));
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                sparseArray.append(2, p(bundleInfoGroup.getBundleByType(2)));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                sparseArray.append(3, p(bundleInfoGroup.getBundleByType(3)));
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            return sparseArray;
        }
        return (SparseArray) invokeL.objValue;
    }

    public static final ib0 p(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, bundleInfo)) == null) {
            if (bundleInfo == null) {
                return null;
            }
            String packageName = bundleInfo.getPackageName();
            Intrinsics.checkExpressionValueIsNotNull(packageName, "bundle.packageName");
            return new ib0(packageName, bundleInfo.getVersionCode(), bundleInfo.needForceUpdate(), bundleInfo.getExt());
        }
        return (ib0) invokeL.objValue;
    }

    public static final Map<String, String> q(Map<String, String> map) {
        InterceptResult invokeL;
        String key;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, map)) == null) {
            HashMap hashMap = new HashMap();
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (entry != null && (key = entry.getKey()) != null) {
                        hashMap.put(key, entry.getValue());
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }
}
