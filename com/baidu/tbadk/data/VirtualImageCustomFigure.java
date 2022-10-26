package com.baidu.tbadk.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import tbclient.CustomFigure;
/* loaded from: classes3.dex */
public class VirtualImageCustomFigure implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static String BACK_GROUND_TYPE_TONE = "tone";
    public static String BACK_GROUND_TYPE_URL = "url";
    public transient /* synthetic */ FieldHolder $fh;
    public String backGroundType;
    public String backgroundValue;
    public String dynamicFigureUrl;
    public String figureUrl;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-820273932, "Lcom/baidu/tbadk/data/VirtualImageCustomFigure;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-820273932, "Lcom/baidu/tbadk/data/VirtualImageCustomFigure;");
        }
    }

    public VirtualImageCustomFigure() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public String getBackGroundType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.backGroundType;
        }
        return (String) invokeV.objValue;
    }

    public String getBackgroundValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.backgroundValue;
        }
        return (String) invokeV.objValue;
    }

    public String getDynamicFigureUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.dynamicFigureUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getFigureUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.figureUrl;
        }
        return (String) invokeV.objValue;
    }

    public void parseProto(CustomFigure customFigure) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, customFigure) != null) || customFigure == null) {
            return;
        }
        this.figureUrl = customFigure.figure_url;
        this.backGroundType = customFigure.background_type;
        this.backgroundValue = customFigure.background_value;
        this.dynamicFigureUrl = customFigure.dynamic_figure_url;
    }

    public void setBackGroundType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.backGroundType = str;
        }
    }

    public void setBackgroundValue(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.backgroundValue = str;
        }
    }

    public void setFigureUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.figureUrl = str;
        }
    }
}
