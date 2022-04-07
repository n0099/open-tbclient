package com.baidu.tieba.home;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetUserBfbInfo.DataRes;
import tbclient.GetUserBfbInfo.GetUserBfbInfoResIdl;
import tbclient.UserBfbInfo;
/* loaded from: classes3.dex */
public class BfbInfoHttpResponseMessage extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public UserBfbInfo bfbInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BfbInfoHttpResponseMessage() {
        super(CmdConfigHttp.CMD_GET_BFB_INFO);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public UserBfbInfo getBfbInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.bfbInfo : (UserBfbInfo) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetUserBfbInfoResIdl getUserBfbInfoResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) || (getUserBfbInfoResIdl = (GetUserBfbInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetUserBfbInfoResIdl.class)) == null) {
            return;
        }
        Error error = getUserBfbInfoResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(getUserBfbInfoResIdl.error.usermsg);
        }
        DataRes dataRes = getUserBfbInfoResIdl.data;
        if (dataRes != null) {
            this.bfbInfo = dataRes.bfb;
        }
    }
}
