package com.baidu.tieba.homepage.topic.topictab.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.data.PostData;
import tbclient.NewTopicList.NewTopicList;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fPO = BdUniqueId.gen();
    public String bAk;
    public long bAl;
    public String bAm;
    public String fOs;
    public b fPP;
    public PostData fPQ;
    public int index;
    public long topicId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fPO;
    }

    public void a(NewTopicList newTopicList) {
        if (newTopicList != null) {
            this.topicId = newTopicList.topic_id.longValue();
            this.bAk = newTopicList.topic_name;
            this.bAm = newTopicList.topic_desc;
            this.bAl = newTopicList.discuss_num.longValue();
            this.fOs = newTopicList.topic_image;
            if (newTopicList.pk_module != null && newTopicList.pk_module.agree != null && newTopicList.pk_module.disagree != null) {
                this.fPP = new b();
                this.fPP.topicId = this.topicId;
                this.fPP.from = 1;
                this.fPP.a(newTopicList.pk_module);
            }
            if (newTopicList.top_agree_post != null) {
                this.fPQ = new PostData();
                this.fPQ.a(newTopicList.top_agree_post, TbadkCoreApplication.getInst());
            }
        }
    }
}
