package com.baidu.tieba.data.chat;

import com.baidu.tieba.im.c.i;
import java.io.Serializable;
/* loaded from: classes.dex */
public class ImMessageCenterShowItemData implements Serializable {
    private static final long serialVersionUID = 3133087680118197014L;
    protected String friendId;
    protected String friendName;
    protected String friendPortrait;
    private i groupSetting;
    protected String msgContent;
    protected String ownerId;
    protected String ownerName;
    protected long serverTime;
    protected int status;
    private String title;
    protected int unReadCount;
    protected int unReadCountExtra;

    public String getPK() {
        return String.valueOf(this.ownerId) + "@" + this.friendId;
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

    public i getGroupSetting() {
        return this.groupSetting;
    }

    public void setGroupSetting(i iVar) {
        this.groupSetting = iVar;
    }

    public int getUnReadCountExtra() {
        return this.unReadCountExtra;
    }

    public void setUnReadCountExtra(int i) {
        this.unReadCountExtra = i;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
