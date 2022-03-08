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
import c.a.q0.r.t.j;
import c.a.r0.d1.r2.s;
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
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.yunjiasu.tornadosdk.Tornado;
import com.baidu.yunjiasu.tornadosdk.TornadoCallback;
import com.baidu.yunjiasu.tornadosdk.TornadoENV;
import com.baidu.yunjiasu.tornadosdk.TornadoEvent;
import com.baidu.yunjiasu.tornadosdk.TornadoRuntime;
import com.baidu.yunjiasu.tornadosdk.TornadoTokenCallback;
/* loaded from: classes5.dex */
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
    public k f41821e;

    /* renamed from: f  reason: collision with root package name */
    public l f41822f;

    /* renamed from: g  reason: collision with root package name */
    public AcceleratorData f41823g;

    /* renamed from: h  reason: collision with root package name */
    public PkgNameAndNodeInfoData f41824h;

    /* renamed from: i  reason: collision with root package name */
    public ViewGroup f41825i;

    /* renamed from: j  reason: collision with root package name */
    public View f41826j;
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
                    Tornado.INSTANCE.start(this.a.f41821e.f41838d, this.a.f41821e.f41840f, this.a.f41821e.f41837c);
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
                    if (this.a.f41823g != null && this.a.f41823g.getItemData() != null) {
                        TbSingleton.getInstance().recordAcceleratorServer(String.valueOf(this.a.f41823g.getItemData().itemId), this.a.f41821e.f41839e);
                    }
                    this.a.D(true);
                } else if (tornadoEvent == TornadoEvent.EVENT_BOOSTER_START_FAIL) {
                    this.a.A();
                } else if (tornadoEvent == TornadoEvent.EVENT_BOOSTER_START_FAIL_WITH_TOKEN_INVALID) {
                    this.a.A();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AcceleratorFragment f41827e;

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
            this.f41827e = acceleratorFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f41827e.getActivity() == null) {
                return;
            }
            this.f41827e.f41822f.a += 0.002f;
            AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
            this.f41827e.m.setProgress(accelerateInterpolator.getInterpolation(this.f41827e.f41822f.a));
            if (this.f41827e.f41822f.a > 0.99f && !Tornado.INSTANCE.isRunning()) {
                this.f41827e.f41822f.a = 0.99f;
                this.f41827e.m.setIndeterminate(true);
                return;
            }
            if (Tornado.INSTANCE.isRunning()) {
                this.f41827e.f41822f.a = 1.0f;
            }
            if (this.f41827e.f41822f.a >= 1.0f) {
                this.f41827e.f41822f.a = 1.0f;
                this.f41827e.q.setText(HomeCfgResponse.ConfigData.GROUP_LAYOUR_GAP);
                this.f41827e.C.removeCallbacks(this.f41827e.H);
            } else {
                this.f41827e.q.setText(Integer.toString(Math.round(accelerateInterpolator.getInterpolation(this.f41827e.f41822f.a) * 100.0f)));
                this.f41827e.C.postDelayed(this.f41827e.H, 10L);
            }
            try {
                if (this.f41827e.getActivity() == null) {
                    this.f41827e.C.removeCallbacks(this.f41827e.H);
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

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AcceleratorFragment f41828e;

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
            this.f41828e = acceleratorFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f41828e.getActivity() == null) {
                return;
            }
            TornadoRuntime runtimeInfo = Tornado.INSTANCE.getRuntimeInfo();
            if (runtimeInfo != null) {
                this.f41828e.v.setText(this.f41828e.z((System.currentTimeMillis() - runtimeInfo.getStartTime().longValue()) / 1000));
            }
            this.f41828e.C.postDelayed(this.f41828e.I, 1000L);
            try {
                if (this.f41828e.getActivity() == null) {
                    this.f41828e.C.removeCallbacks(this.f41828e.I);
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

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AcceleratorFragment f41829e;

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
            this.f41829e = acceleratorFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (!this.f41829e.H()) {
                        this.f41829e.C.removeCallbacks(this.f41829e.J);
                        Tornado.INSTANCE.stop();
                        this.f41829e.getActivity().finish();
                        return;
                    }
                    this.f41829e.C.postDelayed(this.f41829e.J, 2000L);
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

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AcceleratorFragment f41830e;

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
            this.f41830e = acceleratorFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f41830e.getActivity() == null) {
                return;
            }
            this.f41830e.getActivity().onBackPressed();
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AcceleratorFragment f41831e;

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f41832e;

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
                this.f41832e = gVar;
            }

            public /* synthetic */ void a() {
                this.f41832e.f41831e.F();
                this.f41832e.f41831e.M();
            }

            public /* synthetic */ void b(c.a.r0.d1.g1.a.f fVar, c.a.q0.r.t.j jVar, int i2, View view) {
                PkgNameAndNodeInfoData pkgNameAndNodeInfoData = c.a.r0.d1.g1.d.a.a(this.f41832e.f41831e.f41823g.getAvailableTornadoNodeInfoList()).get(Integer.valueOf(i2));
                this.f41832e.f41831e.f41824h = pkgNameAndNodeInfoData;
                this.f41832e.f41831e.f41821e.f41838d = pkgNameAndNodeInfoData.getNodeInfo().getNodeTag();
                this.f41832e.f41831e.f41821e.f41839e = pkgNameAndNodeInfoData.getNodeInfo().getNodeName();
                fVar.b();
                this.f41832e.f41831e.Q();
                this.f41832e.f41831e.C.postDelayed(new Runnable() { // from class: c.a.r0.d1.g1.c.b
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
                    final c.a.r0.d1.g1.a.f c2 = c.a.r0.d1.g1.a.f.c(this.f41832e.f41831e.getPageContext());
                    c2.e(new j.e() { // from class: c.a.r0.d1.g1.c.c
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // c.a.q0.r.t.j.e
                        public final void onItemClick(j jVar, int i2, View view2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, jVar, i2, view2) == null) {
                                AcceleratorFragment.g.a.this.b(c2, jVar, i2, view2);
                            }
                        }
                    });
                    c2.d(this.f41832e.f41831e.f41821e.f41839e);
                    c2.f(c.a.r0.d1.g1.d.a.b(this.f41832e.f41831e.f41823g.getAvailableTornadoNodeInfoList(), this.f41832e.f41831e.f41823g.getAvailableNodesNum()));
                    c2.g(this.f41832e.f41831e.getResources().getString(R.string.accelerator_net_node_title));
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41831e = acceleratorFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && Tornado.INSTANCE.isRunning()) {
                s.f(this.f41831e.getActivity(), new a(this));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AcceleratorFragment f41833e;

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
            this.f41833e = acceleratorFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && Tornado.INSTANCE.isRunning()) {
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.f41833e.getPageContext(), new String[]{"com.baidu.tieba://unidispatch/frs?kw=游帮帮"}, true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AcceleratorFragment f41834e;

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
            this.f41834e = acceleratorFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.q0.l.a.m(this.f41834e.getContext(), "https://tieba.baidu.com/tb/wise/speedup-SDK.html");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AcceleratorFragment f41835e;

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
            this.f41835e = acceleratorFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f41835e.t.setClickable(true);
                this.f41835e.B.setClickable(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f41836b;

        /* renamed from: c  reason: collision with root package name */
        public String f41837c;

        /* renamed from: d  reason: collision with root package name */
        public String f41838d;

        /* renamed from: e  reason: collision with root package name */
        public String f41839e;

        /* renamed from: f  reason: collision with root package name */
        public String f41840f;

        /* renamed from: g  reason: collision with root package name */
        public String f41841g;

        /* renamed from: h  reason: collision with root package name */
        public String f41842h;

        /* renamed from: i  reason: collision with root package name */
        public String f41843i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ AcceleratorFragment f41844j;

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
            this.f41844j = acceleratorFragment;
            this.a = "com.baidu.tieba";
            this.f41836b = "";
            this.f41837c = "";
            this.f41838d = "";
            this.f41839e = "";
            this.f41840f = "";
            this.f41841g = "";
            this.f41842h = "";
            this.f41843i = "";
        }
    }

    /* loaded from: classes5.dex */
    public class l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AcceleratorFragment f41845b;

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
            this.f41845b = acceleratorFragment;
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
        this.f41821e = new k(this);
        this.f41822f = new l(this);
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
            this.n.startLoad(this.f41821e.f41843i, 10, false);
            TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0607).into(this.o);
            this.x.setText(R.string.accelerator_restart_text);
            c.a.r0.d1.g1.d.b.d(this.D);
            this.x.setOnClickListener(new View.OnClickListener() { // from class: c.a.r0.d1.g1.c.g
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
            R(R.string.accelerator_booster_fail);
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
            this.n.startLoad(this.f41821e.f41843i, 10, false);
            TBSelector.makeDrawableSelector().setShape(1).gradientLinear(DrawableSelector.TOP_BOTTOM, R.color.CAM_X0503, R.color.CAM_X0609).into(this.o);
            this.x.setText(R.string.accelerator_enter_game_text);
            c.a.r0.d1.g1.d.b.b(this.D);
            this.y.setText(R.string.accelerator_stop_game_text);
            c.a.r0.d1.g1.d.b.g(this.D);
            this.x.setOnClickListener(new View.OnClickListener() { // from class: c.a.r0.d1.g1.c.e
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
            this.y.setOnClickListener(new View.OnClickListener() { // from class: c.a.r0.d1.g1.c.a
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
                TbSingleton.getInstance().acceleratorData = this.f41824h;
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
            this.f41822f = new l(this);
            this.k.setText(this.f41821e.f41836b);
            this.m.setIndeterminate(false);
            this.m.setProgress(0.0f);
            this.q.setText("0");
            this.u.setText(this.f41821e.f41839e);
            this.l.clearAnimation();
            C();
            this.t.setClickable(false);
            this.B.setClickable(false);
        }
    }

    public final void G(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            this.f41825i = (ViewGroup) view;
            this.f41826j = view.findViewById(R.id.booster_back);
            this.k = (TextView) view.findViewById(R.id.booster_name);
            this.l = view.findViewById(R.id.booster_center_light);
            this.m = (ProgressCircle) view.findViewById(R.id.booster_center_progress);
            this.n = (RoundTbImageView) view.findViewById(R.id.booster_center_icon);
            this.o = view.findViewById(R.id.booster_center_icon_mask);
            this.p = (ViewGroup) view.findViewById(R.id.booster_progress_box);
            this.q = (TextView) view.findViewById(R.id.booster_progress_tv);
            this.r = (ViewGroup) view.findViewById(R.id.booster_fail_box);
            this.s = (ViewGroup) view.findViewById(R.id.booster_success_box);
            this.t = (ViewGroup) view.findViewById(R.id.booster_location_box);
            this.u = (TextView) view.findViewById(R.id.booster_location_name);
            this.v = (TextView) view.findViewById(R.id.booster_time);
            this.w = (ViewGroup) view.findViewById(R.id.booster_starting_tips_box);
            this.x = (TextView) view.findViewById(R.id.booster_btn_1);
            this.y = (TextView) view.findViewById(R.id.booster_btn_2);
            this.z = (ImageView) view.findViewById(R.id.booster_location_icon1);
            this.A = (ImageView) view.findViewById(R.id.booster_location_icon2);
            this.B = view.findViewById(R.id.booster_bottom_tips);
            WebPManager.setPureDrawable(this.z, R.drawable.icon_pure_location, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL);
            WebPManager.setPureDrawable(this.A, R.drawable.icon_pure_unfold10, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL);
            c.a.q0.r.v.c d2 = c.a.q0.r.v.c.d(this.x);
            d2.n(R.string.J_X01);
            d2.f(R.color.CAM_X0302);
            c.a.q0.r.v.c d3 = c.a.q0.r.v.c.d(this.y);
            d3.e(R.string.A_X11);
            d3.n(R.string.J_X01);
            d3.f(R.color.CAM_X0101);
            c.a.q0.r.v.c d4 = c.a.q0.r.v.c.d(this.t);
            d4.n(R.string.J_X01);
            d4.f(R.color.CAM_X0613);
            TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0607).into(this.o);
            TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0613).into(this.l);
            this.f41826j.setOnClickListener(new f(this));
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
        c.a.r0.d1.g1.d.b.c(this.D);
    }

    public /* synthetic */ void J(View view) {
        O(this.f41821e.f41837c);
        c.a.r0.d1.g1.d.b.a(this.D);
    }

    public /* synthetic */ void K(View view) {
        c.a.r0.d1.g1.d.b.f(this.D);
        s.i(getActivity(), new c.a.r0.d1.g1.c.h(this));
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
                R(R.string.accelerator_cannot_open_game);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: P */
    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            Tornado.INSTANCE.setAllowedPackages(PACKAGES);
            Tornado.INSTANCE.setToken(this.f41821e.f41842h, new a(this));
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
            new BdTopToast(getContext(), 3000).setIcon(false).setContent(getString(i2)).show(this.f41825i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, layoutInflater, viewGroup, bundle)) == null) ? layoutInflater.inflate(R.layout.fragment_accelerator, viewGroup, false) : (View) invokeLLL.objValue;
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
            c.a.r0.d1.g1.d.b.e(this.E, this.D, this.F);
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
            k kVar = this.f41821e;
            tornado.init(applicationContext, kVar.a, kVar.f41841g, "tieba", c.a.q0.r.e.d());
            Tornado.INSTANCE.setEnv(TornadoENV.PRINT_LOG, "true");
            Tornado.INSTANCE.setEnv(TornadoENV.ENABLE_DEBUG, "false");
            Tornado.INSTANCE.setCallback(new b(this));
            if (this.G) {
                Tornado.INSTANCE.stop();
                this.C.postDelayed(new Runnable() { // from class: c.a.r0.d1.g1.c.f
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
                        this.C.postDelayed(new Runnable() { // from class: c.a.r0.d1.g1.c.d
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
            this.f41823g = (AcceleratorData) intent.getSerializableExtra(AcceleratorActivityConfig.ACCELERATOR_DATA);
            this.f41824h = (PkgNameAndNodeInfoData) intent.getSerializableExtra(AcceleratorActivityConfig.NODE_INFO);
            k kVar = new k(this);
            this.f41821e = kVar;
            kVar.f41836b = this.f41823g.getItemData().mTitle;
            this.f41821e.f41837c = this.f41824h.getPackageName();
            this.f41821e.f41841g = TbadkCoreApplication.getInst().getCuidGalaxy2();
            this.f41821e.f41838d = this.f41824h.getNodeInfo().getNodeTag();
            this.f41821e.f41839e = this.f41824h.getNodeInfo().getNodeName();
            this.f41821e.f41840f = this.f41824h.getGameId();
            this.f41821e.f41842h = this.f41823g.getTokenInfo().getToken();
            this.f41821e.f41843i = this.f41823g.getItemData().mIconUrl;
            this.D = this.f41823g.getItemData().itemId;
            this.E = intent.getStringExtra("fid");
            this.F = intent.getIntExtra("source", 0);
            this.G = intent.getBooleanExtra(AcceleratorActivityConfig.IS_NEW_ITEM, false);
        }
    }

    public final String z(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048600, this, j2)) == null) ? String.format(getString(R.string.accelerator_time_format), Long.valueOf((j2 / 3600) % 24), Long.valueOf((j2 / 60) % 60), Long.valueOf(j2 % 60)) : (String) invokeJ.objValue;
    }
}
