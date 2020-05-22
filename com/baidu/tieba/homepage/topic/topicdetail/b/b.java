package com.baidu.tieba.homepage.topic.topicdetail.b;

import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes9.dex */
public class b {
    public long dDX;
    public String dDY;
    public String igp;
    public String igq;
    public com.baidu.tieba.homepage.topic.topictab.b.b igr;
    public f igs;
    public long topicId;

    public void a(TopicDetail topicDetail) {
        if (topicDetail != null) {
            this.topicId = topicDetail.topic_id.longValue();
            this.dDY = topicDetail.topic_desc;
            this.dDX = topicDetail.discuss_num.longValue();
            this.igp = topicDetail.topic_image;
            this.igq = topicDetail.bg_image;
        }
    }

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.igr = new com.baidu.tieba.homepage.topic.topictab.b.b();
            this.igr.topicId = this.topicId;
            this.igr.from = 2;
            this.igr.b(pkModule);
        }
    }

    public void a(TimeLine timeLine) {
        if (timeLine != null) {
            this.igs = new f();
            this.igs.a(this.topicId, timeLine);
        }
    }
}
