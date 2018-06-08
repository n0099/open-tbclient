package com.baidu.tbadk.coreExtra.message;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GroupUpdateMessage implements Serializable {
    private static final long serialVersionUID = 1071062952403340773L;
    private String authorId;
    private String authorName;
    private String forumId;
    private int grade;
    private long groupId;
    private int groupType;
    private long lastMsgId;
    private String name;
    private String nameShow;
    private String portrait;

    public long getGroupId() {
        return this.groupId;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }

    public long getLastMsgId() {
        return this.lastMsgId;
    }

    public void setLastMsgId(long j) {
        this.lastMsgId = j;
    }

    public int getGroupType() {
        return this.groupType;
    }

    public void setGroupType(int i) {
        this.groupType = i;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public int getGrade() {
        return this.grade;
    }

    public void setGrade(int i) {
        this.grade = i;
    }

    public String getAuthorId() {
        return this.authorId;
    }

    public void setAuthorId(String str) {
        this.authorId = str;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public void setAuthorName(String str) {
        this.authorName = str;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setNameShow(String str) {
        this.nameShow = str;
    }

    public String getNameShow() {
        return this.nameShow;
    }
}
