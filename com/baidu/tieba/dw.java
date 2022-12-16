package com.baidu.tieba;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.browser.core.util.BdLog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public final class dw {
    public static /* synthetic */ Interceptable $ic;
    public static ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> a;
    public static b b;
    public static volatile boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public /* synthetic */ b(Looper looper, a aVar) {
            this(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 0) {
                dw.d();
                dw.b.sendEmptyMessageDelayed(0, 15000L);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448302970, "Lcom/baidu/tieba/dw;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448302970, "Lcom/baidu/tieba/dw;");
                return;
            }
        }
        a = new ConcurrentHashMap<>();
        c = false;
        b bVar = new b(hw.a("PreferenceQueue").getLooper(), null);
        b = bVar;
        bVar.sendEmptyMessageDelayed(0, 15000L);
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65542, null) == null) && !b.hasMessages(0)) {
            b.sendEmptyMessageDelayed(0, 15000L);
        }
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            Log.d("BdPreferenceQueueWorker", "wait to finish");
            b.removeMessages(0);
            d();
            f();
        }
    }

    public static void c(String str, String str2, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65539, null, str, str2, obj) != null) || str == null) {
            return;
        }
        if (a.containsKey(str)) {
            ConcurrentHashMap<String, Object> concurrentHashMap = a.get(str);
            if (concurrentHashMap != null) {
                if (obj != null) {
                    concurrentHashMap.put(str2, obj);
                } else {
                    concurrentHashMap.remove(str2);
                }
            } else if (obj != null && str2 != null) {
                ConcurrentHashMap<String, Object> concurrentHashMap2 = new ConcurrentHashMap<>();
                concurrentHashMap2.put(str2, obj);
                a.put(str, concurrentHashMap2);
            }
        } else if (obj != null && str2 != null) {
            ConcurrentHashMap<String, Object> concurrentHashMap3 = new ConcurrentHashMap<>();
            concurrentHashMap3.put(str2, obj);
            a.put(str, concurrentHashMap3);
        }
    }

    public static void d() {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) != null) || c) {
            return;
        }
        c = true;
        try {
            try {
                Context baseContext = zv.a().getBaseContext();
                BdLog.a("BdPreferenceQueueWorker", "pending work category: " + a.size());
                for (String str : a.keySet()) {
                    ConcurrentHashMap<String, Object> concurrentHashMap = a.get(str);
                    if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
                        SharedPreferences.Editor edit = baseContext.getSharedPreferences(str, 0).edit();
                        i = 0;
                        for (String str2 : concurrentHashMap.keySet()) {
                            Object obj = concurrentHashMap.get(str2);
                            if (obj != null) {
                                if (obj instanceof Integer) {
                                    edit.putInt(str2, ((Integer) obj).intValue());
                                } else if (obj instanceof Long) {
                                    edit.putLong(str2, ((Long) obj).longValue());
                                } else if (obj instanceof Float) {
                                    edit.putFloat(str2, ((Float) obj).floatValue());
                                } else if (obj instanceof Boolean) {
                                    edit.putBoolean(str2, ((Boolean) obj).booleanValue());
                                } else if (obj instanceof String) {
                                    edit.putString(str2, (String) obj);
                                } else if (obj instanceof Set) {
                                    edit.putStringSet(str2, (Set) obj);
                                }
                                i++;
                            }
                        }
                        edit.commit();
                    } else {
                        i = 0;
                    }
                    concurrentHashMap.clear();
                    if (i > 0) {
                        BdLog.a("BdPreferenceQueueWorker", str + ".xml " + i + " items have been wroten");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            c = false;
        }
    }

    public static void e(String str) {
        ConcurrentHashMap<String, Object> concurrentHashMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, str) == null) && str != null && (concurrentHashMap = a.get(str)) != null) {
            concurrentHashMap.clear();
        }
    }
}
