package com.baidu.tieba.hottopicselect;

import GetSugTopic.TopicList;
/* loaded from: classes15.dex */
public class d {
    private String dQI;
    private String dQK;
    private String dQL;
    private Long iPe;
    private Long iPf;
    private Integer tag;

    public String getTopicName() {
        return this.dQI;
    }

    public void setTopicName(String str) {
        this.dQI = str;
    }

    public Integer cpY() {
        return this.tag;
    }

    public void a(TopicList topicList) {
        if (topicList != null) {
            this.iPe = topicList.topic_id;
            this.dQI = topicList.topic_name;
            this.dQL = topicList.topic_pic;
            this.dQK = topicList.topic_desc;
            this.iPf = topicList.discuss_num;
            this.tag = topicList.tag;
        }
    }
}
