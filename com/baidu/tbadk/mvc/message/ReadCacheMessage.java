package com.baidu.tbadk.mvc.message;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.qr5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ReadCacheMessage<T> extends CustomMessage<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isNeedUid;
    public qr5 requestData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadCacheMessage(int i) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isNeedUid = true;
    }

    public qr5 getRequestData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.requestData;
        }
        return (qr5) invokeV.objValue;
    }

    public boolean isNeedUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.isNeedUid;
        }
        return invokeV.booleanValue;
    }

    public void setNeedUid(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.isNeedUid = z;
        }
    }

    public void setRequestData(qr5 qr5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, qr5Var) == null) {
            this.requestData = qr5Var;
        }
    }
}
