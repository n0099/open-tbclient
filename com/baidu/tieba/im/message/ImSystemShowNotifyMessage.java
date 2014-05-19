package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
/* loaded from: classes.dex */
public class ImSystemShowNotifyMessage extends CustomResponsedMessage<String> {
    private String curSysMid;

    public ImSystemShowNotifyMessage(String str) {
        super(MessageTypes.CMD_IM_SYSTEM_SHOW_NOTIFY);
        this.curSysMid = str;
    }

    public String getCurSysMid() {
        return this.curSysMid;
    }

    public void setCurSysMid(String str) {
        this.curSysMid = str;
    }
}
