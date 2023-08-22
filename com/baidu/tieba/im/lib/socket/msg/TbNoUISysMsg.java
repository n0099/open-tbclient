package com.baidu.tieba.im.lib.socket.msg;

import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.fg8;
import com.baidu.tieba.im.lib.socket.msg.TbSysMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes6.dex */
public class TbNoUISysMsg extends TbSysMsg {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId ADAPTER_TYPE;
    public static final List<Integer> MSG_TYPE_LIST;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    @SerializedName("chatroom_info")
    public TbSysMsg.ChatRoomInfo chatroomInfo;
    @Nullable
    @SerializedName("mask_info")
    public fg8 maskInfo;
    @Nullable
    @SerializedName("user_to")
    public TbSysMsg.User userTo;

    @Override // com.baidu.tieba.im.lib.socket.msg.TbSysMsg
    public boolean isNoUISysMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1568436257, "Lcom/baidu/tieba/im/lib/socket/msg/TbNoUISysMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1568436257, "Lcom/baidu/tieba/im/lib/socket/msg/TbNoUISysMsg;");
                return;
            }
        }
        ADAPTER_TYPE = BdUniqueId.gen();
        MSG_TYPE_LIST = Arrays.asList(-7010, Integer.valueOf((int) TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_MUZZLE), Integer.valueOf((int) TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_UN_MUZZLE), Integer.valueOf((int) TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_MUZZLE_ALL), Integer.valueOf((int) TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_UN_MUZZLE_ALL), Integer.valueOf((int) TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_FROZEN), Integer.valueOf((int) TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_UN_FROZEN), Integer.valueOf((int) TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_THRESHOLD_POST), Integer.valueOf((int) TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_THRESHOLD_VIEW), Integer.valueOf((int) TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_ONLY_MANAGER_CAN_TALK), Integer.valueOf((int) TbEnum.MsgContentType.MSG_CONTENT_TYPE_START_EGG_RAIN));
    }

    public TbNoUISysMsg() {
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

    @Nullable
    public TbSysMsg.ChatRoomInfo getChatroomInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.chatroomInfo;
        }
        return (TbSysMsg.ChatRoomInfo) invokeV.objValue;
    }

    @Nullable
    public fg8 getMaskInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.maskInfo;
        }
        return (fg8) invokeV.objValue;
    }

    @Nullable
    public TbSysMsg.User getUserTo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.userTo;
        }
        return (TbSysMsg.User) invokeV.objValue;
    }
}
