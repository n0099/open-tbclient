package com.baidu.tieba.hottopicselect;

import GetSugTopic.TopicList;
/* loaded from: classes8.dex */
public class d {
    private String dKw;
    private String dKy;
    private String dKz;
    private Long iIZ;
    private Long iJa;
    private Integer tag;

    public String getTopicName() {
        return this.dKw;
    }

    public void setTopicName(String str) {
        this.dKw = str;
    }

    public Integer cmy() {
        return this.tag;
    }

    public void a(TopicList topicList) {
        if (topicList != null) {
            this.iIZ = topicList.topic_id;
            this.dKw = topicList.topic_name;
            this.dKz = topicList.topic_pic;
            this.dKy = topicList.topic_desc;
            this.iJa = topicList.discuss_num;
            this.tag = topicList.tag;
        }
    }
}
