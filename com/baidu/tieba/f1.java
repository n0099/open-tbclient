package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.graphics.Cubemap;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.d1;
import com.baidu.tieba.p7;
import com.baidu.tieba.t6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.LoadErrorCode;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
/* loaded from: classes5.dex */
public class f1 implements a7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final p7<Class, p7<String, a>> a;
    public final p7<String, Class> b;
    public final p7<String, t6<String>> c;
    public final q7<String> d;
    public final p7<Class, p7<String, g1>> e;
    public final t6<b1> f;
    public final h8 g;
    public final t6<e1> h;
    public c1 i;
    public int j;
    public int k;
    public int l;
    public k7 m;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Object a;
        public int b;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = 1;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f1() {
        this(new w1());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((k1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.a7
    public synchronized void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                this.m.a("Disposing.");
                g();
                this.g.dispose();
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.m.a("Waiting for loading to complete...");
            while (!update()) {
                k8.a();
            }
            this.m.a("Loading complete.");
        }
    }

    public k7 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.m;
        }
        return (k7) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f1(k1 k1Var) {
        this(k1Var, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {k1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((k1) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public f1(k1 k1Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {k1Var, Boolean.valueOf(z)};
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
        this.b = new p7<>();
        this.c = new p7<>();
        this.d = new q7<>();
        this.e = new p7<>();
        this.f = new t6<>();
        this.h = new t6<>();
        this.m = new k7("AssetManager", 0);
        if (z) {
            y(n3.class, new i1(k1Var));
            y(x1.class, new n1(k1Var));
            y(Pixmap.class, new p1(k1Var));
            y(y1.class, new s1(k1Var));
            y(u3.class, new u1(k1Var));
            y(Texture.class, new v1(k1Var));
            y(e6.class, new r1(k1Var));
            y(q3.class, new o1(k1Var));
            y(y4.class, new z4(k1Var));
            y(r3.class, new s3(k1Var));
            y(d7.class, new l1(k1Var));
            z(z3.class, ".g3dj", new e4(new i7(), k1Var));
            z(z3.class, ".g3db", new e4(new g8(), k1Var));
            z(z3.class, ".obj", new g4(k1Var));
            y(q5.class, new q1(k1Var));
            y(Cubemap.class, new j1(k1Var));
        }
        this.g = new h8(1, "AssetManager");
    }

    public synchronized void A(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
            synchronized (this) {
                Class c = this.b.c(str);
                if (c != null) {
                    this.a.c(c).c(str).b = i;
                } else {
                    throw new GdxRuntimeException("Asset not loaded: " + str);
                }
            }
        }
    }

    public synchronized void t(String str, t6<b1> t6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, str, t6Var) == null) {
            synchronized (this) {
                q7<String> q7Var = this.d;
                t6.b<b1> it = t6Var.iterator();
                while (it.hasNext()) {
                    b1 next = it.next();
                    if (!q7Var.contains(next.a)) {
                        q7Var.add(next.a);
                        u(str, next);
                    }
                }
                q7Var.b(32);
            }
        }
    }

    public void B(b1 b1Var, RuntimeException runtimeException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b1Var, runtimeException) == null) {
            throw runtimeException;
        }
    }

    public synchronized <T> T j(String str, Class<T> cls) {
        InterceptResult invokeLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, cls)) == null) {
            synchronized (this) {
                t = (T) k(str, cls, true);
            }
            return t;
        }
        return (T) invokeLL.objValue;
    }

    public synchronized <T, P extends d1<T>> void y(Class<T> cls, g1<T, P> g1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, cls, g1Var) == null) {
            synchronized (this) {
                z(cls, null, g1Var);
            }
        }
    }

    public synchronized void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            synchronized (this) {
                String replace = str.replace('\\', WebvttCueParser.CHAR_SLASH);
                if (this.h.b > 0) {
                    e1 first = this.h.first();
                    if (first.b.a.equals(replace)) {
                        this.m.e("Unload (from tasks): " + replace);
                        first.l = true;
                        first.e();
                        return;
                    }
                }
                Class c = this.b.c(replace);
                int i = 0;
                while (true) {
                    if (i < this.f.b) {
                        if (this.f.get(i).a.equals(replace)) {
                            break;
                        }
                        i++;
                    } else {
                        i = -1;
                        break;
                    }
                }
                if (i != -1) {
                    this.k--;
                    b1 h = this.f.h(i);
                    this.m.e("Unload (from queue): " + replace);
                    if (c != null && h.c != null && h.c.a != null) {
                        h.c.a.a(this, h.a, h.b);
                    }
                } else if (c != null) {
                    a c2 = this.a.c(c).c(replace);
                    int i2 = c2.b - 1;
                    c2.b = i2;
                    if (i2 <= 0) {
                        this.m.e("Unload (dispose): " + replace);
                        if (c2.a instanceof a7) {
                            ((a7) c2.a).dispose();
                        }
                        this.b.k(replace);
                        this.a.c(c).k(replace);
                    } else {
                        this.m.e("Unload (decrement): " + replace);
                    }
                    t6<String> c3 = this.c.c(replace);
                    if (c3 != null) {
                        t6.b<String> it = c3.iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            if (v(next)) {
                                C(next);
                            }
                        }
                    }
                    if (c2.b <= 0) {
                        this.c.k(replace);
                    }
                } else {
                    throw new GdxRuntimeException("Asset not loaded: " + replace);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007e A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean D() {
        InterceptResult invokeV;
        boolean z;
        d1.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            e1 peek = this.h.peek();
            try {
                if (!peek.l) {
                    if (!peek.update()) {
                        z = false;
                        if (z) {
                            return false;
                        }
                        if (this.h.b == 1) {
                            this.j++;
                            this.l = 0;
                        }
                        this.h.pop();
                        if (peek.l) {
                            return true;
                        }
                        b1 b1Var = peek.b;
                        a(b1Var.a, b1Var.b, peek.k);
                        b1 b1Var2 = peek.b;
                        d1 d1Var = b1Var2.c;
                        if (d1Var != null && (aVar = d1Var.a) != null) {
                            aVar.a(this, b1Var2.a, b1Var2.b);
                        }
                        long b = f8.b();
                        this.m.a("Loaded: " + (((float) (b - peek.e)) / 1000000.0f) + "ms " + peek.b);
                        return true;
                    }
                }
                z = true;
                if (z) {
                }
            } catch (RuntimeException e) {
                peek.l = true;
                B(peek.b, e);
                throw null;
            }
        } else {
            return invokeV.booleanValue;
        }
    }

    public final void x() {
        d1.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            b1 h = this.f.h(0);
            if (v(h.a)) {
                this.m.a("Already loaded: " + h);
                a c = this.a.c(this.b.c(h.a)).c(h.a);
                c.b = c.b + 1;
                s(h.a);
                d1 d1Var = h.c;
                if (d1Var != null && (aVar = d1Var.a) != null) {
                    aVar.a(this, h.a, h.b);
                }
                this.j++;
                return;
            }
            this.m.e("Loading: " + h);
            f(h);
        }
    }

    public <T> void a(String str, Class<T> cls, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, cls, t) == null) {
            this.b.i(str, cls);
            p7<String, a> c = this.a.c(cls);
            if (c == null) {
                c = new p7<>();
                this.a.i(cls, c);
            }
            a aVar = new a();
            aVar.a = t;
            c.i(str, aVar);
        }
    }

    public final void f(b1 b1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, b1Var) == null) {
            g1 o = o(b1Var.b, b1Var.a);
            if (o != null) {
                this.h.a(new e1(this, b1Var, o, this.g));
                this.l++;
                return;
            }
            throw new GdxRuntimeException("No loader for type: " + m8.e(b1Var.b));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002c A[Catch: all -> 0x0049, TryCatch #0 {, blocks: (B:5:0x0005, B:6:0x000e, B:8:0x0014, B:9:0x0026, B:11:0x002c, B:13:0x003a, B:15:0x0040), top: B:28:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized <T> String m(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, t)) == null) {
            synchronized (this) {
                p7.c<Class> f = this.a.f();
                f.c();
                while (f.hasNext()) {
                    p7.a<String, a> it = this.a.c(f.next()).iterator();
                    while (it.hasNext()) {
                        p7.b next = it.next();
                        Object obj = ((a) next.b).a;
                        if (obj == t || t.equals(obj)) {
                            return (String) next.a;
                        }
                        while (it.hasNext()) {
                        }
                    }
                }
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public synchronized int q(String str) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            synchronized (this) {
                Class c = this.b.c(str);
                if (c != null) {
                    i = this.a.c(c).c(str).b;
                } else {
                    throw new GdxRuntimeException("Asset not loaded: " + str);
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    public final void r(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, th) == null) {
            this.m.c("Error loading asset.", th);
            if (!this.h.isEmpty()) {
                e1 pop = this.h.pop();
                b1 b1Var = pop.b;
                if (pop.g && pop.h != null) {
                    t6.b<b1> it = pop.h.iterator();
                    while (it.hasNext()) {
                        C(it.next().a);
                    }
                }
                this.h.clear();
                c1 c1Var = this.i;
                if (c1Var != null) {
                    c1Var.a(b1Var, th);
                    return;
                }
                throw new GdxRuntimeException(th);
            }
            throw new GdxRuntimeException(th);
        }
    }

    public final void s(String str) {
        t6<String> c;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048595, this, str) != null) || (c = this.c.c(str)) == null) {
            return;
        }
        t6.b<String> it = c.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.a.c(this.b.c(next)).c(next).b++;
            s(next);
        }
    }

    public synchronized void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                this.f.clear();
                while (!update()) {
                }
                o7 o7Var = new o7();
                while (this.b.a > 0) {
                    o7Var.clear();
                    t6<String> d = this.b.f().d();
                    t6.b<String> it = d.iterator();
                    while (it.hasNext()) {
                        t6<String> c = this.c.c(it.next());
                        if (c != null) {
                            t6.b<String> it2 = c.iterator();
                            while (it2.hasNext()) {
                                o7Var.d(it2.next(), 0, 1);
                            }
                        }
                    }
                    t6.b<String> it3 = d.iterator();
                    while (it3.hasNext()) {
                        String next = it3.next();
                        if (o7Var.c(next, 0) == 0) {
                            C(next);
                        }
                    }
                }
                this.a.clear();
                this.b.clear();
                this.c.clear();
                this.j = 0;
                this.k = 0;
                this.l = 0;
                this.f.clear();
                this.h.clear();
            }
        }
    }

    public synchronized <T> T i(String str) {
        InterceptResult invokeL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            synchronized (this) {
                t = (T) l(str, true);
            }
            return t;
        }
        return (T) invokeL.objValue;
    }

    public synchronized t6<String> n(String str) {
        InterceptResult invokeL;
        t6<String> c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            synchronized (this) {
                c = this.c.c(str);
            }
            return c;
        }
        return (t6) invokeL.objValue;
    }

    public boolean update(int i) {
        InterceptResult invokeI;
        boolean update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i)) == null) {
            long a2 = f8.a() + i;
            while (true) {
                update = update();
                if (update || f8.a() > a2) {
                    break;
                }
                k8.a();
            }
            return update;
        }
        return invokeI.booleanValue;
    }

    public synchronized boolean v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            synchronized (this) {
                if (str == null) {
                    return false;
                }
                return this.b.a(str);
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized <T> T k(String str, Class<T> cls, boolean z) {
        InterceptResult invokeLLZ;
        a c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048587, this, str, cls, z)) == null) {
            synchronized (this) {
                p7<String, a> c2 = this.a.c(cls);
                if (c2 != null && (c = c2.c(str)) != null) {
                    return (T) c.a;
                }
                if (!z) {
                    return null;
                }
                throw new GdxRuntimeException("Asset not loaded: " + str);
            }
        }
        return (T) invokeLLZ.objValue;
    }

    public synchronized <T> T l(String str, boolean z) {
        InterceptResult invokeLZ;
        p7<String, a> c;
        a c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048588, this, str, z)) == null) {
            synchronized (this) {
                Class c3 = this.b.c(str);
                if (c3 != null && (c = this.a.c(c3)) != null && (c2 = c.c(str)) != null) {
                    return (T) c2.a;
                }
                if (!z) {
                    return null;
                }
                throw new GdxRuntimeException("Asset not loaded: " + str);
            }
        }
        return (T) invokeLZ.objValue;
    }

    public <T> g1 o(Class<T> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, cls, str)) == null) {
            p7<String, g1> c = this.e.c(cls);
            g1 g1Var = null;
            if (c != null && c.a >= 1) {
                if (str == null) {
                    return c.c("");
                }
                int i = -1;
                p7.a<String, g1> b = c.b();
                b.c();
                while (b.hasNext()) {
                    p7.b next = b.next();
                    if (((String) next.a).length() > i && str.endsWith((String) next.a)) {
                        g1Var = (g1) next.b;
                        i = ((String) next.a).length();
                    }
                }
            }
            return g1Var;
        }
        return (g1) invokeLL.objValue;
    }

    public final synchronized void u(String str, b1 b1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, str, b1Var) == null) {
            synchronized (this) {
                t6<String> c = this.c.c(str);
                if (c == null) {
                    c = new t6<>();
                    this.c.i(str, c);
                }
                c.a(b1Var.a);
                if (v(b1Var.a)) {
                    k7 k7Var = this.m;
                    k7Var.a("Dependency already loaded: " + b1Var);
                    a c2 = this.a.c(this.b.c(b1Var.a)).c(b1Var.a);
                    c2.b = c2.b + 1;
                    s(b1Var.a);
                } else {
                    k7 k7Var2 = this.m;
                    k7Var2.e("Loading dependency: " + b1Var);
                    f(b1Var);
                }
            }
        }
    }

    public synchronized boolean update() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            synchronized (this) {
                boolean z = false;
                try {
                    if (this.h.b == 0) {
                        while (this.f.b != 0 && this.h.b == 0) {
                            x();
                        }
                        if (this.h.b == 0) {
                            return true;
                        }
                    }
                    if (D() && this.f.b == 0) {
                        if (this.h.b == 0) {
                            z = true;
                        }
                    }
                    return z;
                } catch (Throwable th) {
                    r(th);
                    if (this.f.b != 0) {
                        return false;
                    }
                    return true;
                }
            }
        }
        return invokeV.booleanValue;
    }

    public synchronized <T> void w(String str, Class<T> cls, d1<T> d1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048601, this, str, cls, d1Var) == null) {
            synchronized (this) {
                if (o(cls, str) != null) {
                    if (this.f.b == 0) {
                        this.j = 0;
                        this.k = 0;
                        this.l = 0;
                    }
                    for (int i = 0; i < this.f.b; i++) {
                        b1 b1Var = this.f.get(i);
                        if (b1Var.a.equals(str) && !b1Var.b.equals(cls)) {
                            throw new GdxRuntimeException("Asset with name '" + str + "' already in preload queue, but has different type (expected: " + m8.e(cls) + ", found: " + m8.e(b1Var.b) + SmallTailInfo.EMOTION_SUFFIX);
                        }
                    }
                    for (int i2 = 0; i2 < this.h.b; i2++) {
                        b1 b1Var2 = this.h.get(i2).b;
                        if (b1Var2.a.equals(str) && !b1Var2.b.equals(cls)) {
                            throw new GdxRuntimeException("Asset with name '" + str + "' already in task list, but has different type (expected: " + m8.e(cls) + ", found: " + m8.e(b1Var2.b) + SmallTailInfo.EMOTION_SUFFIX);
                        }
                    }
                    Class c = this.b.c(str);
                    if (c != null && !c.equals(cls)) {
                        throw new GdxRuntimeException("Asset with name '" + str + "' already loaded, but has different type (expected: " + m8.e(cls) + ", found: " + m8.e(c) + SmallTailInfo.EMOTION_SUFFIX);
                    }
                    this.k++;
                    b1 b1Var3 = new b1(str, cls, d1Var);
                    this.f.a(b1Var3);
                    this.m.a("Queued: " + b1Var3);
                } else {
                    throw new GdxRuntimeException("No loader for type: " + m8.e(cls));
                }
            }
        }
    }

    public synchronized <T, P extends d1<T>> void z(Class<T> cls, String str, g1<T, P> g1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048604, this, cls, str, g1Var) == null) {
            synchronized (this) {
                if (cls != null) {
                    if (g1Var != null) {
                        k7 k7Var = this.m;
                        k7Var.a("Loader set: " + m8.e(cls) + LoadErrorCode.TOKEN_NEXT + m8.e(g1Var.getClass()));
                        p7<String, g1> c = this.e.c(cls);
                        if (c == null) {
                            p7<Class, p7<String, g1>> p7Var = this.e;
                            p7<String, g1> p7Var2 = new p7<>();
                            p7Var.i(cls, p7Var2);
                            c = p7Var2;
                        }
                        if (str == null) {
                            str = "";
                        }
                        c.i(str, g1Var);
                    } else {
                        throw new IllegalArgumentException("loader cannot be null.");
                    }
                } else {
                    throw new IllegalArgumentException("type cannot be null.");
                }
            }
        }
    }
}
