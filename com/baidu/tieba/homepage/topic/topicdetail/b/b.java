package com.baidu.tieba.homepage.topic.topicdetail.b;

import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes4.dex */
public class b {
    public long bAq;
    public String bAr;
    public String fOf;
    public String fOg;
    public com.baidu.tieba.homepage.topic.topictab.b.b fOh;
    public f fOi;
    public long topicId;

    public void a(TopicDetail topicDetail) {
        if (topicDetail != null) {
            this.topicId = topicDetail.topic_id.longValue();
            this.bAr = topicDetail.topic_desc;
            this.bAq = topicDetail.discuss_num.longValue();
            this.fOf = topicDetail.topic_image;
            this.fOg = topicDetail.bg_image;
        }
    }

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.fOh = new com.baidu.tieba.homepage.topic.topictab.b.b();
            this.fOh.topicId = this.topicId;
            this.fOh.from = 2;
            this.fOh.b(pkModule);
        }
    }

    public void a(TimeLine timeLine) {
        if (timeLine != null) {
            this.fOi = new f();
            this.fOi.a(this.topicId, timeLine);
        }
    }
}
