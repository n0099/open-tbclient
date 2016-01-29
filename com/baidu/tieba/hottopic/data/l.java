package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
import tbclient.Hottopic.CommonThread;
import tbclient.Hottopic.GoodThread;
/* loaded from: classes.dex */
public class l implements u {
    public static final BdUniqueId bLy = BdUniqueId.gen();
    public String bKA;
    public long bLA;
    public long bLB;
    public String bLC;
    private boolean bLz = false;
    public long fid;
    public String fname;
    public long postId;
    public String summary;
    public String tid;
    public String title;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return bLy;
    }

    public boolean XX() {
        return this.bLz;
    }

    public void a(CommonThread commonThread) {
        if (commonThread != null) {
            this.bLz = true;
            this.bKA = commonThread.module_name;
        }
    }

    public void a(GoodThread goodThread) {
        if (goodThread != null) {
            this.bLz = false;
            this.tid = String.valueOf(goodThread.tid);
            this.title = goodThread.title;
            this.bLA = goodThread.reply_num.longValue();
            this.summary = goodThread._abstract;
            this.bLB = goodThread.zan_num.longValue();
            this.fname = goodThread.fname;
            this.fid = goodThread.fid.longValue();
            this.postId = goodThread.post_id.longValue();
            this.bLC = goodThread.head_pic;
        }
    }
}
