package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public class RequestUpdateGroupInfoMessage extends RequestUpdateGroupMessage {
    private static final long serialVersionUID = 5970126981799423191L;
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
}
