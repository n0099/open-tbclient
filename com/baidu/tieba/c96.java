package com.baidu.tieba;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
import com.baidu.tieba.advert.sdk.stretagy.SplashNativePolicy;
import com.baidu.tieba.h76;
import com.baidu.tieba.ul1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c96 implements s96 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gk1 l;
    public static volatile boolean m;
    public static volatile bk1 n;
    public transient /* synthetic */ FieldHolder $fh;
    public int b;
    public volatile AdLoadState c;
    public WeakReference<ViewGroup> d;
    public ex4 e;
    public boolean f;
    public long g;
    public final SplashNativePolicy h;
    public int i;
    public boolean j;
    public String k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947629641, "Lcom/baidu/tieba/c96;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947629641, "Lcom/baidu/tieba/c96;");
        }
    }

    @Override // com.baidu.tieba.s96
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "prologue_gd" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements bk1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c96 a;

        @Override // com.baidu.tieba.bk1
        public boolean c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        public a(c96 c96Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c96Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c96Var;
        }

        @Override // com.baidu.tieba.bk1
        public void a() {
            boolean z;
            boolean z2;
            boolean z3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (s96.a) {
                    System.out.println("IAdSdkSplash prologue ad onclick");
                }
                boolean z4 = true;
                TbSingleton.getInstance().mIsSplashClick = true;
                if (this.a.e != null) {
                    if (c96.l != null && c96.l.b() != null) {
                        if (c96.l.b().optInt(TiebaStatic.Params.AD_TYPE, 0) == 1) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (c96.l.b().optInt("full_type", 0) != 1) {
                            z4 = false;
                        }
                        z = z3;
                        z2 = z4;
                    } else {
                        z = false;
                        z2 = false;
                    }
                    ex4 ex4Var = this.a.e;
                    c96 c96Var = this.a;
                    ex4Var.e(z, z2, c96Var.b, null, fx5.m(c96Var.i), null);
                }
            }
        }

        @Override // com.baidu.tieba.bk1
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                y96.h(y96.b, "1", str, null, 1, 0, this.a.f, this.a.g);
                y96.i(y96.b, "1", str, null, null, null, this.a.g);
                if (s96.a) {
                    PrintStream printStream = System.out;
                    printStream.println("IAdSdkSplash prologue ad loaded failed: " + str);
                }
                if (this.a.e != null) {
                    this.a.e.f(y96.b, false);
                }
                this.a.c = AdLoadState.FAILED;
                h("advert_show", 0);
                if (this.a.h != null) {
                    this.a.h.onSplashEvent(66);
                }
            }
        }

        @Override // com.baidu.tieba.bk1
        public void d() {
            int hashCode;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (s96.a) {
                    System.out.println("IAdSdkSplash prologue ad finish");
                }
                int i = 1;
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 1);
                if (this.a.e == null) {
                    hashCode = 0;
                } else {
                    hashCode = this.a.e.hashCode();
                }
                TiebaStatic.log(param.param(TiebaStatic.Params.OBJ_PARAM2, hashCode));
                StatisticItem param2 = new StatisticItem(TbadkCoreStatisticKey.CLOSE_AD_TIME).param("obj_source", 5).param("obj_type", "a064").param("obj_param1", 2).param(TiebaStatic.Params.OBJ_TO, fx5.m(this.a.i)).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis());
                if (this.a.f) {
                    i = 2;
                }
                param2.param(TiebaStatic.Params.OBJ_PARAM2, i).param(TiebaStatic.Params.SPLASH_UNI, this.a.g).eventStat();
                if (this.a.e != null) {
                    this.a.e.onAdDismiss();
                }
            }
        }

        @Override // com.baidu.tieba.bk1
        public void onAdShow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                if (s96.a) {
                    System.out.println("IAdSdkSplash prologue ad show");
                }
                int i = 0;
                if (this.a.e != null) {
                    this.a.e.g(true, false, this.a.b);
                }
                if (!this.a.j) {
                    this.a.j = true;
                    y96.i(y96.b, "0", null, fx5.m(this.a.i), null, null, this.a.g);
                }
                h("advert_show", 1);
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 0);
                if (this.a.e != null) {
                    i = this.a.e.hashCode();
                }
                TiebaStatic.log(param.param(TiebaStatic.Params.OBJ_PARAM2, i));
            }
        }

        @Override // com.baidu.tieba.bk1
        public void onSkip() {
            int hashCode;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                System.out.println("SplashTes=>PrologueAdSdkSplash=>onSkip");
                if (s96.a) {
                    System.out.println("IAdSdkSplash prologue ad onskip");
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016311, "advertevent://ignore"));
                int i = 2;
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 2);
                if (this.a.e == null) {
                    hashCode = 0;
                } else {
                    hashCode = this.a.e.hashCode();
                }
                TiebaStatic.log(param.param(TiebaStatic.Params.OBJ_PARAM2, hashCode));
                StatisticItem param2 = new StatisticItem(TbadkCoreStatisticKey.CLOSE_AD_TIME).param("obj_source", 5).param("obj_type", "a064").param("obj_param1", 3).param(TiebaStatic.Params.OBJ_TO, fx5.m(this.a.i)).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis());
                if (!this.a.f) {
                    i = 1;
                }
                param2.param(TiebaStatic.Params.OBJ_PARAM2, i).param(TiebaStatic.Params.SPLASH_UNI, this.a.g).eventStat();
            }
        }

        @Override // com.baidu.tieba.bk1
        public void e(mm1 mm1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, mm1Var) == null) {
                if (s96.a) {
                    System.out.println("IAdSdkSplash prologue gd loaded success");
                }
                this.a.c = AdLoadState.SUCCEED;
                if (this.a.e != null) {
                    this.a.e.f(y96.b, true);
                }
                h("advert_load", 1);
                if (this.a.h != null) {
                    if (mm1Var != null) {
                        lk1 a = mm1Var.a();
                        if (a != null) {
                            this.a.k = a.j();
                        }
                        JSONObject b = mm1Var.b();
                        c96 c96Var = this.a;
                        int i = -1;
                        if (b != null) {
                            i = b.optInt("source", -1);
                        }
                        c96Var.i = i;
                        this.a.h.onSplashEvent(65, this.a.i);
                    } else {
                        this.a.h.onSplashEvent(66);
                    }
                }
                y96.h(y96.b, "0", null, fx5.m(this.a.i), 0, 0, this.a.f, this.a.g);
                x96.f(this.a.i, this.a.g);
            }
        }

        @Override // com.baidu.tieba.bk1
        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (s96.a) {
                    System.out.println("IAdSdkSplash prologue ad onAdPlayError");
                }
                if (this.a.e != null) {
                    this.a.e.b("play error");
                }
            }
        }

        @Override // com.baidu.tieba.bk1
        @NonNull
        public ViewGroup g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return (ViewGroup) this.a.d.get();
            }
            return (ViewGroup) invokeV.objValue;
        }

        public final void h(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048583, this, str, i) == null) {
                eh a = fu5.a();
                a.b("type", "prologue");
                a.b("locate", SpeedStatsUtils.UBC_VALUE_SPLASH);
                a.c("switch", Integer.valueOf(r96.d().c()));
                a.c("isSuccess", Integer.valueOf(i));
                BdStatisticsManager.getInstance().debug(str, a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements bk1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c96 a;

        @Override // com.baidu.tieba.bk1
        public boolean c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        public b(c96 c96Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c96Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c96Var;
        }

        @Override // com.baidu.tieba.bk1
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && c96.n != null) {
                c96.n.a();
            }
        }

        @Override // com.baidu.tieba.bk1
        public void d() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && c96.n != null) {
                c96.n.d();
            }
        }

        @Override // com.baidu.tieba.bk1
        public void f() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && c96.n != null) {
                c96.n.f();
            }
        }

        @Override // com.baidu.tieba.bk1
        @NonNull
        public ViewGroup g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                if (c96.n != null) {
                    return c96.n.g();
                }
                return new RelativeLayout(TbadkCoreApplication.getInst().getContext());
            }
            return (ViewGroup) invokeV.objValue;
        }

        @Override // com.baidu.tieba.bk1
        public void onAdShow() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && c96.n != null) {
                c96.n.onAdShow();
            }
        }

        @Override // com.baidu.tieba.bk1
        public void onSkip() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && c96.n != null) {
                c96.n.onSkip();
            }
        }

        @Override // com.baidu.tieba.bk1
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (c96.n == null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("data", str);
                    h76.c().a(this.a.f(), "onAdLoadFailed", hashMap);
                } else if (c96.n != null) {
                    c96.n.b(str);
                }
            }
        }

        @Override // com.baidu.tieba.bk1
        public void e(mm1 mm1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, mm1Var) == null) {
                if (c96.n == null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("data", mm1Var);
                    h76.c().a(this.a.f(), "onAdLoaded", hashMap);
                } else if (c96.n != null) {
                    c96.n.e(mm1Var);
                }
            }
        }
    }

    public c96(SplashNativePolicy splashNativePolicy) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {splashNativePolicy};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = 5;
        this.c = AdLoadState.INIT;
        this.e = null;
        this.f = false;
        this.g = -1L;
        this.i = -1;
        this.j = false;
        this.k = null;
        this.h = splashNativePolicy;
    }

    @Override // com.baidu.tieba.s96
    public void e(hx4 hx4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, hx4Var) == null) && hx4Var != null && hx4Var.b() != null && hx4Var.b().getContext() != null) {
            this.e = hx4Var.a();
            this.f = hx4Var.d();
            this.g = hx4Var.c();
            this.d = new WeakReference<>(hx4Var.b());
            if (n == null) {
                n = new a(this);
            }
            if (m) {
                t();
                m = false;
                return;
            }
            x(n, this.e);
        }
    }

    public static void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            p8.f().g();
        }
    }

    @Override // com.baidu.tieba.s96
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            m = true;
            x(new b(this), null);
        }
    }

    @Override // com.baidu.tieba.s96
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.d.get() != null && this.d.get().getChildCount() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.s96
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return fx5.m(this.i);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s96
    public AdLoadState d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c;
        }
        return (AdLoadState) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s96
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (l != null) {
                l.i();
                l = null;
            }
            n = null;
        }
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return !h76.c().d(f()).isEmpty();
        }
        return invokeV.booleanValue;
    }

    public final void s() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (weakReference = this.d) != null && weakReference.get().getParent() != null && (this.d.get().getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.d.get().getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            this.d.get().setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.s96
    public void show() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || l == null || (weakReference = this.d) == null || weakReference.get() == null || this.c != AdLoadState.SUCCEED) {
            return;
        }
        s();
        this.c = AdLoadState.SHOWED;
        if (s96.a) {
            System.out.println("IAdSdkSplash prologue ad start show");
        }
        try {
            l.o(this.d.get());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (!h76.c().d(f()).isEmpty()) {
                for (h76.a aVar : h76.c().d(f())) {
                    if ("onAdLoaded".equals(aVar.a)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && n != null && !h76.c().d(f()).isEmpty()) {
            for (h76.a aVar : h76.c().d(f())) {
                String str = aVar.a;
                char c = 65535;
                int hashCode = str.hashCode();
                if (hashCode != -610376507) {
                    if (hashCode == 861234439 && str.equals("onAdLoaded")) {
                        c = 0;
                    }
                } else if (str.equals("onAdLoadFailed")) {
                    c = 1;
                }
                if (c != 0) {
                    if (c == 1) {
                        n.b((String) aVar.b.get("data"));
                    }
                } else {
                    n.e((mm1) aVar.b.get("data"));
                }
            }
            h76.c().b(f());
        }
    }

    public final void x(bk1 bk1Var, ex4 ex4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, bk1Var, ex4Var) == null) {
            try {
                Context context = TbadkCoreApplication.getInst().getContext();
                ul1.b bVar = new ul1.b();
                bVar.j(yi.l(context));
                bVar.k(yi.j(context));
                l = new gk1(context, kk1.l(), bVar.i(), bk1Var);
                this.c = AdLoadState.LOADING;
                l.j();
                if (s96.a) {
                    System.out.println("IAdSdkSplash prologue ad start load");
                }
            } catch (OutOfMemoryError unused) {
                TbadkCoreApplication.getInst().onLowMemory();
                if (ex4Var != null) {
                    ex4Var.b("oom");
                }
            }
        }
    }
}
