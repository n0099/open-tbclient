package com.baidu.tieba.hottopicselect;

import GetSugTopic.TopicList;
import GetSugTopic.TopicListModule;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class c {
    private String title;
    private int type = -1;
    private List<d> jmg = new ArrayList();

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String cSI() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public List<d> getList() {
        return this.jmg;
    }

    public void a(TopicListModule topicListModule) {
        if (topicListModule != null) {
            this.title = topicListModule.module_title;
            if (topicListModule.topic_list != null) {
                int count = y.getCount(topicListModule.topic_list);
                for (int i = 0; i < count; i++) {
                    d dVar = new d();
                    TopicList topicList = (TopicList) y.getItem(topicListModule.topic_list, i);
                    if (topicList != null) {
                        dVar.a(topicList);
                        if (!k.isEmptyStringAfterTrim(dVar.getTopicName())) {
                            this.jmg.add(dVar);
                        }
                    }
                }
            }
        }
    }
}
