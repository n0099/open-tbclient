package com.baidu.tieba;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.prologue.business.data.SplashStyleRecorder;
import com.baidu.tieba.of1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ce1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static of1 a(@NonNull ge1 ge1Var) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        int b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ge1Var)) == null) {
            of1.b bVar = new of1.b(ge1Var.j(), ge1Var.g);
            bVar.u(IAdInterListener.AdProdType.PRODUCT_SPLASH);
            boolean z3 = false;
            if (ge1Var.f == 1) {
                z = true;
            } else {
                z = false;
            }
            bVar.i(z);
            bVar.f(b());
            bVar.n(c());
            if (ge1Var.f == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            bVar.p(z2);
            bVar.o(d(ge1Var.m));
            bVar.D(ge1Var.n * 1000);
            bVar.B(1);
            bVar.G(SplashStyleRecorder.a());
            bVar.g(5);
            bVar.z(false);
            bVar.c(ge1Var.l);
            bVar.e(25);
            bVar.d(13);
            bVar.C(72);
            bVar.A(30);
            bVar.F(68);
            bVar.E(30);
            bVar.h(17);
            bVar.r(ge1Var.z);
            if (ge1Var.A == 1) {
                z3 = true;
            }
            bVar.y(z3);
            bVar.b(ge1Var.B);
            bVar.q(ge1Var.f());
            bVar.s("跳转详情页或第三方应用");
            if (ge1Var.l()) {
                b = 47;
            } else {
                b = b() + 39;
            }
            bVar.t(b);
            bVar.k(ge1Var.H);
            bVar.m(ge1Var.G);
            bVar.l(ge1Var.e());
            bVar.j(ge1Var.X);
            bVar.x(ge1Var.i());
            bVar.w(ge1Var.h());
            bVar.v(ge1Var.g());
            return bVar.a();
        }
        return (of1) invokeL.objValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return sd1.a().b();
        }
        return invokeV.intValue;
    }

    @IdRes
    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return sd1.a().c();
        }
        return invokeV.intValue;
    }

    @IdRes
    public static int d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            if (i == 1) {
                return sd1.a().h();
            }
            return sd1.a().g();
        }
        return invokeI.intValue;
    }
}
