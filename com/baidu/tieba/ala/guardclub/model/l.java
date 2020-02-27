package com.baidu.tieba.ala.guardclub.model;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.mobstat.Config;
/* loaded from: classes3.dex */
public class l extends HttpMessage {
    public int type;

    public l() {
        super(1021146);
    }

    public void c(String str, int i, int i2, int i3) {
        addParam("anchor_id", str);
        addParam(Config.PACKAGE_NAME, i);
        addParam("ps", i2);
        addParam("rank_type", i3);
        this.type = i3;
    }
}
