package com.baidu.tieba.ala.liveroom.turntable.lucky;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class d extends HttpMessage {
    private String liveId;

    public d() {
        super(1021157);
    }

    public String getLiveId() {
        return this.liveId;
    }

    public void fs(String str) {
        this.liveId = str;
        addParam("live_id", str);
    }
}
