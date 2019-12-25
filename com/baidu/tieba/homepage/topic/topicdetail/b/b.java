package com.baidu.tieba.homepage.topic.topicdetail.b;

import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes6.dex */
public class b {
    public long cMo;
    public String cMp;
    public f haA;
    public String hax;
    public String hay;
    public com.baidu.tieba.homepage.topic.topictab.b.b haz;
    public long topicId;

    public void a(TopicDetail topicDetail) {
        if (topicDetail != null) {
            this.topicId = topicDetail.topic_id.longValue();
            this.cMp = topicDetail.topic_desc;
            this.cMo = topicDetail.discuss_num.longValue();
            this.hax = topicDetail.topic_image;
            this.hay = topicDetail.bg_image;
        }
    }

    public void a(PkModule pkModule) {
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            this.haz = new com.baidu.tieba.homepage.topic.topictab.b.b();
            this.haz.topicId = this.topicId;
            this.haz.from = 2;
            this.haz.b(pkModule);
        }
    }

    public void a(TimeLine timeLine) {
        if (timeLine != null) {
            this.haA = new f();
            this.haA.a(this.topicId, timeLine);
        }
    }
}
