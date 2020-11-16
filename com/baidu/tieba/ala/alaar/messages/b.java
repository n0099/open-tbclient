package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.utils.p;
/* loaded from: classes4.dex */
public class b extends HttpMessage {
    private int beK;
    private String mRequestType;

    public b(String str) {
        super(1021155);
        this.beK = 2;
        this.mRequestType = str;
    }

    public void setParams() {
        addParam("scene_from", p.GI());
        addParam("client_id", this.beK);
        addParam("request_type", this.mRequestType);
        addParam("ar_sdk_version", com.baidu.minivideo.arface.a.getVersion());
    }
}
