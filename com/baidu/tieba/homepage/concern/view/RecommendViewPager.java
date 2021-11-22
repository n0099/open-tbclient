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
/* loaded from: classes9.dex */
public class RecommendViewPager extends ViewPager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public float f50367e;

    /* renamed from: f  reason: collision with root package name */
    public float f50368f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendViewPager(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f50367e = 0.0f;
        this.f50368f = 0.0f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x002e, code lost:
        if (r1 != 3) goto L18;
     */
    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            int currentItem = getCurrentItem();
            boolean z = (currentItem == 0 || currentItem == (getAdapter() == null ? 0 : getAdapter().getCount()) - 1) ? false : true;
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        float abs = Math.abs(motionEvent.getX() - this.f50367e);
                        float abs2 = Math.abs(motionEvent.getY() - this.f50368f);
                        this.f50367e = motionEvent.getX();
                        this.f50368f = motionEvent.getY();
                        if (abs2 / abs < 1.0f && z) {
                            requestParentInterceptTouchEvent(true);
                        } else {
                            requestParentInterceptTouchEvent(false);
                        }
                    }
                }
                requestParentInterceptTouchEvent(false);
            } else {
                this.f50367e = motionEvent.getX();
                this.f50368f = motionEvent.getY();
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void requestParentInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || getParent() == null) {
            return;
        }
        getParent().requestDisallowInterceptTouchEvent(z);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f50367e = 0.0f;
        this.f50368f = 0.0f;
    }
}
