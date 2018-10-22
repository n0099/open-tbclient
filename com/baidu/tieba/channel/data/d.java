package com.baidu.tieba.channel.data;

import tbclient.GetChannelInfo.DataRes;
/* loaded from: classes3.dex */
public class d {
    private int cSR = 1;
    private g cSS;
    private ChannelInfo cST;
    private ChannelHomeVideoList<h> cSU;

    public g aoY() {
        return this.cSS;
    }

    public boolean aoZ() {
        return this.cSU == null || this.cSU.size() == 0;
    }

    public void a(g gVar) {
        this.cSS = gVar;
    }

    public ChannelInfo apa() {
        return this.cST;
    }

    public void a(ChannelInfo channelInfo) {
        this.cST = channelInfo;
    }

    public ChannelHomeVideoList<h> apb() {
        return this.cSU;
    }

    public void a(ChannelHomeVideoList<h> channelHomeVideoList) {
        this.cSU = channelHomeVideoList;
    }

    public boolean isHost() {
        return this.cSR == 0;
    }

    public void jZ(int i) {
        this.cSR = i;
    }

    public boolean apc() {
        return this.cSS != null && this.cSS.isHasMore();
    }

    public void b(ChannelHomeVideoList<h> channelHomeVideoList) {
        if (this.cSU != null && channelHomeVideoList != null) {
            this.cSU.addAll(channelHomeVideoList);
            checkBigVideoType();
        }
    }

    public void checkBigVideoType() {
        if (this.cSU != null) {
            this.cSU.checkBigVideoType();
        }
    }

    public static d a(DataRes dataRes) {
        d dVar = null;
        if (dataRes != null) {
            dVar = new d();
            dVar.jZ(dataRes.is_guest.intValue());
            dVar.a(ChannelInfo.parse(dataRes.channel));
            if (dataRes.video != null) {
                dVar.a(g.a(dataRes.video.page));
                dVar.a(h.bb(dataRes.video.list));
            }
        }
        return dVar;
    }
}
