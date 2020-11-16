package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes20.dex */
public class m implements q {
    public static final BdUniqueId jQH = BdUniqueId.gen();
    public String ezs;
    public long fid;
    public String fname;
    public String jPz;
    private boolean jQI = false;
    public long jQJ;
    public long postId;
    public long replyNum;
    public String summary;
    public String tid;
    public String title;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jQH;
    }

    public boolean cMQ() {
        return this.jQI;
    }
}
