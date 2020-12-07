package com.baidu.tieba.hottopicselect;

import GetSugTopic.TopicList;
/* loaded from: classes21.dex */
public class d {
    private String eIa;
    private String eIc;
    private String eId;
    private Long kix;
    private Long kiy;
    private Integer tag;

    public String getTopicName() {
        return this.eIa;
    }

    public void setTopicName(String str) {
        this.eIa = str;
    }

    public Integer cSJ() {
        return this.tag;
    }

    public void a(TopicList topicList) {
        if (topicList != null) {
            this.kix = topicList.topic_id;
            this.eIa = topicList.topic_name;
            this.eId = topicList.topic_pic;
            this.eIc = topicList.topic_desc;
            this.kiy = topicList.discuss_num;
            this.tag = topicList.tag;
        }
    }
}
