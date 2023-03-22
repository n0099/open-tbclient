package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.k6;
import com.baidu.tieba.y2;
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
/* loaded from: classes3.dex */
public abstract class b5<T extends y2> implements r6 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<Application, k6<b5>> i;
    public static int j;
    public static boolean k;
    public transient /* synthetic */ FieldHolder $fh;
    public k6<T> a;
    public int b;
    public int c;
    public int d;
    public int e;
    public boolean f;
    public boolean g;
    public c<? extends b5<T>> h;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
    }

    /* loaded from: classes3.dex */
    public static abstract class c<U extends b5<? extends y2>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public k6<b> c;
        public a d;
        public a e;
        public a f;
        public boolean g;
        public boolean h;
        public boolean i;
    }

    public abstract void f(T t);

    public abstract T j(b bVar);

    public abstract void k(T t);

    /* loaded from: classes3.dex */
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448299002, "Lcom/baidu/tieba/b5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448299002, "Lcom/baidu/tieba/b5;");
                return;
            }
        }
        i = new HashMap();
        k = false;
    }

    public b5() {
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
        this.a = new k6<>();
    }

    public static String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            StringBuilder sb = new StringBuilder();
            m(sb);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static void a(Application application, b5 b5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, application, b5Var) == null) {
            k6<b5> k6Var = i.get(application);
            if (k6Var == null) {
                k6Var = new k6<>();
            }
            k6Var.a(b5Var);
            i.put(application, k6Var);
        }
    }

    public static void i(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, application) == null) {
            i.remove(application);
        }
    }

    public static StringBuilder m(StringBuilder sb) {
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

    public static void n(Application application) {
        k6<b5> k6Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65542, null, application) != null) || o0.f == null || (k6Var = i.get(application)) == null) {
            return;
        }
        for (int i2 = 0; i2 < k6Var.b; i2++) {
            k6Var.get(i2).g();
        }
    }

    @Override // com.baidu.tieba.r6
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            w2 w2Var = o0.f;
            k6.b<T> it = this.a.iterator();
            while (it.hasNext()) {
                k(it.next());
            }
            if (this.f) {
                w2Var.p(this.e);
            } else {
                if (this.h.h) {
                    w2Var.p(this.c);
                }
                if (this.h.g) {
                    w2Var.p(this.d);
                }
            }
            w2Var.r(this.b);
            if (i.get(o0.a) != null) {
                i.get(o0.a).i(this, true);
            }
        }
    }

    public void g() {
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            w2 w2Var = o0.f;
            h();
            if (!k) {
                k = true;
                if (o0.a.getType() == Application.ApplicationType.iOS) {
                    IntBuffer asIntBuffer = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asIntBuffer();
                    w2Var.C(36006, asIntBuffer);
                    j = asIntBuffer.get(0);
                } else {
                    j = 0;
                }
            }
            int Q = w2Var.Q();
            this.b = Q;
            w2Var.f(36160, Q);
            c<? extends b5<T>> cVar = this.h;
            int i3 = cVar.a;
            int i4 = cVar.b;
            if (cVar.h) {
                int P = w2Var.P();
                this.c = P;
                w2Var.m(36161, P);
                w2Var.e(36161, this.h.e.a, i3, i4);
            }
            if (this.h.g) {
                int P2 = w2Var.P();
                this.d = P2;
                w2Var.m(36161, P2);
                w2Var.e(36161, this.h.d.a, i3, i4);
            }
            if (this.h.i) {
                int P3 = w2Var.P();
                this.e = P3;
                w2Var.m(36161, P3);
                w2Var.e(36161, this.h.f.a, i3, i4);
            }
            if (this.h.c.b > 1) {
                z = true;
            } else {
                z = false;
            }
            this.g = z;
            if (z) {
                k6.b<b> it = this.h.c.iterator();
                int i5 = 0;
                while (it.hasNext()) {
                    b next = it.next();
                    T j2 = j(next);
                    this.a.a(j2);
                    if (next.a()) {
                        w2Var.B(36160, i5 + 36064, 3553, j2.i(), 0);
                        i5++;
                    } else if (next.b) {
                        w2Var.B(36160, 36096, 3553, j2.i(), 0);
                    } else if (next.c) {
                        w2Var.B(36160, 36128, 3553, j2.i(), 0);
                    }
                }
                i2 = i5;
            } else {
                T j3 = j(this.h.c.first());
                this.a.a(j3);
                w2Var.N(j3.a, j3.i());
                i2 = 0;
            }
            if (this.g) {
                IntBuffer d = BufferUtils.d(i2);
                for (int i6 = 0; i6 < i2; i6++) {
                    d.put(i6 + 36064);
                }
                d.position(0);
                o0.g.c(i2, d);
            } else {
                f(this.a.first());
            }
            if (this.h.h) {
                w2Var.k(36160, 36096, 36161, this.c);
            }
            if (this.h.g) {
                w2Var.k(36160, 36128, 36161, this.d);
            }
            if (this.h.i) {
                w2Var.k(36160, 33306, 36161, this.e);
            }
            w2Var.m(36161, 0);
            k6.b<T> it2 = this.a.iterator();
            while (it2.hasNext()) {
                w2Var.N(it2.next().a, 0);
            }
            int t = w2Var.t(36160);
            if (t == 36061) {
                c<? extends b5<T>> cVar2 = this.h;
                if (cVar2.h && cVar2.g && (o0.b.a("GL_OES_packed_depth_stencil") || o0.b.a("GL_EXT_packed_depth_stencil"))) {
                    if (this.h.h) {
                        w2Var.p(this.c);
                        this.c = 0;
                    }
                    if (this.h.g) {
                        w2Var.p(this.d);
                        this.d = 0;
                    }
                    if (this.h.i) {
                        w2Var.p(this.e);
                        this.e = 0;
                    }
                    int P4 = w2Var.P();
                    this.e = P4;
                    this.f = true;
                    w2Var.m(36161, P4);
                    w2Var.e(36161, 35056, i3, i4);
                    w2Var.m(36161, 0);
                    w2Var.k(36160, 36096, 36161, this.e);
                    w2Var.k(36160, 36128, 36161, this.e);
                    t = w2Var.t(36160);
                }
            }
            w2Var.f(36160, j);
            if (t != 36053) {
                k6.b<T> it3 = this.a.iterator();
                while (it3.hasNext()) {
                    k(it3.next());
                }
                if (this.f) {
                    w2Var.b(this.e);
                } else {
                    if (this.h.h) {
                        w2Var.p(this.c);
                    }
                    if (this.h.g) {
                        w2Var.p(this.d);
                    }
                }
                w2Var.r(this.b);
                if (t != 36054) {
                    if (t != 36057) {
                        if (t != 36055) {
                            if (t == 36061) {
                                throw new IllegalStateException("Frame buffer couldn't be constructed: unsupported combination of formats");
                            }
                            throw new IllegalStateException("Frame buffer couldn't be constructed: unknown error " + t);
                        }
                        throw new IllegalStateException("Frame buffer couldn't be constructed: missing attachment");
                    }
                    throw new IllegalStateException("Frame buffer couldn't be constructed: incomplete dimensions");
                }
                throw new IllegalStateException("Frame buffer couldn't be constructed: incomplete attachment");
            }
            a(o0.a, this);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && !o0.b.b()) {
            c<? extends b5<T>> cVar = this.h;
            if (!cVar.i) {
                k6<b> k6Var = cVar.c;
                if (k6Var.b <= 1) {
                    k6.b<b> it = k6Var.iterator();
                    while (it.hasNext()) {
                        b next = it.next();
                        if (!next.b) {
                            if (!next.c) {
                                if (next.a && !o0.b.a("OES_texture_float")) {
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
