package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.utils.q;
/* loaded from: classes3.dex */
public class a extends HttpMessage {
    private int aIW;

    public a() {
        super(1021158);
        this.aIW = 2;
    }

    public void setParams() {
        addParam("scene_from", q.xf());
        addParam("client_id", this.aIW);
        addParam("ar_sdk_version", com.baidu.minivideo.arface.a.getVersion());
    }
}
