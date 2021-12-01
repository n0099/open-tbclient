package com.baidu.tieba.im.chat.officialBar;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import protobuf.QueryHistoryMsg.DataReq;
import protobuf.QueryHistoryMsg.QueryHistoryMsgReqIdl;
/* loaded from: classes10.dex */
public class RequestHistoryMessage extends TbSocketMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int forum_id;
    public int height;
    public int id;
    public int sHeight;
    public int sWidth;
    public long user_id;
    public int width;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequestHistoryMessage(int i2, long j2, int i3) {
        super(208002);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.forum_id = 0;
        this.user_id = 0L;
        this.id = 0;
        this.width = 0;
        this.height = 0;
        this.sWidth = 0;
        this.sHeight = 0;
        this.forum_id = i2;
        this.user_id = j2;
        this.id = i3;
        LocalViewSize.ImageSize msgBPicMaxSize = LocalViewSize.getInstance().getMsgBPicMaxSize();
        this.width = msgBPicMaxSize.width;
        this.height = msgBPicMaxSize.height;
        LocalViewSize.ImageSize msgSPicMaxSize = LocalViewSize.getInstance().getMsgSPicMaxSize();
        this.sWidth = msgSPicMaxSize.width;
        this.sHeight = msgSPicMaxSize.height;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            DataReq.Builder builder = new DataReq.Builder();
            builder.forumId = Integer.valueOf(this.forum_id);
            builder.userId = Long.valueOf(this.user_id);
            builder.id = Integer.valueOf(this.id);
            builder.width = Integer.valueOf(this.width);
            builder.height = Integer.valueOf(this.height);
            builder.smallWidth = Integer.valueOf(this.sWidth);
            builder.smallHeight = Integer.valueOf(this.sHeight);
            QueryHistoryMsgReqIdl.Builder builder2 = new QueryHistoryMsgReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeV.objValue;
    }

    public int getFid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.forum_id : invokeV.intValue;
    }

    public int getRequestId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.id : invokeV.intValue;
    }
}
