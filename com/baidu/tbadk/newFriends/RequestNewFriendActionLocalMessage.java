package com.baidu.tbadk.newFriends;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class RequestNewFriendActionLocalMessage extends CustomResponsedMessage<Object> {
    private String content;
    private long id;
    private String name;
    private String portrait;
    private String st_type;

    public long getId() {
        return this.id;
    }

    public void setId(long j) {
        this.id = j;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String getSt_type() {
        return this.st_type;
    }

    public void setSt_type(String str) {
        this.st_type = str;
    }

    public RequestNewFriendActionLocalMessage(long j, String str, String str2, String str3, String str4) {
        super(2001173);
        this.id = j;
        this.name = str;
        this.portrait = str2;
        this.content = str3;
        this.st_type = str4;
    }
}
