package com.baidu.tieba.ala.guardclub.model;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes6.dex */
public class f extends HttpMessage {
    private c dLd;
    private int dOq;

    public f() {
        super(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
    }

    public void mQ(int i) {
        this.dOq = i;
    }

    public void a(c cVar) {
        this.dLd = cVar;
    }

    public c aLD() {
        return this.dLd;
    }

    public void setParams() {
        addParam("scene_from", com.baidu.live.utils.o.wt());
        addParam("guard_club_id", this.dOq);
        addParam("client_type", 2);
    }
}
