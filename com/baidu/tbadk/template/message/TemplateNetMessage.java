package com.baidu.tbadk.template.message;

import android.util.Log;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.dw5;
import com.baidu.tieba.ew5;
import com.baidu.tieba.fw5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class TemplateNetMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isNeedCache;
    public dw5 mIReq;
    public ew5 mIResp;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TemplateNetMessage(fw5 fw5Var, dw5 dw5Var, ew5 ew5Var) {
        super(fw5Var.e(), fw5Var.a());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fw5Var, dw5Var, ew5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isNeedCache = false;
        this.mIReq = dw5Var;
        this.mIResp = ew5Var;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            Log.i("Template", "TemplateNetMessage-->isShortConnection=" + z);
            return this.mIReq.b(z);
        }
        return invokeZ.objValue;
    }

    public void setNeedCache(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.isNeedCache = z;
        }
    }

    public dw5 getIReq() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mIReq;
        }
        return (dw5) invokeV.objValue;
    }

    public ew5 getIResp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mIResp;
        }
        return (ew5) invokeV.objValue;
    }

    public boolean isNeedCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.isNeedCache;
        }
        return invokeV.booleanValue;
    }
}
