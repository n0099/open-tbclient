package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.tbadk.core.util.au;
import tbclient.NewHottopic.TimeLineInfo;
/* loaded from: classes21.dex */
public class e {
    public int index;
    public String jKp;
    public String jKq;
    public long tid;
    public String title;
    public long topicId;

    public void a(TimeLineInfo timeLineInfo) {
        if (timeLineInfo != null) {
            this.tid = timeLineInfo.tid.longValue();
            this.title = timeLineInfo.title;
            this.jKp = au.isEmpty(timeLineInfo.small_title) ? timeLineInfo.show_time : timeLineInfo.small_title;
            this.jKq = timeLineInfo.bg_color;
        }
    }
}
