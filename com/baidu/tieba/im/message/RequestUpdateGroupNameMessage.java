package com.baidu.tieba.im.message;

import protobuf.GroupInfo;
/* loaded from: classes10.dex */
public class RequestUpdateGroupNameMessage extends RequestUpdateGroupMessage {
    private String name;

    public RequestUpdateGroupNameMessage(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    @Override // com.baidu.tieba.im.message.RequestUpdateGroupMessage
    protected void subEncode(GroupInfo.Builder builder) {
        builder.name = getName();
    }
}
