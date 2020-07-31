package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes15.dex */
public class m implements q {
    public static final BdUniqueId iKQ = BdUniqueId.gen();
    public String dOZ;
    public long fid;
    public String fname;
    public String iJI;
    private boolean iKR = false;
    public long iKS;
    public long postId;
    public long replyNum;
    public String summary;
    public String tid;
    public String title;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iKQ;
    }

    public boolean cpr() {
        return this.iKR;
    }
}
