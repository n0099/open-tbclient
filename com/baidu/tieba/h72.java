package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
import com.baidu.swan.apps.core.launchtips.monitor.network.NetworkStatus;
import com.baidu.tieba.s62;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes6.dex */
public class h72 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final s62 a;
    public final b72 b;
    public final p62 c;
    public long d;
    public String e;
    public Timer f;

    /* loaded from: classes6.dex */
    public class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h72 a;

        public a(h72 h72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h72Var;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.e(null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements s62.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r62 a;
        public final /* synthetic */ d72 b;
        public final /* synthetic */ dl3 c;
        public final /* synthetic */ h72 d;

        public b(h72 h72Var, r62 r62Var, d72 d72Var, dl3 dl3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h72Var, r62Var, d72Var, dl3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = h72Var;
            this.a = r62Var;
            this.b = d72Var;
            this.c = dl3Var;
        }

        @Override // com.baidu.tieba.s62.b
        public void a(NetworkStatus networkStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, networkStatus) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.a.a());
                sb.append(this.b.d());
                sb.append(networkStatus.getDesc());
                sb.append(this.b.c());
                if (h72.g) {
                    Log.d("SceneLaunchDefaultTips", ">> " + sb.toString());
                }
                this.d.e = sb.toString();
                dl3 dl3Var = this.c;
                if (dl3Var != null) {
                    dl3Var.a(this.d.e);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947776550, "Lcom/baidu/tieba/h72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947776550, "Lcom/baidu/tieba/h72;");
                return;
            }
        }
        g = vm1.a;
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (System.currentTimeMillis() - this.d > LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public final void g() {
        Timer timer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (timer = this.f) != null) {
            timer.cancel();
            this.f = null;
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (g) {
                Log.d("SceneLaunchDefaultTips", ">> start to collect default launch info.");
            }
            g();
            Timer timer = new Timer();
            this.f = timer;
            timer.schedule(new a(this), LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            g();
        }
    }

    public h72() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = System.currentTimeMillis();
        this.e = "";
        this.a = new s62();
        this.b = b72.d();
        this.c = p62.d();
    }

    public void e(@Nullable dl3<String> dl3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dl3Var) == null) {
            if (d() && !TextUtils.isEmpty(this.e)) {
                if (dl3Var != null) {
                    dl3Var.a(this.e);
                    return;
                }
                return;
            }
            this.a.a(new b(this, this.c.f(), this.b.f(), dl3Var));
        }
    }
}
