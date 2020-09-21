package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tieba.tbadkCore.data.PostData;
import tbclient.NewTopicList.NewTopicList;
import tbclient.TopicModule;
/* loaded from: classes21.dex */
public class a extends com.baidu.tieba.card.data.c {
    public static final BdUniqueId jdp = BdUniqueId.gen();
    public static final BdUniqueId jdq = BdUniqueId.gen();
    private bw ajX;
    public String ecp;
    public long ecq;
    public String ecr;
    public int from = 0;
    public int index;
    public String jbX;
    public b jdr;
    public PostData jds;
    public long topicId;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return this.from == 0 ? jdp : jdq;
    }

    public static boolean ab(bw bwVar) {
        return bwVar != null && bwVar.getType() == bw.edt;
    }

    public void a(NewTopicList newTopicList) {
        if (newTopicList != null) {
            this.topicId = newTopicList.topic_id.longValue();
            this.ecp = newTopicList.topic_name;
            this.ecr = newTopicList.topic_desc;
            this.ecq = newTopicList.discuss_num.longValue();
            this.jbX = newTopicList.topic_image;
            if (newTopicList.pk_module != null && newTopicList.pk_module.agree != null && newTopicList.pk_module.disagree != null) {
                this.jdr = new b();
                this.jdr.topicId = this.topicId;
                this.jdr.from = 1;
                this.jdr.a(newTopicList.pk_module);
            }
            if (newTopicList.top_agree_post != null) {
                this.jds = new PostData();
                this.jds.a(newTopicList.top_agree_post, TbadkCoreApplication.getInst());
            }
        }
    }

    public void a(TopicModule topicModule) {
        if (topicModule != null) {
            this.topicId = topicModule.topic_id.longValue();
            this.ecp = topicModule.topic_name;
            this.ecr = topicModule.topic_desc;
            this.jbX = topicModule.topic_image;
            if (topicModule.pk_module != null && topicModule.pk_module.agree != null && topicModule.pk_module.disagree != null) {
                this.jdr = new b();
                this.jdr.topicId = this.topicId;
                this.jdr.from = 3;
                this.jdr.a(topicModule.pk_module);
            }
        }
    }

    public void setThreadData(bw bwVar) {
        this.ajX = bwVar;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bcY() {
        return this.ajX;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ar bda() {
        ar bda = super.bda();
        if (bda != null) {
            bda.cy(this.topicId);
        }
        return bda;
    }
}
