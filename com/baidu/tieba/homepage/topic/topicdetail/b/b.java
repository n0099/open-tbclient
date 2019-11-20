package com.baidu.tieba.homepage.topic.topicdetail.b;

import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes4.dex */
public class b {
    public long bZX;
    public String bZY;
    public String gmW;
    public String gmX;
    public com.baidu.tieba.homepage.topic.topictab.b.b gmY;
    public f gmZ;
    public long topicId;

    public void a(TopicDetail topicDetail) {
        if (topicDetail != null) {
            this.topicId = topicDetail.topic_id.longValue();
            this.bZY = topicDetail.topic_desc;
            this.bZX = topicDetail.discuss_num.longValue();
            this.gmW = topicDetail.topic_image;
            this.gmX = topicDetail.bg_image;
        }
    }

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.gmY = new com.baidu.tieba.homepage.topic.topictab.b.b();
            this.gmY.topicId = this.topicId;
            this.gmY.from = 2;
            this.gmY.b(pkModule);
        }
    }

    public void a(TimeLine timeLine) {
        if (timeLine != null) {
            this.gmZ = new f();
            this.gmZ.a(this.topicId, timeLine);
        }
    }
}
