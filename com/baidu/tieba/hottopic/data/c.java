package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.u;
import tbclient.HottopicRanklist.TopicList;
import tbclient.HottopicRanklist.TopicListModule;
/* loaded from: classes.dex */
public class c implements u {
    public static final BdUniqueId bKM = BdUniqueId.gen();
    private long bKI;
    private String bKJ;
    private int bKN = -1;
    private String bKO;
    private long mId;
    private String mName;
    private int mTag;
    String module_title;
    String rule_jump_url;
    String tips;

    public String XK() {
        return this.module_title;
    }

    public String getTips() {
        return this.tips;
    }

    public String XL() {
        return this.rule_jump_url;
    }

    public long XM() {
        return this.bKI;
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

    public int XN() {
        return this.bKN;
    }

    public void iz(int i) {
        this.bKN = i;
    }

    public void a(TopicList topicList) {
        if (topicList != null) {
            this.mId = topicList.topic_id.longValue();
            this.mName = topicList.topic_name;
            this.mTag = topicList.tag.intValue();
            this.bKI = topicList.discuss_num.longValue();
            this.bKJ = topicList.topic_desc;
            this.bKO = topicList.topic_pic;
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
        return bKM;
    }
}
