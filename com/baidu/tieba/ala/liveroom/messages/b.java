package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.TbConfig;
/* loaded from: classes3.dex */
public class b extends HttpMessage {
    private long aZe;
    public boolean isFirst;

    public void setLiveId(long j) {
        this.aZe = j;
    }

    public b() {
        super(1021129);
        this.isFirst = true;
    }

    public void setParams() {
        addParam("live_id", this.aZe);
        addParam("no_cache", this.isFirst ? 1 : 0);
        addParam("subapp_type", TbConfig.getSubappType());
    }
}
