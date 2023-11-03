package com.baidu.tieba.forum.statistic;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/baidu/tieba/forum/statistic/ForumStatConstant$TabType;", "", "(Ljava/lang/String;I)V", "TAB_TYPE_UNKNOWN", "TAB_TYPE_HOT", "TAB_TYPE_NEW", "TAB_TYPE_GOOD", "TAB_TYPE_GENERAL", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ForumStatConstant$TabType {
    public static final /* synthetic */ ForumStatConstant$TabType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ForumStatConstant$TabType TAB_TYPE_GENERAL;
    public static final ForumStatConstant$TabType TAB_TYPE_GOOD;
    public static final ForumStatConstant$TabType TAB_TYPE_HOT;
    public static final ForumStatConstant$TabType TAB_TYPE_NEW;
    public static final ForumStatConstant$TabType TAB_TYPE_UNKNOWN;
    public transient /* synthetic */ FieldHolder $fh;

    public static final /* synthetic */ ForumStatConstant$TabType[] $values() {
        return new ForumStatConstant$TabType[]{TAB_TYPE_UNKNOWN, TAB_TYPE_HOT, TAB_TYPE_NEW, TAB_TYPE_GOOD, TAB_TYPE_GENERAL};
    }

    public static ForumStatConstant$TabType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (ForumStatConstant$TabType) Enum.valueOf(ForumStatConstant$TabType.class, str) : (ForumStatConstant$TabType) invokeL.objValue;
    }

    public static ForumStatConstant$TabType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (ForumStatConstant$TabType[]) $VALUES.clone() : (ForumStatConstant$TabType[]) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-178340622, "Lcom/baidu/tieba/forum/statistic/ForumStatConstant$TabType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-178340622, "Lcom/baidu/tieba/forum/statistic/ForumStatConstant$TabType;");
                return;
            }
        }
        TAB_TYPE_UNKNOWN = new ForumStatConstant$TabType("TAB_TYPE_UNKNOWN", 0);
        TAB_TYPE_HOT = new ForumStatConstant$TabType("TAB_TYPE_HOT", 1);
        TAB_TYPE_NEW = new ForumStatConstant$TabType("TAB_TYPE_NEW", 2);
        TAB_TYPE_GOOD = new ForumStatConstant$TabType("TAB_TYPE_GOOD", 3);
        TAB_TYPE_GENERAL = new ForumStatConstant$TabType("TAB_TYPE_GENERAL", 4);
        $VALUES = $values();
    }

    public ForumStatConstant$TabType(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
            }
        }
    }
}
