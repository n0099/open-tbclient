package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tieba.tbadkCore.data.PostData;
import tbclient.NewTopicList.NewTopicList;
import tbclient.TopicModule;
/* loaded from: classes22.dex */
public class a extends com.baidu.tieba.card.data.c {
    public static final BdUniqueId jEO = BdUniqueId.gen();
    public static final BdUniqueId jEP = BdUniqueId.gen();
    private bw akq;
    public String ewR;
    public long ewS;
    public String ewT;
    public int from = 0;
    public int index;
    public String jDw;
    public b jEQ;
    public PostData jER;
    public long topicId;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return this.from == 0 ? jEO : jEP;
    }

    public static boolean ab(bw bwVar) {
        return bwVar != null && bwVar.getType() == bw.exW;
    }

    public void a(NewTopicList newTopicList) {
        if (newTopicList != null) {
            this.topicId = newTopicList.topic_id.longValue();
            this.ewR = newTopicList.topic_name;
            this.ewT = newTopicList.topic_desc;
            this.ewS = newTopicList.discuss_num.longValue();
            this.jDw = newTopicList.topic_image;
            if (newTopicList.pk_module != null && newTopicList.pk_module.agree != null && newTopicList.pk_module.disagree != null) {
                this.jEQ = new b();
                this.jEQ.topicId = this.topicId;
                this.jEQ.from = 1;
                this.jEQ.a(newTopicList.pk_module);
            }
            if (newTopicList.top_agree_post != null) {
                this.jER = new PostData();
                this.jER.a(newTopicList.top_agree_post, TbadkCoreApplication.getInst());
            }
        }
    }

    public void a(TopicModule topicModule) {
        if (topicModule != null) {
            this.topicId = topicModule.topic_id.longValue();
            this.ewR = topicModule.topic_name;
            this.ewT = topicModule.topic_desc;
            this.jDw = topicModule.topic_image;
            if (topicModule.pk_module != null && topicModule.pk_module.agree != null && topicModule.pk_module.disagree != null) {
                this.jEQ = new b();
                this.jEQ.topicId = this.topicId;
                this.jEQ.from = 3;
                this.jEQ.a(topicModule.pk_module);
            }
        }
    }

    public void setThreadData(bw bwVar) {
        this.akq = bwVar;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bhz() {
        return this.akq;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ar bhB() {
        ar bhB = super.bhB();
        if (bhB != null) {
            bhB.cI(this.topicId);
        }
        return bhB;
    }
}
