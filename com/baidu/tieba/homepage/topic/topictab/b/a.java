package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.by;
import com.baidu.tieba.tbadkCore.data.PostData;
import tbclient.NewTopicList.NewTopicList;
import tbclient.TopicModule;
/* loaded from: classes22.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId jZa = BdUniqueId.gen();
    public static final BdUniqueId jZb = BdUniqueId.gen();
    private by alu;
    public String eIa;
    public long eIb;
    public String eIc;
    public int from = 0;
    public int index;
    public String jXH;
    public b jZc;
    public PostData jZd;
    public long topicId;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return this.from == 0 ? jZa : jZb;
    }

    public static boolean ad(by byVar) {
        return byVar != null && byVar.getType() == by.eJg;
    }

    public void a(NewTopicList newTopicList) {
        if (newTopicList != null) {
            this.topicId = newTopicList.topic_id.longValue();
            this.eIa = newTopicList.topic_name;
            this.eIc = newTopicList.topic_desc;
            this.eIb = newTopicList.discuss_num.longValue();
            this.jXH = newTopicList.topic_image;
            if (newTopicList.pk_module != null && newTopicList.pk_module.agree != null && newTopicList.pk_module.disagree != null) {
                this.jZc = new b();
                this.jZc.topicId = this.topicId;
                this.jZc.from = 1;
                this.jZc.a(newTopicList.pk_module);
            }
            if (newTopicList.top_agree_post != null) {
                this.jZd = new PostData();
                this.jZd.a(newTopicList.top_agree_post, TbadkCoreApplication.getInst());
            }
        }
    }

    public void a(TopicModule topicModule) {
        if (topicModule != null) {
            this.topicId = topicModule.topic_id.longValue();
            this.eIa = topicModule.topic_name;
            this.eIc = topicModule.topic_desc;
            this.jXH = topicModule.topic_image;
            if (topicModule.pk_module != null && topicModule.pk_module.agree != null && topicModule.pk_module.disagree != null) {
                this.jZc = new b();
                this.jZc.topicId = this.topicId;
                this.jZc.from = 3;
                this.jZc.a(topicModule.pk_module);
            }
        }
    }

    public void setThreadData(by byVar) {
        this.alu = byVar;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.tbadk.core.data.a
    public by bmn() {
        return this.alu;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.tbadk.core.data.a
    public at bmp() {
        at bmp = super.bmp();
        if (bmp != null) {
            bmp.dD(this.topicId);
        }
        return bmp;
    }
}
