package com.baidu.tieba.im.chat.officialBar;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import protobuf.QueryForumDetail.DataRes;
import protobuf.QueryForumDetail.QueryForumDetailResIdl;
/* loaded from: classes5.dex */
public class ResponseOfficialBarInfoMessage extends TbSocketReponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String authen;
    public String portrait;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseOfficialBarInfoMessage() {
        super(208001);
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
        this.portrait = null;
        this.authen = null;
    }

    public String getAuthen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.authen : (String) invokeV.objValue;
    }

    public String getPortrait() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.portrait : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.websockt.TbSocketReponsedMessage, com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) {
            QueryForumDetailResIdl queryForumDetailResIdl = (QueryForumDetailResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryForumDetailResIdl.class);
            setError(queryForumDetailResIdl.error.errorno.intValue());
            setErrorString(queryForumDetailResIdl.error.usermsg);
            DataRes dataRes = queryForumDetailResIdl.data;
            this.portrait = dataRes.portrait;
            this.authen = dataRes.authen;
        }
    }
}
