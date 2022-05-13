package com.baidu.tieba.im.message.chat;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import protobuf.CommitPersonalMsg.CommitPersonalMsgReqIdl;
import protobuf.CommitPersonalMsg.DataReq;
/* loaded from: classes3.dex */
public class PersonalChatMessage extends ChatMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonalChatMessage() {
        super(205001);
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

    private String getRequestContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (getMsgType() != 33 && getMsgType() != 32) {
                return getContent();
            }
            return getEncodeContent();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                DataReq.Builder builder = new DataReq.Builder();
                builder.content = getRequestContent();
                builder.toUid = Long.valueOf(getToUserId());
                builder.msgType = Integer.valueOf(getMsgType());
                builder.recordId = Long.valueOf(getRecordId());
                builder.toUserType = 0;
                builder.st_type = getSt_type();
                CommitPersonalMsgReqIdl.Builder builder2 = new CommitPersonalMsgReqIdl.Builder();
                builder2.data = builder.build(false);
                return builder2.build(false);
            } catch (Exception unused) {
                return null;
            }
        }
        return invokeV.objValue;
    }
}
