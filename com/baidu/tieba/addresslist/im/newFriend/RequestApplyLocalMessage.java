package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes4.dex */
public class RequestApplyLocalMessage extends CustomResponsedMessage<Object> {
    public String content;
    public long friendId;
    public long id;
    public String message;
    public String name;
    public String portrait;
    public long uid;

    public RequestApplyLocalMessage() {
        super(2001216);
    }

    public String getContent() {
        return this.content;
    }

    public long getFriendId() {
        return this.friendId;
    }

    public long getId() {
        return this.id;
    }

    public String getMessage() {
        return this.message;
    }

    public String getName() {
        return this.name;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public long getUid() {
        return this.uid;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setFriendId(long j) {
        this.friendId = j;
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public void setUid(long j) {
        this.uid = j;
    }
}
