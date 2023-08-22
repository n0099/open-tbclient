package com.baidu.tieba.frs.shrinkhead;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes6.dex */
public final class LogicField {
    public static final /* synthetic */ LogicField[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final LogicField BACK_BTN;
    public static final LogicField BACK_IV;
    public static final LogicField BANNER_AND_BOTTOM_VIEW;
    public static final LogicField BRAND_LABEL;
    public static final LogicField FOLD_TITLE;
    public static final LogicField GROUP_BTN;
    public static final LogicField INFO_AREA;
    public static final LogicField LEVEL_AND_LEVEL_NAME;
    public static final LogicField LIKE_BTN;
    public static final LogicField MESSAGE_BTN;
    public static final LogicField MESSAGE_ICON_CONTROLLER;
    public static final LogicField MESSAGE_RED_DOT;
    public static final LogicField MORE_BTN;
    public static final LogicField ROUND_CORNER_STYLE;
    public static final LogicField SEARCH_BTN;
    public static final LogicField SERVICE_AREA;
    public static final LogicField SHARE_BTN;
    public static final LogicField SIGN_BTN;
    public static final LogicField SPEED_ICON;
    public static final LogicField TOP_AREA;
    public static final LogicField TOP_DIVIDER;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-562030609, "Lcom/baidu/tieba/frs/shrinkhead/LogicField;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-562030609, "Lcom/baidu/tieba/frs/shrinkhead/LogicField;");
                return;
            }
        }
        BACK_BTN = new LogicField("BACK_BTN", 0);
        BACK_IV = new LogicField("BACK_IV", 1);
        SEARCH_BTN = new LogicField("SEARCH_BTN", 2);
        MESSAGE_ICON_CONTROLLER = new LogicField("MESSAGE_ICON_CONTROLLER", 3);
        MESSAGE_BTN = new LogicField("MESSAGE_BTN", 4);
        MESSAGE_RED_DOT = new LogicField("MESSAGE_RED_DOT", 5);
        SHARE_BTN = new LogicField("SHARE_BTN", 6);
        FOLD_TITLE = new LogicField("FOLD_TITLE", 7);
        BRAND_LABEL = new LogicField("BRAND_LABEL", 8);
        INFO_AREA = new LogicField("INFO_AREA", 9);
        LEVEL_AND_LEVEL_NAME = new LogicField("LEVEL_AND_LEVEL_NAME", 10);
        SPEED_ICON = new LogicField("SPEED_ICON", 11);
        LIKE_BTN = new LogicField("LIKE_BTN", 12);
        SIGN_BTN = new LogicField("SIGN_BTN", 13);
        MORE_BTN = new LogicField("MORE_BTN", 14);
        SERVICE_AREA = new LogicField("SERVICE_AREA", 15);
        TOP_AREA = new LogicField("TOP_AREA", 16);
        ROUND_CORNER_STYLE = new LogicField("ROUND_CORNER_STYLE", 17);
        TOP_DIVIDER = new LogicField("TOP_DIVIDER", 18);
        BANNER_AND_BOTTOM_VIEW = new LogicField("BANNER_AND_BOTTOM_VIEW", 19);
        LogicField logicField = new LogicField("GROUP_BTN", 20);
        GROUP_BTN = logicField;
        $VALUES = new LogicField[]{BACK_BTN, BACK_IV, SEARCH_BTN, MESSAGE_ICON_CONTROLLER, MESSAGE_BTN, MESSAGE_RED_DOT, SHARE_BTN, FOLD_TITLE, BRAND_LABEL, INFO_AREA, LEVEL_AND_LEVEL_NAME, SPEED_ICON, LIKE_BTN, SIGN_BTN, MORE_BTN, SERVICE_AREA, TOP_AREA, ROUND_CORNER_STYLE, TOP_DIVIDER, BANNER_AND_BOTTOM_VIEW, logicField};
    }

    public LogicField(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static LogicField valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (LogicField) Enum.valueOf(LogicField.class, str);
        }
        return (LogicField) invokeL.objValue;
    }

    public static LogicField[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (LogicField[]) $VALUES.clone();
        }
        return (LogicField[]) invokeV.objValue;
    }
}
