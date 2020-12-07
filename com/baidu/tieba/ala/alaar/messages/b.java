package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.utils.p;
/* loaded from: classes4.dex */
public class b extends HttpMessage {
    private int biZ;
    private String mRequestType;

    public b(String str) {
        super(1021155);
        this.biZ = 2;
        this.mRequestType = str;
    }

    public void setParams() {
        addParam("scene_from", p.Iz());
        addParam("client_id", this.biZ);
        addParam("request_type", this.mRequestType);
        addParam("ar_sdk_version", com.baidu.minivideo.arface.a.getVersion());
    }
}
