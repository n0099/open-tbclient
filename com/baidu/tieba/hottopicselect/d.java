package com.baidu.tieba.hottopicselect;

import GetSugTopic.TopicList;
/* loaded from: classes20.dex */
public class d {
    private String ecp;
    private String ecr;
    private String ecs;
    private Long jmP;
    private Long jmQ;
    private Integer tag;

    public String getTopicName() {
        return this.ecp;
    }

    public void setTopicName(String str) {
        this.ecp = str;
    }

    public Integer cEy() {
        return this.tag;
    }

    public void a(TopicList topicList) {
        if (topicList != null) {
            this.jmP = topicList.topic_id;
            this.ecp = topicList.topic_name;
            this.ecs = topicList.topic_pic;
            this.ecr = topicList.topic_desc;
            this.jmQ = topicList.discuss_num;
            this.tag = topicList.tag;
        }
    }
}
