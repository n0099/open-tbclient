package com.baidu.tieba.im.db.pojo;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import d.b.b.e.m.b;
import d.b.b.e.p.k;
import d.b.i0.d1.w.c;
import java.io.Serializable;
/* loaded from: classes4.dex */
public class ImMessageCenterPojo implements Serializable {
    public static final int DELETEED = 1;
    public static final int HIDDEN = 1;
    public static final int SHOW = 0;
    public static final int UN_DELETE = 0;
    public static final long serialVersionUID = -8887966163420052407L;
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
    public int mCustomGroupType = 1;
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

    public static ImMessageCenterPojo fromCommonMsg(CommonMsgPojo commonMsgPojo) {
        int userType;
        OldUserData oldUserData;
        OldUserData oldUserData2;
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
        if (k.isEmpty(userData.getUserId()) && (oldUserData2 = (OldUserData) OrmObject.objectWithJsonStr(commonMsgPojo.getUser_info(), OldUserData.class)) != null) {
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
            if (k.isEmpty(userData2.getUserId()) && (oldUserData = (OldUserData) OrmObject.objectWithJsonStr(commonMsgPojo.getToUser_info(), OldUserData.class)) != null) {
                oldUserData.setToUserData(userData2);
            }
            imMessageCenterPojo.setGroup_name(userData2.getUserName());
            imMessageCenterPojo.setGroup_head(userData2.getPortrait());
            imMessageCenterPojo.setNameShow(userData2.getName_show());
            imMessageCenterPojo.setBjhAvatar(userData2.getImBjhAvatar());
        }
        boolean z = false;
        if (b.f(TbadkCoreApplication.getCurrentAccount(), 0L) != userData.getUserIdLong()) {
            userType = userData.getUserType();
        } else {
            userType = userData2.getUserType();
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

    public String getBjhAvatar() {
        return this.bjhAvatar;
    }

    public int getCustomGroupType() {
        return this.mCustomGroupType;
    }

    public int getFollowStatus() {
        return this.followStatus;
    }

    public String getGid() {
        return this.gid;
    }

    @Deprecated
    public String getGroup_ext() {
        return this.group_ext;
    }

    public String getGroup_head() {
        return this.group_head;
    }

    public String getGroup_name() {
        return this.group_name;
    }

    @Deprecated
    public int getGroup_type() {
        return this.group_type;
    }

    public int getIsFriend() {
        return this.isFriend;
    }

    public int getIs_delete() {
        return this.is_delete;
    }

    public int getIs_hidden() {
        return this.is_hidden;
    }

    public String getLastContentRawData() {
        return this.last_content_raw_data;
    }

    public String getLastServiceId() {
        return this.lastServiceId;
    }

    public String getLastTaskId() {
        return this.lastTaskId;
    }

    public String getLast_content() {
        return this.last_content;
    }

    public long getLast_content_time() {
        return this.last_content_time;
    }

    public long getLast_rid() {
        return this.last_rid;
    }

    public String getLast_user_name() {
        return this.last_user_name;
    }

    public String getNameShow() {
        return this.nameShow;
    }

    public long getOrderCol() {
        return this.orderCol;
    }

    public long getPulled_msgId() {
        return this.pulled_msgId;
    }

    public String getPushIds() {
        return this.pushIds;
    }

    public long getRead_msgId() {
        return this.read_msgId;
    }

    public int getSend_status() {
        return this.send_status;
    }

    public long getSent_msgId() {
        return this.sent_msgId;
    }

    public String getServiceId() {
        return this.serviceId;
    }

    public long getSid() {
        return this.sid;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public int getType() {
        return this.type;
    }

    public int getUnread_count() {
        return this.unread_count;
    }

    public int getUserType() {
        return this.userType;
    }

    public boolean isSelf() {
        return this.isSelf;
    }

    public void setBjhAvatar(String str) {
        this.bjhAvatar = str;
    }

    public void setCustomGroupType(int i) {
        this.mCustomGroupType = i;
    }

    public void setFollowStatus(int i) {
        this.followStatus = i;
    }

    public void setGid(String str) {
        this.gid = str;
    }

    @Deprecated
    public void setGroup_ext(String str) {
        this.group_ext = str;
    }

    public void setGroup_head(String str) {
        this.group_head = str;
    }

    public void setGroup_name(String str) {
        this.group_name = str;
    }

    @Deprecated
    public void setGroup_type(int i) {
        this.group_type = i;
    }

    public void setIsFriend(int i) {
        this.isFriend = i;
    }

    public void setIs_delete(int i) {
        this.is_delete = i;
    }

    public void setIs_hidden(int i) {
        this.is_hidden = i;
    }

    public void setLastContentRawData(String str) {
        this.last_content_raw_data = str;
    }

    public void setLastServiceId(String str) {
        this.lastServiceId = str;
    }

    public void setLastTaskId(String str) {
        this.lastTaskId = str;
    }

    public void setLast_content(String str) {
        this.last_content = str;
    }

    public void setLast_content_time(long j) {
        this.last_content_time = j;
    }

    public void setLast_rid(long j) {
        this.last_rid = j;
    }

    public void setLast_user_name(String str) {
        this.last_user_name = str;
    }

    public void setNameShow(String str) {
        this.nameShow = str;
    }

    public void setOrderCol(long j) {
        this.orderCol = j;
    }

    public void setPulled_msgId(long j) {
        this.pulled_msgId = j;
    }

    public void setPushIds(String str) {
        this.pushIds = str;
    }

    public void setRead_msgId(long j) {
        this.read_msgId = j;
    }

    public void setSelf(boolean z) {
        this.isSelf = z;
    }

    public void setSend_status(int i) {
        this.send_status = i;
    }

    public void setSent_msgId(long j) {
        this.sent_msgId = j;
    }

    public void setServiceId(String str) {
        this.serviceId = str;
    }

    public void setSid(long j) {
        this.sid = j;
    }

    public void setTaskId(String str) {
        this.taskId = str;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setUnread_count(int i) {
        this.unread_count = i;
    }

    public void setUserType(int i) {
        this.userType = i;
    }
}
