package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class HotTopicIntervalItemHolder extends TypeAdapter.ViewHolder {
    public int akW;
    public View ksi;
    public TextView ksj;

    public HotTopicIntervalItemHolder(View view) {
        super(view);
        this.akW = 3;
        this.ksi = null;
        this.ksj = null;
        dl(view);
    }

    private void dl(View view) {
        if (view != null) {
            this.ksi = view.findViewById(R.id.top_divider_line);
            this.ksj = (TextView) view.findViewById(R.id.item_theme_title);
        }
    }
}
