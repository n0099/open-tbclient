package com.baidu.tbadk.newFriends;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes.dex */
public class ResponseNewFriendUpdateUiMsg extends CustomResponsedMessage<Object> {
    public static final int DELETE = 1;
    public static final int NORMAL = -1;
    public static final int PASSED = 0;
    private int action;
    private String content;
    private long friendId;
    private String key;
    private String name;
    private String portrait;
    private String quanping;

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String getQuanping() {
        return this.quanping;
    }

    public void setQuanping(String str) {
        this.quanping = str;
    }

    public int getAction() {
        return this.action;
    }

    public void setAction(int i) {
        this.action = i;
    }

    public long getFriendId() {
        return this.friendId;
    }

    public void setFriendId(long j) {
        this.friendId = j;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public ResponseNewFriendUpdateUiMsg(int i, long j, String str, String str2, String str3, String str4) {
        super(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL);
        this.action = i;
        this.friendId = j;
        this.portrait = str;
        this.name = str2;
        this.key = str3;
        this.quanping = str4;
    }
}
