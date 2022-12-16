package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.bk9;
import com.baidu.tieba.ik9;
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
/* loaded from: classes3.dex */
public class ak9 implements ik9.a {
    public static /* synthetic */ Interceptable $ic;
    public static ak9 f;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, ik9> a;
    public zj9 b;
    public ExecutorService c;
    public gk9 d;
    public Handler e;

    public void delete(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ak9 b;

        public a(ak9 ak9Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ak9Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ak9Var;
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

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ak9 a;

        public b(ak9 ak9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ak9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ak9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (ik9 ik9Var : this.a.a.values()) {
                    if (ik9Var != null && ik9Var.isRunning()) {
                        ik9Var.pause();
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ak9 a;

        public c(ak9 ak9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ak9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ak9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (ik9 ik9Var : this.a.a.values()) {
                    if (ik9Var != null && ik9Var.isRunning()) {
                        ik9Var.cancel();
                    }
                }
            }
        }
    }

    public ak9() {
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
        i(new zj9());
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            String e = e(str);
            if (this.a.containsKey(e)) {
                ik9 ik9Var = this.a.get(e);
                if (ik9Var != null) {
                    ik9Var.cancel();
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
        ik9 ik9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (this.a.containsKey(str) && (ik9Var = this.a.get(str)) != null && ik9Var.isRunning()) {
                sm9.d("DownloadInfo has been started!");
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean k(String str) {
        InterceptResult invokeL;
        ik9 ik9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            String e = e(str);
            if (this.a.containsKey(e) && (ik9Var = this.a.get(e)) != null) {
                return ik9Var.isRunning();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static ak9 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f == null) {
                synchronized (ak9.class) {
                    if (f == null) {
                        f = new ak9();
                    }
                }
            }
            return f;
        }
        return (ak9) invokeV.objValue;
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

    @Override // com.baidu.tieba.ik9.a
    public void a(String str, ik9 ik9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, ik9Var) == null) {
            this.e.post(new a(this, str));
        }
    }

    public void f(bk9 bk9Var, String str, dk9 dk9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, bk9Var, str, dk9Var) == null) {
            String e = e(str);
            if (!j(e)) {
                ok9 ok9Var = new ok9(bk9Var, new lk9(this.d, dk9Var), this.c, e, this.b, this);
                this.a.put(e, ok9Var);
                ok9Var.start();
            }
        }
    }

    public void g(String str, String str2, String str3, dk9 dk9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, str, str2, str3, dk9Var) == null) {
            bk9.b bVar = new bk9.b();
            bVar.d(str);
            bVar.b(new File(str2));
            bVar.c(str3);
            f(bVar.a(), str, dk9Var);
        }
    }

    public final void i(@NonNull zj9 zj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, zj9Var) == null) {
            if (zj9Var.b() <= zj9Var.a()) {
                this.b = zj9Var;
                this.c = Executors.newFixedThreadPool(zj9Var.a());
                this.d = new mk9(this.e);
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
                ik9 ik9Var = this.a.get(e);
                if (ik9Var != null && ik9Var.isRunning()) {
                    ik9Var.pause();
                }
                this.a.remove(e);
            }
        }
    }
}
