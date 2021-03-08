package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.utils.q;
/* loaded from: classes10.dex */
public class a extends HttpMessage {
    private int bkx;

    public a() {
        super(1021158);
        this.bkx = 2;
    }

    public void setParams() {
        addParam("scene_from", q.Fy());
        addParam("client_id", this.bkx);
        addParam("ar_sdk_version", com.baidu.minivideo.arface.a.getVersion());
    }
}
