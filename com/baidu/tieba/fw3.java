package com.baidu.tieba;

import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.ad.component.AdImageVIew;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.view.InteractiveEndFrameView;
import com.baidu.swan.game.ad.view.RewardLoadWebView;
import com.baidu.swan.game.ad.view.RewardVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class fw3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public kv3 A;
    public boolean B;
    public Runnable C;
    public View.OnClickListener D;
    public View.OnClickListener E;
    public View.OnClickListener F;
    public RelativeLayout a;
    public View b;
    public RewardVideoView c;
    public fv3 d;
    public int e;
    public ProgressBar f;
    public LinearLayout g;
    public ImageView h;
    public TextView i;
    public TextView j;
    public View k;
    public TextView l;
    public RelativeLayout m;
    public int n;
    public int o;
    public Context p;
    public AdElementInfo q;
    public final Handler r;
    public xu3 s;
    public RewardLoadWebView t;
    public RewardLoadWebView u;
    public InteractiveEndFrameView v;
    public Resources w;
    public gv3 x;
    public boolean y;
    public yu3 z;

    public abstract void C(RelativeLayout relativeLayout, AdElementInfo adElementInfo);

    public abstract String q();

    public abstract View u();

    /* loaded from: classes6.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }

        public a(fw3 fw3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw3 a;

        public b(fw3 fw3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fw3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.d != null) {
                this.a.K();
                int currentPosition = this.a.d.getCurrentPosition();
                fw3 fw3Var = this.a;
                fw3Var.J(fw3Var.e, currentPosition);
                int min = Math.min(currentPosition + 1000, this.a.e);
                this.a.f.setProgress(min / 1000);
                if (min < this.a.e) {
                    this.a.r.postDelayed(this.a.C, 100L);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw3 a;

        public c(fw3 fw3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fw3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.c == null) {
                return;
            }
            if (this.a.c.d()) {
                this.a.h.setImageResource(R.drawable.obfuscated_res_0x7f081139);
                this.a.c.e(false);
                return;
            }
            this.a.h.setImageResource(R.drawable.obfuscated_res_0x7f081138);
            this.a.c.e(true);
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw3 a;

        public d(fw3 fw3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fw3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.s != null) {
                this.a.s.e(view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw3 a;

        public e(fw3 fw3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fw3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.z != null) {
                this.a.z.f(view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements RewardVideoView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw3 a;

        public f(fw3 fw3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fw3Var;
        }

        @Override // com.baidu.swan.game.ad.view.RewardVideoView.a
        public void onVolumeChanged(int i) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                AudioManager audioManager = (AudioManager) this.a.p.getSystemService("audio");
                if (Build.VERSION.SDK_INT >= 28) {
                    i2 = audioManager.getStreamMinVolume(3);
                } else {
                    i2 = 0;
                }
                if (i > i2 && this.a.c.d()) {
                    this.a.h.setImageResource(R.drawable.obfuscated_res_0x7f081139);
                    this.a.c.e(false);
                } else if (i <= i2 && !this.a.c.d()) {
                    this.a.h.setImageResource(R.drawable.obfuscated_res_0x7f081138);
                    this.a.c.e(true);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;

        public g(fw3 fw3Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw3Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int h = cv3.b().h();
                if (cv3.b().o(this.a)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a.getLayoutParams();
                    layoutParams.topMargin = this.a.getTop() + h;
                    this.a.setLayoutParams(layoutParams);
                }
            }
        }
    }

    public fw3(Context context, AdElementInfo adElementInfo, gv3 gv3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, adElementInfo, gv3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = new Handler();
        this.B = false;
        this.C = new b(this);
        this.D = new c(this);
        this.E = new d(this);
        this.F = new e(this);
        this.p = context;
        this.q = adElementInfo;
        this.n = cv3.b().k();
        this.o = cv3.b().j();
        this.w = this.p.getResources();
        this.x = gv3Var;
        this.y = ew3.i();
        w();
        this.A = new kv3(this.p);
        x(this.g);
    }

    public void E(xu3 xu3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, xu3Var) == null) {
            this.s = xu3Var;
        }
    }

    public void F(yu3 yu3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, yu3Var) == null) {
            this.z = yu3Var;
        }
    }

    public void G(String str) {
        RewardVideoView rewardVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && (rewardVideoView = this.c) != null) {
            rewardVideoView.f(str);
        }
    }

    public final void x(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, view2) == null) {
            view2.post(new g(this, view2));
        }
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            m();
            I();
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            m();
            I();
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            H();
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f != null) {
            this.r.removeCallbacksAndMessages(null);
            this.r.postDelayed(this.C, 0L);
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.f != null) {
            this.r.removeCallbacksAndMessages(null);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            I();
            RewardLoadWebView rewardLoadWebView = this.t;
            if (rewardLoadWebView != null) {
                rewardLoadWebView.c();
                this.t = null;
            }
            RewardLoadWebView rewardLoadWebView2 = this.u;
            if (rewardLoadWebView2 != null) {
                rewardLoadWebView2.c();
                this.u = null;
            }
            InteractiveEndFrameView interactiveEndFrameView = this.v;
            if (interactiveEndFrameView != null) {
                interactiveEndFrameView.t();
                this.v = null;
            }
        }
    }

    public RewardVideoView.a o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return new f(this);
        }
        return (RewardVideoView.a) invokeV.objValue;
    }

    public View r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public fv3 s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            RewardVideoView rewardVideoView = this.c;
            if (rewardVideoView != null) {
                return rewardVideoView.getPlayer();
            }
            return null;
        }
        return (fv3) invokeV.objValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.B;
        }
        return invokeV.booleanValue;
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.a.setOnTouchListener(new a(this));
            this.h.setOnClickListener(this.D);
            this.i.setOnClickListener(this.E);
        }
    }

    public void y() {
        fv3 fv3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (fv3Var = this.d) != null) {
            this.e = fv3Var.getDuration();
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            I();
        }
    }

    public final void J(long j, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048585, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) != null) || !this.y) {
            return;
        }
        if (j > 15000 && i <= 15000) {
            if (i < 5000) {
                this.g.setVisibility(8);
                this.j.setVisibility(8);
                this.k.setVisibility(8);
                this.i.setVisibility(8);
                return;
            } else if (i < 10000) {
                this.g.setVisibility(0);
                this.j.setVisibility(0);
                this.k.setVisibility(8);
                this.i.setVisibility(8);
                return;
            } else {
                this.g.setVisibility(0);
                this.j.setVisibility(0);
                this.k.setVisibility(0);
                this.i.setVisibility(0);
                return;
            }
        }
        this.j.setText(R.string.obfuscated_res_0x7f0f15fa);
        this.i.setVisibility(0);
        this.k.setVisibility(0);
        this.j.setVisibility(0);
    }

    public final void K() {
        fv3 fv3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.q != null && (fv3Var = this.d) != null) {
            this.e = fv3Var.getDuration();
            int min = Math.min(this.q.getRewardTime(), this.e / 1000);
            int skipTime = this.q.getSkipTime();
            int currentPosition = this.d.getCurrentPosition() / 1000;
            String string = this.p.getResources().getString(R.string.obfuscated_res_0x7f0f15fc);
            String string2 = this.p.getResources().getString(R.string.obfuscated_res_0x7f0f15fd);
            if (currentPosition <= min) {
                this.j.setText(String.format(string, Integer.valueOf(min - currentPosition)));
            } else {
                this.j.setText(String.format(string2, Integer.valueOf((this.e / 1000) - currentPosition)));
            }
            if (currentPosition <= skipTime) {
                this.i.setVisibility(8);
                this.k.setVisibility(8);
                return;
            }
            this.i.setVisibility(0);
            this.k.setVisibility(0);
        }
    }

    public void p() {
        AdElementInfo adElementInfo;
        fv3 fv3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            H();
            ProgressBar progressBar = this.f;
            if (progressBar != null && (fv3Var = this.d) != null) {
                progressBar.setMax(fv3Var.getDuration() / 1000);
                this.f.setVisibility(4);
            }
            if (this.j != null && this.d != null && (adElementInfo = this.q) != null) {
                this.j.setText(String.format(this.p.getResources().getString(R.string.obfuscated_res_0x7f0f15fc), Integer.valueOf(Math.max(this.q.getSkipTime(), Math.min(adElementInfo.getRewardTime(), this.d.getDuration())) / 1000)));
                if (this.q.getSkipTime() >= 0) {
                    this.i.setVisibility(8);
                    this.k.setVisibility(8);
                }
            }
            if (this.g.getVisibility() != 0) {
                this.g.setVisibility(0);
            }
            if (this.m.getVisibility() != 0) {
                this.m.setAnimation(AnimationUtils.loadAnimation(this.p, R.anim.obfuscated_res_0x7f0100f8));
                this.m.setVisibility(0);
            }
            fv3 fv3Var2 = this.d;
            if (fv3Var2 != null) {
                J(fv3Var2.getDuration(), this.d.getCurrentPosition());
            }
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            TextView textView = new TextView(this.p);
            this.l = textView;
            textView.setBackground(this.w.getDrawable(R.drawable.obfuscated_res_0x7f081135));
            this.l.setTextColor(this.w.getColor(R.color.obfuscated_res_0x7f0604ef));
            this.l.setText(this.w.getString(R.string.obfuscated_res_0x7f0f0482));
            this.l.setTextSize(2, 16.0f);
            this.l.setOnClickListener(this.E);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dw3.a(96.0f), dw3.a(30.0f));
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.addRule(13);
            this.l.setGravity(17);
            layoutParams.setMargins(0, this.g.getTop(), this.w.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070484), 0);
            this.a.addView(this.l, layoutParams);
            x(this.l);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.a != null) {
            this.B = true;
            this.g.setVisibility(4);
            this.m.setVisibility(4);
            this.i.setVisibility(4);
            if (!TextUtils.isEmpty(this.q.getEndFrameUrl())) {
                InteractiveEndFrameView interactiveEndFrameView = new InteractiveEndFrameView(this.p);
                this.v = interactiveEndFrameView;
                interactiveEndFrameView.s(this.q, this.a);
                this.a.addView(this.v, new RelativeLayout.LayoutParams(-1, -1));
                tv3.i(this.q, this.A);
            } else if (!TextUtils.isEmpty(this.q.getEndFrameHtml())) {
                RewardLoadWebView rewardLoadWebView = new RewardLoadWebView(this.p);
                this.u = rewardLoadWebView;
                rewardLoadWebView.b("reward_end_frame_html", this.q, this.x);
                this.a.addView(this.u, new RelativeLayout.LayoutParams(-1, -1));
                tv3.i(this.q, this.A);
            } else {
                View inflate = LayoutInflater.from(this.p).inflate(R.layout.obfuscated_res_0x7f0d075a, (ViewGroup) null);
                this.a.addView(inflate, new RelativeLayout.LayoutParams(-1, -1));
                ((AdImageVIew) inflate.findViewById(R.id.obfuscated_res_0x7f091ff4)).setImageUrl(this.q.getIconUrl());
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092685)).setText(this.q.getTitle());
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0908cd)).setText(this.q.getDescription());
                Button button = (Button) inflate.findViewById(R.id.obfuscated_res_0x7f09097f);
                if (this.q.getActionType() == 1) {
                    button.setText(this.p.getResources().getString(R.string.obfuscated_res_0x7f0f138a));
                }
                if (this.q.getActionType() == 2) {
                    button.setText(this.p.getResources().getString(R.string.obfuscated_res_0x7f0f1541));
                }
                inflate.findViewById(R.id.obfuscated_res_0x7f090817).setOnClickListener(this.F);
                button.setOnClickListener(this.F);
            }
            l();
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.b = u();
            this.b.setLayoutParams(new RelativeLayout.LayoutParams(this.n, this.o));
            this.a = (RelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091ff8);
            RewardVideoView rewardVideoView = (RewardVideoView) this.b.findViewById(R.id.video_view);
            this.c = rewardVideoView;
            rewardVideoView.setVolumeChangeListener(o());
            if (this.y) {
                this.c.setOnClickListener(this.F);
            }
            this.f = (ProgressBar) this.b.findViewById(R.id.obfuscated_res_0x7f092446);
            this.g = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f092ab7);
            this.h = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f092ab8);
            if (this.c.d()) {
                this.h.setImageResource(R.drawable.obfuscated_res_0x7f081138);
            }
            this.i = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090778);
            this.j = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09077b);
            this.k = this.b.findViewById(R.id.obfuscated_res_0x7f09077c);
            this.m = (RelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f09035f);
            if (!TextUtils.isEmpty(this.q.getBannerHtml())) {
                this.t = new RewardLoadWebView(this.p);
                this.m.addView(this.t, new RelativeLayout.LayoutParams(-1, -1));
                C(this.m, this.q);
                this.t.b(q(), this.q, this.x);
            } else {
                View inflate = LayoutInflater.from(this.p).inflate(R.layout.obfuscated_res_0x7f0d0759, (ViewGroup) null);
                this.m.addView(inflate);
                ((AdImageVIew) inflate.findViewById(R.id.obfuscated_res_0x7f091ff4)).setImageUrl(this.q.getIconUrl());
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092685)).setText(this.q.getTitle());
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0908cd)).setText(this.q.getDescription());
                Button button = (Button) inflate.findViewById(R.id.obfuscated_res_0x7f09097f);
                if (this.q.getActionType() == 1) {
                    button.setText(this.p.getResources().getString(R.string.obfuscated_res_0x7f0f138a));
                }
                if (this.q.getActionType() == 2) {
                    button.setText(this.p.getResources().getString(R.string.obfuscated_res_0x7f0f1541));
                }
                this.m.setOnClickListener(this.F);
                button.setOnClickListener(this.F);
            }
            this.d = this.c.getPlayer();
            v();
        }
    }
}
