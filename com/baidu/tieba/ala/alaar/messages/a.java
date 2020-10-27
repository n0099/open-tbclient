package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.utils.p;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    private int bfd;

    public a() {
        super(1021158);
        this.bfd = 2;
    }

    public void setParams() {
        addParam("scene_from", p.GQ());
        addParam("client_id", this.bfd);
        addParam("ar_sdk_version", com.baidu.minivideo.arface.a.getVersion());
    }
}
