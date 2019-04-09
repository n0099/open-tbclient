package com.baidu.tieba.channel.data;

import tbclient.GetChannelInfo.DataRes;
/* loaded from: classes6.dex */
public class d {
    private int enU = 1;
    private g enV;
    private ChannelInfo enW;
    private ChannelHomeVideoList<h> enX;

    public g aRo() {
        return this.enV;
    }

    public boolean aRp() {
        return this.enX == null || this.enX.size() == 0;
    }

    public void a(g gVar) {
        this.enV = gVar;
    }

    public ChannelInfo aRq() {
        return this.enW;
    }

    public void a(ChannelInfo channelInfo) {
        this.enW = channelInfo;
    }

    public ChannelHomeVideoList<h> aRr() {
        return this.enX;
    }

    public void a(ChannelHomeVideoList<h> channelHomeVideoList) {
        this.enX = channelHomeVideoList;
    }

    public boolean isHost() {
        return this.enU == 0;
    }

    public void ou(int i) {
        this.enU = i;
    }

    public boolean aRs() {
        return this.enV != null && this.enV.isHasMore();
    }

    public void b(ChannelHomeVideoList<h> channelHomeVideoList) {
        if (this.enX != null && channelHomeVideoList != null) {
            this.enX.addAll(channelHomeVideoList);
            checkBigVideoType();
        }
    }

    public void checkBigVideoType() {
        if (this.enX != null) {
            this.enX.checkBigVideoType();
        }
    }

    public static d a(DataRes dataRes) {
        d dVar = null;
        if (dataRes != null) {
            dVar = new d();
            dVar.ou(dataRes.is_guest.intValue());
            dVar.a(ChannelInfo.parse(dataRes.channel));
            if (dataRes.video != null) {
                dVar.a(g.a(dataRes.video.page));
                dVar.a(h.bp(dataRes.video.list));
            }
        }
        return dVar;
    }
}
