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
import com.baidu.tieba.cl2;
import com.baidu.tieba.d72;
import com.baidu.tieba.zc3;
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
/* loaded from: classes3.dex */
public abstract class a72 extends Fragment implements SlideInterceptor {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean F0;
    public transient /* synthetic */ FieldHolder $fh;
    public p A0;
    public boolean B0;
    public l72 C0;
    public double D0;
    public boolean E0;
    public final String b0;
    public Activity c0;
    public vx2 d0;
    public View e0;
    public SwanAppActionBar f0;
    public be4 g0;
    public SwanAppMenuHeaderView h0;
    public View i0;
    public TextView j0;
    public TextView r0;
    public Button s0;
    public AtomicBoolean t0;
    @Nullable
    public vm3 u0;
    public boolean v0;
    public SlideHelper w0;
    public int x0;
    public int y0;
    public o z0;

    /* loaded from: classes3.dex */
    public interface p {
        void a();
    }

    public abstract boolean I();

    public j83 J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return null;
        }
        return (j83) invokeV.objValue;
    }

    public void P2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
        }
    }

    public boolean d2(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048630, this, new Object[]{Double.valueOf(d2)})) == null) ? d2 >= 0.0d && d2 <= 1.0d : invokeCommon.booleanValue;
    }

    public abstract boolean f2();

    public abstract boolean h2();

    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048636, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public void l2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
        }
    }

    public abstract void m2();

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a72 a;

        /* loaded from: classes3.dex */
        public class a implements g92<Boolean> {
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
            @Override // com.baidu.tieba.g92
            /* renamed from: b */
            public void a(Boolean bool) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) && bool.booleanValue()) {
                    this.a.a.k2();
                }
            }
        }

        public g(a72 a72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a72Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (al2.b().c()) {
                    al2.b().f(this.a.c0, new a(this));
                } else {
                    this.a.k2();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a72 a;

        /* loaded from: classes3.dex */
        public class a implements nm3<xc3<zc3.e>> {
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
            @Override // com.baidu.tieba.nm3
            /* renamed from: b */
            public void a(xc3<zc3.e> xc3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xc3Var) == null) {
                    if (!sc3.h(xc3Var)) {
                        this.a.a.p2();
                    } else {
                        this.a.a.t2();
                    }
                }
            }
        }

        public i(a72 a72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a72Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Activity activity;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (activity = this.a.c0) != null && (activity instanceof SwanAppActivity)) {
                u73 b0 = u73.b0();
                if (b0 != null && !TextUtils.isEmpty(b0.getAppId())) {
                    if (hk3.f() && zj4.a().d()) {
                        b0.e0().g(b0.w(), "mapp_emit_app_close", new a(this));
                        return;
                    } else {
                        this.a.p2();
                        return;
                    }
                }
                this.a.C1();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ View c;
        public final /* synthetic */ a72 d;

        /* loaded from: classes3.dex */
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
                this.a.d.r2();
            }
        }

        /* loaded from: classes3.dex */
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
                this.a.d.T2();
            }
        }

        public l(a72 a72Var, boolean z, boolean z2, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a72Var, Boolean.valueOf(z), Boolean.valueOf(z2), view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = a72Var;
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
                a72 a72Var = this.d;
                if (a72Var.s0 == null) {
                    View view2 = this.c;
                    if (view2 == null) {
                        u42.b("SwanAppBaseFragment", "view为null");
                        return;
                    }
                    a72Var.s0 = (Button) view2.findViewById(R.id.obfuscated_res_0x7f09219b);
                }
                this.d.s0.setVisibility(0);
                if (this.a) {
                    this.d.s0.setOnClickListener(new a(this));
                }
                if (!this.b) {
                    return;
                }
                this.d.t0 = new AtomicBoolean(false);
                this.d.s0.setText(R.string.obfuscated_res_0x7f0f13ec);
                this.d.s0.setOnClickListener(new b(this));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a72 a;

        public a(a72 a72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a72Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E1(t33.E());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ a72 b;

        public b(a72 a72Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a72Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a72Var;
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActionBar swanAppActionBar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a72 a72Var = this.b;
                if (a72Var.c0 != null && (swanAppActionBar = a72Var.f0) != null) {
                    if (this.a) {
                        if (a72Var.j0 == null) {
                            a72Var.j0 = new TextView(this.b.c0);
                        }
                        if (!(this.b.j0.getParent() instanceof SwanAppActionBar)) {
                            this.b.j0.setText(R.string.obfuscated_res_0x7f0f0147);
                            a72 a72Var2 = this.b;
                            a72Var2.j0.setTextColor(a72Var2.M1().getColor(17170455));
                            a72 a72Var3 = this.b;
                            a72Var3.f0.addView(a72Var3.j0);
                            return;
                        }
                        return;
                    }
                    TextView textView = a72Var.j0;
                    if (textView != null) {
                        swanAppActionBar.removeView(textView);
                        this.b.j0 = null;
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a72 a;

        public c(a72 a72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a72Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.l2();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements nm3<xc3<zc3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a72 a;

        public d(a72 a72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nm3
        /* renamed from: b */
        public void a(xc3<zc3.e> xc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xc3Var) == null) {
                if (sc3.h(xc3Var)) {
                    this.a.w0.setRegionFactor(0.1d);
                    a72 a72Var = this.a;
                    a72Var.D0 = 0.1d;
                    a72Var.w0.setCanSlide(a72Var.B1());
                    return;
                }
                a72 a72Var2 = this.a;
                a72Var2.w0.setCanSlide(a72Var2.B1());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements SlidingPaneLayout.PanelSlideListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a72 a;

        public e(a72 a72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a72Var;
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelClosed(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.n2();
            }
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelOpened(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                this.a.H1();
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
                this.a.o2(f);
                if (this.a.A0 != null) {
                    this.a.A0.a();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a72 a;

        public f(a72 a72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a72Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                iy2.d();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a72 a;

        public h(a72 a72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a72Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.m2();
                xe3 xe3Var = new xe3();
                xe3Var.e = "menu";
                if (u73.b0() != null && u73.b0().U().d("key_unread_counts_message", 0).intValue() > 0) {
                    xe3Var.g = String.valueOf(1);
                }
                this.a.D1(xe3Var);
                if (this.a.z0 != null) {
                    this.a.z0.a();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements g92<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a72 a;

        public j(a72 a72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.g92
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) && bool.booleanValue()) {
                this.a.C1();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ a72 b;

        public k(a72 a72Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a72Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a72Var;
            this.a = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || sd3.g()) {
                return;
            }
            this.b.F1(this.a, sd3.d(), sd3.f());
        }
    }

    /* loaded from: classes3.dex */
    public class m implements cl2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a72 a;

        public m(a72 a72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a72Var;
        }

        @Override // com.baidu.tieba.cl2.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.C1();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a72 a;

        public n(a72 a72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a72Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.s2();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public long b;
        public Runnable c;
        public final /* synthetic */ a72 d;

        public o(a72 a72Var, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a72Var, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = a72Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947568013, "Lcom/baidu/tieba/a72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947568013, "Lcom/baidu/tieba/a72;");
                return;
            }
        }
        F0 = eo1.a;
    }

    public final boolean B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (M1().getConfiguration().orientation != 2 && Build.VERSION.SDK_INT != 26) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final cl2.b I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return new m(this);
        }
        return (cl2.b) invokeV.objValue;
    }

    public int K1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (TextUtils.isEmpty(u73.g0())) {
                return 0;
            }
            if (se2.n(u73.g0())) {
                return 2;
            }
            return 1;
        }
        return invokeV.intValue;
    }

    @Nullable
    public vm3 L1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.u0;
        }
        return (vm3) invokeV.objValue;
    }

    public final Resources M1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (m0()) {
                return getResources();
            }
            return AppRuntime.getAppContext().getResources();
        }
        return (Resources) invokeV.objValue;
    }

    public SwanAppActionBar N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.f0;
        }
        return (SwanAppActionBar) invokeV.objValue;
    }

    public final void N2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.w0.setSlideListener(new e(this));
        }
    }

    public View O1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.e0;
        }
        return (View) invokeV.objValue;
    }

    public final d72 P1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            Activity activity = this.c0;
            if (activity == null) {
                return null;
            }
            return ((SwanAppActivity) activity).Z();
        }
        return (d72) invokeV.objValue;
    }

    public vx2 Q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.d0;
        }
        return (vx2) invokeV.objValue;
    }

    public boolean Q2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            SwanAppActionBar swanAppActionBar = this.f0;
            if (swanAppActionBar == null) {
                return false;
            }
            swanAppActionBar.g(true);
            return true;
        }
        return invokeV.booleanValue;
    }

    public be4 R1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.g0;
        }
        return (be4) invokeV.objValue;
    }

    public void S1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            db3.f("backtohome", "menu", ht2.U().g());
            xe3 xe3Var = new xe3();
            xe3Var.e = "gohome";
            xe3Var.c = "menu";
            D1(xe3Var);
        }
    }

    public boolean V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            SwanAppActionBar swanAppActionBar = this.f0;
            if (swanAppActionBar == null) {
                return false;
            }
            swanAppActionBar.g(false);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void V2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            n13.e().d(new a(this), "updateCtsView", false);
        }
    }

    public boolean W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.v0;
        }
        return invokeV.booleanValue;
    }

    public boolean b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            Activity activity = this.c0;
            if (!(activity instanceof SwanAppActivity) || ((SwanAppActivity) activity).T() != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            d72 P1 = P1();
            if (P1 == null || P1.k() <= 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            if (this.y0 == -1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean g2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(u73.g0());
        }
        return invokeV.booleanValue;
    }

    public void i2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            this.f0.setLeftHomeViewVisibility(0);
            this.f0.setLeftHomeViewClickListener(new c(this));
        }
    }

    public void k2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            Activity activity = this.c0;
            if (activity instanceof SwanAppActivity) {
                ((SwanAppActivity) activity).r0(2);
            } else if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    public void n2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            R2(false, 1.0f);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048645, this) == null) {
            this.C0.c();
            super.onPause();
        }
    }

    public final void r2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048649, this) == null) {
            Button button = this.s0;
            if (button != null) {
                button.setVisibility(8);
            }
            TextView textView = this.r0;
            if (textView != null) {
                textView.setVisibility(8);
            }
            if (sd3.d()) {
                sd3.l(true);
            }
        }
    }

    public void s2() {
        vm3 vm3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048650, this) == null) && !this.E0 && W1() && (vm3Var = this.u0) != null) {
            vm3Var.l();
        }
    }

    public final void t2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048651, this) == null) {
            String C = ht2.U().C();
            HashMap hashMap = new HashMap();
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, C);
            ht2.U().u(new vh2("closeBtn", hashMap));
        }
    }

    public void x1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048656, this) != null) || this.u0 == null) {
            return;
        }
        z1(this.y0);
    }

    public a72() {
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
        this.v0 = vm3.i;
        this.x0 = 1;
        this.y0 = 1;
        this.B0 = false;
        this.D0 = -1.0d;
        this.E0 = false;
    }

    public void C1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.c0 != null) {
            it2.a().d(false);
            this.c0.moveTaskToBack(true);
            u2();
            ((SwanAppActivity) this.c0).a0(1);
            wl3.b().e(2);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (F0) {
                Log.d("SwanAppBaseFragment", "onDetach");
            }
            this.c0 = null;
            U1(false);
            super.D0();
            try {
                Field declaredField = Fragment.class.getDeclaredField("u");
                declaredField.setAccessible(true);
                declaredField.set(this, null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void T2() {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048617, this) != null) || this.s0 == null) {
            return;
        }
        AtomicBoolean atomicBoolean = this.t0;
        atomicBoolean.set(!atomicBoolean.get());
        boolean z = this.t0.get();
        Button button = this.s0;
        if (z) {
            i2 = R.string.obfuscated_res_0x7f0f13ed;
        } else {
            i2 = R.string.obfuscated_res_0x7f0f13ec;
        }
        button.setText(i2);
        sd3.j(z);
    }

    public final void u2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048653, this) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onClose");
            hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, u73.g0());
            ht2.U().u(new wh2(hashMap));
            u42.i("SwanAppBaseFragment", "onClose");
            xe3 xe3Var = new xe3();
            xe3Var.e = "close";
            D1(xe3Var);
        }
    }

    public void A2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f0.setLeftBackViewVisibility(z);
        }
    }

    public void C2(boolean z) {
        SlideHelper slideHelper;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && (slideHelper = this.w0) != null) {
            if (B1() && z) {
                z2 = true;
            } else {
                z2 = false;
            }
            slideHelper.setCanSlide(z2);
        }
    }

    public final void D1(xe3 xe3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, xe3Var) == null) {
            Activity activity = this.c0;
            if (activity instanceof SwanAppActivity) {
                ((SwanAppActivity) activity).P(xe3Var);
            }
        }
    }

    public void D2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.B0 = z;
        }
    }

    public final void E1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            ol3.e0(new b(this, z));
        }
    }

    public boolean F2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            return G2(i2, "", false);
        }
        return invokeI.booleanValue;
    }

    public void I2(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, pVar) == null) {
            this.A0 = pVar;
        }
    }

    public void J2(double d2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048597, this, new Object[]{Double.valueOf(d2)}) != null) || !d2(d2)) {
            return;
        }
        if (d2(this.D0)) {
            d2 = this.D0;
        }
        this.w0.setRegionFactor(d2);
    }

    public void K2(int i2) {
        Activity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048599, this, i2) == null) && (activity = this.c0) != null) {
            activity.setRequestedOrientation(i2);
        }
    }

    public void L2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.f0.setRightExitViewVisibility(z);
        }
    }

    public void M2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.f0.setRightZoneVisibility(z);
        }
    }

    public void U2(j72 j72Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, j72Var) == null) {
            this.C0.e(j72Var);
        }
    }

    public void W2(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, view2) == null) {
            n13.e().d(new k(this, view2), "updateStabilityDataView", false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void o1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048642, this, z) == null) {
            super.o1(z);
            if (z) {
                s2();
            }
        }
    }

    public void o2(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048643, this, f2) == null) {
            R2(true, f2);
        }
    }

    public void q2(j72 j72Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, j72Var) == null) {
            this.C0.d(j72Var);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void u0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, context) == null) {
            if (F0) {
                Log.d("SwanAppBaseFragment", "onAttach");
            }
            this.C0 = new l72();
            super.u0(context);
            this.c0 = getActivity();
            U1(true);
        }
    }

    public boolean w2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048655, this, i2)) == null) {
            return x2(i2, false);
        }
        return invokeI.booleanValue;
    }

    @Nullable
    public boolean y2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048658, this, str)) == null) {
            return z2(str, false);
        }
        return invokeL.booleanValue;
    }

    public void z1(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048659, this, i2) != null) || this.u0 == null) {
            return;
        }
        A1(i2, false);
    }

    public View G1(View view2, SlideInterceptor slideInterceptor) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, view2, slideInterceptor)) == null) {
            SlideHelper slideHelper = new SlideHelper();
            this.w0 = slideHelper;
            View wrapSlideView = slideHelper.wrapSlideView(view2.getContext(), view2, slideInterceptor);
            this.w0.setFadeColor(0);
            B2();
            N2();
            return wrapSlideView;
        }
        return (View) invokeLL.objValue;
    }

    public boolean H2(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048592, this, str, z)) == null) {
            return G2(SwanAppConfigData.t(str), str, z);
        }
        return invokeLZ.booleanValue;
    }

    public View a2(FrameLayout frameLayout, View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048627, this, frameLayout, view2)) == null) {
            frameLayout.setTag("IMMERSION_LAYOUT_TAG");
            frameLayout.addView(view2);
            this.u0 = new vm3(this.c0, frameLayout);
            x1();
            return frameLayout;
        }
        return (View) invokeLL.objValue;
    }

    public void A1(@ColorInt int i2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) != null) || this.u0 == null) {
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
            z2 = gk3.a(i2);
        }
        this.u0.m(i2, z, z2);
    }

    public void E2(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            SwanAppActionBar swanAppActionBar = this.f0;
            if (swanAppActionBar != null) {
                swanAppActionBar.setActionBarCustom(z, z2);
            }
            if (this.i0 != null) {
                int i2 = 8;
                if (!z && e2()) {
                    i2 = 0;
                }
                this.i0.setVisibility(i2);
            }
        }
    }

    public final void S2(d72 d72Var, float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLF(1048615, this, d72Var, f2) == null) && d72Var != null && d72Var.k() >= 3) {
            ArrayList arrayList = new ArrayList();
            int k2 = d72Var.k() - 3;
            while (true) {
                if (k2 < 0) {
                    break;
                }
                a72 j2 = d72Var.j(k2);
                if (j2.E0) {
                    j2(f2, j2);
                    arrayList.add(j2);
                    k2--;
                } else {
                    j2(f2, j2);
                    arrayList.add(j2);
                    break;
                }
            }
            d72Var.h().p(arrayList);
        }
    }

    public final void j2(float f2, Fragment fragment) {
        View b0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048637, this, new Object[]{Float.valueOf(f2), fragment}) == null) {
            float o2 = ll3.o(this.c0) >> 2;
            float f3 = (f2 * o2) - o2;
            if (fragment != null && (b0 = fragment.b0()) != null) {
                b0.setX(f3);
            }
        }
    }

    public boolean z2(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048660, this, str, z)) == null) {
            SwanAppActionBar swanAppActionBar = this.f0;
            if (swanAppActionBar == null) {
                return false;
            }
            swanAppActionBar.setTitle(str);
            j83 J1 = J1();
            if (J1 != null) {
                J1.b = str;
                J1.g(z);
            }
            u42.i("SwanAppBaseFragment", "page title: " + str);
            return true;
        }
        return invokeLZ.booleanValue;
    }

    public final void B2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            j83 J1 = J1();
            if (J1 != null && (J1.l || J1.m)) {
                u73 b0 = u73.b0();
                if (b0 != null) {
                    b0.e0().g(b0.w(), "scope_disable_swipe_back", new d(this));
                    return;
                } else {
                    this.w0.setCanSlide(B1());
                    return;
                }
            }
            this.w0.setCanSlide(B1());
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048646, this) == null) {
            super.onResume();
            this.C0.b();
            if (F0) {
                Log.d("SwanAppBaseFragment", "onResume");
            }
            if (a0()) {
                s2();
            }
            V2();
            if (this.g0 != null) {
                boolean d2 = br2.y0().d();
                be4 be4Var = this.g0;
                if (d2 != be4Var.p) {
                    be4Var.y();
                    this.g0.p = br2.y0().d();
                }
            }
        }
    }

    public void F1(View view2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{view2, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            ol3.e0(new l(this, z, z2, view2));
        }
    }

    public boolean G2(@ColorInt int i2, String str, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)})) == null) {
            if (this.f0 == null) {
                return false;
            }
            L2(!this.B0);
            j83 J1 = J1();
            if (J1 != null) {
                if (!TextUtils.isEmpty(str)) {
                    J1.c = str;
                }
                J1.g(z);
            }
            int i3 = -16777216;
            if (i2 != -16777216) {
                i3 = -1;
            }
            if (W1() && i3 != this.x0) {
                this.x0 = i3;
                x1();
            }
            return this.f0.f(i2, this.B0);
        }
        return invokeCommon.booleanValue;
    }

    public void H1() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            d72 P1 = P1();
            if (P1 != null && P1.k() != 1) {
                ie3.f(UUID.randomUUID().toString(), 1);
                d72.b i2 = P1.i("navigateBack");
                i2.n(0, 0);
                i2.g();
                i2.a();
                we3 we3Var = new we3();
                we3Var.e = "back";
                if (c2()) {
                    str = "1";
                } else {
                    str = "0";
                }
                we3Var.g = str;
                we3Var.b = "gesture";
                de3.a(we3Var, t73.K().q().W());
                de3.c(we3Var);
                return;
            }
            Activity activity = this.c0;
            if (activity != null) {
                activity.moveTaskToBack(true);
                wl3.b().e(1);
            }
        }
    }

    public void p2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            if (al2.b().c()) {
                al2.b().f(this.c0, new j(this));
            } else if (cl2.a().b()) {
                C1();
            } else {
                bl2 bl2Var = new bl2();
                bl2Var.h();
                if (bl2Var.j()) {
                    cl2.a().c(this.c0, bl2Var.f(), bl2Var.e(), bl2Var, I1());
                    return;
                }
                C1();
                iy2.e().g();
            }
        }
    }

    public boolean O2(FrameLayout frameLayout, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048607, this, new Object[]{frameLayout, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (frameLayout == null) {
                return false;
            }
            frameLayout.setBackgroundColor(i2);
            j83 J1 = J1();
            if (J1 != null) {
                J1.e = i2;
                J1.p = z;
                return true;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final void R2(boolean z, float f2) {
        d72 P1;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Boolean.valueOf(z), Float.valueOf(f2)}) == null) && (P1 = P1()) != null && P1.k() >= 2) {
            a72 j2 = P1.j(P1.k() - 2);
            j2(f2, j2);
            if (z) {
                if (j2.E0) {
                    S2(P1, f2);
                    return;
                } else {
                    P1.h().o(j2);
                    return;
                }
            }
            P1.h().c(j2);
        }
    }

    public boolean x2(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048657, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            SwanAppActionBar swanAppActionBar = this.f0;
            if (swanAppActionBar == null || this.i0 == null) {
                return false;
            }
            this.y0 = i2;
            swanAppActionBar.setBackgroundColor(i2);
            j83 J1 = J1();
            if (J1 != null) {
                J1.a = i2;
                J1.g(z);
            }
            if (W1()) {
                x1();
            }
            if (e2()) {
                this.i0.setVisibility(0);
                return true;
            }
            this.i0.setVisibility(8);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public void T1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            FloatButton c2 = ka3.d().c();
            if (!z) {
                if (c2 != null && c2.getVisibility() == 0) {
                    c2.setVisibility(8);
                }
            } else if (c2 != null && c2.getVisibility() != 0) {
                c2.setVisibility(0);
            }
        }
    }

    public void U1(boolean z) {
        d72 V;
        a72 j2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048618, this, z) == null) && (V = ht2.U().V()) != null) {
            if (z) {
                j2 = V.m();
            } else {
                j2 = V.j(V.k() - 1);
            }
            if (j2 == null) {
                return;
            }
            T1(j2.f2());
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (!b2()) {
                ll3.c(this.c0);
            }
            if (W1() && this.u0 != null && configuration.orientation == 1) {
                getActivity().getWindow().clearFlags(1024);
                ol3.f0(new n(this), 200L);
            }
        }
    }

    public void X1(View view2) {
        j83 f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, view2) == null) {
            Y1(view2);
            SwanAppConfigData s = ht2.U().s();
            if (s == null) {
                if (F0) {
                    Log.d("SwanAppBaseFragment", "config data is null. " + Log.getStackTraceString(new Exception()));
                    return;
                }
                return;
            }
            vx2 vx2Var = this.d0;
            if (vx2Var == null) {
                f2 = s.e;
            } else {
                f2 = ht2.U().f(mb3.c(vx2Var.i(), s));
            }
            w2(f2.a);
            this.f0.setTitle(f2.b);
            this.z0 = new o(this, new f(this));
            if (!(this instanceof SwanAppAdLandingFragment)) {
                F2(SwanAppConfigData.t(f2.c));
            }
            String str = f2.c;
        }
    }

    public void Y1(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048625, this, view2) != null) || view2 == null) {
            return;
        }
        this.f0 = (SwanAppActionBar) view2.findViewById(R.id.obfuscated_res_0x7f090183);
        this.e0 = view2.findViewById(R.id.obfuscated_res_0x7f090184);
        this.i0 = view2.findViewById(R.id.obfuscated_res_0x7f092419);
        this.f0.setLeftBackViewMinWidth(ll3.f(this.c0, 38.0f));
        g gVar = new g(this);
        this.f0.setLeftBackViewClickListener(gVar);
        this.f0.setLeftFloatBackViewClickListener(gVar);
        this.f0.setRightMenuOnClickListener(new h(this));
        this.f0.setRightExitOnClickListener(new i(this));
    }

    public View Z1(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, view2)) == null) {
            if (view2 == null) {
                return null;
            }
            if ("IMMERSION_LAYOUT_TAG".equals(view2.getTag())) {
                return view2;
            }
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            if (viewGroup != null) {
                if ("IMMERSION_LAYOUT_TAG".equals(viewGroup.getTag())) {
                    return viewGroup;
                }
                viewGroup.removeView(view2);
            }
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            a2(frameLayout, view2);
            return frameLayout;
        }
        return (View) invokeL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void v2(int i2, String str) {
        char c2;
        TimeInterpolator linearInterpolator;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048654, this, i2, str) == null) {
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
            vm3 vm3Var = this.u0;
            if (vm3Var != null && vm3Var.e() != null) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.u0.e(), Key.ALPHA, 0.0f, 1.0f);
                ofFloat2.setDuration(j2);
                ofFloat2.setInterpolator(linearInterpolator);
                ofFloat2.start();
            }
        }
    }
}
