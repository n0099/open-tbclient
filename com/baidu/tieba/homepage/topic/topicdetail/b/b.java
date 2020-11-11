package com.baidu.tieba.homepage.topic.topicdetail.b;

import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes22.dex */
public class b {
    public long eCK;
    public String eCL;
    public String jJt;
    public String jJu;
    public com.baidu.tieba.homepage.topic.topictab.b.b jJv;
    public f jJw;
    public long topicId;

    public void a(TopicDetail topicDetail) {
        if (topicDetail != null) {
            this.topicId = topicDetail.topic_id.longValue();
            this.eCL = topicDetail.topic_desc;
            this.eCK = topicDetail.discuss_num.longValue();
            this.jJt = topicDetail.topic_image;
            this.jJu = topicDetail.bg_image;
        }
    }

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.jJv = new com.baidu.tieba.homepage.topic.topictab.b.b();
            this.jJv.topicId = this.topicId;
            this.jJv.from = 2;
            this.jJv.b(pkModule);
        }
    }

    public void a(TimeLine timeLine) {
        if (timeLine != null) {
            this.jJw = new f();
            this.jJw.a(this.topicId, timeLine);
        }
    }
}
