package com.baidu.tieba.homepage.topic.topicdetail.b;

import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes4.dex */
public class b {
    public long bAn;
    public String bAo;
    public String fOr;
    public String fOs;
    public com.baidu.tieba.homepage.topic.topictab.b.b fOt;
    public f fOu;
    public long topicId;

    public void a(TopicDetail topicDetail) {
        if (topicDetail != null) {
            this.topicId = topicDetail.topic_id.longValue();
            this.bAo = topicDetail.topic_desc;
            this.bAn = topicDetail.discuss_num.longValue();
            this.fOr = topicDetail.topic_image;
            this.fOs = topicDetail.bg_image;
        }
    }

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.fOt = new com.baidu.tieba.homepage.topic.topictab.b.b();
            this.fOt.topicId = this.topicId;
            this.fOt.from = 2;
            this.fOt.b(pkModule);
        }
    }

    public void a(TimeLine timeLine) {
        if (timeLine != null) {
            this.fOu = new f();
            this.fOu.a(this.topicId, timeLine);
        }
    }
}
