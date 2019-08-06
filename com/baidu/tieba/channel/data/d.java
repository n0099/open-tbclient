package com.baidu.tieba.channel.data;

import tbclient.GetChannelInfo.DataRes;
/* loaded from: classes6.dex */
public class d {
    private int eIH = 1;
    private g eII;
    private ChannelInfo eIJ;
    private ChannelHomeVideoList<h> eIK;

    public g baB() {
        return this.eII;
    }

    public boolean baC() {
        return this.eIK == null || this.eIK.size() == 0;
    }

    public void a(g gVar) {
        this.eII = gVar;
    }

    public ChannelInfo baD() {
        return this.eIJ;
    }

    public void a(ChannelInfo channelInfo) {
        this.eIJ = channelInfo;
    }

    public ChannelHomeVideoList<h> baE() {
        return this.eIK;
    }

    public void a(ChannelHomeVideoList<h> channelHomeVideoList) {
        this.eIK = channelHomeVideoList;
    }

    public boolean isHost() {
        return this.eIH == 0;
    }

    public void pP(int i) {
        this.eIH = i;
    }

    public boolean baF() {
        return this.eII != null && this.eII.isHasMore();
    }

    public void b(ChannelHomeVideoList<h> channelHomeVideoList) {
        if (this.eIK != null && channelHomeVideoList != null) {
            this.eIK.addAll(channelHomeVideoList);
            checkBigVideoType();
        }
    }

    public void checkBigVideoType() {
        if (this.eIK != null) {
            this.eIK.checkBigVideoType();
        }
    }

    public static d a(DataRes dataRes) {
        d dVar = null;
        if (dataRes != null) {
            dVar = new d();
            dVar.pP(dataRes.is_guest.intValue());
            dVar.a(ChannelInfo.parse(dataRes.channel));
            if (dataRes.video != null) {
                dVar.a(g.a(dataRes.video.page));
                dVar.a(h.bz(dataRes.video.list));
            }
        }
        return dVar;
    }
}
