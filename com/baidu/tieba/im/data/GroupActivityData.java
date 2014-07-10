package com.baidu.tieba.im.data;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GroupActivityData implements Serializable {
    private static final long serialVersionUID = -8275677249213550974L;
    private int activityId;
    private String activityPortrait;
    private String gActivityArea;
    private String gActivityContent;
    private long gActivityTime;
    private String gActivityTitle;
    private int groupId;
    private String groupName;
    private int isEnd;
    private long userId;
    private String userName;

    public String getActivityPortrait() {
        return this.activityPortrait;
    }

    public void setActivityPortrait(String str) {
        this.activityPortrait = str;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public int getIsEnd() {
        return this.isEnd;
    }

    public void setIsEnd(int i) {
        this.isEnd = i;
    }

    public int getGroupId() {
        return this.groupId;
    }

    public void setGroupId(int i) {
        this.groupId = i;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public int getActivityId() {
        return this.activityId;
    }

    public void setActivityId(int i) {
        this.activityId = i;
    }

    public String getgActivityTitle() {
        return this.gActivityTitle;
    }

    public void setgActivityTitle(String str) {
        this.gActivityTitle = str;
    }

    public long getgActivityTime() {
        return this.gActivityTime;
    }

    public void setgActivityTime(long j) {
        this.gActivityTime = j;
    }

    public String getgActivityContent() {
        return this.gActivityContent;
    }

    public void setgActivityContent(String str) {
        this.gActivityContent = str;
    }

    public String getgActivityArea() {
        return this.gActivityArea;
    }

    public void setgActivityArea(String str) {
        this.gActivityArea = str;
    }
}
