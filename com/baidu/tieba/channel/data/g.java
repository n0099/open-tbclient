package com.baidu.tieba.channel.data;

import tbclient.ChannelPage;
/* loaded from: classes6.dex */
public class g {
    private int eon;
    private int eoo;
    private int totalCount;

    public boolean isHasMore() {
        return this.eon == 1;
    }

    public void setHasMore(int i) {
        this.eon = i;
    }

    public void setTotalCount(int i) {
        this.totalCount = i;
    }

    public void oz(int i) {
        this.eoo = i;
    }

    public static g a(ChannelPage channelPage) {
        if (channelPage == null) {
            return null;
        }
        g gVar = new g();
        gVar.oz(channelPage.total_page.intValue());
        gVar.setHasMore(channelPage.has_more.intValue());
        gVar.setTotalCount(channelPage.total_count.intValue());
        return gVar;
    }
}
