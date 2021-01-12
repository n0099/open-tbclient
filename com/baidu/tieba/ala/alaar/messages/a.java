package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.utils.q;
/* loaded from: classes10.dex */
public class a extends HttpMessage {
    private int bfO;

    public a() {
        super(1021158);
        this.bfO = 2;
    }

    public void setParams() {
        addParam("scene_from", q.Ef());
        addParam("client_id", this.bfO);
        addParam("ar_sdk_version", com.baidu.minivideo.arface.a.getVersion());
    }
}
