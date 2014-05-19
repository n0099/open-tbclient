package com.baidu.tieba.im.live;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
/* loaded from: classes.dex */
public class AccessTokenUpdatedMessage extends CustomResponsedMessage<String> {
    private String accessToken;
    private String bduss;

    public AccessTokenUpdatedMessage() {
        super(MessageTypes.CMD_ACCESS_TOKEN_UPDATED);
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
