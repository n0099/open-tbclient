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
import com.baidu.tieba.c7;
import com.baidu.tieba.d7;
import com.baidu.tieba.y7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class i4 implements j7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c7<h4> a;
    public final c7<s4> b;
    public final c7<q4> c;
    public final c7<Mesh> d;
    public final c7<r4> e;
    public final c7<j7> f;
    public y7<v4, d7<String, Matrix4>> g;

    public i4() {
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
        this.a = new c7<>();
        this.b = new c7<>();
        this.c = new c7<>();
        this.d = new c7<>();
        this.e = new c7<>();
        this.f = new c7<>();
        this.g = new y7<>();
    }

    public i4(x4 x4Var, q5 q5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {x4Var, q5Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new c7<>();
        this.b = new c7<>();
        this.c = new c7<>();
        this.d = new c7<>();
        this.e = new c7<>();
        this.f = new c7<>();
        this.g = new y7<>();
        l(x4Var, q5Var);
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

    @Override // com.baidu.tieba.j7
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c7.b<j7> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().dispose();
            }
        }
    }

    public Iterable<j7> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.f;
        }
        return (Iterable) invokeV.objValue;
    }

    public h4 f(ModelMaterial modelMaterial, q5 q5Var) {
        InterceptResult invokeLL;
        Texture load;
        float f;
        float f2;
        float f3;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, modelMaterial, q5Var)) == null) {
            h4 h4Var = new h4();
            h4Var.d = modelMaterial.a;
            if (modelMaterial.b != null) {
                h4Var.h(new k4(k4.g, modelMaterial.b));
            }
            if (modelMaterial.c != null) {
                h4Var.h(new k4(k4.e, modelMaterial.c));
            }
            if (modelMaterial.d != null) {
                h4Var.h(new k4(k4.f, modelMaterial.d));
            }
            if (modelMaterial.e != null) {
                h4Var.h(new k4(k4.h, modelMaterial.e));
            }
            if (modelMaterial.f != null) {
                h4Var.h(new k4(k4.i, modelMaterial.f));
            }
            if (modelMaterial.g > 0.0f) {
                h4Var.h(new l4(l4.e, modelMaterial.g));
            }
            if (modelMaterial.h != 1.0f) {
                h4Var.h(new j4(770, 771, modelMaterial.h));
            }
            y7 y7Var = new y7();
            c7<e5> c7Var = modelMaterial.i;
            if (c7Var != null) {
                c7.b<e5> it = c7Var.iterator();
                while (it.hasNext()) {
                    e5 next = it.next();
                    if (y7Var.a(next.a)) {
                        load = (Texture) y7Var.c(next.a);
                    } else {
                        load = q5Var.load(next.a);
                        y7Var.i(next.a, load);
                        this.f.a(load);
                    }
                    p5 p5Var = new p5(load);
                    p5Var.b = load.h();
                    p5Var.c = load.f();
                    p5Var.d = load.j();
                    p5Var.e = load.k();
                    Vector2 vector2 = next.b;
                    if (vector2 == null) {
                        f = 0.0f;
                    } else {
                        f = vector2.x;
                    }
                    Vector2 vector22 = next.b;
                    if (vector22 == null) {
                        f2 = 0.0f;
                    } else {
                        f2 = vector22.y;
                    }
                    Vector2 vector23 = next.c;
                    if (vector23 == null) {
                        f3 = 1.0f;
                    } else {
                        f3 = vector23.x;
                    }
                    Vector2 vector24 = next.c;
                    if (vector24 == null) {
                        f4 = 1.0f;
                    } else {
                        f4 = vector24.y;
                    }
                    int i = next.d;
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                if (i != 5) {
                                    if (i != 7) {
                                        if (i != 8) {
                                            if (i == 10) {
                                                h4Var.h(new m4(m4.p, p5Var, f, f2, f3, f4));
                                            }
                                        } else {
                                            h4Var.h(new m4(m4.l, p5Var, f, f2, f3, f4));
                                        }
                                    } else {
                                        h4Var.h(new m4(m4.m, p5Var, f, f2, f3, f4));
                                    }
                                } else {
                                    h4Var.h(new m4(m4.k, p5Var, f, f2, f3, f4));
                                }
                            } else {
                                h4Var.h(new m4(m4.n, p5Var, f, f2, f3, f4));
                            }
                        } else {
                            h4Var.h(new m4(m4.o, p5Var, f, f2, f3, f4));
                        }
                    } else {
                        h4Var.h(new m4(m4.j, p5Var, f, f2, f3, f4));
                    }
                }
            }
            return h4Var;
        }
        return (h4) invokeLL.objValue;
    }

    public void g(y4 y4Var) {
        boolean z;
        z4[] z4VarArr;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, y4Var) == null) {
            int i2 = 0;
            for (z4 z4Var : y4Var.c) {
                i2 += z4Var.b.length;
            }
            if (i2 > 0) {
                z = true;
            } else {
                z = false;
            }
            v3 v3Var = new v3(y4Var.a);
            int length = y4Var.b.length / (v3Var.b / 4);
            Mesh mesh = new Mesh(true, length, i2, v3Var);
            this.d.a(mesh);
            this.f.a(mesh);
            BufferUtils.a(y4Var.b, mesh.m(), y4Var.b.length, 0);
            mesh.j().clear();
            int i3 = 0;
            for (z4 z4Var2 : y4Var.c) {
                r4 r4Var = new r4();
                r4Var.a = z4Var2.a;
                r4Var.b = z4Var2.c;
                r4Var.c = i3;
                if (z) {
                    i = z4Var2.b.length;
                } else {
                    i = length;
                }
                r4Var.d = i;
                r4Var.e = mesh;
                if (z) {
                    mesh.j().put(z4Var2.b);
                }
                i3 += r4Var.d;
                this.e.a(r4Var);
            }
            mesh.j().position(0);
            c7.b<r4> it = this.e.iterator();
            while (it.hasNext()) {
                it.next().update();
            }
        }
    }

    public void q(Iterable<a5> iterable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, iterable) == null) {
            this.g.clear();
            for (a5 a5Var : iterable) {
                this.b.a(p(a5Var));
            }
            y7.a<v4, d7<String, Matrix4>> b = this.g.b();
            b.c();
            while (b.hasNext()) {
                y7.b next = b.next();
                K k = next.a;
                if (((v4) k).a == null) {
                    ((v4) k).a = new d7<>(s4.class, Matrix4.class);
                }
                ((v4) next.a).a.clear();
                d7.a a = ((d7) next.b).a();
                a.iterator();
                while (a.hasNext()) {
                    y7.b next2 = a.next();
                    ((v4) next.a).a.e(i((String) next2.a), new Matrix4((Matrix4) next2.b).inv());
                }
            }
        }
    }

    public s4 i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            return j(str, true);
        }
        return (s4) invokeL.objValue;
    }

    public void o(Iterable<y4> iterable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, iterable) == null) {
            for (y4 y4Var : iterable) {
                g(y4Var);
            }
        }
    }

    public s4 j(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048582, this, str, z)) == null) {
            return k(str, z, false);
        }
        return (s4) invokeLZ.objValue;
    }

    public void l(x4 x4Var, q5 q5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, x4Var, q5Var) == null) {
            o(x4Var.b);
            n(x4Var.c, q5Var);
            q(x4Var.d);
            m(x4Var.e);
            a();
        }
    }

    public void n(Iterable<ModelMaterial> iterable, q5 q5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, iterable, q5Var) == null) {
            for (ModelMaterial modelMaterial : iterable) {
                this.a.a(f(modelMaterial, q5Var));
            }
        }
    }

    public s4 k(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            return s4.f(this.b, str, z, z2);
        }
        return (s4) invokeCommon.objValue;
    }

    public void m(Iterable<w4> iterable) {
        c7<u4<Quaternion>> c7Var;
        c7<u4<Vector3>> c7Var2;
        Vector3 vector3;
        Quaternion quaternion;
        Vector3 vector32;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, iterable) == null) {
            for (w4 w4Var : iterable) {
                q4 q4Var = new q4();
                String str = w4Var.a;
                c7.b<b5> it = w4Var.b.iterator();
                while (it.hasNext()) {
                    b5 next = it.next();
                    s4 i = i(next.a);
                    if (i != null) {
                        t4 t4Var = new t4();
                        if (next.b != null) {
                            c7<u4<Vector3>> c7Var3 = new c7<>();
                            t4Var.a = c7Var3;
                            c7Var3.e(next.b.b);
                            c7.b<c5<Vector3>> it2 = next.b.iterator();
                            while (it2.hasNext()) {
                                c5<Vector3> next2 = it2.next();
                                float f = next2.a;
                                if (f > q4Var.a) {
                                    q4Var.a = f;
                                }
                                c7<u4<Vector3>> c7Var4 = t4Var.a;
                                float f2 = next2.a;
                                Vector3 vector33 = next2.b;
                                if (vector33 == null) {
                                    vector32 = i.d;
                                } else {
                                    vector32 = vector33;
                                }
                                c7Var4.a(new u4<>(f2, new Vector3(vector32)));
                            }
                        }
                        if (next.c != null) {
                            c7<u4<Quaternion>> c7Var5 = new c7<>();
                            t4Var.b = c7Var5;
                            c7Var5.e(next.c.b);
                            c7.b<c5<Quaternion>> it3 = next.c.iterator();
                            while (it3.hasNext()) {
                                c5<Quaternion> next3 = it3.next();
                                float f3 = next3.a;
                                if (f3 > q4Var.a) {
                                    q4Var.a = f3;
                                }
                                c7<u4<Quaternion>> c7Var6 = t4Var.b;
                                float f4 = next3.a;
                                Quaternion quaternion2 = next3.b;
                                if (quaternion2 == null) {
                                    quaternion = i.e;
                                } else {
                                    quaternion = quaternion2;
                                }
                                c7Var6.a(new u4<>(f4, new Quaternion(quaternion)));
                            }
                        }
                        if (next.d != null) {
                            c7<u4<Vector3>> c7Var7 = new c7<>();
                            t4Var.c = c7Var7;
                            c7Var7.e(next.d.b);
                            c7.b<c5<Vector3>> it4 = next.d.iterator();
                            while (it4.hasNext()) {
                                c5<Vector3> next4 = it4.next();
                                float f5 = next4.a;
                                if (f5 > q4Var.a) {
                                    q4Var.a = f5;
                                }
                                c7<u4<Vector3>> c7Var8 = t4Var.c;
                                float f6 = next4.a;
                                Vector3 vector34 = next4.b;
                                if (vector34 == null) {
                                    vector3 = i.f;
                                } else {
                                    vector3 = vector34;
                                }
                                c7Var8.a(new u4<>(f6, new Vector3(vector3)));
                            }
                        }
                        c7<u4<Vector3>> c7Var9 = t4Var.a;
                        if ((c7Var9 != null && c7Var9.b > 0) || (((c7Var = t4Var.b) != null && c7Var.b > 0) || ((c7Var2 = t4Var.c) != null && c7Var2.b > 0))) {
                            q4Var.b.a(t4Var);
                        }
                    }
                }
                if (q4Var.b.b > 0) {
                    this.c.a(q4Var);
                }
            }
        }
    }

    public s4 p(a5 a5Var) {
        InterceptResult invokeL;
        r4 r4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, a5Var)) == null) {
            s4 s4Var = new s4();
            s4Var.a = a5Var.a;
            Vector3 vector3 = a5Var.b;
            if (vector3 != null) {
                s4Var.d.set(vector3);
            }
            Quaternion quaternion = a5Var.c;
            if (quaternion != null) {
                s4Var.e.set(quaternion);
            }
            Vector3 vector32 = a5Var.d;
            if (vector32 != null) {
                s4Var.f.set(vector32);
            }
            d5[] d5VarArr = a5Var.e;
            if (d5VarArr != null) {
                for (d5 d5Var : d5VarArr) {
                    h4 h4Var = null;
                    if (d5Var.b != null) {
                        c7.b<r4> it = this.e.iterator();
                        while (it.hasNext()) {
                            r4Var = it.next();
                            if (d5Var.b.equals(r4Var.a)) {
                                break;
                            }
                        }
                    }
                    r4Var = null;
                    if (d5Var.a != null) {
                        c7.b<h4> it2 = this.a.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            h4 next = it2.next();
                            if (d5Var.a.equals(next.d)) {
                                h4Var = next;
                                break;
                            }
                        }
                    }
                    if (r4Var != null && h4Var != null) {
                        v4 v4Var = new v4();
                        s4Var.i.a(v4Var);
                        d7<String, Matrix4> d7Var = d5Var.c;
                        if (d7Var != null) {
                            this.g.i(v4Var, d7Var);
                        }
                    } else {
                        throw new GdxRuntimeException("Invalid node: " + s4Var.a);
                    }
                }
            }
            a5[] a5VarArr = a5Var.f;
            if (a5VarArr != null) {
                for (a5 a5Var2 : a5VarArr) {
                    s4Var.a(p(a5Var2));
                }
            }
            return s4Var;
        }
        return (s4) invokeL.objValue;
    }
}
