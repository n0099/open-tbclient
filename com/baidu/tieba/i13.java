package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.TooltipCompatHandler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class i13 implements ys2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long c;
    public ConcurrentHashMap<String, JSONObject> d;
    public ConcurrentHashMap<String, Integer> e;
    public q23 f;

    /* loaded from: classes4.dex */
    public class a implements q23 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i13 c;

        @Override // com.baidu.tieba.q23
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.q23
        public void c(@NonNull Runnable runnable, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, runnable, str) == null) {
            }
        }

        @Override // com.baidu.tieba.q23
        public String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "LaunchApiCache" : (String) invokeV.objValue;
        }

        public a(i13 i13Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i13Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = i13Var;
        }

        @Override // com.baidu.tieba.q23
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048579, this, z) != null) {
                return;
            }
            this.c.g();
        }

        @Override // com.baidu.tieba.q23
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.c.c = System.currentTimeMillis();
            }
        }

        @Override // com.baidu.tieba.q23
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.c.g();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final i13 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-769377696, "Lcom/baidu/tieba/i13$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-769377696, "Lcom/baidu/tieba/i13$b;");
                    return;
                }
            }
            a = new i13(null);
        }
    }

    public i13() {
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
        this.c = -1L;
        this.d = new ConcurrentHashMap<>(10);
        this.e = new ConcurrentHashMap<>(10);
        this.f = new a(this);
    }

    public /* synthetic */ i13(a aVar) {
        this();
    }

    public void h(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048580, this, str, jSONObject) != null) || TextUtils.isEmpty(str) || !e()) {
            return;
        }
        this.d.put(str, jSONObject);
    }

    public static i13 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return b.a;
        }
        return (i13) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.c == -1 || System.currentTimeMillis() - this.c > TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            o23.g().i(this.f, 2500);
        }
    }

    public JSONObject d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str) || !e()) {
                return null;
            }
            JSONObject jSONObject = this.d.get(str);
            if (ys2.a && jSONObject != null) {
                Integer num = this.e.get(str);
                if (num == null) {
                    num = 0;
                }
                this.e.put(str, Integer.valueOf(num.intValue() + 1));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.c = -1L;
            if (ys2.a) {
                StringBuilder sb = new StringBuilder();
                sb.append("adopt cache api = [ ");
                for (Map.Entry<String, Integer> entry : this.e.entrySet()) {
                    sb.append((Object) entry.getKey());
                    sb.append("=");
                    sb.append(entry.getValue());
                    sb.append(" ");
                }
                sb.append(PreferencesUtil.RIGHT_MOUNT);
                Log.d("SwanPerformance", sb.toString());
            }
            this.e.clear();
            this.d.clear();
        }
    }
}
