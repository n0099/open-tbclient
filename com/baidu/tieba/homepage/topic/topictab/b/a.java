package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.tbadkCore.data.PostData;
import tbclient.NewTopicList.NewTopicList;
import tbclient.TopicModule;
/* loaded from: classes9.dex */
public class a extends com.baidu.tieba.card.data.c {
    public static final BdUniqueId iiv = BdUniqueId.gen();
    public static final BdUniqueId iiw = BdUniqueId.gen();
    private bk ahg;
    public String dDW;
    public long dDX;
    public String dDY;
    public int from = 0;
    public String ihc;
    public b iix;
    public PostData iiy;
    public int index;
    public long topicId;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return this.from == 0 ? iiv : iiw;
    }

    public static boolean ac(bk bkVar) {
        return bkVar != null && bkVar.getType() == bk.dEQ;
    }

    public void a(NewTopicList newTopicList) {
        if (newTopicList != null) {
            this.topicId = newTopicList.topic_id.longValue();
            this.dDW = newTopicList.topic_name;
            this.dDY = newTopicList.topic_desc;
            this.dDX = newTopicList.discuss_num.longValue();
            this.ihc = newTopicList.topic_image;
            if (newTopicList.pk_module != null && newTopicList.pk_module.agree != null && newTopicList.pk_module.disagree != null) {
                this.iix = new b();
                this.iix.topicId = this.topicId;
                this.iix.from = 1;
                this.iix.a(newTopicList.pk_module);
            }
            if (newTopicList.top_agree_post != null) {
                this.iiy = new PostData();
                this.iiy.a(newTopicList.top_agree_post, TbadkCoreApplication.getInst());
            }
        }
    }

    public void a(TopicModule topicModule) {
        if (topicModule != null) {
            this.topicId = topicModule.topic_id.longValue();
            this.dDW = topicModule.topic_name;
            this.dDY = topicModule.topic_desc;
            this.ihc = topicModule.topic_image;
            if (topicModule.pk_module != null && topicModule.pk_module.agree != null && topicModule.pk_module.disagree != null) {
                this.iix = new b();
                this.iix.topicId = this.topicId;
                this.iix.from = 3;
                this.iix.a(topicModule.pk_module);
            }
        }
    }

    public void setThreadData(bk bkVar) {
        this.ahg = bkVar;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bk aOi() {
        return this.ahg;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ak aOk() {
        ak aOk = super.aOk();
        if (aOk != null) {
            aOk.bY(this.topicId);
        }
        return aOk;
    }
}
