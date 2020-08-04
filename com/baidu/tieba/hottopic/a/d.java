package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.view.HotTopicPkView;
/* loaded from: classes15.dex */
public class d extends ad.a {
    public int aho;
    public TextView iLD;
    public TextView iLE;
    public HotTopicPkView iLF;
    public TextView iLG;
    public TextView iLH;

    public d(View view) {
        super(view);
        this.aho = 3;
        cq(view);
    }

    private void cq(View view) {
        if (view != null) {
            this.iLD = (TextView) view.findViewById(R.id.pk_item_theme_title);
            this.iLE = (TextView) view.findViewById(R.id.pk_topic_title);
            this.iLF = (HotTopicPkView) view.findViewById(R.id.pk_topic_view);
            this.iLG = (TextView) view.findViewById(R.id.pk_topic_positive);
            this.iLH = (TextView) view.findViewById(R.id.pk_topic_opposing);
        }
    }
}
