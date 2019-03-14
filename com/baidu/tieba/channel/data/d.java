package com.baidu.tieba.channel.data;

import tbclient.GetChannelInfo.DataRes;
/* loaded from: classes6.dex */
public class d {
    private int eoi = 1;
    private g eoj;
    private ChannelInfo eok;
    private ChannelHomeVideoList<h> eol;

    public g aRq() {
        return this.eoj;
    }

    public boolean aRr() {
        return this.eol == null || this.eol.size() == 0;
    }

    public void a(g gVar) {
        this.eoj = gVar;
    }

    public ChannelInfo aRs() {
        return this.eok;
    }

    public void a(ChannelInfo channelInfo) {
        this.eok = channelInfo;
    }

    public ChannelHomeVideoList<h> aRt() {
        return this.eol;
    }

    public void a(ChannelHomeVideoList<h> channelHomeVideoList) {
        this.eol = channelHomeVideoList;
    }

    public boolean isHost() {
        return this.eoi == 0;
    }

    public void oy(int i) {
        this.eoi = i;
    }

    public boolean aRu() {
        return this.eoj != null && this.eoj.isHasMore();
    }

    public void b(ChannelHomeVideoList<h> channelHomeVideoList) {
        if (this.eol != null && channelHomeVideoList != null) {
            this.eol.addAll(channelHomeVideoList);
            checkBigVideoType();
        }
    }

    public void checkBigVideoType() {
        if (this.eol != null) {
            this.eol.checkBigVideoType();
        }
    }

    public static d a(DataRes dataRes) {
        d dVar = null;
        if (dataRes != null) {
            dVar = new d();
            dVar.oy(dataRes.is_guest.intValue());
            dVar.a(ChannelInfo.parse(dataRes.channel));
            if (dataRes.video != null) {
                dVar.a(g.a(dataRes.video.page));
                dVar.a(h.br(dataRes.video.list));
            }
        }
        return dVar;
    }
}
