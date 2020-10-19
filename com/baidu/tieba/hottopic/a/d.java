package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.view.HotTopicPkView;
/* loaded from: classes21.dex */
public class d extends af.a {
    public int ajp;
    public TextView jyl;
    public TextView jym;
    public HotTopicPkView jyn;
    public TextView jyo;
    public TextView jyp;

    public d(View view) {
        super(view);
        this.ajp = 3;
        cG(view);
    }

    private void cG(View view) {
        if (view != null) {
            this.jyl = (TextView) view.findViewById(R.id.pk_item_theme_title);
            this.jym = (TextView) view.findViewById(R.id.pk_topic_title);
            this.jyn = (HotTopicPkView) view.findViewById(R.id.pk_topic_view);
            this.jyo = (TextView) view.findViewById(R.id.pk_topic_positive);
            this.jyp = (TextView) view.findViewById(R.id.pk_topic_opposing);
        }
    }
}
