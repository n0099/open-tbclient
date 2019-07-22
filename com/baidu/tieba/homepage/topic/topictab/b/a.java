package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.tbadkCore.data.PostData;
import tbclient.NewTopicList.NewTopicList;
import tbclient.TopicModule;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.card.data.c {
    public static final BdUniqueId gmZ = BdUniqueId.gen();
    public static final BdUniqueId gna = BdUniqueId.gen();
    public String bID;
    public long bIE;
    public String bIF;
    private bg ccj;
    public int from = 0;
    public String glF;
    public b gnb;
    public PostData gnc;
    public int index;
    public long topicId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.from == 0 ? gmZ : gna;
    }

    public static boolean V(bg bgVar) {
        return bgVar != null && bgVar.getType() == bg.bJu;
    }

    public void a(NewTopicList newTopicList) {
        if (newTopicList != null) {
            this.topicId = newTopicList.topic_id.longValue();
            this.bID = newTopicList.topic_name;
            this.bIF = newTopicList.topic_desc;
            this.bIE = newTopicList.discuss_num.longValue();
            this.glF = newTopicList.topic_image;
            if (newTopicList.pk_module != null && newTopicList.pk_module.agree != null && newTopicList.pk_module.disagree != null) {
                this.gnb = new b();
                this.gnb.topicId = this.topicId;
                this.gnb.from = 1;
                this.gnb.a(newTopicList.pk_module);
            }
            if (newTopicList.top_agree_post != null) {
                this.gnc = new PostData();
                this.gnc.a(newTopicList.top_agree_post, TbadkCoreApplication.getInst());
            }
        }
    }

    public void a(TopicModule topicModule) {
        if (topicModule != null) {
            this.topicId = topicModule.topic_id.longValue();
            this.bID = topicModule.topic_name;
            this.bIF = topicModule.topic_desc;
            this.glF = topicModule.topic_image;
            if (topicModule.pk_module != null && topicModule.pk_module.agree != null && topicModule.pk_module.disagree != null) {
                this.gnb = new b();
                this.gnb.topicId = this.topicId;
                this.gnb.from = 3;
                this.gnb.a(topicModule.pk_module);
            }
        }
    }

    public void ai(bg bgVar) {
        this.ccj = bgVar;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bg acx() {
        return this.ccj;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public aj acz() {
        aj acz = super.acz();
        if (acz != null) {
            acz.ap(this.topicId);
        }
        return acz;
    }
}
