package com.baidu.tieba.ala.alasquare.liveroomlivetab;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes7.dex */
public final class NormalSkinPbListView$IconType {
    public static final /* synthetic */ NormalSkinPbListView$IconType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final NormalSkinPbListView$IconType ICON_DOWN_WARD;
    public static final NormalSkinPbListView$IconType ICON_UP_WARD;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1685581741, "Lcom/baidu/tieba/ala/alasquare/liveroomlivetab/NormalSkinPbListView$IconType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1685581741, "Lcom/baidu/tieba/ala/alasquare/liveroomlivetab/NormalSkinPbListView$IconType;");
                return;
            }
        }
        ICON_DOWN_WARD = new NormalSkinPbListView$IconType("ICON_DOWN_WARD", 0);
        NormalSkinPbListView$IconType normalSkinPbListView$IconType = new NormalSkinPbListView$IconType("ICON_UP_WARD", 1);
        ICON_UP_WARD = normalSkinPbListView$IconType;
        $VALUES = new NormalSkinPbListView$IconType[]{ICON_DOWN_WARD, normalSkinPbListView$IconType};
    }

    public NormalSkinPbListView$IconType(String str, int i2) {
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

    public static NormalSkinPbListView$IconType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (NormalSkinPbListView$IconType) Enum.valueOf(NormalSkinPbListView$IconType.class, str) : (NormalSkinPbListView$IconType) invokeL.objValue;
    }

    public static NormalSkinPbListView$IconType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (NormalSkinPbListView$IconType[]) $VALUES.clone() : (NormalSkinPbListView$IconType[]) invokeV.objValue;
    }
}
