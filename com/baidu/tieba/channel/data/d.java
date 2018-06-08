package com.baidu.tieba.channel.data;

import tbclient.GetChannelInfo.DataRes;
/* loaded from: classes3.dex */
public class d {
    private int cEm = 1;
    private g cEn;
    private ChannelInfo cEo;
    private ChannelHomeVideoList<h> cEp;

    public g ajP() {
        return this.cEn;
    }

    public boolean ajQ() {
        return this.cEp == null || this.cEp.size() == 0;
    }

    public void a(g gVar) {
        this.cEn = gVar;
    }

    public ChannelInfo ajR() {
        return this.cEo;
    }

    public void a(ChannelInfo channelInfo) {
        this.cEo = channelInfo;
    }

    public ChannelHomeVideoList<h> ajS() {
        return this.cEp;
    }

    public void a(ChannelHomeVideoList<h> channelHomeVideoList) {
        this.cEp = channelHomeVideoList;
    }

    public boolean isHost() {
        return this.cEm == 0;
    }

    public void iT(int i) {
        this.cEm = i;
    }

    public boolean ajT() {
        return this.cEn != null && this.cEn.isHasMore();
    }

    public void b(ChannelHomeVideoList<h> channelHomeVideoList) {
        if (this.cEp != null && channelHomeVideoList != null) {
            this.cEp.addAll(channelHomeVideoList);
            checkBigVideoType();
        }
    }

    public void checkBigVideoType() {
        if (this.cEp != null) {
            this.cEp.checkBigVideoType();
        }
    }

    public static d a(DataRes dataRes) {
        d dVar = null;
        if (dataRes != null) {
            dVar = new d();
            dVar.iT(dataRes.is_guest.intValue());
            dVar.a(ChannelInfo.parse(dataRes.channel));
            if (dataRes.video != null) {
                dVar.a(g.a(dataRes.video.page));
                dVar.a(h.aK(dataRes.video.list));
            }
        }
        return dVar;
    }
}
