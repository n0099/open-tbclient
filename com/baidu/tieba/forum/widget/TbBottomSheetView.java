package com.baidu.tieba.forum.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.searchbox.launch.stats.FirstFrameSpeedStats;
import com.baidu.tieba.forum.widget.TbBottomSheetView;
import com.baidu.tieba.pm7;
import com.baidu.tieba.vm7;
import com.baidu.tieba.xi7;
import com.baidu.tieba.zl7;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 M2\u00020\u0001:\u0001MB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020-J\b\u00102\u001a\u000200H\u0014J\u0010\u00103\u001a\u0002002\u0006\u00104\u001a\u00020\u0007H\u0002J\u0010\u00105\u001a\u00020\u001c2\u0006\u00106\u001a\u00020\u0007H\u0016J\b\u00107\u001a\u000200H\u0002J\u0017\u00108\u001a\u0004\u0018\u00010\u001c2\u0006\u00109\u001a\u00020:H\u0016¢\u0006\u0002\u0010;J\u001f\u0010<\u001a\u0004\u0018\u00010\u001c2\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010?J\u001d\u0010@\u001a\u00020\u001c2\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010?J\u001f\u0010A\u001a\u0004\u0018\u00010\u001c2\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010?J\u0017\u0010B\u001a\u0004\u0018\u00010\u001c2\u0006\u00109\u001a\u00020:H\u0016¢\u0006\u0002\u0010;J(\u0010C\u001a\u0002002\u0006\u0010D\u001a\u00020\u00072\u0006\u0010E\u001a\u00020\u001c2\u0010\b\u0002\u0010F\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010GJ\b\u0010H\u001a\u000200H\u0014J\u000e\u0010I\u001a\u0002002\u0006\u00101\u001a\u00020-J.\u0010J\u001a\u0002002\b\b\u0002\u0010\u001d\u001a\u00020\u00072\b\b\u0002\u0010K\u001a\u00020\u00072\b\b\u0002\u0010$\u001a\u00020\u00072\b\b\u0002\u0010*\u001a\u00020\u001cJ\b\u0010L\u001a\u00020\u001cH\u0014J\b\u0010E\u001a\u000200H\u0002R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010&\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010+\u001a\u0012\u0012\u0004\u0012\u00020-0,j\b\u0012\u0004\u0012\u00020-`.X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lcom/baidu/tieba/forum/widget/TbBottomSheetView;", "Lcom/baidu/tieba/forum/widget/TbNestedScrollView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomSheetStateListener", "Lcom/baidu/tieba/forum/widget/TbBottomSheetStateListener;", "getBottomSheetStateListener", "()Lcom/baidu/tieba/forum/widget/TbBottomSheetStateListener;", "setBottomSheetStateListener", "(Lcom/baidu/tieba/forum/widget/TbBottomSheetStateListener;)V", "bounceAnimator", "Landroid/animation/ValueAnimator;", "bounceAnimatorListener", "Landroid/animation/AnimatorListenerAdapter;", "getBounceAnimatorListener", "()Landroid/animation/AnimatorListenerAdapter;", "setBounceAnimatorListener", "(Landroid/animation/AnimatorListenerAdapter;)V", "defaultBounceGuideDuration", "", "defaultBounceGuideOffset", "defaultBounceScrollDuration", FirstFrameSpeedStats.FIRST_LAYOUT, "", "initPosition", "interceptSelfScroll", "getInterceptSelfScroll", "()Z", "setInterceptSelfScroll", "(Z)V", "isAutoScrolling", "midHeight", "<set-?>", "midScroll", "getMidScroll", "()I", "minContentHeight", "needBounceScrollAnim", "touchDispatchListeners", "Ljava/util/ArrayList;", "Lcom/baidu/tieba/forum/widget/BottomSheetTouchDispatchListener;", "Lkotlin/collections/ArrayList;", "addTouchDispatchListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "adjustScrollBounds", "bounceScrollTo", "desScrollY", "canScrollSelf", MapBundleKey.MapObjKey.OBJ_DIR, "cancelBounceAnimation", "handleDispatchTouchEvent", "e", "Landroid/view/MotionEvent;", "(Landroid/view/MotionEvent;)Ljava/lang/Boolean;", "handleNestedPreScrollFirst", "scroll", "type", "(II)Ljava/lang/Boolean;", "handleNestedScrollFirst", "handleScrollSelf", "handleTouchEvent", "initScrollPosition", "scrollY", "showBounceGuideAnim", "onScrollFinished", "Lkotlin/Function0;", "onDetachedFromWindow", "removeTouchDispatchListener", "setup", "minHeight", "shouldBlockOnInterceptTouch", "Companion", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class TbBottomSheetView extends TbNestedScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final long A;
    public final long B;
    public final int C;
    public boolean D;
    public int E;
    public int F;
    public int G;
    public int H;
    public boolean I;
    public boolean J;
    public ValueAnimator K;
    public final ArrayList<pm7> L;
    public AnimatorListenerAdapter M;
    public vm7 N;
    public boolean z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(170644991, "Lcom/baidu/tieba/forum/widget/TbBottomSheetView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(170644991, "Lcom/baidu/tieba/forum/widget/TbBottomSheetView;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TbBottomSheetView(Context context) {
        this(context, null, 0, 6, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TbBottomSheetView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* loaded from: classes6.dex */
    public static final class a extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbBottomSheetView a;
        public final /* synthetic */ int b;

        public a(TbBottomSheetView tbBottomSheetView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbBottomSheetView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbBottomSheetView;
            this.b = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationCancel(animator);
                this.a.scrollTo(0, this.b);
                AnimatorListenerAdapter bounceAnimatorListener = this.a.getBounceAnimatorListener();
                if (bounceAnimatorListener != null) {
                    bounceAnimatorListener.onAnimationCancel(animator);
                }
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                super.onAnimationEnd(animator);
                AnimatorListenerAdapter bounceAnimatorListener = this.a.getBounceAnimatorListener();
                if (bounceAnimatorListener != null) {
                    bounceAnimatorListener.onAnimationEnd(animator);
                }
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                super.onAnimationStart(animator);
                AnimatorListenerAdapter bounceAnimatorListener = this.a.getBounceAnimatorListener();
                if (bounceAnimatorListener != null) {
                    bounceAnimatorListener.onAnimationStart(animator);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbBottomSheetView a;
        public final /* synthetic */ int b;

        public b(TbBottomSheetView tbBottomSheetView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbBottomSheetView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbBottomSheetView;
            this.b = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationCancel(animator);
                this.a.scrollTo(0, this.b);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TbBottomSheetView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        new LinkedHashMap();
        this.A = 1000L;
        this.B = 1000L;
        this.C = zl7.a(10);
        this.D = true;
        this.F = 3;
        this.L = new ArrayList<>();
    }

    public /* synthetic */ TbBottomSheetView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @Override // com.baidu.tieba.forum.widget.TbNestedScrollView
    public Boolean t(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048593, this, i, i2)) == null) {
            if (getScrollY() != 0) {
                return Boolean.TRUE;
            }
            return null;
        }
        return (Boolean) invokeII.objValue;
    }

    @Override // com.baidu.tieba.forum.widget.TbNestedScrollView
    public Boolean u(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048594, this, i, i2)) == null) {
            return Boolean.TRUE;
        }
        return (Boolean) invokeII.objValue;
    }

    @Override // com.baidu.tieba.forum.widget.TbNestedScrollView
    public Boolean x(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048595, this, i, i2)) == null) {
            if (i2 == 1) {
                return Boolean.TRUE;
            }
            return null;
        }
        return (Boolean) invokeII.objValue;
    }

    public static final void J(TbBottomSheetView this$0, int i, int i2, ValueAnimator valueAnimator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{this$0, Integer.valueOf(i), Integer.valueOf(i2), valueAnimator}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue != null) {
                this$0.setScrollY(i + ((int) (i2 * ((Float) animatedValue).floatValue())));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final void N(TbBottomSheetView this$0, int i, int i2, ValueAnimator valueAnimator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{this$0, Integer.valueOf(i), Integer.valueOf(i2), valueAnimator}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue != null) {
                this$0.setScrollY(i + ((int) (i2 * ((Float) animatedValue).floatValue())));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static /* synthetic */ void setup$default(TbBottomSheetView tbBottomSheetView, int i, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = 3;
        }
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = i2;
        }
        if ((i4 & 8) != 0) {
            z = false;
        }
        tbBottomSheetView.setup(i, i2, i3, z);
    }

    @Override // com.baidu.tieba.forum.widget.TbNestedScrollView
    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return !this.J;
        }
        return invokeV.booleanValue;
    }

    public final void K() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (valueAnimator = this.K) != null) {
            valueAnimator.cancel();
            valueAnimator.removeAllUpdateListeners();
            valueAnimator.removeAllListeners();
        }
    }

    public final vm7 getBottomSheetStateListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.N;
        }
        return (vm7) invokeV.objValue;
    }

    public final AnimatorListenerAdapter getBounceAnimatorListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.M;
        }
        return (AnimatorListenerAdapter) invokeV.objValue;
    }

    public final boolean getInterceptSelfScroll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.z;
        }
        return invokeV.booleanValue;
    }

    public final int getMidScroll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.E;
        }
        return invokeV.intValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDetachedFromWindow();
            K();
        }
    }

    public final void I(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            K();
            final int scrollY = getScrollY();
            final int i2 = i - scrollY;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setInterpolator(new xi7(0.55f));
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.nm7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        TbBottomSheetView.J(TbBottomSheetView.this, scrollY, i2, valueAnimator);
                    }
                }
            });
            ofFloat.addListener(new a(this, i));
            ofFloat.setDuration(this.A);
            this.K = ofFloat;
            ofFloat.start();
        }
    }

    public final void L(int i, boolean z, Function0<Unit> function0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), function0}) == null) {
            this.D = false;
            scrollTo(getScrollX(), i);
            if (z) {
                M();
            }
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            K();
            final int scrollY = getScrollY();
            final int i = this.C;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f, -1.0f, 0.0f);
            ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat.setRepeatCount(-1);
            ofFloat.setRepeatMode(1);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.mm7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        TbBottomSheetView.N(TbBottomSheetView.this, scrollY, i, valueAnimator);
                    }
                }
            });
            ofFloat.addListener(new b(this, scrollY));
            ofFloat.setDuration(this.B);
            this.K = ofFloat;
            ofFloat.start();
        }
    }

    @Override // com.baidu.tieba.forum.widget.TbNestedScrollView
    public void a() {
        int minScroll;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            setMinScroll(this.G - getHeight());
            this.E = (getMinScroll() + this.H) - this.G;
            if (this.D) {
                this.D = false;
                int scrollX = getScrollX();
                int i = this.F;
                if (i != 1) {
                    if (i != 3) {
                        minScroll = this.E;
                    } else {
                        minScroll = getMaxScroll();
                    }
                } else {
                    minScroll = getMinScroll();
                }
                scrollTo(scrollX, minScroll);
            }
        }
    }

    @Override // com.baidu.tieba.forum.widget.TbNestedScrollView
    public boolean b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (this.z) {
                return false;
            }
            return super.b(i);
        }
        return invokeI.booleanValue;
    }

    public final void setBottomSheetStateListener(vm7 vm7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, vm7Var) == null) {
            this.N = vm7Var;
        }
    }

    public final void setBounceAnimatorListener(AnimatorListenerAdapter animatorListenerAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, animatorListenerAdapter) == null) {
            this.M = animatorListenerAdapter;
        }
    }

    public final void setInterceptSelfScroll(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.z = z;
        }
    }

    @Override // com.baidu.tieba.forum.widget.TbNestedScrollView
    public Boolean p(MotionEvent e) {
        InterceptResult invokeL;
        int minScroll;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, e)) == null) {
            Intrinsics.checkNotNullParameter(e, "e");
            for (pm7 pm7Var : this.L) {
                pm7Var.a(e);
            }
            if (e.getAction() == 0) {
                K();
            }
            if ((e.getAction() == 3 || e.getAction() == 1) && getLastScrollDir() != 0 && getScrollY() >= getMinScroll() && getScrollY() <= getMaxScroll()) {
                if (getScrollY() > this.E) {
                    if (getLastScrollDir() > 0) {
                        minScroll = getMaxScroll();
                    } else {
                        minScroll = this.E;
                    }
                } else if (getLastScrollDir() > 0) {
                    minScroll = this.E;
                } else {
                    minScroll = getMinScroll();
                }
                final int i = minScroll;
                if (this.I) {
                    int scrollY = getScrollY();
                    int i2 = this.E;
                    if (scrollY > i2) {
                        this.J = true;
                        TbNestedScrollView.E(this, i, 0, new Function1<TbNestedScrollView, Unit>(this) { // from class: com.baidu.tieba.forum.widget.TbBottomSheetView$handleDispatchTouchEvent$2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ TbBottomSheetView this$0;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        super(((Integer) newInitContext.callArgs[0]).intValue());
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                            }

                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TbNestedScrollView tbNestedScrollView) {
                                invoke2(tbNestedScrollView);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2(TbNestedScrollView it) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, it) == null) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    this.this$0.J = false;
                                    vm7 bottomSheetStateListener = this.this$0.getBottomSheetStateListener();
                                    if (bottomSheetStateListener != null) {
                                        bottomSheetStateListener.a();
                                    }
                                }
                            }
                        }, 2, null);
                    } else {
                        I(i2);
                    }
                } else {
                    this.J = true;
                    TbNestedScrollView.E(this, i, 0, new Function1<TbNestedScrollView, Unit>(this, i) { // from class: com.baidu.tieba.forum.widget.TbBottomSheetView$handleDispatchTouchEvent$3
                        public static /* synthetic */ Interceptable $ic;
                        public final /* synthetic */ int $desScrollY;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ TbBottomSheetView this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Integer.valueOf(i)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    super(((Integer) newInitContext.callArgs[0]).intValue());
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.$desScrollY = i;
                        }

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TbNestedScrollView tbNestedScrollView) {
                            invoke2(tbNestedScrollView);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(TbNestedScrollView it) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, it) == null) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                this.this$0.J = false;
                                if (this.$desScrollY == this.this$0.getMaxScroll()) {
                                    vm7 bottomSheetStateListener = this.this$0.getBottomSheetStateListener();
                                    if (bottomSheetStateListener != null) {
                                        bottomSheetStateListener.a();
                                        return;
                                    }
                                    return;
                                }
                                vm7 bottomSheetStateListener2 = this.this$0.getBottomSheetStateListener();
                                if (bottomSheetStateListener2 != null) {
                                    bottomSheetStateListener2.b();
                                }
                            }
                        }
                    }, 2, null);
                }
                return Boolean.TRUE;
            }
            return super.p(e);
        }
        return (Boolean) invokeL.objValue;
    }

    public final void setup(int i, int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            this.F = i;
            this.G = i2;
            this.H = i3;
            this.I = z;
            this.D = true;
            requestLayout();
        }
    }

    @Override // com.baidu.tieba.forum.widget.TbNestedScrollView
    public Boolean y(MotionEvent e) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, e)) == null) {
            Intrinsics.checkNotNullParameter(e, "e");
            if (e.getAction() == 0) {
                boolean z = false;
                View childAt = getChildAt(0);
                if (childAt != null && ViewExtentionsKt.k(childAt, e.getRawX(), e.getRawY())) {
                    z = true;
                }
                if (!z) {
                    return Boolean.FALSE;
                }
            }
            return null;
        }
        return (Boolean) invokeL.objValue;
    }
}
