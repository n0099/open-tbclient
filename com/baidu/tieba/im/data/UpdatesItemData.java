package com.baidu.tieba.im.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.util.AbstractImageProvider;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class UpdatesItemData extends AbstractImageProvider implements Serializable {
    public static final long serialVersionUID = -6859992224160576142L;
    public String authorId;
    public String authorName;
    public String content;
    public String eventLink;
    public String groupActivityId;
    public String groupHeadUrl;
    public String groupId;
    public String groupName;
    public boolean isSelected;
    public boolean isShown;
    public String notice_id;
    public long time;
    public String title;
    public String updatesType;

    public String getAuthorId() {
        return this.authorId;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public String getContent() {
        return this.content;
    }

    public String getEventLink() {
        return this.eventLink;
    }

    public String getGroupActivityId() {
        return this.groupActivityId;
    }

    public String getGroupHeadUrl() {
        return this.groupHeadUrl;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public String getGroupName() {
        return this.groupName;
    }

    @Override // com.baidu.tbadk.core.util.AbstractImageProvider, com.baidu.tbadk.core.util.ImageProvider
    public ArrayList<String> getImageUrl() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(getGroupHeadUrl());
        return arrayList;
    }

    public String getNotice_id() {
        return this.notice_id;
    }

    @Override // com.baidu.tbadk.core.util.AbstractImageProvider, com.baidu.tbadk.core.util.ImageProvider
    public ArrayList<String> getPhotoUrl() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(getGroupHeadUrl());
        return arrayList;
    }

    public long getTime() {
        return this.time;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUpdatesType() {
        return this.updatesType;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public boolean isShown() {
        return this.isShown;
    }

    public void setAuthorId(String str) {
        this.authorId = str;
    }

    public void setAuthorName(String str) {
        this.authorName = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setEventLink(String str) {
        this.eventLink = str;
    }

    public void setGroupActivityId(String str) {
        this.groupActivityId = str;
    }

    public void setGroupHeadUrl(String str) {
        this.groupHeadUrl = str;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public void setNotice_id(String str) {
        this.notice_id = str;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public void setShown(boolean z) {
        this.isShown = z;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUpdatesType(String str) {
        this.updatesType = str;
        if (str.equals("dismiss_group")) {
            this.isSelected = true;
        } else {
            this.isSelected = false;
        }
    }

    public GroupNewsPojo toGroupNewsPojo() {
        return new GroupNewsPojo(this);
    }

    public String toJsonString() {
        return OrmObject.jsonStrWithObject(this);
    }
}
