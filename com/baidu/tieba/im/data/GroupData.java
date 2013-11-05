package com.baidu.tieba.im.data;
/* loaded from: classes.dex */
public class GroupData extends BaseGroupData {
    private static final long serialVersionUID = 5616188082014345808L;
    private String authorPortrait;
    private String forumName;
    private long grade;
    private int isHidePosition;
    private String nickName;

    public String getAuthorPortrait() {
        return this.authorPortrait;
    }

    public void setAuthorPortrait(String str) {
        this.authorPortrait = str;
    }

    public void setIsHidePosition(int i) {
        this.isHidePosition = i;
    }

    public int getIsHidePosition() {
        return this.isHidePosition;
    }

    public long getGrade() {
        return this.grade;
    }

    public void setGrade(long j) {
        this.grade = j;
    }

    public String getForumName() {
        return this.forumName;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }
}
