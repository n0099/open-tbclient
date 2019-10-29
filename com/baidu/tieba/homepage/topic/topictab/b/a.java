package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.tbadkCore.data.PostData;
import tbclient.NewTopicList.NewTopicList;
import tbclient.TopicModule;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.card.data.c {
    public static final BdUniqueId gph = BdUniqueId.gen();
    public static final BdUniqueId gpi = BdUniqueId.gen();
    public String caN;
    public long caO;
    public String caP;
    private bh cry;
    public int from = 0;
    public String gnN;
    public b gpj;
    public PostData gpk;
    public int index;
    public long topicId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.from == 0 ? gph : gpi;
    }

    public static boolean V(bh bhVar) {
        return bhVar != null && bhVar.getType() == bh.cbF;
    }

    public void a(NewTopicList newTopicList) {
        if (newTopicList != null) {
            this.topicId = newTopicList.topic_id.longValue();
            this.caN = newTopicList.topic_name;
            this.caP = newTopicList.topic_desc;
            this.caO = newTopicList.discuss_num.longValue();
            this.gnN = newTopicList.topic_image;
            if (newTopicList.pk_module != null && newTopicList.pk_module.agree != null && newTopicList.pk_module.disagree != null) {
                this.gpj = new b();
                this.gpj.topicId = this.topicId;
                this.gpj.from = 1;
                this.gpj.a(newTopicList.pk_module);
            }
            if (newTopicList.top_agree_post != null) {
                this.gpk = new PostData();
                this.gpk.a(newTopicList.top_agree_post, TbadkCoreApplication.getInst());
            }
        }
    }

    public void a(TopicModule topicModule) {
        if (topicModule != null) {
            this.topicId = topicModule.topic_id.longValue();
            this.caN = topicModule.topic_name;
            this.caP = topicModule.topic_desc;
            this.gnN = topicModule.topic_image;
            if (topicModule.pk_module != null && topicModule.pk_module.agree != null && topicModule.pk_module.disagree != null) {
                this.gpj = new b();
                this.gpj.topicId = this.topicId;
                this.gpj.from = 3;
                this.gpj.a(topicModule.pk_module);
            }
        }
    }

    public void ai(bh bhVar) {
        this.cry = bhVar;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bh agI() {
        return this.cry;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public aj agK() {
        aj agK = super.agK();
        if (agK != null) {
            agK.aI(this.topicId);
        }
        return agK;
    }
}
