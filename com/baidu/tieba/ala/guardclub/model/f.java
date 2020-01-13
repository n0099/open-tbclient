package com.baidu.tieba.ala.guardclub.model;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes2.dex */
public class f extends HttpMessage {
    private int eCS;
    private c ezN;

    public f() {
        super(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
    }

    public void pg(int i) {
        this.eCS = i;
    }

    public void a(c cVar) {
        this.ezN = cVar;
    }

    public c bdf() {
        return this.ezN;
    }

    public void setParams() {
        addParam("scene_from", com.baidu.live.utils.q.yN());
        addParam("guard_club_id", this.eCS);
        addParam("client_type", 2);
    }
}
