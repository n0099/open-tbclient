package com.baidu.tieba.hottopicselect;

import GetSugTopic.TopicList;
/* loaded from: classes8.dex */
public class d {
    private String eRS;
    private String eRU;
    private String eRV;
    private Long kvJ;
    private Long kvK;
    private Integer tag;

    public String getTopicName() {
        return this.eRS;
    }

    public void setTopicName(String str) {
        this.eRS = str;
    }

    public Integer cVQ() {
        return this.tag;
    }

    public void a(TopicList topicList) {
        if (topicList != null) {
            this.kvJ = topicList.topic_id;
            this.eRS = topicList.topic_name;
            this.eRV = topicList.topic_pic;
            this.eRU = topicList.topic_desc;
            this.kvK = topicList.discuss_num;
            this.tag = topicList.tag;
        }
    }
}
