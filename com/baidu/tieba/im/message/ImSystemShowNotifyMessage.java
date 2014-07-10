package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class ImSystemShowNotifyMessage extends CustomResponsedMessage<String> {
    private String curSysMid;

    public ImSystemShowNotifyMessage(String str) {
        super(2001128);
        this.curSysMid = str;
    }

    public String getCurSysMid() {
        return this.curSysMid;
    }

    public void setCurSysMid(String str) {
        this.curSysMid = str;
    }
}
