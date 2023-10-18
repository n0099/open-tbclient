package com.baidu.tieba.frs;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class BaseViewPagerTransformer implements ViewPager.PageTransformer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void c(View view2, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(Constants.METHOD_SEND_USER_MSG, this, view2, f) == null) {
        }
    }

    public abstract void e(View view2, float f);

    public BaseViewPagerTransformer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void d(View view2, float f) {
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048579, this, view2, f) == null) {
            float width = view2.getWidth();
            float f3 = 0.0f;
            view2.setRotationX(0.0f);
            view2.setRotationY(0.0f);
            view2.setRotation(0.0f);
            view2.setScaleX(1.0f);
            view2.setScaleY(1.0f);
            view2.setPivotX(0.0f);
            view2.setPivotY(0.0f);
            view2.setTranslationY(0.0f);
            if (b()) {
                f2 = 0.0f;
            } else {
                f2 = (-width) * f;
            }
            view2.setTranslationX(f2);
            if (a()) {
                if (f > -1.0f && f < 1.0f) {
                    f3 = 1.0f;
                }
                view2.setAlpha(f3);
                view2.setEnabled(false);
                return;
            }
            view2.setEnabled(true);
            view2.setAlpha(1.0f);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer
    public void transformPage(View view2, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048581, this, view2, f) == null) {
            d(view2, f);
            e(view2, f);
            c(view2, f);
        }
    }
}
