package com.baidu.tieba.godMultiAttention;

import com.baidu.adp.framework.message.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.Error;
import tbclient.MFollow.DataRes;
import tbclient.MFollow.MFollowResIdl;
import tbclient.MFollow.MFollowResult;
/* loaded from: classes9.dex */
public class MultiAttentionSocketResponseMessage extends TbSocketReponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<MFollowResult> followResults;
    public boolean isAttentionAll;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiAttentionSocketResponseMessage() {
        super(309388);
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

    public List<MFollowResult> getFollowResults() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.followResults : (List) invokeV.objValue;
    }

    public boolean isAttentionAll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.isAttentionAll : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.websockt.TbSocketReponsedMessage, com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) {
            MFollowResIdl mFollowResIdl = (MFollowResIdl) new Wire(new Class[0]).parseFrom(bArr, MFollowResIdl.class);
            Error error = mFollowResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(mFollowResIdl.error.errmsg);
            }
            DataRes dataRes = mFollowResIdl.data;
            if (dataRes != null) {
                this.followResults = dataRes.follow_results;
            }
            Message<?> orginalMessage = getOrginalMessage();
            if (orginalMessage == null || !(orginalMessage.getExtra() instanceof MultiAttentionRequestMessage)) {
                return;
            }
            this.isAttentionAll = ((MultiAttentionRequestMessage) orginalMessage.getExtra()).isAttentionAll();
        }
    }
}
