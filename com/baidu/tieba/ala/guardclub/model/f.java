package com.baidu.tieba.ala.guardclub.model;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes6.dex */
public class f extends HttpMessage {
    private c dKm;
    private int dNz;

    public f() {
        super(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
    }

    public void mP(int i) {
        this.dNz = i;
    }

    public void a(c cVar) {
        this.dKm = cVar;
    }

    public c aLB() {
        return this.dKm;
    }

    public void setParams() {
        addParam("scene_from", com.baidu.live.utils.o.wu());
        addParam("guard_club_id", this.dNz);
        addParam("client_type", 2);
    }
}
