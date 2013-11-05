package com.baidu.tieba.im.db.pojo;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ImMessageCenterPojo implements Serializable {
    public static final int DELETEED = 1;
    public static final int HIDDEN = 1;
    public static final int SHOW = 0;
    public static final int UN_DELETE = 0;
    String ext;
    String gid;
    String group_ext;
    String group_head;
    String group_name;
    int group_type;
    int is_delete;
    int is_hidden;
    String last_content;
    long last_content_time;
    long last_msgId;
    String last_user_name;
    long orderCol;
    long pulled_msgId;
    int type;
    int unread_count;

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

    public long getLast_msgId() {
        return this.last_msgId;
    }

    public void setLast_msgId(long j) {
        this.last_msgId = j;
    }

    public int getGroup_type() {
        return this.group_type;
    }

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
        return "ImMessageCenterPojo [gid=" + this.gid + ", group_name=" + this.group_name + ", group_head=" + this.group_head + ", group_type=" + this.group_type + ", group_ext=" + this.group_ext + ", is_hidden=" + this.is_hidden + ", unread_count=" + this.unread_count + ", last_msgId=" + this.last_msgId + ", last_content_time=" + this.last_content_time + ", last_user_name=" + this.last_user_name + ", last_content=" + this.last_content + ", type=" + this.type + ", ext=" + this.ext + ", orderCol=" + this.orderCol + ", is_delete=" + this.is_delete + "]";
    }
}
