package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.tbadkCore.data.PostData;
import tbclient.NewTopicList.NewTopicList;
import tbclient.TopicModule;
/* loaded from: classes9.dex */
public class a extends com.baidu.tieba.card.data.c {
    public static final BdUniqueId hSY = BdUniqueId.gen();
    public static final BdUniqueId hSZ = BdUniqueId.gen();
    private bj agC;
    public String dpZ;
    public long dqa;
    public String dqb;
    public int from = 0;
    public String hRF;
    public b hTa;
    public PostData hTb;
    public int index;
    public long topicId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.from == 0 ? hSY : hSZ;
    }

    public static boolean ab(bj bjVar) {
        return bjVar != null && bjVar.getType() == bj.dqU;
    }

    public void a(NewTopicList newTopicList) {
        if (newTopicList != null) {
            this.topicId = newTopicList.topic_id.longValue();
            this.dpZ = newTopicList.topic_name;
            this.dqb = newTopicList.topic_desc;
            this.dqa = newTopicList.discuss_num.longValue();
            this.hRF = newTopicList.topic_image;
            if (newTopicList.pk_module != null && newTopicList.pk_module.agree != null && newTopicList.pk_module.disagree != null) {
                this.hTa = new b();
                this.hTa.topicId = this.topicId;
                this.hTa.from = 1;
                this.hTa.a(newTopicList.pk_module);
            }
            if (newTopicList.top_agree_post != null) {
                this.hTb = new PostData();
                this.hTb.a(newTopicList.top_agree_post, TbadkCoreApplication.getInst());
            }
        }
    }

    public void a(TopicModule topicModule) {
        if (topicModule != null) {
            this.topicId = topicModule.topic_id.longValue();
            this.dpZ = topicModule.topic_name;
            this.dqb = topicModule.topic_desc;
            this.hRF = topicModule.topic_image;
            if (topicModule.pk_module != null && topicModule.pk_module.agree != null && topicModule.pk_module.disagree != null) {
                this.hTa = new b();
                this.hTa.topicId = this.topicId;
                this.hTa.from = 3;
                this.hTa.a(topicModule.pk_module);
            }
        }
    }

    public void setThreadData(bj bjVar) {
        this.agC = bjVar;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bj aIu() {
        return this.agC;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public al aIw() {
        al aIw = super.aIw();
        if (aIw != null) {
            aIw.bY(this.topicId);
        }
        return aIw;
    }
}
