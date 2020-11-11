package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.utils.p;
/* loaded from: classes4.dex */
public class b extends HttpMessage {
    private int bgy;
    private String mRequestType;

    public b(String str) {
        super(1021155);
        this.bgy = 2;
        this.mRequestType = str;
    }

    public void setParams() {
        addParam("scene_from", p.Hr());
        addParam("client_id", this.bgy);
        addParam("request_type", this.mRequestType);
        addParam("ar_sdk_version", com.baidu.minivideo.arface.a.getVersion());
    }
}
