package com.baidu.tieba.channel.data;

import tbclient.GetChannelInfo.DataRes;
/* loaded from: classes3.dex */
public class d {
    private int daG = 1;
    private g daH;
    private ChannelInfo daI;
    private ChannelHomeVideoList<h> daJ;

    public g aqm() {
        return this.daH;
    }

    public boolean aqn() {
        return this.daJ == null || this.daJ.size() == 0;
    }

    public void a(g gVar) {
        this.daH = gVar;
    }

    public ChannelInfo aqo() {
        return this.daI;
    }

    public void a(ChannelInfo channelInfo) {
        this.daI = channelInfo;
    }

    public ChannelHomeVideoList<h> aqp() {
        return this.daJ;
    }

    public void a(ChannelHomeVideoList<h> channelHomeVideoList) {
        this.daJ = channelHomeVideoList;
    }

    public boolean isHost() {
        return this.daG == 0;
    }

    public void kI(int i) {
        this.daG = i;
    }

    public boolean aqq() {
        return this.daH != null && this.daH.isHasMore();
    }

    public void b(ChannelHomeVideoList<h> channelHomeVideoList) {
        if (this.daJ != null && channelHomeVideoList != null) {
            this.daJ.addAll(channelHomeVideoList);
            checkBigVideoType();
        }
    }

    public void checkBigVideoType() {
        if (this.daJ != null) {
            this.daJ.checkBigVideoType();
        }
    }

    public static d a(DataRes dataRes) {
        d dVar = null;
        if (dataRes != null) {
            dVar = new d();
            dVar.kI(dataRes.is_guest.intValue());
            dVar.a(ChannelInfo.parse(dataRes.channel));
            if (dataRes.video != null) {
                dVar.a(g.a(dataRes.video.page));
                dVar.a(h.bb(dataRes.video.list));
            }
        }
        return dVar;
    }
}
