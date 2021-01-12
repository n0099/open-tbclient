package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tieba.tbadkCore.data.PostData;
import tbclient.NewTopicList.NewTopicList;
import tbclient.TopicModule;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId khH = BdUniqueId.gen();
    public static final BdUniqueId khI = BdUniqueId.gen();
    private bz ale;
    public String eNh;
    public long eNi;
    public String eNj;
    public int from = 0;
    public int index;
    public String kgp;
    public b khJ;
    public PostData khK;
    public long topicId;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return this.from == 0 ? khH : khI;
    }

    public static boolean ad(bz bzVar) {
        return bzVar != null && bzVar.getType() == bz.eOo;
    }

    public void a(NewTopicList newTopicList) {
        if (newTopicList != null) {
            this.topicId = newTopicList.topic_id.longValue();
            this.eNh = newTopicList.topic_name;
            this.eNj = newTopicList.topic_desc;
            this.eNi = newTopicList.discuss_num.longValue();
            this.kgp = newTopicList.topic_image;
            if (newTopicList.pk_module != null && newTopicList.pk_module.agree != null && newTopicList.pk_module.disagree != null) {
                this.khJ = new b();
                this.khJ.topicId = this.topicId;
                this.khJ.from = 1;
                this.khJ.a(newTopicList.pk_module);
            }
            if (newTopicList.top_agree_post != null) {
                this.khK = new PostData();
                this.khK.a(newTopicList.top_agree_post, TbadkCoreApplication.getInst());
            }
        }
    }

    public void a(TopicModule topicModule) {
        if (topicModule != null) {
            this.topicId = topicModule.topic_id.longValue();
            this.eNh = topicModule.topic_name;
            this.eNj = topicModule.topic_desc;
            this.kgp = topicModule.topic_image;
            if (topicModule.pk_module != null && topicModule.pk_module.agree != null && topicModule.pk_module.disagree != null) {
                this.khJ = new b();
                this.khJ.topicId = this.topicId;
                this.khJ.from = 3;
                this.khJ.a(topicModule.pk_module);
            }
        }
    }

    public void setThreadData(bz bzVar) {
        this.ale = bzVar;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.tbadk.core.data.a
    public bz bkV() {
        return this.ale;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.tbadk.core.data.a
    public at bkX() {
        at bkX = super.bkX();
        if (bkX != null) {
            bkX.dD(this.topicId);
        }
        return bkX;
    }
}
