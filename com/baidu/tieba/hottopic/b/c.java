package com.baidu.tieba.hottopic.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.hottopic.view.HotTopicPkView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class c extends x.a {
    public int afY;
    public TextView bEN;
    public TextView bEO;
    public HotTopicPkView bEP;
    public TextView bEQ;
    public TextView bER;

    public c(View view) {
        super(view);
        this.afY = 3;
        P(view);
    }

    private void P(View view) {
        if (view != null) {
            this.bEN = (TextView) view.findViewById(n.f.pk_item_theme_title);
            this.bEO = (TextView) view.findViewById(n.f.pk_topic_title);
            this.bEP = (HotTopicPkView) view.findViewById(n.f.pk_topic_view);
            this.bEQ = (TextView) view.findViewById(n.f.pk_topic_positive);
            this.bER = (TextView) view.findViewById(n.f.pk_topic_opposing);
        }
    }
}
