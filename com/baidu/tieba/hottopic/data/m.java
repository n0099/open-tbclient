package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes8.dex */
public class m implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId kvb = BdUniqueId.gen();
    public String eNI;
    public long fid;
    public String fname;
    public String ktS;
    private boolean kvc = false;
    public long kvd;
    public long postId;
    public long replyNum;
    public String summary;
    public String tid;
    public String title;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return kvb;
    }

    public boolean cTt() {
        return this.kvc;
    }
}
