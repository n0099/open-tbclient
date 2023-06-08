package com.baidu.tieba.im.forum.broadcast.data;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.t88;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetForumBroadcastList.GetForumBroadcastListResIdl;
/* loaded from: classes6.dex */
public class ResponseSocketMajorHistoryMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public t88 majorHistoryData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseSocketMajorHistoryMessage() {
        super(309669);
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
        this.majorHistoryData = new t88();
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            if (bArr == null) {
                return null;
            }
            GetForumBroadcastListResIdl getForumBroadcastListResIdl = (GetForumBroadcastListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetForumBroadcastListResIdl.class);
            Error error = getForumBroadcastListResIdl.error;
            if (error == null) {
                return getForumBroadcastListResIdl;
            }
            setError(error.errorno.intValue());
            setErrorString(getForumBroadcastListResIdl.error.usermsg);
            if (getError() != 0) {
                return getForumBroadcastListResIdl;
            }
            this.majorHistoryData.d(getForumBroadcastListResIdl.data);
            this.majorHistoryData.f();
            return getForumBroadcastListResIdl;
        }
        return invokeIL.objValue;
    }

    public t88 getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.majorHistoryData;
        }
        return (t88) invokeV.objValue;
    }
}
