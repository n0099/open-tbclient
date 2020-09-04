package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.view.HotTopicPkView;
/* loaded from: classes15.dex */
public class d extends af.a {
    public int aiD;
    public TextView jaH;
    public TextView jaI;
    public HotTopicPkView jaJ;
    public TextView jaK;
    public TextView jaL;

    public d(View view) {
        super(view);
        this.aiD = 3;
        ct(view);
    }

    private void ct(View view) {
        if (view != null) {
            this.jaH = (TextView) view.findViewById(R.id.pk_item_theme_title);
            this.jaI = (TextView) view.findViewById(R.id.pk_topic_title);
            this.jaJ = (HotTopicPkView) view.findViewById(R.id.pk_topic_view);
            this.jaK = (TextView) view.findViewById(R.id.pk_topic_positive);
            this.jaL = (TextView) view.findViewById(R.id.pk_topic_opposing);
        }
    }
}
