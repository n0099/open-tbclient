package com.baidu.tieba.im.more;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public class PrivacySettingMessage extends HttpMessage {
    private String opt;
    private int val;

    public PrivacySettingMessage(String str, int i) {
        super(CmdConfigHttp.SET_PRIVATE_CMD);
        this.opt = str;
        this.val = i;
    }

    public String getOperation() {
        return this.opt;
    }

    public int getType() {
        return this.val;
    }
}
