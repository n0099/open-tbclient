package com.baidu.tieba.channel.data;

import tbclient.GetChannelInfo.DataRes;
/* loaded from: classes6.dex */
public class d {
    private int eSe = 1;
    private g eSf;
    private ChannelInfo eSg;
    private ChannelHomeVideoList<h> eSh;

    public g bbh() {
        return this.eSf;
    }

    public boolean bbi() {
        return this.eSh == null || this.eSh.size() == 0;
    }

    public void a(g gVar) {
        this.eSf = gVar;
    }

    public ChannelInfo bbj() {
        return this.eSg;
    }

    public void a(ChannelInfo channelInfo) {
        this.eSg = channelInfo;
    }

    public ChannelHomeVideoList<h> bbk() {
        return this.eSh;
    }

    public void a(ChannelHomeVideoList<h> channelHomeVideoList) {
        this.eSh = channelHomeVideoList;
    }

    public boolean isHost() {
        return this.eSe == 0;
    }

    public void oU(int i) {
        this.eSe = i;
    }

    public boolean bbl() {
        return this.eSf != null && this.eSf.isHasMore();
    }

    public void b(ChannelHomeVideoList<h> channelHomeVideoList) {
        if (this.eSh != null && channelHomeVideoList != null) {
            this.eSh.addAll(channelHomeVideoList);
            checkBigVideoType();
        }
    }

    public void checkBigVideoType() {
        if (this.eSh != null) {
            this.eSh.checkBigVideoType();
        }
    }

    public static d a(DataRes dataRes) {
        d dVar = null;
        if (dataRes != null) {
            dVar = new d();
            dVar.oU(dataRes.is_guest.intValue());
            dVar.a(ChannelInfo.parse(dataRes.channel));
            if (dataRes.video != null) {
                dVar.a(g.a(dataRes.video.page));
                dVar.a(h.bM(dataRes.video.list));
            }
        }
        return dVar;
    }
}
