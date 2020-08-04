package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.q;
import tbclient.TopicList.TopicList;
import tbclient.TopicList.TopicListModule;
/* loaded from: classes15.dex */
public class c implements q {
    public static final BdUniqueId iJU = BdUniqueId.gen();
    private long iJQ;
    private String iJR;
    private int iJV = -1;
    private String iJW;
    private long mId;
    private String mName;
    private int mTag;
    String module_title;
    String rule_jump_url;
    String tips;

    public String cpb() {
        return this.module_title;
    }

    public String getTips() {
        return this.tips;
    }

    public String cpc() {
        return this.rule_jump_url;
    }

    public long cpd() {
        return this.iJQ;
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

    public int cpe() {
        return this.iJV;
    }

    public void xX(int i) {
        this.iJV = i;
    }

    public void a(TopicList topicList) {
        if (topicList != null) {
            this.mId = topicList.topic_id.longValue();
            this.mName = topicList.topic_name;
            this.mTag = topicList.tag.intValue();
            this.iJQ = topicList.discuss_num.longValue();
            this.iJR = topicList.topic_desc;
            this.iJW = topicList.topic_pic;
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
        return iJU;
    }
}
