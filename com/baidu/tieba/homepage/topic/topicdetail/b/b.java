package com.baidu.tieba.homepage.topic.topicdetail.b;

import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes21.dex */
public class b {
    public long ecq;
    public String ecr;
    public String jbX;
    public String jbY;
    public com.baidu.tieba.homepage.topic.topictab.b.b jbZ;
    public f jca;
    public long topicId;

    public void a(TopicDetail topicDetail) {
        if (topicDetail != null) {
            this.topicId = topicDetail.topic_id.longValue();
            this.ecr = topicDetail.topic_desc;
            this.ecq = topicDetail.discuss_num.longValue();
            this.jbX = topicDetail.topic_image;
            this.jbY = topicDetail.bg_image;
        }
    }

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.jbZ = new com.baidu.tieba.homepage.topic.topictab.b.b();
            this.jbZ.topicId = this.topicId;
            this.jbZ.from = 2;
            this.jbZ.b(pkModule);
        }
    }

    public void a(TimeLine timeLine) {
        if (timeLine != null) {
            this.jca = new f();
            this.jca.a(this.topicId, timeLine);
        }
    }
}
