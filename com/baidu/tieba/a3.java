package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.h3;
import com.baidu.tieba.x2;
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
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public abstract class a3<T extends x2> implements l3 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<Application, h3<a3>> i;
    public static int j;
    public static boolean k;
    public transient /* synthetic */ FieldHolder $fh;
    public h3<T> a;
    public int b;
    public int c;
    public int d;
    public int e;
    public boolean f;
    public boolean g;
    public c<? extends a3<T>> h;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
    }

    /* loaded from: classes5.dex */
    public static abstract class c<U extends a3<? extends x2>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public h3<b> c;
        public a d;
        public a e;
        public a f;
        public boolean g;
        public boolean h;
        public boolean i;
    }

    public abstract void c(T t);

    public abstract T g(b bVar);

    public abstract void h(T t);

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public boolean b;
        public boolean c;

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (!this.b && !this.c) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448297979, "Lcom/baidu/tieba/a3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448297979, "Lcom/baidu/tieba/a3;");
                return;
            }
        }
        i = new HashMap();
        k = false;
    }

    public a3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new h3<>();
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            StringBuilder sb = new StringBuilder();
            j(sb);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static void b(Application application, a3 a3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, application, a3Var) == null) {
            h3<a3> h3Var = i.get(application);
            if (h3Var == null) {
                h3Var = new h3<>();
            }
            h3Var.a(a3Var);
            i.put(application, h3Var);
        }
    }

    public static void f(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, application) == null) {
            i.remove(application);
        }
    }

    public static StringBuilder j(StringBuilder sb) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, sb)) == null) {
            sb.append("Managed buffers/app: { ");
            for (Application application : i.keySet()) {
                sb.append(i.get(application).b);
                sb.append(" ");
            }
            sb.append("}");
            return sb;
        }
        return (StringBuilder) invokeL.objValue;
    }

    public static void k(Application application) {
        h3<a3> h3Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65542, null, application) != null) || o1.d == null || (h3Var = i.get(application)) == null) {
            return;
        }
        for (int i2 = 0; i2 < h3Var.b; i2++) {
            h3Var.get(i2).d();
        }
    }

    public void d() {
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            v2 v2Var = o1.d;
            e();
            if (!k) {
                k = true;
                if (o1.a.getType() == Application.ApplicationType.iOS) {
                    IntBuffer asIntBuffer = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asIntBuffer();
                    v2Var.w(36006, asIntBuffer);
                    j = asIntBuffer.get(0);
                } else {
                    j = 0;
                }
            }
            int I = v2Var.I();
            this.b = I;
            v2Var.f(36160, I);
            c<? extends a3<T>> cVar = this.h;
            int i3 = cVar.a;
            int i4 = cVar.b;
            if (cVar.h) {
                int H = v2Var.H();
                this.c = H;
                v2Var.l(36161, H);
                v2Var.e(36161, this.h.e.a, i3, i4);
            }
            if (this.h.g) {
                int H2 = v2Var.H();
                this.d = H2;
                v2Var.l(36161, H2);
                v2Var.e(36161, this.h.d.a, i3, i4);
            }
            if (this.h.i) {
                int H3 = v2Var.H();
                this.e = H3;
                v2Var.l(36161, H3);
                v2Var.e(36161, this.h.f.a, i3, i4);
            }
            if (this.h.c.b > 1) {
                z = true;
            } else {
                z = false;
            }
            this.g = z;
            if (z) {
                h3.b<b> it = this.h.c.iterator();
                int i5 = 0;
                while (it.hasNext()) {
                    b next = it.next();
                    T g = g(next);
                    this.a.a(g);
                    if (next.a()) {
                        v2Var.v(36160, i5 + 36064, 3553, g.e(), 0);
                        i5++;
                    } else if (next.b) {
                        v2Var.v(36160, 36096, 3553, g.e(), 0);
                    } else if (next.c) {
                        v2Var.v(36160, 36128, 3553, g.e(), 0);
                    }
                }
                i2 = i5;
            } else {
                T g2 = g(this.h.c.first());
                this.a.a(g2);
                v2Var.F(g2.a, g2.e());
                i2 = 0;
            }
            if (this.g) {
                IntBuffer b2 = BufferUtils.b(i2);
                for (int i6 = 0; i6 < i2; i6++) {
                    b2.put(i6 + 36064);
                }
                b2.position(0);
                o1.e.c(i2, b2);
            } else {
                c(this.a.first());
            }
            if (this.h.h) {
                v2Var.j(36160, 36096, 36161, this.c);
            }
            if (this.h.g) {
                v2Var.j(36160, 36128, 36161, this.d);
            }
            if (this.h.i) {
                v2Var.j(36160, 33306, 36161, this.e);
            }
            v2Var.l(36161, 0);
            h3.b<T> it2 = this.a.iterator();
            while (it2.hasNext()) {
                v2Var.F(it2.next().a, 0);
            }
            int r = v2Var.r(36160);
            if (r == 36061) {
                c<? extends a3<T>> cVar2 = this.h;
                if (cVar2.h && cVar2.g && (o1.b.a("GL_OES_packed_depth_stencil") || o1.b.a("GL_EXT_packed_depth_stencil"))) {
                    if (this.h.h) {
                        v2Var.n(this.c);
                        this.c = 0;
                    }
                    if (this.h.g) {
                        v2Var.n(this.d);
                        this.d = 0;
                    }
                    if (this.h.i) {
                        v2Var.n(this.e);
                        this.e = 0;
                    }
                    int H4 = v2Var.H();
                    this.e = H4;
                    this.f = true;
                    v2Var.l(36161, H4);
                    v2Var.e(36161, 35056, i3, i4);
                    v2Var.l(36161, 0);
                    v2Var.j(36160, 36096, 36161, this.e);
                    v2Var.j(36160, 36128, 36161, this.e);
                    r = v2Var.r(36160);
                }
            }
            v2Var.f(36160, j);
            if (r != 36053) {
                h3.b<T> it3 = this.a.iterator();
                while (it3.hasNext()) {
                    h(it3.next());
                }
                if (this.f) {
                    v2Var.b(this.e);
                } else {
                    if (this.h.h) {
                        v2Var.n(this.c);
                    }
                    if (this.h.g) {
                        v2Var.n(this.d);
                    }
                }
                v2Var.p(this.b);
                if (r != 36054) {
                    if (r != 36057) {
                        if (r != 36055) {
                            if (r == 36061) {
                                throw new IllegalStateException("Frame buffer couldn't be constructed: unsupported combination of formats");
                            }
                            throw new IllegalStateException("Frame buffer couldn't be constructed: unknown error " + r);
                        }
                        throw new IllegalStateException("Frame buffer couldn't be constructed: missing attachment");
                    }
                    throw new IllegalStateException("Frame buffer couldn't be constructed: incomplete dimensions");
                }
                throw new IllegalStateException("Frame buffer couldn't be constructed: incomplete attachment");
            }
            b(o1.a, this);
        }
    }

    @Override // com.baidu.tieba.l3
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            v2 v2Var = o1.d;
            h3.b<T> it = this.a.iterator();
            while (it.hasNext()) {
                h(it.next());
            }
            if (this.f) {
                v2Var.n(this.e);
            } else {
                if (this.h.h) {
                    v2Var.n(this.c);
                }
                if (this.h.g) {
                    v2Var.n(this.d);
                }
            }
            v2Var.p(this.b);
            if (i.get(o1.a) != null) {
                i.get(o1.a).g(this, true);
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && !o1.b.b()) {
            c<? extends a3<T>> cVar = this.h;
            if (!cVar.i) {
                h3<b> h3Var = cVar.c;
                if (h3Var.b <= 1) {
                    h3.b<b> it = h3Var.iterator();
                    while (it.hasNext()) {
                        b next = it.next();
                        if (!next.b) {
                            if (!next.c) {
                                if (next.a && !o1.b.a("OES_texture_float")) {
                                    throw new GdxRuntimeException("Float texture FrameBuffer Attachment not available on GLES 2.0");
                                }
                            } else {
                                throw new GdxRuntimeException("Stencil texture FrameBuffer Attachment not available on GLES 2.0");
                            }
                        } else {
                            throw new GdxRuntimeException("Depth texture FrameBuffer Attachment not available on GLES 2.0");
                        }
                    }
                    return;
                }
                throw new GdxRuntimeException("Multiple render targets not available on GLES 2.0");
            }
            throw new GdxRuntimeException("Packed Stencil/Render render buffers are not available on GLES 2.0");
        }
    }
}
