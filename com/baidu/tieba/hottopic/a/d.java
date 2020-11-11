package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.view.HotTopicPkView;
/* loaded from: classes21.dex */
public class d extends af.a {
    public int ajq;
    public TextView jQI;
    public TextView jQJ;
    public HotTopicPkView jQK;
    public TextView jQL;
    public TextView jQM;

    public d(View view) {
        super(view);
        this.ajq = 3;
        cP(view);
    }

    private void cP(View view) {
        if (view != null) {
            this.jQI = (TextView) view.findViewById(R.id.pk_item_theme_title);
            this.jQJ = (TextView) view.findViewById(R.id.pk_topic_title);
            this.jQK = (HotTopicPkView) view.findViewById(R.id.pk_topic_view);
            this.jQL = (TextView) view.findViewById(R.id.pk_topic_positive);
            this.jQM = (TextView) view.findViewById(R.id.pk_topic_opposing);
        }
    }
}
