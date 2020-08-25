package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.utils.p;
/* loaded from: classes7.dex */
public class a extends HttpMessage {
    private int aXS;

    public a() {
        super(1021158);
        this.aXS = 2;
    }

    public void setParams() {
        addParam("scene_from", p.EZ());
        addParam("client_id", this.aXS);
        addParam("ar_sdk_version", com.baidu.minivideo.arface.a.getVersion());
    }
}
