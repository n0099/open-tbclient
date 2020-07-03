package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.tbadk.core.util.ar;
import tbclient.NewHottopic.TimeLineInfo;
/* loaded from: classes9.dex */
public class e {
    public String aCD;
    public int index;
    public String iys;
    public long tid;
    public String title;
    public long topicId;

    public void a(TimeLineInfo timeLineInfo) {
        if (timeLineInfo != null) {
            this.tid = timeLineInfo.tid.longValue();
            this.title = timeLineInfo.title;
            this.iys = ar.isEmpty(timeLineInfo.small_title) ? timeLineInfo.show_time : timeLineInfo.small_title;
            this.aCD = timeLineInfo.bg_color;
        }
    }
}
