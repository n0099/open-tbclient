package com.baidu.tieba.homepage.topic.topicdetail.a;

import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes2.dex */
public class b {
    public long ePu;
    public String ePv;
    public String koL;
    public String koM;
    public com.baidu.tieba.homepage.topic.topictab.b.b koN;
    public f koO;
    public long topicId;

    public void a(TopicDetail topicDetail) {
        if (topicDetail != null) {
            this.topicId = topicDetail.topic_id.longValue();
            this.ePv = topicDetail.topic_desc;
            this.ePu = topicDetail.discuss_num.longValue();
            this.koL = topicDetail.topic_image;
            this.koM = topicDetail.bg_image;
        }
    }

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.koN = new com.baidu.tieba.homepage.topic.topictab.b.b();
            this.koN.topicId = this.topicId;
            this.koN.from = 2;
            this.koN.b(pkModule);
        }
    }

    public void a(TimeLine timeLine) {
        if (timeLine != null) {
            this.koO = new f();
            this.koO.a(this.topicId, timeLine);
        }
    }
}
