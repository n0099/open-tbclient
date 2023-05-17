package com.baidu.tbadk.template.state;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes4.dex */
public final class ViewType {
    public static final /* synthetic */ ViewType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ViewType CONTENT;
    public static final ViewType EMPTY;
    public static final ViewType ERROR;
    public static final ViewType LOADING;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1355189140, "Lcom/baidu/tbadk/template/state/ViewType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1355189140, "Lcom/baidu/tbadk/template/state/ViewType;");
                return;
            }
        }
        CONTENT = new ViewType("CONTENT", 0);
        LOADING = new ViewType("LOADING", 1);
        ERROR = new ViewType("ERROR", 2);
        ViewType viewType = new ViewType("EMPTY", 3);
        EMPTY = viewType;
        $VALUES = new ViewType[]{CONTENT, LOADING, ERROR, viewType};
    }

    public ViewType(String str, int i) {
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

    public static ViewType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (ViewType) Enum.valueOf(ViewType.class, str);
        }
        return (ViewType) invokeL.objValue;
    }

    public static ViewType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (ViewType[]) $VALUES.clone();
        }
        return (ViewType[]) invokeV.objValue;
    }
}
