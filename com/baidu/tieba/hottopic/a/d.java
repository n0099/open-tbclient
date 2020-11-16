package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.view.HotTopicPkView;
/* loaded from: classes20.dex */
public class d extends af.a {
    public int ajv;
    public TextView jRs;
    public TextView jRt;
    public HotTopicPkView jRu;
    public TextView jRv;
    public TextView jRw;

    public d(View view) {
        super(view);
        this.ajv = 3;
        cU(view);
    }

    private void cU(View view) {
        if (view != null) {
            this.jRs = (TextView) view.findViewById(R.id.pk_item_theme_title);
            this.jRt = (TextView) view.findViewById(R.id.pk_topic_title);
            this.jRu = (HotTopicPkView) view.findViewById(R.id.pk_topic_view);
            this.jRv = (TextView) view.findViewById(R.id.pk_topic_positive);
            this.jRw = (TextView) view.findViewById(R.id.pk_topic_opposing);
        }
    }
}
