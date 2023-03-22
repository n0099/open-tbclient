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
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.edgefloat.EdgeFloat;
import com.baidu.tieba.ql6;
import com.baidu.tieba.rl6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u00002\u00020\u0001:\u0001_B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010;\u001a\u00020<H\u0002J(\u0010=\u001a\u00020:2\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0002J\u000e\u0010>\u001a\u00020<2\u0006\u0010?\u001a\u00020@J&\u0010A\u001a\u00020<2\u0006\u0010B\u001a\u00020\u00192\u0006\u0010C\u001a\u00020\u00192\f\u0010D\u001a\b\u0012\u0004\u0012\u00020<0EH\u0002J\u0006\u0010F\u001a\u00020<J\b\u0010G\u001a\u00020\u0012H\u0002J\u0012\u0010H\u001a\u00020\u00122\b\u0010I\u001a\u0004\u0018\u00010\fH\u0002J\u0006\u0010 \u001a\u00020\u0012J\u000e\u0010J\u001a\u00020\u00062\u0006\u0010K\u001a\u00020\u0006J\u000e\u0010L\u001a\u00020<2\u0006\u0010\u0016\u001a\u00020\u0006J\u0016\u0010M\u001a\u00020<2\u0006\u0010N\u001a\u00020\u00062\u0006\u0010K\u001a\u00020\u0006J\u000e\u0010O\u001a\u00020<2\u0006\u0010K\u001a\u00020\u0006J\u0006\u0010P\u001a\u00020<J\u0010\u0010Q\u001a\u00020<2\u0006\u0010R\u001a\u00020\u0006H\u0016J\u0016\u0010S\u001a\u00020<2\u0006\u0010T\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u0006J\u000e\u0010U\u001a\u00020<2\u0006\u0010V\u001a\u00020\u0012J\u0006\u0010W\u001a\u00020<J\b\u0010X\u001a\u00020<H\u0002J\u0006\u0010Y\u001a\u00020<J\u000e\u0010Z\u001a\u00020<2\u0006\u0010I\u001a\u00020\fJ \u0010[\u001a\u00020<2\u0006\u0010\\\u001a\u00020\u00062\u0006\u0010]\u001a\u00020\u00062\u0006\u0010^\u001a\u00020\bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010'\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010+\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00103\u001a\u0002048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b5\u00106R\u000e\u00109\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006`"}, d2 = {"Lcom/baidu/tieba/edgefloat/EdgeFloat;", "Lcom/baidu/tieba/edgefloat/IChangeSkinType;", "builder", "Lcom/baidu/tieba/edgefloat/EdgeFloat$Builder;", "(Lcom/baidu/tieba/edgefloat/EdgeFloat$Builder;)V", "CLICK_MOTION_EVENT_DELTA", "", "FADE_IN_OUT_ANIM_TIME", "", "SLIDE_ANIM_TIME", "activityRef", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "avoidKeyboardHeight", "beforeKeyboardX", "beforeKeyboardY", "bottomLimit", "canDrag", "", "changeSkinListener", "contentView", "Landroid/view/View;", "deltaX", "deltaY", "downEventX", "", "downEventY", NotificationCompat.WearableExtender.KEY_GRAVITY, "height", "<set-?>", "isOnLeft", "()Z", "isShowing", "isTouching", "keyboardHeight", "onActivityDispatchTouchEvent", "Lcom/baidu/tieba/edgefloat/OnActivityDispatchTouchEventListener;", "onTouchListener", "Landroid/view/View$OnTouchListener;", "pageNoSupport", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "pageSupport", "screenHeight", "screenWidth", "startX", "startY", "statusBarHeight", "topLimit", "width", "wm", "Landroid/view/WindowManager;", "getWm", "()Landroid/view/WindowManager;", "wm$delegate", "Lkotlin/Lazy;", "wmParams", "Landroid/view/WindowManager$LayoutParams;", "addToWindow", "", "createLayoutParams", "dispatchTouchEvent", Config.EVENT_PART, "Landroid/view/MotionEvent;", "fadeAlpha", "oldAlpha", "newAlpha", "onEnd", "Lkotlin/Function0;", "hide", "isAttachedToCurrentActivityWindow", "isPageSupport", "activity", "limitY", "y", "moveToX", "moveXY", "x", "moveY", "onBackPressed", "onChangeSkinType", "type", "onKeyboardHeightChanged", "isVisible", "onWindowFocusChanged", "hasFocus", "release", "removeFromWindow", "show", "switchActivity", "translateX", "oldX", "newX", "duration", "Builder", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EdgeFloat implements ql6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public int C;
    public int D;
    public float E;
    public float F;
    public boolean G;
    public final View.OnTouchListener H;
    public final int a;
    public final long b;
    public final long c;
    public WeakReference<Activity> d;
    public View e;
    public int f;
    public int g;
    public int h;
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
    public final ArrayList<String> s;
    public final ArrayList<String> t;
    public ql6 u;
    public rl6 v;
    public final Lazy w;
    public WindowManager.LayoutParams x;
    public boolean y;
    public boolean z;

    /* loaded from: classes4.dex */
    public static class a {
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
        public int l;
        public int m;
        public boolean n;
        public final ArrayList<String> o;
        public final ArrayList<String> p;
        public ql6 q;
        public rl6 r;

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
            this.a = activity;
            this.b = new View(this.a);
            this.c = -2;
            this.d = -2;
            this.e = 51;
            this.n = true;
            this.o = new ArrayList<>();
            this.p = new ArrayList<>();
        }

        public final a A(List<String> pageNoSupport) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pageNoSupport)) == null) {
                Intrinsics.checkNotNullParameter(pageNoSupport, "pageNoSupport");
                this.p.clear();
                this.p.addAll(pageNoSupport);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a B(List<String> pageSupport) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pageSupport)) == null) {
                Intrinsics.checkNotNullParameter(pageSupport, "pageSupport");
                this.o.clear();
                this.o.addAll(pageSupport);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a C(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                this.m = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a D(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                this.l = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a E(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                this.f = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a F(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
                this.g = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a G(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
                this.k = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a H(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
                this.h = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a I(View contentView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, contentView)) == null) {
                Intrinsics.checkNotNullParameter(contentView, "contentView");
                this.b = contentView;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a J(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
                this.c = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
                this.j = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a b(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
                this.i = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a d(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048589, this, z)) == null) {
                this.n = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public final a w(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048608, this, i)) == null) {
                this.e = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a x(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048609, this, i)) == null) {
                this.d = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a y(rl6 onActivityDispatchTouchEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, onActivityDispatchTouchEvent)) == null) {
                Intrinsics.checkNotNullParameter(onActivityDispatchTouchEvent, "onActivityDispatchTouchEvent");
                this.r = onActivityDispatchTouchEvent;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a z(ql6 onChangeSkinType) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, onChangeSkinType)) == null) {
                Intrinsics.checkNotNullParameter(onChangeSkinType, "onChangeSkinType");
                this.q = onChangeSkinType;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final EdgeFloat c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                EdgeFloat edgeFloat = new EdgeFloat(this);
                EdgeFloatLifecycle.b.a().h(edgeFloat);
                return edgeFloat;
            }
            return (EdgeFloat) invokeV.objValue;
        }

        public final Activity e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                return this.a;
            }
            return (Activity) invokeV.objValue;
        }

        public final int f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return this.j;
            }
            return invokeV.intValue;
        }

        public final int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                return this.i;
            }
            return invokeV.intValue;
        }

        public final boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                return this.n;
            }
            return invokeV.booleanValue;
        }

        public final ql6 i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                return this.q;
            }
            return (ql6) invokeV.objValue;
        }

        public final View j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                return this.b;
            }
            return (View) invokeV.objValue;
        }

        public final int k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                return this.e;
            }
            return invokeV.intValue;
        }

        public final int l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                return this.d;
            }
            return invokeV.intValue;
        }

        public final rl6 m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
                return this.r;
            }
            return (rl6) invokeV.objValue;
        }

        public final ArrayList<String> n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                return this.p;
            }
            return (ArrayList) invokeV.objValue;
        }

        public final ArrayList<String> o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
                return this.o;
            }
            return (ArrayList) invokeV.objValue;
        }

        public final int p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
                return this.m;
            }
            return invokeV.intValue;
        }

        public final int q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
                return this.l;
            }
            return invokeV.intValue;
        }

        public final int r() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
                return this.f;
            }
            return invokeV.intValue;
        }

        public final int s() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
                return this.g;
            }
            return invokeV.intValue;
        }

        public final int t() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
                return this.k;
            }
            return invokeV.intValue;
        }

        public final int u() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
                return this.h;
            }
            return invokeV.intValue;
        }

        public final int v() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
                return this.c;
            }
            return invokeV.intValue;
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

    public EdgeFloat(a builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.a = 2;
        this.b = 250L;
        this.c = 300L;
        this.d = new WeakReference<>(builder.e());
        this.e = builder.j();
        this.f = builder.k();
        this.g = builder.r();
        this.h = builder.s();
        this.i = builder.v();
        this.j = builder.l();
        this.k = builder.u();
        this.l = builder.g();
        this.n = builder.f();
        this.o = builder.h();
        this.p = builder.t();
        this.q = builder.q();
        this.r = builder.p();
        this.s = builder.o();
        this.t = builder.n();
        this.u = builder.i();
        this.v = builder.m();
        this.w = LazyKt__LazyJVMKt.lazy(new Function0<WindowManager>(this) { // from class: com.baidu.tieba.edgefloat.EdgeFloat$wm$2
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
                WeakReference weakReference;
                Object obj;
                Activity activity;
                Context applicationContext;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                    return (WindowManager) invokeV.objValue;
                }
                weakReference = this.this$0.d;
                if (weakReference != null && (activity = (Activity) weakReference.get()) != null && (applicationContext = activity.getApplicationContext()) != null) {
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
        this.x = new WindowManager.LayoutParams();
        this.H = new View.OnTouchListener() { // from class: com.baidu.tieba.ol6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, motionEvent)) == null) ? EdgeFloat.u(EdgeFloat.this, view2, motionEvent) : invokeLL.booleanValue;
            }
        };
    }

    public static final void B(EdgeFloat this$0, ValueAnimator valueAnimator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, valueAnimator) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.e.isAttachedToWindow()) {
                WindowManager.LayoutParams layoutParams = this$0.x;
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (animatedValue != null) {
                    layoutParams.x = ((Integer) animatedValue).intValue();
                    this$0.i().updateViewLayout(this$0.e, this$0.x);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
        }
    }

    public final void f(MotionEvent ev) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ev) == null) {
            Intrinsics.checkNotNullParameter(ev, "ev");
            rl6 rl6Var = this.v;
            if (rl6Var != null) {
                rl6Var.dispatchTouchEvent(ev);
            }
        }
    }

    public final int o(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            int i2 = this.k - this.p;
            int height = (this.r - this.l) - this.e.getHeight();
            if (i < i2) {
                return i2;
            }
            if (i > height) {
                return height;
            }
            return i;
        }
        return invokeI.intValue;
    }

    @Override // com.baidu.tieba.ql6
    public void onChangeSkinType(int i) {
        ql6 ql6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048588, this, i) == null) && (ql6Var = this.u) != null) {
            ql6Var.onChangeSkinType(i);
        }
    }

    public final void p(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048589, this, i) != null) || !this.y) {
            return;
        }
        this.x.x += i;
        i().updateViewLayout(this.e, this.x);
    }

    public final void r(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048591, this, i) != null) || !this.y) {
            return;
        }
        this.x.y = o(i);
        i().updateViewLayout(this.e, this.x);
    }

    public static final void h(EdgeFloat this$0, ValueAnimator valueAnimator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, this$0, valueAnimator) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue != null) {
                this$0.e.setAlpha(((Float) animatedValue).floatValue());
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public final void q(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeII(1048590, this, i, i2) != null) || !this.y) {
            return;
        }
        int o = o(i2);
        WindowManager.LayoutParams layoutParams = this.x;
        layoutParams.x = i;
        layoutParams.y = o;
        i().updateViewLayout(this.e, this.x);
    }

    public static final boolean u(EdgeFloat this$0, View view2, MotionEvent motionEvent) {
        InterceptResult invokeLLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, this$0, view2, motionEvent)) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (motionEvent.getAction() == 0) {
                int[] iArr = new int[2];
                this$0.e.getLocationOnScreen(iArr);
                int i2 = iArr[0];
                int i3 = iArr[1];
                if (motionEvent.getRawX() > i2 && motionEvent.getRawX() < this$0.e.getWidth() + i2 && motionEvent.getRawY() > i3 && motionEvent.getRawY() < this$0.e.getHeight() + i3) {
                    this$0.z = true;
                    this$0.C = ((int) motionEvent.getRawX()) - i2;
                    this$0.D = ((int) motionEvent.getRawY()) - i3;
                }
                this$0.E = motionEvent.getRawX();
                this$0.F = motionEvent.getRawY();
            } else if (motionEvent.getAction() == 2) {
                if (this$0.z) {
                    this$0.q(((int) motionEvent.getRawX()) - this$0.C, (((int) motionEvent.getRawY()) - this$0.D) - this$0.p);
                }
            } else if (motionEvent.getAction() == 1) {
                if (Math.abs(motionEvent.getRawX() - this$0.E) < this$0.a && Math.abs(motionEvent.getRawY() - this$0.F) < this$0.a) {
                    View view3 = this$0.e;
                    if (view3 instanceof View.OnClickListener) {
                        ((View.OnClickListener) view3).onClick(view3);
                    }
                } else {
                    if (this$0.z) {
                        int i4 = this$0.x.x;
                        int width = (this$0.e.getWidth() / 2) + i4;
                        int i5 = this$0.q;
                        if (width > i5 / 2) {
                            i = i5 - this$0.e.getWidth();
                            this$0.G = false;
                        } else {
                            this$0.G = true;
                            i = 0;
                        }
                        this$0.A(i4, i, this$0.b);
                    }
                    this$0.z = false;
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public final void A(int i, int i2, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)}) != null) || !this.y) {
            return;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
        ofInt.setDuration(j);
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.nl6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                    EdgeFloat.B(EdgeFloat.this, valueAnimator);
                }
            }
        });
        ofInt.start();
    }

    public final void g(float f, float f2, Function0<Unit> function0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), function0}) == null) {
            ValueAnimator alphaAnim = ValueAnimator.ofFloat(f, f2);
            alphaAnim.setDuration(this.c);
            alphaAnim.setInterpolator(new AccelerateInterpolator());
            alphaAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pl6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        EdgeFloat.h(EdgeFloat.this, valueAnimator);
                    }
                }
            });
            Intrinsics.checkNotNullExpressionValue(alphaAnim, "alphaAnim");
            alphaAnim.addListener(new b(function0));
            alphaAnim.start();
        }
    }

    public final void d() {
        IBinder iBinder;
        Activity activity;
        Window window;
        View decorView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            WeakReference<Activity> weakReference = this.d;
            if (weakReference != null && (activity = weakReference.get()) != null && (window = activity.getWindow()) != null && (decorView = window.getDecorView()) != null) {
                iBinder = decorView.getWindowToken();
            } else {
                iBinder = null;
            }
            this.x.token = iBinder;
            if (!k() && this.x.token != null) {
                if (this.e.isAttachedToWindow()) {
                    i().removeViewImmediate(this.e);
                }
                i().addView(this.e, this.x);
            }
        }
    }

    public final boolean k() {
        InterceptResult invokeV;
        IBinder iBinder;
        Activity activity;
        Window window;
        View decorView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            WeakReference<Activity> weakReference = this.d;
            if (weakReference != null && (activity = weakReference.get()) != null && (window = activity.getWindow()) != null && (decorView = window.getDecorView()) != null) {
                iBinder = decorView.getWindowToken();
            } else {
                iBinder = null;
            }
            if (this.e.isAttachedToWindow() && Intrinsics.areEqual(iBinder, this.e.getApplicationWindowToken())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void y() {
        Activity activity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048597, this) != null) || this.y) {
            return;
        }
        this.y = true;
        if (this.o) {
            this.e.setOnTouchListener(this.H);
        }
        this.e.setAlpha(0.0f);
        g(0.0f, 1.0f, EdgeFloat$show$1.INSTANCE);
        this.x = e(this.g, this.h, this.i, this.j);
        WeakReference<Activity> weakReference = this.d;
        if (weakReference != null) {
            activity = weakReference.get();
        } else {
            activity = null;
        }
        if (!m(activity)) {
            return;
        }
        d();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public final WindowManager.LayoutParams e(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3, i4)) == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.type = 1003;
            layoutParams.flags = 520;
            layoutParams.format = -3;
            layoutParams.gravity = this.f;
            layoutParams.x = i;
            layoutParams.y = i2;
            layoutParams.width = i3;
            layoutParams.height = i4;
            return layoutParams;
        }
        return (WindowManager.LayoutParams) invokeIIII.objValue;
    }

    public final WindowManager i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return (WindowManager) this.w.getValue();
        }
        return (WindowManager) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || !this.y) {
            return;
        }
        this.y = false;
        g(1.0f, 0.0f, new Function0<Unit>(this) { // from class: com.baidu.tieba.edgefloat.EdgeFloat$hide$1
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
                boolean z;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                    return;
                }
                z = this.this$0.y;
                if (z) {
                    return;
                }
                this.this$0.x();
            }
        });
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.G;
        }
        return invokeV.booleanValue;
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.y;
        }
        return invokeV.booleanValue;
    }

    public final void s() {
        rl6 rl6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (rl6Var = this.v) != null) {
            rl6Var.onBackPressed();
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            WeakReference<Activity> weakReference = this.d;
            if (weakReference != null) {
                weakReference.clear();
            }
            this.y = false;
            this.G = false;
        }
    }

    public final boolean m(Activity activity) {
        InterceptResult invokeL;
        String str;
        Class<?> cls;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, activity)) == null) {
            if (activity != null && (cls = activity.getClass()) != null) {
                str = cls.getSimpleName();
            } else {
                str = null;
            }
            if (!this.s.isEmpty()) {
                return CollectionsKt___CollectionsKt.contains(this.s, str);
            }
            Iterator<String> it = this.t.iterator();
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

    public final void t(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            if (!z) {
                int i2 = this.r - this.m;
                WindowManager.LayoutParams layoutParams = this.x;
                if (layoutParams.x == this.A && layoutParams.y == o((i2 - this.e.getHeight()) - this.n)) {
                    q(this.A, this.B);
                }
                this.A = 0;
                this.B = 0;
                return;
            }
            this.m = i;
            WindowManager.LayoutParams layoutParams2 = this.x;
            this.A = layoutParams2.x;
            int i3 = layoutParams2.y;
            this.B = i3;
            int height = i3 + this.e.getHeight();
            int i4 = this.r - i;
            if (height >= i4) {
                r((i4 - this.e.getHeight()) - this.n);
            }
        }
    }

    public final void v(boolean z) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            boolean z2 = !z;
            WeakReference<Activity> weakReference = this.d;
            if (weakReference != null) {
                activity = weakReference.get();
            } else {
                activity = null;
            }
            if (!(z2 | (!m(activity)) | (!this.y)) && this.x.token == null) {
                d();
            }
        }
    }

    public final void z(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, activity) == null) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (!m(activity)) {
                return;
            }
            this.d = new WeakReference<>(activity);
            if (!this.y) {
                return;
            }
            WindowManager.LayoutParams layoutParams = this.x;
            this.x = e(layoutParams.x, layoutParams.y, layoutParams.width, layoutParams.height);
            d();
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && this.e.isAttachedToWindow()) {
            this.e.setOnTouchListener(null);
            try {
                i().removeView(this.e);
            } catch (Exception e) {
                DefaultLog.getInstance().b("EdgeFloat hide removeView crash", e.getMessage());
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw e;
                }
            }
        }
    }
}
