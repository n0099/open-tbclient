package com.baidu.tieba.forum.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\u001c\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\t\u001a)\u0010\n\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f*\u0002H\u000b2\u0006\u0010\r\u001a\u0002H\u000b2\u0006\u0010\u000e\u001a\u0002H\u000b¢\u0006\u0002\u0010\u000f\u001a\u0012\u0010\u0010\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002\u001a\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0002*\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013\u001a(\u0010\u0015\u001a\u0004\u0018\u00010\u0002*\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00012\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0018\u001a\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0002*\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013\u001a$\u0010\u001a\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\t\u001a\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0002*\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013\u001a\u001a\u0010\u001d\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013\u001a\u001a\u0010\u001e\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t\u001a\u0012\u0010!\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\"\u001a\u00020\u0013\u001a\n\u0010#\u001a\u00020\u0005*\u00020\u0002¨\u0006$"}, d2 = {"canNestedScrollHorizontally", "", "Landroid/view/View;", "canNestedScrollVertically", "checkAndAddView", "", "Landroid/view/ViewGroup;", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "index", "", "constrains", ExifInterface.GPS_DIRECTION_TRUE, "", "min", FunAdSdk.PLATFORM_MAX, "(Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;)Ljava/lang/Number;", "containsView", "findChildUnder", "rawX", "", "rawY", "findFirst", "recursively", "predict", "Lkotlin/Function1;", "findHorizontalNestedScrollingTarget", "findScrollableTarget", "dScrollY", "findVerticalNestedScrollingTarget", "isUnder", "setLayoutSize", "layoutWidth", "layoutHeight", "setRoundRect", "radius", "stopScroll", "forum_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ViewExtentionsKt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, view2)) == null) {
            Intrinsics.checkNotNullParameter(view2, "<this>");
            if ((view2 instanceof NestedScrollingChild) && (view2.canScrollHorizontally(1) || view2.canScrollHorizontally(-1))) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static final boolean b(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            Intrinsics.checkNotNullParameter(view2, "<this>");
            if ((view2 instanceof NestedScrollingChild) && (view2.canScrollVertically(1) || view2.canScrollVertically(-1))) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static final void c(ViewGroup viewGroup, View child, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65538, null, viewGroup, child, i) == null) {
            Intrinsics.checkNotNullParameter(viewGroup, "<this>");
            Intrinsics.checkNotNullParameter(child, "child");
            if (!f(viewGroup, child)) {
                viewGroup.addView(child, i);
            }
        }
    }

    public static /* synthetic */ void d(ViewGroup viewGroup, View view2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        c(viewGroup, view2, i);
    }

    public static final <T extends Number> T e(T t, T min, T max) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, t, min, max)) == null) {
            Intrinsics.checkNotNullParameter(t, "<this>");
            Intrinsics.checkNotNullParameter(min, "min");
            Intrinsics.checkNotNullParameter(max, "max");
            if (t.doubleValue() < min.doubleValue()) {
                return min;
            }
            if (t.doubleValue() > max.doubleValue()) {
                return max;
            }
            return t;
        }
        return (T) invokeLLL.objValue;
    }

    public static final View g(ViewGroup viewGroup, final float f, final float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{viewGroup, Float.valueOf(f), Float.valueOf(f2)})) == null) {
            Intrinsics.checkNotNullParameter(viewGroup, "<this>");
            return h(viewGroup, false, new Function1<View, Boolean>(f, f2) { // from class: com.baidu.tieba.forum.widget.ViewExtentionsKt$findChildUnder$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ float $rawX;
                public final /* synthetic */ float $rawY;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {Float.valueOf(f), Float.valueOf(f2)};
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
                    this.$rawX = f;
                    this.$rawY = f2;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(View it) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, it)) == null) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return Boolean.valueOf(ViewExtentionsKt.k(it, this.$rawX, this.$rawY));
                    }
                    return (Boolean) invokeL.objValue;
                }
            });
        }
        return (View) invokeCommon.objValue;
    }

    public static final boolean f(ViewGroup viewGroup, View child) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, viewGroup, child)) == null) {
            Intrinsics.checkNotNullParameter(viewGroup, "<this>");
            Intrinsics.checkNotNullParameter(child, "child");
            if (viewGroup.indexOfChild(child) >= 0) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static final View h(ViewGroup viewGroup, boolean z, Function1<? super View, Boolean> predict) {
        InterceptResult invokeCommon;
        View h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{viewGroup, Boolean.valueOf(z), predict})) == null) {
            Intrinsics.checkNotNullParameter(viewGroup, "<this>");
            Intrinsics.checkNotNullParameter(predict, "predict");
            int childCount = viewGroup.getChildCount();
            int i = 0;
            while (true) {
                ViewGroup viewGroup2 = null;
                if (i >= childCount) {
                    return null;
                }
                View v = viewGroup.getChildAt(i);
                Intrinsics.checkNotNullExpressionValue(v, "v");
                if (predict.invoke(v).booleanValue()) {
                    return v;
                }
                if (z) {
                    if (v instanceof ViewGroup) {
                        viewGroup2 = (ViewGroup) v;
                    }
                    if (viewGroup2 != null && (h = h(viewGroup2, z, predict)) != null) {
                        return h;
                    }
                }
                i++;
            }
        } else {
            return (View) invokeCommon.objValue;
        }
    }

    public static final View i(ViewGroup viewGroup, float f, float f2) {
        InterceptResult invokeCommon;
        View i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{viewGroup, Float.valueOf(f), Float.valueOf(f2)})) == null) {
            Intrinsics.checkNotNullParameter(viewGroup, "<this>");
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View v = viewGroup.getChildAt(i2);
                Intrinsics.checkNotNullExpressionValue(v, "v");
                if (k(v, f, f2)) {
                    if (a(v)) {
                        return v;
                    }
                    if ((v instanceof ViewGroup) && (i = i((ViewGroup) v, f, f2)) != null) {
                        return i;
                    }
                }
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public static final View j(ViewGroup viewGroup, float f, float f2) {
        InterceptResult invokeCommon;
        View j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{viewGroup, Float.valueOf(f), Float.valueOf(f2)})) == null) {
            Intrinsics.checkNotNullParameter(viewGroup, "<this>");
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View v = viewGroup.getChildAt(i);
                Intrinsics.checkNotNullExpressionValue(v, "v");
                if (k(v, f, f2)) {
                    if (b(v)) {
                        return v;
                    }
                    if ((v instanceof ViewGroup) && (j = j((ViewGroup) v, f, f2)) != null) {
                        return j;
                    }
                }
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public static final boolean k(View view2, float f, float f2) {
        InterceptResult invokeCommon;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{view2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
            Intrinsics.checkNotNullParameter(view2, "<this>");
            int[] iArr = new int[2];
            view2.getLocationOnScreen(iArr);
            int i = iArr[0];
            int width = iArr[0] + view2.getWidth();
            int i2 = (int) f;
            if (i <= i2 && i2 <= width) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return false;
            }
            int i3 = iArr[1];
            int height = iArr[1] + view2.getHeight();
            int i4 = (int) f2;
            if (i3 <= i4 && i4 <= height) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                return false;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static final void l(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, view2) == null) {
            Intrinsics.checkNotNullParameter(view2, "<this>");
            MotionEvent obtain = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, (view2.getLeft() + view2.getRight()) / 2.0f, (view2.getTop() + view2.getBottom()) / 2.0f, 0);
            view2.dispatchTouchEvent(obtain);
            obtain.setAction(3);
            view2.dispatchTouchEvent(obtain);
            obtain.recycle();
        }
    }
}
