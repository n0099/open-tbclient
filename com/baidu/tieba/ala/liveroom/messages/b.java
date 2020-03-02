package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.TbConfig;
/* loaded from: classes3.dex */
public class b extends HttpMessage {
    private long aws;

    public void setLiveId(long j) {
        this.aws = j;
    }

    public b() {
        super(1021129);
    }

    public void setParams() {
        addParam("live_id", this.aws);
        addParam("subapp_type", TbConfig.getSubappType());
    }
}
