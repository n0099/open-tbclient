package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.utils.q;
/* loaded from: classes3.dex */
public class c extends HttpMessage {
    private long liveId;

    public c() {
        super(1021006);
        this.liveId = 0L;
    }

    public void setLiveId(long j) {
        this.liveId = j;
    }

    public void setParams() {
        String yu = q.yu();
        addParam("live_id", this.liveId);
        addParam("scene_from", yu);
    }
}
