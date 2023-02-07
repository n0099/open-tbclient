package com.baidu.tbadk.template.message;

import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.sm5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class TemplateSocketResponsedMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public sm5 mIResp;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TemplateSocketResponsedMessage(int i) {
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
    }

    private TemplateNetMessage getTemplateNetMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (getOrginalMessage() != null && (getOrginalMessage().getExtra() instanceof TemplateNetMessage)) {
                return (TemplateNetMessage) getOrginalMessage().getExtra();
            }
            return null;
        }
        return (TemplateNetMessage) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        TemplateNetMessage templateNetMessage;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) != null) || (templateNetMessage = getTemplateNetMessage()) == null || templateNetMessage.getIResp() == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void beforeDispatchInBackGround(int i, byte[] bArr) {
        TemplateNetMessage templateNetMessage;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048579, this, i, bArr) != null) || (templateNetMessage = getTemplateNetMessage()) == null || templateNetMessage.getIResp() == null) {
        }
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048580, this, i, bArr)) == null) {
            Log.i("Template", "TemplateSocketResponsedMessage-->decodeInBackGround");
            TemplateNetMessage templateNetMessage = getTemplateNetMessage();
            if (templateNetMessage != null && templateNetMessage.getIResp() != null) {
                sm5 iResp = templateNetMessage.getIResp();
                this.mIResp = iResp;
                iResp.a(i, bArr);
                setError(this.mIResp.getErrorCode());
                setErrorString(this.mIResp.getErrorMsg());
                return this.mIResp;
            }
            return null;
        }
        return invokeIL.objValue;
    }

    public sm5 getIResp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mIResp;
        }
        return (sm5) invokeV.objValue;
    }
}
