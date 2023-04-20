package com.baidu.tieba;

import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class gc0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String d = "gc0";
    public transient /* synthetic */ FieldHolder $fh;
    public ic0 a;
    public List<hc0> b;
    public int c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947788981, "Lcom/baidu/tieba/gc0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947788981, "Lcom/baidu/tieba/gc0;");
        }
    }

    public gc0(Object obj, List<uc0> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj, list};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = 0;
        b(obj, list);
    }

    public void a(long j) {
        List<hc0> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048576, this, j) == null) && this.a != null && (list = this.b) != null && list.size() != 0) {
            synchronized (this) {
                for (hc0 hc0Var : this.b) {
                    this.a.b(hc0Var.c());
                    hc0Var.b(j);
                }
                notifyAll();
            }
            this.a.d(j);
            this.a.e();
        }
    }

    public final void b(Object obj, List<uc0> list) {
        hc0 hc0Var;
        ic0 ic0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, list) == null) && list != null && list.size() != 0) {
            List<hc0> list2 = this.b;
            if (list2 == null) {
                this.b = new ArrayList();
            } else {
                list2.clear();
            }
            for (int i = 0; i < list.size(); i++) {
                try {
                    this.b.add(new hc0(list.get(i)));
                    if (list.get(i).k()) {
                        this.c = i;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            int size = this.b.size();
            int i2 = this.c;
            if (size > i2) {
                if (obj != null) {
                    if (obj instanceof Surface) {
                        this.a = new ic0(this.b.get(this.c).c(), (Surface) obj, true);
                    } else if (obj instanceof SurfaceTexture) {
                        this.a = new ic0(this.b.get(this.c).c(), (SurfaceTexture) obj);
                    } else if (obj instanceof SurfaceHolder) {
                        this.a = new ic0(this.b.get(this.c).c(), (SurfaceHolder) obj);
                    }
                } else {
                    List<hc0> list3 = this.b;
                    if (list3 != null && list3 != null && (hc0Var = list3.get(i2)) != null && (ic0Var = this.a) != null) {
                        ic0Var.f(hc0Var.c());
                    }
                }
            }
            for (hc0 hc0Var2 : this.b) {
                ic0 ic0Var2 = this.a;
                if (ic0Var2 != null) {
                    ic0Var2.b(hc0Var2.c());
                    hc0Var2.f();
                }
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ic0 ic0Var = this.a;
            if (ic0Var != null) {
                ic0Var.g();
                this.a = null;
            }
            List<hc0> list = this.b;
            if (list != null) {
                for (hc0 hc0Var : list) {
                    hc0Var.e();
                }
                this.b.clear();
                this.b = null;
            }
        }
    }

    public void d(nc0 nc0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, nc0Var) == null) {
            for (hc0 hc0Var : this.b) {
                ic0 ic0Var = this.a;
                if (ic0Var != null) {
                    ic0Var.b(hc0Var.c());
                    hc0Var.g(nc0Var);
                }
            }
        }
    }

    public void e(List<uc0> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            Log.d(d, "updateSurfaceDrawer !!!");
            this.a.c();
            for (hc0 hc0Var : this.b) {
                hc0Var.e();
            }
            this.b.clear();
            b(null, list);
        }
    }
}
