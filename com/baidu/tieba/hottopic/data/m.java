package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes15.dex */
public class m implements q {
    public static final BdUniqueId iZW = BdUniqueId.gen();
    public String dYw;
    public long fid;
    public String fname;
    public String iYO;
    private boolean iZX = false;
    public long iZY;
    public long postId;
    public long replyNum;
    public String summary;
    public String tid;
    public String title;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iZW;
    }

    public boolean cAl() {
        return this.iZX;
    }
}
