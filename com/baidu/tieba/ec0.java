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
public class ec0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String d = "ec0";
    public transient /* synthetic */ FieldHolder $fh;
    public gc0 a;
    public List<fc0> b;
    public int c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947729399, "Lcom/baidu/tieba/ec0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947729399, "Lcom/baidu/tieba/ec0;");
        }
    }

    public ec0(Object obj, List<sc0> list) {
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
        List<fc0> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048576, this, j) == null) && this.a != null && (list = this.b) != null && list.size() != 0) {
            synchronized (this) {
                for (fc0 fc0Var : this.b) {
                    this.a.b(fc0Var.c());
                    fc0Var.b(j);
                }
                notifyAll();
            }
            this.a.d(j);
            this.a.e();
        }
    }

    public final void b(Object obj, List<sc0> list) {
        fc0 fc0Var;
        gc0 gc0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, list) == null) && list != null && list.size() != 0) {
            List<fc0> list2 = this.b;
            if (list2 == null) {
                this.b = new ArrayList();
            } else {
                list2.clear();
            }
            for (int i = 0; i < list.size(); i++) {
                try {
                    this.b.add(new fc0(list.get(i)));
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
                        this.a = new gc0(this.b.get(this.c).c(), (Surface) obj, true);
                    } else if (obj instanceof SurfaceTexture) {
                        this.a = new gc0(this.b.get(this.c).c(), (SurfaceTexture) obj);
                    } else if (obj instanceof SurfaceHolder) {
                        this.a = new gc0(this.b.get(this.c).c(), (SurfaceHolder) obj);
                    }
                } else {
                    List<fc0> list3 = this.b;
                    if (list3 != null && list3 != null && (fc0Var = list3.get(i2)) != null && (gc0Var = this.a) != null) {
                        gc0Var.f(fc0Var.c());
                    }
                }
            }
            for (fc0 fc0Var2 : this.b) {
                gc0 gc0Var2 = this.a;
                if (gc0Var2 != null) {
                    gc0Var2.b(fc0Var2.c());
                    fc0Var2.f();
                }
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            gc0 gc0Var = this.a;
            if (gc0Var != null) {
                gc0Var.g();
                this.a = null;
            }
            List<fc0> list = this.b;
            if (list != null) {
                for (fc0 fc0Var : list) {
                    fc0Var.e();
                }
                this.b.clear();
                this.b = null;
            }
        }
    }

    public void d(lc0 lc0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, lc0Var) == null) {
            for (fc0 fc0Var : this.b) {
                gc0 gc0Var = this.a;
                if (gc0Var != null) {
                    gc0Var.b(fc0Var.c());
                    fc0Var.g(lc0Var);
                }
            }
        }
    }

    public void e(List<sc0> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            Log.d(d, "updateSurfaceDrawer !!!");
            this.a.c();
            for (fc0 fc0Var : this.b) {
                fc0Var.e();
            }
            this.b.clear();
            b(null, list);
        }
    }
}
