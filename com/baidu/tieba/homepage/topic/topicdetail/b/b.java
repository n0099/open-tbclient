package com.baidu.tieba.homepage.topic.topicdetail.b;

import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes21.dex */
public class b {
    public long eBb;
    public String eBc;
    public String jKe;
    public String jKf;
    public com.baidu.tieba.homepage.topic.topictab.b.b jKg;
    public f jKh;
    public long topicId;

    public void a(TopicDetail topicDetail) {
        if (topicDetail != null) {
            this.topicId = topicDetail.topic_id.longValue();
            this.eBc = topicDetail.topic_desc;
            this.eBb = topicDetail.discuss_num.longValue();
            this.jKe = topicDetail.topic_image;
            this.jKf = topicDetail.bg_image;
        }
    }

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.jKg = new com.baidu.tieba.homepage.topic.topictab.b.b();
            this.jKg.topicId = this.topicId;
            this.jKg.from = 2;
            this.jKg.b(pkModule);
        }
    }

    public void a(TimeLine timeLine) {
        if (timeLine != null) {
            this.jKh = new f();
            this.jKh.a(this.topicId, timeLine);
        }
    }
}
