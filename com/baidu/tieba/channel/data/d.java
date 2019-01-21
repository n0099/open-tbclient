package com.baidu.tieba.channel.data;

import tbclient.GetChannelInfo.DataRes;
/* loaded from: classes3.dex */
public class d {
    private int del = 1;
    private g dem;
    private ChannelInfo den;
    private ChannelHomeVideoList<h> deo;

    public g arz() {
        return this.dem;
    }

    public boolean arA() {
        return this.deo == null || this.deo.size() == 0;
    }

    public void a(g gVar) {
        this.dem = gVar;
    }

    public ChannelInfo arB() {
        return this.den;
    }

    public void a(ChannelInfo channelInfo) {
        this.den = channelInfo;
    }

    public ChannelHomeVideoList<h> arC() {
        return this.deo;
    }

    public void a(ChannelHomeVideoList<h> channelHomeVideoList) {
        this.deo = channelHomeVideoList;
    }

    public boolean isHost() {
        return this.del == 0;
    }

    public void kW(int i) {
        this.del = i;
    }

    public boolean arD() {
        return this.dem != null && this.dem.isHasMore();
    }

    public void b(ChannelHomeVideoList<h> channelHomeVideoList) {
        if (this.deo != null && channelHomeVideoList != null) {
            this.deo.addAll(channelHomeVideoList);
            checkBigVideoType();
        }
    }

    public void checkBigVideoType() {
        if (this.deo != null) {
            this.deo.checkBigVideoType();
        }
    }

    public static d a(DataRes dataRes) {
        d dVar = null;
        if (dataRes != null) {
            dVar = new d();
            dVar.kW(dataRes.is_guest.intValue());
            dVar.a(ChannelInfo.parse(dataRes.channel));
            if (dataRes.video != null) {
                dVar.a(g.a(dataRes.video.page));
                dVar.a(h.bd(dataRes.video.list));
            }
        }
        return dVar;
    }
}
