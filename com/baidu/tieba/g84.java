package com.baidu.tieba;

import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes6.dex */
public class g84 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @V8JavascriptField
    public h84[] changedTouches;
    @V8JavascriptField
    public long timeStamp;
    @V8JavascriptField
    public h84[] touches;

    public g84() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "SwanGameTouchData{touches=" + Arrays.toString(this.touches) + ", changedTouches=" + Arrays.toString(this.changedTouches) + ", timeStamp=" + this.timeStamp + '}';
        }
        return (String) invokeV.objValue;
    }
}
