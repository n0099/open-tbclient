package com.baidu.tieba;

import android.view.View;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class br8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final RecyclerView a;
    public final Object b;
    public final Method c;
    public final Method d;
    public final Object e;
    public Object f;
    public Method g;
    public Method h;
    public Method i;
    public Integer j;
    public final PagerSnapHelper k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947654689, "Lcom/baidu/tieba/br8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947654689, "Lcom/baidu/tieba/br8;");
        }
    }

    public br8(ViewPager2 vp) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vp};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(vp, "vp");
        Field declaredField = ViewPager2.class.getDeclaredField("mRecyclerView");
        Intrinsics.checkNotNullExpressionValue(declaredField, "ViewPager2::class.java.g…redField(\"mRecyclerView\")");
        declaredField.setAccessible(true);
        Object obj = declaredField.get(vp);
        if (obj != null) {
            this.a = (RecyclerView) obj;
            Field declaredField2 = ViewPager2.class.getDeclaredField("mPagerSnapHelper");
            Intrinsics.checkNotNullExpressionValue(declaredField2, "ViewPager2::class.java.g…Field(\"mPagerSnapHelper\")");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(vp);
            if (obj2 != null) {
                this.k = (PagerSnapHelper) obj2;
                Field declaredField3 = ViewPager2.class.getDeclaredField("mFakeDragger");
                Intrinsics.checkNotNullExpressionValue(declaredField3, "ViewPager2::class.java.g…aredField(\"mFakeDragger\")");
                declaredField3.setAccessible(true);
                Object obj3 = declaredField3.get(vp);
                if (obj3 != null) {
                    this.e = obj3;
                    Field declaredField4 = ViewPager2.class.getDeclaredField("mScrollEventAdapter");
                    Intrinsics.checkNotNullExpressionValue(declaredField4, "ViewPager2::class.java.g…ld(\"mScrollEventAdapter\")");
                    declaredField4.setAccessible(true);
                    Object obj4 = declaredField4.get(vp);
                    if (obj4 != null) {
                        this.b = obj4;
                        Method declaredMethod = obj4.getClass().getDeclaredMethod("isFakeDragging", new Class[0]);
                        Intrinsics.checkNotNullExpressionValue(declaredMethod, "mScrollEventAdapter.java…dMethod(\"isFakeDragging\")");
                        this.c = declaredMethod;
                        declaredMethod.setAccessible(true);
                        Method declaredMethod2 = this.b.getClass().getDeclaredMethod("notifyEndFakeDrag", new Class[0]);
                        Intrinsics.checkNotNullExpressionValue(declaredMethod2, "mScrollEventAdapter.java…thod(\"notifyEndFakeDrag\")");
                        this.d = declaredMethod2;
                        declaredMethod2.setAccessible(true);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.PagerSnapHelper");
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Object invoke = this.c.invoke(this.b, new Object[0]);
            if (invoke != null) {
                if (!((Boolean) invoke).booleanValue()) {
                    return;
                }
                this.d.invoke(this.b, new Object[0]);
                Method method = null;
                if (this.f == null) {
                    Field declaredField = this.e.getClass().getDeclaredField("mVelocityTracker");
                    Intrinsics.checkNotNullExpressionValue(declaredField, "mFakeDrag.javaClass.getD…Field(\"mVelocityTracker\")");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(this.e);
                    this.f = obj;
                    Intrinsics.checkNotNull(obj);
                    Method declaredMethod = obj.getClass().getDeclaredMethod("computeCurrentVelocity", Integer.TYPE, Float.TYPE);
                    Intrinsics.checkNotNullExpressionValue(declaredMethod, "mVelocityTracker!!.javaC….java, Float::class.java)");
                    this.g = declaredMethod;
                    if (declaredMethod == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("computeCurrentVelocityMethod");
                        declaredMethod = null;
                    }
                    declaredMethod.setAccessible(true);
                    Object obj2 = this.f;
                    Intrinsics.checkNotNull(obj2);
                    Method declaredMethod2 = obj2.getClass().getDeclaredMethod("getXVelocity", new Class[0]);
                    Intrinsics.checkNotNullExpressionValue(declaredMethod2, "mVelocityTracker!!.javaC…redMethod(\"getXVelocity\")");
                    this.h = declaredMethod2;
                    if (declaredMethod2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("getXVelocityMethod");
                        declaredMethod2 = null;
                    }
                    declaredMethod2.setAccessible(true);
                    Object obj3 = this.f;
                    Intrinsics.checkNotNull(obj3);
                    Method declaredMethod3 = obj3.getClass().getDeclaredMethod("getYVelocity", new Class[0]);
                    Intrinsics.checkNotNullExpressionValue(declaredMethod3, "mVelocityTracker!!.javaC…redMethod(\"getYVelocity\")");
                    this.i = declaredMethod3;
                    if (declaredMethod3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("getYVelocityMethod");
                        declaredMethod3 = null;
                    }
                    declaredMethod3.setAccessible(true);
                    Field declaredField2 = this.e.getClass().getDeclaredField("mMaximumVelocity");
                    Intrinsics.checkNotNullExpressionValue(declaredField2, "mFakeDrag.javaClass.getD…Field(\"mMaximumVelocity\")");
                    declaredField2.setAccessible(true);
                    Object obj4 = declaredField2.get(this.e);
                    if (obj4 != null) {
                        this.j = Integer.valueOf(((Integer) obj4).intValue());
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                }
                Method method2 = this.g;
                if (method2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("computeCurrentVelocityMethod");
                    method2 = null;
                }
                method2.invoke(this.f, 1000, this.j);
                Method method3 = this.h;
                if (method3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("getXVelocityMethod");
                    method3 = null;
                }
                Object invoke2 = method3.invoke(this.f, new Object[0]);
                if (invoke2 != null) {
                    float floatValue = ((Float) invoke2).floatValue();
                    Method method4 = this.i;
                    if (method4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("getYVelocityMethod");
                    } else {
                        method = method4;
                    }
                    Object invoke3 = method.invoke(this.f, new Object[0]);
                    if (invoke3 != null) {
                        if (!this.a.fling((int) floatValue, (int) ((Float) invoke3).floatValue())) {
                            b();
                            return;
                        }
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        }
    }

    public final void b() {
        View findSnapView;
        RecyclerView.LayoutManager layoutManager;
        int[] calculateDistanceToFinalSnap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (findSnapView = this.k.findSnapView(this.a.getLayoutManager())) != null && (layoutManager = this.a.getLayoutManager()) != null && (calculateDistanceToFinalSnap = this.k.calculateDistanceToFinalSnap(layoutManager, findSnapView)) != null) {
            if (calculateDistanceToFinalSnap[0] != 0 || calculateDistanceToFinalSnap[1] != 0) {
                this.a.smoothScrollBy(calculateDistanceToFinalSnap[0], calculateDistanceToFinalSnap[1], null, 1000);
            }
        }
    }
}
