package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.utils.q;
/* loaded from: classes3.dex */
public class a extends HttpMessage {
    private int aIQ;

    public a() {
        super(1021158);
        this.aIQ = 2;
    }

    public void setParams() {
        addParam("scene_from", q.xg());
        addParam("client_id", this.aIQ);
        addParam("ar_sdk_version", com.baidu.minivideo.arface.a.getVersion());
    }
}
