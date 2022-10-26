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
import java.util.Iterator;
/* loaded from: classes4.dex */
public class h4 implements i7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final b7 a;
    public final b7 b;
    public final b7 c;
    public final b7 d;
    public final b7 e;
    public final b7 f;
    public x7 g;

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
        this.a = new b7();
        this.b = new b7();
        this.c = new b7();
        this.d = new b7();
        this.e = new b7();
        this.f = new b7();
        this.g = new x7();
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
        this.a = new b7();
        this.b = new b7();
        this.c = new b7();
        this.d = new b7();
        this.e = new b7();
        this.f = new b7();
        this.g = new x7();
        l(w4Var, p5Var);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i = this.b.b;
            for (int i2 = 0; i2 < i; i2++) {
                ((r4) this.b.get(i2)).d(true);
            }
            for (int i3 = 0; i3 < i; i3++) {
                ((r4) this.b.get(i3)).b(true);
            }
        }
    }

    @Override // com.baidu.tieba.i7
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b7.b it = this.f.iterator();
            while (it.hasNext()) {
                ((i7) it.next()).dispose();
            }
        }
    }

    public Iterable h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.f;
        }
        return (Iterable) invokeV.objValue;
    }

    public g4 f(ModelMaterial modelMaterial, p5 p5Var) {
        InterceptResult invokeLL;
        Texture load;
        float f;
        float f2;
        float f3;
        float f4;
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
            b7 b7Var = modelMaterial.i;
            if (b7Var != null) {
                b7.b it = b7Var.iterator();
                while (it.hasNext()) {
                    d5 d5Var = (d5) it.next();
                    if (x7Var.a(d5Var.a)) {
                        load = (Texture) x7Var.c(d5Var.a);
                    } else {
                        load = p5Var.load(d5Var.a);
                        x7Var.i(d5Var.a, load);
                        this.f.a(load);
                    }
                    o5 o5Var = new o5(load);
                    o5Var.b = load.h();
                    o5Var.c = load.f();
                    o5Var.d = load.j();
                    o5Var.e = load.k();
                    Vector2 vector2 = d5Var.b;
                    if (vector2 == null) {
                        f = 0.0f;
                    } else {
                        f = vector2.x;
                    }
                    Vector2 vector22 = d5Var.b;
                    if (vector22 == null) {
                        f2 = 0.0f;
                    } else {
                        f2 = vector22.y;
                    }
                    Vector2 vector23 = d5Var.c;
                    if (vector23 == null) {
                        f3 = 1.0f;
                    } else {
                        f3 = vector23.x;
                    }
                    Vector2 vector24 = d5Var.c;
                    if (vector24 == null) {
                        f4 = 1.0f;
                    } else {
                        f4 = vector24.y;
                    }
                    int i = d5Var.d;
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                if (i != 5) {
                                    if (i != 7) {
                                        if (i != 8) {
                                            if (i == 10) {
                                                g4Var.h(new l4(l4.p, o5Var, f, f2, f3, f4));
                                            }
                                        } else {
                                            g4Var.h(new l4(l4.l, o5Var, f, f2, f3, f4));
                                        }
                                    } else {
                                        g4Var.h(new l4(l4.m, o5Var, f, f2, f3, f4));
                                    }
                                } else {
                                    g4Var.h(new l4(l4.k, o5Var, f, f2, f3, f4));
                                }
                            } else {
                                g4Var.h(new l4(l4.n, o5Var, f, f2, f3, f4));
                            }
                        } else {
                            g4Var.h(new l4(l4.o, o5Var, f, f2, f3, f4));
                        }
                    } else {
                        g4Var.h(new l4(l4.j, o5Var, f, f2, f3, f4));
                    }
                }
            }
            return g4Var;
        }
        return (g4) invokeLL.objValue;
    }

    public void g(x4 x4Var) {
        boolean z;
        y4[] y4VarArr;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, x4Var) == null) {
            int i2 = 0;
            for (y4 y4Var : x4Var.c) {
                i2 += y4Var.b.length;
            }
            if (i2 > 0) {
                z = true;
            } else {
                z = false;
            }
            u3 u3Var = new u3(x4Var.a);
            int length = x4Var.b.length / (u3Var.b / 4);
            Mesh mesh = new Mesh(true, length, i2, u3Var);
            this.d.a(mesh);
            this.f.a(mesh);
            BufferUtils.a(x4Var.b, mesh.m(), x4Var.b.length, 0);
            mesh.j().clear();
            int i3 = 0;
            for (y4 y4Var2 : x4Var.c) {
                q4 q4Var = new q4();
                q4Var.a = y4Var2.a;
                q4Var.b = y4Var2.c;
                q4Var.c = i3;
                if (z) {
                    i = y4Var2.b.length;
                } else {
                    i = length;
                }
                q4Var.d = i;
                q4Var.e = mesh;
                if (z) {
                    mesh.j().put(y4Var2.b);
                }
                i3 += q4Var.d;
                this.e.a(q4Var);
            }
            mesh.j().position(0);
            b7.b it = this.e.iterator();
            while (it.hasNext()) {
                ((q4) it.next()).update();
            }
        }
    }

    public void q(Iterable iterable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, iterable) == null) {
            this.g.clear();
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                this.b.a(p((z4) it.next()));
            }
            x7.a b = this.g.b();
            b.c();
            while (b.hasNext()) {
                x7.b bVar = (x7.b) b.next();
                Object obj = bVar.a;
                if (((u4) obj).a == null) {
                    ((u4) obj).a = new c7(r4.class, Matrix4.class);
                }
                ((u4) bVar.a).a.clear();
                c7.a a = ((c7) bVar.b).a();
                a.iterator();
                while (a.hasNext()) {
                    x7.b bVar2 = (x7.b) a.next();
                    ((u4) bVar.a).a.e(i((String) bVar2.a), new Matrix4((Matrix4) bVar2.b).inv());
                }
            }
        }
    }

    public r4 i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            return j(str, true);
        }
        return (r4) invokeL.objValue;
    }

    public void o(Iterable iterable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, iterable) == null) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                g((x4) it.next());
            }
        }
    }

    public r4 j(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048582, this, str, z)) == null) {
            return k(str, z, false);
        }
        return (r4) invokeLZ.objValue;
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

    public void n(Iterable iterable, p5 p5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, iterable, p5Var) == null) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                this.a.a(f((ModelMaterial) it.next(), p5Var));
            }
        }
    }

    public r4 k(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            return r4.f(this.b, str, z, z2);
        }
        return (r4) invokeCommon.objValue;
    }

    public void m(Iterable iterable) {
        b7 b7Var;
        b7 b7Var2;
        Vector3 vector3;
        Quaternion quaternion;
        Vector3 vector32;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, iterable) == null) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                v4 v4Var = (v4) it.next();
                p4 p4Var = new p4();
                String str = v4Var.a;
                b7.b it2 = v4Var.b.iterator();
                while (it2.hasNext()) {
                    a5 a5Var = (a5) it2.next();
                    r4 i = i(a5Var.a);
                    if (i != null) {
                        s4 s4Var = new s4();
                        if (a5Var.b != null) {
                            b7 b7Var3 = new b7();
                            s4Var.a = b7Var3;
                            b7Var3.e(a5Var.b.b);
                            b7.b it3 = a5Var.b.iterator();
                            while (it3.hasNext()) {
                                b5 b5Var = (b5) it3.next();
                                float f = b5Var.a;
                                if (f > p4Var.a) {
                                    p4Var.a = f;
                                }
                                b7 b7Var4 = s4Var.a;
                                float f2 = b5Var.a;
                                Object obj = b5Var.b;
                                if (obj == null) {
                                    vector32 = i.d;
                                } else {
                                    vector32 = (Vector3) obj;
                                }
                                b7Var4.a(new t4(f2, new Vector3(vector32)));
                            }
                        }
                        if (a5Var.c != null) {
                            b7 b7Var5 = new b7();
                            s4Var.b = b7Var5;
                            b7Var5.e(a5Var.c.b);
                            b7.b it4 = a5Var.c.iterator();
                            while (it4.hasNext()) {
                                b5 b5Var2 = (b5) it4.next();
                                float f3 = b5Var2.a;
                                if (f3 > p4Var.a) {
                                    p4Var.a = f3;
                                }
                                b7 b7Var6 = s4Var.b;
                                float f4 = b5Var2.a;
                                Object obj2 = b5Var2.b;
                                if (obj2 == null) {
                                    quaternion = i.e;
                                } else {
                                    quaternion = (Quaternion) obj2;
                                }
                                b7Var6.a(new t4(f4, new Quaternion(quaternion)));
                            }
                        }
                        if (a5Var.d != null) {
                            b7 b7Var7 = new b7();
                            s4Var.c = b7Var7;
                            b7Var7.e(a5Var.d.b);
                            b7.b it5 = a5Var.d.iterator();
                            while (it5.hasNext()) {
                                b5 b5Var3 = (b5) it5.next();
                                float f5 = b5Var3.a;
                                if (f5 > p4Var.a) {
                                    p4Var.a = f5;
                                }
                                b7 b7Var8 = s4Var.c;
                                float f6 = b5Var3.a;
                                Object obj3 = b5Var3.b;
                                if (obj3 == null) {
                                    vector3 = i.f;
                                } else {
                                    vector3 = (Vector3) obj3;
                                }
                                b7Var8.a(new t4(f6, new Vector3(vector3)));
                            }
                        }
                        b7 b7Var9 = s4Var.a;
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
                        b7.b it = this.e.iterator();
                        while (it.hasNext()) {
                            q4Var = (q4) it.next();
                            if (c5Var.b.equals(q4Var.a)) {
                                break;
                            }
                        }
                    }
                    q4Var = null;
                    if (c5Var.a != null) {
                        b7.b it2 = this.a.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            g4 g4Var2 = (g4) it2.next();
                            if (c5Var.a.equals(g4Var2.d)) {
                                g4Var = g4Var2;
                                break;
                            }
                        }
                    }
                    if (q4Var != null && g4Var != null) {
                        u4 u4Var = new u4();
                        r4Var.i.a(u4Var);
                        c7 c7Var = c5Var.c;
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
}
