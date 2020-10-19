package com.baidu.tieba.hottopicselect;

import GetSugTopic.TopicList;
/* loaded from: classes21.dex */
public class d {
    private String eou;
    private String eow;
    private String eox;
    private Long jBM;
    private Long jBN;
    private Integer tag;

    public String getTopicName() {
        return this.eou;
    }

    public void setTopicName(String str) {
        this.eou = str;
    }

    public Integer cIh() {
        return this.tag;
    }

    public void a(TopicList topicList) {
        if (topicList != null) {
            this.jBM = topicList.topic_id;
            this.eou = topicList.topic_name;
            this.eox = topicList.topic_pic;
            this.eow = topicList.topic_desc;
            this.jBN = topicList.discuss_num;
            this.tag = topicList.tag;
        }
    }
}
