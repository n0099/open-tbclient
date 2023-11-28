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
public class c90 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String d = "c90";
    public transient /* synthetic */ FieldHolder $fh;
    public e90 a;
    public List<d90> b;
    public int c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947629455, "Lcom/baidu/tieba/c90;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947629455, "Lcom/baidu/tieba/c90;");
        }
    }

    public c90(Object obj, List<q90> list) {
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
        List<d90> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048576, this, j) == null) && this.a != null && (list = this.b) != null && list.size() != 0) {
            synchronized (this) {
                for (d90 d90Var : this.b) {
                    this.a.b(d90Var.c());
                    d90Var.b(j);
                }
                notifyAll();
            }
            this.a.d(j);
            this.a.e();
        }
    }

    public final void b(Object obj, List<q90> list) {
        d90 d90Var;
        e90 e90Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, list) == null) && list != null && list.size() != 0) {
            List<d90> list2 = this.b;
            if (list2 == null) {
                this.b = new ArrayList();
            } else {
                list2.clear();
            }
            for (int i = 0; i < list.size(); i++) {
                try {
                    this.b.add(new d90(list.get(i)));
                    if (list.get(i).l()) {
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
                        this.a = new e90(this.b.get(this.c).c(), (Surface) obj, true);
                    } else if (obj instanceof SurfaceTexture) {
                        this.a = new e90(this.b.get(this.c).c(), (SurfaceTexture) obj);
                    } else if (obj instanceof SurfaceHolder) {
                        this.a = new e90(this.b.get(this.c).c(), (SurfaceHolder) obj);
                    }
                } else {
                    List<d90> list3 = this.b;
                    if (list3 != null && list3 != null && (d90Var = list3.get(i2)) != null && (e90Var = this.a) != null) {
                        e90Var.f(d90Var.c());
                    }
                }
            }
            for (d90 d90Var2 : this.b) {
                e90 e90Var2 = this.a;
                if (e90Var2 != null) {
                    e90Var2.b(d90Var2.c());
                    d90Var2.f();
                }
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            e90 e90Var = this.a;
            if (e90Var != null) {
                e90Var.g();
                this.a = null;
            }
            List<d90> list = this.b;
            if (list != null) {
                for (d90 d90Var : list) {
                    d90Var.e();
                }
                this.b.clear();
                this.b = null;
            }
        }
    }

    public void d(j90 j90Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, j90Var) == null) {
            for (d90 d90Var : this.b) {
                e90 e90Var = this.a;
                if (e90Var != null) {
                    e90Var.b(d90Var.c());
                    d90Var.g(j90Var);
                }
            }
        }
    }

    public void e(List<q90> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            Log.d(d, "updateSurfaceDrawer !!!");
            this.a.c();
            for (d90 d90Var : this.b) {
                d90Var.e();
            }
            this.b.clear();
            b(null, list);
        }
    }
}
