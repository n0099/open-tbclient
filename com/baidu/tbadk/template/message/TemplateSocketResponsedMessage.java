package com.baidu.tbadk.template.message;

import c.a.q0.a1.e.d;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class TemplateSocketResponsedMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d mIResp;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TemplateSocketResponsedMessage(int i2) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private TemplateNetMessage getTemplateNetMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (getOrginalMessage() == null || !(getOrginalMessage().getExtra() instanceof TemplateNetMessage)) {
                return null;
            }
            return (TemplateNetMessage) getOrginalMessage().getExtra();
        }
        return (TemplateNetMessage) invokeV.objValue;
    }

    public d getIResp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mIResp : (d) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i2, byte[] bArr) {
        TemplateNetMessage templateNetMessage;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) != null) || (templateNetMessage = getTemplateNetMessage()) == null || templateNetMessage.getIResp() == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void beforeDispatchInBackGround(int i2, byte[] bArr) {
        TemplateNetMessage templateNetMessage;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048579, this, i2, bArr) != null) || (templateNetMessage = getTemplateNetMessage()) == null || templateNetMessage.getIResp() == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        TemplateNetMessage templateNetMessage;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048581, this, i2, bArr) == null) || (templateNetMessage = getTemplateNetMessage()) == null || templateNetMessage.getIResp() == null) {
            return;
        }
        d iResp = templateNetMessage.getIResp();
        this.mIResp = iResp;
        iResp.a(i2, bArr);
        setError(this.mIResp.getErrorCode());
        setErrorString(this.mIResp.getErrorMsg());
    }
}
