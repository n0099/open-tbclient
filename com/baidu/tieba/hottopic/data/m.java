package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes7.dex */
public class m implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId kmU = BdUniqueId.gen();
    public String eLw;
    public long fid;
    public String fname;
    public String klL;
    private boolean kmV = false;
    public long kmW;
    public long postId;
    public long replyNum;
    public String summary;
    public String tid;
    public String title;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return kmU;
    }

    public boolean cRu() {
        return this.kmV;
    }
}
