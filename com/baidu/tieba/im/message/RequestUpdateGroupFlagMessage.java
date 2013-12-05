package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public class RequestUpdateGroupFlagMessage extends RequestUpdateGroupMessage {
    private static final long serialVersionUID = 1284534837795929418L;
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
}
