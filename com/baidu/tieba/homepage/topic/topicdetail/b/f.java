package com.baidu.tieba.homepage.topic.topicdetail.b;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TimeLineInfo;
/* loaded from: classes6.dex */
public class f {
    public List<e> haJ;
    public String title;

    public void a(long j, TimeLine timeLine) {
        if (timeLine != null && !v.isEmpty(timeLine.timeline_info)) {
            this.title = timeLine.title;
            this.haJ = new ArrayList();
            int i = 0;
            for (TimeLineInfo timeLineInfo : timeLine.timeline_info) {
                if (timeLineInfo != null && ((timeLineInfo.tid != null && timeLineInfo.tid.longValue() != 0) || !TextUtils.isEmpty(timeLineInfo.title) || !TextUtils.isEmpty(timeLineInfo.bg_color) || !TextUtils.isEmpty(timeLineInfo.show_time) || !TextUtils.isEmpty(timeLineInfo.small_title))) {
                    e eVar = new e();
                    eVar.topicId = j;
                    eVar.index = i;
                    eVar.a(timeLineInfo);
                    this.haJ.add(eVar);
                    i++;
                }
            }
        }
    }
}
