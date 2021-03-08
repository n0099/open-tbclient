package com.baidu.tieba.homepage.topic.topicdetail.a;

import com.baidu.tbadk.core.util.au;
import tbclient.NewHottopic.TimeLineInfo;
/* loaded from: classes2.dex */
public class e {
    public int index;
    public String kqY;
    public String kqZ;
    public long tid;
    public String title;
    public long topicId;

    public void a(TimeLineInfo timeLineInfo) {
        if (timeLineInfo != null) {
            this.tid = timeLineInfo.tid.longValue();
            this.title = timeLineInfo.title;
            this.kqY = au.isEmpty(timeLineInfo.small_title) ? timeLineInfo.show_time : timeLineInfo.small_title;
            this.kqZ = timeLineInfo.bg_color;
        }
    }
}
