package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.tbadkCore.data.PostData;
import tbclient.NewTopicList.NewTopicList;
import tbclient.TopicModule;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.card.data.c {
    public static final BdUniqueId goq = BdUniqueId.gen();
    public static final BdUniqueId gor = BdUniqueId.gen();
    public String bZW;
    public long bZX;
    public String bZY;
    private bh cqG;
    public int from = 0;
    public String gmW;
    public b gos;
    public PostData got;
    public int index;
    public long topicId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.from == 0 ? goq : gor;
    }

    public static boolean V(bh bhVar) {
        return bhVar != null && bhVar.getType() == bh.caO;
    }

    public void a(NewTopicList newTopicList) {
        if (newTopicList != null) {
            this.topicId = newTopicList.topic_id.longValue();
            this.bZW = newTopicList.topic_name;
            this.bZY = newTopicList.topic_desc;
            this.bZX = newTopicList.discuss_num.longValue();
            this.gmW = newTopicList.topic_image;
            if (newTopicList.pk_module != null && newTopicList.pk_module.agree != null && newTopicList.pk_module.disagree != null) {
                this.gos = new b();
                this.gos.topicId = this.topicId;
                this.gos.from = 1;
                this.gos.a(newTopicList.pk_module);
            }
            if (newTopicList.top_agree_post != null) {
                this.got = new PostData();
                this.got.a(newTopicList.top_agree_post, TbadkCoreApplication.getInst());
            }
        }
    }

    public void a(TopicModule topicModule) {
        if (topicModule != null) {
            this.topicId = topicModule.topic_id.longValue();
            this.bZW = topicModule.topic_name;
            this.bZY = topicModule.topic_desc;
            this.gmW = topicModule.topic_image;
            if (topicModule.pk_module != null && topicModule.pk_module.agree != null && topicModule.pk_module.disagree != null) {
                this.gos = new b();
                this.gos.topicId = this.topicId;
                this.gos.from = 3;
                this.gos.a(topicModule.pk_module);
            }
        }
    }

    public void ai(bh bhVar) {
        this.cqG = bhVar;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bh agG() {
        return this.cqG;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public aj agI() {
        aj agI = super.agI();
        if (agI != null) {
            agI.aH(this.topicId);
        }
        return agI;
    }
}
