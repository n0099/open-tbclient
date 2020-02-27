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
    public static final BdUniqueId hhu = BdUniqueId.gen();
    public static final BdUniqueId hhv = BdUniqueId.gen();
    private bj NQ;
    public String cQA;
    public long cQB;
    public String cQC;
    public int from = 0;
    public String hgb;
    public b hhw;
    public PostData hhx;
    public int index;
    public long topicId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.from == 0 ? hhu : hhv;
    }

    public static boolean aa(bj bjVar) {
        return bjVar != null && bjVar.getType() == bj.cRu;
    }

    public void a(NewTopicList newTopicList) {
        if (newTopicList != null) {
            this.topicId = newTopicList.topic_id.longValue();
            this.cQA = newTopicList.topic_name;
            this.cQC = newTopicList.topic_desc;
            this.cQB = newTopicList.discuss_num.longValue();
            this.hgb = newTopicList.topic_image;
            if (newTopicList.pk_module != null && newTopicList.pk_module.agree != null && newTopicList.pk_module.disagree != null) {
                this.hhw = new b();
                this.hhw.topicId = this.topicId;
                this.hhw.from = 1;
                this.hhw.a(newTopicList.pk_module);
            }
            if (newTopicList.top_agree_post != null) {
                this.hhx = new PostData();
                this.hhx.a(newTopicList.top_agree_post, TbadkCoreApplication.getInst());
            }
        }
    }

    public void a(TopicModule topicModule) {
        if (topicModule != null) {
            this.topicId = topicModule.topic_id.longValue();
            this.cQA = topicModule.topic_name;
            this.cQC = topicModule.topic_desc;
            this.hgb = topicModule.topic_image;
            if (topicModule.pk_module != null && topicModule.pk_module.agree != null && topicModule.pk_module.disagree != null) {
                this.hhw = new b();
                this.hhw.topicId = this.topicId;
                this.hhw.from = 3;
                this.hhw.a(topicModule.pk_module);
            }
        }
    }

    public void setThreadData(bj bjVar) {
        this.NQ = bjVar;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bj aAe() {
        return this.NQ;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public al aAg() {
        al aAg = super.aAg();
        if (aAg != null) {
            aAg.bt(this.topicId);
        }
        return aAg;
    }
}
