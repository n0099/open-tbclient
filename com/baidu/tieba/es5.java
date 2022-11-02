package com.baidu.tieba;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
import com.baidu.tieba.advert.sdk.stretagy.SplashNativePolicy;
import com.baidu.tieba.mg1;
import com.baidu.tieba.mq5;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
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
/* loaded from: classes4.dex */
public class es5 implements us5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pe1 l;
    public static volatile boolean m;
    public static volatile ke1 n;
    public transient /* synthetic */ FieldHolder $fh;
    public int b;
    public volatile AdLoadState c;
    public WeakReference<ViewGroup> d;
    public np4 e;
    public boolean f;
    public long g;
    public final SplashNativePolicy h;
    public int i;
    public boolean j;
    public String k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947744930, "Lcom/baidu/tieba/es5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947744930, "Lcom/baidu/tieba/es5;");
        }
    }

    @Override // com.baidu.tieba.us5
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "prologue_gd" : (String) invokeV.objValue;
    }

    /* loaded from: classes4.dex */
    public class a implements ke1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ es5 a;

        @Override // com.baidu.tieba.ke1
        public boolean c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        public a(es5 es5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {es5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = es5Var;
        }

        @Override // com.baidu.tieba.ke1
        public void a() {
            boolean z;
            boolean z2;
            boolean z3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (us5.a) {
                    System.out.println("IAdSdkSplash prologue ad onclick");
                }
                boolean z4 = true;
                TbSingleton.getInstance().mIsSplashClick = true;
                if (this.a.e != null) {
                    if (es5.l != null && es5.l.b() != null) {
                        if (es5.l.b().optInt(TiebaStatic.Params.AD_TYPE, 0) == 1) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (es5.l.b().optInt("full_type", 0) != 1) {
                            z4 = false;
                        }
                        z = z3;
                        z2 = z4;
                    } else {
                        z = false;
                        z2 = false;
                    }
                    np4 np4Var = this.a.e;
                    es5 es5Var = this.a;
                    np4Var.e(z, z2, es5Var.b, null, th5.m(es5Var.i), null);
                }
            }
        }

        @Override // com.baidu.tieba.ke1
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                zs5.k(zs5.b, "1", str, null, 1, 0, this.a.f, this.a.g);
                zs5.l(zs5.b, "1", str, null, null, null, this.a.g);
                if (us5.a) {
                    PrintStream printStream = System.out;
                    printStream.println("IAdSdkSplash prologue ad loaded failed: " + str);
                }
                if (this.a.e != null) {
                    this.a.e.f(zs5.b, false);
                }
                this.a.c = AdLoadState.FAILED;
                h("advert_show", 0);
                if (this.a.h != null) {
                    this.a.h.onSplashEvent(66);
                }
            }
        }

        @Override // com.baidu.tieba.ke1
        public void d() {
            int hashCode;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (us5.a) {
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
                StatisticItem param2 = new StatisticItem(TbadkCoreStatisticKey.CLOSE_AD_TIME).param("obj_source", 5).param("obj_type", "a064").param("obj_param1", 2).param(TiebaStatic.Params.OBJ_TO, th5.m(this.a.i)).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis());
                if (this.a.f) {
                    i = 2;
                }
                param2.param(TiebaStatic.Params.OBJ_PARAM2, i).param(TiebaStatic.Params.SPLASH_UNI, this.a.g).eventStat();
                if (this.a.e != null) {
                    this.a.e.onAdDismiss();
                }
            }
        }

        @Override // com.baidu.tieba.ke1
        public void onAdShow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                if (us5.a) {
                    System.out.println("IAdSdkSplash prologue ad show");
                }
                int i = 0;
                if (this.a.e != null) {
                    this.a.e.g(true, false, this.a.b);
                }
                zs5.a();
                if (!this.a.j) {
                    this.a.j = true;
                    zs5.l(zs5.b, "0", null, th5.m(this.a.i), null, null, this.a.g);
                }
                h("advert_show", 1);
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 0);
                if (this.a.e != null) {
                    i = this.a.e.hashCode();
                }
                TiebaStatic.log(param.param(TiebaStatic.Params.OBJ_PARAM2, i));
            }
        }

        @Override // com.baidu.tieba.ke1
        public void onSkip() {
            int hashCode;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                System.out.println("SplashTes=>PrologueAdSdkSplash=>onSkip");
                if (us5.a) {
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
                StatisticItem param2 = new StatisticItem(TbadkCoreStatisticKey.CLOSE_AD_TIME).param("obj_source", 5).param("obj_type", "a064").param("obj_param1", 3).param(TiebaStatic.Params.OBJ_TO, th5.m(this.a.i)).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis());
                if (!this.a.f) {
                    i = 1;
                }
                param2.param(TiebaStatic.Params.OBJ_PARAM2, i).param(TiebaStatic.Params.SPLASH_UNI, this.a.g).eventStat();
            }
        }

        @Override // com.baidu.tieba.ke1
        public void e(eh1 eh1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, eh1Var) == null) {
                if (us5.a) {
                    System.out.println("IAdSdkSplash prologue gd loaded success");
                }
                this.a.c = AdLoadState.SUCCEED;
                if (this.a.e != null) {
                    this.a.e.f(zs5.b, true);
                }
                h("advert_load", 1);
                if (this.a.h != null) {
                    if (eh1Var != null) {
                        ue1 a = eh1Var.a();
                        if (a != null) {
                            this.a.k = a.f();
                        }
                        JSONObject b = eh1Var.b();
                        es5 es5Var = this.a;
                        int i = -1;
                        if (b != null) {
                            i = b.optInt("source", -1);
                        }
                        es5Var.i = i;
                        this.a.h.onSplashEvent(65, this.a.i);
                    } else {
                        this.a.h.onSplashEvent(66);
                    }
                }
                zs5.k(zs5.b, "0", null, th5.m(this.a.i), 0, 0, this.a.f, this.a.g);
                ys5.f(this.a.i, this.a.g);
            }
        }

        @Override // com.baidu.tieba.ke1
        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (us5.a) {
                    System.out.println("IAdSdkSplash prologue ad onAdPlayError");
                }
                if (this.a.e != null) {
                    this.a.e.b("play error");
                }
            }
        }

        @Override // com.baidu.tieba.ke1
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
                eh a = te5.a();
                a.b("type", "prologue");
                a.b("locate", SpeedStatsUtils.UBC_VALUE_SPLASH);
                a.c(SetImageWatermarkTypeReqMsg.SWITCH, Integer.valueOf(ts5.d().c()));
                a.c("isSuccess", Integer.valueOf(i));
                BdStatisticsManager.getInstance().debug(str, a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ke1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ es5 a;

        @Override // com.baidu.tieba.ke1
        public boolean c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        public b(es5 es5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {es5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = es5Var;
        }

        @Override // com.baidu.tieba.ke1
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && es5.n != null) {
                es5.n.a();
            }
        }

        @Override // com.baidu.tieba.ke1
        public void d() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && es5.n != null) {
                es5.n.d();
            }
        }

        @Override // com.baidu.tieba.ke1
        public void f() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && es5.n != null) {
                es5.n.f();
            }
        }

        @Override // com.baidu.tieba.ke1
        @NonNull
        public ViewGroup g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                if (es5.n != null) {
                    return es5.n.g();
                }
                return new RelativeLayout(TbadkCoreApplication.getInst().getContext());
            }
            return (ViewGroup) invokeV.objValue;
        }

        @Override // com.baidu.tieba.ke1
        public void onAdShow() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && es5.n != null) {
                es5.n.onAdShow();
            }
        }

        @Override // com.baidu.tieba.ke1
        public void onSkip() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && es5.n != null) {
                es5.n.onSkip();
            }
        }

        @Override // com.baidu.tieba.ke1
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (es5.n == null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("data", str);
                    mq5.c().a(this.a.f(), "onAdLoadFailed", hashMap);
                } else if (es5.n != null) {
                    es5.n.b(str);
                }
            }
        }

        @Override // com.baidu.tieba.ke1
        public void e(eh1 eh1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, eh1Var) == null) {
                if (es5.n == null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("data", eh1Var);
                    mq5.c().a(this.a.f(), "onAdLoaded", hashMap);
                } else if (es5.n != null) {
                    es5.n.e(eh1Var);
                }
            }
        }
    }

    public es5(SplashNativePolicy splashNativePolicy) {
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

    @Override // com.baidu.tieba.us5
    public void e(qp4 qp4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, qp4Var) == null) && qp4Var != null && qp4Var.b() != null && qp4Var.b().getContext() != null) {
            this.e = qp4Var.a();
            this.f = qp4Var.d();
            this.g = qp4Var.c();
            this.d = new WeakReference<>(qp4Var.b());
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
            x8.f().g();
        }
    }

    @Override // com.baidu.tieba.us5
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            m = true;
            x(new b(this), null);
        }
    }

    @Override // com.baidu.tieba.us5
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

    @Override // com.baidu.tieba.us5
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return th5.m(this.i);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.us5
    public AdLoadState d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c;
        }
        return (AdLoadState) invokeV.objValue;
    }

    @Override // com.baidu.tieba.us5
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (l != null) {
                l.h();
                l = null;
            }
            n = null;
        }
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return !mq5.c().d(f()).isEmpty();
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

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (!mq5.c().d(f()).isEmpty()) {
                for (mq5.a aVar : mq5.c().d(f())) {
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

    @Override // com.baidu.tieba.us5
    public void show() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || l == null || (weakReference = this.d) == null || weakReference.get() == null || this.c != AdLoadState.SUCCEED) {
            return;
        }
        s();
        this.c = AdLoadState.SHOWED;
        if (us5.a) {
            System.out.println("IAdSdkSplash prologue ad start show");
        }
        l.n(this.d.get());
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && n != null && !mq5.c().d(f()).isEmpty()) {
            for (mq5.a aVar : mq5.c().d(f())) {
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
                    n.e((eh1) aVar.b.get("data"));
                }
            }
            mq5.c().b(f());
        }
    }

    public final void x(ke1 ke1Var, np4 np4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, ke1Var, np4Var) == null) {
            try {
                Context context = TbadkCoreApplication.getInst().getContext();
                mg1.b bVar = new mg1.b();
                bVar.j(xi.l(context));
                bVar.k(xi.j(context));
                l = new pe1(context, te1.l(), bVar.i(), ke1Var);
                this.c = AdLoadState.LOADING;
                l.i();
                if (us5.a) {
                    System.out.println("IAdSdkSplash prologue ad start load");
                }
            } catch (OutOfMemoryError unused) {
                TbadkCoreApplication.getInst().onLowMemory();
                if (np4Var != null) {
                    np4Var.b("oom");
                }
            }
        }
    }
}
