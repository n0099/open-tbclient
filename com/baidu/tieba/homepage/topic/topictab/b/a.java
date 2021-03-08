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
    public static final BdUniqueId ksf = BdUniqueId.gen();
    public static final BdUniqueId ksg = BdUniqueId.gen();
    private cb amn;
    public String eQU;
    public long eQV;
    public String eQW;
    public int from = 0;
    public int index;
    public String kqN;
    public b ksh;
    public PostData ksi;
    public long topicId;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return this.from == 0 ? ksf : ksg;
    }

    public static boolean ae(cb cbVar) {
        return cbVar != null && cbVar.getType() == cb.eSb;
    }

    public void a(NewTopicList newTopicList) {
        if (newTopicList != null) {
            this.topicId = newTopicList.topic_id.longValue();
            this.eQU = newTopicList.topic_name;
            this.eQW = newTopicList.topic_desc;
            this.eQV = newTopicList.discuss_num.longValue();
            this.kqN = newTopicList.topic_image;
            if (newTopicList.pk_module != null && newTopicList.pk_module.agree != null && newTopicList.pk_module.disagree != null) {
                this.ksh = new b();
                this.ksh.topicId = this.topicId;
                this.ksh.from = 1;
                this.ksh.a(newTopicList.pk_module);
            }
            if (newTopicList.top_agree_post != null) {
                this.ksi = new PostData();
                this.ksi.a(newTopicList.top_agree_post, TbadkCoreApplication.getInst());
            }
        }
    }

    public void a(TopicModule topicModule) {
        if (topicModule != null) {
            this.topicId = topicModule.topic_id.longValue();
            this.eQU = topicModule.topic_name;
            this.eQW = topicModule.topic_desc;
            this.kqN = topicModule.topic_image;
            if (topicModule.pk_module != null && topicModule.pk_module.agree != null && topicModule.pk_module.disagree != null) {
                this.ksh = new b();
                this.ksh.topicId = this.topicId;
                this.ksh.from = 3;
                this.ksh.a(topicModule.pk_module);
            }
        }
    }

    public void setThreadData(cb cbVar) {
        this.amn = cbVar;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.tbadk.core.data.a
    public cb blp() {
        return this.amn;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.tbadk.core.data.a
    public av blr() {
        av blr = super.blr();
        if (blr != null) {
            blr.dJ(this.topicId);
        }
        return blr;
    }
}
