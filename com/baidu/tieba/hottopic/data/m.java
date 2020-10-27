package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes21.dex */
public class m implements q {
    public static final BdUniqueId jJZ = BdUniqueId.gen();
    public String evi;
    public long fid;
    public String fname;
    public String jIR;
    private boolean jKa = false;
    public long jKb;
    public long postId;
    public long replyNum;
    public String summary;
    public String tid;
    public String title;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jJZ;
    }

    public boolean cKI() {
        return this.jKa;
    }
}
