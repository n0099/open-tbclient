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
    public static final BdUniqueId kpP = BdUniqueId.gen();
    public static final BdUniqueId kpQ = BdUniqueId.gen();
    private cb akU;
    public String ePt;
    public long ePu;
    public String ePv;
    public int from = 0;
    public int index;
    public String kox;
    public b kpR;
    public PostData kpS;
    public long topicId;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return this.from == 0 ? kpP : kpQ;
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
            this.kox = newTopicList.topic_image;
            if (newTopicList.pk_module != null && newTopicList.pk_module.agree != null && newTopicList.pk_module.disagree != null) {
                this.kpR = new b();
                this.kpR.topicId = this.topicId;
                this.kpR.from = 1;
                this.kpR.a(newTopicList.pk_module);
            }
            if (newTopicList.top_agree_post != null) {
                this.kpS = new PostData();
                this.kpS.a(newTopicList.top_agree_post, TbadkCoreApplication.getInst());
            }
        }
    }

    public void a(TopicModule topicModule) {
        if (topicModule != null) {
            this.topicId = topicModule.topic_id.longValue();
            this.ePt = topicModule.topic_name;
            this.ePv = topicModule.topic_desc;
            this.kox = topicModule.topic_image;
            if (topicModule.pk_module != null && topicModule.pk_module.agree != null && topicModule.pk_module.disagree != null) {
                this.kpR = new b();
                this.kpR.topicId = this.topicId;
                this.kpR.from = 3;
                this.kpR.a(topicModule.pk_module);
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
