package com.baidu.tieba.frs;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public abstract class BaseViewPagerTransformer implements ViewPager.PageTransformer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BaseViewPagerTransformer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static final float min(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? f2 < f3 ? f3 : f2 : invokeCommon.floatValue;
    }

    public boolean hideOffscreenPages() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isPagingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onPostTransform(View view, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(Constants.METHOD_SEND_USER_MSG, this, view, f2) == null) {
        }
    }

    public void onPreTransform(View view, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048579, this, view, f2) == null) {
            float width = view.getWidth();
            float f3 = 0.0f;
            view.setRotationX(0.0f);
            view.setRotationY(0.0f);
            view.setRotation(0.0f);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            view.setPivotX(0.0f);
            view.setPivotY(0.0f);
            view.setTranslationY(0.0f);
            view.setTranslationX(isPagingEnabled() ? 0.0f : (-width) * f2);
            if (hideOffscreenPages()) {
                if (f2 > -1.0f && f2 < 1.0f) {
                    f3 = 1.0f;
                }
                view.setAlpha(f3);
                view.setEnabled(false);
                return;
            }
            view.setEnabled(true);
            view.setAlpha(1.0f);
        }
    }

    public abstract void onTransform(View view, float f2);

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer
    public void transformPage(View view, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048581, this, view, f2) == null) {
            onPreTransform(view, f2);
            onTransform(view, f2);
            onPostTransform(view, f2);
        }
    }
}
