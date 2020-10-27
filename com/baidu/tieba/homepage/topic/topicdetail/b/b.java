package com.baidu.tieba.homepage.topic.topicdetail.b;

import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes22.dex */
public class b {
    public long ewS;
    public String ewT;
    public String jDw;
    public String jDx;
    public com.baidu.tieba.homepage.topic.topictab.b.b jDy;
    public f jDz;
    public long topicId;

    public void a(TopicDetail topicDetail) {
        if (topicDetail != null) {
            this.topicId = topicDetail.topic_id.longValue();
            this.ewT = topicDetail.topic_desc;
            this.ewS = topicDetail.discuss_num.longValue();
            this.jDw = topicDetail.topic_image;
            this.jDx = topicDetail.bg_image;
        }
    }

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.jDy = new com.baidu.tieba.homepage.topic.topictab.b.b();
            this.jDy.topicId = this.topicId;
            this.jDy.from = 2;
            this.jDy.b(pkModule);
        }
    }

    public void a(TimeLine timeLine) {
        if (timeLine != null) {
            this.jDz = new f();
            this.jDz.a(this.topicId, timeLine);
        }
    }
}
