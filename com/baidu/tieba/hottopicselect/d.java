package com.baidu.tieba.hottopicselect;

import GetSugTopic.TopicList;
/* loaded from: classes7.dex */
public class d {
    private String eQU;
    private String eQW;
    private String eQX;
    private Long kBB;
    private Long kBC;
    private Integer tag;

    public String getTopicName() {
        return this.eQU;
    }

    public void setTopicName(String str) {
        this.eQU = str;
    }

    public Integer cUm() {
        return this.tag;
    }

    public void a(TopicList topicList) {
        if (topicList != null) {
            this.kBB = topicList.topic_id;
            this.eQU = topicList.topic_name;
            this.eQX = topicList.topic_pic;
            this.eQW = topicList.topic_desc;
            this.kBC = topicList.discuss_num;
            this.tag = topicList.tag;
        }
    }
}
