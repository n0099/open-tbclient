package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.utils.q;
/* loaded from: classes3.dex */
public class b extends HttpMessage {
    private int aIQ;
    private String mRequestType;

    public b(String str) {
        super(1021155);
        this.aIQ = 2;
        this.mRequestType = str;
    }

    public void setParams() {
        addParam("scene_from", q.xg());
        addParam("client_id", this.aIQ);
        addParam("request_type", this.mRequestType);
        addParam("ar_sdk_version", com.baidu.minivideo.arface.a.getVersion());
    }
}
