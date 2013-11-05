package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public class RequestUpdateGroupPortraitMessage extends RequestUpdateGroupMessage {
    private static final long serialVersionUID = -8030575228993001822L;
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
}
