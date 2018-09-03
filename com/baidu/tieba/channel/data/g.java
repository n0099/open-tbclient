package com.baidu.tieba.channel.data;

import tbclient.ChannelPage;
/* loaded from: classes3.dex */
public class g {
    private int cEM;
    private int cEN;
    private int totalCount;

    public boolean isHasMore() {
        return this.cEM == 1;
    }

    public void setHasMore(int i) {
        this.cEM = i;
    }

    public void setTotalCount(int i) {
        this.totalCount = i;
    }

    public void jd(int i) {
        this.cEN = i;
    }

    public static g a(ChannelPage channelPage) {
        if (channelPage == null) {
            return null;
        }
        g gVar = new g();
        gVar.jd(channelPage.total_page.intValue());
        gVar.setHasMore(channelPage.has_more.intValue());
        gVar.setTotalCount(channelPage.total_count.intValue());
        return gVar;
    }
}
