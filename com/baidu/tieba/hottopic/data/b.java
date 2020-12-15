package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.q;
import tbclient.TopicList.TopicList;
import tbclient.TopicList.TopicListModule;
/* loaded from: classes21.dex */
public class b implements q {
    public static final BdUniqueId kdn = BdUniqueId.gen();
    private long kdk;
    private String kdl;
    private String kdm;
    private long mId;
    private String mName;
    private int mTag;
    String module_title;
    String rule_jump_url;
    String tips;

    public String cRN() {
        return this.kdm;
    }

    public String cRO() {
        return this.kdl;
    }

    public long getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public String cRP() {
        return this.module_title;
    }

    public void a(TopicList topicList) {
        if (topicList != null) {
            this.mId = topicList.topic_id.longValue();
            this.mName = topicList.topic_name;
            this.mTag = topicList.tag.intValue();
            this.kdk = topicList.discuss_num.longValue();
            this.kdl = topicList.topic_desc;
            this.kdm = topicList.topic_pic;
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
        return kdn;
    }
}
