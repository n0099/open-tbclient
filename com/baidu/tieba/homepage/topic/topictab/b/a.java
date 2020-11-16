package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tieba.tbadkCore.data.PostData;
import tbclient.NewTopicList.NewTopicList;
import tbclient.TopicModule;
/* loaded from: classes21.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId jLx = BdUniqueId.gen();
    public static final BdUniqueId jLy = BdUniqueId.gen();
    private bx akt;
    public String eBa;
    public long eBb;
    public String eBc;
    public int from = 0;
    public int index;
    public String jKe;
    public PostData jLA;
    public b jLz;
    public long topicId;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return this.from == 0 ? jLx : jLy;
    }

    public static boolean ad(bx bxVar) {
        return bxVar != null && bxVar.getType() == bx.eCf;
    }

    public void a(NewTopicList newTopicList) {
        if (newTopicList != null) {
            this.topicId = newTopicList.topic_id.longValue();
            this.eBa = newTopicList.topic_name;
            this.eBc = newTopicList.topic_desc;
            this.eBb = newTopicList.discuss_num.longValue();
            this.jKe = newTopicList.topic_image;
            if (newTopicList.pk_module != null && newTopicList.pk_module.agree != null && newTopicList.pk_module.disagree != null) {
                this.jLz = new b();
                this.jLz.topicId = this.topicId;
                this.jLz.from = 1;
                this.jLz.a(newTopicList.pk_module);
            }
            if (newTopicList.top_agree_post != null) {
                this.jLA = new PostData();
                this.jLA.a(newTopicList.top_agree_post, TbadkCoreApplication.getInst());
            }
        }
    }

    public void a(TopicModule topicModule) {
        if (topicModule != null) {
            this.topicId = topicModule.topic_id.longValue();
            this.eBa = topicModule.topic_name;
            this.eBc = topicModule.topic_desc;
            this.jKe = topicModule.topic_image;
            if (topicModule.pk_module != null && topicModule.pk_module.agree != null && topicModule.pk_module.disagree != null) {
                this.jLz = new b();
                this.jLz.topicId = this.topicId;
                this.jLz.from = 3;
                this.jLz.a(topicModule.pk_module);
            }
        }
    }

    public void setThreadData(bx bxVar) {
        this.akt = bxVar;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.tbadk.core.data.a
    public bx bjd() {
        return this.akt;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.tbadk.core.data.a
    public as bjf() {
        as bjf = super.bjf();
        if (bjf != null) {
            bjf.de(this.topicId);
        }
        return bjf;
    }
}
