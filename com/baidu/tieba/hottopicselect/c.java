package com.baidu.tieba.hottopicselect;

import GetSugTopic.TopicList;
import GetSugTopic.TopicListModule;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class c {
    private String title;
    private int type = -1;
    private List<d> hVs = new ArrayList();

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String cpX() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public List<d> getList() {
        return this.hVs;
    }

    public void a(TopicListModule topicListModule) {
        if (topicListModule != null) {
            this.title = topicListModule.module_title;
            if (topicListModule.topic_list != null) {
                int count = x.getCount(topicListModule.topic_list);
                for (int i = 0; i < count; i++) {
                    d dVar = new d();
                    TopicList topicList = (TopicList) x.getItem(topicListModule.topic_list, i);
                    if (topicList != null) {
                        dVar.a(topicList);
                        if (!k.isEmptyStringAfterTrim(dVar.getTopicName())) {
                            this.hVs.add(dVar);
                        }
                    }
                }
            }
        }
    }
}
