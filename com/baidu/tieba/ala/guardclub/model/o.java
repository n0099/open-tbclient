package com.baidu.tieba.ala.guardclub.model;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes6.dex */
public class o extends HttpMessage {
    private String id;

    public o() {
        super(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT);
    }

    public void to(String str) {
        this.id = str;
    }

    public void setParams() {
        addParam("scene_from", com.baidu.live.utils.o.wt());
        addParam("guard_club_id", this.id);
        addParam("client_type", 2);
    }
}
