package com.baidu.tieba.channel.data;

import tbclient.ChannelPage;
/* loaded from: classes6.dex */
public class g {
    private int eIM;
    private int eIN;
    private int totalCount;

    public boolean isHasMore() {
        return this.eIM == 1;
    }

    public void setHasMore(int i) {
        this.eIM = i;
    }

    public void setTotalCount(int i) {
        this.totalCount = i;
    }

    public void pQ(int i) {
        this.eIN = i;
    }

    public static g a(ChannelPage channelPage) {
        if (channelPage == null) {
            return null;
        }
        g gVar = new g();
        gVar.pQ(channelPage.total_page.intValue());
        gVar.setHasMore(channelPage.has_more.intValue());
        gVar.setTotalCount(channelPage.total_count.intValue());
        return gVar;
    }
}
