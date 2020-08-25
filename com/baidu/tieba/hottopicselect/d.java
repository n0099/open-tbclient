package com.baidu.tieba.hottopicselect;

import GetSugTopic.TopicList;
/* loaded from: classes15.dex */
public class d {
    private String eab;
    private String ead;
    private String eae;
    private Long jed;
    private Long jee;
    private Integer tag;

    public String getTopicName() {
        return this.eab;
    }

    public void setTopicName(String str) {
        this.eab = str;
    }

    public Integer cAQ() {
        return this.tag;
    }

    public void a(TopicList topicList) {
        if (topicList != null) {
            this.jed = topicList.topic_id;
            this.eab = topicList.topic_name;
            this.eae = topicList.topic_pic;
            this.ead = topicList.topic_desc;
            this.jee = topicList.discuss_num;
            this.tag = topicList.tag;
        }
    }
}
