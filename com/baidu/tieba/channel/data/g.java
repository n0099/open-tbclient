package com.baidu.tieba.channel.data;

import tbclient.ChannelPage;
/* loaded from: classes3.dex */
public class g {
    private int cCk;
    private int cCl;
    private int totalCount;

    public boolean isHasMore() {
        return this.cCk == 1;
    }

    public void setHasMore(int i) {
        this.cCk = i;
    }

    public void setTotalCount(int i) {
        this.totalCount = i;
    }

    public void iS(int i) {
        this.cCl = i;
    }

    public static g a(ChannelPage channelPage) {
        if (channelPage == null) {
            return null;
        }
        g gVar = new g();
        gVar.iS(channelPage.total_page.intValue());
        gVar.setHasMore(channelPage.has_more.intValue());
        gVar.setTotalCount(channelPage.total_count.intValue());
        return gVar;
    }
}
