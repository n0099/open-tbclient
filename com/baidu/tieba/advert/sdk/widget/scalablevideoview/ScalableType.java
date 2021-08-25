package com.baidu.tieba.advert.sdk.widget.scalablevideoview;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes7.dex */
public final class ScalableType {
    public static final /* synthetic */ ScalableType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ScalableType CENTER;
    public static final ScalableType CENTER_BOTTOM;
    public static final ScalableType CENTER_BOTTOM_CROP;
    public static final ScalableType CENTER_CROP;
    public static final ScalableType CENTER_INSIDE;
    public static final ScalableType CENTER_TOP;
    public static final ScalableType CENTER_TOP_CROP;
    public static final ScalableType END_INSIDE;
    public static final ScalableType FIT_CENTER;
    public static final ScalableType FIT_END;
    public static final ScalableType FIT_START;
    public static final ScalableType FIT_XY;
    public static final ScalableType LEFT_BOTTOM;
    public static final ScalableType LEFT_BOTTOM_CROP;
    public static final ScalableType LEFT_CENTER;
    public static final ScalableType LEFT_CENTER_CROP;
    public static final ScalableType LEFT_TOP;
    public static final ScalableType LEFT_TOP_CROP;
    public static final ScalableType NONE;
    public static final ScalableType RIGHT_BOTTOM;
    public static final ScalableType RIGHT_BOTTOM_CROP;
    public static final ScalableType RIGHT_CENTER;
    public static final ScalableType RIGHT_CENTER_CROP;
    public static final ScalableType RIGHT_TOP;
    public static final ScalableType RIGHT_TOP_CROP;
    public static final ScalableType START_INSIDE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1034742945, "Lcom/baidu/tieba/advert/sdk/widget/scalablevideoview/ScalableType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1034742945, "Lcom/baidu/tieba/advert/sdk/widget/scalablevideoview/ScalableType;");
                return;
            }
        }
        NONE = new ScalableType("NONE", 0);
        FIT_XY = new ScalableType("FIT_XY", 1);
        FIT_START = new ScalableType("FIT_START", 2);
        FIT_CENTER = new ScalableType("FIT_CENTER", 3);
        FIT_END = new ScalableType("FIT_END", 4);
        LEFT_TOP = new ScalableType("LEFT_TOP", 5);
        LEFT_CENTER = new ScalableType("LEFT_CENTER", 6);
        LEFT_BOTTOM = new ScalableType("LEFT_BOTTOM", 7);
        CENTER_TOP = new ScalableType("CENTER_TOP", 8);
        CENTER = new ScalableType("CENTER", 9);
        CENTER_BOTTOM = new ScalableType("CENTER_BOTTOM", 10);
        RIGHT_TOP = new ScalableType("RIGHT_TOP", 11);
        RIGHT_CENTER = new ScalableType("RIGHT_CENTER", 12);
        RIGHT_BOTTOM = new ScalableType("RIGHT_BOTTOM", 13);
        LEFT_TOP_CROP = new ScalableType("LEFT_TOP_CROP", 14);
        LEFT_CENTER_CROP = new ScalableType("LEFT_CENTER_CROP", 15);
        LEFT_BOTTOM_CROP = new ScalableType("LEFT_BOTTOM_CROP", 16);
        CENTER_TOP_CROP = new ScalableType("CENTER_TOP_CROP", 17);
        CENTER_CROP = new ScalableType("CENTER_CROP", 18);
        CENTER_BOTTOM_CROP = new ScalableType("CENTER_BOTTOM_CROP", 19);
        RIGHT_TOP_CROP = new ScalableType("RIGHT_TOP_CROP", 20);
        RIGHT_CENTER_CROP = new ScalableType("RIGHT_CENTER_CROP", 21);
        RIGHT_BOTTOM_CROP = new ScalableType("RIGHT_BOTTOM_CROP", 22);
        START_INSIDE = new ScalableType("START_INSIDE", 23);
        CENTER_INSIDE = new ScalableType("CENTER_INSIDE", 24);
        ScalableType scalableType = new ScalableType("END_INSIDE", 25);
        END_INSIDE = scalableType;
        $VALUES = new ScalableType[]{NONE, FIT_XY, FIT_START, FIT_CENTER, FIT_END, LEFT_TOP, LEFT_CENTER, LEFT_BOTTOM, CENTER_TOP, CENTER, CENTER_BOTTOM, RIGHT_TOP, RIGHT_CENTER, RIGHT_BOTTOM, LEFT_TOP_CROP, LEFT_CENTER_CROP, LEFT_BOTTOM_CROP, CENTER_TOP_CROP, CENTER_CROP, CENTER_BOTTOM_CROP, RIGHT_TOP_CROP, RIGHT_CENTER_CROP, RIGHT_BOTTOM_CROP, START_INSIDE, CENTER_INSIDE, scalableType};
    }

    public ScalableType(String str, int i2) {
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

    public static ScalableType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ScalableType) Enum.valueOf(ScalableType.class, str) : (ScalableType) invokeL.objValue;
    }

    public static ScalableType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ScalableType[]) $VALUES.clone() : (ScalableType[]) invokeV.objValue;
    }
}
