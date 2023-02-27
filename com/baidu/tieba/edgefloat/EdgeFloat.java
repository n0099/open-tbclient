package com.baidu.tieba.edgefloat;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.edgefloat.EdgeFloat;
import com.baidu.tieba.tl6;
import com.baidu.tieba.ul6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010 \n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001WB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u00104\u001a\u000205H\u0002J(\u00106\u001a\u0002032\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006H\u0002J\u000e\u00107\u001a\u0002052\u0006\u00108\u001a\u000209J&\u0010:\u001a\u0002052\u0006\u0010;\u001a\u00020\u00142\u0006\u0010<\u001a\u00020\u00142\f\u0010=\u001a\b\u0012\u0004\u0012\u0002050>H\u0002J\u0006\u0010?\u001a\u000205J\b\u0010@\u001a\u00020\u0018H\u0002J\u0012\u0010A\u001a\u00020\u00182\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002J\u0006\u0010\u001b\u001a\u00020\u0018J\u000e\u0010B\u001a\u0002052\u0006\u0010\u0011\u001a\u00020\u0006J\u0016\u0010C\u001a\u0002052\u0006\u0010D\u001a\u00020\u00062\u0006\u0010E\u001a\u00020\u0006J\u000e\u0010F\u001a\u0002052\u0006\u0010E\u001a\u00020\u0006J\u0006\u0010G\u001a\u000205J\u0010\u0010H\u001a\u0002052\u0006\u0010I\u001a\u00020\u0006H\u0016J\u0016\u0010J\u001a\u0002052\u0006\u0010K\u001a\u00020\u00182\u0006\u0010L\u001a\u00020\u0006J\u000e\u0010M\u001a\u0002052\u0006\u0010N\u001a\u00020\u0018J\u0006\u0010O\u001a\u000205J\u0014\u0010P\u001a\u0002052\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0QJ\u0006\u0010R\u001a\u000205J\u000e\u0010S\u001a\u0002052\u0006\u0010\u0002\u001a\u00020\u0003J \u0010T\u001a\u0002052\u0006\u0010U\u001a\u00020\u00062\u0006\u0010D\u001a\u00020\u00062\u0006\u0010V\u001a\u00020\bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0018@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010!\u001a\u0012\u0012\u0004\u0012\u00020#0\"j\b\u0012\u0004\u0012\u00020#`$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010,\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b.\u0010/R\u000e\u00102\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006X"}, d2 = {"Lcom/baidu/tieba/edgefloat/EdgeFloat;", "Lcom/baidu/tieba/edgefloat/IChangeSkinType;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "CLICK_MOTION_EVENT_DELTA", "", "FADE_IN_OUT_ANIM_TIME", "", "SLIDE_ANIM_TIME", "TRANSLATE_X_ANIM_TIME", "beforeKeybordX", "beforeKeybordY", "bottomLimit", "changeSkinListener", "contentView", "Landroid/view/View;", "deltaX", "deltaY", "downEventX", "", "downEventY", "height", "<set-?>", "", "isOnLeft", "()Z", "isShowing", "isTouching", "onActivityDispatchTouchEvent", "Lcom/baidu/tieba/edgefloat/OnActivityDispatchTouchEventListener;", "onTouchListener", "Landroid/view/View$OnTouchListener;", "pageNoSupport", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "screenHeight", "screenWidth", "startX", "startY", "statusBarHeight", "topLimit", "width", "wm", "Landroid/view/WindowManager;", "getWm", "()Landroid/view/WindowManager;", "wm$delegate", "Lkotlin/Lazy;", "wmParams", "Landroid/view/WindowManager$LayoutParams;", "addToWindow", "", "createLayoutParams", "dispatchTouchEvent", Config.EVENT_PART, "Landroid/view/MotionEvent;", "fadeAlpha", "oldAlpha", "newAlpha", "onEnd", "Lkotlin/Function0;", "hide", "isAttachedToCurrentActivityWindow", "isPageSupport", "moveToX", "moveXY", "newX", "newY", "moveY", "onBackPressed", "onChangeSkinType", "type", "onKeyboardHeightChanged", "isVisible", "keyboardHeight", "onWindowFocusChanged", "hasFocus", "release", "setPageNoSupport", "", "show", "switchActivity", "translateX", "oldX", "duration", "Builder", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EdgeFloat implements tl6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public tl6 A;
    public ul6 B;
    public final View.OnTouchListener C;
    public Activity a;
    public final int b;
    public final long c;
    public final long d;
    public final Lazy e;
    public WindowManager.LayoutParams f;
    public View g;
    public boolean h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public int p;
    public int q;
    public int r;
    public int s;
    public float t;
    public float u;
    public int v;
    public int w;
    public int x;
    public boolean y;
    public final ArrayList<String> z;

    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Activity a;
        public View b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;
        public int j;
        public int k;
        public final ArrayList<String> l;
        public tl6 m;
        public ul6 n;

        public a(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.a = activity;
            this.b = new View(this.a);
            this.l = new ArrayList<>();
        }

        public final a a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                this.h = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a c(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                this.d = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a d(ul6 onActivityDispatchTouchEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, onActivityDispatchTouchEvent)) == null) {
                Intrinsics.checkNotNullParameter(onActivityDispatchTouchEvent, "onActivityDispatchTouchEvent");
                this.n = onActivityDispatchTouchEvent;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a e(tl6 onChangeSkinType) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, onChangeSkinType)) == null) {
                Intrinsics.checkNotNullParameter(onChangeSkinType, "onChangeSkinType");
                this.m = onChangeSkinType;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a f(List<String> pageNoSupport) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, pageNoSupport)) == null) {
                Intrinsics.checkNotNullParameter(pageNoSupport, "pageNoSupport");
                this.l.clear();
                this.l.addAll(pageNoSupport);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a g(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
                this.k = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a h(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
                this.j = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a i(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
                this.e = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a j(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
                this.f = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a k(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
                this.i = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a l(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
                this.g = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a m(View contentView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, contentView)) == null) {
                Intrinsics.checkNotNullParameter(contentView, "contentView");
                this.b = contentView;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a n(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
                this.c = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final EdgeFloat b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                EdgeFloat edgeFloat = new EdgeFloat(this.a);
                edgeFloat.g = this.b;
                edgeFloat.k = this.c;
                edgeFloat.l = this.d;
                edgeFloat.i = this.e;
                edgeFloat.j = this.f;
                edgeFloat.m = this.g;
                edgeFloat.n = this.h;
                edgeFloat.v = this.i;
                edgeFloat.w = this.j;
                edgeFloat.x = this.k;
                edgeFloat.I(this.l);
                edgeFloat.A = this.m;
                edgeFloat.B = this.n;
                EdgeFloatLifecycle.b.a().h(edgeFloat);
                return edgeFloat;
            }
            return (EdgeFloat) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static final class b implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Function0 a;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }

        public b(Function0 function0) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {function0};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = function0;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.invoke();
            }
        }
    }

    public EdgeFloat(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = activity;
        this.b = 2;
        this.c = 250L;
        this.d = 300L;
        this.e = LazyKt__LazyJVMKt.lazy(new Function0<WindowManager>(this) { // from class: com.baidu.tieba.edgefloat.EdgeFloat$wm$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ EdgeFloat this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WindowManager invoke() {
                InterceptResult invokeV;
                Activity activity2;
                Object obj;
                Context applicationContext;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                    return (WindowManager) invokeV.objValue;
                }
                activity2 = this.this$0.a;
                if (activity2 != null && (applicationContext = activity2.getApplicationContext()) != null) {
                    obj = applicationContext.getSystemService("window");
                } else {
                    obj = null;
                }
                if (obj != null) {
                    return (WindowManager) obj;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
            }
        });
        this.f = new WindowManager.LayoutParams();
        this.z = new ArrayList<>();
        this.C = new View.OnTouchListener() { // from class: com.baidu.tieba.rl6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, motionEvent)) == null) ? EdgeFloat.F(EdgeFloat.this, view2, motionEvent) : invokeLL.booleanValue;
            }
        };
    }

    public static final boolean F(EdgeFloat this$0, View view2, MotionEvent motionEvent) {
        InterceptResult invokeLLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, this$0, view2, motionEvent)) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            View view3 = null;
            if (motionEvent.getAction() == 0) {
                int[] iArr = new int[2];
                View view4 = this$0.g;
                if (view4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentView");
                    view4 = null;
                }
                view4.getLocationOnScreen(iArr);
                int i2 = iArr[0];
                int i3 = iArr[1];
                if (motionEvent.getRawX() > i2) {
                    float rawX = motionEvent.getRawX();
                    View view5 = this$0.g;
                    if (view5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("contentView");
                        view5 = null;
                    }
                    if (rawX < view5.getWidth() + i2 && motionEvent.getRawY() > i3) {
                        float rawY = motionEvent.getRawY();
                        View view6 = this$0.g;
                        if (view6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("contentView");
                        } else {
                            view3 = view6;
                        }
                        if (rawY < view3.getHeight() + i3) {
                            this$0.o = true;
                            this$0.r = ((int) motionEvent.getRawX()) - i2;
                            this$0.s = ((int) motionEvent.getRawY()) - i3;
                        }
                    }
                }
                this$0.t = motionEvent.getRawX();
                this$0.u = motionEvent.getRawY();
            } else if (motionEvent.getAction() == 2) {
                if (this$0.o) {
                    int rawY2 = ((int) motionEvent.getRawY()) - this$0.s;
                    int i4 = this$0.v;
                    int i5 = rawY2 - i4;
                    int i6 = this$0.m - i4;
                    int i7 = (this$0.x - this$0.n) - this$0.f.height;
                    if (i5 < i6) {
                        i5 = i6;
                    } else if (i5 > i7) {
                        i5 = i7;
                    }
                    this$0.f.x = ((int) motionEvent.getRawX()) - this$0.r;
                    this$0.f.y = i5;
                    WindowManager u = this$0.u();
                    View view7 = this$0.g;
                    if (view7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("contentView");
                    } else {
                        view3 = view7;
                    }
                    u.updateViewLayout(view3, this$0.f);
                }
            } else if (motionEvent.getAction() == 1) {
                if (Math.abs(motionEvent.getRawX() - this$0.t) < this$0.b && Math.abs(motionEvent.getRawY() - this$0.u) < this$0.b) {
                    View view8 = this$0.g;
                    if (view8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("contentView");
                        view8 = null;
                    }
                    if (view8 instanceof View.OnClickListener) {
                        View view9 = this$0.g;
                        if (view9 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("contentView");
                            view9 = null;
                        }
                        View.OnClickListener onClickListener = (View.OnClickListener) view9;
                        View view10 = this$0.g;
                        if (view10 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("contentView");
                        } else {
                            view3 = view10;
                        }
                        onClickListener.onClick(view3);
                    }
                } else {
                    if (this$0.o) {
                        int i8 = this$0.f.x;
                        View view11 = this$0.g;
                        if (view11 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("contentView");
                            view11 = null;
                        }
                        int width = (view11.getWidth() / 2) + i8;
                        int i9 = this$0.w;
                        if (width > i9 / 2) {
                            View view12 = this$0.g;
                            if (view12 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("contentView");
                            } else {
                                view3 = view12;
                            }
                            i = i9 - view3.getWidth();
                            this$0.y = false;
                        } else {
                            this$0.y = true;
                            i = 0;
                        }
                        this$0.L(i8, i, this$0.c);
                    }
                    this$0.o = false;
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static final void M(EdgeFloat this$0, ValueAnimator valueAnimator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, this$0, valueAnimator) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            View view2 = this$0.g;
            View view3 = null;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentView");
                view2 = null;
            }
            if (view2.isAttachedToWindow()) {
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (animatedValue != null) {
                    this$0.f.x = ((Integer) animatedValue).intValue();
                    WindowManager u = this$0.u();
                    View view4 = this$0.g;
                    if (view4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("contentView");
                    } else {
                        view3 = view4;
                    }
                    u.updateViewLayout(view3, this$0.f);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
        }
    }

    public final void E(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            if (!z) {
                WindowManager.LayoutParams layoutParams = this.f;
                int i2 = layoutParams.x;
                int i3 = this.p;
                if (i2 == i3 && layoutParams.y == this.m) {
                    B(i3, this.q);
                }
                this.p = 0;
                this.q = 0;
                return;
            }
            WindowManager.LayoutParams layoutParams2 = this.f;
            this.p = layoutParams2.x;
            int i4 = layoutParams2.y;
            this.q = i4;
            if (i4 + layoutParams2.height >= this.x - i) {
                C(this.m);
            }
        }
    }

    public final void A(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048576, this, i) != null) || !this.h) {
            return;
        }
        this.f.x += i;
        WindowManager u = u();
        View view2 = this.g;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            view2 = null;
        }
        u.updateViewLayout(view2, this.f);
    }

    public final void C(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) != null) || !this.h) {
            return;
        }
        this.f.y = i;
        WindowManager u = u();
        View view2 = this.g;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            view2 = null;
        }
        u.updateViewLayout(view2, this.f);
    }

    public final void G(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && !((!z) | (!y(this.a)) | (!this.h)) && this.f.token == null) {
            p();
        }
    }

    public final void I(List<String> pageNoSupport) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, pageNoSupport) == null) {
            Intrinsics.checkNotNullParameter(pageNoSupport, "pageNoSupport");
            this.z.clear();
            this.z.addAll(pageNoSupport);
        }
    }

    @Override // com.baidu.tieba.tl6
    public void onChangeSkinType(int i) {
        tl6 tl6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i) == null) && (tl6Var = this.A) != null) {
            tl6Var.onChangeSkinType(i);
        }
    }

    public final void r(MotionEvent ev) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, ev) == null) {
            Intrinsics.checkNotNullParameter(ev, "ev");
            ul6 ul6Var = this.B;
            if (ul6Var != null) {
                ul6Var.dispatchTouchEvent(ev);
            }
        }
    }

    public final void B(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) != null) || !this.h) {
            return;
        }
        WindowManager.LayoutParams layoutParams = this.f;
        layoutParams.x = i;
        layoutParams.y = i2;
        WindowManager u = u();
        View view2 = this.g;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            view2 = null;
        }
        u.updateViewLayout(view2, this.f);
    }

    public static final void t(EdgeFloat this$0, ValueAnimator valueAnimator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, null, this$0, valueAnimator) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue != null) {
                float floatValue = ((Float) animatedValue).floatValue();
                View view2 = this$0.g;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentView");
                    view2 = null;
                }
                view2.setAlpha(floatValue);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public final void D() {
        ul6 ul6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (ul6Var = this.B) != null) {
            ul6Var.onBackPressed();
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a = null;
            this.h = false;
            this.y = false;
        }
    }

    public final WindowManager u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return (WindowManager) this.e.getValue();
        }
        return (WindowManager) invokeV.objValue;
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048593, this) != null) || !this.h) {
            return;
        }
        this.h = false;
        s(1.0f, 0.0f, new Function0<Unit>(this) { // from class: com.baidu.tieba.edgefloat.EdgeFloat$hide$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ EdgeFloat this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
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
            }

            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                View view2;
                WindowManager u;
                View view3;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                    return;
                }
                view2 = this.this$0.g;
                View view4 = null;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentView");
                    view2 = null;
                }
                view2.setOnTouchListener(null);
                u = this.this$0.u();
                view3 = this.this$0.g;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentView");
                } else {
                    view4 = view3;
                }
                u.removeView(view4);
            }
        });
    }

    public final boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.y;
        }
        return invokeV.booleanValue;
    }

    public final boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.h;
        }
        return invokeV.booleanValue;
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || this.h) {
            return;
        }
        this.h = true;
        View view2 = this.g;
        View view3 = null;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            view2 = null;
        }
        view2.setOnTouchListener(this.C);
        View view4 = this.g;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
        } else {
            view3 = view4;
        }
        view3.setAlpha(0.0f);
        s(0.0f, 1.0f, EdgeFloat$show$1.INSTANCE);
        this.f = q(this.i, this.j, this.k, this.l);
        if (!y(this.a)) {
            return;
        }
        p();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public final boolean w() {
        InterceptResult invokeV;
        IBinder iBinder;
        Window window;
        View decorView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            Activity activity = this.a;
            View view2 = null;
            if (activity != null && (window = activity.getWindow()) != null && (decorView = window.getDecorView()) != null) {
                iBinder = decorView.getWindowToken();
            } else {
                iBinder = null;
            }
            View view3 = this.g;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentView");
                view3 = null;
            }
            if (view3.isAttachedToWindow()) {
                View view4 = this.g;
                if (view4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentView");
                } else {
                    view2 = view4;
                }
                if (Intrinsics.areEqual(iBinder, view2.getApplicationWindowToken())) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void K(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, activity) == null) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (!y(activity)) {
                return;
            }
            this.a = activity;
            if (!this.h) {
                return;
            }
            WindowManager.LayoutParams layoutParams = this.f;
            this.f = q(layoutParams.x, layoutParams.y, layoutParams.width, layoutParams.height);
            p();
        }
    }

    public final boolean y(Activity activity) {
        InterceptResult invokeL;
        String str;
        Class<?> cls;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, activity)) == null) {
            if (activity != null && (cls = activity.getClass()) != null) {
                str = cls.getSimpleName();
            } else {
                str = null;
            }
            Iterator<String> it = this.z.iterator();
            while (it.hasNext()) {
                String pageNoSupport = it.next();
                Intrinsics.checkNotNullExpressionValue(pageNoSupport, "pageNoSupport");
                if (Intrinsics.areEqual(str, pageNoSupport)) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void L(int i, int i2, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)}) != null) || !this.h) {
            return;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
        ofInt.setDuration(j);
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ql6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                    EdgeFloat.M(EdgeFloat.this, valueAnimator);
                }
            }
        });
        ofInt.start();
    }

    public final void s(float f, float f2, Function0<Unit> function0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), function0}) == null) {
            ValueAnimator alphaAnim = ValueAnimator.ofFloat(f, f2);
            alphaAnim.setDuration(this.d);
            alphaAnim.setInterpolator(new AccelerateInterpolator());
            alphaAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.sl6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        EdgeFloat.t(EdgeFloat.this, valueAnimator);
                    }
                }
            });
            Intrinsics.checkNotNullExpressionValue(alphaAnim, "alphaAnim");
            alphaAnim.addListener(new b(function0));
            alphaAnim.start();
        }
    }

    public final void p() {
        IBinder iBinder;
        Window window;
        View decorView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            Activity activity = this.a;
            View view2 = null;
            if (activity != null && (window = activity.getWindow()) != null && (decorView = window.getDecorView()) != null) {
                iBinder = decorView.getWindowToken();
            } else {
                iBinder = null;
            }
            this.f.token = iBinder;
            if (!w() && this.f.token != null) {
                View view3 = this.g;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentView");
                    view3 = null;
                }
                if (view3.isAttachedToWindow()) {
                    WindowManager u = u();
                    View view4 = this.g;
                    if (view4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("contentView");
                        view4 = null;
                    }
                    u.removeViewImmediate(view4);
                }
                WindowManager u2 = u();
                View view5 = this.g;
                if (view5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentView");
                } else {
                    view2 = view5;
                }
                u2.addView(view2, this.f);
            }
        }
    }

    public final WindowManager.LayoutParams q(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048589, this, i, i2, i3, i4)) == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.type = 1003;
            layoutParams.flags = 520;
            layoutParams.format = -3;
            layoutParams.gravity = 51;
            layoutParams.x = i;
            layoutParams.y = i2;
            layoutParams.width = i3;
            layoutParams.height = i4;
            return layoutParams;
        }
        return (WindowManager.LayoutParams) invokeIIII.objValue;
    }
}
