package com.baidu.tieba.channel.data;

import tbclient.ChannelPage;
/* loaded from: classes3.dex */
public class g {
    private int cSW;
    private int cSX;
    private int totalCount;

    public boolean isHasMore() {
        return this.cSW == 1;
    }

    public void setHasMore(int i) {
        this.cSW = i;
    }

    public void setTotalCount(int i) {
        this.totalCount = i;
    }

    public void ka(int i) {
        this.cSX = i;
    }

    public static g a(ChannelPage channelPage) {
        if (channelPage == null) {
            return null;
        }
        g gVar = new g();
        gVar.ka(channelPage.total_page.intValue());
        gVar.setHasMore(channelPage.has_more.intValue());
        gVar.setTotalCount(channelPage.total_count.intValue());
        return gVar;
    }
}
