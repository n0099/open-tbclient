package com.baidu.tieba.im.chat.officialBar;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.baidu.tieba.hi;
import com.baidu.tieba.me;
import com.baidu.tieba.t05;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import protobuf.QueryHistoryMsg.MsgInfo;
import protobuf.QueryHistoryMsg.QueryHistoryMsgResIdl;
/* loaded from: classes4.dex */
public class ResponseHistoryMessage extends TbSocketReponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<a> msg;
    public int msgCount;

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseHistoryMessage() {
        super(208002);
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
        this.msgCount = 0;
        this.msg = new LinkedList();
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            QueryHistoryMsgResIdl queryHistoryMsgResIdl = (QueryHistoryMsgResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryHistoryMsgResIdl.class);
            setError(queryHistoryMsgResIdl.error.errorno.intValue());
            setErrorString(queryHistoryMsgResIdl.error.usermsg);
            this.msgCount = queryHistoryMsgResIdl.data.total.intValue();
            List<MsgInfo> list = queryHistoryMsgResIdl.data.res;
            if (list != null) {
                for (MsgInfo msgInfo : list) {
                    a aVar = new a();
                    if (msgInfo != null) {
                        Date date = new Date();
                        date.setTime(msgInfo.sendTime.longValue() * 1000);
                        hi.getDateStringMouth(date);
                        msgInfo.type.intValue();
                        String str = msgInfo.content;
                        msgInfo.id.intValue();
                        this.msg.add(aVar);
                    }
                }
            }
            if (!this.msg.isEmpty()) {
                t05.d();
                me<byte[]> b = t05.b("tb.im_official_history");
                RequestHistoryMessage requestHistoryMessage = (RequestHistoryMessage) getOrginalMessage();
                if (requestHistoryMessage != null && requestHistoryMessage.getRequestId() == 0) {
                    b.g(TbadkCoreApplication.getCurrentAccount() + "@" + String.valueOf(requestHistoryMessage.getFid()), bArr);
                }
            }
            return queryHistoryMsgResIdl;
        }
        return invokeIL.objValue;
    }

    public List<a> getMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.msg;
        }
        return (List) invokeV.objValue;
    }

    public int getMsgCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.msgCount;
        }
        return invokeV.intValue;
    }
}
