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
    public static final BdUniqueId hhw = BdUniqueId.gen();
    public static final BdUniqueId hhx = BdUniqueId.gen();
    private bj NQ;
    public String cQB;
    public long cQC;
    public String cQD;
    public int from = 0;
    public String hgd;
    public b hhy;
    public PostData hhz;
    public int index;
    public long topicId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.from == 0 ? hhw : hhx;
    }

    public static boolean aa(bj bjVar) {
        return bjVar != null && bjVar.getType() == bj.cRv;
    }

    public void a(NewTopicList newTopicList) {
        if (newTopicList != null) {
            this.topicId = newTopicList.topic_id.longValue();
            this.cQB = newTopicList.topic_name;
            this.cQD = newTopicList.topic_desc;
            this.cQC = newTopicList.discuss_num.longValue();
            this.hgd = newTopicList.topic_image;
            if (newTopicList.pk_module != null && newTopicList.pk_module.agree != null && newTopicList.pk_module.disagree != null) {
                this.hhy = new b();
                this.hhy.topicId = this.topicId;
                this.hhy.from = 1;
                this.hhy.a(newTopicList.pk_module);
            }
            if (newTopicList.top_agree_post != null) {
                this.hhz = new PostData();
                this.hhz.a(newTopicList.top_agree_post, TbadkCoreApplication.getInst());
            }
        }
    }

    public void a(TopicModule topicModule) {
        if (topicModule != null) {
            this.topicId = topicModule.topic_id.longValue();
            this.cQB = topicModule.topic_name;
            this.cQD = topicModule.topic_desc;
            this.hgd = topicModule.topic_image;
            if (topicModule.pk_module != null && topicModule.pk_module.agree != null && topicModule.pk_module.disagree != null) {
                this.hhy = new b();
                this.hhy.topicId = this.topicId;
                this.hhy.from = 3;
                this.hhy.a(topicModule.pk_module);
            }
        }
    }

    public void setThreadData(bj bjVar) {
        this.NQ = bjVar;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bj aAg() {
        return this.NQ;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public al aAi() {
        al aAi = super.aAi();
        if (aAi != null) {
            aAi.bt(this.topicId);
        }
        return aAi;
    }
}
