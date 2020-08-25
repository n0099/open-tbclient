package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.view.HotTopicPkView;
/* loaded from: classes15.dex */
public class d extends af.a {
    public int aiB;
    public TextView jaB;
    public TextView jaC;
    public HotTopicPkView jaD;
    public TextView jaE;
    public TextView jaF;

    public d(View view) {
        super(view);
        this.aiB = 3;
        ct(view);
    }

    private void ct(View view) {
        if (view != null) {
            this.jaB = (TextView) view.findViewById(R.id.pk_item_theme_title);
            this.jaC = (TextView) view.findViewById(R.id.pk_topic_title);
            this.jaD = (HotTopicPkView) view.findViewById(R.id.pk_topic_view);
            this.jaE = (TextView) view.findViewById(R.id.pk_topic_positive);
            this.jaF = (TextView) view.findViewById(R.id.pk_topic_opposing);
        }
    }
}
