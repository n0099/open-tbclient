package com.baidu.tieba.im.message;

import b.a.r0.l1.w.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import protobuf.CommitGroupMsg.CommitGroupMsgResIdl;
/* loaded from: classes9.dex */
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
    @Override // com.baidu.tieba.im.message.ResponseCommitMessage, com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) {
            CommitGroupMsgResIdl commitGroupMsgResIdl = (CommitGroupMsgResIdl) new Wire(new Class[0]).parseFrom(bArr, CommitGroupMsgResIdl.class);
            setError(commitGroupMsgResIdl.error.errorno.intValue());
            setErrorString(commitGroupMsgResIdl.error.usermsg);
            if (getError() != 0) {
                return;
            }
            setMsgId(b.a(commitGroupMsgResIdl.data.msgId.longValue()));
            setRecordId(commitGroupMsgResIdl.data.recordId.longValue());
            setGroupId(String.valueOf(commitGroupMsgResIdl.data.groupId));
        }
    }
}
