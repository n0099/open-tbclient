package com.baidu.tieba.channel.data;

import tbclient.GetChannelInfo.DataRes;
/* loaded from: classes3.dex */
public class d {
    private int cTX = 1;
    private g cTY;
    private ChannelInfo cTZ;
    private ChannelHomeVideoList<h> cUa;

    public g aoz() {
        return this.cTY;
    }

    public boolean aoA() {
        return this.cUa == null || this.cUa.size() == 0;
    }

    public void a(g gVar) {
        this.cTY = gVar;
    }

    public ChannelInfo aoB() {
        return this.cTZ;
    }

    public void a(ChannelInfo channelInfo) {
        this.cTZ = channelInfo;
    }

    public ChannelHomeVideoList<h> aoC() {
        return this.cUa;
    }

    public void a(ChannelHomeVideoList<h> channelHomeVideoList) {
        this.cUa = channelHomeVideoList;
    }

    public boolean isHost() {
        return this.cTX == 0;
    }

    public void ks(int i) {
        this.cTX = i;
    }

    public boolean aoD() {
        return this.cTY != null && this.cTY.isHasMore();
    }

    public void b(ChannelHomeVideoList<h> channelHomeVideoList) {
        if (this.cUa != null && channelHomeVideoList != null) {
            this.cUa.addAll(channelHomeVideoList);
            checkBigVideoType();
        }
    }

    public void checkBigVideoType() {
        if (this.cUa != null) {
            this.cUa.checkBigVideoType();
        }
    }

    public static d a(DataRes dataRes) {
        d dVar = null;
        if (dataRes != null) {
            dVar = new d();
            dVar.ks(dataRes.is_guest.intValue());
            dVar.a(ChannelInfo.parse(dataRes.channel));
            if (dataRes.video != null) {
                dVar.a(g.a(dataRes.video.page));
                dVar.a(h.aZ(dataRes.video.list));
            }
        }
        return dVar;
    }
}
