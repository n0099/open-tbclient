package com.baidu.tieba.advert.sdk.widget.scalablevideoview;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes12.dex */
public final class PivotPoint {
    public static final /* synthetic */ PivotPoint[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final PivotPoint CENTER;
    public static final PivotPoint CENTER_BOTTOM;
    public static final PivotPoint CENTER_TOP;
    public static final PivotPoint LEFT_BOTTOM;
    public static final PivotPoint LEFT_CENTER;
    public static final PivotPoint LEFT_TOP;
    public static final PivotPoint RIGHT_BOTTOM;
    public static final PivotPoint RIGHT_CENTER;
    public static final PivotPoint RIGHT_TOP;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1222672576, "Lcom/baidu/tieba/advert/sdk/widget/scalablevideoview/PivotPoint;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1222672576, "Lcom/baidu/tieba/advert/sdk/widget/scalablevideoview/PivotPoint;");
                return;
            }
        }
        LEFT_TOP = new PivotPoint("LEFT_TOP", 0);
        LEFT_CENTER = new PivotPoint("LEFT_CENTER", 1);
        LEFT_BOTTOM = new PivotPoint("LEFT_BOTTOM", 2);
        CENTER_TOP = new PivotPoint("CENTER_TOP", 3);
        CENTER = new PivotPoint("CENTER", 4);
        CENTER_BOTTOM = new PivotPoint("CENTER_BOTTOM", 5);
        RIGHT_TOP = new PivotPoint("RIGHT_TOP", 6);
        RIGHT_CENTER = new PivotPoint("RIGHT_CENTER", 7);
        PivotPoint pivotPoint = new PivotPoint("RIGHT_BOTTOM", 8);
        RIGHT_BOTTOM = pivotPoint;
        $VALUES = new PivotPoint[]{LEFT_TOP, LEFT_CENTER, LEFT_BOTTOM, CENTER_TOP, CENTER, CENTER_BOTTOM, RIGHT_TOP, RIGHT_CENTER, pivotPoint};
    }

    public PivotPoint(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static PivotPoint valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (PivotPoint) Enum.valueOf(PivotPoint.class, str) : (PivotPoint) invokeL.objValue;
    }

    public static PivotPoint[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (PivotPoint[]) $VALUES.clone() : (PivotPoint[]) invokeV.objValue;
    }
}
