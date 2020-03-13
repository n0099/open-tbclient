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
    public static final BdUniqueId hhI = BdUniqueId.gen();
    public static final BdUniqueId hhJ = BdUniqueId.gen();
    private bj NQ;
    public String cQC;
    public long cQD;
    public String cQE;
    public int from = 0;
    public String hgp;
    public b hhK;
    public PostData hhL;
    public int index;
    public long topicId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.from == 0 ? hhI : hhJ;
    }

    public static boolean aa(bj bjVar) {
        return bjVar != null && bjVar.getType() == bj.cRw;
    }

    public void a(NewTopicList newTopicList) {
        if (newTopicList != null) {
            this.topicId = newTopicList.topic_id.longValue();
            this.cQC = newTopicList.topic_name;
            this.cQE = newTopicList.topic_desc;
            this.cQD = newTopicList.discuss_num.longValue();
            this.hgp = newTopicList.topic_image;
            if (newTopicList.pk_module != null && newTopicList.pk_module.agree != null && newTopicList.pk_module.disagree != null) {
                this.hhK = new b();
                this.hhK.topicId = this.topicId;
                this.hhK.from = 1;
                this.hhK.a(newTopicList.pk_module);
            }
            if (newTopicList.top_agree_post != null) {
                this.hhL = new PostData();
                this.hhL.a(newTopicList.top_agree_post, TbadkCoreApplication.getInst());
            }
        }
    }

    public void a(TopicModule topicModule) {
        if (topicModule != null) {
            this.topicId = topicModule.topic_id.longValue();
            this.cQC = topicModule.topic_name;
            this.cQE = topicModule.topic_desc;
            this.hgp = topicModule.topic_image;
            if (topicModule.pk_module != null && topicModule.pk_module.agree != null && topicModule.pk_module.disagree != null) {
                this.hhK = new b();
                this.hhK.topicId = this.topicId;
                this.hhK.from = 3;
                this.hhK.a(topicModule.pk_module);
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
