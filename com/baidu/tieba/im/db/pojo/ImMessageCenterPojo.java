package com.baidu.tieba.im.db.pojo;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.IMUserExtraData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.bi;
import com.baidu.tieba.h25;
import com.baidu.tieba.ve8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.Objects;
/* loaded from: classes6.dex */
public class ImMessageCenterPojo implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DELETEED = 1;
    public static final int HIDDEN = 1;
    public static final int SHOW = 0;
    public static final int SHOW_OUT_OF_STRANGER_FALSE = 0;
    public static final int SHOW_OUT_OF_STRANGER_TRUE = 1;
    public static final int UN_DELETE = 0;
    public static final long serialVersionUID = -8887966163420052407L;
    public transient /* synthetic */ FieldHolder $fh;
    public h25 atInfoData;
    public String bjhAvatar;
    public int followStatus;
    public String forumId;
    public String forumName;
    public String gid;
    public String groupJumpUrl;
    public String group_ext;
    public String group_head;
    public String group_name;
    public int group_type;
    public IMUserExtraData imUserExtraData;
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
    public long roomId;
    public int send_status;
    public long sent_msgId;
    public String serviceId;
    public int showOutOfStranger;
    public long sid;
    public String specialMsgText;
    public String taskId;
    public int type;
    public int unread_count;
    public int userType;

    public ImMessageCenterPojo() {
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
        this.mCustomGroupType = 2;
    }

    public h25 getAtInfoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.atInfoData;
        }
        return (h25) invokeV.objValue;
    }

    public String getBjhAvatar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.bjhAvatar;
        }
        return (String) invokeV.objValue;
    }

    public int getCustomGroupType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mCustomGroupType;
        }
        return invokeV.intValue;
    }

    public int getFollowStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.followStatus;
        }
        return invokeV.intValue;
    }

    public String getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.forumId;
        }
        return (String) invokeV.objValue;
    }

    public String getForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.forumName;
        }
        return (String) invokeV.objValue;
    }

    public String getGid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.gid;
        }
        return (String) invokeV.objValue;
    }

    public String getGroupJumpUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.groupJumpUrl;
        }
        return (String) invokeV.objValue;
    }

    @Deprecated
    public String getGroup_ext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.group_ext;
        }
        return (String) invokeV.objValue;
    }

    public String getGroup_head() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.group_head;
        }
        return (String) invokeV.objValue;
    }

    public String getGroup_name() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.group_name;
        }
        return (String) invokeV.objValue;
    }

    @Deprecated
    public int getGroup_type() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.group_type;
        }
        return invokeV.intValue;
    }

    public IMUserExtraData getImUserExtraData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.imUserExtraData;
        }
        return (IMUserExtraData) invokeV.objValue;
    }

    public int getIsFriend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.isFriend;
        }
        return invokeV.intValue;
    }

    public int getIs_delete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.is_delete;
        }
        return invokeV.intValue;
    }

    public int getIs_hidden() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.is_hidden;
        }
        return invokeV.intValue;
    }

    public String getLastContentRawData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.last_content_raw_data;
        }
        return (String) invokeV.objValue;
    }

    public String getLastServiceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.lastServiceId;
        }
        return (String) invokeV.objValue;
    }

    public String getLastTaskId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.lastTaskId;
        }
        return (String) invokeV.objValue;
    }

    public String getLast_content() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.last_content;
        }
        return (String) invokeV.objValue;
    }

    public long getLast_content_time() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.last_content_time;
        }
        return invokeV.longValue;
    }

    public long getLast_rid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.last_rid;
        }
        return invokeV.longValue;
    }

    public String getLast_user_name() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.last_user_name;
        }
        return (String) invokeV.objValue;
    }

    public String getNameShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.nameShow;
        }
        return (String) invokeV.objValue;
    }

    public long getOrderCol() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.orderCol;
        }
        return invokeV.longValue;
    }

    public long getPulled_msgId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.pulled_msgId;
        }
        return invokeV.longValue;
    }

    public String getPushIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.pushIds;
        }
        return (String) invokeV.objValue;
    }

    public long getRead_msgId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.read_msgId;
        }
        return invokeV.longValue;
    }

    public long getRoomId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.roomId;
        }
        return invokeV.longValue;
    }

    public int getSend_status() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.send_status;
        }
        return invokeV.intValue;
    }

    public long getSent_msgId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.sent_msgId;
        }
        return invokeV.longValue;
    }

    public String getServiceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.serviceId;
        }
        return (String) invokeV.objValue;
    }

    public int getShowOutOfStranger() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.showOutOfStranger;
        }
        return invokeV.intValue;
    }

    public long getSid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.sid;
        }
        return invokeV.longValue;
    }

    public String getSpecialMsgText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.specialMsgText;
        }
        return (String) invokeV.objValue;
    }

    public String getTaskId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.taskId;
        }
        return (String) invokeV.objValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.type;
        }
        return invokeV.intValue;
    }

    public int getUnread_count() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.unread_count;
        }
        return invokeV.intValue;
    }

    public int getUserType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.userType;
        }
        return invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return Objects.hash(this.gid);
        }
        return invokeV.intValue;
    }

    public boolean isSelf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.isSelf;
        }
        return invokeV.booleanValue;
    }

    public static ImMessageCenterPojo fromCommonMsg(CommonMsgPojo commonMsgPojo) {
        InterceptResult invokeL;
        int i;
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
            if (bi.isEmpty(userData.getUserId()) && (oldUserData2 = (OldUserData) OrmObject.objectWithJsonStr(commonMsgPojo.getUser_info(), OldUserData.class)) != null) {
                oldUserData2.setToUserData(userData);
            }
            String toUid = commonMsgPojo.getToUid();
            if (!TextUtils.isEmpty(toUid) && toUid.equals(gid) && currentAccount.equals(gid)) {
                return null;
            }
            if (currentAccount.equals(commonMsgPojo.getUid())) {
                if (userData2 != null) {
                    if (bi.isEmpty(userData2.getUserId()) && (oldUserData = (OldUserData) OrmObject.objectWithJsonStr(commonMsgPojo.getToUser_info(), OldUserData.class)) != null) {
                        oldUserData.setToUserData(userData2);
                    }
                    imMessageCenterPojo.setGroup_name(userData2.getUserName());
                    imMessageCenterPojo.setGroup_head(userData2.getPortrait());
                    imMessageCenterPojo.setNameShow(userData2.getName_show());
                    imMessageCenterPojo.setBjhAvatar(userData2.getImBjhAvatar());
                }
            } else {
                imMessageCenterPojo.setGroup_name(userData.getUserName());
                imMessageCenterPojo.setGroup_head(userData.getPortrait());
                imMessageCenterPojo.setNameShow(userData.getName_show());
                imMessageCenterPojo.setBjhAvatar(userData.getImBjhAvatar());
            }
            boolean z = false;
            if (JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L) != userData.getUserIdLong()) {
                i = userData.getUserType();
            } else if (userData2 != null) {
                i = userData2.getUserType();
            } else {
                i = 0;
            }
            if (i == 1 || i == 3 || i == 4) {
                imMessageCenterPojo.setCustomGroupType(4);
                z = true;
            }
            imMessageCenterPojo.setUserType(i);
            if (!z) {
                imMessageCenterPojo.setCustomGroupType(2);
            }
            imMessageCenterPojo.setLast_content(ve8.D(commonMsgPojo.getMsg_type(), commonMsgPojo.getContent()));
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

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj != null && ImMessageCenterPojo.class == obj.getClass()) {
                return this.gid.equals(((ImMessageCenterPojo) obj).gid);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setAtInfoData(h25 h25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, h25Var) == null) {
            this.atInfoData = h25Var;
        }
    }

    public void setBjhAvatar(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, str) == null) {
            this.bjhAvatar = str;
        }
    }

    public void setCustomGroupType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i) == null) {
            this.mCustomGroupType = i;
        }
    }

    public void setFollowStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
            this.followStatus = i;
        }
    }

    public void setForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            this.forumId = str;
        }
    }

    public void setForumName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, str) == null) {
            this.forumName = str;
        }
    }

    public void setGid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, str) == null) {
            this.gid = str;
        }
    }

    public void setGroupJumpUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, str) == null) {
            this.groupJumpUrl = str;
        }
    }

    @Deprecated
    public void setGroup_ext(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, str) == null) {
            this.group_ext = str;
        }
    }

    public void setGroup_head(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, str) == null) {
            this.group_head = str;
        }
    }

    public void setGroup_name(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, str) == null) {
            this.group_name = str;
        }
    }

    @Deprecated
    public void setGroup_type(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048629, this, i) == null) {
            this.group_type = i;
        }
    }

    public void setImUserExtraData(IMUserExtraData iMUserExtraData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, iMUserExtraData) == null) {
            this.imUserExtraData = iMUserExtraData;
        }
    }

    public void setIsFriend(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048631, this, i) == null) {
            this.isFriend = i;
        }
    }

    public void setIs_delete(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048632, this, i) == null) {
            this.is_delete = i;
        }
    }

    public void setIs_hidden(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048633, this, i) == null) {
            this.is_hidden = i;
        }
    }

    public void setLastContentRawData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, str) == null) {
            this.last_content_raw_data = str;
        }
    }

    public void setLastServiceId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, str) == null) {
            this.lastServiceId = str;
        }
    }

    public void setLastTaskId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, str) == null) {
            this.lastTaskId = str;
        }
    }

    public void setLast_content(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, str) == null) {
            this.last_content = str;
        }
    }

    public void setLast_content_time(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048638, this, j) == null) {
            this.last_content_time = j;
        }
    }

    public void setLast_rid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048639, this, j) == null) {
            this.last_rid = j;
        }
    }

    public void setLast_user_name(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, str) == null) {
            this.last_user_name = str;
        }
    }

    public void setNameShow(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, str) == null) {
            this.nameShow = str;
        }
    }

    public void setOrderCol(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048642, this, j) == null) {
            this.orderCol = j;
        }
    }

    public void setPulled_msgId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048643, this, j) == null) {
            this.pulled_msgId = j;
        }
    }

    public void setPushIds(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, str) == null) {
            this.pushIds = str;
        }
    }

    public void setRead_msgId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048645, this, j) == null) {
            this.read_msgId = j;
        }
    }

    public void setRoomId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048646, this, j) == null) {
            this.roomId = j;
        }
    }

    public void setSelf(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048647, this, z) == null) {
            this.isSelf = z;
        }
    }

    public void setSend_status(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048648, this, i) == null) {
            this.send_status = i;
        }
    }

    public void setSent_msgId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048649, this, j) == null) {
            this.sent_msgId = j;
        }
    }

    public void setServiceId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, str) == null) {
            this.serviceId = str;
        }
    }

    public void setShowOutOfStranger(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048651, this, i) == null) {
            this.showOutOfStranger = i;
        }
    }

    public void setSid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048652, this, j) == null) {
            this.sid = j;
        }
    }

    public void setSpecialMsgText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, str) == null) {
            this.specialMsgText = str;
        }
    }

    public void setTaskId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, str) == null) {
            this.taskId = str;
        }
    }

    public void setType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048655, this, i) == null) {
            this.type = i;
        }
    }

    public void setUnread_count(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048656, this, i) == null) {
            this.unread_count = i;
        }
    }

    public void setUserType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048657, this, i) == null) {
            this.userType = i;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            return "ImMessageCenterPojo{mCustomGroupType=" + this.mCustomGroupType + ", gid='" + this.gid + "', group_name='" + this.group_name + "', group_head='" + this.group_head + "', group_type=" + this.group_type + ", group_ext='" + this.group_ext + "', is_hidden=" + this.is_hidden + ", unread_count=" + this.unread_count + ", last_rid=" + this.last_rid + ", pulled_msgId=" + this.pulled_msgId + ", last_content_time=" + this.last_content_time + ", last_user_name='" + this.last_user_name + "', last_content='" + this.last_content + "', last_content_raw_data='" + this.last_content_raw_data + "', send_status=" + this.send_status + ", type=" + this.type + ", orderCol=" + this.orderCol + ", is_delete=" + this.is_delete + ", isSelf=" + this.isSelf + ", isFriend=" + this.isFriend + ", followStatus=" + this.followStatus + ", sent_msgId=" + this.sent_msgId + ", read_msgId=" + this.read_msgId + ", userType=" + this.userType + ", sid=" + this.sid + ", taskId='" + this.taskId + "', serviceId='" + this.serviceId + "', lastServiceId='" + this.lastServiceId + "', lastTaskId='" + this.lastTaskId + "', pushIds='" + this.pushIds + "', nameShow='" + this.nameShow + "', bjhAvatar='" + this.bjhAvatar + "', showOutOfStranger='" + this.showOutOfStranger + "'}";
        }
        return (String) invokeV.objValue;
    }
}
