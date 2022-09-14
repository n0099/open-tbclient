package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.model.data.ModelMaterial;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.b7;
import com.baidu.tieba.c7;
import com.baidu.tieba.x7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class h4 implements i7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final b7<g4> a;
    public final b7<r4> b;
    public final b7<p4> c;
    public final b7<Mesh> d;
    public final b7<q4> e;
    public final b7<i7> f;
    public x7<u4, c7<String, Matrix4>> g;

    public h4() {
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
        this.a = new b7<>();
        this.b = new b7<>();
        this.c = new b7<>();
        this.d = new b7<>();
        this.e = new b7<>();
        this.f = new b7<>();
        this.g = new x7<>();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i = this.b.b;
            for (int i2 = 0; i2 < i; i2++) {
                this.b.get(i2).d(true);
            }
            for (int i3 = 0; i3 < i; i3++) {
                this.b.get(i3).b(true);
            }
        }
    }

    @Override // com.baidu.tieba.i7
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b7.b<i7> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().dispose();
            }
        }
    }

    public g4 f(ModelMaterial modelMaterial, p5 p5Var) {
        InterceptResult invokeLL;
        Texture load;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, modelMaterial, p5Var)) == null) {
            g4 g4Var = new g4();
            g4Var.d = modelMaterial.a;
            if (modelMaterial.b != null) {
                g4Var.h(new j4(j4.g, modelMaterial.b));
            }
            if (modelMaterial.c != null) {
                g4Var.h(new j4(j4.e, modelMaterial.c));
            }
            if (modelMaterial.d != null) {
                g4Var.h(new j4(j4.f, modelMaterial.d));
            }
            if (modelMaterial.e != null) {
                g4Var.h(new j4(j4.h, modelMaterial.e));
            }
            if (modelMaterial.f != null) {
                g4Var.h(new j4(j4.i, modelMaterial.f));
            }
            if (modelMaterial.g > 0.0f) {
                g4Var.h(new k4(k4.e, modelMaterial.g));
            }
            if (modelMaterial.h != 1.0f) {
                g4Var.h(new i4(770, 771, modelMaterial.h));
            }
            x7 x7Var = new x7();
            b7<d5> b7Var = modelMaterial.i;
            if (b7Var != null) {
                b7.b<d5> it = b7Var.iterator();
                while (it.hasNext()) {
                    d5 next = it.next();
                    if (x7Var.a(next.a)) {
                        load = (Texture) x7Var.c(next.a);
                    } else {
                        load = p5Var.load(next.a);
                        x7Var.i(next.a, load);
                        this.f.a(load);
                    }
                    o5 o5Var = new o5(load);
                    o5Var.b = load.h();
                    o5Var.c = load.f();
                    o5Var.d = load.j();
                    o5Var.e = load.k();
                    Vector2 vector2 = next.b;
                    float f = vector2 == null ? 0.0f : vector2.x;
                    Vector2 vector22 = next.b;
                    float f2 = vector22 == null ? 0.0f : vector22.y;
                    Vector2 vector23 = next.c;
                    float f3 = vector23 == null ? 1.0f : vector23.x;
                    Vector2 vector24 = next.c;
                    float f4 = vector24 == null ? 1.0f : vector24.y;
                    int i = next.d;
                    if (i == 2) {
                        g4Var.h(new l4(l4.j, o5Var, f, f2, f3, f4));
                    } else if (i == 3) {
                        g4Var.h(new l4(l4.o, o5Var, f, f2, f3, f4));
                    } else if (i == 4) {
                        g4Var.h(new l4(l4.n, o5Var, f, f2, f3, f4));
                    } else if (i == 5) {
                        g4Var.h(new l4(l4.k, o5Var, f, f2, f3, f4));
                    } else if (i == 7) {
                        g4Var.h(new l4(l4.m, o5Var, f, f2, f3, f4));
                    } else if (i == 8) {
                        g4Var.h(new l4(l4.l, o5Var, f, f2, f3, f4));
                    } else if (i == 10) {
                        g4Var.h(new l4(l4.p, o5Var, f, f2, f3, f4));
                    }
                }
            }
            return g4Var;
        }
        return (g4) invokeLL.objValue;
    }

    public void g(x4 x4Var) {
        y4[] y4VarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, x4Var) == null) {
            int i = 0;
            for (y4 y4Var : x4Var.c) {
                i += y4Var.b.length;
            }
            boolean z = i > 0;
            u3 u3Var = new u3(x4Var.a);
            int length = x4Var.b.length / (u3Var.b / 4);
            Mesh mesh = new Mesh(true, length, i, u3Var);
            this.d.a(mesh);
            this.f.a(mesh);
            BufferUtils.a(x4Var.b, mesh.m(), x4Var.b.length, 0);
            mesh.j().clear();
            int i2 = 0;
            for (y4 y4Var2 : x4Var.c) {
                q4 q4Var = new q4();
                q4Var.a = y4Var2.a;
                q4Var.b = y4Var2.c;
                q4Var.c = i2;
                q4Var.d = z ? y4Var2.b.length : length;
                q4Var.e = mesh;
                if (z) {
                    mesh.j().put(y4Var2.b);
                }
                i2 += q4Var.d;
                this.e.a(q4Var);
            }
            mesh.j().position(0);
            b7.b<q4> it = this.e.iterator();
            while (it.hasNext()) {
                it.next().update();
            }
        }
    }

    public Iterable<i7> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f : (Iterable) invokeV.objValue;
    }

    public r4 i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? j(str, true) : (r4) invokeL.objValue;
    }

    public r4 j(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048582, this, str, z)) == null) ? k(str, z, false) : (r4) invokeLZ.objValue;
    }

    public r4 k(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? r4.f(this.b, str, z, z2) : (r4) invokeCommon.objValue;
    }

    public void l(w4 w4Var, p5 p5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, w4Var, p5Var) == null) {
            o(w4Var.b);
            n(w4Var.c, p5Var);
            q(w4Var.d);
            m(w4Var.e);
            a();
        }
    }

    public void m(Iterable<v4> iterable) {
        b7<t4<Quaternion>> b7Var;
        b7<t4<Vector3>> b7Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, iterable) == null) {
            for (v4 v4Var : iterable) {
                p4 p4Var = new p4();
                String str = v4Var.a;
                b7.b<a5> it = v4Var.b.iterator();
                while (it.hasNext()) {
                    a5 next = it.next();
                    r4 i = i(next.a);
                    if (i != null) {
                        s4 s4Var = new s4();
                        if (next.b != null) {
                            b7<t4<Vector3>> b7Var3 = new b7<>();
                            s4Var.a = b7Var3;
                            b7Var3.e(next.b.b);
                            b7.b<b5<Vector3>> it2 = next.b.iterator();
                            while (it2.hasNext()) {
                                b5<Vector3> next2 = it2.next();
                                float f = next2.a;
                                if (f > p4Var.a) {
                                    p4Var.a = f;
                                }
                                b7<t4<Vector3>> b7Var4 = s4Var.a;
                                float f2 = next2.a;
                                Vector3 vector3 = next2.b;
                                b7Var4.a(new t4<>(f2, new Vector3(vector3 == null ? i.d : vector3)));
                            }
                        }
                        if (next.c != null) {
                            b7<t4<Quaternion>> b7Var5 = new b7<>();
                            s4Var.b = b7Var5;
                            b7Var5.e(next.c.b);
                            b7.b<b5<Quaternion>> it3 = next.c.iterator();
                            while (it3.hasNext()) {
                                b5<Quaternion> next3 = it3.next();
                                float f3 = next3.a;
                                if (f3 > p4Var.a) {
                                    p4Var.a = f3;
                                }
                                b7<t4<Quaternion>> b7Var6 = s4Var.b;
                                float f4 = next3.a;
                                Quaternion quaternion = next3.b;
                                b7Var6.a(new t4<>(f4, new Quaternion(quaternion == null ? i.e : quaternion)));
                            }
                        }
                        if (next.d != null) {
                            b7<t4<Vector3>> b7Var7 = new b7<>();
                            s4Var.c = b7Var7;
                            b7Var7.e(next.d.b);
                            b7.b<b5<Vector3>> it4 = next.d.iterator();
                            while (it4.hasNext()) {
                                b5<Vector3> next4 = it4.next();
                                float f5 = next4.a;
                                if (f5 > p4Var.a) {
                                    p4Var.a = f5;
                                }
                                b7<t4<Vector3>> b7Var8 = s4Var.c;
                                float f6 = next4.a;
                                Vector3 vector32 = next4.b;
                                b7Var8.a(new t4<>(f6, new Vector3(vector32 == null ? i.f : vector32)));
                            }
                        }
                        b7<t4<Vector3>> b7Var9 = s4Var.a;
                        if ((b7Var9 != null && b7Var9.b > 0) || (((b7Var = s4Var.b) != null && b7Var.b > 0) || ((b7Var2 = s4Var.c) != null && b7Var2.b > 0))) {
                            p4Var.b.a(s4Var);
                        }
                    }
                }
                if (p4Var.b.b > 0) {
                    this.c.a(p4Var);
                }
            }
        }
    }

    public void n(Iterable<ModelMaterial> iterable, p5 p5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, iterable, p5Var) == null) {
            for (ModelMaterial modelMaterial : iterable) {
                this.a.a(f(modelMaterial, p5Var));
            }
        }
    }

    public void o(Iterable<x4> iterable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, iterable) == null) {
            for (x4 x4Var : iterable) {
                g(x4Var);
            }
        }
    }

    public r4 p(z4 z4Var) {
        InterceptResult invokeL;
        q4 q4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, z4Var)) == null) {
            r4 r4Var = new r4();
            r4Var.a = z4Var.a;
            Vector3 vector3 = z4Var.b;
            if (vector3 != null) {
                r4Var.d.set(vector3);
            }
            Quaternion quaternion = z4Var.c;
            if (quaternion != null) {
                r4Var.e.set(quaternion);
            }
            Vector3 vector32 = z4Var.d;
            if (vector32 != null) {
                r4Var.f.set(vector32);
            }
            c5[] c5VarArr = z4Var.e;
            if (c5VarArr != null) {
                for (c5 c5Var : c5VarArr) {
                    g4 g4Var = null;
                    if (c5Var.b != null) {
                        b7.b<q4> it = this.e.iterator();
                        while (it.hasNext()) {
                            q4Var = it.next();
                            if (c5Var.b.equals(q4Var.a)) {
                                break;
                            }
                        }
                    }
                    q4Var = null;
                    if (c5Var.a != null) {
                        b7.b<g4> it2 = this.a.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            g4 next = it2.next();
                            if (c5Var.a.equals(next.d)) {
                                g4Var = next;
                                break;
                            }
                        }
                    }
                    if (q4Var != null && g4Var != null) {
                        u4 u4Var = new u4();
                        r4Var.i.a(u4Var);
                        c7<String, Matrix4> c7Var = c5Var.c;
                        if (c7Var != null) {
                            this.g.i(u4Var, c7Var);
                        }
                    } else {
                        throw new GdxRuntimeException("Invalid node: " + r4Var.a);
                    }
                }
            }
            z4[] z4VarArr = z4Var.f;
            if (z4VarArr != null) {
                for (z4 z4Var2 : z4VarArr) {
                    r4Var.a(p(z4Var2));
                }
            }
            return r4Var;
        }
        return (r4) invokeL.objValue;
    }

    public void q(Iterable<z4> iterable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, iterable) == null) {
            this.g.clear();
            for (z4 z4Var : iterable) {
                this.b.a(p(z4Var));
            }
            x7.a<u4, c7<String, Matrix4>> b = this.g.b();
            b.c();
            while (b.hasNext()) {
                x7.b next = b.next();
                K k = next.a;
                if (((u4) k).a == null) {
                    ((u4) k).a = new c7<>(r4.class, Matrix4.class);
                }
                ((u4) next.a).a.clear();
                c7.a a = ((c7) next.b).a();
                a.iterator();
                while (a.hasNext()) {
                    x7.b next2 = a.next();
                    ((u4) next.a).a.e(i((String) next2.a), new Matrix4((Matrix4) next2.b).inv());
                }
            }
        }
    }

    public h4(w4 w4Var, p5 p5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {w4Var, p5Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new b7<>();
        this.b = new b7<>();
        this.c = new b7<>();
        this.d = new b7<>();
        this.e = new b7<>();
        this.f = new b7<>();
        this.g = new x7<>();
        l(w4Var, p5Var);
    }
}
