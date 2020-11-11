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
    public static final BdUniqueId jKM = BdUniqueId.gen();
    public static final BdUniqueId jKN = BdUniqueId.gen();
    private bw akq;
    public String eCJ;
    public long eCK;
    public String eCL;
    public int from = 0;
    public int index;
    public String jJt;
    public b jKO;
    public PostData jKP;
    public long topicId;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return this.from == 0 ? jKM : jKN;
    }

    public static boolean ab(bw bwVar) {
        return bwVar != null && bwVar.getType() == bw.eDN;
    }

    public void a(NewTopicList newTopicList) {
        if (newTopicList != null) {
            this.topicId = newTopicList.topic_id.longValue();
            this.eCJ = newTopicList.topic_name;
            this.eCL = newTopicList.topic_desc;
            this.eCK = newTopicList.discuss_num.longValue();
            this.jJt = newTopicList.topic_image;
            if (newTopicList.pk_module != null && newTopicList.pk_module.agree != null && newTopicList.pk_module.disagree != null) {
                this.jKO = new b();
                this.jKO.topicId = this.topicId;
                this.jKO.from = 1;
                this.jKO.a(newTopicList.pk_module);
            }
            if (newTopicList.top_agree_post != null) {
                this.jKP = new PostData();
                this.jKP.a(newTopicList.top_agree_post, TbadkCoreApplication.getInst());
            }
        }
    }

    public void a(TopicModule topicModule) {
        if (topicModule != null) {
            this.topicId = topicModule.topic_id.longValue();
            this.eCJ = topicModule.topic_name;
            this.eCL = topicModule.topic_desc;
            this.jJt = topicModule.topic_image;
            if (topicModule.pk_module != null && topicModule.pk_module.agree != null && topicModule.pk_module.disagree != null) {
                this.jKO = new b();
                this.jKO.topicId = this.topicId;
                this.jKO.from = 3;
                this.jKO.a(topicModule.pk_module);
            }
        }
    }

    public void setThreadData(bw bwVar) {
        this.akq = bwVar;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bjZ() {
        return this.akq;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ar bkb() {
        ar bkb = super.bkb();
        if (bkb != null) {
            bkb.de(this.topicId);
        }
        return bkb;
    }
}
