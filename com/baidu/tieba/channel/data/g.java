package com.baidu.tieba.channel.data;

import tbclient.ChannelPage;
/* loaded from: classes6.dex */
public class g {
    private int eIF;
    private int eIG;
    private int totalCount;

    public boolean isHasMore() {
        return this.eIF == 1;
    }

    public void setHasMore(int i) {
        this.eIF = i;
    }

    public void setTotalCount(int i) {
        this.totalCount = i;
    }

    public void pP(int i) {
        this.eIG = i;
    }

    public static g a(ChannelPage channelPage) {
        if (channelPage == null) {
            return null;
        }
        g gVar = new g();
        gVar.pP(channelPage.total_page.intValue());
        gVar.setHasMore(channelPage.has_more.intValue());
        gVar.setTotalCount(channelPage.total_count.intValue());
        return gVar;
    }
}
