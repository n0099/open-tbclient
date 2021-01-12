package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.view.HotTopicPkView;
/* loaded from: classes7.dex */
public class HotTopicPkItemHolder extends TypeAdapter.ViewHolder {
    public int akf;
    public TextView knF;
    public TextView knG;
    public HotTopicPkView knH;
    public TextView knI;
    public TextView knJ;

    public HotTopicPkItemHolder(View view) {
        super(view);
        this.akf = 3;
        dl(view);
    }

    private void dl(View view) {
        if (view != null) {
            this.knF = (TextView) view.findViewById(R.id.pk_item_theme_title);
            this.knG = (TextView) view.findViewById(R.id.pk_topic_title);
            this.knH = (HotTopicPkView) view.findViewById(R.id.pk_topic_view);
            this.knI = (TextView) view.findViewById(R.id.pk_topic_positive);
            this.knJ = (TextView) view.findViewById(R.id.pk_topic_opposing);
        }
    }
}
