package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.graphics.Cubemap;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.e1;
import com.baidu.tieba.q7;
import com.baidu.tieba.u6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.LoadErrorCode;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
/* loaded from: classes6.dex */
public class g1 implements b7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final q7<Class, q7<String, a>> a;
    public final q7<String, Class> b;
    public final q7<String, u6<String>> c;
    public final r7<String> d;
    public final q7<Class, q7<String, h1>> e;
    public final u6<c1> f;
    public final i8 g;
    public final u6<f1> h;
    public d1 i;
    public int j;
    public int k;
    public int l;
    public l7 m;

    /* loaded from: classes6.dex */
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
    public g1() {
        this(new x1());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((l1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.b7
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
                l8.a();
            }
            this.m.a("Loading complete.");
        }
    }

    public l7 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.m;
        }
        return (l7) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g1(l1 l1Var) {
        this(l1Var, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {l1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((l1) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public g1(l1 l1Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {l1Var, Boolean.valueOf(z)};
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
        this.b = new q7<>();
        this.c = new q7<>();
        this.d = new r7<>();
        this.e = new q7<>();
        this.f = new u6<>();
        this.h = new u6<>();
        this.m = new l7("AssetManager", 0);
        if (z) {
            y(o3.class, new j1(l1Var));
            y(y1.class, new o1(l1Var));
            y(Pixmap.class, new q1(l1Var));
            y(z1.class, new t1(l1Var));
            y(v3.class, new v1(l1Var));
            y(Texture.class, new w1(l1Var));
            y(f6.class, new s1(l1Var));
            y(r3.class, new p1(l1Var));
            y(z4.class, new a5(l1Var));
            y(s3.class, new t3(l1Var));
            y(e7.class, new m1(l1Var));
            z(a4.class, ".g3dj", new f4(new j7(), l1Var));
            z(a4.class, ".g3db", new f4(new h8(), l1Var));
            z(a4.class, ".obj", new h4(l1Var));
            y(r5.class, new r1(l1Var));
            y(Cubemap.class, new k1(l1Var));
        }
        this.g = new i8(1, "AssetManager");
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

    public synchronized void t(String str, u6<c1> u6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, str, u6Var) == null) {
            synchronized (this) {
                r7<String> r7Var = this.d;
                u6.b<c1> it = u6Var.iterator();
                while (it.hasNext()) {
                    c1 next = it.next();
                    if (!r7Var.contains(next.a)) {
                        r7Var.add(next.a);
                        u(str, next);
                    }
                }
                r7Var.b(32);
            }
        }
    }

    public void B(c1 c1Var, RuntimeException runtimeException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c1Var, runtimeException) == null) {
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

    public synchronized <T, P extends e1<T>> void y(Class<T> cls, h1<T, P> h1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, cls, h1Var) == null) {
            synchronized (this) {
                z(cls, null, h1Var);
            }
        }
    }

    public synchronized void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            synchronized (this) {
                String replace = str.replace('\\', WebvttCueParser.CHAR_SLASH);
                if (this.h.b > 0) {
                    f1 first = this.h.first();
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
                    c1 h = this.f.h(i);
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
                        if (c2.a instanceof b7) {
                            ((b7) c2.a).dispose();
                        }
                        this.b.k(replace);
                        this.a.c(c).k(replace);
                    } else {
                        this.m.e("Unload (decrement): " + replace);
                    }
                    u6<String> c3 = this.c.c(replace);
                    if (c3 != null) {
                        u6.b<String> it = c3.iterator();
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
        e1.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            f1 peek = this.h.peek();
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
                        c1 c1Var = peek.b;
                        a(c1Var.a, c1Var.b, peek.k);
                        c1 c1Var2 = peek.b;
                        e1 e1Var = c1Var2.c;
                        if (e1Var != null && (aVar = e1Var.a) != null) {
                            aVar.a(this, c1Var2.a, c1Var2.b);
                        }
                        long b = g8.b();
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
        e1.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            c1 h = this.f.h(0);
            if (v(h.a)) {
                this.m.a("Already loaded: " + h);
                a c = this.a.c(this.b.c(h.a)).c(h.a);
                c.b = c.b + 1;
                s(h.a);
                e1 e1Var = h.c;
                if (e1Var != null && (aVar = e1Var.a) != null) {
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
            q7<String, a> c = this.a.c(cls);
            if (c == null) {
                c = new q7<>();
                this.a.i(cls, c);
            }
            a aVar = new a();
            aVar.a = t;
            c.i(str, aVar);
        }
    }

    public final void f(c1 c1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, c1Var) == null) {
            h1 o = o(c1Var.b, c1Var.a);
            if (o != null) {
                this.h.a(new f1(this, c1Var, o, this.g));
                this.l++;
                return;
            }
            throw new GdxRuntimeException("No loader for type: " + n8.e(c1Var.b));
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
                q7.c<Class> f = this.a.f();
                f.c();
                while (f.hasNext()) {
                    q7.a<String, a> it = this.a.c(f.next()).iterator();
                    while (it.hasNext()) {
                        q7.b next = it.next();
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
                f1 pop = this.h.pop();
                c1 c1Var = pop.b;
                if (pop.g && pop.h != null) {
                    u6.b<c1> it = pop.h.iterator();
                    while (it.hasNext()) {
                        C(it.next().a);
                    }
                }
                this.h.clear();
                d1 d1Var = this.i;
                if (d1Var != null) {
                    d1Var.a(c1Var, th);
                    return;
                }
                throw new GdxRuntimeException(th);
            }
            throw new GdxRuntimeException(th);
        }
    }

    public final void s(String str) {
        u6<String> c;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048595, this, str) != null) || (c = this.c.c(str)) == null) {
            return;
        }
        u6.b<String> it = c.iterator();
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
                p7 p7Var = new p7();
                while (this.b.a > 0) {
                    p7Var.clear();
                    u6<String> d = this.b.f().d();
                    u6.b<String> it = d.iterator();
                    while (it.hasNext()) {
                        u6<String> c = this.c.c(it.next());
                        if (c != null) {
                            u6.b<String> it2 = c.iterator();
                            while (it2.hasNext()) {
                                p7Var.d(it2.next(), 0, 1);
                            }
                        }
                    }
                    u6.b<String> it3 = d.iterator();
                    while (it3.hasNext()) {
                        String next = it3.next();
                        if (p7Var.c(next, 0) == 0) {
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

    public synchronized u6<String> n(String str) {
        InterceptResult invokeL;
        u6<String> c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            synchronized (this) {
                c = this.c.c(str);
            }
            return c;
        }
        return (u6) invokeL.objValue;
    }

    public boolean update(int i) {
        InterceptResult invokeI;
        boolean update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i)) == null) {
            long a2 = g8.a() + i;
            while (true) {
                update = update();
                if (update || g8.a() > a2) {
                    break;
                }
                l8.a();
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
                q7<String, a> c2 = this.a.c(cls);
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
        q7<String, a> c;
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

    public <T> h1 o(Class<T> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, cls, str)) == null) {
            q7<String, h1> c = this.e.c(cls);
            h1 h1Var = null;
            if (c != null && c.a >= 1) {
                if (str == null) {
                    return c.c("");
                }
                int i = -1;
                q7.a<String, h1> b = c.b();
                b.c();
                while (b.hasNext()) {
                    q7.b next = b.next();
                    if (((String) next.a).length() > i && str.endsWith((String) next.a)) {
                        h1Var = (h1) next.b;
                        i = ((String) next.a).length();
                    }
                }
            }
            return h1Var;
        }
        return (h1) invokeLL.objValue;
    }

    public final synchronized void u(String str, c1 c1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, str, c1Var) == null) {
            synchronized (this) {
                u6<String> c = this.c.c(str);
                if (c == null) {
                    c = new u6<>();
                    this.c.i(str, c);
                }
                c.a(c1Var.a);
                if (v(c1Var.a)) {
                    l7 l7Var = this.m;
                    l7Var.a("Dependency already loaded: " + c1Var);
                    a c2 = this.a.c(this.b.c(c1Var.a)).c(c1Var.a);
                    c2.b = c2.b + 1;
                    s(c1Var.a);
                } else {
                    l7 l7Var2 = this.m;
                    l7Var2.e("Loading dependency: " + c1Var);
                    f(c1Var);
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

    public synchronized <T> void w(String str, Class<T> cls, e1<T> e1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048601, this, str, cls, e1Var) == null) {
            synchronized (this) {
                if (o(cls, str) != null) {
                    if (this.f.b == 0) {
                        this.j = 0;
                        this.k = 0;
                        this.l = 0;
                    }
                    for (int i = 0; i < this.f.b; i++) {
                        c1 c1Var = this.f.get(i);
                        if (c1Var.a.equals(str) && !c1Var.b.equals(cls)) {
                            throw new GdxRuntimeException("Asset with name '" + str + "' already in preload queue, but has different type (expected: " + n8.e(cls) + ", found: " + n8.e(c1Var.b) + SmallTailInfo.EMOTION_SUFFIX);
                        }
                    }
                    for (int i2 = 0; i2 < this.h.b; i2++) {
                        c1 c1Var2 = this.h.get(i2).b;
                        if (c1Var2.a.equals(str) && !c1Var2.b.equals(cls)) {
                            throw new GdxRuntimeException("Asset with name '" + str + "' already in task list, but has different type (expected: " + n8.e(cls) + ", found: " + n8.e(c1Var2.b) + SmallTailInfo.EMOTION_SUFFIX);
                        }
                    }
                    Class c = this.b.c(str);
                    if (c != null && !c.equals(cls)) {
                        throw new GdxRuntimeException("Asset with name '" + str + "' already loaded, but has different type (expected: " + n8.e(cls) + ", found: " + n8.e(c) + SmallTailInfo.EMOTION_SUFFIX);
                    }
                    this.k++;
                    c1 c1Var3 = new c1(str, cls, e1Var);
                    this.f.a(c1Var3);
                    this.m.a("Queued: " + c1Var3);
                } else {
                    throw new GdxRuntimeException("No loader for type: " + n8.e(cls));
                }
            }
        }
    }

    public synchronized <T, P extends e1<T>> void z(Class<T> cls, String str, h1<T, P> h1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048604, this, cls, str, h1Var) == null) {
            synchronized (this) {
                if (cls != null) {
                    if (h1Var != null) {
                        l7 l7Var = this.m;
                        l7Var.a("Loader set: " + n8.e(cls) + LoadErrorCode.TOKEN_NEXT + n8.e(h1Var.getClass()));
                        q7<String, h1> c = this.e.c(cls);
                        if (c == null) {
                            q7<Class, q7<String, h1>> q7Var = this.e;
                            q7<String, h1> q7Var2 = new q7<>();
                            q7Var.i(cls, q7Var2);
                            c = q7Var2;
                        }
                        if (str == null) {
                            str = "";
                        }
                        c.i(str, h1Var);
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
