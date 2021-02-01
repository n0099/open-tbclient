package com.baidu.tieba.homepage.topic.topicdetail.a;

import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes2.dex */
public class b {
    public long ePu;
    public String ePv;
    public f koA;
    public String kox;
    public String koy;
    public com.baidu.tieba.homepage.topic.topictab.b.b koz;
    public long topicId;

    public void a(TopicDetail topicDetail) {
        if (topicDetail != null) {
            this.topicId = topicDetail.topic_id.longValue();
            this.ePv = topicDetail.topic_desc;
            this.ePu = topicDetail.discuss_num.longValue();
            this.kox = topicDetail.topic_image;
            this.koy = topicDetail.bg_image;
        }
    }

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.koz = new com.baidu.tieba.homepage.topic.topictab.b.b();
            this.koz.topicId = this.topicId;
            this.koz.from = 2;
            this.koz.b(pkModule);
        }
    }

    public void a(TimeLine timeLine) {
        if (timeLine != null) {
            this.koA = new f();
            this.koA.a(this.topicId, timeLine);
        }
    }
}
