package com.baidu.tieba.channel.data;

import tbclient.ChannelPage;
/* loaded from: classes3.dex */
public class g {
    private int cEr;
    private int cEs;
    private int totalCount;

    public boolean isHasMore() {
        return this.cEr == 1;
    }

    public void setHasMore(int i) {
        this.cEr = i;
    }

    public void setTotalCount(int i) {
        this.totalCount = i;
    }

    public void iU(int i) {
        this.cEs = i;
    }

    public static g a(ChannelPage channelPage) {
        if (channelPage == null) {
            return null;
        }
        g gVar = new g();
        gVar.iU(channelPage.total_page.intValue());
        gVar.setHasMore(channelPage.has_more.intValue());
        gVar.setTotalCount(channelPage.total_count.intValue());
        return gVar;
    }
}
