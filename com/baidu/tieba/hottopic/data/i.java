package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
import tbclient.Hottopic.CommonThread;
import tbclient.Hottopic.GoodThread;
/* loaded from: classes.dex */
public class i implements u {
    public static final BdUniqueId bHV = BdUniqueId.gen();
    public long WH;
    private boolean bHI = false;
    public long bHW;
    public long bHX;
    public String bHY;
    public String bHa;
    public String fname;
    public long postId;
    public String summary;
    public String tid;
    public String title;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return bHV;
    }

    public boolean VD() {
        return this.bHI;
    }

    public void a(CommonThread commonThread) {
        if (commonThread != null) {
            this.bHI = true;
            this.bHa = commonThread.module_name;
        }
    }

    public void a(GoodThread goodThread) {
        if (goodThread != null) {
            this.bHI = false;
            this.tid = String.valueOf(goodThread.tid);
            this.title = goodThread.title;
            this.bHW = goodThread.reply_num.longValue();
            this.summary = goodThread._abstract;
            this.bHX = goodThread.zan_num.longValue();
            this.fname = goodThread.fname;
            this.WH = goodThread.fid.longValue();
            this.postId = goodThread.post_id.longValue();
            this.bHY = goodThread.head_pic;
        }
    }
}
