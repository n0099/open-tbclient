package com.baidu.tieba.channel.data;

import tbclient.ChannelPage;
/* loaded from: classes3.dex */
public class g {
    private int dcY;
    private int dcZ;
    private int totalCount;

    public boolean isHasMore() {
        return this.dcY == 1;
    }

    public void setHasMore(int i) {
        this.dcY = i;
    }

    public void setTotalCount(int i) {
        this.totalCount = i;
    }

    public void lJ(int i) {
        this.dcZ = i;
    }

    public static g a(ChannelPage channelPage) {
        if (channelPage == null) {
            return null;
        }
        g gVar = new g();
        gVar.lJ(channelPage.total_page.intValue());
        gVar.setHasMore(channelPage.has_more.intValue());
        gVar.setTotalCount(channelPage.total_count.intValue());
        return gVar;
    }
}
