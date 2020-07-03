package com.baidu.tieba.homepage.hotTopic.tab.b;

import android.support.annotation.NonNull;
import tbclient.RecomTopicList;
/* loaded from: classes9.dex */
public class b {
    public String dKw;
    public int index;
    public boolean iqX;
    public int tag;
    public long topicId;

    public b() {
        this.iqX = true;
    }

    public b(@NonNull RecomTopicList recomTopicList) {
        this.topicId = recomTopicList.topic_id.longValue();
        this.dKw = recomTopicList.topic_name;
        this.tag = recomTopicList.tag.intValue();
        this.index = -1;
    }
}
