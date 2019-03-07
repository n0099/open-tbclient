package com.baidu.tieba.homepage.topic.topicdetail.b;

import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes4.dex */
public class b {
    public long bAl;
    public String bAm;
    public String fOs;
    public String fOt;
    public com.baidu.tieba.homepage.topic.topictab.b.b fOu;
    public f fOv;
    public long topicId;

    public void a(TopicDetail topicDetail) {
        if (topicDetail != null) {
            this.topicId = topicDetail.topic_id.longValue();
            this.bAm = topicDetail.topic_desc;
            this.bAl = topicDetail.discuss_num.longValue();
            this.fOs = topicDetail.topic_image;
            this.fOt = topicDetail.bg_image;
        }
    }

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.fOu = new com.baidu.tieba.homepage.topic.topictab.b.b();
            this.fOu.topicId = this.topicId;
            this.fOu.from = 2;
            this.fOu.b(pkModule);
        }
    }

    public void a(TimeLine timeLine) {
        if (timeLine != null) {
            this.fOv = new f();
            this.fOv.a(this.topicId, timeLine);
        }
    }
}
