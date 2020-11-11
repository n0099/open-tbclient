package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes21.dex */
public class m implements q {
    public static final BdUniqueId jPX = BdUniqueId.gen();
    public String eBb;
    public long fid;
    public String fname;
    public String jOP;
    private boolean jPY = false;
    public long jPZ;
    public long postId;
    public long replyNum;
    public String summary;
    public String tid;
    public String title;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jPX;
    }

    public boolean cNj() {
        return this.jPY;
    }
}
