package com.baidu.tieba.channel.data;

import tbclient.ChannelPage;
/* loaded from: classes3.dex */
public class g {
    private int cuF;
    private int cuG;
    private int totalCount;

    public boolean isHasMore() {
        return this.cuF == 1;
    }

    public void setHasMore(int i) {
        this.cuF = i;
    }

    public void setTotalCount(int i) {
        this.totalCount = i;
    }

    public void iT(int i) {
        this.cuG = i;
    }

    public static g a(ChannelPage channelPage) {
        if (channelPage == null) {
            return null;
        }
        g gVar = new g();
        gVar.iT(channelPage.total_page.intValue());
        gVar.setHasMore(channelPage.has_more.intValue());
        gVar.setTotalCount(channelPage.total_count.intValue());
        return gVar;
    }
}
