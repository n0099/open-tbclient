package com.baidu.tieba.homepage.hotTopic.tab.b;

import android.support.annotation.NonNull;
import tbclient.RecomTopicList;
/* loaded from: classes16.dex */
public class b {
    public String dQI;
    public int index;
    public boolean ixb;
    public int tag;
    public long topicId;

    public b() {
        this.ixb = true;
    }

    public b(@NonNull RecomTopicList recomTopicList) {
        this.topicId = recomTopicList.topic_id.longValue();
        this.dQI = recomTopicList.topic_name;
        this.tag = recomTopicList.tag.intValue();
        this.index = -1;
    }
}
