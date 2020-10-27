package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.view.HotTopicPkView;
/* loaded from: classes21.dex */
public class d extends af.a {
    public int ajq;
    public TextView jKK;
    public TextView jKL;
    public HotTopicPkView jKM;
    public TextView jKN;
    public TextView jKO;

    public d(View view) {
        super(view);
        this.ajq = 3;
        cK(view);
    }

    private void cK(View view) {
        if (view != null) {
            this.jKK = (TextView) view.findViewById(R.id.pk_item_theme_title);
            this.jKL = (TextView) view.findViewById(R.id.pk_topic_title);
            this.jKM = (HotTopicPkView) view.findViewById(R.id.pk_topic_view);
            this.jKN = (TextView) view.findViewById(R.id.pk_topic_positive);
            this.jKO = (TextView) view.findViewById(R.id.pk_topic_opposing);
        }
    }
}
