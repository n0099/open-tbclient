package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.utils.p;
import com.baidu.mobstat.Config;
/* loaded from: classes4.dex */
public class c extends HttpMessage {
    private BdUniqueId blA;
    private String mRequestType;
    private int pn;
    private int rn;

    public c(BdUniqueId bdUniqueId, String str, int i, int i2) {
        super(1021156);
        this.blA = bdUniqueId;
        this.mRequestType = str;
        this.pn = i;
        this.rn = i2;
    }

    public void setParams() {
        addParam("scene_from", p.Gv());
        addParam("type", this.mRequestType);
        addParam(Config.PACKAGE_NAME, this.pn);
        addParam("rn", this.rn);
        setTag(this.blA);
    }
}
