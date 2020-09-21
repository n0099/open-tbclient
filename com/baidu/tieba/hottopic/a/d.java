package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.view.HotTopicPkView;
/* loaded from: classes20.dex */
public class d extends af.a {
    public int aiX;
    public TextView jjn;
    public TextView jjo;
    public HotTopicPkView jjp;
    public TextView jjq;
    public TextView jjr;

    public d(View view) {
        super(view);
        this.aiX = 3;
        cC(view);
    }

    private void cC(View view) {
        if (view != null) {
            this.jjn = (TextView) view.findViewById(R.id.pk_item_theme_title);
            this.jjo = (TextView) view.findViewById(R.id.pk_topic_title);
            this.jjp = (HotTopicPkView) view.findViewById(R.id.pk_topic_view);
            this.jjq = (TextView) view.findViewById(R.id.pk_topic_positive);
            this.jjr = (TextView) view.findViewById(R.id.pk_topic_opposing);
        }
    }
}
