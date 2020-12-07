package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.q;
import tbclient.TopicList.TopicList;
import tbclient.TopicList.TopicListModule;
/* loaded from: classes21.dex */
public class c implements q {
    public static final BdUniqueId kdm = BdUniqueId.gen();
    private long kdi;
    private String kdj;
    private int kdn = -1;
    private String kdo;
    private long mId;
    private String mName;
    private int mTag;
    String module_title;
    String rule_jump_url;
    String tips;

    public String cRO() {
        return this.module_title;
    }

    public String getTips() {
        return this.tips;
    }

    public String cRP() {
        return this.rule_jump_url;
    }

    public long cRQ() {
        return this.kdi;
    }

    public int getTag() {
        return this.mTag;
    }

    public long getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public int cRR() {
        return this.kdn;
    }

    public void Dr(int i) {
        this.kdn = i;
    }

    public void a(TopicList topicList) {
        if (topicList != null) {
            this.mId = topicList.topic_id.longValue();
            this.mName = topicList.topic_name;
            this.mTag = topicList.tag.intValue();
            this.kdi = topicList.discuss_num.longValue();
            this.kdj = topicList.topic_desc;
            this.kdo = topicList.topic_pic;
        }
    }

    public void a(TopicListModule topicListModule) {
        try {
            this.module_title = topicListModule.module_title;
            this.tips = topicListModule.tips;
            this.rule_jump_url = topicListModule.rule_jump_url;
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kdm;
    }
}
