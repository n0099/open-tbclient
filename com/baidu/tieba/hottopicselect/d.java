package com.baidu.tieba.hottopicselect;

import GetSugTopic.TopicList;
/* loaded from: classes21.dex */
public class d {
    private String eIa;
    private String eIc;
    private String eId;
    private Long kiA;
    private Long kiz;
    private Integer tag;

    public String getTopicName() {
        return this.eIa;
    }

    public void setTopicName(String str) {
        this.eIa = str;
    }

    public Integer cSK() {
        return this.tag;
    }

    public void a(TopicList topicList) {
        if (topicList != null) {
            this.kiz = topicList.topic_id;
            this.eIa = topicList.topic_name;
            this.eId = topicList.topic_pic;
            this.eIc = topicList.topic_desc;
            this.kiA = topicList.discuss_num;
            this.tag = topicList.tag;
        }
    }
}
