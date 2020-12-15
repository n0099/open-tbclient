package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.view.HotTopicPkView;
/* loaded from: classes21.dex */
public class d extends af.a {
    public int aku;
    public TextView keY;
    public TextView keZ;
    public HotTopicPkView kfa;
    public TextView kfb;
    public TextView kfc;

    public d(View view) {
        super(view);
        this.aku = 3;
        db(view);
    }

    private void db(View view) {
        if (view != null) {
            this.keY = (TextView) view.findViewById(R.id.pk_item_theme_title);
            this.keZ = (TextView) view.findViewById(R.id.pk_topic_title);
            this.kfa = (HotTopicPkView) view.findViewById(R.id.pk_topic_view);
            this.kfb = (TextView) view.findViewById(R.id.pk_topic_positive);
            this.kfc = (TextView) view.findViewById(R.id.pk_topic_opposing);
        }
    }
}
