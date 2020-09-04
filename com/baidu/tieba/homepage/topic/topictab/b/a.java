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
    public static final BdUniqueId iUJ = BdUniqueId.gen();
    public static final BdUniqueId iUK = BdUniqueId.gen();
    private bw ajz;
    public String eaf;
    public long eag;
    public String eah;
    public int from = 0;
    public String iTr;
    public b iUL;
    public PostData iUM;
    public int index;
    public long topicId;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return this.from == 0 ? iUJ : iUK;
    }

    public static boolean aa(bw bwVar) {
        return bwVar != null && bwVar.getType() == bw.ebj;
    }

    public void a(NewTopicList newTopicList) {
        if (newTopicList != null) {
            this.topicId = newTopicList.topic_id.longValue();
            this.eaf = newTopicList.topic_name;
            this.eah = newTopicList.topic_desc;
            this.eag = newTopicList.discuss_num.longValue();
            this.iTr = newTopicList.topic_image;
            if (newTopicList.pk_module != null && newTopicList.pk_module.agree != null && newTopicList.pk_module.disagree != null) {
                this.iUL = new b();
                this.iUL.topicId = this.topicId;
                this.iUL.from = 1;
                this.iUL.a(newTopicList.pk_module);
            }
            if (newTopicList.top_agree_post != null) {
                this.iUM = new PostData();
                this.iUM.a(newTopicList.top_agree_post, TbadkCoreApplication.getInst());
            }
        }
    }

    public void a(TopicModule topicModule) {
        if (topicModule != null) {
            this.topicId = topicModule.topic_id.longValue();
            this.eaf = topicModule.topic_name;
            this.eah = topicModule.topic_desc;
            this.iTr = topicModule.topic_image;
            if (topicModule.pk_module != null && topicModule.pk_module.agree != null && topicModule.pk_module.disagree != null) {
                this.iUL = new b();
                this.iUL.topicId = this.topicId;
                this.iUL.from = 3;
                this.iUL.a(topicModule.pk_module);
            }
        }
    }

    public void setThreadData(bw bwVar) {
        this.ajz = bwVar;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bce() {
        return this.ajz;
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
