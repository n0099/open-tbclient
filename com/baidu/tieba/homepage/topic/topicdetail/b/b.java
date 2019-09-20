package com.baidu.tieba.homepage.topic.topicdetail.b;

import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes4.dex */
public class b {
    public long bJh;
    public String bJi;
    public String goo;
    public String gop;
    public com.baidu.tieba.homepage.topic.topictab.b.b goq;
    public f gor;
    public long topicId;

    public void a(TopicDetail topicDetail) {
        if (topicDetail != null) {
            this.topicId = topicDetail.topic_id.longValue();
            this.bJi = topicDetail.topic_desc;
            this.bJh = topicDetail.discuss_num.longValue();
            this.goo = topicDetail.topic_image;
            this.gop = topicDetail.bg_image;
        }
    }

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.goq = new com.baidu.tieba.homepage.topic.topictab.b.b();
            this.goq.topicId = this.topicId;
            this.goq.from = 2;
            this.goq.b(pkModule);
        }
    }

    public void a(TimeLine timeLine) {
        if (timeLine != null) {
            this.gor = new f();
            this.gor.a(this.topicId, timeLine);
        }
    }
}
