package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.view.HotTopicPkView;
/* loaded from: classes8.dex */
public class HotTopicPkItemHolder extends TypeAdapter.ViewHolder {
    public int ajU;
    public TextView kwa;
    public TextView kwb;
    public HotTopicPkView kwc;
    public TextView kwd;
    public TextView kwe;

    public HotTopicPkItemHolder(View view) {
        super(view);
        this.ajU = 3;
        dj(view);
    }

    private void dj(View view) {
        if (view != null) {
            this.kwa = (TextView) view.findViewById(R.id.pk_item_theme_title);
            this.kwb = (TextView) view.findViewById(R.id.pk_topic_title);
            this.kwc = (HotTopicPkView) view.findViewById(R.id.pk_topic_view);
            this.kwd = (TextView) view.findViewById(R.id.pk_topic_positive);
            this.kwe = (TextView) view.findViewById(R.id.pk_topic_opposing);
        }
    }
}
