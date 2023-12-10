package com.baidu.tieba;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class ghb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-774442197, "Lcom/baidu/tieba/ghb$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-774442197, "Lcom/baidu/tieba/ghb$a;");
                    return;
                }
            }
            int[] iArr = new int[EmotionGroupType.values().length];
            iArr[EmotionGroupType.LOCAL.ordinal()] = 1;
            iArr[EmotionGroupType.BIG_EMOTION.ordinal()] = 2;
            iArr[EmotionGroupType.PROMOTION.ordinal()] = 3;
            iArr[EmotionGroupType.USER_COLLECT.ordinal()] = 4;
            iArr[EmotionGroupType.SINGLE_FORUM.ordinal()] = 5;
            iArr[EmotionGroupType.NET_SUG.ordinal()] = 6;
            iArr[EmotionGroupType.USER_DIY.ordinal()] = 7;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final String b(EmotionGroupType emotionGroupType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, emotionGroupType)) == null) {
            switch (a.$EnumSwitchMapping$0[emotionGroupType.ordinal()]) {
                case 1:
                    return "LOCAL";
                case 2:
                    return "BIG_EMOTION";
                case 3:
                    return "PROMOTION";
                case 4:
                    return "USER_COLLECT";
                case 5:
                    return "SINGLE_FORUM";
                case 6:
                    return "NET_SUG";
                case 7:
                    return "USER_DIY";
                default:
                    return "";
            }
        }
        return (String) invokeL.objValue;
    }
}
