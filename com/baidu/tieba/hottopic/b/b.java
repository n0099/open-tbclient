package com.baidu.tieba.hottopic.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class b extends x.a {
    public View aCK;
    public TextView bqh;
    public TextView bqi;
    public TextView bqj;

    public b(View view) {
        super(view);
        this.bqh = null;
        this.bqi = null;
        this.bqj = null;
        this.aCK = null;
        this.bqh = (TextView) view.findViewById(i.f.hot_topic_info_title);
        this.bqi = (TextView) view.findViewById(i.f.hot_topic_info_threadcount);
        this.bqj = (TextView) view.findViewById(i.f.hot_topic_info_abstract);
        this.aCK = view.findViewById(i.f.divider_line);
    }
}
