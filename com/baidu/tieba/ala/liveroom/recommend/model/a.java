package com.baidu.tieba.ala.liveroom.recommend.model;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    public int Xq;
    public long gvZ;
    public int gwa;
    public int gwb;
    public long liveId;

    public a() {
        super(1021193);
    }

    public void setParams() {
        addParam("live_id", this.liveId);
        addParam("session_id", this.gvZ);
        addParam("refresh_type", this.Xq);
        addParam("big_refresh_count", this.gwa);
    }
}
