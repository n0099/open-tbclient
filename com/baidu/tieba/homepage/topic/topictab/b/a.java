package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.tbadkCore.data.PostData;
import tbclient.NewTopicList.NewTopicList;
import tbclient.TopicModule;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId kqd = BdUniqueId.gen();
    public static final BdUniqueId kqe = BdUniqueId.gen();
    private cb akU;
    public String ePt;
    public long ePu;
    public String ePv;
    public int from = 0;
    public int index;
    public String koL;
    public b kqf;
    public PostData kqg;
    public long topicId;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return this.from == 0 ? kqd : kqe;
    }

    public static boolean ae(cb cbVar) {
        return cbVar != null && cbVar.getType() == cb.eQA;
    }

    public void a(NewTopicList newTopicList) {
        if (newTopicList != null) {
            this.topicId = newTopicList.topic_id.longValue();
            this.ePt = newTopicList.topic_name;
            this.ePv = newTopicList.topic_desc;
            this.ePu = newTopicList.discuss_num.longValue();
            this.koL = newTopicList.topic_image;
            if (newTopicList.pk_module != null && newTopicList.pk_module.agree != null && newTopicList.pk_module.disagree != null) {
                this.kqf = new b();
                this.kqf.topicId = this.topicId;
                this.kqf.from = 1;
                this.kqf.a(newTopicList.pk_module);
            }
            if (newTopicList.top_agree_post != null) {
                this.kqg = new PostData();
                this.kqg.a(newTopicList.top_agree_post, TbadkCoreApplication.getInst());
            }
        }
    }

    public void a(TopicModule topicModule) {
        if (topicModule != null) {
            this.topicId = topicModule.topic_id.longValue();
            this.ePt = topicModule.topic_name;
            this.ePv = topicModule.topic_desc;
            this.koL = topicModule.topic_image;
            if (topicModule.pk_module != null && topicModule.pk_module.agree != null && topicModule.pk_module.disagree != null) {
                this.kqf = new b();
                this.kqf.topicId = this.topicId;
                this.kqf.from = 3;
                this.kqf.a(topicModule.pk_module);
            }
        }
    }

    public void setThreadData(cb cbVar) {
        this.akU = cbVar;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.tbadk.core.data.a
    public cb bln() {
        return this.akU;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.tbadk.core.data.a
    public av blp() {
        av blp = super.blp();
        if (blp != null) {
            blp.dJ(this.topicId);
        }
        return blp;
    }
}
