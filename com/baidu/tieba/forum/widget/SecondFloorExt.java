package com.baidu.tieba.forum.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.FloatRange;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.forum.widget.SecondFloorExt;
import com.baidu.tieba.hp7;
import com.baidu.tieba.jp7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.yy.gslbsdk.db.DelayTB;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u008b\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0003\f\u0015\u0018\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020#J\b\u0010'\u001a\u00020(H\u0002J\u0006\u0010)\u001a\u00020(J\u0006\u0010*\u001a\u00020(J\u0017\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020.H\u0002¢\u0006\u0002\u0010/J\u000e\u00100\u001a\u00020(2\u0006\u00101\u001a\u00020\u000fJ\u0006\u00102\u001a\u00020(J\u0006\u00103\u001a\u00020(J\u0010\u00104\u001a\u00020\u00002\b\b\u0001\u00105\u001a\u00020\u0007J\u0010\u00106\u001a\u00020\u00002\b\b\u0001\u0010\b\u001a\u00020\u0007J\u000e\u00107\u001a\u00020,2\u0006\u00108\u001a\u00020\u0007J4\u00109\u001a\u00020(2\u0006\u0010:\u001a\u00020\u00072\b\b\u0002\u0010;\u001a\u00020<2\u0018\b\u0002\u0010=\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010?\u0012\u0004\u0012\u00020(\u0018\u00010>H\u0002J\u0018\u0010@\u001a\u00020(2\u0006\u0010A\u001a\u00020\u00072\u0006\u0010&\u001a\u00020BH\u0002J\u0010\u0010C\u001a\u00020(2\u0006\u0010D\u001a\u00020\u0007H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u0010\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010!\u001a\u0012\u0012\u0004\u0012\u00020#0\"j\b\u0012\u0004\u0012\u00020#`$X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/baidu/tieba/forum/widget/SecondFloorExt;", "", "scrollTarget", "Landroid/view/View;", "touchTarget", "(Landroid/view/View;Landroid/view/View;)V", "dragFactor", "", "expandThreshold", "lastX", "lastY", "linkageTouchDispatchEvent", "com/baidu/tieba/forum/widget/SecondFloorExt$linkageTouchDispatchEvent$1", "Lcom/baidu/tieba/forum/widget/SecondFloorExt$linkageTouchDispatchEvent$1;", "linkageView", "Lcom/baidu/tieba/forum/widget/TbLinkageScrollView;", "releaseAnimUpdateListener", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "releaseAnimator", "Landroid/view/ViewPropertyAnimator;", "releaseToCloseAnimListener", "com/baidu/tieba/forum/widget/SecondFloorExt$releaseToCloseAnimListener$1", "Lcom/baidu/tieba/forum/widget/SecondFloorExt$releaseToCloseAnimListener$1;", "releaseToExpandAnimListener", "com/baidu/tieba/forum/widget/SecondFloorExt$releaseToExpandAnimListener$1", "Lcom/baidu/tieba/forum/widget/SecondFloorExt$releaseToExpandAnimListener$1;", "shakeAnimator", "Landroid/animation/ValueAnimator;", "<set-?>", "", "state", "getState", "()I", "translateListeners", "Ljava/util/ArrayList;", "Lcom/baidu/tieba/forum/widget/SecondFloorTranslateListener;", "Lkotlin/collections/ArrayList;", "addTranslateListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "cancelReleaseAnimator", "", "collapse", "expand", "handleDispatchTouchEvent", "", "e", "Landroid/view/MotionEvent;", "(Landroid/view/MotionEvent;)Ljava/lang/Boolean;", "hook", "linkageScrollView", "interceptShake", MissionEvent.MESSAGE_DESTROY, "setDragFactor", "factor", "setExpandThreshold", "shake", "offsetY", "shakeOnce", "offset", DelayTB.DELAY, "", "onEnd", "Lkotlin/Function1;", "Landroid/animation/Animator;", "startReleaseAnim", "toTranslationY", "Landroid/animation/Animator$AnimatorListener;", "startShakeAnim", "end", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SecondFloorExt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final View a;
    public final View b;
    public TbLinkageScrollView c;
    public float d;
    public float e;
    public float f;
    public float g;
    public int h;
    public final ArrayList<jp7> i;
    public final a j;
    public ValueAnimator k;
    public ViewPropertyAnimator l;
    public final b m;
    public final c n;
    public final ValueAnimator.AnimatorUpdateListener o;

    /* loaded from: classes6.dex */
    public static final class a implements hp7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SecondFloorExt a;

        public a(SecondFloorExt secondFloorExt) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {secondFloorExt};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = secondFloorExt;
        }

        @Override // com.baidu.tieba.hp7
        public Boolean a(MotionEvent e) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, e)) == null) {
                Intrinsics.checkNotNullParameter(e, "e");
                return this.a.k(e);
            }
            return (Boolean) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SecondFloorExt a;

        public b(SecondFloorExt secondFloorExt) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {secondFloorExt};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = secondFloorExt;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) != null) {
                return;
            }
            this.a.h = 2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, animator) != null) {
                return;
            }
            this.a.h = 0;
            ArrayList<jp7> arrayList = this.a.i;
            SecondFloorExt secondFloorExt = this.a;
            for (jp7 jp7Var : arrayList) {
                jp7Var.b(secondFloorExt.j());
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) != null) {
                return;
            }
            this.a.h = 0;
            ArrayList<jp7> arrayList = this.a.i;
            SecondFloorExt secondFloorExt = this.a;
            for (jp7 jp7Var : arrayList) {
                jp7Var.b(secondFloorExt.j());
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SecondFloorExt a;

        public c(SecondFloorExt secondFloorExt) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {secondFloorExt};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = secondFloorExt;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, animator) != null) {
                return;
            }
            this.a.h = 0;
            ArrayList<jp7> arrayList = this.a.i;
            SecondFloorExt secondFloorExt = this.a;
            for (jp7 jp7Var : arrayList) {
                jp7Var.b(secondFloorExt.j());
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) != null) {
                return;
            }
            this.a.h = 4;
            ArrayList<jp7> arrayList = this.a.i;
            SecondFloorExt secondFloorExt = this.a;
            for (jp7 jp7Var : arrayList) {
                jp7Var.b(secondFloorExt.j());
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                if (this.a.a.getTranslationY() == 0.0f) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    for (jp7 jp7Var : this.a.i) {
                        jp7Var.d(false);
                    }
                }
                this.a.h = 3;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class d extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SecondFloorExt a;
        public final /* synthetic */ Function1<Animator, Unit> b;

        public d(SecondFloorExt secondFloorExt, Function1<? super Animator, Unit> function1) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {secondFloorExt, function1};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = secondFloorExt;
            this.b = function1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.a.m.onAnimationCancel(animator);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.m.onAnimationEnd(animator);
                Function1<Animator, Unit> function1 = this.b;
                if (function1 != null) {
                    function1.invoke(animator);
                }
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                for (jp7 jp7Var : this.a.i) {
                    jp7Var.d(false);
                }
            }
        }
    }

    public SecondFloorExt(View scrollTarget, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {scrollTarget, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(scrollTarget, "scrollTarget");
        this.a = scrollTarget;
        this.b = view2;
        this.d = 1.0f;
        this.e = 0.5f;
        this.i = new ArrayList<>();
        this.j = new a(this);
        this.m = new b(this);
        this.n = new c(this);
        this.o = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ep7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                    SecondFloorExt.o(SecondFloorExt.this, valueAnimator);
                }
            }
        };
    }

    public final SecondFloorExt f(jp7 listener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, listener)) == null) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            if (!this.i.contains(listener)) {
                this.i.add(listener);
            }
            return this;
        }
        return (SecondFloorExt) invokeL.objValue;
    }

    public final void l(TbLinkageScrollView linkageScrollView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, linkageScrollView) == null) {
            Intrinsics.checkNotNullParameter(linkageScrollView, "linkageScrollView");
            this.c = linkageScrollView;
            linkageScrollView.H(this.j);
        }
    }

    public final SecondFloorExt p(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048585, this, f)) == null) {
            this.e = f;
            return this;
        }
        return (SecondFloorExt) invokeF.objValue;
    }

    public final boolean q(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048586, this, f)) == null) {
            g();
            v(f);
            return true;
        }
        return invokeF.booleanValue;
    }

    public final void v(final float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048589, this, f) == null) {
            r(f, 100L, new Function1<Animator, Unit>(this, f) { // from class: com.baidu.tieba.forum.widget.SecondFloorExt$startShakeAnim$1
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ float $end;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SecondFloorExt this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Float.valueOf(f)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.$end = f;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Animator animator) {
                    invoke2(animator);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        SecondFloorExt.s(this.this$0, this.$end, 150L, null, 4, null);
                    }
                }
            });
        }
    }

    public static final void o(SecondFloorExt this$0, ValueAnimator valueAnimator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, this$0, valueAnimator) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            for (jp7 jp7Var : this$0.i) {
                jp7Var.a(this$0.h, this$0.a.getTranslationY());
            }
        }
    }

    public static final void t(SecondFloorExt this$0, ValueAnimator valueAnimator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, this$0, valueAnimator) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue != null) {
                float floatValue = ((Float) animatedValue).floatValue();
                this$0.a.setTranslationY(floatValue);
                for (jp7 jp7Var : this$0.i) {
                    jp7Var.c(floatValue);
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public final void u(float f, Animator.AnimatorListener animatorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Float.valueOf(f), animatorListener}) == null) {
            ViewPropertyAnimator listener = this.a.animate().setInterpolator(new AccelerateDecelerateInterpolator()).translationY(f).setUpdateListener(this.o).setListener(animatorListener);
            this.l = listener;
            listener.start();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.forum.widget.SecondFloorExt */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void s(SecondFloorExt secondFloorExt, float f, long j, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        secondFloorExt.r(f, j, function1);
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            m();
            ViewPropertyAnimator viewPropertyAnimator = this.l;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
                viewPropertyAnimator.setUpdateListener(null);
                viewPropertyAnimator.setListener(null);
            }
            this.l = null;
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            g();
            u(0.0f, this.m);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            g();
            u(this.a.getHeight(), this.n);
        }
    }

    public final int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ValueAnimator valueAnimator = this.k;
            if (valueAnimator != null) {
                this.a.setTranslationY(0.0f);
                this.m.onAnimationCancel(valueAnimator);
                valueAnimator.removeAllUpdateListeners();
                valueAnimator.removeAllListeners();
                valueAnimator.cancel();
            }
            this.k = null;
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            g();
            this.i.clear();
            TbLinkageScrollView tbLinkageScrollView = this.c;
            if (tbLinkageScrollView != null) {
                tbLinkageScrollView.K(this.j);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0064, code lost:
        if (r6 == false) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Boolean k(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Animator.AnimatorListener animatorListener;
        boolean z;
        int i;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                float f = 0.0f;
                boolean z3 = true;
                if (action != 1) {
                    if (action != 2) {
                        if (action != 3) {
                            return null;
                        }
                    } else {
                        int rawX = (int) (this.f - motionEvent.getRawX());
                        int rawY = (int) (this.g - motionEvent.getRawY());
                        this.f = motionEvent.getRawX();
                        this.g = motionEvent.getRawY();
                        if (this.h != 1) {
                            if (this.a.getScrollY() == 0) {
                                View view2 = this.b;
                                if (view2 != null) {
                                    i = view2.getScrollY();
                                } else {
                                    i = 0;
                                }
                                if (i == 0 && Math.abs(rawX) < Math.abs(rawY)) {
                                    if (rawY >= 0) {
                                        if (this.a.getTranslationY() == 0.0f) {
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                    }
                                    z = true;
                                    if (z) {
                                        g();
                                        this.h = 1;
                                        for (jp7 jp7Var : this.i) {
                                            jp7Var.d(true);
                                        }
                                    }
                                }
                            }
                            z = false;
                            if (z) {
                            }
                        }
                        if (this.h == 1) {
                            if ((this.a.getTranslationY() > 0.0f || rawY <= 0) ? false : false) {
                                this.a.setTranslationY(0.0f);
                                this.h = 0;
                                for (jp7 jp7Var2 : this.i) {
                                    jp7Var2.b(this.h);
                                }
                                return Boolean.TRUE;
                            }
                            View view3 = this.a;
                            view3.setTranslationY(view3.getTranslationY() - (rawY * this.d));
                            for (jp7 jp7Var3 : this.i) {
                                jp7Var3.c(this.a.getTranslationY());
                            }
                            return Boolean.TRUE;
                        }
                        return null;
                    }
                }
                if (this.h == 1) {
                    if (this.a.getTranslationY() / this.a.getHeight() >= this.e) {
                        f = this.a.getHeight();
                        animatorListener = this.n;
                    } else {
                        animatorListener = this.m;
                    }
                    u(f, animatorListener);
                    return Boolean.TRUE;
                }
                return null;
            }
            this.f = motionEvent.getRawX();
            this.g = motionEvent.getRawY();
            return null;
        }
        return (Boolean) invokeL.objValue;
    }

    public final void r(float f, long j, Function1<? super Animator, Unit> function1) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Float.valueOf(f), Long.valueOf(j), function1}) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, f);
            ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat.setDuration(600L);
            ofFloat.setRepeatCount(1);
            ofFloat.setRepeatMode(2);
            ofFloat.setStartDelay(j);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.bp7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        SecondFloorExt.t(SecondFloorExt.this, valueAnimator);
                    }
                }
            });
            ofFloat.addListener(new d(this, function1));
            this.k = ofFloat;
            ofFloat.start();
        }
    }
}
