package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.utils.q;
/* loaded from: classes11.dex */
public class a extends HttpMessage {
    private int bkE;

    public a() {
        super(1021158);
        this.bkE = 2;
    }

    public void setParams() {
        addParam("scene_from", q.Ia());
        addParam("client_id", this.bkE);
        addParam("ar_sdk_version", com.baidu.minivideo.arface.a.getVersion());
    }
}
