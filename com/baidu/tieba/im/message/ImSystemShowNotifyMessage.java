package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes13.dex */
public class ImSystemShowNotifyMessage extends CustomResponsedMessage<String> {
    private String curSysMid;

    public ImSystemShowNotifyMessage(String str) {
        super(CmdConfigCustom.CMD_IM_SYSTEM_SHOW_NOTIFY);
        this.curSysMid = str;
    }

    public String getCurSysMid() {
        return this.curSysMid;
    }

    public void setCurSysMid(String str) {
        this.curSysMid = str;
    }
}
