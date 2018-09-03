package com.baidu.tieba.channel.data;

import tbclient.GetChannelInfo.DataRes;
/* loaded from: classes3.dex */
public class d {
    private int cEH = 1;
    private g cEI;
    private ChannelInfo cEJ;
    private ChannelHomeVideoList<h> cEK;

    public g ajK() {
        return this.cEI;
    }

    public boolean ajL() {
        return this.cEK == null || this.cEK.size() == 0;
    }

    public void a(g gVar) {
        this.cEI = gVar;
    }

    public ChannelInfo ajM() {
        return this.cEJ;
    }

    public void a(ChannelInfo channelInfo) {
        this.cEJ = channelInfo;
    }

    public ChannelHomeVideoList<h> ajN() {
        return this.cEK;
    }

    public void a(ChannelHomeVideoList<h> channelHomeVideoList) {
        this.cEK = channelHomeVideoList;
    }

    public boolean isHost() {
        return this.cEH == 0;
    }

    public void jc(int i) {
        this.cEH = i;
    }

    public boolean ajO() {
        return this.cEI != null && this.cEI.isHasMore();
    }

    public void b(ChannelHomeVideoList<h> channelHomeVideoList) {
        if (this.cEK != null && channelHomeVideoList != null) {
            this.cEK.addAll(channelHomeVideoList);
            checkBigVideoType();
        }
    }

    public void checkBigVideoType() {
        if (this.cEK != null) {
            this.cEK.checkBigVideoType();
        }
    }

    public static d a(DataRes dataRes) {
        d dVar = null;
        if (dataRes != null) {
            dVar = new d();
            dVar.jc(dataRes.is_guest.intValue());
            dVar.a(ChannelInfo.parse(dataRes.channel));
            if (dataRes.video != null) {
                dVar.a(g.a(dataRes.video.page));
                dVar.a(h.aK(dataRes.video.list));
            }
        }
        return dVar;
    }
}
