package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tieba.tbadkCore.data.PostData;
import tbclient.NewTopicList.NewTopicList;
import tbclient.TopicModule;
/* loaded from: classes22.dex */
public class a extends com.baidu.tieba.card.data.c {
    public static final BdUniqueId jso = BdUniqueId.gen();
    public static final BdUniqueId jsp = BdUniqueId.gen();
    private bw akp;
    public String eou;
    public long eov;
    public String eow;
    public int from = 0;
    public int index;
    public String jqW;
    public b jsq;
    public PostData jsr;
    public long topicId;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return this.from == 0 ? jso : jsp;
    }

    public static boolean ab(bw bwVar) {
        return bwVar != null && bwVar.getType() == bw.epy;
    }

    public void a(NewTopicList newTopicList) {
        if (newTopicList != null) {
            this.topicId = newTopicList.topic_id.longValue();
            this.eou = newTopicList.topic_name;
            this.eow = newTopicList.topic_desc;
            this.eov = newTopicList.discuss_num.longValue();
            this.jqW = newTopicList.topic_image;
            if (newTopicList.pk_module != null && newTopicList.pk_module.agree != null && newTopicList.pk_module.disagree != null) {
                this.jsq = new b();
                this.jsq.topicId = this.topicId;
                this.jsq.from = 1;
                this.jsq.a(newTopicList.pk_module);
            }
            if (newTopicList.top_agree_post != null) {
                this.jsr = new PostData();
                this.jsr.a(newTopicList.top_agree_post, TbadkCoreApplication.getInst());
            }
        }
    }

    public void a(TopicModule topicModule) {
        if (topicModule != null) {
            this.topicId = topicModule.topic_id.longValue();
            this.eou = topicModule.topic_name;
            this.eow = topicModule.topic_desc;
            this.jqW = topicModule.topic_image;
            if (topicModule.pk_module != null && topicModule.pk_module.agree != null && topicModule.pk_module.disagree != null) {
                this.jsq = new b();
                this.jsq.topicId = this.topicId;
                this.jsq.from = 3;
                this.jsq.a(topicModule.pk_module);
            }
        }
    }

    public void setThreadData(bw bwVar) {
        this.akp = bwVar;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bfG() {
        return this.akp;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ar bfI() {
        ar bfI = super.bfI();
        if (bfI != null) {
            bfI.cG(this.topicId);
        }
        return bfI;
    }
}
