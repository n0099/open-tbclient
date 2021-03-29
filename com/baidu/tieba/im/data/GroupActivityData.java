package com.baidu.tieba.im.data;

import java.io.Serializable;
/* loaded from: classes3.dex */
public class GroupActivityData implements Serializable {
    public static final long serialVersionUID = -8275677249213550974L;
    public int activityId;
    public String activityPortrait;
    public String gActivityArea;
    public String gActivityContent;
    public long gActivityTime;
    public String gActivityTitle;
    public long groupId;
    public String groupName;
    public int isEnd;
    public String nameShow;
    public long userId;
    public String userName;

    public int getActivityId() {
        return this.activityId;
    }

    public String getActivityPortrait() {
        return this.activityPortrait;
    }

    public long getGroupId() {
        return this.groupId;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public int getIsEnd() {
        return this.isEnd;
    }

    public String getNameShow() {
        return this.nameShow;
    }

    public long getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getgActivityArea() {
        return this.gActivityArea;
    }

    public String getgActivityContent() {
        return this.gActivityContent;
    }

    public long getgActivityTime() {
        return this.gActivityTime;
    }

    public String getgActivityTitle() {
        return this.gActivityTitle;
    }

    public void setActivityId(int i) {
        this.activityId = i;
    }

    public void setActivityPortrait(String str) {
        this.activityPortrait = str;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public void setIsEnd(int i) {
        this.isEnd = i;
    }

    public void setNameShow(String str) {
        this.nameShow = str;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public void setgActivityArea(String str) {
        this.gActivityArea = str;
    }

    public void setgActivityContent(String str) {
        this.gActivityContent = str;
    }

    public void setgActivityTime(long j) {
        this.gActivityTime = j;
    }

    public void setgActivityTitle(String str) {
        this.gActivityTitle = str;
    }
}
