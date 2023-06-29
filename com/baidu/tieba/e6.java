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
import com.baidu.tieba.h7;
import com.baidu.tieba.n3;
import com.baidu.tieba.p7;
import com.baidu.tieba.u3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class e6 implements a7 {
    public static /* synthetic */ Interceptable $ic;
    public static final Class[] e;
    public transient /* synthetic */ FieldHolder $fh;
    public p7<Class, p7<String, Object>> a;
    public u3 b;
    public float c;
    public final p7<String, Class> d;

    /* loaded from: classes5.dex */
    public class a extends h7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e6 n;

        public a(e6 e6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.n = e6Var;
        }

        @Override // com.baidu.tieba.h7
        public boolean g(Class cls, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cls, str)) == null) {
                return str.equals("parent");
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.h7
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

        @Override // com.baidu.tieba.h7
        public <T> T k(Class<T> cls, Class cls2, JsonValue jsonValue) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, cls, cls2, jsonValue)) == null) {
                if (jsonValue != null && jsonValue.D() && !m8.f(CharSequence.class, cls)) {
                    return (T) this.n.h(jsonValue.j(), cls);
                }
                return (T) super.k(cls, cls2, jsonValue);
            }
            return (T) invokeLLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends h7.b<e6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e6 a;
        public final /* synthetic */ e6 b;

        public b(e6 e6Var, e6 e6Var2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e6Var, e6Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = e6Var;
            this.a = e6Var2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.h7.d
        /* renamed from: b */
        public e6 a(h7 h7Var, JsonValue jsonValue, Class cls) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h7Var, jsonValue, cls)) == null) {
                for (JsonValue jsonValue2 = jsonValue.f; jsonValue2 != null; jsonValue2 = jsonValue2.h) {
                    try {
                        Class e = h7Var.e(jsonValue2.G());
                        if (e == null) {
                            e = m8.a(jsonValue2.G());
                        }
                        c(h7Var, e, jsonValue2);
                    } catch (ReflectionException e2) {
                        throw new SerializationException(e2);
                    }
                }
                return this.a;
            }
            return (e6) invokeLLL.objValue;
        }

        public final void c(h7 h7Var, Class cls, JsonValue jsonValue) {
            Class cls2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, h7Var, cls, jsonValue) == null) {
                if (cls == f.class) {
                    cls2 = o6.class;
                } else {
                    cls2 = cls;
                }
                for (JsonValue jsonValue2 = jsonValue.f; jsonValue2 != null; jsonValue2 = jsonValue2.h) {
                    Object j = h7Var.j(cls, jsonValue2);
                    if (j != null) {
                        try {
                            this.b.f(jsonValue2.e, j, cls2);
                            if (cls2 != o6.class && m8.f(o6.class, cls2)) {
                                this.b.f(jsonValue2.e, j, o6.class);
                            }
                        } catch (Exception e) {
                            throw new SerializationException("Error reading " + m8.e(cls) + ": " + jsonValue2.e, e);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends h7.b<n3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c3 a;
        public final /* synthetic */ e6 b;

        public c(e6 e6Var, c3 c3Var, e6 e6Var2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e6Var, c3Var, e6Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c3Var;
            this.b = e6Var2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.h7.d
        /* renamed from: b */
        public n3 a(h7 h7Var, JsonValue jsonValue, Class cls) {
            InterceptResult invokeLLL;
            n3 n3Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h7Var, jsonValue, cls)) == null) {
                String str = (String) h7Var.l("file", String.class, jsonValue);
                int intValue = ((Integer) h7Var.n("scaledSize", Integer.TYPE, -1, jsonValue)).intValue();
                Boolean bool = (Boolean) h7Var.n("flip", Boolean.class, Boolean.FALSE, jsonValue);
                Boolean bool2 = (Boolean) h7Var.n("markupEnabled", Boolean.class, Boolean.FALSE, jsonValue);
                c3 a = this.a.i().a(str);
                if (!a.c()) {
                    a = x0.d.a(str);
                }
                if (a.c()) {
                    String h = a.h();
                    try {
                        t6<v3> m = this.b.m(h);
                        if (m != null) {
                            n3Var = new n3(new n3.a(a, bool.booleanValue()), m, true);
                        } else {
                            v3 v3Var = (v3) this.b.r(h, v3.class);
                            if (v3Var != null) {
                                n3Var = new n3(a, v3Var, bool.booleanValue());
                            } else {
                                c3 i = a.i();
                                c3 a2 = i.a(h + ".png");
                                if (a2.c()) {
                                    n3Var = new n3(a, a2, bool.booleanValue());
                                } else {
                                    n3Var = new n3(a, bool.booleanValue());
                                }
                            }
                        }
                        n3Var.f().p = bool2.booleanValue();
                        if (intValue != -1) {
                            n3Var.f().h(intValue / n3Var.a());
                        }
                        return n3Var;
                    } catch (RuntimeException e) {
                        throw new SerializationException("Error loading bitmap font: " + a, e);
                    }
                }
                throw new SerializationException("Font file not found: " + a);
            }
            return (n3) invokeLLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d extends h7.b<d3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e6 a;

        public d(e6 e6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.h7.d
        /* renamed from: b */
        public d3 a(h7 h7Var, JsonValue jsonValue, Class cls) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h7Var, jsonValue, cls)) == null) {
                if (jsonValue.D()) {
                    return (d3) this.a.h(jsonValue.j(), d3.class);
                }
                String str = (String) h7Var.n("hex", String.class, null, jsonValue);
                if (str != null) {
                    return d3.h(str);
                }
                return new d3(((Float) h7Var.n("r", Float.TYPE, Float.valueOf(0.0f), jsonValue)).floatValue(), ((Float) h7Var.n("g", Float.TYPE, Float.valueOf(0.0f), jsonValue)).floatValue(), ((Float) h7Var.n("b", Float.TYPE, Float.valueOf(0.0f), jsonValue)).floatValue(), ((Float) h7Var.n("a", Float.TYPE, Float.valueOf(1.0f), jsonValue)).floatValue());
            }
            return (d3) invokeLLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class e extends h7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e6 a;

        public e(e6 e6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e6Var;
        }

        @Override // com.baidu.tieba.h7.d
        public Object a(h7 h7Var, JsonValue jsonValue, Class cls) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, h7Var, jsonValue, cls)) == null) {
                String str = (String) h7Var.l("name", String.class, jsonValue);
                d3 d3Var = (d3) h7Var.l("color", d3.class, jsonValue);
                if (d3Var != null) {
                    o6 q = this.a.q(str, d3Var);
                    if (q instanceof n6) {
                        ((n6) q).n(jsonValue.e + " (" + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + d3Var + SmallTailInfo.EMOTION_SUFFIX);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448301916, "Lcom/baidu/tieba/e6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448301916, "Lcom/baidu/tieba/e6;");
                return;
            }
        }
        e = new Class[]{n3.class, d3.class, f.class, p6.class, q6.class, r6.class, s6.class, v5.class, w5.class, x5.class, y5.class, z5.class, a6.class, b6.class, c6.class, d6.class, f6.class, g6.class, h6.class, i6.class, j6.class, k6.class, l6.class, m6.class};
    }

    public e6() {
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
        this.a = new p7<>();
        this.c = 1.0f;
        this.d = new p7<>(e.length);
        for (Class cls : e) {
            this.d.i(cls.getSimpleName(), cls);
        }
    }

    @Override // com.baidu.tieba.a7
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            u3 u3Var = this.b;
            if (u3Var != null) {
                u3Var.dispose();
            }
            p7.e<p7<String, Object>> n = this.a.n();
            n.c();
            while (n.hasNext()) {
                p7.e<Object> n2 = n.next().n();
                n2.c();
                while (n2.hasNext()) {
                    Object next = n2.next();
                    if (next instanceof a7) {
                        ((a7) next).dispose();
                    }
                }
            }
        }
    }

    public e6(u3 u3Var) {
        Class[] clsArr;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {u3Var};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = new p7<>();
        this.c = 1.0f;
        this.d = new p7<>(e.length);
        for (Class cls : e) {
            this.d.i(cls.getSimpleName(), cls);
        }
        this.b = u3Var;
        g(u3Var);
    }

    public v3 l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            v3 v3Var = (v3) r(str, v3.class);
            if (v3Var != null) {
                return v3Var;
            }
            Texture texture = (Texture) r(str, Texture.class);
            if (texture != null) {
                v3 v3Var2 = new v3(texture);
                f(str, v3Var2, v3.class);
                return v3Var2;
            }
            throw new GdxRuntimeException("No TextureRegion or Texture registered with name: " + str);
        }
        return (v3) invokeL.objValue;
    }

    public t6<v3> m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            v3 v3Var = (v3) r(str + "_0", v3.class);
            if (v3Var != null) {
                t6<v3> t6Var = new t6<>();
                int i = 1;
                while (v3Var != null) {
                    t6Var.a(v3Var);
                    v3Var = (v3) r(str + "_" + i, v3.class);
                    i++;
                }
                return t6Var;
            }
            return null;
        }
        return (t6) invokeL.objValue;
    }

    public void s(o6 o6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, o6Var) == null) {
            o6Var.b(o6Var.l() * this.c);
            o6Var.c(o6Var.g() * this.c);
            o6Var.d(o6Var.e() * this.c);
            o6Var.f(o6Var.i() * this.c);
            o6Var.j(o6Var.a() * this.c);
            o6Var.h(o6Var.k() * this.c);
        }
    }

    public void a(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, obj) == null) {
            f(str, obj, obj.getClass());
        }
    }

    public o6 q(String str, d3 d3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, d3Var)) == null) {
            return p(i(str), d3Var);
        }
        return (o6) invokeLL.objValue;
    }

    public void f(String str, Object obj, Class cls) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, obj, cls) == null) {
            if (str != null) {
                if (obj != null) {
                    p7<String, Object> c2 = this.a.c(cls);
                    if (c2 == null) {
                        if (cls != v3.class && cls != o6.class && cls != t3.class) {
                            i = 64;
                        } else {
                            i = 256;
                        }
                        c2 = new p7<>(i);
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

    public void g(u3 u3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, u3Var) == null) {
            t6<u3.a> g = u3Var.g();
            int i = g.b;
            for (int i2 = 0; i2 < i; i2++) {
                u3.a aVar = g.get(i2);
                String str = aVar.i;
                if (aVar.h != -1) {
                    str = str + "_" + aVar.h;
                }
                f(str, aVar, v3.class);
            }
        }
    }

    public <T> T h(String str, Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, cls)) == null) {
            if (str != null) {
                if (cls != null) {
                    if (cls == o6.class) {
                        return (T) i(str);
                    }
                    if (cls == v3.class) {
                        return (T) l(str);
                    }
                    if (cls == p3.class) {
                        return (T) k(str);
                    }
                    if (cls == t3.class) {
                        return (T) n(str);
                    }
                    p7<String, Object> c2 = this.a.c(cls);
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

    public o6 i(String str) {
        InterceptResult invokeL;
        o6 q6Var;
        o6 q6Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            o6 o6Var = (o6) r(str, o6.class);
            if (o6Var != null) {
                return o6Var;
            }
            try {
                v3 l = l(str);
                if (l instanceof u3.a) {
                    u3.a aVar = (u3.a) l;
                    if (aVar.k("split") != null) {
                        q6Var2 = new p6(k(str));
                    } else if (aVar.p || aVar.l != aVar.n || aVar.m != aVar.o) {
                        q6Var2 = new q6(n(str));
                    }
                    o6Var = q6Var2;
                }
                if (o6Var == null) {
                    o6 r6Var = new r6(l);
                    try {
                        if (this.c != 1.0f) {
                            s(r6Var);
                        }
                    } catch (GdxRuntimeException unused) {
                    }
                    o6Var = r6Var;
                }
            } catch (GdxRuntimeException unused2) {
            }
            if (o6Var == null) {
                p3 p3Var = (p3) r(str, p3.class);
                if (p3Var != null) {
                    q6Var = new p6(p3Var);
                } else {
                    t3 t3Var = (t3) r(str, t3.class);
                    if (t3Var != null) {
                        q6Var = new q6(t3Var);
                    } else {
                        throw new GdxRuntimeException("No Drawable, NinePatch, TextureRegion, Texture, or Sprite registered with name: " + str);
                    }
                }
                o6Var = q6Var;
            }
            if (o6Var instanceof n6) {
                ((n6) o6Var).n(str);
            }
            f(str, o6Var, o6.class);
            return o6Var;
        }
        return (o6) invokeL.objValue;
    }

    public h7 j(c3 c3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, c3Var)) == null) {
            a aVar = new a(this);
            aVar.p(null);
            aVar.q(false);
            aVar.o(e6.class, new b(this, this));
            aVar.o(n3.class, new c(this, c3Var, this));
            aVar.o(d3.class, new d(this));
            aVar.o(f.class, new e(this));
            p7.a<String, Class> it = this.d.iterator();
            while (it.hasNext()) {
                p7.b next = it.next();
                aVar.a((String) next.a, (Class) next.b);
            }
            return aVar;
        }
        return (h7) invokeL.objValue;
    }

    public p3 k(String str) {
        InterceptResult invokeL;
        int[] k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            p3 p3Var = (p3) r(str, p3.class);
            if (p3Var != null) {
                return p3Var;
            }
            try {
                v3 l = l(str);
                if ((l instanceof u3.a) && (k = ((u3.a) l).k("split")) != null) {
                    p3Var = new p3(l, k[0], k[1], k[2], k[3]);
                    int[] k2 = ((u3.a) l).k("pad");
                    if (k2 != null) {
                        p3Var.n(k2[0], k2[1], k2[2], k2[3]);
                    }
                }
                if (p3Var == null) {
                    p3Var = new p3(l);
                }
                if (this.c != 1.0f) {
                    p3Var.m(this.c, this.c);
                }
                f(str, p3Var, p3.class);
                return p3Var;
            } catch (GdxRuntimeException unused) {
                throw new GdxRuntimeException("No NinePatch, TextureRegion, or Texture registered with name: " + str);
            }
        }
        return (p3) invokeL.objValue;
    }

    public t3 n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            t3 t3Var = (t3) r(str, t3.class);
            if (t3Var != null) {
                return t3Var;
            }
            try {
                v3 l = l(str);
                if (l instanceof u3.a) {
                    u3.a aVar = (u3.a) l;
                    if (aVar.p || aVar.l != aVar.n || aVar.m != aVar.o) {
                        t3Var = new u3.b(aVar);
                    }
                }
                if (t3Var == null) {
                    t3Var = new t3(l);
                }
                if (this.c != 1.0f) {
                    t3Var.z(t3Var.n() * this.c, t3Var.k() * this.c);
                }
                f(str, t3Var, t3.class);
                return t3Var;
            } catch (GdxRuntimeException unused) {
                throw new GdxRuntimeException("No NinePatch, TextureRegion, or Texture registered with name: " + str);
            }
        }
        return (t3) invokeL.objValue;
    }

    public void o(c3 c3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, c3Var) == null) {
            try {
                j(c3Var).d(e6.class, c3Var);
            } catch (SerializationException e2) {
                throw new SerializationException("Error reading file: " + c3Var, e2);
            }
        }
    }

    public o6 p(o6 o6Var, d3 d3Var) {
        InterceptResult invokeLL;
        o6 p;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, o6Var, d3Var)) == null) {
            if (o6Var instanceof r6) {
                p = ((r6) o6Var).p(d3Var);
            } else if (o6Var instanceof p6) {
                p = ((p6) o6Var).q(d3Var);
            } else if (o6Var instanceof q6) {
                p = ((q6) o6Var).p(d3Var);
            } else {
                throw new GdxRuntimeException("Unable to copy, unknown drawable type: " + o6Var.getClass());
            }
            if (p instanceof n6) {
                n6 n6Var = (n6) p;
                if (o6Var instanceof n6) {
                    n6Var.n(((n6) o6Var).m() + " (" + d3Var + SmallTailInfo.EMOTION_SUFFIX);
                } else {
                    n6Var.n(" (" + d3Var + SmallTailInfo.EMOTION_SUFFIX);
                }
            }
            return p;
        }
        return (o6) invokeLL.objValue;
    }

    public <T> T r(String str, Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, str, cls)) == null) {
            if (str != null) {
                if (cls != null) {
                    p7<String, Object> c2 = this.a.c(cls);
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
