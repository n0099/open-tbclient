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
import com.baidu.tieba.frs.accelerator.view.ProgressCircle;
import com.baidu.tieba.fy6;
import com.baidu.tieba.gt4;
import com.baidu.tieba.hv4;
import com.baidu.tieba.hy6;
import com.baidu.tieba.iy6;
import com.baidu.tieba.jg;
import com.baidu.tieba.k05;
import com.baidu.tieba.n15;
import com.baidu.tieba.u87;
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
import com.google.android.gms.common.GooglePlayServicesUtilLight;
/* loaded from: classes4.dex */
public class AcceleratorFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] H;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public int B;
    public boolean C;
    public Runnable D;
    public Runnable E;
    public Runnable F;
    public TornadoCallback G;
    public p a;
    public q b;
    public AcceleratorData c;
    public PkgNameAndNodeInfoData d;
    public ViewGroup e;
    public View f;
    public TextView g;
    public View h;
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
    public jg y;
    public long z;

    /* loaded from: classes4.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AcceleratorFragment a;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ k a;

            /* renamed from: com.baidu.tieba.frs.accelerator.ui.AcceleratorFragment$k$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class C0261a implements k05.f {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ fy6 a;
                public final /* synthetic */ a b;

                /* renamed from: com.baidu.tieba.frs.accelerator.ui.AcceleratorFragment$k$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes4.dex */
                public class RunnableC0262a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ C0261a a;

                    public RunnableC0262a(C0261a c0261a) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {c0261a};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = c0261a;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                            return;
                        }
                        this.a.b.a.a.g2();
                        this.a.b.a.a.m2();
                    }
                }

                public C0261a(a aVar, fy6 fy6Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar, fy6Var};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = aVar;
                    this.a = fy6Var;
                }

                @Override // com.baidu.tieba.k05.f
                public void M0(k05 k05Var, int i, View view2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLIL(1048576, this, k05Var, i, view2) == null) {
                        PkgNameAndNodeInfoData pkgNameAndNodeInfoData = hy6.a(this.b.a.a.c.getAvailableTornadoNodeInfoList()).get(Integer.valueOf(i));
                        this.b.a.a.d = pkgNameAndNodeInfoData;
                        this.b.a.a.a.d = pkgNameAndNodeInfoData.getNodeInfo().getNodeTag();
                        this.b.a.a.a.e = pkgNameAndNodeInfoData.getNodeInfo().getNodeName();
                        this.a.b();
                        this.b.a.a.n2();
                        this.b.a.a.y.postDelayed(new RunnableC0262a(this), 100L);
                    }
                }
            }

            public a(k kVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = kVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    fy6 c = fy6.c(this.a.a.getPageContext());
                    c.e(new C0261a(this, c));
                    c.d(this.a.a.a.e);
                    c.f(hy6.b(this.a.a.c.getAvailableTornadoNodeInfoList(), this.a.a.c.getAvailableNodesNum()));
                    c.g(this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0065));
                    c.h();
                }
            }
        }

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
            this.a = acceleratorFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !Tornado.INSTANCE.isRunning()) {
                return;
            }
            u87.f(this.a.getActivity(), new a(this));
        }
    }

    /* loaded from: classes4.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AcceleratorFragment a;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ o a;

            public a(o oVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = oVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    if (this.a.a.c != null && this.a.a.c.getItemData() != null) {
                        TbSingleton.getInstance().removeAcceleratorServer(String.valueOf(this.a.a.c.getItemData().itemId));
                    }
                    this.a.a.n2();
                    this.a.a.getActivity().finish();
                }
            }
        }

        public o(AcceleratorFragment acceleratorFragment) {
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                iy6.f(this.a.z);
                u87.i(this.a.getActivity(), new a(this));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                gt4.s(this.a.getContext(), "https://tieba.baidu.com/tb/wise/speedup-SDK.html");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.p.setClickable(true);
                this.a.x.setClickable(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements TornadoTokenCallback {
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

        @Override // com.baidu.yunjiasu.tornadosdk.TornadoTokenCallback
        public void onResult(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    Tornado.INSTANCE.start(this.a.a.d, this.a.a.f, this.a.a.c);
                } else {
                    this.a.b2();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.m2();
        }
    }

    /* loaded from: classes4.dex */
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
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.m2();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements TornadoCallback {
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

        @Override // com.baidu.yunjiasu.tornadosdk.TornadoCallback
        public void onEvent(TornadoEvent tornadoEvent, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, tornadoEvent, str) == null) {
                if (tornadoEvent == TornadoEvent.EVENT_BOOSTER_START_OK) {
                    if (this.a.c != null && this.a.c.getItemData() != null) {
                        TbSingleton.getInstance().recordAcceleratorServer(String.valueOf(this.a.c.getItemData().itemId), this.a.a.e);
                    }
                    this.a.e2(true);
                } else if (tornadoEvent != TornadoEvent.EVENT_BOOSTER_START_FAIL) {
                    if (tornadoEvent != TornadoEvent.EVENT_BOOSTER_START_FAIL_WITH_TOKEN_INVALID) {
                        return;
                    }
                    this.a.b2();
                } else {
                    this.a.b2();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AcceleratorFragment a;

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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.getActivity() == null) {
                return;
            }
            this.a.b.a += 0.002f;
            AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
            this.a.i.setProgress(accelerateInterpolator.getInterpolation(this.a.b.a));
            if (this.a.b.a > 0.99f && !Tornado.INSTANCE.isRunning()) {
                this.a.b.a = 0.99f;
                this.a.i.setIndeterminate(true);
                return;
            }
            if (Tornado.INSTANCE.isRunning()) {
                this.a.b.a = 1.0f;
            }
            if (this.a.b.a >= 1.0f) {
                this.a.b.a = 1.0f;
                this.a.m.setText("100");
                this.a.y.removeCallbacks(this.a.D);
            } else {
                this.a.m.setText(Integer.toString(Math.round(accelerateInterpolator.getInterpolation(this.a.b.a) * 100.0f)));
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

    /* loaded from: classes4.dex */
    public class h implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.getActivity() == null) {
                return;
            }
            TornadoRuntime runtimeInfo = Tornado.INSTANCE.getRuntimeInfo();
            if (runtimeInfo != null) {
                this.a.r.setText(this.a.a2((System.currentTimeMillis() - runtimeInfo.getStartTime().longValue()) / 1000));
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

    /* loaded from: classes4.dex */
    public class i implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (!this.a.i2()) {
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

    /* loaded from: classes4.dex */
    public class j implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.getActivity() != null) {
                this.a.getActivity().onBackPressed();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AcceleratorFragment a;

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
            this.a = acceleratorFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !Tornado.INSTANCE.isRunning()) {
                return;
            }
            UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.a.getPageContext(), new String[]{"com.baidu.tieba://unidispatch/frs?kw=游帮帮"}, true);
        }
    }

    /* loaded from: classes4.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AcceleratorFragment a;

        public m(AcceleratorFragment acceleratorFragment) {
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.g2();
            this.a.m2();
            iy6.c(this.a.z);
        }
    }

    /* loaded from: classes4.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AcceleratorFragment a;

        public n(AcceleratorFragment acceleratorFragment) {
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                AcceleratorFragment acceleratorFragment = this.a;
                acceleratorFragment.k2(acceleratorFragment.a.c);
                iy6.a(this.a.z);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;
        public final /* synthetic */ AcceleratorFragment j;

        public p(AcceleratorFragment acceleratorFragment) {
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
            this.b = "";
            this.c = "";
            this.d = "";
            this.e = "";
            this.f = "";
            this.g = "";
            this.h = "";
            this.i = "";
        }
    }

    /* loaded from: classes4.dex */
    public class q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;
        public final /* synthetic */ AcceleratorFragment b;

        public q(AcceleratorFragment acceleratorFragment) {
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
            this.b = acceleratorFragment;
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
        H = new String[]{GooglePlayServicesUtilLight.GOOGLE_PLAY_GAMES_PACKAGE, "com.google.android.gms", "com.google.android.gsf", "android.uid.system", "com.google.uid.shared", "android.uid.systemui"};
    }

    public final void c2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.y.removeCallbacks(this.E);
            this.y.post(this.E);
        }
    }

    public final void d2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.y.removeCallbacks(this.D);
            this.y.post(this.D);
        }
    }

    public final void f2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.y.removeCallbacks(this.F);
            this.y.post(this.F);
        }
    }

    public final void m2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            Tornado.INSTANCE.setAllowedPackages(H);
            Tornado.INSTANCE.setToken(this.a.h, new c(this));
        }
    }

    public final void n2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            Tornado.INSTANCE.stop();
            this.y.removeCallbacks(this.D);
            this.y.removeCallbacks(this.E);
            TbSingleton.getInstance().acceleratorItemId = -1L;
            TbSingleton.getInstance().acceleratorData = null;
        }
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
        this.a = new p(this);
        this.b = new q(this);
        this.y = jg.a();
        this.z = 0L;
        this.D = new g(this);
        this.E = new h(this);
        this.F = new i(this);
        this.G = new f(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onDestroyView();
            if (!Tornado.INSTANCE.isRunning()) {
                Tornado.INSTANCE.stop();
                Tornado.INSTANCE.release();
            }
            try {
                this.y.removeCallbacks(this.D);
                this.y.removeCallbacks(this.E);
                this.y.removeCallbacks(this.F);
                if (this.D != null) {
                    this.D = null;
                }
                if (this.E != null) {
                    this.E = null;
                }
                if (this.F != null) {
                    this.F = null;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (this.G != null) {
                this.G = null;
            }
        }
    }

    public final void k2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            try {
                getContext().startActivity(getContext().getPackageManager().getLaunchIntentForPackage(str));
            } catch (Exception unused) {
                o2(R.string.obfuscated_res_0x7f0f005c);
            }
        }
    }

    public final void o2(@StringRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            BdTopToast bdTopToast = new BdTopToast(getContext(), 3000);
            bdTopToast.h(false);
            bdTopToast.g(getString(i2));
            bdTopToast.i(this.e);
        }
    }

    public final String a2(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
            return String.format(getString(R.string.obfuscated_res_0x7f0f006b), Long.valueOf((j2 / 3600) % 24), Long.valueOf((j2 / 60) % 60), Long.valueOf(j2 % 60));
        }
        return (String) invokeJ.objValue;
    }

    public final void b2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.h.setVisibility(4);
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
            this.j.M(this.a.i, 10, false);
            TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0607).into(this.k);
            this.t.setText(R.string.obfuscated_res_0x7f0f0067);
            iy6.d(this.z);
            this.t.setOnClickListener(new m(this));
            o2(R.string.obfuscated_res_0x7f0f0058);
            this.x.setClickable(true);
        }
    }

    public final void g2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.h.setVisibility(4);
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
            this.b = new q(this);
            this.g.setText(this.a.b);
            this.i.setIndeterminate(false);
            this.i.setProgress(0.0f);
            this.m.setText("0");
            this.q.setText(this.a.e);
            this.h.clearAnimation();
            d2();
            this.p.setClickable(false);
            this.x.setClickable(false);
        }
    }

    public final void e2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.h.setVisibility(0);
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
            this.j.M(this.a.i, 10, false);
            TBSelector.makeDrawableSelector().setShape(1).gradientLinear(DrawableSelector.TOP_BOTTOM, R.color.CAM_X0503, R.color.CAM_X0609).into(this.k);
            this.t.setText(R.string.obfuscated_res_0x7f0f0061);
            iy6.b(this.z);
            this.u.setText(R.string.obfuscated_res_0x7f0f006a);
            iy6.g(this.z);
            this.t.setOnClickListener(new n(this));
            this.u.setOnClickListener(new o(this));
            j2();
            c2();
            if (z) {
                u87.g(getActivity(), new a(this));
            }
            if (this.z > 0) {
                TbSingleton.getInstance().acceleratorItemId = this.z;
                TbSingleton.getInstance().acceleratorData = this.d;
            }
            this.y.postDelayed(new b(this), 100L);
        }
    }

    public final void h2(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
            this.e = (ViewGroup) view2;
            this.f = view2.findViewById(R.id.obfuscated_res_0x7f09040d);
            this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09041b);
            this.h = view2.findViewById(R.id.obfuscated_res_0x7f090414);
            this.i = (ProgressCircle) view2.findViewById(R.id.obfuscated_res_0x7f090415);
            this.j = (RoundTbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090412);
            this.k = view2.findViewById(R.id.obfuscated_res_0x7f090413);
            this.l = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f09041c);
            this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09041d);
            this.n = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f090416);
            this.o = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f090420);
            this.p = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f090417);
            this.q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09041a);
            this.r = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090423);
            this.s = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f09041f);
            this.t = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09040f);
            this.u = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090410);
            this.v = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090418);
            this.w = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090419);
            this.x = view2.findViewById(R.id.obfuscated_res_0x7f09040e);
            WebPManager.setPureDrawable(this.v, R.drawable.icon_pure_location, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL);
            WebPManager.setPureDrawable(this.w, R.drawable.obfuscated_res_0x7f080a9f, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL);
            n15 d2 = n15.d(this.t);
            d2.o(R.string.J_X01);
            d2.f(R.color.CAM_X0302);
            n15 d3 = n15.d(this.u);
            d3.e(R.string.A_X11);
            d3.o(R.string.J_X01);
            d3.f(R.color.CAM_X0101);
            n15 d4 = n15.d(this.p);
            d4.o(R.string.J_X01);
            d4.f(R.color.CAM_X0613);
            TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0607).into(this.k);
            TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0613).into(this.h);
            this.f.setOnClickListener(new j(this));
            this.p.setOnClickListener(new k(this));
            this.x.setOnClickListener(new l(this));
            g2();
            f2();
        }
    }

    public final boolean i2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) getContext().getSystemService("connectivity");
                if (connectivityManager.getActiveNetworkInfo() == null) {
                    return false;
                }
                if (!connectivityManager.getActiveNetworkInfo().isConnected()) {
                    return false;
                }
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public final void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(1000L);
            scaleAnimation.setRepeatMode(2);
            scaleAnimation.setRepeatCount(-1);
            scaleAnimation.setInterpolator(new DecelerateInterpolator());
            this.h.startAnimation(scaleAnimation);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onPause();
            if (getActivity() != null && getActivity().getWindow() != null) {
                getActivity().getWindow().clearFlags(512);
                getActivity().getWindow().getDecorView().setSystemUiVisibility(0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onResume();
            if (getActivity() != null && getActivity().getWindow() != null) {
                getActivity().getWindow().addFlags(512);
            }
            iy6.e(this.A, this.z, this.B);
        }
    }

    public void l2(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, intent) == null) {
            this.c = (AcceleratorData) intent.getSerializableExtra(AcceleratorActivityConfig.ACCELERATOR_DATA);
            this.d = (PkgNameAndNodeInfoData) intent.getSerializableExtra(AcceleratorActivityConfig.NODE_INFO);
            p pVar = new p(this);
            this.a = pVar;
            pVar.b = this.c.getItemData().mTitle;
            this.a.c = this.d.getPackageName();
            this.a.g = TbadkCoreApplication.getInst().getCuidGalaxy2();
            this.a.d = this.d.getNodeInfo().getNodeTag();
            this.a.e = this.d.getNodeInfo().getNodeName();
            this.a.f = this.d.getGameId();
            this.a.h = this.c.getTokenInfo().getToken();
            this.a.i = this.c.getItemData().mIconUrl;
            this.z = this.c.getItemData().itemId;
            this.A = intent.getStringExtra("fid");
            this.B = intent.getIntExtra("source", 0);
            this.C = intent.getBooleanExtra(AcceleratorActivityConfig.IS_NEW_ITEM, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048591, this, layoutInflater, viewGroup, bundle)) == null) {
            return layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d02ed, viewGroup, false);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view2, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, view2, bundle) == null) {
            h2(view2);
            if (!i2()) {
                try {
                    getActivity().finish();
                    return;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            Tornado tornado = Tornado.INSTANCE;
            Context applicationContext = requireContext().getApplicationContext();
            p pVar = this.a;
            tornado.init(applicationContext, pVar.a, pVar.g, "tieba", hv4.d());
            Tornado.INSTANCE.setEnv(TornadoENV.PRINT_LOG, "true");
            Tornado.INSTANCE.setEnv(TornadoENV.ENABLE_DEBUG, "false");
            Tornado.INSTANCE.setCallback(this.G);
            if (this.C) {
                Tornado.INSTANCE.stop();
                this.y.postDelayed(new d(this), 100L);
            } else if (Tornado.INSTANCE.isVPNProcessRunning()) {
                if (!Tornado.INSTANCE.isBind()) {
                    if (Tornado.INSTANCE.bind()) {
                        e2(false);
                    } else {
                        Tornado.INSTANCE.stop();
                        this.y.postDelayed(new e(this), 100L);
                    }
                } else {
                    e2(false);
                }
            } else {
                m2();
            }
            super.onViewCreated(view2, bundle);
        }
    }
}
