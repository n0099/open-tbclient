package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class HotTopicIntervalItemHolder extends TypeAdapter.ViewHolder {
    public int ajU;
    public View kvY;
    public TextView kvZ;

    public HotTopicIntervalItemHolder(View view) {
        super(view);
        this.ajU = 3;
        this.kvY = null;
        this.kvZ = null;
        dj(view);
    }

    private void dj(View view) {
        if (view != null) {
            this.kvY = view.findViewById(R.id.top_divider_line);
            this.kvZ = (TextView) view.findViewById(R.id.item_theme_title);
        }
    }
}
