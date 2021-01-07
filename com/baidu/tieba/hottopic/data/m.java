package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes8.dex */
public class m implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId krz = BdUniqueId.gen();
    public String eQh;
    public long fid;
    public String fname;
    public String kqq;
    private boolean krA = false;
    public long krB;
    public long postId;
    public long replyNum;
    public String summary;
    public String tid;
    public String title;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return krz;
    }

    public boolean cVm() {
        return this.krA;
    }
}
