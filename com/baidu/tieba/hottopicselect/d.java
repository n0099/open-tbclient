package com.baidu.tieba.hottopicselect;

import GetSugTopic.TopicList;
/* loaded from: classes21.dex */
public class d {
    private String ewR;
    private String ewT;
    private String ewU;
    private Long jOl;
    private Long jOm;
    private Integer tag;

    public String getTopicName() {
        return this.ewR;
    }

    public void setTopicName(String str) {
        this.ewR = str;
    }

    public Integer cLo() {
        return this.tag;
    }

    public void a(TopicList topicList) {
        if (topicList != null) {
            this.jOl = topicList.topic_id;
            this.ewR = topicList.topic_name;
            this.ewU = topicList.topic_pic;
            this.ewT = topicList.topic_desc;
            this.jOm = topicList.discuss_num;
            this.tag = topicList.tag;
        }
    }
}
