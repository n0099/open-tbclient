package com.baidu.tieba.homepage.topic.topicdetail.b;

import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes22.dex */
public class b {
    public long eIb;
    public String eIc;
    public String jXH;
    public String jXI;
    public com.baidu.tieba.homepage.topic.topictab.b.b jXJ;
    public f jXK;
    public long topicId;

    public void a(TopicDetail topicDetail) {
        if (topicDetail != null) {
            this.topicId = topicDetail.topic_id.longValue();
            this.eIc = topicDetail.topic_desc;
            this.eIb = topicDetail.discuss_num.longValue();
            this.jXH = topicDetail.topic_image;
            this.jXI = topicDetail.bg_image;
        }
    }

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.jXJ = new com.baidu.tieba.homepage.topic.topictab.b.b();
            this.jXJ.topicId = this.topicId;
            this.jXJ.from = 2;
            this.jXJ.b(pkModule);
        }
    }

    public void a(TimeLine timeLine) {
        if (timeLine != null) {
            this.jXK = new f();
            this.jXK.a(this.topicId, timeLine);
        }
    }
}
