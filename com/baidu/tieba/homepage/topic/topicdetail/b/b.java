package com.baidu.tieba.homepage.topic.topicdetail.b;

import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes4.dex */
public class b {
    public long bIJ;
    public String bIK;
    public f gmA;
    public String gmx;
    public String gmy;
    public com.baidu.tieba.homepage.topic.topictab.b.b gmz;
    public long topicId;

    public void a(TopicDetail topicDetail) {
        if (topicDetail != null) {
            this.topicId = topicDetail.topic_id.longValue();
            this.bIK = topicDetail.topic_desc;
            this.bIJ = topicDetail.discuss_num.longValue();
            this.gmx = topicDetail.topic_image;
            this.gmy = topicDetail.bg_image;
        }
    }

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.gmz = new com.baidu.tieba.homepage.topic.topictab.b.b();
            this.gmz.topicId = this.topicId;
            this.gmz.from = 2;
            this.gmz.b(pkModule);
        }
    }

    public void a(TimeLine timeLine) {
        if (timeLine != null) {
            this.gmA = new f();
            this.gmA.a(this.topicId, timeLine);
        }
    }
}
