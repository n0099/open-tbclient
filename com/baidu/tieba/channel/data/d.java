package com.baidu.tieba.channel.data;

import tbclient.GetChannelInfo.DataRes;
/* loaded from: classes6.dex */
public class d {
    private int eSV = 1;
    private g eSW;
    private ChannelInfo eSX;
    private ChannelHomeVideoList<h> eSY;

    public g bbj() {
        return this.eSW;
    }

    public boolean bbk() {
        return this.eSY == null || this.eSY.size() == 0;
    }

    public void a(g gVar) {
        this.eSW = gVar;
    }

    public ChannelInfo bbl() {
        return this.eSX;
    }

    public void a(ChannelInfo channelInfo) {
        this.eSX = channelInfo;
    }

    public ChannelHomeVideoList<h> bbm() {
        return this.eSY;
    }

    public void a(ChannelHomeVideoList<h> channelHomeVideoList) {
        this.eSY = channelHomeVideoList;
    }

    public boolean isHost() {
        return this.eSV == 0;
    }

    public void oV(int i) {
        this.eSV = i;
    }

    public boolean bbn() {
        return this.eSW != null && this.eSW.isHasMore();
    }

    public void b(ChannelHomeVideoList<h> channelHomeVideoList) {
        if (this.eSY != null && channelHomeVideoList != null) {
            this.eSY.addAll(channelHomeVideoList);
            checkBigVideoType();
        }
    }

    public void checkBigVideoType() {
        if (this.eSY != null) {
            this.eSY.checkBigVideoType();
        }
    }

    public static d a(DataRes dataRes) {
        d dVar = null;
        if (dataRes != null) {
            dVar = new d();
            dVar.oV(dataRes.is_guest.intValue());
            dVar.a(ChannelInfo.parse(dataRes.channel));
            if (dataRes.video != null) {
                dVar.a(g.a(dataRes.video.page));
                dVar.a(h.bM(dataRes.video.list));
            }
        }
        return dVar;
    }
}
