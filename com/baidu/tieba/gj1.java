package com.baidu.tieba;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import com.baidu.prologue.business.data.SplashStyleRecorder;
import com.baidu.tieba.bl1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class gj1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static bl1 a(@NonNull kj1 kj1Var) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        int b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, kj1Var)) == null) {
            bl1.b bVar = new bl1.b(kj1Var.j(), kj1Var.g);
            bVar.t("rsplash");
            boolean z3 = false;
            if (kj1Var.f == 1) {
                z = true;
            } else {
                z = false;
            }
            bVar.i(z);
            bVar.f(b());
            bVar.m(c());
            if (kj1Var.f == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            bVar.o(z2);
            bVar.n(d(kj1Var.m));
            bVar.C(kj1Var.n * 1000);
            bVar.A(1);
            bVar.F(SplashStyleRecorder.a());
            bVar.g(5);
            bVar.y(false);
            bVar.c(kj1Var.l);
            bVar.e(25);
            bVar.d(13);
            bVar.B(72);
            bVar.z(30);
            bVar.E(68);
            bVar.D(30);
            bVar.h(17);
            bVar.q(kj1Var.z);
            if (kj1Var.A == 1) {
                z3 = true;
            }
            bVar.x(z3);
            bVar.b(kj1Var.B);
            bVar.p(kj1Var.f());
            bVar.r("跳转详情页或第三方应用");
            if (kj1Var.l()) {
                b = 47;
            } else {
                b = b() + 39;
            }
            bVar.s(b);
            bVar.j(kj1Var.H);
            bVar.l(kj1Var.G);
            bVar.k(kj1Var.e());
            bVar.w(kj1Var.i());
            bVar.v(kj1Var.h());
            bVar.u(kj1Var.g());
            return bVar.a();
        }
        return (bl1) invokeL.objValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return wi1.a().b();
        }
        return invokeV.intValue;
    }

    @IdRes
    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return wi1.a().c();
        }
        return invokeV.intValue;
    }

    @IdRes
    public static int d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            if (i == 1) {
                return wi1.a().h();
            }
            return wi1.a().g();
        }
        return invokeI.intValue;
    }
}
