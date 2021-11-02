package com.baidu.tieba.advert.sdk.data;

import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes9.dex */
public final class CreativeType {
    public static final /* synthetic */ CreativeType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final CreativeType FLASH;
    public static final CreativeType HTML;
    public static final CreativeType IMAGE;
    public static final CreativeType NATIVE;
    public transient /* synthetic */ FieldHolder $fh;
    public int typeId;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(193189263, "Lcom/baidu/tieba/advert/sdk/data/CreativeType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(193189263, "Lcom/baidu/tieba/advert/sdk/data/CreativeType;");
                return;
            }
        }
        IMAGE = new CreativeType("IMAGE", 0, 0);
        FLASH = new CreativeType("FLASH", 1, 1);
        HTML = new CreativeType("HTML", 2, 3);
        CreativeType creativeType = new CreativeType(Constant.TYPE_NATIVE, 3, 5);
        NATIVE = creativeType;
        $VALUES = new CreativeType[]{IMAGE, FLASH, HTML, creativeType};
    }

    public CreativeType(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.typeId = i3;
    }

    public static CreativeType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (CreativeType) Enum.valueOf(CreativeType.class, str) : (CreativeType) invokeL.objValue;
    }

    public static CreativeType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (CreativeType[]) $VALUES.clone() : (CreativeType[]) invokeV.objValue;
    }

    public int getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.typeId : invokeV.intValue;
    }
}
