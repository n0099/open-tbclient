package com.baidu.tieba.im.forum.broadcast.data;

import c.a.p0.j1.i.a.b.a;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetForumBroadcastList.GetForumBroadcastListResIdl;
/* loaded from: classes7.dex */
public class ResponseSocketMajorHistoryMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a majorHistoryData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseSocketMajorHistoryMessage() {
        super(309669);
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
        this.majorHistoryData = new a();
    }

    public a getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.majorHistoryData : (a) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        GetForumBroadcastListResIdl getForumBroadcastListResIdl;
        Error error;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) || bArr == null || (error = (getForumBroadcastListResIdl = (GetForumBroadcastListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetForumBroadcastListResIdl.class)).error) == null) {
            return;
        }
        setError(error.errorno.intValue());
        setErrorString(getForumBroadcastListResIdl.error.usermsg);
        if (getError() != 0) {
            return;
        }
        this.majorHistoryData.d(getForumBroadcastListResIdl.data);
        this.majorHistoryData.f();
    }
}
