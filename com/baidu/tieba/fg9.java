package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.gg9;
import com.baidu.tieba.ng9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes4.dex */
public class fg9 implements ng9.a {
    public static /* synthetic */ Interceptable $ic;
    public static fg9 f;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, ng9> a;
    public eg9 b;
    public ExecutorService c;
    public lg9 d;
    public Handler e;

    public void delete(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ fg9 b;

        public a(fg9 fg9Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fg9Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fg9Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.containsKey(this.a)) {
                this.b.a.remove(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fg9 a;

        public b(fg9 fg9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fg9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fg9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (ng9 ng9Var : this.a.a.values()) {
                    if (ng9Var != null && ng9Var.isRunning()) {
                        ng9Var.pause();
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fg9 a;

        public c(fg9 fg9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fg9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fg9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (ng9 ng9Var : this.a.a.values()) {
                    if (ng9Var != null && ng9Var.isRunning()) {
                        ng9Var.cancel();
                    }
                }
            }
        }
    }

    public fg9() {
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
        this.e = new Handler(Looper.getMainLooper());
        this.a = new LinkedHashMap();
        i(new eg9());
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            String e = e(str);
            if (this.a.containsKey(e)) {
                ng9 ng9Var = this.a.get(e);
                if (ng9Var != null) {
                    ng9Var.cancel();
                }
                this.a.remove(e);
            }
        }
    }

    public final String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (str != null) {
                return String.valueOf(str.hashCode());
            }
            throw new IllegalArgumentException("Tag can't be null!");
        }
        return (String) invokeL.objValue;
    }

    public final boolean j(String str) {
        InterceptResult invokeL;
        ng9 ng9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (this.a.containsKey(str) && (ng9Var = this.a.get(str)) != null && ng9Var.isRunning()) {
                xi9.d("DownloadInfo has been started!");
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean k(String str) {
        InterceptResult invokeL;
        ng9 ng9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            String e = e(str);
            if (this.a.containsKey(e) && (ng9Var = this.a.get(e)) != null) {
                return ng9Var.isRunning();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static fg9 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f == null) {
                synchronized (fg9.class) {
                    if (f == null) {
                        f = new fg9();
                    }
                }
            }
            return f;
        }
        return (fg9) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.e.post(new c(this));
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.e.post(new b(this));
        }
    }

    @Override // com.baidu.tieba.ng9.a
    public void a(String str, ng9 ng9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, ng9Var) == null) {
            this.e.post(new a(this, str));
        }
    }

    public void f(gg9 gg9Var, String str, ig9 ig9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, gg9Var, str, ig9Var) == null) {
            String e = e(str);
            if (!j(e)) {
                tg9 tg9Var = new tg9(gg9Var, new qg9(this.d, ig9Var), this.c, e, this.b, this);
                this.a.put(e, tg9Var);
                tg9Var.start();
            }
        }
    }

    public void g(String str, String str2, String str3, ig9 ig9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, str, str2, str3, ig9Var) == null) {
            gg9.b bVar = new gg9.b();
            bVar.d(str);
            bVar.b(new File(str2));
            bVar.c(str3);
            f(bVar.a(), str, ig9Var);
        }
    }

    public final void i(@NonNull eg9 eg9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eg9Var) == null) {
            if (eg9Var.b() <= eg9Var.a()) {
                this.b = eg9Var;
                this.c = Executors.newFixedThreadPool(eg9Var.a());
                this.d = new rg9(this.e);
                return;
            }
            throw new IllegalArgumentException("thread num must < max thread num");
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            String e = e(str);
            if (this.a.containsKey(e)) {
                ng9 ng9Var = this.a.get(e);
                if (ng9Var != null && ng9Var.isRunning()) {
                    ng9Var.pause();
                }
                this.a.remove(e);
            }
        }
    }
}
