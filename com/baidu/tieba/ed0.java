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
public class ed0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String d = "ed0";
    public transient /* synthetic */ FieldHolder $fh;
    public gd0 a;
    public List<fd0> b;
    public int c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947730360, "Lcom/baidu/tieba/ed0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947730360, "Lcom/baidu/tieba/ed0;");
        }
    }

    public ed0(Object obj, List<sd0> list) {
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
        List<fd0> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048576, this, j) == null) && this.a != null && (list = this.b) != null && list.size() != 0) {
            synchronized (this) {
                for (fd0 fd0Var : this.b) {
                    this.a.b(fd0Var.c());
                    fd0Var.b(j);
                }
                notifyAll();
            }
            this.a.d(j);
            this.a.e();
        }
    }

    public final void b(Object obj, List<sd0> list) {
        fd0 fd0Var;
        gd0 gd0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, list) == null) && list != null && list.size() != 0) {
            List<fd0> list2 = this.b;
            if (list2 == null) {
                this.b = new ArrayList();
            } else {
                list2.clear();
            }
            for (int i = 0; i < list.size(); i++) {
                try {
                    this.b.add(new fd0(list.get(i)));
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
                        this.a = new gd0(this.b.get(this.c).c(), (Surface) obj, true);
                    } else if (obj instanceof SurfaceTexture) {
                        this.a = new gd0(this.b.get(this.c).c(), (SurfaceTexture) obj);
                    } else if (obj instanceof SurfaceHolder) {
                        this.a = new gd0(this.b.get(this.c).c(), (SurfaceHolder) obj);
                    }
                } else {
                    List<fd0> list3 = this.b;
                    if (list3 != null && list3 != null && (fd0Var = list3.get(i2)) != null && (gd0Var = this.a) != null) {
                        gd0Var.f(fd0Var.c());
                    }
                }
            }
            for (fd0 fd0Var2 : this.b) {
                gd0 gd0Var2 = this.a;
                if (gd0Var2 != null) {
                    gd0Var2.b(fd0Var2.c());
                    fd0Var2.f();
                }
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            gd0 gd0Var = this.a;
            if (gd0Var != null) {
                gd0Var.g();
                this.a = null;
            }
            List<fd0> list = this.b;
            if (list != null) {
                for (fd0 fd0Var : list) {
                    fd0Var.e();
                }
                this.b.clear();
                this.b = null;
            }
        }
    }

    public void d(ld0 ld0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ld0Var) == null) {
            for (fd0 fd0Var : this.b) {
                gd0 gd0Var = this.a;
                if (gd0Var != null) {
                    gd0Var.b(fd0Var.c());
                    fd0Var.g(ld0Var);
                }
            }
        }
    }

    public void e(List<sd0> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            Log.d(d, "updateSurfaceDrawer !!!");
            this.a.c();
            for (fd0 fd0Var : this.b) {
                fd0Var.e();
            }
            this.b.clear();
            b(null, list);
        }
    }
}
