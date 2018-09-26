package com.baidu.tieba.channel.data;

import tbclient.ChannelPage;
/* loaded from: classes3.dex */
public class g {
    private int cKD;
    private int cKE;
    private int totalCount;

    public boolean isHasMore() {
        return this.cKD == 1;
    }

    public void setHasMore(int i) {
        this.cKD = i;
    }

    public void setTotalCount(int i) {
        this.totalCount = i;
    }

    public void jC(int i) {
        this.cKE = i;
    }

    public static g a(ChannelPage channelPage) {
        if (channelPage == null) {
            return null;
        }
        g gVar = new g();
        gVar.jC(channelPage.total_page.intValue());
        gVar.setHasMore(channelPage.has_more.intValue());
        gVar.setTotalCount(channelPage.total_count.intValue());
        return gVar;
    }
}
