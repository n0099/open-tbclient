package com.baidu.tieba.channel.data;

import tbclient.GetChannelInfo.DataRes;
/* loaded from: classes6.dex */
public class d {
    private int enT = 1;
    private g enU;
    private ChannelInfo enV;
    private ChannelHomeVideoList<h> enW;

    public g aRo() {
        return this.enU;
    }

    public boolean aRp() {
        return this.enW == null || this.enW.size() == 0;
    }

    public void a(g gVar) {
        this.enU = gVar;
    }

    public ChannelInfo aRq() {
        return this.enV;
    }

    public void a(ChannelInfo channelInfo) {
        this.enV = channelInfo;
    }

    public ChannelHomeVideoList<h> aRr() {
        return this.enW;
    }

    public void a(ChannelHomeVideoList<h> channelHomeVideoList) {
        this.enW = channelHomeVideoList;
    }

    public boolean isHost() {
        return this.enT == 0;
    }

    public void ou(int i) {
        this.enT = i;
    }

    public boolean aRs() {
        return this.enU != null && this.enU.isHasMore();
    }

    public void b(ChannelHomeVideoList<h> channelHomeVideoList) {
        if (this.enW != null && channelHomeVideoList != null) {
            this.enW.addAll(channelHomeVideoList);
            checkBigVideoType();
        }
    }

    public void checkBigVideoType() {
        if (this.enW != null) {
            this.enW.checkBigVideoType();
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
