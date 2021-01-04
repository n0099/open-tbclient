package com.baidu.tieba.homepage.topic.topicdetail.a;

import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes2.dex */
public class b {
    public long eRT;
    public String eRU;
    public String kkV;
    public String kkW;
    public com.baidu.tieba.homepage.topic.topictab.b.b kkX;
    public f kkY;
    public long topicId;

    public void a(TopicDetail topicDetail) {
        if (topicDetail != null) {
            this.topicId = topicDetail.topic_id.longValue();
            this.eRU = topicDetail.topic_desc;
            this.eRT = topicDetail.discuss_num.longValue();
            this.kkV = topicDetail.topic_image;
            this.kkW = topicDetail.bg_image;
        }
    }

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.kkX = new com.baidu.tieba.homepage.topic.topictab.b.b();
            this.kkX.topicId = this.topicId;
            this.kkX.from = 2;
            this.kkX.b(pkModule);
        }
    }

    public void a(TimeLine timeLine) {
        if (timeLine != null) {
            this.kkY = new f();
            this.kkY.a(this.topicId, timeLine);
        }
    }
}
