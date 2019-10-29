package com.baidu.tieba.homepage.topic.topicdetail.b;

import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes4.dex */
public class b {
    public long caO;
    public String caP;
    public String gnN;
    public String gnO;
    public com.baidu.tieba.homepage.topic.topictab.b.b gnP;
    public f gnQ;
    public long topicId;

    public void a(TopicDetail topicDetail) {
        if (topicDetail != null) {
            this.topicId = topicDetail.topic_id.longValue();
            this.caP = topicDetail.topic_desc;
            this.caO = topicDetail.discuss_num.longValue();
            this.gnN = topicDetail.topic_image;
            this.gnO = topicDetail.bg_image;
        }
    }

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.gnP = new com.baidu.tieba.homepage.topic.topictab.b.b();
            this.gnP.topicId = this.topicId;
            this.gnP.from = 2;
            this.gnP.b(pkModule);
        }
    }

    public void a(TimeLine timeLine) {
        if (timeLine != null) {
            this.gnQ = new f();
            this.gnQ.a(this.topicId, timeLine);
        }
    }
}
