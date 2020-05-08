package com.baidu.tieba.homepage.topic.topicdetail.b;

import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes9.dex */
public class b {
    public long dqa;
    public String dqb;
    public String hRF;
    public String hRG;
    public com.baidu.tieba.homepage.topic.topictab.b.b hRH;
    public f hRI;
    public long topicId;

    public void a(TopicDetail topicDetail) {
        if (topicDetail != null) {
            this.topicId = topicDetail.topic_id.longValue();
            this.dqb = topicDetail.topic_desc;
            this.dqa = topicDetail.discuss_num.longValue();
            this.hRF = topicDetail.topic_image;
            this.hRG = topicDetail.bg_image;
        }
    }

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.hRH = new com.baidu.tieba.homepage.topic.topictab.b.b();
            this.hRH.topicId = this.topicId;
            this.hRH.from = 2;
            this.hRH.b(pkModule);
        }
    }

    public void a(TimeLine timeLine) {
        if (timeLine != null) {
            this.hRI = new f();
            this.hRI.a(this.topicId, timeLine);
        }
    }
}
