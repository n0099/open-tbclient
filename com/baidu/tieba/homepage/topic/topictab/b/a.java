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
    public static final BdUniqueId gnR = BdUniqueId.gen();
    public static final BdUniqueId gnS = BdUniqueId.gen();
    public String bII;
    public long bIJ;
    public String bIK;
    private bh ccq;
    public int from = 0;
    public String gmx;
    public b gnT;
    public PostData gnU;
    public int index;
    public long topicId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.from == 0 ? gnR : gnS;
    }

    public static boolean W(bh bhVar) {
        return bhVar != null && bhVar.getType() == bh.bJz;
    }

    public void a(NewTopicList newTopicList) {
        if (newTopicList != null) {
            this.topicId = newTopicList.topic_id.longValue();
            this.bII = newTopicList.topic_name;
            this.bIK = newTopicList.topic_desc;
            this.bIJ = newTopicList.discuss_num.longValue();
            this.gmx = newTopicList.topic_image;
            if (newTopicList.pk_module != null && newTopicList.pk_module.agree != null && newTopicList.pk_module.disagree != null) {
                this.gnT = new b();
                this.gnT.topicId = this.topicId;
                this.gnT.from = 1;
                this.gnT.a(newTopicList.pk_module);
            }
            if (newTopicList.top_agree_post != null) {
                this.gnU = new PostData();
                this.gnU.a(newTopicList.top_agree_post, TbadkCoreApplication.getInst());
            }
        }
    }

    public void a(TopicModule topicModule) {
        if (topicModule != null) {
            this.topicId = topicModule.topic_id.longValue();
            this.bII = topicModule.topic_name;
            this.bIK = topicModule.topic_desc;
            this.gmx = topicModule.topic_image;
            if (topicModule.pk_module != null && topicModule.pk_module.agree != null && topicModule.pk_module.disagree != null) {
                this.gnT = new b();
                this.gnT.topicId = this.topicId;
                this.gnT.from = 3;
                this.gnT.a(topicModule.pk_module);
            }
        }
    }

    public void aj(bh bhVar) {
        this.ccq = bhVar;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bh acy() {
        return this.ccq;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public aj acA() {
        aj acA = super.acA();
        if (acA != null) {
            acA.ap(this.topicId);
        }
        return acA;
    }
}
