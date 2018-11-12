package com.baidu.tieba.channel.data;

import tbclient.ChannelPage;
/* loaded from: classes3.dex */
public class g {
    private int cUc;
    private int cUd;
    private int totalCount;

    public boolean isHasMore() {
        return this.cUc == 1;
    }

    public void setHasMore(int i) {
        this.cUc = i;
    }

    public void setTotalCount(int i) {
        this.totalCount = i;
    }

    public void kt(int i) {
        this.cUd = i;
    }

    public static g a(ChannelPage channelPage) {
        if (channelPage == null) {
            return null;
        }
        g gVar = new g();
        gVar.kt(channelPage.total_page.intValue());
        gVar.setHasMore(channelPage.has_more.intValue());
        gVar.setTotalCount(channelPage.total_count.intValue());
        return gVar;
    }
}
