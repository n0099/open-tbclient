package com.baidu.tieba.data.chat;

import com.baidu.tieba.im.groupInfo.GroupSettingItemData;
import java.io.Serializable;
/* loaded from: classes.dex */
public class RecentChatFriendData implements Serializable {
    protected String friendId;
    protected String friendName;
    protected String friendPortrait;
    private GroupSettingItemData groupSetting;
    private String lastMsgUserName;
    protected long localTime;
    protected String msgContent;
    protected String ownerId;
    protected String ownerName;
    protected long serverTime;
    protected int status;
    protected int unReadCount;

    public String getPK() {
        return this.ownerId + "@" + this.friendId;
    }

    public String getOwnerId() {
        return this.ownerId;
    }

    public void setOwnerId(String str) {
        this.ownerId = str;
    }

    public String getFriendId() {
        return this.friendId;
    }

    public void setFriendId(String str) {
        this.friendId = str;
    }

    public String getFriendPortrait() {
        return this.friendPortrait;
    }

    public void setFriendPortrait(String str) {
        this.friendPortrait = str;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public long getLocalTime() {
        return this.localTime;
    }

    public void setLocalTime(long j) {
        this.localTime = j;
    }

    public long getServerTime() {
        return this.serverTime;
    }

    public void setServerTime(long j) {
        this.serverTime = j;
    }

    public String getMsgContent() {
        return this.msgContent;
    }

    public void setMsgContent(String str) {
        this.msgContent = str;
    }

    public int getUnReadCount() {
        return this.unReadCount;
    }

    public void setUnReadCount(int i) {
        this.unReadCount = i;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public void setOwnerName(String str) {
        this.ownerName = str;
    }

    public String getFriendName() {
        return this.friendName;
    }

    public void setFriendName(String str) {
        this.friendName = str;
    }

    public String getLastMsgUserName() {
        return this.lastMsgUserName;
    }

    public void setLastMsgUserName(String str) {
        this.lastMsgUserName = str;
    }

    public GroupSettingItemData getGroupSetting() {
        return this.groupSetting;
    }

    public void setGroupSetting(GroupSettingItemData groupSettingItemData) {
        this.groupSetting = groupSettingItemData;
    }
}
