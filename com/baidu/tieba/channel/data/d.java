package com.baidu.tieba.channel.data;

import tbclient.GetChannelInfo.DataRes;
/* loaded from: classes3.dex */
public class d {
    private ChannelInfo ddA;
    private ChannelHomeVideoList<h> ddB;
    private int ddy = 1;
    private g ddz;

    public g arb() {
        return this.ddz;
    }

    public boolean arc() {
        return this.ddB == null || this.ddB.size() == 0;
    }

    public void a(g gVar) {
        this.ddz = gVar;
    }

    public ChannelInfo ard() {
        return this.ddA;
    }

    public void a(ChannelInfo channelInfo) {
        this.ddA = channelInfo;
    }

    public ChannelHomeVideoList<h> are() {
        return this.ddB;
    }

    public void a(ChannelHomeVideoList<h> channelHomeVideoList) {
        this.ddB = channelHomeVideoList;
    }

    public boolean isHost() {
        return this.ddy == 0;
    }

    public void kV(int i) {
        this.ddy = i;
    }

    public boolean arf() {
        return this.ddz != null && this.ddz.isHasMore();
    }

    public void b(ChannelHomeVideoList<h> channelHomeVideoList) {
        if (this.ddB != null && channelHomeVideoList != null) {
            this.ddB.addAll(channelHomeVideoList);
            checkBigVideoType();
        }
    }

    public void checkBigVideoType() {
        if (this.ddB != null) {
            this.ddB.checkBigVideoType();
        }
    }

    public static d a(DataRes dataRes) {
        d dVar = null;
        if (dataRes != null) {
            dVar = new d();
            dVar.kV(dataRes.is_guest.intValue());
            dVar.a(ChannelInfo.parse(dataRes.channel));
            if (dataRes.video != null) {
                dVar.a(g.a(dataRes.video.page));
                dVar.a(h.bc(dataRes.video.list));
            }
        }
        return dVar;
    }
}
