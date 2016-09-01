package com.baidu.tieba.im.db.pojo;

import android.text.TextUtils;
import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.h.b;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.util.h;
import java.io.Serializable;
/* loaded from: classes.dex */
public class ImMessageCenterPojo implements Serializable {
    public static final int DELETEED = 1;
    public static final int HIDDEN = 1;
    public static final int SHOW = 0;
    public static final int UN_DELETE = 0;
    private static final long serialVersionUID = -8887966163420052407L;
    String gid;
    String group_ext;
    String group_head;
    String group_name;
    int group_type;
    int isFriend;
    private boolean isSelf;
    int is_delete;
    int is_hidden;
    String last_content;
    long last_content_time;
    long last_rid;
    String last_user_name;
    private int mCustomGroupType = 1;
    long orderCol;
    long pulled_msgId;
    private String pushIds;
    private long read_msgId;
    int send_status;
    private long sent_msgId;
    private long sid;
    private String taskId;
    int type;
    int unread_count;
    private int userType;

    public String getPushIds() {
        return this.pushIds;
    }

    public void setPushIds(String str) {
        this.pushIds = str;
    }

    public long getSid() {
        return this.sid;
    }

    public void setSid(long j) {
        this.sid = j;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public void setTaskId(String str) {
        this.taskId = str;
    }

    public boolean isSelf() {
        return this.isSelf;
    }

    public int getSend_status() {
        return this.send_status;
    }

    public void setSend_status(int i) {
        this.send_status = i;
    }

    public void setSelf(boolean z) {
        this.isSelf = z;
    }

    public long getLast_rid() {
        return this.last_rid;
    }

    public void setLast_rid(long j) {
        this.last_rid = j;
    }

    public long getPulled_msgId() {
        return this.pulled_msgId;
    }

    public void setPulled_msgId(long j) {
        this.pulled_msgId = j;
    }

    public int getIs_delete() {
        return this.is_delete;
    }

    public void setIs_delete(int i) {
        this.is_delete = i;
    }

    public int getIs_hidden() {
        return this.is_hidden;
    }

    public void setIs_hidden(int i) {
        this.is_hidden = i;
    }

    @Deprecated
    public int getGroup_type() {
        return this.group_type;
    }

    @Deprecated
    public void setGroup_type(int i) {
        this.group_type = i;
    }

    public String getGid() {
        return this.gid;
    }

    public void setGid(String str) {
        this.gid = str;
    }

    public String getGroup_name() {
        return this.group_name;
    }

    public void setGroup_name(String str) {
        this.group_name = str;
    }

    public String getGroup_head() {
        return this.group_head;
    }

    public void setGroup_head(String str) {
        this.group_head = str;
    }

    @Deprecated
    public String getGroup_ext() {
        return this.group_ext;
    }

    @Deprecated
    public void setGroup_ext(String str) {
        this.group_ext = str;
    }

    public int getUnread_count() {
        return this.unread_count;
    }

    public void setUnread_count(int i) {
        this.unread_count = i;
    }

    public long getLast_content_time() {
        return this.last_content_time;
    }

    public void setLast_content_time(long j) {
        this.last_content_time = j;
    }

    public String getLast_user_name() {
        return this.last_user_name;
    }

    public void setLast_user_name(String str) {
        this.last_user_name = str;
    }

    public String getLast_content() {
        return this.last_content;
    }

    public void setLast_content(String str) {
        this.last_content = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public long getOrderCol() {
        return this.orderCol;
    }

    public void setOrderCol(long j) {
        this.orderCol = j;
    }

    public int getUserType() {
        return this.userType;
    }

    public void setUserType(int i) {
        this.userType = i;
    }

    public static ImMessageCenterPojo fromCommonMsg(CommonMsgPojo commonMsgPojo) {
        int userType;
        boolean z;
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
        UserData userData = (UserData) i.objectWithJsonStr(commonMsgPojo.getUser_info(), UserData.class);
        UserData userData2 = (UserData) i.objectWithJsonStr(commonMsgPojo.getToUser_info(), UserData.class);
        if (userData == null) {
            return null;
        }
        if (j.isEmpty(userData.getUserId()) && (oldUserData2 = (OldUserData) i.objectWithJsonStr(commonMsgPojo.getUser_info(), OldUserData.class)) != null) {
            oldUserData2.setToUserData(userData);
        }
        String toUid = commonMsgPojo.getToUid();
        if (!TextUtils.isEmpty(toUid) && toUid.equals(gid) && currentAccount.equals(gid)) {
            return null;
        }
        if (currentAccount.equals(commonMsgPojo.getUid())) {
            if (userData2 != null) {
                if (j.isEmpty(userData2.getUserId()) && (oldUserData = (OldUserData) i.objectWithJsonStr(commonMsgPojo.getToUser_info(), OldUserData.class)) != null) {
                    oldUserData.setToUserData(userData2);
                }
                imMessageCenterPojo.setGroup_name(userData2.getUserName());
                imMessageCenterPojo.setGroup_head(userData2.getPortrait());
            }
        } else {
            imMessageCenterPojo.setGroup_name(userData.getUserName());
            imMessageCenterPojo.setGroup_head(userData.getPortrait());
        }
        if (b.c(TbadkCoreApplication.getCurrentAccount(), 0L) != userData.getUserIdLong()) {
            userType = userData.getUserType();
        } else {
            userType = userData2.getUserType();
        }
        if (userType != 1 && userType != 3 && userType != 4) {
            z = false;
        } else {
            imMessageCenterPojo.setCustomGroupType(4);
            z = true;
        }
        imMessageCenterPojo.setUserType(userType);
        if (!z) {
            imMessageCenterPojo.setCustomGroupType(2);
        }
        imMessageCenterPojo.setLast_content(h.A(commonMsgPojo.getMsg_type(), commonMsgPojo.getContent()));
        imMessageCenterPojo.setLast_user_name(userData.getUserName());
        imMessageCenterPojo.setLast_content_time(commonMsgPojo.getCreate_time() * 1000);
        imMessageCenterPojo.setSelf(commonMsgPojo.isSelf);
        imMessageCenterPojo.setIsFriend(commonMsgPojo.getIsFriend());
        imMessageCenterPojo.setLast_rid(commonMsgPojo.getRid());
        imMessageCenterPojo.setLast_rid(commonMsgPojo.getRid());
        imMessageCenterPojo.setSend_status(commonMsgPojo.getMsg_status());
        return imMessageCenterPojo;
    }

    public int getCustomGroupType() {
        return this.mCustomGroupType;
    }

    public void setCustomGroupType(int i) {
        this.mCustomGroupType = i;
    }

    public int getIsFriend() {
        return this.isFriend;
    }

    public void setIsFriend(int i) {
        this.isFriend = i;
    }

    public long getSent_msgId() {
        return this.sent_msgId;
    }

    public void setSent_msgId(long j) {
        this.sent_msgId = j;
    }

    public long getRead_msgId() {
        return this.read_msgId;
    }

    public void setRead_msgId(long j) {
        this.read_msgId = j;
    }
}
