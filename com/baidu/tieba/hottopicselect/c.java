package com.baidu.tieba.hottopicselect;

import GetSugTopic.TopicList;
import GetSugTopic.TopicListModule;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class c {
    private String title;
    private int type = -1;
    private List<d> hPt = new ArrayList();

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String cmw() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public List<d> getList() {
        return this.hPt;
    }

    public void a(TopicListModule topicListModule) {
        if (topicListModule != null) {
            this.title = topicListModule.module_title;
            if (topicListModule.topic_list != null) {
                int count = w.getCount(topicListModule.topic_list);
                for (int i = 0; i < count; i++) {
                    d dVar = new d();
                    TopicList topicList = (TopicList) w.getItem(topicListModule.topic_list, i);
                    if (topicList != null) {
                        dVar.a(topicList);
                        if (!k.isEmptyStringAfterTrim(dVar.getTopicName())) {
                            this.hPt.add(dVar);
                        }
                    }
                }
            }
        }
    }
}
