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
import com.baidu.tieba.q7;
import com.baidu.tieba.u6;
import com.baidu.tieba.v6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class a4 implements b7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final u6<z3> a;
    public final u6<k4> b;
    public final u6<i4> c;
    public final u6<Mesh> d;
    public final u6<j4> e;
    public final u6<b7> f;
    public q7<n4, v6<String, Matrix4>> g;

    public a4() {
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
        this.a = new u6<>();
        this.b = new u6<>();
        this.c = new u6<>();
        this.d = new u6<>();
        this.e = new u6<>();
        this.f = new u6<>();
        this.g = new q7<>();
    }

    public a4(p4 p4Var, i5 i5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {p4Var, i5Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new u6<>();
        this.b = new u6<>();
        this.c = new u6<>();
        this.d = new u6<>();
        this.e = new u6<>();
        this.f = new u6<>();
        this.g = new q7<>();
        l(p4Var, i5Var);
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

    @Override // com.baidu.tieba.b7
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            u6.b<b7> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().dispose();
            }
        }
    }

    public Iterable<b7> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.f;
        }
        return (Iterable) invokeV.objValue;
    }

    public z3 f(ModelMaterial modelMaterial, i5 i5Var) {
        InterceptResult invokeLL;
        Texture load;
        float f;
        float f2;
        float f3;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, modelMaterial, i5Var)) == null) {
            z3 z3Var = new z3();
            z3Var.d = modelMaterial.a;
            if (modelMaterial.b != null) {
                z3Var.h(new c4(c4.g, modelMaterial.b));
            }
            if (modelMaterial.c != null) {
                z3Var.h(new c4(c4.e, modelMaterial.c));
            }
            if (modelMaterial.d != null) {
                z3Var.h(new c4(c4.f, modelMaterial.d));
            }
            if (modelMaterial.e != null) {
                z3Var.h(new c4(c4.h, modelMaterial.e));
            }
            if (modelMaterial.f != null) {
                z3Var.h(new c4(c4.i, modelMaterial.f));
            }
            if (modelMaterial.g > 0.0f) {
                z3Var.h(new d4(d4.e, modelMaterial.g));
            }
            if (modelMaterial.h != 1.0f) {
                z3Var.h(new b4(770, 771, modelMaterial.h));
            }
            q7 q7Var = new q7();
            u6<w4> u6Var = modelMaterial.i;
            if (u6Var != null) {
                u6.b<w4> it = u6Var.iterator();
                while (it.hasNext()) {
                    w4 next = it.next();
                    if (q7Var.a(next.a)) {
                        load = (Texture) q7Var.c(next.a);
                    } else {
                        load = i5Var.load(next.a);
                        q7Var.i(next.a, load);
                        this.f.a(load);
                    }
                    h5 h5Var = new h5(load);
                    h5Var.b = load.h();
                    h5Var.c = load.f();
                    h5Var.d = load.j();
                    h5Var.e = load.k();
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
                                                z3Var.h(new e4(e4.p, h5Var, f, f2, f3, f4));
                                            }
                                        } else {
                                            z3Var.h(new e4(e4.l, h5Var, f, f2, f3, f4));
                                        }
                                    } else {
                                        z3Var.h(new e4(e4.m, h5Var, f, f2, f3, f4));
                                    }
                                } else {
                                    z3Var.h(new e4(e4.k, h5Var, f, f2, f3, f4));
                                }
                            } else {
                                z3Var.h(new e4(e4.n, h5Var, f, f2, f3, f4));
                            }
                        } else {
                            z3Var.h(new e4(e4.o, h5Var, f, f2, f3, f4));
                        }
                    } else {
                        z3Var.h(new e4(e4.j, h5Var, f, f2, f3, f4));
                    }
                }
            }
            return z3Var;
        }
        return (z3) invokeLL.objValue;
    }

    public void g(q4 q4Var) {
        boolean z;
        r4[] r4VarArr;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, q4Var) == null) {
            int i2 = 0;
            for (r4 r4Var : q4Var.c) {
                i2 += r4Var.b.length;
            }
            if (i2 > 0) {
                z = true;
            } else {
                z = false;
            }
            n3 n3Var = new n3(q4Var.a);
            int length = q4Var.b.length / (n3Var.b / 4);
            Mesh mesh = new Mesh(true, length, i2, n3Var);
            this.d.a(mesh);
            this.f.a(mesh);
            BufferUtils.a(q4Var.b, mesh.m(), q4Var.b.length, 0);
            mesh.j().clear();
            int i3 = 0;
            for (r4 r4Var2 : q4Var.c) {
                j4 j4Var = new j4();
                j4Var.a = r4Var2.a;
                j4Var.b = r4Var2.c;
                j4Var.c = i3;
                if (z) {
                    i = r4Var2.b.length;
                } else {
                    i = length;
                }
                j4Var.d = i;
                j4Var.e = mesh;
                if (z) {
                    mesh.j().put(r4Var2.b);
                }
                i3 += j4Var.d;
                this.e.a(j4Var);
            }
            mesh.j().position(0);
            u6.b<j4> it = this.e.iterator();
            while (it.hasNext()) {
                it.next().update();
            }
        }
    }

    public void q(Iterable<s4> iterable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, iterable) == null) {
            this.g.clear();
            for (s4 s4Var : iterable) {
                this.b.a(p(s4Var));
            }
            q7.a<n4, v6<String, Matrix4>> b = this.g.b();
            b.c();
            while (b.hasNext()) {
                q7.b next = b.next();
                K k = next.a;
                if (((n4) k).a == null) {
                    ((n4) k).a = new v6<>(k4.class, Matrix4.class);
                }
                ((n4) next.a).a.clear();
                v6.a a = ((v6) next.b).a();
                a.iterator();
                while (a.hasNext()) {
                    q7.b next2 = a.next();
                    ((n4) next.a).a.e(i((String) next2.a), new Matrix4((Matrix4) next2.b).inv());
                }
            }
        }
    }

    public k4 i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            return j(str, true);
        }
        return (k4) invokeL.objValue;
    }

    public void o(Iterable<q4> iterable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, iterable) == null) {
            for (q4 q4Var : iterable) {
                g(q4Var);
            }
        }
    }

    public k4 j(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048582, this, str, z)) == null) {
            return k(str, z, false);
        }
        return (k4) invokeLZ.objValue;
    }

    public void l(p4 p4Var, i5 i5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, p4Var, i5Var) == null) {
            o(p4Var.b);
            n(p4Var.c, i5Var);
            q(p4Var.d);
            m(p4Var.e);
            a();
        }
    }

    public void n(Iterable<ModelMaterial> iterable, i5 i5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, iterable, i5Var) == null) {
            for (ModelMaterial modelMaterial : iterable) {
                this.a.a(f(modelMaterial, i5Var));
            }
        }
    }

    public k4 k(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            return k4.f(this.b, str, z, z2);
        }
        return (k4) invokeCommon.objValue;
    }

    public void m(Iterable<o4> iterable) {
        u6<m4<Quaternion>> u6Var;
        u6<m4<Vector3>> u6Var2;
        Vector3 vector3;
        Quaternion quaternion;
        Vector3 vector32;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, iterable) == null) {
            for (o4 o4Var : iterable) {
                i4 i4Var = new i4();
                String str = o4Var.a;
                u6.b<t4> it = o4Var.b.iterator();
                while (it.hasNext()) {
                    t4 next = it.next();
                    k4 i = i(next.a);
                    if (i != null) {
                        l4 l4Var = new l4();
                        if (next.b != null) {
                            u6<m4<Vector3>> u6Var3 = new u6<>();
                            l4Var.a = u6Var3;
                            u6Var3.e(next.b.b);
                            u6.b<u4<Vector3>> it2 = next.b.iterator();
                            while (it2.hasNext()) {
                                u4<Vector3> next2 = it2.next();
                                float f = next2.a;
                                if (f > i4Var.a) {
                                    i4Var.a = f;
                                }
                                u6<m4<Vector3>> u6Var4 = l4Var.a;
                                float f2 = next2.a;
                                Vector3 vector33 = next2.b;
                                if (vector33 == null) {
                                    vector32 = i.d;
                                } else {
                                    vector32 = vector33;
                                }
                                u6Var4.a(new m4<>(f2, new Vector3(vector32)));
                            }
                        }
                        if (next.c != null) {
                            u6<m4<Quaternion>> u6Var5 = new u6<>();
                            l4Var.b = u6Var5;
                            u6Var5.e(next.c.b);
                            u6.b<u4<Quaternion>> it3 = next.c.iterator();
                            while (it3.hasNext()) {
                                u4<Quaternion> next3 = it3.next();
                                float f3 = next3.a;
                                if (f3 > i4Var.a) {
                                    i4Var.a = f3;
                                }
                                u6<m4<Quaternion>> u6Var6 = l4Var.b;
                                float f4 = next3.a;
                                Quaternion quaternion2 = next3.b;
                                if (quaternion2 == null) {
                                    quaternion = i.e;
                                } else {
                                    quaternion = quaternion2;
                                }
                                u6Var6.a(new m4<>(f4, new Quaternion(quaternion)));
                            }
                        }
                        if (next.d != null) {
                            u6<m4<Vector3>> u6Var7 = new u6<>();
                            l4Var.c = u6Var7;
                            u6Var7.e(next.d.b);
                            u6.b<u4<Vector3>> it4 = next.d.iterator();
                            while (it4.hasNext()) {
                                u4<Vector3> next4 = it4.next();
                                float f5 = next4.a;
                                if (f5 > i4Var.a) {
                                    i4Var.a = f5;
                                }
                                u6<m4<Vector3>> u6Var8 = l4Var.c;
                                float f6 = next4.a;
                                Vector3 vector34 = next4.b;
                                if (vector34 == null) {
                                    vector3 = i.f;
                                } else {
                                    vector3 = vector34;
                                }
                                u6Var8.a(new m4<>(f6, new Vector3(vector3)));
                            }
                        }
                        u6<m4<Vector3>> u6Var9 = l4Var.a;
                        if ((u6Var9 != null && u6Var9.b > 0) || (((u6Var = l4Var.b) != null && u6Var.b > 0) || ((u6Var2 = l4Var.c) != null && u6Var2.b > 0))) {
                            i4Var.b.a(l4Var);
                        }
                    }
                }
                if (i4Var.b.b > 0) {
                    this.c.a(i4Var);
                }
            }
        }
    }

    public k4 p(s4 s4Var) {
        InterceptResult invokeL;
        j4 j4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, s4Var)) == null) {
            k4 k4Var = new k4();
            k4Var.a = s4Var.a;
            Vector3 vector3 = s4Var.b;
            if (vector3 != null) {
                k4Var.d.set(vector3);
            }
            Quaternion quaternion = s4Var.c;
            if (quaternion != null) {
                k4Var.e.set(quaternion);
            }
            Vector3 vector32 = s4Var.d;
            if (vector32 != null) {
                k4Var.f.set(vector32);
            }
            v4[] v4VarArr = s4Var.e;
            if (v4VarArr != null) {
                for (v4 v4Var : v4VarArr) {
                    z3 z3Var = null;
                    if (v4Var.b != null) {
                        u6.b<j4> it = this.e.iterator();
                        while (it.hasNext()) {
                            j4Var = it.next();
                            if (v4Var.b.equals(j4Var.a)) {
                                break;
                            }
                        }
                    }
                    j4Var = null;
                    if (v4Var.a != null) {
                        u6.b<z3> it2 = this.a.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            z3 next = it2.next();
                            if (v4Var.a.equals(next.d)) {
                                z3Var = next;
                                break;
                            }
                        }
                    }
                    if (j4Var != null && z3Var != null) {
                        n4 n4Var = new n4();
                        k4Var.i.a(n4Var);
                        v6<String, Matrix4> v6Var = v4Var.c;
                        if (v6Var != null) {
                            this.g.i(n4Var, v6Var);
                        }
                    } else {
                        throw new GdxRuntimeException("Invalid node: " + k4Var.a);
                    }
                }
            }
            s4[] s4VarArr = s4Var.f;
            if (s4VarArr != null) {
                for (s4 s4Var2 : s4VarArr) {
                    k4Var.a(p(s4Var2));
                }
            }
            return k4Var;
        }
        return (k4) invokeL.objValue;
    }
}
