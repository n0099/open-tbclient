package com.baidu.tieba.forumMember.tbtitle.model.res;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.forumMember.tbtitle.model.req.GetLevelInfoRequestMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cb6;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetLevelInfo.DataRes;
import tbclient.GetLevelInfo.GetLevelInfoResIdl;
/* loaded from: classes3.dex */
public class GetLevelInfoSocketResponsedMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DataRes mResult;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetLevelInfoSocketResponsedMessage() {
        super(301005);
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

    public DataRes getmResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mResult : (DataRes) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            GetLevelInfoRequestMessage getLevelInfoRequestMessage = (getOrginalMessage() == null || getOrginalMessage().getExtra() == null) ? null : (GetLevelInfoRequestMessage) getOrginalMessage().getExtra();
            if (getLevelInfoRequestMessage != null) {
                cb6 cb6Var = new cb6();
                cb6Var.c(getLevelInfoRequestMessage.getForumId() + "", bArr);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, bArr) == null) {
            GetLevelInfoResIdl getLevelInfoResIdl = (GetLevelInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetLevelInfoResIdl.class);
            Error error = getLevelInfoResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(getLevelInfoResIdl.error.usermsg);
            }
            if (getError() == 0 && (dataRes = getLevelInfoResIdl.data) != null) {
                this.mResult = dataRes;
            }
        }
    }
}
