package com.baidu.tieba.homepage.topic.topicdetail.b;

import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes16.dex */
public class b {
    public long eag;
    public String eah;
    public String iTr;
    public String iTs;
    public com.baidu.tieba.homepage.topic.topictab.b.b iTt;
    public f iTu;
    public long topicId;

    public void a(TopicDetail topicDetail) {
        if (topicDetail != null) {
            this.topicId = topicDetail.topic_id.longValue();
            this.eah = topicDetail.topic_desc;
            this.eag = topicDetail.discuss_num.longValue();
            this.iTr = topicDetail.topic_image;
            this.iTs = topicDetail.bg_image;
        }
    }

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.iTt = new com.baidu.tieba.homepage.topic.topictab.b.b();
            this.iTt.topicId = this.topicId;
            this.iTt.from = 2;
            this.iTt.b(pkModule);
        }
    }

    public void a(TimeLine timeLine) {
        if (timeLine != null) {
            this.iTu = new f();
            this.iTu.a(this.topicId, timeLine);
        }
    }
}
