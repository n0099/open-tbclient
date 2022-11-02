package com.baidu.tieba.im.db.pojo;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.tieba.im.message.chat.GroupChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.ke7;
import com.baidu.tieba.le7;
import com.baidu.tieba.wg;
import com.baidu.tieba.wi;
import com.baidu.tieba.xc7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class CommonMsgPojo extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DELETEED = 1;
    public static final int READED = 0;
    public static final int UNREAD = 1;
    public static final int UN_DELETE = 0;
    public static final long serialVersionUID = -7522120557807426716L;
    public transient /* synthetic */ FieldHolder $fh;
    public String content;
    public long create_time;
    public int customGroupType;
    public String ext;
    public int followStatus;
    public String gid;
    public long illegalMsgId;
    public int isFriend;
    public boolean isPrivate;
    public boolean isSelf;
    public int is_delete;
    public long mid;
    public int msg_status;
    public int msg_type;
    public String pushIds;
    public int read_flag;
    public long rid;
    public String serviceId;
    public long sid;
    public String taskId;
    public String toUid;
    public String to_user_info;
    public UserData to_user_info_data;
    public String uid;
    public String user_info;
    public UserData user_info_data;

    public CommonMsgPojo() {
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
        this.gid = "";
        this.uid = "";
        this.toUid = "";
        this.user_info = "";
        this.to_user_info = "";
        this.user_info_data = null;
        this.to_user_info_data = null;
        this.content = "";
        this.ext = "";
        this.isPrivate = false;
    }

    public void checkRidAndSelf() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                if (TbadkCoreApplication.getCurrentAccount().equals(this.uid)) {
                    this.isSelf = true;
                }
            } else {
                this.isSelf = false;
            }
            if (!this.isSelf) {
                this.rid = this.mid;
            } else if (this.rid == 0) {
                this.rid = this.mid;
            }
        }
    }

    public long getIllegalMsgId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            long j = 0;
            if (this.illegalMsgId == 0) {
                JSONObject jSONObject = null;
                try {
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (getContent() == null) {
                    return this.illegalMsgId;
                }
                jSONObject = new JSONObject(getContent());
                if (jSONObject != null) {
                    j = jSONObject.optLong("msg_id");
                }
                this.illegalMsgId = ke7.a(j);
            }
            return this.illegalMsgId;
        }
        return invokeV.longValue;
    }

    public UserData getPrivateOtherUser_infoObj() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.user_info_data != null && this.to_user_info_data != null) {
                if (wg.g(TbadkCoreApplication.getCurrentAccount(), 0L) == this.user_info_data.getUserIdLong()) {
                    return this.to_user_info_data;
                }
                return this.user_info_data;
            }
            return null;
        }
        return (UserData) invokeV.objValue;
    }

    public CommonMsgPojo(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {chatMessage};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.gid = "";
        this.uid = "";
        this.toUid = "";
        this.user_info = "";
        this.to_user_info = "";
        this.user_info_data = null;
        this.to_user_info_data = null;
        this.content = "";
        this.ext = "";
        this.isPrivate = false;
        if (chatMessage != null) {
            if (chatMessage instanceof CommonGroupChatMessage) {
                this.gid = ((CommonGroupChatMessage) chatMessage).getGroupId();
            } else if (chatMessage instanceof PersonalChatMessage) {
                this.gid = String.valueOf(xc7.j);
            } else if (chatMessage instanceof OfficialChatMessage) {
                this.gid = String.valueOf(xc7.k);
            }
            this.mid = chatMessage.getMsgId();
            this.uid = String.valueOf(chatMessage.getUserId());
            this.toUid = String.valueOf(chatMessage.getToUserId());
            this.user_info_data = chatMessage.getUserInfo();
            this.to_user_info_data = chatMessage.getToUserInfo();
            try {
                this.to_user_info = OrmObject.jsonStrWithObject(chatMessage.getToUserInfo());
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.create_time = chatMessage.getTime();
            this.msg_type = chatMessage.getMsgType();
            if (chatMessage.getLocalData() != null) {
                this.msg_status = chatMessage.getLocalData().getStatus().shortValue();
                if (!TextUtils.isEmpty(chatMessage.getLocalData().getErrorString()) && TextUtils.isEmpty(this.ext)) {
                    this.ext = chatMessage.getLocalData().getErrorString();
                }
            }
            this.content = chatMessage.getContent();
            this.sid = chatMessage.getSid();
            this.taskId = String.valueOf(chatMessage.getTaskId());
            this.serviceId = String.valueOf(chatMessage.getServiceId());
            this.is_delete = 0;
            this.rid = chatMessage.getRecordId();
            checkRidAndSelf();
            this.isFriend = chatMessage.getIsFriend();
            this.followStatus = chatMessage.getFollowStatus();
        }
    }

    public String getContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.content;
        }
        return (String) invokeV.objValue;
    }

    public long getCreate_time() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.create_time;
        }
        return invokeV.longValue;
    }

    public int getCustomGroupType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.customGroupType;
        }
        return invokeV.intValue;
    }

    public String getExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.ext;
        }
        return (String) invokeV.objValue;
    }

    public int getFollowStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.followStatus;
        }
        return invokeV.intValue;
    }

    public String getGid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.gid;
        }
        return (String) invokeV.objValue;
    }

    public int getIsFriend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.isFriend;
        }
        return invokeV.intValue;
    }

    public int getIs_delete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.is_delete;
        }
        return invokeV.intValue;
    }

    public long getMid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mid;
        }
        return invokeV.longValue;
    }

    public int getMsg_status() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.msg_status;
        }
        return invokeV.intValue;
    }

    public int getMsg_type() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.msg_type;
        }
        return invokeV.intValue;
    }

    public String getPushIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.pushIds;
        }
        return (String) invokeV.objValue;
    }

    public int getRead_flag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.read_flag;
        }
        return invokeV.intValue;
    }

    public long getRid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.rid;
        }
        return invokeV.longValue;
    }

    public String getServiceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.serviceId;
        }
        return (String) invokeV.objValue;
    }

    public long getSid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.sid;
        }
        return invokeV.longValue;
    }

    public String getTaskId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.taskId;
        }
        return (String) invokeV.objValue;
    }

    public String getToUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.toUid;
        }
        return (String) invokeV.objValue;
    }

    public String getToUser_info() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            String str = this.to_user_info;
            if (str == null || (str.length() < 1 && this.to_user_info_data != null)) {
                this.to_user_info = OrmObject.jsonStrWithObject(this.to_user_info_data);
            }
            return this.to_user_info;
        }
        return (String) invokeV.objValue;
    }

    public UserData getToUser_infoObj() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.to_user_info_data;
        }
        return (UserData) invokeV.objValue;
    }

    public String getUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.uid;
        }
        return (String) invokeV.objValue;
    }

    public String getUser_info() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            String str = this.user_info;
            if (str == null || (str.length() < 1 && this.user_info_data != null)) {
                this.user_info = OrmObject.jsonStrWithObject(this.user_info_data);
            }
            return this.user_info;
        }
        return (String) invokeV.objValue;
    }

    public UserData getUser_infoObj() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.user_info_data;
        }
        return (UserData) invokeV.objValue;
    }

    public boolean isPrivate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.isPrivate;
        }
        return invokeV.booleanValue;
    }

    public boolean isSelf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            if (!TextUtils.isEmpty(this.uid) && this.uid.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.isSelf = true;
            } else {
                this.isSelf = false;
            }
            return this.isSelf;
        }
        return invokeV.booleanValue;
    }

    public void setContent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            this.content = str;
        }
    }

    public void setCreate_time(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048605, this, j) == null) {
            this.create_time = j;
        }
    }

    public void setCustomGroupType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            this.customGroupType = i;
        }
    }

    public void setExt(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.ext = str;
        }
    }

    public void setFollowStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            this.followStatus = i;
        }
    }

    public void setGid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            this.gid = str;
        }
    }

    public void setIsFriend(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i) == null) {
            this.isFriend = i;
        }
    }

    public void setIs_delete(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i) == null) {
            this.is_delete = i;
        }
    }

    public void setMid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048612, this, j) == null) {
            this.mid = j;
        }
    }

    public void setMsg_status(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i) == null) {
            this.msg_status = i;
        }
    }

    public void setMsg_type(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i) == null) {
            this.msg_type = i;
        }
    }

    public void setPrivate(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.isPrivate = z;
        }
    }

    public void setPushIds(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            this.pushIds = str;
        }
    }

    public void setRead_flag(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i) == null) {
            this.read_flag = i;
        }
    }

    public void setRid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048618, this, j) == null) {
            this.rid = j;
        }
    }

    public void setSelf(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.isSelf = z;
        }
    }

    public void setServiceId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            this.serviceId = str;
        }
    }

    public void setSid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048621, this, j) == null) {
            this.sid = j;
        }
    }

    public void setTaskId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            this.taskId = str;
        }
    }

    public void setToUid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, str) == null) {
            this.toUid = str;
        }
    }

    public void setToUser_info(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, str) == null) {
            this.to_user_info = str;
            this.to_user_info_data = null;
        }
    }

    public void setUid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, str) == null) {
            this.uid = str;
        }
    }

    public void setUser_info(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, str) == null) {
            this.user_info = str;
            this.user_info_data = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ChatMessage toChatMessage() {
        InterceptResult invokeV;
        long j;
        long j2;
        long j3;
        ChatMessage personalChatMessage;
        UserData userInfo;
        UserData toUserInfo;
        OldUserData oldUserData;
        long j4;
        OldUserData oldUserData2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            long j5 = 0;
            try {
                if (this.uid != null && this.uid.length() > 0) {
                    j2 = Long.parseLong(this.uid);
                } else {
                    j2 = 0;
                }
                try {
                } catch (Exception e) {
                    long j6 = j2;
                    e = e;
                    j = j6;
                    e.printStackTrace();
                    j2 = j;
                    j3 = 0;
                    if (TextUtils.isEmpty(this.toUid)) {
                    }
                    personalChatMessage.setMsgId(this.mid);
                    personalChatMessage.setUserId(j2);
                    personalChatMessage.setToUserId(j3);
                    personalChatMessage.setRecordId(this.rid);
                    this.user_info_data = (UserData) OrmObject.objectWithJsonStr(this.user_info, UserData.class);
                    this.to_user_info_data = (UserData) OrmObject.objectWithJsonStr(this.to_user_info, UserData.class);
                    personalChatMessage.setUserInfo(this.user_info_data);
                    personalChatMessage.setToUserInfo(this.to_user_info_data);
                    personalChatMessage.setTime(this.create_time);
                    personalChatMessage.setMsgType((short) this.msg_type);
                    MsgLocalData msgLocalData = new MsgLocalData();
                    msgLocalData.setStatus(Short.valueOf((short) this.msg_status));
                    msgLocalData.setErrorString(this.ext);
                    personalChatMessage.setErrorString(this.ext);
                    personalChatMessage.setLocalData(msgLocalData);
                    personalChatMessage.setContent(this.content);
                    userInfo = personalChatMessage.getUserInfo();
                    if (userInfo != null) {
                    }
                    toUserInfo = personalChatMessage.getToUserInfo();
                    if (toUserInfo != null) {
                    }
                    le7.q(personalChatMessage);
                    personalChatMessage.setIsFriend(this.isFriend);
                    personalChatMessage.setFollowStatus(this.followStatus);
                    return personalChatMessage;
                }
            } catch (Exception e2) {
                e = e2;
                j = 0;
            }
            if (this.toUid != null && this.toUid.length() > 0) {
                j3 = Long.parseLong(this.toUid);
                if (TextUtils.isEmpty(this.toUid)) {
                    personalChatMessage = new GroupChatMessage();
                    personalChatMessage.setGroupId(this.gid);
                } else {
                    personalChatMessage = new PersonalChatMessage();
                }
                personalChatMessage.setMsgId(this.mid);
                personalChatMessage.setUserId(j2);
                personalChatMessage.setToUserId(j3);
                personalChatMessage.setRecordId(this.rid);
                this.user_info_data = (UserData) OrmObject.objectWithJsonStr(this.user_info, UserData.class);
                this.to_user_info_data = (UserData) OrmObject.objectWithJsonStr(this.to_user_info, UserData.class);
                personalChatMessage.setUserInfo(this.user_info_data);
                personalChatMessage.setToUserInfo(this.to_user_info_data);
                personalChatMessage.setTime(this.create_time);
                personalChatMessage.setMsgType((short) this.msg_type);
                MsgLocalData msgLocalData2 = new MsgLocalData();
                msgLocalData2.setStatus(Short.valueOf((short) this.msg_status));
                msgLocalData2.setErrorString(this.ext);
                personalChatMessage.setErrorString(this.ext);
                personalChatMessage.setLocalData(msgLocalData2);
                personalChatMessage.setContent(this.content);
                userInfo = personalChatMessage.getUserInfo();
                if (userInfo != null) {
                    if (wi.isEmpty(userInfo.getUserId()) && (oldUserData2 = (OldUserData) OrmObject.objectWithJsonStr(this.user_info, OldUserData.class)) != null) {
                        oldUserData2.setToUserData(userInfo);
                    }
                    try {
                        j4 = Long.parseLong(userInfo.getUserId());
                    } catch (Exception unused) {
                        j4 = 0;
                    }
                    personalChatMessage.setUserId(j4);
                }
                toUserInfo = personalChatMessage.getToUserInfo();
                if (toUserInfo != null) {
                    if (wi.isEmpty(toUserInfo.getUserId()) && (oldUserData = (OldUserData) OrmObject.objectWithJsonStr(this.to_user_info, OldUserData.class)) != null) {
                        oldUserData.setToUserData(toUserInfo);
                    }
                    try {
                        j5 = Long.parseLong(toUserInfo.getUserId());
                    } catch (Exception unused2) {
                    }
                    personalChatMessage.setToUserId(j5);
                }
                le7.q(personalChatMessage);
                personalChatMessage.setIsFriend(this.isFriend);
                personalChatMessage.setFollowStatus(this.followStatus);
                return personalChatMessage;
            }
            j3 = 0;
            if (TextUtils.isEmpty(this.toUid)) {
            }
            personalChatMessage.setMsgId(this.mid);
            personalChatMessage.setUserId(j2);
            personalChatMessage.setToUserId(j3);
            personalChatMessage.setRecordId(this.rid);
            this.user_info_data = (UserData) OrmObject.objectWithJsonStr(this.user_info, UserData.class);
            this.to_user_info_data = (UserData) OrmObject.objectWithJsonStr(this.to_user_info, UserData.class);
            personalChatMessage.setUserInfo(this.user_info_data);
            personalChatMessage.setToUserInfo(this.to_user_info_data);
            personalChatMessage.setTime(this.create_time);
            personalChatMessage.setMsgType((short) this.msg_type);
            MsgLocalData msgLocalData22 = new MsgLocalData();
            msgLocalData22.setStatus(Short.valueOf((short) this.msg_status));
            msgLocalData22.setErrorString(this.ext);
            personalChatMessage.setErrorString(this.ext);
            personalChatMessage.setLocalData(msgLocalData22);
            personalChatMessage.setContent(this.content);
            userInfo = personalChatMessage.getUserInfo();
            if (userInfo != null) {
            }
            toUserInfo = personalChatMessage.getToUserInfo();
            if (toUserInfo != null) {
            }
            le7.q(personalChatMessage);
            personalChatMessage.setIsFriend(this.isFriend);
            personalChatMessage.setFollowStatus(this.followStatus);
            return personalChatMessage;
        }
        return (ChatMessage) invokeV.objValue;
    }
}
