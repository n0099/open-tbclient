package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import tbclient.TopicList.TopicList;
import tbclient.TopicList.TopicListModule;
/* loaded from: classes7.dex */
public class c implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId klV = BdUniqueId.gen();
    private long klR;
    private String klS;
    private int klW = -1;
    private String klX;
    private long mId;
    private String mName;
    private int mTag;
    String module_title;
    String rule_jump_url;
    String tips;

    public String cRe() {
        return this.module_title;
    }

    public String getTips() {
        return this.tips;
    }

    public String cRf() {
        return this.rule_jump_url;
    }

    public long cRg() {
        return this.klR;
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

    public int cRh() {
        return this.klW;
    }

    public void BY(int i) {
        this.klW = i;
    }

    public void a(TopicList topicList) {
        if (topicList != null) {
            this.mId = topicList.topic_id.longValue();
            this.mName = topicList.topic_name;
            this.mTag = topicList.tag.intValue();
            this.klR = topicList.discuss_num.longValue();
            this.klS = topicList.topic_desc;
            this.klX = topicList.topic_pic;
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

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return klV;
    }
}
