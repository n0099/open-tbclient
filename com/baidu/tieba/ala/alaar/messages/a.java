package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.utils.p;
/* loaded from: classes3.dex */
public class a extends HttpMessage {
    private int aRl;

    public a() {
        super(1021158);
        this.aRl = 2;
    }

    public void setParams() {
        addParam("scene_from", p.yU());
        addParam("client_id", this.aRl);
        addParam("ar_sdk_version", com.baidu.minivideo.arface.a.getVersion());
    }
}
