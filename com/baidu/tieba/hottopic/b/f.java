package com.baidu.tieba.hottopic.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.hottopic.view.HotTopicPkView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class f extends x.a {
    public int ahU;
    public TextView bMk;
    public TextView bMl;
    public HotTopicPkView bMm;
    public TextView bMn;
    public TextView bMo;

    public f(View view) {
        super(view);
        this.ahU = 3;
        ai(view);
    }

    private void ai(View view) {
        if (view != null) {
            this.bMk = (TextView) view.findViewById(t.g.pk_item_theme_title);
            this.bMl = (TextView) view.findViewById(t.g.pk_topic_title);
            this.bMm = (HotTopicPkView) view.findViewById(t.g.pk_topic_view);
            this.bMn = (TextView) view.findViewById(t.g.pk_topic_positive);
            this.bMo = (TextView) view.findViewById(t.g.pk_topic_opposing);
        }
    }
}
