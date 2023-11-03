package com.baidu.tieba.feed.data;

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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/baidu/tieba/feed/data/ThreadManageType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "ID_DEL", "ID_FORBID", "ID_TOP", "ID_GOOD", "ID_MULTI_DEL", "ID_RECOMMEND", "ID_MOVE_AREA", "ID_BROADCAST", "lib-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ThreadManageType {
    public static final /* synthetic */ ThreadManageType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ThreadManageType ID_BROADCAST;
    public static final ThreadManageType ID_DEL;
    public static final ThreadManageType ID_FORBID;
    public static final ThreadManageType ID_GOOD;
    public static final ThreadManageType ID_MOVE_AREA;
    public static final ThreadManageType ID_MULTI_DEL;
    public static final ThreadManageType ID_RECOMMEND;
    public static final ThreadManageType ID_TOP;
    public transient /* synthetic */ FieldHolder $fh;
    public final int value;

    public static final /* synthetic */ ThreadManageType[] $values() {
        return new ThreadManageType[]{ID_DEL, ID_FORBID, ID_TOP, ID_GOOD, ID_MULTI_DEL, ID_RECOMMEND, ID_MOVE_AREA, ID_BROADCAST};
    }

    public static ThreadManageType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (ThreadManageType) Enum.valueOf(ThreadManageType.class, str) : (ThreadManageType) invokeL.objValue;
    }

    public static ThreadManageType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (ThreadManageType[]) $VALUES.clone() : (ThreadManageType[]) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1952675632, "Lcom/baidu/tieba/feed/data/ThreadManageType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1952675632, "Lcom/baidu/tieba/feed/data/ThreadManageType;");
                return;
            }
        }
        ID_DEL = new ThreadManageType("ID_DEL", 0, 1);
        ID_FORBID = new ThreadManageType("ID_FORBID", 1, 2);
        ID_TOP = new ThreadManageType("ID_TOP", 2, 3);
        ID_GOOD = new ThreadManageType("ID_GOOD", 3, 4);
        ID_MULTI_DEL = new ThreadManageType("ID_MULTI_DEL", 4, 5);
        ID_RECOMMEND = new ThreadManageType("ID_RECOMMEND", 5, 6);
        ID_MOVE_AREA = new ThreadManageType("ID_MOVE_AREA", 6, 7);
        ID_BROADCAST = new ThreadManageType("ID_BROADCAST", 7, 8);
        $VALUES = $values();
    }

    public ThreadManageType(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.value = i2;
    }

    public final int getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.value;
        }
        return invokeV.intValue;
    }
}
