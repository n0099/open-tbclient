package com.baidu.tieba.homepage.tabfeed.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.hotTopic.tab.b.d;
import java.util.ArrayList;
import java.util.List;
import tbclient.ActivityPage.HotTopic;
import tbclient.RecomTopicList;
/* loaded from: classes2.dex */
public class b extends d {
    public String title = TbadkCoreApplication.getInst().getString(R.string.recommend_user_hot_topic_title);

    public void a(HotTopic hotTopic) {
        if (hotTopic != null) {
            this.floorPosition = hotTopic.floor_position.intValue();
            parserProtobuf(hotTopic.topic_list);
        }
    }

    public void parserProtobuf(List<RecomTopicList> list) {
        if (!y.isEmpty(list)) {
            int min = Math.min(list.size(), 4);
            ArrayList arrayList = new ArrayList(list.size());
            for (int i = 0; i < min; i++) {
                arrayList.add(new com.baidu.tieba.homepage.hotTopic.tab.b.c(list.get(i)));
            }
            dZ(arrayList);
        }
    }
}
