package com.baidu.tieba.danmu.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/baidu/tieba/danmu/data/ItemState;", "", "(Ljava/lang/String;I)V", "Uninitialized", "Measuring", "Measured", "Rendering", "Rendered", V8ExceptionInfo.V8_EXCEPTION_ERROR, "danmu_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes11.dex */
public final class ItemState {
    public static final /* synthetic */ ItemState[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ItemState Error;
    public static final ItemState Measured;
    public static final ItemState Measuring;
    public static final ItemState Rendered;
    public static final ItemState Rendering;
    public static final ItemState Uninitialized;
    public transient /* synthetic */ FieldHolder $fh;

    public static final /* synthetic */ ItemState[] $values() {
        return new ItemState[]{Uninitialized, Measuring, Measured, Rendering, Rendered, Error};
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1044332482, "Lcom/baidu/tieba/danmu/data/ItemState;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1044332482, "Lcom/baidu/tieba/danmu/data/ItemState;");
                return;
            }
        }
        Uninitialized = new ItemState("Uninitialized", 0);
        Measuring = new ItemState("Measuring", 1);
        Measured = new ItemState("Measured", 2);
        Rendering = new ItemState("Rendering", 3);
        Rendered = new ItemState("Rendered", 4);
        Error = new ItemState(V8ExceptionInfo.V8_EXCEPTION_ERROR, 5);
        $VALUES = $values();
    }

    public ItemState(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
            }
        }
    }

    public static ItemState valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (ItemState) Enum.valueOf(ItemState.class, str) : (ItemState) invokeL.objValue;
    }

    public static ItemState[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (ItemState[]) $VALUES.clone() : (ItemState[]) invokeV.objValue;
    }
}
