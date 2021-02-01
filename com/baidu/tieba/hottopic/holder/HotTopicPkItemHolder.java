package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.view.HotTopicPkView;
/* loaded from: classes8.dex */
public class HotTopicPkItemHolder extends TypeAdapter.ViewHolder {
    public int ajU;
    public TextView kvM;
    public TextView kvN;
    public HotTopicPkView kvO;
    public TextView kvP;
    public TextView kvQ;

    public HotTopicPkItemHolder(View view) {
        super(view);
        this.ajU = 3;
        dj(view);
    }

    private void dj(View view) {
        if (view != null) {
            this.kvM = (TextView) view.findViewById(R.id.pk_item_theme_title);
            this.kvN = (TextView) view.findViewById(R.id.pk_topic_title);
            this.kvO = (HotTopicPkView) view.findViewById(R.id.pk_topic_view);
            this.kvP = (TextView) view.findViewById(R.id.pk_topic_positive);
            this.kvQ = (TextView) view.findViewById(R.id.pk_topic_opposing);
        }
    }
}
