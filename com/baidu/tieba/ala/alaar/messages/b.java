package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.utils.q;
/* loaded from: classes10.dex */
public class b extends HttpMessage {
    private int bkx;
    private String mRequestType;

    public b(String str) {
        super(1021155);
        this.bkx = 2;
        this.mRequestType = str;
    }

    public void setParams() {
        addParam("scene_from", q.Fy());
        addParam("client_id", this.bkx);
        addParam("request_type", this.mRequestType);
        addParam("ar_sdk_version", com.baidu.minivideo.arface.a.getVersion());
    }
}
