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
import com.baidu.tieba.i7;
import com.baidu.tieba.o3;
import com.baidu.tieba.q7;
import com.baidu.tieba.v3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class f6 implements b7 {
    public static /* synthetic */ Interceptable $ic;
    public static final Class[] e;
    public transient /* synthetic */ FieldHolder $fh;
    public q7<Class, q7<String, Object>> a;
    public v3 b;
    public float c;
    public final q7<String, Class> d;

    /* loaded from: classes5.dex */
    public class a extends i7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f6 n;

        public a(f6 f6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.n = f6Var;
        }

        @Override // com.baidu.tieba.i7
        public boolean g(Class cls, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cls, str)) == null) {
                return str.equals("parent");
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.i7
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

        @Override // com.baidu.tieba.i7
        public <T> T k(Class<T> cls, Class cls2, JsonValue jsonValue) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, cls, cls2, jsonValue)) == null) {
                if (jsonValue != null && jsonValue.D() && !n8.f(CharSequence.class, cls)) {
                    return (T) this.n.h(jsonValue.j(), cls);
                }
                return (T) super.k(cls, cls2, jsonValue);
            }
            return (T) invokeLLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends i7.b<f6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f6 a;
        public final /* synthetic */ f6 b;

        public b(f6 f6Var, f6 f6Var2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f6Var, f6Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = f6Var;
            this.a = f6Var2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i7.d
        /* renamed from: b */
        public f6 a(i7 i7Var, JsonValue jsonValue, Class cls) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i7Var, jsonValue, cls)) == null) {
                for (JsonValue jsonValue2 = jsonValue.f; jsonValue2 != null; jsonValue2 = jsonValue2.h) {
                    try {
                        Class e = i7Var.e(jsonValue2.G());
                        if (e == null) {
                            e = n8.a(jsonValue2.G());
                        }
                        c(i7Var, e, jsonValue2);
                    } catch (ReflectionException e2) {
                        throw new SerializationException(e2);
                    }
                }
                return this.a;
            }
            return (f6) invokeLLL.objValue;
        }

        public final void c(i7 i7Var, Class cls, JsonValue jsonValue) {
            Class cls2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, i7Var, cls, jsonValue) == null) {
                if (cls == f.class) {
                    cls2 = p6.class;
                } else {
                    cls2 = cls;
                }
                for (JsonValue jsonValue2 = jsonValue.f; jsonValue2 != null; jsonValue2 = jsonValue2.h) {
                    Object j = i7Var.j(cls, jsonValue2);
                    if (j != null) {
                        try {
                            this.b.f(jsonValue2.e, j, cls2);
                            if (cls2 != p6.class && n8.f(p6.class, cls2)) {
                                this.b.f(jsonValue2.e, j, p6.class);
                            }
                        } catch (Exception e) {
                            throw new SerializationException("Error reading " + n8.e(cls) + ": " + jsonValue2.e, e);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends i7.b<o3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d3 a;
        public final /* synthetic */ f6 b;

        public c(f6 f6Var, d3 d3Var, f6 f6Var2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f6Var, d3Var, f6Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d3Var;
            this.b = f6Var2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i7.d
        /* renamed from: b */
        public o3 a(i7 i7Var, JsonValue jsonValue, Class cls) {
            InterceptResult invokeLLL;
            o3 o3Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i7Var, jsonValue, cls)) == null) {
                String str = (String) i7Var.l("file", String.class, jsonValue);
                int intValue = ((Integer) i7Var.n("scaledSize", Integer.TYPE, -1, jsonValue)).intValue();
                Boolean bool = (Boolean) i7Var.n("flip", Boolean.class, Boolean.FALSE, jsonValue);
                Boolean bool2 = (Boolean) i7Var.n("markupEnabled", Boolean.class, Boolean.FALSE, jsonValue);
                d3 a = this.a.i().a(str);
                if (!a.c()) {
                    a = y0.d.a(str);
                }
                if (a.c()) {
                    String h = a.h();
                    try {
                        u6<w3> m = this.b.m(h);
                        if (m != null) {
                            o3Var = new o3(new o3.a(a, bool.booleanValue()), m, true);
                        } else {
                            w3 w3Var = (w3) this.b.r(h, w3.class);
                            if (w3Var != null) {
                                o3Var = new o3(a, w3Var, bool.booleanValue());
                            } else {
                                d3 i = a.i();
                                d3 a2 = i.a(h + ".png");
                                if (a2.c()) {
                                    o3Var = new o3(a, a2, bool.booleanValue());
                                } else {
                                    o3Var = new o3(a, bool.booleanValue());
                                }
                            }
                        }
                        o3Var.f().p = bool2.booleanValue();
                        if (intValue != -1) {
                            o3Var.f().h(intValue / o3Var.a());
                        }
                        return o3Var;
                    } catch (RuntimeException e) {
                        throw new SerializationException("Error loading bitmap font: " + a, e);
                    }
                }
                throw new SerializationException("Font file not found: " + a);
            }
            return (o3) invokeLLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d extends i7.b<e3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f6 a;

        public d(f6 f6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i7.d
        /* renamed from: b */
        public e3 a(i7 i7Var, JsonValue jsonValue, Class cls) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i7Var, jsonValue, cls)) == null) {
                if (jsonValue.D()) {
                    return (e3) this.a.h(jsonValue.j(), e3.class);
                }
                String str = (String) i7Var.n("hex", String.class, null, jsonValue);
                if (str != null) {
                    return e3.h(str);
                }
                return new e3(((Float) i7Var.n("r", Float.TYPE, Float.valueOf(0.0f), jsonValue)).floatValue(), ((Float) i7Var.n("g", Float.TYPE, Float.valueOf(0.0f), jsonValue)).floatValue(), ((Float) i7Var.n("b", Float.TYPE, Float.valueOf(0.0f), jsonValue)).floatValue(), ((Float) i7Var.n("a", Float.TYPE, Float.valueOf(1.0f), jsonValue)).floatValue());
            }
            return (e3) invokeLLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class e extends i7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f6 a;

        public e(f6 f6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f6Var;
        }

        @Override // com.baidu.tieba.i7.d
        public Object a(i7 i7Var, JsonValue jsonValue, Class cls) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, i7Var, jsonValue, cls)) == null) {
                String str = (String) i7Var.l("name", String.class, jsonValue);
                e3 e3Var = (e3) i7Var.l("color", e3.class, jsonValue);
                if (e3Var != null) {
                    p6 q = this.a.q(str, e3Var);
                    if (q instanceof o6) {
                        ((o6) q).n(jsonValue.e + " (" + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + e3Var + SmallTailInfo.EMOTION_SUFFIX);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448302877, "Lcom/baidu/tieba/f6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448302877, "Lcom/baidu/tieba/f6;");
                return;
            }
        }
        e = new Class[]{o3.class, e3.class, f.class, q6.class, r6.class, s6.class, t6.class, w5.class, x5.class, y5.class, z5.class, a6.class, b6.class, c6.class, d6.class, e6.class, g6.class, h6.class, i6.class, j6.class, k6.class, l6.class, m6.class, n6.class};
    }

    public f6() {
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
        this.a = new q7<>();
        this.c = 1.0f;
        this.d = new q7<>(e.length);
        for (Class cls : e) {
            this.d.i(cls.getSimpleName(), cls);
        }
    }

    @Override // com.baidu.tieba.b7
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            v3 v3Var = this.b;
            if (v3Var != null) {
                v3Var.dispose();
            }
            q7.e<q7<String, Object>> n = this.a.n();
            n.c();
            while (n.hasNext()) {
                q7.e<Object> n2 = n.next().n();
                n2.c();
                while (n2.hasNext()) {
                    Object next = n2.next();
                    if (next instanceof b7) {
                        ((b7) next).dispose();
                    }
                }
            }
        }
    }

    public f6(v3 v3Var) {
        Class[] clsArr;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v3Var};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = new q7<>();
        this.c = 1.0f;
        this.d = new q7<>(e.length);
        for (Class cls : e) {
            this.d.i(cls.getSimpleName(), cls);
        }
        this.b = v3Var;
        g(v3Var);
    }

    public w3 l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            w3 w3Var = (w3) r(str, w3.class);
            if (w3Var != null) {
                return w3Var;
            }
            Texture texture = (Texture) r(str, Texture.class);
            if (texture != null) {
                w3 w3Var2 = new w3(texture);
                f(str, w3Var2, w3.class);
                return w3Var2;
            }
            throw new GdxRuntimeException("No TextureRegion or Texture registered with name: " + str);
        }
        return (w3) invokeL.objValue;
    }

    public u6<w3> m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            w3 w3Var = (w3) r(str + "_0", w3.class);
            if (w3Var != null) {
                u6<w3> u6Var = new u6<>();
                int i = 1;
                while (w3Var != null) {
                    u6Var.a(w3Var);
                    w3Var = (w3) r(str + "_" + i, w3.class);
                    i++;
                }
                return u6Var;
            }
            return null;
        }
        return (u6) invokeL.objValue;
    }

    public void s(p6 p6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, p6Var) == null) {
            p6Var.b(p6Var.l() * this.c);
            p6Var.c(p6Var.g() * this.c);
            p6Var.d(p6Var.e() * this.c);
            p6Var.f(p6Var.i() * this.c);
            p6Var.j(p6Var.a() * this.c);
            p6Var.h(p6Var.k() * this.c);
        }
    }

    public void a(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, obj) == null) {
            f(str, obj, obj.getClass());
        }
    }

    public p6 q(String str, e3 e3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, e3Var)) == null) {
            return p(i(str), e3Var);
        }
        return (p6) invokeLL.objValue;
    }

    public void f(String str, Object obj, Class cls) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, obj, cls) == null) {
            if (str != null) {
                if (obj != null) {
                    q7<String, Object> c2 = this.a.c(cls);
                    if (c2 == null) {
                        if (cls != w3.class && cls != p6.class && cls != u3.class) {
                            i = 64;
                        } else {
                            i = 256;
                        }
                        c2 = new q7<>(i);
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

    public void g(v3 v3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, v3Var) == null) {
            u6<v3.a> g = v3Var.g();
            int i = g.b;
            for (int i2 = 0; i2 < i; i2++) {
                v3.a aVar = g.get(i2);
                String str = aVar.i;
                if (aVar.h != -1) {
                    str = str + "_" + aVar.h;
                }
                f(str, aVar, w3.class);
            }
        }
    }

    public <T> T h(String str, Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, cls)) == null) {
            if (str != null) {
                if (cls != null) {
                    if (cls == p6.class) {
                        return (T) i(str);
                    }
                    if (cls == w3.class) {
                        return (T) l(str);
                    }
                    if (cls == q3.class) {
                        return (T) k(str);
                    }
                    if (cls == u3.class) {
                        return (T) n(str);
                    }
                    q7<String, Object> c2 = this.a.c(cls);
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

    public p6 i(String str) {
        InterceptResult invokeL;
        p6 r6Var;
        p6 r6Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            p6 p6Var = (p6) r(str, p6.class);
            if (p6Var != null) {
                return p6Var;
            }
            try {
                w3 l = l(str);
                if (l instanceof v3.a) {
                    v3.a aVar = (v3.a) l;
                    if (aVar.k("split") != null) {
                        r6Var2 = new q6(k(str));
                    } else if (aVar.p || aVar.l != aVar.n || aVar.m != aVar.o) {
                        r6Var2 = new r6(n(str));
                    }
                    p6Var = r6Var2;
                }
                if (p6Var == null) {
                    p6 s6Var = new s6(l);
                    try {
                        if (this.c != 1.0f) {
                            s(s6Var);
                        }
                    } catch (GdxRuntimeException unused) {
                    }
                    p6Var = s6Var;
                }
            } catch (GdxRuntimeException unused2) {
            }
            if (p6Var == null) {
                q3 q3Var = (q3) r(str, q3.class);
                if (q3Var != null) {
                    r6Var = new q6(q3Var);
                } else {
                    u3 u3Var = (u3) r(str, u3.class);
                    if (u3Var != null) {
                        r6Var = new r6(u3Var);
                    } else {
                        throw new GdxRuntimeException("No Drawable, NinePatch, TextureRegion, Texture, or Sprite registered with name: " + str);
                    }
                }
                p6Var = r6Var;
            }
            if (p6Var instanceof o6) {
                ((o6) p6Var).n(str);
            }
            f(str, p6Var, p6.class);
            return p6Var;
        }
        return (p6) invokeL.objValue;
    }

    public i7 j(d3 d3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, d3Var)) == null) {
            a aVar = new a(this);
            aVar.p(null);
            aVar.q(false);
            aVar.o(f6.class, new b(this, this));
            aVar.o(o3.class, new c(this, d3Var, this));
            aVar.o(e3.class, new d(this));
            aVar.o(f.class, new e(this));
            q7.a<String, Class> it = this.d.iterator();
            while (it.hasNext()) {
                q7.b next = it.next();
                aVar.a((String) next.a, (Class) next.b);
            }
            return aVar;
        }
        return (i7) invokeL.objValue;
    }

    public q3 k(String str) {
        InterceptResult invokeL;
        int[] k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q3 q3Var = (q3) r(str, q3.class);
            if (q3Var != null) {
                return q3Var;
            }
            try {
                w3 l = l(str);
                if ((l instanceof v3.a) && (k = ((v3.a) l).k("split")) != null) {
                    q3Var = new q3(l, k[0], k[1], k[2], k[3]);
                    int[] k2 = ((v3.a) l).k("pad");
                    if (k2 != null) {
                        q3Var.n(k2[0], k2[1], k2[2], k2[3]);
                    }
                }
                if (q3Var == null) {
                    q3Var = new q3(l);
                }
                if (this.c != 1.0f) {
                    q3Var.m(this.c, this.c);
                }
                f(str, q3Var, q3.class);
                return q3Var;
            } catch (GdxRuntimeException unused) {
                throw new GdxRuntimeException("No NinePatch, TextureRegion, or Texture registered with name: " + str);
            }
        }
        return (q3) invokeL.objValue;
    }

    public u3 n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            u3 u3Var = (u3) r(str, u3.class);
            if (u3Var != null) {
                return u3Var;
            }
            try {
                w3 l = l(str);
                if (l instanceof v3.a) {
                    v3.a aVar = (v3.a) l;
                    if (aVar.p || aVar.l != aVar.n || aVar.m != aVar.o) {
                        u3Var = new v3.b(aVar);
                    }
                }
                if (u3Var == null) {
                    u3Var = new u3(l);
                }
                if (this.c != 1.0f) {
                    u3Var.z(u3Var.n() * this.c, u3Var.k() * this.c);
                }
                f(str, u3Var, u3.class);
                return u3Var;
            } catch (GdxRuntimeException unused) {
                throw new GdxRuntimeException("No NinePatch, TextureRegion, or Texture registered with name: " + str);
            }
        }
        return (u3) invokeL.objValue;
    }

    public void o(d3 d3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, d3Var) == null) {
            try {
                j(d3Var).d(f6.class, d3Var);
            } catch (SerializationException e2) {
                throw new SerializationException("Error reading file: " + d3Var, e2);
            }
        }
    }

    public p6 p(p6 p6Var, e3 e3Var) {
        InterceptResult invokeLL;
        p6 p;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, p6Var, e3Var)) == null) {
            if (p6Var instanceof s6) {
                p = ((s6) p6Var).p(e3Var);
            } else if (p6Var instanceof q6) {
                p = ((q6) p6Var).q(e3Var);
            } else if (p6Var instanceof r6) {
                p = ((r6) p6Var).p(e3Var);
            } else {
                throw new GdxRuntimeException("Unable to copy, unknown drawable type: " + p6Var.getClass());
            }
            if (p instanceof o6) {
                o6 o6Var = (o6) p;
                if (p6Var instanceof o6) {
                    o6Var.n(((o6) p6Var).m() + " (" + e3Var + SmallTailInfo.EMOTION_SUFFIX);
                } else {
                    o6Var.n(" (" + e3Var + SmallTailInfo.EMOTION_SUFFIX);
                }
            }
            return p;
        }
        return (p6) invokeLL.objValue;
    }

    public <T> T r(String str, Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, str, cls)) == null) {
            if (str != null) {
                if (cls != null) {
                    q7<String, Object> c2 = this.a.c(cls);
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
