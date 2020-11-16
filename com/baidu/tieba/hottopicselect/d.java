package com.baidu.tieba.hottopicselect;

import GetSugTopic.TopicList;
/* loaded from: classes20.dex */
public class d {
    private String eBa;
    private String eBc;
    private String eBd;
    private Long jUS;
    private Long jUT;
    private Integer tag;

    public String getTopicName() {
        return this.eBa;
    }

    public void setTopicName(String str) {
        this.eBa = str;
    }

    public Integer cNv() {
        return this.tag;
    }

    public void a(TopicList topicList) {
        if (topicList != null) {
            this.jUS = topicList.topic_id;
            this.eBa = topicList.topic_name;
            this.eBd = topicList.topic_pic;
            this.eBc = topicList.topic_desc;
            this.jUT = topicList.discuss_num;
            this.tag = topicList.tag;
        }
    }
}
