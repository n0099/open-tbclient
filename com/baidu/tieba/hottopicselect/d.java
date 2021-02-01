package com.baidu.tieba.hottopicselect;

import GetSugTopic.TopicList;
/* loaded from: classes8.dex */
public class d {
    private String ePt;
    private String ePv;
    private String ePw;
    private Long kzl;
    private Long kzm;
    private Integer tag;

    public String getTopicName() {
        return this.ePt;
    }

    public void setTopicName(String str) {
        this.ePt = str;
    }

    public Integer cTY() {
        return this.tag;
    }

    public void a(TopicList topicList) {
        if (topicList != null) {
            this.kzl = topicList.topic_id;
            this.ePt = topicList.topic_name;
            this.ePw = topicList.topic_pic;
            this.ePv = topicList.topic_desc;
            this.kzm = topicList.discuss_num;
            this.tag = topicList.tag;
        }
    }
}
