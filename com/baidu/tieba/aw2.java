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
import com.baidu.tieba.hr2;
import com.baidu.tieba.t52;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class aw2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public rc4 a;
    public SwanAppMenuHeaderView b;
    public q52 c;
    public Context d;

    /* loaded from: classes5.dex */
    public interface h {
        void onFail();

        void onSuccess();
    }

    /* loaded from: classes5.dex */
    public class a implements pc4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aw2 a;

        public a(aw2 aw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aw2Var;
        }

        @Override // com.baidu.tieba.pc4
        public boolean b(View view2, sc4 sc4Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, sc4Var)) == null) {
                return this.a.v(sc4Var);
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements SwanAppMenuHeaderView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aw2 a;

        public b(aw2 aw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aw2Var;
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

    /* loaded from: classes5.dex */
    public class c implements SwanAppMenuHeaderView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aw2 a;

        public c(aw2 aw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aw2Var;
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

    /* loaded from: classes5.dex */
    public class d implements SwanAppMenuHeaderView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aw2 a;

        public d(aw2 aw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aw2Var;
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

    /* loaded from: classes5.dex */
    public class e implements ei2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aw2 a;

        public e(aw2 aw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aw2Var;
        }

        @Override // com.baidu.tieba.ei2
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && !z) {
                c63 f = c63.f(this.a.d.getApplicationContext(), R.string.obfuscated_res_0x7f0f014a);
                f.l(2);
                f.G();
            }
        }

        @Override // com.baidu.tieba.ei2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c63 f = c63.f(this.a.d, R.string.obfuscated_res_0x7f0f15d5);
                f.l(2);
                f.G();
            }
        }

        @Override // com.baidu.tieba.ei2
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c63 f = c63.f(this.a.d.getApplicationContext(), R.string.obfuscated_res_0x7f0f014b);
                f.l(2);
                f.G();
                this.a.C();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements di2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ aw2 b;

        public f(aw2 aw2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aw2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = aw2Var;
            this.a = str;
        }

        @Override // com.baidu.tieba.di2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c63 f = c63.f(this.b.d, R.string.obfuscated_res_0x7f0f15d5);
                f.l(2);
                f.G();
            }
        }

        @Override // com.baidu.tieba.di2
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && !z) {
                c63 f = c63.f(this.b.d.getApplicationContext(), R.string.obfuscated_res_0x7f0f0193);
                f.l(2);
                f.G();
            }
        }

        @Override // com.baidu.tieba.di2
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                id2.t();
                if (aw2.k(this.b.c.n())) {
                    aw2.p("addmyswan", this.a);
                    return;
                }
                c63 g = c63.g(this.b.d, rp2.l0().f(this.b.d));
                g.l(2);
                g.q(2);
                g.G();
                this.b.C();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class g implements di2 {
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

        @Override // com.baidu.tieba.di2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c63 f = c63.f(this.a.getApplicationContext(), R.string.obfuscated_res_0x7f0f15d5);
                f.l(2);
                f.G();
                h hVar = this.b;
                if (hVar != null) {
                    hVar.onFail();
                }
            }
        }

        @Override // com.baidu.tieba.di2
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (!z) {
                    c63 f = c63.f(this.a.getApplicationContext(), R.string.obfuscated_res_0x7f0f0193);
                    f.l(2);
                    f.G();
                }
                h hVar = this.b;
                if (hVar != null) {
                    hVar.onFail();
                }
            }
        }

        @Override // com.baidu.tieba.di2
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                id2.t();
                if (aw2.k(this.a)) {
                    h hVar = this.b;
                    if (hVar != null) {
                        hVar.onSuccess();
                        return;
                    }
                    return;
                }
                Context applicationContext = this.a.getApplicationContext();
                c63 g = c63.g(applicationContext, rp2.l0().f(applicationContext));
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947629517, "Lcom/baidu/tieba/aw2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947629517, "Lcom/baidu/tieba/aw2;");
                return;
            }
        }
        e = vm1.a;
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b.setAttentionBtnStates(id2.n(j63.K().getAppId()));
        }
    }

    public final boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            fk3.b(this.d).c(kw2.b(ek3.n()));
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
            String P = j63.K().q().P();
            if (TextUtils.isEmpty(P)) {
                return;
            }
            if (id2.n(P)) {
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
            sj3.a(xr2.V().getActivity());
            k32.k("SwanAppMenuHelper", "restart");
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
            sj3.a((SwanAppActivity) context);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public aw2(rc4 rc4Var, q52 q52Var) {
        this(rc4Var, q52Var, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rc4Var, q52Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((rc4) objArr2[0], (q52) objArr2[1], (SwanAppMenuHeaderView) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public aw2(rc4 rc4Var, q52 q52Var, SwanAppMenuHeaderView swanAppMenuHeaderView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rc4Var, q52Var, swanAppMenuHeaderView};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = rc4Var;
        this.b = swanAppMenuHeaderView;
        this.c = q52Var;
        if (q52Var != null) {
            this.d = q52Var.z();
        }
    }

    public static boolean k(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, activity)) == null) {
            return rp2.l0().a(activity);
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
            SwanLauncher.j().m(((SwanAppErrorActivity) activity).z().D());
            if (activity != null) {
                ti3.j(activity);
            }
        }
    }

    public final void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            SwanFavorDataManager h2 = SwanFavorDataManager.h();
            e eVar = new e(this);
            fg2 l = fg2.l();
            l.n(3);
            h2.c(str, eVar, l.k());
            o("deletemyswan");
        }
    }

    public static void h(@NonNull Activity activity, h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, activity, hVar) == null) {
            String P = j63.K().q().P();
            if (TextUtils.isEmpty(P) && hVar != null) {
                hVar.onFail();
            }
            if (!id2.n(P)) {
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
        boolean a2 = rp2.M().a();
        rp2.M().e(!a2);
        if (activity instanceof SwanAppActivity) {
            ((SwanAppActivity) activity).z(rp2.M().a(), true);
        } else if (activity instanceof SwanAppErrorActivity) {
            ((SwanAppErrorActivity) activity).F();
        }
        if (a2) {
            c63 f2 = c63.f(activity.getApplicationContext(), R.string.obfuscated_res_0x7f0f0146);
            f2.m(R.drawable.obfuscated_res_0x7f08015e);
            f2.l(2);
            f2.B();
        } else {
            c63 f3 = c63.f(activity.getApplicationContext(), R.string.obfuscated_res_0x7f0f0147);
            f3.m(R.drawable.obfuscated_res_0x7f0801c2);
            f3.l(2);
            f3.B();
        }
        o("daynightmode");
    }

    public boolean v(sc4 sc4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, sc4Var)) == null) {
            if (this.c != null && this.d != null) {
                int c2 = sc4Var.c();
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
                                                return rp2.K().j(sc4Var);
                                        }
                                    }
                                    ek3.d();
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
                    j(this.c.n());
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
        nd3 nd3Var = new nd3();
        nd3Var.e = str;
        if (!TextUtils.isEmpty(str2)) {
            nd3Var.a("page", str2);
            nd3Var.g = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            nd3Var.b = str3;
        }
        if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
            nd3Var.a(str4, str5);
        }
        SwanAppActivity activity = xr2.V().getActivity();
        if (activity != null) {
            activity.O(nd3Var);
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (e) {
                Log.d("SwanAppMenuHelper", "startAboutFragment");
            }
            t52 W = xr2.V().W();
            if (W == null) {
                c63.f(this.d, R.string.obfuscated_res_0x7f0f01dd).G();
                return;
            }
            t52.b i = W.i("navigateTo");
            i.n(t52.g, t52.i);
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
            t52 R1 = this.c.R1();
            if (R1 == null) {
                c63.f(this.d, R.string.obfuscated_res_0x7f0f01dd).G();
                return;
            }
            t52.b i = R1.i("navigateTo");
            i.n(t52.g, t52.i);
            i.k("authority", null).a();
            o(ShareLoginStat.GetShareListStat.KEY_PERMISSION);
        }
    }

    public final void i() {
        hr2.a T2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (j23.H()) {
                if (e) {
                    Log.d("SwanAppMenuHelper", "in debug mode cannot add shortcut");
                }
                c63.f(this.d.getApplicationContext(), R.string.obfuscated_res_0x7f0f0166).G();
                return;
            }
            if (e) {
                Log.d("SwanAppMenuHelper", "add shortcut");
            }
            if (k63.c0() != null) {
                T2 = k63.c0().X();
            } else {
                T2 = ((SwanAppActivity) this.c.n()).T();
            }
            xb3.i(this.c.z(), T2);
            o("addshortcut");
        }
    }

    public final void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            if (j23.H()) {
                if (e) {
                    Log.d("SwanAppMenuHelper", "in debug mode cannot add favor");
                }
                c63.f(this.d.getApplicationContext(), R.string.obfuscated_res_0x7f0f0165).G();
                return;
            }
            String e2 = ek3.n().e();
            SwanFavorDataManager.h().b(str, new f(this, e2));
            p("addmyswan", e2);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            t52 R1 = this.c.R1();
            if (R1 == null) {
                c63.f(this.d, R.string.obfuscated_res_0x7f0f01dd).G();
                return;
            }
            t52.b i = R1.i("navigateTo");
            i.n(t52.g, t52.i);
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
                    string = this.d.getString(R.string.obfuscated_res_0x7f0f15f6);
                } else {
                    string = this.d.getString(R.string.obfuscated_res_0x7f0f15f5);
                }
                c63 g2 = c63.g(this.d, string);
                g2.l(2);
                g2.G();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void z() {
        k63 q;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048590, this) != null) || this.a == null || this.c == null || this.d == null || (q = j63.K().q()) == null) {
            return;
        }
        q.w();
        this.a.n(new a(this));
        SwanAppMenuHeaderView swanAppMenuHeaderView = this.b;
        if (swanAppMenuHeaderView != null) {
            swanAppMenuHeaderView.setOnMenuHeaderClickListener(new b(this));
            this.b.setAttentionBtnShow(rp2.t().b());
            this.b.setOnAttentionBtnClickListener(new c(this));
            if (!q.x0()) {
                this.b.setOnMenuHeaderLongClickListener(new d(this));
            }
        }
    }
}
