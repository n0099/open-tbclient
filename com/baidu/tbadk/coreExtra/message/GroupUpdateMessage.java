package com.baidu.tbadk.coreExtra.message;

import java.io.Serializable;
/* loaded from: classes3.dex */
public class GroupUpdateMessage implements Serializable {
    public static final long serialVersionUID = 1071062952403340773L;
    public String authorId;
    public String authorName;
    public String forumId;
    public int grade;
    public long groupId;
    public int groupType;
    public long lastMsgId;
    public String name;
    public String nameShow;
    public String portrait;

    public String getAuthorId() {
        return this.authorId;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public String getForumId() {
        return this.forumId;
    }

    public int getGrade() {
        return this.grade;
    }

    public long getGroupId() {
        return this.groupId;
    }

    public int getGroupType() {
        return this.groupType;
    }

    public long getLastMsgId() {
        return this.lastMsgId;
    }

    public String getName() {
        return this.name;
    }

    public String getNameShow() {
        return this.nameShow;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public void setAuthorId(String str) {
        this.authorId = str;
    }

    public void setAuthorName(String str) {
        this.authorName = str;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setGrade(int i2) {
        this.grade = i2;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }

    public void setGroupType(int i2) {
        this.groupType = i2;
    }

    public void setLastMsgId(long j) {
        this.lastMsgId = j;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNameShow(String str) {
        this.nameShow = str;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }
}
