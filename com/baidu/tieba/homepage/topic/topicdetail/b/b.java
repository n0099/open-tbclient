package com.baidu.tieba.homepage.topic.topicdetail.b;

import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes9.dex */
public class b {
    public long dKx;
    public String dKy;
    public String iyh;
    public String iyi;
    public com.baidu.tieba.homepage.topic.topictab.b.b iyj;
    public f iyk;
    public long topicId;

    public void a(TopicDetail topicDetail) {
        if (topicDetail != null) {
            this.topicId = topicDetail.topic_id.longValue();
            this.dKy = topicDetail.topic_desc;
            this.dKx = topicDetail.discuss_num.longValue();
            this.iyh = topicDetail.topic_image;
            this.iyi = topicDetail.bg_image;
        }
    }

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.iyj = new com.baidu.tieba.homepage.topic.topictab.b.b();
            this.iyj.topicId = this.topicId;
            this.iyj.from = 2;
            this.iyj.b(pkModule);
        }
    }

    public void a(TimeLine timeLine) {
        if (timeLine != null) {
            this.iyk = new f();
            this.iyk.a(this.topicId, timeLine);
        }
    }
}
