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
    public static final BdUniqueId gpI = BdUniqueId.gen();
    public static final BdUniqueId gpJ = BdUniqueId.gen();
    public String bJg;
    public long bJh;
    public String bJi;
    private bh cdk;
    public int from = 0;
    public String goo;
    public b gpK;
    public PostData gpL;
    public int index;
    public long topicId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.from == 0 ? gpI : gpJ;
    }

    public static boolean X(bh bhVar) {
        return bhVar != null && bhVar.getType() == bh.bJX;
    }

    public void a(NewTopicList newTopicList) {
        if (newTopicList != null) {
            this.topicId = newTopicList.topic_id.longValue();
            this.bJg = newTopicList.topic_name;
            this.bJi = newTopicList.topic_desc;
            this.bJh = newTopicList.discuss_num.longValue();
            this.goo = newTopicList.topic_image;
            if (newTopicList.pk_module != null && newTopicList.pk_module.agree != null && newTopicList.pk_module.disagree != null) {
                this.gpK = new b();
                this.gpK.topicId = this.topicId;
                this.gpK.from = 1;
                this.gpK.a(newTopicList.pk_module);
            }
            if (newTopicList.top_agree_post != null) {
                this.gpL = new PostData();
                this.gpL.a(newTopicList.top_agree_post, TbadkCoreApplication.getInst());
            }
        }
    }

    public void a(TopicModule topicModule) {
        if (topicModule != null) {
            this.topicId = topicModule.topic_id.longValue();
            this.bJg = topicModule.topic_name;
            this.bJi = topicModule.topic_desc;
            this.goo = topicModule.topic_image;
            if (topicModule.pk_module != null && topicModule.pk_module.agree != null && topicModule.pk_module.disagree != null) {
                this.gpK = new b();
                this.gpK.topicId = this.topicId;
                this.gpK.from = 3;
                this.gpK.a(topicModule.pk_module);
            }
        }
    }

    public void ak(bh bhVar) {
        this.cdk = bhVar;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bh acC() {
        return this.cdk;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public aj acE() {
        aj acE = super.acE();
        if (acE != null) {
            acE.ap(this.topicId);
        }
        return acE;
    }
}
