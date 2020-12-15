package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.tbadk.core.util.au;
import tbclient.NewHottopic.TimeLineInfo;
/* loaded from: classes22.dex */
public class e {
    public int index;
    public String jXU;
    public String jXV;
    public long tid;
    public String title;
    public long topicId;

    public void a(TimeLineInfo timeLineInfo) {
        if (timeLineInfo != null) {
            this.tid = timeLineInfo.tid.longValue();
            this.title = timeLineInfo.title;
            this.jXU = au.isEmpty(timeLineInfo.small_title) ? timeLineInfo.show_time : timeLineInfo.small_title;
            this.jXV = timeLineInfo.bg_color;
        }
    }
}
