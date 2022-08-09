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
import com.repackage.fh6;
import com.repackage.fs4;
import com.repackage.gh6;
import com.repackage.hh6;
import com.repackage.jm4;
import com.repackage.kr6;
import com.repackage.ln4;
import com.repackage.ms4;
import com.repackage.rg;
import com.repackage.wg6;
/* loaded from: classes3.dex */
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
    public l b;
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
    public rg y;
    public long z;

    /* loaded from: classes3.dex */
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
                    this.a.N1();
                } else {
                    Tornado.INSTANCE.start(this.a.a.d, this.a.a.f, this.a.a.c);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
                    if (this.a.c != null && this.a.c.getItemData() != null) {
                        TbSingleton.getInstance().recordAcceleratorServer(String.valueOf(this.a.c.getItemData().itemId), this.a.a.e);
                    }
                    this.a.Q1(true);
                } else if (tornadoEvent == TornadoEvent.EVENT_BOOSTER_START_FAIL) {
                    this.a.N1();
                } else if (tornadoEvent == TornadoEvent.EVENT_BOOSTER_START_FAIL_WITH_TOKEN_INVALID) {
                    this.a.N1();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
                this.a.r.setText(this.a.M1((System.currentTimeMillis() - runtimeInfo.getStartTime().longValue()) / 1000));
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

    /* loaded from: classes3.dex */
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
                    if (!this.a.U1()) {
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

    /* loaded from: classes3.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.getActivity() == null) {
                return;
            }
            this.a.getActivity().onBackPressed();
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AcceleratorFragment a;

        /* loaded from: classes3.dex */
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
                this.a.a.S1();
                this.a.a.Z1();
            }

            public /* synthetic */ void b(wg6 wg6Var, fs4 fs4Var, int i, View view2) {
                PkgNameAndNodeInfoData pkgNameAndNodeInfoData = gh6.a(this.a.a.c.getAvailableTornadoNodeInfoList()).get(Integer.valueOf(i));
                this.a.a.d = pkgNameAndNodeInfoData;
                this.a.a.a.d = pkgNameAndNodeInfoData.getNodeInfo().getNodeTag();
                this.a.a.a.e = pkgNameAndNodeInfoData.getNodeInfo().getNodeName();
                wg6Var.b();
                this.a.a.e2();
                this.a.a.y.postDelayed(new Runnable() { // from class: com.repackage.zg6
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
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
                    final wg6 c = wg6.c(this.a.a.getPageContext());
                    c.e(new fs4.e() { // from class: com.repackage.yg6
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // com.repackage.fs4.e
                        public final void i0(fs4 fs4Var, int i, View view3) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, fs4Var, i, view3) == null) {
                                AcceleratorFragment.g.a.this.b(c, fs4Var, i, view3);
                            }
                        }
                    });
                    c.d(this.a.a.a.e);
                    c.f(gh6.b(this.a.a.c.getAvailableTornadoNodeInfoList(), this.a.a.c.getAvailableNodesNum()));
                    c.g(this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0062));
                    c.h();
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && Tornado.INSTANCE.isRunning()) {
                kr6.f(this.a.getActivity(), new a(this));
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && Tornado.INSTANCE.isRunning()) {
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.a.getPageContext(), new String[]{"com.baidu.tieba://unidispatch/frs?kw=游帮帮"}, true);
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                jm4.o(this.a.getContext(), "https://tieba.baidu.com/tb/wise/speedup-SDK.html");
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class k {
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

    /* loaded from: classes3.dex */
    public class l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;
        public final /* synthetic */ AcceleratorFragment b;

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
        this.b = new l(this);
        this.y = rg.a();
        this.z = 0L;
        this.D = new c(this);
        this.E = new d(this);
        this.F = new e(this);
    }

    public final String M1(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) ? String.format(getString(R.string.obfuscated_res_0x7f0f0068), Long.valueOf((j2 / 3600) % 24), Long.valueOf((j2 / 60) % 60), Long.valueOf(j2 % 60)) : (String) invokeJ.objValue;
    }

    public final void N1() {
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
            this.j.K(this.a.i, 10, false);
            TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0607).into(this.k);
            this.t.setText(R.string.obfuscated_res_0x7f0f0064);
            hh6.d(this.z);
            this.t.setOnClickListener(new View.OnClickListener() { // from class: com.repackage.ch6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        AcceleratorFragment.this.V1(view2);
                    }
                }
            });
            f2(R.string.obfuscated_res_0x7f0f0055);
            this.x.setClickable(true);
        }
    }

    public final void O1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.y.removeCallbacks(this.E);
            this.y.post(this.E);
        }
    }

    public final void P1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.y.removeCallbacks(this.D);
            this.y.post(this.D);
        }
    }

    public final void Q1(boolean z) {
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
            this.j.K(this.a.i, 10, false);
            TBSelector.makeDrawableSelector().setShape(1).gradientLinear(DrawableSelector.TOP_BOTTOM, R.color.CAM_X0503, R.color.CAM_X0609).into(this.k);
            this.t.setText(R.string.obfuscated_res_0x7f0f005e);
            hh6.b(this.z);
            this.u.setText(R.string.obfuscated_res_0x7f0f0067);
            hh6.g(this.z);
            this.t.setOnClickListener(new View.OnClickListener() { // from class: com.repackage.bh6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        AcceleratorFragment.this.W1(view2);
                    }
                }
            });
            this.u.setOnClickListener(new View.OnClickListener() { // from class: com.repackage.ah6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        AcceleratorFragment.this.X1(view2);
                    }
                }
            });
            a2();
            O1();
            if (z) {
                kr6.g(getActivity(), new i(this));
            }
            if (this.z > 0) {
                TbSingleton.getInstance().acceleratorItemId = this.z;
                TbSingleton.getInstance().acceleratorData = this.d;
            }
            this.y.postDelayed(new j(this), 100L);
        }
    }

    public final void R1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.y.removeCallbacks(this.F);
            this.y.post(this.F);
        }
    }

    public final void S1() {
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
            this.b = new l(this);
            this.g.setText(this.a.b);
            this.i.setIndeterminate(false);
            this.i.setProgress(0.0f);
            this.m.setText("0");
            this.q.setText(this.a.e);
            this.h.clearAnimation();
            P1();
            this.p.setClickable(false);
            this.x.setClickable(false);
        }
    }

    public final void T1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
            this.e = (ViewGroup) view2;
            this.f = view2.findViewById(R.id.obfuscated_res_0x7f0903b1);
            this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0903bf);
            this.h = view2.findViewById(R.id.obfuscated_res_0x7f0903b8);
            this.i = (ProgressCircle) view2.findViewById(R.id.obfuscated_res_0x7f0903b9);
            this.j = (RoundTbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0903b6);
            this.k = view2.findViewById(R.id.obfuscated_res_0x7f0903b7);
            this.l = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f0903c0);
            this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0903c1);
            this.n = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f0903ba);
            this.o = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f0903c4);
            this.p = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f0903bb);
            this.q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0903be);
            this.r = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0903c7);
            this.s = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f0903c3);
            this.t = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0903b3);
            this.u = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0903b4);
            this.v = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0903bc);
            this.w = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0903bd);
            this.x = view2.findViewById(R.id.obfuscated_res_0x7f0903b2);
            WebPManager.setPureDrawable(this.v, R.drawable.obfuscated_res_0x7f080952, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL);
            WebPManager.setPureDrawable(this.w, R.drawable.obfuscated_res_0x7f080a0f, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL);
            ms4 d2 = ms4.d(this.t);
            d2.n(R.string.J_X01);
            d2.f(R.color.CAM_X0302);
            ms4 d3 = ms4.d(this.u);
            d3.e(R.string.A_X11);
            d3.n(R.string.J_X01);
            d3.f(R.color.CAM_X0101);
            ms4 d4 = ms4.d(this.p);
            d4.n(R.string.J_X01);
            d4.f(R.color.CAM_X0613);
            TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0607).into(this.k);
            TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0613).into(this.h);
            this.f.setOnClickListener(new f(this));
            this.p.setOnClickListener(new g(this));
            this.x.setOnClickListener(new h(this));
            S1();
            R1();
        }
    }

    public final boolean U1() {
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

    public /* synthetic */ void V1(View view2) {
        S1();
        Z1();
        hh6.c(this.z);
    }

    public /* synthetic */ void W1(View view2) {
        b2(this.a.c);
        hh6.a(this.z);
    }

    public /* synthetic */ void X1(View view2) {
        hh6.f(this.z);
        kr6.i(getActivity(), new fh6(this));
    }

    public final void a2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(1000L);
            scaleAnimation.setRepeatMode(2);
            scaleAnimation.setRepeatCount(-1);
            scaleAnimation.setInterpolator(new DecelerateInterpolator());
            this.h.startAnimation(scaleAnimation);
        }
    }

    public final void b2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            try {
                getContext().startActivity(getContext().getPackageManager().getLaunchIntentForPackage(str));
            } catch (Exception unused) {
                f2(R.string.obfuscated_res_0x7f0f0059);
            }
        }
    }

    public void c2(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, intent) == null) {
            this.c = (AcceleratorData) intent.getSerializableExtra(AcceleratorActivityConfig.ACCELERATOR_DATA);
            this.d = (PkgNameAndNodeInfoData) intent.getSerializableExtra(AcceleratorActivityConfig.NODE_INFO);
            k kVar = new k(this);
            this.a = kVar;
            kVar.b = this.c.getItemData().mTitle;
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

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: d2 */
    public final void Z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            Tornado.INSTANCE.setAllowedPackages(G);
            Tornado.INSTANCE.setToken(this.a.h, new a(this));
        }
    }

    public final void e2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            Tornado.INSTANCE.stop();
            this.y.removeCallbacks(this.D);
            this.y.removeCallbacks(this.E);
            TbSingleton.getInstance().acceleratorItemId = -1L;
            TbSingleton.getInstance().acceleratorData = null;
        }
    }

    public final void f2(@StringRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            BdTopToast bdTopToast = new BdTopToast(getContext(), 3000);
            bdTopToast.h(false);
            bdTopToast.g(getString(i2));
            bdTopToast.i(this.e);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048596, this, layoutInflater, viewGroup, bundle)) == null) ? layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d02cd, viewGroup, false) : (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onResume();
            if (getActivity() != null && getActivity().getWindow() != null) {
                getActivity().getWindow().addFlags(512);
            }
            hh6.e(this.A, this.z, this.B);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view2, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, view2, bundle) == null) {
            T1(view2);
            if (!U1()) {
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
            tornado.init(applicationContext, kVar.a, kVar.g, "tieba", ln4.d());
            Tornado.INSTANCE.setEnv(TornadoENV.PRINT_LOG, "true");
            Tornado.INSTANCE.setEnv(TornadoENV.ENABLE_DEBUG, "false");
            Tornado.INSTANCE.setCallback(new b(this));
            if (this.C) {
                Tornado.INSTANCE.stop();
                this.y.postDelayed(new Runnable() { // from class: com.repackage.eh6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            AcceleratorFragment.this.Y1();
                        }
                    }
                }, 100L);
            } else if (Tornado.INSTANCE.isVPNProcessRunning()) {
                if (!Tornado.INSTANCE.isBind()) {
                    if (Tornado.INSTANCE.bind()) {
                        Q1(false);
                    } else {
                        Tornado.INSTANCE.stop();
                        this.y.postDelayed(new Runnable() { // from class: com.repackage.dh6
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    AcceleratorFragment.this.Z1();
                                }
                            }
                        }, 100L);
                    }
                } else {
                    Q1(false);
                }
            } else {
                Z1();
            }
            super.onViewCreated(view2, bundle);
        }
    }
}
