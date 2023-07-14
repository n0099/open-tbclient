package com.baidu.tieba.im.message;

import androidx.annotation.Nullable;
import com.baidu.tieba.bh8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import protobuf.CommitGroupMsg.CommitGroupMsgResIdl;
/* loaded from: classes6.dex */
public class ResponseCommitGroupMessage extends ResponseCommitMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseCommitGroupMessage() {
        super(202001);
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

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            CommitGroupMsgResIdl commitGroupMsgResIdl = (CommitGroupMsgResIdl) new Wire(new Class[0]).parseFrom(bArr, CommitGroupMsgResIdl.class);
            setError(commitGroupMsgResIdl.error.errorno.intValue());
            setErrorString(commitGroupMsgResIdl.error.usermsg);
            if (getError() != 0) {
                return commitGroupMsgResIdl;
            }
            setMsgId(bh8.a(commitGroupMsgResIdl.data.msgId.longValue()));
            setRecordId(commitGroupMsgResIdl.data.recordId.longValue());
            setGroupId(String.valueOf(commitGroupMsgResIdl.data.groupId));
            return commitGroupMsgResIdl;
        }
        return invokeIL.objValue;
    }
}
