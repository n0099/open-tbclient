package com.baidu.tieba.homepage.topic.topicdetail.b;

import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes4.dex */
public class b {
    public long bHD;
    public String bHE;
    public String gfo;
    public String gfp;
    public com.baidu.tieba.homepage.topic.topictab.b.b gfq;
    public f gfr;
    public long topicId;

    public void a(TopicDetail topicDetail) {
        if (topicDetail != null) {
            this.topicId = topicDetail.topic_id.longValue();
            this.bHE = topicDetail.topic_desc;
            this.bHD = topicDetail.discuss_num.longValue();
            this.gfo = topicDetail.topic_image;
            this.gfp = topicDetail.bg_image;
        }
    }

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.gfq = new com.baidu.tieba.homepage.topic.topictab.b.b();
            this.gfq.topicId = this.topicId;
            this.gfq.from = 2;
            this.gfq.b(pkModule);
        }
    }

    public void a(TimeLine timeLine) {
        if (timeLine != null) {
            this.gfr = new f();
            this.gfr.a(this.topicId, timeLine);
        }
    }
}
