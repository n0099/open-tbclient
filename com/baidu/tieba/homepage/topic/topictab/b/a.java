package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tieba.tbadkCore.data.PostData;
import tbclient.NewTopicList.NewTopicList;
import tbclient.TopicModule;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId kmn = BdUniqueId.gen();
    public static final BdUniqueId kmo = BdUniqueId.gen();
    private bz alW;
    public String eRS;
    public long eRT;
    public String eRU;
    public int from = 0;
    public int index;
    public String kkV;
    public b kmp;
    public PostData kmq;
    public long topicId;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return this.from == 0 ? kmn : kmo;
    }

    public static boolean ad(bz bzVar) {
        return bzVar != null && bzVar.getType() == bz.eSZ;
    }

    public void a(NewTopicList newTopicList) {
        if (newTopicList != null) {
            this.topicId = newTopicList.topic_id.longValue();
            this.eRS = newTopicList.topic_name;
            this.eRU = newTopicList.topic_desc;
            this.eRT = newTopicList.discuss_num.longValue();
            this.kkV = newTopicList.topic_image;
            if (newTopicList.pk_module != null && newTopicList.pk_module.agree != null && newTopicList.pk_module.disagree != null) {
                this.kmp = new b();
                this.kmp.topicId = this.topicId;
                this.kmp.from = 1;
                this.kmp.a(newTopicList.pk_module);
            }
            if (newTopicList.top_agree_post != null) {
                this.kmq = new PostData();
                this.kmq.a(newTopicList.top_agree_post, TbadkCoreApplication.getInst());
            }
        }
    }

    public void a(TopicModule topicModule) {
        if (topicModule != null) {
            this.topicId = topicModule.topic_id.longValue();
            this.eRS = topicModule.topic_name;
            this.eRU = topicModule.topic_desc;
            this.kkV = topicModule.topic_image;
            if (topicModule.pk_module != null && topicModule.pk_module.agree != null && topicModule.pk_module.disagree != null) {
                this.kmp = new b();
                this.kmp.topicId = this.topicId;
                this.kmp.from = 3;
                this.kmp.a(topicModule.pk_module);
            }
        }
    }

    public void setThreadData(bz bzVar) {
        this.alW = bzVar;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.tbadk.core.data.a
    public bz boO() {
        return this.alW;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.tbadk.core.data.a
    public at boQ() {
        at boQ = super.boQ();
        if (boQ != null) {
            boQ.dD(this.topicId);
        }
        return boQ;
    }
}
