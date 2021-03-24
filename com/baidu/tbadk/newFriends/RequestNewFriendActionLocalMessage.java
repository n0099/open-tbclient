package com.baidu.tbadk.newFriends;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes3.dex */
public class RequestNewFriendActionLocalMessage extends CustomResponsedMessage<Object> {
    public String content;
    public long id;
    public String name;
    public String portrait;
    public String st_type;

    public RequestNewFriendActionLocalMessage(long j, String str, String str2, String str3, String str4) {
        super(2001169);
        this.id = j;
        this.name = str;
        this.portrait = str2;
        this.content = str3;
        this.st_type = str4;
    }

    public String getContent() {
        return this.content;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public String getSt_type() {
        return this.st_type;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public void setSt_type(String str) {
        this.st_type = str;
    }
}
