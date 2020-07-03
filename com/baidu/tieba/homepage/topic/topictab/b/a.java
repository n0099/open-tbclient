package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tieba.tbadkCore.data.PostData;
import tbclient.NewTopicList.NewTopicList;
import tbclient.TopicModule;
/* loaded from: classes9.dex */
public class a extends com.baidu.tieba.card.data.c {
    private bu aiq;
    public String dKw;
    public long dKx;
    public String dKy;
    public int from = 0;
    public int index;
    public String iyh;
    public b izB;
    public PostData izC;
    public long topicId;
    public static final BdUniqueId izz = BdUniqueId.gen();
    public static final BdUniqueId izA = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return this.from == 0 ? izz : izA;
    }

    public static boolean ad(bu buVar) {
        return buVar != null && buVar.getType() == bu.dLy;
    }

    public void a(NewTopicList newTopicList) {
        if (newTopicList != null) {
            this.topicId = newTopicList.topic_id.longValue();
            this.dKw = newTopicList.topic_name;
            this.dKy = newTopicList.topic_desc;
            this.dKx = newTopicList.discuss_num.longValue();
            this.iyh = newTopicList.topic_image;
            if (newTopicList.pk_module != null && newTopicList.pk_module.agree != null && newTopicList.pk_module.disagree != null) {
                this.izB = new b();
                this.izB.topicId = this.topicId;
                this.izB.from = 1;
                this.izB.a(newTopicList.pk_module);
            }
            if (newTopicList.top_agree_post != null) {
                this.izC = new PostData();
                this.izC.a(newTopicList.top_agree_post, TbadkCoreApplication.getInst());
            }
        }
    }

    public void a(TopicModule topicModule) {
        if (topicModule != null) {
            this.topicId = topicModule.topic_id.longValue();
            this.dKw = topicModule.topic_name;
            this.dKy = topicModule.topic_desc;
            this.iyh = topicModule.topic_image;
            if (topicModule.pk_module != null && topicModule.pk_module.agree != null && topicModule.pk_module.disagree != null) {
                this.izB = new b();
                this.izB.topicId = this.topicId;
                this.izB.from = 3;
                this.izB.a(topicModule.pk_module);
            }
        }
    }

    public void setThreadData(bu buVar) {
        this.aiq = buVar;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bu aPS() {
        return this.aiq;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ap aPU() {
        ap aPU = super.aPU();
        if (aPU != null) {
            aPU.bY(this.topicId);
        }
        return aPU;
    }
}
