package com.baidu.tieba.channel.data;

import tbclient.ChannelPage;
/* loaded from: classes3.dex */
public class g {
    private int dep;
    private int deq;
    private int totalCount;

    public boolean isHasMore() {
        return this.dep == 1;
    }

    public void setHasMore(int i) {
        this.dep = i;
    }

    public void setTotalCount(int i) {
        this.totalCount = i;
    }

    public void kX(int i) {
        this.deq = i;
    }

    public static g a(ChannelPage channelPage) {
        if (channelPage == null) {
            return null;
        }
        g gVar = new g();
        gVar.kX(channelPage.total_page.intValue());
        gVar.setHasMore(channelPage.has_more.intValue());
        gVar.setTotalCount(channelPage.total_count.intValue());
        return gVar;
    }
}
