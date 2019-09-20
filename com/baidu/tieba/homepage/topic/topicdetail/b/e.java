package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.tbadk.core.util.aq;
import tbclient.NewHottopic.TimeLineInfo;
/* loaded from: classes4.dex */
public class e {
    public String bdC;
    public String goz;
    public int index;
    public long tid;
    public String title;
    public long topicId;

    public void a(TimeLineInfo timeLineInfo) {
        if (timeLineInfo != null) {
            this.tid = timeLineInfo.tid.longValue();
            this.title = timeLineInfo.title;
            this.goz = aq.isEmpty(timeLineInfo.small_title) ? timeLineInfo.show_time : timeLineInfo.small_title;
            this.bdC = timeLineInfo.bg_color;
        }
    }
}
