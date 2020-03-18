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
    public static final BdUniqueId hjj = BdUniqueId.gen();
    public static final BdUniqueId hjk = BdUniqueId.gen();
    private bj NR;
    public String cQP;
    public long cQQ;
    public String cQR;
    public int from = 0;
    public String hhP;
    public b hjl;
    public PostData hjm;
    public int index;
    public long topicId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.from == 0 ? hjj : hjk;
    }

    public static boolean ab(bj bjVar) {
        return bjVar != null && bjVar.getType() == bj.cRJ;
    }

    public void a(NewTopicList newTopicList) {
        if (newTopicList != null) {
            this.topicId = newTopicList.topic_id.longValue();
            this.cQP = newTopicList.topic_name;
            this.cQR = newTopicList.topic_desc;
            this.cQQ = newTopicList.discuss_num.longValue();
            this.hhP = newTopicList.topic_image;
            if (newTopicList.pk_module != null && newTopicList.pk_module.agree != null && newTopicList.pk_module.disagree != null) {
                this.hjl = new b();
                this.hjl.topicId = this.topicId;
                this.hjl.from = 1;
                this.hjl.a(newTopicList.pk_module);
            }
            if (newTopicList.top_agree_post != null) {
                this.hjm = new PostData();
                this.hjm.a(newTopicList.top_agree_post, TbadkCoreApplication.getInst());
            }
        }
    }

    public void a(TopicModule topicModule) {
        if (topicModule != null) {
            this.topicId = topicModule.topic_id.longValue();
            this.cQP = topicModule.topic_name;
            this.cQR = topicModule.topic_desc;
            this.hhP = topicModule.topic_image;
            if (topicModule.pk_module != null && topicModule.pk_module.agree != null && topicModule.pk_module.disagree != null) {
                this.hjl = new b();
                this.hjl.topicId = this.topicId;
                this.hjl.from = 3;
                this.hjl.a(topicModule.pk_module);
            }
        }
    }

    public void setThreadData(bj bjVar) {
        this.NR = bjVar;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bj aAj() {
        return this.NR;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public al aAl() {
        al aAl = super.aAl();
        if (aAl != null) {
            aAl.bt(this.topicId);
        }
        return aAl;
    }
}
