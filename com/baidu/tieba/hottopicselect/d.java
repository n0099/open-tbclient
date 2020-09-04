package com.baidu.tieba.hottopicselect;

import GetSugTopic.TopicList;
/* loaded from: classes15.dex */
public class d {
    private String eaf;
    private String eah;
    private String eai;
    private Long jej;
    private Long jek;
    private Integer tag;

    public String getTopicName() {
        return this.eaf;
    }

    public void setTopicName(String str) {
        this.eaf = str;
    }

    public Integer cAR() {
        return this.tag;
    }

    public void a(TopicList topicList) {
        if (topicList != null) {
            this.jej = topicList.topic_id;
            this.eaf = topicList.topic_name;
            this.eai = topicList.topic_pic;
            this.eah = topicList.topic_desc;
            this.jek = topicList.discuss_num;
            this.tag = topicList.tag;
        }
    }
}
