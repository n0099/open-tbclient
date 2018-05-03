package com.baidu.tieba.channel.data;

import tbclient.GetChannelInfo.DataRes;
/* loaded from: classes3.dex */
public class d {
    private int cuA = 1;
    private g cuB;
    private ChannelInfo cuC;
    private ChannelHomeVideoList<h> cuD;

    public g agh() {
        return this.cuB;
    }

    public boolean agi() {
        return this.cuD == null || this.cuD.size() == 0;
    }

    public void a(g gVar) {
        this.cuB = gVar;
    }

    public ChannelInfo agj() {
        return this.cuC;
    }

    public void a(ChannelInfo channelInfo) {
        this.cuC = channelInfo;
    }

    public ChannelHomeVideoList<h> agk() {
        return this.cuD;
    }

    public void a(ChannelHomeVideoList<h> channelHomeVideoList) {
        this.cuD = channelHomeVideoList;
    }

    public boolean isHost() {
        return this.cuA == 0;
    }

    public void iS(int i) {
        this.cuA = i;
    }

    public boolean agl() {
        return this.cuB != null && this.cuB.isHasMore();
    }

    public void b(ChannelHomeVideoList<h> channelHomeVideoList) {
        if (this.cuD != null && channelHomeVideoList != null) {
            this.cuD.addAll(channelHomeVideoList);
            checkBigVideoType();
        }
    }

    public void checkBigVideoType() {
        if (this.cuD != null) {
            this.cuD.checkBigVideoType();
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
