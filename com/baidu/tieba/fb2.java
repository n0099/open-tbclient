package com.baidu.tieba;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.appframework.AppFrameworkConstants;
import com.baidu.searchbox.appframework.fragment.BaseFragment;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.widget.SlideHelper;
import com.baidu.searchbox.widget.SlideInterceptor;
import com.baidu.searchbox.widget.SlidingPaneLayout;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.res.ui.FloatButton;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.tieba.eh3;
import com.baidu.tieba.hp2;
import com.baidu.tieba.ib2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public abstract class fb2 extends Fragment implements SlideInterceptor {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean F0;
    public transient /* synthetic */ FieldHolder $fh;
    public p A0;
    public boolean B0;
    public qb2 C0;
    public double D0;
    public boolean E0;
    public final String b0;
    public Activity c0;
    public a23 d0;
    public View e0;
    public SwanAppActionBar f0;
    public gi4 g0;
    public SwanAppMenuHeaderView h0;
    public View i0;
    public TextView j0;
    public TextView r0;
    public Button s0;
    public AtomicBoolean t0;
    @Nullable
    public ar3 u0;
    public boolean v0;
    public SlideHelper w0;
    public int x0;
    public int y0;
    public o z0;

    /* loaded from: classes5.dex */
    public interface p {
        void a();
    }

    public abstract boolean H();

    public oc3 I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return null;
        }
        return (oc3) invokeV.objValue;
    }

    public void O2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
        }
    }

    public boolean c2(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048627, this, new Object[]{Double.valueOf(d2)})) == null) ? d2 >= 0.0d && d2 <= 1.0d : invokeCommon.booleanValue;
    }

    public abstract boolean e2();

    public abstract boolean g2();

    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048634, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public void k2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
        }
    }

    public abstract void l2();

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fb2 a;

        /* loaded from: classes5.dex */
        public class a implements ld2<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ld2
            /* renamed from: b */
            public void a(Boolean bool) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) && bool.booleanValue()) {
                    this.a.a.j2();
                }
            }
        }

        public g(fb2 fb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fb2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (fp2.b().c()) {
                    fp2.b().f(this.a.c0, new a(this));
                } else {
                    this.a.j2();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fb2 a;

        /* loaded from: classes5.dex */
        public class a implements sq3<ch3<eh3.e>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ i a;

            public a(i iVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = iVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.sq3
            /* renamed from: b */
            public void a(ch3<eh3.e> ch3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ch3Var) == null) {
                    if (!xg3.h(ch3Var)) {
                        this.a.a.o2();
                    } else {
                        this.a.a.s2();
                    }
                }
            }
        }

        public i(fb2 fb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fb2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Activity activity;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (activity = this.a.c0) != null && (activity instanceof SwanAppActivity)) {
                zb3 b0 = zb3.b0();
                if (b0 != null && !TextUtils.isEmpty(b0.getAppId())) {
                    if (mo3.f() && eo4.a().d()) {
                        b0.e0().g(b0.w(), "mapp_emit_app_close", new a(this));
                        return;
                    } else {
                        this.a.o2();
                        return;
                    }
                }
                this.a.A1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ View c;
        public final /* synthetic */ fb2 d;

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l a;

            public a(l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = lVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                    return;
                }
                this.a.d.q2();
            }
        }

        /* loaded from: classes5.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l a;

            public b(l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = lVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                    return;
                }
                this.a.d.S2();
            }
        }

        public l(fb2 fb2Var, boolean z, boolean z2, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fb2Var, Boolean.valueOf(z), Boolean.valueOf(z2), view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = fb2Var;
            this.a = z;
            this.b = z2;
            this.c = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.a && !this.b) {
                    return;
                }
                fb2 fb2Var = this.d;
                if (fb2Var.s0 == null) {
                    View view2 = this.c;
                    if (view2 == null) {
                        z82.b("SwanAppBaseFragment", "view为null");
                        return;
                    }
                    fb2Var.s0 = (Button) view2.findViewById(R.id.obfuscated_res_0x7f092251);
                }
                this.d.s0.setVisibility(0);
                if (this.a) {
                    this.d.s0.setOnClickListener(new a(this));
                }
                if (!this.b) {
                    return;
                }
                this.d.t0 = new AtomicBoolean(false);
                this.d.s0.setText(R.string.obfuscated_res_0x7f0f152d);
                this.d.s0.setOnClickListener(new b(this));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fb2 a;

        public a(fb2 fb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fb2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.D1(y73.E());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ fb2 b;

        public b(fb2 fb2Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fb2Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fb2Var;
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActionBar swanAppActionBar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                fb2 fb2Var = this.b;
                if (fb2Var.c0 != null && (swanAppActionBar = fb2Var.f0) != null) {
                    if (this.a) {
                        if (fb2Var.j0 == null) {
                            fb2Var.j0 = new TextView(this.b.c0);
                        }
                        if (!(this.b.j0.getParent() instanceof SwanAppActionBar)) {
                            this.b.j0.setText(R.string.obfuscated_res_0x7f0f016f);
                            fb2 fb2Var2 = this.b;
                            fb2Var2.j0.setTextColor(fb2Var2.L1().getColor(17170455));
                            fb2 fb2Var3 = this.b;
                            fb2Var3.f0.addView(fb2Var3.j0);
                            return;
                        }
                        return;
                    }
                    TextView textView = fb2Var.j0;
                    if (textView != null) {
                        swanAppActionBar.removeView(textView);
                        this.b.j0 = null;
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fb2 a;

        public c(fb2 fb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fb2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.k2();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements sq3<ch3<eh3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fb2 a;

        public d(fb2 fb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fb2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sq3
        /* renamed from: b */
        public void a(ch3<eh3.e> ch3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ch3Var) == null) {
                if (xg3.h(ch3Var)) {
                    this.a.w0.setRegionFactor(0.1d);
                    fb2 fb2Var = this.a;
                    fb2Var.D0 = 0.1d;
                    fb2Var.w0.setCanSlide(fb2Var.z1());
                    return;
                }
                fb2 fb2Var2 = this.a;
                fb2Var2.w0.setCanSlide(fb2Var2.z1());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements SlidingPaneLayout.PanelSlideListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fb2 a;

        public e(fb2 fb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fb2Var;
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelClosed(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.m2();
            }
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelOpened(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                this.a.G1();
            }
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelSlide(View view2, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(Constants.METHOD_SEND_USER_MSG, this, view2, f) == null) {
                View maskView = this.a.w0.getMaskView();
                if (maskView != null) {
                    maskView.setAlpha(1.0f - f);
                }
                this.a.n2(f);
                if (this.a.A0 != null) {
                    this.a.A0.a();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fb2 a;

        public f(fb2 fb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fb2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                n23.d();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fb2 a;

        public h(fb2 fb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fb2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.l2();
                cj3 cj3Var = new cj3();
                cj3Var.e = "menu";
                if (zb3.b0() != null && zb3.b0().U().d("key_unread_counts_message", 0).intValue() > 0) {
                    cj3Var.g = String.valueOf(1);
                }
                this.a.C1(cj3Var);
                if (this.a.z0 != null) {
                    this.a.z0.a();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements ld2<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fb2 a;

        public j(fb2 fb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fb2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ld2
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) && bool.booleanValue()) {
                this.a.A1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ fb2 b;

        public k(fb2 fb2Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fb2Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fb2Var;
            this.a = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || xh3.g()) {
                return;
            }
            this.b.E1(this.a, xh3.d(), xh3.f());
        }
    }

    /* loaded from: classes5.dex */
    public class m implements hp2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fb2 a;

        public m(fb2 fb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fb2Var;
        }

        @Override // com.baidu.tieba.hp2.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.A1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fb2 a;

        public n(fb2 fb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fb2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.r2();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public long b;
        public Runnable c;
        public final /* synthetic */ fb2 d;

        public o(fb2 fb2Var, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fb2Var, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = fb2Var;
            this.a = 0;
            this.b = 0L;
            this.c = runnable;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.b > 1333) {
                    this.b = currentTimeMillis;
                    this.a = 1;
                    return;
                }
                int i = this.a + 1;
                this.a = i;
                if (i == 3) {
                    Runnable runnable = this.c;
                    if (runnable != null) {
                        runnable.run();
                    }
                    this.a = 0;
                    this.b = 0L;
                    return;
                }
                this.b = currentTimeMillis;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947758291, "Lcom/baidu/tieba/fb2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947758291, "Lcom/baidu/tieba/fb2;");
                return;
            }
        }
        F0 = js1.a;
    }

    public final hp2.b H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return new m(this);
        }
        return (hp2.b) invokeV.objValue;
    }

    public int J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (TextUtils.isEmpty(zb3.g0())) {
                return 0;
            }
            if (xi2.n(zb3.g0())) {
                return 2;
            }
            return 1;
        }
        return invokeV.intValue;
    }

    @Nullable
    public ar3 K1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.u0;
        }
        return (ar3) invokeV.objValue;
    }

    public final Resources L1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (l0()) {
                return getResources();
            }
            return AppRuntime.getAppContext().getResources();
        }
        return (Resources) invokeV.objValue;
    }

    public SwanAppActionBar M1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.f0;
        }
        return (SwanAppActionBar) invokeV.objValue;
    }

    public final void M2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.w0.setSlideListener(new e(this));
        }
    }

    public View N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.e0;
        }
        return (View) invokeV.objValue;
    }

    public final ib2 O1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            Activity activity = this.c0;
            if (activity == null) {
                return null;
            }
            return ((SwanAppActivity) activity).Y();
        }
        return (ib2) invokeV.objValue;
    }

    public a23 P1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.d0;
        }
        return (a23) invokeV.objValue;
    }

    public boolean P2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            SwanAppActionBar swanAppActionBar = this.f0;
            if (swanAppActionBar == null) {
                return false;
            }
            swanAppActionBar.g(true);
            return true;
        }
        return invokeV.booleanValue;
    }

    public gi4 Q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.g0;
        }
        return (gi4) invokeV.objValue;
    }

    public void R1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            if3.f("backtohome", "menu", mx2.T().g());
            cj3 cj3Var = new cj3();
            cj3Var.e = "gohome";
            cj3Var.c = "menu";
            C1(cj3Var);
        }
    }

    public boolean U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            SwanAppActionBar swanAppActionBar = this.f0;
            if (swanAppActionBar == null) {
                return false;
            }
            swanAppActionBar.g(false);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void U2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            s53.e().d(new a(this), "updateCtsView", false);
        }
    }

    public boolean V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.v0;
        }
        return invokeV.booleanValue;
    }

    public boolean a2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            Activity activity = this.c0;
            if (!(activity instanceof SwanAppActivity) || ((SwanAppActivity) activity).S() != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            ib2 O1 = O1();
            if (O1 == null || O1.k() <= 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean d2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            if (this.y0 == -1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean f2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(zb3.g0());
        }
        return invokeV.booleanValue;
    }

    public void h2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            this.f0.setLeftHomeViewVisibility(0);
            this.f0.setLeftHomeViewClickListener(new c(this));
        }
    }

    public void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            Activity activity = this.c0;
            if (activity instanceof SwanAppActivity) {
                ((SwanAppActivity) activity).q0(2);
            } else if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    public void m2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            Q2(false, 1.0f);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048643, this) == null) {
            this.C0.c();
            super.onPause();
        }
    }

    public final void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048646, this) == null) {
            Button button = this.s0;
            if (button != null) {
                button.setVisibility(8);
            }
            TextView textView = this.r0;
            if (textView != null) {
                textView.setVisibility(8);
            }
            if (xh3.d()) {
                xh3.l(true);
            }
        }
    }

    public void r2() {
        ar3 ar3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048647, this) == null) && !this.E0 && V1() && (ar3Var = this.u0) != null) {
            ar3Var.l();
        }
    }

    public final void s2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048648, this) == null) {
            String C = mx2.T().C();
            HashMap hashMap = new HashMap();
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, C);
            mx2.T().u(new am2("closeBtn", hashMap));
        }
    }

    public void w1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048653, this) != null) || this.u0 == null) {
            return;
        }
        x1(this.y0);
    }

    public final boolean z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            if (L1().getConfiguration().orientation != 2 && Build.VERSION.SDK_INT != 26) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public fb2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b0 = UUID.randomUUID().toString();
        this.v0 = ar3.i;
        this.x0 = 1;
        this.y0 = 1;
        this.B0 = false;
        this.D0 = -1.0d;
        this.E0 = false;
    }

    public void A1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.c0 != null) {
            nx2.a().d(false);
            this.c0.moveTaskToBack(true);
            t2();
            ((SwanAppActivity) this.c0).Z(1);
            bq3.b().e(2);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (F0) {
                Log.d("SwanAppBaseFragment", "onDetach");
            }
            this.c0 = null;
            T1(false);
            super.C0();
            try {
                Field declaredField = Fragment.class.getDeclaredField("u");
                declaredField.setAccessible(true);
                declaredField.set(this, null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void S2() {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048614, this) != null) || this.s0 == null) {
            return;
        }
        AtomicBoolean atomicBoolean = this.t0;
        atomicBoolean.set(!atomicBoolean.get());
        boolean z = this.t0.get();
        Button button = this.s0;
        if (z) {
            i2 = R.string.obfuscated_res_0x7f0f152e;
        } else {
            i2 = R.string.obfuscated_res_0x7f0f152d;
        }
        button.setText(i2);
        xh3.j(z);
    }

    public final void t2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048650, this) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onClose");
            hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, zb3.g0());
            mx2.T().u(new bm2(hashMap));
            z82.i("SwanAppBaseFragment", "onClose");
            cj3 cj3Var = new cj3();
            cj3Var.e = "close";
            C1(cj3Var);
        }
    }

    public void B2(boolean z) {
        SlideHelper slideHelper;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && (slideHelper = this.w0) != null) {
            if (z1() && z) {
                z2 = true;
            } else {
                z2 = false;
            }
            slideHelper.setCanSlide(z2);
        }
    }

    public final void C1(cj3 cj3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cj3Var) == null) {
            Activity activity = this.c0;
            if (activity instanceof SwanAppActivity) {
                ((SwanAppActivity) activity).O(cj3Var);
            }
        }
    }

    public void C2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.B0 = z;
        }
    }

    public final void D1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            tp3.e0(new b(this, z));
        }
    }

    public boolean E2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            return F2(i2, "", false);
        }
        return invokeI.booleanValue;
    }

    public void H2(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, pVar) == null) {
            this.A0 = pVar;
        }
    }

    public void I2(double d2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048594, this, new Object[]{Double.valueOf(d2)}) != null) || !c2(d2)) {
            return;
        }
        if (c2(this.D0)) {
            d2 = this.D0;
        }
        this.w0.setRegionFactor(d2);
    }

    public void J2(int i2) {
        Activity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048596, this, i2) == null) && (activity = this.c0) != null) {
            activity.setRequestedOrientation(i2);
        }
    }

    public void K2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.f0.setRightExitViewVisibility(z);
        }
    }

    public void L2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.f0.setRightZoneVisibility(z);
        }
    }

    public void T2(ob2 ob2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, ob2Var) == null) {
            this.C0.e(ob2Var);
        }
    }

    public void V2(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, view2) == null) {
            s53.e().d(new k(this, view2), "updateStabilityDataView", false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void n1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048639, this, z) == null) {
            super.n1(z);
            if (z) {
                r2();
            }
        }
    }

    public void n2(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048640, this, f2) == null) {
            Q2(true, f2);
        }
    }

    public void p2(ob2 ob2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, ob2Var) == null) {
            this.C0.d(ob2Var);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void t0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, context) == null) {
            if (F0) {
                Log.d("SwanAppBaseFragment", "onAttach");
            }
            this.C0 = new qb2();
            super.t0(context);
            this.c0 = getActivity();
            T1(true);
        }
    }

    public boolean v2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048652, this, i2)) == null) {
            return w2(i2, false);
        }
        return invokeI.booleanValue;
    }

    public void x1(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048655, this, i2) != null) || this.u0 == null) {
            return;
        }
        y1(i2, false);
    }

    @Nullable
    public boolean x2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048656, this, str)) == null) {
            return y2(str, false);
        }
        return invokeL.booleanValue;
    }

    public void z2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048660, this, z) == null) {
            this.f0.setLeftBackViewVisibility(z);
        }
    }

    public View F1(View view2, SlideInterceptor slideInterceptor) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, view2, slideInterceptor)) == null) {
            SlideHelper slideHelper = new SlideHelper();
            this.w0 = slideHelper;
            View wrapSlideView = slideHelper.wrapSlideView(view2.getContext(), view2, slideInterceptor);
            this.w0.setFadeColor(0);
            A2();
            M2();
            return wrapSlideView;
        }
        return (View) invokeLL.objValue;
    }

    public boolean G2(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048589, this, str, z)) == null) {
            return F2(SwanAppConfigData.t(str), str, z);
        }
        return invokeLZ.booleanValue;
    }

    public View Z1(FrameLayout frameLayout, View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048624, this, frameLayout, view2)) == null) {
            frameLayout.setTag(BaseFragment.IMMERSION_LAYOUT_TAG);
            frameLayout.addView(view2);
            this.u0 = new ar3(this.c0, frameLayout);
            w1();
            return frameLayout;
        }
        return (View) invokeLL.objValue;
    }

    public final void A2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            oc3 I1 = I1();
            if (I1 != null && (I1.l || I1.m)) {
                zb3 b0 = zb3.b0();
                if (b0 != null) {
                    b0.e0().g(b0.w(), "scope_disable_swipe_back", new d(this));
                    return;
                } else {
                    this.w0.setCanSlide(z1());
                    return;
                }
            }
            this.w0.setCanSlide(z1());
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048644, this) == null) {
            super.onResume();
            this.C0.b();
            if (F0) {
                Log.d("SwanAppBaseFragment", "onResume");
            }
            if (Z()) {
                r2();
            }
            U2();
            if (this.g0 != null) {
                boolean d2 = gv2.y0().d();
                gi4 gi4Var = this.g0;
                if (d2 != gi4Var.p) {
                    gi4Var.y();
                    this.g0.p = gv2.y0().d();
                }
            }
        }
    }

    public void D2(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            SwanAppActionBar swanAppActionBar = this.f0;
            if (swanAppActionBar != null) {
                swanAppActionBar.setActionBarCustom(z, z2);
            }
            if (this.i0 != null) {
                int i2 = 8;
                if (!z && d2()) {
                    i2 = 0;
                }
                this.i0.setVisibility(i2);
            }
        }
    }

    public final void R2(ib2 ib2Var, float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLF(1048612, this, ib2Var, f2) == null) && ib2Var != null && ib2Var.k() >= 3) {
            ArrayList arrayList = new ArrayList();
            int k2 = ib2Var.k() - 3;
            while (true) {
                if (k2 < 0) {
                    break;
                }
                fb2 j2 = ib2Var.j(k2);
                if (j2.E0) {
                    i2(f2, j2);
                    arrayList.add(j2);
                    k2--;
                } else {
                    i2(f2, j2);
                    arrayList.add(j2);
                    break;
                }
            }
            ib2Var.h().p(arrayList);
        }
    }

    public final void i2(float f2, Fragment fragment) {
        View b0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048633, this, new Object[]{Float.valueOf(f2), fragment}) == null) {
            float o2 = qp3.o(this.c0) >> 2;
            float f3 = (f2 * o2) - o2;
            if (fragment != null && (b0 = fragment.b0()) != null) {
                b0.setX(f3);
            }
        }
    }

    public void y1(@ColorInt int i2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048657, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) != null) || this.u0 == null) {
            return;
        }
        this.y0 = i2;
        int i3 = this.x0;
        boolean z2 = true;
        if (i3 != 1) {
            if (i3 != -16777216) {
                z2 = false;
            }
        } else {
            z2 = lo3.a(i2);
        }
        this.u0.m(i2, z, z2);
    }

    public boolean y2(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048658, this, str, z)) == null) {
            SwanAppActionBar swanAppActionBar = this.f0;
            if (swanAppActionBar == null) {
                return false;
            }
            swanAppActionBar.setTitle(str);
            oc3 I1 = I1();
            if (I1 != null) {
                I1.b = str;
                I1.g(z);
            }
            z82.i("SwanAppBaseFragment", "page title: " + str);
            return true;
        }
        return invokeLZ.booleanValue;
    }

    public void E1(View view2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{view2, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            tp3.e0(new l(this, z, z2, view2));
        }
    }

    public boolean F2(@ColorInt int i2, String str, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)})) == null) {
            if (this.f0 == null) {
                return false;
            }
            K2(!this.B0);
            oc3 I1 = I1();
            if (I1 != null) {
                if (!TextUtils.isEmpty(str)) {
                    I1.c = str;
                }
                I1.g(z);
            }
            int i3 = -16777216;
            if (i2 != -16777216) {
                i3 = -1;
            }
            if (V1() && i3 != this.x0) {
                this.x0 = i3;
                w1();
            }
            return this.f0.f(i2, this.B0);
        }
        return invokeCommon.booleanValue;
    }

    public void G1() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            ib2 O1 = O1();
            if (O1 != null && O1.k() != 1) {
                ni3.f(UUID.randomUUID().toString(), 1);
                ib2.b i2 = O1.i("navigateBack");
                i2.n(0, 0);
                i2.g();
                i2.a();
                bj3 bj3Var = new bj3();
                bj3Var.e = "back";
                if (b2()) {
                    str = "1";
                } else {
                    str = "0";
                }
                bj3Var.g = str;
                bj3Var.b = AppFrameworkConstants.VALUE_GESTURE_BACK;
                ii3.a(bj3Var, yb3.K().q().W());
                ii3.c(bj3Var);
                return;
            }
            Activity activity = this.c0;
            if (activity != null) {
                activity.moveTaskToBack(true);
                bq3.b().e(1);
            }
        }
    }

    public void o2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            if (fp2.b().c()) {
                fp2.b().f(this.c0, new j(this));
            } else if (hp2.a().b()) {
                A1();
            } else {
                gp2 gp2Var = new gp2();
                gp2Var.h();
                if (gp2Var.j()) {
                    hp2.a().c(this.c0, gp2Var.f(), gp2Var.e(), gp2Var, H1());
                    return;
                }
                A1();
                n23.e().g();
            }
        }
    }

    public boolean N2(FrameLayout frameLayout, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048604, this, new Object[]{frameLayout, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (frameLayout == null) {
                return false;
            }
            frameLayout.setBackgroundColor(i2);
            oc3 I1 = I1();
            if (I1 != null) {
                I1.e = i2;
                I1.p = z;
                return true;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final void Q2(boolean z, float f2) {
        ib2 O1;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{Boolean.valueOf(z), Float.valueOf(f2)}) == null) && (O1 = O1()) != null && O1.k() >= 2) {
            fb2 j2 = O1.j(O1.k() - 2);
            i2(f2, j2);
            if (z) {
                if (j2.E0) {
                    R2(O1, f2);
                    return;
                } else {
                    O1.h().o(j2);
                    return;
                }
            }
            O1.h().c(j2);
        }
    }

    public boolean w2(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048654, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            SwanAppActionBar swanAppActionBar = this.f0;
            if (swanAppActionBar == null || this.i0 == null) {
                return false;
            }
            this.y0 = i2;
            swanAppActionBar.setBackgroundColor(i2);
            oc3 I1 = I1();
            if (I1 != null) {
                I1.a = i2;
                I1.g(z);
            }
            if (V1()) {
                w1();
            }
            if (d2()) {
                this.i0.setVisibility(0);
                return true;
            }
            this.i0.setVisibility(8);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public void S1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            FloatButton c2 = pe3.d().c();
            if (!z) {
                if (c2 != null && c2.getVisibility() == 0) {
                    c2.setVisibility(8);
                }
            } else if (c2 != null && c2.getVisibility() != 0) {
                c2.setVisibility(0);
            }
        }
    }

    public void T1(boolean z) {
        ib2 U;
        fb2 j2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048615, this, z) == null) && (U = mx2.T().U()) != null) {
            if (z) {
                j2 = U.m();
            } else {
                j2 = U.j(U.k() - 1);
            }
            if (j2 == null) {
                return;
            }
            S1(j2.e2());
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (!a2()) {
                qp3.c(this.c0);
            }
            if (V1() && this.u0 != null && configuration.orientation == 1) {
                getActivity().getWindow().clearFlags(1024);
                tp3.f0(new n(this), 200L);
            }
        }
    }

    public void W1(View view2) {
        oc3 f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, view2) == null) {
            X1(view2);
            SwanAppConfigData s = mx2.T().s();
            if (s == null) {
                if (F0) {
                    Log.d("SwanAppBaseFragment", "config data is null. " + Log.getStackTraceString(new Exception()));
                    return;
                }
                return;
            }
            a23 a23Var = this.d0;
            if (a23Var == null) {
                f2 = s.e;
            } else {
                f2 = mx2.T().f(rf3.c(a23Var.i(), s));
            }
            v2(f2.a);
            this.f0.setTitle(f2.b);
            this.z0 = new o(this, new f(this));
            if (!(this instanceof SwanAppAdLandingFragment)) {
                E2(SwanAppConfigData.t(f2.c));
            }
            String str = f2.c;
        }
    }

    public void X1(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048622, this, view2) != null) || view2 == null) {
            return;
        }
        this.f0 = (SwanAppActionBar) view2.findViewById(R.id.obfuscated_res_0x7f09018f);
        this.e0 = view2.findViewById(R.id.obfuscated_res_0x7f090190);
        this.i0 = view2.findViewById(R.id.obfuscated_res_0x7f0924d5);
        this.f0.setLeftBackViewMinWidth(qp3.f(this.c0, 38.0f));
        g gVar = new g(this);
        this.f0.setLeftBackViewClickListener(gVar);
        this.f0.setLeftFloatBackViewClickListener(gVar);
        this.f0.setRightMenuOnClickListener(new h(this));
        this.f0.setRightExitOnClickListener(new i(this));
    }

    public View Y1(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, view2)) == null) {
            if (view2 == null) {
                return null;
            }
            if (BaseFragment.IMMERSION_LAYOUT_TAG.equals(view2.getTag())) {
                return view2;
            }
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            if (viewGroup != null) {
                if (BaseFragment.IMMERSION_LAYOUT_TAG.equals(viewGroup.getTag())) {
                    return viewGroup;
                }
                viewGroup.removeView(view2);
            }
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            Z1(frameLayout, view2);
            return frameLayout;
        }
        return (View) invokeL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void u2(int i2, String str) {
        char c2;
        TimeInterpolator linearInterpolator;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048651, this, i2, str) == null) {
            switch (str.hashCode()) {
                case -1965087616:
                    if (str.equals("easeOut")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1310316109:
                    if (str.equals("easeIn")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1102672091:
                    if (str.equals(Easing.LINEAR_NAME)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1330629787:
                    if (str.equals("easeInOut")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        if (c2 != 3) {
                            linearInterpolator = new LinearInterpolator();
                        } else {
                            linearInterpolator = new AccelerateDecelerateInterpolator();
                        }
                    } else {
                        linearInterpolator = new DecelerateInterpolator();
                    }
                } else {
                    linearInterpolator = new AccelerateInterpolator();
                }
            } else {
                linearInterpolator = new LinearInterpolator();
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f0, Key.ALPHA, 0.0f, 1.0f);
            long j2 = i2;
            ofFloat.setDuration(j2);
            ofFloat.setInterpolator(linearInterpolator);
            ofFloat.start();
            ar3 ar3Var = this.u0;
            if (ar3Var != null && ar3Var.e() != null) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.u0.e(), Key.ALPHA, 0.0f, 1.0f);
                ofFloat2.setDuration(j2);
                ofFloat2.setInterpolator(linearInterpolator);
                ofFloat2.start();
            }
        }
    }
}
