package com.baidu.tieba.im.message;

import protobuf.GroupInfo;
/* loaded from: classes3.dex */
public class RequestUpdateGroupInfoMessage extends RequestUpdateGroupMessage {
    private String intro;

    public RequestUpdateGroupInfoMessage(String str) {
        this.intro = str;
    }

    public String getIntro() {
        return this.intro;
    }

    public void setIntro(String str) {
        this.intro = str;
    }

    @Override // com.baidu.tieba.im.message.RequestUpdateGroupMessage
    protected void subEncode(GroupInfo.Builder builder) {
        builder.intro = getIntro();
    }
}
