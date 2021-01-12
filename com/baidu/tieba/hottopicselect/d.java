package com.baidu.tieba.hottopicselect;

import GetSugTopic.TopicList;
/* loaded from: classes7.dex */
public class d {
    private String eNh;
    private String eNj;
    private String eNk;
    private Long kre;
    private Long krf;
    private Integer tag;

    public String getTopicName() {
        return this.eNh;
    }

    public void setTopicName(String str) {
        this.eNh = str;
    }

    public Integer cRZ() {
        return this.tag;
    }

    public void a(TopicList topicList) {
        if (topicList != null) {
            this.kre = topicList.topic_id;
            this.eNh = topicList.topic_name;
            this.eNk = topicList.topic_pic;
            this.eNj = topicList.topic_desc;
            this.krf = topicList.discuss_num;
            this.tag = topicList.tag;
        }
    }
}
