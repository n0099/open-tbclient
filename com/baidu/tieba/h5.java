package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.utils.BufferUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.g7;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
/* loaded from: classes4.dex */
public class h5 implements r6 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String s = "";
    public static String t = "";
    public static final g7<Application, k6<h5>> u;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public boolean b;
    public final f7<String> c;
    public final f7<String> d;
    public final f7<String> e;
    public String[] f;
    public final f7<String> g;
    public final f7<String> h;
    public final f7<String> i;
    public String[] j;
    public int k;
    public int l;
    public int m;
    public final String n;
    public final String o;
    public boolean p;
    public IntBuffer q;
    public IntBuffer r;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448304768, "Lcom/baidu/tieba/h5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448304768, "Lcom/baidu/tieba/h5;");
                return;
            }
        }
        u = new g7<>();
        BufferUtils.d(1);
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.p) {
            h(this.n, this.o);
            this.p = false;
        }
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int M = o0.f.M();
            if (M == 0) {
                return -1;
            }
            return M;
        }
        return invokeV.intValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.b) {
                String J = o0.f.J(this.k);
                this.a = J;
                return J;
            }
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.b;
        }
        return invokeV.booleanValue;
    }

    public h5(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = "";
        this.c = new f7<>();
        this.d = new f7<>();
        this.e = new f7<>();
        this.g = new f7<>();
        this.h = new f7<>();
        this.i = new f7<>();
        this.q = BufferUtils.d(1);
        this.r = BufferUtils.d(1);
        if (str != null) {
            if (str2 != null) {
                String str3 = s;
                if (str3 != null && str3.length() > 0) {
                    str = s + str;
                }
                String str4 = t;
                if (str4 != null && str4.length() > 0) {
                    str2 = t + str2;
                }
                this.n = str;
                this.o = str2;
                BufferUtils.c(16);
                h(str, str2);
                if (o()) {
                    j();
                    k();
                    a(o0.a, this);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("fragment shader must not be null");
        }
        throw new IllegalArgumentException("vertex shader must not be null");
    }

    public static void g(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, application) == null) {
            u.k(application);
        }
    }

    public static String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Managed shaders/app: { ");
            g7.c<Application> f = u.f();
            f.c();
            while (f.hasNext()) {
                sb.append(u.c(f.next()).b);
                sb.append(" ");
            }
            sb.append("}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static void n(Application application) {
        k6<h5> c;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, application) != null) || o0.f == null || (c = u.c(application)) == null) {
            return;
        }
        for (int i = 0; i < c.b; i++) {
            c.get(i).p = true;
            c.get(i).f();
        }
    }

    public final void a(Application application, h5 h5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, application, h5Var) == null) {
            k6<h5> c = u.c(application);
            if (c == null) {
                c = new k6<>();
            }
            c.a(h5Var);
            u.i(application, c);
        }
    }

    @Override // com.baidu.tieba.r6
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            w2 w2Var = o0.f;
            w2Var.d(0);
            w2Var.K(this.l);
            w2Var.K(this.m);
            w2Var.H(this.k);
            if (u.c(o0.a) != null) {
                u.c(o0.a).i(this, true);
            }
        }
    }

    public final void h(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            this.l = q(35633, str);
            int q = q(35632, str2);
            this.m = q;
            if (this.l != -1 && q != -1) {
                int p = p(i());
                this.k = p;
                if (p == -1) {
                    this.b = false;
                    return;
                } else {
                    this.b = true;
                    return;
                }
            }
            this.b = false;
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.q.clear();
            o0.f.l(this.k, 35721, this.q);
            int i = this.q.get(0);
            this.j = new String[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.q.clear();
                this.q.put(0, 1);
                this.r.clear();
                String D = o0.f.D(this.k, i2, this.q, this.r);
                this.g.h(D, o0.f.R(this.k, D));
                this.h.h(D, this.r.get(0));
                this.i.h(D, this.q.get(0));
                this.j[i2] = D;
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.q.clear();
            o0.f.l(this.k, 35718, this.q);
            int i = this.q.get(0);
            this.f = new String[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.q.clear();
                this.q.put(0, 1);
                this.r.clear();
                String z = o0.f.z(this.k, i2, this.q, this.r);
                this.c.h(z, o0.f.w(this.k, z));
                this.d.h(z, this.r.get(0));
                this.e.h(z, this.q.get(0));
                this.f[i2] = z;
            }
        }
    }

    public final int p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            w2 w2Var = o0.f;
            if (i == -1) {
                return -1;
            }
            w2Var.L(i, this.l);
            w2Var.L(i, this.m);
            w2Var.G(i);
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(4);
            allocateDirect.order(ByteOrder.nativeOrder());
            IntBuffer asIntBuffer = allocateDirect.asIntBuffer();
            w2Var.l(i, 35714, asIntBuffer);
            if (asIntBuffer.get(0) == 0) {
                this.a = o0.f.J(i);
                return -1;
            }
            return i;
        }
        return invokeI.intValue;
    }

    public final int q(int i, String str) {
        InterceptResult invokeIL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048586, this, i, str)) == null) {
            w2 w2Var = o0.f;
            IntBuffer d = BufferUtils.d(1);
            int T = w2Var.T(i);
            if (T == 0) {
                return -1;
            }
            w2Var.y(T, str);
            w2Var.s(T);
            w2Var.I(T, 35713, d);
            if (d.get(0) == 0) {
                String x = w2Var.x(T);
                StringBuilder sb = new StringBuilder();
                sb.append(this.a);
                if (i == 35633) {
                    str2 = "Vertex shader\n";
                } else {
                    str2 = "Fragment shader:\n";
                }
                sb.append(str2);
                this.a = sb.toString();
                this.a += x;
                return -1;
            }
            return T;
        }
        return invokeIL.intValue;
    }
}
