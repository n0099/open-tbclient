package com.baidu.tieba.homepage.topic.topicdetail.b;

import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes22.dex */
public class b {
    public long eov;
    public String eow;
    public String jqW;
    public String jqX;
    public com.baidu.tieba.homepage.topic.topictab.b.b jqY;
    public f jqZ;
    public long topicId;

    public void a(TopicDetail topicDetail) {
        if (topicDetail != null) {
            this.topicId = topicDetail.topic_id.longValue();
            this.eow = topicDetail.topic_desc;
            this.eov = topicDetail.discuss_num.longValue();
            this.jqW = topicDetail.topic_image;
            this.jqX = topicDetail.bg_image;
        }
    }

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.jqY = new com.baidu.tieba.homepage.topic.topictab.b.b();
            this.jqY.topicId = this.topicId;
            this.jqY.from = 2;
            this.jqY.b(pkModule);
        }
    }

    public void a(TimeLine timeLine) {
        if (timeLine != null) {
            this.jqZ = new f();
            this.jqZ.a(this.topicId, timeLine);
        }
    }
}
