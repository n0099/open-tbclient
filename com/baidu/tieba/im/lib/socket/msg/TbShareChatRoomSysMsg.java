package com.baidu.tieba.im.lib.socket.msg;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.ShareChatroomMsgData;
import com.baidu.tieba.im.lib.socket.msg.data.ShareChatRoomData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
/* loaded from: classes6.dex */
public class TbShareChatRoomSysMsg extends TbSysMsg {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MSG_TYPE = 7020;
    public static final String SHARE_CHAT_ROOM_THUMBNAIL_TEXT;
    public static final long serialVersionUID = 6450622373896571168L;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("share_chatroom_info")
    public ShareChatRoomData shareChatRoom;

    @Override // com.baidu.tieba.im.lib.socket.msg.TbSysMsg
    public boolean isConvertToNormalMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2066870214, "Lcom/baidu/tieba/im/lib/socket/msg/TbShareChatRoomSysMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2066870214, "Lcom/baidu/tieba/im/lib/socket/msg/TbShareChatRoomSysMsg;");
                return;
            }
        }
        SHARE_CHAT_ROOM_THUMBNAIL_TEXT = TbadkApplication.getInst().getString(R.string.last_msg_chat_room_share);
    }

    public TbShareChatRoomSysMsg() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.im.lib.socket.msg.TbSysMsg, com.baidu.tieba.im.lib.socket.msg.TbBaseMsg
    @NonNull
    public CharSequence getThumbnailText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return SHARE_CHAT_ROOM_THUMBNAIL_TEXT;
        }
        return (CharSequence) invokeV.objValue;
    }

    public ShareChatroomMsgData formatMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new ShareChatroomMsgData(this.shareChatRoom.getId(), this.shareChatRoom.getName(), this.shareChatRoom.getIcon(), this.shareChatRoom.getForumId(), this.shareChatRoom.getForumName(), this.shareChatRoom.getChatCount());
        }
        return (ShareChatroomMsgData) invokeV.objValue;
    }
}
