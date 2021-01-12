package com.baidu.tieba.homepage.topic.topicdetail.a;

import com.baidu.tbadk.core.util.at;
import tbclient.NewHottopic.TimeLineInfo;
/* loaded from: classes2.dex */
public class e {
    public int index;
    public String kgA;
    public String kgB;
    public long tid;
    public String title;
    public long topicId;

    public void a(TimeLineInfo timeLineInfo) {
        if (timeLineInfo != null) {
            this.tid = timeLineInfo.tid.longValue();
            this.title = timeLineInfo.title;
            this.kgA = at.isEmpty(timeLineInfo.small_title) ? timeLineInfo.show_time : timeLineInfo.small_title;
            this.kgB = timeLineInfo.bg_color;
        }
    }
}
