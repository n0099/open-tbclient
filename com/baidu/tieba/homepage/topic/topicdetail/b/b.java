package com.baidu.tieba.homepage.topic.topicdetail.b;

import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes4.dex */
public class b {
    public long bHE;
    public String bHF;
    public String gfr;
    public String gfs;
    public com.baidu.tieba.homepage.topic.topictab.b.b gft;
    public f gfu;
    public long topicId;

    public void a(TopicDetail topicDetail) {
        if (topicDetail != null) {
            this.topicId = topicDetail.topic_id.longValue();
            this.bHF = topicDetail.topic_desc;
            this.bHE = topicDetail.discuss_num.longValue();
            this.gfr = topicDetail.topic_image;
            this.gfs = topicDetail.bg_image;
        }
    }

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.gft = new com.baidu.tieba.homepage.topic.topictab.b.b();
            this.gft.topicId = this.topicId;
            this.gft.from = 2;
            this.gft.b(pkModule);
        }
    }

    public void a(TimeLine timeLine) {
        if (timeLine != null) {
            this.gfu = new f();
            this.gfu.a(this.topicId, timeLine);
        }
    }
}
