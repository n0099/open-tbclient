package com.baidu.tieba.channel.data;

import tbclient.GetChannelInfo.DataRes;
/* loaded from: classes6.dex */
public class d {
    private int eDE = 1;
    private g eDF;
    private ChannelInfo eDG;
    private ChannelHomeVideoList<h> eDH;

    public g aYA() {
        return this.eDF;
    }

    public boolean aYB() {
        return this.eDH == null || this.eDH.size() == 0;
    }

    public void a(g gVar) {
        this.eDF = gVar;
    }

    public ChannelInfo aYC() {
        return this.eDG;
    }

    public void a(ChannelInfo channelInfo) {
        this.eDG = channelInfo;
    }

    public ChannelHomeVideoList<h> aYD() {
        return this.eDH;
    }

    public void a(ChannelHomeVideoList<h> channelHomeVideoList) {
        this.eDH = channelHomeVideoList;
    }

    public boolean isHost() {
        return this.eDE == 0;
    }

    public void py(int i) {
        this.eDE = i;
    }

    public boolean aYE() {
        return this.eDF != null && this.eDF.isHasMore();
    }

    public void b(ChannelHomeVideoList<h> channelHomeVideoList) {
        if (this.eDH != null && channelHomeVideoList != null) {
            this.eDH.addAll(channelHomeVideoList);
            checkBigVideoType();
        }
    }

    public void checkBigVideoType() {
        if (this.eDH != null) {
            this.eDH.checkBigVideoType();
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
