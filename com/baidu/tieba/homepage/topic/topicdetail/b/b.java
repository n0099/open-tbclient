package com.baidu.tieba.homepage.topic.topicdetail.b;

import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes9.dex */
public class b {
    public long cQB;
    public String cQC;
    public String hgb;
    public String hgc;
    public com.baidu.tieba.homepage.topic.topictab.b.b hgd;
    public f hge;
    public long topicId;

    public void a(TopicDetail topicDetail) {
        if (topicDetail != null) {
            this.topicId = topicDetail.topic_id.longValue();
            this.cQC = topicDetail.topic_desc;
            this.cQB = topicDetail.discuss_num.longValue();
            this.hgb = topicDetail.topic_image;
            this.hgc = topicDetail.bg_image;
        }
    }

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.hgd = new com.baidu.tieba.homepage.topic.topictab.b.b();
            this.hgd.topicId = this.topicId;
            this.hgd.from = 2;
            this.hgd.b(pkModule);
        }
    }

    public void a(TimeLine timeLine) {
        if (timeLine != null) {
            this.hge = new f();
            this.hge.a(this.topicId, timeLine);
        }
    }
}
