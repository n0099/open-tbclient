package com.baidu.tieba.ala.guardclub.model;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.utils.q;
/* loaded from: classes3.dex */
public class j extends HttpMessage {
    private String id;

    public j() {
        super(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT);
    }

    public void yA(String str) {
        this.id = str;
    }

    public void setParams() {
        addParam("scene_from", q.sI());
        addParam("guard_club_id", this.id);
        addParam("client_type", 2);
    }
}
