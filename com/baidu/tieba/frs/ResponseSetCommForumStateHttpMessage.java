package com.baidu.tieba.frs;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.SetCommonForumState.SetCommonForumStateResIdl;
/* loaded from: classes9.dex */
public class ResponseSetCommForumStateHttpMessage extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SetCommonForumStateResIdl mResponseData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseSetCommForumStateHttpMessage() {
        super(CmdConfigHttp.CMD_SET_COMMON_FORUM_STATE);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) {
            super.decodeInBackGround(i2, bArr);
            SetCommonForumStateResIdl setCommonForumStateResIdl = (SetCommonForumStateResIdl) new Wire(new Class[0]).parseFrom(bArr, SetCommonForumStateResIdl.class);
            this.mResponseData = setCommonForumStateResIdl;
            Error error = setCommonForumStateResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(this.mResponseData.error.errmsg);
            }
        }
    }
}
