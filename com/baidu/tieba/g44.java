package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class g44 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @V8JavascriptField
    public double clientX;
    @V8JavascriptField
    public double clientY;
    @V8JavascriptField
    public int identifier;

    public g44() {
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

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return Double.valueOf(this.identifier + this.clientX + this.clientY).hashCode();
        }
        return invokeV.intValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (!(obj instanceof g44)) {
                return false;
            }
            g44 g44Var = (g44) obj;
            if (this.identifier != g44Var.identifier || this.clientX != g44Var.clientX || this.clientY != g44Var.clientY) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "{identifier=" + this.identifier + ", clientX=" + this.clientX + ", clientY=" + this.clientY + '}';
        }
        return (String) invokeV.objValue;
    }
}
