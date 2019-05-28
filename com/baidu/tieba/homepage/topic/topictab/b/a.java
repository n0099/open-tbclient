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
    public static final BdUniqueId ggK = BdUniqueId.gen();
    public static final BdUniqueId ggL = BdUniqueId.gen();
    public String bHC;
    public long bHD;
    public String bHE;
    private bg cbg;
    public int from = 0;
    public String gfp;
    public b ggM;
    public PostData ggN;
    public int index;
    public long topicId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.from == 0 ? ggK : ggL;
    }

    public static boolean V(bg bgVar) {
        return bgVar != null && bgVar.getType() == bg.bIt;
    }

    public void a(NewTopicList newTopicList) {
        if (newTopicList != null) {
            this.topicId = newTopicList.topic_id.longValue();
            this.bHC = newTopicList.topic_name;
            this.bHE = newTopicList.topic_desc;
            this.bHD = newTopicList.discuss_num.longValue();
            this.gfp = newTopicList.topic_image;
            if (newTopicList.pk_module != null && newTopicList.pk_module.agree != null && newTopicList.pk_module.disagree != null) {
                this.ggM = new b();
                this.ggM.topicId = this.topicId;
                this.ggM.from = 1;
                this.ggM.a(newTopicList.pk_module);
            }
            if (newTopicList.top_agree_post != null) {
                this.ggN = new PostData();
                this.ggN.a(newTopicList.top_agree_post, TbadkCoreApplication.getInst());
            }
        }
    }

    public void a(TopicModule topicModule) {
        if (topicModule != null) {
            this.topicId = topicModule.topic_id.longValue();
            this.bHC = topicModule.topic_name;
            this.bHE = topicModule.topic_desc;
            this.gfp = topicModule.topic_image;
            if (topicModule.pk_module != null && topicModule.pk_module.agree != null && topicModule.pk_module.disagree != null) {
                this.ggM = new b();
                this.ggM.topicId = this.topicId;
                this.ggM.from = 3;
                this.ggM.a(topicModule.pk_module);
            }
        }
    }

    public void ai(bg bgVar) {
        this.cbg = bgVar;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bg abv() {
        return this.cbg;
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
