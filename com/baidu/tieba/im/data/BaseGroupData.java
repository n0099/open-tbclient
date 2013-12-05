package com.baidu.tieba.im.data;

import com.baidu.tieba.util.ak;
import java.io.Serializable;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class BaseGroupData implements ak, Serializable {
    private static final long serialVersionUID = 5616188082014345808L;
    private String album;
    private int authorId;
    private String authorName;
    private String business;
    private int createTime;
    private int flag;
    private int forumId;
    private int groupId;
    private int groupType;
    private String intro;
    private String lat;
    private String lng;
    private int maxMemberNum;
    private int memberNum;
    private String name;
    private String notice;
    private String portrait;
    private String position;
    private int status;

    public int getFlag() {
        return this.flag;
    }

    public void setFlag(int i) {
        this.flag = i;
    }

    public int getForumId() {
        return this.forumId;
    }

    public void setForumId(int i) {
        this.forumId = i;
    }

    public int getGroupId() {
        return this.groupId;
    }

    public void setGroupId(int i) {
        this.groupId = i;
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

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String str) {
        this.position = str;
    }

    public String getBusiness() {
        return this.business;
    }

    public void setBusiness(String str) {
        this.business = str;
    }

    public String getLng() {
        return this.lng;
    }

    public void setLng(String str) {
        this.lng = str;
    }

    public String getLat() {
        return this.lat;
    }

    public void setLat(String str) {
        this.lat = str;
    }

    public String getNotice() {
        return this.notice;
    }

    public void setNotice(String str) {
        this.notice = str;
    }

    public String getAlbum() {
        return this.album;
    }

    public void setAlbum(String str) {
        this.album = str;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
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

    public int getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(int i) {
        this.createTime = i;
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

    public int getGroupType() {
        return this.groupType;
    }

    public void setGroupType(int i) {
        this.groupType = i;
    }

    @Override // com.baidu.tieba.util.ak
    public LinkedList<String> getImageUrl() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(this.portrait);
        return linkedList;
    }

    @Override // com.baidu.tieba.util.ak
    public LinkedList<String> getPhotoUrl() {
        return null;
    }

    @Override // com.baidu.tieba.util.ak
    public LinkedList<String> getForumPhotoUrl() {
        return null;
    }
}
