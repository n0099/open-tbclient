package com.baidu.tieba.enterForum.hotuserrank.model;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.k56;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetInfluenceRank.GetInfluenceRankResIdl;
/* loaded from: classes3.dex */
public class HotUserRankSocketResMsg extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public k56 pageData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotUserRankSocketResMsg() {
        super(309652);
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

    public k56 getPageData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.pageData : (k56) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetInfluenceRankResIdl getInfluenceRankResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) || (getInfluenceRankResIdl = (GetInfluenceRankResIdl) new Wire(new Class[0]).parseFrom(bArr, GetInfluenceRankResIdl.class)) == null) {
            return;
        }
        Error error = getInfluenceRankResIdl.error;
        if (error != null) {
            Integer num = error.errorno;
            if (num != null) {
                setError(num.intValue());
            }
            setErrorString(getInfluenceRankResIdl.error.usermsg);
        }
        k56 k56Var = new k56();
        this.pageData = k56Var;
        k56Var.c(getInfluenceRankResIdl.data);
    }
}
