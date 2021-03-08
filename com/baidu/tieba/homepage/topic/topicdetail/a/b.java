package com.baidu.tieba.homepage.topic.topicdetail.a;

import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes2.dex */
public class b {
    public long eQV;
    public String eQW;
    public String kqN;
    public String kqO;
    public com.baidu.tieba.homepage.topic.topictab.b.b kqP;
    public f kqQ;
    public long topicId;

    public void a(TopicDetail topicDetail) {
        if (topicDetail != null) {
            this.topicId = topicDetail.topic_id.longValue();
            this.eQW = topicDetail.topic_desc;
            this.eQV = topicDetail.discuss_num.longValue();
            this.kqN = topicDetail.topic_image;
            this.kqO = topicDetail.bg_image;
        }
    }

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.kqP = new com.baidu.tieba.homepage.topic.topictab.b.b();
            this.kqP.topicId = this.topicId;
            this.kqP.from = 2;
            this.kqP.b(pkModule);
        }
    }

    public void a(TimeLine timeLine) {
        if (timeLine != null) {
            this.kqQ = new f();
            this.kqQ.a(this.topicId, timeLine);
        }
    }
}
