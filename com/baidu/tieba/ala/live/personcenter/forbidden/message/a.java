package com.baidu.tieba.ala.live.personcenter.forbidden.message;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.mobstat.Config;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    private int pn;
    private int ps;

    public a() {
        super(1021079);
        this.pn = 1;
        this.ps = 20;
    }

    public void buildParams() {
        addParam(Config.PACKAGE_NAME, this.pn);
        addParam("ps", this.ps);
    }

    public void setPn(int i) {
        this.pn = i;
    }

    public int getPn() {
        return this.pn;
    }

    public boolean bHj() {
        return this.pn == 1;
    }
}
