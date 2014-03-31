package com.baidu.tieba.im.db.pojo;

import android.text.TextUtils;
import com.baidu.adp.lib.util.f;
import com.baidu.adp.lib.util.h;
import com.baidu.gson.Gson;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.f.q;
import java.io.Serializable;
/* loaded from: classes.dex */
public class ImMessageCenterPojo implements Serializable {
    public static final int DELETEED = 1;
    public static final int HIDDEN = 1;
    public static final int SHOW = 0;
    public static final int UN_DELETE = 0;
    private static final long serialVersionUID = -8887966163420052407L;
    String ext;
    String gid;
    String group_ext;
    String group_head;
    String group_name;
    int group_type;
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
    int type;
    int unread_count;

    public boolean isSelf() {
        return this.isSelf;
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

    public String getGroup_ext() {
        return this.group_ext;
    }

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

    public String getExt() {
        return this.ext;
    }

    public void setExt(String str) {
        this.ext = str;
    }

    public long getOrderCol() {
        return this.orderCol;
    }

    public void setOrderCol(long j) {
        this.orderCol = j;
    }

    public String toString() {
        return "ImMessageCenterPojo [gid=" + this.gid + ", group_name=" + this.group_name + ", group_head=" + this.group_head + ", group_type=" + this.group_type + ", group_ext=" + this.group_ext + ", is_hidden=" + this.is_hidden + ", unread_count=" + this.unread_count + ", last_rid=" + this.last_rid + ", pulled_msgId=" + this.pulled_msgId + ", last_content_time=" + this.last_content_time + ", last_user_name=" + this.last_user_name + ", last_content=" + this.last_content + ", type=" + this.type + ", ext=" + this.ext + ", orderCol=" + this.orderCol + ", is_delete=" + this.is_delete + "]";
    }

    public static ImMessageCenterPojo fromCommonMsg(CommonMsgPojo commonMsgPojo) {
        boolean z;
        OldUserData oldUserData;
        OldUserData oldUserData2;
        if (commonMsgPojo == null) {
            f.e("see init cmpojo is null");
            return null;
        }
        String E = TbadkApplication.E();
        if (TextUtils.isEmpty(E)) {
            f.e("see init not login:");
            return null;
        }
        f.e("see init private cmpojo:" + commonMsgPojo);
        String gid = commonMsgPojo.getGid();
        if (TextUtils.isEmpty(gid)) {
            f.b("see init private uid  is null uid:" + gid);
            return null;
        }
        ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
        imMessageCenterPojo.setGid(gid);
        UserData userData = (UserData) new Gson().fromJson(commonMsgPojo.getUser_info(), (Class<Object>) UserData.class);
        UserData userData2 = (UserData) new Gson().fromJson(commonMsgPojo.getToUser_info(), (Class<Object>) UserData.class);
        if (userData == null) {
            f.e("see init private userinfo:" + commonMsgPojo.getUser_info());
            return null;
        }
        if (h.b(userData.getUserId()) && (oldUserData2 = (OldUserData) new Gson().fromJson(commonMsgPojo.getUser_info(), (Class<Object>) OldUserData.class)) != null) {
            oldUserData2.setToUserData(userData);
        }
        String toUid = commonMsgPojo.getToUid();
        if (!TextUtils.isEmpty(toUid) && toUid.equals(gid) && E.equals(gid)) {
            f.b("see init private : send msg to self");
            return null;
        }
        String uid = commonMsgPojo.getUid();
        if (E.equals(uid)) {
            if (userData2 != null) {
                if (h.b(userData2.getUserId()) && (oldUserData = (OldUserData) new Gson().fromJson(commonMsgPojo.getToUser_info(), (Class<Object>) OldUserData.class)) != null) {
                    oldUserData.setToUserData(userData2);
                }
                imMessageCenterPojo.setGroup_name(userData2.getUserName());
                imMessageCenterPojo.setGroup_head(userData2.getPortrait());
            }
        } else {
            imMessageCenterPojo.setGroup_name(userData.getUserName());
            imMessageCenterPojo.setGroup_head(userData.getPortrait());
        }
        if (E.equals(uid)) {
            if (userData2 != null && userData2.getUserType() == 1) {
                imMessageCenterPojo.setCustomGroupType(4);
                z = true;
            }
            z = false;
        } else {
            if (userData != null && userData.getUserType() == 1) {
                imMessageCenterPojo.setCustomGroupType(4);
                z = true;
            }
            z = false;
        }
        if (!z) {
            imMessageCenterPojo.setCustomGroupType(2);
        }
        if (E.equals(uid)) {
            imMessageCenterPojo.setLast_content(q.g(commonMsgPojo.toChatMessage()));
        } else {
            imMessageCenterPojo.setLast_content(String.valueOf(userData.getUserName()) + ":" + q.g(commonMsgPojo.toChatMessage()));
        }
        imMessageCenterPojo.setLast_content_time(commonMsgPojo.getCreate_time() * 1000);
        imMessageCenterPojo.setSelf(commonMsgPojo.isSelf);
        f.e("see convert " + imMessageCenterPojo + "ori:" + commonMsgPojo);
        return imMessageCenterPojo;
    }

    public int getCustomGroupType() {
        return this.mCustomGroupType;
    }

    public void setCustomGroupType(int i) {
        this.mCustomGroupType = i;
    }
}
