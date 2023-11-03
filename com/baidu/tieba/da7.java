package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FeedKV;
/* loaded from: classes5.dex */
public final class da7 {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947697903, "Lcom/baidu/tieba/da7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947697903, "Lcom/baidu/tieba/da7;");
                return;
            }
        }
        a = new a(null);
    }

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
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

        public final HashMap<String, String> a(List<FeedKV> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
                HashMap<String, String> hashMap = new HashMap<>();
                if (list != null && !list.isEmpty()) {
                    for (FeedKV feedKV : list) {
                        String str = feedKV.key;
                        Intrinsics.checkNotNullExpressionValue(str, "feedKV.key");
                        String str2 = feedKV.value;
                        Intrinsics.checkNotNullExpressionValue(str2, "feedKV.value");
                        hashMap.put(str, str2);
                    }
                }
                return hashMap;
            }
            return (HashMap) invokeL.objValue;
        }

        public final Map<String, String> b(JSONArray jSONArray) {
            InterceptResult invokeL;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray)) == null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                if (jSONArray != null && jSONArray.length() != 0) {
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            String key = optJSONObject.optString("key");
                            if (key != null && key.length() != 0) {
                                z = false;
                            } else {
                                z = true;
                            }
                            if (!z) {
                                String value = optJSONObject.optString("value");
                                Intrinsics.checkNotNullExpressionValue(key, "key");
                                Intrinsics.checkNotNullExpressionValue(value, "value");
                                linkedHashMap.put(key, value);
                            }
                        }
                    }
                }
                return linkedHashMap;
            }
            return (Map) invokeL.objValue;
        }
    }
}
