package com.baidu.tieba.homepage.topic.topicdetail.b;

import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes9.dex */
public class b {
    public long cQC;
    public String cQD;
    public String hgd;
    public String hge;
    public com.baidu.tieba.homepage.topic.topictab.b.b hgf;
    public f hgg;
    public long topicId;

    public void a(TopicDetail topicDetail) {
        if (topicDetail != null) {
            this.topicId = topicDetail.topic_id.longValue();
            this.cQD = topicDetail.topic_desc;
            this.cQC = topicDetail.discuss_num.longValue();
            this.hgd = topicDetail.topic_image;
            this.hge = topicDetail.bg_image;
        }
    }

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.hgf = new com.baidu.tieba.homepage.topic.topictab.b.b();
            this.hgf.topicId = this.topicId;
            this.hgf.from = 2;
            this.hgf.b(pkModule);
        }
    }

    public void a(TimeLine timeLine) {
        if (timeLine != null) {
            this.hgg = new f();
            this.hgg.a(this.topicId, timeLine);
        }
    }
}
