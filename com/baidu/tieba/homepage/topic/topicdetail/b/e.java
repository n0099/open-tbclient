package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.tbadk.core.util.ap;
import tbclient.NewHottopic.TimeLineInfo;
/* loaded from: classes4.dex */
public class e {
    public String aZB;
    public String fOD;
    public int index;
    public long tid;
    public String title;
    public long topicId;

    public void a(TimeLineInfo timeLineInfo) {
        if (timeLineInfo != null) {
            this.tid = timeLineInfo.tid.longValue();
            this.title = timeLineInfo.title;
            this.fOD = ap.isEmpty(timeLineInfo.small_title) ? timeLineInfo.show_time : timeLineInfo.small_title;
            this.aZB = timeLineInfo.bg_color;
        }
    }
}
