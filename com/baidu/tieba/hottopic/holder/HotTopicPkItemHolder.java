package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.view.HotTopicPkView;
/* loaded from: classes7.dex */
public class HotTopicPkItemHolder extends TypeAdapter.ViewHolder {
    public int aln;
    public TextView kyc;
    public TextView kyd;
    public HotTopicPkView kye;
    public TextView kyf;
    public TextView kyg;

    public HotTopicPkItemHolder(View view) {
        super(view);
        this.aln = 3;
        dj(view);
    }

    private void dj(View view) {
        if (view != null) {
            this.kyc = (TextView) view.findViewById(R.id.pk_item_theme_title);
            this.kyd = (TextView) view.findViewById(R.id.pk_topic_title);
            this.kye = (HotTopicPkView) view.findViewById(R.id.pk_topic_view);
            this.kyf = (TextView) view.findViewById(R.id.pk_topic_positive);
            this.kyg = (TextView) view.findViewById(R.id.pk_topic_opposing);
        }
    }
}
