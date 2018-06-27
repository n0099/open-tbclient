package com.baidu.tieba.channel.data;

import tbclient.GetChannelInfo.DataRes;
/* loaded from: classes3.dex */
public class d {
    private int cCf = 1;
    private g cCg;
    private ChannelInfo cCh;
    private ChannelHomeVideoList<h> cCi;

    public g ajj() {
        return this.cCg;
    }

    public boolean ajk() {
        return this.cCi == null || this.cCi.size() == 0;
    }

    public void a(g gVar) {
        this.cCg = gVar;
    }

    public ChannelInfo ajl() {
        return this.cCh;
    }

    public void a(ChannelInfo channelInfo) {
        this.cCh = channelInfo;
    }

    public ChannelHomeVideoList<h> ajm() {
        return this.cCi;
    }

    public void a(ChannelHomeVideoList<h> channelHomeVideoList) {
        this.cCi = channelHomeVideoList;
    }

    public boolean isHost() {
        return this.cCf == 0;
    }

    public void iR(int i) {
        this.cCf = i;
    }

    public boolean ajn() {
        return this.cCg != null && this.cCg.isHasMore();
    }

    public void b(ChannelHomeVideoList<h> channelHomeVideoList) {
        if (this.cCi != null && channelHomeVideoList != null) {
            this.cCi.addAll(channelHomeVideoList);
            checkBigVideoType();
        }
    }

    public void checkBigVideoType() {
        if (this.cCi != null) {
            this.cCi.checkBigVideoType();
        }
    }

    public static d a(DataRes dataRes) {
        d dVar = null;
        if (dataRes != null) {
            dVar = new d();
            dVar.iR(dataRes.is_guest.intValue());
            dVar.a(ChannelInfo.parse(dataRes.channel));
            if (dataRes.video != null) {
                dVar.a(g.a(dataRes.video.page));
                dVar.a(h.aL(dataRes.video.list));
            }
        }
        return dVar;
    }
}
