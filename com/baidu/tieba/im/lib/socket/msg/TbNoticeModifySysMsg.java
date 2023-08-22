package com.baidu.tieba.im.lib.socket.msg;

import com.baidu.tieba.im.lib.socket.msg.TbSysMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
/* loaded from: classes6.dex */
public class TbNoticeModifySysMsg extends TbNoUISysMsg {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MSG_TYPE = 7001;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("chatroom_info")
    public TbSysMsg.ChatRoomInfo chatroomInfo;

    public TbNoticeModifySysMsg() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        setType(7001);
    }

    @Override // com.baidu.tieba.im.lib.socket.msg.TbNoUISysMsg
    public TbSysMsg.ChatRoomInfo getChatroomInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.chatroomInfo;
        }
        return (TbSysMsg.ChatRoomInfo) invokeV.objValue;
    }
}
