package com.baidu.tieba.hottopic.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class b extends x.a {
    public View aDF;
    public TextView bps;
    public TextView bpt;
    public TextView bpu;

    public b(View view) {
        super(view);
        this.bps = null;
        this.bpt = null;
        this.bpu = null;
        this.aDF = null;
        this.bps = (TextView) view.findViewById(i.f.hot_topic_info_title);
        this.bpt = (TextView) view.findViewById(i.f.hot_topic_info_threadcount);
        this.bpu = (TextView) view.findViewById(i.f.hot_topic_info_abstract);
        this.aDF = view.findViewById(i.f.divider_line);
    }
}
