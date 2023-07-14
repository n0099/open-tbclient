package com.baidu.tieba;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import com.baidu.prologue.business.data.SplashStyleRecorder;
import com.baidu.tieba.tl1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class hk1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static tl1 a(@NonNull lk1 lk1Var) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        int b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, lk1Var)) == null) {
            tl1.b bVar = new tl1.b(lk1Var.j(), lk1Var.g);
            bVar.u("rsplash");
            boolean z3 = false;
            if (lk1Var.f == 1) {
                z = true;
            } else {
                z = false;
            }
            bVar.i(z);
            bVar.f(b());
            bVar.n(c());
            if (lk1Var.f == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            bVar.p(z2);
            bVar.o(d(lk1Var.m));
            bVar.D(lk1Var.n * 1000);
            bVar.B(1);
            bVar.G(SplashStyleRecorder.a());
            bVar.g(5);
            bVar.z(false);
            bVar.c(lk1Var.l);
            bVar.e(25);
            bVar.d(13);
            bVar.C(72);
            bVar.A(30);
            bVar.F(68);
            bVar.E(30);
            bVar.h(17);
            bVar.r(lk1Var.z);
            if (lk1Var.A == 1) {
                z3 = true;
            }
            bVar.y(z3);
            bVar.b(lk1Var.B);
            bVar.q(lk1Var.f());
            bVar.s("跳转详情页或第三方应用");
            if (lk1Var.l()) {
                b = 47;
            } else {
                b = b() + 39;
            }
            bVar.t(b);
            bVar.k(lk1Var.H);
            bVar.m(lk1Var.G);
            bVar.l(lk1Var.e());
            bVar.j(lk1Var.X);
            bVar.x(lk1Var.i());
            bVar.w(lk1Var.h());
            bVar.v(lk1Var.g());
            return bVar.a();
        }
        return (tl1) invokeL.objValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return xj1.a().b();
        }
        return invokeV.intValue;
    }

    @IdRes
    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return xj1.a().c();
        }
        return invokeV.intValue;
    }

    @IdRes
    public static int d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            if (i == 1) {
                return xj1.a().h();
            }
            return xj1.a().g();
        }
        return invokeI.intValue;
    }
}
