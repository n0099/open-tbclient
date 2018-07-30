package com.baidu.tieba.channel.data;

import tbclient.GetChannelInfo.DataRes;
/* loaded from: classes3.dex */
public class d {
    private int cEK = 1;
    private g cEL;
    private ChannelInfo cEM;
    private ChannelHomeVideoList<h> cEN;

    public g ajH() {
        return this.cEL;
    }

    public boolean ajI() {
        return this.cEN == null || this.cEN.size() == 0;
    }

    public void a(g gVar) {
        this.cEL = gVar;
    }

    public ChannelInfo ajJ() {
        return this.cEM;
    }

    public void a(ChannelInfo channelInfo) {
        this.cEM = channelInfo;
    }

    public ChannelHomeVideoList<h> ajK() {
        return this.cEN;
    }

    public void a(ChannelHomeVideoList<h> channelHomeVideoList) {
        this.cEN = channelHomeVideoList;
    }

    public boolean isHost() {
        return this.cEK == 0;
    }

    public void jd(int i) {
        this.cEK = i;
    }

    public boolean ajL() {
        return this.cEL != null && this.cEL.isHasMore();
    }

    public void b(ChannelHomeVideoList<h> channelHomeVideoList) {
        if (this.cEN != null && channelHomeVideoList != null) {
            this.cEN.addAll(channelHomeVideoList);
            checkBigVideoType();
        }
    }

    public void checkBigVideoType() {
        if (this.cEN != null) {
            this.cEN.checkBigVideoType();
        }
    }

    public static d a(DataRes dataRes) {
        d dVar = null;
        if (dataRes != null) {
            dVar = new d();
            dVar.jd(dataRes.is_guest.intValue());
            dVar.a(ChannelInfo.parse(dataRes.channel));
            if (dataRes.video != null) {
                dVar.a(g.a(dataRes.video.page));
                dVar.a(h.aK(dataRes.video.list));
            }
        }
        return dVar;
    }
}
