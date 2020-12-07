package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes21.dex */
public class m implements q {
    public static final BdUniqueId kek = BdUniqueId.gen();
    public String eGr;
    public long fid;
    public String fname;
    public String kdc;
    private boolean kel = false;
    public long kem;
    public long postId;
    public long replyNum;
    public String summary;
    public String tid;
    public String title;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kek;
    }

    public boolean cSe() {
        return this.kel;
    }
}
