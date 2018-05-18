package com.baidu.tieba.channel.data;

import tbclient.ChannelPage;
/* loaded from: classes3.dex */
public class g {
    private int cvO;
    private int cvP;
    private int totalCount;

    public boolean isHasMore() {
        return this.cvO == 1;
    }

    public void setHasMore(int i) {
        this.cvO = i;
    }

    public void setTotalCount(int i) {
        this.totalCount = i;
    }

    public void iS(int i) {
        this.cvP = i;
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
