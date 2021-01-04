package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.view.HotTopicPkView;
/* loaded from: classes8.dex */
public class HotTopicPkItemHolder extends TypeAdapter.ViewHolder {
    public int akW;
    public TextView ksk;
    public TextView ksl;
    public HotTopicPkView ksm;
    public TextView ksn;
    public TextView kso;

    public HotTopicPkItemHolder(View view) {
        super(view);
        this.akW = 3;
        dl(view);
    }

    private void dl(View view) {
        if (view != null) {
            this.ksk = (TextView) view.findViewById(R.id.pk_item_theme_title);
            this.ksl = (TextView) view.findViewById(R.id.pk_topic_title);
            this.ksm = (HotTopicPkView) view.findViewById(R.id.pk_topic_view);
            this.ksn = (TextView) view.findViewById(R.id.pk_topic_positive);
            this.kso = (TextView) view.findViewById(R.id.pk_topic_opposing);
        }
    }
}
