package com.baidu.tieba.homepage.topic.topicdetail.b;

import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes4.dex */
public class b {
    public long bHD;
    public String bHE;
    public String gfp;
    public String gfq;
    public com.baidu.tieba.homepage.topic.topictab.b.b gfr;
    public f gfs;
    public long topicId;

    public void a(TopicDetail topicDetail) {
        if (topicDetail != null) {
            this.topicId = topicDetail.topic_id.longValue();
            this.bHE = topicDetail.topic_desc;
            this.bHD = topicDetail.discuss_num.longValue();
            this.gfp = topicDetail.topic_image;
            this.gfq = topicDetail.bg_image;
        }
    }

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.gfr = new com.baidu.tieba.homepage.topic.topictab.b.b();
            this.gfr.topicId = this.topicId;
            this.gfr.from = 2;
            this.gfr.b(pkModule);
        }
    }

    public void a(TimeLine timeLine) {
        if (timeLine != null) {
            this.gfs = new f();
            this.gfs.a(this.topicId, timeLine);
        }
    }
}
