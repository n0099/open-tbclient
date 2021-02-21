package com.baidu.tieba.homepage.hotTopic.tab.b;

import androidx.annotation.NonNull;
import tbclient.RecomTopicList;
/* loaded from: classes2.dex */
public class c {
    public String ePt;
    public int index;
    public boolean kgT;
    public int tag;
    public long topicId;

    public c() {
        this.kgT = true;
    }

    public c(@NonNull RecomTopicList recomTopicList, int i) {
        this.topicId = recomTopicList.topic_id.longValue();
        this.ePt = recomTopicList.topic_name;
        this.tag = recomTopicList.tag.intValue();
        this.index = i + 1;
    }

    public c(@NonNull RecomTopicList recomTopicList) {
        this.topicId = recomTopicList.topic_id.longValue();
        this.ePt = recomTopicList.topic_name;
        this.tag = recomTopicList.tag.intValue();
        this.index = -1;
    }
}
