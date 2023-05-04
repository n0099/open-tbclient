package com.baidu.tieba;

import android.graphics.SurfaceTexture;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.hka;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a3a implements hka.b {
    public static /* synthetic */ Interceptable $ic;
    public static volatile a3a k;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public hka.b b;
    public hka.b c;
    public hka.b d;
    public boolean e;
    public hka.f f;
    public SurfaceTexture g;
    public int h;
    public boolean i;
    public hka.a j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947565626, "Lcom/baidu/tieba/a3a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947565626, "Lcom/baidu/tieba/a3a;");
        }
    }

    /* loaded from: classes3.dex */
    public class a implements hka.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a3a a;

        public a(a3a a3aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a3aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a3aVar;
        }

        @Override // com.baidu.tieba.hka.a
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj instanceof String) {
                    String str = (String) obj;
                }
                this.a.C();
                this.a.d.k(this.a.g, this.a.f);
                if (!this.a.i) {
                    return;
                }
                this.a.i = false;
                this.a.d.n();
            }
        }
    }

    public a3a(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = false;
        this.i = false;
        this.j = new a(this);
        if (Build.VERSION.SDK_INT >= 21) {
            if (System.currentTimeMillis() - y2a.b.c() >= y2a.a) {
                y2a.b.k(0);
            }
            if (1 != y2a.b.d().intValue()) {
                this.c = x2a.U(tbPageContext);
            }
        }
        z2a B = z2a.B(tbPageContext);
        this.b = B;
        this.d = B;
    }

    @Override // com.baidu.tieba.hka.b
    public void d(byte[] bArr) {
        hka.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, bArr) == null) && (bVar = this.d) == this.b && bVar != null) {
            bVar.d(bArr);
        }
    }

    @Override // com.baidu.tieba.hka.b
    public void h(boolean z) {
        hka.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.e = z;
            if (z && (bVar = this.c) != null) {
                bVar.s(this.j);
                this.d = this.c;
                return;
            }
            hka.b bVar2 = this.c;
            if (bVar2 != null) {
                bVar2.release();
            }
            this.d = this.b;
        }
    }

    @Override // com.baidu.tieba.hka.b
    public void i(boolean z) {
        hka.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048585, this, z) == null) && (bVar = this.d) != null) {
            bVar.i(z);
        }
    }

    @Override // com.baidu.tieba.hka.b
    public void j(boolean z) {
        hka.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048586, this, z) == null) && (bVar = this.d) != null) {
            bVar.j(z);
        }
    }

    @Override // com.baidu.tieba.hka.b
    public void l(int i) {
        hka.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048588, this, i) == null) && (bVar = this.d) != null) {
            bVar.l(i);
        }
    }

    @Override // com.baidu.tieba.hka.b
    public void m(boolean z) {
        hka.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z) == null) && (bVar = this.d) != null) {
            bVar.m(z);
        }
    }

    @Override // com.baidu.tieba.hka.b
    public void s(hka.a aVar) {
        hka.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, aVar) == null) && (bVar = this.c) != null) {
            bVar.s(aVar);
        }
    }

    @Override // com.baidu.tieba.hka.b
    public void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.h = i;
            hka.b bVar = this.d;
            if (bVar != null) {
                bVar.u(i);
            }
        }
    }

    public static a3a D(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext)) == null) {
            if (k == null) {
                synchronized (a3a.class) {
                    if (k == null) {
                        k = new a3a(tbPageContext);
                    } else if (tbPageContext != null) {
                        k.a = tbPageContext;
                    }
                }
            }
            return k;
        }
        return (a3a) invokeL.objValue;
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.c != null) {
            this.b.u(this.h);
            this.b.i(this.c.o());
            this.b.m(this.c.a());
            this.b.j(this.c.p());
            this.c.q();
            this.c.release();
            this.d = this.b;
            this.e = false;
        }
    }

    @Override // com.baidu.tieba.hka.b
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            hka.b bVar = this.d;
            if (bVar != null) {
                return bVar.a();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.hka.b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            hka.b bVar = this.d;
            if (bVar != null) {
                return bVar.b();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.hka.b
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            hka.b bVar = this.d;
            if (bVar != null) {
                return bVar.e();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hka.b
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            hka.b bVar = this.d;
            if (bVar != null) {
                return bVar.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.hka.b
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.i = true;
            hka.b bVar = this.d;
            if (bVar != null) {
                bVar.n();
            }
        }
    }

    @Override // com.baidu.tieba.hka.b
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            hka.b bVar = this.d;
            if (bVar != null) {
                return bVar.o();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.hka.b
    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            hka.b bVar = this.d;
            if (bVar != null) {
                return bVar.p();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.hka.b
    public void q() {
        hka.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (bVar = this.d) != null) {
            bVar.q();
        }
    }

    @Override // com.baidu.tieba.hka.b
    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            hka.b bVar = this.d;
            if (bVar != null) {
                return bVar.r();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.hka.b
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            q();
            this.d = null;
            hka.b bVar = this.b;
            if (bVar != null) {
                bVar.release();
            }
            hka.b bVar2 = this.c;
            if (bVar2 != null) {
                bVar2.release();
            }
            k = null;
            this.f = null;
            this.g = null;
            this.j = null;
        }
    }

    @Override // com.baidu.tieba.hka.b
    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            hka.b bVar = this.d;
            if (bVar != null) {
                return bVar.v();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.hka.b
    public void c(int i, int i2, int i3, int i4) {
        hka.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIII(1048579, this, i, i2, i3, i4) == null) && (bVar = this.d) != null) {
            bVar.c(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.hka.b
    public void t(int i, int i2, int i3, int i4) {
        hka.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIII(1048597, this, i, i2, i3, i4) == null) && (bVar = this.d) != null) {
            bVar.t(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.hka.b
    public void g(int i, int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            this.b.g(i, i2, i3, z);
            hka.b bVar = this.c;
            if (bVar != null) {
                bVar.g(i, i2, i3, z);
            }
        }
    }

    @Override // com.baidu.tieba.hka.b
    public boolean k(SurfaceTexture surfaceTexture, hka.f fVar) {
        InterceptResult invokeLL;
        hka.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, surfaceTexture, fVar)) == null) {
            this.g = surfaceTexture;
            this.f = fVar;
            if (this.e && (bVar = this.c) != null) {
                if (bVar.k(surfaceTexture, fVar)) {
                    return true;
                }
                C();
                hka.b bVar2 = this.d;
                if (bVar2 == null) {
                    return false;
                }
                boolean k2 = bVar2.k(surfaceTexture, fVar);
                if (this.i) {
                    this.i = false;
                    this.d.n();
                }
                return k2;
            }
            hka.b bVar3 = this.b;
            this.d = bVar3;
            if (bVar3 == null) {
                return false;
            }
            return bVar3.k(surfaceTexture, fVar);
        }
        return invokeLL.booleanValue;
    }
}
