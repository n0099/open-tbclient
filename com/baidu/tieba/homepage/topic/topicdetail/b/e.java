package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.tbadk.core.util.as;
import tbclient.NewHottopic.TimeLineInfo;
/* loaded from: classes16.dex */
public class e {
    public String aDY;
    public String iEy;
    public int index;
    public long tid;
    public String title;
    public long topicId;

    public void a(TimeLineInfo timeLineInfo) {
        if (timeLineInfo != null) {
            this.tid = timeLineInfo.tid.longValue();
            this.title = timeLineInfo.title;
            this.iEy = as.isEmpty(timeLineInfo.small_title) ? timeLineInfo.show_time : timeLineInfo.small_title;
            this.aDY = timeLineInfo.bg_color;
        }
    }
}
