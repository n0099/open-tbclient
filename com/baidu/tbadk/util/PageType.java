package com.baidu.tbadk.util;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public final class PageType {
    public static final /* synthetic */ PageType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final PageType FLOOR_IN_FLOOR;
    public static final PageType FRS;
    public static final PageType IMAGE_PB;
    public static final PageType PB;
    public static final PageType PERSON_INFO;
    public static final PageType WRITE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1616468920, "Lcom/baidu/tbadk/util/PageType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1616468920, "Lcom/baidu/tbadk/util/PageType;");
                return;
            }
        }
        PERSON_INFO = new PageType("PERSON_INFO", 0);
        FRS = new PageType("FRS", 1);
        PB = new PageType("PB", 2);
        IMAGE_PB = new PageType("IMAGE_PB", 3);
        FLOOR_IN_FLOOR = new PageType("FLOOR_IN_FLOOR", 4);
        PageType pageType = new PageType("WRITE", 5);
        WRITE = pageType;
        $VALUES = new PageType[]{PERSON_INFO, FRS, PB, IMAGE_PB, FLOOR_IN_FLOOR, pageType};
    }

    public PageType(String str, int i2) {
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

    public static PageType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (PageType) Enum.valueOf(PageType.class, str) : (PageType) invokeL.objValue;
    }

    public static PageType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (PageType[]) $VALUES.clone() : (PageType[]) invokeV.objValue;
    }
}
