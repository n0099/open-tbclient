package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.data.PostData;
import tbclient.NewTopicList.NewTopicList;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fPC = BdUniqueId.gen();
    public String bAq;
    public long bAr;
    public String bAs;
    public String fOf;
    public b fPD;
    public PostData fPE;
    public int index;
    public long topicId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fPC;
    }

    public void a(NewTopicList newTopicList) {
        if (newTopicList != null) {
            this.topicId = newTopicList.topic_id.longValue();
            this.bAq = newTopicList.topic_name;
            this.bAs = newTopicList.topic_desc;
            this.bAr = newTopicList.discuss_num.longValue();
            this.fOf = newTopicList.topic_image;
            if (newTopicList.pk_module != null && newTopicList.pk_module.agree != null && newTopicList.pk_module.disagree != null) {
                this.fPD = new b();
                this.fPD.topicId = this.topicId;
                this.fPD.from = 1;
                this.fPD.a(newTopicList.pk_module);
            }
            if (newTopicList.top_agree_post != null) {
                this.fPE = new PostData();
                this.fPE.a(newTopicList.top_agree_post, TbadkCoreApplication.getInst());
            }
        }
    }
}
