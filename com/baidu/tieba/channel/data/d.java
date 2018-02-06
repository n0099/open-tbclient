package com.baidu.tieba.channel.data;

import tbclient.GetChannelInfo.DataRes;
/* loaded from: classes3.dex */
public class d {
    private int dcT = 1;
    private g dcU;
    private ChannelInfo dcV;
    private ChannelHomeVideoList<h> dcW;

    public g amh() {
        return this.dcU;
    }

    public boolean ami() {
        return this.dcW == null || this.dcW.size() == 0;
    }

    public void a(g gVar) {
        this.dcU = gVar;
    }

    public ChannelInfo amj() {
        return this.dcV;
    }

    public void a(ChannelInfo channelInfo) {
        this.dcV = channelInfo;
    }

    public ChannelHomeVideoList<h> amk() {
        return this.dcW;
    }

    public void a(ChannelHomeVideoList<h> channelHomeVideoList) {
        this.dcW = channelHomeVideoList;
    }

    public boolean isHost() {
        return this.dcT == 0;
    }

    public void lI(int i) {
        this.dcT = i;
    }

    public boolean aml() {
        return this.dcU != null && this.dcU.isHasMore();
    }

    public void b(ChannelHomeVideoList<h> channelHomeVideoList) {
        if (this.dcW != null && channelHomeVideoList != null) {
            this.dcW.addAll(channelHomeVideoList);
            checkBigVideoType();
        }
    }

    public void checkBigVideoType() {
        if (this.dcW != null) {
            this.dcW.checkBigVideoType();
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
