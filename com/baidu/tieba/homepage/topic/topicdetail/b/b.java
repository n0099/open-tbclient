package com.baidu.tieba.homepage.topic.topicdetail.b;

import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes7.dex */
public class b {
    public long cMy;
    public String cMz;
    public String hea;
    public String heb;
    public com.baidu.tieba.homepage.topic.topictab.b.b hec;
    public f hed;
    public long topicId;

    public void a(TopicDetail topicDetail) {
        if (topicDetail != null) {
            this.topicId = topicDetail.topic_id.longValue();
            this.cMz = topicDetail.topic_desc;
            this.cMy = topicDetail.discuss_num.longValue();
            this.hea = topicDetail.topic_image;
            this.heb = topicDetail.bg_image;
        }
    }

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.hec = new com.baidu.tieba.homepage.topic.topictab.b.b();
            this.hec.topicId = this.topicId;
            this.hec.from = 2;
            this.hec.b(pkModule);
        }
    }

    public void a(TimeLine timeLine) {
        if (timeLine != null) {
            this.hed = new f();
            this.hed.a(this.topicId, timeLine);
        }
    }
}
