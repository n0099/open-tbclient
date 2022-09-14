package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.nadcore.player.helper.BdVideoGesture;
import com.baidu.nadcore.player.strategy.IVideoUpdateStrategy;
import com.baidu.nadcore.player.utils.BdNetUtils;
import com.baidu.nadcore.video.videoplayer.ui.full.BdThumbSeekBar;
import com.baidu.nadcore.video.videoplayer.ui.full.BdVideoCacheView;
import com.baidu.nadcore.video.videoplayer.ui.full.BdVideoNewCacheView;
import com.baidu.nadcore.video.videoplayer.ui.full.BdVideoPopImageView;
import com.baidu.nadcore.video.videoplayer.ui.full.BdVideoSeekbarImageView;
import com.baidu.nadcore.video.videoplayer.widget.LockImageView;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class gw0 extends cw0 implements View.OnClickListener, eu0 {
    public static /* synthetic */ Interceptable $ic;
    public static final int A;
    public static final int x;
    public static final int y;
    public static final int z;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout e;
    public BdVideoSeekbarImageView f;
    public BdVideoSeekbarImageView g;
    public BdVideoPopImageView h;
    public BdVideoPopImageView i;
    public BdVideoPopImageView j;
    public BdVideoCacheView k;
    public BdThumbSeekBar l;
    public LockImageView m;
    public BdVideoGesture n;
    public GestureDetector o;
    public GestureDetector.SimpleOnGestureListener p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public float u;
    public String v;
    public final Runnable w;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gw0 a;

        public a(gw0 gw0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gw0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.t) {
                gw0 gw0Var = this.a;
                gw0Var.n0(Math.max(0, gw0Var.getCurrentPosition() - 5));
                Handler handler = this.a.d;
                if (handler != null) {
                    handler.postDelayed(this, 1000L);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends FrameLayout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gw0 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(gw0 gw0Var, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw0Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gw0Var;
        }

        @Override // android.view.View
        public void onConfigurationChanged(Configuration configuration) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, configuration) == null) {
                super.onConfigurationChanged(configuration);
                gw0 gw0Var = this.a;
                Context context = gw0Var.c;
                if (context != null) {
                    gw0Var.n.f(context);
                }
                if (this.a.t) {
                    this.a.k0();
                }
            }
        }

        @Override // android.view.View
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
                if (!this.a.u().p1()) {
                    if (this.a.t) {
                        if (motionEvent.getAction() == 1 || !this.a.u().Y()) {
                            this.a.k0();
                        }
                        return true;
                    } else if (!this.a.u().V0() || ar0.W0() || this.a.u().A() == null || this.a.u().A().getContentView() == null || this.a.u().A().O() == null || !this.a.u().A().getContentView().onTouchEvent(motionEvent)) {
                        if (this.a.l0() && getParent() != null) {
                            getParent().requestDisallowInterceptTouchEvent(true);
                        }
                        IVideoUpdateStrategy n1 = this.a.u().n1();
                        if (!n1.b()) {
                            return super.onTouchEvent(motionEvent);
                        }
                        if (n1.d()) {
                            boolean V0 = this.a.u().V0();
                            if (this.a.u().o1() != null) {
                                this.a.u().o1().getPage();
                            }
                            if (V0 && !this.a.g0() && this.a.j0(motionEvent)) {
                                return true;
                            }
                            if (this.a.o.onTouchEvent(motionEvent) && this.a.S()) {
                                return true;
                            }
                            if (!ar0.W0() && this.a.e0()) {
                                if (!this.a.u().V0()) {
                                    this.a.U(motionEvent);
                                }
                                if (this.a.g0()) {
                                    getParent().requestDisallowInterceptTouchEvent(true);
                                    return true;
                                } else if (this.a.n.b(motionEvent)) {
                                    return true;
                                }
                            }
                            if (motionEvent.getAction() == 0) {
                                return this.a.i0(motionEvent);
                            }
                            return super.onTouchEvent(motionEvent);
                        }
                        return false;
                    } else {
                        return true;
                    }
                }
                return super.onTouchEvent(motionEvent);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gw0 a;

        public c(gw0 gw0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gw0Var;
        }

        public final void a(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, motionEvent) == null) {
                gw0 gw0Var = this.a;
                if (gw0Var.e == null) {
                    gw0Var.t = false;
                    return;
                }
                if (gw0Var.u().W()) {
                    this.a.u().l0();
                }
                if (this.a.u().Y()) {
                    if (this.a.e.getParent() != null) {
                        this.a.e.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    this.a.t = true;
                    if (this.a.u().V0() && ar0.W0()) {
                        if (this.a.m.getVisibility() == 0) {
                            this.a.s0();
                        }
                    } else {
                        this.a.F(xs0.w(LayerEvent.ACTION_LONG_PRESS));
                    }
                    boolean z = ((double) motionEvent.getX()) > ((double) this.a.e.getWidth()) / 2.0d;
                    if (z) {
                        this.a.v = "speed";
                        this.a.u().z0(this.a.X());
                    } else {
                        this.a.v = "backward";
                        gw0 gw0Var2 = this.a;
                        gw0Var2.d.post(gw0Var2.w);
                    }
                    if (this.a.u().y() != null) {
                        this.a.u().y().D(z, true);
                    }
                }
            }
        }

        public final boolean b(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
                if (!this.a.u().Q() && !this.a.u().R()) {
                    if (this.a.d0()) {
                        c(motionEvent);
                    } else {
                        this.a.s0();
                    }
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        public final boolean c(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
                this.a.e.setVisibility(0);
                if (motionEvent.getAction() != 0 || this.a.u().Q()) {
                    return false;
                }
                this.a.F(xs0.w(LayerEvent.ACTION_TOUCH_DOWN));
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
                oq0 u = this.a.u();
                if (u == null || u.y() == null || ar0.W0()) {
                    return false;
                }
                return u.y().x(motionEvent);
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, motionEvent) == null) && this.a.S() && this.a.T()) {
                a(motionEvent);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) ? b(motionEvent) : invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947808201, "Lcom/baidu/tieba/gw0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947808201, "Lcom/baidu/tieba/gw0;");
                return;
            }
        }
        x = p31.a(124.0f);
        y = p31.a(85.0f);
        z = p31.a(119.0f);
        A = p31.a(50.0f);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gw0(@NonNull Activity activity) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Activity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.q = false;
        this.r = false;
        this.s = true;
        this.t = false;
        this.u = 1.0f;
        this.v = "speed";
        this.w = new a(this);
    }

    @Override // com.baidu.tieba.uv0
    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c0();
            this.e = new b(this, this.c);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(p31.a(300.0f), p31.a(300.0f));
            this.k = new BdVideoNewCacheView(this.c);
            q0(false);
            layoutParams.gravity = 17;
            this.e.addView(this.k, layoutParams);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.gravity = 80;
            layoutParams2.bottomMargin = p31.b(-4.3f);
            BdThumbSeekBar bdThumbSeekBar = new BdThumbSeekBar(this.c, 2);
            this.l = bdThumbSeekBar;
            bdThumbSeekBar.setThumbScaleVisible(false);
            this.l.setDragable(false);
            this.e.addView(this.l, layoutParams2);
            LockImageView lockImageView = new LockImageView(this.c);
            this.m = lockImageView;
            lockImageView.setBackground(this.c.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e2a));
            this.m.e(ar0.W0() ? 1000 : 2000);
            this.m.setOnClickListener(this);
            this.m.setVisibility(4);
            this.e.addView(this.m, Y());
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            layoutParams3.gravity = 17;
            BdVideoSeekbarImageView W = W();
            this.f = W;
            if (W == null) {
                BdVideoSeekbarImageView bdVideoSeekbarImageView = new BdVideoSeekbarImageView(this.c);
                this.f = bdVideoSeekbarImageView;
                bdVideoSeekbarImageView.setIcon(R.drawable.obfuscated_res_0x7f080e30);
                this.f.setWidth(p31.a(124.0f));
                this.f.setHeight(p31.a(85.0f));
            }
            this.f.setVisibility(4);
            this.e.addView(this.f, layoutParams3);
            BdVideoSeekbarImageView V = V();
            this.g = V;
            if (V == null) {
                BdVideoSeekbarImageView bdVideoSeekbarImageView2 = new BdVideoSeekbarImageView(this.c);
                this.g = bdVideoSeekbarImageView2;
                bdVideoSeekbarImageView2.setIcon(R.drawable.obfuscated_res_0x7f080e2f);
                this.g.setWidth(p31.a(124.0f));
                this.g.setHeight(p31.a(85.0f));
            }
            this.g.setVisibility(4);
            this.e.addView(this.g, layoutParams3);
            if (!this.r) {
                BdVideoPopImageView bdVideoPopImageView = new BdVideoPopImageView(this.c);
                this.h = bdVideoPopImageView;
                bdVideoPopImageView.setIcon(R.drawable.obfuscated_res_0x7f080e32);
                this.h.setMsg("100%");
                this.h.setVisibility(4);
                this.e.addView(this.h, layoutParams3);
                BdVideoPopImageView bdVideoPopImageView2 = new BdVideoPopImageView(this.c);
                this.i = bdVideoPopImageView2;
                bdVideoPopImageView2.setMsg("0%");
                this.i.setIcon(R.drawable.obfuscated_res_0x7f080e31);
                this.i.setVisibility(4);
                this.e.addView(this.i, layoutParams3);
            }
            BdVideoPopImageView bdVideoPopImageView3 = new BdVideoPopImageView(this.c);
            this.j = bdVideoPopImageView3;
            bdVideoPopImageView3.setMsg("0%");
            this.j.setIcon(R.drawable.obfuscated_res_0x7f080e2c);
            this.j.setVisibility(4);
            this.e.addView(this.j, layoutParams3);
        }
    }

    public boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? u().V0() : invokeV.booleanValue;
    }

    public void U(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, motionEvent) == null) {
        }
    }

    public BdVideoSeekbarImageView V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (BdVideoSeekbarImageView) invokeV.objValue;
    }

    public BdVideoSeekbarImageView W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (BdVideoSeekbarImageView) invokeV.objValue;
    }

    public final float X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            this.u = u().G();
            float min = Math.min(this.u * bz0.j(), bz0.i());
            return min > 0.0f ? min : this.u;
        }
        return invokeV.floatValue;
    }

    public FrameLayout.LayoutParams Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(p31.a(37.0f), p31.a(37.0f));
            layoutParams.gravity = 16;
            layoutParams.leftMargin = p31.b(15.0f);
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeV.objValue;
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.q) {
                this.l.setVisibility(4);
            } else {
                this.l.setVisibility(0);
            }
        }
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f.setVisibility(4);
            this.g.setVisibility(4);
            if (!this.r) {
                this.h.setVisibility(4);
                this.i.setVisibility(4);
            }
            this.j.setVisibility(4);
            F(xs0.w(LayerEvent.ACTION_POSITION_SLIDE_COMPLETE));
        }
    }

    @Override // com.baidu.tieba.eu0
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            F(xs0.w(LayerEvent.ACTION_ADJUST_VOLUME_COMPLETE));
        }
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.d.sendEmptyMessageDelayed(20, 3000L);
        }
    }

    @Override // com.baidu.tieba.eu0
    public void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i, i2) == null) {
            int r = u().r();
            int h0 = h0(i2 + i, r);
            int i3 = h0 - i;
            boolean z2 = r >= 3600;
            String a2 = c21.a(h0, z2);
            String a3 = c21.a(r, z2);
            if (i3 >= 0) {
                this.f.setVisibility(0);
                this.g.setVisibility(8);
                this.f.setMsg(a2, a3);
                this.f.c(h0, r);
                if (W() == null) {
                    t0(this.f);
                }
            } else {
                this.f.setVisibility(8);
                this.g.setVisibility(0);
                this.g.setMsg(a2, a3);
                this.g.c(h0, r);
                if (V() == null) {
                    t0(this.g);
                }
            }
            this.g.requestLayout();
            this.f.requestLayout();
            ht0 w = xs0.w(LayerEvent.ACTION_POSITION_SLIDE);
            w.n(2, Integer.valueOf(i));
            w.n(3, Integer.valueOf(i3));
            F(w);
        }
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.n = new lt0(this.c, this);
            this.p = new c(this);
            this.o = new GestureDetector(this.c, this.p);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.tieba.uv0, com.baidu.tieba.iu0
    public void d(@NonNull ht0 ht0Var) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, ht0Var) == null) {
            String c3 = ht0Var.c();
            switch (c3.hashCode()) {
                case -1759675333:
                    if (c3.equals(PlayerEvent.ACTION_GO_BACK_OR_FOREGROUND)) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -971135626:
                    if (c3.equals(PlayerEvent.ACTION_PLAYER_DETACH)) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -882902390:
                    if (c3.equals(PlayerEvent.ACTION_SET_DATA_SOURCE)) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -525235558:
                    if (c3.equals(PlayerEvent.ACTION_ON_PREPARED)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -461848373:
                    if (c3.equals(PlayerEvent.ACTION_ON_ERROR)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 154871702:
                    if (c3.equals(PlayerEvent.ACTION_ON_COMPLETE)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1370689931:
                    if (c3.equals(PlayerEvent.ACTION_ON_INFO)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 0) {
                int g = ht0Var.g(1);
                if (701 == g) {
                    q0(true);
                } else if (702 == g) {
                    q0(false);
                } else if (904 == g || g == 956) {
                    q0(false);
                    if (f0()) {
                        p0();
                    }
                }
            } else if (c2 == 1) {
                this.e.setVisibility(4);
                this.n.g();
                a0();
            } else if (c2 == 2 || c2 == 3) {
                q0(false);
            } else if (c2 != 4) {
                if (c2 == 5 && this.t) {
                    k0();
                }
            } else {
                this.l.setProgress(0);
            }
        }
    }

    public boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (u().V0() && ar0.W0()) ? false : true : invokeV.booleanValue;
    }

    public boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? u().V0() : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.eu0
    public void f(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048593, this, f) == null) {
            if (u().f1() == 1) {
                u().y().v();
                return;
            }
            int b2 = (int) ((f / ty0.b(this.c)) * 100.0f);
            if (ty0.c(this.c) == 0) {
                b2 = 0;
            }
            if (!this.r) {
                if (b2 == 0) {
                    if (this.i.getVisibility() == 4) {
                        if (this.h.getVisibility() == 0) {
                            this.h.setVisibility(4);
                            this.h.requestLayout();
                        }
                        this.i.setVisibility(0);
                        this.i.requestLayout();
                    }
                } else if (this.h.getVisibility() == 4) {
                    if (this.i.getVisibility() == 0) {
                        this.i.setVisibility(4);
                        this.i.requestLayout();
                    }
                    this.h.setVisibility(0);
                    this.h.requestLayout();
                }
                BdVideoPopImageView bdVideoPopImageView = this.h;
                bdVideoPopImageView.setMsg(b2 + "%");
                BdVideoPopImageView bdVideoPopImageView2 = this.i;
                bdVideoPopImageView2.setMsg(b2 + "%");
            }
            ty0.d(mi0.b(), (int) f);
            ht0 w = xs0.w(LayerEvent.ACTION_ADJUST_VOLUME);
            w.n(20, Integer.valueOf(b2));
            F(w);
            qy0.b("GestureLayer", "onVolumeSlide : " + f);
        }
    }

    public boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? S() && bz0.r() && T() && u().r() >= 60 : invokeV.booleanValue;
    }

    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.hw0
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.e : (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.eu0
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? u().C() : invokeV.intValue;
    }

    @Override // com.baidu.tieba.iu0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? new int[]{4, 2, 3, 5} : (int[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uv0, com.baidu.tieba.iu0
    public void h(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, playerStatus, playerStatus2) == null) {
            super.h(playerStatus, playerStatus2);
            if (playerStatus == PlayerStatus.PLAYING) {
                this.e.setVisibility(0);
                q0(false);
            } else if (playerStatus == PlayerStatus.PREPARING) {
                q0(true);
                this.e.setVisibility(0);
            }
        }
    }

    public final int h0(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048600, this, i, i2)) == null) {
            if (i < 0) {
                return 0;
            }
            return i > i2 ? i2 : i;
        }
        return invokeII.intValue;
    }

    @Override // com.baidu.tieba.eu0
    public void i(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048601, this, f) == null) {
            if (u().f1() == 1) {
                u().y().v();
                return;
            }
            this.j.setVisibility(0);
            this.j.requestLayout();
            BdVideoPopImageView bdVideoPopImageView = this.j;
            bdVideoPopImageView.setMsg(((int) ((f / 255.0f) * 100.0f)) + "%");
            u21.d(getActivity(), (int) f);
            F(xs0.w(LayerEvent.ACTION_ADJUST_LIGHT));
            qy0.b("GestureLayer", "onBrightSlide : " + f);
        }
    }

    public boolean i0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean j0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, motionEvent)) == null) {
            if (ar0.W0()) {
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.tieba.uv0, com.baidu.tieba.iu0
    public void k(@NonNull ht0 ht0Var) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, ht0Var) == null) {
            String c3 = ht0Var.c();
            switch (c3.hashCode()) {
                case -1638530599:
                    if (c3.equals(LayerEvent.ACTION_PANEL_VISIBLE_CHANGED)) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -997577826:
                    if (c3.equals(LayerEvent.ACTION_CLICK_RETRY)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -552621273:
                    if (c3.equals(LayerEvent.ACTION_SWITCH_FULL)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -552580917:
                    if (c3.equals(LayerEvent.ACTION_SWITCH_HALF)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 250537257:
                    if (c3.equals(LayerEvent.ACTION_NET_ERROR_SHOW)) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 264969781:
                    if (c3.equals(LayerEvent.ACTION_HIDE_CACHE_LOADING)) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 665895127:
                    if (c3.equals(LayerEvent.ACTION_BARRAGE_VIEW)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1231554669:
                    if (c3.equals(LayerEvent.ACTION_LOCK_SCREEN)) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1409909918:
                    if (c3.equals(LayerEvent.ACTION_SWITCH_FLOATING)) {
                        c2 = '\b';
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    if (BdNetUtils.h()) {
                        q0(true);
                        return;
                    }
                    return;
                case 1:
                    this.m.setVisibility(4);
                    a0();
                    m0();
                    return;
                case 2:
                    o0();
                    return;
                case 3:
                default:
                    return;
                case 4:
                case 5:
                    q0(false);
                    return;
                case 6:
                    this.q = ((Boolean) ht0Var.f(9)).booleanValue();
                    Z();
                    if (u().V0()) {
                        this.d.removeMessages(20);
                        if (!ar0.W0()) {
                            this.m.setVisibility(this.q ? 0 : 4);
                            return;
                        } else {
                            b0();
                            return;
                        }
                    } else if (u().U0()) {
                        this.l.setVisibility(0);
                        return;
                    } else {
                        return;
                    }
                case 7:
                    this.m.e(ar0.W0() ? 1000 : 2000);
                    return;
                case '\b':
                    this.l.setVisibility(0);
                    this.m.setVisibility(4);
                    return;
            }
        }
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.t = false;
            boolean equals = TextUtils.equals(this.v, "speed");
            if (equals) {
                u().z0(this.u);
            } else {
                this.d.removeCallbacks(this.w);
            }
            if (u().y() != null) {
                u().y().D(equals, false);
            }
        }
    }

    @Override // com.baidu.tieba.eu0
    public void l(int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            n0((int) (i + f));
        }
    }

    public boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.eu0
    public void m(BdVideoGesture.VideoPluginGesture videoPluginGesture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, videoPluginGesture) == null) {
            a0();
            if (videoPluginGesture == BdVideoGesture.VideoPluginGesture.InitChange) {
                u().y().w();
            } else {
                u().y().v();
            }
        }
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            az0.i(this);
        }
    }

    public final void n0(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i) == null) {
            int r = u().r();
            if (r > 1 && i > (i2 = r - 1)) {
                i = i2;
            }
            u().o0(i);
        }
    }

    @Override // com.baidu.tieba.eu0
    public Activity o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? getActivity() : (Activity) invokeV.objValue;
    }

    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            az0.k(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048613, this, view2) == null) && view2.equals(this.m)) {
            u().a1();
            this.m.b();
            cy0.c().d(xs0.w(LayerEvent.ACTION_LOCK_SCREEN));
            u().y().E(ar0.W0());
        }
    }

    @Override // com.baidu.tieba.cw0, com.baidu.tieba.uv0, com.baidu.tieba.hw0
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            super.onLayerRelease();
            this.n.h();
            this.o.setOnDoubleTapListener(null);
        }
    }

    @Override // com.baidu.tieba.eu0
    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? u().Q() : invokeV.booleanValue;
    }

    public final void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
        }
    }

    @Override // com.baidu.tieba.uv0, com.baidu.tieba.iu0
    public void q(@NonNull ht0 ht0Var) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, ht0Var) == null) {
            String c3 = ht0Var.c();
            int hashCode = c3.hashCode();
            if (hashCode != -1530009462) {
                if (hashCode == 906917140 && c3.equals(ControlEvent.ACTION_RESUME)) {
                    c2 = 1;
                }
                c2 = 65535;
            } else {
                if (c3.equals(ControlEvent.ACTION_SYNC_PROGRESS)) {
                    c2 = 0;
                }
                c2 = 65535;
            }
            if (c2 == 0) {
                r0(ht0Var.g(1), ht0Var.g(2), ht0Var.g(3));
            } else if (c2 != 1) {
            } else {
                this.e.setVisibility(0);
            }
        }
    }

    public void q0(boolean z2) {
        BdVideoCacheView bdVideoCacheView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048618, this, z2) == null) && this.s && (bdVideoCacheView = this.k) != null) {
            if (z2) {
                bdVideoCacheView.c(0);
            } else {
                bdVideoCacheView.c(4);
            }
        }
    }

    public void r0(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048619, this, i, i2, i3) == null) {
            if (u().r1()) {
                i = u().k1();
                i2 = u().j1();
            }
            this.l.h(i, i2, i3);
        }
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.d.removeMessages(20);
            if (this.m.getVisibility() != 0) {
                this.m.setVisibility(0);
                b0();
                return;
            }
            this.m.setVisibility(4);
        }
    }

    public final void t0(BdVideoSeekbarImageView bdVideoSeekbarImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, bdVideoSeekbarImageView) == null) {
            if (u().V0()) {
                bdVideoSeekbarImageView.setIconVisible(true);
                bdVideoSeekbarImageView.setWidth(x);
                bdVideoSeekbarImageView.setHeight(y);
                return;
            }
            bdVideoSeekbarImageView.setIconVisible(false);
            bdVideoSeekbarImageView.setWidth(z);
            bdVideoSeekbarImageView.setHeight(A);
        }
    }

    @Override // com.baidu.tieba.uv0
    public void z(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, message) == null) {
            super.z(message);
            if (message == null || message.what != 20 || this.q) {
                return;
            }
            this.m.setVisibility(4);
            this.d.removeMessages(20);
        }
    }

    public gw0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.q = false;
        this.r = false;
        this.s = true;
        this.t = false;
        this.u = 1.0f;
        this.v = "speed";
        this.w = new a(this);
    }
}
