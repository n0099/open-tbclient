package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import com.baidu.tieba.p08;
import com.baidu.tieba.w9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import protobuf.CommitReceivedPmsg.CommitReceivedPmsgReqIdl;
import protobuf.CommitReceivedPmsg.DataReq;
/* loaded from: classes4.dex */
public class RequestPersonalMsgReadMessage extends TbSocketMessage implements w9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long hasSentMsgId;
    public long toUid;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequestPersonalMsgReadMessage(long j, long j2) {
        super(205006);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2)};
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
        this.hasSentMsgId = j;
        this.toUid = j2;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                DataReq.Builder builder = new DataReq.Builder();
                builder.groupId = p08.j;
                builder.msgType = 22;
                builder.msgId = Long.valueOf(this.hasSentMsgId);
                builder.toUid = Long.valueOf(this.toUid);
                builder.toUserType = 0;
                CommitReceivedPmsgReqIdl.Builder builder2 = new CommitReceivedPmsgReqIdl.Builder();
                builder2.data = builder.build(false);
                return builder2.build(false);
            } catch (Exception unused) {
                return null;
            }
        }
        return invokeV.objValue;
    }

    @Override // com.baidu.tieba.w9
    public boolean onFindMessage(SocketMessage socketMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketMessage)) == null) {
            if (socketMessage == null || !(socketMessage instanceof RequestPersonalMsgReadMessage)) {
                return false;
            }
            RequestPersonalMsgReadMessage requestPersonalMsgReadMessage = (RequestPersonalMsgReadMessage) socketMessage;
            if (requestPersonalMsgReadMessage.hasSentMsgId != this.hasSentMsgId || requestPersonalMsgReadMessage.toUid != this.toUid) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
