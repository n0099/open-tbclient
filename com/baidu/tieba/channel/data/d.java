package com.baidu.tieba.channel.data;

import tbclient.GetChannelInfo.DataRes;
/* loaded from: classes3.dex */
public class d {
    private int dek = 1;
    private g del;
    private ChannelInfo dem;
    private ChannelHomeVideoList<h> den;

    public g arz() {
        return this.del;
    }

    public boolean arA() {
        return this.den == null || this.den.size() == 0;
    }

    public void a(g gVar) {
        this.del = gVar;
    }

    public ChannelInfo arB() {
        return this.dem;
    }

    public void a(ChannelInfo channelInfo) {
        this.dem = channelInfo;
    }

    public ChannelHomeVideoList<h> arC() {
        return this.den;
    }

    public void a(ChannelHomeVideoList<h> channelHomeVideoList) {
        this.den = channelHomeVideoList;
    }

    public boolean isHost() {
        return this.dek == 0;
    }

    public void kW(int i) {
        this.dek = i;
    }

    public boolean arD() {
        return this.del != null && this.del.isHasMore();
    }

    public void b(ChannelHomeVideoList<h> channelHomeVideoList) {
        if (this.den != null && channelHomeVideoList != null) {
            this.den.addAll(channelHomeVideoList);
            checkBigVideoType();
        }
    }

    public void checkBigVideoType() {
        if (this.den != null) {
            this.den.checkBigVideoType();
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
