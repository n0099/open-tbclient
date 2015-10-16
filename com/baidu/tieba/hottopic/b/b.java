package com.baidu.tieba.hottopic.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class b extends x.a {
    public View aDQ;
    public TextView bpD;
    public TextView bpE;
    public TextView bpF;

    public b(View view) {
        super(view);
        this.bpD = null;
        this.bpE = null;
        this.bpF = null;
        this.aDQ = null;
        this.bpD = (TextView) view.findViewById(i.f.hot_topic_info_title);
        this.bpE = (TextView) view.findViewById(i.f.hot_topic_info_threadcount);
        this.bpF = (TextView) view.findViewById(i.f.hot_topic_info_abstract);
        this.aDQ = view.findViewById(i.f.divider_line);
    }
}
