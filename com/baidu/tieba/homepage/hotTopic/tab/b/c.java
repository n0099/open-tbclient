package com.baidu.tieba.homepage.hotTopic.tab.b;

import android.support.annotation.NonNull;
import tbclient.RecomTopicList;
/* loaded from: classes22.dex */
public class c {
    public String eIa;
    public int index;
    public boolean jQt;
    public int tag;
    public long topicId;

    public c() {
        this.jQt = true;
    }

    public c(@NonNull RecomTopicList recomTopicList, int i) {
        this.topicId = recomTopicList.topic_id.longValue();
        this.eIa = recomTopicList.topic_name;
        this.tag = recomTopicList.tag.intValue();
        this.index = i + 1;
    }

    public c(@NonNull RecomTopicList recomTopicList) {
        this.topicId = recomTopicList.topic_id.longValue();
        this.eIa = recomTopicList.topic_name;
        this.tag = recomTopicList.tag.intValue();
        this.index = -1;
    }
}
