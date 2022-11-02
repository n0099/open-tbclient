package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.swan.apps.api.SwanApi$$ModulesProvider;
import com.baidu.swan.apps.api.module.network.SwanApiNetworkV8Module;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.Map;
/* loaded from: classes3.dex */
public class cs1 implements fs1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public Context a;
    @NonNull
    public CallbackHandler b;
    public WeakReference<Activity> c;
    public c32 d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947685224, "Lcom/baidu/tieba/cs1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947685224, "Lcom/baidu/tieba/cs1;");
                return;
            }
        }
        e = ok1.a;
    }

    @Override // com.baidu.tieba.fs1
    @NonNull
    public c32 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.d;
        }
        return (c32) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fs1
    @NonNull
    public CallbackHandler g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b;
        }
        return (CallbackHandler) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fs1
    @NonNull
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return h();
        }
        return (Context) invokeV.objValue;
    }

    @NonNull
    public final Context h() {
        InterceptResult invokeV;
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            WeakReference<Activity> weakReference = this.c;
            if (weakReference != null) {
                activity = weakReference.get();
            } else {
                activity = null;
            }
            if (activity == null) {
                return this.a;
            }
            return activity;
        }
        return (Context) invokeV.objValue;
    }

    public cs1(@NonNull Context context, @NonNull CallbackHandler callbackHandler, @NonNull c32 c32Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, callbackHandler, c32Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = context;
        this.b = callbackHandler;
        this.d = c32Var;
    }

    public void a(@NonNull c32 c32Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, c32Var) == null) {
            c32Var.addJavascriptInterface(new SwanApiNetworkV8Module(this), SwanApiNetworkV8Module.MODULE_NAME);
        }
    }

    public final void b(@NonNull c32 c32Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c32Var) == null) {
            if (c32Var instanceof ob2) {
                c((ob2) c32Var);
            } else {
                d(c32Var);
            }
        }
    }

    public final void c(@NonNull ob2 ob2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ob2Var) == null) {
            e(ob2Var, SwanApi$$ModulesProvider.getV8ApiModules(this), ln2.s().b(this));
        }
    }

    public final void d(@NonNull c32 c32Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, c32Var) == null) {
            e(c32Var, SwanApi$$ModulesProvider.getWebviewApiModules(this), ln2.s().c(this));
        }
    }

    public void i(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, activity) == null) && activity != null) {
            this.c = new WeakReference<>(activity);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void e(@NonNull c32 c32Var, Map<String, Object> map, Map<String, Object> map2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, c32Var, map, map2) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (map2 != null) {
                if (map == null) {
                    map = map2;
                } else {
                    try {
                        map.putAll(map2);
                    } catch (Exception e2) {
                        if (!e) {
                            return;
                        }
                        e2.printStackTrace();
                        throw new RuntimeException("doBindSwanApis fail: " + e2.getMessage());
                    }
                }
            }
            if (map == null) {
                if (!e) {
                    return;
                }
                throw new RuntimeException("doBindSwanApis fail: api modules cannot be null");
            }
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (TextUtils.isEmpty(key)) {
                    if (e) {
                        throw new RuntimeException("doBindSwanApis fail: moduleName cannot be empty");
                    }
                } else if (value == null) {
                    if (e) {
                        throw new RuntimeException("doBindSwanApis fail: module obj cannot be null");
                    }
                } else {
                    c32Var.addJavascriptInterface(value, key);
                    if (e) {
                        if (c32Var instanceof ob2) {
                            str = "V8";
                        } else {
                            str = "Webview";
                        }
                        Log.d("Api-Binder", "doBindSwanApis(" + str + "): bound " + key);
                    }
                }
            }
            if (e) {
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (currentTimeMillis2 > 5) {
                    Log.w("Api-Binder", "doBindSwanApis: 耗时 " + currentTimeMillis2 + "ms");
                }
            }
        }
    }
}
