package com.baidu.tieba.channel.data;

import tbclient.GetChannelInfo.DataRes;
/* loaded from: classes6.dex */
public class d {
    private int eIA = 1;
    private g eIB;
    private ChannelInfo eIC;
    private ChannelHomeVideoList<h> eID;

    public g baz() {
        return this.eIB;
    }

    public boolean baA() {
        return this.eID == null || this.eID.size() == 0;
    }

    public void a(g gVar) {
        this.eIB = gVar;
    }

    public ChannelInfo baB() {
        return this.eIC;
    }

    public void a(ChannelInfo channelInfo) {
        this.eIC = channelInfo;
    }

    public ChannelHomeVideoList<h> baC() {
        return this.eID;
    }

    public void a(ChannelHomeVideoList<h> channelHomeVideoList) {
        this.eID = channelHomeVideoList;
    }

    public boolean isHost() {
        return this.eIA == 0;
    }

    public void pO(int i) {
        this.eIA = i;
    }

    public boolean baD() {
        return this.eIB != null && this.eIB.isHasMore();
    }

    public void b(ChannelHomeVideoList<h> channelHomeVideoList) {
        if (this.eID != null && channelHomeVideoList != null) {
            this.eID.addAll(channelHomeVideoList);
            checkBigVideoType();
        }
    }

    public void checkBigVideoType() {
        if (this.eID != null) {
            this.eID.checkBigVideoType();
        }
    }

    public static d a(DataRes dataRes) {
        d dVar = null;
        if (dataRes != null) {
            dVar = new d();
            dVar.pO(dataRes.is_guest.intValue());
            dVar.a(ChannelInfo.parse(dataRes.channel));
            if (dataRes.video != null) {
                dVar.a(g.a(dataRes.video.page));
                dVar.a(h.bz(dataRes.video.list));
            }
        }
        return dVar;
    }
}
