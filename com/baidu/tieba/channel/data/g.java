package com.baidu.tieba.channel.data;

import tbclient.ChannelPage;
/* loaded from: classes6.dex */
public class g {
    private int enY;
    private int enZ;
    private int totalCount;

    public boolean isHasMore() {
        return this.enY == 1;
    }

    public void setHasMore(int i) {
        this.enY = i;
    }

    public void setTotalCount(int i) {
        this.totalCount = i;
    }

    public void ov(int i) {
        this.enZ = i;
    }

    public static g a(ChannelPage channelPage) {
        if (channelPage == null) {
            return null;
        }
        g gVar = new g();
        gVar.ov(channelPage.total_page.intValue());
        gVar.setHasMore(channelPage.has_more.intValue());
        gVar.setTotalCount(channelPage.total_count.intValue());
        return gVar;
    }
}
