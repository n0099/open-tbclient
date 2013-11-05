package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public class RequestUpdateGroupNameMessage extends RequestUpdateGroupMessage {
    private static final long serialVersionUID = 5970126981799423191L;
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
}
