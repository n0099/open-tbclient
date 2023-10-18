package com.baidu.tbadk.coreExtra.data;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public final class EmotionGroupType {
    public static final /* synthetic */ EmotionGroupType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final EmotionGroupType BIG_EMOTION;
    public static final EmotionGroupType LOCAL;
    public static final EmotionGroupType NET_SUG;
    public static final EmotionGroupType PROMOTION;
    public static final EmotionGroupType SINGLE_FORUM;
    public static final EmotionGroupType USER_COLLECT;
    public static final EmotionGroupType USER_DIY;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1587936132, "Lcom/baidu/tbadk/coreExtra/data/EmotionGroupType$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1587936132, "Lcom/baidu/tbadk/coreExtra/data/EmotionGroupType$a;");
                    return;
                }
            }
            int[] iArr = new int[EmotionGroupType.values().length];
            a = iArr;
            try {
                iArr[EmotionGroupType.BIG_EMOTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[EmotionGroupType.USER_COLLECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[EmotionGroupType.USER_DIY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

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
        NET_SUG = new EmotionGroupType("NET_SUG", 5);
        EmotionGroupType emotionGroupType = new EmotionGroupType("USER_DIY", 6);
        USER_DIY = emotionGroupType;
        $VALUES = new EmotionGroupType[]{LOCAL, BIG_EMOTION, PROMOTION, USER_COLLECT, SINGLE_FORUM, NET_SUG, emotionGroupType};
    }

    public EmotionGroupType(String str, int i) {
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

    public static boolean isSendAsPic(@NonNull EmotionGroupType emotionGroupType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, emotionGroupType)) == null) {
            int i = a.a[emotionGroupType.ordinal()];
            if (i == 1 || i == 2 || i == 3) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static EmotionGroupType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return (EmotionGroupType) Enum.valueOf(EmotionGroupType.class, str);
        }
        return (EmotionGroupType) invokeL.objValue;
    }

    public static EmotionGroupType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return (EmotionGroupType[]) $VALUES.clone();
        }
        return (EmotionGroupType[]) invokeV.objValue;
    }
}
