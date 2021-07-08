package com.baidu.tbadk.coreExtra.data;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class EmotionGroupType {
    public static final /* synthetic */ EmotionGroupType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final EmotionGroupType BIG_EMOTION;
    public static final EmotionGroupType LOCAL;
    public static final EmotionGroupType NET_SUG;
    public static final EmotionGroupType PROMOTION;
    public static final EmotionGroupType SINGLE_FORUM;
    public static final EmotionGroupType USER_COLLECT;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1629630745, "Lcom/baidu/tbadk/coreExtra/data/EmotionGroupType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1629630745, "Lcom/baidu/tbadk/coreExtra/data/EmotionGroupType;");
                return;
            }
        }
        LOCAL = new EmotionGroupType("LOCAL", 0);
        BIG_EMOTION = new EmotionGroupType("BIG_EMOTION", 1);
        PROMOTION = new EmotionGroupType("PROMOTION", 2);
        USER_COLLECT = new EmotionGroupType("USER_COLLECT", 3);
        SINGLE_FORUM = new EmotionGroupType("SINGLE_FORUM", 4);
        EmotionGroupType emotionGroupType = new EmotionGroupType("NET_SUG", 5);
        NET_SUG = emotionGroupType;
        $VALUES = new EmotionGroupType[]{LOCAL, BIG_EMOTION, PROMOTION, USER_COLLECT, SINGLE_FORUM, emotionGroupType};
    }

    public EmotionGroupType(String str, int i2) {
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

    public static EmotionGroupType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (EmotionGroupType) Enum.valueOf(EmotionGroupType.class, str) : (EmotionGroupType) invokeL.objValue;
    }

    public static EmotionGroupType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (EmotionGroupType[]) $VALUES.clone() : (EmotionGroupType[]) invokeV.objValue;
    }
}
