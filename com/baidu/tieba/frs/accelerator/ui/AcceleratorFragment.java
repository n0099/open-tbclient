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
import c.a.s0.s.s.j;
import c.a.t0.e1.c1;
import c.a.t0.e1.e1;
import c.a.t0.e1.f1;
import c.a.t0.e1.g1;
import c.a.t0.e1.i1;
import c.a.t0.e1.z2.s;
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
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.yunjiasu.tornadosdk.Tornado;
import com.baidu.yunjiasu.tornadosdk.TornadoCallback;
import com.baidu.yunjiasu.tornadosdk.TornadoENV;
import com.baidu.yunjiasu.tornadosdk.TornadoEvent;
import com.baidu.yunjiasu.tornadosdk.TornadoRuntime;
import com.baidu.yunjiasu.tornadosdk.TornadoTokenCallback;
/* loaded from: classes12.dex */
public class AcceleratorFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] PACKAGES;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView A;
    public View B;
    public c.a.d.f.m.e C;
    public long D;
    public String E;
    public int F;
    public boolean G;
    public Runnable H;
    public Runnable I;
    public Runnable J;

    /* renamed from: e  reason: collision with root package name */
    public k f43184e;

    /* renamed from: f  reason: collision with root package name */
    public l f43185f;

    /* renamed from: g  reason: collision with root package name */
    public AcceleratorData f43186g;

    /* renamed from: h  reason: collision with root package name */
    public PkgNameAndNodeInfoData f43187h;

    /* renamed from: i  reason: collision with root package name */
    public ViewGroup f43188i;

    /* renamed from: j  reason: collision with root package name */
    public View f43189j;
    public TextView k;
    public View l;
    public ProgressCircle m;
    public RoundTbImageView n;
    public View o;
    public ViewGroup p;
    public TextView q;
    public ViewGroup r;
    public ViewGroup s;
    public ViewGroup t;
    public TextView u;
    public TextView v;
    public ViewGroup w;
    public TextView x;
    public TextView y;
    public ImageView z;

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                    this.a.A();
                } else {
                    Tornado.INSTANCE.start(this.a.f43184e.f43201d, this.a.f43184e.f43203f, this.a.f43184e.f43200c);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                    this.a.D(true);
                } else if (tornadoEvent == TornadoEvent.EVENT_BOOSTER_START_FAIL) {
                    this.a.A();
                } else if (tornadoEvent == TornadoEvent.EVENT_BOOSTER_START_FAIL_WITH_TOKEN_INVALID) {
                    this.a.A();
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AcceleratorFragment f43190e;

        public c(AcceleratorFragment acceleratorFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {acceleratorFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43190e = acceleratorFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f43190e.getActivity() == null) {
                return;
            }
            this.f43190e.f43185f.a += 0.002f;
            AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
            this.f43190e.m.setProgress(accelerateInterpolator.getInterpolation(this.f43190e.f43185f.a));
            if (this.f43190e.f43185f.a > 0.99f && !Tornado.INSTANCE.isRunning()) {
                this.f43190e.f43185f.a = 0.99f;
                this.f43190e.m.setIndeterminate(true);
                return;
            }
            if (Tornado.INSTANCE.isRunning()) {
                this.f43190e.f43185f.a = 1.0f;
            }
            if (this.f43190e.f43185f.a >= 1.0f) {
                this.f43190e.f43185f.a = 1.0f;
                this.f43190e.q.setText(HomeCfgResponse.ConfigData.GROUP_LAYOUR_GAP);
                this.f43190e.C.removeCallbacks(this.f43190e.H);
            } else {
                this.f43190e.q.setText(Integer.toString(Math.round(accelerateInterpolator.getInterpolation(this.f43190e.f43185f.a) * 100.0f)));
                this.f43190e.C.postDelayed(this.f43190e.H, 10L);
            }
            try {
                if (this.f43190e.getActivity() == null) {
                    this.f43190e.C.removeCallbacks(this.f43190e.H);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AcceleratorFragment f43191e;

        public d(AcceleratorFragment acceleratorFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {acceleratorFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43191e = acceleratorFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f43191e.getActivity() == null) {
                return;
            }
            TornadoRuntime runtimeInfo = Tornado.INSTANCE.getRuntimeInfo();
            if (runtimeInfo != null) {
                this.f43191e.v.setText(this.f43191e.z((System.currentTimeMillis() - runtimeInfo.getStartTime().longValue()) / 1000));
            }
            this.f43191e.C.postDelayed(this.f43191e.I, 1000L);
            try {
                if (this.f43191e.getActivity() == null) {
                    this.f43191e.C.removeCallbacks(this.f43191e.I);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AcceleratorFragment f43192e;

        public e(AcceleratorFragment acceleratorFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {acceleratorFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43192e = acceleratorFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (!this.f43192e.H()) {
                        this.f43192e.C.removeCallbacks(this.f43192e.J);
                        Tornado.INSTANCE.stop();
                        this.f43192e.getActivity().finish();
                        return;
                    }
                    this.f43192e.C.postDelayed(this.f43192e.J, 2000L);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AcceleratorFragment f43193e;

        public f(AcceleratorFragment acceleratorFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {acceleratorFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43193e = acceleratorFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f43193e.getActivity() == null) {
                return;
            }
            this.f43193e.getActivity().onBackPressed();
        }
    }

    /* loaded from: classes12.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AcceleratorFragment f43194e;

        /* loaded from: classes12.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f43195e;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f43195e = gVar;
            }

            public /* synthetic */ void a() {
                this.f43195e.f43194e.F();
                this.f43195e.f43194e.M();
            }

            public /* synthetic */ void b(c.a.t0.e1.q1.a.f fVar, c.a.s0.s.s.j jVar, int i2, View view) {
                PkgNameAndNodeInfoData pkgNameAndNodeInfoData = c.a.t0.e1.q1.d.a.a(this.f43195e.f43194e.f43186g.getAvailableTornadoNodeInfoList()).get(Integer.valueOf(i2));
                this.f43195e.f43194e.f43187h = pkgNameAndNodeInfoData;
                this.f43195e.f43194e.f43184e.f43201d = pkgNameAndNodeInfoData.getNodeInfo().getNodeTag();
                this.f43195e.f43194e.f43184e.f43202e = pkgNameAndNodeInfoData.getNodeInfo().getNodeName();
                fVar.b();
                this.f43195e.f43194e.Q();
                this.f43195e.f43194e.C.postDelayed(new Runnable() { // from class: c.a.t0.e1.q1.c.b
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
                    final c.a.t0.e1.q1.a.f c2 = c.a.t0.e1.q1.a.f.c(this.f43195e.f43194e.getPageContext());
                    c2.d(new j.e() { // from class: c.a.t0.e1.q1.c.c
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // c.a.s0.s.s.j.e
                        public final void onItemClick(j jVar, int i2, View view2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, jVar, i2, view2) == null) {
                                AcceleratorFragment.g.a.this.b(c2, jVar, i2, view2);
                            }
                        }
                    });
                    c2.e(c.a.t0.e1.q1.d.a.b(this.f43195e.f43194e.f43186g.getAvailableTornadoNodeInfoList(), this.f43195e.f43194e.f43186g.getAvailableNodesNum()));
                    c2.f(this.f43195e.f43194e.getResources().getString(i1.accelerator_net_node_title));
                    c2.g();
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43194e = acceleratorFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && Tornado.INSTANCE.isRunning()) {
                s.f(this.f43194e.getActivity(), new a(this));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AcceleratorFragment f43196e;

        public h(AcceleratorFragment acceleratorFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {acceleratorFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43196e = acceleratorFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && Tornado.INSTANCE.isRunning()) {
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.f43196e.getPageContext(), new String[]{"com.baidu.tieba://unidispatch/frs?kw=游帮帮"}, true);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AcceleratorFragment f43197e;

        public i(AcceleratorFragment acceleratorFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {acceleratorFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43197e = acceleratorFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.s0.m.a.m(this.f43197e.getContext(), "https://tieba.baidu.com/tb/wise/speedup-SDK.html");
            }
        }
    }

    /* loaded from: classes12.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AcceleratorFragment f43198e;

        public j(AcceleratorFragment acceleratorFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {acceleratorFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43198e = acceleratorFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f43198e.t.setClickable(true);
                this.f43198e.B.setClickable(true);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f43199b;

        /* renamed from: c  reason: collision with root package name */
        public String f43200c;

        /* renamed from: d  reason: collision with root package name */
        public String f43201d;

        /* renamed from: e  reason: collision with root package name */
        public String f43202e;

        /* renamed from: f  reason: collision with root package name */
        public String f43203f;

        /* renamed from: g  reason: collision with root package name */
        public String f43204g;

        /* renamed from: h  reason: collision with root package name */
        public String f43205h;

        /* renamed from: i  reason: collision with root package name */
        public String f43206i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ AcceleratorFragment f43207j;

        public k(AcceleratorFragment acceleratorFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {acceleratorFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43207j = acceleratorFragment;
            this.a = "com.baidu.tieba";
            this.f43199b = "";
            this.f43200c = "";
            this.f43201d = "";
            this.f43202e = "";
            this.f43203f = "";
            this.f43204g = "";
            this.f43205h = "";
            this.f43206i = "";
        }
    }

    /* loaded from: classes12.dex */
    public class l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AcceleratorFragment f43208b;

        public l(AcceleratorFragment acceleratorFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {acceleratorFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43208b = acceleratorFragment;
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
        PACKAGES = new String[]{"com.google.android.play.games", "com.google.android.gms", "com.google.android.gsf", "android.uid.system", "com.google.uid.shared", "android.uid.systemui"};
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
        this.f43184e = new k(this);
        this.f43185f = new l(this);
        this.C = c.a.d.f.m.e.a();
        this.D = 0L;
        this.H = new c(this);
        this.I = new d(this);
        this.J = new e(this);
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.l.setVisibility(4);
            this.m.setVisibility(4);
            this.n.setVisibility(0);
            this.o.setVisibility(0);
            this.p.setVisibility(4);
            this.r.setVisibility(0);
            this.s.setVisibility(4);
            this.t.setVisibility(0);
            this.v.setVisibility(4);
            this.w.setVisibility(4);
            this.x.setVisibility(0);
            this.y.setVisibility(4);
            this.n.startLoad(this.f43184e.f43206i, 10, false);
            TBSelector.makeDrawableSelector().setShape(1).defaultColor(c1.CAM_X0607).into(this.o);
            this.x.setText(i1.accelerator_restart_text);
            c.a.t0.e1.q1.d.b.d(this.D);
            this.x.setOnClickListener(new View.OnClickListener() { // from class: c.a.t0.e1.q1.c.g
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        AcceleratorFragment.this.I(view);
                    }
                }
            });
            R(i1.accelerator_booster_fail);
            this.B.setClickable(true);
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.C.removeCallbacks(this.I);
            this.C.post(this.I);
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.C.removeCallbacks(this.H);
            this.C.post(this.H);
        }
    }

    public final void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.l.setVisibility(0);
            this.m.setVisibility(4);
            this.n.setVisibility(0);
            this.o.setVisibility(0);
            this.p.setVisibility(4);
            this.r.setVisibility(4);
            this.s.setVisibility(0);
            this.t.setVisibility(0);
            this.v.setVisibility(0);
            this.w.setVisibility(0);
            this.x.setVisibility(0);
            this.y.setVisibility(0);
            this.n.startLoad(this.f43184e.f43206i, 10, false);
            TBSelector.makeDrawableSelector().setShape(1).gradientLinear(DrawableSelector.TOP_BOTTOM, c1.CAM_X0503, c1.CAM_X0609).into(this.o);
            this.x.setText(i1.accelerator_enter_game_text);
            c.a.t0.e1.q1.d.b.b(this.D);
            this.y.setText(i1.accelerator_stop_game_text);
            c.a.t0.e1.q1.d.b.g(this.D);
            this.x.setOnClickListener(new View.OnClickListener() { // from class: c.a.t0.e1.q1.c.e
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        AcceleratorFragment.this.J(view);
                    }
                }
            });
            this.y.setOnClickListener(new View.OnClickListener() { // from class: c.a.t0.e1.q1.c.a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        AcceleratorFragment.this.K(view);
                    }
                }
            });
            N();
            B();
            if (z) {
                s.g(getActivity(), new i(this));
            }
            if (this.D > 0) {
                TbSingleton.getInstance().acceleratorItemId = this.D;
                TbSingleton.getInstance().acceleratorData = this.f43187h;
            }
            this.C.postDelayed(new j(this), 100L);
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.C.removeCallbacks(this.J);
            this.C.post(this.J);
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.l.setVisibility(4);
            this.m.setVisibility(0);
            this.n.setVisibility(4);
            this.o.setVisibility(4);
            this.p.setVisibility(0);
            this.r.setVisibility(4);
            this.s.setVisibility(4);
            this.t.setVisibility(0);
            this.v.setVisibility(4);
            this.w.setVisibility(0);
            this.x.setVisibility(4);
            this.y.setVisibility(4);
            this.f43185f = new l(this);
            this.k.setText(this.f43184e.f43199b);
            this.m.setIndeterminate(false);
            this.m.setProgress(0.0f);
            this.q.setText("0");
            this.u.setText(this.f43184e.f43202e);
            this.l.clearAnimation();
            C();
            this.t.setClickable(false);
            this.B.setClickable(false);
        }
    }

    public final void G(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            this.f43188i = (ViewGroup) view;
            this.f43189j = view.findViewById(f1.booster_back);
            this.k = (TextView) view.findViewById(f1.booster_name);
            this.l = view.findViewById(f1.booster_center_light);
            this.m = (ProgressCircle) view.findViewById(f1.booster_center_progress);
            this.n = (RoundTbImageView) view.findViewById(f1.booster_center_icon);
            this.o = view.findViewById(f1.booster_center_icon_mask);
            this.p = (ViewGroup) view.findViewById(f1.booster_progress_box);
            this.q = (TextView) view.findViewById(f1.booster_progress_tv);
            this.r = (ViewGroup) view.findViewById(f1.booster_fail_box);
            this.s = (ViewGroup) view.findViewById(f1.booster_success_box);
            this.t = (ViewGroup) view.findViewById(f1.booster_location_box);
            this.u = (TextView) view.findViewById(f1.booster_location_name);
            this.v = (TextView) view.findViewById(f1.booster_time);
            this.w = (ViewGroup) view.findViewById(f1.booster_starting_tips_box);
            this.x = (TextView) view.findViewById(f1.booster_btn_1);
            this.y = (TextView) view.findViewById(f1.booster_btn_2);
            this.z = (ImageView) view.findViewById(f1.booster_location_icon1);
            this.A = (ImageView) view.findViewById(f1.booster_location_icon2);
            this.B = view.findViewById(f1.booster_bottom_tips);
            WebPManager.setPureDrawable(this.z, e1.icon_pure_location, c1.CAM_X0101, WebPManager.ResourceStateType.NORMAL);
            WebPManager.setPureDrawable(this.A, e1.icon_pure_unfold10, c1.CAM_X0101, WebPManager.ResourceStateType.NORMAL);
            c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(this.x);
            d2.n(i1.J_X01);
            d2.f(c1.CAM_X0302);
            c.a.s0.s.u.c d3 = c.a.s0.s.u.c.d(this.y);
            d3.e(i1.A_X11);
            d3.n(i1.J_X01);
            d3.f(c1.CAM_X0101);
            c.a.s0.s.u.c d4 = c.a.s0.s.u.c.d(this.t);
            d4.n(i1.J_X01);
            d4.f(c1.CAM_X0613);
            TBSelector.makeDrawableSelector().setShape(1).defaultColor(c1.CAM_X0607).into(this.o);
            TBSelector.makeDrawableSelector().setShape(1).defaultColor(c1.CAM_X0613).into(this.l);
            this.f43189j.setOnClickListener(new f(this));
            this.t.setOnClickListener(new g(this));
            this.B.setOnClickListener(new h(this));
            F();
            E();
        }
    }

    public final boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
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

    public /* synthetic */ void I(View view) {
        F();
        M();
        c.a.t0.e1.q1.d.b.c(this.D);
    }

    public /* synthetic */ void J(View view) {
        O(this.f43184e.f43200c);
        c.a.t0.e1.q1.d.b.a(this.D);
    }

    public /* synthetic */ void K(View view) {
        c.a.t0.e1.q1.d.b.f(this.D);
        s.i(getActivity(), new c.a.t0.e1.q1.c.h(this));
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(1000L);
            scaleAnimation.setRepeatMode(2);
            scaleAnimation.setRepeatCount(-1);
            scaleAnimation.setInterpolator(new DecelerateInterpolator());
            this.l.startAnimation(scaleAnimation);
        }
    }

    public final void O(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            try {
                getContext().startActivity(getContext().getPackageManager().getLaunchIntentForPackage(str));
            } catch (Exception unused) {
                R(i1.accelerator_cannot_open_game);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: P */
    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            Tornado.INSTANCE.setAllowedPackages(PACKAGES);
            Tornado.INSTANCE.setToken(this.f43184e.f43205h, new a(this));
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            Tornado.INSTANCE.stop();
            this.C.removeCallbacks(this.H);
            this.C.removeCallbacks(this.I);
            TbSingleton.getInstance().acceleratorItemId = -1L;
            TbSingleton.getInstance().acceleratorData = null;
        }
    }

    public final void R(@StringRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            new BdTopToast(getContext(), 3000).setIcon(false).setContent(getString(i2)).show(this.f43188i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, layoutInflater, viewGroup, bundle)) == null) ? layoutInflater.inflate(g1.fragment_accelerator, viewGroup, false) : (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onDestroyView();
            if (!Tornado.INSTANCE.isRunning()) {
                Tornado.INSTANCE.stop();
                Tornado.INSTANCE.release();
            }
            try {
                this.C.removeCallbacks(this.H);
                this.C.removeCallbacks(this.I);
                this.C.removeCallbacks(this.J);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onResume();
            if (getActivity() != null && getActivity().getWindow() != null) {
                getActivity().getWindow().addFlags(512);
            }
            c.a.t0.e1.q1.d.b.e(this.E, this.D, this.F);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, view, bundle) == null) {
            G(view);
            if (!H()) {
                try {
                    getActivity().finish();
                    return;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            Tornado tornado = Tornado.INSTANCE;
            Context applicationContext = requireContext().getApplicationContext();
            k kVar = this.f43184e;
            tornado.init(applicationContext, kVar.a, kVar.f43204g, "tieba", "1.0");
            Tornado.INSTANCE.setEnv(TornadoENV.PRINT_LOG, "true");
            Tornado.INSTANCE.setEnv(TornadoENV.ENABLE_DEBUG, "false");
            Tornado.INSTANCE.setCallback(new b(this));
            if (this.G) {
                Tornado.INSTANCE.stop();
                this.C.postDelayed(new Runnable() { // from class: c.a.t0.e1.q1.c.f
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            AcceleratorFragment.this.L();
                        }
                    }
                }, 100L);
            } else if (Tornado.INSTANCE.isVPNProcessRunning()) {
                if (!Tornado.INSTANCE.isBind()) {
                    if (Tornado.INSTANCE.bind()) {
                        D(false);
                    } else {
                        Tornado.INSTANCE.stop();
                        this.C.postDelayed(new Runnable() { // from class: c.a.t0.e1.q1.c.d
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    AcceleratorFragment.this.M();
                                }
                            }
                        }, 100L);
                    }
                } else {
                    D(false);
                }
            } else {
                M();
            }
            super.onViewCreated(view, bundle);
        }
    }

    public void setIntentConfig(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, intent) == null) {
            this.f43186g = (AcceleratorData) intent.getSerializableExtra(AcceleratorActivityConfig.ACCELERATOR_DATA);
            this.f43187h = (PkgNameAndNodeInfoData) intent.getSerializableExtra(AcceleratorActivityConfig.NODE_INFO);
            k kVar = new k(this);
            this.f43184e = kVar;
            kVar.f43199b = this.f43186g.getItemData().mTitle;
            this.f43184e.f43200c = this.f43187h.getPackageName();
            this.f43184e.f43204g = TbadkCoreApplication.getInst().getCuidGalaxy2();
            this.f43184e.f43201d = this.f43187h.getNodeInfo().getNodeTag();
            this.f43184e.f43202e = this.f43187h.getNodeInfo().getNodeName();
            this.f43184e.f43203f = this.f43187h.getGameId();
            this.f43184e.f43205h = this.f43186g.getTokenInfo().getToken();
            this.f43184e.f43206i = this.f43186g.getItemData().mIconUrl;
            this.D = this.f43186g.getItemData().itemId;
            this.E = intent.getStringExtra("fid");
            this.F = intent.getIntExtra("source", 0);
            this.G = intent.getBooleanExtra(AcceleratorActivityConfig.IS_NEW_ITEM, false);
        }
    }

    public final String z(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048600, this, j2)) == null) ? String.format(getString(i1.accelerator_time_format), Long.valueOf((j2 / 3600) % 24), Long.valueOf((j2 / 60) % 60), Long.valueOf(j2 % 60)) : (String) invokeJ.objValue;
    }
}
