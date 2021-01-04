package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.utils.q;
/* loaded from: classes11.dex */
public class b extends HttpMessage {
    private int bkE;
    private String mRequestType;

    public b(String str) {
        super(1021155);
        this.bkE = 2;
        this.mRequestType = str;
    }

    public void setParams() {
        addParam("scene_from", q.Ia());
        addParam("client_id", this.bkE);
        addParam("request_type", this.mRequestType);
        addParam("ar_sdk_version", com.baidu.minivideo.arface.a.getVersion());
    }
}
