package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes8.dex */
public class m implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId kvp = BdUniqueId.gen();
    public String eNI;
    public long fid;
    public String fname;
    public String kug;
    private boolean kvq = false;
    public long kvr;
    public long postId;
    public long replyNum;
    public String summary;
    public String tid;
    public String title;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return kvp;
    }

    public boolean cTA() {
        return this.kvq;
    }
}
