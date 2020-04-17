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
    public static final BdUniqueId hSS = BdUniqueId.gen();
    public static final BdUniqueId hST = BdUniqueId.gen();
    private bj agz;
    public String dpV;
    public long dpW;
    public String dpX;
    public int from = 0;
    public String hRz;
    public b hSU;
    public PostData hSV;
    public int index;
    public long topicId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.from == 0 ? hSS : hST;
    }

    public static boolean ab(bj bjVar) {
        return bjVar != null && bjVar.getType() == bj.dqQ;
    }

    public void a(NewTopicList newTopicList) {
        if (newTopicList != null) {
            this.topicId = newTopicList.topic_id.longValue();
            this.dpV = newTopicList.topic_name;
            this.dpX = newTopicList.topic_desc;
            this.dpW = newTopicList.discuss_num.longValue();
            this.hRz = newTopicList.topic_image;
            if (newTopicList.pk_module != null && newTopicList.pk_module.agree != null && newTopicList.pk_module.disagree != null) {
                this.hSU = new b();
                this.hSU.topicId = this.topicId;
                this.hSU.from = 1;
                this.hSU.a(newTopicList.pk_module);
            }
            if (newTopicList.top_agree_post != null) {
                this.hSV = new PostData();
                this.hSV.a(newTopicList.top_agree_post, TbadkCoreApplication.getInst());
            }
        }
    }

    public void a(TopicModule topicModule) {
        if (topicModule != null) {
            this.topicId = topicModule.topic_id.longValue();
            this.dpV = topicModule.topic_name;
            this.dpX = topicModule.topic_desc;
            this.hRz = topicModule.topic_image;
            if (topicModule.pk_module != null && topicModule.pk_module.agree != null && topicModule.pk_module.disagree != null) {
                this.hSU = new b();
                this.hSU.topicId = this.topicId;
                this.hSU.from = 3;
                this.hSU.a(topicModule.pk_module);
            }
        }
    }

    public void setThreadData(bj bjVar) {
        this.agz = bjVar;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bj aIw() {
        return this.agz;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public al aIy() {
        al aIy = super.aIy();
        if (aIy != null) {
            aIy.bY(this.topicId);
        }
        return aIy;
    }
}
