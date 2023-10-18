package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.net.http.Headers;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView;
import com.baidu.tieba.mq2;
import com.baidu.tieba.y42;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class fv2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public wb4 a;
    public SwanAppMenuHeaderView b;
    public v42 c;
    public Context d;

    /* loaded from: classes6.dex */
    public interface h {
        void onFail();

        void onSuccess();
    }

    /* loaded from: classes6.dex */
    public class a implements ub4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fv2 a;

        public a(fv2 fv2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fv2Var;
        }

        @Override // com.baidu.tieba.ub4
        public boolean b(View view2, xb4 xb4Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, xb4Var)) == null) {
                return this.a.v(xb4Var);
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements SwanAppMenuHeaderView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fv2 a;

        public b(fv2 fv2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fv2Var;
        }

        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.e
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a.f();
                this.a.A();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements SwanAppMenuHeaderView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fv2 a;

        public c(fv2 fv2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fv2Var;
        }

        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.e
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a.f();
                this.a.u();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements SwanAppMenuHeaderView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fv2 a;

        public d(fv2 fv2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fv2Var;
        }

        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.f
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                this.a.a.f();
                return this.a.w();
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class e implements jh2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fv2 a;

        public e(fv2 fv2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fv2Var;
        }

        @Override // com.baidu.tieba.jh2
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && !z) {
                h53 f = h53.f(this.a.d.getApplicationContext(), R.string.obfuscated_res_0x7f0f0142);
                f.l(2);
                f.G();
            }
        }

        @Override // com.baidu.tieba.jh2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h53 f = h53.f(this.a.d, R.string.obfuscated_res_0x7f0f15ad);
                f.l(2);
                f.G();
            }
        }

        @Override // com.baidu.tieba.jh2
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                h53 f = h53.f(this.a.d.getApplicationContext(), R.string.obfuscated_res_0x7f0f0143);
                f.l(2);
                f.G();
                this.a.C();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements ih2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ fv2 b;

        public f(fv2 fv2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fv2Var;
            this.a = str;
        }

        @Override // com.baidu.tieba.ih2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h53 f = h53.f(this.b.d, R.string.obfuscated_res_0x7f0f15ad);
                f.l(2);
                f.G();
            }
        }

        @Override // com.baidu.tieba.ih2
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && !z) {
                h53 f = h53.f(this.b.d.getApplicationContext(), R.string.obfuscated_res_0x7f0f018b);
                f.l(2);
                f.G();
            }
        }

        @Override // com.baidu.tieba.ih2
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                nc2.t();
                if (fv2.k(this.b.c.m())) {
                    fv2.p("addmyswan", this.a);
                    return;
                }
                h53 g = h53.g(this.b.d, wo2.l0().f(this.b.d));
                g.l(2);
                g.q(2);
                g.G();
                this.b.C();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class g implements ih2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ h b;

        public g(Activity activity, h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activity;
            this.b = hVar;
        }

        @Override // com.baidu.tieba.ih2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h53 f = h53.f(this.a.getApplicationContext(), R.string.obfuscated_res_0x7f0f15ad);
                f.l(2);
                f.G();
                h hVar = this.b;
                if (hVar != null) {
                    hVar.onFail();
                }
            }
        }

        @Override // com.baidu.tieba.ih2
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (!z) {
                    h53 f = h53.f(this.a.getApplicationContext(), R.string.obfuscated_res_0x7f0f018b);
                    f.l(2);
                    f.G();
                }
                h hVar = this.b;
                if (hVar != null) {
                    hVar.onFail();
                }
            }
        }

        @Override // com.baidu.tieba.ih2
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                nc2.t();
                if (fv2.k(this.a)) {
                    h hVar = this.b;
                    if (hVar != null) {
                        hVar.onSuccess();
                        return;
                    }
                    return;
                }
                Context applicationContext = this.a.getApplicationContext();
                h53 g = h53.g(applicationContext, wo2.l0().f(applicationContext));
                g.l(2);
                g.q(2);
                g.G();
                h hVar2 = this.b;
                if (hVar2 != null) {
                    hVar2.onSuccess();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947777511, "Lcom/baidu/tieba/fv2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947777511, "Lcom/baidu/tieba/fv2;");
                return;
            }
        }
        e = am1.a;
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b.setAttentionBtnStates(nc2.n(o53.K().getAppId()));
        }
    }

    public final boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            kj3.b(this.d).c(pv2.b(jj3.n()));
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.c.T2();
            o("share");
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            String P = o53.K().q().P();
            if (TextUtils.isEmpty(P)) {
                return;
            }
            if (nc2.n(P)) {
                m(P);
            } else {
                l(P);
            }
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            o(Headers.REFRESH);
            xi3.a(cr2.V().getActivity());
            p22.k("SwanAppMenuHelper", "restart");
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (e) {
                Log.d("SwanAppMenuHelper", "restart");
            }
            Context context = this.d;
            if (context == null) {
                return;
            }
            xi3.a((SwanAppActivity) context);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public fv2(wb4 wb4Var, v42 v42Var) {
        this(wb4Var, v42Var, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wb4Var, v42Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((wb4) objArr2[0], (v42) objArr2[1], (SwanAppMenuHeaderView) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public fv2(wb4 wb4Var, v42 v42Var, SwanAppMenuHeaderView swanAppMenuHeaderView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wb4Var, v42Var, swanAppMenuHeaderView};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = wb4Var;
        this.b = swanAppMenuHeaderView;
        this.c = v42Var;
        if (v42Var != null) {
            this.d = v42Var.s();
        }
    }

    public static boolean k(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, activity)) == null) {
            return wo2.l0().a(activity);
        }
        return invokeL.booleanValue;
    }

    public static void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, str) == null) {
            p(str, null);
        }
    }

    public static void t(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65553, null, activity) == null) && (activity instanceof SwanAppErrorActivity)) {
            SwanLauncher.j().m(((SwanAppErrorActivity) activity).y().D());
            if (activity != null) {
                yh3.j(activity);
            }
        }
    }

    public final void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            SwanFavorDataManager h2 = SwanFavorDataManager.h();
            e eVar = new e(this);
            kf2 l = kf2.l();
            l.n(3);
            h2.c(str, eVar, l.k());
            o("deletemyswan");
        }
    }

    public static void h(@NonNull Activity activity, h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, activity, hVar) == null) {
            String P = o53.K().q().P();
            if (TextUtils.isEmpty(P) && hVar != null) {
                hVar.onFail();
            }
            if (!nc2.n(P)) {
                SwanFavorDataManager.h().b(P, new g(activity, hVar));
            } else if (hVar != null) {
                hVar.onSuccess();
            }
        }
    }

    public static void j(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65547, null, activity) != null) || activity == null) {
            return;
        }
        if (e) {
            Log.d("SwanAppMenuHelper", "change night mode");
        }
        boolean a2 = wo2.M().a();
        wo2.M().e(!a2);
        if (activity instanceof SwanAppActivity) {
            ((SwanAppActivity) activity).y(wo2.M().a(), true);
        } else if (activity instanceof SwanAppErrorActivity) {
            ((SwanAppErrorActivity) activity).E();
        }
        if (a2) {
            h53 f2 = h53.f(activity.getApplicationContext(), R.string.obfuscated_res_0x7f0f013e);
            f2.m(R.drawable.obfuscated_res_0x7f080159);
            f2.l(2);
            f2.B();
        } else {
            h53 f3 = h53.f(activity.getApplicationContext(), R.string.obfuscated_res_0x7f0f013f);
            f3.m(R.drawable.obfuscated_res_0x7f0801bd);
            f3.l(2);
            f3.B();
        }
        o("daynightmode");
    }

    public boolean v(xb4 xb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, xb4Var)) == null) {
            if (this.c != null && this.d != null) {
                int c2 = xb4Var.c();
                if (c2 != 4) {
                    if (c2 != 5) {
                        if (c2 != 35) {
                            if (c2 != 49) {
                                if (c2 != 42) {
                                    if (c2 != 43) {
                                        switch (c2) {
                                            case 37:
                                                B();
                                                return true;
                                            case 38:
                                                u();
                                                return true;
                                            case 39:
                                                x();
                                                return true;
                                            default:
                                                return wo2.K().j(xb4Var);
                                        }
                                    }
                                    jj3.d();
                                    return true;
                                }
                                y();
                                return true;
                            }
                            s();
                            return true;
                        }
                        i();
                        return true;
                    }
                    j(this.c.m());
                    return true;
                }
                n();
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void p(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, str, str2) == null) {
            q(str, str2, null);
        }
    }

    public static void q(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65551, null, str, str2, str3) == null) {
            r(str, str2, str3, null, null);
        }
    }

    public static void r(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLLL(65552, null, str, str2, str3, str4, str5) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        sc3 sc3Var = new sc3();
        sc3Var.e = str;
        if (!TextUtils.isEmpty(str2)) {
            sc3Var.a("page", str2);
            sc3Var.g = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            sc3Var.b = str3;
        }
        if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
            sc3Var.a(str4, str5);
        }
        SwanAppActivity activity = cr2.V().getActivity();
        if (activity != null) {
            activity.N(sc3Var);
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (e) {
                Log.d("SwanAppMenuHelper", "startAboutFragment");
            }
            y42 W = cr2.V().W();
            if (W == null) {
                h53.f(this.d, R.string.obfuscated_res_0x7f0f01d5).G();
                return;
            }
            y42.b i = W.i("navigateTo");
            i.n(y42.g, y42.i);
            i.k("about", null).a();
            o("about");
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (e) {
                Log.d("SwanAppMenuHelper", "startSettingFragment");
            }
            y42 S1 = this.c.S1();
            if (S1 == null) {
                h53.f(this.d, R.string.obfuscated_res_0x7f0f01d5).G();
                return;
            }
            y42.b i = S1.i("navigateTo");
            i.n(y42.g, y42.i);
            i.k("authority", null).a();
            o(ShareLoginStat.GetShareListStat.KEY_PERMISSION);
        }
    }

    public final void i() {
        mq2.a S;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (o13.H()) {
                if (e) {
                    Log.d("SwanAppMenuHelper", "in debug mode cannot add shortcut");
                }
                h53.f(this.d.getApplicationContext(), R.string.obfuscated_res_0x7f0f015e).G();
                return;
            }
            if (e) {
                Log.d("SwanAppMenuHelper", "add shortcut");
            }
            if (p53.c0() != null) {
                S = p53.c0().X();
            } else {
                S = ((SwanAppActivity) this.c.m()).S();
            }
            cb3.i(this.c.s(), S);
            o("addshortcut");
        }
    }

    public final void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            if (o13.H()) {
                if (e) {
                    Log.d("SwanAppMenuHelper", "in debug mode cannot add favor");
                }
                h53.f(this.d.getApplicationContext(), R.string.obfuscated_res_0x7f0f015d).G();
                return;
            }
            String e2 = jj3.n().e();
            SwanFavorDataManager.h().b(str, new f(this, e2));
            p("addmyswan", e2);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            y42 S1 = this.c.S1();
            if (S1 == null) {
                h53.f(this.d, R.string.obfuscated_res_0x7f0f01d5).G();
                return;
            }
            y42.b i = S1.i("navigateTo");
            i.n(y42.g, y42.i);
            i.k(AccountConstants.LOGOUT_TYPE_NATIVE_SRC_SETTINGS, null).a();
            o("set");
        }
    }

    public final boolean w() {
        InterceptResult invokeV;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.c != null && this.d != null) {
                if (D()) {
                    string = this.d.getString(R.string.obfuscated_res_0x7f0f15ce);
                } else {
                    string = this.d.getString(R.string.obfuscated_res_0x7f0f15cd);
                }
                h53 g2 = h53.g(this.d, string);
                g2.l(2);
                g2.G();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void z() {
        p53 q;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048590, this) != null) || this.a == null || this.c == null || this.d == null || (q = o53.K().q()) == null) {
            return;
        }
        q.w();
        this.a.n(new a(this));
        SwanAppMenuHeaderView swanAppMenuHeaderView = this.b;
        if (swanAppMenuHeaderView != null) {
            swanAppMenuHeaderView.setOnMenuHeaderClickListener(new b(this));
            this.b.setAttentionBtnShow(wo2.t().b());
            this.b.setOnAttentionBtnClickListener(new c(this));
            if (!q.x0()) {
                this.b.setOnMenuHeaderLongClickListener(new d(this));
            }
        }
    }
}
