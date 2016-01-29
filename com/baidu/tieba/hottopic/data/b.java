package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.u;
import tbclient.HottopicRanklist.TopicList;
import tbclient.HottopicRanklist.TopicListModule;
/* loaded from: classes.dex */
public class b implements u {
    public static final BdUniqueId bKL = BdUniqueId.gen();
    private long bKI;
    private String bKJ;
    private String bKK;
    private long mId;
    private String mName;
    private int mTag;
    String module_title;
    String rule_jump_url;
    String tips;

    public String XI() {
        return this.bKK;
    }

    public String XJ() {
        return this.bKJ;
    }

    public long getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public String XK() {
        return this.module_title;
    }

    public void a(TopicList topicList) {
        if (topicList != null) {
            this.mId = topicList.topic_id.longValue();
            this.mName = topicList.topic_name;
            this.mTag = topicList.tag.intValue();
            this.bKI = topicList.discuss_num.longValue();
            this.bKJ = topicList.topic_desc;
            this.bKK = topicList.topic_pic;
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

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return bKL;
    }
}
