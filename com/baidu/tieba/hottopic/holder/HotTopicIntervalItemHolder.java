package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class HotTopicIntervalItemHolder extends TypeAdapter.ViewHolder {
    public int ajU;
    public View kvK;
    public TextView kvL;

    public HotTopicIntervalItemHolder(View view) {
        super(view);
        this.ajU = 3;
        this.kvK = null;
        this.kvL = null;
        dj(view);
    }

    private void dj(View view) {
        if (view != null) {
            this.kvK = view.findViewById(R.id.top_divider_line);
            this.kvL = (TextView) view.findViewById(R.id.item_theme_title);
        }
    }
}
