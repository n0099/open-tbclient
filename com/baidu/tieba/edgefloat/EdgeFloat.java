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
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tieba.edgefloat.EdgeFloat;
import com.baidu.tieba.hx6;
import com.baidu.tieba.ix6;
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
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b \u0018\u00002\u00020\u0001:\u0002fgB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010>\u001a\u00020?H\u0002J(\u0010@\u001a\u00020=2\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0002J\u000e\u0010A\u001a\u00020?2\u0006\u0010B\u001a\u00020CJ&\u0010D\u001a\u00020?2\u0006\u0010E\u001a\u00020\u00192\u0006\u0010F\u001a\u00020\u00192\f\u0010G\u001a\b\u0012\u0004\u0012\u00020?0HH\u0002J\u0006\u0010I\u001a\u00020?J\b\u0010J\u001a\u00020\u0012H\u0002J\u0012\u0010K\u001a\u00020\u00122\b\u0010L\u001a\u0004\u0018\u00010\fH\u0002J\u0006\u0010 \u001a\u00020\u0012J\u000e\u0010M\u001a\u00020\u00062\u0006\u0010N\u001a\u00020\u0006J\b\u0010O\u001a\u00020?H\u0002J\b\u0010P\u001a\u00020?H\u0002J\u000e\u0010Q\u001a\u00020?2\u0006\u0010\u0016\u001a\u00020\u0006J\u0016\u0010R\u001a\u00020?2\u0006\u0010S\u001a\u00020\u00062\u0006\u0010N\u001a\u00020\u0006J\u000e\u0010T\u001a\u00020?2\u0006\u0010N\u001a\u00020\u0006J\u0006\u0010U\u001a\u00020?J\u0010\u0010V\u001a\u00020?2\u0006\u0010W\u001a\u00020\u0006H\u0016J\u0016\u0010X\u001a\u00020?2\u0006\u0010Y\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u0006J\u0016\u0010Z\u001a\u00020?2\u0006\u0010/\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u0006J\u000e\u0010[\u001a\u00020?2\u0006\u0010\\\u001a\u00020\u0012J\u0006\u0010]\u001a\u00020?J\b\u0010^\u001a\u00020?H\u0002J\u0016\u0010_\u001a\u00020?2\u0006\u00105\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006J\u0006\u0010`\u001a\u00020?J\u000e\u0010a\u001a\u00020?2\u0006\u0010L\u001a\u00020\fJ \u0010b\u001a\u00020?2\u0006\u0010c\u001a\u00020\u00062\u0006\u0010d\u001a\u00020\u00062\u0006\u0010e\u001a\u00020\bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010)\u001a\u0012\u0012\u0004\u0012\u00020+0*j\b\u0012\u0004\u0012\u00020+`,X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010-\u001a\u0012\u0012\u0004\u0012\u00020+0*j\b\u0012\u0004\u0012\u00020+`,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00106\u001a\u0002078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b8\u00109R\u000e\u0010<\u001a\u00020=X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006h"}, d2 = {"Lcom/baidu/tieba/edgefloat/EdgeFloat;", "Lcom/baidu/tieba/edgefloat/IChangeSkinType;", "builder", "Lcom/baidu/tieba/edgefloat/EdgeFloat$Builder;", "(Lcom/baidu/tieba/edgefloat/EdgeFloat$Builder;)V", "CLICK_MOTION_EVENT_DELTA", "", "FADE_IN_OUT_ANIM_TIME", "", "SLIDE_ANIM_TIME", "activityRef", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "avoidKeyboardHeight", "beforeKeyboardX", "beforeKeyboardY", "bottomLimit", "canDrag", "", "changeSkinListener", "contentView", "Landroid/view/View;", "deltaX", "deltaY", "downEventX", "", "downEventY", NotificationCompat.WearableExtender.KEY_GRAVITY, "height", "<set-?>", "isOnLeft", "()Z", "isShowing", "isTouching", "keyboardHeight", "onActivityDispatchTouchEvent", "Lcom/baidu/tieba/edgefloat/OnActivityDispatchTouchEventListener;", "onScreenSizeChangedCallback", "Lcom/baidu/tieba/edgefloat/EdgeFloat$OnScreenSizeChangedCallback;", "onTouchListener", "Landroid/view/View$OnTouchListener;", "pageNoSupport", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "pageSupport", "screenHeight", "screenWidth", "startX", "startY", "statusBarHeight", "topLimit", "useFadeAnimation", "width", "wm", "Landroid/view/WindowManager;", "getWm", "()Landroid/view/WindowManager;", "wm$delegate", "Lkotlin/Lazy;", "wmParams", "Landroid/view/WindowManager$LayoutParams;", "addToWindow", "", "createLayoutParams", "dispatchTouchEvent", Config.EVENT_PART, "Landroid/view/MotionEvent;", "fadeAlpha", "oldAlpha", "newAlpha", "onEnd", "Lkotlin/Function0;", "hide", "isAttachedToCurrentActivityWindow", "isPageSupport", "activity", "limitY", "y", "moveToDefaultEdge", "moveToEdge", "moveToX", "moveXY", "x", "moveY", "onBackPressed", "onChangeSkinType", "type", "onKeyboardHeightChanged", "isVisible", "onScreenSizeChanged", "onWindowFocusChanged", "hasFocus", "release", "removeFromWindow", "resetContentViewSize", "show", "switchActivity", "translateX", "oldX", "newX", "duration", "Builder", "OnScreenSizeChangedCallback", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EdgeFloat implements hx6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public int C;
    public int D;
    public int E;
    public int F;
    public float G;
    public float H;
    public boolean I;
    public final View.OnTouchListener J;
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
    public hx6 u;
    public ix6 v;
    public final boolean w;
    public final b x;
    public final Lazy y;
    public WindowManager.LayoutParams z;

    /* loaded from: classes5.dex */
    public interface b {
        void a(int i, int i2);
    }

    /* loaded from: classes5.dex */
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
        public hx6 q;
        public ix6 r;
        public boolean s;
        public b t;

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
            this.s = true;
        }

        public final a A(ix6 onActivityDispatchTouchEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, onActivityDispatchTouchEvent)) == null) {
                Intrinsics.checkNotNullParameter(onActivityDispatchTouchEvent, "onActivityDispatchTouchEvent");
                this.r = onActivityDispatchTouchEvent;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a B(hx6 onChangeSkinType) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onChangeSkinType)) == null) {
                Intrinsics.checkNotNullParameter(onChangeSkinType, "onChangeSkinType");
                this.q = onChangeSkinType;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a C(List<String> pageNoSupport) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pageNoSupport)) == null) {
                Intrinsics.checkNotNullParameter(pageNoSupport, "pageNoSupport");
                this.p.clear();
                this.p.addAll(pageNoSupport);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a D(List<String> pageSupport) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, pageSupport)) == null) {
                Intrinsics.checkNotNullParameter(pageSupport, "pageSupport");
                this.o.clear();
                this.o.addAll(pageSupport);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a E(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                this.m = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a F(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
                this.l = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a G(b onScreenSizeChangedCallback) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, onScreenSizeChangedCallback)) == null) {
                Intrinsics.checkNotNullParameter(onScreenSizeChangedCallback, "onScreenSizeChangedCallback");
                this.t = onScreenSizeChangedCallback;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a H(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
                this.s = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public final a I(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
                this.f = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a J(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
                this.g = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a K(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
                this.k = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a L(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
                this.h = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a M(View contentView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, contentView)) == null) {
                Intrinsics.checkNotNullParameter(contentView, "contentView");
                this.b = contentView;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a N(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
                this.c = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
                this.j = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a b(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
                this.i = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a d(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048593, this, z)) == null) {
                this.n = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public final a y(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048614, this, i)) == null) {
                this.e = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a z(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048615, this, i)) == null) {
                this.d = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final EdgeFloat c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                EdgeFloat edgeFloat = new EdgeFloat(this);
                EdgeFloatLifecycle.b.a().i(edgeFloat);
                return edgeFloat;
            }
            return (EdgeFloat) invokeV.objValue;
        }

        public final Activity e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                return this.a;
            }
            return (Activity) invokeV.objValue;
        }

        public final int f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                return this.j;
            }
            return invokeV.intValue;
        }

        public final int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                return this.i;
            }
            return invokeV.intValue;
        }

        public final boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                return this.n;
            }
            return invokeV.booleanValue;
        }

        public final hx6 i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
                return this.q;
            }
            return (hx6) invokeV.objValue;
        }

        public final View j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                return this.b;
            }
            return (View) invokeV.objValue;
        }

        public final int k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
                return this.e;
            }
            return invokeV.intValue;
        }

        public final int l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
                return this.d;
            }
            return invokeV.intValue;
        }

        public final ix6 m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
                return this.r;
            }
            return (ix6) invokeV.objValue;
        }

        public final b n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
                return this.t;
            }
            return (b) invokeV.objValue;
        }

        public final ArrayList<String> o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
                return this.p;
            }
            return (ArrayList) invokeV.objValue;
        }

        public final ArrayList<String> p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
                return this.o;
            }
            return (ArrayList) invokeV.objValue;
        }

        public final int q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
                return this.m;
            }
            return invokeV.intValue;
        }

        public final int r() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
                return this.l;
            }
            return invokeV.intValue;
        }

        public final int s() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
                return this.f;
            }
            return invokeV.intValue;
        }

        public final int t() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
                return this.g;
            }
            return invokeV.intValue;
        }

        public final int u() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
                return this.k;
            }
            return invokeV.intValue;
        }

        public final int v() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
                return this.h;
            }
            return invokeV.intValue;
        }

        public final boolean w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
                return this.s;
            }
            return invokeV.booleanValue;
        }

        public final int x() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
                return this.c;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public static final class c implements Animator.AnimatorListener {
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

        public c(Function0 function0) {
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
        this.g = builder.s();
        this.h = builder.t();
        this.i = builder.x();
        this.j = builder.l();
        this.k = builder.v();
        this.l = builder.g();
        this.n = builder.f();
        this.o = builder.h();
        this.p = builder.u();
        this.q = builder.r();
        this.r = builder.q();
        this.s = builder.p();
        this.t = builder.o();
        this.u = builder.i();
        this.v = builder.m();
        this.w = builder.w();
        this.x = builder.n();
        this.y = LazyKt__LazyJVMKt.lazy(new Function0<WindowManager>(this) { // from class: com.baidu.tieba.edgefloat.EdgeFloat$wm$2
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
                    obj = applicationContext.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW);
                } else {
                    obj = null;
                }
                if (obj != null) {
                    return (WindowManager) obj;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
            }
        });
        this.z = new WindowManager.LayoutParams();
        this.J = new View.OnTouchListener() { // from class: com.baidu.tieba.fx6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, motionEvent)) == null) ? EdgeFloat.y(EdgeFloat.this, view2, motionEvent) : invokeLL.booleanValue;
            }
        };
    }

    public static final void G(EdgeFloat this$0, ValueAnimator valueAnimator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, valueAnimator) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.e.isAttachedToWindow()) {
                WindowManager.LayoutParams layoutParams = this$0.z;
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (animatedValue != null) {
                    layoutParams.x = ((Integer) animatedValue).intValue();
                    this$0.j().updateViewLayout(this$0.e, this$0.z);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
        }
    }

    public final void C(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) != null) || !this.A) {
            return;
        }
        this.i = i;
        this.j = i2;
        this.z = f(this.g, this.h, i, i2);
        if (this.e.isAttachedToWindow()) {
            j().updateViewLayout(this.e, this.z);
        }
    }

    public final void g(MotionEvent ev) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ev) == null) {
            Intrinsics.checkNotNullParameter(ev, "ev");
            ix6 ix6Var = this.v;
            if (ix6Var != null) {
                ix6Var.dispatchTouchEvent(ev);
            }
        }
    }

    @Override // com.baidu.tieba.hx6
    public void onChangeSkinType(int i) {
        hx6 hx6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048592, this, i) == null) && (hx6Var = this.u) != null) {
            hx6Var.onChangeSkinType(i);
        }
    }

    public final int p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
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

    public final void s(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048596, this, i) != null) || !this.A) {
            return;
        }
        this.z.x += i;
        if (this.e.isAttachedToWindow()) {
            j().updateViewLayout(this.e, this.z);
        }
    }

    public final void u(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048598, this, i) != null) || !this.A) {
            return;
        }
        this.z.y = p(i);
        if (this.e.isAttachedToWindow()) {
            j().updateViewLayout(this.e, this.z);
        }
    }

    public static final void i(EdgeFloat this$0, ValueAnimator valueAnimator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, this$0, valueAnimator) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue != null) {
                this$0.e.setAlpha(((Float) animatedValue).floatValue());
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public final void t(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeII(1048597, this, i, i2) != null) || !this.A) {
            return;
        }
        int p = p(i2);
        WindowManager.LayoutParams layoutParams = this.z;
        layoutParams.x = i;
        layoutParams.y = p;
        if (this.e.isAttachedToWindow()) {
            j().updateViewLayout(this.e, this.z);
        }
    }

    public final void x(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048601, this, i, i2) == null) {
            if (i == this.q && i2 == this.r) {
                return;
            }
            this.q = i;
            this.r = i2;
            if (this.o) {
                q();
            }
            b bVar = this.x;
            if (bVar != null) {
                bVar.a(i, i2);
            }
        }
    }

    public static final boolean y(EdgeFloat this$0, View view2, MotionEvent motionEvent) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, this$0, view2, motionEvent)) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (motionEvent.getAction() == 0) {
                int[] iArr = new int[2];
                this$0.e.getLocationOnScreen(iArr);
                int i = iArr[0];
                int i2 = iArr[1];
                if (motionEvent.getRawX() > i && motionEvent.getRawX() < this$0.e.getWidth() + i && motionEvent.getRawY() > i2 && motionEvent.getRawY() < this$0.e.getHeight() + i2) {
                    this$0.B = true;
                    this$0.E = ((int) motionEvent.getRawX()) - i;
                    this$0.F = ((int) motionEvent.getRawY()) - i2;
                }
                this$0.G = motionEvent.getRawX();
                this$0.H = motionEvent.getRawY();
            } else if (motionEvent.getAction() == 2) {
                if (this$0.B) {
                    this$0.t(((int) motionEvent.getRawX()) - this$0.E, (((int) motionEvent.getRawY()) - this$0.F) - this$0.p);
                }
            } else if (motionEvent.getAction() == 1) {
                if (Math.abs(motionEvent.getRawX() - this$0.G) < this$0.a && Math.abs(motionEvent.getRawY() - this$0.H) < this$0.a) {
                    View view3 = this$0.e;
                    if (view3 instanceof View.OnClickListener) {
                        ((View.OnClickListener) view3).onClick(view3);
                    }
                } else {
                    if (this$0.B) {
                        this$0.r();
                    }
                    this$0.B = false;
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            WeakReference<Activity> weakReference = this.d;
            if (weakReference != null) {
                weakReference.clear();
            }
            this.A = false;
            this.I = false;
        }
    }

    public final WindowManager j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return (WindowManager) this.y.getValue();
        }
        return (WindowManager) invokeV.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048587, this) != null) || !this.A) {
            return;
        }
        this.A = false;
        if (this.w) {
            h(1.0f, 0.0f, new Function0<Unit>(this) { // from class: com.baidu.tieba.edgefloat.EdgeFloat$hide$1
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
                    View view2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                        return;
                    }
                    z = this.this$0.A;
                    if (z) {
                        return;
                    }
                    view2 = this.this$0.e;
                    view2.setVisibility(4);
                    this.this$0.B();
                }
            });
            return;
        }
        this.e.setVisibility(4);
        B();
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.I;
        }
        return invokeV.booleanValue;
    }

    public final boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.A;
        }
        return invokeV.booleanValue;
    }

    public final void q() {
        int width;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            int i = this.z.x;
            if (this.I) {
                width = 0;
            } else {
                width = this.q - this.e.getWidth();
            }
            F(i, width, this.b);
        }
    }

    public final void v() {
        ix6 ix6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && (ix6Var = this.v) != null) {
            ix6Var.onBackPressed();
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.e.isAttachedToWindow()) {
            this.e.setOnTouchListener(null);
            try {
                j().removeView(this.e);
            } catch (Exception e) {
                DefaultLog.getInstance().b("EdgeFloat hide removeView crash", e.getMessage());
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw e;
                }
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            int i = this.z.x;
            int width = (this.e.getWidth() / 2) + i;
            int i2 = this.q;
            int i3 = 0;
            if (width > i2 / 2) {
                this.I = false;
                i3 = i2 - this.e.getWidth();
            } else {
                this.I = true;
            }
            F(i, i3, this.b);
        }
    }

    public final void D() {
        Activity activity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || this.A) {
            return;
        }
        this.A = true;
        if (this.o) {
            this.e.setOnTouchListener(this.J);
        }
        this.e.setVisibility(0);
        if (this.w) {
            this.e.setAlpha(0.0f);
            h(0.0f, 1.0f, EdgeFloat$show$1.INSTANCE);
        }
        this.z = f(this.g, this.h, this.i, this.j);
        WeakReference<Activity> weakReference = this.d;
        if (weakReference != null) {
            activity = weakReference.get();
        } else {
            activity = null;
        }
        if (!n(activity)) {
            return;
        }
        e();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void e() {
        IBinder iBinder;
        Activity activity;
        Window window;
        View decorView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            WeakReference<Activity> weakReference = this.d;
            if (weakReference != null && (activity = weakReference.get()) != null && (window = activity.getWindow()) != null && (decorView = window.getDecorView()) != null) {
                iBinder = decorView.getWindowToken();
            } else {
                iBinder = null;
            }
            this.z.token = iBinder;
            if (l()) {
                return;
            }
            try {
                if (this.z.token != null) {
                    if (this.e.isAttachedToWindow()) {
                        j().removeViewImmediate(this.e);
                    }
                    j().addView(this.e, this.z);
                }
            } catch (Exception e) {
                if (!BdBaseApplication.getInst().isDebugMode()) {
                    DefaultLog.getInstance().b("Sprite Window", e.getMessage());
                    new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 6).param("obj_source", e.getMessage()).eventStat();
                    return;
                }
                throw e;
            }
        }
    }

    public final void E(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, activity) == null) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (!n(activity)) {
                return;
            }
            this.d = new WeakReference<>(activity);
            if (!this.A) {
                return;
            }
            WindowManager.LayoutParams layoutParams = this.z;
            this.z = f(layoutParams.x, layoutParams.y, layoutParams.width, layoutParams.height);
            e();
        }
    }

    public final void z(boolean z) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            boolean z2 = !z;
            WeakReference<Activity> weakReference = this.d;
            if (weakReference != null) {
                activity = weakReference.get();
            } else {
                activity = null;
            }
            if (!(z2 | (!n(activity)) | (!this.A)) && this.z.token == null) {
                e();
            }
        }
    }

    public final void F(int i, int i2, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)}) != null) || !this.A) {
            return;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
        ofInt.setDuration(j);
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ex6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                    EdgeFloat.G(EdgeFloat.this, valueAnimator);
                }
            }
        });
        ofInt.start();
    }

    public final void h(float f, float f2, Function0<Unit> function0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), function0}) == null) {
            ValueAnimator alphaAnim = ValueAnimator.ofFloat(f, f2);
            alphaAnim.setDuration(this.c);
            alphaAnim.setInterpolator(new AccelerateInterpolator());
            alphaAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.gx6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        EdgeFloat.i(EdgeFloat.this, valueAnimator);
                    }
                }
            });
            Intrinsics.checkNotNullExpressionValue(alphaAnim, "alphaAnim");
            alphaAnim.addListener(new c(function0));
            alphaAnim.start();
        }
    }

    public final WindowManager.LayoutParams f(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048583, this, i, i2, i3, i4)) == null) {
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

    public final boolean l() {
        InterceptResult invokeV;
        IBinder iBinder;
        Activity activity;
        Window window;
        View decorView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
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

    public final boolean n(Activity activity) {
        InterceptResult invokeL;
        String str;
        Class<?> cls;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, activity)) == null) {
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

    public final void w(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            if (!z) {
                int i2 = this.r - this.m;
                WindowManager.LayoutParams layoutParams = this.z;
                if (layoutParams.x == this.C && layoutParams.y == p((i2 - this.e.getHeight()) - this.n)) {
                    t(this.C, this.D);
                }
                this.C = 0;
                this.D = 0;
                return;
            }
            this.m = i;
            WindowManager.LayoutParams layoutParams2 = this.z;
            this.C = layoutParams2.x;
            int i3 = layoutParams2.y;
            this.D = i3;
            int height = i3 + this.e.getHeight();
            int i4 = this.r - i;
            if (height >= i4) {
                u((i4 - this.e.getHeight()) - this.n);
            }
        }
    }
}
