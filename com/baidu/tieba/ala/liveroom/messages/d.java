package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.mobstat.Config;
/* loaded from: classes4.dex */
public class d extends HttpMessage {
    public int pn;
    public int ps;

    public d() {
        super(1021207);
        this.pn = 1;
        this.ps = 10;
    }

    public void setParams() {
        addParam(Config.PACKAGE_NAME, this.pn);
        addParam("ps", this.ps);
    }
}
