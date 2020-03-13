package com.baidu.tieba.homepage.topic.topicdetail.b;

import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes9.dex */
public class b {
    public long cQD;
    public String cQE;
    public String hgp;
    public String hgq;
    public com.baidu.tieba.homepage.topic.topictab.b.b hgr;
    public f hgs;
    public long topicId;

    public void a(TopicDetail topicDetail) {
        if (topicDetail != null) {
            this.topicId = topicDetail.topic_id.longValue();
            this.cQE = topicDetail.topic_desc;
            this.cQD = topicDetail.discuss_num.longValue();
            this.hgp = topicDetail.topic_image;
            this.hgq = topicDetail.bg_image;
        }
    }

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.hgr = new com.baidu.tieba.homepage.topic.topictab.b.b();
            this.hgr.topicId = this.topicId;
            this.hgr.from = 2;
            this.hgr.b(pkModule);
        }
    }

    public void a(TimeLine timeLine) {
        if (timeLine != null) {
            this.hgs = new f();
            this.hgs.a(this.topicId, timeLine);
        }
    }
}
