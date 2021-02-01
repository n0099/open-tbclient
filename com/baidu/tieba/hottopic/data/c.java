package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import tbclient.TopicList.TopicList;
import tbclient.TopicList.TopicListModule;
/* loaded from: classes8.dex */
public class c implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId kuc = BdUniqueId.gen();
    private long ktY;
    private String ktZ;
    private int kud = -1;
    private String kue;
    private long mId;
    private String mName;
    private int mTag;
    String module_title;
    String rule_jump_url;
    String tips;

    public String cTd() {
        return this.module_title;
    }

    public String getTips() {
        return this.tips;
    }

    public String cTe() {
        return this.rule_jump_url;
    }

    public long cTf() {
        return this.ktY;
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

    public int cTg() {
        return this.kud;
    }

    public void Cq(int i) {
        this.kud = i;
    }

    public void a(TopicList topicList) {
        if (topicList != null) {
            this.mId = topicList.topic_id.longValue();
            this.mName = topicList.topic_name;
            this.mTag = topicList.tag.intValue();
            this.ktY = topicList.discuss_num.longValue();
            this.ktZ = topicList.topic_desc;
            this.kue = topicList.topic_pic;
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
        return kuc;
    }
}
