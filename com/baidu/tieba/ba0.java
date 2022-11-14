package com.baidu.tieba;

import android.animation.Animator;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.refresh.ContinuousAnimationView;
import com.baidu.live.business.refresh.LoadAnimStrategy;
import com.baidu.live.business.refresh.SmartBubbleAnimatedView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ba0 extends z90 {
    public static /* synthetic */ Interceptable $ic;
    public static final int v;
    public static final int w;
    public static final int x;
    public transient /* synthetic */ FieldHolder $fh;
    public View d;
    public LinearLayout e;
    public f f;
    public e g;
    public g h;
    public d i;
    public ContinuousAnimationView j;
    public boolean k;
    public SmartBubbleAnimatedView l;
    public i m;
    public h n;
    public boolean o;
    public boolean p;
    public boolean q;
    public View.OnClickListener r;
    public View.OnClickListener s;
    public String t;
    public final Animator.AnimatorListener u;

    /* loaded from: classes3.dex */
    public interface d {
        void a();
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a(View view2, boolean z);
    }

    /* loaded from: classes3.dex */
    public interface f {
        void e(boolean z);
    }

    /* loaded from: classes3.dex */
    public interface g {
        void a(boolean z);
    }

    /* loaded from: classes3.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public abstract int a();

        public abstract String b();
    }

    /* loaded from: classes3.dex */
    public interface i {
        void a(int i);

        void onAnimationEnd();
    }

    @Override // com.baidu.tieba.z90, com.baidu.live.business.refresh.BdSwipeRefreshLayout.h
    public long getCompleteAnimTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 600L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.z90
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ba0 a;

        public a(ba0 ba0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ba0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.r != null) {
                this.a.r.onClick(view2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ba0 a;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }

        public b(ba0 ba0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ba0Var;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) != null) || this.a.q) {
                return;
            }
            this.a.q = true;
            this.a.j.setSpeed(1.0f);
            this.a.j.setMinAndMaxFrame(ba0.w, ba0.x);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements SmartBubbleAnimatedView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ba0 a;

        public c(ba0 ba0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ba0Var;
        }

        @Override // com.baidu.live.business.refresh.SmartBubbleAnimatedView.e
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.m != null) {
                this.a.m.onAnimationEnd();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947638104, "Lcom/baidu/tieba/ba0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947638104, "Lcom/baidu/tieba/ba0;");
                return;
            }
        }
        v = LoadAnimStrategy.getInstance().pullEndFrame;
        w = LoadAnimStrategy.getInstance().loopStartFrame;
        x = LoadAnimStrategy.getInstance().loopEndFrame;
    }

    public final void C() {
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (continuousAnimationView = this.j) != null) {
            if (continuousAnimationView.isAnimating()) {
                this.j.cancelAnimation();
            }
            this.q = false;
            this.j.loop(true);
            this.j.setMinFrame(v);
            this.j.setRepeatMode(1);
            this.j.removeAllAnimatorListeners();
            this.j.addAnimatorListener(this.u);
            this.j.playAnimation();
        }
    }

    @Override // com.baidu.tieba.z90
    public void j() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || h()) {
            return;
        }
        d dVar = this.i;
        if (dVar != null) {
            dVar.a();
        }
        if (!A()) {
            B();
            return;
        }
        ContinuousAnimationView continuousAnimationView = this.j;
        if (continuousAnimationView != null && continuousAnimationView.isAnimating()) {
            this.j.cancelAnimation();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ba0(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.k = false;
        this.o = true;
        this.p = true;
        this.q = false;
        this.r = null;
        this.s = new a(this);
        this.u = new b(this);
    }

    @Override // com.baidu.tieba.z90
    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.p = true;
            if (w() && this.j.isAnimating()) {
                this.j.cancelAnimation();
            }
            e eVar = this.g;
            if (eVar != null) {
                eVar.a(this.d, z);
            }
        }
    }

    @Override // com.baidu.tieba.z90
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) != null) || h()) {
            return;
        }
        f fVar = this.f;
        if (fVar != null && this.p) {
            fVar.e(z);
        }
        this.p = true;
    }

    @Override // com.baidu.tieba.z90
    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            g gVar = this.h;
            if (gVar != null) {
                gVar.a(z);
            }
            v();
        }
    }

    public void z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.t = str;
        }
    }

    public final void B() {
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && w() && (continuousAnimationView = this.j) != null) {
            continuousAnimationView.loop(false);
        }
    }

    @Override // com.baidu.tieba.z90
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            v();
            if (!w() || h()) {
                return;
            }
            C();
        }
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return aa0.a().b();
        }
        return invokeV.booleanValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.k;
        }
        return invokeV.booleanValue;
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!x() || !this.o || this.n == null || this.e == null) {
                return false;
            }
            this.j.setVisibility(8);
            if (this.l == null) {
                SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(getContext());
                this.l = smartBubbleAnimatedView;
                smartBubbleAnimatedView.setExtrusionRemind(true);
            }
            this.l.a = this.n.b();
            this.l.b = this.n.a();
            if (this.l.getParent() != null) {
                this.e.removeView(this.l);
            }
            this.e.addView(this.l);
            this.l.setOnBubbleAnimateListener(new c(this));
            i iVar = this.m;
            if (iVar != null) {
                iVar.a(this.l.getTipViewHeight());
            }
            this.l.f();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.z90, com.baidu.live.business.refresh.BdSwipeRefreshLayout.h
    public void c(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            super.c(f2, f3);
            if (w()) {
                this.j.setAlpha(f2);
                this.j.setFrame((int) (f2 * v));
            }
        }
    }

    @Override // com.baidu.tieba.z90
    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            boolean equals = "recommend".equals(this.t);
            int i2 = R.layout.obfuscated_res_0x7f0d0555;
            if (!equals && !"baidu".equals(LiveFeedPageSdk.getInstance().getHost())) {
                if (LiveFeedPageSdk.HOST_HAOKAN.equals(LiveFeedPageSdk.getInstance().getHost())) {
                    i2 = R.layout.obfuscated_res_0x7f0d0556;
                } else if (LiveFeedPageSdk.HOST_QUANMIN.equals(LiveFeedPageSdk.getInstance().getHost())) {
                    i2 = R.layout.obfuscated_res_0x7f0d0557;
                } else if ("tieba".equals(LiveFeedPageSdk.getInstance().getHost())) {
                    i2 = R.layout.obfuscated_res_0x7f0d0558;
                }
            }
            View inflate = LayoutInflater.from(getContext()).inflate(i2, (ViewGroup) null);
            this.d = inflate;
            this.e = (LinearLayout) inflate.findViewById(R.id.pull_root);
            ContinuousAnimationView continuousAnimationView = (ContinuousAnimationView) this.d.findViewById(R.id.obfuscated_res_0x7f090712);
            this.j = continuousAnimationView;
            continuousAnimationView.setOnClickListener(this.s);
            v();
            return this.d;
        }
        return (View) invokeV.objValue;
    }

    public final void v() {
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            SmartBubbleAnimatedView smartBubbleAnimatedView = this.l;
            if (smartBubbleAnimatedView != null && smartBubbleAnimatedView.getParent() != null) {
                this.e.removeView(this.l);
            }
            if (w() && (continuousAnimationView = this.j) != null) {
                if (continuousAnimationView.getVisibility() != 0) {
                    this.j.setVisibility(0);
                }
                if (this.j.isAnimating()) {
                    this.j.cancelAnimation();
                }
                this.j.setMinAndMaxProgress(0.0f, 1.0f);
                this.j.setFrame(0);
                this.j.setSpeed(1.3f);
            }
        }
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            String m = vc0.f().m(str);
            if (TextUtils.isEmpty(m)) {
                int n = vc0.f().n(str);
                if (n != 0) {
                    this.j.setAnimation(n);
                    return;
                }
                return;
            }
            this.j.setAnimation(m);
        }
    }
}
