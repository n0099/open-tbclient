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
    public static final BdUniqueId ggM = BdUniqueId.gen();
    public static final BdUniqueId ggN = BdUniqueId.gen();
    public String bHD;
    public long bHE;
    public String bHF;
    private bg cbh;
    public int from = 0;
    public String gfr;
    public b ggO;
    public PostData ggP;
    public int index;
    public long topicId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.from == 0 ? ggM : ggN;
    }

    public static boolean V(bg bgVar) {
        return bgVar != null && bgVar.getType() == bg.bIu;
    }

    public void a(NewTopicList newTopicList) {
        if (newTopicList != null) {
            this.topicId = newTopicList.topic_id.longValue();
            this.bHD = newTopicList.topic_name;
            this.bHF = newTopicList.topic_desc;
            this.bHE = newTopicList.discuss_num.longValue();
            this.gfr = newTopicList.topic_image;
            if (newTopicList.pk_module != null && newTopicList.pk_module.agree != null && newTopicList.pk_module.disagree != null) {
                this.ggO = new b();
                this.ggO.topicId = this.topicId;
                this.ggO.from = 1;
                this.ggO.a(newTopicList.pk_module);
            }
            if (newTopicList.top_agree_post != null) {
                this.ggP = new PostData();
                this.ggP.a(newTopicList.top_agree_post, TbadkCoreApplication.getInst());
            }
        }
    }

    public void a(TopicModule topicModule) {
        if (topicModule != null) {
            this.topicId = topicModule.topic_id.longValue();
            this.bHD = topicModule.topic_name;
            this.bHF = topicModule.topic_desc;
            this.gfr = topicModule.topic_image;
            if (topicModule.pk_module != null && topicModule.pk_module.agree != null && topicModule.pk_module.disagree != null) {
                this.ggO = new b();
                this.ggO.topicId = this.topicId;
                this.ggO.from = 3;
                this.ggO.a(topicModule.pk_module);
            }
        }
    }

    public void ai(bg bgVar) {
        this.cbh = bgVar;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bg abv() {
        return this.cbh;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public aj abx() {
        aj abx = super.abx();
        if (abx != null) {
            abx.ao(this.topicId);
        }
        return abx;
    }
}
