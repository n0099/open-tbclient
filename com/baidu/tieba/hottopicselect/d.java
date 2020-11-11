package com.baidu.tieba.hottopicselect;

import GetSugTopic.TopicList;
/* loaded from: classes21.dex */
public class d {
    private String eCJ;
    private String eCL;
    private String eCM;
    private Long jUi;
    private Long jUj;
    private Integer tag;

    public String getTopicName() {
        return this.eCJ;
    }

    public void setTopicName(String str) {
        this.eCJ = str;
    }

    public Integer cNP() {
        return this.tag;
    }

    public void a(TopicList topicList) {
        if (topicList != null) {
            this.jUi = topicList.topic_id;
            this.eCJ = topicList.topic_name;
            this.eCM = topicList.topic_pic;
            this.eCL = topicList.topic_desc;
            this.jUj = topicList.discuss_num;
            this.tag = topicList.tag;
        }
    }
}
