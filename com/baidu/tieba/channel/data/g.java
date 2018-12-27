package com.baidu.tieba.channel.data;

import tbclient.ChannelPage;
/* loaded from: classes3.dex */
public class g {
    private int ddD;
    private int ddE;
    private int totalCount;

    public boolean isHasMore() {
        return this.ddD == 1;
    }

    public void setHasMore(int i) {
        this.ddD = i;
    }

    public void setTotalCount(int i) {
        this.totalCount = i;
    }

    public void kW(int i) {
        this.ddE = i;
    }

    public static g a(ChannelPage channelPage) {
        if (channelPage == null) {
            return null;
        }
        g gVar = new g();
        gVar.kW(channelPage.total_page.intValue());
        gVar.setHasMore(channelPage.has_more.intValue());
        gVar.setTotalCount(channelPage.total_count.intValue());
        return gVar;
    }
}
