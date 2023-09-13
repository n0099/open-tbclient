package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsCodeCacheCallback;
import com.baidu.searchbox.v8engine.JsCodeCacheResult;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class hd2 implements dd2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public gd2 a;
    public String b;
    public boolean c;
    public boolean d;

    /* loaded from: classes6.dex */
    public class a implements JsCodeCacheCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hd2 a;

        public a(hd2 hd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hd2Var;
        }

        @Override // com.baidu.searchbox.v8engine.JsCodeCacheCallback
        public void onJsCodeCacheFinished(JsCodeCacheResult jsCodeCacheResult) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jsCodeCacheResult) == null) {
                if (hd2.e) {
                    if (jsCodeCacheResult != null) {
                        str = jsCodeCacheResult.toString();
                    } else {
                        str = StringUtil.NULL_STRING;
                    }
                    Log.d("V8MasterAdapter", str);
                }
                if (jsCodeCacheResult != null && jsCodeCacheResult.isCacheUsed) {
                    if (!TextUtils.equals(jsCodeCacheResult.businessId, "appframe")) {
                        if (!TextUtils.equals(jsCodeCacheResult.businessId, "appjs")) {
                            return;
                        }
                        this.a.d = true;
                        return;
                    }
                    this.a.c = true;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements zi2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v92 a;
        public final /* synthetic */ hd2 b;

        public b(hd2 hd2Var, v92 v92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hd2Var, v92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hd2Var;
            this.a = v92Var;
        }

        @Override // com.baidu.tieba.zi2
        public void a(pi2 pi2Var) {
            v92 v92Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, pi2Var) == null) && (v92Var = this.a) != null) {
                v92Var.a(this.b.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        public c(hd2 hd2Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hd2Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    Process.setThreadPriority(this.a);
                } catch (Throwable th) {
                    h82.c("V8MasterAdapter", th.getMessage());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947819795, "Lcom/baidu/tieba/hd2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947819795, "Lcom/baidu/tieba/hd2;");
                return;
            }
        }
        e = rr1.a;
    }

    @Override // com.baidu.tieba.dd2
    public void destroy() {
        gd2 gd2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (gd2Var = this.a) != null) {
            gd2Var.g();
        }
    }

    @Override // com.baidu.tieba.dd2
    public fa2 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a.i();
        }
        return (fa2) invokeV.objValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return z92.b(this.c, this.d);
        }
        return invokeV.intValue;
    }

    public hd2(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.dd2
    public void attachActivity(Activity activity) {
        gd2 gd2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) && (gd2Var = this.a) != null) {
            gd2Var.d(activity);
        }
    }

    @Override // com.baidu.tieba.dd2
    public void b(v92 v92Var) {
        gd2 gd2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, v92Var) == null) && (gd2Var = this.a) != null) {
            gd2Var.l(new b(this, v92Var));
        }
    }

    public gd2 h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            return new gd2(str, "runtime/index.js");
        }
        return (gd2) invokeL.objValue;
    }

    @Override // com.baidu.tieba.dd2
    @AnyThread
    public void o(int i) {
        gd2 gd2Var;
        pi2 i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048585, this, i) == null) && (gd2Var = this.a) != null && (i2 = gd2Var.i()) != null) {
            i2.runOnJSThread(new c(this, i));
        }
    }

    @Override // com.baidu.tieba.dd2
    public void C(vh2 vh2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, vh2Var) != null) || vh2Var == null) {
            return;
        }
        if (e) {
            Log.d("V8MasterAdapter", "pathList item: " + vh2Var.b);
        }
        this.a.j(z92.a("appjs", vh2Var.b));
    }

    @Override // com.baidu.tieba.dd2
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            if (this.a == null) {
                gd2 h = h(bi2.U().c0());
                this.a = h;
                this.b = str;
                h.k(new a(this));
            } else if (e) {
                Log.e("V8MasterAdapter", Log.getStackTraceString(new Exception("same instance loadUrl should not be call twice.")));
            }
        }
    }

    @Override // com.baidu.tieba.dd2
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            gd2 gd2Var = this.a;
            if (gd2Var != null) {
                return gd2Var.h();
            }
            if (e) {
                Log.d("V8MasterAdapter", Log.getStackTraceString(new Exception("illegal state")));
                return "";
            }
            return "";
        }
        return (String) invokeV.objValue;
    }
}
