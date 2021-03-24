package com.baidu.tbadk.newFriends;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes3.dex */
public class ResponseNewFriendUpdateUiMsg extends CustomResponsedMessage<Object> {
    public static final int DELETE = 1;
    public static final int NORMAL = -1;
    public static final int PASSED = 0;
    public int action;
    public String content;
    public long friendId;
    public String key;
    public String name;
    public String portrait;
    public String quanping;

    public ResponseNewFriendUpdateUiMsg(int i, long j, String str, String str2, String str3, String str4) {
        super(2001174);
        this.action = i;
        this.friendId = j;
        this.portrait = str;
        this.name = str2;
        this.key = str3;
        this.quanping = str4;
    }

    public int getAction() {
        return this.action;
    }

    public String getContent() {
        return this.content;
    }

    public long getFriendId() {
        return this.friendId;
    }

    public String getKey() {
        return this.key;
    }

    public String getName() {
        return this.name;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public String getQuanping() {
        return this.quanping;
    }

    public void setAction(int i) {
        this.action = i;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setFriendId(long j) {
        this.friendId = j;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public void setQuanping(String str) {
        this.quanping = str;
    }
}
