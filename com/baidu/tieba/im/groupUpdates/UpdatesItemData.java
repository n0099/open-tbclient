package com.baidu.tieba.im.groupUpdates;

import com.baidu.gson.Gson;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import java.io.Serializable;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class UpdatesItemData extends com.baidu.tbadk.core.util.a implements Serializable {
    private static final long serialVersionUID = -6859992224160576142L;
    private String authorId;
    private String authorName;
    private String content;
    private String eventLink;
    private String groupActivityId;
    private String groupHeadUrl;
    private String groupId;
    private String groupName;
    private boolean isSelected;
    private boolean isShown;
    private LiveCardData mLiveCardData = null;
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
        if (this.updatesType.equals("dismiss_group")) {
            this.isSelected = true;
        } else {
            this.isSelected = false;
        }
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

    @Override // com.baidu.tbadk.core.util.a, com.baidu.tbadk.core.util.ad
    public LinkedList<String> getImageUrl() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(getGroupHeadUrl());
        return linkedList;
    }

    @Override // com.baidu.tbadk.core.util.a, com.baidu.tbadk.core.util.ad
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

    public String getEventLink() {
        return this.eventLink;
    }

    public void setEventLink(String str) {
        this.eventLink = str;
    }

    public String getGroupActivityId() {
        return this.groupActivityId;
    }

    public void setGroupActivityId(String str) {
        this.groupActivityId = str;
    }

    public LiveCardData getLiveCardData() {
        return this.mLiveCardData;
    }

    public void setLiveCardData(LiveCardData liveCardData) {
        this.mLiveCardData = liveCardData;
    }
}
