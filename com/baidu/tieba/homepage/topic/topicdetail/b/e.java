package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.tbadk.core.util.at;
import tbclient.NewHottopic.TimeLineInfo;
/* loaded from: classes16.dex */
public class e {
    public String aJi;
    public String iTw;
    public int index;
    public long tid;
    public String title;
    public long topicId;

    public void a(TimeLineInfo timeLineInfo) {
        if (timeLineInfo != null) {
            this.tid = timeLineInfo.tid.longValue();
            this.title = timeLineInfo.title;
            this.iTw = at.isEmpty(timeLineInfo.small_title) ? timeLineInfo.show_time : timeLineInfo.small_title;
            this.aJi = timeLineInfo.bg_color;
        }
    }
}
