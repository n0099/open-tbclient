package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.tbadkCore.data.PostData;
import tbclient.NewTopicList.NewTopicList;
import tbclient.TopicModule;
/* loaded from: classes7.dex */
public class a extends com.baidu.tieba.card.data.c {
    public static final BdUniqueId hfu = BdUniqueId.gen();
    public static final BdUniqueId hfv = BdUniqueId.gen();
    private bj Np;
    public String cMx;
    public long cMy;
    public String cMz;
    public int from = 0;
    public String hea;
    public b hfw;
    public PostData hfx;
    public int index;
    public long topicId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.from == 0 ? hfu : hfv;
    }

    public static boolean Z(bj bjVar) {
        return bjVar != null && bjVar.getType() == bj.cNr;
    }

    public void a(NewTopicList newTopicList) {
        if (newTopicList != null) {
            this.topicId = newTopicList.topic_id.longValue();
            this.cMx = newTopicList.topic_name;
            this.cMz = newTopicList.topic_desc;
            this.cMy = newTopicList.discuss_num.longValue();
            this.hea = newTopicList.topic_image;
            if (newTopicList.pk_module != null && newTopicList.pk_module.agree != null && newTopicList.pk_module.disagree != null) {
                this.hfw = new b();
                this.hfw.topicId = this.topicId;
                this.hfw.from = 1;
                this.hfw.a(newTopicList.pk_module);
            }
            if (newTopicList.top_agree_post != null) {
                this.hfx = new PostData();
                this.hfx.a(newTopicList.top_agree_post, TbadkCoreApplication.getInst());
            }
        }
    }

    public void a(TopicModule topicModule) {
        if (topicModule != null) {
            this.topicId = topicModule.topic_id.longValue();
            this.cMx = topicModule.topic_name;
            this.cMz = topicModule.topic_desc;
            this.hea = topicModule.topic_image;
            if (topicModule.pk_module != null && topicModule.pk_module.agree != null && topicModule.pk_module.disagree != null) {
                this.hfw = new b();
                this.hfw.topicId = this.topicId;
                this.hfw.from = 3;
                this.hfw.a(topicModule.pk_module);
            }
        }
    }

    public void setThreadData(bj bjVar) {
        this.Np = bjVar;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bj axQ() {
        return this.Np;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public al axS() {
        al axS = super.axS();
        if (axS != null) {
            axS.bp(this.topicId);
        }
        return axS;
    }
}
