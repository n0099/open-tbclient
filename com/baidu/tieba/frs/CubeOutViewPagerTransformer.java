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

    public static double f(double d, double d2, double d3, double d4, double d5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Double.valueOf(d), Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5)})) == null) ? (((d - d2) / (d3 - d2)) * (d5 - d4)) + d4 : invokeCommon.doubleValue;
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

    public CubeOutViewPagerTransformer() {
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

    @Override // com.baidu.tieba.frs.BaseViewPagerTransformer
    public void e(View view2, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, f) == null) {
            float f2 = ((float) f(f, -1.0d, 1.0d, -90.0d, 90.0d)) * 0.5f;
            view2.setCameraDistance(5500 * 1.0f);
            if (f > 0.0f) {
                view2.setRotationY(f2);
                view2.setPivotX(0.0f);
                view2.setPivotY(view2.getHeight() * 0.5f);
                view2.setLayerType(2, null);
            } else if (f < 0.0f) {
                view2.setRotationY(f2);
                view2.setPivotX(view2.getWidth() * 1.0f);
                view2.setPivotY(view2.getHeight() * 0.5f);
                view2.setLayerType(2, null);
            } else {
                view2.setRotationY(0.0f);
                view2.setPivotX(view2.getWidth() * 0.5f);
                view2.setPivotY(view2.getHeight() * 0.5f);
                view2.setLayerType(0, null);
            }
        }
    }
}
