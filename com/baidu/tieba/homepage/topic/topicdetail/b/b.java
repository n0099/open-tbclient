package com.baidu.tieba.homepage.topic.topicdetail.b;

import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes22.dex */
public class b {
    public long eIb;
    public String eIc;
    public String jXJ;
    public String jXK;
    public com.baidu.tieba.homepage.topic.topictab.b.b jXL;
    public f jXM;
    public long topicId;

    public void a(TopicDetail topicDetail) {
        if (topicDetail != null) {
            this.topicId = topicDetail.topic_id.longValue();
            this.eIc = topicDetail.topic_desc;
            this.eIb = topicDetail.discuss_num.longValue();
            this.jXJ = topicDetail.topic_image;
            this.jXK = topicDetail.bg_image;
        }
    }

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.jXL = new com.baidu.tieba.homepage.topic.topictab.b.b();
            this.jXL.topicId = this.topicId;
            this.jXL.from = 2;
            this.jXL.b(pkModule);
        }
    }

    public void a(TimeLine timeLine) {
        if (timeLine != null) {
            this.jXM = new f();
            this.jXM.a(this.topicId, timeLine);
        }
    }
}
