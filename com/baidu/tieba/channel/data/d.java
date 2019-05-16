package com.baidu.tieba.channel.data;

import tbclient.GetChannelInfo.DataRes;
/* loaded from: classes6.dex */
public class d {
    private int eDD = 1;
    private g eDE;
    private ChannelInfo eDF;
    private ChannelHomeVideoList<h> eDG;

    public g aYx() {
        return this.eDE;
    }

    public boolean aYy() {
        return this.eDG == null || this.eDG.size() == 0;
    }

    public void a(g gVar) {
        this.eDE = gVar;
    }

    public ChannelInfo aYz() {
        return this.eDF;
    }

    public void a(ChannelInfo channelInfo) {
        this.eDF = channelInfo;
    }

    public ChannelHomeVideoList<h> aYA() {
        return this.eDG;
    }

    public void a(ChannelHomeVideoList<h> channelHomeVideoList) {
        this.eDG = channelHomeVideoList;
    }

    public boolean isHost() {
        return this.eDD == 0;
    }

    public void py(int i) {
        this.eDD = i;
    }

    public boolean aYB() {
        return this.eDE != null && this.eDE.isHasMore();
    }

    public void b(ChannelHomeVideoList<h> channelHomeVideoList) {
        if (this.eDG != null && channelHomeVideoList != null) {
            this.eDG.addAll(channelHomeVideoList);
            checkBigVideoType();
        }
    }

    public void checkBigVideoType() {
        if (this.eDG != null) {
            this.eDG.checkBigVideoType();
        }
    }

    public static d a(DataRes dataRes) {
        d dVar = null;
        if (dataRes != null) {
            dVar = new d();
            dVar.py(dataRes.is_guest.intValue());
            dVar.a(ChannelInfo.parse(dataRes.channel));
            if (dataRes.video != null) {
                dVar.a(g.a(dataRes.video.page));
                dVar.a(h.bx(dataRes.video.list));
            }
        }
        return dVar;
    }
}
