package com.baidu.tieba.homepage.topic.topicdetail.b;

import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes9.dex */
public class b {
    public long dDX;
    public String dDY;
    public String ihc;
    public String ihd;
    public com.baidu.tieba.homepage.topic.topictab.b.b ihe;
    public f ihf;
    public long topicId;

    public void a(TopicDetail topicDetail) {
        if (topicDetail != null) {
            this.topicId = topicDetail.topic_id.longValue();
            this.dDY = topicDetail.topic_desc;
            this.dDX = topicDetail.discuss_num.longValue();
            this.ihc = topicDetail.topic_image;
            this.ihd = topicDetail.bg_image;
        }
    }

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.ihe = new com.baidu.tieba.homepage.topic.topictab.b.b();
            this.ihe.topicId = this.topicId;
            this.ihe.from = 2;
            this.ihe.b(pkModule);
        }
    }

    public void a(TimeLine timeLine) {
        if (timeLine != null) {
            this.ihf = new f();
            this.ihf.a(this.topicId, timeLine);
        }
    }
}
