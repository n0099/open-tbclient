package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.messages.gfh.GfhKeyValue;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.payment.PaymentManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.l33;
import com.baidu.tieba.y74;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b04 extends k32 implements p44, l33.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i1;
    public transient /* synthetic */ FieldHolder $fh;
    public DuMixGameSurfaceView F0;
    public View G0;
    public ImageView H0;
    public View I0;
    public ImageView J0;
    public FrameLayout K0;
    public View L0;
    public z64 M0;
    public z64 N0;
    public o44 O0;
    public l33 P0;
    public x64 Q0;
    public TextView R0;
    public boolean S0;
    public m T0;
    public volatile boolean U0;
    public AudioManager V0;
    public boolean W0;
    public l X0;
    public OrientationEventListener Y0;
    public String Z0;
    public GameCloseGuidePopView a1;
    public y74 b1;
    public boolean c1;
    public View d1;
    public boolean e1;
    public long f1;
    public long g1;
    public boolean h1;

    @Override // com.baidu.tieba.k32
    public boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.k32
    public boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes3.dex */
    public class b extends OrientationEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mb2 a;
        public final /* synthetic */ b04 b;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                int b;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && nh3.q(this.a.b.getActivity(), this.a.b.G0) && (b = nh3.b(this.a.b.getActivity())) > 0) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a.b.G0.getLayoutParams();
                    layoutParams.rightMargin += b;
                    this.a.b.G0.setLayoutParams(layoutParams);
                    v04.e().b(b);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(b04 b04Var, Context context, int i, mb2 mb2Var) {
            super(context, i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b04Var, context, Integer.valueOf(i), mb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = b04Var;
            this.a = mb2Var;
        }

        @Override // android.view.OrientationEventListener
        @SuppressLint({"SourceLockedOrientationActivity"})
        public void onOrientationChanged(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(1048576, this, i) != null) || this.b.M0.h()) {
                return;
            }
            if (260 < i && i < 280 && !this.b.Z0.equals("landscape")) {
                this.b.c0.setRequestedOrientation(0);
                this.b.Z0 = "landscape";
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.b.G0.getLayoutParams();
                layoutParams.rightMargin = this.b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07016e);
                this.b.G0.setLayoutParams(layoutParams);
                v04.e().b(0);
                w54.a(this.a, this.b.Z0);
                if (b04.i1) {
                    Log.d("SwanGameFragment", "onOrientationChanged: " + this.b.Z0);
                }
            } else if (80 < i && i < 100 && !this.b.Z0.endsWith("landscapeReverse")) {
                this.b.c0.setRequestedOrientation(8);
                this.b.Z0 = "landscapeReverse";
                w54.a(this.a, this.b.Z0);
                if (b04.i1) {
                    Log.d("SwanGameFragment", "onOrientationChanged: " + this.b.Z0);
                }
                this.b.G0.postDelayed(new a(this), 100L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l implements AudioManager.OnAudioFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b04 a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ l b;

            public a(l lVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = lVar;
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.b.a.F3()) {
                    return;
                }
                int i = this.a;
                if (i != -2) {
                    if (i == -1) {
                        if (b04.i1) {
                            Log.d("SwanGameFragment", "--focusChange AUDIOFOCUS_LOSS");
                        }
                        this.b.a.U2();
                        return;
                    }
                    return;
                }
                if (b04.i1) {
                    Log.d("SwanGameFragment", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                }
                this.b.a.U2();
            }
        }

        public l(b04 b04Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b04Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b04Var;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                yh3.e0(new a(this, i));
            }
        }

        public /* synthetic */ l(b04 b04Var, c cVar) {
            this(b04Var);
        }
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b04 a;

        public a(b04 b04Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b04Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b04Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.K0.removeView(this.a.L0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b04 a;

        public c(b04 b04Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b04Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b04Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                v04.j().a(this.a.d0, this.a.getContext());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnSystemUiVisibilityChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b04 a;

        public d(b04 b04Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b04Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b04Var;
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (b04.i1) {
                    Log.d("SwanGameFragment", "onSystemUiVisibilityChange:" + i + ",mIsForeground:" + this.a.U0);
                }
                if (this.a.U0 || this.a.E3()) {
                    ng3.e(this.a.c0);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b04 a;

        public e(b04 b04Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b04Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b04Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int e = nh3.e(this.a.getContext());
                if (nh3.q(this.a.getActivity(), this.a.G0) && !((SwanAppActivity) this.a.getActivity()).i0()) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a.G0.getLayoutParams();
                    layoutParams.topMargin = this.a.G0.getTop() + e;
                    this.a.G0.setLayoutParams(layoutParams);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b04 a;

        public f(b04 b04Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b04Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b04Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.j2();
                hb3 hb3Var = new hb3();
                hb3Var.e = SupportMenuInflater.XML_MENU;
                this.a.A1(hb3Var);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b04 a;

        public g(b04 b04Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b04Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b04Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (b04.i1 && d03.e()) {
                    return;
                }
                e43 M = e43.M();
                if (M != null && TextUtils.equals(e43.g0(), "7TxyeScrKPj02EATE68RBG5Z8f46a8So")) {
                    this.a.L3();
                } else if (M != null && mh2.a().b()) {
                    this.a.K3("exitButton");
                } else {
                    r04 r04Var = new r04();
                    r04Var.e();
                    if (r04Var.f()) {
                        v04.h().a(this.a.c0, r04Var, this.a.s3());
                    } else {
                        this.a.K3("exitButton");
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements y74.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b04 a;

        public h(b04 b04Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b04Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b04Var;
        }

        @Override // com.baidu.tieba.y74.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.H3("pandacontinue");
            this.a.b1.dismiss();
        }

        @Override // com.baidu.tieba.y74.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.a.H3("pandaclose");
            this.a.b1.dismiss();
        }

        @Override // com.baidu.tieba.y74.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) {
                return;
            }
            this.a.H3("pandaexit");
            this.a.b1.dismiss();
            this.a.r3();
        }
    }

    /* loaded from: classes3.dex */
    public class i implements GameCloseGuidePopView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b04 a;

        public i(b04 b04Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b04Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b04Var;
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.r3();
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.a.r3();
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void c() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a.a1 != null) {
                this.a.K0.removeView(this.a.a1);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements v14 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b04 a;

        public j(b04 b04Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b04Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b04Var;
        }

        @Override // com.baidu.tieba.v14
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.r3();
        }
    }

    /* loaded from: classes3.dex */
    public class k implements GameCloseGuidePopView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b04 a;

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        public k(b04 b04Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b04Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b04Var;
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.d1 != null) {
                    this.a.K0.removeView(this.a.d1);
                    this.a.d1 = null;
                }
                this.a.r3();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class m extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<TextView> a;
        public WeakReference<DuMixGameSurfaceView> b;

        public m(TextView textView, DuMixGameSurfaceView duMixGameSurfaceView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {textView, duMixGameSurfaceView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(textView);
            this.b = new WeakReference<>(duMixGameSurfaceView);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int fps;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                TextView textView = this.a.get();
                DuMixGameSurfaceView duMixGameSurfaceView = this.b.get();
                if (textView != null) {
                    if (duMixGameSurfaceView == null) {
                        fps = 0;
                    } else {
                        fps = duMixGameSurfaceView.getFPS();
                    }
                    String valueOf = String.valueOf(fps);
                    textView.setText(valueOf);
                    if (b04.i1) {
                        Log.d("SwanGameFragment", "gameFps:" + valueOf);
                    }
                }
                sendEmptyMessageDelayed(0, 500L);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947591139, "Lcom/baidu/tieba/b04;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947591139, "Lcom/baidu/tieba/b04;");
                return;
            }
        }
        i1 = ok1.a;
    }

    public static b04 G3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new b04();
        }
        return (b04) invokeV.objValue;
    }

    public boolean D3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return !this.U0;
        }
        return invokeV.booleanValue;
    }

    public final boolean E3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            n32 M1 = M1();
            if (M1 != null && (M1.m() instanceof b04)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.k32
    public void M2() {
        DuMixGameSurfaceView duMixGameSurfaceView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (duMixGameSurfaceView = this.F0) != null && duMixGameSurfaceView.getV8Engine() != null) {
            this.F0.getV8Engine().dispatchEvent(new JSEvent("sharebtn"));
        }
    }

    public final void O3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && vh3.F(this.c0)) {
            w33.f(ln2.c(), R.string.obfuscated_res_0x7f0f0183).G();
            this.c0.finishAndRemoveTask();
        }
    }

    @Override // com.baidu.tieba.p44
    @NonNull
    public o44 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.O0;
        }
        return (o44) invokeV.objValue;
    }

    @Override // com.baidu.tieba.l33.a
    public l33 d() {
        InterceptResult invokeV;
        z64 z64Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.P0 == null && (z64Var = this.N0) != null && z64Var.getRootView() != null) {
                this.P0 = new l33(this, this.N0.getRootView(), 0);
            }
            return this.P0;
        }
        return (l33) invokeV.objValue;
    }

    public final v14 s3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return new j(this);
        }
        return (v14) invokeV.objValue;
    }

    public final GameCloseGuidePopView.e t3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return new k(this);
        }
        return (GameCloseGuidePopView.e) invokeV.objValue;
    }

    @NonNull
    public x64 u3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.Q0;
        }
        return (x64) invokeV.objValue;
    }

    public View v3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.G0;
        }
        return (View) invokeV.objValue;
    }

    public z64 w3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.M0;
        }
        return (z64) invokeV.objValue;
    }

    public la4 x3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.g0;
        }
        return (la4) invokeV.objValue;
    }

    public z64 y3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.N0;
        }
        return (z64) invokeV.objValue;
    }

    public final void z3() {
        DuMixGameSurfaceView duMixGameSurfaceView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048615, this) != null) || (duMixGameSurfaceView = this.F0) == null) {
            return;
        }
        duMixGameSurfaceView.setOnSystemUiVisibilityChangeListener(new d(this));
    }

    public b04() {
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
        this.O0 = new o44();
        this.Q0 = new x64();
        this.U0 = true;
        this.Z0 = "landscape";
        this.c1 = false;
        this.h1 = false;
    }

    public final boolean F3() {
        InterceptResult invokeV;
        boolean booleanValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            e43 M = e43.M();
            if (M == null) {
                booleanValue = false;
            } else {
                booleanValue = M.U().c("key_audio_is_mix_with_other", Boolean.FALSE).booleanValue();
            }
            if (i1) {
                Log.d("SwanGameFragment", "   isMixWithOther -> " + booleanValue);
            }
            return booleanValue;
        }
        return invokeV.booleanValue;
    }

    public boolean L3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.b1 == null) {
                y74 y74Var = new y74(getContext());
                this.b1 = y74Var;
                y74Var.e(new h(this));
            }
            H3("pandadialog");
            this.b1.show();
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void M3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.S0) {
                if (i1) {
                    Log.d("SwanGameFragment", "Fps monitor already started");
                    return;
                }
                return;
            }
            this.S0 = true;
            m mVar = new m(this.R0, this.F0);
            this.T0 = mVar;
            mVar.sendEmptyMessage(0);
            if (i1) {
                Log.d("SwanGameFragment", "Start fps monitor");
            }
        }
    }

    public final void N3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (!this.S0) {
                if (i1) {
                    Log.d("SwanGameFragment", "fps monitor not started yet");
                    return;
                }
                return;
            }
            this.S0 = false;
            m mVar = this.T0;
            if (mVar != null) {
                mVar.removeMessages(0);
                this.T0 = null;
            }
            if (i1) {
                Log.d("SwanGameFragment", "Stop fps monitor");
            }
        }
    }

    public void U2() {
        l lVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048592, this) != null) || !this.W0) {
            return;
        }
        AudioManager audioManager = this.V0;
        if (audioManager != null && (lVar = this.X0) != null) {
            audioManager.abandonAudioFocus(lVar);
            this.V0 = null;
            this.X0 = null;
        }
        this.W0 = false;
        if (i1) {
            Log.d("SwanGameFragment", "   abandonAudioFocus");
        }
    }

    @Override // com.baidu.tieba.k32, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (i1) {
                Log.d("SwanGameFragment", "onPause() obj: " + this);
            }
            super.onPause();
            if (U()) {
                pause();
            }
        }
    }

    @Override // com.baidu.tieba.k32, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (i1) {
                Log.d("SwanGameFragment", "onResume() obj: " + this);
            }
            super.onResume();
            if (U()) {
                resume();
            }
        }
    }

    public final void r3() {
        Activity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (activity = this.c0) != null && (activity instanceof SwanAppActivity)) {
            activity.moveTaskToBack(true);
            hb3 hb3Var = new hb3();
            hb3Var.e = "close";
            A1(hb3Var);
            ((SwanAppActivity) this.c0).Y(1);
            gi3.b().e(2);
            sx3.g("0");
        }
    }

    public final void H3(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && !TextUtils.isEmpty(str)) {
            hb3 hb3Var = new hb3();
            hb3Var.e = str;
            A1(hb3Var);
        }
    }

    public void J3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.c1 = z;
        }
    }

    @Override // com.baidu.tieba.k32, com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            O3();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void u0(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, bundle) == null) {
            super.u0(bundle);
            yg3.j(new c(this), "SwanGamePageHistory");
        }
    }

    public final void A3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f092318);
            this.G0 = findViewById;
            findViewById.post(new e(this));
            this.H0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09231a);
            this.I0 = view2.findViewById(R.id.obfuscated_res_0x7f09231b);
            this.J0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f092319);
            this.H0.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080124));
            this.J0.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f08010f));
            this.I0.setBackgroundResource(R.color.obfuscated_res_0x7f060391);
            this.G0.setBackgroundResource(R.drawable.obfuscated_res_0x7f080120);
            this.H0.setOnClickListener(new f(this));
            this.J0.setOnClickListener(new g(this));
        }
    }

    public void C3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            FrameLayout frameLayout = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f09018f);
            this.K0 = frameLayout;
            DuMixGameSurfaceView r = e04.m().r();
            this.F0 = r;
            if (r != null && r.getParent() == null) {
                frameLayout.addView(this.F0, 0, new FrameLayout.LayoutParams(-1, -1));
                if (i1) {
                    Log.d("SwanGameFragment", "SwanGameCoreRuntime GameSurfaceView is added");
                }
            }
            if (i1 && !d03.n()) {
                View inflate = ((ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f09018d)).inflate();
                if (inflate != null) {
                    this.R0 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09018c);
                }
                M3();
            }
            A3(view2);
            this.N0 = new z64((FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090190));
            this.M0 = new z64(this.K0);
        }
    }

    public boolean K3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            String a2 = x74.a();
            if (TextUtils.equals(a2, x74.b(GfhKeyValue.TYPE_DATE))) {
                if (TextUtils.equals(str, "exitButton")) {
                    r3();
                    return false;
                }
                return false;
            }
            View a3 = v04.e().a(this.c0, t3());
            this.d1 = a3;
            if (a3 != null) {
                this.K0.addView(a3);
                this.e1 = true;
                x74.c(GfhKeyValue.TYPE_DATE, a2);
                return true;
            }
            if (this.a1 == null) {
                GameCloseGuidePopView gameCloseGuidePopView = new GameCloseGuidePopView(getContext());
                this.a1 = gameCloseGuidePopView;
                gameCloseGuidePopView.setOnClickListener(new i(this));
            }
            this.K0.addView(this.a1);
            x74.c(GfhKeyValue.TYPE_DATE, a2);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void B3() {
        FragmentActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (activity = getActivity()) == null) {
            return;
        }
        if (this.c1) {
            la4 la4Var = this.g0;
            if (la4Var != null && la4Var.i()) {
                this.g0.g(false);
            }
            this.g0 = null;
            this.c1 = false;
        }
        if (this.h0 == null) {
            this.h0 = new SwanAppMenuHeaderView(getContext());
        }
        if (this.g0 == null) {
            la4 la4Var2 = new la4(activity, this.G0, 0, ln2.K(), new nj3());
            this.g0 = la4Var2;
            la4Var2.m(ng3.c());
            this.O0.b(this.g0);
            sl1 F = rp2.U().F();
            if (F != null) {
                F.b(this.g0);
            }
            new ut2(this.g0, this, this.h0).z();
        }
    }

    @Override // com.baidu.tieba.k32
    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (PaymentManager.k()) {
                return PaymentManager.k();
            }
            e43 M = e43.M();
            if (M != null && TextUtils.equals(e43.g0(), "7TxyeScrKPj02EATE68RBG5Z8f46a8So")) {
                return L3();
            }
            if (M != null && mh2.a().b()) {
                return K3(com.alipay.sdk.widget.d.x);
            }
            r04 r04Var = new r04();
            r04Var.e();
            if (r04Var.f()) {
                v04.h().a(this.c0, r04Var, s3());
                return true;
            }
            return K3(com.alipay.sdk.widget.d.x);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.k32
    public void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            Context context = getContext();
            if (context instanceof Activity) {
                fh3.a(context, ((Activity) context).getWindow().getDecorView().getWindowToken());
            }
            B3();
            SwanAppMenuHeaderView swanAppMenuHeaderView = this.h0;
            if (swanAppMenuHeaderView != null) {
                swanAppMenuHeaderView.setAttentionBtnStates(cb2.n(d43.K().getAppId()));
            }
            if (e43.b0() != null) {
                this.g0.o(e43.b0().W().d0());
            }
            this.g0.u(ln2.M().a(), H1(), this.h0, false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            if (i1) {
                Log.d("SwanGameFragment", "onDestroy() obj: " + this);
                N3();
            }
            DuMixGameSurfaceView duMixGameSurfaceView = this.F0;
            if (duMixGameSurfaceView != null) {
                duMixGameSurfaceView.setOnSystemUiVisibilityChangeListener(null);
                this.F0.q();
            }
            if (this.e1) {
                this.d1 = null;
                v04.e().release();
            }
            z64 z64Var = this.M0;
            if (z64Var != null) {
                z64Var.l();
            }
            z64 z64Var2 = this.N0;
            if (z64Var2 != null) {
                z64Var2.l();
            }
            this.Q0.d();
            dr2.c();
            o04.g(false);
            o04.k();
            super.y0();
        }
    }

    public final void I3() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || F3() || this.W0) {
            return;
        }
        if (this.V0 == null) {
            AudioManager audioManager = (AudioManager) AppRuntime.getAppContext().getSystemService("audio");
            this.V0 = audioManager;
            if (audioManager == null) {
                return;
            }
        }
        if (this.X0 == null) {
            this.X0 = new l(this, null);
        }
        boolean z = true;
        if (this.V0.requestAudioFocus(this.X0, 3, 1) != 1) {
            z = false;
        }
        this.W0 = z;
        if (i1) {
            Log.d("SwanGameFragment", "   requestAudioFocus");
        }
    }

    @Override // com.baidu.tieba.k32, com.baidu.swan.support.v4.app.Fragment
    public void m1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            super.m1(z);
            if (i1) {
                Log.d("SwanGameFragment", "setUserVisibleHint isVisibleToUser: " + z);
            }
            if (!k0()) {
                return;
            }
            if (z) {
                resume();
            } else {
                pause();
            }
        }
    }

    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.U0 = false;
            U2();
            if (this.L0 == null) {
                this.L0 = new View(this.c0);
            }
            this.K0.removeView(this.L0);
            this.K0.addView(this.L0, new FrameLayout.LayoutParams(-1, -1));
            GameCloseGuidePopView gameCloseGuidePopView = this.a1;
            if (gameCloseGuidePopView != null) {
                this.K0.removeView(gameCloseGuidePopView);
                this.a1 = null;
            }
            z64 z64Var = this.M0;
            if (z64Var != null) {
                z64Var.k();
            }
            z64 z64Var2 = this.N0;
            if (z64Var2 != null) {
                z64Var2.k();
            }
            DuMixGameSurfaceView duMixGameSurfaceView = this.F0;
            if (duMixGameSurfaceView != null && duMixGameSurfaceView.getV8Engine() != null) {
                mb2 v8Engine = this.F0.getV8Engine();
                if (i1) {
                    Log.d("SwanGameFragment", "pause() obj: " + this + " ,v8Engine: " + v8Engine);
                }
                if (!v8Engine.s0()) {
                    v8Engine.onPause();
                    v8Engine.dispatchEvent(new JSEvent("apphide"));
                    x54.a(v8Engine);
                    EventTarget n = v8Engine.n();
                    if (n instanceof ly3) {
                        ((ly3) n).hideKeyboard();
                    }
                }
                hy3.h().l();
                if (this.h1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.g1 = currentTimeMillis;
                    lz3.d(this.f1, currentTimeMillis);
                }
                rx3.o().n();
                dr2.j(false);
                this.F0.s();
                OrientationEventListener orientationEventListener = this.Y0;
                if (orientationEventListener != null) {
                    orientationEventListener.disable();
                }
                la4 la4Var = this.g0;
                if (la4Var != null && la4Var.i()) {
                    this.g0.g(false);
                }
            }
        }
    }

    public void resume() {
        Activity activity;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            I3();
            DuMixGameSurfaceView duMixGameSurfaceView = this.F0;
            if (duMixGameSurfaceView != null && duMixGameSurfaceView.getV8Engine() != null) {
                mb2 v8Engine = this.F0.getV8Engine();
                if (i1) {
                    Log.d("SwanGameFragment", "resume() obj: " + this + " ,v8Engine: " + v8Engine);
                }
                this.U0 = true;
                this.F0.t();
                hy3.h().k();
                x54.b(v8Engine);
                Activity activity2 = this.c0;
                if (activity2 != null && (activity2 instanceof SwanAppActivity)) {
                    v8Engine.dispatchEvent(new h24(((SwanAppActivity) activity2).S()));
                }
                v8Engine.onResume();
                if (this.K0 != null && this.L0 != null) {
                    yh3.b0(new a(this), 500L);
                }
                Activity activity3 = this.c0;
                if (activity3 != null && (activity3 instanceof SwanAppActivity)) {
                    boolean i0 = ((SwanAppActivity) activity3).i0();
                    if (!this.M0.h()) {
                        Activity activity4 = this.c0;
                        if (i0) {
                            if (this.Z0.equals("landscape")) {
                                i2 = 0;
                            } else {
                                i2 = 8;
                            }
                        } else {
                            i2 = 1;
                        }
                        activity4.setRequestedOrientation(i2);
                        this.M0.n(i0);
                        this.N0.n(i0);
                    }
                    ng3.e(this.c0);
                }
                if (this.Y0 == null) {
                    this.Y0 = new b(this, this.c0, 3, v8Engine);
                }
                if (this.Y0.canDetectOrientation() && (activity = this.c0) != null && ((SwanAppActivity) activity).i0()) {
                    this.Y0.enable();
                } else {
                    this.Y0.disable();
                }
                this.h1 = false;
                if (e43.M() != null && e43.M().Y() != null) {
                    try {
                        this.h1 = new JSONObject(e43.M().Y().P().getString(PrefetchEvent.EVENT_DATA_EXTRA_DATA)).optBoolean("needDuration");
                        this.f1 = System.currentTimeMillis();
                    } catch (Exception e2) {
                        if (i1) {
                            e2.printStackTrace();
                        }
                    }
                }
                if (this.d1 != null) {
                    v04.e().c();
                }
                rx3.o().x();
                dr2.j(true);
                z64 z64Var = this.M0;
                if (z64Var != null) {
                    z64Var.m();
                }
                z64 z64Var2 = this.N0;
                if (z64Var2 != null) {
                    z64Var2.m();
                }
                O3();
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View x0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048611, this, layoutInflater, viewGroup, bundle)) == null) {
            if (i1) {
                Log.d("SwanGameFragment", "onCreateView obj: " + this);
            }
            if (nh3.p(getActivity())) {
                nh3.s(getActivity());
            }
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d008b, viewGroup, false);
            C3(inflate);
            z3();
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }
}
