package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class CubeOutViewPagerTransformer extends BaseViewPagerTransformer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CubeOutViewPagerTransformer() {
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

    public static double f(double d2, double d3, double d4, double d5, double d6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5), Double.valueOf(d6)})) == null) ? (((d2 - d3) / (d4 - d3)) * (d6 - d5)) + d5 : invokeCommon.doubleValue;
    }

    @Override // com.baidu.tieba.frs.BaseViewPagerTransformer
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.frs.BaseViewPagerTransformer
    public void e(View view, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, f2) == null) {
            float f3 = ((float) f(f2, -1.0d, 1.0d, -90.0d, 90.0d)) * 0.5f;
            view.setCameraDistance(5500 * 1.0f);
            if (f2 > 0.0f) {
                view.setRotationY(f3);
                view.setPivotX(0.0f);
                view.setPivotY(view.getHeight() * 0.5f);
                view.setLayerType(2, null);
            } else if (f2 < 0.0f) {
                view.setRotationY(f3);
                view.setPivotX(view.getWidth() * 1.0f);
                view.setPivotY(view.getHeight() * 0.5f);
                view.setLayerType(2, null);
            } else {
                view.setRotationY(0.0f);
                view.setPivotX(view.getWidth() * 0.5f);
                view.setPivotY(view.getHeight() * 0.5f);
                view.setLayerType(0, null);
            }
        }
    }
}
