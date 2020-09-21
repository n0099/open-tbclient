package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes20.dex */
public class m implements q {
    public static final BdUniqueId jiC = BdUniqueId.gen();
    public String eaG;
    public long fid;
    public String fname;
    public String jht;
    private boolean jiD = false;
    public long jiE;
    public long postId;
    public long replyNum;
    public String summary;
    public String tid;
    public String title;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jiC;
    }

    public boolean cDS() {
        return this.jiD;
    }
}
