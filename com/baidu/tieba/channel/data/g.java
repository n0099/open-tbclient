package com.baidu.tieba.channel.data;

import tbclient.ChannelPage;
/* loaded from: classes6.dex */
public class g {
    private int eDJ;
    private int eDK;
    private int totalCount;

    public boolean isHasMore() {
        return this.eDJ == 1;
    }

    public void setHasMore(int i) {
        this.eDJ = i;
    }

    public void setTotalCount(int i) {
        this.totalCount = i;
    }

    public void pz(int i) {
        this.eDK = i;
    }

    public static g a(ChannelPage channelPage) {
        if (channelPage == null) {
            return null;
        }
        g gVar = new g();
        gVar.pz(channelPage.total_page.intValue());
        gVar.setHasMore(channelPage.has_more.intValue());
        gVar.setTotalCount(channelPage.total_count.intValue());
        return gVar;
    }
}
