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
/* loaded from: classes5.dex */
public class b90 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String d = "b90";
    public transient /* synthetic */ FieldHolder $fh;
    public d90 a;
    public List<c90> b;
    public int c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947599664, "Lcom/baidu/tieba/b90;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947599664, "Lcom/baidu/tieba/b90;");
        }
    }

    public b90(Object obj, List<p90> list) {
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
        List<c90> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048576, this, j) == null) && this.a != null && (list = this.b) != null && list.size() != 0) {
            synchronized (this) {
                for (c90 c90Var : this.b) {
                    this.a.b(c90Var.c());
                    c90Var.b(j);
                }
                notifyAll();
            }
            this.a.d(j);
            this.a.e();
        }
    }

    public final void b(Object obj, List<p90> list) {
        c90 c90Var;
        d90 d90Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, list) == null) && list != null && list.size() != 0) {
            List<c90> list2 = this.b;
            if (list2 == null) {
                this.b = new ArrayList();
            } else {
                list2.clear();
            }
            for (int i = 0; i < list.size(); i++) {
                try {
                    this.b.add(new c90(list.get(i)));
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
                        this.a = new d90(this.b.get(this.c).c(), (Surface) obj, true);
                    } else if (obj instanceof SurfaceTexture) {
                        this.a = new d90(this.b.get(this.c).c(), (SurfaceTexture) obj);
                    } else if (obj instanceof SurfaceHolder) {
                        this.a = new d90(this.b.get(this.c).c(), (SurfaceHolder) obj);
                    }
                } else {
                    List<c90> list3 = this.b;
                    if (list3 != null && list3 != null && (c90Var = list3.get(i2)) != null && (d90Var = this.a) != null) {
                        d90Var.f(c90Var.c());
                    }
                }
            }
            for (c90 c90Var2 : this.b) {
                d90 d90Var2 = this.a;
                if (d90Var2 != null) {
                    d90Var2.b(c90Var2.c());
                    c90Var2.f();
                }
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d90 d90Var = this.a;
            if (d90Var != null) {
                d90Var.g();
                this.a = null;
            }
            List<c90> list = this.b;
            if (list != null) {
                for (c90 c90Var : list) {
                    c90Var.e();
                }
                this.b.clear();
                this.b = null;
            }
        }
    }

    public void d(i90 i90Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, i90Var) == null) {
            for (c90 c90Var : this.b) {
                d90 d90Var = this.a;
                if (d90Var != null) {
                    d90Var.b(c90Var.c());
                    c90Var.g(i90Var);
                }
            }
        }
    }

    public void e(List<p90> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            Log.d(d, "updateSurfaceDrawer !!!");
            this.a.c();
            for (c90 c90Var : this.b) {
                c90Var.e();
            }
            this.b.clear();
            b(null, list);
        }
    }
}
