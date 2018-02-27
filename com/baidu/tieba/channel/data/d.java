package com.baidu.tieba.channel.data;

import tbclient.GetChannelInfo.DataRes;
/* loaded from: classes3.dex */
public class d {
    private int dcH = 1;
    private g dcI;
    private ChannelInfo dcJ;
    private ChannelHomeVideoList<h> dcK;

    public g amg() {
        return this.dcI;
    }

    public boolean amh() {
        return this.dcK == null || this.dcK.size() == 0;
    }

    public void a(g gVar) {
        this.dcI = gVar;
    }

    public ChannelInfo ami() {
        return this.dcJ;
    }

    public void a(ChannelInfo channelInfo) {
        this.dcJ = channelInfo;
    }

    public ChannelHomeVideoList<h> amj() {
        return this.dcK;
    }

    public void a(ChannelHomeVideoList<h> channelHomeVideoList) {
        this.dcK = channelHomeVideoList;
    }

    public boolean isHost() {
        return this.dcH == 0;
    }

    public void lI(int i) {
        this.dcH = i;
    }

    public boolean amk() {
        return this.dcI != null && this.dcI.isHasMore();
    }

    public void b(ChannelHomeVideoList<h> channelHomeVideoList) {
        if (this.dcK != null && channelHomeVideoList != null) {
            this.dcK.addAll(channelHomeVideoList);
            checkBigVideoType();
        }
    }

    public void checkBigVideoType() {
        if (this.dcK != null) {
            this.dcK.checkBigVideoType();
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
