package com.baidu.tieba.channel.data;

import tbclient.ChannelPage;
/* loaded from: classes6.dex */
public class g {
    private int eSj;
    private int eSk;
    private int totalCount;

    public boolean isHasMore() {
        return this.eSj == 1;
    }

    public void setHasMore(int i) {
        this.eSj = i;
    }

    public void setTotalCount(int i) {
        this.totalCount = i;
    }

    public void oV(int i) {
        this.eSk = i;
    }

    public static g a(ChannelPage channelPage) {
        if (channelPage == null) {
            return null;
        }
        g gVar = new g();
        gVar.oV(channelPage.total_page.intValue());
        gVar.setHasMore(channelPage.has_more.intValue());
        gVar.setTotalCount(channelPage.total_count.intValue());
        return gVar;
    }
}
