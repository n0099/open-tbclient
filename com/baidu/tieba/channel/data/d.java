package com.baidu.tieba.channel.data;

import tbclient.GetChannelInfo.DataRes;
/* loaded from: classes3.dex */
public class d {
    private ChannelInfo cKA;
    private ChannelHomeVideoList<h> cKB;
    private int cKy = 1;
    private g cKz;

    public g alv() {
        return this.cKz;
    }

    public boolean alw() {
        return this.cKB == null || this.cKB.size() == 0;
    }

    public void a(g gVar) {
        this.cKz = gVar;
    }

    public ChannelInfo alx() {
        return this.cKA;
    }

    public void a(ChannelInfo channelInfo) {
        this.cKA = channelInfo;
    }

    public ChannelHomeVideoList<h> aly() {
        return this.cKB;
    }

    public void a(ChannelHomeVideoList<h> channelHomeVideoList) {
        this.cKB = channelHomeVideoList;
    }

    public boolean isHost() {
        return this.cKy == 0;
    }

    public void jB(int i) {
        this.cKy = i;
    }

    public boolean alz() {
        return this.cKz != null && this.cKz.isHasMore();
    }

    public void b(ChannelHomeVideoList<h> channelHomeVideoList) {
        if (this.cKB != null && channelHomeVideoList != null) {
            this.cKB.addAll(channelHomeVideoList);
            checkBigVideoType();
        }
    }

    public void checkBigVideoType() {
        if (this.cKB != null) {
            this.cKB.checkBigVideoType();
        }
    }

    public static d a(DataRes dataRes) {
        d dVar = null;
        if (dataRes != null) {
            dVar = new d();
            dVar.jB(dataRes.is_guest.intValue());
            dVar.a(ChannelInfo.parse(dataRes.channel));
            if (dataRes.video != null) {
                dVar.a(g.a(dataRes.video.page));
                dVar.a(h.aL(dataRes.video.list));
            }
        }
        return dVar;
    }
}
