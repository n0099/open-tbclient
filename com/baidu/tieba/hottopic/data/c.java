package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.q;
import tbclient.TopicList.TopicList;
import tbclient.TopicList.TopicListModule;
/* loaded from: classes20.dex */
public class c implements q {
    public static final BdUniqueId jhD = BdUniqueId.gen();
    private String jhA;
    private int jhE = -1;
    private String jhF;
    private long jhz;
    private long mId;
    private String mName;
    private int mTag;
    String module_title;
    String rule_jump_url;
    String tips;

    public String cDC() {
        return this.module_title;
    }

    public String getTips() {
        return this.tips;
    }

    public String cDD() {
        return this.rule_jump_url;
    }

    public long cDE() {
        return this.jhz;
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

    public int cDF() {
        return this.jhE;
    }

    public void AS(int i) {
        this.jhE = i;
    }

    public void a(TopicList topicList) {
        if (topicList != null) {
            this.mId = topicList.topic_id.longValue();
            this.mName = topicList.topic_name;
            this.mTag = topicList.tag.intValue();
            this.jhz = topicList.discuss_num.longValue();
            this.jhA = topicList.topic_desc;
            this.jhF = topicList.topic_pic;
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
        return jhD;
    }
}
