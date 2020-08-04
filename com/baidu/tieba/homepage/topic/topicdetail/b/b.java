package com.baidu.tieba.homepage.topic.topicdetail.b;

import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes16.dex */
public class b {
    public long dQJ;
    public String dQK;
    public String iEn;
    public String iEo;
    public com.baidu.tieba.homepage.topic.topictab.b.b iEp;
    public f iEq;
    public long topicId;

    public void a(TopicDetail topicDetail) {
        if (topicDetail != null) {
            this.topicId = topicDetail.topic_id.longValue();
            this.dQK = topicDetail.topic_desc;
            this.dQJ = topicDetail.discuss_num.longValue();
            this.iEn = topicDetail.topic_image;
            this.iEo = topicDetail.bg_image;
        }
    }

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.iEp = new com.baidu.tieba.homepage.topic.topictab.b.b();
            this.iEp.topicId = this.topicId;
            this.iEp.from = 2;
            this.iEp.b(pkModule);
        }
    }

    public void a(TimeLine timeLine) {
        if (timeLine != null) {
            this.iEq = new f();
            this.iEq.a(this.topicId, timeLine);
        }
    }
}
