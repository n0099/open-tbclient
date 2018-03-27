package com.baidu.tieba.channel.data;

import tbclient.GetChannelInfo.DataRes;
/* loaded from: classes3.dex */
public class d {
    private int dcK = 1;
    private g dcL;
    private ChannelInfo dcM;
    private ChannelHomeVideoList<h> dcN;

    public g amh() {
        return this.dcL;
    }

    public boolean ami() {
        return this.dcN == null || this.dcN.size() == 0;
    }

    public void a(g gVar) {
        this.dcL = gVar;
    }

    public ChannelInfo amj() {
        return this.dcM;
    }

    public void a(ChannelInfo channelInfo) {
        this.dcM = channelInfo;
    }

    public ChannelHomeVideoList<h> amk() {
        return this.dcN;
    }

    public void a(ChannelHomeVideoList<h> channelHomeVideoList) {
        this.dcN = channelHomeVideoList;
    }

    public boolean isHost() {
        return this.dcK == 0;
    }

    public void lI(int i) {
        this.dcK = i;
    }

    public boolean aml() {
        return this.dcL != null && this.dcL.isHasMore();
    }

    public void b(ChannelHomeVideoList<h> channelHomeVideoList) {
        if (this.dcN != null && channelHomeVideoList != null) {
            this.dcN.addAll(channelHomeVideoList);
            checkBigVideoType();
        }
    }

    public void checkBigVideoType() {
        if (this.dcN != null) {
            this.dcN.checkBigVideoType();
        }
    }

    public static d a(DataRes dataRes) {
        d dVar = null;
        if (dataRes != null) {
            dVar = new d();
            dVar.lI(dataRes.is_guest.intValue());
            dVar.a(ChannelInfo.parse(dataRes.channel));
            if (dataRes.video != null) {
                dVar.a(g.a(dataRes.video.page));
                dVar.a(h.aJ(dataRes.video.list));
            }
        }
        return dVar;
    }
}
