package com.baidu.tbadk.data;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tbclient.Loop.AtMsgBase;
import tbclient.Loop.ChatRoomAtInfo;
import tbclient.Loop.ChatroomInfoBasic;
import tbclient.Loop.ChatroomList;
import tbclient.Loop.ChatroomMEMsgInfo;
/* loaded from: classes5.dex */
public class ChatRoomInfoData extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BTN_TYPE_DEFAULT = 0;
    public static final int BTN_TYPE_ENTER_CHAT_ROOM = 3;
    public static final int BTN_TYPE_EXPERIENCE_INCREASE = 1;
    public static final int BTN_TYPE_UNREAD_NUM = 2;
    public static final long serialVersionUID = -317647475408404670L;
    public transient /* synthetic */ FieldHolder $fh;
    public AtInfoData atInfoData;
    public ChatroomInfoBasicData chatroomInfoBasicData;
    public ChatroomMEMsgInfoData chatroomMEMsgInfoData;
    public String jumpUrl;
    public long roomId;

    /* loaded from: classes5.dex */
    public static class AtInfoData extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<AtMsgBaseData> allMsgList;
        public List<AtMsgBaseData> allSingleList;
        public int atAllMsgCount;
        public int atCountAll;
        public int atSingleMsgCount;

        public AtInfoData() {
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

        public List<AtMsgBaseData> getAllMsgList() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.allMsgList;
            }
            return (List) invokeV.objValue;
        }

        public List<AtMsgBaseData> getAllSingleList() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.allSingleList;
            }
            return (List) invokeV.objValue;
        }

        public int getAtAllMsgCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.atAllMsgCount;
            }
            return invokeV.intValue;
        }

        public int getAtCountAll() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.atCountAll;
            }
            return invokeV.intValue;
        }

        public int getAtSingleMsgCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.atSingleMsgCount;
            }
            return invokeV.intValue;
        }

        private List<AtMsgBaseData> toAtMsgBaseData(List<AtMsgBase> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, list)) == null) {
                if (!ListUtils.isEmpty(list)) {
                    ArrayList arrayList = new ArrayList();
                    for (AtMsgBase atMsgBase : list) {
                        AtMsgBaseData atMsgBaseData = new AtMsgBaseData();
                        atMsgBaseData.parseProto(atMsgBase);
                        arrayList.add(atMsgBaseData);
                    }
                    return arrayList;
                }
                return null;
            }
            return (List) invokeL.objValue;
        }

        public void parseProto(ChatRoomAtInfo chatRoomAtInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048581, this, chatRoomAtInfo) == null) && chatRoomAtInfo != null) {
                this.atCountAll = chatRoomAtInfo.at_count_all.intValue();
                this.atAllMsgCount = chatRoomAtInfo.at_all_msg_count.intValue();
                this.atSingleMsgCount = chatRoomAtInfo.at_single_msg_count.intValue();
                this.allMsgList = toAtMsgBaseData(chatRoomAtInfo.at_all_msg_list);
                this.allSingleList = toAtMsgBaseData(chatRoomAtInfo.at_single_msg_list);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class AtMsgBaseData extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long msgId;
        public String msgKey;

        public AtMsgBaseData() {
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

        public long getMsgId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.msgId;
            }
            return invokeV.longValue;
        }

        public String getMsgKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.msgKey;
            }
            return (String) invokeV.objValue;
        }

        public void parseProto(AtMsgBase atMsgBase) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, atMsgBase) == null) && atMsgBase != null) {
                this.msgId = atMsgBase.msg_id.longValue();
                this.msgKey = atMsgBase.msg_key;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class ChatroomInfoBasicData extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String avatar;
        public int btnType;
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

        public int getBtnType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.btnType;
            }
            return invokeV.intValue;
        }

        public long getForumId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.forumId;
            }
            return invokeV.longValue;
        }

        public String getForumName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.forumName;
            }
            return (String) invokeV.objValue;
        }

        public String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.name;
            }
            return (String) invokeV.objValue;
        }

        public String getUnreadNum() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.unreadNum;
            }
            return (String) invokeV.objValue;
        }

        public void parseProto(ChatroomInfoBasic chatroomInfoBasic) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048582, this, chatroomInfoBasic) != null) || chatroomInfoBasic == null) {
                return;
            }
            this.forumId = chatroomInfoBasic.forum_id.longValue();
            this.forumName = chatroomInfoBasic.forum_name;
            this.avatar = chatroomInfoBasic.avatar;
            this.name = chatroomInfoBasic.name;
            this.unreadNum = chatroomInfoBasic.unread_num;
            this.btnType = chatroomInfoBasic.btn_type.intValue();
        }

        public void setUnreadNum(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
                this.unreadNum = str;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class ChatroomMEMsgInfoData extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String content;
        public String fromName;
        public long fromUid;
        public long msgId;
        public String specialMsg;
        public String specialMsgType;

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

        public String getSpecialMsg() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.specialMsg;
            }
            return (String) invokeV.objValue;
        }

        public String getSpecialMsgType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.specialMsgType;
            }
            return (String) invokeV.objValue;
        }

        public void parseProto(ChatroomMEMsgInfo chatroomMEMsgInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048582, this, chatroomMEMsgInfo) != null) || chatroomMEMsgInfo == null) {
                return;
            }
            this.fromUid = chatroomMEMsgInfo.from_uid.longValue();
            this.fromName = chatroomMEMsgInfo.from_name;
            this.content = chatroomMEMsgInfo.content;
            this.msgId = chatroomMEMsgInfo.msg_id.longValue();
            this.specialMsg = chatroomMEMsgInfo.special_msg;
            this.specialMsgType = chatroomMEMsgInfo.special_msg_type;
        }

        public void setContent(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
                this.content = str;
            }
        }

        public void setFromName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
                this.fromName = str;
            }
        }

        public void setFromUid(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
                this.fromUid = j;
            }
        }

        public void setMsgId(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048586, this, j) == null) {
                this.msgId = j;
            }
        }

        public void setSpecialMsg(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
                this.specialMsg = str;
            }
        }

        public void setSpecialMsgType(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
                this.specialMsgType = str;
            }
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

    @Nullable
    public AtInfoData getAtInfoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.atInfoData;
        }
        return (AtInfoData) invokeV.objValue;
    }

    public ChatroomInfoBasicData getChatroomInfoBasicData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.chatroomInfoBasicData;
        }
        return (ChatroomInfoBasicData) invokeV.objValue;
    }

    public ChatroomMEMsgInfoData getChatroomMEMsgInfoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.chatroomMEMsgInfoData;
        }
        return (ChatroomMEMsgInfoData) invokeV.objValue;
    }

    public String getJumpUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.jumpUrl;
        }
        return (String) invokeV.objValue;
    }

    public long getRoomId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.roomId;
        }
        return invokeV.longValue;
    }

    public void parseProto(ChatroomList chatroomList) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, chatroomList) != null) || chatroomList == null) {
            return;
        }
        this.roomId = chatroomList.room_id.longValue();
        this.jumpUrl = chatroomList.jump_url;
        this.chatroomInfoBasicData.parseProto(chatroomList.room_info);
        this.chatroomMEMsgInfoData.parseProto(chatroomList.msg_info);
        if (chatroomList.at_info != null) {
            AtInfoData atInfoData = new AtInfoData();
            this.atInfoData = atInfoData;
            atInfoData.parseProto(chatroomList.at_info);
        }
    }
}
