package com.baidu.tieba.channel.data;

import tbclient.ChannelPage;
/* loaded from: classes3.dex */
public class g {
    private int daL;
    private int daM;
    private int totalCount;

    public boolean isHasMore() {
        return this.daL == 1;
    }

    public void setHasMore(int i) {
        this.daL = i;
    }

    public void setTotalCount(int i) {
        this.totalCount = i;
    }

    public void kJ(int i) {
        this.daM = i;
    }

    public static g a(ChannelPage channelPage) {
        if (channelPage == null) {
            return null;
        }
        g gVar = new g();
        gVar.kJ(channelPage.total_page.intValue());
        gVar.setHasMore(channelPage.has_more.intValue());
        gVar.setTotalCount(channelPage.total_count.intValue());
        return gVar;
    }
}
