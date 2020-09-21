package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.utils.p;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    private int bas;

    public a() {
        super(1021158);
        this.bas = 2;
    }

    public void setParams() {
        addParam("scene_from", p.Fz());
        addParam("client_id", this.bas);
        addParam("ar_sdk_version", com.baidu.minivideo.arface.a.getVersion());
    }
}
