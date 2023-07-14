package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class RecommendViewPager extends ViewPager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;
    public float b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendViewPager(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        this.a = 0.0f;
        this.b = 0.0f;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0.0f;
        this.b = 0.0f;
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0026, code lost:
        if (r3 != 3) goto L13;
     */
    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        int count;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            int currentItem = getCurrentItem();
            if (getAdapter() == null) {
                count = 0;
            } else {
                count = getAdapter().getCount();
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        float abs = Math.abs(motionEvent.getX() - this.a);
                        float abs2 = Math.abs(motionEvent.getY() - this.b);
                        if (currentItem != count - 1 && motionEvent.getX() < this.a) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (currentItem != 0 && motionEvent.getX() > this.a) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        this.a = motionEvent.getX();
                        this.b = motionEvent.getY();
                        int i = (abs > 0.0f ? 1 : (abs == 0.0f ? 0 : -1));
                        if (i != 0 && Math.abs(abs2 / abs) < 1.0f && (z2 || z)) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (i == 0 && abs2 == 0.0f) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (!z4 && !z3) {
                            a(false);
                        } else {
                            a(true);
                        }
                    }
                }
                a(false);
            } else {
                this.a = motionEvent.getX();
                this.b = motionEvent.getY();
                a(true);
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }
}
