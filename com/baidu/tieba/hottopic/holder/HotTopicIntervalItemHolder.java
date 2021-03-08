package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class HotTopicIntervalItemHolder extends TypeAdapter.ViewHolder {
    public int aln;
    public View kya;
    public TextView kyb;

    public HotTopicIntervalItemHolder(View view) {
        super(view);
        this.aln = 3;
        this.kya = null;
        this.kyb = null;
        dj(view);
    }

    private void dj(View view) {
        if (view != null) {
            this.kya = view.findViewById(R.id.top_divider_line);
            this.kyb = (TextView) view.findViewById(R.id.item_theme_title);
        }
    }
}
