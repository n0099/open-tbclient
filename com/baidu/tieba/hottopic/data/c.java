package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.q;
import tbclient.TopicList.TopicList;
import tbclient.TopicList.TopicListModule;
/* loaded from: classes15.dex */
public class c implements q {
    public static final BdUniqueId iYS = BdUniqueId.gen();
    private long iYO;
    private String iYP;
    private int iYT = -1;
    private String iYU;
    private long mId;
    private String mName;
    private int mTag;
    String module_title;
    String rule_jump_url;
    String tips;

    public String czU() {
        return this.module_title;
    }

    public String getTips() {
        return this.tips;
    }

    public String czV() {
        return this.rule_jump_url;
    }

    public long czW() {
        return this.iYO;
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

    public int czX() {
        return this.iYT;
    }

    public void Ar(int i) {
        this.iYT = i;
    }

    public void a(TopicList topicList) {
        if (topicList != null) {
            this.mId = topicList.topic_id.longValue();
            this.mName = topicList.topic_name;
            this.mTag = topicList.tag.intValue();
            this.iYO = topicList.discuss_num.longValue();
            this.iYP = topicList.topic_desc;
            this.iYU = topicList.topic_pic;
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
        return iYS;
    }
}
