package com.baidu.tieba.im.db.pojo;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.b;
import c.a.d.f.p.m;
import c.a.t0.t1.w.c;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes12.dex */
public class ImMessageCenterPojo implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DELETEED = 1;
    public static final int HIDDEN = 1;
    public static final int SHOW = 0;
    public static final int UN_DELETE = 0;
    public static final long serialVersionUID = -8887966163420052407L;
    public transient /* synthetic */ FieldHolder $fh;
    public String bjhAvatar;
    public int followStatus;
    public String gid;
    public String group_ext;
    public String group_head;
    public String group_name;
    public int group_type;
    public int isFriend;
    public boolean isSelf;
    public int is_delete;
    public int is_hidden;
    public String lastServiceId;
    public String lastTaskId;
    public String last_content;
    public String last_content_raw_data;
    public long last_content_time;
    public long last_rid;
    public String last_user_name;
    public int mCustomGroupType;
    public String nameShow;
    public long orderCol;
    public long pulled_msgId;
    public String pushIds;
    public long read_msgId;
    public int send_status;
    public long sent_msgId;
    public String serviceId;
    public long sid;
    public String taskId;
    public int type;
    public int unread_count;
    public int userType;

    public ImMessageCenterPojo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCustomGroupType = 1;
    }

    public static ImMessageCenterPojo fromCommonMsg(CommonMsgPojo commonMsgPojo) {
        InterceptResult invokeL;
        int userType;
        OldUserData oldUserData;
        OldUserData oldUserData2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, commonMsgPojo)) == null) {
            if (commonMsgPojo == null) {
                return null;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (TextUtils.isEmpty(currentAccount)) {
                return null;
            }
            String gid = commonMsgPojo.getGid();
            if (TextUtils.isEmpty(gid)) {
                return null;
            }
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid(gid);
            UserData userData = (UserData) OrmObject.objectWithJsonStr(commonMsgPojo.getUser_info(), UserData.class);
            UserData userData2 = (UserData) OrmObject.objectWithJsonStr(commonMsgPojo.getToUser_info(), UserData.class);
            if (userData == null) {
                return null;
            }
            if (m.isEmpty(userData.getUserId()) && (oldUserData2 = (OldUserData) OrmObject.objectWithJsonStr(commonMsgPojo.getUser_info(), OldUserData.class)) != null) {
                oldUserData2.setToUserData(userData);
            }
            String toUid = commonMsgPojo.getToUid();
            if (!TextUtils.isEmpty(toUid) && toUid.equals(gid) && currentAccount.equals(gid)) {
                return null;
            }
            if (!currentAccount.equals(commonMsgPojo.getUid())) {
                imMessageCenterPojo.setGroup_name(userData.getUserName());
                imMessageCenterPojo.setGroup_head(userData.getPortrait());
                imMessageCenterPojo.setNameShow(userData.getName_show());
                imMessageCenterPojo.setBjhAvatar(userData.getImBjhAvatar());
            } else if (userData2 != null) {
                if (m.isEmpty(userData2.getUserId()) && (oldUserData = (OldUserData) OrmObject.objectWithJsonStr(commonMsgPojo.getToUser_info(), OldUserData.class)) != null) {
                    oldUserData.setToUserData(userData2);
                }
                imMessageCenterPojo.setGroup_name(userData2.getUserName());
                imMessageCenterPojo.setGroup_head(userData2.getPortrait());
                imMessageCenterPojo.setNameShow(userData2.getName_show());
                imMessageCenterPojo.setBjhAvatar(userData2.getImBjhAvatar());
            }
            boolean z = false;
            if (b.g(TbadkCoreApplication.getCurrentAccount(), 0L) != userData.getUserIdLong()) {
                userType = userData.getUserType();
            } else {
                userType = userData2 != null ? userData2.getUserType() : 0;
            }
            if (userType == 1 || userType == 3 || userType == 4) {
                imMessageCenterPojo.setCustomGroupType(4);
                z = true;
            }
            imMessageCenterPojo.setUserType(userType);
            if (!z) {
                imMessageCenterPojo.setCustomGroupType(2);
            }
            imMessageCenterPojo.setLast_content(c.u(commonMsgPojo.getMsg_type(), commonMsgPojo.getContent()));
            imMessageCenterPojo.setLast_user_name(userData.getName_show());
            imMessageCenterPojo.setLast_content_time(commonMsgPojo.getCreate_time() * 1000);
            imMessageCenterPojo.setSelf(commonMsgPojo.isSelf);
            imMessageCenterPojo.setIsFriend(commonMsgPojo.getIsFriend());
            imMessageCenterPojo.setFollowStatus(commonMsgPojo.getFollowStatus());
            imMessageCenterPojo.setLast_rid(commonMsgPojo.getRid());
            imMessageCenterPojo.setLast_rid(commonMsgPojo.getRid());
            imMessageCenterPojo.setSend_status(commonMsgPojo.getMsg_status());
            return imMessageCenterPojo;
        }
        return (ImMessageCenterPojo) invokeL.objValue;
    }

    public String getBjhAvatar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.bjhAvatar : (String) invokeV.objValue;
    }

    public int getCustomGroupType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mCustomGroupType : invokeV.intValue;
    }

    public int getFollowStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.followStatus : invokeV.intValue;
    }

    public String getGid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.gid : (String) invokeV.objValue;
    }

    @Deprecated
    public String getGroup_ext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.group_ext : (String) invokeV.objValue;
    }

    public String getGroup_head() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.group_head : (String) invokeV.objValue;
    }

    public String getGroup_name() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.group_name : (String) invokeV.objValue;
    }

    @Deprecated
    public int getGroup_type() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.group_type : invokeV.intValue;
    }

    public int getIsFriend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.isFriend : invokeV.intValue;
    }

    public int getIs_delete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.is_delete : invokeV.intValue;
    }

    public int getIs_hidden() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.is_hidden : invokeV.intValue;
    }

    public String getLastContentRawData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.last_content_raw_data : (String) invokeV.objValue;
    }

    public String getLastServiceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.lastServiceId : (String) invokeV.objValue;
    }

    public String getLastTaskId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.lastTaskId : (String) invokeV.objValue;
    }

    public String getLast_content() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.last_content : (String) invokeV.objValue;
    }

    public long getLast_content_time() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.last_content_time : invokeV.longValue;
    }

    public long getLast_rid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.last_rid : invokeV.longValue;
    }

    public String getLast_user_name() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.last_user_name : (String) invokeV.objValue;
    }

    public String getNameShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.nameShow : (String) invokeV.objValue;
    }

    public long getOrderCol() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.orderCol : invokeV.longValue;
    }

    public long getPulled_msgId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.pulled_msgId : invokeV.longValue;
    }

    public String getPushIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.pushIds : (String) invokeV.objValue;
    }

    public long getRead_msgId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.read_msgId : invokeV.longValue;
    }

    public int getSend_status() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.send_status : invokeV.intValue;
    }

    public long getSent_msgId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.sent_msgId : invokeV.longValue;
    }

    public String getServiceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.serviceId : (String) invokeV.objValue;
    }

    public long getSid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.sid : invokeV.longValue;
    }

    public String getTaskId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.taskId : (String) invokeV.objValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.type : invokeV.intValue;
    }

    public int getUnread_count() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.unread_count : invokeV.intValue;
    }

    public int getUserType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.userType : invokeV.intValue;
    }

    public boolean isSelf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.isSelf : invokeV.booleanValue;
    }

    public void setBjhAvatar(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
            this.bjhAvatar = str;
        }
    }

    public void setCustomGroupType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            this.mCustomGroupType = i2;
        }
    }

    public void setFollowStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            this.followStatus = i2;
        }
    }

    public void setGid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            this.gid = str;
        }
    }

    @Deprecated
    public void setGroup_ext(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            this.group_ext = str;
        }
    }

    public void setGroup_head(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            this.group_head = str;
        }
    }

    public void setGroup_name(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            this.group_name = str;
        }
    }

    @Deprecated
    public void setGroup_type(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
            this.group_type = i2;
        }
    }

    public void setIsFriend(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            this.isFriend = i2;
        }
    }

    public void setIs_delete(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
            this.is_delete = i2;
        }
    }

    public void setIs_hidden(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
            this.is_hidden = i2;
        }
    }

    public void setLastContentRawData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, str) == null) {
            this.last_content_raw_data = str;
        }
    }

    public void setLastServiceId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            this.lastServiceId = str;
        }
    }

    public void setLastTaskId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, str) == null) {
            this.lastTaskId = str;
        }
    }

    public void setLast_content(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            this.last_content = str;
        }
    }

    public void setLast_content_time(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048623, this, j2) == null) {
            this.last_content_time = j2;
        }
    }

    public void setLast_rid(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048624, this, j2) == null) {
            this.last_rid = j2;
        }
    }

    public void setLast_user_name(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, str) == null) {
            this.last_user_name = str;
        }
    }

    public void setNameShow(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, str) == null) {
            this.nameShow = str;
        }
    }

    public void setOrderCol(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048627, this, j2) == null) {
            this.orderCol = j2;
        }
    }

    public void setPulled_msgId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048628, this, j2) == null) {
            this.pulled_msgId = j2;
        }
    }

    public void setPushIds(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, str) == null) {
            this.pushIds = str;
        }
    }

    public void setRead_msgId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048630, this, j2) == null) {
            this.read_msgId = j2;
        }
    }

    public void setSelf(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z) == null) {
            this.isSelf = z;
        }
    }

    public void setSend_status(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048632, this, i2) == null) {
            this.send_status = i2;
        }
    }

    public void setSent_msgId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048633, this, j2) == null) {
            this.sent_msgId = j2;
        }
    }

    public void setServiceId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, str) == null) {
            this.serviceId = str;
        }
    }

    public void setSid(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048635, this, j2) == null) {
            this.sid = j2;
        }
    }

    public void setTaskId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, str) == null) {
            this.taskId = str;
        }
    }

    public void setType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048637, this, i2) == null) {
            this.type = i2;
        }
    }

    public void setUnread_count(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048638, this, i2) == null) {
            this.unread_count = i2;
        }
    }

    public void setUserType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048639, this, i2) == null) {
            this.userType = i2;
        }
    }
}
