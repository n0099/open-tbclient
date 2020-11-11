package com.baidu.tieba.ala.guardclub.model;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.utils.p;
import com.baidu.mobstat.Config;
/* loaded from: classes4.dex */
public class f extends HttpMessage {
    private int pn;
    private int ps;

    public f() {
        super(1021139);
        this.ps = 20;
        this.pn = 1;
    }

    public void setPs(int i) {
        this.ps = i;
    }

    public void setPn(int i) {
        this.pn = i;
    }

    public void setParams() {
        addParam("scene_from", p.Hr());
        addParam("ps", this.ps);
        addParam(Config.PACKAGE_NAME, this.pn);
    }
}
