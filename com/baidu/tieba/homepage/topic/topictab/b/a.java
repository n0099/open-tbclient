package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.tbadkCore.data.PostData;
import tbclient.NewTopicList.NewTopicList;
import tbclient.TopicModule;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.card.data.c {
    public static final BdUniqueId hbR = BdUniqueId.gen();
    public static final BdUniqueId hbS = BdUniqueId.gen();
    private bj Nl;
    public String cMn;
    public long cMo;
    public String cMp;
    public int from = 0;
    public String hax;
    public b hbT;
    public PostData hbU;
    public int index;
    public long topicId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.from == 0 ? hbR : hbS;
    }

    public static boolean Y(bj bjVar) {
        return bjVar != null && bjVar.getType() == bj.cNh;
    }

    public void a(NewTopicList newTopicList) {
        if (newTopicList != null) {
            this.topicId = newTopicList.topic_id.longValue();
            this.cMn = newTopicList.topic_name;
            this.cMp = newTopicList.topic_desc;
            this.cMo = newTopicList.discuss_num.longValue();
            this.hax = newTopicList.topic_image;
            if (newTopicList.pk_module != null && newTopicList.pk_module.agree != null && newTopicList.pk_module.disagree != null) {
                this.hbT = new b();
                this.hbT.topicId = this.topicId;
                this.hbT.from = 1;
                this.hbT.a(newTopicList.pk_module);
            }
            if (newTopicList.top_agree_post != null) {
                this.hbU = new PostData();
                this.hbU.a(newTopicList.top_agree_post, TbadkCoreApplication.getInst());
            }
        }
    }

    public void a(TopicModule topicModule) {
        if (topicModule != null) {
            this.topicId = topicModule.topic_id.longValue();
            this.cMn = topicModule.topic_name;
            this.cMp = topicModule.topic_desc;
            this.hax = topicModule.topic_image;
            if (topicModule.pk_module != null && topicModule.pk_module.agree != null && topicModule.pk_module.disagree != null) {
                this.hbT = new b();
                this.hbT.topicId = this.topicId;
                this.hbT.from = 3;
                this.hbT.a(topicModule.pk_module);
            }
        }
    }

    public void setThreadData(bj bjVar) {
        this.Nl = bjVar;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bj axx() {
        return this.Nl;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public al axz() {
        al axz = super.axz();
        if (axz != null) {
            axz.bm(this.topicId);
        }
        return axz;
    }
}
