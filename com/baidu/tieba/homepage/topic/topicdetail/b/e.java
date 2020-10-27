package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.tbadk.core.util.at;
import tbclient.NewHottopic.TimeLineInfo;
/* loaded from: classes22.dex */
public class e {
    public String aOk;
    public int index;
    public String jDH;
    public long tid;
    public String title;
    public long topicId;

    public void a(TimeLineInfo timeLineInfo) {
        if (timeLineInfo != null) {
            this.tid = timeLineInfo.tid.longValue();
            this.title = timeLineInfo.title;
            this.jDH = at.isEmpty(timeLineInfo.small_title) ? timeLineInfo.show_time : timeLineInfo.small_title;
            this.aOk = timeLineInfo.bg_color;
        }
    }
}
