package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.coreExtra.data.FriendBotPostConfigData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class bu9 {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947657603, "Lcom/baidu/tieba/bu9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947657603, "Lcom/baidu/tieba/bu9;");
                return;
            }
        }
        a = new a(null);
    }

    @JvmStatic
    public static final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            a.a(str);
        }
    }

    @JvmStatic
    public static final Map<String, Long> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.b() : (Map) invokeV.objValue;
    }

    @JvmStatic
    public static final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a.c() : invokeV.booleanValue;
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

        @JvmStatic
        public final void a(String tid) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, tid) == null) {
                Intrinsics.checkNotNullParameter(tid, "tid");
                if (TextUtils.isEmpty(tid)) {
                    return;
                }
                String str = "friend_bot_sha_time" + tid;
                Map<String, Long> b = b();
                if (b.containsKey(str)) {
                    b.remove(str);
                    String jSONObject = new JSONObject(b).toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject(tidMap as Map<*, *>).toString()");
                    SharedPrefHelper.getInstance().putString("friend_bot_sha_time_tids", jSONObject);
                }
            }
        }

        @JvmStatic
        public final Map<String, Long> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                String string = SharedPrefHelper.getInstance().getString("friend_bot_sha_time_tids", "");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                try {
                    JSONObject jSONObject = new JSONObject(string);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        long optLong = jSONObject.optLong(next);
                        if (optLong > 0) {
                            Long valueOf = Long.valueOf(optLong);
                            Intrinsics.checkNotNullExpressionValue(next, "next");
                            linkedHashMap.put(next, valueOf);
                        }
                    }
                } catch (JSONException e) {
                    BdLog.e(e);
                }
                return linkedHashMap;
            }
            return (Map) invokeV.objValue;
        }

        @JvmStatic
        public final boolean c() {
            InterceptResult invokeV;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                FriendBotPostConfigData friendBotPostConfigData = TbSingleton.getInstance().getFriendBotPostConfigData();
                if (friendBotPostConfigData == null) {
                    return false;
                }
                Integer pbFirstFloorBotBubbleShow = friendBotPostConfigData.getPbFirstFloorBotBubbleShow();
                if (pbFirstFloorBotBubbleShow != null) {
                    i = pbFirstFloorBotBubbleShow.intValue();
                } else {
                    i = 0;
                }
                long j = SharedPrefHelper.getInstance().getLong("friend_bot_guide_show", 0L);
                if (i == 0) {
                    if (j > 0) {
                        return false;
                    }
                    return true;
                } else if (i != 1) {
                    return false;
                } else {
                    if (j < 0) {
                        return true;
                    }
                    return !TimeHelper.isSameDay(j, System.currentTimeMillis());
                }
            }
            return invokeV.booleanValue;
        }
    }
}
