package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.graphics.Texture;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class d4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Texture a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public float k;
    public float l;
    public float m;
    public float n;
    public float o;
    public float p;
    public float[] q;
    public int r;
    public final r3 s;
    public float t;
    public float u;
    public float v;
    public float w;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448300893, "Lcom/baidu/tieba/d4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448300893, "Lcom/baidu/tieba/d4;");
            }
        }
    }

    public float b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.p;
        }
        return invokeV.floatValue;
    }

    public float c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.k;
        }
        return invokeV.floatValue;
    }

    public float d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            float f = this.w;
            if (f == -1.0f) {
                return b();
            }
            return f;
        }
        return invokeV.floatValue;
    }

    public float e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            float f = this.t;
            if (f == -1.0f) {
                return c();
            }
            return f;
        }
        return invokeV.floatValue;
    }

    public float f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            float f = this.u;
            if (f == -1.0f) {
                return h();
            }
            return f;
        }
        return invokeV.floatValue;
    }

    public float g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            float f = this.v;
            if (f == -1.0f) {
                return i();
            }
            return f;
        }
        return invokeV.floatValue;
    }

    public float h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.l;
        }
        return invokeV.floatValue;
    }

    public float i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.o;
        }
        return invokeV.floatValue;
    }

    public float j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.o + this.n + this.p;
        }
        return invokeV.floatValue;
    }

    public float k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.k + this.m + this.l;
        }
        return invokeV.floatValue;
    }

    public d4(d4 d4Var, r3 r3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d4Var, r3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.q = new float[180];
        this.s = new r3(r3.e);
        this.t = -1.0f;
        this.u = -1.0f;
        this.v = -1.0f;
        this.w = -1.0f;
        this.a = d4Var.a;
        this.b = d4Var.b;
        this.c = d4Var.c;
        this.d = d4Var.d;
        this.e = d4Var.e;
        this.f = d4Var.f;
        this.g = d4Var.g;
        this.h = d4Var.h;
        this.i = d4Var.i;
        this.j = d4Var.j;
        this.k = d4Var.k;
        this.l = d4Var.l;
        this.m = d4Var.m;
        this.n = d4Var.n;
        this.o = d4Var.o;
        this.p = d4Var.p;
        this.t = d4Var.t;
        this.v = d4Var.v;
        this.w = d4Var.w;
        this.u = d4Var.u;
        float[] fArr = new float[d4Var.q.length];
        this.q = fArr;
        float[] fArr2 = d4Var.q;
        System.arraycopy(fArr2, 0, fArr, 0, fArr2.length);
        this.r = d4Var.r;
        this.s.e(r3Var);
    }

    public d4(j4 j4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {j4Var};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.q = new float[180];
        this.s = new r3(r3.e);
        this.t = -1.0f;
        this.u = -1.0f;
        this.v = -1.0f;
        this.w = -1.0f;
        l(new j4[]{null, null, null, null, j4Var, null, null, null, null});
    }

    public d4(j4 j4Var, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {j4Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.q = new float[180];
        this.s = new r3(r3.e);
        this.t = -1.0f;
        this.u = -1.0f;
        this.v = -1.0f;
        this.w = -1.0f;
        if (j4Var != null) {
            int c = (j4Var.c() - i) - i2;
            int b = (j4Var.b() - i3) - i4;
            j4[] j4VarArr = new j4[9];
            if (i3 > 0) {
                if (i > 0) {
                    j4VarArr[0] = new j4(j4Var, 0, 0, i, i3);
                }
                if (c > 0) {
                    j4VarArr[1] = new j4(j4Var, i, 0, c, i3);
                }
                if (i2 > 0) {
                    j4VarArr[2] = new j4(j4Var, i + c, 0, i2, i3);
                }
            }
            if (b > 0) {
                if (i > 0) {
                    j4VarArr[3] = new j4(j4Var, 0, i3, i, b);
                }
                if (c > 0) {
                    j4VarArr[4] = new j4(j4Var, i, i3, c, b);
                }
                if (i2 > 0) {
                    j4VarArr[5] = new j4(j4Var, i + c, i3, i2, b);
                }
            }
            if (i4 > 0) {
                if (i > 0) {
                    j4VarArr[6] = new j4(j4Var, 0, i3 + b, i, i4);
                }
                if (c > 0) {
                    j4VarArr[7] = new j4(j4Var, i, i3 + b, c, i4);
                }
                if (i2 > 0) {
                    j4VarArr[8] = new j4(j4Var, i + c, i3 + b, i2, i4);
                }
            }
            if (i == 0 && c == 0) {
                j4VarArr[1] = j4VarArr[2];
                j4VarArr[4] = j4VarArr[5];
                j4VarArr[7] = j4VarArr[8];
                j4VarArr[2] = null;
                j4VarArr[5] = null;
                j4VarArr[8] = null;
            }
            if (i3 == 0 && b == 0) {
                j4VarArr[3] = j4VarArr[6];
                j4VarArr[4] = j4VarArr[7];
                j4VarArr[5] = j4VarArr[8];
                j4VarArr[6] = null;
                j4VarArr[7] = null;
                j4VarArr[8] = null;
            }
            l(j4VarArr);
            return;
        }
        throw new IllegalArgumentException("region cannot be null.");
    }

    public final int a(j4 j4Var, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{j4Var, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            Texture texture = this.a;
            if (texture == null) {
                this.a = j4Var.f();
            } else if (texture != j4Var.f()) {
                throw new IllegalArgumentException("All regions must be from the same texture.");
            }
            float f = j4Var.b;
            float f2 = j4Var.e;
            float f3 = j4Var.d;
            float f4 = j4Var.c;
            if (this.a.f() == Texture.TextureFilter.Linear || this.a.h() == Texture.TextureFilter.Linear) {
                if (z) {
                    float x = 0.5f / this.a.x();
                    f += x;
                    f3 -= x;
                }
                if (z2) {
                    float u = 0.5f / this.a.u();
                    f2 -= u;
                    f4 += u;
                }
            }
            float[] fArr = this.q;
            int i = this.r;
            fArr[i + 3] = f;
            fArr[i + 4] = f2;
            fArr[i + 8] = f;
            fArr[i + 9] = f4;
            fArr[i + 13] = f3;
            fArr[i + 14] = f4;
            fArr[i + 18] = f3;
            fArr[i + 19] = f2;
            this.r = i + 20;
            return i;
        }
        return invokeCommon.intValue;
    }

    public final void l(j4[] j4VarArr) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, j4VarArr) == null) {
            if (j4VarArr[6] != null) {
                this.b = a(j4VarArr[6], false, false);
                this.k = j4VarArr[6].c();
                this.p = j4VarArr[6].b();
            } else {
                this.b = -1;
            }
            if (j4VarArr[7] != null) {
                j4 j4Var = j4VarArr[7];
                if (j4VarArr[6] == null && j4VarArr[8] == null) {
                    z6 = false;
                } else {
                    z6 = true;
                }
                this.c = a(j4Var, z6, false);
                this.m = Math.max(this.m, j4VarArr[7].c());
                this.p = Math.max(this.p, j4VarArr[7].b());
            } else {
                this.c = -1;
            }
            if (j4VarArr[8] != null) {
                this.d = a(j4VarArr[8], false, false);
                this.l = Math.max(this.l, j4VarArr[8].c());
                this.p = Math.max(this.p, j4VarArr[8].b());
            } else {
                this.d = -1;
            }
            if (j4VarArr[3] != null) {
                j4 j4Var2 = j4VarArr[3];
                if (j4VarArr[0] == null && j4VarArr[6] == null) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                this.e = a(j4Var2, false, z5);
                this.k = Math.max(this.k, j4VarArr[3].c());
                this.n = Math.max(this.n, j4VarArr[3].b());
            } else {
                this.e = -1;
            }
            if (j4VarArr[4] != null) {
                j4 j4Var3 = j4VarArr[4];
                if (j4VarArr[3] == null && j4VarArr[5] == null) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (j4VarArr[1] == null && j4VarArr[7] == null) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                this.f = a(j4Var3, z3, z4);
                this.m = Math.max(this.m, j4VarArr[4].c());
                this.n = Math.max(this.n, j4VarArr[4].b());
            } else {
                this.f = -1;
            }
            if (j4VarArr[5] != null) {
                j4 j4Var4 = j4VarArr[5];
                if (j4VarArr[2] == null && j4VarArr[8] == null) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                this.g = a(j4Var4, false, z2);
                this.l = Math.max(this.l, j4VarArr[5].c());
                this.n = Math.max(this.n, j4VarArr[5].b());
            } else {
                this.g = -1;
            }
            if (j4VarArr[0] != null) {
                this.h = a(j4VarArr[0], false, false);
                this.k = Math.max(this.k, j4VarArr[0].c());
                this.o = Math.max(this.o, j4VarArr[0].b());
            } else {
                this.h = -1;
            }
            if (j4VarArr[1] != null) {
                j4 j4Var5 = j4VarArr[1];
                if (j4VarArr[0] == null && j4VarArr[2] == null) {
                    z = false;
                } else {
                    z = true;
                }
                this.i = a(j4Var5, z, false);
                this.m = Math.max(this.m, j4VarArr[1].c());
                this.o = Math.max(this.o, j4VarArr[1].b());
            } else {
                this.i = -1;
            }
            if (j4VarArr[2] != null) {
                this.j = a(j4VarArr[2], false, false);
                this.l = Math.max(this.l, j4VarArr[2].c());
                this.o = Math.max(this.o, j4VarArr[2].b());
            } else {
                this.j = -1;
            }
            int i = this.r;
            float[] fArr = this.q;
            if (i < fArr.length) {
                float[] fArr2 = new float[i];
                System.arraycopy(fArr, 0, fArr2, 0, i);
                this.q = fArr2;
            }
        }
    }

    public void m(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            this.k *= f;
            this.l *= f;
            this.o *= f2;
            this.p *= f2;
            this.m *= f;
            this.n *= f2;
            float f3 = this.t;
            if (f3 != -1.0f) {
                this.t = f3 * f;
            }
            float f4 = this.u;
            if (f4 != -1.0f) {
                this.u = f4 * f;
            }
            float f5 = this.v;
            if (f5 != -1.0f) {
                this.v = f5 * f2;
            }
            float f6 = this.w;
            if (f6 != -1.0f) {
                this.w = f6 * f2;
            }
        }
    }

    public void n(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            this.t = f;
            this.u = f2;
            this.v = f3;
            this.w = f4;
        }
    }
}
