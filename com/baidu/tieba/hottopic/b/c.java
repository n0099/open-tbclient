package com.baidu.tieba.hottopic.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.hottopic.view.HotTopicPkView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class c extends x.a {
    public int ahf;
    public TextView bIr;
    public TextView bIs;
    public HotTopicPkView bIt;
    public TextView bIu;
    public TextView bIv;

    public c(View view) {
        super(view);
        this.ahf = 3;
        U(view);
    }

    private void U(View view) {
        if (view != null) {
            this.bIr = (TextView) view.findViewById(n.g.pk_item_theme_title);
            this.bIs = (TextView) view.findViewById(n.g.pk_topic_title);
            this.bIt = (HotTopicPkView) view.findViewById(n.g.pk_topic_view);
            this.bIu = (TextView) view.findViewById(n.g.pk_topic_positive);
            this.bIv = (TextView) view.findViewById(n.g.pk_topic_opposing);
        }
    }
}
