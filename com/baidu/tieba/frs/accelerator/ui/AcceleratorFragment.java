package com.baidu.tieba.frs.accelerator.ui;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.r.t.l;
import c.a.p0.f1.r2.s;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AcceleratorActivityConfig;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.selector.DrawableSelector;
import com.baidu.tbadk.core.view.RoundTbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.accelerator.AcceleratorData;
import com.baidu.tieba.frs.accelerator.PkgNameAndNodeInfoData;
import com.baidu.tieba.frs.accelerator.ui.AcceleratorFragment;
import com.baidu.tieba.frs.accelerator.view.ProgressCircle;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.yunjiasu.tornadosdk.Tornado;
import com.baidu.yunjiasu.tornadosdk.TornadoCallback;
import com.baidu.yunjiasu.tornadosdk.TornadoENV;
import com.baidu.yunjiasu.tornadosdk.TornadoEvent;
import com.baidu.yunjiasu.tornadosdk.TornadoRuntime;
import com.baidu.yunjiasu.tornadosdk.TornadoTokenCallback;
/* loaded from: classes5.dex */
public class AcceleratorFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] G;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public int B;
    public boolean C;
    public Runnable D;
    public Runnable E;
    public Runnable F;
    public k a;

    /* renamed from: b  reason: collision with root package name */
    public l f32357b;

    /* renamed from: c  reason: collision with root package name */
    public AcceleratorData f32358c;

    /* renamed from: d  reason: collision with root package name */
    public PkgNameAndNodeInfoData f32359d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f32360e;

    /* renamed from: f  reason: collision with root package name */
    public View f32361f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f32362g;

    /* renamed from: h  reason: collision with root package name */
    public View f32363h;
    public ProgressCircle i;
    public RoundTbImageView j;
    public View k;
    public ViewGroup l;
    public TextView m;
    public ViewGroup n;
    public ViewGroup o;
    public ViewGroup p;
    public TextView q;
    public TextView r;
    public ViewGroup s;
    public TextView t;
    public TextView u;
    public ImageView v;
    public ImageView w;
    public View x;
    public c.a.d.f.m.e y;
    public long z;

    /* loaded from: classes5.dex */
    public class a implements TornadoTokenCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AcceleratorFragment a;

        public a(AcceleratorFragment acceleratorFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {acceleratorFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = acceleratorFragment;
        }

        @Override // com.baidu.yunjiasu.tornadosdk.TornadoTokenCallback
        public void onResult(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (!z) {
                    this.a.X0();
                } else {
                    Tornado.INSTANCE.start(this.a.a.f32366d, this.a.a.f32368f, this.a.a.f32365c);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements TornadoCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AcceleratorFragment a;

        public b(AcceleratorFragment acceleratorFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {acceleratorFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = acceleratorFragment;
        }

        @Override // com.baidu.yunjiasu.tornadosdk.TornadoCallback
        public void onEvent(TornadoEvent tornadoEvent, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, tornadoEvent, str) == null) {
                if (tornadoEvent == TornadoEvent.EVENT_BOOSTER_START_OK) {
                    if (this.a.f32358c != null && this.a.f32358c.getItemData() != null) {
                        TbSingleton.getInstance().recordAcceleratorServer(String.valueOf(this.a.f32358c.getItemData().itemId), this.a.a.f32367e);
                    }
                    this.a.a1(true);
                } else if (tornadoEvent == TornadoEvent.EVENT_BOOSTER_START_FAIL) {
                    this.a.X0();
                } else if (tornadoEvent == TornadoEvent.EVENT_BOOSTER_START_FAIL_WITH_TOKEN_INVALID) {
                    this.a.X0();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AcceleratorFragment a;

        public c(AcceleratorFragment acceleratorFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {acceleratorFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = acceleratorFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.getActivity() == null) {
                return;
            }
            this.a.f32357b.a += 0.002f;
            AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
            this.a.i.setProgress(accelerateInterpolator.getInterpolation(this.a.f32357b.a));
            if (this.a.f32357b.a > 0.99f && !Tornado.INSTANCE.isRunning()) {
                this.a.f32357b.a = 0.99f;
                this.a.i.setIndeterminate(true);
                return;
            }
            if (Tornado.INSTANCE.isRunning()) {
                this.a.f32357b.a = 1.0f;
            }
            if (this.a.f32357b.a >= 1.0f) {
                this.a.f32357b.a = 1.0f;
                this.a.m.setText("100");
                this.a.y.removeCallbacks(this.a.D);
            } else {
                this.a.m.setText(Integer.toString(Math.round(accelerateInterpolator.getInterpolation(this.a.f32357b.a) * 100.0f)));
                this.a.y.postDelayed(this.a.D, 10L);
            }
            try {
                if (this.a.getActivity() == null) {
                    this.a.y.removeCallbacks(this.a.D);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AcceleratorFragment a;

        public d(AcceleratorFragment acceleratorFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {acceleratorFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = acceleratorFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.getActivity() == null) {
                return;
            }
            TornadoRuntime runtimeInfo = Tornado.INSTANCE.getRuntimeInfo();
            if (runtimeInfo != null) {
                this.a.r.setText(this.a.W0((System.currentTimeMillis() - runtimeInfo.getStartTime().longValue()) / 1000));
            }
            this.a.y.postDelayed(this.a.E, 1000L);
            try {
                if (this.a.getActivity() == null) {
                    this.a.y.removeCallbacks(this.a.E);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AcceleratorFragment a;

        public e(AcceleratorFragment acceleratorFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {acceleratorFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = acceleratorFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (!this.a.e1()) {
                        this.a.y.removeCallbacks(this.a.F);
                        Tornado.INSTANCE.stop();
                        this.a.getActivity().finish();
                        return;
                    }
                    this.a.y.postDelayed(this.a.F, 2000L);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AcceleratorFragment a;

        public f(AcceleratorFragment acceleratorFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {acceleratorFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = acceleratorFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.getActivity() == null) {
                return;
            }
            this.a.getActivity().onBackPressed();
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AcceleratorFragment a;

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
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

            public /* synthetic */ void a() {
                this.a.a.c1();
                this.a.a.j1();
            }

            public /* synthetic */ void b(c.a.p0.f1.g1.a.f fVar, c.a.o0.r.t.l lVar, int i, View view) {
                PkgNameAndNodeInfoData pkgNameAndNodeInfoData = c.a.p0.f1.g1.d.a.a(this.a.a.f32358c.getAvailableTornadoNodeInfoList()).get(Integer.valueOf(i));
                this.a.a.f32359d = pkgNameAndNodeInfoData;
                this.a.a.a.f32366d = pkgNameAndNodeInfoData.getNodeInfo().getNodeTag();
                this.a.a.a.f32367e = pkgNameAndNodeInfoData.getNodeInfo().getNodeName();
                fVar.b();
                this.a.a.o1();
                this.a.a.y.postDelayed(new Runnable() { // from class: c.a.p0.f1.g1.c.c
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            AcceleratorFragment.g.a.this.a();
                        }
                    }
                }, 100L);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
                    final c.a.p0.f1.g1.a.f c2 = c.a.p0.f1.g1.a.f.c(this.a.a.getPageContext());
                    c2.e(new l.e() { // from class: c.a.p0.f1.g1.c.b
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // c.a.o0.r.t.l.e
                        public final void onItemClick(l lVar, int i, View view2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, lVar, i, view2) == null) {
                                AcceleratorFragment.g.a.this.b(c2, lVar, i, view2);
                            }
                        }
                    });
                    c2.d(this.a.a.a.f32367e);
                    c2.f(c.a.p0.f1.g1.d.a.b(this.a.a.f32358c.getAvailableTornadoNodeInfoList(), this.a.a.f32358c.getAvailableNodesNum()));
                    c2.g(this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0062));
                    c2.h();
                }
            }
        }

        public g(AcceleratorFragment acceleratorFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {acceleratorFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = acceleratorFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && Tornado.INSTANCE.isRunning()) {
                s.f(this.a.getActivity(), new a(this));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AcceleratorFragment a;

        public h(AcceleratorFragment acceleratorFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {acceleratorFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = acceleratorFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && Tornado.INSTANCE.isRunning()) {
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.a.getPageContext(), new String[]{"com.baidu.tieba://unidispatch/frs?kw=游帮帮"}, true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AcceleratorFragment a;

        public i(AcceleratorFragment acceleratorFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {acceleratorFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = acceleratorFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.o0.l.a.m(this.a.getContext(), "https://tieba.baidu.com/tb/wise/speedup-SDK.html");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AcceleratorFragment a;

        public j(AcceleratorFragment acceleratorFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {acceleratorFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = acceleratorFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.p.setClickable(true);
                this.a.x.setClickable(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f32364b;

        /* renamed from: c  reason: collision with root package name */
        public String f32365c;

        /* renamed from: d  reason: collision with root package name */
        public String f32366d;

        /* renamed from: e  reason: collision with root package name */
        public String f32367e;

        /* renamed from: f  reason: collision with root package name */
        public String f32368f;

        /* renamed from: g  reason: collision with root package name */
        public String f32369g;

        /* renamed from: h  reason: collision with root package name */
        public String f32370h;
        public String i;
        public final /* synthetic */ AcceleratorFragment j;

        public k(AcceleratorFragment acceleratorFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {acceleratorFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = acceleratorFragment;
            this.a = "com.baidu.tieba";
            this.f32364b = "";
            this.f32365c = "";
            this.f32366d = "";
            this.f32367e = "";
            this.f32368f = "";
            this.f32369g = "";
            this.f32370h = "";
            this.i = "";
        }
    }

    /* loaded from: classes5.dex */
    public class l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AcceleratorFragment f32371b;

        public l(AcceleratorFragment acceleratorFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {acceleratorFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32371b = acceleratorFragment;
            this.a = 0.0f;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(484079713, "Lcom/baidu/tieba/frs/accelerator/ui/AcceleratorFragment;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(484079713, "Lcom/baidu/tieba/frs/accelerator/ui/AcceleratorFragment;");
                return;
            }
        }
        G = new String[]{"com.google.android.play.games", "com.google.android.gms", "com.google.android.gsf", "android.uid.system", "com.google.uid.shared", "android.uid.systemui"};
    }

    public AcceleratorFragment() {
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
        this.a = new k(this);
        this.f32357b = new l(this);
        this.y = c.a.d.f.m.e.a();
        this.z = 0L;
        this.D = new c(this);
        this.E = new d(this);
        this.F = new e(this);
    }

    public final String W0(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) ? String.format(getString(R.string.obfuscated_res_0x7f0f0068), Long.valueOf((j2 / 3600) % 24), Long.valueOf((j2 / 60) % 60), Long.valueOf(j2 % 60)) : (String) invokeJ.objValue;
    }

    public final void X0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f32363h.setVisibility(4);
            this.i.setVisibility(4);
            this.j.setVisibility(0);
            this.k.setVisibility(0);
            this.l.setVisibility(4);
            this.n.setVisibility(0);
            this.o.setVisibility(4);
            this.p.setVisibility(0);
            this.r.setVisibility(4);
            this.s.setVisibility(4);
            this.t.setVisibility(0);
            this.u.setVisibility(4);
            this.j.J(this.a.i, 10, false);
            TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0607).into(this.k);
            this.t.setText(R.string.obfuscated_res_0x7f0f0064);
            c.a.p0.f1.g1.d.b.d(this.z);
            this.t.setOnClickListener(new View.OnClickListener() { // from class: c.a.p0.f1.g1.c.a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        AcceleratorFragment.this.f1(view);
                    }
                }
            });
            p1(R.string.obfuscated_res_0x7f0f0055);
            this.x.setClickable(true);
        }
    }

    public final void Y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.y.removeCallbacks(this.E);
            this.y.post(this.E);
        }
    }

    public final void Z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.y.removeCallbacks(this.D);
            this.y.post(this.D);
        }
    }

    public final void a1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f32363h.setVisibility(0);
            this.i.setVisibility(4);
            this.j.setVisibility(0);
            this.k.setVisibility(0);
            this.l.setVisibility(4);
            this.n.setVisibility(4);
            this.o.setVisibility(0);
            this.p.setVisibility(0);
            this.r.setVisibility(0);
            this.s.setVisibility(0);
            this.t.setVisibility(0);
            this.u.setVisibility(0);
            this.j.J(this.a.i, 10, false);
            TBSelector.makeDrawableSelector().setShape(1).gradientLinear(DrawableSelector.TOP_BOTTOM, R.color.CAM_X0503, R.color.CAM_X0609).into(this.k);
            this.t.setText(R.string.obfuscated_res_0x7f0f005e);
            c.a.p0.f1.g1.d.b.b(this.z);
            this.u.setText(R.string.obfuscated_res_0x7f0f0067);
            c.a.p0.f1.g1.d.b.g(this.z);
            this.t.setOnClickListener(new View.OnClickListener() { // from class: c.a.p0.f1.g1.c.d
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        AcceleratorFragment.this.g1(view);
                    }
                }
            });
            this.u.setOnClickListener(new View.OnClickListener() { // from class: c.a.p0.f1.g1.c.f
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        AcceleratorFragment.this.h1(view);
                    }
                }
            });
            k1();
            Y0();
            if (z) {
                s.g(getActivity(), new i(this));
            }
            if (this.z > 0) {
                TbSingleton.getInstance().acceleratorItemId = this.z;
                TbSingleton.getInstance().acceleratorData = this.f32359d;
            }
            this.y.postDelayed(new j(this), 100L);
        }
    }

    public final void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.y.removeCallbacks(this.F);
            this.y.post(this.F);
        }
    }

    public final void c1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f32363h.setVisibility(4);
            this.i.setVisibility(0);
            this.j.setVisibility(4);
            this.k.setVisibility(4);
            this.l.setVisibility(0);
            this.n.setVisibility(4);
            this.o.setVisibility(4);
            this.p.setVisibility(0);
            this.r.setVisibility(4);
            this.s.setVisibility(0);
            this.t.setVisibility(4);
            this.u.setVisibility(4);
            this.f32357b = new l(this);
            this.f32362g.setText(this.a.f32364b);
            this.i.setIndeterminate(false);
            this.i.setProgress(0.0f);
            this.m.setText("0");
            this.q.setText(this.a.f32367e);
            this.f32363h.clearAnimation();
            Z0();
            this.p.setClickable(false);
            this.x.setClickable(false);
        }
    }

    public final void d1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            this.f32360e = (ViewGroup) view;
            this.f32361f = view.findViewById(R.id.obfuscated_res_0x7f090397);
            this.f32362g = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0903a5);
            this.f32363h = view.findViewById(R.id.obfuscated_res_0x7f09039e);
            this.i = (ProgressCircle) view.findViewById(R.id.obfuscated_res_0x7f09039f);
            this.j = (RoundTbImageView) view.findViewById(R.id.obfuscated_res_0x7f09039c);
            this.k = view.findViewById(R.id.obfuscated_res_0x7f09039d);
            this.l = (ViewGroup) view.findViewById(R.id.obfuscated_res_0x7f0903a6);
            this.m = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0903a7);
            this.n = (ViewGroup) view.findViewById(R.id.obfuscated_res_0x7f0903a0);
            this.o = (ViewGroup) view.findViewById(R.id.obfuscated_res_0x7f0903aa);
            this.p = (ViewGroup) view.findViewById(R.id.obfuscated_res_0x7f0903a1);
            this.q = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0903a4);
            this.r = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0903ad);
            this.s = (ViewGroup) view.findViewById(R.id.obfuscated_res_0x7f0903a9);
            this.t = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090399);
            this.u = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09039a);
            this.v = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f0903a2);
            this.w = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f0903a3);
            this.x = view.findViewById(R.id.obfuscated_res_0x7f090398);
            WebPManager.setPureDrawable(this.v, R.drawable.obfuscated_res_0x7f08091a, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL);
            WebPManager.setPureDrawable(this.w, R.drawable.obfuscated_res_0x7f0809cb, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL);
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.t);
            d2.n(R.string.J_X01);
            d2.f(R.color.CAM_X0302);
            c.a.o0.r.v.c d3 = c.a.o0.r.v.c.d(this.u);
            d3.e(R.string.A_X11);
            d3.n(R.string.J_X01);
            d3.f(R.color.CAM_X0101);
            c.a.o0.r.v.c d4 = c.a.o0.r.v.c.d(this.p);
            d4.n(R.string.J_X01);
            d4.f(R.color.CAM_X0613);
            TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0607).into(this.k);
            TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0613).into(this.f32363h);
            this.f32361f.setOnClickListener(new f(this));
            this.p.setOnClickListener(new g(this));
            this.x.setOnClickListener(new h(this));
            c1();
            b1();
        }
    }

    public final boolean e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) getContext().getSystemService("connectivity");
                if (connectivityManager.getActiveNetworkInfo() != null) {
                    return connectivityManager.getActiveNetworkInfo().isConnected();
                }
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public /* synthetic */ void f1(View view) {
        c1();
        j1();
        c.a.p0.f1.g1.d.b.c(this.z);
    }

    public /* synthetic */ void g1(View view) {
        l1(this.a.f32365c);
        c.a.p0.f1.g1.d.b.a(this.z);
    }

    public /* synthetic */ void h1(View view) {
        c.a.p0.f1.g1.d.b.f(this.z);
        s.i(getActivity(), new c.a.p0.f1.g1.c.h(this));
    }

    public final void k1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(1000L);
            scaleAnimation.setRepeatMode(2);
            scaleAnimation.setRepeatCount(-1);
            scaleAnimation.setInterpolator(new DecelerateInterpolator());
            this.f32363h.startAnimation(scaleAnimation);
        }
    }

    public final void l1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            try {
                getContext().startActivity(getContext().getPackageManager().getLaunchIntentForPackage(str));
            } catch (Exception unused) {
                p1(R.string.obfuscated_res_0x7f0f0059);
            }
        }
    }

    public void m1(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, intent) == null) {
            this.f32358c = (AcceleratorData) intent.getSerializableExtra(AcceleratorActivityConfig.ACCELERATOR_DATA);
            this.f32359d = (PkgNameAndNodeInfoData) intent.getSerializableExtra(AcceleratorActivityConfig.NODE_INFO);
            k kVar = new k(this);
            this.a = kVar;
            kVar.f32364b = this.f32358c.getItemData().mTitle;
            this.a.f32365c = this.f32359d.getPackageName();
            this.a.f32369g = TbadkCoreApplication.getInst().getCuidGalaxy2();
            this.a.f32366d = this.f32359d.getNodeInfo().getNodeTag();
            this.a.f32367e = this.f32359d.getNodeInfo().getNodeName();
            this.a.f32368f = this.f32359d.getGameId();
            this.a.f32370h = this.f32358c.getTokenInfo().getToken();
            this.a.i = this.f32358c.getItemData().mIconUrl;
            this.z = this.f32358c.getItemData().itemId;
            this.A = intent.getStringExtra("fid");
            this.B = intent.getIntExtra("source", 0);
            this.C = intent.getBooleanExtra(AcceleratorActivityConfig.IS_NEW_ITEM, false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: n1 */
    public final void j1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            Tornado.INSTANCE.setAllowedPackages(G);
            Tornado.INSTANCE.setToken(this.a.f32370h, new a(this));
        }
    }

    public final void o1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            Tornado.INSTANCE.stop();
            this.y.removeCallbacks(this.D);
            this.y.removeCallbacks(this.E);
            TbSingleton.getInstance().acceleratorItemId = -1L;
            TbSingleton.getInstance().acceleratorData = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048595, this, layoutInflater, viewGroup, bundle)) == null) ? layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d02d8, viewGroup, false) : (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onDestroyView();
            if (!Tornado.INSTANCE.isRunning()) {
                Tornado.INSTANCE.stop();
                Tornado.INSTANCE.release();
            }
            try {
                this.y.removeCallbacks(this.D);
                this.y.removeCallbacks(this.E);
                this.y.removeCallbacks(this.F);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onPause();
            if (getActivity() == null || getActivity().getWindow() == null) {
                return;
            }
            getActivity().getWindow().clearFlags(512);
            getActivity().getWindow().getDecorView().setSystemUiVisibility(0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onResume();
            if (getActivity() != null && getActivity().getWindow() != null) {
                getActivity().getWindow().addFlags(512);
            }
            c.a.p0.f1.g1.d.b.e(this.A, this.z, this.B);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, view, bundle) == null) {
            d1(view);
            if (!e1()) {
                try {
                    getActivity().finish();
                    return;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            Tornado tornado = Tornado.INSTANCE;
            Context applicationContext = requireContext().getApplicationContext();
            k kVar = this.a;
            tornado.init(applicationContext, kVar.a, kVar.f32369g, "tieba", c.a.o0.r.e.d());
            Tornado.INSTANCE.setEnv(TornadoENV.PRINT_LOG, "true");
            Tornado.INSTANCE.setEnv(TornadoENV.ENABLE_DEBUG, "false");
            Tornado.INSTANCE.setCallback(new b(this));
            if (this.C) {
                Tornado.INSTANCE.stop();
                this.y.postDelayed(new Runnable() { // from class: c.a.p0.f1.g1.c.g
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            AcceleratorFragment.this.i1();
                        }
                    }
                }, 100L);
            } else if (Tornado.INSTANCE.isVPNProcessRunning()) {
                if (!Tornado.INSTANCE.isBind()) {
                    if (Tornado.INSTANCE.bind()) {
                        a1(false);
                    } else {
                        Tornado.INSTANCE.stop();
                        this.y.postDelayed(new Runnable() { // from class: c.a.p0.f1.g1.c.e
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    AcceleratorFragment.this.j1();
                                }
                            }
                        }, 100L);
                    }
                } else {
                    a1(false);
                }
            } else {
                j1();
            }
            super.onViewCreated(view, bundle);
        }
    }

    public final void p1(@StringRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            BdTopToast bdTopToast = new BdTopToast(getContext(), 3000);
            bdTopToast.i(false);
            bdTopToast.h(getString(i2));
            bdTopToast.j(this.f32360e);
        }
    }
}
