package com.baidu.tbadk.live;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class AccessTokenUpdatedMessage extends CustomResponsedMessage<String> {
    private String accessToken;
    private String bduss;

    public AccessTokenUpdatedMessage() {
        super(2001164);
    }

    public String getBduss() {
        return this.bduss;
    }

    public void setBduss(String str) {
        this.bduss = str;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }
}
