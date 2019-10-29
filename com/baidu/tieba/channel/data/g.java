package com.baidu.tieba.channel.data;

import tbclient.ChannelPage;
/* loaded from: classes6.dex */
public class g {
    private int eTa;
    private int eTb;
    private int totalCount;

    public boolean isHasMore() {
        return this.eTa == 1;
    }

    public void setHasMore(int i) {
        this.eTa = i;
    }

    public void setTotalCount(int i) {
        this.totalCount = i;
    }

    public void oW(int i) {
        this.eTb = i;
    }

    public static g a(ChannelPage channelPage) {
        if (channelPage == null) {
            return null;
        }
        g gVar = new g();
        gVar.oW(channelPage.total_page.intValue());
        gVar.setHasMore(channelPage.has_more.intValue());
        gVar.setTotalCount(channelPage.total_count.intValue());
        return gVar;
    }
}
