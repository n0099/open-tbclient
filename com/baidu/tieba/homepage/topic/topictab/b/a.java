package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tieba.tbadkCore.data.PostData;
import tbclient.NewTopicList.NewTopicList;
import tbclient.TopicModule;
/* loaded from: classes16.dex */
public class a extends com.baidu.tieba.card.data.c {
    public static final BdUniqueId iFD = BdUniqueId.gen();
    public static final BdUniqueId iFE = BdUniqueId.gen();
    private bv aii;
    public String dQI;
    public long dQJ;
    public String dQK;
    public int from = 0;
    public String iEl;
    public b iFF;
    public PostData iFG;
    public int index;
    public long topicId;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return this.from == 0 ? iFD : iFE;
    }

    public static boolean aa(bv bvVar) {
        return bvVar != null && bvVar.getType() == bv.dRJ;
    }

    public void a(NewTopicList newTopicList) {
        if (newTopicList != null) {
            this.topicId = newTopicList.topic_id.longValue();
            this.dQI = newTopicList.topic_name;
            this.dQK = newTopicList.topic_desc;
            this.dQJ = newTopicList.discuss_num.longValue();
            this.iEl = newTopicList.topic_image;
            if (newTopicList.pk_module != null && newTopicList.pk_module.agree != null && newTopicList.pk_module.disagree != null) {
                this.iFF = new b();
                this.iFF.topicId = this.topicId;
                this.iFF.from = 1;
                this.iFF.a(newTopicList.pk_module);
            }
            if (newTopicList.top_agree_post != null) {
                this.iFG = new PostData();
                this.iFG.a(newTopicList.top_agree_post, TbadkCoreApplication.getInst());
            }
        }
    }

    public void a(TopicModule topicModule) {
        if (topicModule != null) {
            this.topicId = topicModule.topic_id.longValue();
            this.dQI = topicModule.topic_name;
            this.dQK = topicModule.topic_desc;
            this.iEl = topicModule.topic_image;
            if (topicModule.pk_module != null && topicModule.pk_module.agree != null && topicModule.pk_module.disagree != null) {
                this.iFF = new b();
                this.iFF.topicId = this.topicId;
                this.iFF.from = 3;
                this.iFF.a(topicModule.pk_module);
            }
        }
    }

    public void setThreadData(bv bvVar) {
        this.aii = bvVar;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bv aTN() {
        return this.aii;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public aq aTP() {
        aq aTP = super.aTP();
        if (aTP != null) {
            aTP.cn(this.topicId);
        }
        return aTP;
    }
}
