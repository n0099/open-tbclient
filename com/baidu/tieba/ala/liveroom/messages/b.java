package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.TbConfig;
/* loaded from: classes4.dex */
public class b extends HttpMessage {
    private long bnV;
    public boolean isFirst;

    public void setLiveId(long j) {
        this.bnV = j;
    }

    public b() {
        super(1021129);
        this.isFirst = true;
    }

    public void setParams() {
        addParam("live_id", this.bnV);
        addParam("no_cache", this.isFirst ? 1 : 0);
        addParam("subapp_type", TbConfig.getSubappType());
    }
}
