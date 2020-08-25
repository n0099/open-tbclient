package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tieba.tbadkCore.data.PostData;
import tbclient.NewTopicList.NewTopicList;
import tbclient.TopicModule;
/* loaded from: classes16.dex */
public class a extends com.baidu.tieba.card.data.c {
    public static final BdUniqueId iUD = BdUniqueId.gen();
    public static final BdUniqueId iUE = BdUniqueId.gen();
    private bw ajx;
    public String eab;
    public long eac;
    public String ead;
    public int from = 0;
    public String iTl;
    public b iUF;
    public PostData iUG;
    public int index;
    public long topicId;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return this.from == 0 ? iUD : iUE;
    }

    public static boolean aa(bw bwVar) {
        return bwVar != null && bwVar.getType() == bw.ebf;
    }

    public void a(NewTopicList newTopicList) {
        if (newTopicList != null) {
            this.topicId = newTopicList.topic_id.longValue();
            this.eab = newTopicList.topic_name;
            this.ead = newTopicList.topic_desc;
            this.eac = newTopicList.discuss_num.longValue();
            this.iTl = newTopicList.topic_image;
            if (newTopicList.pk_module != null && newTopicList.pk_module.agree != null && newTopicList.pk_module.disagree != null) {
                this.iUF = new b();
                this.iUF.topicId = this.topicId;
                this.iUF.from = 1;
                this.iUF.a(newTopicList.pk_module);
            }
            if (newTopicList.top_agree_post != null) {
                this.iUG = new PostData();
                this.iUG.a(newTopicList.top_agree_post, TbadkCoreApplication.getInst());
            }
        }
    }

    public void a(TopicModule topicModule) {
        if (topicModule != null) {
            this.topicId = topicModule.topic_id.longValue();
            this.eab = topicModule.topic_name;
            this.ead = topicModule.topic_desc;
            this.iTl = topicModule.topic_image;
            if (topicModule.pk_module != null && topicModule.pk_module.agree != null && topicModule.pk_module.disagree != null) {
                this.iUF = new b();
                this.iUF.topicId = this.topicId;
                this.iUF.from = 3;
                this.iUF.a(topicModule.pk_module);
            }
        }
    }

    public void setThreadData(bw bwVar) {
        this.ajx = bwVar;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bce() {
        return this.ajx;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ar bcg() {
        ar bcg = super.bcg();
        if (bcg != null) {
            bcg.cx(this.topicId);
        }
        return bcg;
    }
}
