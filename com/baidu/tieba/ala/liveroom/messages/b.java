package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.TbConfig;
/* loaded from: classes6.dex */
public class b extends HttpMessage {
    private long aju;

    public void setLiveId(long j) {
        this.aju = j;
    }

    public b() {
        super(1021129);
    }

    public void setParams() {
        addParam("live_id", this.aju);
        addParam("subapp_type", TbConfig.getSubappType());
    }
}
