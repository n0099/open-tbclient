package com.baidu.tieba.homepage.topic.topicdetail.b;

import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes9.dex */
public class b {
    public long dpW;
    public String dpX;
    public String hRA;
    public com.baidu.tieba.homepage.topic.topictab.b.b hRB;
    public f hRC;
    public String hRz;
    public long topicId;

    public void a(TopicDetail topicDetail) {
        if (topicDetail != null) {
            this.topicId = topicDetail.topic_id.longValue();
            this.dpX = topicDetail.topic_desc;
            this.dpW = topicDetail.discuss_num.longValue();
            this.hRz = topicDetail.topic_image;
            this.hRA = topicDetail.bg_image;
        }
    }

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.hRB = new com.baidu.tieba.homepage.topic.topictab.b.b();
            this.hRB.topicId = this.topicId;
            this.hRB.from = 2;
            this.hRB.b(pkModule);
        }
    }

    public void a(TimeLine timeLine) {
        if (timeLine != null) {
            this.hRC = new f();
            this.hRC.a(this.topicId, timeLine);
        }
    }
}
