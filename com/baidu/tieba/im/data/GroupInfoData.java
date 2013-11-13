package com.baidu.tieba.im.data;

import com.baidu.tieba.util.an;
import java.io.Serializable;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class GroupInfoData implements an, Serializable {
    private static final long serialVersionUID = 5616188082014345808L;
    private int authorId;
    private String authorName;
    private int forumId;
    private int grade;
    private int groupId;
    private String intro;
    private int isGroupManager;
    private int maxMemberNum;
    private int memberNum;
    private String name;
    private String portrait;

    public int getGrade() {
        return this.grade;
    }

    public void setGrade(int i) {
        this.grade = i;
    }

    public int getIsGroupManager() {
        return this.isGroupManager;
    }

    public void setIsGroupManager(int i) {
        this.isGroupManager = i;
    }

    public int getGroupId() {
        return this.groupId;
    }

    public void setGroupId(int i) {
        this.groupId = i;
    }

    public long getForumId() {
        return this.forumId;
    }

    public void setForumId(int i) {
        this.forumId = i;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getIntro() {
        return this.intro;
    }

    public void setIntro(String str) {
        this.intro = str;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public int getMaxMemberNum() {
        return this.maxMemberNum;
    }

    public void setMaxMemberNum(int i) {
        this.maxMemberNum = i;
    }

    public int getMemberNum() {
        return this.memberNum;
    }

    public void setMemberNum(int i) {
        this.memberNum = i;
    }

    public int getAuthorId() {
        return this.authorId;
    }

    public void setAuthorId(int i) {
        this.authorId = i;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public void setAuthorName(String str) {
        this.authorName = str;
    }

    public String toString() {
        return "GroupInfoData [isManager=" + this.isGroupManager + ", groupId=" + this.groupId + ", forumId=" + this.forumId + ", name=" + this.name + ", intro=" + this.intro + ", portrait=" + this.portrait + ", maxMemberNum=" + this.maxMemberNum + ", memberNum=" + this.memberNum + ", authorId=" + this.authorId + ", authorName=" + this.authorName + "]";
    }

    @Override // com.baidu.tieba.util.an
    public LinkedList<String> getImageUrl() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(this.portrait);
        return linkedList;
    }

    @Override // com.baidu.tieba.util.an
    public LinkedList<String> getPhotoUrl() {
        return null;
    }

    @Override // com.baidu.tieba.util.an
    public LinkedList<String> getForumPhotoUrl() {
        return null;
    }
}
