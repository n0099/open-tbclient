package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.SerializationException;
import com.badlogic.gdx.utils.reflect.ReflectionException;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.g7;
import com.baidu.tieba.m3;
import com.baidu.tieba.o7;
import com.baidu.tieba.t3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class d6 implements z6 {
    public static /* synthetic */ Interceptable $ic;
    public static final Class[] e;
    public transient /* synthetic */ FieldHolder $fh;
    public o7<Class, o7<String, Object>> a;
    public t3 b;
    public float c;
    public final o7<String, Class> d;

    /* loaded from: classes5.dex */
    public class a extends g7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d6 n;

        public a(d6 d6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.n = d6Var;
        }

        @Override // com.baidu.tieba.g7
        public boolean g(Class cls, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cls, str)) == null) {
                return str.equals("parent");
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.g7
        public void i(Object obj, JsonValue jsonValue) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, jsonValue) == null) {
                if (jsonValue.s("parent")) {
                    String str = (String) l("parent", String.class, jsonValue);
                    Class<?> cls = obj.getClass();
                    do {
                        try {
                            c(this.n.h(str, cls), obj);
                        } catch (GdxRuntimeException unused) {
                            cls = cls.getSuperclass();
                            if (cls == Object.class) {
                                SerializationException serializationException = new SerializationException("Unable to find parent resource with name: " + str);
                                serializationException.addTrace(jsonValue.f.Q());
                                throw serializationException;
                            }
                        }
                    } while (cls == Object.class);
                    SerializationException serializationException2 = new SerializationException("Unable to find parent resource with name: " + str);
                    serializationException2.addTrace(jsonValue.f.Q());
                    throw serializationException2;
                }
                super.i(obj, jsonValue);
            }
        }

        @Override // com.baidu.tieba.g7
        public <T> T k(Class<T> cls, Class cls2, JsonValue jsonValue) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, cls, cls2, jsonValue)) == null) {
                if (jsonValue != null && jsonValue.D() && !l8.f(CharSequence.class, cls)) {
                    return (T) this.n.h(jsonValue.j(), cls);
                }
                return (T) super.k(cls, cls2, jsonValue);
            }
            return (T) invokeLLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends g7.b<d6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d6 a;
        public final /* synthetic */ d6 b;

        public b(d6 d6Var, d6 d6Var2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d6Var, d6Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = d6Var;
            this.a = d6Var2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.g7.d
        /* renamed from: b */
        public d6 a(g7 g7Var, JsonValue jsonValue, Class cls) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, g7Var, jsonValue, cls)) == null) {
                for (JsonValue jsonValue2 = jsonValue.f; jsonValue2 != null; jsonValue2 = jsonValue2.h) {
                    try {
                        Class e = g7Var.e(jsonValue2.G());
                        if (e == null) {
                            e = l8.a(jsonValue2.G());
                        }
                        c(g7Var, e, jsonValue2);
                    } catch (ReflectionException e2) {
                        throw new SerializationException(e2);
                    }
                }
                return this.a;
            }
            return (d6) invokeLLL.objValue;
        }

        public final void c(g7 g7Var, Class cls, JsonValue jsonValue) {
            Class cls2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, g7Var, cls, jsonValue) == null) {
                if (cls == f.class) {
                    cls2 = n6.class;
                } else {
                    cls2 = cls;
                }
                for (JsonValue jsonValue2 = jsonValue.f; jsonValue2 != null; jsonValue2 = jsonValue2.h) {
                    Object j = g7Var.j(cls, jsonValue2);
                    if (j != null) {
                        try {
                            this.b.f(jsonValue2.e, j, cls2);
                            if (cls2 != n6.class && l8.f(n6.class, cls2)) {
                                this.b.f(jsonValue2.e, j, n6.class);
                            }
                        } catch (Exception e) {
                            throw new SerializationException("Error reading " + l8.e(cls) + ": " + jsonValue2.e, e);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends g7.b<m3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b3 a;
        public final /* synthetic */ d6 b;

        public c(d6 d6Var, b3 b3Var, d6 d6Var2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d6Var, b3Var, d6Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b3Var;
            this.b = d6Var2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.g7.d
        /* renamed from: b */
        public m3 a(g7 g7Var, JsonValue jsonValue, Class cls) {
            InterceptResult invokeLLL;
            m3 m3Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, g7Var, jsonValue, cls)) == null) {
                String str = (String) g7Var.l("file", String.class, jsonValue);
                int intValue = ((Integer) g7Var.n("scaledSize", Integer.TYPE, -1, jsonValue)).intValue();
                Boolean bool = (Boolean) g7Var.n("flip", Boolean.class, Boolean.FALSE, jsonValue);
                Boolean bool2 = (Boolean) g7Var.n("markupEnabled", Boolean.class, Boolean.FALSE, jsonValue);
                b3 a = this.a.i().a(str);
                if (!a.c()) {
                    a = w0.d.a(str);
                }
                if (a.c()) {
                    String h = a.h();
                    try {
                        s6<u3> m = this.b.m(h);
                        if (m != null) {
                            m3Var = new m3(new m3.a(a, bool.booleanValue()), m, true);
                        } else {
                            u3 u3Var = (u3) this.b.r(h, u3.class);
                            if (u3Var != null) {
                                m3Var = new m3(a, u3Var, bool.booleanValue());
                            } else {
                                b3 i = a.i();
                                b3 a2 = i.a(h + ".png");
                                if (a2.c()) {
                                    m3Var = new m3(a, a2, bool.booleanValue());
                                } else {
                                    m3Var = new m3(a, bool.booleanValue());
                                }
                            }
                        }
                        m3Var.f().p = bool2.booleanValue();
                        if (intValue != -1) {
                            m3Var.f().h(intValue / m3Var.a());
                        }
                        return m3Var;
                    } catch (RuntimeException e) {
                        throw new SerializationException("Error loading bitmap font: " + a, e);
                    }
                }
                throw new SerializationException("Font file not found: " + a);
            }
            return (m3) invokeLLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d extends g7.b<c3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d6 a;

        public d(d6 d6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.g7.d
        /* renamed from: b */
        public c3 a(g7 g7Var, JsonValue jsonValue, Class cls) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, g7Var, jsonValue, cls)) == null) {
                if (jsonValue.D()) {
                    return (c3) this.a.h(jsonValue.j(), c3.class);
                }
                String str = (String) g7Var.n("hex", String.class, null, jsonValue);
                if (str != null) {
                    return c3.h(str);
                }
                return new c3(((Float) g7Var.n("r", Float.TYPE, Float.valueOf(0.0f), jsonValue)).floatValue(), ((Float) g7Var.n("g", Float.TYPE, Float.valueOf(0.0f), jsonValue)).floatValue(), ((Float) g7Var.n("b", Float.TYPE, Float.valueOf(0.0f), jsonValue)).floatValue(), ((Float) g7Var.n("a", Float.TYPE, Float.valueOf(1.0f), jsonValue)).floatValue());
            }
            return (c3) invokeLLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class e extends g7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d6 a;

        public e(d6 d6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d6Var;
        }

        @Override // com.baidu.tieba.g7.d
        public Object a(g7 g7Var, JsonValue jsonValue, Class cls) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, g7Var, jsonValue, cls)) == null) {
                String str = (String) g7Var.l("name", String.class, jsonValue);
                c3 c3Var = (c3) g7Var.l("color", c3.class, jsonValue);
                if (c3Var != null) {
                    n6 q = this.a.q(str, c3Var);
                    if (q instanceof m6) {
                        ((m6) q).n(jsonValue.e + " (" + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + c3Var + SmallTailInfo.EMOTION_SUFFIX);
                    }
                    return q;
                }
                throw new SerializationException("TintedDrawable missing color: " + jsonValue);
            }
            return invokeLLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448300955, "Lcom/baidu/tieba/d6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448300955, "Lcom/baidu/tieba/d6;");
                return;
            }
        }
        e = new Class[]{m3.class, c3.class, f.class, o6.class, p6.class, q6.class, r6.class, u5.class, v5.class, w5.class, x5.class, y5.class, z5.class, a6.class, b6.class, c6.class, e6.class, f6.class, g6.class, h6.class, i6.class, j6.class, k6.class, l6.class};
    }

    public d6() {
        Class[] clsArr;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new o7<>();
        this.c = 1.0f;
        this.d = new o7<>(e.length);
        for (Class cls : e) {
            this.d.i(cls.getSimpleName(), cls);
        }
    }

    @Override // com.baidu.tieba.z6
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            t3 t3Var = this.b;
            if (t3Var != null) {
                t3Var.dispose();
            }
            o7.e<o7<String, Object>> n = this.a.n();
            n.c();
            while (n.hasNext()) {
                o7.e<Object> n2 = n.next().n();
                n2.c();
                while (n2.hasNext()) {
                    Object next = n2.next();
                    if (next instanceof z6) {
                        ((z6) next).dispose();
                    }
                }
            }
        }
    }

    public d6(t3 t3Var) {
        Class[] clsArr;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t3Var};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = new o7<>();
        this.c = 1.0f;
        this.d = new o7<>(e.length);
        for (Class cls : e) {
            this.d.i(cls.getSimpleName(), cls);
        }
        this.b = t3Var;
        g(t3Var);
    }

    public u3 l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            u3 u3Var = (u3) r(str, u3.class);
            if (u3Var != null) {
                return u3Var;
            }
            Texture texture = (Texture) r(str, Texture.class);
            if (texture != null) {
                u3 u3Var2 = new u3(texture);
                f(str, u3Var2, u3.class);
                return u3Var2;
            }
            throw new GdxRuntimeException("No TextureRegion or Texture registered with name: " + str);
        }
        return (u3) invokeL.objValue;
    }

    public s6<u3> m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            u3 u3Var = (u3) r(str + "_0", u3.class);
            if (u3Var != null) {
                s6<u3> s6Var = new s6<>();
                int i = 1;
                while (u3Var != null) {
                    s6Var.a(u3Var);
                    u3Var = (u3) r(str + "_" + i, u3.class);
                    i++;
                }
                return s6Var;
            }
            return null;
        }
        return (s6) invokeL.objValue;
    }

    public void s(n6 n6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, n6Var) == null) {
            n6Var.b(n6Var.l() * this.c);
            n6Var.c(n6Var.g() * this.c);
            n6Var.d(n6Var.e() * this.c);
            n6Var.f(n6Var.i() * this.c);
            n6Var.j(n6Var.a() * this.c);
            n6Var.h(n6Var.k() * this.c);
        }
    }

    public void a(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, obj) == null) {
            f(str, obj, obj.getClass());
        }
    }

    public n6 q(String str, c3 c3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, c3Var)) == null) {
            return p(i(str), c3Var);
        }
        return (n6) invokeLL.objValue;
    }

    public void f(String str, Object obj, Class cls) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, obj, cls) == null) {
            if (str != null) {
                if (obj != null) {
                    o7<String, Object> c2 = this.a.c(cls);
                    if (c2 == null) {
                        if (cls != u3.class && cls != n6.class && cls != s3.class) {
                            i = 64;
                        } else {
                            i = 256;
                        }
                        c2 = new o7<>(i);
                        this.a.i(cls, c2);
                    }
                    c2.i(str, obj);
                    return;
                }
                throw new IllegalArgumentException("resource cannot be null.");
            }
            throw new IllegalArgumentException("name cannot be null.");
        }
    }

    public void g(t3 t3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, t3Var) == null) {
            s6<t3.a> g = t3Var.g();
            int i = g.b;
            for (int i2 = 0; i2 < i; i2++) {
                t3.a aVar = g.get(i2);
                String str = aVar.i;
                if (aVar.h != -1) {
                    str = str + "_" + aVar.h;
                }
                f(str, aVar, u3.class);
            }
        }
    }

    public <T> T h(String str, Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, cls)) == null) {
            if (str != null) {
                if (cls != null) {
                    if (cls == n6.class) {
                        return (T) i(str);
                    }
                    if (cls == u3.class) {
                        return (T) l(str);
                    }
                    if (cls == o3.class) {
                        return (T) k(str);
                    }
                    if (cls == s3.class) {
                        return (T) n(str);
                    }
                    o7<String, Object> c2 = this.a.c(cls);
                    if (c2 != null) {
                        T t = (T) c2.c(str);
                        if (t != null) {
                            return t;
                        }
                        throw new GdxRuntimeException("No " + cls.getName() + " registered with name: " + str);
                    }
                    throw new GdxRuntimeException("No " + cls.getName() + " registered with name: " + str);
                }
                throw new IllegalArgumentException("type cannot be null.");
            }
            throw new IllegalArgumentException("name cannot be null.");
        }
        return (T) invokeLL.objValue;
    }

    public n6 i(String str) {
        InterceptResult invokeL;
        n6 p6Var;
        n6 p6Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            n6 n6Var = (n6) r(str, n6.class);
            if (n6Var != null) {
                return n6Var;
            }
            try {
                u3 l = l(str);
                if (l instanceof t3.a) {
                    t3.a aVar = (t3.a) l;
                    if (aVar.k("split") != null) {
                        p6Var2 = new o6(k(str));
                    } else if (aVar.p || aVar.l != aVar.n || aVar.m != aVar.o) {
                        p6Var2 = new p6(n(str));
                    }
                    n6Var = p6Var2;
                }
                if (n6Var == null) {
                    n6 q6Var = new q6(l);
                    try {
                        if (this.c != 1.0f) {
                            s(q6Var);
                        }
                    } catch (GdxRuntimeException unused) {
                    }
                    n6Var = q6Var;
                }
            } catch (GdxRuntimeException unused2) {
            }
            if (n6Var == null) {
                o3 o3Var = (o3) r(str, o3.class);
                if (o3Var != null) {
                    p6Var = new o6(o3Var);
                } else {
                    s3 s3Var = (s3) r(str, s3.class);
                    if (s3Var != null) {
                        p6Var = new p6(s3Var);
                    } else {
                        throw new GdxRuntimeException("No Drawable, NinePatch, TextureRegion, Texture, or Sprite registered with name: " + str);
                    }
                }
                n6Var = p6Var;
            }
            if (n6Var instanceof m6) {
                ((m6) n6Var).n(str);
            }
            f(str, n6Var, n6.class);
            return n6Var;
        }
        return (n6) invokeL.objValue;
    }

    public g7 j(b3 b3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, b3Var)) == null) {
            a aVar = new a(this);
            aVar.p(null);
            aVar.q(false);
            aVar.o(d6.class, new b(this, this));
            aVar.o(m3.class, new c(this, b3Var, this));
            aVar.o(c3.class, new d(this));
            aVar.o(f.class, new e(this));
            o7.a<String, Class> it = this.d.iterator();
            while (it.hasNext()) {
                o7.b next = it.next();
                aVar.a((String) next.a, (Class) next.b);
            }
            return aVar;
        }
        return (g7) invokeL.objValue;
    }

    public o3 k(String str) {
        InterceptResult invokeL;
        int[] k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            o3 o3Var = (o3) r(str, o3.class);
            if (o3Var != null) {
                return o3Var;
            }
            try {
                u3 l = l(str);
                if ((l instanceof t3.a) && (k = ((t3.a) l).k("split")) != null) {
                    o3Var = new o3(l, k[0], k[1], k[2], k[3]);
                    int[] k2 = ((t3.a) l).k("pad");
                    if (k2 != null) {
                        o3Var.n(k2[0], k2[1], k2[2], k2[3]);
                    }
                }
                if (o3Var == null) {
                    o3Var = new o3(l);
                }
                if (this.c != 1.0f) {
                    o3Var.m(this.c, this.c);
                }
                f(str, o3Var, o3.class);
                return o3Var;
            } catch (GdxRuntimeException unused) {
                throw new GdxRuntimeException("No NinePatch, TextureRegion, or Texture registered with name: " + str);
            }
        }
        return (o3) invokeL.objValue;
    }

    public s3 n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            s3 s3Var = (s3) r(str, s3.class);
            if (s3Var != null) {
                return s3Var;
            }
            try {
                u3 l = l(str);
                if (l instanceof t3.a) {
                    t3.a aVar = (t3.a) l;
                    if (aVar.p || aVar.l != aVar.n || aVar.m != aVar.o) {
                        s3Var = new t3.b(aVar);
                    }
                }
                if (s3Var == null) {
                    s3Var = new s3(l);
                }
                if (this.c != 1.0f) {
                    s3Var.z(s3Var.n() * this.c, s3Var.k() * this.c);
                }
                f(str, s3Var, s3.class);
                return s3Var;
            } catch (GdxRuntimeException unused) {
                throw new GdxRuntimeException("No NinePatch, TextureRegion, or Texture registered with name: " + str);
            }
        }
        return (s3) invokeL.objValue;
    }

    public void o(b3 b3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, b3Var) == null) {
            try {
                j(b3Var).d(d6.class, b3Var);
            } catch (SerializationException e2) {
                throw new SerializationException("Error reading file: " + b3Var, e2);
            }
        }
    }

    public n6 p(n6 n6Var, c3 c3Var) {
        InterceptResult invokeLL;
        n6 p;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, n6Var, c3Var)) == null) {
            if (n6Var instanceof q6) {
                p = ((q6) n6Var).p(c3Var);
            } else if (n6Var instanceof o6) {
                p = ((o6) n6Var).q(c3Var);
            } else if (n6Var instanceof p6) {
                p = ((p6) n6Var).p(c3Var);
            } else {
                throw new GdxRuntimeException("Unable to copy, unknown drawable type: " + n6Var.getClass());
            }
            if (p instanceof m6) {
                m6 m6Var = (m6) p;
                if (n6Var instanceof m6) {
                    m6Var.n(((m6) n6Var).m() + " (" + c3Var + SmallTailInfo.EMOTION_SUFFIX);
                } else {
                    m6Var.n(" (" + c3Var + SmallTailInfo.EMOTION_SUFFIX);
                }
            }
            return p;
        }
        return (n6) invokeLL.objValue;
    }

    public <T> T r(String str, Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, str, cls)) == null) {
            if (str != null) {
                if (cls != null) {
                    o7<String, Object> c2 = this.a.c(cls);
                    if (c2 == null) {
                        return null;
                    }
                    return (T) c2.c(str);
                }
                throw new IllegalArgumentException("type cannot be null.");
            }
            throw new IllegalArgumentException("name cannot be null.");
        }
        return (T) invokeLL.objValue;
    }
}
