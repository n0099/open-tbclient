package com.baidu.tieba.homepage.topic.topicdetail.b;

import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes9.dex */
public class b {
    public long cQQ;
    public String cQR;
    public String hhP;
    public String hhQ;
    public com.baidu.tieba.homepage.topic.topictab.b.b hhR;
    public f hhS;
    public long topicId;

    public void a(TopicDetail topicDetail) {
        if (topicDetail != null) {
            this.topicId = topicDetail.topic_id.longValue();
            this.cQR = topicDetail.topic_desc;
            this.cQQ = topicDetail.discuss_num.longValue();
            this.hhP = topicDetail.topic_image;
            this.hhQ = topicDetail.bg_image;
        }
    }

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.hhR = new com.baidu.tieba.homepage.topic.topictab.b.b();
            this.hhR.topicId = this.topicId;
            this.hhR.from = 2;
            this.hhR.b(pkModule);
        }
    }

    public void a(TimeLine timeLine) {
        if (timeLine != null) {
            this.hhS = new f();
            this.hhS.a(this.topicId, timeLine);
        }
    }
}
