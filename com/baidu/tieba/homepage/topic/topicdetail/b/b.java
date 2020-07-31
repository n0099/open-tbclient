package com.baidu.tieba.homepage.topic.topicdetail.b;

import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes16.dex */
public class b {
    public long dQJ;
    public String dQK;
    public String iEl;
    public String iEm;
    public com.baidu.tieba.homepage.topic.topictab.b.b iEn;
    public f iEo;
    public long topicId;

    public void a(TopicDetail topicDetail) {
        if (topicDetail != null) {
            this.topicId = topicDetail.topic_id.longValue();
            this.dQK = topicDetail.topic_desc;
            this.dQJ = topicDetail.discuss_num.longValue();
            this.iEl = topicDetail.topic_image;
            this.iEm = topicDetail.bg_image;
        }
    }

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.iEn = new com.baidu.tieba.homepage.topic.topictab.b.b();
            this.iEn.topicId = this.topicId;
            this.iEn.from = 2;
            this.iEn.b(pkModule);
        }
    }

    public void a(TimeLine timeLine) {
        if (timeLine != null) {
            this.iEo = new f();
            this.iEo.a(this.topicId, timeLine);
        }
    }
}
