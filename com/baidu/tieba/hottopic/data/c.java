package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.q;
import tbclient.TopicList.TopicList;
import tbclient.TopicList.TopicListModule;
/* loaded from: classes21.dex */
public class c implements q {
    public static final BdUniqueId kdo = BdUniqueId.gen();
    private long kdk;
    private String kdl;
    private int kdp = -1;
    private String kdq;
    private long mId;
    private String mName;
    private int mTag;
    String module_title;
    String rule_jump_url;
    String tips;

    public String cRP() {
        return this.module_title;
    }

    public String getTips() {
        return this.tips;
    }

    public String cRQ() {
        return this.rule_jump_url;
    }

    public long cRR() {
        return this.kdk;
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

    public int cRS() {
        return this.kdp;
    }

    public void Dr(int i) {
        this.kdp = i;
    }

    public void a(TopicList topicList) {
        if (topicList != null) {
            this.mId = topicList.topic_id.longValue();
            this.mName = topicList.topic_name;
            this.mTag = topicList.tag.intValue();
            this.kdk = topicList.discuss_num.longValue();
            this.kdl = topicList.topic_desc;
            this.kdq = topicList.topic_pic;
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
        return kdo;
    }
}
