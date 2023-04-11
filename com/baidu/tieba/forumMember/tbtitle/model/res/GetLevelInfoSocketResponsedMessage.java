package com.baidu.tieba.forumMember.tbtitle.model.res;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.forumMember.tbtitle.model.req.GetLevelInfoRequestMessage;
import com.baidu.tieba.l37;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetLevelInfo.DataRes;
import tbclient.GetLevelInfo.GetLevelInfoResIdl;
/* loaded from: classes4.dex */
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mResult;
        }
        return (DataRes) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        GetLevelInfoRequestMessage getLevelInfoRequestMessage;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            if (getOrginalMessage() != null && getOrginalMessage().getExtra() != null) {
                getLevelInfoRequestMessage = (GetLevelInfoRequestMessage) getOrginalMessage().getExtra();
            } else {
                getLevelInfoRequestMessage = null;
            }
            if (getLevelInfoRequestMessage != null) {
                l37 l37Var = new l37();
                l37Var.c(getLevelInfoRequestMessage.getForumId() + "", bArr);
            }
        }
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, bArr)) == null) {
            GetLevelInfoResIdl getLevelInfoResIdl = (GetLevelInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetLevelInfoResIdl.class);
            Error error = getLevelInfoResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(getLevelInfoResIdl.error.usermsg);
            }
            if (getError() != 0) {
                return getLevelInfoResIdl;
            }
            DataRes dataRes = getLevelInfoResIdl.data;
            if (dataRes != null) {
                this.mResult = dataRes;
            }
            return getLevelInfoResIdl;
        }
        return invokeIL.objValue;
    }
}
