package com.baidu.tieba.homepage.mygod.data;

import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import tbclient.GodFeed.GodFeedResIdl;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.homepage.recommendfrs.data.c {
    private long csP;
    private int csQ = -1;

    @Override // com.baidu.tieba.homepage.recommendfrs.data.c, com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
        GodFeedResIdl godFeedResIdl;
        if ((message instanceof GodFeedResIdl) && (godFeedResIdl = (GodFeedResIdl) message) != null && godFeedResIdl.error != null && godFeedResIdl.error.errorno.intValue() == 0 && godFeedResIdl.data != null) {
            this.mHasMore = godFeedResIdl.data.has_more.intValue() == 1;
            this.pn = godFeedResIdl.data.pn.intValue();
            this.csP = godFeedResIdl.data.timeline.longValue();
            if (godFeedResIdl.data.thread_list != null) {
                this.cwj = new ArrayList();
                this.cwj.addAll(godFeedResIdl.data.thread_list);
            }
            this.csQ = godFeedResIdl.data.has_attention_god.intValue();
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

    public long ahs() {
        return this.csP;
    }

    public int aht() {
        return this.csQ;
    }
}
