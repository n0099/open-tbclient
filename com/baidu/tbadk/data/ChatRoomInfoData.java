package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import tbclient.Loop.ChatroomInfoBasic;
import tbclient.Loop.ChatroomList;
import tbclient.Loop.ChatroomMEMsgInfo;
/* loaded from: classes3.dex */
public class ChatRoomInfoData extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -317647475408404670L;
    public transient /* synthetic */ FieldHolder $fh;
    public ChatroomInfoBasicData chatroomInfoBasicData;
    public ChatroomMEMsgInfoData chatroomMEMsgInfoData;
    public String jumpUrl;
    public long roomId;

    /* loaded from: classes3.dex */
    public static class ChatroomInfoBasicData extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String avatar;
        public long forumId;
        public String forumName;
        public String name;
        public String unreadNum;

        public ChatroomInfoBasicData() {
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

        public String getAvatar() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.avatar;
            }
            return (String) invokeV.objValue;
        }

        public long getForumId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.forumId;
            }
            return invokeV.longValue;
        }

        public String getForumName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.forumName;
            }
            return (String) invokeV.objValue;
        }

        public String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.name;
            }
            return (String) invokeV.objValue;
        }

        public String getUnreadNum() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.unreadNum;
            }
            return (String) invokeV.objValue;
        }

        public void parseProto(ChatroomInfoBasic chatroomInfoBasic) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048581, this, chatroomInfoBasic) != null) || chatroomInfoBasic == null) {
                return;
            }
            this.forumId = chatroomInfoBasic.forum_id.longValue();
            this.forumName = chatroomInfoBasic.forum_name;
            this.avatar = chatroomInfoBasic.avatar;
            this.name = chatroomInfoBasic.name;
            this.unreadNum = chatroomInfoBasic.unread_num;
        }
    }

    /* loaded from: classes3.dex */
    public static class ChatroomMEMsgInfoData extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String content;
        public String fromName;
        public long fromUid;
        public long msgId;

        public ChatroomMEMsgInfoData() {
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

        public String getContent() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.content;
            }
            return (String) invokeV.objValue;
        }

        public String getFromName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.fromName;
            }
            return (String) invokeV.objValue;
        }

        public long getFromUid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.fromUid;
            }
            return invokeV.longValue;
        }

        public long getMsgId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.msgId;
            }
            return invokeV.longValue;
        }

        public void parseProto(ChatroomMEMsgInfo chatroomMEMsgInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048580, this, chatroomMEMsgInfo) != null) || chatroomMEMsgInfo == null) {
                return;
            }
            this.fromUid = chatroomMEMsgInfo.from_uid.longValue();
            this.fromName = chatroomMEMsgInfo.from_name;
            this.content = chatroomMEMsgInfo.content;
            this.msgId = chatroomMEMsgInfo.msg_id.longValue();
        }
    }

    public ChatRoomInfoData() {
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
        this.chatroomInfoBasicData = new ChatroomInfoBasicData();
        this.chatroomMEMsgInfoData = new ChatroomMEMsgInfoData();
    }

    public ChatroomInfoBasicData getChatroomInfoBasicData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.chatroomInfoBasicData;
        }
        return (ChatroomInfoBasicData) invokeV.objValue;
    }

    public ChatroomMEMsgInfoData getChatroomMEMsgInfoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.chatroomMEMsgInfoData;
        }
        return (ChatroomMEMsgInfoData) invokeV.objValue;
    }

    public String getJumpUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.jumpUrl;
        }
        return (String) invokeV.objValue;
    }

    public long getRoomId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.roomId;
        }
        return invokeV.longValue;
    }

    public void parseProto(ChatroomList chatroomList) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, chatroomList) != null) || chatroomList == null) {
            return;
        }
        this.roomId = chatroomList.room_id.longValue();
        this.jumpUrl = chatroomList.jump_url;
        this.chatroomInfoBasicData.parseProto(chatroomList.room_info);
        this.chatroomMEMsgInfoData.parseProto(chatroomList.msg_info);
    }
}
