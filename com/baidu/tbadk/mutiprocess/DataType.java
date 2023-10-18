package com.baidu.tbadk.mutiprocess;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public final class DataType {
    public static final /* synthetic */ DataType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final DataType ORM;
    public static final DataType PARCELABLE;
    public static final DataType SERIALIZABLE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1274707415, "Lcom/baidu/tbadk/mutiprocess/DataType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1274707415, "Lcom/baidu/tbadk/mutiprocess/DataType;");
                return;
            }
        }
        ORM = new DataType("ORM", 0);
        PARCELABLE = new DataType("PARCELABLE", 1);
        DataType dataType = new DataType("SERIALIZABLE", 2);
        SERIALIZABLE = dataType;
        $VALUES = new DataType[]{ORM, PARCELABLE, dataType};
    }

    public DataType(String str, int i) {
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

    public static DataType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (DataType) Enum.valueOf(DataType.class, str);
        }
        return (DataType) invokeL.objValue;
    }

    public static DataType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (DataType[]) $VALUES.clone();
        }
        return (DataType[]) invokeV.objValue;
    }
}
