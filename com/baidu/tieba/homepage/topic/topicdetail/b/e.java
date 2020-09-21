package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.tbadk.core.util.at;
import tbclient.NewHottopic.TimeLineInfo;
/* loaded from: classes21.dex */
public class e {
    public String aKA;
    public int index;
    public String jci;
    public long tid;
    public String title;
    public long topicId;

    public void a(TimeLineInfo timeLineInfo) {
        if (timeLineInfo != null) {
            this.tid = timeLineInfo.tid.longValue();
            this.title = timeLineInfo.title;
            this.jci = at.isEmpty(timeLineInfo.small_title) ? timeLineInfo.show_time : timeLineInfo.small_title;
            this.aKA = timeLineInfo.bg_color;
        }
    }
}
