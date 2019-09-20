package com.baidu.tieba.channel.data;

import tbclient.GetChannelInfo.DataRes;
/* loaded from: classes6.dex */
public class d {
    private int eKq = 1;
    private g eKr;
    private ChannelInfo eKs;
    private ChannelHomeVideoList<h> eKt;

    public g bbf() {
        return this.eKr;
    }

    public boolean bbg() {
        return this.eKt == null || this.eKt.size() == 0;
    }

    public void a(g gVar) {
        this.eKr = gVar;
    }

    public ChannelInfo bbh() {
        return this.eKs;
    }

    public void a(ChannelInfo channelInfo) {
        this.eKs = channelInfo;
    }

    public ChannelHomeVideoList<h> bbi() {
        return this.eKt;
    }

    public void a(ChannelHomeVideoList<h> channelHomeVideoList) {
        this.eKt = channelHomeVideoList;
    }

    public boolean isHost() {
        return this.eKq == 0;
    }

    public void pT(int i) {
        this.eKq = i;
    }

    public boolean bbj() {
        return this.eKr != null && this.eKr.isHasMore();
    }

    public void b(ChannelHomeVideoList<h> channelHomeVideoList) {
        if (this.eKt != null && channelHomeVideoList != null) {
            this.eKt.addAll(channelHomeVideoList);
            checkBigVideoType();
        }
    }

    public void checkBigVideoType() {
        if (this.eKt != null) {
            this.eKt.checkBigVideoType();
        }
    }

    public static d a(DataRes dataRes) {
        d dVar = null;
        if (dataRes != null) {
            dVar = new d();
            dVar.pT(dataRes.is_guest.intValue());
            dVar.a(ChannelInfo.parse(dataRes.channel));
            if (dataRes.video != null) {
                dVar.a(g.a(dataRes.video.page));
                dVar.a(h.bz(dataRes.video.list));
            }
        }
        return dVar;
    }
}
