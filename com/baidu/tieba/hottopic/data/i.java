package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
import tbclient.Hottopic.CommonThread;
import tbclient.Hottopic.GoodThread;
/* loaded from: classes.dex */
public class i implements u {
    public static final BdUniqueId bEs = BdUniqueId.gen();
    public long Wg;
    public long bAH;
    public String bDw;
    private boolean bEf = false;
    public long bEt;
    public String bEu;
    public String fname;
    public long postId;
    public String summary;
    public String tid;
    public String title;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return bEs;
    }

    public boolean UA() {
        return this.bEf;
    }

    public void a(CommonThread commonThread) {
        if (commonThread != null) {
            this.bEf = true;
            this.bDw = commonThread.module_name;
        }
    }

    public void a(GoodThread goodThread) {
        if (goodThread != null) {
            this.bEf = false;
            this.tid = String.valueOf(goodThread.tid);
            this.title = goodThread.title;
            this.bEt = goodThread.reply_num.longValue();
            this.summary = goodThread._abstract;
            this.bAH = goodThread.zan_num.longValue();
            this.fname = goodThread.fname;
            this.Wg = goodThread.fid.longValue();
            this.postId = goodThread.post_id.longValue();
            this.bEu = goodThread.head_pic;
        }
    }
}
