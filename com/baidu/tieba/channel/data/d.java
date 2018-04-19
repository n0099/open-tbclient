package com.baidu.tieba.channel.data;

import tbclient.GetChannelInfo.DataRes;
/* loaded from: classes3.dex */
public class d {
    private int cuD = 1;
    private g cuE;
    private ChannelInfo cuF;
    private ChannelHomeVideoList<h> cuG;

    public g agh() {
        return this.cuE;
    }

    public boolean agi() {
        return this.cuG == null || this.cuG.size() == 0;
    }

    public void a(g gVar) {
        this.cuE = gVar;
    }

    public ChannelInfo agj() {
        return this.cuF;
    }

    public void a(ChannelInfo channelInfo) {
        this.cuF = channelInfo;
    }

    public ChannelHomeVideoList<h> agk() {
        return this.cuG;
    }

    public void a(ChannelHomeVideoList<h> channelHomeVideoList) {
        this.cuG = channelHomeVideoList;
    }

    public boolean isHost() {
        return this.cuD == 0;
    }

    public void iS(int i) {
        this.cuD = i;
    }

    public boolean agl() {
        return this.cuE != null && this.cuE.isHasMore();
    }

    public void b(ChannelHomeVideoList<h> channelHomeVideoList) {
        if (this.cuG != null && channelHomeVideoList != null) {
            this.cuG.addAll(channelHomeVideoList);
            checkBigVideoType();
        }
    }

    public void checkBigVideoType() {
        if (this.cuG != null) {
            this.cuG.checkBigVideoType();
        }
    }

    public static d a(DataRes dataRes) {
        d dVar = null;
        if (dataRes != null) {
            dVar = new d();
            dVar.iS(dataRes.is_guest.intValue());
            dVar.a(ChannelInfo.parse(dataRes.channel));
            if (dataRes.video != null) {
                dVar.a(g.a(dataRes.video.page));
                dVar.a(h.aE(dataRes.video.list));
            }
        }
        return dVar;
    }
}
