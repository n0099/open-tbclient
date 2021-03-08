package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes7.dex */
public class m implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId kxr = BdUniqueId.gen();
    public String ePj;
    public long fid;
    public String fname;
    public String kwi;
    private boolean kxs = false;
    public long kxt;
    public long postId;
    public long replyNum;
    public String summary;
    public String tid;
    public String title;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return kxr;
    }

    public boolean cTH() {
        return this.kxs;
    }
}
