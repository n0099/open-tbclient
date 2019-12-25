package com.baidu.tieba.im.message;

import protobuf.GroupInfo;
/* loaded from: classes7.dex */
public class RequestUpdateGroupPortraitMessage extends RequestUpdateGroupMessage {
    private String portrait;

    public RequestUpdateGroupPortraitMessage(String str) {
        this.portrait = null;
        this.portrait = str;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    @Override // com.baidu.tieba.im.message.RequestUpdateGroupMessage
    protected void subEncode(GroupInfo.Builder builder) {
        builder.portrait = getPortrait();
    }
}
