package com.baidu.tieba.homepage.topic.topicdetail.b;

import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes16.dex */
public class b {
    public long eac;
    public String ead;
    public String iTl;
    public String iTm;
    public com.baidu.tieba.homepage.topic.topictab.b.b iTn;
    public f iTo;
    public long topicId;

    public void a(TopicDetail topicDetail) {
        if (topicDetail != null) {
            this.topicId = topicDetail.topic_id.longValue();
            this.ead = topicDetail.topic_desc;
            this.eac = topicDetail.discuss_num.longValue();
            this.iTl = topicDetail.topic_image;
            this.iTm = topicDetail.bg_image;
        }
    }

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.iTn = new com.baidu.tieba.homepage.topic.topictab.b.b();
            this.iTn.topicId = this.topicId;
            this.iTn.from = 2;
            this.iTn.b(pkModule);
        }
    }

    public void a(TimeLine timeLine) {
        if (timeLine != null) {
            this.iTo = new f();
            this.iTo.a(this.topicId, timeLine);
        }
    }
}
