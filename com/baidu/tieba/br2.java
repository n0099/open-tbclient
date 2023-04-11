package com.baidu.tieba;

import android.app.Application;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.adaptation.implementation.DefaultSwanAppBgMusicPlayer;
import com.baidu.swan.apps.adaptation.interfaces.apkfetcher.ISwanApkFetcher;
import com.baidu.tieba.dt1;
import com.baidu.tieba.sr1;
import com.baidu.tieba.vs1;
import com.baidu.tieba.ws1;
import com.baidu.tieba.xt1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
@Autowired
/* loaded from: classes3.dex */
public final class br2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Inject(force = false)
    public static kr1 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            return new it3();
        }
        return (kr1) invokeV.objValue;
    }

    @Inject(force = false)
    public static ut1 A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return new dr1();
        }
        return (ut1) invokeV.objValue;
    }

    @Inject
    public static gc2 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new qt3();
        }
        return (gc2) invokeV.objValue;
    }

    @Inject(force = false)
    public static ff2 B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return new xf2();
        }
        return (ff2) invokeV.objValue;
    }

    @Inject(force = false)
    public static os1 C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return zt3.a();
        }
        return (os1) invokeV.objValue;
    }

    @Inject
    public static as2 C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return new gp4();
        }
        return (as2) invokeV.objValue;
    }

    @Inject
    public static ps1 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return new wo4();
        }
        return (ps1) invokeV.objValue;
    }

    @Inject(force = false)
    public static mt1 D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return new zq1();
        }
        return (mt1) invokeV.objValue;
    }

    @Inject(force = false)
    public static lr1 E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return new qp1();
        }
        return (lr1) invokeV.objValue;
    }

    @Inject(force = false)
    public static nt1 E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return new ft3();
        }
        return (nt1) invokeV.objValue;
    }

    @Inject(force = false)
    public static mr1 F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return r26.a();
        }
        return (mr1) invokeV.objValue;
    }

    @Inject(force = false)
    public static vt1 F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            return new ju1();
        }
        return (vt1) invokeV.objValue;
    }

    @Inject(force = false)
    public static qs1 G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            return new vt3();
        }
        return (qs1) invokeV.objValue;
    }

    @Inject
    public static bs2 G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            return l36.a();
        }
        return (bs2) invokeV.objValue;
    }

    @Inject(force = false)
    public static rs1 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            return f26.a();
        }
        return (rs1) invokeV.objValue;
    }

    @Inject(force = false)
    public static c03 H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            return c03.a;
        }
        return (c03) invokeV.objValue;
    }

    @Inject
    public static ur2 I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            return ac4.a();
        }
        return (ur2) invokeV.objValue;
    }

    @Inject
    public static vr2 J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            return fc4.a();
        }
        return (vr2) invokeV.objValue;
    }

    @Inject(force = false)
    public static wd4 K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            return et3.a();
        }
        return (wd4) invokeV.objValue;
    }

    @Inject(force = false)
    public static vs1 L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            return new vs1.a();
        }
        return (vs1) invokeV.objValue;
    }

    @Inject(force = false)
    public static er1 M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            return e36.a();
        }
        return (er1) invokeV.objValue;
    }

    @Inject(force = false)
    public static ws1 N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            return new ws1.a();
        }
        return (ws1) invokeV.objValue;
    }

    @Inject
    public static xs1 O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
            return ju3.a();
        }
        return (xs1) invokeV.objValue;
    }

    @Inject(force = false)
    public static or1 P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            return new rp1();
        }
        return (or1) invokeV.objValue;
    }

    @Inject(force = false)
    public static ys1 Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) {
            return new rt3();
        }
        return (ys1) invokeV.objValue;
    }

    @Inject(force = false)
    public static zs1 R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            return new oq1();
        }
        return (zs1) invokeV.objValue;
    }

    @Inject
    public static wr2 S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) {
            return k26.a();
        }
        return (wr2) invokeV.objValue;
    }

    @Inject(force = false)
    public static xr2 T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) {
            return i36.a();
        }
        return (xr2) invokeV.objValue;
    }

    @Inject(force = false)
    public static at1 U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) {
            return new qq1();
        }
        return (at1) invokeV.objValue;
    }

    @Inject(force = false)
    public static bt1 V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) {
            return o26.a();
        }
        return (bt1) invokeV.objValue;
    }

    @Inject(force = false)
    public static ct1 W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) {
            return new rq1();
        }
        return (ct1) invokeV.objValue;
    }

    @Inject(force = false)
    public static tr1 X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) {
            return new vp1();
        }
        return (tr1) invokeV.objValue;
    }

    @Inject(force = false)
    public static dt1 Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) {
            return new dt1.a();
        }
        return (dt1) invokeV.objValue;
    }

    @Inject(force = false)
    public static rt1 Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65569, null)) == null) {
            return new br1();
        }
        return (rt1) invokeV.objValue;
    }

    @Inject(force = false)
    public static qt1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) {
            return new ar1();
        }
        return (qt1) invokeV.objValue;
    }

    @Inject(force = false)
    public static ft1 a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) {
            return new sq1();
        }
        return (ft1) invokeV.objValue;
    }

    @Inject(force = false)
    public static ISwanApkFetcher b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) {
            return new ISwanApkFetcher.b();
        }
        return (ISwanApkFetcher) invokeV.objValue;
    }

    @Inject
    public static yr2 b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65573, null)) == null) {
            return b26.a();
        }
        return (yr2) invokeV.objValue;
    }

    public static Application c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65574, null)) == null) {
            return AppRuntime.getApplication();
        }
        return (Application) invokeV.objValue;
    }

    @Inject(force = false)
    public static it1 c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) {
            return new vq1();
        }
        return (it1) invokeV.objValue;
    }

    @Inject(force = false)
    public static sr1 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65576, null)) == null) {
            return new sr1.b();
        }
        return (sr1) invokeV.objValue;
    }

    @Inject(force = false)
    public static pr1 d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65577, null)) == null) {
            return new sp1();
        }
        return (pr1) invokeV.objValue;
    }

    @Inject(force = false)
    public static hr1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65578, null)) == null) {
            return new sq3();
        }
        return (hr1) invokeV.objValue;
    }

    @Inject(force = false)
    public static kt1 e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65579, null)) == null) {
            return new wq1();
        }
        return (kt1) invokeV.objValue;
    }

    @Inject(force = false)
    public static wr1 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65580, null)) == null) {
            return DefaultSwanAppBgMusicPlayer.j();
        }
        return (wr1) invokeV.objValue;
    }

    @Inject
    public static zr2 f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65581, null)) == null) {
            return b36.a();
        }
        return (zr2) invokeV.objValue;
    }

    @Inject(force = false)
    public static xr1 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65582, null)) == null) {
            return new pp1();
        }
        return (xr1) invokeV.objValue;
    }

    @Inject(force = false)
    public static qr1 g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65583, null)) == null) {
            return new ou3();
        }
        return (qr1) invokeV.objValue;
    }

    @Inject
    public static wj3 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65584, null)) == null) {
            return av3.a();
        }
        return (wj3) invokeV.objValue;
    }

    @Inject(force = false)
    public static rr1 h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65585, null)) == null) {
            return so3.a();
        }
        return (rr1) invokeV.objValue;
    }

    @Inject(force = false)
    public static yr1 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65586, null)) == null) {
            return ct3.a();
        }
        return (yr1) invokeV.objValue;
    }

    @Inject(force = false)
    public static vr1 i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65587, null)) == null) {
            return new vc3();
        }
        return (vr1) invokeV.objValue;
    }

    @Inject(force = false)
    public static zr1 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65588, null)) == null) {
            return new wp1();
        }
        return (zr1) invokeV.objValue;
    }

    @Inject(force = false)
    public static as1 j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65589, null)) == null) {
            return ap3.a();
        }
        return (as1) invokeV.objValue;
    }

    @Inject(force = false)
    public static bs1 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65590, null)) == null) {
            return new xp1();
        }
        return (bs1) invokeV.objValue;
    }

    @Inject
    public static rr2 k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65591, null)) == null) {
            return pq3.a();
        }
        return (rr2) invokeV.objValue;
    }

    @Inject(force = false)
    public static cs1 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65592, null)) == null) {
            return new yp1();
        }
        return (cs1) invokeV.objValue;
    }

    @Inject(force = false)
    public static js1 l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65593, null)) == null) {
            return new eq1();
        }
        return (js1) invokeV.objValue;
    }

    @Inject(force = false)
    public static ds1 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65594, null)) == null) {
            return new zp1();
        }
        return (ds1) invokeV.objValue;
    }

    @Inject(force = false)
    public static ns1 m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65595, null)) == null) {
            return new iq1();
        }
        return (ns1) invokeV.objValue;
    }

    @Inject(force = false)
    public static gt1 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65596, null)) == null) {
            return new tq1();
        }
        return (gt1) invokeV.objValue;
    }

    @Inject(force = false)
    public static tr2 n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65597, null)) == null) {
            return new jq1();
        }
        return (tr2) invokeV.objValue;
    }

    @Inject(force = false)
    public static es1 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65598, null)) == null) {
            return d26.a();
        }
        return (es1) invokeV.objValue;
    }

    @Inject(force = false)
    public static ss1 o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65599, null)) == null) {
            return new kq1();
        }
        return (ss1) invokeV.objValue;
    }

    @Inject(force = false)
    public static ir1 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65600, null)) == null) {
            return cv3.a();
        }
        return (ir1) invokeV.objValue;
    }

    @Inject(force = false)
    public static ts1 p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65601, null)) == null) {
            return new lq1();
        }
        return (ts1) invokeV.objValue;
    }

    @Inject(force = false)
    public static fs1 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65602, null)) == null) {
            return new hp3();
        }
        return (fs1) invokeV.objValue;
    }

    @Inject(force = false)
    public static us1 q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65603, null)) == null) {
            return new nq1();
        }
        return (us1) invokeV.objValue;
    }

    @Inject(force = false)
    public static gs1 r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65604, null)) == null) {
            return new bq1();
        }
        return (gs1) invokeV.objValue;
    }

    @Inject(force = false)
    public static ei4 r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65605, null)) == null) {
            return ht3.a();
        }
        return (ei4) invokeV.objValue;
    }

    @Inject(force = false)
    public static sr2 s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65606, null)) == null) {
            return ot3.a();
        }
        return (sr2) invokeV.objValue;
    }

    @Inject(force = false)
    public static et1 s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65607, null)) == null) {
            return fq3.a();
        }
        return (et1) invokeV.objValue;
    }

    @Inject(force = false)
    public static hs1 t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65608, null)) == null) {
            return new cq1();
        }
        return (hs1) invokeV.objValue;
    }

    @Inject(force = false)
    public static ht1 t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65609, null)) == null) {
            return new uq1();
        }
        return (ht1) invokeV.objValue;
    }

    @Inject(force = false)
    public static is1 u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65610, null)) == null) {
            return new dq1();
        }
        return (is1) invokeV.objValue;
    }

    @Inject(force = false)
    public static ot1 u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65611, null)) == null) {
            return new pq1();
        }
        return (ot1) invokeV.objValue;
    }

    @Inject(force = false)
    public static xt1 v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65612, null)) == null) {
            return new xt1.b();
        }
        return (xt1) invokeV.objValue;
    }

    @Inject(force = false)
    public static pt1 v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65613, null)) == null) {
            return e04.a();
        }
        return (pt1) invokeV.objValue;
    }

    @Inject(force = false)
    public static jr1 w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65614, null)) == null) {
            return new op1();
        }
        return (jr1) invokeV.objValue;
    }

    @Inject(force = false)
    public static st1 w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65615, null)) == null) {
            return new qu3();
        }
        return (st1) invokeV.objValue;
    }

    @Inject(force = false)
    public static ks1 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65616, null)) == null) {
            return new fq1();
        }
        return (ks1) invokeV.objValue;
    }

    @Inject(force = false)
    public static tt1 x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65617, null)) == null) {
            return new cr1();
        }
        return (tt1) invokeV.objValue;
    }

    @Inject(force = false)
    public static ls1 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65618, null)) == null) {
            return new gq1();
        }
        return (ls1) invokeV.objValue;
    }

    @Inject(force = false)
    public static fr1 y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65619, null)) == null) {
            return new xq1();
        }
        return (fr1) invokeV.objValue;
    }

    @Inject(force = false)
    public static ms1 z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65620, null)) == null) {
            return new hq1();
        }
        return (ms1) invokeV.objValue;
    }

    @Inject(force = false)
    @Deprecated
    public static lt1 z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65621, null)) == null) {
            return new yq1();
        }
        return (lt1) invokeV.objValue;
    }
}
