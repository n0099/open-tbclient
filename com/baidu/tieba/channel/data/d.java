package com.baidu.tieba.channel.data;

import tbclient.GetChannelInfo.DataRes;
/* loaded from: classes3.dex */
public class d {
    private int cvJ = 1;
    private g cvK;
    private ChannelInfo cvL;
    private ChannelHomeVideoList<h> cvM;

    public g agh() {
        return this.cvK;
    }

    public boolean agi() {
        return this.cvM == null || this.cvM.size() == 0;
    }

    public void a(g gVar) {
        this.cvK = gVar;
    }

    public ChannelInfo agj() {
        return this.cvL;
    }

    public void a(ChannelInfo channelInfo) {
        this.cvL = channelInfo;
    }

    public ChannelHomeVideoList<h> agk() {
        return this.cvM;
    }

    public void a(ChannelHomeVideoList<h> channelHomeVideoList) {
        this.cvM = channelHomeVideoList;
    }

    public boolean isHost() {
        return this.cvJ == 0;
    }

    public void iR(int i) {
        this.cvJ = i;
    }

    public boolean agl() {
        return this.cvK != null && this.cvK.isHasMore();
    }

    public void b(ChannelHomeVideoList<h> channelHomeVideoList) {
        if (this.cvM != null && channelHomeVideoList != null) {
            this.cvM.addAll(channelHomeVideoList);
            checkBigVideoType();
        }
    }

    public void checkBigVideoType() {
        if (this.cvM != null) {
            this.cvM.checkBigVideoType();
        }
    }

    public static d a(DataRes dataRes) {
        d dVar = null;
        if (dataRes != null) {
            dVar = new d();
            dVar.iR(dataRes.is_guest.intValue());
            dVar.a(ChannelInfo.parse(dataRes.channel));
            if (dataRes.video != null) {
                dVar.a(g.a(dataRes.video.page));
                dVar.a(h.aH(dataRes.video.list));
            }
        }
        return dVar;
    }
}
