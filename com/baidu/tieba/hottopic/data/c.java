package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.q;
import tbclient.TopicList.TopicList;
import tbclient.TopicList.TopicListModule;
/* loaded from: classes8.dex */
public class c implements q {
    public static final BdUniqueId iDO = BdUniqueId.gen();
    private long iDK;
    private String iDL;
    private int iDP = -1;
    private String iDQ;
    private long mId;
    private String mName;
    private int mTag;
    String module_title;
    String rule_jump_url;
    String tips;

    public String clA() {
        return this.module_title;
    }

    public String getTips() {
        return this.tips;
    }

    public String clB() {
        return this.rule_jump_url;
    }

    public long clC() {
        return this.iDK;
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

    public int clD() {
        return this.iDP;
    }

    public void xF(int i) {
        this.iDP = i;
    }

    public void a(TopicList topicList) {
        if (topicList != null) {
            this.mId = topicList.topic_id.longValue();
            this.mName = topicList.topic_name;
            this.mTag = topicList.tag.intValue();
            this.iDK = topicList.discuss_num.longValue();
            this.iDL = topicList.topic_desc;
            this.iDQ = topicList.topic_pic;
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
        return iDO;
    }
}
