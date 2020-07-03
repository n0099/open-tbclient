package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.view.HotTopicPkView;
/* loaded from: classes8.dex */
public class d extends ad.a {
    public int ahx;
    public TextView iFA;
    public TextView iFB;
    public TextView iFx;
    public TextView iFy;
    public HotTopicPkView iFz;

    public d(View view) {
        super(view);
        this.ahx = 3;
        ck(view);
    }

    private void ck(View view) {
        if (view != null) {
            this.iFx = (TextView) view.findViewById(R.id.pk_item_theme_title);
            this.iFy = (TextView) view.findViewById(R.id.pk_topic_title);
            this.iFz = (HotTopicPkView) view.findViewById(R.id.pk_topic_view);
            this.iFA = (TextView) view.findViewById(R.id.pk_topic_positive);
            this.iFB = (TextView) view.findViewById(R.id.pk_topic_opposing);
        }
    }
}
