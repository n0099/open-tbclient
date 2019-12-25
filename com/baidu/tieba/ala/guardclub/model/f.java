package com.baidu.tieba.ala.guardclub.model;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes2.dex */
public class f extends HttpMessage {
    private int eBH;
    private c eyC;

    public f() {
        super(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
    }

    public void pf(int i) {
        this.eBH = i;
    }

    public void a(c cVar) {
        this.eyC = cVar;
    }

    public c bcK() {
        return this.eyC;
    }

    public void setParams() {
        addParam("scene_from", com.baidu.live.utils.p.yu());
        addParam("guard_club_id", this.eBH);
        addParam("client_type", 2);
    }
}
