package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public class RequestUpdateGroupFlagMessage extends RequestUpdateGroupMessage {
    private static final long serialVersionUID = 1284534837795929418L;
    private int flag;

    public int getFlag() {
        return this.flag;
    }

    public RequestUpdateGroupFlagMessage(int i) {
        this.flag = 0;
        this.flag = i;
    }
}
