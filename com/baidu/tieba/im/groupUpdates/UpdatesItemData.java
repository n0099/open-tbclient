package com.baidu.tieba.im.groupUpdates;

import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.util.an;
import com.google.gson.Gson;
import java.io.Serializable;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class UpdatesItemData implements an, Serializable {
    private static final long serialVersionUID = -6859992224160576142L;
    private String authorId;
    private String authorName;
    private String content;
    private String groupHeadUrl;
    private String groupId;
    private String groupName;
    private boolean isSelected;
    private boolean isShown;
    private String notice_id;
    private long time;
    private String title;
    private String updatesType;

    public String toJsonString() {
        return new Gson().toJson(this).toString();
    }

    public GroupNewsPojo toGroupNewsPojo() {
        return new GroupNewsPojo(this);
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String getGroupHeadUrl() {
        return this.groupHeadUrl;
    }

    public void setGroupHeadUrl(String str) {
        this.groupHeadUrl = str;
    }

    public String getUpdatesType() {
        return this.updatesType;
    }

    public void setUpdatesType(String str) {
        this.updatesType = str;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public boolean isShown() {
        return this.isShown;
    }

    public void setShown(boolean z) {
        this.isShown = z;
    }

    public String getNotice_id() {
        return this.notice_id;
    }

    public void setNotice_id(String str) {
        this.notice_id = str;
    }

    @Override // com.baidu.tieba.util.an
    public LinkedList<String> getImageUrl() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(getGroupHeadUrl());
        return linkedList;
    }

    @Override // com.baidu.tieba.util.an
    public LinkedList<String> getPhotoUrl() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(getGroupHeadUrl());
        return linkedList;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
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

    @Override // com.baidu.tieba.util.an
    public LinkedList<String> getForumPhotoUrl() {
        return null;
    }
}
