package com.baidu.tieba.im.message;

import protobuf.GroupInfo;
/* loaded from: classes.dex */
public class RequestUpdateGroupFlagMessage extends RequestUpdateGroupMessage {
    private String business;
    private int flag;
    private String position;

    public int getFlag() {
        return this.flag;
    }

    public String getPosition() {
        return this.position;
    }

    public String getBusiness() {
        return this.business;
    }

    public RequestUpdateGroupFlagMessage(int i, String str, String str2) {
        this.flag = 0;
        this.position = "";
        this.business = "";
        this.flag = i;
        this.position = str;
        this.business = str2;
    }

    @Override // com.baidu.tieba.im.message.RequestUpdateGroupMessage
    protected void subEncode(GroupInfo.Builder builder) {
        builder.business = getBusiness();
        builder.portrait = getPosition();
        builder.flag = Integer.valueOf(getFlag());
    }
}
