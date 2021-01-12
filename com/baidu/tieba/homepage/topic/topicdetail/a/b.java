package com.baidu.tieba.homepage.topic.topicdetail.a;

import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes2.dex */
public class b {
    public long eNi;
    public String eNj;
    public String kgp;
    public String kgq;
    public com.baidu.tieba.homepage.topic.topictab.b.b kgr;
    public f kgs;
    public long topicId;

    public void a(TopicDetail topicDetail) {
        if (topicDetail != null) {
            this.topicId = topicDetail.topic_id.longValue();
            this.eNj = topicDetail.topic_desc;
            this.eNi = topicDetail.discuss_num.longValue();
            this.kgp = topicDetail.topic_image;
            this.kgq = topicDetail.bg_image;
        }
    }

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.kgr = new com.baidu.tieba.homepage.topic.topictab.b.b();
            this.kgr.topicId = this.topicId;
            this.kgr.from = 2;
            this.kgr.b(pkModule);
        }
    }

    public void a(TimeLine timeLine) {
        if (timeLine != null) {
            this.kgs = new f();
            this.kgs.a(this.topicId, timeLine);
        }
    }
}
