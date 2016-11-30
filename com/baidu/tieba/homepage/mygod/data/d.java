package com.baidu.tieba.homepage.mygod.data;

import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import tbclient.BannerInfo;
import tbclient.GodFeed.GodFeedResIdl;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.homepage.recommendfrs.data.c {
    private long cJU;
    private int cJV = -1;
    private BannerInfo cJW = null;

    @Override // com.baidu.tieba.homepage.recommendfrs.data.c, com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
        GodFeedResIdl godFeedResIdl;
        if ((message instanceof GodFeedResIdl) && (godFeedResIdl = (GodFeedResIdl) message) != null && godFeedResIdl.error != null && godFeedResIdl.error.errorno.intValue() == 0 && godFeedResIdl.data != null) {
            this.mHasMore = godFeedResIdl.data.has_more.intValue() == 1;
            this.pn = godFeedResIdl.data.pn.intValue();
            this.cJU = godFeedResIdl.data.timeline.longValue();
            if (godFeedResIdl.data.thread_list != null) {
                this.cNV = new ArrayList();
                this.cNV.addAll(godFeedResIdl.data.thread_list);
            }
            this.cJV = godFeedResIdl.data.has_attention_god.intValue();
            this.cJW = godFeedResIdl.data.banner_info;
        }
    }

    @Override // com.baidu.tieba.homepage.recommendfrs.data.c, com.baidu.tbadk.mvc.b.b
    public boolean z(byte[] bArr) {
        try {
            a((GodFeedResIdl) new Wire(new Class[0]).parseFrom(bArr, GodFeedResIdl.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public long aop() {
        return this.cJU;
    }

    public int aoq() {
        return this.cJV;
    }

    public BannerInfo aor() {
        return this.cJW;
    }
}
